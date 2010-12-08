package org.example

class Registration {	
	Boolean paid 
	Date dateCreated
	Date lastUpdated
	
	static belongsTo = [race:Race, runner:Runner]
	
	static constraints = {
		race() 
		runner() 
		paid() 
		dateCreated()
	}
	
	String toString(){
		return "${runner.lastName}, ${runner.firstName}"
	}
}
