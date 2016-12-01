package com.excelsoft.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.search.annotations.Field;

@Embeddable
@XmlRootElement
public class MercostsheetdemmapId extends BaseObject implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -4801895356066524324L;
	private String costSheetNo;
    private BigDecimal versionNo;
    private String costSheetType;
    private String componentId;
    private String mainColor;
    private String demType1;
    private String demType2;
    private String demValue1;
    private String demValue2;

	public MercostsheetdemmapId() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MercostsheetdemmapId(String costSheetNo, BigDecimal versionNo,
			String costSheetType, String componentId, String mainColor,
			String demType1, String demType2, String demValue1, String demValue2) {
		super();
		this.costSheetNo = costSheetNo;
		this.versionNo = versionNo;
		this.costSheetType = costSheetType;
		this.componentId = componentId;
		this.mainColor = mainColor;
		this.demType1 = demType1;
		this.demType2 = demType2;
		this.demValue1 = demValue1;
		this.demValue2 = demValue2;
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

    @Column(name="component_id", nullable=false, length=10, columnDefinition="CHAR(10)")
    @Field
    public String getComponentId() {
        return this.componentId;
    }
    
    public void setComponentId(String componentId) {
        this.componentId = componentId;
    }

    @Column(name="main_color", nullable=false, length=10, columnDefinition="CHAR(10)")
    @Field
    public String getMainColor() {
        return this.mainColor;
    }
    
    public void setMainColor(String mainColor) {
        this.mainColor = mainColor;
    }

    @Column(name="dem_type1", nullable=false, length=10, columnDefinition="CHAR(10)")
    @Field
    public String getDemType1() {
        return this.demType1;
    }
    
    public void setDemType1(String demType1) {
        this.demType1 = demType1;
    }

    @Column(name="dem_type2", nullable=false, length=10, columnDefinition="CHAR(10)")
    @Field
    public String getDemType2() {
        return this.demType2;
    }
    
    public void setDemType2(String demType2) {
        this.demType2 = demType2;
    }

    @Column(name="dem_value1", nullable=false, length=10, columnDefinition="CHAR(10)")
    @Field
    public String getDemValue1() {
        return this.demValue1;
    }
    
    public void setDemValue1(String demValue1) {
        this.demValue1 = demValue1;
    }

    @Column(name="dem_value2", nullable=false, length=10, columnDefinition="CHAR(10)")
    @Field
    public String getDemValue2() {
        return this.demValue2;
    }
    
    public void setDemValue2(String demValue2) {
        this.demValue2 = demValue2;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MercostsheetdemmapId pojo = (MercostsheetdemmapId) o;

        if (costSheetNo != null ? !costSheetNo.equals(pojo.costSheetNo) : pojo.costSheetNo != null) return false;
        if (versionNo != null ? !versionNo.equals(pojo.versionNo) : pojo.versionNo != null) return false;
        if (costSheetType != null ? !costSheetType.equals(pojo.costSheetType) : pojo.costSheetType != null) return false;
        if (componentId != null ? !componentId.equals(pojo.componentId) : pojo.componentId != null) return false;
        if (mainColor != null ? !mainColor.equals(pojo.mainColor) : pojo.mainColor != null) return false;
        if (demType1 != null ? !demType1.equals(pojo.demType1) : pojo.demType1 != null) return false;
        if (demType2 != null ? !demType2.equals(pojo.demType2) : pojo.demType2 != null) return false;
        if (demValue1 != null ? !demValue1.equals(pojo.demValue1) : pojo.demValue1 != null) return false;
        if (demValue2 != null ? !demValue2.equals(pojo.demValue2) : pojo.demValue2 != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = 31 * result + (costSheetNo != null ? costSheetNo.hashCode() : 0);
        result = (versionNo != null ? versionNo.hashCode() : 0);
        result = 31 * result + (costSheetType != null ? costSheetType.hashCode() : 0);
        result = 31 * result + (componentId != null ? componentId.hashCode() : 0);
        result = 31 * result + (mainColor != null ? mainColor.hashCode() : 0);
        result = 31 * result + (demType1 != null ? demType1.hashCode() : 0);
        result = 31 * result + (demType2 != null ? demType2.hashCode() : 0);
        result = 31 * result + (demValue1 != null ? demValue1.hashCode() : 0);
        result = 31 * result + (demValue2 != null ? demValue2.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("costSheetNo").append("='").append(getCostSheetNo()).append("', ");
        sb.append("versionNo").append("='").append(getVersionNo()).append("', ");
        sb.append("costSheetType").append("='").append(getCostSheetType()).append("', ");
        sb.append("componentId").append("='").append(getComponentId()).append("', ");
        sb.append("mainColor").append("='").append(getMainColor()).append("', ");
        sb.append("demType1").append("='").append(getDemType1()).append("', ");
        sb.append("demType2").append("='").append(getDemType2()).append("', ");
        sb.append("demValue1").append("='").append(getDemValue1()).append("', ");
        sb.append("demValue2").append("='").append(getDemValue2()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

}
