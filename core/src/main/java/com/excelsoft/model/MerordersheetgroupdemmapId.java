package com.excelsoft.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.search.annotations.Field;

@Embeddable
@XmlRootElement
public class MerordersheetgroupdemmapId extends BaseObject implements
		Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String horizontalDemtype;
	private String horizontalDem;
	private String verticaldemType;
	private String verticalDem;
	private Long groupSettingId;
	private Long ordersheetId;
	private String planingOrdersheetNo;
	private String orderType;

	public MerordersheetgroupdemmapId() {
		super();
	}

	public MerordersheetgroupdemmapId(String horizontalDemtype,
			String horizontalDem, String verticaldemType, String verticalDem,
			Long groupSettingId, Long ordersheetId, String planingOrdersheetNo,
			String orderType) {
		super();
		this.horizontalDemtype = horizontalDemtype;
		this.horizontalDem = horizontalDem;
		this.verticaldemType = verticaldemType;
		this.verticalDem = verticalDem;
		this.groupSettingId = groupSettingId;
		this.ordersheetId = ordersheetId;
		this.planingOrdersheetNo = planingOrdersheetNo;
		this.orderType = orderType;
	}

	@Column(name = "horizontal_demtype", nullable = false, length = 10, columnDefinition = "CHAR(10)")
	@Field
	public String getHorizontalDemtype() {
		return this.horizontalDemtype;
	}

	public void setHorizontalDemtype(String horizontalDemtype) {
		this.horizontalDemtype = horizontalDemtype;
	}

	@Column(name = "horizontal_dem", nullable = false, length = 10, columnDefinition = "CHAR(10)")
	@Field
	public String getHorizontalDem() {
		return this.horizontalDem;
	}

	public void setHorizontalDem(String horizontalDem) {
		this.horizontalDem = horizontalDem;
	}

	@Column(name = "verticaldem_type", nullable = false, length = 10, columnDefinition = "CHAR(10)")
	@Field
	public String getVerticaldemType() {
		return this.verticaldemType;
	}

	public void setVerticaldemType(String verticaldemType) {
		this.verticaldemType = verticaldemType;
	}

	@Column(name = "vertical_dem", nullable = false, length = 10, columnDefinition = "CHAR(10)")
	@Field
	public String getVerticalDem() {
		return this.verticalDem;
	}

	public void setVerticalDem(String verticalDem) {
		this.verticalDem = verticalDem;
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

		MerordersheetgroupdemmapId pojo = (MerordersheetgroupdemmapId) o;

		if (horizontalDemtype != null ? !horizontalDemtype
				.equals(pojo.horizontalDemtype)
				: pojo.horizontalDemtype != null)
			return false;
		if (horizontalDem != null ? !horizontalDem.equals(pojo.horizontalDem)
				: pojo.horizontalDem != null)
			return false;
		if (verticaldemType != null ? !verticaldemType
				.equals(pojo.verticaldemType) : pojo.verticaldemType != null)
			return false;
		if (verticalDem != null ? !verticalDem.equals(pojo.verticalDem)
				: pojo.verticalDem != null)
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
				+ (horizontalDemtype != null ? horizontalDemtype.hashCode() : 0);
		result = (horizontalDem != null ? horizontalDem.hashCode() : 0);
		result = 31 * result
				+ (verticaldemType != null ? verticaldemType.hashCode() : 0);
		result = 31 * result
				+ (verticalDem != null ? verticalDem.hashCode() : 0);
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
		sb.append("horizontalDemtype").append("='")
				.append(getHorizontalDemtype()).append("', ");
		sb.append("horizontalDem").append("='").append(getHorizontalDem())
				.append("', ");
		sb.append("verticaldemType").append("='").append(getVerticaldemType())
				.append("', ");
		sb.append("verticalDem").append("='").append(getVerticalDem())
				.append("', ");
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
