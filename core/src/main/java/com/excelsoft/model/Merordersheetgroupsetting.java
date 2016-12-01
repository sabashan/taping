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
@Table(name="merordersheetgroupsetting")
@XmlRootElement
public class Merordersheetgroupsetting extends BaseObject implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MerordersheetgroupsettingId id;
    private Merordersheetorder merordersheetorder;
    private String component;
    /*private Set<Merordersheetgroupdemmap> merordersheetgroupdemmaps = new HashSet<Merordersheetgroupdemmap>(0);
    private Set<Merordersheetgroup> merordersheetgroups = new HashSet<Merordersheetgroup>(0);
    private Set<Merordersheetgroupcolor> merordersheetgroupcolors = new HashSet<Merordersheetgroupcolor>(0);*/
    
    public Merordersheetgroupsetting() {
		super();
	}
    
    

    public Merordersheetgroupsetting(MerordersheetgroupsettingId id,
			Merordersheetorder merordersheetorder, String component) {
		super();
		this.id = id;
		this.merordersheetorder = merordersheetorder;
		this.component = component;
	}

    


	public Merordersheetgroupsetting(MerordersheetgroupsettingId id) {
		super();
		this.id = id;
	}



	@EmbeddedId @DocumentId    
    public MerordersheetgroupsettingId getId() {
        return this.id;
    }
    
   

	public void setId(MerordersheetgroupsettingId id) {
        this.id = id;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumns( { 
        @JoinColumn(name="ordersheet_id", referencedColumnName="ordersheet_id", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="planing_ordersheet_no", referencedColumnName="planing_ordersheet_no", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="order_type", referencedColumnName="order_type", nullable=false, insertable=false, updatable=false) } )
    public Merordersheetorder getMerordersheetorder() {
        return this.merordersheetorder;
    }
    
    public void setMerordersheetorder(Merordersheetorder merordersheetorder) {
        this.merordersheetorder = merordersheetorder;
    }
    
    @Column(name="component", length=6, columnDefinition="CHAR(6)")
    @Field
    public String getComponent() {
        return this.component;
    }
    
    public void setComponent(String component) {
        this.component = component;
    }
/*@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="merordersheetgroupsetting")
    public Set<Merordersheetgroupdemmap> getMerordersheetgroupdemmaps() {
        return this.merordersheetgroupdemmaps;
    }
    
    public void setMerordersheetgroupdemmaps(Set<Merordersheetgroupdemmap> merordersheetgroupdemmaps) {
        this.merordersheetgroupdemmaps = merordersheetgroupdemmaps;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="merordersheetgroupsetting")
    public Set<Merordersheetgroup> getMerordersheetgroups() {
        return this.merordersheetgroups;
    }
    
    public void setMerordersheetgroups(Set<Merordersheetgroup> merordersheetgroups) {
        this.merordersheetgroups = merordersheetgroups;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="merordersheetgroupsetting")
    public Set<Merordersheetgroupcolor> getMerordersheetgroupcolors() {
        return this.merordersheetgroupcolors;
    }
    
    public void setMerordersheetgroupcolors(Set<Merordersheetgroupcolor> merordersheetgroupcolors) {
        this.merordersheetgroupcolors = merordersheetgroupcolors;
    }*/

    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Merordersheetgroupsetting other = (Merordersheetgroupsetting) obj;
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
		return true;
	}

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((component == null) ? 0 : component.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

    @Override
	public String toString() {
		return "Merordersheetgroupsetting [id=" + id + ", component="
				+ component + "]";
	}

}
