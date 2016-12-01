package com.excelsoft.model;

import com.excelsoft.model.BaseObject;

import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

import java.math.BigDecimal;
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
@Table(name="mstlocation")
@Indexed
@XmlRootElement
public class Mstlocation extends BaseObject implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -836135391743818876L;
	private String locationCode;
    private String locationName;
    private String locationAddr;
    private String locationType;
    private String telNo;
    private String faxNo;
    private String emailAddr;
    private String contactName;
    private Date stockOpBalDate;
    private String tinNo;
    private String regNo;
    private String tqbNo;
    private BigDecimal totMachAvail;
    private BigDecimal totalAvailableMinutes;
    private BigDecimal totalOperators;
    private BigDecimal costPerMachinePerDay;
    private String bondingRegno;
    private String compCode;
    private String vendorNo;
    private String createdBy;
    private Date createdOn;
    private String createdAt;
    private String modifiedBy;
    private Date modifiedOn;
    private String modifiedAt;
    private String calendarLocationCode;
    private String calendarname;
    private String procPrgCode;
    private BigDecimal locationNo;
    private String documentationDesc;
    private Character factoryYn;
    private String importTqbNo;
    private BigDecimal minuteValue;
    private String assetIdPrefix;
    private String level1;
    private String level2;
    private String internalSub;

    
    
    public Mstlocation(String locationCode) {
		super();
		this.locationCode = locationCode;
	}

	public Mstlocation() {
		super();
	}

	

	@Id  @DocumentId    
	@Column(name="location_code" , length=6 ,columnDefinition="CHAR(6)")
    public String getLocationCode() {
        return this.locationCode;
    }
    
    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }
    
    @Column(name="location_name", nullable=false, length=40 ,columnDefinition="CHAR(40)")
    @Field
    public String getLocationName() {
        return this.locationName;
    }
    
    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }
    
    @Column(name="location_addr", nullable=false, length=100 ,columnDefinition="CHAR(100)")
    @Field
    public String getLocationAddr() {
        return this.locationAddr;
    }
    
    public void setLocationAddr(String locationAddr) {
        this.locationAddr = locationAddr;
    }
    
    @Column(name="location_type", nullable=false, length=1  ,columnDefinition="CHAR(1)")
    @Field
    public String getLocationType() {
        return this.locationType;
    }
    
    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }
    
    @Column(name="tel_no", nullable=false, length=20 ,columnDefinition="CHAR(20)")
    @Field
    public String getTelNo() {
        return this.telNo;
    }
    
    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }
    
    @Column(name="fax_no", nullable=false, length=20 ,columnDefinition="CHAR(20)")
    @Field
    public String getFaxNo() {
        return this.faxNo;
    }
    
    public void setFaxNo(String faxNo) {
        this.faxNo = faxNo;
    }
    
    @Column(name="email_addr", nullable=false, length=20 ,columnDefinition="CHAR(20)")
    @Field
    public String getEmailAddr() {
        return this.emailAddr;
    }
    
    public void setEmailAddr(String emailAddr) {
        this.emailAddr = emailAddr;
    }
    
    @Column(name="contact_name", nullable=false, length=30 ,columnDefinition="CHAR(30)")
    @Field
    public String getContactName() {
        return this.contactName;
    }
    
    public void setContactName(String contactName) {
        this.contactName = contactName;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="stock_op_bal_date", length=10)
    @Field
    public Date getStockOpBalDate() {
        return this.stockOpBalDate;
    }
    
    public void setStockOpBalDate(Date stockOpBalDate) {
        this.stockOpBalDate = stockOpBalDate;
    }
    
    @Column(name="tin_no", length=20 ,columnDefinition="CHAR(20)")
    @Field
    public String getTinNo() {
        return this.tinNo;
    }
    
    public void setTinNo(String tinNo) {
        this.tinNo = tinNo;
    }
    
    @Column(name="reg_no", length=20 ,columnDefinition="CHAR(20)")
    @Field
    public String getRegNo() {
        return this.regNo;
    }
    
    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }
    
    @Column(name="tqb_no", length=20 ,columnDefinition="CHAR(20)")
    @Field
    public String getTqbNo() {
        return this.tqbNo;
    }
    
    public void setTqbNo(String tqbNo) {
        this.tqbNo = tqbNo;
    }
    
    @Column(name="tot_mach_avail", precision=20, scale=6)
    @Field
    public BigDecimal getTotMachAvail() {
        return this.totMachAvail;
    }
    
    public void setTotMachAvail(BigDecimal totMachAvail) {
        this.totMachAvail = totMachAvail;
    }
    
    @Column(name="total_available_minutes", precision=20, scale=6)
    @Field
    public BigDecimal getTotalAvailableMinutes() {
        return this.totalAvailableMinutes;
    }
    
    public void setTotalAvailableMinutes(BigDecimal totalAvailableMinutes) {
        this.totalAvailableMinutes = totalAvailableMinutes;
    }
    
    @Column(name="total_operators", precision=20, scale=6)
    @Field
    public BigDecimal getTotalOperators() {
        return this.totalOperators;
    }
    
    public void setTotalOperators(BigDecimal totalOperators) {
        this.totalOperators = totalOperators;
    }
    
    @Column(name="cost_per_machine_per_day", precision=20, scale=6)
    @Field
    public BigDecimal getCostPerMachinePerDay() {
        return this.costPerMachinePerDay;
    }
    
    public void setCostPerMachinePerDay(BigDecimal costPerMachinePerDay) {
        this.costPerMachinePerDay = costPerMachinePerDay;
    }
    
    @Column(name="bonding_regno", length=30 ,columnDefinition="CHAR(30)")
    @Field
    public String getBondingRegno() {
        return this.bondingRegno;
    }
    
    public void setBondingRegno(String bondingRegno) {
        this.bondingRegno = bondingRegno;
    }
    
    @Column(name="comp_code", length=6 ,columnDefinition="CHAR(6)")
    @Field
    public String getCompCode() {
        return this.compCode;
    }
    
    public void setCompCode(String compCode) {
        this.compCode = compCode;
    }
    
    @Column(name="vendor_no", length=10 ,columnDefinition="CHAR(10)")
    @Field
    public String getVendorNo() {
        return this.vendorNo;
    }
    
    public void setVendorNo(String vendorNo) {
        this.vendorNo = vendorNo;
    }
    
    @Column(name="created_by", length=10 ,columnDefinition="CHAR(10)")
    @Field
    public String getCreatedBy() {
        return this.createdBy;
    }
    
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created_on", length=19)
    @Field
    public Date getCreatedOn() {
        return this.createdOn;
    }
    
    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }
    
    @Column(name="created_at", length=10 ,columnDefinition="CHAR(10)")
    @Field
    public String getCreatedAt() {
        return this.createdAt;
    }
    
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
    
    @Column(name="modified_by", length=10 ,columnDefinition="CHAR(10)")
    @Field
    public String getModifiedBy() {
        return this.modifiedBy;
    }
    
    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="modified_on", length=19)
    @Field
    public Date getModifiedOn() {
        return this.modifiedOn;
    }
    
    public void setModifiedOn(Date modifiedOn) {
        this.modifiedOn = modifiedOn;
    }
    
    @Column(name="modified_at", length=10 ,columnDefinition="CHAR(10)")
    @Field
    public String getModifiedAt() {
        return this.modifiedAt;
    }
    
    public void setModifiedAt(String modifiedAt) {
        this.modifiedAt = modifiedAt;
    }
    
    @Column(name="calendar_location_code", length=6 ,columnDefinition="CHAR(6)")
    @Field
    public String getCalendarLocationCode() {
        return this.calendarLocationCode;
    }
    
    public void setCalendarLocationCode(String calendarLocationCode) {
        this.calendarLocationCode = calendarLocationCode;
    }
    
    @Column(name="calendarname", length=20 ,columnDefinition="CHAR(20)")
    @Field
    public String getCalendarname() {
        return this.calendarname;
    }
    
    public void setCalendarname(String calendarname) {
        this.calendarname = calendarname;
    }
    
    @Column(name="proc_prg_code", length=15 ,columnDefinition="CHAR(15)")
    @Field
    public String getProcPrgCode() {
        return this.procPrgCode;
    }
    
    public void setProcPrgCode(String procPrgCode) {
        this.procPrgCode = procPrgCode;
    }
    
    @Column(name="location_no", precision=2, scale=0)
    @Field
    public BigDecimal getLocationNo() {
        return this.locationNo;
    }
    
    public void setLocationNo(BigDecimal locationNo) {
        this.locationNo = locationNo;
    }
    
    @Column(name="Documentation_desc", length=40 ,columnDefinition="CHAR(40)")
    @Field
    public String getDocumentationDesc() {
        return this.documentationDesc;
    }
    
    public void setDocumentationDesc(String documentationDesc) {
        this.documentationDesc = documentationDesc;
    }
    
    @Column(name="factory_yn", length=1)
    @Field
    public Character getFactoryYn() {
        return this.factoryYn;
    }
    
    public void setFactoryYn(Character factoryYn) {
        this.factoryYn = factoryYn;
    }
    
    @Column(name="import_tqb_no", length=20 ,columnDefinition="CHAR(20)")
    @Field
    public String getImportTqbNo() {
        return this.importTqbNo;
    }
    
    public void setImportTqbNo(String importTqbNo) {
        this.importTqbNo = importTqbNo;
    }
    
    @Column(name="minute_value", precision=20, scale=6)
    @Field
    public BigDecimal getMinuteValue() {
        return this.minuteValue;
    }
    
    public void setMinuteValue(BigDecimal minuteValue) {
        this.minuteValue = minuteValue;
    }
    
    @Column(name="asset_id_prefix", length=2 ,columnDefinition="CHAR(2)")
    @Field
    public String getAssetIdPrefix() {
        return this.assetIdPrefix;
    }
    
    public void setAssetIdPrefix(String assetIdPrefix) {
        this.assetIdPrefix = assetIdPrefix;
    }
    
    @Column(name="level_1", length=3 ,columnDefinition="CHAR(3)")
    @Field
    public String getLevel1() {
        return this.level1;
    }
    
    public void setLevel1(String level1) {
        this.level1 = level1;
    }
    
    @Column(name="level_2", length=3 ,columnDefinition="CHAR(3)")
    @Field
    public String getLevel2() {
        return this.level2;
    }
    
    public void setLevel2(String level2) {
        this.level2 = level2;
    }
    
    @Column(name="internal_sub", length=1 ,columnDefinition="CHAR(1)")
    @Field
    public String getInternalSub() {
        return this.internalSub;
    }
    
    public void setInternalSub(String internalSub) {
        this.internalSub = internalSub;
    }

    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mstlocation other = (Mstlocation) obj;
		if (assetIdPrefix == null) {
			if (other.assetIdPrefix != null)
				return false;
		} else if (!assetIdPrefix.equals(other.assetIdPrefix))
			return false;
		if (bondingRegno == null) {
			if (other.bondingRegno != null)
				return false;
		} else if (!bondingRegno.equals(other.bondingRegno))
			return false;
		if (calendarLocationCode == null) {
			if (other.calendarLocationCode != null)
				return false;
		} else if (!calendarLocationCode.equals(other.calendarLocationCode))
			return false;
		if (calendarname == null) {
			if (other.calendarname != null)
				return false;
		} else if (!calendarname.equals(other.calendarname))
			return false;
		if (compCode == null) {
			if (other.compCode != null)
				return false;
		} else if (!compCode.equals(other.compCode))
			return false;
		if (contactName == null) {
			if (other.contactName != null)
				return false;
		} else if (!contactName.equals(other.contactName))
			return false;
		if (costPerMachinePerDay == null) {
			if (other.costPerMachinePerDay != null)
				return false;
		} else if (!costPerMachinePerDay.equals(other.costPerMachinePerDay))
			return false;
		if (createdAt == null) {
			if (other.createdAt != null)
				return false;
		} else if (!createdAt.equals(other.createdAt))
			return false;
		if (createdBy == null) {
			if (other.createdBy != null)
				return false;
		} else if (!createdBy.equals(other.createdBy))
			return false;
		if (createdOn == null) {
			if (other.createdOn != null)
				return false;
		} else if (!createdOn.equals(other.createdOn))
			return false;
		if (documentationDesc == null) {
			if (other.documentationDesc != null)
				return false;
		} else if (!documentationDesc.equals(other.documentationDesc))
			return false;
		if (emailAddr == null) {
			if (other.emailAddr != null)
				return false;
		} else if (!emailAddr.equals(other.emailAddr))
			return false;
		if (factoryYn == null) {
			if (other.factoryYn != null)
				return false;
		} else if (!factoryYn.equals(other.factoryYn))
			return false;
		if (faxNo == null) {
			if (other.faxNo != null)
				return false;
		} else if (!faxNo.equals(other.faxNo))
			return false;
		if (importTqbNo == null) {
			if (other.importTqbNo != null)
				return false;
		} else if (!importTqbNo.equals(other.importTqbNo))
			return false;
		if (internalSub == null) {
			if (other.internalSub != null)
				return false;
		} else if (!internalSub.equals(other.internalSub))
			return false;
		if (level1 == null) {
			if (other.level1 != null)
				return false;
		} else if (!level1.equals(other.level1))
			return false;
		if (level2 == null) {
			if (other.level2 != null)
				return false;
		} else if (!level2.equals(other.level2))
			return false;
		if (locationAddr == null) {
			if (other.locationAddr != null)
				return false;
		} else if (!locationAddr.equals(other.locationAddr))
			return false;
		if (locationCode == null) {
			if (other.locationCode != null)
				return false;
		} else if (!locationCode.equals(other.locationCode))
			return false;
		if (locationName == null) {
			if (other.locationName != null)
				return false;
		} else if (!locationName.equals(other.locationName))
			return false;
		if (locationNo == null) {
			if (other.locationNo != null)
				return false;
		} else if (!locationNo.equals(other.locationNo))
			return false;
		if (locationType == null) {
			if (other.locationType != null)
				return false;
		} else if (!locationType.equals(other.locationType))
			return false;
		if (minuteValue == null) {
			if (other.minuteValue != null)
				return false;
		} else if (!minuteValue.equals(other.minuteValue))
			return false;
		if (modifiedAt == null) {
			if (other.modifiedAt != null)
				return false;
		} else if (!modifiedAt.equals(other.modifiedAt))
			return false;
		if (modifiedBy == null) {
			if (other.modifiedBy != null)
				return false;
		} else if (!modifiedBy.equals(other.modifiedBy))
			return false;
		if (modifiedOn == null) {
			if (other.modifiedOn != null)
				return false;
		} else if (!modifiedOn.equals(other.modifiedOn))
			return false;
		if (procPrgCode == null) {
			if (other.procPrgCode != null)
				return false;
		} else if (!procPrgCode.equals(other.procPrgCode))
			return false;
		if (regNo == null) {
			if (other.regNo != null)
				return false;
		} else if (!regNo.equals(other.regNo))
			return false;
		if (stockOpBalDate == null) {
			if (other.stockOpBalDate != null)
				return false;
		} else if (!stockOpBalDate.equals(other.stockOpBalDate))
			return false;
		if (telNo == null) {
			if (other.telNo != null)
				return false;
		} else if (!telNo.equals(other.telNo))
			return false;
		if (tinNo == null) {
			if (other.tinNo != null)
				return false;
		} else if (!tinNo.equals(other.tinNo))
			return false;
		if (totMachAvail == null) {
			if (other.totMachAvail != null)
				return false;
		} else if (!totMachAvail.equals(other.totMachAvail))
			return false;
		if (totalAvailableMinutes == null) {
			if (other.totalAvailableMinutes != null)
				return false;
		} else if (!totalAvailableMinutes.equals(other.totalAvailableMinutes))
			return false;
		if (totalOperators == null) {
			if (other.totalOperators != null)
				return false;
		} else if (!totalOperators.equals(other.totalOperators))
			return false;
		if (tqbNo == null) {
			if (other.tqbNo != null)
				return false;
		} else if (!tqbNo.equals(other.tqbNo))
			return false;
		if (vendorNo == null) {
			if (other.vendorNo != null)
				return false;
		} else if (!vendorNo.equals(other.vendorNo))
			return false;
		return true;
	}

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((assetIdPrefix == null) ? 0 : assetIdPrefix.hashCode());
		result = prime * result
				+ ((bondingRegno == null) ? 0 : bondingRegno.hashCode());
		result = prime
				* result
				+ ((calendarLocationCode == null) ? 0 : calendarLocationCode
						.hashCode());
		result = prime * result
				+ ((calendarname == null) ? 0 : calendarname.hashCode());
		result = prime * result
				+ ((compCode == null) ? 0 : compCode.hashCode());
		result = prime * result
				+ ((contactName == null) ? 0 : contactName.hashCode());
		result = prime
				* result
				+ ((costPerMachinePerDay == null) ? 0 : costPerMachinePerDay
						.hashCode());
		result = prime * result
				+ ((createdAt == null) ? 0 : createdAt.hashCode());
		result = prime * result
				+ ((createdBy == null) ? 0 : createdBy.hashCode());
		result = prime * result
				+ ((createdOn == null) ? 0 : createdOn.hashCode());
		result = prime
				* result
				+ ((documentationDesc == null) ? 0 : documentationDesc
						.hashCode());
		result = prime * result
				+ ((emailAddr == null) ? 0 : emailAddr.hashCode());
		result = prime * result
				+ ((factoryYn == null) ? 0 : factoryYn.hashCode());
		result = prime * result + ((faxNo == null) ? 0 : faxNo.hashCode());
		result = prime * result
				+ ((importTqbNo == null) ? 0 : importTqbNo.hashCode());
		result = prime * result
				+ ((internalSub == null) ? 0 : internalSub.hashCode());
		result = prime * result + ((level1 == null) ? 0 : level1.hashCode());
		result = prime * result + ((level2 == null) ? 0 : level2.hashCode());
		result = prime * result
				+ ((locationAddr == null) ? 0 : locationAddr.hashCode());
		result = prime * result
				+ ((locationCode == null) ? 0 : locationCode.hashCode());
		result = prime * result
				+ ((locationName == null) ? 0 : locationName.hashCode());
		result = prime * result
				+ ((locationNo == null) ? 0 : locationNo.hashCode());
		result = prime * result
				+ ((locationType == null) ? 0 : locationType.hashCode());
		result = prime * result
				+ ((minuteValue == null) ? 0 : minuteValue.hashCode());
		result = prime * result
				+ ((modifiedAt == null) ? 0 : modifiedAt.hashCode());
		result = prime * result
				+ ((modifiedBy == null) ? 0 : modifiedBy.hashCode());
		result = prime * result
				+ ((modifiedOn == null) ? 0 : modifiedOn.hashCode());
		result = prime * result
				+ ((procPrgCode == null) ? 0 : procPrgCode.hashCode());
		result = prime * result + ((regNo == null) ? 0 : regNo.hashCode());
		result = prime * result
				+ ((stockOpBalDate == null) ? 0 : stockOpBalDate.hashCode());
		result = prime * result + ((telNo == null) ? 0 : telNo.hashCode());
		result = prime * result + ((tinNo == null) ? 0 : tinNo.hashCode());
		result = prime * result
				+ ((totMachAvail == null) ? 0 : totMachAvail.hashCode());
		result = prime
				* result
				+ ((totalAvailableMinutes == null) ? 0 : totalAvailableMinutes
						.hashCode());
		result = prime * result
				+ ((totalOperators == null) ? 0 : totalOperators.hashCode());
		result = prime * result + ((tqbNo == null) ? 0 : tqbNo.hashCode());
		result = prime * result
				+ ((vendorNo == null) ? 0 : vendorNo.hashCode());
		return result;
	}

    @Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Mstlocation [locationCode=").append(locationCode)
				.append(", locationName=").append(locationName)
				.append(", locationAddr=").append(locationAddr)
				.append(", locationType=").append(locationType)
				.append(", telNo=").append(telNo).append(", faxNo=")
				.append(faxNo).append(", emailAddr=").append(emailAddr)
				.append(", contactName=").append(contactName)
				.append(", stockOpBalDate=").append(stockOpBalDate)
				.append(", tinNo=").append(tinNo).append(", regNo=")
				.append(regNo).append(", tqbNo=").append(tqbNo)
				.append(", totMachAvail=").append(totMachAvail)
				.append(", totalAvailableMinutes=")
				.append(totalAvailableMinutes).append(", totalOperators=")
				.append(totalOperators).append(", costPerMachinePerDay=")
				.append(costPerMachinePerDay).append(", bondingRegno=")
				.append(bondingRegno).append(", compCode=").append(compCode)
				.append(", vendorNo=").append(vendorNo).append(", createdBy=")
				.append(createdBy).append(", createdOn=").append(createdOn)
				.append(", createdAt=").append(createdAt)
				.append(", modifiedBy=").append(modifiedBy)
				.append(", modifiedOn=").append(modifiedOn)
				.append(", modifiedAt=").append(modifiedAt)
				.append(", calendarLocationCode=").append(calendarLocationCode)
				.append(", calendarname=").append(calendarname)
				.append(", procPrgCode=").append(procPrgCode)
				.append(", locationNo=").append(locationNo)
				.append(", documentationDesc=").append(documentationDesc)
				.append(", factoryYn=").append(factoryYn)
				.append(", importTqbNo=").append(importTqbNo)
				.append(", minuteValue=").append(minuteValue)
				.append(", assetIdPrefix=").append(assetIdPrefix)
				.append(", level1=").append(level1).append(", level2=")
				.append(level2).append(", internalSub=").append(internalSub)
				.append("]");
		return builder.toString();
	}

}
