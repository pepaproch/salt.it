@file: JsModule("@material-ui/core/Typography")

package frontend.components.materialui.Typography

import frontend.components.materialui.MuiColor
import frontend.components.materialui.MuiColors
import react.*
import kotlin.js.*

external interface MuiTypographyProps : RProps {

    var align: String
    var children: Any?
    var classes: Any?
    var color: String
    var component: Any?
    var gutterBottom: Boolean
    var headlineMapping: dynamic?
    var noWrap: Boolean
    var paragraph: Boolean
    var variant: String

}

@JsName("default")
external class Typography : Component<MuiTypographyProps, RState> {
    override fun render(): ReactElement?
}