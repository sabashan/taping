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

import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;

@Entity
@Table(name="mercostsheetgroupsetting")
@XmlRootElement
public class Mercostsheetgroupsetting extends BaseObject implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 5004824631225817472L;
	private MercostsheetgroupsettingId id;
    private Mercostsheetgroup mercostsheetgroup;
    private String component;
    private Integer lineNo;
//    private Set<Mercostsheetgroupdemmap> mercostsheetgroupdemmaps = new HashSet<Mercostsheetgroupdemmap>(0);
//    private Set<Mercostsheetgroupcolor> mercostsheetgroupcolors = new HashSet<Mercostsheetgroupcolor>(0);

    @EmbeddedId @DocumentId    
    public MercostsheetgroupsettingId getId() {
        return this.id;
    }
    
    public Mercostsheetgroupsetting() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Mercostsheetgroupsetting(MercostsheetgroupsettingId id,
			Mercostsheetgroup mercostsheetgroup, String component,
			Integer lineNo) {
		super();
		this.id = id;
		this.mercostsheetgroup = mercostsheetgroup;
		this.component = component;
		this.lineNo = lineNo;
	}

	public Mercostsheetgroupsetting(MercostsheetgroupsettingId id2,
			Mercostsheetgroup mercostsheetgroup2, String componentId) {
		// TODO Auto-generated constructor stub
		/******* changed by nuwan */
	}

	public void setId(MercostsheetgroupsettingId id) {
        this.id = id;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumns( { 
        @JoinColumn(name="group_id", referencedColumnName="group_id", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="cost_sheet_no", referencedColumnName="cost_sheet_no", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="version_no", referencedColumnName="version_no", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="cost_sheet_type", referencedColumnName="cost_sheet_type", nullable=false, insertable=false, updatable=false) } )
    public Mercostsheetgroup getMercostsheetgroup() {
        return this.mercostsheetgroup;
    }
    
    public void setMercostsheetgroup(Mercostsheetgroup mercostsheetgroup) {
        this.mercostsheetgroup = mercostsheetgroup;
    }

    @Column(name="component", length=6, columnDefinition="CHAR(6)")
    @Field
    public String getComponent() {
        return this.component;
    }
    
    public void setComponent(String component) {
        this.component = component;
    }
    
    @Column(name="line_no", length=2, columnDefinition="INT(2)")
    @Field
	public Integer getLineNo() {
		return lineNo;
	}

	public void setLineNo(Integer lineNo) {
		this.lineNo = lineNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((component == null) ? 0 : component.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lineNo == null) ? 0 : lineNo.hashCode());
		result = prime
				* result
				+ ((mercostsheetgroup == null) ? 0 : mercostsheetgroup
						.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mercostsheetgroupsetting other = (Mercostsheetgroupsetting) obj;
		if (component == null) {
			if (other.component != null)
				return false;
		} else if (!component.equals(other.component))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lineNo == null) {
			if (other.lineNo != null)
				return false;
		} else if (!lineNo.equals(other.lineNo))
			return false;
		if (mercostsheetgroup == null) {
			if (other.mercostsheetgroup != null)
				return false;
		} else if (!mercostsheetgroup.equals(other.mercostsheetgroup))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Mercostsheetgroupsetting [id=");
		builder.append(id);
		builder.append(", component=");
		builder.append(component);
		builder.append(", lineNo=");
		builder.append(lineNo);
		builder.append("]");
		return builder.toString();
	}

}
