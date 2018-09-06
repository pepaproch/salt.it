package frontend.components.materialui.list

import react.*

import styled.*


fun RBuilder.list(component: Component<ListProps, RState>? = null, dense: Boolean = false, disablePadding: Boolean = false, subheader: ReactElement? = null, handler: RHandler<ListProps>) = muiList {
	setProps(component, dense, disablePadding, subheader, attrs)
	handler()
}


fun RBuilder.styledList(component: Component<ListProps, RState>? = null, dense: Boolean = false, disablePadding: Boolean = false, subheader: ReactElement? = null, handler: StyledHandler<ListProps>): ReactElement {
	return (styled(muiList)){
		setProps(component, dense, disablePadding, subheader, attrs)
		handler()
	}

}

fun <P : StyledProps> RBuilder.styledComponent(rClass: RClass<P>): RBuilder.(StyledHandler<P>) -> ReactElement = { handler ->
	child(with(StyledElementBuilder<P>(rClass)) {
		handler()
		create()
	})
}

fun setProps(component: Component<ListProps, RState>?, dense: Boolean, disablePadding: Boolean, subheader: ReactElement?, attrs: ListProps) {
	attrs.dense = dense
	subheader?.let { attrs.subheader = subheader }
	component?.let { attrs.component = component }
	attrs.disablePadding = disablePadding
}


