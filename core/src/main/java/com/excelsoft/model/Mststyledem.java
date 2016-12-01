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

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;

@SuppressWarnings("serial")
@Entity
@Table(name = "mststyledem")
@XmlRootElement
public class Mststyledem extends BaseObject implements Serializable {
	private MststyledemId id;
	private Mststyleheader mststyleheader;
	private String dimention;

	public Mststyledem(MststyledemId id, Mststyleheader mststyleheader,
			String dimention) {
		super();
		this.id = id;
		this.mststyleheader = mststyleheader;
		this.dimention = dimention;
	}

	public Mststyledem() {
		super();
	}

	@EmbeddedId
	@DocumentId
	public MststyledemId getId() {
		return this.id;
	}

	public void setId(MststyledemId id) {
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

	@Column(name = "dimention", length = 45 ,columnDefinition="CHAR(45)")
	@Field
	public String getDimention() {
		return this.dimention;
	}

	public void setDimention(String dimention) {
		this.dimention = dimention;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mststyledem other = (Mststyledem) obj;
		if (dimention == null) {
			if (other.dimention != null)
				return false;
		} else if (!dimention.equals(other.dimention))
			return false;
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
		result = prime * result
				+ ((dimention == null) ? 0 : dimention.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "Mststyledem [id=" + id + ", dimention=" + dimention + "]";
	}

}
