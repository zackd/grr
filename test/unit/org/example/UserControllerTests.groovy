package org.example

import grails.test.*

class UserControllerTests extends ControllerUnitTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testIndex() {
		controller.index()
		assertEquals "list", controller.redirectArgs["action"]
	}
	
	void testShow(){
		// mock domain 
		def jdoe = new User(login:"jdoe")
		def suziq = new User(login:"suziq") 
		mockDomain(User, [jdoe, suziq])
		
		// set params
		controller.params.id = 2 
		
		// call the controller 
		def map = controller.show()
		
		assertEquals "suziq", map.userInstance.login
	}
	
	void testAuthenticate(){
		println "testAuthenticate"
		
		def jdoe = new User(login:"jdoe", password:"password") 
		mockDomain(User, [jdoe])
		
		println "test login success"
		controller.params.login = "jdoe" 
		controller.params.password = "password" 
		controller.authenticate()
		assertNotNull controller.session.user 
		assertEquals "jdoe", controller.session.user.login
		
		println "bad password"
		controller.params.login = "jdoe"
		controller.params.password = "bad"
		controller.authenticate()
		assertTrue controller.flash.message.startsWith("Sorry,")
		
		println "bad user"
		controller.params.login = "bad" 
		controller.params.password = "password"
		controller.authenticate() 
		assertTrue controller.flash.message.startsWith("Sorry,")
		
		// test blanks	
		println "blank password"
		controller.params.login = "jdoe"
		controller.params.password = ""
		controller.authenticate() 
		assertTrue controller.flash.message.startsWith("Sorry,")
		
		println "blank user"
		controller.params.login = ""
		controller.params.password = "password"
		controller.authenticate() 
		assertTrue controller.flash.message.startsWith("Sorry,")
		
		println "both blank"
		controller.params.login = ""
		controller.params.password = ""
		controller.authenticate() 
		assertTrue controller.flash.message.startsWith("Sorry,")
	}
	
}
