package com.excelsoft.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;

@SuppressWarnings("serial")
@Table(name="mstusersecurity")
@XmlRootElement
@Entity
public class Mstusersecurity extends BaseObject implements Serializable {
    private MstusersecurityId id;
    private String programType;
    private String programDesc;
    private char insertRec;
    private char updateRec;
    private char deleteRec;
    private char viewRec;
    private char printRec;
    private Character approveRec;
    private Character othersAccess;
    private String approvalCode;
    private String isoCode;
    private String proUser;
    private Character postRec;
    private Character auditEnabled;
    private Character auditVisible;
    private Character unapproveRec;
    private Character auditReplicEnabled;
    private Character advanceOption;
    private String sysdateRange;

    @EmbeddedId @DocumentId    
    public MstusersecurityId getId() {
        return this.id;
    }
    
    public void setId(MstusersecurityId id) {
        this.id = id;
    }
    
    @Column(name="program_type", nullable=false, length=4 ,columnDefinition="CHAR(4)")
    @Field
    public String getProgramType() {
        return this.programType;
    }
    
    public void setProgramType(String programType) {
        this.programType = programType;
    }
    
    @Column(name="program_desc", nullable=false, length=30 ,columnDefinition="CHAR(30)")
    @Field
    public String getProgramDesc() {
        return this.programDesc;
    }
    
    public void setProgramDesc(String programDesc) {
        this.programDesc = programDesc;
    }
    
    @Column(name="insert_rec", nullable=false, length=1)
    @Field
    public char getInsertRec() {
        return this.insertRec;
    }
    
    public void setInsertRec(char insertRec) {
        this.insertRec = insertRec;
    }
    
    @Column(name="update_rec", nullable=false, length=1)
    @Field
    public char getUpdateRec() {
        return this.updateRec;
    }
    
    public void setUpdateRec(char updateRec) {
        this.updateRec = updateRec;
    }
    
    @Column(name="delete_rec", nullable=false, length=1)
    @Field
    public char getDeleteRec() {
        return this.deleteRec;
    }
    
    public void setDeleteRec(char deleteRec) {
        this.deleteRec = deleteRec;
    }
    
    @Column(name="view_rec", nullable=false, length=1)
    @Field
    public char getViewRec() {
        return this.viewRec;
    }
    
    public void setViewRec(char viewRec) {
        this.viewRec = viewRec;
    }
    
    @Column(name="print_rec", nullable=false, length=1)
    @Field
    public char getPrintRec() {
        return this.printRec;
    }
    
    public void setPrintRec(char printRec) {
        this.printRec = printRec;
    }
    
    @Column(name="approve_rec", length=1)
    @Field
    public Character getApproveRec() {
        return this.approveRec;
    }
    
    public void setApproveRec(Character approveRec) {
        this.approveRec = approveRec;
    }
    
    @Column(name="others_access", length=1)
    @Field
    public Character getOthersAccess() {
        return this.othersAccess;
    }
    
    public void setOthersAccess(Character othersAccess) {
        this.othersAccess = othersAccess;
    }
    
    @Column(name="approval_code", length=4 ,columnDefinition="CHAR(4)")
    @Field
    public String getApprovalCode() {
        return this.approvalCode;
    }
    
    public void setApprovalCode(String approvalCode) {
        this.approvalCode = approvalCode;
    }
    
    @Column(name="iso_code", length=20 ,columnDefinition="CHAR(20)")
    @Field
    public String getIsoCode() {
        return this.isoCode;
    }
    
    public void setIsoCode(String isoCode) {
        this.isoCode = isoCode;
    }
    
    @Column(name="pro_user", length=10 ,columnDefinition="CHAR(10)")
    @Field
    public String getProUser() {
        return this.proUser;
    }
    
    public void setProUser(String proUser) {
        this.proUser = proUser;
    }
    
    @Column(name="post_rec", length=1)
    @Field
    public Character getPostRec() {
        return this.postRec;
    }
    
    public void setPostRec(Character postRec) {
        this.postRec = postRec;
    }
    
    @Column(name="audit_enabled", length=1)
    @Field
    public Character getAuditEnabled() {
        return this.auditEnabled;
    }
    
    public void setAuditEnabled(Character auditEnabled) {
        this.auditEnabled = auditEnabled;
    }
    
    @Column(name="audit_visible", length=1)
    @Field
    public Character getAuditVisible() {
        return this.auditVisible;
    }
    
    public void setAuditVisible(Character auditVisible) {
        this.auditVisible = auditVisible;
    }
    
    @Column(name="unapprove_rec", length=1)
    @Field
    public Character getUnapproveRec() {
        return this.unapproveRec;
    }
    
    public void setUnapproveRec(Character unapproveRec) {
        this.unapproveRec = unapproveRec;
    }
    
    @Column(name="audit_replic_enabled", length=1)
    @Field
    public Character getAuditReplicEnabled() {
        return this.auditReplicEnabled;
    }
    
    public void setAuditReplicEnabled(Character auditReplicEnabled) {
        this.auditReplicEnabled = auditReplicEnabled;
    }
    
    @Column(name="advance_option", length=1)
    @Field
    public Character getAdvanceOption() {
        return this.advanceOption;
    }
    
    public void setAdvanceOption(Character advanceOption) {
        this.advanceOption = advanceOption;
    }
    
    @Column(name="sysdate_range", length=7 ,columnDefinition="CHAR")
    @Field
    public String getSysdateRange() {
        return this.sysdateRange;
    }
    
