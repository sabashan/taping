package com.excelsoft.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.search.annotations.DocumentId;

@Entity
@Table(name="mercostsheetcountry")
@XmlRootElement
public class Mercostsheetcountry extends BaseObject implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -5661414202689827142L;
	private MercostsheetcountryId id;
    private Mercostsheethdr mercostsheethdr;

    public Mercostsheetcountry() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Mercostsheetcountry(MercostsheetcountryId id,
			Mercostsheethdr mercostsheethdr) {
		super();
		this.id = id;
		this.mercostsheethdr = mercostsheethdr;
	}

	@EmbeddedId @DocumentId    
    public MercostsheetcountryId getId() {
        return this.id;
    }
    
    public void setId(MercostsheetcountryId id) {
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

    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mercostsheetcountry other = (Mercostsheetcountry) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

    @Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Mercostsheetcountry [id=");
		builder.append(id);
		builder.append("]");
		return builder.toString();
	}

}
