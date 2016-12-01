package com.excelsoft.model;

import com.excelsoft.model.BaseObject;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;

@Entity
@Table(name="mstsupplier" )
@XmlRootElement
public class Mstsupplier extends BaseObject implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -1028172781489124681L;
	private MstsupplierId id;
    private Mstcompany mstcompany;
    private String suppName;
    private String suppAddress;
    private String telNo;
    private String faxNo;
    private String tlxNo;
    private String emailAddr;
    private String contactName;
    private String purchGlCode;
    private String glCtrlAcc;
    private String crTerm;
    private String recType;
    private String supType;
    private String suppGstNumber;
    private String createdBy;
    private Date createdOn;
    private String createdAt;
    private String modifiedBy;
    private Date modifiedOn;
    private String modifiedAt;
    private Character glMaintain;
    private String invoiceToCode;
    private Long creditLimitAmo;
    private String bankName;
    private String bankAdd;
    private String bankAccNo;
    private String bankAccName;
    private String swiftCode;
    private String tqbRegNo;
    private String curCode;
    private String fileNo;
    private String businessRegNo;
    private String natureOfService;
    private String registeredNo;
    private String approvalCode;
    private String approvedBy;
    private Date approvedOn;
    private String approvedAt;
    private String chequeName;
    private Character supStatus;
    private Date inactiveOn;
    private String inactiveBy;
    private Date freezedOn;
    private String freezedBy;
    private Long sevlSuppCode;

    @EmbeddedId @DocumentId    
    public MstsupplierId getId() {
        return this.id;
    }
    
    public void setId(MstsupplierId id) {
        this.id = id;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="comp_code", nullable=false, insertable=false, updatable=false)
