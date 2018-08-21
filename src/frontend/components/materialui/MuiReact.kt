package frontend.components.materialui
interface MuiColors {
    val value: String
}

enum class MuiColor(override val value: String) : MuiColors {
    INHERIT("inherit"),
    PRIMARY("primary"),
    SECONDARY("secondary"),
    DEFAULT("default");

}


enum class MuiTextAlign (val value : String) {
INHERIT("inherit"),
 LEFT("left"),
 CENTER("center"),
 RIGHT("right"),
 JUSTIFY("justify"),


}