package com.excelsoft.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.search.annotations.Field;

@Embeddable
@XmlRootElement
public class MerordersheetgroupbomId extends BaseObject implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long ordersheetgroupbomId;
	private Long groupId;
	private Long groupSettingId;
	private Long ordersheetId;
	private String planingOrdersheetNo;
	private String orderType;

	public MerordersheetgroupbomId() {
		super();
	}

	public MerordersheetgroupbomId(Long ordersheetgroupbomId, Long groupId,
			Long groupSettingId, Long ordersheetId, String planingOrdersheetNo,
			String orderType) {
		super();
		this.ordersheetgroupbomId = ordersheetgroupbomId;
		this.groupId = groupId;
		this.groupSettingId = groupSettingId;
		this.ordersheetId = ordersheetId;
		this.planingOrdersheetNo = planingOrdersheetNo;
		this.orderType = orderType;
	}

	@Column(name = "ordersheetgroupbom_id", nullable = false, columnDefinition = "INT")
	@Field
	public Long getOrdersheetgroupbomId() {
		return this.ordersheetgroupbomId;
	}

	public void setOrdersheetgroupbomId(Long ordersheetgroupbomId) {
		this.ordersheetgroupbomId = ordersheetgroupbomId;
	}

	@Column(name = "group_id", nullable = false, columnDefinition = "INT")
	@Field
	public Long getGroupId() {
		return this.groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
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

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		MerordersheetgroupbomId pojo = (MerordersheetgroupbomId) o;

		if (ordersheetgroupbomId != null ? !ordersheetgroupbomId
				.equals(pojo.ordersheetgroupbomId)
				: pojo.ordersheetgroupbomId != null)
			return false;
		if (groupId != null ? !groupId.equals(pojo.groupId)
				: pojo.groupId != null)
			return false;
		if (groupSettingId != null ? !groupSettingId
				.equals(pojo.groupSettingId) : pojo.groupSettingId != null)
			return false;
		if (ordersheetId != null ? !ordersheetId.equals(pojo.ordersheetId)
				: pojo.ordersheetId != null)
			return false;
		if (planingOrdersheetNo != null ? !planingOrdersheetNo
				.equals(pojo.planingOrdersheetNo)
				: pojo.planingOrdersheetNo != null)
			return false;
		if (orderType != null ? !orderType.equals(pojo.orderType)
				: pojo.orderType != null)
			return false;

		return true;
	}

	public int hashCode() {
		int result = 0;
		result = 31
				* result
				+ (ordersheetgroupbomId != null ? ordersheetgroupbomId
						.hashCode() : 0);
		result = (groupId != null ? groupId.hashCode() : 0);
		result = 31 * result
				+ (groupSettingId != null ? groupSettingId.hashCode() : 0);
		result = 31 * result
				+ (ordersheetId != null ? ordersheetId.hashCode() : 0);
		result = 31
				* result
				+ (planingOrdersheetNo != null ? planingOrdersheetNo.hashCode()
						: 0);
		result = 31 * result + (orderType != null ? orderType.hashCode() : 0);

		return result;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer(getClass().getSimpleName());

		sb.append(" [");
		sb.append("ordersheetgroupbomId").append("='")
				.append(getOrdersheetgroupbomId()).append("', ");
		sb.append("groupId").append("='").append(getGroupId()).append("', ");
		sb.append("groupSettingId").append("='").append(getGroupSettingId())
				.append("', ");
		sb.append("ordersheetId").append("='").append(getOrdersheetId())
				.append("', ");
		sb.append("planingOrdersheetNo").append("='")
				.append(getPlaningOrdersheetNo()).append("', ");
		sb.append("orderType").append("='").append(getOrderType()).append("'");
		sb.append("]");

		return sb.toString();
	}

}
