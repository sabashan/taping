package com.excelsoft.model;

import com.excelsoft.model.BaseObject;

import org.hibernate.search.annotations.Field;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.math.BigDecimal;

@Embeddable
@XmlRootElement
public class MercostsheetsmvId extends BaseObject implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -2462286748492001780L;
	private BigDecimal styleRouteId;
	private String costSheetNo;
    private BigDecimal versionNo;
    private String costSheetType;

    
    public MercostsheetsmvId(BigDecimal styleRouteId, String costSheetNo,
			BigDecimal versionNo, String costSheetType) {
		super();
		this.styleRouteId = styleRouteId;
		this.costSheetNo = costSheetNo;
		this.versionNo = versionNo;
		this.costSheetType = costSheetType;
	}
	public MercostsheetsmvId() {
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
		MercostsheetsmvId other = (MercostsheetsmvId) obj;
		if (costSheetType == null) {
			if (other.costSheetType != null)
				return false;
		} else if (!costSheetType.equals(other.costSheetType))
			return false;
		if (costSheetNo == null) {
			if (other.costSheetNo != null)
				return false;
		} else if (!costSheetNo.equals(other.costSheetNo))
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
				+ ((costSheetType == null) ? 0 : costSheetType.hashCode());
		result = prime * result
				+ ((costSheetNo == null) ? 0 : costSheetNo.hashCode());
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
				.append(styleRouteId).append(", costSheetNo=")
				.append(costSheetNo).append(", versionNo=")
				.append(versionNo).append(", costSheetType=")
				.append(costSheetType).append("]");
		return builder.toString();
	}

}
