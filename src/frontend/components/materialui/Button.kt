package frontend.components.materialui

import frontend.containers.DrawerButtonProps
import frontend.containers.RClassWithDefault
import react.RBuilder
import react.ReactElement
import styled.StyledHandler
import styled.StyledProps
import styled.styled

@JsModule("@material-ui/core/IconButton")
external val reactIconButton: RClassWithDefault<MuiButtonProps>

val MuIButtonIcon: RBuilder.(StyledHandler<MuiButtonProps>) -> ReactElement = styled(reactIconButton.default)


@JsModule("@material-ui/core/Button")
external val reactButton: RClassWithDefault<MuiButtonProps>


interface MuiButtonProps : StyledProps {
    var  onClick : ()-> Unit
}



interface  MuiIconButtonProps : MuiButtonProps, MuiIconProps {

    var disabled : Boolean
}