package com.excelsoft.model;

import com.excelsoft.model.BaseObject;

import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.math.BigDecimal;

@Embeddable
@Indexed
@XmlRootElement
public class MerprecostsheetsmvId extends BaseObject implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -2462286748492001780L;
	private BigDecimal styleRouteId;
    private String preCostSheetNo;
    private BigDecimal versionNo;
    private String costsheetType;

    
    public MerprecostsheetsmvId(BigDecimal styleRouteId, String preCostSheetNo,
			BigDecimal versionNo, String costsheetType) {
		super();
		this.styleRouteId = styleRouteId;
		this.preCostSheetNo = preCostSheetNo;
		this.versionNo = versionNo;
		this.costsheetType = costsheetType;
	}
	public MerprecostsheetsmvId() {
		super();
	}
	@Column(name="style_route_id", nullable=false , length = 20, columnDefinition = "BIGINT(20)")
    @Field
    public BigDecimal getStyleRouteId() {
        return this.styleRouteId;
    }
    
    public void setStyleRouteId(BigDecimal styleRouteId) {
        this.styleRouteId = styleRouteId;
    }

    @Column(name="pre_cost_sheet_no", nullable=false, length=15 ,columnDefinition="CHAR(15)")
    @Field
    public String getPreCostSheetNo() {
        return this.preCostSheetNo;
    }
    
    public void setPreCostSheetNo(String preCostSheetNo) {
        this.preCostSheetNo = preCostSheetNo;
    }

    @Column(name="version_no", nullable=false, precision=10, scale=0 ,columnDefinition="DECIMAL(10)")
    @Field
    public BigDecimal getVersionNo() {
        return this.versionNo;
    }
    
    public void setVersionNo(BigDecimal versionNo) {
        this.versionNo = versionNo;
    }
    @Column(name="costsheet_type", nullable=false, length=10,columnDefinition="CHAR(10)")
    @Field
    public String getCostsheetType() {
        return this.costsheetType;
    }
    
    public void setCostsheetType(String costsheetType) {
        this.costsheetType = costsheetType;
    }
    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MerprecostsheetsmvId other = (MerprecostsheetsmvId) obj;
		if (costsheetType == null) {
			if (other.costsheetType != null)
				return false;
		} else if (!costsheetType.equals(other.costsheetType))
			return false;
		if (preCostSheetNo == null) {
			if (other.preCostSheetNo != null)
				return false;
		} else if (!preCostSheetNo.equals(other.preCostSheetNo))
			return false;
		if (styleRouteId == null) {
			if (other.styleRouteId != null)
				return false;
		} else if (!styleRouteId.equals(other.styleRouteId))
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
				+ ((costsheetType == null) ? 0 : costsheetType.hashCode());
		result = prime * result
				+ ((preCostSheetNo == null) ? 0 : preCostSheetNo.hashCode());
		result = prime * result
				+ ((styleRouteId == null) ? 0 : styleRouteId.hashCode());
		result = prime * result
				+ ((versionNo == null) ? 0 : versionNo.hashCode());
		return result;
	}

    @Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MerprecostsheetsmvId [styleRouteId=")
				.append(styleRouteId).append(", preCostSheetNo=")
				.append(preCostSheetNo).append(", versionNo=")
				.append(versionNo).append(", costsheetType=")
				.append(costsheetType).append("]");
		return builder.toString();
	}

}
