package navigation

import react.*
import react.dom.div
import react.dom.h2


@JsModule("@material-ui/core/AppBar")
external val reactAppBar: DefaultWraper<AppBarrProps>


@JsModule("@material-ui/core/Toolbar")
external val reactToolBar: DefaultWraper<RProps>


@JsModule("@material-ui/core/IconButton")
external val reactIconButton: DefaultWraper<RProps>

@JsModule("@material-ui/core/Button")
external val reactButton: DefaultWraper<RProps>



@JsModule("@material-ui/core/Typography")
external val reactTypography: DefaultWraper<ReactAppBarTypography>


@JsModule("@material-ui/icons/Menu")
external val reactMenuIcon: DefaultWraper<RProps>

abstract class DefaultWraper<T : RProps> : RClass<T> {

     abstract var default : DefaultWraper<T>
}


external interface ReactAppBarProps : RProps {
    var title: String
    var typography :ReactAppBarTypography


}


external interface ReactAppBarTypography: RProps {
    var title: String

}




interface AppBarrProps : RProps {
    var title: String
    var position : String
    var color : String
}

interface AppBarrState : RState {




}

class AppNavigation(props:ReactAppBarProps) : RComponent<ReactAppBarProps, AppBarrState>(props) {

    private val appBar  =  reactAppBar.default
    private val  toolBar = reactToolBar.default
    private val iconButton = reactIconButton.default
    private val menuIcon = reactMenuIcon.default
    private  val button = reactButton.default
    private  val typoography = reactTypography.default

    override fun AppBarrState.init(props: AppBarrProps) {


    }

    private fun handleChange(value: String) {

        console.log(value)
    }

    override fun RBuilder.render() {

        appBar {
            attrs {AppBarrProps
                position = "static"
                color = "defaul"
                title = props.title
            }
          toolBar {
              iconButton {
                  menuIcon {}
              }
              typoography {
                + props.title
                }


          }
        }





    }

}

fun RBuilder.appBarr(title: String) = child(AppNavigation::class) {
    attrs.title = title
    attrs.typography = {
        attrs {
            title = "jok"
        }
    }



}