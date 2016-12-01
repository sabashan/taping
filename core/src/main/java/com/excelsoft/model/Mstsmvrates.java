package com.excelsoft.model;

import com.excelsoft.model.BaseObject;

import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import javax.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;

@Entity
@Table(name="mstsmvrates")
@XmlRootElement
public class Mstsmvrates extends BaseObject implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 8280731741690747762L;
	private MstsmvratesId id;
    private BigDecimal smvValue;
    private Long volAdded;

    @EmbeddedId @DocumentId    
    public MstsmvratesId getId() {
        return this.id;
    }
    
    public void setId(MstsmvratesId id) {
        this.id = id;
    }
    
    @Column(name="smv_value", precision=20, scale=6 ,columnDefinition="DECIMAL(20,6)")
    @Field
    public BigDecimal getSmvValue() {
        return this.smvValue;
    }
    
    public void setSmvValue(BigDecimal smvValue) {
        this.smvValue = smvValue;
    }
    
    @Column(name="vol_added", precision=2, scale=0 ,columnDefinition="DECIMAL(2,0)")
    @Field
    public Long getVolAdded() {
        return this.volAdded;
    }
    
    public void setVolAdded(Long volAdded) {
        this.volAdded = volAdded;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mstsmvrates pojo = (Mstsmvrates) o;

        if (smvValue != null ? !smvValue.equals(pojo.smvValue) : pojo.smvValue != null) return false;
        if (volAdded != null ? !volAdded.equals(pojo.volAdded) : pojo.volAdded != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (smvValue != null ? smvValue.hashCode() : 0);
        result = 31 * result + (volAdded != null ? volAdded.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("id").append("='").append(getId()).append("', ");
        sb.append("smvValue").append("='").append(getSmvValue()).append("', ");
        sb.append("volAdded").append("='").append(getVolAdded()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

}
