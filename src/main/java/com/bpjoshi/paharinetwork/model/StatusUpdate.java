package com.bpjoshi.paharinetwork.model;

import java.util.Date;

/**
 * @author Bhagwati Prasad(bpjoshi)
 * Represents a Status Update
 */
public class StatusUpdate {
	private Long statusId;
	private String statusText;
	private Date statusDate;
	public Long getStatusId() {
		return statusId;
	}
	
	public StatusUpdate(String statusText){
		this.statusText=statusText;
	}
	
	/**
	 * @param statusText
	 * @param statusDate
	 */
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
	
	
}
