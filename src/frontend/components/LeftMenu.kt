package frontend.components





import frontend.components.materialui.MuiList
import frontend.components.materialui.MuiListItem
import frontend.components.materialui.MuiListItemText
import react.RBuilder
import react.RComponent
import react.RProps

import react.RState
import react.dom.p
import styled.css


class LeftMenu(props: RProps) : RComponent<RProps, RState>(props) {


    override fun RBuilder.render() {
        MuiList {
            css {
               put("width", "240px")
            }
            MuiListItem {
                MuiListItemText {
                    + "AAAAAAAAAAAAAAAAAAAAAAAAAAA"
                }
            }

            MuiListItem {

                MuiListItemText {
                    + "BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB"
                }
            }
        }

    }

}


fun RBuilder.leftMenu( ) = child(LeftMenu::class) {


}