package com.excelsoft.model;

import com.excelsoft.model.BaseObject;

import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;

@Embeddable
@Indexed
@XmlRootElement
public class MstsmvvoulmeratesId extends BaseObject implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String buyerCode;
    private Date fromDate;
    private Date toDate;
    private String smvCode;
    private BigDecimal fromVolume;
    private BigDecimal toVolume;


    public MstsmvvoulmeratesId(String buyerCode, Date fromDate, Date toDate,
			String smvCode, BigDecimal fromVolume, BigDecimal toVolume) {
		super();
		this.buyerCode = buyerCode;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.smvCode = smvCode;
		this.fromVolume = fromVolume;
		this.toVolume = toVolume;
	}

	public MstsmvvoulmeratesId() {
		super();
	}

	@Column(name="buyer_code", nullable=false, length=10)
    @Field
    public String getBuyerCode() {
        return this.buyerCode;
    }
    
    public void setBuyerCode(String buyerCode) {
        this.buyerCode = buyerCode;
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

    @Column(name="smv_code", nullable=false, length=20)
    @Field
    public String getSmvCode() {
        return this.smvCode;
    }
    
    public void setSmvCode(String smvCode) {
        this.smvCode = smvCode;
    }

    @Column(name="from_volume", nullable=false, precision=20, scale=6)
    @Field
    public BigDecimal getFromVolume() {
        return this.fromVolume;
    }
    
    public void setFromVolume(BigDecimal fromVolume) {
        this.fromVolume = fromVolume;
    }

    @Column(name="to_volume", nullable=false, precision=20, scale=6)
    @Field
    public BigDecimal getToVolume() {
        return this.toVolume;
    }
    
    public void setToVolume(BigDecimal toVolume) {
        this.toVolume = toVolume;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MstsmvvoulmeratesId pojo = (MstsmvvoulmeratesId) o;

        if (buyerCode != null ? !buyerCode.equals(pojo.buyerCode) : pojo.buyerCode != null) return false;
        if (fromDate != null ? !fromDate.equals(pojo.fromDate) : pojo.fromDate != null) return false;
        if (toDate != null ? !toDate.equals(pojo.toDate) : pojo.toDate != null) return false;
        if (smvCode != null ? !smvCode.equals(pojo.smvCode) : pojo.smvCode != null) return false;
        if (fromVolume != null ? !fromVolume.equals(pojo.fromVolume) : pojo.fromVolume != null) return false;
        if (toVolume != null ? !toVolume.equals(pojo.toVolume) : pojo.toVolume != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = 31 * result + (buyerCode != null ? buyerCode.hashCode() : 0);
        result = (fromDate != null ? fromDate.hashCode() : 0);
        result = 31 * result + (toDate != null ? toDate.hashCode() : 0);
        result = 31 * result + (smvCode != null ? smvCode.hashCode() : 0);
        result = 31 * result + (fromVolume != null ? fromVolume.hashCode() : 0);
        result = 31 * result + (toVolume != null ? toVolume.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("buyerCode").append("='").append(getBuyerCode()).append("', ");
        sb.append("fromDate").append("='").append(getFromDate()).append("', ");
        sb.append("toDate").append("='").append(getToDate()).append("', ");
        sb.append("smvCode").append("='").append(getSmvCode()).append("', ");
        sb.append("fromVolume").append("='").append(getFromVolume()).append("', ");
        sb.append("toVolume").append("='").append(getToVolume()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

}
