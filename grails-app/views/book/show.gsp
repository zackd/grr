
<%@ page import="org.example.Book" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'book.label', default: 'Book')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
		
		<sec:ifAnyGranted roles="ROLE_ADMIN">
			<div class="nav">
				<span class="menuButton"><a class="home" href="${createLink(uri: '/')}">Home</a></span>
				<span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
			</div>
		</sec:ifAnyGranted>
		
        <div class="body">
            <h1><g:message code="default.show.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="dialog">
                <table>
                    <tbody>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="book.id.label" default="Id" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: bookInstance, field: "id")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="book.title.label" default="Title" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: bookInstance, field: "title")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="book.author.label" default="Author" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: bookInstance, field: "author")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="book.review.label" default="Review" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: bookInstance, field: "review")}</td>
                            
                        </tr>
                    
                    </tbody>
                </table>

				${fieldValue(bean: bookInstance, field: "review").encodeAsTextile2Html()}


            </div>
            <div class="buttons">
                <g:form>
                    <g:hiddenField name="id" value="${bookInstance?.id}" />
                    <span class="button"><g:actionSubmit class="edit" action="edit" value="${message(code: 'default.button.edit.label', default: 'Edit')}" /></span>
                    <span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" /></span>
                </g:form>
            </div>
        </div>
    </body>
</html>
