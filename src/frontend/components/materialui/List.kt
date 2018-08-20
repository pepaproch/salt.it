package frontend.components.materialui


import frontend.containers.RClassWithDefault

import styled.StyledProps
import styled.styled

@JsModule("@material-ui/core/List")
private external val reactMuiList: RClassWithDefault<StyledProps>
var MuiList = styled(reactMuiList.default)


@JsModule("@material-ui/core/ListItem")
private external val reactMuiListItem: RClassWithDefault<MuiListItemProps>
var MuiListItem = styled(reactMuiListItem.default)

interface MuiListItemProps : StyledProps {
    var button :Boolean
    var disabled : Boolean
    var divider : Boolean
}

@JsModule("@material-ui/core/ListItemIcon")
private external val reactMuiListIcon: RClassWithDefault<StyledProps>
var MuiListIcon = styled(reactMuiListIcon.default)



@JsModule("@material-ui/core/ListItemText")
private external val reactMuiListText: RClassWithDefault<MuiListItemTextProps>
var MuiListItemText = styled(reactMuiListText.default)


interface MuiListItemTextProps : StyledProps {
  var  primary : String
}


