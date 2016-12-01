package com.excelsoft.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.search.annotations.Field;

@SuppressWarnings("serial")
@Embeddable
@XmlRootElement
public class MststyledemId extends BaseObject implements Serializable {
	private String demType;
	private String demValue;
	private String styleId;
	private String locationCode;
	private String compCode;
	private String custCode;
	private String depCode;

	public MststyledemId(String demType, String styleId, String locationCode,
			String compCode, String custCode, String depCode,String demValue) {
		super();
		this.demType = demType;
		this.styleId = styleId;
		this.locationCode = locationCode;
		this.compCode = compCode;
		this.custCode = custCode;
		this.depCode = depCode;
		this.demValue=demValue;
	}

	public MststyledemId() {
		super();
	}

	@Column(name = "dem_type", nullable = false, length=6 ,columnDefinition="CHAR(10)")
	@Field
	public String getDemType() {
		return this.demType;
	}
	@Column(name = "dem_value", nullable = false, length=6 ,columnDefinition="CHAR(10)")
	@Field
	public String getDemValue() {
		return demValue;
	}

	public void setDemValue(String demValue) {
		this.demValue = demValue;
	}

	public void setDemType(String demType) {
		this.demType = demType;
	}

	@Column(name = "style_id", nullable = false, length = 10 ,columnDefinition="CHAR(10)")
	@Field
	public String getStyleId() {
		return this.styleId;
	}

	public void setStyleId(String styleId) {
		this.styleId = styleId;
	}

	@Column(name = "location_code", nullable = false, length=6 ,columnDefinition="CHAR(6)")
	@Field
	public String getLocationCode() {
		return this.locationCode;
	}

	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}

	@Column(name = "comp_code", nullable = false, length=6 ,columnDefinition="CHAR(6)")
	@Field
	public String getCompCode() {
		return this.compCode;
	}

	public void setCompCode(String compCode) {
		this.compCode = compCode;
	}

	@Column(name = "cust_code", nullable = false, length = 10 ,columnDefinition="CHAR(10)")
	@Field
	public String getCustCode() {
		return this.custCode;
	}

	public void setCustCode(String custCode) {
		this.custCode = custCode;
	}

	@Column(name = "dep_code", nullable = false, length=6 ,columnDefinition="CHAR(10)")
	@Field
	public String getDepCode() {
		return this.depCode;
	}

	public void setDepCode(String depCode) {
		this.depCode = depCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MststyledemId other = (MststyledemId) obj;
		if (compCode == null) {
			if (other.compCode != null)
				return false;
		} else if (!compCode.equals(other.compCode))
			return false;
		if (custCode == null) {
			if (other.custCode != null)
				return false;
		} else if (!custCode.equals(other.custCode))
			return false;
		if (demType == null) {
			if (other.demType != null)
				return false;
		} else if (!demType.equals(other.demType))
			return false;
		if (demValue == null) {
			if (other.demValue != null)
				return false;
		} else if (!demValue.equals(other.demValue))
			return false;
		if (depCode == null) {
			if (other.depCode != null)
				return false;
		} else if (!depCode.equals(other.depCode))
			return false;
		if (locationCode == null) {
			if (other.locationCode != null)
				return false;
		} else if (!locationCode.equals(other.locationCode))
			return false;
		if (styleId == null) {
			if (other.styleId != null)
				return false;
		} else if (!styleId.equals(other.styleId))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((compCode == null) ? 0 : compCode.hashCode());
		result = prime * result
				+ ((custCode == null) ? 0 : custCode.hashCode());
		result = prime * result + ((demType == null) ? 0 : demType.hashCode());
		result = prime * result
				+ ((demValue == null) ? 0 : demValue.hashCode());
		result = prime * result + ((depCode == null) ? 0 : depCode.hashCode());
		result = prime * result
				+ ((locationCode == null) ? 0 : locationCode.hashCode());
		result = prime * result + ((styleId == null) ? 0 : styleId.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "MststyledemId [demType=" + demType + ", demValue=" + demValue
				+ ", styleId=" + styleId + ", locationCode=" + locationCode
				+ ", compCode=" + compCode + ", custCode=" + custCode
				+ ", depCode=" + depCode + "]";
	}

}
