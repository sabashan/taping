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
@Table(name="mstmachinetype")
@Indexed
@XmlRootElement
public class Mstmachinetype extends BaseObject implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -1077416769596410442L;
	private String typeCode;
    private String description;
    private BigDecimal operationStdLength;
    private String operationStdLengthUom;
    private String userId;
    private Date lastChangedDate;
    private Date createdDate;
    private Character manualOpt;
    private String createdBy;
    private Date createdOn;
    private String createdAt;
    private String modifiedBy;
    private Date modifiedOn;
    private String modifiedAt;

    public Mstmachinetype(String typeCode) {
		super();
		this.typeCode = typeCode;
	}

	public Mstmachinetype() {
		super();
	}

	@Id  @DocumentId   
    @Column(name="type_code" ,length=6 ,columnDefinition="CHAR(6)")
    public String getTypeCode() {
        return this.typeCode;
    }
    
    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }
    
    @Column(name="description", length=40 ,columnDefinition="CHAR(40)")
    @Field
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    @Column(name="operation_std_length", precision=20, scale=6,columnDefinition="CHAR(20)")
    @Field
    public BigDecimal getOperationStdLength() {
        return this.operationStdLength;
    }
    
    public void setOperationStdLength(BigDecimal operationStdLength) {
        this.operationStdLength = operationStdLength;
    }
    
    @Column(name="operation_std_length_uom", length=8,columnDefinition="CHAR(8)")
    @Field
    public String getOperationStdLengthUom() {
        return this.operationStdLengthUom;
    }
    
    public void setOperationStdLengthUom(String operationStdLengthUom) {
        this.operationStdLengthUom = operationStdLengthUom;
    }
    
    @Column(name="user_id", length=6 ,columnDefinition="CHAR(6)")
    @Field
    public String getUserId() {
        return this.userId;
    }
    
    public void setUserId(String userId) {
        this.userId = userId;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="last_changed_date", length=19)
    @Field
    public Date getLastChangedDate() {
        return this.lastChangedDate;
    }
    
    public void setLastChangedDate(Date lastChangedDate) {
        this.lastChangedDate = lastChangedDate;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created_date", length=19)
    @Field
    public Date getCreatedDate() {
        return this.createdDate;
    }
    
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
    
    @Column(name="manual_opt", length=1 ,columnDefinition="CHAR(1)")
    @Field
    public Character getManualOpt() {
        return this.manualOpt;
    }
    
    public void setManualOpt(Character manualOpt) {
        this.manualOpt = manualOpt;
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

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mstmachinetype pojo = (Mstmachinetype) o;

        if (description != null ? !description.equals(pojo.description) : pojo.description != null) return false;
        if (operationStdLength != null ? !operationStdLength.equals(pojo.operationStdLength) : pojo.operationStdLength != null) return false;
        if (operationStdLengthUom != null ? !operationStdLengthUom.equals(pojo.operationStdLengthUom) : pojo.operationStdLengthUom != null) return false;
        if (userId != null ? !userId.equals(pojo.userId) : pojo.userId != null) return false;
        if (lastChangedDate != null ? !lastChangedDate.equals(pojo.lastChangedDate) : pojo.lastChangedDate != null) return false;
        if (createdDate != null ? !createdDate.equals(pojo.createdDate) : pojo.createdDate != null) return false;
        if (manualOpt != null ? !manualOpt.equals(pojo.manualOpt) : pojo.manualOpt != null) return false;
        if (createdBy != null ? !createdBy.equals(pojo.createdBy) : pojo.createdBy != null) return false;
        if (createdOn != null ? !createdOn.equals(pojo.createdOn) : pojo.createdOn != null) return false;
        if (createdAt != null ? !createdAt.equals(pojo.createdAt) : pojo.createdAt != null) return false;
        if (modifiedBy != null ? !modifiedBy.equals(pojo.modifiedBy) : pojo.modifiedBy != null) return false;
        if (modifiedOn != null ? !modifiedOn.equals(pojo.modifiedOn) : pojo.modifiedOn != null) return false;
        if (modifiedAt != null ? !modifiedAt.equals(pojo.modifiedAt) : pojo.modifiedAt != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (description != null ? description.hashCode() : 0);
        result = 31 * result + (operationStdLength != null ? operationStdLength.hashCode() : 0);
        result = 31 * result + (operationStdLengthUom != null ? operationStdLengthUom.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (lastChangedDate != null ? lastChangedDate.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (manualOpt != null ? manualOpt.hashCode() : 0);
        result = 31 * result + (createdBy != null ? createdBy.hashCode() : 0);
        result = 31 * result + (createdOn != null ? createdOn.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (modifiedBy != null ? modifiedBy.hashCode() : 0);
        result = 31 * result + (modifiedOn != null ? modifiedOn.hashCode() : 0);
        result = 31 * result + (modifiedAt != null ? modifiedAt.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("typeCode").append("='").append(getTypeCode()).append("', ");
        sb.append("description").append("='").append(getDescription()).append("', ");
        sb.append("operationStdLength").append("='").append(getOperationStdLength()).append("', ");
        sb.append("operationStdLengthUom").append("='").append(getOperationStdLengthUom()).append("', ");
        sb.append("userId").append("='").append(getUserId()).append("', ");
        sb.append("lastChangedDate").append("='").append(getLastChangedDate()).append("', ");
        sb.append("createdDate").append("='").append(getCreatedDate()).append("', ");
        sb.append("manualOpt").append("='").append(getManualOpt()).append("', ");
        sb.append("createdBy").append("='").append(getCreatedBy()).append("', ");
        sb.append("createdOn").append("='").append(getCreatedOn()).append("', ");
        sb.append("createdAt").append("='").append(getCreatedAt()).append("', ");
        sb.append("modifiedBy").append("='").append(getModifiedBy()).append("', ");
        sb.append("modifiedOn").append("='").append(getModifiedOn()).append("', ");
        sb.append("modifiedAt").append("='").append(getModifiedAt()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

}
