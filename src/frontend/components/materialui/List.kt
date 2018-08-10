package frontend.components.materialui


import frontend.containers.RClassWithDefault

import styled.StyledProps
import styled.styled

@JsModule("@material-ui/core/List")
private external val reactMuiList: RClassWithDefault<StyledProps>
var MuiList = styled(reactMuiList.default)


@JsModule("@material-ui/core/ListItem")
private external val reactMuiListItem: RClassWithDefault<StyledProps>
var MuiListItem = styled(reactMuiListItem.default)


@JsModule("@material-ui/core/ListItemIcon")
private external val reactMuiListIcon: RClassWithDefault<StyledProps>
var MuiListIcon = styled(reactMuiListIcon.default)


@JsModule("@material-ui/core/ListItemText")
private external val reactMuiListText: RClassWithDefault<StyledProps>
var MuiListItemText = styled(reactMuiListText.default)



