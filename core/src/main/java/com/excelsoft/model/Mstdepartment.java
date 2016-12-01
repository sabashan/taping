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

@SuppressWarnings("serial")
@Entity
@Table(name="mstdepartment")
@Indexed
@XmlRootElement
public class Mstdepartment extends BaseObject implements Serializable {
    private String depCode;
    private String depName;
    private String createdBy;
    private Date createdOn;
    private String createdAt;
    private String modifiedBy;
    private Date modifiedOn;
    private String modifiedAt;

    
    
    public Mstdepartment(String depCode) {
		super();
		this.depCode = depCode;
	}

	public Mstdepartment() {
		super();
	}

	public Mstdepartment(String depCode, String depName, String createdBy,
			Date createdOn, String createdAt, String modifiedBy,
			Date modifiedOn, String modifiedAt) {
		super();
		this.depCode = depCode;
		this.depName = depName;
		this.createdBy = createdBy;
		this.createdOn = createdOn;
		this.createdAt = createdAt;
		this.modifiedBy = modifiedBy;
		this.modifiedOn = modifiedOn;
		this.modifiedAt = modifiedAt;
	}

	@Id  @DocumentId    
	@Column(name="dep_code" ,columnDefinition="CHAR(6)" ,length=6)
    public String getDepCode() {
        return this.depCode;
    }
    
    public void setDepCode(String depCode) {
        this.depCode = depCode;
    }
    
    @Column(name="dep_name", length=40 ,columnDefinition="CHAR(40)")
    @Field
    public String getDepName() {
        return this.depName;
    }
    
    public void setDepName(String depName) {
        this.depName = depName;
    }
    
    @Column(name="created_by", length=20 ,columnDefinition="CHAR(20)")
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

        Mstdepartment pojo = (Mstdepartment) o;

        if (depName != null ? !depName.equals(pojo.depName) : pojo.depName != null) return false;
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
        result = (depName != null ? depName.hashCode() : 0);
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
        sb.append("depCode").append("='").append(getDepCode()).append("', ");
        sb.append("depName").append("='").append(getDepName()).append("', ");
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
