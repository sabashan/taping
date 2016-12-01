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
@Table(name="mercostsheetcurrency")
@XmlRootElement
public class Mercostsheetcurrency extends BaseObject implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -8264410382069240361L;
	private MercostsheetcurrencyId id;
    private Mercostsheethdr mercostsheethdr;
    private Long exchangeRate;
    private Boolean isDefault;

    public Mercostsheetcurrency() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Mercostsheetcurrency(MercostsheetcurrencyId id,
			Mercostsheethdr mercostsheethdr, Long exchangeRate,
			Boolean isDefault) {
		super();
		this.id = id;
		this.mercostsheethdr = mercostsheethdr;
		this.exchangeRate = exchangeRate;
		this.isDefault = isDefault;
	}

	@EmbeddedId @DocumentId    
    public MercostsheetcurrencyId getId() {
        return this.id;
    }
    
    public void setId(MercostsheetcurrencyId id) {
        this.id = id;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumns( { 
        @JoinColumn(name="cost_sheet_no", referencedColumnName="cost_sheet_no", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="version_no", referencedColumnName="version_no", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="cost_sheet_type", referencedColumnName="cost_sheet_type", nullable=false, insertable=false, updatable=false) } )
    public Mercostsheethdr getMercostsheethdr() {
        return this.mercostsheethdr;
    }
    
    public void setMercostsheethdr(Mercostsheethdr mercostsheethdr) {
        this.mercostsheethdr = mercostsheethdr;
    }

    @Column(name="exchange_rate", precision=10, scale=0, columnDefinition="DECIMAL(10,0)")
    @Field
    public Long getExchangeRate() {
        return this.exchangeRate;
    }
    
    public void setExchangeRate(Long exchangeRate) {
        this.exchangeRate = exchangeRate;
    }
    
    @Column(name="is_default")
    @Field
    public Boolean getIsDefault() {
        return this.isDefault;
    }
    
    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mercostsheetcurrency other = (Mercostsheetcurrency) obj;
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
		if (isDefault == null) {
			if (other.isDefault != null)
				return false;
		} else if (!isDefault.equals(other.isDefault))
			return false;
		return true;
	}

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((exchangeRate == null) ? 0 : exchangeRate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((isDefault == null) ? 0 : isDefault.hashCode());
		return result;
	}

    @Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Mercostsheetcurrency [id=");
		builder.append(id);
		builder.append(", exchangeRate=");
		builder.append(exchangeRate);
		builder.append(", isDefault=");
		builder.append(isDefault);
		builder.append("]");
		return builder.toString();
	}

}
