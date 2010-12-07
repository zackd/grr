import org.example.Book
import org.example.Runner

class BootStrap {

	def init = { servletContext ->
		
		// bookstore		
		if (!Book.count()) { // if empty
			new Book(author: "Stephen King", title: "The Shining").save(failOnError: true)
			new Book(author: "James Patterson", title: "Along Came a Spider").save(failOnError: true)
		}
		
		// racetrack
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
		
	}

	def destroy = {
		
	}
} 