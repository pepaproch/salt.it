package frontend.components



import frontend.containers.*
import kotlinx.css.*
import react.RBuilder
import react.RComponent
import react.RState
import styled.*



@JsModule("@material-ui/core/Drawer")
external val reactDrawer: RClassWithDefault<MuiDrawerProps>
var styledreactDrawer = styled(reactDrawer.default)




interface MuiDrawerProps : StyledProps {
    var anchor: String
    var onClose: () -> Unit
    var variant: String
    var open: Boolean

}

interface MuiDrawerState : RState {
    var open: Boolean
}

object DrawerComponentStyles : StyleSheet("leftDrawer", isStatic = true) {

    var drawerWidth : LinearDimension = LinearDimension("240px")


    val drawerPaper by css  {
        position = Position.relative
        whiteSpace = WhiteSpace.nowrap
        width =  drawerWidth
    }

    val   drawerPaperClose by css {
        overflowX = Overflow.hidden

        width = drawerWidth
    }
}


class MuiDrawer(props: MuiDrawerProps) : RComponent<MuiDrawerProps, MuiDrawerState>(props) {


    override fun RBuilder.render() {

        styledreactDrawer {
           css {
              + DrawerComponentStyles.drawerPaper
               if(!props.open) {
                   + DrawerComponentStyles.drawerPaperClose
               }

           }
            attrs {
                open = props.open
                variant = props.variant

            }

            leftMenu()

        }
    }

}


fun RBuilder.leftDrawer(open: Boolean) = child(MuiDrawer::class) {

    attrs.anchor = "left"
    attrs.variant = "persistent"
    attrs.open = open

}