package com.excelsoft.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.search.annotations.Field;

@Embeddable
@XmlRootElement
public class MercostsheetrowmaterialId extends BaseObject implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 323741053083332776L;
	private Long groupId;
    private String costSheetNo;
    private BigDecimal versionNo;
    private String costSheetType;
    private BigDecimal costSheetRowMatCode;
    private String  component;
    
    public MercostsheetrowmaterialId() {
		super();
		// TODO Auto-generated constructor stub
	}



	 public MercostsheetrowmaterialId(Long groupId, String costSheetNo,
			BigDecimal versionNo, String costSheetType,
			BigDecimal costSheetRowMatCode, String component) {
		super();
		this.groupId = groupId;
		this.costSheetNo = costSheetNo;
		this.versionNo = versionNo;
		this.costSheetType = costSheetType;
		this.costSheetRowMatCode = costSheetRowMatCode;
		this.component = component;
	}


	 @Column(name="component", nullable=false, length=15, columnDefinition="CHAR(15)")
	  @Field
	public String getComponent() {
		return component;
	}



	public void setComponent(String component) {
		this.component = component;
	}



	@Column(name="cost_sheet_rowmat_code", nullable=false, length=10, columnDefinition="DECIMAL(10,0)")
	    @Field
	public BigDecimal getCostSheetRowMatCode() {
		return costSheetRowMatCode;
	}



	public void setCostSheetRowMatCode(BigDecimal costSheetRowMatCode) {
		this.costSheetRowMatCode = costSheetRowMatCode;
	}



	@Column(name="group_id", nullable=false)
    @Field
    public Long getGroupId() {
        return this.groupId;
    }
    
    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    @Column(name="cost_sheet_no", nullable=false, length=15, columnDefinition="CHAR(15)")
    @Field
    public String getCostSheetNo() {
        return this.costSheetNo;
    }
    
    public void setCostSheetNo(String costSheetNo) {
        this.costSheetNo = costSheetNo;
    }

    @Column(name="version_no", nullable=false, precision=10, scale=0, columnDefinition="DECIMAL(10,0)")
    @Field
    public BigDecimal getVersionNo() {
        return this.versionNo;
    }
    
    public void setVersionNo(BigDecimal versionNo) {
        this.versionNo = versionNo;
    }

    @Column(name="cost_sheet_type", nullable=false, length=10, columnDefinition="CHAR(10)")
    @Field
    public String getCostSheetType() {
        return this.costSheetType;
    }
    
    public void setCostSheetType(String costSheetType) {
        this.costSheetType = costSheetType;
    }

    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MercostsheetrowmaterialId other = (MercostsheetrowmaterialId) obj;
		if (component == null) {
			if (other.component != null)
				return false;
		} else if (!component.equals(other.component))
			return false;
		if (costSheetNo == null) {
			if (other.costSheetNo != null)
				return false;
		} else if (!costSheetNo.equals(other.costSheetNo))
			return false;
		if (costSheetRowMatCode == null) {
			if (other.costSheetRowMatCode != null)
				return false;
		} else if (!costSheetRowMatCode.equals(other.costSheetRowMatCode))
			return false;
		if (costSheetType == null) {
			if (other.costSheetType != null)
				return false;
		} else if (!costSheetType.equals(other.costSheetType))
			return false;
		if (groupId == null) {
			if (other.groupId != null)
				return false;
		} else if (!groupId.equals(other.groupId))
			return false;
		if (versionNo == null) {
			if (other.versionNo != null)
				return false;
		} else if (!versionNo.equals(other.versionNo))
			return false;
		return true;
	}

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((component == null) ? 0 : component.hashCode());
		result = prime * result
				+ ((costSheetNo == null) ? 0 : costSheetNo.hashCode());
		result = prime
				* result
				+ ((costSheetRowMatCode == null) ? 0 : costSheetRowMatCode
						.hashCode());
		result = prime * result
				+ ((costSheetType == null) ? 0 : costSheetType.hashCode());
		result = prime * result + ((groupId == null) ? 0 : groupId.hashCode());
		result = prime * result
				+ ((versionNo == null) ? 0 : versionNo.hashCode());
		return result;
	}

    @Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MercostsheetrowmaterialId [groupId=");
		builder.append(groupId);
		builder.append(", costSheetNo=");
		builder.append(costSheetNo);
		builder.append(", versionNo=");
		builder.append(versionNo);
		builder.append(", costSheetType=");
		builder.append(costSheetType);
		builder.append(", costSheetRowMatCode=");
		builder.append(costSheetRowMatCode);
		builder.append(", component=");
		builder.append(component);
		builder.append("]");
		return builder.toString();
	}

}
