package com.excelsoft.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.search.annotations.DocumentId;

@Entity
@Table(name="mercostsheetgroupcolor")
@XmlRootElement
public class Mercostsheetgroupcolor extends BaseObject implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -1806323300654253640L;
	private MercostsheetgroupcolorId id;
    private Mercostsheetgroupsetting mercostsheetgroupsetting;

    public Mercostsheetgroupcolor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Mercostsheetgroupcolor(MercostsheetgroupcolorId id,
			Mercostsheetgroupsetting mercostsheetgroupsetting) {
		super();
		this.id = id;
		this.mercostsheetgroupsetting = mercostsheetgroupsetting;
	}

	@EmbeddedId @DocumentId    
    public MercostsheetgroupcolorId getId() {
        return this.id;
    }
    
    public void setId(MercostsheetgroupcolorId id) {
        this.id = id;
    }

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

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mercostsheetgroupcolor pojo = (Mercostsheetgroupcolor) o;

        if (mercostsheetgroupsetting != null ? !mercostsheetgroupsetting.equals(pojo.mercostsheetgroupsetting) : pojo.mercostsheetgroupsetting != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (mercostsheetgroupsetting != null ? mercostsheetgroupsetting.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("id").append("='").append(getId()).append("', ");
        sb.append("mercostsheetgroupsetting").append("='").append(getMercostsheetgroupsetting()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

}
