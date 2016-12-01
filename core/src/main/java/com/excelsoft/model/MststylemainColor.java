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

@SuppressWarnings("serial")
@Entity
@Table(name="mststylemain_color")
@XmlRootElement
/**
 * 
 * @author Raminda
 *
 */
public class MststylemainColor extends BaseObject implements Serializable {
    private MststylemainColorId id;
    private Mststyleheader mststyleheader;
    private Long packQty;

    public MststylemainColor(){}
    /**
     * 
     * @param id
     * @param mststyleheader
     * @param packQty
     * @param mststylechildColors
     */
    public MststylemainColor(MststylemainColorId id,
			Mststyleheader mststyleheader, Long packQty) {
		super();
		this.id = id;
		this.mststyleheader = mststyleheader;
		this.packQty = packQty;
	}

	@EmbeddedId @DocumentId    
    public MststylemainColorId getId() {
        return this.id;
    }
    
    public void setId(MststylemainColorId id) {
        this.id = id;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumns( { 
        @JoinColumn(name="style_id", referencedColumnName="style_id", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="location_code", referencedColumnName="location_code", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="dep_code", referencedColumnName="dep_code", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="comp_code", referencedColumnName="comp_code", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="cust_code", referencedColumnName="cust_code", nullable=false, insertable=false, updatable=false) } )
@JsonIgnore
	public Mststyleheader getMststyleheader() {
        return this.mststyleheader;
    }
    
    public void setMststyleheader(Mststyleheader mststyleheader) {
        this.mststyleheader = mststyleheader;
    }
    
    @Column(name="pack_qty")
    @Field
    public Long getPackQty() {
        return this.packQty;
    }
    
    public void setPackQty(Long packQty) {
        this.packQty = packQty;
    }


    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MststylemainColor other = (MststylemainColor) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (packQty == null) {
			if (other.packQty != null)
				return false;
		} else if (!packQty.equals(other.packQty))
			return false;
		return true;
	}

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((packQty == null) ? 0 : packQty.hashCode());
		return result;
	}

    @Override
	public String toString() {
		return "MststylemainColor [id=" + id + ", packQty=" + packQty + "]";
	}

}
