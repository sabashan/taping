package com.excelsoft.model;

import java.io.Serializable;
import java.math.BigDecimal;
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

@SuppressWarnings("serial")
@Entity
@Table(name="mstcompany")
@Indexed
@XmlRootElement
public class Mstcompany extends BaseObject implements Serializable {
    private String compCode;
    private String assetIdPrefix;
    private String auditCompAddress;
    private String auditCompName;
    private String baseCurCode;
    private String bssectCode;
    private String cntryCode;
    private String compAddress;
    private String compLogo;
    private String compName;
    private String createdAt;
    private String createdBy;
    private Date createdOn;
    private String emailAddress;
    private String faxNo;
    private Character groupConsolidation;
    private String gstNo;
    private String hldcompCode;
    private BigDecimal minuteValue;
    private String modifiedAt;
    private String modifiedBy;
    private Date modifiedOn;
    private String registrationno;
    private String revaluedMstCode;
    private String seamsCode;
    private String sortCode;
    private BigDecimal stReProfitBf;
    private Character status;
    private Date stockOpBalDate;
    private String svatNo;
    private String telNo;
    private String tqbNo;
    private String vatNo;
    private Date yrEndDate;
    private Date yrStartDt;

    
    
    public Mstcompany(String compCode) {
		super();
		this.compCode = compCode;
	}

	public Mstcompany() {
		super();
	}

	

	@Id  @DocumentId    
	 @Column(name="comp_code"  ,length=6 ,columnDefinition="CHAR(6)")
    public String getCompCode() {
        return this.compCode;
    }
    
    public void setCompCode(String compCode) {
        this.compCode = compCode;
    }
    
    @Column(name="asset_id_prefix", length=2 ,columnDefinition="CHAR(2)")
    @Field
    public String getAssetIdPrefix() {
        return this.assetIdPrefix;
    }
    
    public void setAssetIdPrefix(String assetIdPrefix) {
        this.assetIdPrefix = assetIdPrefix;
    }
    
    @Column(name="audit_comp_address", length=120 )
    @Field
    public String getAuditCompAddress() {
        return this.auditCompAddress;
    }
    
    public void setAuditCompAddress(String auditCompAddress) {
        this.auditCompAddress = auditCompAddress;
    }
    
    @Column(name="audit_comp_name", length=40 ,columnDefinition="CHAR(40)")
    @Field
    public String getAuditCompName() {
        return this.auditCompName;
    }
    
    public void setAuditCompName(String auditCompName) {
        this.auditCompName = auditCompName;
    }
    
    @Column(name="base_cur_code", length=6 ,columnDefinition="CHAR(6)")
    @Field
    public String getBaseCurCode() {
        return this.baseCurCode;
    }
    
    public void setBaseCurCode(String baseCurCode) {
        this.baseCurCode = baseCurCode;
    }
    
    @Column(name="bssect_code", length=10 ,columnDefinition="CHAR(10)")
    @Field
    public String getBssectCode() {
        return this.bssectCode;
    }
    
    public void setBssectCode(String bssectCode) {
        this.bssectCode = bssectCode;
    }
    
    @Column(name="cntry_code", length=10 ,columnDefinition="CHAR(10)")
    @Field
    public String getCntryCode() {
        return this.cntryCode;
    }
    
    public void setCntryCode(String cntryCode) {
        this.cntryCode = cntryCode;
    }
    
    @Column(name="comp_address", length=120 ,columnDefinition="CHAR(120)")
    @Field
    public String getCompAddress() {
        return this.compAddress;
    }
    
    public void setCompAddress(String compAddress) {
        this.compAddress = compAddress;
    }
    
    @Column(name="comp_logo", length=100 )
    @Field
    public String getCompLogo() {
        return this.compLogo;
    }
    
    public void setCompLogo(String compLogo) {
        this.compLogo = compLogo;
    }
    
    @Column(name="comp_name", length=40 ,columnDefinition="CHAR(40)")
    @Field
    public String getCompName() {
        return this.compName;
    }
    
