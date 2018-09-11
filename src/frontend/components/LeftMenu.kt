package frontend.components


import frontend.components.materialui.*
import frontend.components.materialui.list.list
import frontend.components.materialui.list.muiList
import frontend.components.materialui.list.styledList
import kotlinx.css.*
import react.RBuilder
import react.RComponent
import react.RProps

import react.RState
import react.router.dom.navLink
import styled.StyleSheet
import styled.css
import styled.styledDiv
import styled.styledLi

interface LeftMenuProps : RProps {
    var handleDrawerClose : () -> Unit
}


class LeftMenu(props: LeftMenuProps) : RComponent<LeftMenuProps, RState>(props) {

    object DrawerHeaderStyles : StyleSheet(name = "drawerHeader") {
        val drawerHeader by css {
            display = Display.flex
            alignItems = Align.center
            justifyContent = JustifyContent.flexEnd
            minHeight = LinearDimension("64px")
            paddingRight = LinearDimension("16px")
        }
    }


    override fun RBuilder.render() {
        styledDiv {
            styledDiv {
                css {
                    +DrawerHeaderStyles.drawerHeader
                }
                MuIButtonIcon {

                    attrs {
                        onClick = props.handleDrawerClose
                    }
                    MuIChevronLeftIcon {
                        attrs {

                        }
                    }
                }
            }


            MuiDivider {}
           styledList {
            css {
                put("width" , "240px")

            }
               navLink ("p1") {
                   MuiListItem {

                       attrs {
                           button = true
                           divider = true
                       }
                       MuiListItemText {
                           +"Hello "
                       }
                   }
               }
               navLink ("p2") {
                   MuiListItem {

                       MuiListItemText {
                           attrs { primary = "Heloo" }
                       }
                   }
               }
            }
        }
    }

}


fun RBuilder.leftMenu(handleDrawerClose : ()->Unit) = child(LeftMenu::class) {
   attrs.handleDrawerClose = handleDrawerClose

}