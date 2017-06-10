/**
 * 
 */
package com.bpjoshi.paharinetwork.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Bhagwati Prasad(bpjoshi)
 *
 */
@Entity
@Table(name="validation_details")
public class VerificationToken {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="token_id")
	private Long tokenId;
	@Column(name="token_String")
	private String tokenString;
	@JoinColumn(name="user_id", nullable=false)
	@OneToOne(targetEntity=EndUser.class)
	private EndUser endUser;
	@Column(name="expiry_date")
	private Date expiryDate;
	@Column(name="token_type")
	@Enumerated(EnumType.STRING)
	private ValidationTokenType tokenType;
	
	/**
	 * Default Constructor
	 */
	public VerificationToken() {
	}
	
	/**
	 * @param tokenString
	 * @param endUser
	 * @param tokenType
	 */
	public VerificationToken(String tokenString, EndUser endUser,
			ValidationTokenType tokenType) {
		this.tokenString = tokenString;
		this.endUser = endUser;
		this.tokenType = tokenType;
	}
		
	
	public Long getTokenId() {
		return tokenId;
	}
	public void setTokenId(Long tokenId) {
		this.tokenId = tokenId;
	}
	public String getTokenString() {
		return tokenString;
	}
	public void setTokenString(String tokenString) {
		this.tokenString = tokenString;
	}
	public EndUser getEndUser() {
		return endUser;
	}
	public void setEndUser(EndUser endUser) {
		this.endUser = endUser;
	}
	public Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	public ValidationTokenType getTokenType() {
		return tokenType;
	}
	public void setTokenType(ValidationTokenType tokenType) {
		this.tokenType = tokenType;
	}
}
