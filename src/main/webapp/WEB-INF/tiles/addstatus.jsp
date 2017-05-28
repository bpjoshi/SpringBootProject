<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<div class="row">
	<div class="col-md-8 col-md-offset-2">
		<div class="panel panel-default">
			<div class="panel-heading">
				<div class="panel-title">Update Your Status</div>
			</div>
			<div class="panel-body">
				<form>
					<div class="form-group">
						<textarea name="text" rows="10" cols="50"></textarea>
					</div>
					<input type="submit" name="submit" value="Update Status" />
				</form>
			</div>
		</div>
	</div>
</div>