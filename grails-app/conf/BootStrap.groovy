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
				
				def review = """\
					h2{color:green}. This is a title

					h3. This is a subhead

					p{color:red}. This is some text of dubious character. Isn't the use of "quotes" just lazy writing -- and theft of 'intellectual property' besides? I think the time has come to see a block quote.

					bq[fr]. This is a block quote. I'll admit it's not the most exciting block quote ever devised.

					Simple list:

					#{color:blue} one
					# two
					# three

					Multi-level list:

					# one
					## aye
					## bee
					## see
					# two
					## x
					## y
					# three

					Mixed list:

					* Point one
					* Point two
					## Step 1
					## Step 2
					## Step 3
					* Point three
					** Sub point 1
					** Sub point 2
					
					Well, that went well. How about we insert an <a href="/" title="watch out">old-fashioned hypertext link</a>? Will the quote marks in the tags get messed up? No!

					"This is a link (optional title)":http://www.textism.com
					
					table{border:1px solid black}.
					|_. this|_. is|_. a|_. header|
					<{background:gray}. |h2. this is|{background:red;width:200px}. a|^<>{height:200px}. row|
					|this|<>{padding:10px}. is|^. another|(bob#bob). row|

					An image:

					!/common/textist.gif(optional alt text)!

					# Librarians rule
					# Yes they do
					# But you knew that

					Some more text of dubious character. Here is a noisome string of CAPITAL letters. Here is something we want to _emphasize_. 
					That was a linebreak. And something to indicate *strength*. Of course I could use <em>my own HTML tags</em> if I <strong>felt</strong> like it.

					h3. Coding

					This <code>is some code, "isn't it"</code>. Watch those quote marks! Now for some preformatted text:

					<pre>
					<code>
						
						<pre>
						<code>
							* troubles handling code here
						</code>
						</pre>
					</code>
					</pre>

					This isn't code.


					So you see, my friends:

					* The time is now
					* The time is not later
					* The time is not yesterday
					* We must act
				""".replaceAll(/\t/, "")
				/* <code>
				$text = str_replace("<p>%::%</p>","",$text);
				$text = str_replace("%::%</p>","",$text);
				$text = str_replace("%::%","",$text);
				*/
				
				if (!Book.count()) { // if empty
					new Book(author: "Stephen King", title: "The Shining", review: review).save(failOnError: true)
					new Book(author: "James Patterson", title: "Along Came a Spider", review: review).save(failOnError: true)
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