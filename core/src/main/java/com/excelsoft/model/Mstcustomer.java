package com.excelsoft.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

@Entity
@Table(name="mstcustomer")
@Indexed
@XmlRootElement
public class Mstcustomer extends BaseObject implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -247369744442793951L;
	private String custCode;
    private String boiRegno;
    private String buyerEmail;
    private String chequeName;
    private String contactName;
    private String crTerm;
    private String createdAt;
    private String createdBy;
    private Date createdOn;
    private Long creditLimit;
    private String custAddress;
    private String custName;
    private String custReference;
    private String custType;
    private String dtFormat;
    private String emailAddress;
    private Long extDiscPer;
    private Long factoryDayvalue;
    private String faxNo;
    private Long financeAmt;
    private Long fobValue;
    private String glCtrlAcc;
    private Character importFr;
    private Long intDiscPer;
    private String invCustCode;
    private Long markupPercentage;
    private Long maxQtyallowPcn;
    private Long minimumPack;
    private String modifiedAt;
    private String modifiedBy;
    private Date modifiedOn;
    private Boolean numberofDecimal;
    private Long ocdComm;
    private Long othComm;
    private String ownerShip;
    private String salesGlCode;
    private String taxNo;
    private String telNo;
    private String tlxNo;
    private String tqbNo;
    private Character trackingReference;
    private Integer costsheetValidDays;
    
    
    public Mstcustomer(String custCode) {
		super();
		this.custCode = custCode;
	}

	public Mstcustomer() {
		super();
	}


	@Id  @DocumentId    
	 @Column(name="cust_code",length=6 ,columnDefinition="CHAR(6)" )
    public String getCustCode() {
        return this.custCode;
    }
    
    public void setCustCode(String custCode) {
        this.custCode = custCode;
    }
    
    @Column(name="boi_regno", length=8 )
    @Field
    public String getBoiRegno() {
        return this.boiRegno;
    }
    
    public void setBoiRegno(String boiRegno) {
        this.boiRegno = boiRegno;
    }
    
    @Column(name="buyer_email", length=50 )
    @Field
    public String getBuyerEmail() {
        return this.buyerEmail;
    }
    
    public void setBuyerEmail(String buyerEmail) {
        this.buyerEmail = buyerEmail;
    }
    
    @Column(name="cheque_name", length=100 ,columnDefinition="CHAR(100)")
    @Field
    public String getChequeName() {
        return this.chequeName;
    }
    
    public void setChequeName(String chequeName) {
        this.chequeName = chequeName;
    }
    
    @Column(name="contact_name", length=30 ,columnDefinition="CHAR(30)")
    @Field
    public String getContactName() {
        return this.contactName;
    }
    
    public void setContactName(String contactName) {
        this.contactName = contactName;
    }
    
    @Column(name="cr_term", length=6 ,columnDefinition="CHAR(6)")
    @Field
    public String getCrTerm() {
        return this.crTerm;
    }
    
    public void setCrTerm(String crTerm) {
        this.crTerm = crTerm;
    }
    
    @Column(name="created_at", length=10 ,columnDefinition="CHAR(10)")
    @Field
    public String getCreatedAt() {
        return this.createdAt;
    }
    
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
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
    
    @Column(name="credit_limit")
    @Field
    public Long getCreditLimit() {
        return this.creditLimit;
    }
    
    public void setCreditLimit(Long creditLimit) {
        this.creditLimit = creditLimit;
    }
    
    @Column(name="cust_address", length=120)
    @Field
    public String getCustAddress() {
        return this.custAddress;
    }
    
    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }
    
    @Column(name="cust_name", nullable=false, length=40 ,columnDefinition="CHAR(40)")
    @Field
    public String getCustName() {
        return this.custName;
    }
    
    public void setCustName(String custName) {
        this.custName = custName;
    }
    
    @Column(name="cust_reference", length=2 ,columnDefinition="CHAR(2)")
    @Field
    public String getCustReference() {
        return this.custReference;
    }
    
    public void setCustReference(String custReference) {
        this.custReference = custReference;
    }
    
    @Column(name="cust_type", length=6 ,columnDefinition="CHAR(6)")
    @Field
    public String getCustType() {
        return this.custType;
    }
    
    public void setCustType(String custType) {
        this.custType = custType;
    }
    
    @Column(name="dt_format", length=11 ,columnDefinition="CHAR(11)")
    @Field
    public String getDtFormat() {
        return this.dtFormat;
    }
    
    public void setDtFormat(String dtFormat) {
        this.dtFormat = dtFormat;
    }
    
    @Column(name="email_address", length=40 )
    @Field
    public String getEmailAddress() {
        return this.emailAddress;
    }
    
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    
    @Column(name="ext_disc_per")
    @Field
    public Long getExtDiscPer() {
        return this.extDiscPer;
    }
    
    public void setExtDiscPer(Long extDiscPer) {
        this.extDiscPer = extDiscPer;
    }
    
    @Column(name="factory_dayvalue")
    @Field
    public Long getFactoryDayvalue() {
        return this.factoryDayvalue;
    }
    
    public void setFactoryDayvalue(Long factoryDayvalue) {
        this.factoryDayvalue = factoryDayvalue;
    }
    
    @Column(name="fax_no", length=14 ,columnDefinition="CHAR(14)")
    @Field
    public String getFaxNo() {
        return this.faxNo;
    }
    
    public void setFaxNo(String faxNo) {
        this.faxNo = faxNo;
    }
    
   
	@Column(name="finance_amt")
    @Field
    public Long getFinanceAmt() {
        return this.financeAmt;
    }
    
    public void setFinanceAmt(Long financeAmt) {
        this.financeAmt = financeAmt;
    }
    
    @Column(name="fob_value")
    @Field
    public Long getFobValue() {
        return this.fobValue;
    }
    
    public void setFobValue(Long fobValue) {
        this.fobValue = fobValue;
    }
    
    @Column(name="gl_ctrl_acc", length=10 ,columnDefinition="CHAR(10)")
    @Field
    public String getGlCtrlAcc() {
        return this.glCtrlAcc;
    }
    
    public void setGlCtrlAcc(String glCtrlAcc) {
        this.glCtrlAcc = glCtrlAcc;
    }
    
    @Column(name="import_fr", length=1)
    @Field
    public Character getImportFr() {
        return this.importFr;
    }
    
    public void setImportFr(Character importFr) {
        this.importFr = importFr;
    }
    
    @Column(name="int_disc_per")
    @Field
    public Long getIntDiscPer() {
        return this.intDiscPer;
    }
    
    public void setIntDiscPer(Long intDiscPer) {
        this.intDiscPer = intDiscPer;
    }
    
    @Column(name="inv_cust_code", length=10 ,columnDefinition="CHAR(10)")
    @Field
    public String getInvCustCode() {
        return this.invCustCode;
    }
    
    public void setInvCustCode(String invCustCode) {
        this.invCustCode = invCustCode;
    }
    
    @Column(name="markup_percentage")
    @Field
    public Long getMarkupPercentage() {
        return this.markupPercentage;
    }
    
    public void setMarkupPercentage(Long markupPercentage) {
        this.markupPercentage = markupPercentage;
    }
    
    @Column(name="max_qtyallow_pcn")
    @Field
    public Long getMaxQtyallowPcn() {
        return this.maxQtyallowPcn;
    }
    
    public void setMaxQtyallowPcn(Long maxQtyallowPcn) {
        this.maxQtyallowPcn = maxQtyallowPcn;
    }
    
    @Column(name="minimum_pack")
    @Field
    public Long getMinimumPack() {
        return this.minimumPack;
    }
    
    public void setMinimumPack(Long minimumPack) {
        this.minimumPack = minimumPack;
    }
    
    @Column(name="modified_at", length=10 ,columnDefinition="CHAR(10)")
    @Field
    public String getModifiedAt() {
        return this.modifiedAt;
    }
    
    public void setModifiedAt(String modifiedAt) {
        this.modifiedAt = modifiedAt;
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
    
    @Column(name="numberof_decimal")
    @Field
    public Boolean getNumberofDecimal() {
        return this.numberofDecimal;
    }
    
    public void setNumberofDecimal(Boolean numberofDecimal) {
        this.numberofDecimal = numberofDecimal;
    }
    
    @Column(name="ocd_comm")
    @Field
    public Long getOcdComm() {
        return this.ocdComm;
    }
    
    public void setOcdComm(Long ocdComm) {
        this.ocdComm = ocdComm;
    }
    
    @Column(name="oth_comm")
    @Field
    public Long getOthComm() {
        return this.othComm;
    }
    
    public void setOthComm(Long othComm) {
        this.othComm = othComm;
    }
    
    @Column(name="owner_ship", length=10 ,columnDefinition="CHAR(10)")
    @Field
    public String getOwnerShip() {
        return this.ownerShip;
    }
    
    public void setOwnerShip(String ownerShip) {
        this.ownerShip = ownerShip;
    }
    
    @Column(name="sales_gl_code", length=10 ,columnDefinition="CHAR(10)")
    @Field
    public String getSalesGlCode() {
        return this.salesGlCode;
    }
    
    public void setSalesGlCode(String salesGlCode) {
        this.salesGlCode = salesGlCode;
    }
    
    @Column(name="tax_no", length=30 ,columnDefinition="CHAR(30)")
    @Field
    public String getTaxNo() {
        return this.taxNo;
    }
    
    public void setTaxNo(String taxNo) {
        this.taxNo = taxNo;
    }
    
    @Column(name="tel_no", length=14 ,columnDefinition="CHAR(14)")
    @Field
    public String getTelNo() {
        return this.telNo;
    }
    
    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }
    
    @Column(name="tlx_no", length=14 ,columnDefinition="CHAR(14)")
    @Field
    public String getTlxNo() {
        return this.tlxNo;
    }
    
    public void setTlxNo(String tlxNo) {
        this.tlxNo = tlxNo;
    }
    
    @Column(name="tqb_no", length=30 ,columnDefinition="CHAR(30)")
    @Field
    public String getTqbNo() {
        return this.tqbNo;
    }
    
    public void setTqbNo(String tqbNo) {
        this.tqbNo = tqbNo;
    }
    
    @Column(name="tracking_reference", length=1)
    @Field
    public Character getTrackingReference() {
        return this.trackingReference;
    }
    
    public void setTrackingReference(Character trackingReference) {
        this.trackingReference = trackingReference;
    }

    @Column(name="costsheet_valid_days")
    @Field
    public Integer getCostsheetValidDays() {
		return costsheetValidDays;
	}

	public void setCostsheetValidDays(Integer costsheetValidDays) {
		this.costsheetValidDays = costsheetValidDays;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mstcustomer other = (Mstcustomer) obj;
		if (boiRegno == null) {
			if (other.boiRegno != null)
				return false;
		} else if (!boiRegno.equals(other.boiRegno))
			return false;
		if (buyerEmail == null) {
			if (other.buyerEmail != null)
				return false;
		} else if (!buyerEmail.equals(other.buyerEmail))
			return false;
		if (chequeName == null) {
			if (other.chequeName != null)
				return false;
		} else if (!chequeName.equals(other.chequeName))
			return false;
		if (contactName == null) {
			if (other.contactName != null)
				return false;
		} else if (!contactName.equals(other.contactName))
			return false;
		if (costsheetValidDays == null) {
			if (other.costsheetValidDays != null)
				return false;
		} else if (!costsheetValidDays.equals(other.costsheetValidDays))
			return false;
		if (crTerm == null) {
			if (other.crTerm != null)
				return false;
		} else if (!crTerm.equals(other.crTerm))
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
		if (creditLimit == null) {
			if (other.creditLimit != null)
				return false;
		} else if (!creditLimit.equals(other.creditLimit))
			return false;
		if (custAddress == null) {
			if (other.custAddress != null)
				return false;
		} else if (!custAddress.equals(other.custAddress))
			return false;
		if (custCode == null) {
			if (other.custCode != null)
				return false;
		} else if (!custCode.equals(other.custCode))
			return false;
		if (custName == null) {
			if (other.custName != null)
				return false;
		} else if (!custName.equals(other.custName))
			return false;
		if (custReference == null) {
			if (other.custReference != null)
				return false;
		} else if (!custReference.equals(other.custReference))
			return false;
		if (custType == null) {
			if (other.custType != null)
				return false;
		} else if (!custType.equals(other.custType))
			return false;
		if (dtFormat == null) {
			if (other.dtFormat != null)
				return false;
		} else if (!dtFormat.equals(other.dtFormat))
			return false;
		if (emailAddress == null) {
			if (other.emailAddress != null)
				return false;
		} else if (!emailAddress.equals(other.emailAddress))
			return false;
		if (extDiscPer == null) {
			if (other.extDiscPer != null)
				return false;
		} else if (!extDiscPer.equals(other.extDiscPer))
			return false;
		if (factoryDayvalue == null) {
			if (other.factoryDayvalue != null)
				return false;
		} else if (!factoryDayvalue.equals(other.factoryDayvalue))
			return false;
		if (faxNo == null) {
			if (other.faxNo != null)
				return false;
		} else if (!faxNo.equals(other.faxNo))
			return false;
		if (financeAmt == null) {
			if (other.financeAmt != null)
				return false;
		} else if (!financeAmt.equals(other.financeAmt))
			return false;
		if (fobValue == null) {
			if (other.fobValue != null)
				return false;
		} else if (!fobValue.equals(other.fobValue))
			return false;
		if (glCtrlAcc == null) {
			if (other.glCtrlAcc != null)
				return false;
		} else if (!glCtrlAcc.equals(other.glCtrlAcc))
			return false;
		if (importFr == null) {
			if (other.importFr != null)
				return false;
		} else if (!importFr.equals(other.importFr))
			return false;
		if (intDiscPer == null) {
			if (other.intDiscPer != null)
				return false;
		} else if (!intDiscPer.equals(other.intDiscPer))
			return false;
		if (invCustCode == null) {
			if (other.invCustCode != null)
				return false;
		} else if (!invCustCode.equals(other.invCustCode))
			return false;
		if (markupPercentage == null) {
			if (other.markupPercentage != null)
				return false;
		} else if (!markupPercentage.equals(other.markupPercentage))
			return false;
		if (maxQtyallowPcn == null) {
			if (other.maxQtyallowPcn != null)
				return false;
		} else if (!maxQtyallowPcn.equals(other.maxQtyallowPcn))
			return false;
		if (minimumPack == null) {
			if (other.minimumPack != null)
				return false;
		} else if (!minimumPack.equals(other.minimumPack))
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
		if (numberofDecimal == null) {
			if (other.numberofDecimal != null)
				return false;
		} else if (!numberofDecimal.equals(other.numberofDecimal))
			return false;
		if (ocdComm == null) {
			if (other.ocdComm != null)
				return false;
		} else if (!ocdComm.equals(other.ocdComm))
			return false;
		if (othComm == null) {
			if (other.othComm != null)
				return false;
		} else if (!othComm.equals(other.othComm))
			return false;
		if (ownerShip == null) {
			if (other.ownerShip != null)
				return false;
		} else if (!ownerShip.equals(other.ownerShip))
			return false;
		if (salesGlCode == null) {
			if (other.salesGlCode != null)
				return false;
		} else if (!salesGlCode.equals(other.salesGlCode))
			return false;
		if (taxNo == null) {
			if (other.taxNo != null)
				return false;
		} else if (!taxNo.equals(other.taxNo))
			return false;
		if (telNo == null) {
			if (other.telNo != null)
				return false;
		} else if (!telNo.equals(other.telNo))
			return false;
		if (tlxNo == null) {
			if (other.tlxNo != null)
				return false;
		} else if (!tlxNo.equals(other.tlxNo))
			return false;
		if (tqbNo == null) {
			if (other.tqbNo != null)
				return false;
		} else if (!tqbNo.equals(other.tqbNo))
			return false;
		if (trackingReference == null) {
			if (other.trackingReference != null)
				return false;
		} else if (!trackingReference.equals(other.trackingReference))
			return false;
		return true;
	}

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((boiRegno == null) ? 0 : boiRegno.hashCode());
		result = prime * result
				+ ((buyerEmail == null) ? 0 : buyerEmail.hashCode());
		result = prime * result
				+ ((chequeName == null) ? 0 : chequeName.hashCode());
		result = prime * result
				+ ((contactName == null) ? 0 : contactName.hashCode());
		result = prime
				* result
				+ ((costsheetValidDays == null) ? 0 : costsheetValidDays
						.hashCode());
		result = prime * result + ((crTerm == null) ? 0 : crTerm.hashCode());
		result = prime * result
				+ ((createdAt == null) ? 0 : createdAt.hashCode());
		result = prime * result
				+ ((createdBy == null) ? 0 : createdBy.hashCode());
		result = prime * result
				+ ((createdOn == null) ? 0 : createdOn.hashCode());
		result = prime * result
				+ ((creditLimit == null) ? 0 : creditLimit.hashCode());
		result = prime * result
				+ ((custAddress == null) ? 0 : custAddress.hashCode());
		result = prime * result
				+ ((custCode == null) ? 0 : custCode.hashCode());
		result = prime * result
				+ ((custName == null) ? 0 : custName.hashCode());
		result = prime * result
				+ ((custReference == null) ? 0 : custReference.hashCode());
		result = prime * result
				+ ((custType == null) ? 0 : custType.hashCode());
		result = prime * result
				+ ((dtFormat == null) ? 0 : dtFormat.hashCode());
		result = prime * result
				+ ((emailAddress == null) ? 0 : emailAddress.hashCode());
		result = prime * result
				+ ((extDiscPer == null) ? 0 : extDiscPer.hashCode());
		result = prime * result
				+ ((factoryDayvalue == null) ? 0 : factoryDayvalue.hashCode());
		result = prime * result + ((faxNo == null) ? 0 : faxNo.hashCode());
		result = prime * result
				+ ((financeAmt == null) ? 0 : financeAmt.hashCode());
		result = prime * result
				+ ((fobValue == null) ? 0 : fobValue.hashCode());
		result = prime * result
				+ ((glCtrlAcc == null) ? 0 : glCtrlAcc.hashCode());
		result = prime * result
				+ ((importFr == null) ? 0 : importFr.hashCode());
		result = prime * result
				+ ((intDiscPer == null) ? 0 : intDiscPer.hashCode());
		result = prime * result
				+ ((invCustCode == null) ? 0 : invCustCode.hashCode());
		result = prime
				* result
				+ ((markupPercentage == null) ? 0 : markupPercentage.hashCode());
		result = prime * result
				+ ((maxQtyallowPcn == null) ? 0 : maxQtyallowPcn.hashCode());
		result = prime * result
				+ ((minimumPack == null) ? 0 : minimumPack.hashCode());
		result = prime * result
				+ ((modifiedAt == null) ? 0 : modifiedAt.hashCode());
		result = prime * result
				+ ((modifiedBy == null) ? 0 : modifiedBy.hashCode());
		result = prime * result
				+ ((modifiedOn == null) ? 0 : modifiedOn.hashCode());
		result = prime * result
				+ ((numberofDecimal == null) ? 0 : numberofDecimal.hashCode());
		result = prime * result + ((ocdComm == null) ? 0 : ocdComm.hashCode());
		result = prime * result + ((othComm == null) ? 0 : othComm.hashCode());
		result = prime * result
				+ ((ownerShip == null) ? 0 : ownerShip.hashCode());
		result = prime * result
				+ ((salesGlCode == null) ? 0 : salesGlCode.hashCode());
		result = prime * result + ((taxNo == null) ? 0 : taxNo.hashCode());
		result = prime * result + ((telNo == null) ? 0 : telNo.hashCode());
		result = prime * result + ((tlxNo == null) ? 0 : tlxNo.hashCode());
		result = prime * result + ((tqbNo == null) ? 0 : tqbNo.hashCode());
		result = prime
				* result
				+ ((trackingReference == null) ? 0 : trackingReference
						.hashCode());
		return result;
	}

    @Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Mstcustomer [custCode=");
		builder.append(custCode);
		builder.append(", boiRegno=");
		builder.append(boiRegno);
		builder.append(", buyerEmail=");
		builder.append(buyerEmail);
		builder.append(", chequeName=");
		builder.append(chequeName);
		builder.append(", contactName=");
		builder.append(contactName);
		builder.append(", crTerm=");
		builder.append(crTerm);
		builder.append(", createdAt=");
		builder.append(createdAt);
		builder.append(", createdBy=");
		builder.append(createdBy);
		builder.append(", createdOn=");
		builder.append(createdOn);
		builder.append(", creditLimit=");
		builder.append(creditLimit);
		builder.append(", custAddress=");
		builder.append(custAddress);
		builder.append(", custName=");
		builder.append(custName);
		builder.append(", custReference=");
		builder.append(custReference);
		builder.append(", custType=");
		builder.append(custType);
		builder.append(", dtFormat=");
		builder.append(dtFormat);
		builder.append(", emailAddress=");
		builder.append(emailAddress);
		builder.append(", extDiscPer=");
		builder.append(extDiscPer);
		builder.append(", factoryDayvalue=");
		builder.append(factoryDayvalue);
		builder.append(", faxNo=");
		builder.append(faxNo);
		builder.append(", financeAmt=");
		builder.append(financeAmt);
		builder.append(", fobValue=");
		builder.append(fobValue);
		builder.append(", glCtrlAcc=");
		builder.append(glCtrlAcc);
		builder.append(", importFr=");
		builder.append(importFr);
		builder.append(", intDiscPer=");
		builder.append(intDiscPer);
		builder.append(", invCustCode=");
		builder.append(invCustCode);
		builder.append(", markupPercentage=");
		builder.append(markupPercentage);
		builder.append(", maxQtyallowPcn=");
		builder.append(maxQtyallowPcn);
		builder.append(", minimumPack=");
		builder.append(minimumPack);
		builder.append(", modifiedAt=");
		builder.append(modifiedAt);
		builder.append(", modifiedBy=");
		builder.append(modifiedBy);
		builder.append(", modifiedOn=");
		builder.append(modifiedOn);
		builder.append(", numberofDecimal=");
		builder.append(numberofDecimal);
		builder.append(", ocdComm=");
		builder.append(ocdComm);
		builder.append(", othComm=");
		builder.append(othComm);
		builder.append(", ownerShip=");
		builder.append(ownerShip);
		builder.append(", salesGlCode=");
		builder.append(salesGlCode);
		builder.append(", taxNo=");
		builder.append(taxNo);
		builder.append(", telNo=");
		builder.append(telNo);
		builder.append(", tlxNo=");
		builder.append(tlxNo);
		builder.append(", tqbNo=");
		builder.append(tqbNo);
		builder.append(", trackingReference=");
		builder.append(trackingReference);
		builder.append(", costsheetValidDays=");
		builder.append(costsheetValidDays);
		builder.append("]");
		return builder.toString();
	}

}
