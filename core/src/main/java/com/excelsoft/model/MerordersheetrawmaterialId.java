package com.excelsoft.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.search.annotations.Field;

@Embeddable
@XmlRootElement
public class MerordersheetrawmaterialId extends BaseObject implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String planingOrdersheetNo;
    private BigDecimal rowMaterialNo;
    private String orderType;
    
    


    public MerordersheetrawmaterialId() {
		super();
	}
    
    
	public MerordersheetrawmaterialId(String planingOrdersheetNo,
			BigDecimal rowMaterialNo, String orderType) {
		super();
		this.planingOrdersheetNo = planingOrdersheetNo;
		this.rowMaterialNo = rowMaterialNo;
		this.orderType = orderType;
	}



	public MerordersheetrawmaterialId(String planingOrdersheetNo2,
			String rowMaterialNo2, String orderType2) {
		// TODO Auto-generated constructor stub
	}


	@Column(name="planing_ordersheet_no", nullable=false, length=15, columnDefinition="CHAR(15)")
    @Field
    public String getPlaningOrdersheetNo() {
        return this.planingOrdersheetNo;
    }
    
    public void setPlaningOrdersheetNo(String planingOrdersheetNo) {
        this.planingOrdersheetNo = planingOrdersheetNo;
    }

    @Column(name="row_material_no", nullable=false, length=10, columnDefinition="DECIMAL(10,0)")
    @Field
    public BigDecimal getRowMaterialNo() {
        return this.rowMaterialNo;
    }
    
    public void setRowMaterialNo(BigDecimal rowMaterialNo) {
        this.rowMaterialNo = rowMaterialNo;
    }

   
    @Column(name="order_type", nullable=false, length=10, columnDefinition="CHAR(10)")
    @Field
    public String getOrderType() {
		return orderType;
	}


	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}


	public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MerordersheetrawmaterialId pojo = (MerordersheetrawmaterialId) o;

        if (planingOrdersheetNo != null ? !planingOrdersheetNo.equals(pojo.planingOrdersheetNo) : pojo.planingOrdersheetNo != null) return false;
        if (rowMaterialNo != null ? !rowMaterialNo.equals(pojo.rowMaterialNo) : pojo.rowMaterialNo != null) return false;
        if (orderType != null ? !orderType.equals(pojo.orderType) : pojo.orderType != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = 31 * result + (planingOrdersheetNo != null ? planingOrdersheetNo.hashCode() : 0);
        result = (rowMaterialNo != null ? rowMaterialNo.hashCode() : 0);
        result = 31 * result + (orderType != null ? orderType.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("planingOrdersheetNo").append("='").append(getPlaningOrdersheetNo()).append("', ");
        sb.append("rowMaterialNo").append("='").append(getRowMaterialNo()).append("', ");
        sb.append("orderType").append("='").append(getOrderType()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

}
