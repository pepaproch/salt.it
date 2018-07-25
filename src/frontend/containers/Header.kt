package frontend.containers

import kotlinext.js.Object
import kotlinx.css.Color
import kotlinx.css.padding
import kotlinx.css.px
import logo.logo
import react.*
import styled.StyleSheet
import styled.StyledComponents


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

    abstract var default: DefaultWraper<T>
}


external interface ReactAppBarProps : RProps {
    var title: String
    var typography: ReactAppBarTypography


}


external interface ReactAppBarTypography : RProps {
    var title: String
    var variant: String
    var align: String
    var className: String
    var classes : String

}

var css: Any = object {
    var flex: Any = object {
        val flexGrow: String = "1"
    }
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
        setState {
            pageTitle = props.title
        }

    }


    override fun RBuilder.render() {

        appBar {
            attrs {
                position = "static"
                color = "default"
                title = props.title
            }
            toolBar {
                iconButton {
                    menuIcon {

                    }
                }

                typoography {


                    attrs {

                        align = props.typography.align
                        variant = props.typography.variant



                    }
                    +"This should be Styled"


                }


                logo()

            }

        }


    }


}

class typo(override var title: String = "Page Title", override var variant: String = "title", override var align: String = "left", override var className: String = ComponentStyles.name, override var classes: String) : ReactAppBarTypography

object ComponentStyles : StyleSheet("ComponentStyles", isStatic = true) {
    val wrapper by css {
        padding(vertical = 16.px)
        backgroundColor = Color.green
    }
}


fun RBuilder.header(title: String) = child(Header::class) {
    ComponentStyles.inject()
    attrs.title = title
    attrs.typography = typo(align = "right" , classes = ComponentStyles.name)

}



