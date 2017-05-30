<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<<c:url var="url" value="/viewstatus"></c:url>
<div class="row">
	<div class="col-md-8 col-md-offset-2">
		<!-- Loop to print out statuses -->
		<c:forEach var="statusUpdate" items="${page.content}">
			<div class="panel panel-default">
				<div class="panel-heading">
					<div class="panel-title">
						Last updated on
						<fmt:formatDate pattern="EEEE d MMMM y 'at' H:mm:s"
							value="${statusUpdate.statusDate}" />
					</div>
				</div>
				<div class="panel-body">
					<c:out value="${statusUpdate.statusText}" />
				</div>
			</div>
		</c:forEach>
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
	</div>
</div>