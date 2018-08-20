

package frontend.components

import frontend.containers.*
import kotlinx.css.Color
import kotlinx.css.hyphenize
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState


@JsModule("@material-ui/core/Typography")
external val reactTypography: RClassWithDefault<MuiTypographyProps>

interface MuiTypographyProps : RProps {
    var text: String
    var variant: String
    var color: String
    var style : dynamic
    var align : String

}

enum class MuiTypographyColor(val value: String) {
    INHERIT("inherit"),
    PRIMARY("primary"),
    TEXT_SECONDARY("textSecondary"),
    SECONDARY("secondary"),
    ERROR("ERROR"),
    DEFAULT("default");
    override fun toString() = value

}

enum class MuiTypographyPossition(val value : String) {
    STATIC("static")
}
class MuiTypography(props: MuiTypographyProps) : RComponent<MuiTypographyProps, RState>(props) {

    override fun RBuilder.render() {
        console.log(props.style)
        reactTypography.default {
            attrs {
                variant = props.variant
                color = props.color
                style = props.style
                align = props.align
            }
            +props.text
        }
    }

}

