package com.excelsoft.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;

@Entity
@Table(name="mercostsheetgroup")
@XmlRootElement
public class Mercostsheetgroup extends BaseObject implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -4954174861834665869L;
	private MercostsheetgroupId id;
    private Mercostsheethdr mercostsheethdr;
    private Merprecostsheet merprecostsheethdr;
    private String groupName;
    private String country;
    private BigDecimal totalCost;
    private BigDecimal sellingPrice;
   /* private String baseBody;
    private String buyerReference;*/
    private String shipmentMode;
    private String deliveryTerm;
    private String remarks;
    private Boolean isGroupLocked;
    private Boolean isCostingLocked;
    private BigDecimal rowMaterialValue;
    private BigDecimal serviceValue;
    private BigDecimal cm;
    private BigDecimal cmt;
    private BigDecimal financeCost;
    private BigDecimal markupAmount;
    private BigDecimal buyerCommission;
    private BigDecimal ourPrice;
    private BigDecimal externalCommission;
//    private Set<Mercostsheetrowmaterial> mercostsheetrowmaterials = new HashSet<Mercostsheetrowmaterial>(0);
//    private Set<Mercostsheetgroupsetting> mercostsheetgroupsettings = new HashSet<Mercostsheetgroupsetting>(0);
    
    public Mercostsheetgroup() {
		super();
		// TODO Auto-generated constructor stub
	}

    public Mercostsheetgroup(MercostsheetgroupId id,
		Mercostsheethdr mercostsheethdr, Merprecostsheet merprecostsheethdr,
		String groupName, String country, BigDecimal totalCost, BigDecimal sellingPrice,
		String shipmentMode,
		String deliveryTerm, String remarks, Boolean isGroupLocked,
		Boolean isCostingLocked) {
		super();
		this.id = id;
		this.mercostsheethdr = mercostsheethdr;
		this.merprecostsheethdr = merprecostsheethdr;
		this.groupName = groupName;
		this.country = country;
		this.totalCost = totalCost;
		this.sellingPrice = sellingPrice;
		//this.baseBody = baseBody;
		//this.buyerReference = buyerReference;
		this.shipmentMode = shipmentMode;
		this.deliveryTerm = deliveryTerm;
		this.remarks = remarks;
		this.isGroupLocked = isGroupLocked;
		this.isCostingLocked = isCostingLocked;
    }

	@EmbeddedId @DocumentId    
    public MercostsheetgroupId getId() {
        return this.id;
    }

	public void setId(MercostsheetgroupId id) {
        this.id = id;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumns( { 
        @JoinColumn(name="cost_sheet_no", referencedColumnName="cost_sheet_no", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="version_no", referencedColumnName="version_no", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="cost_sheet_type", referencedColumnName="cost_sheet_type", nullable=false, insertable=false, updatable=false) } )
  @JsonIgnore
    public Mercostsheethdr getMercostsheethdr() {
        return this.mercostsheethdr;
    }
    
    public void setMercostsheethdr(Mercostsheethdr mercostsheethdr) {
        this.mercostsheethdr = mercostsheethdr;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumns( { 
        @JoinColumn(name="pre_costsheet_type", referencedColumnName="costsheet_type", nullable=false), 
        @JoinColumn(name="pre_cost_sheet_no", referencedColumnName="pre_cost_sheet_no", nullable=false), 
        @JoinColumn(name="pre_cost_sheet_version_no", referencedColumnName="version_no", nullable=false) } )
    @JsonIgnore
    public Merprecostsheet getMerprecostsheethdr() {
        return this.merprecostsheethdr;
    }
    
    public void setMerprecostsheethdr(Merprecostsheet merprecostsheethdr) {
        this.merprecostsheethdr = merprecostsheethdr;
    }

    @Column(name="group_name", length=45, columnDefinition="CHAR(45)")
    @Field
    public String getGroupName() {
        return this.groupName;
    }
    
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Column(name="country", length=10, columnDefinition="CHAR(10)")
    @Field
    public String getCountry() {
        return this.country;
    }
    
    public void setCountry(String country) {
        this.country = country;
    }

    @Column(name="total_cost", precision=10, scale=0, columnDefinition="DECIMAL(10,4)")
    @Field
    public BigDecimal getTotalCost() {
        return this.totalCost;
    }
    
    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    @Column(name="selling_price", precision=10, scale=0, columnDefinition="DECIMAL(10,4)")
    @Field
    public BigDecimal getSellingPrice() {
        return this.sellingPrice;
    }
    
    public void setSellingPrice(BigDecimal sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

	

    @Column(name="shipment_mode", length=10, columnDefinition="CHAR(10)")
    @Field
    public String getShipmentMode() {
        return this.shipmentMode;
    }
    
    public void setShipmentMode(String shipmentMode) {
        this.shipmentMode = shipmentMode;
    }

    @Column(name="delivery_term", length=10, columnDefinition="CHAR(10)")
    @Field
    public String getDeliveryTerm() {
        return this.deliveryTerm;
    }
    
    public void setDeliveryTerm(String deliveryTerm) {
        this.deliveryTerm = deliveryTerm;
    }

    @Column(name="remarks", length=255, columnDefinition="CHAR(255)")
    @Field
    public String getRemarks() {
        return this.remarks;
    }
    
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    
    @Column(name="is_group_locked")
    @Field
    public Boolean getIsGroupLocked() {
        return this.isGroupLocked;
    }
    
    public void setIsGroupLocked(Boolean isGroupLocked) {
        this.isGroupLocked = isGroupLocked;
    }
    
    @Column(name="is_costing_locked")
    @Field
    public Boolean getIsCostingLocked() {
        return this.isCostingLocked;
    }
    
    public void setIsCostingLocked(Boolean isCostingLocked) {
        this.isCostingLocked = isCostingLocked;
    }
    
    @Column(name="row_material_value", precision=10, scale=0,columnDefinition="DECIMAL(10)")
    @Field
    public BigDecimal getRowMaterialValue() {
        return this.rowMaterialValue;
    }
    
    public void setRowMaterialValue(BigDecimal rowMaterialValue) {
        this.rowMaterialValue = rowMaterialValue;
    }
    
    @Column(name="service_value", precision=10, scale=0,columnDefinition="DECIMAL(10,4)")
    @Field
    public BigDecimal getServiceValue() {
        return this.serviceValue;
    }
    
    public void setServiceValue(BigDecimal serviceValue) {
        this.serviceValue = serviceValue;
    }
    
    @Column(name="cm", precision=10, scale=0,columnDefinition="DECIMAL(10,4)")
    @Field
    public BigDecimal getCm() {
        return this.cm;
    }
    
    public void setCm(BigDecimal cm) {
        this.cm = cm;
    }
    
    @Column(name="cmt", precision=10, scale=0,columnDefinition="DECIMAL(10,4)")
    @Field
    public BigDecimal getCmt() {
        return this.cmt;
    }
    
    public void setCmt(BigDecimal cmt) {
        this.cmt = cmt;
    }
    
    @Column(name="finance_cost", precision=10, scale=0,columnDefinition="DECIMAL(10,4)")
    @Field
    public BigDecimal getFinanceCost() {
        return this.financeCost;
    }
    
    public void setFinanceCost(BigDecimal financeCost) {
        this.financeCost = financeCost;
    }
    
    
    @Column(name="markup_amount", precision=10, scale=0,columnDefinition="DECIMAL(10,4)")
    @Field
    public BigDecimal getMarkupAmount() {
        return this.markupAmount;
    }
    
    public void setMarkupAmount(BigDecimal markupAmount) {
        this.markupAmount = markupAmount;
    }
    
    @Column(name="buyer_Commission", precision=10, scale=0,columnDefinition="DECIMAL(10,4)")
    @Field
    public BigDecimal getBuyerCommission() {
        return this.buyerCommission;
    }
    
    public void setBuyerCommission(BigDecimal buyerCommission) {
        this.buyerCommission = buyerCommission;
    }
    
    @Column(name="our_price", precision=10, scale=0,columnDefinition="DECIMAL(10,4)")
    @Field
    public BigDecimal getOurPrice() {
        return this.ourPrice;
    }
    
    public void setOurPrice(BigDecimal ourPrice) {
        this.ourPrice = ourPrice;
    }
    
    @Column(name="external_commission", precision=10, scale=0,columnDefinition="DECIMAL(10,4)")
    @Field
    public BigDecimal getExternalCommission() {
        return this.externalCommission;
    }
    
    public void setExternalCommission(BigDecimal externalCommission) {
        this.externalCommission = externalCommission;
    }
    
   

    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mercostsheetgroup other = (Mercostsheetgroup) obj;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (deliveryTerm == null) {
			if (other.deliveryTerm != null)
				return false;
		} else if (!deliveryTerm.equals(other.deliveryTerm))
			return false;
		if (groupName == null) {
			if (other.groupName != null)
				return false;
		} else if (!groupName.equals(other.groupName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isCostingLocked == null) {
			if (other.isCostingLocked != null)
				return false;
		} else if (!isCostingLocked.equals(other.isCostingLocked))
			return false;
		if (isGroupLocked == null) {
			if (other.isGroupLocked != null)
				return false;
		} else if (!isGroupLocked.equals(other.isGroupLocked))
			return false;
		if (remarks == null) {
			if (other.remarks != null)
				return false;
		} else if (!remarks.equals(other.remarks))
			return false;
		if (sellingPrice == null) {
			if (other.sellingPrice != null)
				return false;
		} else if (!sellingPrice.equals(other.sellingPrice))
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
		return true;
	}

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result
				+ ((deliveryTerm == null) ? 0 : deliveryTerm.hashCode());
		result = prime * result
				+ ((groupName == null) ? 0 : groupName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((isCostingLocked == null) ? 0 : isCostingLocked.hashCode());
		result = prime * result
				+ ((isGroupLocked == null) ? 0 : isGroupLocked.hashCode());
		result = prime * result + ((remarks == null) ? 0 : remarks.hashCode());
		result = prime * result
				+ ((sellingPrice == null) ? 0 : sellingPrice.hashCode());
		result = prime * result
				+ ((shipmentMode == null) ? 0 : shipmentMode.hashCode());
		result = prime * result
				+ ((totalCost == null) ? 0 : totalCost.hashCode());
		return result;
	}

    @Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Mercostsheetgroup [id=");
		builder.append(id);
		builder.append(", groupName=");
		builder.append(groupName);
		builder.append(", country=");
		builder.append(country);
		builder.append(", totalCost=");
		builder.append(totalCost);
		builder.append(", sellingPrice=");
		builder.append(sellingPrice);
		builder.append(", shipmentMode=");
		builder.append(shipmentMode);
		builder.append(", deliveryTerm=");
		builder.append(deliveryTerm);
		builder.append(", remarks=");
		builder.append(remarks);
		builder.append(", isGroupLocked=");
		builder.append(isGroupLocked);
		builder.append(", isCostingLocked=");
		builder.append(isCostingLocked);
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
		builder.append(", markupAmount=");
		builder.append(markupAmount);
		builder.append(", buyerCommission=");
		builder.append(buyerCommission);
		builder.append(", ourPrice=");
		builder.append(ourPrice);
		builder.append(", externalCommission=");
		builder.append(externalCommission);
		builder.append("]");
		return builder.toString();
	}

}
