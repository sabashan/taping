package com.excelsoft.model;

import java.io.Serializable;
import java.math.BigDecimal;

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
@Table(name = "mststylecomponent")
@XmlRootElement
public class Mststylecomponent extends BaseObject implements Serializable {
	private MststylecomponentId id;
	private Mststyleheader mststyleheader;
	private String productType;
	private BigDecimal compRatio;

	public Mststylecomponent(MststylecomponentId id,
			Mststyleheader mststyleheader, String productType,
			BigDecimal compRatio) {
		super();
		this.id = id;
		this.mststyleheader = mststyleheader;
		this.productType = productType;
		this.compRatio = compRatio;
	}

	public Mststylecomponent() {
		super();
	}

	@EmbeddedId
	@DocumentId
	public MststylecomponentId getId() {
		return this.id;
	}

	public void setId(MststylecomponentId id) {
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

	@Column(name = "product_type" ,columnDefinition="CHAR(10)")
	@Field
	public String getProductType() {
		return this.productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	@Column(name = "comp_ratio", precision = 5 )
	@Field
	public BigDecimal getCompRatio() {
		return this.compRatio;
	}

	public void setCompRatio(BigDecimal compRatio) {
		this.compRatio = compRatio;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mststylecomponent other = (Mststylecomponent) obj;
		if (compRatio == null) {
			if (other.compRatio != null)
				return false;
		} else if (!compRatio.equals(other.compRatio))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (mststyleheader == null) {
			if (other.mststyleheader != null)
				return false;
		} else if (!mststyleheader.equals(other.mststyleheader))
			return false;
		if (productType == null) {
			if (other.productType != null)
				return false;
		} else if (!productType.equals(other.productType))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((compRatio == null) ? 0 : compRatio.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((mststyleheader == null) ? 0 : mststyleheader.hashCode());
		result = prime * result
				+ ((productType == null) ? 0 : productType.hashCode());
		return result;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Mststylecomponent [id=").append(id)
				.append(", productType=").append(productType)
				.append(", compRatio=").append(compRatio).append("]");
		return builder.toString();
	}

}
