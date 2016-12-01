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
public class MstsupplierId extends BaseObject implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -6257427367066463429L;
	private String compCode;
    private String suppCode;


    public MstsupplierId(String compCode, String suppCode) {
		super();
		this.compCode = compCode;
		this.suppCode = suppCode;
	}
    public MstsupplierId() {
		super();
	}
	@Column(name="comp_code", nullable=false, length=6 , columnDefinition = "CHAR(6)")
    @Field
    public String getCompCode() {
        return this.compCode;
    }
    
    public void setCompCode(String compCode) {
        this.compCode = compCode;
    }

    @Column(name="supp_code", unique=true, nullable=false, length=10 , columnDefinition = "CHAR(10)")
    @Field
    public String getSuppCode() {
        return this.suppCode;
    }
    
    public void setSuppCode(String suppCode) {
        this.suppCode = suppCode;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MstsupplierId pojo = (MstsupplierId) o;

        if (compCode != null ? !compCode.equals(pojo.compCode) : pojo.compCode != null) return false;
        if (suppCode != null ? !suppCode.equals(pojo.suppCode) : pojo.suppCode != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = 31 * result + (compCode != null ? compCode.hashCode() : 0);
        result = (suppCode != null ? suppCode.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("compCode").append("='").append(getCompCode()).append("', ");
        sb.append("suppCode").append("='").append(getSuppCode()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

}
