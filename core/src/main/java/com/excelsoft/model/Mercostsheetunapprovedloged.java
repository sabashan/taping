package com.excelsoft.model;

import java.io.Serializable;
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
@Table(name="mercostsheetunapprovedloged")
@XmlRootElement
public class Mercostsheetunapprovedloged extends BaseObject implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 3863695610081175884L;
	private MercostsheetunapprovedlogedId id;
    private Mercostsheethdr mercostsheethdr;
    private Date unapprovedOn;
    private String unapprovedBy;
    private String unapprovedAt;
    private String description;

    public Mercostsheetunapprovedloged() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Mercostsheetunapprovedloged(MercostsheetunapprovedlogedId id,
			Mercostsheethdr mercostsheethdr, Date unapprovedOn,
			String unapprovedBy, String unapprovedAt, String description) {
		super();
		this.id = id;
		this.mercostsheethdr = mercostsheethdr;
		this.unapprovedOn = unapprovedOn;
		this.unapprovedBy = unapprovedBy;
		this.unapprovedAt = unapprovedAt;
		this.description = description;
	}

	@EmbeddedId @DocumentId    
    public MercostsheetunapprovedlogedId getId() {
        return this.id;
    }
    
    public void setId(MercostsheetunapprovedlogedId id) {
        this.id = id;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumns( { 
        @JoinColumn(name="cost_sheet_no", referencedColumnName="cost_sheet_no", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="version_no", referencedColumnName="version_no", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="cost_sheet_type", referencedColumnName="cost_sheet_type", nullable=false, insertable=false, updatable=false) } )
    public Mercostsheethdr getMercostsheethdr() {
        return this.mercostsheethdr;
    }
    
    public void setMercostsheethdr(Mercostsheethdr mercostsheethdr) {
        this.mercostsheethdr = mercostsheethdr;
    }
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="unapproved_on", length=19)
    @Field
    public Date getUnapprovedOn() {
        return this.unapprovedOn;
    }
    
    public void setUnapprovedOn(Date unapprovedOn) {
        this.unapprovedOn = unapprovedOn;
    }

    @Column(name="unapproved_by", length=45, columnDefinition="CHAR(45)")
    @Field
    public String getUnapprovedBy() {
        return this.unapprovedBy;
    }
    
    public void setUnapprovedBy(String unapprovedBy) {
        this.unapprovedBy = unapprovedBy;
    }

    @Column(name="unapproved_at", length=45, columnDefinition="CHAR(45)")
    @Field
    public String getUnapprovedAt() {
        return this.unapprovedAt;
    }
    
    public void setUnapprovedAt(String unapprovedAt) {
        this.unapprovedAt = unapprovedAt;
    }

    @Column(name="description", length=255, columnDefinition="CHAR(255)")
    @Field
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mercostsheetunapprovedloged pojo = (Mercostsheetunapprovedloged) o;

        if (mercostsheethdr != null ? !mercostsheethdr.equals(pojo.mercostsheethdr) : pojo.mercostsheethdr != null) return false;
        if (unapprovedOn != null ? !unapprovedOn.equals(pojo.unapprovedOn) : pojo.unapprovedOn != null) return false;
        if (unapprovedBy != null ? !unapprovedBy.equals(pojo.unapprovedBy) : pojo.unapprovedBy != null) return false;
        if (unapprovedAt != null ? !unapprovedAt.equals(pojo.unapprovedAt) : pojo.unapprovedAt != null) return false;
        if (description != null ? !description.equals(pojo.description) : pojo.description != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (mercostsheethdr != null ? mercostsheethdr.hashCode() : 0);
        result = 31 * result + (unapprovedOn != null ? unapprovedOn.hashCode() : 0);
        result = 31 * result + (unapprovedBy != null ? unapprovedBy.hashCode() : 0);
        result = 31 * result + (unapprovedAt != null ? unapprovedAt.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("id").append("='").append(getId()).append("', ");
        sb.append("mercostsheethdr").append("='").append(getMercostsheethdr()).append("', ");
        sb.append("unapprovedOn").append("='").append(getUnapprovedOn()).append("', ");
        sb.append("unapprovedBy").append("='").append(getUnapprovedBy()).append("', ");
        sb.append("unapprovedAt").append("='").append(getUnapprovedAt()).append("', ");
        sb.append("description").append("='").append(getDescription()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

}
