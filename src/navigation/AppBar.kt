package navigation

import react.*
import react.dom.div




@JsModule("@material-ui/core")
external val reactAppBar: RClass<ReactAppBarProps>

external interface ReactAppBarProps : RProps {
    var title: String
    var onChange: (String) -> Unit
}

interface AppBarrProps : RProps {
    var title: String
}

interface AppBarrState : RState {
    var title: String
}


class AppBar(props:AppBarrProps) : RComponent<AppBarrProps, AppBarrState>(props) {

    override fun AppBarrState.init(props: AppBarrProps) {
       title = props.title
    }

    private fun handleChange(value: String) {
        setState {
            title = value
        }
        console.log(value)
    }

    override fun RBuilder.render() {
        div {
       reactAppBar {
           attrs {
               title = state.title
           }
       }
        }
    }
}

fun RBuilder.appBarr(title: String) = child(AppBar::class) {
    attrs.title = title
}