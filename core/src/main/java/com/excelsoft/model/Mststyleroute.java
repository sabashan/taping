package com.excelsoft.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

@Entity
@Table(name = "mststyleroute")
@Indexed
@XmlRootElement
public class Mststyleroute extends AuditFields implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long styleRouteId;
	private Mststyleheader mststyleheader;
	private String componentId;
	private String mainColor;
	private String styleRouteName;
	private String assignLocation;
	private String buyerDept;
	private String productType;
	private Long noOfPcs;
	private Long orderQty;
	private Long noOfMachines;
	private Long noOfWokers;
	private Long noOfHealpers;
	private Long workMins;
	private Long cycleTime;
	private Date targetDate;
	private String remarks;
	private String approvedBy;
	private Date approvedOn;
	private String routeStatus;
	private BigDecimal totalSMV;

	public Mststyleroute(Long styleRouteId, Mststyleheader mststyleheader,
			String componentId, String mainColor, String styleRouteName,
			String assignLocation, String buyerDept, String productType,
			Long noOfPcs, Long orderQty, Long noOfMachines, Long noOfWokers,
			Long noOfHealpers, Long workMins, Long cycleTime, Date targetDate,
			String remarks, String approvedBy, Date approvedOn,
			String routeStatus, BigDecimal totalSMV) {
		super();
		this.styleRouteId = styleRouteId;
		this.mststyleheader = mststyleheader;
		this.componentId = componentId;
		this.mainColor = mainColor;
		this.styleRouteName = styleRouteName;
		this.assignLocation = assignLocation;
		this.buyerDept = buyerDept;
		this.productType = productType;
		this.noOfPcs = noOfPcs;
		this.orderQty = orderQty;
		this.noOfMachines = noOfMachines;
		this.noOfWokers = noOfWokers;
		this.noOfHealpers = noOfHealpers;
		this.workMins = workMins;
		this.cycleTime = cycleTime;
		this.targetDate = targetDate;
		this.remarks = remarks;
		this.approvedBy = approvedBy;
		this.approvedOn = approvedOn;
		this.routeStatus = routeStatus;
		this.totalSMV = totalSMV;
	}

	public Mststyleroute(Long styleRouteId) {
		super();
		this.styleRouteId = styleRouteId;
	}
	public Mststyleroute() {
		super();
		
	}
	@Id
	@DocumentId
	@Column(name = "style_route_id", nullable = false, length = 20, columnDefinition = "BIGINT(20)")
	public Long getStyleRouteId() {
		return this.styleRouteId;
	}

	public void setStyleRouteId(Long styleRouteId) {
		this.styleRouteId = styleRouteId;
	}

	@ManyToOne(fetch=FetchType.EAGER )
	@JoinColumns({
			@JoinColumn(name = "comp_code", referencedColumnName = "comp_code", nullable = false),
			@JoinColumn(name = "cust_code", referencedColumnName = "cust_code", nullable = false),
			@JoinColumn(name = "dep_code", referencedColumnName = "dep_code", nullable = false),
			@JoinColumn(name = "location_code", referencedColumnName = "location_code", nullable = false),
			@JoinColumn(name = "style_id", referencedColumnName = "style_id", nullable = false) })
	
	public Mststyleheader getMststyleheader() {
		return this.mststyleheader;
	}

	public void setMststyleheader(Mststyleheader mststyleheader) {
		this.mststyleheader = mststyleheader;
	}

	
	
	
	@Column(name = "component_id", nullable = false, length = 10, columnDefinition = "CHAR(10)")
	@Field
	public String getComponentId() {
		return this.componentId;
	}

	public void setComponentId(String componentId) {
		this.componentId = componentId;
	}

	@Column(name = "main_color", nullable = false, length = 10, columnDefinition = "CHAR(10)")
	@Field
	public String getMainColor() {
		return this.mainColor;
	}

	public void setMainColor(String mainColor) {
		this.mainColor = mainColor;
	}

	@Column(name = "style_route_name", length = 30, columnDefinition = "CHAR(30)")
	@Field
	public String getStyleRouteName() {
		return this.styleRouteName;
	}

	public void setStyleRouteName(String styleRouteName) {
		this.styleRouteName = styleRouteName;
	}

	@Column(name = "assign_location", length = 6, columnDefinition = "CHAR(6)")
	@Field
	public String getAssignLocation() {
		return this.assignLocation;
	}

	public void setAssignLocation(String assignLocation) {
		this.assignLocation = assignLocation;
	}

	@Column(name = "buyer_dept", length = 10, columnDefinition = "CHAR(10)")
	@Field
	public String getBuyerDept() {
		return this.buyerDept;
	}

	public void setBuyerDept(String buyerDept) {
		this.buyerDept = buyerDept;
	}

	@Column(name = "product_type", length = 10, columnDefinition = "CHAR(10)")
	@Field
	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	@Column(name = "no_of_pcs")
	@Field
	public Long getNoOfPcs() {
		return this.noOfPcs;
	}

	public void setNoOfPcs(Long noOfPcs) {
		this.noOfPcs = noOfPcs;
	}

	@Column(name = "order_qty")
	@Field
	public Long getOrderQty() {
		return this.orderQty;
	}

	public void setOrderQty(Long orderQty) {
		this.orderQty = orderQty;
	}

	@Column(name = "no_of_machines")
	@Field
	public Long getNoOfMachines() {
		return this.noOfMachines;
	}

	public void setNoOfMachines(Long noOfMachines) {
		this.noOfMachines = noOfMachines;
	}

	@Column(name = "no_of_wokers")
	@Field
	public Long getNoOfWokers() {
		return this.noOfWokers;
	}

	public void setNoOfWokers(Long noOfWokers) {
		this.noOfWokers = noOfWokers;
	}

	@Column(name = "no_of_healpers")
	@Field
	public Long getNoOfHealpers() {
		return this.noOfHealpers;
	}

	public void setNoOfHealpers(Long noOfHealpers) {
		this.noOfHealpers = noOfHealpers;
	}

	@Column(name = "work_mins")
	@Field
	public Long getWorkMins() {
		return this.workMins;
	}

	public void setWorkMins(Long workMins) {
		this.workMins = workMins;
	}

	@Column(name = "cycle_time")
	@Field
	public Long getCycleTime() {
		return this.cycleTime;
	}

	public void setCycleTime(Long cycleTime) {
		this.cycleTime = cycleTime;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "target_date", length = 10)
	@Field
	public Date getTargetDate() {
		return this.targetDate;
	}

	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}

	@Column(name = "remarks", length = 100, columnDefinition = "CHAR(100)")
	@Field
	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

