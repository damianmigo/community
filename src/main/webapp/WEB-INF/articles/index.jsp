<jsp:include page="/WEB-INF/common/header.jsp">
	<jsp:param name="pageTitle" value="Homepage" />
</jsp:include>

<div class="container">
	<div class="page-header">
		<h1>Articles</h1>
	</div>
	<c:forEach items="${articles}" var="article">
		<h3>
			<a href="<c:url value="/articles/${article.slug}" />">
				<c:out value="${article.title}" />
			</a>
		</h3>
		<h4>
			By <c:out value="${article.authorId}" />
			|
			<fmt:formatDate pattern="MMMMM d, y" value="${article.creationDate}" />
		</h4>
		
	</c:forEach>
</div>

<jsp:include page="/WEB-INF/common/footer.jsp"></jsp:include>