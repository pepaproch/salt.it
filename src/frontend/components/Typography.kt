package frontend.components

import frontend.containers.*
import kotlinx.css.CSSBuilder
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.span
import styled.styled
import styled.styledDiv

@JsModule("@material-ui/core/Typography")
external val reactTypography: RClassWithDefault<RProps>

interface MuiTypographyProps :RProps  {
    var  title :String
}

class MuiTypography(props: MuiTypographyProps) : RComponent<MuiTypographyProps, RState>(props = props) {
    val css = CSSBuilder()

    override fun RBuilder.render() {

        reactTypography.default {

        }
    }

}

fun RBuilder.mUiTypography(title :String) = child(MuiTypography::class) {

attrs.title = title
}