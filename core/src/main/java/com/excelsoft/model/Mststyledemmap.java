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

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.search.annotations.DocumentId;

@SuppressWarnings("serial")
@Entity
@Table(name = "mststyledemmap")
@XmlRootElement
public class Mststyledemmap extends BaseObject implements Serializable {
	private MststyledemmapId id;
	private Mststyleheader mststyleheader;

	public Mststyledemmap(MststyledemmapId id, Mststyleheader mststyleheader) {
		super();
		this.id = id;
		this.mststyleheader = mststyleheader;
	}

	public Mststyledemmap() {
		super();
	}

	@EmbeddedId
	@DocumentId
	public MststyledemmapId getId() {
		return this.id;
	}

	public void setId(MststyledemmapId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "style_id", referencedColumnName = "style_id", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "location_code", referencedColumnName = "location_code", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "dep_code", referencedColumnName = "dep_code", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "comp_code", referencedColumnName = "comp_code", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "cust_code", referencedColumnName = "cust_code", nullable = false, insertable = false, updatable = false) })
	@JsonIgnore
	public Mststyleheader getMststyleheader() {
		return this.mststyleheader;
	}

	public void setMststyleheader(Mststyleheader mststyleheader) {
		this.mststyleheader = mststyleheader;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mststyledemmap other = (Mststyledemmap) obj;
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
		return "Mststyledemmap [id=" + id + "]";
	}

}
