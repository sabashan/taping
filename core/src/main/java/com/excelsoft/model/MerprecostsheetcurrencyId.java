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
public class MerprecostsheetcurrencyId extends BaseObject implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 2438012339205398013L;
	private String preCostSheetNo;
    private BigDecimal versionNo;
    private String currencyCode;
    private String costsheetType;


    
    public MerprecostsheetcurrencyId(String preCostSheetNo, BigDecimal versionNo,
			String currencyCode, String costsheetType) {
		super();
		this.preCostSheetNo = preCostSheetNo;
		this.versionNo = versionNo;
		this.currencyCode = currencyCode;
		this.costsheetType = costsheetType;
	}
	public MerprecostsheetcurrencyId() {
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
    @Column(name="currency_code", nullable=false, length=4 ,columnDefinition="CHAR(4)")
    @Field
    public String getCurrencyCode() {
        return this.currencyCode;
    }
    
    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MerprecostsheetcurrencyId other = (MerprecostsheetcurrencyId) obj;
		if (costsheetType == null) {
			if (other.costsheetType != null)
				return false;
		} else if (!costsheetType.equals(other.costsheetType))
			return false;
		if (currencyCode == null) {
			if (other.currencyCode != null)
				return false;
		} else if (!currencyCode.equals(other.currencyCode))
			return false;
		if (preCostSheetNo == null) {
			if (other.preCostSheetNo != null)
				return false;
		} else if (!preCostSheetNo.equals(other.preCostSheetNo))
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
				+ ((currencyCode == null) ? 0 : currencyCode.hashCode());
		result = prime * result
				+ ((preCostSheetNo == null) ? 0 : preCostSheetNo.hashCode());
		result = prime * result
				+ ((versionNo == null) ? 0 : versionNo.hashCode());
		return result;
	}

    @Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MerprecostsheetcurrencyId [preCostSheetNo=")
				.append(preCostSheetNo).append(", versionNo=")
				.append(versionNo).append(", currencyCode=")
				.append(currencyCode).append(", costsheetType=")
				.append(costsheetType).append("]");
		return builder.toString();
	}

}
