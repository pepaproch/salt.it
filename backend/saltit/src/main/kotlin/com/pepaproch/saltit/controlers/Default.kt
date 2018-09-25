package controllers

@Controller
class DefaultController {

	@GetMapping("/")
	fun blog(model: Model): String {
		model["title"] = "Home Page"
		return "index"
	}

	}