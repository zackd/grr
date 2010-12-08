package org.example

class FooterTagLib {
	def thisYear = { 
		out << new Date().format("yyyy")
	}
}
