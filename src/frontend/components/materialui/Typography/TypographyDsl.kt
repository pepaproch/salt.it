package frontend.components.materialui.Typography



import frontend.components.MuiTypographyColor
import kotlinx.css.TextAlign
import react.*




fun RBuilder.Typography(variant: String = "title" , color: String = MuiTypographyColor.INHERIT.value ,handler: RHandler<MuiTypographyProps>): ReactElement = child(Typography::class) {
    attrs.variant = variant
    attrs.color = color
    attrs.align = TextAlign.right.toString()
    handler.invoke(this)

}