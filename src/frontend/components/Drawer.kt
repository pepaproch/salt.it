package frontend.components



import frontend.containers.*
import kotlinx.css.*
import react.*
import styled.*



@JsModule("@material-ui/core/Drawer")
external val reactDrawer: RClassWithDefault<MuiDrawerProps>
var styledreactDrawer = styled(reactDrawer.default)




interface MuiDrawerProps : StyledProps {
    var anchor: String
    var variant: String
    var open: Boolean
    var content : () -> ReactElement

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
                +DrawerComponentStyles.drawerPaper
                if (!props.open) {
                    +DrawerComponentStyles.drawerPaperClose
                }

            }
            attrs {
                open = props.open
                variant = props.variant


            }
            child(props.content())



        }
    }


}


