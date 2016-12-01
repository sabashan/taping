package com.excelsoft.model;



import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;

@Entity
@Table(name="mstcurrency")
@Indexed
@XmlRootElement
public class Mstcurrency extends AuditFields implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -8965255366983228662L;
	private String curCode;
    private String curName;
    private Long curRate;
    private Date validUntil;
    private String decName;
    private Long customCurRate;
    
   

    @Id  @DocumentId    
    @Column(name="cur_code", length=4 ,columnDefinition="CHAR(4)")
    public String getCurCode() {
        return this.curCode;
    }
    
    public void setCurCode(String curCode) {
        this.curCode = curCode;
    }
    
    @Column(name="cur_name", nullable=false, length=30 ,columnDefinition="CHAR(30)")
    @Field
    public String getCurName() {
        return this.curName;
    }
    
    public void setCurName(String curName) {
        this.curName = curName;
    }
    
    @Column(name="cur_rate", nullable=false, precision=20, scale=6 ,columnDefinition="DECIMAL(20)")
    @Field
    public Long getCurRate() {
        return this.curRate;
    }
    
    public void setCurRate(Long curRate) {
        this.curRate = curRate;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="valid_until", nullable=false, length=10)
    @Field
    public Date getValidUntil() {
        return this.validUntil;
    }
    
    public void setValidUntil(Date validUntil) {
        this.validUntil = validUntil;
    }
    
    @Column(name="dec_name", length=10 ,columnDefinition="CHAR(10)")
    @Field
    public String getDecName() {
        return this.decName;
    }
    
    public void setDecName(String decName) {
        this.decName = decName;
    }
    
    @Column(name="custom_cur_rate", precision=20, scale=6 ,columnDefinition="DECIMAL(20)")
    @Field
    public Long getCustomCurRate() {
        return this.customCurRate;
    }
    
    public void setCustomCurRate(Long customCurRate) {
        this.customCurRate = customCurRate;
    }
    
    
   


    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mstcurrency pojo = (Mstcurrency) o;

        if (curName != null ? !curName.equals(pojo.curName) : pojo.curName != null) return false;
        if (curRate != null ? !curRate.equals(pojo.curRate) : pojo.curRate != null) return false;
        if (validUntil != null ? !validUntil.equals(pojo.validUntil) : pojo.validUntil != null) return false;
        if (decName != null ? !decName.equals(pojo.decName) : pojo.decName != null) return false;
        if (customCurRate != null ? !customCurRate.equals(pojo.customCurRate) : pojo.customCurRate != null) return false;
        if (createdBy != null ? !createdBy.equals(pojo.createdBy) : pojo.createdBy != null) return false;
        if (createdOn != null ? !createdOn.equals(pojo.createdOn) : pojo.createdOn != null) return false;
        if (createdAt != null ? !createdAt.equals(pojo.createdAt) : pojo.createdAt != null) return false;
        if (modifiedBy != null ? !modifiedBy.equals(pojo.modifiedBy) : pojo.modifiedBy != null) return false;
        if (modifiedOn != null ? !modifiedOn.equals(pojo.modifiedOn) : pojo.modifiedOn != null) return false;
        if (modifiedAt != null ? !modifiedAt.equals(pojo.modifiedAt) : pojo.modifiedAt != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (curName != null ? curName.hashCode() : 0);
        result = 31 * result + (curRate != null ? curRate.hashCode() : 0);
        result = 31 * result + (validUntil != null ? validUntil.hashCode() : 0);
        result = 31 * result + (decName != null ? decName.hashCode() : 0);
        result = 31 * result + (customCurRate != null ? customCurRate.hashCode() : 0);
        result = 31 * result + (createdBy != null ? createdBy.hashCode() : 0);
        result = 31 * result + (createdOn != null ? createdOn.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (modifiedBy != null ? modifiedBy.hashCode() : 0);
        result = 31 * result + (modifiedOn != null ? modifiedOn.hashCode() : 0);
        result = 31 * result + (modifiedAt != null ? modifiedAt.hashCode() : 0);

        return result;
    }

    @Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Mstcurrency [curCode=").append(curCode)
				.append(", curName=").append(curName).append(", curRate=")
				.append(curRate).append(", validUntil=").append(validUntil)
				.append(", decName=").append(decName)
				.append(", customCurRate=").append(customCurRate).append("]");
		return builder.toString();
	}

}
