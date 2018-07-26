package logo

import react.*
import react.dom.*
import styled.css
import styled.styledDiv

@JsModule("src/logo/react.svg")
external val reactLogo: dynamic
@JsModule("src/logo/kotlin.svg")
external val kotlinLogo: dynamic



fun RBuilder.logo(height: Int = 5) {
   styledDiv {
       css {
        put ("flex", "1")
           put("height" , "100px")
       }

        img(alt = "React logo.logo", src = reactLogo, classes = "Logo-react" ) {}
        img(alt = "Kotlin logo.logo", src = kotlinLogo, classes = "Logo-kotlin") {}
    }
}
