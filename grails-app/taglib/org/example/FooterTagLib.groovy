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
	
	// addSlashes! and newlines : "\n"
	def line = "h3. Coding This\n <code>is some code, \"isn't it\"</code>.\n Watch those quote marks! Now for some preformatted text:"
	
	// * can't handle multi-line groovy strings
	def mutli = """\
		h3. Coding This <code>is some code, "isn't it"</code>. Watch those quote marks! Now for some preformatted text:
	"""
	
	def textileBlock = {
		out << line.encodeAsTextile2Html()
	}
	
}
