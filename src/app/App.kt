package app


import react.RBuilder
import react.RComponent
import react.RProps
import react.RState

import frontend.containers.header

class App : RComponent<RProps, RState>() {
    override fun RBuilder.render() {
            header("Test")

    }
}

fun RBuilder.app() = child(App::class) {}
