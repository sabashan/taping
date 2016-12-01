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
@Table(name="mercostsheetrowmaterial")
@XmlRootElement
public class Mercostsheetrowmaterial extends BaseObject implements Serializable {
    /**
	 * 
	 */	
	private static final long serialVersionUID = 5614219809443770115L;
	private MercostsheetrowmaterialId id;
    private Mstsupplier mstsupplier;
    private Mstcurrency mstcurrency;
    private Mstitemtype mstitemtype;
    private String itemCode;
    private Mercostsheetgroup mercostsheetgroup;
    private String additionalAttribute1;
    private String additionalAttribute2;
    private String itemColor;
    private String itemWidth;
    private String itemDecription;
    private String itemCatogery;
    private String shipingType;
    private BigDecimal exchangeRate;
    private BigDecimal price;
    private BigDecimal finance;
    private Boolean isShellFabric;
    private Boolean isLocked;
    private BigDecimal consumption;
    private String uom;
    private BigDecimal allowance;
    
    public Mercostsheetrowmaterial() {
		super();
	}	

	public Mercostsheetrowmaterial(MercostsheetrowmaterialId id) {
		super();
		this.id = id;
	}

	public Mercostsheetrowmaterial(MercostsheetrowmaterialId id,
			Mstsupplier mstsupplier, Mstcurrency mstcurrency,
			Mstitemtype mstitemtype, String itemCode,
			Mercostsheetgroup mercostsheetgroup, String additionalAttribute1,
			String additionalAttribute2, String itemColor, String itemWidth,
			String itemDecription, String itemCatogery, String shipingType,
			BigDecimal exchangeRate, BigDecimal price, BigDecimal finance, Boolean isShellFabric,
			Boolean isLocked, BigDecimal consumption, String uom,
			BigDecimal allowance) {
		super();
		this.id = id;
		this.mstsupplier = mstsupplier;
		this.mstcurrency = mstcurrency;
		this.mstitemtype = mstitemtype;
		this.itemCode = itemCode;
		this.mercostsheetgroup = mercostsheetgroup;
		this.additionalAttribute1 = additionalAttribute1;
		this.additionalAttribute2 = additionalAttribute2;
		this.itemColor = itemColor;
		this.itemWidth = itemWidth;
		this.itemDecription = itemDecription;
		this.itemCatogery = itemCatogery;
		this.shipingType = shipingType;
		this.exchangeRate = exchangeRate;
		this.price = price;
		this.finance = finance;
		this.isShellFabric = isShellFabric;
		this.isLocked = isLocked;
		this.consumption = consumption;
		this.uom = uom;
		this.allowance = allowance;
	}



	@EmbeddedId @DocumentId    
    public MercostsheetrowmaterialId getId() {
        return this.id;
    }
    
    public void setId(MercostsheetrowmaterialId id) {
        this.id = id;
    }

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumns( { 
        @JoinColumn(name="supp_code", referencedColumnName="comp_code"), 
        @JoinColumn(name="supp_comp_code", referencedColumnName="supp_code") } )
    public Mstsupplier getMstsupplier() {
        return this.mstsupplier;
    }
    
