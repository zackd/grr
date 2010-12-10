import org.example.Book

import org.example.Race
import org.example.Runner
import org.example.Registration
import org.example.Role
import org.example.User
import org.example.UserRole

import grails.util.GrailsUtil

class BootStrap {
	
	def springSecurityService
	
	def init = { servletContext ->
		switch(GrailsUtil.environment){
			case "development":
				// bookstore data	
				if (!Book.count()) { // if empty
					new Book(author: "Stephen King", title: "The Shining").save(failOnError: true)
					new Book(author: "James Patterson", title: "Along Came a Spider").save(failOnError: true)
				}
				
				// racetrack data ----------------
				
				//roles
				def adminRole = new Role(authority: 'ROLE_ADMIN').save(flush: true)
				def userRole = new Role(authority: 'ROLE_USER').save(flush: true)
				
				// admin
				def adminUser = new User(
							username:"grails", 
							password: springSecurityService.encodePassword('nsecure'),
							enabled:true
							)
				adminUser.save(flush: true)
				
				if (adminUser.hasErrors()) {
					println adminUser.errors
				}
				UserRole.create adminUser, adminRole, true
				
				assert User.count() == 1
				assert Role.count() == 2
				assert UserRole.count() == 1
				
				
				// race
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
				
				
				// runners
				def runners = [
					[firstName:"No", lastName:"RM", age: 30, gender:"M", address:"123 Main St", city:"Goose", state:"NC", zipcode:"12345", email:"norm@whereever.com"],
					[firstName:"Ann", lastName:"Dode", age: 30, gender:"F", address:"123 Main St", city:"Goose", state:"NC", zipcode:"12345", email:"anode@whereever.com"],
					[firstName:"Paul", lastName:"Dofe", age: 30, gender:"M", address:"123 Main St", city:"Goose", state:"NC", zipcode:"12345", email:"pd@whereever.com"],
					[firstName:"Stephen", lastName:"Dose", age: 30, gender:"M", address:"123 Main St", city:"Goose", state:"NC", zipcode:"12345", email:"steee@whereever.com"],
					[firstName:"Simon", lastName:"Dfoe", age: 30, gender:"M", address:"123 Main St", city:"Goose", state:"NC", zipcode:"12345", email:"sedan@whereever.com"],
					[firstName:"Walter", lastName:"Dhoe", age: 30, gender:"M", address:"123 Main St", city:"Goose", state:"NC", zipcode:"12345", email:"pk@whereever.com"],
					[firstName:"Rod", lastName:"in", age: 30, gender:"M", address:"123 Main St", city:"Goose", state:"NC", zipcode:"12345", email:"therod@whereever.com"],
					[firstName:"Jo", lastName:"Doge", age: 30, gender:"F", address:"123 Main St", city:"Goose", state:"NC", zipcode:"12345", email:"jo90@whereever.com"],
					[firstName:"Jane", lastName:"Dobqe", age: 30, gender:"F", address:"123 Main St", city:"Goose", state:"NC", zipcode:"12345", email:"jane@whereever.com"],
					[firstName:"Claire", lastName:"Dogee", age: 30, gender:"F", address:"123 Main St", city:"Goose", state:"NC", zipcode:"12345", email:"c6@whereever.com"],
					[firstName:"Emily", lastName:"Dokye", age: 30, gender:"F", address:"123 Main St", city:"Goose", state:"NC", zipcode:"12345", email:"en6n@whereever.com"],
					[firstName:"Jane", lastName:"Doae", age: 30, gender:"F", address:"123 Main St", city:"Goose", state:"NC", zipcode:"12345", email:"jane@whereever.com"],
					[firstName:"Matt", lastName:"Hendriksen", age: 8, gender:"M", address:"1 West St", city:"Goose", state:"NC", zipcode:"35475", email:"matt@whereever.com"],
					[firstName:"John", lastName:"Dlioe", age: 40, gender:"M", address:"123 Main St", city:"Goose", state:"NC", zipcode:"12345", email:"john@whereever.com"]
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
					} else {
						
						// register for the race
						def reg = new Registration(
							paid:false,
							runner: runner, 
							race:event
							)
						reg.save() 
						if (reg.hasErrors()) {
							println reg.errors
						}
						
						// create user account
						String username = runner.firstName + "" + runner.lastName
						def usr = new User(
							username: username.toLowerCase(),
							password: springSecurityService.encodePassword('password'),
							enabled:true
							)
						usr.save()
						if (usr.hasErrors()) {
							println usr.errors
						}
						UserRole.create usr, userRole, true
					}
				}
				break
				
			case "production": break
		}
	}

	def destroy = {
		
	}
} 