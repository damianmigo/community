<!DOCTYPE html>
<html>
	<head>
		<title>eCommerce DevFiles | ${param.pageTitle}</title>
		<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
			integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
			integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
		<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro" rel="stylesheet" type="text/css">
		<link href="<c:url value='/resources/css/styles.css' />" rel="stylesheet" type="text/css">
		${param.headContent}
	</head>
	<body>
		<nav class="navbar navbar-default navbar-static-top">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="<c:url value='/' />">e-commerce DevFiles</a>
				</div>
				<div id="navbar" class="navbar-collapse collapse">
					<ul class="nav navbar-nav">
						<c:set var="requestUri" value="${requestScope['javax.servlet.forward.request_uri']}" />
						<li class="">
							<a href="<c:url value='/' />">Home</a>
						</li>
						<li class="${fn:contains(requestUri, '/members') ? 'active' : ''}">
							<a href="<c:url value='/members' />">Members</a>
						</li>
						<li class="${fn:contains(requestUri, '/articles') ? 'active' : ''}">
							<a href="<c:url value='/articles' />">Articles</a>
						</li>
						<c:remove var="requestUri" />
					</ul>
					
					<ul class="nav navbar-nav navbar-right">
						<li><a href="<c:url value='/members/signup' />">Sign up</a></li>
						<li><a href="<c:url value='/members/login' />">Log in</a></li>
          			</ul>
					
				</div>
			</div>
		</nav>