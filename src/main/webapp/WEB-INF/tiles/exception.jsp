<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="row">
	<div class="col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2 text-center">
		<div class="message">
			<c:out value="${message}" /> <br/>while trying to access 
			<c:out value="${url}" /> <br/>
			
		</div>
	</div>
</div>