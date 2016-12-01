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
@Table(name="mercostsheetdemmap")
@XmlRootElement
public class Mercostsheetdemmap extends BaseObject implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 7532385828936380041L;
	private MercostsheetdemmapId id;
    private Mercostsheethdr mercostsheethdr;
    private Boolean isTicked;

    public Mercostsheetdemmap() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Mercostsheetdemmap(MercostsheetdemmapId id,
			Mercostsheethdr mercostsheethdr, Boolean isTicked) {
		super();
		this.id = id;
		this.mercostsheethdr = mercostsheethdr;
		this.isTicked = isTicked;
	}

	@EmbeddedId @DocumentId    
    public MercostsheetdemmapId getId() {
        return this.id;
    }
    
    public void setId(MercostsheetdemmapId id) {
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
    
    @Column(name="is_ticked")
    @Field
    public Boolean getIsTicked() {
        return this.isTicked;
    }
    
    public void setIsTicked(Boolean isTicked) {
        this.isTicked = isTicked;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mercostsheetdemmap pojo = (Mercostsheetdemmap) o;

        if (mercostsheethdr != null ? !mercostsheethdr.equals(pojo.mercostsheethdr) : pojo.mercostsheethdr != null) return false;
        if (isTicked != null ? !isTicked.equals(pojo.isTicked) : pojo.isTicked != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (mercostsheethdr != null ? mercostsheethdr.hashCode() : 0);
        result = 31 * result + (isTicked != null ? isTicked.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("id").append("='").append(getId()).append("', ");
        sb.append("mercostsheethdr").append("='").append(getMercostsheethdr()).append("', ");
        sb.append("isTicked").append("='").append(getIsTicked()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

}
