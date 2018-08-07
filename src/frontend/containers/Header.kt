package frontend.containers


import frontend.components.MuiTypography
import frontend.components.MuiTypographyColor


import react.*
import kotlin.reflect.KClass


@JsModule("@material-ui/core/AppBar")
external val reactAppBar: RClassWithDefault<AppBarrProps>

@JsModule("@material-ui/core/Toolbar")
external val reactToolBar: RClassWithDefault<RProps>


abstract class RClassWithDefault<T : RProps> : RClass<T>, KClass<Any> {

    abstract var default: RClassWithDefault<T>

}


interface AppBarrProps : RProps {
    var position: String
    var color: String
    var pageTitle: String
}

interface AppBarrState : RState {
    var pageTitle: String

}

class Header(props: AppBarrProps) : RComponent<AppBarrProps, AppBarrState>(props) {

    private val appBar = reactAppBar.default


    override fun AppBarrState.init(props: AppBarrProps) {

        pageTitle = props.pageTitle


    }


    override fun RBuilder.render() {

        reactAppBar.default {
            attrs {
                position = "static"
                color = MuiTypographyColor.DEFAULT.value

            }

            reactToolBar.default {
                pageTitle(state.pageTitle)
            }
        }


    }


}


fun RBuilder.header() = child(Header::class) {

    attrs.pageTitle = "Vulnerable Koltin APP"


}


fun RBuilder.pageTitle(text: String) = child(MuiTypography::class) {
    attrs.variant = "headline"
    attrs.text = text
    attrs.color = MuiTypographyColor.PRIMARY.value
}
