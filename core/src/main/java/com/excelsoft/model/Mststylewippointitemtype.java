package com.excelsoft.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;

@Entity
@Table(name="mststylewippointitemtype")
@XmlRootElement
public class Mststylewippointitemtype extends BaseObject implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -7532955886406069773L;
	private MststylewippointitemtypeId id;
    private Mstitemtype mstitemtype;
    private Short attached;

    @EmbeddedId @DocumentId
    public MststylewippointitemtypeId getId() {
        return this.id;
    }
    
    public void setId(MststylewippointitemtypeId id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name="item_type", nullable=false, insertable=false, updatable=false)
    public Mstitemtype getMstitemtype() {
        return this.mstitemtype;
    }
    
    public void setMstitemtype(Mstitemtype mstitemtype) {
        this.mstitemtype = mstitemtype;
    }
    
    @Column(name="attached", precision=3, scale=0)
    @Field
    public Short getAttached() {
        return this.attached;
    }
    
    public void setAttached(Short attached) {
        this.attached = attached;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mststylewippointitemtype pojo = (Mststylewippointitemtype) o;

        if (mstitemtype != null ? !mstitemtype.equals(pojo.mstitemtype) : pojo.mstitemtype != null) return false;
        if (attached != null ? !attached.equals(pojo.attached) : pojo.attached != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (mstitemtype != null ? mstitemtype.hashCode() : 0);
        result = 31 * result + (attached != null ? attached.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("id").append("='").append(getId()).append("', ");
        sb.append("mstitemtype").append("='").append(getMstitemtype()).append("', ");
        sb.append("attached").append("='").append(getAttached()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

}
