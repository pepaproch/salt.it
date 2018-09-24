@file:JsModule("@material-ui/core/styles")

package frontend.components.materialui.theme

import kotlinext.js.Object
import react.*

external  fun createMuiTheme(): Theme
external  fun createMuiTheme(options: dynamic?) : Theme


external interface ThemeProps: RProps {
    var theme: Any
    var sheetsManager : Any?
    var disableStylesGeneration : Boolean
}

 external class MuiThemeProvider(theme: Theme) : Component<ThemeProps, RState> {
     override fun render() : ReactElement = definedExternally

 }




    external interface Theme {
    var shape: Object
    var breakpoints: Object
    var direction: Object
    var mixins: Object
    var overrides: Object
    var palette: Object
    var props: RProps
    var shadows: Object
    var spacing: Object
    var transitions: Object
    var typography: Object
    var zIndex: Object
}


external interface ThemeOptions {
//  var  shape: Object
//   var breakpoints: Object
//   var direction: Object
//   var mixins: Object
 var overrides: dynamic?
//    var palette: Object
//    var props: Object
//   var shadows: Object
//   var spacing: Object
//    var transitions: Object
    var typography: TypographyThemeOptions?
//    var zIndex: Object
}


external interface TypographyThemeOptions {
var fontSize: Int?
}

