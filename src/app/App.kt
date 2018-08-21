package app



import frontend.components.MuiDrawer

import frontend.components.leftMenu
import frontend.components.materialui.Typography.MuiTypographyVariant
import frontend.components.materialui.Typography.Typography
import frontend.containers.Header
import frontend.containers.RClassWithDefault
import kotlinext.js.Object
import react.*

@JsModule("@material-ui/core/styles/MuiThemeProvider")
external val reactTh: RClassWithDefault<RProps>

@JsModule("@material-ui/core")
external  val  ssss : Object


interface AppState : RState {
    var drawerOpen: Boolean
    var currentPage: String
}

interface AppProp : RProps {
    var initialPage: String
}




class App(props: AppProp) : RComponent<AppProp, AppState>(props) {

    private fun togleDrawer(open: Boolean) {


            setState {
                drawerOpen = open
            }


    }

    override fun AppState.init(props: AppProp) {

        drawerOpen = false
        currentPage = props.initialPage


    }


    override fun RBuilder.render() {
 var propTypes = ssss

            header(opened = state.drawerOpen,
                    handleDrawerOpen = { togleDrawer(true) }, curentPage = state.currentPage)



            leftDrawer(state.drawerOpen, content = { leftMenu({ togleDrawer(false) }) })



        }
}

fun RBuilder.app() = child(App::class) {
    attrs.initialPage = "Kotlin React App"
}


fun RBuilder.header(opened: Boolean, handleDrawerOpen: () -> Unit, curentPage: String) = child(Header::class) {
    attrs.drawerOpened = opened
    attrs.handleDrawerOpen = handleDrawerOpen
    attrs.curentPage = curentPage

}


fun RBuilder.leftDrawer(open: Boolean, content: () -> ReactElement) = child(MuiDrawer::class) {

    attrs.anchor = "left"
    attrs.variant = "persistent"
    attrs.open = open
    attrs.content = content

}