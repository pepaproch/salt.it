package app


import frontend.components.MuiDrawer

import frontend.components.leftMenu
import frontend.components.materialui.theme.*

import frontend.containers.Header
import kotlinext.js.asJsObject
import kotlinx.css.Color
import kotlinx.css.LinearDimension

import react.*
import react.dom.h1

import react.router.dom.browserRouter
import react.router.dom.route
import react.router.dom.switch


interface AppState : RState {
	var fontSize: Int
	var drawerOpen: Boolean
	var currentPage: String
}

interface AppProp : RProps {
	var initialPage: String
}


class App(props: AppProp) : RComponent<AppProp, AppState>(props) {


	private fun togleDrawer(open: Boolean) {


		setState {
			drawerOpen = open
		}


	}

	private fun setFontSize(size: Int) {

		setState {
			fontSize = size
		}
	}

	override fun AppState.init(props: AppProp) {

		drawerOpen = false
		currentPage = props.initialPage


	}


	override fun RBuilder.render() {

		var muiO = MuiThemeOptions.create {
			typography { fontSize = 12 }
			overrides {
				muiSlider {
					"track" {
						backgroundColor = Color.white

					}
					"thumb" {
						backgroundColor = Color.white
					}
				}
				muiIconButton{
					"root"{
						color = Color.white
					}

				}
			}
		}




		var theme = createMuiTheme(muiO.toJsThemeOptions())
		browserRouter {
			MuiThemeProvider(theme) {

				header(opened = state.drawerOpen,
						handleDrawerOpen = { togleDrawer(true) }, curentPage = state.currentPage)
				leftDrawer(state.drawerOpen, content = { leftMenu({ togleDrawer(false) }) })

				switch {
					route("/p1", render = ::p1)
					route("/p2", render = ::p2)

				}
			}
		}


	}
}

fun RBuilder.p1() = child(
		h1 {
			+"PAGE 0"
		}

)

fun RBuilder.p2() = child(
		h1 {
			+"PAGE 2"
		}

)

fun RBuilder.app() = child(App::class) {
	attrs.initialPage = "Kotlin React App"
}


fun RBuilder.header(opened: Boolean, handleDrawerOpen: () -> Unit, curentPage: String) = child(Header::class) {
	attrs.drawerOpened = opened
	attrs.handleDrawerOpen = handleDrawerOpen
	attrs.curentPage = curentPage

}


fun RBuilder.leftDrawer(open: Boolean, content: () -> ReactElement) = child(MuiDrawer::class) {

	attrs.anchor = "left"
	attrs.variant = "persistent"
	attrs.open = open
	attrs.content = content

}