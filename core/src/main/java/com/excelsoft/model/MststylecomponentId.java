package com.excelsoft.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.search.annotations.Field;

@SuppressWarnings("serial")
@Embeddable
@XmlRootElement
public class MststylecomponentId extends BaseObject implements Serializable {
	private String componentId;
	private String styleId;
	private String locationCode;
	private String depCode;
	private String compCode;
	private String custCode;

	public MststylecomponentId(String componentId, String styleId,
			String locationCode, String depCode, String compCode,
			String custCode) {
		super();
		this.componentId = componentId;
		this.styleId = styleId;
		this.locationCode = locationCode;
		this.depCode = depCode;
		this.compCode = compCode;
		this.custCode = custCode;
	}

	public MststylecomponentId() {
		super();
	}

	@Column(name = "component_id", nullable = false, length=6 ,columnDefinition="CHAR(6)")
	@Field
	public String getComponentId() {
		return this.componentId;
	}

	public void setComponentId(String componentId) {
		this.componentId = componentId;
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

	@Column(name = "dep_code", nullable = false, length=6 ,columnDefinition="CHAR(10)")
	@Field
	public String getDepCode() {
		return this.depCode;
	}

	public void setDepCode(String depCode) {
		this.depCode = depCode;
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

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		MststylecomponentId pojo = (MststylecomponentId) o;

		if (componentId != null ? !componentId.equals(pojo.componentId)
				: pojo.componentId != null)
			return false;
		if (styleId != null ? !styleId.equals(pojo.styleId)
				: pojo.styleId != null)
			return false;
		if (locationCode != null ? !locationCode.equals(pojo.locationCode)
				: pojo.locationCode != null)
			return false;
		if (depCode != null ? !depCode.equals(pojo.depCode)
				: pojo.depCode != null)
			return false;
		if (compCode != null ? !compCode.equals(pojo.compCode)
				: pojo.compCode != null)
			return false;
		if (custCode != null ? !custCode.equals(pojo.custCode)
				: pojo.custCode != null)
			return false;

		return true;
	}

	public int hashCode() {
		int result = 0;
		result = 31 * result
				+ (componentId != null ? componentId.hashCode() : 0);
		result = (styleId != null ? styleId.hashCode() : 0);
		result = 31 * result
				+ (locationCode != null ? locationCode.hashCode() : 0);
		result = 31 * result + (depCode != null ? depCode.hashCode() : 0);
		result = 31 * result + (compCode != null ? compCode.hashCode() : 0);
		result = 31 * result + (custCode != null ? custCode.hashCode() : 0);

		return result;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer(getClass().getSimpleName());

		sb.append(" [");
		sb.append("componentId").append("='").append(getComponentId())
				.append("', ");
		sb.append("styleId").append("='").append(getStyleId()).append("', ");
		sb.append("locationCode").append("='").append(getLocationCode())
				.append("', ");
		sb.append("depCode").append("='").append(getDepCode()).append("', ");
		sb.append("compCode").append("='").append(getCompCode()).append("', ");
		sb.append("custCode").append("='").append(getCustCode()).append("'");
		sb.append("]");

		return sb.toString();
	}

}
