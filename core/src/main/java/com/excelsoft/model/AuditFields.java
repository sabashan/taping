package com.excelsoft.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public class AuditFields  extends BaseObject{
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 3156007518969684264L;
	protected Date  createdOn;
	protected String createdBy;
	protected String createdAt;
	protected Date  modifiedOn;
	protected String modifiedBy;
	protected String modifiedAt;
	

	/**
	 * @return the Calendar_modified
	 */
	AuditFields(){
		Date dNow=new Date();
	    SimpleDateFormat ft =new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss");
		try {
			dNow=ft.parse(ft.format(dNow));
		} catch (ParseException e) {
			dNow=new Date();
		}
	    //modifiedOn= dNow;
	}
	
	@Column(name = "created_on")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreatedOn() {
		return createdOn;
	}


	@Column(name = "created_by", length = 10 ,columnDefinition="CHAR(50)")
	public String getCreatedBy() {
		return createdBy;
	}

	@Column(name = "created_at" , length = 50 , columnDefinition="CHAR(50)")
	public String getCreatedAt() {
		return createdAt;
	}

	@Column(name = "modified_on", nullable= true)
	@Temporal(TemporalType.TIMESTAMP)
	public Date getModifiedOn() {
		return modifiedOn;
	}


	@Column(name = "modified_by", columnDefinition="CHAR(50)", nullable= true)
	public String getModifiedBy() {
		return modifiedBy;
	}


	@Column(name = "modified_at", columnDefinition="CHAR(50)", nullable= true)
	public String getModifiedAt() {
		return modifiedAt;
	}


	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}


	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}


	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}


	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}


	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}


	public void setModifiedAt(String modifiedAt) {
		this.modifiedAt = modifiedAt;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((createdAt == null) ? 0 : createdAt.hashCode());
		result = prime * result
				+ ((createdBy == null) ? 0 : createdBy.hashCode());
		result = prime * result
				+ ((createdOn == null) ? 0 : createdOn.hashCode());
		result = prime * result
				+ ((modifiedAt == null) ? 0 : modifiedAt.hashCode());
		result = prime * result
				+ ((modifiedBy == null) ? 0 : modifiedBy.hashCode());
		result = prime * result
				+ ((modifiedOn == null) ? 0 : modifiedOn.hashCode());
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
		AuditFields other = (AuditFields) obj;
		if (createdAt == null) {
			if (other.createdAt != null)
				return false;
		} else if (!createdAt.equals(other.createdAt))
			return false;
		if (createdBy == null) {
			if (other.createdBy != null)
				return false;
		} else if (!createdBy.equals(other.createdBy))
			return false;
		if (createdOn == null) {
			if (other.createdOn != null)
				return false;
		} else if (!createdOn.equals(other.createdOn))
			return false;
		if (modifiedAt == null) {
			if (other.modifiedAt != null)
				return false;
		} else if (!modifiedAt.equals(other.modifiedAt))
			return false;
		if (modifiedBy == null) {
			if (other.modifiedBy != null)
				return false;
		} else if (!modifiedBy.equals(other.modifiedBy))
			return false;
		if (modifiedOn == null) {
			if (other.modifiedOn != null)
				return false;
		} else if (!modifiedOn.equals(other.modifiedOn))
			return false;
		return true;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AuditFields [createdOn=").append(createdOn)
				.append(", createdBy=").append(createdBy)
				.append(", createdAt=").append(createdAt)
				.append(", modifiedOn=").append(modifiedOn)
				.append(", modifiedBy=").append(modifiedBy)
				.append(", modifiedAt=").append(modifiedAt).append("]");
		return builder.toString();
	}
	
}
