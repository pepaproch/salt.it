package app

import logo.logo
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.code
import react.dom.div
import react.dom.h1
import react.dom.p
import ticker.ticker
import editor.quill
import navigation.appBarr

class App : RComponent<RProps, RState>() {
    override fun RBuilder.render() {
        div("App-header") {
            logo()
            h1 {
                +"Welcome to React with Kotlin"
            }
        }
        p("App-intro") {
            +"To get started, edit "
            code { +"ddapp/App.kt" }
            +" and save to reload."
        }
        p("App-ticker") {
            ticker()
        }
        quill("ahoj")

        p{
            appBarr("Test")
        }
    }
}

fun RBuilder.app() = child(App::class) {}
