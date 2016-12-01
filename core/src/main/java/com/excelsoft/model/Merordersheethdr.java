package com.excelsoft.model;


import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;

@Entity
@Table(name = "merordersheethdr")
@XmlRootElement
public class Merordersheethdr extends AuditFields implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 90740348686538218L;
	private MerordersheethdrId id;
	private Mststyleheader mststyleheader;
	private Long totalQty;
	private String remarks;
	private Boolean isProcess;
	private String status;
	private String season;
	private String buyer;
    private String location;
    private String department;
    private String company;
	/*
	 * private Set<Merordersheetrawmaterial> merordersheetrawmaterials = new
	 * HashSet<Merordersheetrawmaterial>(0);
	 */

	public Merordersheethdr() {
		super();
	}

	public Merordersheethdr(MerordersheethdrId id) {
		super();
		this.id = id;
	}

	

	public Merordersheethdr(MerordersheethdrId id,
			Mststyleheader mststyleheader, Long totalQty, String remarks,
			Boolean isProcess, String status, String season, String buyer) {
		super();
		this.id = id;
		this.mststyleheader = mststyleheader;
		this.totalQty = totalQty;
		this.remarks = remarks;
		this.isProcess = isProcess;
		this.status = status;
		this.season = season;
		this.buyer = buyer;
	}

	@EmbeddedId
	@DocumentId
	public MerordersheethdrId getId() {
		return this.id;
	}

	public void setId(MerordersheethdrId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumns({
			@JoinColumn(name = "comp_code", referencedColumnName = "comp_code", nullable = true),
			@JoinColumn(name = "cust_code", referencedColumnName = "cust_code", nullable = true),
			@JoinColumn(name = "dep_code", referencedColumnName = "dep_code", nullable = true),
			@JoinColumn(name = "location_code", referencedColumnName = "location_code", nullable = true),
			@JoinColumn(name = "style_id", referencedColumnName = "style_id", nullable = true) })
	public Mststyleheader getMststyleheader() {
		return this.mststyleheader;
	}

	public void setMststyleheader(Mststyleheader mststyleheader) {
		this.mststyleheader = mststyleheader;
	}

	@Column(name = "season", nullable = false, length = 10, columnDefinition = "CHAR(10)")
	@Field
	public String getSeason() {
		return this.season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	@Column(name = "total_qty", precision = 14, scale = 0, columnDefinition = "BIGINT(14)")
	@Field
	public Long getTotalQty() {
		return this.totalQty;
	}

	public void setTotalQty(Long totalQty) {
		this.totalQty = totalQty;
	}

	@Column(name = "remarks", columnDefinition = "CHAR(255)")
	@Field
	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Column(name = "is_process")
	@Field
	public Boolean getIsProcess() {
		return this.isProcess;
	}

	public void setIsProcess(Boolean isProcess) {
		this.isProcess = isProcess;
	}

	@Column(name = "status", length = 10, columnDefinition = "CHAR(10)")
	@Field
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@Column(name="buyer", length=10 ,columnDefinition="CHAR(10)") 
	 @Field
	public String getBuyer() {
		return buyer;
	}

	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}
	 @Column(name="location", length=6 ,columnDefinition="CHAR(6)")
	    @Field
	    public String getLocation() {
	        return this.location;
	    }
	    
	    public void setLocation(String location) {
	        this.location = location;
	    }

	    @Column(name="department", length=6 ,columnDefinition="CHAR(10)")
	    @Field
	    public String getDepartment() {
	        return this.department;
	    }
	    
	    public void setDepartment(String department) {
	        this.department = department;
	    }

	    @Column(name="company",  length=6 ,columnDefinition="CHAR(6)")
	    @Field
	    public String getCompany() {
	        return this.company;
	    }
	    
	    public void setCompany(String company) {
	        this.company = company;
	    }
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Merordersheethdr other = (Merordersheethdr) obj;
		if (buyer == null) {
			if (other.buyer != null)
				return false;
		} else if (!buyer.equals(other.buyer))
			return false;
		if (company == null) {
			if (other.company != null)
				return false;
		} else if (!company.equals(other.company))
			return false;
		if (department == null) {
			if (other.department != null)
				return false;
		} else if (!department.equals(other.department))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isProcess == null) {
			if (other.isProcess != null)
				return false;
		} else if (!isProcess.equals(other.isProcess))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (remarks == null) {
			if (other.remarks != null)
				return false;
		} else if (!remarks.equals(other.remarks))
			return false;
		if (season == null) {
			if (other.season != null)
				return false;
		} else if (!season.equals(other.season))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (totalQty == null) {
			if (other.totalQty != null)
				return false;
		} else if (!totalQty.equals(other.totalQty))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((buyer == null) ? 0 : buyer.hashCode());
		result = prime * result + ((company == null) ? 0 : company.hashCode());
		result = prime * result
				+ ((department == null) ? 0 : department.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((isProcess == null) ? 0 : isProcess.hashCode());
		result = prime * result
				+ ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((remarks == null) ? 0 : remarks.hashCode());
		result = prime * result + ((season == null) ? 0 : season.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result
				+ ((totalQty == null) ? 0 : totalQty.hashCode());
		return result;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Merordersheethdr [id=");
		builder.append(id);
		builder.append(", totalQty=");
		builder.append(totalQty);
		builder.append(", remarks=");
		builder.append(remarks);
		builder.append(", isProcess=");
		builder.append(isProcess);
		builder.append(", status=");
		builder.append(status);
		builder.append(", season=");
		builder.append(season);
		builder.append(", buyer=");
		builder.append(buyer);
		builder.append(", location=");
		builder.append(location);
		builder.append(", department=");
		builder.append(department);
		builder.append(", company=");
		builder.append(company);
		builder.append("]");
		return builder.toString();
	}

}
