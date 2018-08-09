package frontend.components


import frontend.containers.*
import frontend.containers.ComponentStyles
import kotlinext.js.getOwnPropertyNames

import kotlinx.css.*
import react.RBuilder
import react.RComponent

import react.RState
import react.dom.div
import react.dom.p
import styled.*

@JsModule("@material-ui/core/Drawer")
external val reactDrawer: RClassWithDefault<MuiDrawerProps>

var  styledreactDrawer = styled(reactDrawer.default)


interface MuiDrawerProps  : StyledProps {
 var   anchor : String
 var    open : Boolean
  var onClose : Any
  var variant : String

}


object DrawerComponentStyles : StyleSheet("leftDrawer", isStatic = true) {
    val wrapper by ComponentStyles.css {



    }
}




class MuiDrawer(props: MuiDrawerProps) : RComponent<MuiDrawerProps, RState>(props) {
    override fun RBuilder.render() {


        styledreactDrawer {

            attrs {
                open = props.open


            }
            css  {

            }
            p {
                + "ssssssssssssssssssssssssssssssssssssssssssssssssssssssss"
            }
        }
    }

}


fun RBuilder.leftDrawer() =  child(MuiDrawer::class) {
    attrs.open = false
    attrs.anchor= "left"
    attrs.variant = "permanent"

}