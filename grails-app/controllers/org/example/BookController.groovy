package org.example

import grails.plugins.springsecurity.Secured

@Secured(['ROLE_USER','ROLE_ADMIN'])
class BookController {
    def scaffold = Book
}
