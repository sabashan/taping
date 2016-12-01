package com.excelsoft.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

@Embeddable
@Indexed
@XmlRootElement
public class MststylewippointitemtypeId extends BaseObject implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 3912168470456191334L;
	private String wippointCode;
    private String itemType;

	public MststylewippointitemtypeId() {
		super();
		// TODO Auto-generated constructor stub
	}

    public MststylewippointitemtypeId(String wippointCode, String itemType) {
		super();
		this.wippointCode = wippointCode;
		this.itemType = itemType;
	}

	@Column(name="wippoint_code", nullable=false, length=5, columnDefinition = "CHAR(5)")
    @Field
    public String getWippointCode() {
        return this.wippointCode;
    }
    
    public void setWippointCode(String wippointCode) {
        this.wippointCode = wippointCode;
    }

    @Column(name="item_type", nullable=false, length=10, columnDefinition = "CHAR(10)")
    @Field
    public String getItemType() {
        return this.itemType;
    }
    
    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MststylewippointitemtypeId pojo = (MststylewippointitemtypeId) o;

        if (wippointCode != null ? !wippointCode.equals(pojo.wippointCode) : pojo.wippointCode != null) return false;
        if (itemType != null ? !itemType.equals(pojo.itemType) : pojo.itemType != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = 31 * result + (wippointCode != null ? wippointCode.hashCode() : 0);
        result = (itemType != null ? itemType.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("wippointCode").append("='").append(getWippointCode()).append("', ");
        sb.append("itemType").append("='").append(getItemType()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

}
