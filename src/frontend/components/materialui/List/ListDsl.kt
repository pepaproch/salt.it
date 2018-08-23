package frontend.components.materialui.list

import react.*
import styled.StyledBuilder

import styled.StyledElementBuilder

import styled.StyledProps

 fun  RBuilder.styledList(type: Any , block: StyledBuilder<ListProps>.() -> Unit) =
        child(block.apply(block).create())


fun  RBuilder.list(handler: RHandler<ListProps>)  =  styledList(handler)
