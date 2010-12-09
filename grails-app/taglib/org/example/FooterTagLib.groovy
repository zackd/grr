package org.example

class FooterTagLib {
	def thisYear = { 
		out << new Date().format("yyyy")
	}
	def copyright = {attrs, body-> 
		out << "&copy; " + attrs.startYear + " - "
		out << thisYear() + " " + body()
	}
	
	def textile = {attrs, body->
		out << attrs.input.encodeAsTextile2Html() + " " + body()
	}
}
