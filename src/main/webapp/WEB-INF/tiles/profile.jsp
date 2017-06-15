<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sForm" uri="http://www.springframework.org/tags/form"%>
<c:url var="imgUrl" value="/img" />
<c:url var="editProfile" value="/editprofileabout" />
<c:url var="uploadProfilePic" value="/uploadprofilepic" />
<div class="row">
	<div class="col-md-10 col-md-offset-1">
		<div class="profile-main">
			<div class="profile-image">
				<img alt="" src="${imgUrl}/profilepick.png">
			</div>
			<div class="profile-about-text">
				<c:choose>
					<c:when test="${profile.profileAboutText==null}">
						You haven't added any information to your profile. <br />
						Please click on 'Update About Section' to add information about yourself.
					</c:when>
					<c:otherwise>
						${profile.profileAboutText}
					</c:otherwise>
				</c:choose>
			</div>
		</div>
		<div class="profile-about-edit">
			<a href="${editProfile}">Update About Section</a>
		</div>
		<p>&nbsp;</p>
		<div id="profilePictureUpload">
			<form action="${uploadProfilePic}" method="post" enctype="multipart/form-data">
				Choose A Picture: <input type="file" accept="image/*" name="profilePic" />
				<input type="submit" value="Upoad photo" />
				<!-- Need to Paste CSRF token because it is not a spring form -->
				<input type="hidden"  name="${_csrf.parameterName }" value="${_csrf.token}"/>
			</form>
		</div>
	</div>
</div>

