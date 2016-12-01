package com.excelsoft.model;

import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name="merprecostsheethdr")
@XmlRootElement
public class Merprecostsheet extends AuditFields implements Serializable {
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 3090527111542729737L;
	private MerprecostsheetId id;
    private Mstcurrency mstcurrencyByDftRmCurrency;
    private Mststyleheader mststyleheader;
    private Mstcurrency mstcurrencyByCostSheetCurrency;
    private String season;
    private Boolean compWiseCost;
    private BigDecimal totalSmv;
    private String flag;
    private BigDecimal dftRmExchangeRate;
    private BigDecimal costSheetExchangeRate;
    private BigDecimal rowMaterialValue;
    private BigDecimal serviceValue;
    private BigDecimal cm;
    private BigDecimal cmt;
    private BigDecimal financeCost;
    private BigDecimal totalCost;
    private BigDecimal markupAmount;
    private BigDecimal buyerCommission;
    private BigDecimal ourPrice;
    private BigDecimal externalCommission;
    private BigDecimal sellingPrice;
    private Mstuser merchandiser;
    private String baseBody;
    private String buyerReference;
    private String destinationCountry;
    private String shipmentMode;
    private String deliveryTerm;
    private Date validTill;
    private String remarks;
    private BigDecimal orderQty;
    
    
    public Merprecostsheet() {
		super();
	}

	public Merprecostsheet(MerprecostsheetId id) {
		super();
		this.id = id;
	}

	public Merprecostsheet(MerprecostsheetId id,
			Mstcurrency mstcurrencyByDftRmCurrency,
			Mststyleheader mststyleheader,
			Mstcurrency mstcurrencyByCostSheetCurrency, String season,
			Boolean compWiseCost, BigDecimal totalSmv, String flag,
			BigDecimal dftRmExchangeRate, BigDecimal costSheetExchangeRate,
			BigDecimal rowMaterialValue, BigDecimal serviceValue,
			BigDecimal cm, BigDecimal cmt, BigDecimal financeCost,
			BigDecimal totalCost, BigDecimal markupAmount,
			BigDecimal buyerCommission, BigDecimal ourPrice,
			BigDecimal externalCommission, BigDecimal sellingPrice,
			Mstuser merchandiser, String baseBody, String buyerReference,
			String destinationCountry, String shipmentMode,
			String deliveryTerm, Date validTill, String remarks,
			BigDecimal orderQty) {
		super();
		this.id = id;
		this.mstcurrencyByDftRmCurrency = mstcurrencyByDftRmCurrency;
		this.mststyleheader = mststyleheader;
		this.mstcurrencyByCostSheetCurrency = mstcurrencyByCostSheetCurrency;
		this.season = season;
		this.compWiseCost = compWiseCost;
		this.totalSmv = totalSmv;
		this.flag = flag;
		this.dftRmExchangeRate = dftRmExchangeRate;
		this.costSheetExchangeRate = costSheetExchangeRate;
		this.rowMaterialValue = rowMaterialValue;
		this.serviceValue = serviceValue;
		this.cm = cm;
		this.cmt = cmt;
		this.financeCost = financeCost;
		this.totalCost = totalCost;
		this.markupAmount = markupAmount;
		this.buyerCommission = buyerCommission;
		this.ourPrice = ourPrice;
		this.externalCommission = externalCommission;
		this.sellingPrice = sellingPrice;
		this.merchandiser = merchandiser;
		this.baseBody = baseBody;
		this.buyerReference = buyerReference;
		this.destinationCountry = destinationCountry;
		this.shipmentMode = shipmentMode;
		this.deliveryTerm = deliveryTerm;
		this.validTill = validTill;
		this.remarks = remarks;
		this.orderQty = orderQty;
	}

	@EmbeddedId @DocumentId    
    public MerprecostsheetId getId() {
        return this.id;
    }
    
    public void setId(MerprecostsheetId id) {
        this.id = id;
    }

