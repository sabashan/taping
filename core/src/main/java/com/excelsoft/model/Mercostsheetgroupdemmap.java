package com.excelsoft.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;

@Entity
@Table(name="mercostsheetgroupdemmap")
@XmlRootElement
public class Mercostsheetgroupdemmap extends BaseObject implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -1957079516524872013L;
	private MercostsheetgroupdemmapId id;
    private Mercostsheetgroupsetting mercostsheetgroupsetting;
    private String color;
    private Boolean status;
    private Boolean assigned;

    public Mercostsheetgroupdemmap() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Mercostsheetgroupdemmap(MercostsheetgroupdemmapId id,
			Mercostsheetgroupsetting mercostsheetgroupsetting, String color,
			Boolean status, Boolean assigned) {
		super();
		this.id = id;
		this.mercostsheetgroupsetting = mercostsheetgroupsetting;
		this.color = color;
		this.status = status;
		this.assigned = assigned;
	}

	@EmbeddedId @DocumentId    
    public MercostsheetgroupdemmapId getId() {
        return this.id;
    }
    
    public void setId(MercostsheetgroupdemmapId id) {
        this.id = id;
    }

  //  @JsonIgnore
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumns( { 
        @JoinColumn(name="group_setting_id", referencedColumnName="group_setting_id", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="group_id", referencedColumnName="group_id", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="cost_sheet_no", referencedColumnName="cost_sheet_no", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="version_no", referencedColumnName="version_no", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="cost_sheet_type", referencedColumnName="cost_sheet_type", nullable=false, insertable=false, updatable=false) } )
    public Mercostsheetgroupsetting getMercostsheetgroupsetting() {
        return this.mercostsheetgroupsetting;
    }
    
    public void setMercostsheetgroupsetting(Mercostsheetgroupsetting mercostsheetgroupsetting) {
        this.mercostsheetgroupsetting = mercostsheetgroupsetting;
    }

    @Column(name="color", nullable=false, length=10, columnDefinition="CHAR(10)")
    @Field
    public String getColor() {
        return this.color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }

    @Column(name="status")
    @Field
    public Boolean getStatus() {
        return this.status;
    }
    
    public void setStatus(Boolean status) {
        this.status = status;
    }
    
    @Column(name="assigned")
    @Field
    public Boolean getAssigned() {
        return this.assigned;
    }
    
    public void setAssigned(Boolean assigned) {
        this.assigned = assigned;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mercostsheetgroupdemmap pojo = (Mercostsheetgroupdemmap) o;

        if (mercostsheetgroupsetting != null ? !mercostsheetgroupsetting.equals(pojo.mercostsheetgroupsetting) : pojo.mercostsheetgroupsetting != null) return false;
        if (status != null ? !status.equals(pojo.status) : pojo.status != null) return false;
        if (assigned != null ? !assigned.equals(pojo.assigned) : pojo.assigned != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (mercostsheetgroupsetting != null ? mercostsheetgroupsetting.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (assigned != null ? assigned.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("id").append("='").append(getId()).append("', ");
        sb.append("mercostsheetgroupsetting").append("='").append(getMercostsheetgroupsetting()).append("', ");
        sb.append("status").append("='").append(getStatus()).append("', ");
        sb.append("assigned").append("='").append(getAssigned()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

}
