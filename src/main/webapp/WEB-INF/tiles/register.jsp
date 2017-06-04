<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sForm" uri="http://www.springframework.org/tags/form"%>
<c:url var="loginUrl" value="/login" />
<div class="row">
	<div class="col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
		<%--Error messages zone --%>
		<div class="errorMessages">
			<sForm:errors path="userEmail"></sForm:errors>
		</div>
		<div class="errorMessages">
			<sForm:errors path="userPassword"></sForm:errors>
		</div>
		<%--Error messages zone finished --%>
		<div class="panel panel-default">
			<div class="panel-heading">
				<div class="panel-title">User Registration Form</div>
			</div>
			<div class="panel-body">
				<sForm:form method="post" class="form-login" modelAttribute="endUser">
					<div class="input-group">
					<sForm:input type="text" path="userEmail" placeholder="Email" class="form-control" />
					</div>
					<div class="input-group">
					<sForm:input type="password" path="userPassword" placeholder="Password" class="form-control"  />
					</div>
					<div class="input-group">
					<input type="password" name="repeatPassword" placeholder="Repeat Password" class="form-control"  />
					</div>
					<div class="input-group">
					<button type="submit" class="btn-primary pull-right">Sign Up</button>
					</div>
				</sForm:form>
			</div>
		</div>
	</div>
</div>

