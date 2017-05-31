<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- These two values below must be passed to pagination tag in order for it to work -->
<%@ attribute name="page"  required="true" type="org.springframework.data.domain.Page" %>
<%@ attribute name="url"  required="true" %>
<div class="pagination">
	<c:forEach var="pageNumber" begin="1" end="${page.totalPages}">
		<c:choose>
			<c:when test="${page.number!=pageNumber-1}">
				<a href="${url}?p=${pageNumber}"><c:out value="${pageNumber}"></c:out></a>
			</c:when>
			<c:otherwise>
				<strong><c:out value="${pageNumber}"></c:out> </strong>
			</c:otherwise>
		</c:choose>

		<c:if test="${pageNumber!=page.totalPages }">
					|
				</c:if>
	</c:forEach>
</div>