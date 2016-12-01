package com.excelsoft.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.search.annotations.Field;

@Embeddable
@XmlRootElement
public class MercostsheetgroupdemmapId extends BaseObject implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 6045059679027823794L;
	private Long groupSettingId;
    private Long groupId;
    private String costSheetNo;
    private BigDecimal versionNo;
    private String costSheetType;
    private String horizontalDemtype;
    private String horizontalDem;
    private String verticaldemType;
    private String verticalDem;

    public MercostsheetgroupdemmapId() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MercostsheetgroupdemmapId(Long groupSettingId, Long groupId,
			String costSheetNo, BigDecimal versionNo, String costSheetType,
			String horizontalDemtype, String horizontalDem,
			String verticaldemType, String verticalDem) {
		super();
		this.groupSettingId = groupSettingId;
		this.groupId = groupId;
		this.costSheetNo = costSheetNo;
		this.versionNo = versionNo;
		this.costSheetType = costSheetType;
		this.horizontalDemtype = horizontalDemtype;
		this.horizontalDem = horizontalDem;
		this.verticaldemType = verticaldemType;
		this.verticalDem = verticalDem;
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

    @Column(name="horizontal_demtype", nullable=false, length=10, columnDefinition="CHAR(10)")
    @Field
    public String getHorizontalDemtype() {
        return this.horizontalDemtype;
    }
    
    public void setHorizontalDemtype(String horizontalDemtype) {
        this.horizontalDemtype = horizontalDemtype;
    }

    @Column(name="horizontal_dem", nullable=false, length=10, columnDefinition="CHAR(10)")
    @Field
    public String getHorizontalDem() {
        return this.horizontalDem;
    }
    
    public void setHorizontalDem(String horizontalDem) {
        this.horizontalDem = horizontalDem;
    }

    @Column(name="verticaldem_type", nullable=false, length=10, columnDefinition="CHAR(10)")
    @Field
    public String getVerticaldemType() {
        return this.verticaldemType;
    }
    
    public void setVerticaldemType(String verticaldemType) {
        this.verticaldemType = verticaldemType;
    }

    @Column(name="vertical_dem", nullable=false, length=10, columnDefinition="CHAR(10)")
    @Field
    public String getVerticalDem() {
        return this.verticalDem;
    }
    
    public void setVerticalDem(String verticalDem) {
        this.verticalDem = verticalDem;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MercostsheetgroupdemmapId pojo = (MercostsheetgroupdemmapId) o;

        if (groupSettingId != null ? !groupSettingId.equals(pojo.groupSettingId) : pojo.groupSettingId != null) return false;
        if (groupId != null ? !groupId.equals(pojo.groupId) : pojo.groupId != null) return false;
        if (costSheetNo != null ? !costSheetNo.equals(pojo.costSheetNo) : pojo.costSheetNo != null) return false;
        if (versionNo != null ? !versionNo.equals(pojo.versionNo) : pojo.versionNo != null) return false;
        if (costSheetType != null ? !costSheetType.equals(pojo.costSheetType) : pojo.costSheetType != null) return false;
        if (horizontalDemtype != null ? !horizontalDemtype.equals(pojo.horizontalDemtype) : pojo.horizontalDemtype != null) return false;
        if (horizontalDem != null ? !horizontalDem.equals(pojo.horizontalDem) : pojo.horizontalDem != null) return false;
        if (verticaldemType != null ? !verticaldemType.equals(pojo.verticaldemType) : pojo.verticaldemType != null) return false;
        if (verticalDem != null ? !verticalDem.equals(pojo.verticalDem) : pojo.verticalDem != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = 31 * result + (groupSettingId != null ? groupSettingId.hashCode() : 0);
        result = (groupId != null ? groupId.hashCode() : 0);
        result = 31 * result + (costSheetNo != null ? costSheetNo.hashCode() : 0);
        result = 31 * result + (versionNo != null ? versionNo.hashCode() : 0);
        result = 31 * result + (costSheetType != null ? costSheetType.hashCode() : 0);
        result = 31 * result + (horizontalDemtype != null ? horizontalDemtype.hashCode() : 0);
        result = 31 * result + (horizontalDem != null ? horizontalDem.hashCode() : 0);
        result = 31 * result + (verticaldemType != null ? verticaldemType.hashCode() : 0);
        result = 31 * result + (verticalDem != null ? verticalDem.hashCode() : 0);

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
        sb.append("horizontalDemtype").append("='").append(getHorizontalDemtype()).append("', ");
        sb.append("horizontalDem").append("='").append(getHorizontalDem()).append("', ");
        sb.append("verticaldemType").append("='").append(getVerticaldemType()).append("', ");
        sb.append("verticalDem").append("='").append(getVerticalDem()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

}
