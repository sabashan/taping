package com.excelsoft.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;

@Entity
@Table(name="mststylerouteoperationdemmap")
@XmlRootElement
public class Mststylerouteoperationdemmap extends BaseObject implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MststylerouteoperationdemmapId id;
    private Mststylerouteoperation mststylerouteoperation;
    private BigDecimal smvValue;

    @EmbeddedId @DocumentId    
    public MststylerouteoperationdemmapId getId() {
        return this.id;
    }
    
    public void setId(MststylerouteoperationdemmapId id) {
        this.id = id;
    }
@ManyToOne
    @JoinColumns( { 
        @JoinColumn(name="opeartion_no", referencedColumnName="opeartion_no", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="style_route_id", referencedColumnName="style_route_id", nullable=false, insertable=false, updatable=false) } )
    public Mststylerouteoperation getMststylerouteoperation() {
        return this.mststylerouteoperation;
    }
    
    public void setMststylerouteoperation(Mststylerouteoperation mststylerouteoperation) {
        this.mststylerouteoperation = mststylerouteoperation;
    }
    
    @Column(name="smv_value", precision=20, scale=6, columnDefinition = "DECIMAL(20,6)")
    @Field
    public BigDecimal getSmvValue() {
        return this.smvValue;
    }
    
    public void setSmvValue(BigDecimal smvValue) {
        this.smvValue = smvValue;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mststylerouteoperationdemmap pojo = (Mststylerouteoperationdemmap) o;

        if (mststylerouteoperation != null ? !mststylerouteoperation.equals(pojo.mststylerouteoperation) : pojo.mststylerouteoperation != null) return false;
        if (smvValue != null ? !smvValue.equals(pojo.smvValue) : pojo.smvValue != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (mststylerouteoperation != null ? mststylerouteoperation.hashCode() : 0);
        result = 31 * result + (smvValue != null ? smvValue.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("id").append("='").append(getId()).append("', ");
        sb.append("mststylerouteoperation").append("='").append(getMststylerouteoperation()).append("', ");
        sb.append("smvValue").append("='").append(getSmvValue()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

}
