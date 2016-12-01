package com.excelsoft.model;

import com.excelsoft.model.BaseObject;

import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;

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
import java.math.BigDecimal;

@Entity
@Table(name="merprecostsheetsmv")
@XmlRootElement
public class Merprecostsheetsmv extends BaseObject implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -5259434439685056400L;
	private MerprecostsheetsmvId id;
    private Merprecostsheet merprecostsheet;
    private String routeLocation;
    private Mststyleroute styleRouteId;
    private BigDecimal ratio;
	private String fmvCategory;
	private BigDecimal fmv;
	private BigDecimal lineEfficency;

    
	public Merprecostsheetsmv(MerprecostsheetsmvId id) {
		super();
		this.id = id;
	}
    public Merprecostsheetsmv() {
		super();
		
	}
	

	public Merprecostsheetsmv(MerprecostsheetsmvId id,
			Merprecostsheet merprecostsheet, String routeLocation,
			Mststyleroute styleRouteId, BigDecimal ratio, String fmvCategory,
			BigDecimal fmv, BigDecimal lineEfficency) {
		super();
		this.id = id;
		this.merprecostsheet = merprecostsheet;
		this.routeLocation = routeLocation;
		this.styleRouteId = styleRouteId;
		this.ratio = ratio;
		this.fmvCategory = fmvCategory;
		this.fmv = fmv;
		this.lineEfficency = lineEfficency;
	}

	@EmbeddedId @DocumentId    
    public MerprecostsheetsmvId getId() {
        return this.id;
    }
    
    public void setId(MerprecostsheetsmvId id) {
        this.id = id;
    }
    @Column(name="fmv", precision=10, scale=0, columnDefinition="DECIMAL(10,0)")
    @Field
    public BigDecimal getFmv() {
		return fmv;
	}

	public void setFmv(BigDecimal fmv) {
		this.fmv = fmv;
	}
	@Column(name="fmv_category", length=10, columnDefinition="CHAR(10)")
    @Field
	public String getFmvCategory() {
		return fmvCategory;
	}

	public void setFmvCategory(String fmvCategory) {
		this.fmvCategory = fmvCategory;
	}
	
	@Column(name="line_efficency", precision=20, scale=6, columnDefinition="DECIMAL(20,6)")
    @Field
	public BigDecimal getLineEfficency() {
		return lineEfficency;
	}
	
	public void setLineEfficency(BigDecimal lineEfficency) {
		this.lineEfficency = lineEfficency;
	}
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumns( { 
        @JoinColumn(name="pre_cost_sheet_no", referencedColumnName="pre_cost_sheet_no", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="version_no", referencedColumnName="version_no", nullable=false, insertable=false, updatable=false) ,
        @JoinColumn(name="costsheet_type", referencedColumnName="costsheet_type", nullable=false, insertable=false, updatable=false)} )
public Merprecostsheet getMerprecostsheet() {
        return this.merprecostsheet;
    }
    
    public void setMerprecostsheet(Merprecostsheet merprecostsheet) {
        this.merprecostsheet = merprecostsheet;
    }
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="style_route_id", referencedColumnName="style_route_id", nullable=false, insertable=false, updatable=false)
    public Mststyleroute getStyleRouteId() {
		return styleRouteId;
	}
	public void setStyleRouteId(Mststyleroute styleRouteId) {
		this.styleRouteId = styleRouteId;
	}
	@Column(name="route_location", length=6 ,columnDefinition="CHAR(6)")
    @Field
    public String getRouteLocation() {
        return this.routeLocation;
    }
    
    public void setRouteLocation(String routeLocation) {
        this.routeLocation = routeLocation;
    }
    
    @Column(name="ratio", precision=10, scale=0 ,columnDefinition="DECIMAL(10)")
    @Field
    public BigDecimal getRatio() {
        return this.ratio;
    }
    
    public void setRatio(BigDecimal ratio) {
        this.ratio = ratio;
    }

    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Merprecostsheetsmv other = (Merprecostsheetsmv) obj;
		if (fmv == null) {
			if (other.fmv != null)
				return false;
		} else if (!fmv.equals(other.fmv))
			return false;
		if (fmvCategory == null) {
			if (other.fmvCategory != null)
				return false;
		} else if (!fmvCategory.equals(other.fmvCategory))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lineEfficency == null) {
			if (other.lineEfficency != null)
				return false;
		} else if (!lineEfficency.equals(other.lineEfficency))
			return false;
		if (ratio == null) {
			if (other.ratio != null)
				return false;
		} else if (!ratio.equals(other.ratio))
			return false;
		if (routeLocation == null) {
			if (other.routeLocation != null)
				return false;
		} else if (!routeLocation.equals(other.routeLocation))
			return false;
		if (styleRouteId == null) {
			if (other.styleRouteId != null)
				return false;
		} else if (!styleRouteId.equals(other.styleRouteId))
			return false;
		return true;
	}

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fmv == null) ? 0 : fmv.hashCode());
		result = prime * result
				+ ((fmvCategory == null) ? 0 : fmvCategory.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((lineEfficency == null) ? 0 : lineEfficency.hashCode());
		result = prime * result + ((ratio == null) ? 0 : ratio.hashCode());
		result = prime * result
				+ ((routeLocation == null) ? 0 : routeLocation.hashCode());
		result = prime * result
				+ ((styleRouteId == null) ? 0 : styleRouteId.hashCode());
		return result;
	}

    @Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Merprecostsheetsmv [id=");
		builder.append(id);
		builder.append(", routeLocation=");
		builder.append(routeLocation);
		builder.append(", styleRouteId=");
		builder.append(styleRouteId);
		builder.append(", ratio=");
		builder.append(ratio);
		builder.append(", fmvCategory=");
		builder.append(fmvCategory);
		builder.append(", fmv=");
		builder.append(fmv);
		builder.append(", lineEfficency=");
		builder.append(lineEfficency);
		builder.append("]");
		return builder.toString();
	}

}
