<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sForm" uri="http://www.springframework.org/tags/form"%>
<div class="row">
	<div class="col-md-8 col-md-offset-2">
		<div class="panel panel-default">
			<div class="panel-heading">
				<div class="panel-title">Edit 'About' Section in Profile</div>
			</div>
				<sForm:form modelAttribute="profile">
					<div class="errorMessages">
						<sForm:errors path="profileAboutText"></sForm:errors>
					</div>
					<div class="form-group">
						<sForm:textarea path="profileAboutText" name="profileAboutText" rows="7"
							cols="50"></sForm:textarea>
					</div>
					<input type="submit" name="submit" value="Save" />
				</sForm:form>
		</div>
	</div>
</div>

<!-- What you get is what you see java script editor -->
<script src='//cdn.tinymce.com/4/tinymce.min.js'></script>
<script>
	tinymce.init({
		selector: 'textarea',
		plugins: "link"
	});
</script>