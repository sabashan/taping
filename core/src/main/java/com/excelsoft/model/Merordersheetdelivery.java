package com.excelsoft.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;

@Entity
@Table(name="merordersheetdelivery")
@XmlRootElement
public class Merordersheetdelivery extends BaseObject implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MerordersheetdeliveryId id;
    private Merordersheetorder merordersheetorder;
    private String deliveryQuantity;
    private Date deliveryDate;
    private String country;
    private BigDecimal maxAllow;
    private BigDecimal minAllow;
    private String port;
    private String paymentType;
    private String deliveryTerm;
    private String shippingMode;
    private String agentCode;
    private String currencyCode;
    private BigDecimal exchangeRate;
    private String merchandisor;
    
    

    public Merordersheetdelivery() {
		super();
	}

    
    
	public Merordersheetdelivery(MerordersheetdeliveryId id,
			Merordersheetorder merordersheetorder, String deliveryQuantity,
			Date deliveryDate, String country, BigDecimal maxAllow,
			BigDecimal minAllow, String port, String paymentType,
			String deliveryTerm, String shippingMode, String agentCode,
			String currencyCode, BigDecimal exchangeRate, String merchandisor) {
		super();
		this.id = id;
		this.merordersheetorder = merordersheetorder;
		this.deliveryQuantity = deliveryQuantity;
		this.deliveryDate = deliveryDate;
		this.country = country;
		this.maxAllow = maxAllow;
		this.minAllow = minAllow;
		this.port = port;
		this.paymentType = paymentType;
		this.deliveryTerm = deliveryTerm;
		this.shippingMode = shippingMode;
		this.agentCode = agentCode;
		this.currencyCode = currencyCode;
		this.exchangeRate = exchangeRate;
		this.merchandisor = merchandisor;
	}


	

	public Merordersheetdelivery(MerordersheetdeliveryId id) {
		super();
		this.id = id;
	}



	@EmbeddedId @DocumentId    
    public MerordersheetdeliveryId getId() {
        return this.id;
    }
    
    public void setId(MerordersheetdeliveryId id) {
        this.id = id;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumns( { 
        @JoinColumn(name="ordersheet_id", referencedColumnName="ordersheet_id", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="planing_ordersheet_no", referencedColumnName="planing_ordersheet_no", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="order_type", referencedColumnName="order_type", nullable=false, insertable=false, updatable=false) } )
    public Merordersheetorder getMerordersheetorder() {
        return this.merordersheetorder;
    }
    
    public void setMerordersheetorder(Merordersheetorder merordersheetorder) {
        this.merordersheetorder = merordersheetorder;
    }
    
    @Column(name="delivery_quantity", length=2, columnDefinition="CHAR(2)")
    @Field
    public String getDeliveryQuantity() {
        return this.deliveryQuantity;
    }
    
    public void setDeliveryQuantity(String deliveryQuantity) {
        this.deliveryQuantity = deliveryQuantity;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="delivery_date", length=10)
    @Field
    public Date getDeliveryDate() {
        return this.deliveryDate;
    }
    
    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
    
    @Column(name="country", length=10, columnDefinition="CHAR(10)")
    @Field
    public String getCountry() {
        return this.country;
    }
    
    public void setCountry(String country) {
        this.country = country;
    }
    
    @Column(name="max_allow", precision=9, scale=6, columnDefinition="DECIMAL(9.6)")
    @Field
    public BigDecimal getMaxAllow() {
        return this.maxAllow;
    }
    
    public void setMaxAllow(BigDecimal maxAllow) {
        this.maxAllow = maxAllow;
    }
    
    @Column(name="min_allow", precision=9, scale=6, columnDefinition="DECIMAL(9.6)")
    @Field
    public BigDecimal getMinAllow() {
        return this.minAllow;
    }
    
    public void setMinAllow(BigDecimal minAllow) {
        this.minAllow = minAllow;
    }
    
    @Column(name="port", length=16, columnDefinition="CHAR(16)")
    @Field
    public String getPort() {
        return this.port;
    }
    
    public void setPort(String port) {
        this.port = port;
    }
    
    @Column(name="payment_type", length=10, columnDefinition="CHAR(10)")
    @Field
    public String getPaymentType() {
        return this.paymentType;
    }
    
    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }
    
    @Column(name="delivery_term", length=10, columnDefinition="CHAR(10)")
    @Field
    public String getDeliveryTerm() {
        return this.deliveryTerm;
    }
    
    public void setDeliveryTerm(String deliveryTerm) {
        this.deliveryTerm = deliveryTerm;
    }
    
    @Column(name="shipping_mode", length=10, columnDefinition="CHAR(10)")
    @Field
    public String getShippingMode() {
        return this.shippingMode;
    }
    
    public void setShippingMode(String shippingMode) {
        this.shippingMode = shippingMode;
    }
    
    @Column(name="agent_code", length=10, columnDefinition="CHAR(10)")
    @Field
    public String getAgentCode() {
        return this.agentCode;
    }
    
    public void setAgentCode(String agentCode) {
        this.agentCode = agentCode;
    }
    
    @Column(name="currency_code", length=4, columnDefinition="CHAR(4)")
    @Field
    public String getCurrencyCode() {
        return this.currencyCode;
    }
    
    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }
    
    @Column(name="exchange_rate", precision=20, scale=6, columnDefinition="DECIMAL(20.6)")
    @Field
    public BigDecimal getExchangeRate() {
        return this.exchangeRate;
    }
    
    public void setExchangeRate(BigDecimal exchangeRate) {
        this.exchangeRate = exchangeRate;
    }
    
    @Column(name="merchandisor", length=10, columnDefinition="CHAR(10)")
    @Field
    public String getMerchandisor() {
        return this.merchandisor;
    }
    
    public void setMerchandisor(String merchandisor) {
        this.merchandisor = merchandisor;
    }

    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Merordersheetdelivery other = (Merordersheetdelivery) obj;
		if (agentCode == null) {
			if (other.agentCode != null)
				return false;
		} else if (!agentCode.equals(other.agentCode))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (currencyCode == null) {
			if (other.currencyCode != null)
				return false;
		} else if (!currencyCode.equals(other.currencyCode))
			return false;
		if (deliveryDate == null) {
			if (other.deliveryDate != null)
				return false;
		} else if (!deliveryDate.equals(other.deliveryDate))
			return false;
		if (deliveryQuantity == null) {
			if (other.deliveryQuantity != null)
				return false;
		} else if (!deliveryQuantity.equals(other.deliveryQuantity))
			return false;
		if (deliveryTerm == null) {
			if (other.deliveryTerm != null)
				return false;
		} else if (!deliveryTerm.equals(other.deliveryTerm))
			return false;
		if (exchangeRate == null) {
			if (other.exchangeRate != null)
				return false;
		} else if (!exchangeRate.equals(other.exchangeRate))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (maxAllow == null) {
			if (other.maxAllow != null)
				return false;
		} else if (!maxAllow.equals(other.maxAllow))
			return false;
		if (merchandisor == null) {
			if (other.merchandisor != null)
				return false;
		} else if (!merchandisor.equals(other.merchandisor))
			return false;
		if (minAllow == null) {
			if (other.minAllow != null)
				return false;
		} else if (!minAllow.equals(other.minAllow))
			return false;
		if (paymentType == null) {
			if (other.paymentType != null)
				return false;
		} else if (!paymentType.equals(other.paymentType))
			return false;
		if (port == null) {
			if (other.port != null)
				return false;
		} else if (!port.equals(other.port))
			return false;
		if (shippingMode == null) {
			if (other.shippingMode != null)
				return false;
		} else if (!shippingMode.equals(other.shippingMode))
			return false;
		return true;
	}

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((agentCode == null) ? 0 : agentCode.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result
				+ ((currencyCode == null) ? 0 : currencyCode.hashCode());
		result = prime * result
				+ ((deliveryDate == null) ? 0 : deliveryDate.hashCode());
		result = prime
				* result
				+ ((deliveryQuantity == null) ? 0 : deliveryQuantity.hashCode());
		result = prime * result
				+ ((deliveryTerm == null) ? 0 : deliveryTerm.hashCode());
		result = prime * result
				+ ((exchangeRate == null) ? 0 : exchangeRate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((maxAllow == null) ? 0 : maxAllow.hashCode());
		result = prime * result
				+ ((merchandisor == null) ? 0 : merchandisor.hashCode());
		result = prime * result
				+ ((minAllow == null) ? 0 : minAllow.hashCode());
		result = prime * result
				+ ((paymentType == null) ? 0 : paymentType.hashCode());
		result = prime * result + ((port == null) ? 0 : port.hashCode());
		result = prime * result
				+ ((shippingMode == null) ? 0 : shippingMode.hashCode());
		return result;
	}

    @Override
	public String toString() {
		return "Merordersheetdelivery [id=" + id + ", deliveryQuantity="
				+ deliveryQuantity + ", deliveryDate=" + deliveryDate
				+ ", country=" + country + ", maxAllow=" + maxAllow
				+ ", minAllow=" + minAllow + ", port=" + port
				+ ", paymentType=" + paymentType + ", deliveryTerm="
				+ deliveryTerm + ", shippingMode=" + shippingMode
				+ ", agentCode=" + agentCode + ", currencyCode=" + currencyCode
				+ ", exchangeRate=" + exchangeRate + ", merchandisor="
				+ merchandisor + "]";
	}

}
