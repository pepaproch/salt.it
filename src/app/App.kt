package app




import react.RBuilder
import react.RComponent
import react.RProps
import react.RState

import frontend.containers.header
import react.dom.p

class App : RComponent<RProps, RState>() {
    override fun RBuilder.render() {
        header()

    }
}

fun RBuilder.app() = child(App::class) {}
