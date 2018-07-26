package frontend.containers

import react.*



import kotlinext.js.Object
import kotlinx.css.Color
import kotlinx.css.padding
import kotlinx.css.px
import logo.logo
import react.*
import styled.StyleSheet
import styled.StyledComponents


@JsModule("@material-ui/core/AppBar")
external val typography: RClass<RProps>

class AppTypography(props: RProps) : RComponent<RProps, RState>(props) {
    override fun RBuilder.render() {

        var t : RComponent<RProps,RState> = typography.asDynamic().default as RComponent<RProps,RState>

        t {

            +"TYP"
        }
    }

}


fun RBuilder.typography() = child(AppTypography::class) {


}