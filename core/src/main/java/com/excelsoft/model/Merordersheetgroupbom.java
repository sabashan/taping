package com.excelsoft.model;

import java.io.Serializable;
import java.math.BigDecimal;

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
@Table(name = "merordersheetgroupbom")
@XmlRootElement
public class Merordersheetgroupbom extends BaseObject implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MerordersheetgroupbomId id;
	private Merordersheetgroup merordersheetgroup;
/*
 * private MerordersheetrawmaterialId id;
    private Mstitemtype mstitemtype;
    private Merordersheethdr merordersheethdr;
    private Mstcurrency mstcurrency;
    private Mstsupplier mstsupplier;
    private String additionalAttribute1;
    private String additionalAttribute2;
    private String itemColor;
    private String itemWidth;
    private String shipingType;
    private Long exchangeRate;
    private Long price;
    private Long finance;
    private Boolean isShellFabric;
    private Boolean isLocked;
    private String bomPlacement;
    private BigDecimal itemConsumtion;
    private String unit;
    private String itemCode;
    private BigDecimal allowPrecent;
    private Character sizeWiseIndent;
 */
	public Merordersheetgroupbom() {
		super();
	}

	public Merordersheetgroupbom(MerordersheetgroupbomId id) {
		super();
		this.id = id;
	}

	public Merordersheetgroupbom(MerordersheetgroupbomId id,
			Merordersheetgroup merordersheetgroup) {
		super();
		this.id = id;
		this.merordersheetgroup = merordersheetgroup;
	}

	@EmbeddedId
	@DocumentId
	public MerordersheetgroupbomId getId() {
		return this.id;
	}

	public void setId(MerordersheetgroupbomId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "group_id", referencedColumnName = "group_id", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "group_setting_id", referencedColumnName = "group_setting_id", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "ordersheet_id", referencedColumnName = "ordersheet_id", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "planing_ordersheet_no", referencedColumnName = "planing_ordersheet_no", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "order_type", referencedColumnName = "order_type", nullable = false, insertable = false, updatable = false) })
	public Merordersheetgroup getMerordersheetgroup() {
		return this.merordersheetgroup;
	}

	public void setMerordersheetgroup(Merordersheetgroup merordersheetgroup) {
		this.merordersheetgroup = merordersheetgroup;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Merordersheetgroupbom other = (Merordersheetgroupbom) obj;
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
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "Merordersheetgroupbom [id=" + id + "]";
	}

}
