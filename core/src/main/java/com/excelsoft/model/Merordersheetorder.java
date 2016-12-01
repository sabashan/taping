package com.excelsoft.model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;

@Entity
@Table(name="merordersheetorder")
@XmlRootElement
public class Merordersheetorder extends BaseObject implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MerordersheetorderId id;
    private Merordersheethdr merordersheethdr;
    private String orderNo;
    private String ordersheetCategory;
    private String buyerPo;
    private Long qty;
    private String sizeBackup;
    private String orderStatus;
    private String allocation;
    private String salesOrderNo;
    /*private Set<Merordersheetdem> merordersheetdems = new HashSet<Merordersheetdem>(0);
    private Set<Merordersheetdelivery> merordersheetdeliveries = new HashSet<Merordersheetdelivery>(0);
    private Set<Merordersheetgroupsetting> merordersheetgroupsettings = new HashSet<Merordersheetgroupsetting>(0);*/
    
    
    
    

    public Merordersheetorder() {
		super();
	}
    
    

	public Merordersheetorder(MerordersheetorderId id,
			Merordersheethdr merordersheethdr, String orderNo,
			String ordersheetCategory, String buyerPo, Long qty,
			String sizeBackup, String orderStatus, String allocation,
			String salesOrderNo, Set<Merordersheetdem> merordersheetdems,
			Set<Merordersheetdelivery> merordersheetdeliveries,
			Set<Merordersheetgroupsetting> merordersheetgroupsettings) {
		super();
		this.id = id;
		this.merordersheethdr = merordersheethdr;
		this.orderNo = orderNo;
		this.ordersheetCategory = ordersheetCategory;
		this.buyerPo = buyerPo;
		this.qty = qty;
		this.sizeBackup = sizeBackup;
		this.orderStatus = orderStatus;
		this.allocation = allocation;
		this.salesOrderNo = salesOrderNo;
		/*this.merordersheetdems = merordersheetdems;
		this.merordersheetdeliveries = merordersheetdeliveries;
		this.merordersheetgroupsettings = merordersheetgroupsettings;*/
	}

	

	public Merordersheetorder(MerordersheetorderId id) {
		super();
		this.id = id;
	}



	@EmbeddedId @DocumentId    
    public MerordersheetorderId getId() {
        return this.id;
    }
    
    public void setId(MerordersheetorderId id) {
        this.id = id;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumns( { 
        @JoinColumn(name="order_type", referencedColumnName="order_type", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="planing_ordersheet_no", referencedColumnName="planing_ordersheet_no", nullable=false, insertable=false, updatable=false) } )
    public Merordersheethdr getMerordersheethdr() {
        return this.merordersheethdr;
    }
    
    public void setMerordersheethdr(Merordersheethdr merordersheethdr) {
        this.merordersheethdr = merordersheethdr;
    }
    
    @Column(name="order_no", length=15, columnDefinition="CHAR(15)")
    @Field
    public String getOrderNo() {
        return this.orderNo;
    }
    
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
    
    @Column(name="ordersheet_category", length=10, columnDefinition="CHAR(10)")
    @Field
    public String getOrdersheetCategory() {
        return this.ordersheetCategory;
    }
    
    public void setOrdersheetCategory(String ordersheetCategory) {
        this.ordersheetCategory = ordersheetCategory;
    }
    
    @Column(name="buyer_po", length=20, columnDefinition="CHAR(20)")
    @Field
    public String getBuyerPo() {
        return this.buyerPo;
    }
    
    public void setBuyerPo(String buyerPo) {
        this.buyerPo = buyerPo;
    }
    
    @Column(name="qty", precision=10, scale=0, columnDefinition="DECIMAL(10.0)")
    @Field
    public Long getQty() {
        return this.qty;
    }
    
    public void setQty(Long qty) {
        this.qty = qty;
    }
    
    @Column(name="size_backup", length=10, columnDefinition="CHAR(10)")
    @Field
    public String getSizeBackup() {
        return this.sizeBackup;
    }
    
    public void setSizeBackup(String sizeBackup) {
        this.sizeBackup = sizeBackup;
    }
    
    @Column(name="order_status", length=10, columnDefinition="CHAR(10)")
    @Field
    public String getOrderStatus() {
        return this.orderStatus;
    }
    
    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
    
    @Column(name="allocation", length=45, columnDefinition="CHAR(45)")
    @Field
    public String getAllocation() {
        return this.allocation;
    }
    
    public void setAllocation(String allocation) {
        this.allocation = allocation;
    }
    
    @Column(name="sales_order_no", length=15, columnDefinition="CHAR(15)")
    @Field
    public String getSalesOrderNo() {
        return this.salesOrderNo;
    }
    
    public void setSalesOrderNo(String salesOrderNo) {
        this.salesOrderNo = salesOrderNo;
    }
/*@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="merordersheetorder")
    public Set<Merordersheetdem> getMerordersheetdems() {
        return this.merordersheetdems;
    }
    
    public void setMerordersheetdems(Set<Merordersheetdem> merordersheetdems) {
        this.merordersheetdems = merordersheetdems;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="merordersheetorder")
    public Set<Merordersheetdelivery> getMerordersheetdeliveries() {
        return this.merordersheetdeliveries;
    }
    
    public void setMerordersheetdeliveries(Set<Merordersheetdelivery> merordersheetdeliveries) {
        this.merordersheetdeliveries = merordersheetdeliveries;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="merordersheetorder")
    public Set<Merordersheetgroupsetting> getMerordersheetgroupsettings() {
        return this.merordersheetgroupsettings;
    }
    
    public void setMerordersheetgroupsettings(Set<Merordersheetgroupsetting> merordersheetgroupsettings) {
        this.merordersheetgroupsettings = merordersheetgroupsettings;
    }*/

    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Merordersheetorder other = (Merordersheetorder) obj;
		if (allocation == null) {
			if (other.allocation != null)
				return false;
		} else if (!allocation.equals(other.allocation))
			return false;
		if (buyerPo == null) {
			if (other.buyerPo != null)
				return false;
		} else if (!buyerPo.equals(other.buyerPo))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (orderNo == null) {
			if (other.orderNo != null)
				return false;
		} else if (!orderNo.equals(other.orderNo))
			return false;
		if (orderStatus == null) {
			if (other.orderStatus != null)
				return false;
		} else if (!orderStatus.equals(other.orderStatus))
			return false;
		if (ordersheetCategory == null) {
			if (other.ordersheetCategory != null)
				return false;
		} else if (!ordersheetCategory.equals(other.ordersheetCategory))
			return false;
		if (qty == null) {
			if (other.qty != null)
				return false;
		} else if (!qty.equals(other.qty))
			return false;
		if (salesOrderNo == null) {
			if (other.salesOrderNo != null)
				return false;
		} else if (!salesOrderNo.equals(other.salesOrderNo))
			return false;
		if (sizeBackup == null) {
			if (other.sizeBackup != null)
				return false;
		} else if (!sizeBackup.equals(other.sizeBackup))
			return false;
		return true;
	}

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((allocation == null) ? 0 : allocation.hashCode());
		result = prime * result + ((buyerPo == null) ? 0 : buyerPo.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((orderNo == null) ? 0 : orderNo.hashCode());
		result = prime * result
				+ ((orderStatus == null) ? 0 : orderStatus.hashCode());
		result = prime
				* result
				+ ((ordersheetCategory == null) ? 0 : ordersheetCategory
						.hashCode());
		result = prime * result + ((qty == null) ? 0 : qty.hashCode());
		result = prime * result
				+ ((salesOrderNo == null) ? 0 : salesOrderNo.hashCode());
		result = prime * result
				+ ((sizeBackup == null) ? 0 : sizeBackup.hashCode());
		return result;
	}

    @Override
	public String toString() {
		return "Merordersheetorder [id=" + id + ", orderNo=" + orderNo
				+ ", ordersheetCategory=" + ordersheetCategory + ", buyerPo="
				+ buyerPo + ", qty=" + qty + ", sizeBackup=" + sizeBackup
				+ ", orderStatus=" + orderStatus + ", allocation=" + allocation
				+ ", salesOrderNo=" + salesOrderNo + "]";
	}

}
