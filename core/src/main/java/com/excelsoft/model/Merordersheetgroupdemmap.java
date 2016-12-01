package com.excelsoft.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;

@Entity
@Table(name = "merordersheetgroupdemmap")
@XmlRootElement
public class Merordersheetgroupdemmap extends BaseObject implements
		Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MerordersheetgroupdemmapId id;
	private Merordersheetgroupsetting merordersheetgroupsetting;
	private Boolean status;
	private Boolean assigned;

	public Merordersheetgroupdemmap() {
		super();
	}

	public Merordersheetgroupdemmap(MerordersheetgroupdemmapId id,
			Merordersheetgroupsetting merordersheetgroupsetting,
			Boolean status, Boolean assigned) {
		super();
		this.id = id;
		this.merordersheetgroupsetting = merordersheetgroupsetting;
		this.status = status;
		this.assigned = assigned;
	}

	public Merordersheetgroupdemmap(MerordersheetgroupdemmapId id) {
		super();
		this.id = id;
	}

	@EmbeddedId
	@DocumentId
	public MerordersheetgroupdemmapId getId() {
		return this.id;
	}

	public void setId(MerordersheetgroupdemmapId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "group_setting_id", referencedColumnName = "group_setting_id", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "ordersheet_id", referencedColumnName = "ordersheet_id", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "planing_ordersheet_no", referencedColumnName = "planing_ordersheet_no", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "order_type", referencedColumnName = "order_type", nullable = false, insertable = false, updatable = false) })
	public Merordersheetgroupsetting getMerordersheetgroupsetting() {
		return this.merordersheetgroupsetting;
	}

	public void setMerordersheetgroupsetting(
			Merordersheetgroupsetting merordersheetgroupsetting) {
		this.merordersheetgroupsetting = merordersheetgroupsetting;
	}

	@Column(name = "status")
	@Field
	public Boolean getStatus() {
		return this.status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	@Column(name = "assigned")
	@Field
	public Boolean getAssigned() {
		return this.assigned;
	}

	public void setAssigned(Boolean assigned) {
		this.assigned = assigned;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Merordersheetgroupdemmap other = (Merordersheetgroupdemmap) obj;
		if (assigned == null) {
			if (other.assigned != null)
				return false;
		} else if (!assigned.equals(other.assigned))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((assigned == null) ? 0 : assigned.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "Merordersheetgroupdemmap [id=" + id + ", status=" + status
				+ ", assigned=" + assigned + "]";
	}

}
