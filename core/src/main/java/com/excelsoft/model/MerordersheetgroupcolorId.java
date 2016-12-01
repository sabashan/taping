package com.excelsoft.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.search.annotations.Field;

@Embeddable
@XmlRootElement
public class MerordersheetgroupcolorId extends BaseObject implements
		Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String color;
	private Long groupSettingId;
	private Long ordersheetId;
	private String planingOrdersheetNo;
	private String orderType;

	public MerordersheetgroupcolorId() {
		super();
	}

	public MerordersheetgroupcolorId(String color, Long groupSettingId,
			Long ordersheetId, String planingOrdersheetNo, String orderType) {
		super();
		this.color = color;
		this.groupSettingId = groupSettingId;
		this.ordersheetId = ordersheetId;
		this.planingOrdersheetNo = planingOrdersheetNo;
		this.orderType = orderType;
	}

	@Column(name = "color", nullable = false, length = 10, columnDefinition = "CHAR(10)")
	@Field
	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Column(name = "group_setting_id", nullable = false, columnDefinition = "INT")
	@Field
	public Long getGroupSettingId() {
		return this.groupSettingId;
	}

	public void setGroupSettingId(Long groupSettingId) {
		this.groupSettingId = groupSettingId;
	}

	@Column(name = "ordersheet_id", nullable = false, columnDefinition = "INT")
	@Field
	public Long getOrdersheetId() {
		return this.ordersheetId;
	}

	public void setOrdersheetId(Long ordersheetId) {
		this.ordersheetId = ordersheetId;
	}

	@Column(name = "planing_ordersheet_no", nullable = false, length = 15, columnDefinition = "CHAR(15)")
	@Field
	public String getPlaningOrdersheetNo() {
		return this.planingOrdersheetNo;
	}

	public void setPlaningOrdersheetNo(String planingOrdersheetNo) {
		this.planingOrdersheetNo = planingOrdersheetNo;
	}

	@Column(name = "order_type", nullable = false, length = 45, columnDefinition = "CHAR(45)")
	@Field
	public String getOrderType() {
		return this.orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MerordersheetgroupcolorId other = (MerordersheetgroupcolorId) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "MerordersheetgroupcolorId [color=" + color + "]";
	}

}
