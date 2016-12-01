package com.excelsoft.model;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.search.annotations.DocumentId;

@Entity
@Table(name = "merordersheetgroupcolor")
@XmlRootElement
public class Merordersheetgroupcolor extends BaseObject implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MerordersheetgroupcolorId id;
	private Merordersheetgroupsetting merordersheetgroupsetting;

	public Merordersheetgroupcolor() {
		super();
	}

	public Merordersheetgroupcolor(MerordersheetgroupcolorId id,
			Merordersheetgroupsetting merordersheetgroupsetting) {
		super();
		this.id = id;
		this.merordersheetgroupsetting = merordersheetgroupsetting;
	}

	public Merordersheetgroupcolor(MerordersheetgroupcolorId id) {
		super();
		this.id = id;
	}

	@EmbeddedId
	@DocumentId
	public MerordersheetgroupcolorId getId() {
		return this.id;
	}

	public void setId(MerordersheetgroupcolorId id) {
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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Merordersheetgroupcolor other = (Merordersheetgroupcolor) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "Merordersheetgroupcolor [id=" + id + "]";
	}

}
