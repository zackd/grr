package org.example

class FooterTagLib {
	def thisYear = { 
		out << new Date().format("yyyy")
	}
	def copyright = {attrs, body-> 
		out << "&copy; " + attrs.startYear + " - "
		out << thisYear() + " " + body()
	}
	
	def tex = {
		String text = "h2. textile markup"
		out << text.encodeAsTextile2Html()
	}
}
