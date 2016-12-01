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
@Table(name="merordersheetdem")
@XmlRootElement
public class Merordersheetdem extends BaseObject implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MerordersheetdemId id;
    private Merordersheetorder merordersheetorder;
    private String quentity;
    
    

    public Merordersheetdem() {
		super();
	}

    
    
	public Merordersheetdem(MerordersheetdemId id,
			Merordersheetorder merordersheetorder, String quentity) {
		super();
		this.id = id;
		this.merordersheetorder = merordersheetorder;
		this.quentity = quentity;
	}

	
	public Merordersheetdem(MerordersheetdemId id) {
		super();
		this.id = id;
	}



	@EmbeddedId @DocumentId    
    public MerordersheetdemId getId() {
        return this.id;
    }
    
    public void setId(MerordersheetdemId id) {
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
    
    @Column(name="quentity", length=45, columnDefinition="CHAR(45)")
    @Field
    public String getQuentity() {
        return this.quentity;
    }
    
    public void setQuentity(String quentity) {
        this.quentity = quentity;
    }

    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Merordersheetdem other = (Merordersheetdem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (quentity == null) {
			if (other.quentity != null)
				return false;
		} else if (!quentity.equals(other.quentity))
			return false;
		return true;
	}

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((quentity == null) ? 0 : quentity.hashCode());
		return result;
	}

    @Override
	public String toString() {
		return "Merordersheetdem [id=" + id + ", quentity=" + quentity + "]";
	}

}
