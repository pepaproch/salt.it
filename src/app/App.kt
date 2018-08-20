package app


import frontend.components.leftDrawer
import frontend.containers.Header
import frontend.components.materialui.Typography
import react.*


interface AppState : RState {
    var drawerOpen: Boolean
    var currentPage: String
}


class App : RComponent<RProps, AppState>() {

    override fun AppState.init(props: RProps) {
setState {
    drawerOpen = false
    currentPage = "Home"
    console.log("INIT STATE")
}
    }


    override fun RBuilder.render() {

        header(state.drawerOpen ,handleDrawerOpen = {
            setState {
                drawerOpen = !drawerOpen
            }
            console.log("CHANGE STATE")
        })
        leftDrawer(state.drawerOpen)

           tTypography {
               +"dddddddddddddddd"
           }
    }

}

fun RBuilder.app() = child(App::class) {
}


fun RBuilder.header(opened :Boolean,handleDrawerOpen: () -> Unit) = child(Header::class) {
   attrs.drawerOpened= opened
    attrs.handleDrawerOpen = handleDrawerOpen

}


fun RBuilder.tTypography(handler: RHandler<RProps>?) : ReactElement =  child(Typography::class) {
    attrs.color = "inherit"
    handler?.invoke(this)
}