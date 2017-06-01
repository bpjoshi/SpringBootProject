package com.bpjoshi.paharinetwork.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author Bhagwati Prasad(bpjoshi)
 * Represents a Status Update
 */
@Entity
@Table(name="status_update")
public class StatusUpdate {
	@Id
	@Column(name="status_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long statusId;
	//Validation Message will be loaded from ValidationMessages.properties by spring
	@Size(min=10, max=250, message="{addStatus.statusText.sizeMessage}")
	@Column(name="status_text")
	private String statusText;
	@Column(name="status_date")
	@Temporal(TemporalType.TIMESTAMP)
	//below annotation to map string type date passed
	@DateTimeFormat(pattern="yyyy/MM/dd hh:mm:ss")
	private Date statusDate;
	public Long getStatusId() {
		return statusId;
	}
	@PrePersist
	protected void onStatusCreate(){
		if(statusDate==null){
			statusDate= new Date();
		}
	}
	
	public StatusUpdate(){
		
	}
	
	public StatusUpdate(String statusText){
		this.statusText=statusText;
	}
	
	public StatusUpdate(String statusText, Date statusDate) {
		super();
		this.statusText = statusText;
		this.statusDate = statusDate;
	}

	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}
	public String getStatusText() {
		return statusText;
	}
	public void setStatusText(String statusText) {
		this.statusText = statusText;
	}
	public Date getStatusDate() {
		return statusDate;
	}
	public void setStatusDate(Date statusDate) {
		this.statusDate = statusDate;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((statusDate == null) ? 0 : statusDate.hashCode());
		result = prime * result
				+ ((statusId == null) ? 0 : statusId.hashCode());
		result = prime * result
				+ ((statusText == null) ? 0 : statusText.hashCode());
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
		StatusUpdate other = (StatusUpdate) obj;
		if (statusDate == null) {
			if (other.statusDate != null)
				return false;
		} else if (!statusDate.equals(other.statusDate))
			return false;
		if (statusId == null) {
			if (other.statusId != null)
				return false;
		} else if (!statusId.equals(other.statusId))
			return false;
		if (statusText == null) {
			if (other.statusText != null)
				return false;
		} else if (!statusText.equals(other.statusText))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "StatusUpdate [statusId=" + statusId + ", statusText="
				+ statusText + ", statusDate=" + statusDate + "]";
	}
	
	
	
}
