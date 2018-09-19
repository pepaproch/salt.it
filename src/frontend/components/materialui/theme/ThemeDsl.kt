package frontend.components.materialui.theme


import kotlinx.css.CSSBuilder

import react.RBuilder
import react.RHandler


typealias RuleSet = CSSBuilder.() -> Unit
typealias OptionsSet = OverrideBuilder.() -> Unit


interface OverideOptionWrapper {
	val overideRules: MutableList<OverrideComponentOptions>
	fun overideOption(selector: String, block: OptionsSet)

}

data class OverrideComponentOptions(val componentName: String, val classesSet: dynamic)
data class OverrideClassOptions(val className: String, val rulesSet: dynamic)


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
	operator fun String.invoke(block: OverrideClassOptionBuilder.() -> Unit) = classOverride(this, block)


	fun build(): dynamic {

		val js = js("{}")
		classSelectors.forEach {
			js[it.className] = css.apply(it.rulesSet)
		}

		return js
	}

	private fun classOverride(classSelector: String, block: RuleSet) = OverrideClassOptions(classSelector, block).apply {
		css.block()
		classSelectors.add(this)
	}
}


class MuiThemeOptions private constructor(typography: TypographyThemeOptions?, overrides: OverrideComponentOptions?) : ThemeOptions {

	override var typography: TypographyThemeOptions? = typography


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

		fun overides(block: OverrideBuilder.() -> Unit) {
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
