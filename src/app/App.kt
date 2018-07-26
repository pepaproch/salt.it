package app


import react.RBuilder
import react.RComponent
import react.RProps
import react.RState

import frontend.containers.header
import frontend.containers.typography

class App : RComponent<RProps, RState>() {
    override fun RBuilder.render() {
           typography()

    }
}

fun RBuilder.app() = child(App::class) {}
