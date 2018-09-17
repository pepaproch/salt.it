package frontend.components.materialui.Typography


import frontend.components.materialui.MuiColor
import frontend.components.materialui.MuiColors
import frontend.components.materialui.MuiTextAlign
import react.*


enum class MuiColorTypography(override val value: String) : MuiColors {
    TEXT_SECONDARY("textSecondary"),
    ERROR("ERROR"),
}

enum class MuiTypographyVariant(val value: String) {
    DISPLAY4("display4"),
    DISPLAY3("display3"),
    DISPLAY2("display2"),
    DISPLAY1("display1"),
    HEADLINE("headline"),
    TITLE("title"),
    SUBHEADING("subheading"),
    BODY2("body2"),
    BODY1("body1"),
    CAPTION("caption"),
    BUTTON("button"),

}


fun RBuilder.Typography(align: MuiTextAlign = MuiTextAlign.INHERIT,
                        children: Any? = null,
                        classes: Any? = null,
                        color: MuiColors = MuiColor.INHERIT,
                        component: Any? = null,
                        gutterBottom: Boolean = false,
                        headlineMapping: dynamic? = null,
                        noWrap: Boolean = false,
                        paragraph: Boolean = false,
                        variant: MuiTypographyVariant = MuiTypographyVariant.BODY1,
                        handler: RHandler<MuiTypographyProps>): ReactElement = child(Typography::class) {
    attrs.align = align.value
    attrs.children = children ?: attrs.children
    attrs.classes = classes ?: attrs.classes
    attrs.color = color.value
    attrs.component = component ?: attrs.component
    attrs.gutterBottom = gutterBottom
    attrs.headlineMapping = headlineMapping ?: attrs.headlineMapping
    attrs.noWrap = noWrap
    attrs.paragraph = paragraph
    attrs.variant = variant.value

    handler()

}