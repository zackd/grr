class UrlMappings {
    static mappings = {
      "/" {
			action = "index"
			controller = "app"
		}
      "/$controller/$action?/$id?"{
	      constraints {
			 // apply constraints here
		  }
	  }
	  "500"(view:'/error')
	}
}
