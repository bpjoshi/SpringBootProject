<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "sForm" uri = "http://www.springframework.org/tags/form" %>
<div class="row">
	<div class="col-md-8 col-md-offset-2">
		<div class="panel panel-default">
			<div class="panel-heading">
				<div class="panel-title">Update Your Status</div>
			</div>
			<div class="panel-body">
				<sForm:form commandName="statusUpdate">
					<div class="form-group">
						<sForm:textarea path="statusText" name="statusText" rows="7" cols="50"></sForm:textarea>
					</div>
					<input type="submit" name="submit" value="Update Status" />
				</sForm:form>
			</div>
		</div>
		<!-- To Display Latest Status Update -->
		<div class="panel panel-default">
			<div class="panel-heading">
				<div class="panel-title"><c:out value="${latestStatusUpdate.statusDate}" /></div>
			</div>
			<div class="panel-body">
				<c:out value="${latestStatusUpdate.statusText}" />
			</div>
		</div>
	</div>
</div>