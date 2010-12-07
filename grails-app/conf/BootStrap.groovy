import org.example.Book

class BootStrap {

	def init = { servletContext ->
		if (!Book.count()) { // if empty
			new Book(author: "Stephen King", title: "The Shining").save(failOnError: true)
			new Book(author: "James Patterson", title: "Along Came a Spider").save(failOnError: true)
		}
	}

	def destroy = {
		
	}
} 