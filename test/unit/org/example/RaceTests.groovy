package org.example

import grails.test.*

class RaceTests extends GrailsUnitTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

	void testInMiles() { 
		println "running testInMiles"
		def race = new Race(distance:5.0)
		assertEquals 3.107, race.inMiles() // assert 5 km equals 3.107 miles
	}
}
