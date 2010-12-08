import org.example.Book

import org.example.Race
import org.example.Runner
import org.example.Registration

import grails.util.GrailsUtil

class BootStrap {

	def init = { servletContext ->
		switch(GrailsUtil.environment){
			case "development":
				// bookstore data	
				if (!Book.count()) { // if empty
					new Book(author: "Stephen King", title: "The Shining").save(failOnError: true)
					new Book(author: "James Patterson", title: "Along Came a Spider").save(failOnError: true)
				}
				
				// racetrack data
				def registrant
				def runners = [
					[firstName:"Jane", lastName:"Doe", age: 30, gender:"F", address:"123 Main St", city:"Goose", state:"NC", zipcode:"12345", email:"jane@whereever.com"],
					[firstName:"Matt", lastName:"Hendriksen", age: 8, gender:"M", address:"1 West St", city:"Goose", state:"NC", zipcode:"35475", email:"matt@whereever.com"],
					[firstName:"John", lastName:"Doe", age: 40, gender:"M", address:"123 Main St", city:"Goose", state:"NC", zipcode:"12345", email:"john@whereever.com"]
				]
				runners.each { runner -> 
					runner = new Runner(
								firstName: runner.firstName,
								lastName: runner.lastName, 
								dateOfBirth:(new Date() - 365*runner.age), 
								gender: runner.gender, 
								address: runner.address, 
								city: runner.city, 
								state: runner.state, 
								zipcode: runner.zipcode, 
								email: runner.email
								)
					runner.save()
					if (runner.hasErrors()) {
						println runner.errors
					}
					registrant = runner
				}
				
				def event = new Race(
							name:"belgian marathon",
							startDate:(new Date() + 90), 
							city:"Brugges", 
							state:"NC", 
							distance:23.0,
							cost:20.0, 
							maxRunners:3150
							)
				event.save() 
				if (event.hasErrors()) {
					println event.errors
				}
				
				def reg = new Registration(
					paid:false,
					runner: registrant, 
					race:event
					)
				reg.save() 
				if (reg.hasErrors()) {
					println reg.errors
				}
				
				break
				
			case "production": break
		}
	}

	def destroy = {
		
	}
} 