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
		println "testSimpleConstraints"
		
		mockForConstraintsTests(User)
		
		println "test role constraint"
		def user = new User(
			login:"someone", 
			password:"blah", 
			role:"SuperUser"// bad role: 'admin' or 'user'
			)
			
		assertFalse "Validation should not succeed", user.validate()
		assertTrue "There should be errors", user.hasErrors()
		assertEquals "inList", user.errors["role"]
		
		println "test login blank"
		user = new User(
			login:"", 
			password:"word", 
			role:"user"
		)
			
		assertFalse "Validation should not succeed", user.validate()
		assertTrue "There should be errors", user.hasErrors()
		assertEquals "blank", user.errors["login"]
		
		println "test password blank"
		user = new User(
			login:"someone", 
			password:"", 
			role:"user"
		)
			
		assertFalse "Validation should not succeed", user.validate()
		assertTrue "There should be errors", user.hasErrors()
		assertEquals "blank", user.errors["password"]
		
	// mock domain
		def jdoe = new User(login:"jdoe") 
		def admin = new User(login:"admin")
		
		mockDomain(User, [jdoe, admin])
		
		
		println "test unique constraint"
		def badUser = new User(login:"jdoe")
		badUser.save()
		assertEquals 2, User.count()
		assertEquals "unique", badUser.errors["login"]
		
		println "test add user"
		def goodUser = new User(
			login:"good",
			password:"password",
			role:"user"
			)
		goodUser.save()
		assertEquals 3, User.count()
		assertNotNull User.findByLoginAndPassword("good", "password")
		
	}
	 
}
