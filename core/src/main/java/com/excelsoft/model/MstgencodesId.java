package com.excelsoft.model;

import com.excelsoft.model.BaseObject;

import org.hibernate.search.annotations.Field;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;

@Embeddable
@XmlRootElement
public class MstgencodesId extends BaseObject implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -3372518637059945070L;
	private String type;
    private String code;


    
    public MstgencodesId() {
		super();
	}

	public MstgencodesId(String type, String code) {
		super();
		this.type = type;
		this.code = code;
	}

	@Column(name="type", nullable=false, length=6 ,columnDefinition="CHAR(6)")
    @Field
    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
    }

    @Column(name="code", nullable=false, length=10 ,columnDefinition="CHAR(10)")
    @Field
    public String getCode() {
        return this.code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MstgencodesId pojo = (MstgencodesId) o;

        if (type != null ? !type.equals(pojo.type) : pojo.type != null) return false;
        if (code != null ? !code.equals(pojo.code) : pojo.code != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = (code != null ? code.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("type").append("='").append(getType()).append("', ");
        sb.append("code").append("='").append(getCode()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

}