    public void setMstsupplier(Mstsupplier mstsupplier) {
        this.mstsupplier = mstsupplier;
    }

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="currency")
    public Mstcurrency getMstcurrency() {
        return this.mstcurrency;
    }
    
    public void setMstcurrency(Mstcurrency mstcurrency) {
        this.mstcurrency = mstcurrency;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumns( { 
        @JoinColumn(name="item_type", referencedColumnName="item_type", nullable=false) 
       } )
    public Mstitemtype getMstitemtype() {
		return mstitemtype;
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
        @JoinColumn(name="group_id", referencedColumnName="group_id", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="cost_sheet_no", referencedColumnName="cost_sheet_no", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="version_no", referencedColumnName="version_no", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="cost_sheet_type", referencedColumnName="cost_sheet_type", nullable=false, insertable=false, updatable=false) } )
	  @JsonIgnore
    public Mercostsheetgroup getMercostsheetgroup() {
        return this.mercostsheetgroup;
    }
    
    public void setMercostsheetgroup(Mercostsheetgroup mercostsheetgroup) {
        this.mercostsheetgroup = mercostsheetgroup;
    }

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
    @Column(name="item_decription", length=100 ,columnDefinition="CHAR(100)")
    @Field
    public String getItemDecription() {
        return this.itemDecription;
    }
    
    public void setItemDecription(String itemDecription) {
        this.itemDecription = itemDecription;
    }
    @Column(name="item_catogery", length=4 ,columnDefinition="CHAR(10)")
    @Field
    public String getItemCatogery() {
        return this.itemCatogery;
    }
    
    public void setItemCatogery(String itemCatogery) {
        this.itemCatogery = itemCatogery;
    }
    @Column(name="shiping_type", length=7, columnDefinition="CHAR(7)")
    @Field
    public String getShipingType() {
        return this.shipingType;
    }
    
    public void setShipingType(String shipingType) {
        this.shipingType = shipingType;
    }

    @Column(name="exchange_rate", precision=10, scale=0, columnDefinition="DECIMAL(10,0)")
    @Field
    public BigDecimal getExchangeRate() {
        return this.exchangeRate;
    }
    
    public void setExchangeRate(BigDecimal exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    @Column(name="price", precision=10, scale=0, columnDefinition="DECIMAL(10,0)")
    @Field
    public BigDecimal getPrice() {
        return this.price;
    }
    
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Column(name="finance", precision=10, scale=0, columnDefinition="DECIMAL(10,0)")
    @Field
    public BigDecimal getFinance() {
        return this.finance;
    }
    
    public void setFinance(BigDecimal finance) {
        this.finance = finance;
    }
    
    @Column(name="is_shell_fabric")
    @Field
    public Boolean getIsShellFabric() {
        return this.isShellFabric;
    }
    
    public void setIsShellFabric(Boolean isShellFabric) {
        this.isShellFabric = isShellFabric;
    }
    
    @Column(name="is_locked")
    @Field
    public Boolean getIsLocked() {
        return this.isLocked;
    }
    
    public void setIsLocked(Boolean isLocked) {
        this.isLocked = isLocked;
    }
    @Column(name="consumption", precision=10, scale=0 ,columnDefinition="DECIMAL(10)")
    @Field
    public BigDecimal getConsumption() {
        return this.consumption;
    }
    
    public void setConsumption(BigDecimal consumption) {
        this.consumption = consumption;
    }
    
    @Column(name="uom", precision=10, scale=0 ,columnDefinition="CHAR(10)")
    @Field
    public String getUom() {
        return this.uom;
    }
    
    public void setUom(String uom) {
        this.uom = uom;
    }
    
    @Column(name="allowance", precision=10, scale=0  ,columnDefinition="DECIMAL(10)")
    @Field
	public BigDecimal getAllowance() {
		return allowance;
	}
	public void setAllowance(BigDecimal allowance) {
		this.allowance = allowance;
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
		result = prime * result
				+ ((allowance == null) ? 0 : allowance.hashCode());
		result = prime * result
				+ ((consumption == null) ? 0 : consumption.hashCode());
		result = prime * result
				+ ((exchangeRate == null) ? 0 : exchangeRate.hashCode());
		result = prime * result + ((finance == null) ? 0 : finance.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((isLocked == null) ? 0 : isLocked.hashCode());
		result = prime * result
				+ ((isShellFabric == null) ? 0 : isShellFabric.hashCode());
		result = prime * result
				+ ((itemCatogery == null) ? 0 : itemCatogery.hashCode());
		result = prime * result
				+ ((itemColor == null) ? 0 : itemColor.hashCode());
		result = prime * result
				+ ((itemDecription == null) ? 0 : itemDecription.hashCode());
		result = prime * result
				+ ((itemWidth == null) ? 0 : itemWidth.hashCode());
		result = prime
				* result
				+ ((mercostsheetgroup == null) ? 0 : mercostsheetgroup
						.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result
				+ ((shipingType == null) ? 0 : shipingType.hashCode());
		result = prime * result + ((uom == null) ? 0 : uom.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mercostsheetrowmaterial other = (Mercostsheetrowmaterial) obj;
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
		if (allowance == null) {
			if (other.allowance != null)
				return false;
		} else if (!allowance.equals(other.allowance))
			return false;
		if (consumption == null) {
			if (other.consumption != null)
				return false;
		} else if (!consumption.equals(other.consumption))
			return false;
		if (exchangeRate == null) {
			if (other.exchangeRate != null)
				return false;
		} else if (!exchangeRate.equals(other.exchangeRate))
			return false;
		if (finance == null) {
			if (other.finance != null)
				return false;
		} else if (!finance.equals(other.finance))
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
		if (isShellFabric == null) {
			if (other.isShellFabric != null)
				return false;
		} else if (!isShellFabric.equals(other.isShellFabric))
			return false;
		if (itemCatogery == null) {
			if (other.itemCatogery != null)
				return false;
		} else if (!itemCatogery.equals(other.itemCatogery))
			return false;
		if (itemColor == null) {
			if (other.itemColor != null)
				return false;
		} else if (!itemColor.equals(other.itemColor))
			return false;
		if (itemDecription == null) {
			if (other.itemDecription != null)
				return false;
		} else if (!itemDecription.equals(other.itemDecription))
			return false;
		if (itemWidth == null) {
			if (other.itemWidth != null)
				return false;
		} else if (!itemWidth.equals(other.itemWidth))
			return false;
		if (mercostsheetgroup == null) {
			if (other.mercostsheetgroup != null)
				return false;
		} else if (!mercostsheetgroup.equals(other.mercostsheetgroup))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (shipingType == null) {
			if (other.shipingType != null)
				return false;
		} else if (!shipingType.equals(other.shipingType))
			return false;
		if (uom == null) {
			if (other.uom != null)
				return false;
		} else if (!uom.equals(other.uom))
			return false;
		return true;
	}

    @Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Mercostsheetrowmaterial [id=");
		builder.append(id);
		builder.append(", additionalAttribute1=");
		builder.append(additionalAttribute1);
		builder.append(", additionalAttribute2=");
		builder.append(additionalAttribute2);
		builder.append(", itemColor=");
		builder.append(itemColor);
		builder.append(", itemWidth=");
		builder.append(itemWidth);
		builder.append(", itemDecription=");
		builder.append(itemDecription);
		builder.append(", itemCatogery=");
		builder.append(itemCatogery);
		builder.append(", shipingType=");
		builder.append(shipingType);
		builder.append(", exchangeRate=");
		builder.append(exchangeRate);
		builder.append(", price=");
		builder.append(price);
		builder.append(", finance=");
		builder.append(finance);
		builder.append(", isShellFabric=");
		builder.append(isShellFabric);
		builder.append(", isLocked=");
		builder.append(isLocked);
		builder.append(", consumption=");
		builder.append(consumption);
		builder.append(", uom=");
		builder.append(uom);
		builder.append(", allowance=");
		builder.append(allowance);
		builder.append("]");
		return builder.toString();
	}

}
