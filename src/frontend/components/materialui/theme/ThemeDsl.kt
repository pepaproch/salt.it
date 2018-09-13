package frontend.components.materialui.theme

import kotlinx.css.RuleSet
import react.RBuilder
import react.RHandler


data class OverideComponentOptions (val selectorName : String , val ruleSet: RuleSet )
data class OverideOptions(val component: String )


class OverideBuilder {

    fun build(): OverideOptions {
     return   OverideOptions("")
    }
}
val OverideBuilder.muiSlider :ComponentSelector get() = ComponentSelector("MuiSlider")

class MuiThemeOptions private constructor(typography: TypographyThemeOptions?) : ThemeOptions {

    override var typography: TypographyThemeOptions? = typography


    private constructor(builder: Builder) : this(builder.typography)

    class Builder private constructor() {

        constructor(init: Builder.() -> Unit) : this() {
            init()
        }

        var typography: TypographyThemeOptions? = null
        var overides : OverideOptions ? = null
        fun typography(block: MuiTypographyThemeOptions.Builder.() -> Unit) {
            typography = MuiTypographyThemeOptions.Builder().apply(block).build()
        }

        fun overides(block : OverideBuilder.()-> Unit) {
           overides =  OverideBuilder().apply(block).build()
        }

        fun build() = MuiThemeOptions(typography)

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