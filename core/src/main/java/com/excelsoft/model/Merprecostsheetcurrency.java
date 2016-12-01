package com.excelsoft.model;

import com.excelsoft.model.BaseObject;

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
@Table(name="merprecostsheetcurrency")
@XmlRootElement
public class Merprecostsheetcurrency extends BaseObject implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 5185805763627249199L;

	private MerprecostsheetcurrencyId id;
    private Merprecostsheet merprecostsheet;
    private Mstcurrency mstcurrency;
    private BigDecimal exchangeRate;

    public Merprecostsheetcurrency(MerprecostsheetcurrencyId id,
			Merprecostsheet merprecostsheet, Mstcurrency mstcurrency,
			BigDecimal exchangeRate) {
		super();
		this.id = id;
		this.merprecostsheet = merprecostsheet;
		this.mstcurrency = mstcurrency;
		this.exchangeRate = exchangeRate;
	}

	public Merprecostsheetcurrency() {
		super();
	}

	public Merprecostsheetcurrency(MerprecostsheetcurrencyId id) {
		super();
		this.id = id;
	}

	@EmbeddedId @DocumentId    
    public MerprecostsheetcurrencyId getId() {
        return this.id;
    }
    
    public void setId(MerprecostsheetcurrencyId id) {
        this.id = id;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumns( { 
        @JoinColumn(name="pre_cost_sheet_no", referencedColumnName="pre_cost_sheet_no", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="version_no", referencedColumnName="version_no", nullable=false, insertable=false, updatable=false),
        @JoinColumn(name="costsheet_type", referencedColumnName="costsheet_type", nullable=false, insertable=false, updatable=false)} )
    public Merprecostsheet getMerprecostsheet() {
        return this.merprecostsheet;
    }
    
    public void setMerprecostsheet(Merprecostsheet merprecostsheet) {
        this.merprecostsheet = merprecostsheet;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="currency_code", nullable=false, insertable=false, updatable=false)
    public Mstcurrency getMstcurrency() {
        return this.mstcurrency;
    }
    
    public void setMstcurrency(Mstcurrency mstcurrency) {
        this.mstcurrency = mstcurrency;
    }
    
    @Column(name="exchange_rate", precision=10, scale=0 ,columnDefinition="DECIMAL(10)")
    @Field
    public BigDecimal getExchangeRate() {
        return this.exchangeRate;
    }
    
    public void setExchangeRate(BigDecimal exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Merprecostsheetcurrency other = (Merprecostsheetcurrency) obj;
		if (exchangeRate == null) {
			if (other.exchangeRate != null)
				return false;
		} else if (!exchangeRate.equals(other.exchangeRate))
			return false;
		if (mstcurrency == null) {
			if (other.mstcurrency != null)
				return false;
		} else if (!mstcurrency.equals(other.mstcurrency))
			return false;
		return true;
	}

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((exchangeRate == null) ? 0 : exchangeRate.hashCode());
		result = prime * result
				+ ((mstcurrency == null) ? 0 : mstcurrency.hashCode());
		return result;
	}

    @Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Merprecostsheetcurrency [id=");
		builder.append(id);
		builder.append(", exchangeRate=");
		builder.append(exchangeRate);
		builder.append("]");
		return builder.toString();
	}

}
