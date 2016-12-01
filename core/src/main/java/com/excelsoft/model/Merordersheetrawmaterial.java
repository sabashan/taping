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

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;

@Entity
@Table(name="merordersheetrawmaterial")
@XmlRootElement
public class Merordersheetrawmaterial extends BaseObject implements Serializable {
   
	/**
	 * 
	 */
	private static final long serialVersionUID = -7840989602074064950L;
	
	private MerordersheetrawmaterialId id;
    private Mstitemtype mstitemtype;
    private Merordersheethdr merordersheethdr;
   // private Mstcurrency mstcurrency;
    //private Mstsupplier mstsupplier;
    private Boolean isRelease;
    private String additionalAttribute1;
    private String additionalAttribute2;
    private String itemColor;
    private String itemWidth;
    private String itemDescription;
   // private String shipingType;
    //private Long exchangeRate;
   // private Long price;
   // private Long finance;
   // private Boolean isShellFabric;
    private Boolean isLocked;
   // private String bomPlacement;
   // private BigDecimal itemConsumtion;
  ///  private String unit;
    private String itemCode;
    //private BigDecimal allowPrecent;
   // private Character sizeWiseIndent;
    
    

    public Merordersheetrawmaterial() {
		super();
	}
    
	public Merordersheetrawmaterial(MerordersheetrawmaterialId id,
			Mstitemtype mstitemtype, Merordersheethdr merordersheethdr,
			Boolean isRelease, String additionalAttribute1,
			String additionalAttribute2, String itemColor, String itemWidth,
			String itemDescription, Boolean isLocked, String itemCode) {
		super();
		this.id = id;
		this.mstitemtype = mstitemtype;
		this.merordersheethdr = merordersheethdr;
		this.isRelease = isRelease;
		this.additionalAttribute1 = additionalAttribute1;
		this.additionalAttribute2 = additionalAttribute2;
		this.itemColor = itemColor;
		this.itemWidth = itemWidth;
		this.itemDescription = itemDescription;
		this.isLocked = isLocked;
		this.itemCode = itemCode;
	}

	@EmbeddedId @DocumentId    
    public MerordersheetrawmaterialId getId() {
        return this.id;
    }
    
    public void setId(MerordersheetrawmaterialId id) {
        this.id = id;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="item_type", nullable=false)
    public Mstitemtype getMstitemtype() {
        return this.mstitemtype;
    }
    
    public void setMstitemtype(Mstitemtype mstitemtype) {
        this.mstitemtype = mstitemtype;
    }
    
    @Column(name="item_code", length=30, columnDefinition="CHAR(30)")
	@Field
	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumns( { 
        @JoinColumn(name="order_type", referencedColumnName="order_type", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="planing_ordersheet_no", referencedColumnName="planing_ordersheet_no", nullable=false, insertable=false, updatable=false) } )
   @JsonIgnore
public Merordersheethdr getMerordersheethdr() {
        return this.merordersheethdr;
    }
    
    public void setMerordersheethdr(Merordersheethdr merordersheethdr) {
        this.merordersheethdr = merordersheethdr;
    }
/*@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="currency")
    public Mstcurrency getMstcurrency() {
        return this.mstcurrency;
    }
    
    public void setMstcurrency(Mstcurrency mstcurrency) {
        this.mstcurrency = mstcurrency;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumns( { 
        @JoinColumn(name="supp_comp_code", referencedColumnName="comp_code"), 
        @JoinColumn(name="supp_code", referencedColumnName="supp_code") } )
    public Mstsupplier getMstsupplier() {
        return this.mstsupplier;
    }
    
    public void setMstsupplier(Mstsupplier mstsupplier) {
        this.mstsupplier = mstsupplier;
    }*/
    
    @Column(name="additional_attribute1", length=45, columnDefinition="CHAR(45)")
    @Field
    public String getAdditionalAttribute1() {
        return this.additionalAttribute1;
    }
    
    public void setAdditionalAttribute1(String additionalAttribute1) {
        this.additionalAttribute1 = additionalAttribute1;
    }
    
    @Column(name="additional_attribute2", length=45, columnDefinition="CHAR(45)")
    @Field
    public String getAdditionalAttribute2() {
        return this.additionalAttribute2;
    }
    
    public void setAdditionalAttribute2(String additionalAttribute2) {
        this.additionalAttribute2 = additionalAttribute2;
    }
    
    @Column(name="item_color", length=10, columnDefinition="CHAR(10)")
    @Field
    public String getItemColor() {
        return this.itemColor;
    }
    
    public void setItemColor(String itemColor) {
        this.itemColor = itemColor;
    }
    
    @Column(name="item_width", length=10, columnDefinition="CHAR(10)")
    @Field
    public String getItemWidth() {
        return this.itemWidth;
    }
    
