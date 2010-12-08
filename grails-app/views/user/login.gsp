
<%@ page import="org.example.User" %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<meta name="layout" content="main" />
		<g:set var="entityName" value="${message(code: 'user.label', default: 'User')}" />
		<title>grr login</title>
	</head>
	<body>
		<g:if test="${session?.user?.admin}">
			<div class="nav">
				<span class="menuButton"><a class="home" href="${createLink(uri: '/')}">Home</a></span>
				<span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
			</div>	
		</g:if>
		
		<div class="body">
			<h1>grr login</h1>
			<g:if test="${flash.message}">
				<div class="message">${flash.message}</div>
			</g:if>
			
			<g:form action="authenticate" method="post" >
				<div class="dialog">
					<table>
					<tbody>
					<tr class="prop">
						<td valign="top" class="name">
							<label for="login">Login:</label>
						</td>
						<td valign="top"> 
							<input type="text" id="login" name="login"/>
						</td>
					</tr>
					<tr class="prop"> 
						<td valign="top" class="name">
							<label for="password">Password:</label>
						</td>
						<td valign="top">
							<input type="password" id="password" name="password"/>
						</td>
					</tr>
					</tbody>
					</table>
				</div>
				
				<div class="buttons">
					<span class="button">
						<input type="submit" value="Login" />
					</span>
				</div>
			</g:form>
		</div>
	</body>
</html>
