class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        //"/"(view:"/index")
				"/"(controller:"caja/listClient")
				"/client/index"(controller:"caja/listClient")
				//"/caja/index"(controller:"caja/listClient")
				"/caja/"(controller:"caja/listClient")
        "500"(view:'/error')
	}
}