    public void setItemWidth(String itemWidth) {
        this.itemWidth = itemWidth;
    }
    
   /* @Column(name="shiping_type", length=10, columnDefinition="CHAR(10)")
    @Field
    public String getShipingType() {
        return this.shipingType;
    }
    
    public void setShipingType(String shipingType) {
        this.shipingType = shipingType;
    }
    
    @Column(name="exchange_rate", precision=10, scale=0, columnDefinition="DECIMAL(10.0)")
    @Field
    public Long getExchangeRate() {
        return this.exchangeRate;
    }
    
    public void setExchangeRate(Long exchangeRate) {
        this.exchangeRate = exchangeRate;
    }
    
    @Column(name="price", precision=10, scale=0, columnDefinition="DECIMAL(10.0)")
    @Field
    public Long getPrice() {
        return this.price;
    }
    
    public void setPrice(Long price) {
        this.price = price;
    }
    
    @Column(name="finance", precision=10, scale=0,columnDefinition="DECIMAL(10.0)" )
    @Field
    public Long getFinance() {
        return this.finance;
    }
    
    public void setFinance(Long finance) {
        this.finance = finance;
    }
    
    @Column(name="is_shell_fabric")
    @Field
    public Boolean getIsShellFabric() {
        return this.isShellFabric;
    }
    
    public void setIsShellFabric(Boolean isShellFabric) {
        this.isShellFabric = isShellFabric;
    }*/
    
    @Column(name="is_locked")
    @Field
    public Boolean getIsLocked() {
        return this.isLocked;
    }
    
    public void setIsLocked(Boolean isLocked) {
        this.isLocked = isLocked;
    }
    
    
    @Column(name="isrelease")
    @Field
	public Boolean getIsRelease() {
		return isRelease;
	}

	public void setIsRelease(Boolean isRelease) {
		this.isRelease = isRelease;
	}

	@Column(name="item_description" , length=200, columnDefinition="CHAR(200)")
    @Field
	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}


@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Merordersheetrawmaterial other = (Merordersheetrawmaterial) obj;
	if (additionalAttribute1 == null) {
		if (other.additionalAttribute1 != null)
			return false;
	} else if (!additionalAttribute1.equals(other.additionalAttribute1))
		return false;
	if (additionalAttribute2 == null) {
		if (other.additionalAttribute2 != null)
			return false;
	} else if (!additionalAttribute2.equals(other.additionalAttribute2))
		return false;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	if (isLocked == null) {
		if (other.isLocked != null)
			return false;
	} else if (!isLocked.equals(other.isLocked))
		return false;
	if (isRelease == null) {
		if (other.isRelease != null)
			return false;
	} else if (!isRelease.equals(other.isRelease))
		return false;
	if (itemCode == null) {
		if (other.itemCode != null)
			return false;
	} else if (!itemCode.equals(other.itemCode))
		return false;
	if (itemColor == null) {
		if (other.itemColor != null)
			return false;
	} else if (!itemColor.equals(other.itemColor))
		return false;
	if (itemDescription == null) {
		if (other.itemDescription != null)
			return false;
	} else if (!itemDescription.equals(other.itemDescription))
		return false;
	if (itemWidth == null) {
		if (other.itemWidth != null)
			return false;
	} else if (!itemWidth.equals(other.itemWidth))
		return false;
	return true;
}

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((additionalAttribute1 == null) ? 0 : additionalAttribute1
						.hashCode());
		result = prime
				* result
				+ ((additionalAttribute2 == null) ? 0 : additionalAttribute2
						.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((isLocked == null) ? 0 : isLocked.hashCode());
		result = prime * result
				+ ((isRelease == null) ? 0 : isRelease.hashCode());
		result = prime * result
				+ ((itemCode == null) ? 0 : itemCode.hashCode());
		result = prime * result
				+ ((itemColor == null) ? 0 : itemColor.hashCode());
		result = prime * result
				+ ((itemDescription == null) ? 0 : itemDescription.hashCode());
		result = prime * result
				+ ((itemWidth == null) ? 0 : itemWidth.hashCode());
		return result;
	}

    @Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Merordersheetrawmaterial [id=");
		builder.append(id);
		builder.append(", isRelease=");
		builder.append(isRelease);
		builder.append(", additionalAttribute1=");
		builder.append(additionalAttribute1);
		builder.append(", additionalAttribute2=");
		builder.append(additionalAttribute2);
		builder.append(", itemColor=");
		builder.append(itemColor);
		builder.append(", itemWidth=");
		builder.append(itemWidth);
		builder.append(", itemDescription=");
		builder.append(itemDescription);
		builder.append(", isLocked=");
		builder.append(isLocked);
		builder.append(", itemCode=");
		builder.append(itemCode);
		builder.append("]");
		return builder.toString();
	}

}