    public void setCompName(String compName) {
        this.compName = compName;
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
    
    @Column(name="email_address", length=30 )
    @Field
    public String getEmailAddress() {
        return this.emailAddress;
    }
    
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    
    @Column(name="fax_no", length=20 )
    @Field
    public String getFaxNo() {
        return this.faxNo;
    }
    
    public void setFaxNo(String faxNo) {
        this.faxNo = faxNo;
    }
    
    @Column(name="group_consolidation", length=1)
    @Field
    public Character getGroupConsolidation() {
        return this.groupConsolidation;
    }
    
    public void setGroupConsolidation(Character groupConsolidation) {
        this.groupConsolidation = groupConsolidation;
    }
    
    @Column(name="gst_no", length=30 ,columnDefinition="CHAR(30)")
    @Field
    public String getGstNo() {
        return this.gstNo;
    }
    
    public void setGstNo(String gstNo) {
        this.gstNo = gstNo;
    }
    
    @Column(name="hldcomp_code", length=10 ,columnDefinition="CHAR(10)")
    @Field
    public String getHldcompCode() {
        return this.hldcompCode;
    }
    
    public void setHldcompCode(String hldcompCode) {
        this.hldcompCode = hldcompCode;
    }
    
    @Column(name="minute_value", precision=20, scale=6)
    @Field
    public BigDecimal getMinuteValue() {
        return this.minuteValue;
    }
    
    public void setMinuteValue(BigDecimal minuteValue) {
        this.minuteValue = minuteValue;
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
    
    @Column(name="registrationno", length=10 ,columnDefinition="CHAR(10)")
    @Field
    public String getRegistrationno() {
        return this.registrationno;
    }
    
    public void setRegistrationno(String registrationno) {
        this.registrationno = registrationno;
    }
    
    @Column(name="revalued_mst_code", length=10 ,columnDefinition="CHAR(10)")
    @Field
    public String getRevaluedMstCode() {
        return this.revaluedMstCode;
    }
    
    public void setRevaluedMstCode(String revaluedMstCode) {
        this.revaluedMstCode = revaluedMstCode;
    }
    
    @Column(name="seams_code", length=6 ,columnDefinition="CHAR(6)")
    @Field
    public String getSeamsCode() {
        return this.seamsCode;
    }
    
    public void setSeamsCode(String seamsCode) {
        this.seamsCode = seamsCode;
    }
    
    @Column(name="sort_code", length=4 ,columnDefinition="CHAR(4)")
    @Field
    public String getSortCode() {
        return this.sortCode;
    }
    
    public void setSortCode(String sortCode) {
        this.sortCode = sortCode;
    }
    
    @Column(name="st_re_profit_bf", precision=20, scale=6)
    @Field
    public BigDecimal getStReProfitBf() {
        return this.stReProfitBf;
    }
    
    public void setStReProfitBf(BigDecimal stReProfitBf) {
        this.stReProfitBf = stReProfitBf;
    }
    
    @Column(name="status", length=1)
    @Field
    public Character getStatus() {
        return this.status;
    }
    
    public void setStatus(Character status) {
        this.status = status;
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
    
    @Column(name="svat_no", length=30 ,columnDefinition="CHAR(30)")
    @Field
    public String getSvatNo() {
        return this.svatNo;
    }
    
    public void setSvatNo(String svatNo) {
        this.svatNo = svatNo;
    }
    
    @Column(name="tel_no", length=20 )
    @Field
    public String getTelNo() {
        return this.telNo;
    }
    
    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }
    
    @Column(name="tqb_no", length=30 ,columnDefinition="CHAR(30)")
    @Field
    public String getTqbNo() {
        return this.tqbNo;
    }
    
    public void setTqbNo(String tqbNo) {
        this.tqbNo = tqbNo;
    }
    
    @Column(name="vat_no", length=30 ,columnDefinition="CHAR(30)" )
    @Field
    public String getVatNo() {
        return this.vatNo;
    }
    
    public void setVatNo(String vatNo) {
        this.vatNo = vatNo;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="yr_end_date", nullable=false, length=10)
    @Field
    public Date getYrEndDate() {
        return this.yrEndDate;
    }
    
    public void setYrEndDate(Date yrEndDate) {
        this.yrEndDate = yrEndDate;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="yr_start_dt", nullable=false, length=10)
    @Field
    public Date getYrStartDt() {
        return this.yrStartDt;
    }
    
    public void setYrStartDt(Date yrStartDt) {
        this.yrStartDt = yrStartDt;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mstcompany pojo = (Mstcompany) o;

        if (assetIdPrefix != null ? !assetIdPrefix.equals(pojo.assetIdPrefix) : pojo.assetIdPrefix != null) return false;
        if (auditCompAddress != null ? !auditCompAddress.equals(pojo.auditCompAddress) : pojo.auditCompAddress != null) return false;
        if (auditCompName != null ? !auditCompName.equals(pojo.auditCompName) : pojo.auditCompName != null) return false;
        if (baseCurCode != null ? !baseCurCode.equals(pojo.baseCurCode) : pojo.baseCurCode != null) return false;
        if (bssectCode != null ? !bssectCode.equals(pojo.bssectCode) : pojo.bssectCode != null) return false;
        if (cntryCode != null ? !cntryCode.equals(pojo.cntryCode) : pojo.cntryCode != null) return false;
        if (compAddress != null ? !compAddress.equals(pojo.compAddress) : pojo.compAddress != null) return false;
        if (compLogo != null ? !compLogo.equals(pojo.compLogo) : pojo.compLogo != null) return false;
        if (compName != null ? !compName.equals(pojo.compName) : pojo.compName != null) return false;
        if (createdAt != null ? !createdAt.equals(pojo.createdAt) : pojo.createdAt != null) return false;
        if (createdBy != null ? !createdBy.equals(pojo.createdBy) : pojo.createdBy != null) return false;
        if (createdOn != null ? !createdOn.equals(pojo.createdOn) : pojo.createdOn != null) return false;
        if (emailAddress != null ? !emailAddress.equals(pojo.emailAddress) : pojo.emailAddress != null) return false;
        if (faxNo != null ? !faxNo.equals(pojo.faxNo) : pojo.faxNo != null) return false;
        if (groupConsolidation != null ? !groupConsolidation.equals(pojo.groupConsolidation) : pojo.groupConsolidation != null) return false;
        if (gstNo != null ? !gstNo.equals(pojo.gstNo) : pojo.gstNo != null) return false;
        if (hldcompCode != null ? !hldcompCode.equals(pojo.hldcompCode) : pojo.hldcompCode != null) return false;
        if (minuteValue != null ? !minuteValue.equals(pojo.minuteValue) : pojo.minuteValue != null) return false;
        if (modifiedAt != null ? !modifiedAt.equals(pojo.modifiedAt) : pojo.modifiedAt != null) return false;
        if (modifiedBy != null ? !modifiedBy.equals(pojo.modifiedBy) : pojo.modifiedBy != null) return false;
        if (modifiedOn != null ? !modifiedOn.equals(pojo.modifiedOn) : pojo.modifiedOn != null) return false;
        if (registrationno != null ? !registrationno.equals(pojo.registrationno) : pojo.registrationno != null) return false;
        if (revaluedMstCode != null ? !revaluedMstCode.equals(pojo.revaluedMstCode) : pojo.revaluedMstCode != null) return false;
        if (seamsCode != null ? !seamsCode.equals(pojo.seamsCode) : pojo.seamsCode != null) return false;
        if (sortCode != null ? !sortCode.equals(pojo.sortCode) : pojo.sortCode != null) return false;
        if (stReProfitBf != null ? !stReProfitBf.equals(pojo.stReProfitBf) : pojo.stReProfitBf != null) return false;
        if (status != null ? !status.equals(pojo.status) : pojo.status != null) return false;
        if (stockOpBalDate != null ? !stockOpBalDate.equals(pojo.stockOpBalDate) : pojo.stockOpBalDate != null) return false;
        if (svatNo != null ? !svatNo.equals(pojo.svatNo) : pojo.svatNo != null) return false;
        if (telNo != null ? !telNo.equals(pojo.telNo) : pojo.telNo != null) return false;
        if (tqbNo != null ? !tqbNo.equals(pojo.tqbNo) : pojo.tqbNo != null) return false;
        if (vatNo != null ? !vatNo.equals(pojo.vatNo) : pojo.vatNo != null) return false;
        if (yrEndDate != null ? !yrEndDate.equals(pojo.yrEndDate) : pojo.yrEndDate != null) return false;
        if (yrStartDt != null ? !yrStartDt.equals(pojo.yrStartDt) : pojo.yrStartDt != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (assetIdPrefix != null ? assetIdPrefix.hashCode() : 0);
        result = 31 * result + (auditCompAddress != null ? auditCompAddress.hashCode() : 0);
        result = 31 * result + (auditCompName != null ? auditCompName.hashCode() : 0);
        result = 31 * result + (baseCurCode != null ? baseCurCode.hashCode() : 0);
        result = 31 * result + (bssectCode != null ? bssectCode.hashCode() : 0);
        result = 31 * result + (cntryCode != null ? cntryCode.hashCode() : 0);
        result = 31 * result + (compAddress != null ? compAddress.hashCode() : 0);
        result = 31 * result + (compLogo != null ? compLogo.hashCode() : 0);
        result = 31 * result + (compName != null ? compName.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (createdBy != null ? createdBy.hashCode() : 0);
        result = 31 * result + (createdOn != null ? createdOn.hashCode() : 0);
        result = 31 * result + (emailAddress != null ? emailAddress.hashCode() : 0);
        result = 31 * result + (faxNo != null ? faxNo.hashCode() : 0);
        result = 31 * result + (groupConsolidation != null ? groupConsolidation.hashCode() : 0);
        result = 31 * result + (gstNo != null ? gstNo.hashCode() : 0);
        result = 31 * result + (hldcompCode != null ? hldcompCode.hashCode() : 0);
        result = 31 * result + (minuteValue != null ? minuteValue.hashCode() : 0);
        result = 31 * result + (modifiedAt != null ? modifiedAt.hashCode() : 0);
        result = 31 * result + (modifiedBy != null ? modifiedBy.hashCode() : 0);
        result = 31 * result + (modifiedOn != null ? modifiedOn.hashCode() : 0);
        result = 31 * result + (registrationno != null ? registrationno.hashCode() : 0);
        result = 31 * result + (revaluedMstCode != null ? revaluedMstCode.hashCode() : 0);
        result = 31 * result + (seamsCode != null ? seamsCode.hashCode() : 0);
        result = 31 * result + (sortCode != null ? sortCode.hashCode() : 0);
        result = 31 * result + (stReProfitBf != null ? stReProfitBf.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (stockOpBalDate != null ? stockOpBalDate.hashCode() : 0);
        result = 31 * result + (svatNo != null ? svatNo.hashCode() : 0);
        result = 31 * result + (telNo != null ? telNo.hashCode() : 0);
        result = 31 * result + (tqbNo != null ? tqbNo.hashCode() : 0);
        result = 31 * result + (vatNo != null ? vatNo.hashCode() : 0);
        result = 31 * result + (yrEndDate != null ? yrEndDate.hashCode() : 0);
        result = 31 * result + (yrStartDt != null ? yrStartDt.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("compCode").append("='").append(getCompCode()).append("', ");
        sb.append("assetIdPrefix").append("='").append(getAssetIdPrefix()).append("', ");
        sb.append("auditCompAddress").append("='").append(getAuditCompAddress()).append("', ");
        sb.append("auditCompName").append("='").append(getAuditCompName()).append("', ");
        sb.append("baseCurCode").append("='").append(getBaseCurCode()).append("', ");
        sb.append("bssectCode").append("='").append(getBssectCode()).append("', ");
        sb.append("cntryCode").append("='").append(getCntryCode()).append("', ");
        sb.append("compAddress").append("='").append(getCompAddress()).append("', ");
        sb.append("compLogo").append("='").append(getCompLogo()).append("', ");
        sb.append("compName").append("='").append(getCompName()).append("', ");
        sb.append("createdAt").append("='").append(getCreatedAt()).append("', ");
        sb.append("createdBy").append("='").append(getCreatedBy()).append("', ");
        sb.append("createdOn").append("='").append(getCreatedOn()).append("', ");
        sb.append("emailAddress").append("='").append(getEmailAddress()).append("', ");
        sb.append("faxNo").append("='").append(getFaxNo()).append("', ");
        sb.append("groupConsolidation").append("='").append(getGroupConsolidation()).append("', ");
        sb.append("gstNo").append("='").append(getGstNo()).append("', ");
        sb.append("hldcompCode").append("='").append(getHldcompCode()).append("', ");
        sb.append("minuteValue").append("='").append(getMinuteValue()).append("', ");
        sb.append("modifiedAt").append("='").append(getModifiedAt()).append("', ");
        sb.append("modifiedBy").append("='").append(getModifiedBy()).append("', ");
        sb.append("modifiedOn").append("='").append(getModifiedOn()).append("', ");
        sb.append("registrationno").append("='").append(getRegistrationno()).append("', ");
        sb.append("revaluedMstCode").append("='").append(getRevaluedMstCode()).append("', ");
        sb.append("seamsCode").append("='").append(getSeamsCode()).append("', ");
        sb.append("sortCode").append("='").append(getSortCode()).append("', ");
        sb.append("stReProfitBf").append("='").append(getStReProfitBf()).append("', ");
        sb.append("status").append("='").append(getStatus()).append("', ");
        sb.append("stockOpBalDate").append("='").append(getStockOpBalDate()).append("', ");
        sb.append("svatNo").append("='").append(getSvatNo()).append("', ");
        sb.append("telNo").append("='").append(getTelNo()).append("', ");
        sb.append("tqbNo").append("='").append(getTqbNo()).append("', ");
        sb.append("vatNo").append("='").append(getVatNo()).append("', ");
        sb.append("yrEndDate").append("='").append(getYrEndDate()).append("', ");
        sb.append("yrStartDt").append("='").append(getYrStartDt()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

}
