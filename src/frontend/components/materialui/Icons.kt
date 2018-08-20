package frontend.components.materialui

import frontend.containers.RClassWithDefault
import react.RBuilder

import react.ReactElement

import styled.StyledHandler
import styled.StyledProps
import styled.styled

@JsModule("@material-ui/icons/Menu")
external val reactMenuIcon: RClassWithDefault<MuiIconProps>

val MuImenuIcon: RBuilder.(StyledHandler<MuiIconProps>) -> ReactElement = styled(reactMenuIcon.default)


@JsModule("@material-ui/icons/ChevronLeft")
external val reacChevronLeftIcon: RClassWithDefault<MuiIconProps>

val MuIChevronLeftIcon: RBuilder.(StyledHandler<MuiIconProps>) -> ReactElement = styled(reacChevronLeftIcon.default)



interface  MuiIconProps : StyledProps {
 var   color : String
}




