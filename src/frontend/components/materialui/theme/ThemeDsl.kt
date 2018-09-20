package frontend.components.materialui.theme


import kotlinext.js.asJsObject
import kotlinx.css.CSSBuilder
import kotlinx.css.hyphenize

import react.RBuilder
import react.RHandler


typealias RuleSet = CSSBuilder.() -> Unit
typealias OptionsSet = OverrideBuilder.() -> Unit


data class OverrideComponentOptions(val componentName: String, val classesSet: dynamic)
data class OverrideClassOptions(val className: String, val rulesSet: LinkedHashMap<String, Any>)


class OverrideBuilder {

	val componentSelectors: MutableList<OverrideComponentOptions> = mutableListOf()
	operator fun String.invoke(block: OverrideClassOptionBuilder.() -> Unit) = componentOverride(this, block)
	operator fun ComponentSelector.invoke(block: OverrideClassOptionBuilder.() -> Unit) = componentName(block)
	fun build(): dynamic {
		val js = js("{}")
		componentSelectors.forEach {
			js[it.componentName] = it.classesSet
		}

		return js
	}

	private fun componentOverride(componentSelector: String, block: OverrideClassOptionBuilder.() -> Unit) = apply {
		val build = OverrideClassOptionBuilder().apply(block).build()
		componentSelectors.add(OverrideComponentOptions(componentSelector, build))
	}


}


class OverrideClassOptionBuilder {

	val css = CSSBuilder(allowClasses = false)

	val classSelectors: MutableList<OverrideClassOptions> = mutableListOf()
	operator fun String.invoke(block: CSSBuilder.() -> Unit) = classOverride(this, block)


	fun build(): dynamic {

		val js = js("{}")
		classSelectors.forEach {
			val content = js("{}")

			it.rulesSet.forEach {
			content[it.key.hyphenize()] = it.value
			}

			js[it.className] = content
		}

		return js
	}

	private fun classOverride(classSelector: String, block: RuleSet) = apply {
		val asJsObject =css.apply(block)
		val declarations = css.declarations
		classSelectors.add(OverrideClassOptions(classSelector, declarations))
	}
}


class MuiThemeOptions private constructor(typography: TypographyThemeOptions?, overrides: dynamic?) : ThemeOptions {

	override var typography: TypographyThemeOptions? = typography
	override  var overrides : dynamic? = overrides


	private constructor(builder: Builder) : this(builder.typography, builder.overrides)

	class Builder private constructor() {

		constructor(init: Builder.() -> Unit) : this() {
			init()
		}

		var typography: TypographyThemeOptions? = null
		var overrides: dynamic = null

		fun typography(block: MuiTypographyThemeOptions.Builder.() -> Unit) {
			typography = MuiTypographyThemeOptions.Builder().apply(block).build()
		}

		fun overrides(block: OverrideBuilder.() -> Unit) {
			overrides = OverrideBuilder().apply(block).build()
		}

		fun build() = MuiThemeOptions(typography, overrides)

	}

	companion object {
		fun create(init: Builder.() -> Unit) = Builder(init).build()
	}

}


class MuiTypographyThemeOptions(override var fontSize: Int?) : TypographyThemeOptions {

	class Builder {
		var fontSize: Int? = null

		fun build() = MuiTypographyThemeOptions(fontSize)
	}


}

fun RBuilder.MuiThemeProvider(theme: Theme, handler: RHandler<ThemeProps>) = child(MuiThemeProvider::class) {
	attrs.theme = theme
	handler()
}
