package com.excelsoft.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.search.annotations.Field;

@Embeddable
@XmlRootElement
public class MercostsheetgroupcolorId extends BaseObject implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -4146697325108026446L;
	private Long groupSettingId;
    private Long groupId;
    private String costSheetNo;
    private BigDecimal versionNo;
    private String costSheetType;
    private String color;

    public MercostsheetgroupcolorId() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MercostsheetgroupcolorId(Long groupSettingId, Long groupId,
			String costSheetNo, BigDecimal versionNo, String costSheetType,
			String color) {
		super();
		this.groupSettingId = groupSettingId;
		this.groupId = groupId;
		this.costSheetNo = costSheetNo;
		this.versionNo = versionNo;
		this.costSheetType = costSheetType;
		this.color = color;
	}

	@Column(name="group_setting_id", nullable=false)
    @Field
    public Long getGroupSettingId() {
        return this.groupSettingId;
    }
    
    public void setGroupSettingId(Long groupSettingId) {
        this.groupSettingId = groupSettingId;
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

    @Column(name="color", nullable=false, length=10, columnDefinition="CHAR(10)")
    @Field
    public String getColor() {
        return this.color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MercostsheetgroupcolorId pojo = (MercostsheetgroupcolorId) o;

        if (groupSettingId != null ? !groupSettingId.equals(pojo.groupSettingId) : pojo.groupSettingId != null) return false;
        if (groupId != null ? !groupId.equals(pojo.groupId) : pojo.groupId != null) return false;
        if (costSheetNo != null ? !costSheetNo.equals(pojo.costSheetNo) : pojo.costSheetNo != null) return false;
        if (versionNo != null ? !versionNo.equals(pojo.versionNo) : pojo.versionNo != null) return false;
        if (costSheetType != null ? !costSheetType.equals(pojo.costSheetType) : pojo.costSheetType != null) return false;
        if (color != null ? !color.equals(pojo.color) : pojo.color != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = 31 * result + (groupSettingId != null ? groupSettingId.hashCode() : 0);
        result = (groupId != null ? groupId.hashCode() : 0);
        result = 31 * result + (costSheetNo != null ? costSheetNo.hashCode() : 0);
        result = 31 * result + (versionNo != null ? versionNo.hashCode() : 0);
        result = 31 * result + (costSheetType != null ? costSheetType.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("groupSettingId").append("='").append(getGroupSettingId()).append("', ");
        sb.append("groupId").append("='").append(getGroupId()).append("', ");
        sb.append("costSheetNo").append("='").append(getCostSheetNo()).append("', ");
        sb.append("versionNo").append("='").append(getVersionNo()).append("', ");
        sb.append("costSheetType").append("='").append(getCostSheetType()).append("', ");
        sb.append("color").append("='").append(getColor()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

}
