package frontend.components.materialui.theme

import kotlinx.css.CSSBuilder
import kotlinx.css.StyledElement
import react.RBuilder
import react.RHandler


typealias RuleSet = CSSBuilder.() -> Unit
typealias OptionsSet = OverideBuilder.() -> Unit

interface OverideOptionWrapper {
    val overideRules: MutableList<OverrideComponentOptions>
    fun overideOption(selector: String , block : OptionsSet)

}

data class OverrideComponentOptions(val componentName: String, val classesSet: OverideBuilder.() -> Unit)
data class OverrideClassOptions(val className: String, val rulesSet: RuleSet)




class OverideBuilder {


    val overideComponentRules: MutableList<OverrideComponentOptions> = mutableListOf()

    operator fun String.invoke(block: OverideBuilder.() -> Unit) = componentOverride(this,block)

    operator fun ComponentSelector.invoke(block: OverideBuilder.() -> Unit) = componentName(block)

    fun build(): MutableList<OverrideComponentOptions>{

        return overideComponentRules
    }
    private fun componentOverride(componentSelector: String, block: OptionsSet): OverrideComponentOptions = OverrideComponentOptions(componentSelector,block).apply {
        overideComponentRules.add(this)
    }
}



class MuiThemeOptions private constructor(typography: TypographyThemeOptions? , overrides :  OverrideComponentOptions?) : ThemeOptions {

    override var typography: TypographyThemeOptions? = typography


    private constructor(builder: Builder) : this(builder.typography , builder.overrides)

    class Builder private constructor() {

        constructor(init: Builder.() -> Unit) : this() {
            init()
        }

        var typography: TypographyThemeOptions? = null
        var overrides :OverrideComponentOptions? = null

        fun typography(block: MuiTypographyThemeOptions.Builder.() -> Unit) {
            typography = MuiTypographyThemeOptions.Builder().apply(block).build()
        }

        fun overides(block: OverideBuilder.() -> Unit) {
            overrides = OverideBuilder().apply(block).build()
        }

        fun build() = MuiThemeOptions(typography ,overrides)

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