@JsonIgnore
    public Mstcompany getMstcompany() {
        return this.mstcompany;
    }
    
    public void setMstcompany(Mstcompany mstcompany) {
        this.mstcompany = mstcompany;
    }
    
    @Column(name="supp_name", length=100 , columnDefinition = "CHAR(100)")
    @Field
    public String getSuppName() {
        return this.suppName;
    }
    
    public void setSuppName(String suppName) {
        this.suppName = suppName;
    }
    
    @Column(name="supp_address", length=120 , columnDefinition = "CHAR(120)")
    @Field
    public String getSuppAddress() {
        return this.suppAddress;
    }
    
    public void setSuppAddress(String suppAddress) {
        this.suppAddress = suppAddress;
    }
    
    @Column(name="tel_no", length=20 , columnDefinition = "CHAR(20)")
    @Field
    public String getTelNo() {
        return this.telNo;
    }
    
    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }
    
    @Column(name="fax_no", length=20 , columnDefinition = "CHAR(20)")
    @Field
    public String getFaxNo() {
        return this.faxNo;
    }
    
    public void setFaxNo(String faxNo) {
        this.faxNo = faxNo;
    }
    
    @Column(name="tlx_no", length=20 , columnDefinition = "CHAR(20)")
    @Field
    public String getTlxNo() {
        return this.tlxNo;
    }
    
    public void setTlxNo(String tlxNo) {
        this.tlxNo = tlxNo;
    }
    
    @Column(name="email_addr", length=40 , columnDefinition = "CHAR(40)")
    @Field
    public String getEmailAddr() {
        return this.emailAddr;
    }
    
    public void setEmailAddr(String emailAddr) {
        this.emailAddr = emailAddr;
    }
    
    @Column(name="contact_name", length=30 , columnDefinition = "CHAR(30)")
    @Field
    public String getContactName() {
        return this.contactName;
    }
    
    public void setContactName(String contactName) {
        this.contactName = contactName;
    }
    
    @Column(name="purch_gl_code", length=10 , columnDefinition = "CHAR(10)")
    @Field
    public String getPurchGlCode() {
        return this.purchGlCode;
    }
    
    public void setPurchGlCode(String purchGlCode) {
        this.purchGlCode = purchGlCode;
    }
    
    @Column(name="gl_ctrl_acc", length=10 , columnDefinition = "CHAR(10)")
    @Field
    public String getGlCtrlAcc() {
        return this.glCtrlAcc;
    }
    
    public void setGlCtrlAcc(String glCtrlAcc) {
        this.glCtrlAcc = glCtrlAcc;
    }
    
    @Column(name="cr_term", length=6 , columnDefinition = "CHAR(6)")
    @Field
    public String getCrTerm() {
        return this.crTerm;
    }
    
    public void setCrTerm(String crTerm) {
        this.crTerm = crTerm;
    }
    
    @Column(name="rec_type", length=8 , columnDefinition = "CHAR(8)")
    @Field
    public String getRecType() {
        return this.recType;
    }
    
    public void setRecType(String recType) {
        this.recType = recType;
    }
    
    @Column(name="sup_type", length=4 , columnDefinition = "CHAR(4)")
    @Field
    public String getSupType() {
        return this.supType;
    }
    
    public void setSupType(String supType) {
        this.supType = supType;
    }
    
    @Column(name="supp_gst_number", length=30 , columnDefinition = "CHAR(30)")
    @Field
    public String getSuppGstNumber() {
        return this.suppGstNumber;
    }
    
    public void setSuppGstNumber(String suppGstNumber) {
        this.suppGstNumber = suppGstNumber;
    }
    
    @Column(name="created_by", length=10 , columnDefinition = "CHAR(10)")
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
    
    @Column(name="created_at", length=10 , columnDefinition = "CHAR(10)")
    @Field
    public String getCreatedAt() {
        return this.createdAt;
    }
    
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
    
    @Column(name="modified_by", length=10 , columnDefinition = "CHAR(10)")
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
    
    @Column(name="modified_at", length=10 , columnDefinition = "CHAR(10)")
    @Field
    public String getModifiedAt() {
        return this.modifiedAt;
    }
    
    public void setModifiedAt(String modifiedAt) {
        this.modifiedAt = modifiedAt;
    }
    
    @Column(name="gl_maintain", length=1 , columnDefinition = "CHAR(1)")
    @Field
    public Character getGlMaintain() {
        return this.glMaintain;
    }
    
    public void setGlMaintain(Character glMaintain) {
        this.glMaintain = glMaintain;
    }
    
    @Column(name="invoice_to_code", length=30 , columnDefinition = "CHAR(30)")
    @Field
    public String getInvoiceToCode() {
        return this.invoiceToCode;
    }
    
    public void setInvoiceToCode(String invoiceToCode) {
        this.invoiceToCode = invoiceToCode;
    }
    
    @Column(name="credit_Limit_amo", precision=20, scale=6 , columnDefinition = "DECIMAL(20)")
    @Field
    public Long getCreditLimitAmo() {
        return this.creditLimitAmo;
    }
    
    public void setCreditLimitAmo(Long creditLimitAmo) {
        this.creditLimitAmo = creditLimitAmo;
    }
    
    @Column(name="bank_name", length=150 , columnDefinition = "CHAR(150)")
    @Field
    public String getBankName() {
        return this.bankName;
    }
    
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
    
    @Column(name="bank_Add", length=16777215 , columnDefinition = "MEDIUMTEXT")
    @Lob
    public String getBankAdd() {
        return this.bankAdd;
    }
    
    public void setBankAdd(String bankAdd) {
        this.bankAdd = bankAdd;
    }
    
    @Column(name="bank_acc_no", length=30 , columnDefinition = "CHAR(30)")
    @Field
    public String getBankAccNo() {
        return this.bankAccNo;
    }
    
    public void setBankAccNo(String bankAccNo) {
        this.bankAccNo = bankAccNo;
    }
    
    @Column(name="bank_acc_name", length=100 , columnDefinition = "DECIMAL(20)")
    @Field
    public String getBankAccName() {
        return this.bankAccName;
    }
    
    public void setBankAccName(String bankAccName) {
        this.bankAccName = bankAccName;
    }
    
    @Column(name="swift_code", length=30 , columnDefinition = "CHAR(30)")
    @Field
    public String getSwiftCode() {
        return this.swiftCode;
    }
    
    public void setSwiftCode(String swiftCode) {
        this.swiftCode = swiftCode;
    }
    
    @Column(name="TQB_reg_no", length=10 , columnDefinition = "CHAR(10)")
    @Field
    public String getTqbRegNo() {
        return this.tqbRegNo;
    }
    
    public void setTqbRegNo(String tqbRegNo) {
        this.tqbRegNo = tqbRegNo;
    }
    
    @Column(name="cur_code", length=4 , columnDefinition = "CHAR(4)")
    @Field
    public String getCurCode() {
        return this.curCode;
    }
    
    public void setCurCode(String curCode) {
        this.curCode = curCode;
    }
    
    @Column(name="file_no", length=20 , columnDefinition = "CHAR(20)")
    @Field
    public String getFileNo() {
        return this.fileNo;
    }
    
    public void setFileNo(String fileNo) {
        this.fileNo = fileNo;
    }
    
    @Column(name="business_reg_no", length=30 , columnDefinition = "CHAR(30)")
    @Field
    public String getBusinessRegNo() {
        return this.businessRegNo;
    }
    
    public void setBusinessRegNo(String businessRegNo) {
        this.businessRegNo = businessRegNo;
    }
    
    @Column(name="nature_of_service", length=200 , columnDefinition = "CHAR(200)")
    @Field
    public String getNatureOfService() {
        return this.natureOfService;
    }
    
    public void setNatureOfService(String natureOfService) {
        this.natureOfService = natureOfService;
    }
    
    @Column(name="registered_no", length=30 , columnDefinition = "CHAR(30)")
    @Field
    public String getRegisteredNo() {
        return this.registeredNo;
    }
    
    public void setRegisteredNo(String registeredNo) {
        this.registeredNo = registeredNo;
    }
    
    @Column(name="approval_code", length=4 , columnDefinition = "CHAR(4)")
    @Field
    public String getApprovalCode() {
        return this.approvalCode;
    }
    
    public void setApprovalCode(String approvalCode) {
        this.approvalCode = approvalCode;
    }
    
    @Column(name="approved_by", length=10 , columnDefinition = "CHAR(10)")
    @Field
    public String getApprovedBy() {
        return this.approvedBy;
    }
    
    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="approved_on", length=19)
    @Field
    public Date getApprovedOn() {
        return this.approvedOn;
    }
    
    public void setApprovedOn(Date approvedOn) {
        this.approvedOn = approvedOn;
    }
    
    @Column(name="approved_at", length=10 , columnDefinition = "CHAR(10)")
    @Field
    public String getApprovedAt() {
        return this.approvedAt;
    }
    
    public void setApprovedAt(String approvedAt) {
        this.approvedAt = approvedAt;
    }
    
    @Column(name="cheque_name", length=100 , columnDefinition = "CHAR(100)")
    @Field
    public String getChequeName() {
        return this.chequeName;
    }
    
    public void setChequeName(String chequeName) {
        this.chequeName = chequeName;
    }
    
    @Column(name="sup_status", length=1 , columnDefinition = "CHAR(1)")
    @Field
    public Character getSupStatus() {
        return this.supStatus;
    }
    
    public void setSupStatus(Character supStatus) {
        this.supStatus = supStatus;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="inactive_on", length=19)
    @Field
    public Date getInactiveOn() {
        return this.inactiveOn;
    }
    
    public void setInactiveOn(Date inactiveOn) {
        this.inactiveOn = inactiveOn;
    }
    
    @Column(name="inactive_by", length=10 , columnDefinition = "CHAR(10)")
    @Field
    public String getInactiveBy() {
        return this.inactiveBy;
    }
    
    public void setInactiveBy(String inactiveBy) {
        this.inactiveBy = inactiveBy;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="freezed_on", length=19)
    @Field
    public Date getFreezedOn() {
        return this.freezedOn;
    }
    
    public void setFreezedOn(Date freezedOn) {
        this.freezedOn = freezedOn;
    }
    
    @Column(name="freezed_by", length=10 , columnDefinition = "CHAR(10)")
    @Field
    public String getFreezedBy() {
        return this.freezedBy;
    }
    
    public void setFreezedBy(String freezedBy) {
        this.freezedBy = freezedBy;
    }
    
    @Column(name="sevlSupp_code", precision=4, scale=0 , columnDefinition = "DECIMAL(4)")
    @Field
    public Long getSevlSuppCode() {
        return this.sevlSuppCode;
    }
    
    public void setSevlSuppCode(Long sevlSuppCode) {
        this.sevlSuppCode = sevlSuppCode;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mstsupplier pojo = (Mstsupplier) o;

        if (mstcompany != null ? !mstcompany.equals(pojo.mstcompany) : pojo.mstcompany != null) return false;
        if (suppName != null ? !suppName.equals(pojo.suppName) : pojo.suppName != null) return false;
        if (suppAddress != null ? !suppAddress.equals(pojo.suppAddress) : pojo.suppAddress != null) return false;
        if (telNo != null ? !telNo.equals(pojo.telNo) : pojo.telNo != null) return false;
        if (faxNo != null ? !faxNo.equals(pojo.faxNo) : pojo.faxNo != null) return false;
        if (tlxNo != null ? !tlxNo.equals(pojo.tlxNo) : pojo.tlxNo != null) return false;
        if (emailAddr != null ? !emailAddr.equals(pojo.emailAddr) : pojo.emailAddr != null) return false;
        if (contactName != null ? !contactName.equals(pojo.contactName) : pojo.contactName != null) return false;
        if (purchGlCode != null ? !purchGlCode.equals(pojo.purchGlCode) : pojo.purchGlCode != null) return false;
        if (glCtrlAcc != null ? !glCtrlAcc.equals(pojo.glCtrlAcc) : pojo.glCtrlAcc != null) return false;
        if (crTerm != null ? !crTerm.equals(pojo.crTerm) : pojo.crTerm != null) return false;
        if (recType != null ? !recType.equals(pojo.recType) : pojo.recType != null) return false;
        if (supType != null ? !supType.equals(pojo.supType) : pojo.supType != null) return false;
        if (suppGstNumber != null ? !suppGstNumber.equals(pojo.suppGstNumber) : pojo.suppGstNumber != null) return false;
        if (createdBy != null ? !createdBy.equals(pojo.createdBy) : pojo.createdBy != null) return false;
        if (createdOn != null ? !createdOn.equals(pojo.createdOn) : pojo.createdOn != null) return false;
        if (createdAt != null ? !createdAt.equals(pojo.createdAt) : pojo.createdAt != null) return false;
        if (modifiedBy != null ? !modifiedBy.equals(pojo.modifiedBy) : pojo.modifiedBy != null) return false;
        if (modifiedOn != null ? !modifiedOn.equals(pojo.modifiedOn) : pojo.modifiedOn != null) return false;
        if (modifiedAt != null ? !modifiedAt.equals(pojo.modifiedAt) : pojo.modifiedAt != null) return false;
        if (glMaintain != null ? !glMaintain.equals(pojo.glMaintain) : pojo.glMaintain != null) return false;
        if (invoiceToCode != null ? !invoiceToCode.equals(pojo.invoiceToCode) : pojo.invoiceToCode != null) return false;
        if (creditLimitAmo != null ? !creditLimitAmo.equals(pojo.creditLimitAmo) : pojo.creditLimitAmo != null) return false;
        if (bankName != null ? !bankName.equals(pojo.bankName) : pojo.bankName != null) return false;
        if (bankAdd != null ? !bankAdd.equals(pojo.bankAdd) : pojo.bankAdd != null) return false;
        if (bankAccNo != null ? !bankAccNo.equals(pojo.bankAccNo) : pojo.bankAccNo != null) return false;
        if (bankAccName != null ? !bankAccName.equals(pojo.bankAccName) : pojo.bankAccName != null) return false;
        if (swiftCode != null ? !swiftCode.equals(pojo.swiftCode) : pojo.swiftCode != null) return false;
        if (tqbRegNo != null ? !tqbRegNo.equals(pojo.tqbRegNo) : pojo.tqbRegNo != null) return false;
        if (curCode != null ? !curCode.equals(pojo.curCode) : pojo.curCode != null) return false;
        if (fileNo != null ? !fileNo.equals(pojo.fileNo) : pojo.fileNo != null) return false;
        if (businessRegNo != null ? !businessRegNo.equals(pojo.businessRegNo) : pojo.businessRegNo != null) return false;
        if (natureOfService != null ? !natureOfService.equals(pojo.natureOfService) : pojo.natureOfService != null) return false;
        if (registeredNo != null ? !registeredNo.equals(pojo.registeredNo) : pojo.registeredNo != null) return false;
        if (approvalCode != null ? !approvalCode.equals(pojo.approvalCode) : pojo.approvalCode != null) return false;
        if (approvedBy != null ? !approvedBy.equals(pojo.approvedBy) : pojo.approvedBy != null) return false;
        if (approvedOn != null ? !approvedOn.equals(pojo.approvedOn) : pojo.approvedOn != null) return false;
        if (approvedAt != null ? !approvedAt.equals(pojo.approvedAt) : pojo.approvedAt != null) return false;
        if (chequeName != null ? !chequeName.equals(pojo.chequeName) : pojo.chequeName != null) return false;
        if (supStatus != null ? !supStatus.equals(pojo.supStatus) : pojo.supStatus != null) return false;
        if (inactiveOn != null ? !inactiveOn.equals(pojo.inactiveOn) : pojo.inactiveOn != null) return false;
        if (inactiveBy != null ? !inactiveBy.equals(pojo.inactiveBy) : pojo.inactiveBy != null) return false;
        if (freezedOn != null ? !freezedOn.equals(pojo.freezedOn) : pojo.freezedOn != null) return false;
        if (freezedBy != null ? !freezedBy.equals(pojo.freezedBy) : pojo.freezedBy != null) return false;
        if (sevlSuppCode != null ? !sevlSuppCode.equals(pojo.sevlSuppCode) : pojo.sevlSuppCode != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (mstcompany != null ? mstcompany.hashCode() : 0);
        result = 31 * result + (suppName != null ? suppName.hashCode() : 0);
        result = 31 * result + (suppAddress != null ? suppAddress.hashCode() : 0);
        result = 31 * result + (telNo != null ? telNo.hashCode() : 0);
        result = 31 * result + (faxNo != null ? faxNo.hashCode() : 0);
        result = 31 * result + (tlxNo != null ? tlxNo.hashCode() : 0);
        result = 31 * result + (emailAddr != null ? emailAddr.hashCode() : 0);
        result = 31 * result + (contactName != null ? contactName.hashCode() : 0);
        result = 31 * result + (purchGlCode != null ? purchGlCode.hashCode() : 0);
        result = 31 * result + (glCtrlAcc != null ? glCtrlAcc.hashCode() : 0);
        result = 31 * result + (crTerm != null ? crTerm.hashCode() : 0);
        result = 31 * result + (recType != null ? recType.hashCode() : 0);
        result = 31 * result + (supType != null ? supType.hashCode() : 0);
        result = 31 * result + (suppGstNumber != null ? suppGstNumber.hashCode() : 0);
        result = 31 * result + (createdBy != null ? createdBy.hashCode() : 0);
        result = 31 * result + (createdOn != null ? createdOn.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (modifiedBy != null ? modifiedBy.hashCode() : 0);
        result = 31 * result + (modifiedOn != null ? modifiedOn.hashCode() : 0);
        result = 31 * result + (modifiedAt != null ? modifiedAt.hashCode() : 0);
        result = 31 * result + (glMaintain != null ? glMaintain.hashCode() : 0);
        result = 31 * result + (invoiceToCode != null ? invoiceToCode.hashCode() : 0);
        result = 31 * result + (creditLimitAmo != null ? creditLimitAmo.hashCode() : 0);
        result = 31 * result + (bankName != null ? bankName.hashCode() : 0);
        result = 31 * result + (bankAdd != null ? bankAdd.hashCode() : 0);
        result = 31 * result + (bankAccNo != null ? bankAccNo.hashCode() : 0);
        result = 31 * result + (bankAccName != null ? bankAccName.hashCode() : 0);
        result = 31 * result + (swiftCode != null ? swiftCode.hashCode() : 0);
        result = 31 * result + (tqbRegNo != null ? tqbRegNo.hashCode() : 0);
        result = 31 * result + (curCode != null ? curCode.hashCode() : 0);
        result = 31 * result + (fileNo != null ? fileNo.hashCode() : 0);
        result = 31 * result + (businessRegNo != null ? businessRegNo.hashCode() : 0);
        result = 31 * result + (natureOfService != null ? natureOfService.hashCode() : 0);
        result = 31 * result + (registeredNo != null ? registeredNo.hashCode() : 0);
        result = 31 * result + (approvalCode != null ? approvalCode.hashCode() : 0);
        result = 31 * result + (approvedBy != null ? approvedBy.hashCode() : 0);
        result = 31 * result + (approvedOn != null ? approvedOn.hashCode() : 0);
        result = 31 * result + (approvedAt != null ? approvedAt.hashCode() : 0);
        result = 31 * result + (chequeName != null ? chequeName.hashCode() : 0);
        result = 31 * result + (supStatus != null ? supStatus.hashCode() : 0);
        result = 31 * result + (inactiveOn != null ? inactiveOn.hashCode() : 0);
        result = 31 * result + (inactiveBy != null ? inactiveBy.hashCode() : 0);
        result = 31 * result + (freezedOn != null ? freezedOn.hashCode() : 0);
        result = 31 * result + (freezedBy != null ? freezedBy.hashCode() : 0);
        result = 31 * result + (sevlSuppCode != null ? sevlSuppCode.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("id").append("='").append(getId()).append("', ");
        sb.append("mstcompany").append("='").append(getMstcompany()).append("', ");
        sb.append("suppName").append("='").append(getSuppName()).append("', ");
        sb.append("suppAddress").append("='").append(getSuppAddress()).append("', ");
        sb.append("telNo").append("='").append(getTelNo()).append("', ");
        sb.append("faxNo").append("='").append(getFaxNo()).append("', ");
        sb.append("tlxNo").append("='").append(getTlxNo()).append("', ");
        sb.append("emailAddr").append("='").append(getEmailAddr()).append("', ");
        sb.append("contactName").append("='").append(getContactName()).append("', ");
        sb.append("purchGlCode").append("='").append(getPurchGlCode()).append("', ");
        sb.append("glCtrlAcc").append("='").append(getGlCtrlAcc()).append("', ");
        sb.append("crTerm").append("='").append(getCrTerm()).append("', ");
        sb.append("recType").append("='").append(getRecType()).append("', ");
        sb.append("supType").append("='").append(getSupType()).append("', ");
        sb.append("suppGstNumber").append("='").append(getSuppGstNumber()).append("', ");
        sb.append("createdBy").append("='").append(getCreatedBy()).append("', ");
        sb.append("createdOn").append("='").append(getCreatedOn()).append("', ");
        sb.append("createdAt").append("='").append(getCreatedAt()).append("', ");
        sb.append("modifiedBy").append("='").append(getModifiedBy()).append("', ");
        sb.append("modifiedOn").append("='").append(getModifiedOn()).append("', ");
        sb.append("modifiedAt").append("='").append(getModifiedAt()).append("', ");
        sb.append("glMaintain").append("='").append(getGlMaintain()).append("', ");
        sb.append("invoiceToCode").append("='").append(getInvoiceToCode()).append("', ");
        sb.append("creditLimitAmo").append("='").append(getCreditLimitAmo()).append("', ");
        sb.append("bankName").append("='").append(getBankName()).append("', ");
        sb.append("bankAdd").append("='").append(getBankAdd()).append("', ");
        sb.append("bankAccNo").append("='").append(getBankAccNo()).append("', ");
        sb.append("bankAccName").append("='").append(getBankAccName()).append("', ");
        sb.append("swiftCode").append("='").append(getSwiftCode()).append("', ");
        sb.append("tqbRegNo").append("='").append(getTqbRegNo()).append("', ");
        sb.append("curCode").append("='").append(getCurCode()).append("', ");
        sb.append("fileNo").append("='").append(getFileNo()).append("', ");
        sb.append("businessRegNo").append("='").append(getBusinessRegNo()).append("', ");
        sb.append("natureOfService").append("='").append(getNatureOfService()).append("', ");
        sb.append("registeredNo").append("='").append(getRegisteredNo()).append("', ");
        sb.append("approvalCode").append("='").append(getApprovalCode()).append("', ");
        sb.append("approvedBy").append("='").append(getApprovedBy()).append("', ");
        sb.append("approvedOn").append("='").append(getApprovedOn()).append("', ");
        sb.append("approvedAt").append("='").append(getApprovedAt()).append("', ");
        sb.append("chequeName").append("='").append(getChequeName()).append("', ");
        sb.append("supStatus").append("='").append(getSupStatus()).append("', ");
        sb.append("inactiveOn").append("='").append(getInactiveOn()).append("', ");
        sb.append("inactiveBy").append("='").append(getInactiveBy()).append("', ");
        sb.append("freezedOn").append("='").append(getFreezedOn()).append("', ");
        sb.append("freezedBy").append("='").append(getFreezedBy()).append("', ");
        sb.append("sevlSuppCode").append("='").append(getSevlSuppCode()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

}