    public void setSysdateRange(String sysdateRange) {
        this.sysdateRange = sysdateRange;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mstusersecurity pojo = (Mstusersecurity) o;

        if (programType != null ? !programType.equals(pojo.programType) : pojo.programType != null) return false;
        if (programDesc != null ? !programDesc.equals(pojo.programDesc) : pojo.programDesc != null) return false;
//        if (insertRec != null ? !insertRec.equals(pojo.insertRec) : pojo.insertRec != null) return false;
//        if (updateRec != null ? !updateRec.equals(pojo.updateRec) : pojo.updateRec != null) return false;
//        if (deleteRec != null ? !deleteRec.equals(pojo.deleteRec) : pojo.deleteRec != null) return false;
//        if (viewRec != null ? !viewRec.equals(pojo.viewRec) : pojo.viewRec != null) return false;
//        if (printRec != null ? !printRec.equals(pojo.printRec) : pojo.printRec != null) return false;
        if (approveRec != null ? !approveRec.equals(pojo.approveRec) : pojo.approveRec != null) return false;
        if (othersAccess != null ? !othersAccess.equals(pojo.othersAccess) : pojo.othersAccess != null) return false;
        if (approvalCode != null ? !approvalCode.equals(pojo.approvalCode) : pojo.approvalCode != null) return false;
        if (isoCode != null ? !isoCode.equals(pojo.isoCode) : pojo.isoCode != null) return false;
        if (proUser != null ? !proUser.equals(pojo.proUser) : pojo.proUser != null) return false;
        if (postRec != null ? !postRec.equals(pojo.postRec) : pojo.postRec != null) return false;
        if (auditEnabled != null ? !auditEnabled.equals(pojo.auditEnabled) : pojo.auditEnabled != null) return false;
        if (auditVisible != null ? !auditVisible.equals(pojo.auditVisible) : pojo.auditVisible != null) return false;
        if (unapproveRec != null ? !unapproveRec.equals(pojo.unapproveRec) : pojo.unapproveRec != null) return false;
        if (auditReplicEnabled != null ? !auditReplicEnabled.equals(pojo.auditReplicEnabled) : pojo.auditReplicEnabled != null) return false;
        if (advanceOption != null ? !advanceOption.equals(pojo.advanceOption) : pojo.advanceOption != null) return false;
        if (sysdateRange != null ? !sysdateRange.equals(pojo.sysdateRange) : pojo.sysdateRange != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (programType != null ? programType.hashCode() : 0);
        result = 31 * result + (programDesc != null ? programDesc.hashCode() : 0);
//        result = 31 * result + (insertRec != null ? insertRec.hashCode() : 0);
//        result = 31 * result + (updateRec != null ? updateRec.hashCode() : 0);
//        result = 31 * result + (deleteRec != null ? deleteRec.hashCode() : 0);
//        result = 31 * result + (viewRec != null ? viewRec.hashCode() : 0);
//        result = 31 * result + (printRec != null ? printRec.hashCode() : 0);
        result = 31 * result + (approveRec != null ? approveRec.hashCode() : 0);
        result = 31 * result + (othersAccess != null ? othersAccess.hashCode() : 0);
        result = 31 * result + (approvalCode != null ? approvalCode.hashCode() : 0);
        result = 31 * result + (isoCode != null ? isoCode.hashCode() : 0);
        result = 31 * result + (proUser != null ? proUser.hashCode() : 0);
        result = 31 * result + (postRec != null ? postRec.hashCode() : 0);
        result = 31 * result + (auditEnabled != null ? auditEnabled.hashCode() : 0);
        result = 31 * result + (auditVisible != null ? auditVisible.hashCode() : 0);
        result = 31 * result + (unapproveRec != null ? unapproveRec.hashCode() : 0);
        result = 31 * result + (auditReplicEnabled != null ? auditReplicEnabled.hashCode() : 0);
        result = 31 * result + (advanceOption != null ? advanceOption.hashCode() : 0);
        result = 31 * result + (sysdateRange != null ? sysdateRange.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("id").append("='").append(getId()).append("', ");
        sb.append("programType").append("='").append(getProgramType()).append("', ");
        sb.append("programDesc").append("='").append(getProgramDesc()).append("', ");
        sb.append("insertRec").append("='").append(getInsertRec()).append("', ");
        sb.append("updateRec").append("='").append(getUpdateRec()).append("', ");
        sb.append("deleteRec").append("='").append(getDeleteRec()).append("', ");
        sb.append("viewRec").append("='").append(getViewRec()).append("', ");
        sb.append("printRec").append("='").append(getPrintRec()).append("', ");
        sb.append("approveRec").append("='").append(getApproveRec()).append("', ");
        sb.append("othersAccess").append("='").append(getOthersAccess()).append("', ");
        sb.append("approvalCode").append("='").append(getApprovalCode()).append("', ");
        sb.append("isoCode").append("='").append(getIsoCode()).append("', ");
        sb.append("proUser").append("='").append(getProUser()).append("', ");
        sb.append("postRec").append("='").append(getPostRec()).append("', ");
        sb.append("auditEnabled").append("='").append(getAuditEnabled()).append("', ");
        sb.append("auditVisible").append("='").append(getAuditVisible()).append("', ");
        sb.append("unapproveRec").append("='").append(getUnapproveRec()).append("', ");
        sb.append("auditReplicEnabled").append("='").append(getAuditReplicEnabled()).append("', ");
        sb.append("advanceOption").append("='").append(getAdvanceOption()).append("', ");
        sb.append("sysdateRange").append("='").append(getSysdateRange()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

}
