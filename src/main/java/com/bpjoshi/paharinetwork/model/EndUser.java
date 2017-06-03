package com.bpjoshi.paharinetwork.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


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
@Column(name="user_email", unique=true)
private Long userEmail;
@Column(name="user_password")
private Long userPassword;

}
