package com.excelsoft.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

@Entity
@Table(name = "mststylewippoints", uniqueConstraints = @UniqueConstraint(columnNames = "sequnce_no"))
@Indexed
@XmlRootElement
public class Mststylewippoints extends BaseObject implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2048146755497795545L;
	private String wippointCode;
	private String name;
	private Integer sequnceNo;
	private Boolean mandetory;
	private String wippoint;
	private String description;
	private Boolean activeWip;

	public Mststylewippoints() {
	}

	public Mststylewippoints(String wippointCode, String name,
			Integer sequnceNo, Boolean mandetory, String wippoint,
			String description, Boolean activeWip) {
		super();
		this.wippointCode = wippointCode;
		this.name = name;
		this.sequnceNo = sequnceNo;
		this.mandetory = mandetory;
		this.wippoint = wippoint;
		this.description = description;
		this.activeWip = activeWip;
	}

	public Mststylewippoints(String wippointCode) {
		super();
		this.wippointCode = wippointCode;
	}

	@Id
	@DocumentId
	@Column(name = "wippoint_code", length = 5, columnDefinition = "CHAR(5)")
	public String getWippointCode() {
		return this.wippointCode;
	}

	public void setWippointCode(String wippointCode) {
		this.wippointCode = wippointCode;
	}

	@Column(name = "name", length = 45, columnDefinition = "CHAR(45)")
	@Field
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "sequnce_no", unique = true, precision = 5, scale = 0)
	@Field
	public Integer getSequnceNo() {
		return this.sequnceNo;
	}

	public void setSequnceNo(Integer sequnceNo) {
		this.sequnceNo = sequnceNo;
	}

	@Column(name = "mandetory")
	@Field
	public Boolean getMandetory() {
		return this.mandetory;
	}

	public void setMandetory(Boolean mandetory) {
		this.mandetory = mandetory;
	}

	@Column(name = "wippoint", length = 10)
	@Field
	public String getWippoint() {
		return this.wippoint;
	}

	public void setWippoint(String wippoint) {
		this.wippoint = wippoint;
	}

	@Column(name = "description", length = 50)
	@Field
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "active_wip", length = 10)
	@Field
	public Boolean getActiveWip() {
		return activeWip;
	}

	public void setActiveWip(Boolean activeWip) {
		this.activeWip = activeWip;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((activeWip == null) ? 0 : activeWip.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result
				+ ((mandetory == null) ? 0 : mandetory.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((sequnceNo == null) ? 0 : sequnceNo.hashCode());
		result = prime * result
				+ ((wippoint == null) ? 0 : wippoint.hashCode());
		result = prime * result
				+ ((wippointCode == null) ? 0 : wippointCode.hashCode());
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
		Mststylewippoints other = (Mststylewippoints) obj;
		if (activeWip == null) {
			if (other.activeWip != null)
				return false;
		} else if (!activeWip.equals(other.activeWip))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (mandetory == null) {
			if (other.mandetory != null)
				return false;
		} else if (!mandetory.equals(other.mandetory))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (sequnceNo == null) {
			if (other.sequnceNo != null)
				return false;
		} else if (!sequnceNo.equals(other.sequnceNo))
			return false;
		if (wippoint == null) {
			if (other.wippoint != null)
				return false;
		} else if (!wippoint.equals(other.wippoint))
			return false;
		if (wippointCode == null) {
			if (other.wippointCode != null)
				return false;
		} else if (!wippointCode.equals(other.wippointCode))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Mststylewippoints [wippointCode=" + wippointCode + ", name="
				+ name + ", sequnceNo=" + sequnceNo + ", mandetory="
				+ mandetory + ", wippoint=" + wippoint + ", description="
				+ description + ", activeWip=" + activeWip + "]";
	}

}
