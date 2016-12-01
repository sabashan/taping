package com.excelsoft.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.search.annotations.Field;

@SuppressWarnings("serial")
@Embeddable
@XmlRootElement
public class MststyledemmapId extends BaseObject implements Serializable {
	private String styleId;
	private String locationCode;
	private String compCode;
	private String custCode;
	private String depCode;
	private String demType1;
	private String demType2;
	private String demValue1;
	private String demValue2;
	private String mainColor;

	public MststyledemmapId(String styleId, String locationCode,
			String compCode, String custCode, String depCode, String demType1,
			String demType2,String demValue1,
			String demValue2, String mainColor) {
		super();
		this.styleId = styleId;
		this.locationCode = locationCode;
		this.compCode = compCode;
		this.custCode = custCode;
		this.depCode = depCode;
		this.demType1 = demType1;
		this.demType2 = demType2;
		this.mainColor = mainColor;
		this.demValue1=demValue1;
		this.demValue2=demValue2;
	}

	public MststyledemmapId() {
		super();
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

	@Column(name = "dem_type1", nullable = false, length=6 ,columnDefinition="CHAR(10)")
	@Field
	public String getDemType1() {
		return this.demType1;
	}

	public void setDemType1(String demType1) {
		this.demType1 = demType1;
	}

	@Column(name = "dem_type2", nullable = false, length=6 ,columnDefinition="CHAR(10)")
	@Field
	public String getDemType2() {
		return this.demType2;
	}

	public void setDemType2(String demType2) {
		this.demType2 = demType2;
	}
	@Column(name = "dem_Value1", nullable = false, length=6 ,columnDefinition="CHAR(10)")
	@Field
	public String getDemValue1() {
		return demValue1;
	}
	@Column(name = "dem_Value2", nullable = false, length=6 ,columnDefinition="CHAR(10)")
	@Field
	public String getDemValue2() {
		return demValue2;
	}

	public void setDemValue1(String demValue1) {
		this.demValue1 = demValue1;
	}

	public void setDemValue2(String demValue2) {
		this.demValue2 = demValue2;
	}

	@Column(name = "main_color", nullable = false, length=6 ,columnDefinition="CHAR(10)")
	@Field
	public String getMainColor() {
		return this.mainColor;
	}

	public void setMainColor(String mainColor) {
		this.mainColor = mainColor;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MststyledemmapId other = (MststyledemmapId) obj;
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
		if (demType1 == null) {
			if (other.demType1 != null)
				return false;
		} else if (!demType1.equals(other.demType1))
			return false;
		if (demType2 == null) {
			if (other.demType2 != null)
				return false;
		} else if (!demType2.equals(other.demType2))
			return false;
		if (demValue1 == null) {
			if (other.demValue1 != null)
				return false;
		} else if (!demValue1.equals(other.demValue1))
			return false;
		if (demValue2 == null) {
			if (other.demValue2 != null)
				return false;
		} else if (!demValue2.equals(other.demValue2))
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
		if (mainColor == null) {
			if (other.mainColor != null)
				return false;
		} else if (!mainColor.equals(other.mainColor))
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
		result = prime * result
				+ ((demType1 == null) ? 0 : demType1.hashCode());
		result = prime * result
				+ ((demType2 == null) ? 0 : demType2.hashCode());
		result = prime * result
				+ ((demValue1 == null) ? 0 : demValue1.hashCode());
		result = prime * result
				+ ((demValue2 == null) ? 0 : demValue2.hashCode());
		result = prime * result + ((depCode == null) ? 0 : depCode.hashCode());
		result = prime * result
				+ ((locationCode == null) ? 0 : locationCode.hashCode());
		result = prime * result
				+ ((mainColor == null) ? 0 : mainColor.hashCode());
		result = prime * result + ((styleId == null) ? 0 : styleId.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "MststyledemmapId [styleId=" + styleId + ", locationCode="
				+ locationCode + ", compCode=" + compCode + ", custCode="
				+ custCode + ", depCode=" + depCode + ", demType1=" + demType1
				+ ", demType2=" + demType2 + ", demValue1=" + demValue1
				+ ", demValue2=" + demValue2 + ", mainColor=" + mainColor + "]";
	}

}
