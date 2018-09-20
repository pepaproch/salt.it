package frontend.containers



import frontend.components.materialui.Slider.slider
import frontend.components.materialui.Typography.MuiTypographyVariant
import frontend.components.materialui.Typography.Typography
import kotlinx.css.*


import react.*
import styled.*

import kotlin.reflect.KClass


@JsModule("@material-ui/core/AppBar")
external val reactAppBar: RClassWithDefault<AppBarrProps>

@JsModule("@material-ui/core/Toolbar")
external val reactToolBar: RClassWithDefault<RProps>


@JsModule("@material-ui/core/IconButton")
@JsName("default")
external val reactIconButton: RClassWithDefault<DrawerButtonProps>

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
    var handleDrawerOpen : () -> Unit
    var drawerOpened : Boolean
     var curentPage: String
}



object ComponentStyles : StyleSheet("HeaderStyles", isStatic = true) {

    var drawerWidth : LinearDimension = LinearDimension("240px")

    val wrapper by css {
        display = Display.flex
    }


    val  appBar by css {
        width = LinearDimension("100%")
        marginLeft = LinearDimension("0")



    }

  val  appBarShift by css {
        width = LinearDimension("100%") - LinearDimension(drawerWidth.value)
        marginLeft = LinearDimension(drawerWidth.value)



    }
}





class Header(props: AppBarrProps) : RComponent<AppBarrProps, RState>(props) {

    private val appBar = styled(reactAppBar.default)





    override fun RBuilder.render() {

        appBar {
            css {
                when(props.drawerOpened) {
                    false -> +ComponentStyles.appBar
                    true -> +ComponentStyles.appBarShift
                }
            }
            attrs {
                position = "static"


            }

            reactToolBar.default {
                if(!props.drawerOpened) {
                    reactIconButton.default {

                        attrs.onClick = props.handleDrawerOpen
                        reactMenuIcon.default {

                        }
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
                       pageTitle(props.curentPage)
                   }
                    styledDiv {
                        slider {  }
                    }



                }
            }
        }


    }


}







fun RBuilder.pageTitle(text: String ) = Typography(variant = MuiTypographyVariant.HEADLINE) {

+text
}