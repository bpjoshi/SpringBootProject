<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- These two values below must be passed to pagination tag in order for it to work -->
<%@ attribute name="page"  required="true" type="org.springframework.data.domain.Page" %>
<%@ attribute name="url"  required="true" %>
<%@ attribute name="size" required="false" %>
<c:set var="size" value="${empty size?2:size}"></c:set>
<c:set var="block" value="${empty param.b?0:param.b}"></c:set>

<p>Block:${block}</p>
<p>Size: ${size}</p>
<c:set var="startPage" value="${block*size+1}" />
<c:set var="endPage" value="${(block+1)*size}" />
<c:set var="endPage" value="${endPage>page.totalPages?page.totalPages:endPage}" />

<p>start page: ${startPage}</p>
<p>start page: ${endPage}</p>

<div class="pagination">
	<c:if test="${block!=0}">
	<a href="${url}?b=${block-1}">&lt;&lt;</a>
	</c:if>
	<c:forEach var="pageNumber" begin="${startPage}" end="${endPage}">
		<c:choose>
			<c:when test="${page.number!=pageNumber-1}">
				<a href="${url}?p=${pageNumber}"><c:out value="${pageNumber}"></c:out></a>
			</c:when>
			<c:otherwise>
				<strong><c:out value="${pageNumber}"></c:out> </strong>
			</c:otherwise>
		</c:choose>

		<c:if test="${pageNumber!=endPage }">
					|
				</c:if>
	</c:forEach>
	<c:if test="${endPage!=page.totalPages}">
	<a href="${url}?b=${block+1}">&gt;&gt;</a>
	</c:if>
</div>