package org.example

import grails.plugins.springsecurity.Secured

@Secured(['ROLE_USER','ROLE_ADMIN'])
class RaceController {
	
	def scaffold = true
	
	/*
    def index = {
		render "Hello worlds?!"
	}
	
	def foo = {
		render "another red herring"
	}*/
}
