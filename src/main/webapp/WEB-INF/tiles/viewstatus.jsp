<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib tagdir="/WEB-INF/tags/" prefix="jwp" %>
<c:url var="url" value="/viewstatus"></c:url>
<div class="row">
	<div class="col-md-8 col-md-offset-2">
		<!-- Loop to print out statuses -->
		<c:forEach var="statusUpdate" items="${page.content}">
			<c:url var="editLink" value="/editstatus?id=${statusUpdate.statusId}"></c:url>
			<c:url var="deleteLink" value="/deletestatus?id=${statusUpdate.statusId}"></c:url>
			<div class="panel panel-default">
				<div class="panel-heading">
					<div class="panel-title">
						Last updated on
						<fmt:formatDate pattern="EEEE d MMMM y 'at' H:mm:s"
							value="${statusUpdate.statusDate}" />
					</div>
				</div>
				<div class="panel-body">
					<div>
					<!-- removed c:out to wysiwyg type presentation -->
					${statusUpdate.statusText}"
					</div>
					<div class="edit-links pull-right">
						<a href="${editLink }">Edit</a>|<a onclick="return confirm('Do you really want to delete this status?')" href="${deleteLink}">Delete</a>
					</div>
				</div>
			</div>
		</c:forEach>
				<!-- Call the custom pagination tag -->
			<jwp:pagination page="${page}" url="${url }" size="${4}" />
	</div>
</div>