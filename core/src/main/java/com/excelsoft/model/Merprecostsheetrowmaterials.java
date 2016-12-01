package com.excelsoft.model;

import com.excelsoft.model.BaseObject;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name="merprecostsheetrowmaterials")
@XmlRootElement
public class Merprecostsheetrowmaterials extends BaseObject implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -7111913476818028904L;
	private MerprecostsheetrowmaterialsId id;
    private Merprecostsheet merprecostsheet;
    private Mstitem mstitem;
    private String itemDecription;
    private String itemColor;
    private String itemWidth;
    private String shipingType;
    private String supplierCode;
    private String supplierCompCode;
    private String currency;
    private BigDecimal exchangeRate;
    private BigDecimal price;
    private BigDecimal finance;
    private Boolean isshellfabric;
    private String itemCatogery;
    private BigDecimal consumption;
    private String uom;
    private BigDecimal allowance;

    public Merprecostsheetrowmaterials() {

	}
    public Merprecostsheetrowmaterials(MerprecostsheetrowmaterialsId id) {
		super();
		this.id = id;
	}
	@EmbeddedId @DocumentId    
    public MerprecostsheetrowmaterialsId getId() {
        return this.id;
    }
    
    public void setId(MerprecostsheetrowmaterialsId id) {
        this.id = id;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumns( { 
        @JoinColumn(name="pre_cost_sheet_no", referencedColumnName="pre_cost_sheet_no", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="version_no", referencedColumnName="version_no", nullable=false, insertable=false, updatable=false) ,
        @JoinColumn(name="costsheet_type", referencedColumnName="costsheet_type", nullable=false, insertable=false, updatable=false)} )
    @JsonIgnore
public Merprecostsheet getMerprecostsheet() {
        return this.merprecostsheet;
    }
    
    public void setMerprecostsheet(Merprecostsheet merprecostsheet) {
        this.merprecostsheet = merprecostsheet;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumns( { 
        @JoinColumn(name="item_type", referencedColumnName="item_type", nullable=true), 
        @JoinColumn(name="item_code", referencedColumnName="item_code", nullable=true) } )
    public Mstitem getMstitem() {
        return this.mstitem;
    }
    
    public void setMstitem(Mstitem mstitem) {
        this.mstitem = mstitem;
    }
    
    @Column(name="item_decription", length=100 ,columnDefinition="CHAR(100)")
    @Field
    public String getItemDecription() {
        return this.itemDecription;
    }
    
    public void setItemDecription(String itemDecription) {
        this.itemDecription = itemDecription;
    }
    
    @Column(name="item_color", length=10 ,columnDefinition="CHAR(10)")
    @Field
    public String getItemColor() {
        return this.itemColor;
    }
    
    public void setItemColor(String itemColor) {
        this.itemColor = itemColor;
    }
    
    @Column(name="item_width", length=10 ,columnDefinition="CHAR(10)")
    @Field
    public String getItemWidth() {
        return this.itemWidth;
    }
    
    public void setItemWidth(String itemWidth) {
        this.itemWidth = itemWidth;
    }
    
    @Column(name="shiping_type", length=7 ,columnDefinition="CHAR(7)")
    @Field
    public String getShipingType() {
        return this.shipingType;
    }
    
    public void setShipingType(String shipingType) {
        this.shipingType = shipingType;
    }
    
    @Column(name="supplier_code", length=10 ,columnDefinition="CHAR(10)")
    @Field
    public String getSupplierCode() {
        return this.supplierCode;
    }
    
    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }
    
    @Column(name="supplier_comp_code", length=6 ,columnDefinition="CHAR(6)")
    @Field
    public String getSupplierCompCode() {
        return this.supplierCompCode;
    }
    
    public void setSupplierCompCode(String supplierCompCode) {
        this.supplierCompCode = supplierCompCode;
    }
    
    @Column(name="currency", length=4 ,columnDefinition="CHAR(4)")
    @Field
    public String getCurrency() {
        return this.currency;
    }
    
    public void setCurrency(String currency) {
        this.currency = currency;
    }
    
    @Column(name="exchange_rate", precision=10, scale=0 ,columnDefinition="DECIMAL(10)")
    @Field
    public BigDecimal getExchangeRate() {
        return this.exchangeRate;
    }
    
    public void setExchangeRate(BigDecimal exchangeRate) {
        this.exchangeRate = exchangeRate;
    }
    
    @Column(name="price", precision=10, scale=0 ,columnDefinition="DECIMAL(10)")
    @Field
    public BigDecimal getPrice() {
        return this.price;
    }
    
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    
    @Column(name="finance", precision=10, scale=0 ,columnDefinition="DECIMAL(10)")
    @Field
    public BigDecimal getFinance() {
        return this.finance;
    }
    
    public void setFinance(BigDecimal finance) {
        this.finance = finance;
    }
    
    @Column(name="isshellfabric")
    @Field
    public Boolean getIsshellfabric() {
        return this.isshellfabric;
    }
    
    public void setIsshellfabric(Boolean isshellfabric) {
        this.isshellfabric = isshellfabric;
    }
    
    @Column(name="item_catogery", length=4 ,columnDefinition="CHAR(10)")
    @Field
    public String getItemCatogery() {
        return this.itemCatogery;
    }
    
    public void setItemCatogery(String itemCatogery) {
        this.itemCatogery = itemCatogery;
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
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Merprecostsheetrowmaterials other = (Merprecostsheetrowmaterials) obj;
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
		if (currency == null) {
			if (other.currency != null)
				return false;
		} else if (!currency.equals(other.currency))
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
		if (isshellfabric == null) {
			if (other.isshellfabric != null)
				return false;
		} else if (!isshellfabric.equals(other.isshellfabric))
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
		if (supplierCode == null) {
			if (other.supplierCode != null)
				return false;
		} else if (!supplierCode.equals(other.supplierCode))
			return false;
		if (supplierCompCode == null) {
			if (other.supplierCompCode != null)
				return false;
		} else if (!supplierCompCode.equals(other.supplierCompCode))
			return false;
		if (uom == null) {
			if (other.uom != null)
				return false;
		} else if (!uom.equals(other.uom))
			return false;
		return true;
	}

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((allowance == null) ? 0 : allowance.hashCode());
		result = prime * result
				+ ((consumption == null) ? 0 : consumption.hashCode());
		result = prime * result
				+ ((currency == null) ? 0 : currency.hashCode());
		result = prime * result
				+ ((exchangeRate == null) ? 0 : exchangeRate.hashCode());
		result = prime * result + ((finance == null) ? 0 : finance.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((isshellfabric == null) ? 0 : isshellfabric.hashCode());
		result = prime * result
				+ ((itemCatogery == null) ? 0 : itemCatogery.hashCode());
		result = prime * result
				+ ((itemColor == null) ? 0 : itemColor.hashCode());
		result = prime * result
				+ ((itemDecription == null) ? 0 : itemDecription.hashCode());
		result = prime * result
				+ ((itemWidth == null) ? 0 : itemWidth.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result
				+ ((shipingType == null) ? 0 : shipingType.hashCode());
		result = prime * result
				+ ((supplierCode == null) ? 0 : supplierCode.hashCode());
		result = prime
				* result
				+ ((supplierCompCode == null) ? 0 : supplierCompCode.hashCode());
		result = prime * result + ((uom == null) ? 0 : uom.hashCode());
		return result;
	}

    @Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Merprecostsheetrowmaterials [id=");
		builder.append(id);
		builder.append(", itemDecription=");
		builder.append(itemDecription);
		builder.append(", itemColor=");
		builder.append(itemColor);
		builder.append(", itemWidth=");
		builder.append(itemWidth);
		builder.append(", shipingType=");
		builder.append(shipingType);
		builder.append(", supplierCode=");
		builder.append(supplierCode);
		builder.append(", supplierCompCode=");
		builder.append(supplierCompCode);
		builder.append(", currency=");
		builder.append(currency);
		builder.append(", exchangeRate=");
		builder.append(exchangeRate);
		builder.append(", price=");
		builder.append(price);
		builder.append(", finance=");
		builder.append(finance);
		builder.append(", isshellfabric=");
		builder.append(isshellfabric);
		builder.append(", itemCatogery=");
		builder.append(itemCatogery);
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

