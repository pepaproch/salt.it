@file:JsModule("@material-ui/core/List")


package frontend.components.materialui.list

import react.*
import styled.StyledProps


external interface ListProps : StyledProps {
    var component: Component<ListProps, RState>?
    var dense : Boolean?
    var disablePadding: Boolean?
    var subheader : ReactElement?
}
@JsName("default")
external class List : Component<ListProps,RState> , RClass<ListProps> {
    override var displayName: String?
    override fun render() = definedExternally

}
