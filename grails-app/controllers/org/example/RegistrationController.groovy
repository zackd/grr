package org.example

import grails.plugins.springsecurity.Secured

@Secured(['ROLE_ADMIN'])
class RegistrationController {
    
	def scaffold = true
	
}
