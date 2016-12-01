package com.excelsoft.model;

import com.excelsoft.model.BaseObject;

import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;

@Embeddable
@Indexed
@XmlRootElement
public class MstsmvratesId extends BaseObject implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -4451786387957556854L;
	private String buyerCode;
    private String smvCode;
    private Date fromDate;
    private Date toDate;


    public MstsmvratesId(String buyerCode, String smvCode, Date fromDate,
			Date toDate) {
		super();
		this.buyerCode = buyerCode;
		this.smvCode = smvCode;
		this.fromDate = fromDate;
		this.toDate = toDate;
	}
    public MstsmvratesId() {
		super();
		
	}
	@Column(name="buyer_code", nullable=false, length=10  ,columnDefinition="CHAR(10)")
    @Field
    public String getBuyerCode() {
        return this.buyerCode;
    }
    
    public void setBuyerCode(String buyerCode) {
        this.buyerCode = buyerCode;
    }

    @Column(name="smv_code", nullable=false, length=20 ,columnDefinition="CHAR(20)")
    @Field
    public String getSmvCode() {
        return this.smvCode;
    }
    
    public void setSmvCode(String smvCode) {
        this.smvCode = smvCode;
    }

    @Column(name="from_date", nullable=false, length=10)
    @Field
    public Date getFromDate() {
        return this.fromDate;
    }
    
    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    @Column(name="to_date", nullable=false, length=10)
    @Field
    public Date getToDate() {
        return this.toDate;
    }
    
    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MstsmvratesId pojo = (MstsmvratesId) o;

        if (buyerCode != null ? !buyerCode.equals(pojo.buyerCode) : pojo.buyerCode != null) return false;
        if (smvCode != null ? !smvCode.equals(pojo.smvCode) : pojo.smvCode != null) return false;
        if (fromDate != null ? !fromDate.equals(pojo.fromDate) : pojo.fromDate != null) return false;
        if (toDate != null ? !toDate.equals(pojo.toDate) : pojo.toDate != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = 31 * result + (buyerCode != null ? buyerCode.hashCode() : 0);
        result = (smvCode != null ? smvCode.hashCode() : 0);
        result = 31 * result + (fromDate != null ? fromDate.hashCode() : 0);
        result = 31 * result + (toDate != null ? toDate.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("buyerCode").append("='").append(getBuyerCode()).append("', ");
        sb.append("smvCode").append("='").append(getSmvCode()).append("', ");
        sb.append("fromDate").append("='").append(getFromDate()).append("', ");
        sb.append("toDate").append("='").append(getToDate()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

}
