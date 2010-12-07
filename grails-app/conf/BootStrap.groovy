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
				def jane = new Runner(
							firstName:"Jane",
							lastName:"Doe", 
							dateOfBirth:(new Date() - 365*30), 
							gender:"F", 
							address:"123 Main St", 
							city:"Goose", 
							state:"NC", 
							zipcode:"12345", 
							email:"jane@whereever.com"
							)
				jane.save()
				if (jane.hasErrors()) {
					println jane.errors
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
					runner:jane, 
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