package org.example

import grails.test.*

class UserTests extends GrailsUnitTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testSimpleConstraints() {
		println "test login constraints"
		
		mockForConstraintsTests(User)
		
		println "test login: bad role"
		def user = new User(
			login:"someone", 
			password:"blah", 
			role:"SuperUser"// bad role: 'admin' or 'user'
			)
			
		assertFalse "Validation should not succeed", user.validate()
		assertTrue "There should be errors", user.hasErrors()
		assertEquals "inList", user.errors["role"]
		
		println "test login: blank login"
		user = new User(
			login:"", 
			password:"word", 
			role:"user"
		)
			
		assertFalse "Validation should not succeed", user.validate()
		assertTrue "There should be errors", user.hasErrors()
		assertEquals "blank", user.errors["login"]
		
		println "test login: blank password"
		user = new User(
			login:"someone", 
			password:"", 
			role:"user"
		)
			
		assertFalse "Validation should not succeed", user.validate()
		assertTrue "There should be errors", user.hasErrors()
		assertEquals "blank", user.errors["password"]
		/*
		println "test login: bad login"
		user = new User(
			login:"bad", 
			password:"password", 
			role:"user"
		)
			
		assertFalse "Validation should not succeed", user.validate()
		assertTrue "There should be errors", user.hasErrors()
		assertEquals "blank", user.errors["login"]
		
		println "test login: bad password"
		user = new User(
			login:"someone", 
			password:"bad", 
			role:"user"
		)
			
		assertFalse "Validation should not succeed", user.validate()
		assertTrue "There should be errors", user.hasErrors()
		assertEquals "blank", user.errors["password"]
		*/
	}
	 
}
