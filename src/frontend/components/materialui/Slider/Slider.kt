@file:JsModule("@material-ui/lab/Slider")


package frontend.components.materialui.Slider


import org.w3c.dom.events.Event
import react.*
import styled.StyledProps


external interface SliderProps : StyledProps {
    var component: Component<RProps, RState>?
    var disabled: Boolean?
    var reverse: Boolean?
    var vertical: Boolean?
    var max: Number?
    var min: Number?
    var step: Number?
    var value: Number ?
    var onChange : (event:Event , value: Number) -> Unit ?
    var onDragEnd : (event:Event ) -> Unit ?
    var onDragStart : (event:Event ) -> Unit ?



}
@JsName("default")
external val  muiSlider : RClass<SliderProps>



