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
@Table(name="mstsmvvoulmerates")
@XmlRootElement
public class Mstsmvvoulmerates extends BaseObject implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -6450176620052927727L;
	private MstsmvvoulmeratesId id;
    private BigDecimal smvValue;

    @EmbeddedId @DocumentId    
    public MstsmvvoulmeratesId getId() {
        return this.id;
    }
    
    public void setId(MstsmvvoulmeratesId id) {
        this.id = id;
    }
    
    @Column(name="smv_value", precision=20, scale=6)
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

        Mstsmvvoulmerates pojo = (Mstsmvvoulmerates) o;

        if (smvValue != null ? !smvValue.equals(pojo.smvValue) : pojo.smvValue != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (smvValue != null ? smvValue.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("id").append("='").append(getId()).append("', ");
        sb.append("smvValue").append("='").append(getSmvValue()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

}
