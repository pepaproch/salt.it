
@file: JsModule("@material-ui/core/Typography")
package frontend.components.materialui.Typography
import react.*
import kotlin.js.*

external interface MuiTypographyProps : RProps {
    var variant: String
    var color: String
    var style : dynamic
    var align : String

}
@JsName("default")
external class Typography: Component<MuiTypographyProps, RState> {
    override fun render(): ReactElement?
}