class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        //"/"(view:"/index")
				"/"(controller:"caja/listClientes")
        "500"(view:'/error')
	}
}
