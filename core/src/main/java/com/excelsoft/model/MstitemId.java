package com.excelsoft.model;

import com.excelsoft.model.BaseObject;

import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;

@Embeddable
@Indexed
@XmlRootElement
public class MstitemId extends BaseObject implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -4999902967641316800L;
	private String itemType;
    private String itemCode;


    public MstitemId(String itemType, String itemCode) {
		super();
		this.itemType = itemType;
		this.itemCode = itemCode;
	}
    public MstitemId() {
		super();
		
	}
	@Column(name="item_type", nullable=false, length=10 ,columnDefinition="CHAR(10)")
    @Field
    public String getItemType() {
        return this.itemType;
    }
    
    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    @Column(name="item_code", nullable=false, length=30 ,columnDefinition="CHAR(30)")
    @Field
    public String getItemCode() {
        return this.itemCode;
    }
    
    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MstitemId pojo = (MstitemId) o;

        if (itemType != null ? !itemType.equals(pojo.itemType) : pojo.itemType != null) return false;
        if (itemCode != null ? !itemCode.equals(pojo.itemCode) : pojo.itemCode != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = 31 * result + (itemType != null ? itemType.hashCode() : 0);
        result = (itemCode != null ? itemCode.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("itemType").append("='").append(getItemType()).append("', ");
        sb.append("itemCode").append("='").append(getItemCode()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

}
