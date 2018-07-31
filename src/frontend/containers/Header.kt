package frontend.containers


import frontend.components.MuiTypography
import kotlinx.css.*
import kotlinx.html.DIV
import logo.logo
import react.*
import react.dom.WithClassName
import styled.*
import kotlin.reflect.KClass


@JsModule("@material-ui/core/AppBar")
external val reactAppBar: RClassWithDefault<AppBarrProps>

@JsModule("@material-ui/core/Toolbar")
external val reactToolBar: RClassWithDefault<RProps>


@JsModule("@material-ui/core/IconButton")
external val reactIconButton: RClassWithDefault<RProps>

@JsModule("@material-ui/core/Button")
external val reactButton: RClassWithDefault<RProps>


@JsModule("@material-ui/core/Typography")
external val reactTypography: RClassWithDefault<ReactAppBarTypography>


@JsModule("@material-ui/icons/Menu")
external val reactMenuIcon: RClassWithDefault<RProps>


abstract class RClassWithDefault<T : RProps> : RClass<T>, KClass<Any> {

    abstract var default: RClassWithDefault<T>

}


external interface ReactAppBarProps : RProps {
    var title: String
    var typography: ReactAppBarTypography



}


external interface ReactAppBarTypography : WithClassName {
    var title: String
    var variant: String
    var align: String
    override var className: String?
    var color: String

}





interface AppBarrProps : RProps {
    var title: String
    var position: String
    var color: String
}

interface AppBarrState : RState {
    var pageTitle: String

}

class Header(props: ReactAppBarProps) : RComponent<ReactAppBarProps, AppBarrState>(props) {

    private val appBar = reactAppBar.default
    private val toolBar = reactToolBar.default
    private val iconButton = reactIconButton.default
    private val menuIcon = reactMenuIcon.default
    private val button = reactButton.default
    private val typoography = reactTypography.default


    override fun AppBarrState.init(props: ReactAppBarProps) {

            pageTitle = props.title



    }


    override fun RBuilder.render() {

        reactAppBar.default {
            attrs {
                position = "static"
                color = "default"
                title = props.title

            }
            reactToolBar.default {
                iconButton {
                    menuIcon {

                    }
                }

                styled(reactTypography )
            }



                logo()
                }




            }




    }




class typo(override var title: String = "Page Title", override var variant: String = "title", override var align: String = "left", override var color: String = "primary", override var className: String?) : ReactAppBarTypography



fun RBuilder.header(title: String) = child(Header::class) {

    attrs.title = title
    attrs.typography = typo(align = "right" ,color = "primary" , className = "ReactTypoGraphy")



}



