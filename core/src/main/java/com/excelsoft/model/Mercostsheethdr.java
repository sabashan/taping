package com.excelsoft.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;

@Entity
@Table(name="mercostsheethdr")
@XmlRootElement
public class Mercostsheethdr extends AuditFields implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 722789363256267927L;
	private MercostsheethdrId id;
    private Merprecostsheet merprecostsheethdr;
    private Mststyleheader mststyleheader;
    private String season;
    private Date createDate;
    private Boolean compWiseCost;
    private Long totalSmv;
    private String flag;
    private String baseBody;
    private String buyerReference;
//    private String fmvCategory;
//    private Long fmv;
//    private BigDecimal lineEfficency;
    private String merchandiser;
    private Mstcurrency costSheetCurrency;
    private Long costSheetExchangeRate;
    private Boolean averageWiseCost;
    private Boolean countryWiseCost;
    private Boolean sizeWiseCost;
    private Mstcurrency dftRmCurrency;
    private Long dftRmExchangeRate;
    private Boolean isCurrencyLocked;
    private Boolean isHeaderLoced;
    private BigDecimal orderQty;
//    private Set<Mercostsheetdemmap> mercostsheetdemmaps = new HashSet<Mercostsheetdemmap>(0);
//    private Set<Mercostsheetgroup> mercostsheetgroups = new HashSet<Mercostsheetgroup>(0);
//    private Set<Mercostsheetcurrency> mercostsheetcurrencies = new HashSet<Mercostsheetcurrency>(0);
//    private Set<Mercostsheetunapprovedloged> mercostsheetunapprovedlogeds = new HashSet<Mercostsheetunapprovedloged>(0);
//    private Set<Mercostsheetcountry> mercostsheetcountries = new HashSet<Mercostsheetcountry>(0);
    
    public Mercostsheethdr() {
		super();
		// TODO Auto-generated constructor stub
	}

 
   

	public Mercostsheethdr(MercostsheethdrId id,
		Merprecostsheet merprecostsheethdr, Mststyleheader mststyleheader,
		String season, Date createDate, Boolean compWiseCost, Long totalSmv,
		String flag, String baseBody, String buyerReference,
		String merchandiser, Mstcurrency costSheetCurrency,
		Long costSheetExchangeRate, Boolean averageWiseCost,
		Boolean countryWiseCost, Boolean sizeWiseCost,
		Mstcurrency dftRmCurrency, Long dftRmExchangeRate,
		Boolean isCurrencyLocked, Boolean isHeaderLoced, BigDecimal orderQty) {
	super();
	this.id = id;
	this.merprecostsheethdr = merprecostsheethdr;
	this.mststyleheader = mststyleheader;
	this.season = season;
	this.createDate = createDate;
	this.compWiseCost = compWiseCost;
	this.totalSmv = totalSmv;
	this.flag = flag;
	this.baseBody = baseBody;
	this.buyerReference = buyerReference;
	this.merchandiser = merchandiser;
	this.costSheetCurrency = costSheetCurrency;
	this.costSheetExchangeRate = costSheetExchangeRate;
	this.averageWiseCost = averageWiseCost;
	this.countryWiseCost = countryWiseCost;
	this.sizeWiseCost = sizeWiseCost;
	this.dftRmCurrency = dftRmCurrency;
	this.dftRmExchangeRate = dftRmExchangeRate;
	this.isCurrencyLocked = isCurrencyLocked;
	this.isHeaderLoced = isHeaderLoced;
	this.orderQty = orderQty;
}




	@EmbeddedId @DocumentId    
    public MercostsheethdrId getId() {
        return this.id;
    }

	public void setId(MercostsheethdrId id) {
        this.id = id;
    }
	
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumns( { 
        @JoinColumn(name="pre_cost_sheet_type", referencedColumnName="costsheet_type", columnDefinition="CHAR(10)", nullable=true), 
        @JoinColumn(name="pre_cost_sheet_no", referencedColumnName="pre_cost_sheet_no", columnDefinition="CHAR(15)", nullable=true), 
        @JoinColumn(name="pre_cost_version_no", referencedColumnName="version_no", columnDefinition="DECIMAL(10,0)", nullable=true) } )
    public Merprecostsheet getMerprecostsheethdr() {
        return this.merprecostsheethdr;
    }
    
    public void setMerprecostsheethdr(Merprecostsheet merprecostsheethdr) {
        this.merprecostsheethdr = merprecostsheethdr;
    }
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumns( { 
        @JoinColumn(name="comp_code", referencedColumnName="comp_code", nullable=false), 
        @JoinColumn(name="cust_code", referencedColumnName="cust_code", nullable=false), 
        @JoinColumn(name="dep_code", referencedColumnName="dep_code", nullable=false), 
        @JoinColumn(name="location_code", referencedColumnName="location_code", nullable=false), 
        @JoinColumn(name="style_id", referencedColumnName="style_id", nullable=false) } )
    public Mststyleheader getMststyleheader() {
        return this.mststyleheader;
    }
    
    public void setMststyleheader(Mststyleheader mststyleheader) {
        this.mststyleheader = mststyleheader;
    }
    
    @Column(name="season", nullable=false, length=10, columnDefinition="CHAR(10)")
    @Field
    public String getSeason() {
        return this.season;
    }
    
    public void setSeason(String season) {
        this.season = season;
    }
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="create_date", length=19)
    @Field
    public Date getCreateDate() {
        return this.createDate;
    }
    
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    @Column(name="base_body", length=10, columnDefinition="CHAR(10)")
    @Field
    public String getBaseBody() {
        return this.baseBody;
    }
    
    public void setBaseBody(String baseBody) {
        this.baseBody = baseBody;
    }

    @Column(name="buyer_reference", length=255, columnDefinition="CHAR(255)")
    @Field
    public String getBuyerReference() {
        return this.buyerReference;
    }
    
    public void setBuyerReference(String buyerReference) {
        this.buyerReference = buyerReference;
    }
   

	@Column(name="comp_wise_cost")
    @Field
    public Boolean getCompWiseCost() {
        return this.compWiseCost;
    }
    
    public void setCompWiseCost(Boolean compWiseCost) {
        this.compWiseCost = compWiseCost;
    }
    
    @Column(name="total_smv", precision=10, scale=0, columnDefinition="DECIMAL(10,0)")
    @Field
    public Long getTotalSmv() {
        return this.totalSmv;
    }
    
    public void setTotalSmv(Long totalSmv) {
        this.totalSmv = totalSmv;
    }
    
    @Column(name="flag", length=10 ,columnDefinition="CHAR(10)")
    @Field
    public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
	
    /*
    @Column(name="fmv_category", length=10)
    @Field
    public String getFmvCategory() {
        return this.fmvCategory;
    }
    
    public void setFmvCategory(String fmvCategory) {
        this.fmvCategory = fmvCategory;
    }
    
    @Column(name="fmv", precision=10, scale=0)
    @Field
    public Long getFmv() {
        return this.fmv;
    }
    
    public void setFmv(Long fmv) {
        this.fmv = fmv;
    }
    
    @Column(name="line_efficency", precision=20, scale=6)
    @Field
    public BigDecimal getLineEfficency() {
        return this.lineEfficency;
    }
    
    public void setLineEfficency(BigDecimal lineEfficency) {
        this.lineEfficency = lineEfficency;
    }
    */
    @Column(name="merchandiser", length=50, columnDefinition="CHAR(50)")
    @Field
    public String getMerchandiser() {
        return this.merchandiser;
    }
    
    public void setMerchandiser(String merchandiser) {
        this.merchandiser = merchandiser;
    }
    
    @ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cost_sheet_currency")
    public Mstcurrency getCostSheetCurrency() {
        return this.costSheetCurrency;
    }
    
    public void setCostSheetCurrency(Mstcurrency costSheetCurrency) {
        this.costSheetCurrency = costSheetCurrency;
    }
    
    @Column(name="cost_sheet_exchange_rate", precision=10, scale=0, columnDefinition="DECIMAL(10)")
    @Field
    public Long getCostSheetExchangeRate() {
        return this.costSheetExchangeRate;
    }
    
    public void setCostSheetExchangeRate(Long costSheetExchangeRate) {
        this.costSheetExchangeRate = costSheetExchangeRate;
    }
    
    @Column(name="average_wise_cost")
    @Field
    public Boolean getAverageWiseCost() {
        return this.averageWiseCost;
    }
    
    public void setAverageWiseCost(Boolean averageWiseCost) {
        this.averageWiseCost = averageWiseCost;
    }
    
    @Column(name="country_wise_cost")
    @Field
    public Boolean getCountryWiseCost() {
        return this.countryWiseCost;
    }
    
    public void setCountryWiseCost(Boolean countryWiseCost) {
        this.countryWiseCost = countryWiseCost;
    }
    
    @Column(name="size_wise_cost")
    @Field
    public Boolean getSizeWiseCost() {
        return this.sizeWiseCost;
    }
    
    public void setSizeWiseCost(Boolean sizeWiseCost) {
        this.sizeWiseCost = sizeWiseCost;
    }
    
    @ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="dft_rm_currency")
    public Mstcurrency getDftRmCurrency() {
        return this.dftRmCurrency;
    }
    
    public void setDftRmCurrency(Mstcurrency dftRmCurrency) {
        this.dftRmCurrency = dftRmCurrency;
    }
    
    @Column(name="dft_rm_exchange_rate", precision=10, scale=0,columnDefinition="DECIMAL(10)")
    @Field
    public Long getDftRmExchangeRate() {
        return this.dftRmExchangeRate;
    }
    
    public void setDftRmExchangeRate(Long dftRmExchangeRate) {
        this.dftRmExchangeRate = dftRmExchangeRate;
    }
    
    @Column(name="is_currency_locked")
    @Field
    public Boolean getIsCurrencyLocked() {
        return this.isCurrencyLocked;
    }
    
    public void setIsCurrencyLocked(Boolean isCurrencyLocked) {
        this.isCurrencyLocked = isCurrencyLocked;
    }
    
    @Column(name="is_header_loced")
    @Field
    public Boolean getIsHeaderLoced() {
        return this.isHeaderLoced;
    }
    
    public void setIsHeaderLoced(Boolean isHeaderLoced) {
        this.isHeaderLoced = isHeaderLoced;
    }

    @Column(name="order_qty", precision=10, scale=0 ,columnDefinition="DECIMAL(10)")
    @Field
    public BigDecimal getOrderQty() {
		return orderQty;
	}

	public void setOrderQty(BigDecimal orderQty) {
		this.orderQty = orderQty;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((averageWiseCost == null) ? 0 : averageWiseCost.hashCode());
		result = prime * result
				+ ((baseBody == null) ? 0 : baseBody.hashCode());
		result = prime * result
				+ ((buyerReference == null) ? 0 : buyerReference.hashCode());
		result = prime * result
				+ ((compWiseCost == null) ? 0 : compWiseCost.hashCode());
		result = prime
				* result
				+ ((costSheetExchangeRate == null) ? 0 : costSheetExchangeRate
						.hashCode());
		result = prime * result
				+ ((countryWiseCost == null) ? 0 : countryWiseCost.hashCode());
		result = prime * result
				+ ((createDate == null) ? 0 : createDate.hashCode());
		result = prime
				* result
				+ ((dftRmExchangeRate == null) ? 0 : dftRmExchangeRate
						.hashCode());
		result = prime * result + ((flag == null) ? 0 : flag.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime
				* result
				+ ((isCurrencyLocked == null) ? 0 : isCurrencyLocked.hashCode());
		result = prime * result
				+ ((isHeaderLoced == null) ? 0 : isHeaderLoced.hashCode());
		result = prime * result
				+ ((merchandiser == null) ? 0 : merchandiser.hashCode());
		result = prime * result
				+ ((orderQty == null) ? 0 : orderQty.hashCode());
		result = prime * result + ((season == null) ? 0 : season.hashCode());
		result = prime * result
				+ ((sizeWiseCost == null) ? 0 : sizeWiseCost.hashCode());
		result = prime * result
				+ ((totalSmv == null) ? 0 : totalSmv.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mercostsheethdr other = (Mercostsheethdr) obj;
		if (averageWiseCost == null) {
			if (other.averageWiseCost != null)
				return false;
		} else if (!averageWiseCost.equals(other.averageWiseCost))
			return false;
		if (baseBody == null) {
			if (other.baseBody != null)
				return false;
		} else if (!baseBody.equals(other.baseBody))
			return false;
		if (buyerReference == null) {
			if (other.buyerReference != null)
				return false;
		} else if (!buyerReference.equals(other.buyerReference))
			return false;
		if (compWiseCost == null) {
			if (other.compWiseCost != null)
				return false;
		} else if (!compWiseCost.equals(other.compWiseCost))
			return false;
		if (costSheetExchangeRate == null) {
			if (other.costSheetExchangeRate != null)
				return false;
		} else if (!costSheetExchangeRate.equals(other.costSheetExchangeRate))
			return false;
		if (countryWiseCost == null) {
			if (other.countryWiseCost != null)
				return false;
		} else if (!countryWiseCost.equals(other.countryWiseCost))
			return false;
		if (createDate == null) {
			if (other.createDate != null)
				return false;
		} else if (!createDate.equals(other.createDate))
			return false;
		if (dftRmExchangeRate == null) {
			if (other.dftRmExchangeRate != null)
				return false;
		} else if (!dftRmExchangeRate.equals(other.dftRmExchangeRate))
			return false;
		if (flag == null) {
			if (other.flag != null)
				return false;
		} else if (!flag.equals(other.flag))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isCurrencyLocked == null) {
			if (other.isCurrencyLocked != null)
				return false;
		} else if (!isCurrencyLocked.equals(other.isCurrencyLocked))
			return false;
		if (isHeaderLoced == null) {
			if (other.isHeaderLoced != null)
				return false;
		} else if (!isHeaderLoced.equals(other.isHeaderLoced))
			return false;
		if (merchandiser == null) {
			if (other.merchandiser != null)
				return false;
		} else if (!merchandiser.equals(other.merchandiser))
			return false;
		if (orderQty == null) {
			if (other.orderQty != null)
				return false;
		} else if (!orderQty.equals(other.orderQty))
			return false;
		if (season == null) {
			if (other.season != null)
				return false;
		} else if (!season.equals(other.season))
			return false;
		if (sizeWiseCost == null) {
			if (other.sizeWiseCost != null)
				return false;
		} else if (!sizeWiseCost.equals(other.sizeWiseCost))
			return false;
		if (totalSmv == null) {
			if (other.totalSmv != null)
				return false;
		} else if (!totalSmv.equals(other.totalSmv))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Mercostsheethdr [id=");
		builder.append(id);
		builder.append(", season=");
		builder.append(season);
		builder.append(", createDate=");
		builder.append(createDate);
		builder.append(", compWiseCost=");
		builder.append(compWiseCost);
		builder.append(", totalSmv=");
		builder.append(totalSmv);
		builder.append(", flag=");
		builder.append(flag);
		builder.append(", baseBody=");
		builder.append(baseBody);
		builder.append(", buyerReference=");
		builder.append(buyerReference);
		builder.append(", merchandiser=");
		builder.append(merchandiser);
		builder.append(", costSheetExchangeRate=");
		builder.append(costSheetExchangeRate);
		builder.append(", averageWiseCost=");
		builder.append(averageWiseCost);
		builder.append(", countryWiseCost=");
		builder.append(countryWiseCost);
		builder.append(", sizeWiseCost=");
		builder.append(sizeWiseCost);
		builder.append(", dftRmExchangeRate=");
		builder.append(dftRmExchangeRate);
		builder.append(", isCurrencyLocked=");
		builder.append(isCurrencyLocked);
		builder.append(", isHeaderLoced=");
		builder.append(isHeaderLoced);
		builder.append(", orderQty=");
		builder.append(orderQty);
		builder.append("]");
		return builder.toString();
	}
	
	
}
