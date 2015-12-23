<jsp:include page="/WEB-INF/common/header.jsp">
	<jsp:param name="pageTitle" value="Homepage" />
</jsp:include>

<div class="container">
	<div class="page-header">
		<h1>Members</h1>
	</div>
	<table class="table table-hover">
		<thead>
			<tr>
				<td>#</td>
				<td>Full name / nickname</td>
				<td>Registration date</td>
				<td>Professional headline</td>
				<td>Country</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${profiles}" var="profile" varStatus="status">
				<tr>
					<td>${status.count}</td>
					<td>
						<c:choose>
							<c:when test="${profile.showRealName}">
								<c:out value="${profile.firstName}" />&nbsp;<c:out value="${profile.lastName}" />
							</c:when>
							<c:otherwise>
								<c:out value="${profile.nickname}" />
							</c:otherwise>
						</c:choose>
					</td>
					<td>
						<fmt:formatDate value="${profile.registrationDate}" />
					</td>
					<td>
						<c:out value="${profile.professionalHeadline}" />
					</td>
					<td>
						<c:out value="${profile.country}" />
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

<jsp:include page="/WEB-INF/common/footer.jsp"></jsp:include>