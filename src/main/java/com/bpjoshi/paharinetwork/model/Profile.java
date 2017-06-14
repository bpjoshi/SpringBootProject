/**
 * 
 */
package com.bpjoshi.paharinetwork.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
//Dependency on Hibernate
import org.hibernate.annotations.GenericGenerator;

/**
 * @author Bhagwati Prasad(bpjoshi)
 *
 */
@Entity
@Table(name="user_profile")
public class Profile {
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid",strategy = "uuid")
	@Column(name="profile_id")
	private String profileId;
	@Column(name="profile_about_text", length=3000)
	private String profileAboutText;
	@OneToOne(targetEntity=EndUser.class)
	@JoinColumn(name="user_id", nullable=false)
	private EndUser endUser;
	public String getProfileId() {
		return profileId;
	}
	public void setProfileId(String profileId) {
		this.profileId = profileId;
	}
	public String getProfileAboutText() {
		return profileAboutText;
	}
	public void setProfileAboutText(String profileAboutText) {
		this.profileAboutText = profileAboutText;
	}
	public EndUser getEndUser() {
		return endUser;
	}
	public void setEndUser(EndUser endUser) {
		this.endUser = endUser;
	}
	
	
}
