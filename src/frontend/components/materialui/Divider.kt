package frontend.components.materialui

import frontend.containers.RClassWithDefault
import styled.StyledProps
import styled.styled

@JsModule("@material-ui/core/Divider")
private external val reactMuiDivider: RClassWithDefault<StyledProps>
var MuiDivider = styled(reactMuiDivider.default)
