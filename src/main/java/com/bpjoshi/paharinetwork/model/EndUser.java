package com.bpjoshi.paharinetwork.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;


/**
 * @author Bhagwati Prasad(bpjoshi)
 *
 */
@Entity
@Table(name="end_user")
public class EndUser {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
@Column(name="user_id")
private Long userId;
@Email(message="{register.email.invalid}")
@NotBlank(message="{register.email.invalid}")
@Column(name="user_email", unique=true)
private String userEmail;
@Size(min=5, max=15, message="{register.password.invalid}")
@Transient
private String plainPassword;
@Column(name="user_password", length=60)
private String userPassword;
@Column(name="user_role", length=20)
private String userRole;
@Autowired
@Transient
private PasswordEncoder passwordEncoder;

public String getUserRole() {
	return userRole;
}
public void setUserRole(String userRole) {
	this.userRole = userRole;
}
public Long getUserId() {
	return userId;
}
public void setUserId(Long userId) {
	this.userId = userId;
}
public String getUserEmail() {
	return userEmail;
}
public void setUserEmail(String userEmail) {
	this.userEmail = userEmail;
}
public String getUserPassword() {
	return userPassword;
}
public void setUserPassword(String userPassword) {
	this.userPassword = userPassword;
}



public String getPlainPassword() {
	return plainPassword;
}
public void setPlainPassword(String plainPassword) {
	this.plainPassword = plainPassword;
	this.setUserPassword(passwordEncoder.encode(plainPassword));
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((userEmail == null) ? 0 : userEmail.hashCode());
	result = prime * result + ((userId == null) ? 0 : userId.hashCode());
	result = prime * result
			+ ((userPassword == null) ? 0 : userPassword.hashCode());
	result = prime * result + ((userRole == null) ? 0 : userRole.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	EndUser other = (EndUser) obj;
	if (userEmail == null) {
		if (other.userEmail != null)
			return false;
	} else if (!userEmail.equals(other.userEmail))
		return false;
	if (userId == null) {
		if (other.userId != null)
			return false;
	} else if (!userId.equals(other.userId))
		return false;
	if (userPassword == null) {
		if (other.userPassword != null)
			return false;
	} else if (!userPassword.equals(other.userPassword))
		return false;
	if (userRole == null) {
		if (other.userRole != null)
			return false;
	} else if (!userRole.equals(other.userRole))
		return false;
	return true;
}
@Override
public String toString() {
	return "EndUser [userId=" + userId + ", userEmail=" + userEmail
			+ ", userPassword=" + userPassword + ", userRole=" + userRole + "]";
}



}
