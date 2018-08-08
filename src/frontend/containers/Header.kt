package frontend.containers


import frontend.components.MuiTypography
import frontend.components.MuiTypographyColor

import kotlinx.css.*


import react.*
import styled.StyleSheet
import styled.css
import styled.styledDiv

import kotlin.reflect.KClass


@JsModule("@material-ui/core/AppBar")
external val reactAppBar: RClassWithDefault<AppBarrProps>

@JsModule("@material-ui/core/Toolbar")
external val reactToolBar: RClassWithDefault<RProps>


@JsModule("@material-ui/core/IconButton")
external val reactIconButton: RClassWithDefault<RProps>

@JsModule("@material-ui/core/Button")
external val reactButton: RClassWithDefault<RProps>





@JsModule("@material-ui/icons/Menu")
external val reactMenuIcon: RClassWithDefault<RProps>


abstract class RClassWithDefault<T : RProps> : RClass<T>, KClass<Any> {

    abstract var default: RClassWithDefault<T>

}


interface AppBarrProps : RProps {
    var position: String
    var color: String
    var pageTitle: String
}

interface AppBarrState : RState {
    var pageTitle: String

}

object ComponentStyles : StyleSheet("HeaderStyles", isStatic = true) {
    val wrapper by css {
        padding(vertical = 16.px)

        width = LinearDimension("100%")
        display = Display.flex
    }
}




class Header(props: AppBarrProps) : RComponent<AppBarrProps, AppBarrState>(props) {

    private val appBar = reactAppBar.default


    override fun AppBarrState.init(props: AppBarrProps) {

        pageTitle = props.pageTitle


    }


    override fun RBuilder.render() {

        reactAppBar.default {
            attrs {
                position = "static"
                color = MuiTypographyColor.DEFAULT.value

            }

            reactToolBar.default {
                reactMenuIcon.default {
                    reactMenuIcon.default {

                    }
                }
                styledDiv {
                    css  {
                        + ComponentStyles.wrapper

                    }

                   styledDiv {
                       css {
                           flexGrow = 1.0
                       }
                       pageTitle(state.pageTitle)
                   }



                }
            }
        }


    }


}


fun RBuilder.header() = child(Header::class) {

    attrs.pageTitle = "Vulnerable Koltin APP"


}





fun RBuilder.pageTitle(text: String) = child(MuiTypography::class) {
    attrs.variant = "headline"
    attrs.text = text
    attrs.color = MuiTypographyColor.PRIMARY.value
    attrs.align = TextAlign.right.toString()

}
