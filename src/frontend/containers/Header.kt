package frontend.containers


import frontend.components.MuiTypography
import frontend.components.MuiTypographyColor

import kotlinx.css.*


import react.*
import styled.*

import kotlin.reflect.KClass


@JsModule("@material-ui/core/AppBar")
external val reactAppBar: RClassWithDefault<AppBarrProps>

@JsModule("@material-ui/core/Toolbar")
external val reactToolBar: RClassWithDefault<RProps>


@JsModule("@material-ui/core/IconButton")
external val reactIconButton: RClassWithDefault<RProps>

@JsModule("@material-ui/core/Button")
external val reactButton: RClassWithDefault<DrawerButtonProps>





@JsModule("@material-ui/icons/Menu")
external val reactMenuIcon: RClassWithDefault<RProps>


abstract class RClassWithDefault<T : RProps> : RClass<T>, KClass<Any> {

    abstract var default: RClassWithDefault<T>

}

interface DrawerButtonProps : RProps {
    var onClick: () -> Unit

}

interface AppBarrProps : StyledProps {
    var position: String
    var color: String
    var pageTitle: String
    var openDraver: () -> Unit

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

var drawerWidth : LinearDimension = LinearDimension("200px")

  val  appBarShift by css {
        marginLeft = LinearDimension("100px")
        width = drawerWidth

    }
}




class Header(props: AppBarrProps) : RComponent<AppBarrProps, AppBarrState>(props) {

    private val appBar = styled(reactAppBar.default)


    override fun AppBarrState.init(props: AppBarrProps) {

        pageTitle = props.pageTitle


    }


    override fun RBuilder.render() {

        appBar {
            css {
                + ComponentStyles.appBarShift
            }
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
