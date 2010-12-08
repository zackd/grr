<!doctype html>	 

<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>	   <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>	   <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>	   <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"> <!--<![endif]-->
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

	<title><g:layoutTitle default="Grails" /></title>
	
	<meta name="description" content="">
	<meta name="author" content="">

	<meta name="viewport" content="width=device-width, initial-scale=1.0">

	<link rel="stylesheet" href="${resource(dir:'css',file:'main.css')}" />
	<link rel="shortcut icon" href="${resource(dir:'images',file:'favicon.ico')}" type="image/x-icon" />
	
	<g:layoutHead />
	<g:javascript library="application" />
</head>
<body>
	<div id="spinner" class="spinner" style="display:none;">
	<img src="${resource(dir:'images',file:'spinner.gif')}" alt="Spinner" />
	</div>
	<div id="grailsLogo" class="logo">
		<a href="http://grails.org"><img src="${resource(dir:'images',file:'grails_logo.png')}" alt="Grails" border="0" /></a>
	</div>
	<g:layoutBody />
</body>
</html>