package com.excelsoft.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.search.annotations.Field;

@Embeddable
@XmlRootElement
public class MerordersheetdemId extends BaseObject implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String country;
    private String component;
    private String color;
    private String horiDem;
    private String horiValue;
    private String vertiDem;
    private String vertiValue;
    private Long ordersheetId;
    private String planingOrdersheetNo;
    private String orderType;
    
    


    public MerordersheetdemId() {
		super();
	}
    
    public MerordersheetdemId(String country, String component, String color,
			String horiDem, String horiValue, String vertiDem,
			String vertiValue, Long ordersheetId, String planingOrdersheetNo,
			String orderType) {
		super();
		this.country = country;
		this.component = component;
		this.color = color;
		this.horiDem = horiDem;
		this.horiValue = horiValue;
		this.vertiDem = vertiDem;
		this.vertiValue = vertiValue;
		this.ordersheetId = ordersheetId;
		this.planingOrdersheetNo = planingOrdersheetNo;
		this.orderType = orderType;
	}



	@Column(name="country", nullable=false, length=45, columnDefinition="CHAR(45)")
    @Field
    public String getCountry() {
        return this.country;
    }
    
    public void setCountry(String country) {
        this.country = country;
    }

    @Column(name="component", nullable=false, length=45, columnDefinition="CHAR(45)")
    @Field
    public String getComponent() {
        return this.component;
    }
    
    public void setComponent(String component) {
        this.component = component;
    }

    @Column(name="color", nullable=false, length=45, columnDefinition="CHAR(45)")
    @Field
    public String getColor() {
        return this.color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }

    @Column(name="hori_dem", nullable=false, length=45, columnDefinition="CHAR(45)")
    @Field
    public String getHoriDem() {
        return this.horiDem;
    }
    
    public void setHoriDem(String horiDem) {
        this.horiDem = horiDem;
    }

    @Column(name="hori_value", nullable=false, length=45, columnDefinition="CHAR(45)")
    @Field
    public String getHoriValue() {
        return this.horiValue;
    }
    
    public void setHoriValue(String horiValue) {
        this.horiValue = horiValue;
    }

    @Column(name="verti_dem", nullable=false, length=45, columnDefinition="CHAR(45)")
    @Field
    public String getVertiDem() {
        return this.vertiDem;
    }
    
    public void setVertiDem(String vertiDem) {
        this.vertiDem = vertiDem;
    }

    @Column(name="verti_value", nullable=false, length=45, columnDefinition="CHAR(45)")
    @Field
    public String getVertiValue() {
        return this.vertiValue;
    }
    
    public void setVertiValue(String vertiValue) {
        this.vertiValue = vertiValue;
    }

    @Column(name="ordersheet_id", nullable=false, columnDefinition="INT")
    @Field
    public Long getOrdersheetId() {
        return this.ordersheetId;
    }
    
    public void setOrdersheetId(Long ordersheetId) {
        this.ordersheetId = ordersheetId;
    }

    @Column(name="planing_ordersheet_no", nullable=false, length=15, columnDefinition="CHAR(15)")
    @Field
    public String getPlaningOrdersheetNo() {
        return this.planingOrdersheetNo;
    }
    
    public void setPlaningOrdersheetNo(String planingOrdersheetNo) {
        this.planingOrdersheetNo = planingOrdersheetNo;
    }

    @Column(name="order_type", nullable=false, length=45, columnDefinition="CHAR(45)")
    @Field
    public String getOrderType() {
        return this.orderType;
    }
    
    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MerordersheetdemId pojo = (MerordersheetdemId) o;

        if (country != null ? !country.equals(pojo.country) : pojo.country != null) return false;
        if (component != null ? !component.equals(pojo.component) : pojo.component != null) return false;
        if (color != null ? !color.equals(pojo.color) : pojo.color != null) return false;
        if (horiDem != null ? !horiDem.equals(pojo.horiDem) : pojo.horiDem != null) return false;
        if (horiValue != null ? !horiValue.equals(pojo.horiValue) : pojo.horiValue != null) return false;
        if (vertiDem != null ? !vertiDem.equals(pojo.vertiDem) : pojo.vertiDem != null) return false;
        if (vertiValue != null ? !vertiValue.equals(pojo.vertiValue) : pojo.vertiValue != null) return false;
        if (ordersheetId != null ? !ordersheetId.equals(pojo.ordersheetId) : pojo.ordersheetId != null) return false;
        if (planingOrdersheetNo != null ? !planingOrdersheetNo.equals(pojo.planingOrdersheetNo) : pojo.planingOrdersheetNo != null) return false;
        if (orderType != null ? !orderType.equals(pojo.orderType) : pojo.orderType != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = (component != null ? component.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + (horiDem != null ? horiDem.hashCode() : 0);
        result = 31 * result + (horiValue != null ? horiValue.hashCode() : 0);
        result = 31 * result + (vertiDem != null ? vertiDem.hashCode() : 0);
        result = 31 * result + (vertiValue != null ? vertiValue.hashCode() : 0);
        result = 31 * result + (ordersheetId != null ? ordersheetId.hashCode() : 0);
        result = 31 * result + (planingOrdersheetNo != null ? planingOrdersheetNo.hashCode() : 0);
        result = 31 * result + (orderType != null ? orderType.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("country").append("='").append(getCountry()).append("', ");
        sb.append("component").append("='").append(getComponent()).append("', ");
        sb.append("color").append("='").append(getColor()).append("', ");
        sb.append("horiDem").append("='").append(getHoriDem()).append("', ");
        sb.append("horiValue").append("='").append(getHoriValue()).append("', ");
        sb.append("vertiDem").append("='").append(getVertiDem()).append("', ");
        sb.append("vertiValue").append("='").append(getVertiValue()).append("', ");
        sb.append("ordersheetId").append("='").append(getOrdersheetId()).append("', ");
        sb.append("planingOrdersheetNo").append("='").append(getPlaningOrdersheetNo()).append("', ");
        sb.append("orderType").append("='").append(getOrderType()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

}
