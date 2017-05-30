<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<div class="row">
	<div class="col-md-8 col-md-offset-2">
	<!-- Loop to print out statuses -->
<c:forEach var="statusUpdate" items="${page.content}">
	<div class="panel panel-default">
			<div class="panel-heading">
				<div class="panel-title">Last updated on <fmt:formatDate pattern="EEEE d MMMM y 'at' H:mm:s" value="${statusUpdate.statusDate}" /></div>
			</div>
			<div class="panel-body">
				<c:out value="${statusUpdate.statusText}" />
			</div>
		</div>
</c:forEach>
</div>
</div>