//	@Column(name = "created_by", length = 50, columnDefinition = "CHAR(50)")
//	@Field
//	public String getCreatedBy() {
//		return this.createdBy;
//	}
//
//	public void setCreatedBy(String createdBy) {
//		this.createdBy = createdBy;
//	}
//
//	@Temporal(TemporalType.TIMESTAMP)
//	@Column(name = "created_on", length = 19)
//	@Field
//	public Date getCreatedOn() {
//		return this.createdOn;
//	}
//
//	public void setCreatedOn(Date createdOn) {
//		this.createdOn = createdOn;
//	}
//
//	@Column(name = "modified_by", length = 50, columnDefinition = "CHAR(50)")
//	@Field
//	public String getModifiedBy() {
//		return this.modifiedBy;
//	}
//
//	public void setModifiedBy(String modifiedBy) {
//		this.modifiedBy = modifiedBy;
//	}
//
//	@Temporal(TemporalType.TIMESTAMP)
//	@Column(name = "modified_on", length = 19)
//	@Field
//	public Date getModifiedOn() {
//		return this.modifiedOn;
//	}
//
//	public void setModifiedOn(Date modifiedOn) {
//		this.modifiedOn = modifiedOn;
//	}

	@Column(name = "approved_by", length = 50, columnDefinition = "CHAR(50)")
	@Field
	public String getApprovedBy() {
		return this.approvedBy;
	}

	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "approved_on", length = 19)
	@Field
	public Date getApprovedOn() {
		return this.approvedOn;
	}

	public void setApprovedOn(Date approvedOn) {
		this.approvedOn = approvedOn;
	}

	@Column(name = "route_status", nullable = false, length = 10, columnDefinition = "CHAR(10)")
	@Field
	public String getRouteStatus() {
		return this.routeStatus;
	}

	public void setRouteStatus(String routeStatus) {
		this.routeStatus = routeStatus;
	}

	@Transient
	public BigDecimal getTotalSMV() {
		return totalSMV;
	}

	@Transient
	public void setTotalSMV(BigDecimal totalSMV) {
		this.totalSMV = totalSMV;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mststyleroute other = (Mststyleroute) obj;
		if (approvedBy == null) {
			if (other.approvedBy != null)
				return false;
		} else if (!approvedBy.equals(other.approvedBy))
			return false;
		if (approvedOn == null) {
			if (other.approvedOn != null)
				return false;
		} else if (!approvedOn.equals(other.approvedOn))
			return false;
		if (assignLocation == null) {
			if (other.assignLocation != null)
				return false;
		} else if (!assignLocation.equals(other.assignLocation))
			return false;
		if (buyerDept == null) {
			if (other.buyerDept != null)
				return false;
		} else if (!buyerDept.equals(other.buyerDept))
			return false;
		if (componentId == null) {
			if (other.componentId != null)
				return false;
		} else if (!componentId.equals(other.componentId))
			return false;
		if (cycleTime == null) {
			if (other.cycleTime != null)
				return false;
		} else if (!cycleTime.equals(other.cycleTime))
			return false;
		if (mainColor == null) {
			if (other.mainColor != null)
				return false;
		} else if (!mainColor.equals(other.mainColor))
			return false;
		if (mststyleheader == null) {
			if (other.mststyleheader != null)
				return false;
		} else if (!mststyleheader.equals(other.mststyleheader))
			return false;
		if (noOfHealpers == null) {
			if (other.noOfHealpers != null)
				return false;
		} else if (!noOfHealpers.equals(other.noOfHealpers))
			return false;
		if (noOfMachines == null) {
			if (other.noOfMachines != null)
				return false;
		} else if (!noOfMachines.equals(other.noOfMachines))
			return false;
		if (noOfPcs == null) {
			if (other.noOfPcs != null)
				return false;
		} else if (!noOfPcs.equals(other.noOfPcs))
			return false;
		if (noOfWokers == null) {
			if (other.noOfWokers != null)
				return false;
		} else if (!noOfWokers.equals(other.noOfWokers))
			return false;
		if (orderQty == null) {
			if (other.orderQty != null)
				return false;
		} else if (!orderQty.equals(other.orderQty))
			return false;
		if (productType == null) {
			if (other.productType != null)
				return false;
		} else if (!productType.equals(other.productType))
			return false;
		if (remarks == null) {
			if (other.remarks != null)
				return false;
		} else if (!remarks.equals(other.remarks))
			return false;
		if (routeStatus == null) {
			if (other.routeStatus != null)
				return false;
		} else if (!routeStatus.equals(other.routeStatus))
			return false;
		if (styleRouteId == null) {
			if (other.styleRouteId != null)
				return false;
		} else if (!styleRouteId.equals(other.styleRouteId))
			return false;
		if (styleRouteName == null) {
			if (other.styleRouteName != null)
				return false;
		} else if (!styleRouteName.equals(other.styleRouteName))
			return false;
		if (targetDate == null) {
			if (other.targetDate != null)
				return false;
		} else if (!targetDate.equals(other.targetDate))
			return false;
		if (totalSMV == null) {
			if (other.totalSMV != null)
				return false;
		} else if (!totalSMV.equals(other.totalSMV))
			return false;
		if (workMins == null) {
			if (other.workMins != null)
				return false;
		} else if (!workMins.equals(other.workMins))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((approvedBy == null) ? 0 : approvedBy.hashCode());
		result = prime * result
				+ ((approvedOn == null) ? 0 : approvedOn.hashCode());
		result = prime * result
				+ ((assignLocation == null) ? 0 : assignLocation.hashCode());
		result = prime * result
				+ ((buyerDept == null) ? 0 : buyerDept.hashCode());
		result = prime * result
				+ ((componentId == null) ? 0 : componentId.hashCode());
		result = prime * result
				+ ((cycleTime == null) ? 0 : cycleTime.hashCode());
		result = prime * result
				+ ((mainColor == null) ? 0 : mainColor.hashCode());
		result = prime * result
				+ ((mststyleheader == null) ? 0 : mststyleheader.hashCode());
		result = prime * result
				+ ((noOfHealpers == null) ? 0 : noOfHealpers.hashCode());
		result = prime * result
				+ ((noOfMachines == null) ? 0 : noOfMachines.hashCode());
		result = prime * result + ((noOfPcs == null) ? 0 : noOfPcs.hashCode());
		result = prime * result
				+ ((noOfWokers == null) ? 0 : noOfWokers.hashCode());
		result = prime * result
				+ ((orderQty == null) ? 0 : orderQty.hashCode());
		result = prime * result
				+ ((productType == null) ? 0 : productType.hashCode());
		result = prime * result + ((remarks == null) ? 0 : remarks.hashCode());
		result = prime * result
				+ ((routeStatus == null) ? 0 : routeStatus.hashCode());
		result = prime * result
				+ ((styleRouteId == null) ? 0 : styleRouteId.hashCode());
		result = prime * result
				+ ((styleRouteName == null) ? 0 : styleRouteName.hashCode());
		result = prime * result
				+ ((targetDate == null) ? 0 : targetDate.hashCode());
		result = prime * result
				+ ((totalSMV == null) ? 0 : totalSMV.hashCode());
		result = prime * result
				+ ((workMins == null) ? 0 : workMins.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "Mststyleroute [styleRouteId=" + styleRouteId
				+ ", mststyleheader=" + mststyleheader + ", componentId="
				+ componentId + ", mainColor=" + mainColor
				+ ", styleRouteName=" + styleRouteName + ", assignLocation="
				+ assignLocation + ", buyerDept=" + buyerDept
				+ ", productType=" + productType + ", noOfPcs=" + noOfPcs
				+ ", orderQty=" + orderQty + ", noOfMachines=" + noOfMachines
				+ ", noOfWokers=" + noOfWokers + ", noOfHealpers="
				+ noOfHealpers + ", workMins=" + workMins + ", cycleTime="
				+ cycleTime + ", targetDate=" + targetDate + ", remarks="
				+ remarks + ", approvedBy=" + approvedBy + ", approvedOn="
				+ approvedOn + ", routeStatus=" + routeStatus + ", totalSMV="
				+ totalSMV + "]";
	}

}
