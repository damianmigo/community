<c:set var="headContent">
	<script src="signup.js"></script>
</c:set>
<jsp:include page="/WEB-INF/common/header.jsp">
	<jsp:param name="pageTitle" value="Members - Sign up" />
	<jsp:param name="headContent" value="${headContent}" />
</jsp:include>
<c:remove var="headContent" />

<div class="container">
	<div class="page-header">
		<h1>Sign up</h1>
	</div>
	
	<div class="row">
		<div class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
			<spring:form role="form" modelAttribute="">
				<div class="row">
					<div class="col-xs-12 col-sm-6 col-md-6">
						<div class="form-group">
							<spring:input type="text" tabindex="1" placeholder="First name" class="form-control input-lg" path="firstName" />
						</div>
					</div>
					<div class="col-xs-12 col-sm-6 col-md-6">
						<div class="form-group">
							<input type="text" tabindex="2" placeholder="Last name" class="form-control input-lg" name="lastName">
						</div>
					</div>
				</div>
				<div class="form-group">
					<input type="text" tabindex="3" placeholder="Nickname" class="form-control input-lg" name="nickname">
				</div>
				<div class="form-group">
					<input type="email" tabindex="4" placeholder="Email address" class="form-control input-lg" name="email">
				</div>
				<div class="form-group">
					<input type="password" tabindex="5" placeholder="Password" class="form-control input-lg" name="password">
				</div>
				<div class="row">
					<div class="col-xs-12 col-md-12">
						<div class="form-group">
							<input type="submit" tabindex="7" class="btn btn-primary btn-block btn-lg" value="Sign up">
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12 text-center">
						 By signing up, you agree to the Terms of Service
					</div>
				</div>
			</spring:form>
		</div>
	</div>
</div>

<jsp:include page="/WEB-INF/common/footer.jsp"></jsp:include>