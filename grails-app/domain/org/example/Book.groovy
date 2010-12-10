package org.example

class Book {
	String title
	String author
	String review
	
    static constraints = {
		title(blank: false)
		author(blank: false)
    }
	static mapping = {
		review type:'text'
	}
}
