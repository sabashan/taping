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
public class MerprecostsheetrowmaterialsId extends BaseObject implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 7621909125571511160L;
	private String preCostSheetNo;
    private BigDecimal versionNo;
    private String costsheetType;
    private BigDecimal precostsheetRowMatCode;
    private String component;


   
    public MerprecostsheetrowmaterialsId(String preCostSheetNo, BigDecimal versionNo,
			String costsheetType, BigDecimal precostsheetRowMatCode, String component) {
		super();
		this.preCostSheetNo = preCostSheetNo;
		this.versionNo = versionNo;
		this.costsheetType = costsheetType;
		this.precostsheetRowMatCode = precostsheetRowMatCode;
		this.component = component;
	}

	public MerprecostsheetrowmaterialsId() {
		super();
		
	}

	@Column(name="pre_cost_sheet_no", nullable=false, length=15 ,columnDefinition="CHAR(15)")
    @Field
    public String getPreCostSheetNo() {
        return this.preCostSheetNo;
    }
    
    public void setPreCostSheetNo(String preCostSheetNo) {
        this.preCostSheetNo = preCostSheetNo;
    }

    @Column(name="version_no", nullable=false, precision=10, scale=0,columnDefinition="DECIMAL(10)")
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
    @Column(name="precostsheet_row_mat_code", nullable=false, precision=10, scale=0,columnDefinition="DECIMAL(10)")
    @Field
    public BigDecimal getPrecostsheetRowMatCode() {
        return this.precostsheetRowMatCode;
    }
    
    public void setPrecostsheetRowMatCode(BigDecimal precostsheetRowMatCode) {
        this.precostsheetRowMatCode = precostsheetRowMatCode;
    }

    @Column(name="component", nullable=false, length=6,columnDefinition="CHAR(6)")
    @Field
    public String getComponent() {
        return this.component;
    }
    
    public void setComponent(String component) {
        this.component = component;
    }

    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MerprecostsheetrowmaterialsId other = (MerprecostsheetrowmaterialsId) obj;
		if (component == null) {
			if (other.component != null)
				return false;
		} else if (!component.equals(other.component))
			return false;
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
		if (precostsheetRowMatCode == null) {
			if (other.precostsheetRowMatCode != null)
				return false;
		} else if (!precostsheetRowMatCode.equals(other.precostsheetRowMatCode))
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
				+ ((costsheetType == null) ? 0 : costsheetType.hashCode());
		result = prime * result
				+ ((preCostSheetNo == null) ? 0 : preCostSheetNo.hashCode());
		result = prime
				* result
				+ ((precostsheetRowMatCode == null) ? 0
						: precostsheetRowMatCode.hashCode());
		result = prime * result
				+ ((versionNo == null) ? 0 : versionNo.hashCode());
		return result;
	}

    @Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MerprecostsheetrowmaterialsId [preCostSheetNo=")
				.append(preCostSheetNo).append(", versionNo=")
				.append(versionNo).append(", costsheetType=")
				.append(costsheetType).append(", precostsheetRowMatCode=")
				.append(precostsheetRowMatCode).append(", component=")
				.append(component).append("]");
		return builder.toString();
	}

}
