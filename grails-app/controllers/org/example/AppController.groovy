package org.example

import grails.plugins.springsecurity.Secured

@Secured(['ROLE_USER','ROLE_ADMIN'])
class AppController {
    def index = {
		render(view:"index", params: params)
	}
}
