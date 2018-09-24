package frontend.components.materialui.Slider

import frontend.components.materialui.list.ListProps
import frontend.components.materialui.list.muiList
import frontend.components.materialui.list.setProps
import org.w3c.dom.events.Event
import react.*


fun RBuilder.slider(component: Component<RProps, RState>? = null,
					disabled: Boolean? = false,
					reverse: Boolean? = false,
					vertical: Boolean? = false,
					max: Number? = 500,
					min: Number? = 0,
					step: Number? = 1,
					value: Number? = 50,
					onChange: (event: Event, value: Number) -> Unit = { event, value -> console.log(event) },
					onDragEnd: (event: Event) -> Unit = { event -> console.log(event) },
					onDragStart: (event: Event) -> Unit = { event -> console.log(event) },
					handler: RHandler<SliderProps>) = muiSlider {

	component?.let { attrs.component = component }
	attrs.disabled = disabled
	attrs.reverse = reverse
	attrs.vertical = vertical
	attrs.max = max
	attrs.min = min
	attrs.step = step
	attrs.value = value
	attrs.onChange = onChange
	attrs.onDragEnd = onDragEnd
	attrs.onDragStart = onDragStart


	handler()
}
