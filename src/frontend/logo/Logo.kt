package frontend.logo

import react.*
import react.dom.*
import styled.css
import styled.styledDiv

@JsModule("src/frontend.logo/react.svg")
external val reactLogo: dynamic
@JsModule("src/frontend.logo/kotlin.svg")
external val kotlinLogo: dynamic



fun RBuilder.logo(height: Int = 5) {
   styledDiv {
       css {
        put ("flex", "1")
           put("height" , "100px")
       }

        img(alt = "React frontend.logo.frontend.logo", src = reactLogo, classes = "Logo-react" ) {}
        img(alt = "Kotlin frontend.logo.frontend.logo", src = kotlinLogo, classes = "Logo-kotlin") {}
    }
}
