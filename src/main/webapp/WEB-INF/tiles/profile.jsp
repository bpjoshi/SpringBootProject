<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sForm" uri="http://www.springframework.org/tags/form"%>
<c:url var="imgUrl" value="/img" />
<c:url var="editProfile" value="/editprofile" />
<div class="row">
	<div class="col-md-10 col-md-offset-1">
		<div class="profile-main">
			<div class="profile-image">
				<img alt="" src="${imgUrl}/profilepick.png">
			</div>
			<div class="profile-about-text">
				<c:if test="${profile.profileAboutText==null}">
					Here you can mention about yourself. Click on the edit link below to add information
					to your profile.
				</c:if>
			</div>
		</div>
		<div class="profile-about-edit">
			<a href="${editProfile}"></a>
		</div>
	</div>
</div>

