package com.excelsoft.model;

import com.excelsoft.model.BaseObject;

import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;

@Entity
@Table(name="mstgencodes")
@XmlRootElement
public class Mstgencodes extends BaseObject implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -6770735721828037310L;
	private MstgencodesId id;
    private String desc;
    private int uomDenom;
    private String locationCode;
    private String createdBy;
    private Date createdOn;
    private String createdAt;
    private String modifiedBy;
    private Date modifiedOn;
    private String modifiedAt;
    private String edit;
    private String remoteLocation;
    private Character gspApprovedCountry;


    
    public Mstgencodes(MstgencodesId id) {
		super();
		this.id = id;
	}

	public Mstgencodes() {
		super();
	}

	public Mstgencodes(MstgencodesId id, String desc, int uomDenom,
			String locationCode, String createdBy, Date createdOn,
			String createdAt, String modifiedBy, Date modifiedOn,
			String modifiedAt, String edit, String remoteLocation,
			Character gspApprovedCountry) {
		super();
		this.id = id;
		this.desc = desc;
		this.uomDenom = uomDenom;
		this.locationCode = locationCode;
		this.createdBy = createdBy;
		this.createdOn = createdOn;
		this.createdAt = createdAt;
		this.modifiedBy = modifiedBy;
		this.modifiedOn = modifiedOn;
		this.modifiedAt = modifiedAt;
		this.edit = edit;
		this.remoteLocation = remoteLocation;
		this.gspApprovedCountry = gspApprovedCountry;
	}

	@EmbeddedId @DocumentId    
    public MstgencodesId getId() {
        return this.id;
    }
    
    public void setId(MstgencodesId id) {
        this.id = id;
    }
    
    
    @Column(name="desc", length=30 ,columnDefinition="CHAR(30)")
    @Field
    public String getDesc() {
        return this.desc;
    }
    
    public void setDesc(String desc) {
        this.desc = desc;
    }
    
    @Column(name="uom_denom", nullable=false, precision=6, scale=0)
    @Field
    public int getUomDenom() {
        return this.uomDenom;
    }
    
    public void setUomDenom(int uomDenom) {
        this.uomDenom = uomDenom;
    }
    
    @Column(name="location_code", length=6 ,columnDefinition="CHAR(6)")
    @Field
    public String getLocationCode() {
        return this.locationCode;
    }
    
    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
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
    
    @Column(name="edit", length=3 ,columnDefinition="CHAR(3)")
    @Field
    public String getedits() {
        return this.edit;
    }
    
    public void setedits(String edits) {
        this.edit = edits;
    }
    
    @Column(name="remote_location", length=6 ,columnDefinition="CHAR(6)")
    @Field
    public String getRemoteLocation() {
        return this.remoteLocation;
    }
    
    public void setRemoteLocation(String remoteLocation) {
        this.remoteLocation = remoteLocation;
    }
    
    @Column(name="gsp_approved_country", length=1)
    @Field
    public Character getGspApprovedCountry() {
        return this.gspApprovedCountry;
    }
    
    public void setGspApprovedCountry(Character gspApprovedCountry) {
        this.gspApprovedCountry = gspApprovedCountry;
    }


    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mstgencodes other = (Mstgencodes) obj;
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
		if (desc == null) {
			if (other.desc != null)
				return false;
		} else if (!desc.equals(other.desc))
			return false;
		if (edit == null) {
			if (other.edit != null)
				return false;
		} else if (!edit.equals(other.edit))
			return false;
		if (gspApprovedCountry == null) {
			if (other.gspApprovedCountry != null)
				return false;
		} else if (!gspApprovedCountry.equals(other.gspApprovedCountry))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (locationCode == null) {
			if (other.locationCode != null)
				return false;
		} else if (!locationCode.equals(other.locationCode))
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
		if (remoteLocation == null) {
			if (other.remoteLocation != null)
				return false;
		} else if (!remoteLocation.equals(other.remoteLocation))
			return false;
		if (uomDenom != other.uomDenom)
			return false;
		return true;
	}

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((createdAt == null) ? 0 : createdAt.hashCode());
		result = prime * result
				+ ((createdBy == null) ? 0 : createdBy.hashCode());
		result = prime * result
				+ ((createdOn == null) ? 0 : createdOn.hashCode());
		result = prime * result + ((desc == null) ? 0 : desc.hashCode());
		result = prime * result + ((edit == null) ? 0 : edit.hashCode());
		result = prime
				* result
				+ ((gspApprovedCountry == null) ? 0 : gspApprovedCountry
						.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((locationCode == null) ? 0 : locationCode.hashCode());
		result = prime * result
				+ ((modifiedAt == null) ? 0 : modifiedAt.hashCode());
		result = prime * result
				+ ((modifiedBy == null) ? 0 : modifiedBy.hashCode());
		result = prime * result
				+ ((modifiedOn == null) ? 0 : modifiedOn.hashCode());
		result = prime * result
				+ ((remoteLocation == null) ? 0 : remoteLocation.hashCode());
		result = prime * result + uomDenom;
		return result;
	}

    @Override
	public String toString() {
		return "Mstgencodes [id=" + id + ", desc=" + desc + ", uomDenom="
				+ uomDenom + ", locationCode=" + locationCode + ", createdBy="
				+ createdBy + ", createdOn=" + createdOn + ", createdAt="
				+ createdAt + ", modifiedBy=" + modifiedBy + ", modifiedOn="
				+ modifiedOn + ", modifiedAt=" + modifiedAt + ", edit=" + edit
				+ ", remoteLocation=" + remoteLocation
				+ ", gspApprovedCountry=" + gspApprovedCountry + "]";
	}

}
