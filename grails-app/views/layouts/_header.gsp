<div id="header">
	<p><a class="header-main" href="${resource(dir:'')}">grr</a></p>
	<p class="header-sub">git@github.com:mog-labs/grr.git</p>
	
	<div id="loginHeader">
		<sec:ifLoggedIn>
			<sec:loggedInUserInfo field="username"/>
			[<g:link controller='logout' action='index'>Logout</g:link>]
		</sec:ifLoggedIn>
		
		<sec:ifNotLoggedIn>
			[<g:link controller='login' action='auth'>Login</g:link>]
		</sec:ifNotLoggedIn>
	</div>
</div>