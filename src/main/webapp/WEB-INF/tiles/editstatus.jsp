<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sForm" uri="http://www.springframework.org/tags/form"%>
<div class="row">
	<div class="col-md-8 col-md-offset-2">
		<div class="panel panel-default">
			<div class="panel-heading">
				<div class="panel-title">Update Your Status</div>
			</div>
				<sForm:form modelAttribute="statusUpdate">
					<div class="errorMessages">
						<sForm:errors path="statusText"></sForm:errors>
					</div>
					<div class="form-group">
						<sForm:textarea path="statusText" name="statusText" rows="7"
							cols="50"></sForm:textarea>
					</div>
					<input type="submit" name="submit" value="Update Status" />
				</sForm:form>
		</div>
		
	</div>
</div>

<!-- What you get is what you see java script editor -->
<script src='/css/jquery.tinymce.min.js'></script>
<script>
	tinymce.init({
		selector: "textarea"
	});
</script>