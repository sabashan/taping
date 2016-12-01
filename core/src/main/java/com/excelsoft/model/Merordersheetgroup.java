package com.excelsoft.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;

@Entity
@Table(name="merordersheetgroup")
@XmlRootElement
public class Merordersheetgroup extends BaseObject implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MerordersheetgroupId id;
    private Merordersheetgroupsetting merordersheetgroupsetting;
    private String groupName;
    private String country;
    private Long totalCost;
    private Long sellingPrice;
    private String baseBody;
    private String buyerReference;
    private String shipmentMode;
    private String deliveryTerm;
    private String remarks;
    private Boolean isGroupLocked;
    private Boolean isCostingLocked;
    //private Set<Merordersheetgroupbom> merordersheetgroupboms = new HashSet<Merordersheetgroupbom>(0);
    
    public Merordersheetgroup() {
		super();
	}
    
    public Merordersheetgroup(MerordersheetgroupId id,
			Merordersheetgroupsetting merordersheetgroupsetting,
			String groupName, String country, Long totalCost,
			Long sellingPrice, String baseBody, String buyerReference,
			String shipmentMode, String deliveryTerm, String remarks,
			Boolean isGroupLocked, Boolean isCostingLocked) {
		super();
		this.id = id;
		this.merordersheetgroupsetting = merordersheetgroupsetting;
		this.groupName = groupName;
		this.country = country;
		this.totalCost = totalCost;
		this.sellingPrice = sellingPrice;
		this.baseBody = baseBody;
		this.buyerReference = buyerReference;
		this.shipmentMode = shipmentMode;
		this.deliveryTerm = deliveryTerm;
		this.remarks = remarks;
		this.isGroupLocked = isGroupLocked;
		this.isCostingLocked = isCostingLocked;
	}
    
    public Merordersheetgroup(MerordersheetgroupId id) {
		super();
		this.id = id;
	}

	@EmbeddedId @DocumentId    
    public MerordersheetgroupId getId() {
        return this.id;
    }
    
    

	public void setId(MerordersheetgroupId id) {
        this.id = id;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumns( { 
        @JoinColumn(name="group_setting_id", referencedColumnName="group_setting_id", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="ordersheet_id", referencedColumnName="ordersheet_id", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="planing_ordersheet_no", referencedColumnName="planing_ordersheet_no", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="order_type", referencedColumnName="order_type", nullable=false, insertable=false, updatable=false) } )
    public Merordersheetgroupsetting getMerordersheetgroupsetting() {
        return this.merordersheetgroupsetting;
    }
    
    public void setMerordersheetgroupsetting(Merordersheetgroupsetting merordersheetgroupsetting) {
        this.merordersheetgroupsetting = merordersheetgroupsetting;
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
    
    @Column(name="total_cost", precision=10, scale=0, columnDefinition="DECIMAL(10.0)")
    @Field
    public Long getTotalCost() {
        return this.totalCost;
    }
    
    public void setTotalCost(Long totalCost) {
        this.totalCost = totalCost;
    }
    
    @Column(name="selling_price", precision=10, scale=0, columnDefinition="DECIMAL(10.0)")
    @Field
    public Long getSellingPrice() {
        return this.sellingPrice;
    }
    
    public void setSellingPrice(Long sellingPrice) {
        this.sellingPrice = sellingPrice;
    }
    
    @Column(name="base_body", length=10, columnDefinition="CHAR(10)")
    @Field
    public String getBaseBody() {
        return this.baseBody;
    }
    
    public void setBaseBody(String baseBody) {
        this.baseBody = baseBody;
    }
    
    @Column(name="buyer_reference", columnDefinition="CHAR(255)")
    @Field
    public String getBuyerReference() {
        return this.buyerReference;
    }
    
    public void setBuyerReference(String buyerReference) {
        this.buyerReference = buyerReference;
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
    
    @Column(name="remarks", columnDefinition="CHAR(255)")
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
/*@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="merordersheetgroup")
    public Set<Merordersheetgroupbom> getMerordersheetgroupboms() {
        return this.merordersheetgroupboms;
    }
    
    public void setMerordersheetgroupboms(Set<Merordersheetgroupbom> merordersheetgroupboms) {
        this.merordersheetgroupboms = merordersheetgroupboms;
    }*/

    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Merordersheetgroup other = (Merordersheetgroup) obj;
		if (baseBody == null) {
			if (other.baseBody != null)
				return false;
		} else if (!baseBody.equals(other.baseBody))
			return false;
		if (buyerReference == null) {
			if (other.buyerReference != null)
				return false;
		} else if (!buyerReference.equals(other.buyerReference))
			return false;
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
		result = prime * result
				+ ((baseBody == null) ? 0 : baseBody.hashCode());
		result = prime * result
				+ ((buyerReference == null) ? 0 : buyerReference.hashCode());
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
		return "Merordersheetgroup [id=" + id + ", groupName=" + groupName
				+ ", country=" + country + ", totalCost=" + totalCost
				+ ", sellingPrice=" + sellingPrice + ", baseBody=" + baseBody
				+ ", buyerReference=" + buyerReference + ", shipmentMode="
				+ shipmentMode + ", deliveryTerm=" + deliveryTerm
				+ ", remarks=" + remarks + ", isGroupLocked=" + isGroupLocked
				+ ", isCostingLocked=" + isCostingLocked + "]";
	}

}
