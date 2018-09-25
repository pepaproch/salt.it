package index

import frontend.app.*
import kotlinext.js.*
import react.dom.*
import kotlin.browser.*

fun main(args: Array<String>) {
    requireAll(require.context("src", true, js("/\\.css$/")))
    require("react-quill/dist/quill.snow.css")

    render(document.getElementById("root")) {
        app()
    }
}