    @ManyToOne()
    @JoinColumns({ 
	    @JoinColumn(name="comp_code", referencedColumnName="comp_code", nullable=false), 
	    @JoinColumn(name="cust_code", referencedColumnName="cust_code", nullable=false), 
	    @JoinColumn(name="dep_code", referencedColumnName="dep_code", nullable=false), 
	    @JoinColumn(name="location_code", referencedColumnName="location_code", nullable=false), 
	    @JoinColumn(name="style_id", referencedColumnName="style_id", nullable=false) } )
    public Mststyleheader getMststyleheader() {
        return this.mststyleheader;
    }

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="dft_rm_currency")
	    public Mstcurrency getMstcurrencyByDftRmCurrency() {
		return mstcurrencyByDftRmCurrency;
	}
	
	public void setMstcurrencyByDftRmCurrency(Mstcurrency mstcurrencyByDftRmCurrency) {
		this.mstcurrencyByDftRmCurrency = mstcurrencyByDftRmCurrency;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cost_sheet_currency")
	public Mstcurrency getMstcurrencyByCostSheetCurrency() {
		return mstcurrencyByCostSheetCurrency;
	}
	
	public void setMstcurrencyByCostSheetCurrency(
			Mstcurrency mstcurrencyByCostSheetCurrency) {
		this.mstcurrencyByCostSheetCurrency = mstcurrencyByCostSheetCurrency;
	}

	@Column(name="dft_rm_exchange_rate", precision=10, scale=0,columnDefinition="DECIMAL(10)")
	@Field
	public BigDecimal getDftRmExchangeRate() {
		return dftRmExchangeRate;
	}
	
	public void setDftRmExchangeRate(BigDecimal dftRmExchangeRate) {
		this.dftRmExchangeRate = dftRmExchangeRate;
	}
	@Column(name="cost_sheet_exchange_rate", precision=10, scale=0,columnDefinition="DECIMAL(10)")
	@Field
	public BigDecimal getCostSheetExchangeRate() {
		return costSheetExchangeRate;
	}
	
	public void setCostSheetExchangeRate(BigDecimal costSheetExchangeRate) {
		this.costSheetExchangeRate = costSheetExchangeRate;
	}

	public void setMststyleheader(Mststyleheader mststyleheader) {
        this.mststyleheader = mststyleheader;
    }
   
    @Column(name="flag", nullable=false, length=10 ,columnDefinition="CHAR(10)")
    @Field
    public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	@Column(name="Season", nullable=false, length=10 ,columnDefinition="CHAR(10)")
    @Field
    public String getSeason() {
        return this.season;
    }
    
    public void setSeason(String season) {
        this.season = season;
    }
 
    @Column(name="comp_wise_cost")
    @Field
    public Boolean getCompWiseCost() {
        return this.compWiseCost;
    }
    
    public void setCompWiseCost(Boolean compWiseCost) {
        this.compWiseCost = compWiseCost;
    }
    
    @Column(name="total_smv", precision=10, scale=0 ,columnDefinition="DECIMAL(10)")
    @Field
    public BigDecimal getTotalSmv() {
        return this.totalSmv;
    }
    
    public void setTotalSmv(BigDecimal totalSmv) {
        this.totalSmv = totalSmv;
    }
    @Column(name="order_qty", precision=10, scale=0 ,columnDefinition="DECIMAL(10)")
    @Field
    public BigDecimal getOrderQty() {
		return orderQty;
	}

	public void setOrderQty(BigDecimal orderQty) {
		this.orderQty = orderQty;
	}


    @Column(name="row_material_value", precision=10, scale=0,columnDefinition="DECIMAL(10)")
    @Field
    public BigDecimal getRowMaterialValue() {
        return this.rowMaterialValue;
    }
    
    public void setRowMaterialValue(BigDecimal rowMaterialValue) {
        this.rowMaterialValue = rowMaterialValue;
    }
    
    @Column(name="service_value", precision=10, scale=0,columnDefinition="DECIMAL(10)")
    @Field
    public BigDecimal getServiceValue() {
        return this.serviceValue;
    }
    
    public void setServiceValue(BigDecimal serviceValue) {
        this.serviceValue = serviceValue;
    }
    
    @Column(name="cm", precision=10, scale=0,columnDefinition="DECIMAL(10)")
    @Field
    public BigDecimal getCm() {
        return this.cm;
    }
    
    public void setCm(BigDecimal cm) {
        this.cm = cm;
    }
    
    @Column(name="cmt", precision=10, scale=0,columnDefinition="DECIMAL(10)")
    @Field
    public BigDecimal getCmt() {
        return this.cmt;
    }
    
    public void setCmt(BigDecimal cmt) {
        this.cmt = cmt;
    }
    
    @Column(name="finance_cost", precision=10, scale=0,columnDefinition="DECIMAL(10)")
    @Field
    public BigDecimal getFinanceCost() {
        return this.financeCost;
    }
    
    public void setFinanceCost(BigDecimal financeCost) {
        this.financeCost = financeCost;
    }
    
    @Column(name="total_cost", precision=10, scale=0,columnDefinition="DECIMAL(10)")
    @Field
    public BigDecimal getTotalCost() {
        return this.totalCost;
    }
    
    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }
    
    @Column(name="markup_amount", precision=10, scale=0,columnDefinition="DECIMAL(10)")
    @Field
    public BigDecimal getMarkupAmount() {
        return this.markupAmount;
    }
    
    public void setMarkupAmount(BigDecimal markupAmount) {
        this.markupAmount = markupAmount;
    }
    
    @Column(name="buyer_Commission", precision=10, scale=0,columnDefinition="DECIMAL(10)")
    @Field
    public BigDecimal getBuyerCommission() {
        return this.buyerCommission;
    }
    
    public void setBuyerCommission(BigDecimal buyerCommission) {
        this.buyerCommission = buyerCommission;
    }
    
    @Column(name="our_price", precision=10, scale=0,columnDefinition="DECIMAL(10)")
    @Field
    public BigDecimal getOurPrice() {
        return this.ourPrice;
    }
    
    public void setOurPrice(BigDecimal ourPrice) {
        this.ourPrice = ourPrice;
    }
    
    @Column(name="external_commission", precision=10, scale=0,columnDefinition="DECIMAL(10)")
    @Field
    public BigDecimal getExternalCommission() {
        return this.externalCommission;
    }
    
    public void setExternalCommission(BigDecimal externalCommission) {
        this.externalCommission = externalCommission;
    }
    
    @Column(name="selling_price", precision=10, scale=0,columnDefinition="DECIMAL(10)")
    @Field
    public BigDecimal getSellingPrice() {
        return this.sellingPrice;
    }
    
    public void setSellingPrice(BigDecimal sellingPrice) {
        this.sellingPrice = sellingPrice;
    }
    
    @ManyToOne()
    @JoinColumn(name="merchandiser")
    public Mstuser getMerchandiser() {
        return this.merchandiser;
    }
    
    public void setMerchandiser(Mstuser merchandiser) {
        this.merchandiser = merchandiser;
    }
    
    @Column(name="base_body", length=10,columnDefinition="CHAR(10)")
    @Field
    public String getBaseBody() {
        return this.baseBody;
    }
    
    public void setBaseBody(String baseBody) {
        this.baseBody = baseBody;
    }
    
    @Column(name="buyer_reference" ,length=255 ,columnDefinition="CHAR(255)")
    @Field
    public String getBuyerReference() {
        return this.buyerReference;
    }
    
    public void setBuyerReference(String buyerReference) {
        this.buyerReference = buyerReference;
    }
    
    @Column(name="destination_country", length=10,columnDefinition="CHAR(10)")
    @Field
    public String getDestinationCountry() {
        return this.destinationCountry;
    }
    
    public void setDestinationCountry(String destinationCountry) {
        this.destinationCountry = destinationCountry;
    }
    
    @Column(name="shipment_mode", length=10,columnDefinition="CHAR(10)")
    @Field
    public String getShipmentMode() {
        return this.shipmentMode;
    }
    
    public void setShipmentMode(String shipmentMode) {
        this.shipmentMode = shipmentMode;
    }
    
    @Column(name="delivery_term", length=10,columnDefinition="CHAR(10)")
    @Field
    public String getDeliveryTerm() {
        return this.deliveryTerm;
    }
    
    public void setDeliveryTerm(String deliveryTerm) {
        this.deliveryTerm = deliveryTerm;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="valid_till", length=19)
    @Field
    public Date getValidTill() {
        return this.validTill;
    }
    
    public void setValidTill(Date validTill) {
        this.validTill = validTill;
    }
    
    @Column(name="Remarks" ,length=255,columnDefinition="CHAR(255)")
    @Field
    public String getRemarks() {
        return this.remarks;
    }
    
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }


    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Merprecostsheet other = (Merprecostsheet) obj;
		if (baseBody == null) {
			if (other.baseBody != null)
				return false;
		} else if (!baseBody.equals(other.baseBody))
			return false;
		if (buyerCommission == null) {
			if (other.buyerCommission != null)
				return false;
		} else if (!buyerCommission.equals(other.buyerCommission))
			return false;
		if (buyerReference == null) {
			if (other.buyerReference != null)
				return false;
		} else if (!buyerReference.equals(other.buyerReference))
			return false;
		if (cm == null) {
			if (other.cm != null)
				return false;
		} else if (!cm.equals(other.cm))
			return false;
		if (cmt == null) {
			if (other.cmt != null)
				return false;
		} else if (!cmt.equals(other.cmt))
			return false;
		if (compWiseCost == null) {
			if (other.compWiseCost != null)
				return false;
		} else if (!compWiseCost.equals(other.compWiseCost))
			return false;
		if (costSheetExchangeRate == null) {
			if (other.costSheetExchangeRate != null)
				return false;
		} else if (!costSheetExchangeRate.equals(other.costSheetExchangeRate))
			return false;
		if (deliveryTerm == null) {
			if (other.deliveryTerm != null)
				return false;
		} else if (!deliveryTerm.equals(other.deliveryTerm))
			return false;
		if (destinationCountry == null) {
			if (other.destinationCountry != null)
				return false;
		} else if (!destinationCountry.equals(other.destinationCountry))
			return false;
		if (dftRmExchangeRate == null) {
			if (other.dftRmExchangeRate != null)
				return false;
		} else if (!dftRmExchangeRate.equals(other.dftRmExchangeRate))
			return false;
		if (externalCommission == null) {
			if (other.externalCommission != null)
				return false;
		} else if (!externalCommission.equals(other.externalCommission))
			return false;
		if (financeCost == null) {
			if (other.financeCost != null)
				return false;
		} else if (!financeCost.equals(other.financeCost))
			return false;
		if (flag == null) {
			if (other.flag != null)
				return false;
		} else if (!flag.equals(other.flag))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (markupAmount == null) {
			if (other.markupAmount != null)
				return false;
		} else if (!markupAmount.equals(other.markupAmount))
			return false;
		if (merchandiser == null) {
			if (other.merchandiser != null)
				return false;
		} else if (!merchandiser.equals(other.merchandiser))
			return false;
		if (orderQty == null) {
			if (other.orderQty != null)
				return false;
		} else if (!orderQty.equals(other.orderQty))
			return false;
		if (ourPrice == null) {
			if (other.ourPrice != null)
				return false;
		} else if (!ourPrice.equals(other.ourPrice))
			return false;
		if (remarks == null) {
			if (other.remarks != null)
				return false;
		} else if (!remarks.equals(other.remarks))
			return false;
		if (rowMaterialValue == null) {
			if (other.rowMaterialValue != null)
				return false;
		} else if (!rowMaterialValue.equals(other.rowMaterialValue))
			return false;
		if (season == null) {
			if (other.season != null)
				return false;
		} else if (!season.equals(other.season))
			return false;
		if (sellingPrice == null) {
			if (other.sellingPrice != null)
				return false;
		} else if (!sellingPrice.equals(other.sellingPrice))
			return false;
		if (serviceValue == null) {
			if (other.serviceValue != null)
				return false;
		} else if (!serviceValue.equals(other.serviceValue))
			return false;
		if (shipmentMode == null) {
			if (other.shipmentMode != null)
				return false;
		} else if (!shipmentMode.equals(other.shipmentMode))
			return false;
		if (totalCost == null) {
			if (other.totalCost != null)
				return false;
		} else if (!totalCost.equals(other.totalCost))
			return false;
		if (totalSmv == null) {
			if (other.totalSmv != null)
				return false;
		} else if (!totalSmv.equals(other.totalSmv))
			return false;
		if (validTill == null) {
			if (other.validTill != null)
				return false;
		} else if (!validTill.equals(other.validTill))
			return false;
		return true;
	}

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((baseBody == null) ? 0 : baseBody.hashCode());
		result = prime * result
				+ ((buyerCommission == null) ? 0 : buyerCommission.hashCode());
		result = prime * result
				+ ((buyerReference == null) ? 0 : buyerReference.hashCode());
		result = prime * result + ((cm == null) ? 0 : cm.hashCode());
		result = prime * result + ((cmt == null) ? 0 : cmt.hashCode());
		result = prime * result
				+ ((compWiseCost == null) ? 0 : compWiseCost.hashCode());
		result = prime
				* result
				+ ((costSheetExchangeRate == null) ? 0 : costSheetExchangeRate
						.hashCode());
		result = prime * result
				+ ((deliveryTerm == null) ? 0 : deliveryTerm.hashCode());
		result = prime
				* result
				+ ((destinationCountry == null) ? 0 : destinationCountry
						.hashCode());
		result = prime
				* result
				+ ((dftRmExchangeRate == null) ? 0 : dftRmExchangeRate
						.hashCode());
		result = prime
				* result
				+ ((externalCommission == null) ? 0 : externalCommission
						.hashCode());
		result = prime * result
				+ ((financeCost == null) ? 0 : financeCost.hashCode());
		result = prime * result + ((flag == null) ? 0 : flag.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((markupAmount == null) ? 0 : markupAmount.hashCode());
		result = prime * result
				+ ((merchandiser == null) ? 0 : merchandiser.hashCode());
		result = prime * result
				+ ((orderQty == null) ? 0 : orderQty.hashCode());
		result = prime * result
				+ ((ourPrice == null) ? 0 : ourPrice.hashCode());
		result = prime * result + ((remarks == null) ? 0 : remarks.hashCode());
		result = prime
				* result
				+ ((rowMaterialValue == null) ? 0 : rowMaterialValue.hashCode());
		result = prime * result + ((season == null) ? 0 : season.hashCode());
		result = prime * result
				+ ((sellingPrice == null) ? 0 : sellingPrice.hashCode());
		result = prime * result
				+ ((serviceValue == null) ? 0 : serviceValue.hashCode());
		result = prime * result
				+ ((shipmentMode == null) ? 0 : shipmentMode.hashCode());
		result = prime * result
				+ ((totalCost == null) ? 0 : totalCost.hashCode());
		result = prime * result
				+ ((totalSmv == null) ? 0 : totalSmv.hashCode());
		result = prime * result
				+ ((validTill == null) ? 0 : validTill.hashCode());
		return result;
	}

    @Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Merprecostsheet [id=");
		builder.append(id);
		builder.append(", season=");
		builder.append(season);
		builder.append(", compWiseCost=");
		builder.append(compWiseCost);
		builder.append(", totalSmv=");
		builder.append(totalSmv);
		builder.append(", flag=");
		builder.append(flag);
		builder.append(", dftRmExchangeRate=");
		builder.append(dftRmExchangeRate);
		builder.append(", costSheetExchangeRate=");
		builder.append(costSheetExchangeRate);
		builder.append(", rowMaterialValue=");
		builder.append(rowMaterialValue);
		builder.append(", serviceValue=");
		builder.append(serviceValue);
		builder.append(", cm=");
		builder.append(cm);
		builder.append(", cmt=");
		builder.append(cmt);
		builder.append(", financeCost=");
		builder.append(financeCost);
		builder.append(", totalCost=");
		builder.append(totalCost);
		builder.append(", markupAmount=");
		builder.append(markupAmount);
		builder.append(", buyerCommission=");
		builder.append(buyerCommission);
		builder.append(", ourPrice=");
		builder.append(ourPrice);
		builder.append(", externalCommission=");
		builder.append(externalCommission);
		builder.append(", sellingPrice=");
		builder.append(sellingPrice);
		builder.append(", merchandiser=");
		builder.append(merchandiser);
		builder.append(", baseBody=");
		builder.append(baseBody);
		builder.append(", buyerReference=");
		builder.append(buyerReference);
		builder.append(", destinationCountry=");
		builder.append(destinationCountry);
		builder.append(", shipmentMode=");
		builder.append(shipmentMode);
		builder.append(", deliveryTerm=");
		builder.append(deliveryTerm);
		builder.append(", validTill=");
		builder.append(validTill);
		builder.append(", remarks=");
		builder.append(remarks);
		builder.append(", orderQty=");
		builder.append(orderQty);
		builder.append("]");
		return builder.toString();
	}

}
