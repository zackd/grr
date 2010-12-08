package org.example

class Runner {	
	String firstName 
	String lastName 
	Date dateOfBirth 
	String gender 
	String address 
	String city 
	String state 
	String zipcode 
	String email
	
	static hasMany = [registrations:Registration]
	
	static constraints = {
		firstName(blank:false) 
		lastName(blank:false) 
		dateOfBirth() 
		gender(inList:["M", "F"]) 
		address()
		city() 
		state() 
		zipcode() 
		email(email:true)
	}
	
	String toString(){
		return "${lastName}, ${firstName} (${email})"
	}
}
