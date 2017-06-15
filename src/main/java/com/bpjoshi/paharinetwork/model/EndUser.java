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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.bpjoshi.paharinetwork.validations.PasswordMatcher;


/**
 * @author Bhagwati Prasad(bpjoshi)
 *
 */
@Entity
@Table(name="end_user")
@PasswordMatcher(message="{register.repeatpassword.mismatch}")
public class EndUser {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
@Column(name="user_id")
private Long userId;
@Email(message="{register.email.invalid}")
@NotBlank(message="{register.email.invalid}")
@Column(name="user_email", unique=true)
private String userEmail;
@Transient
@Size(min=5, max=15, message="{register.password.invalid}")
private String plainPassword;
@Transient
private String repeatPassword;
@Column(name="user_password", length=60)
private String userPassword;
@Column(name="user_role", length=20)
private String userRole;
@Column(name="user_enabled")
private boolean userEnabled;

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
	this.setUserPassword(new BCryptPasswordEncoder().encode(plainPassword));
}
public String getRepeatPassword() {
	return repeatPassword;
}
public void setRepeatPassword(String repeatPassword) {
	this.repeatPassword = repeatPassword;
}
public Boolean getUserEnabled() {
	return userEnabled;
}
public void setUserEnabled(Boolean userEnabled) {
	this.userEnabled = userEnabled;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((userEmail == null) ? 0 : userEmail.hashCode());
	result = prime * result + (userEnabled ? 1231 : 1237);
	result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
	if (userEnabled != other.userEnabled)
		return false;
	if (userId == null) {
		if (other.userId != null)
			return false;
	} else if (!userId.equals(other.userId))
		return false;
	if (userRole == null) {
		if (other.userRole != null)
			return false;
	} else if (!userRole.equals(other.userRole))
		return false;
	return true;
}

}
