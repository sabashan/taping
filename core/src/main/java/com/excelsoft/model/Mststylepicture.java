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
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.search.annotations.DocumentId;


/**
 * 
 * @author Raminda
 *
 */
@Table(name = "mststylepicture")
@XmlRootElement
@Entity
public class Mststylepicture extends BaseObject implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8000022250274148730L;
	private MststylepictureId id;
	private Mststyleheader mststyleheader;
	private Mstpicture mstpicture;
	private String mstPicpictures;
	private Integer sequenceNo;
	
	public Mststylepicture() {
	};
	
	public Mststylepicture(MststylepictureId id) {
		super();
		this.id = id;
	};
	/**
	 * 
	 * @param id
	 * @param mststyleheader
	 *//*
	public Mststylepicture(MststylepictureId id, Mststyleheader mststyleheader) {
		super();
		this.id = id;
		this.mststyleheader = mststyleheader;
	}*/

	@EmbeddedId
	@DocumentId
	public MststylepictureId getId() {
		return this.id;
	}

	public void setId(MststylepictureId id) {
		this.id = id;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "pic_code", referencedColumnName = "pic_code", nullable = false, insertable = false, updatable = false)})	
	@JsonIgnore
	public Mstpicture getMstpicture() {
		return mstpicture;
	}

	public void setMstpicture(Mstpicture mstpicture) {
		this.mstpicture = mstpicture;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "style_id", referencedColumnName = "style_id", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "location_code", referencedColumnName = "location_code", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "dep_code", referencedColumnName = "dep_code", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "comp_code", referencedColumnName = "comp_code", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "cust_code", referencedColumnName = "cust_code", nullable = false, insertable = false, updatable = false) })
	@JsonIgnore
	public Mststyleheader getMststyleheader() {
		return this.mststyleheader;
	}
	
	@Column(name = "sequence_no", nullable = false, length = 11 ,columnDefinition="INT")
	public Integer getSequenceNo() {
		return sequenceNo;
	}

	public void setSequenceNo(Integer sequenceNo) {
		this.sequenceNo = sequenceNo;
	}

	public void setMststyleheader(Mststyleheader mststyleheader) {
		this.mststyleheader = mststyleheader;
	}
	
    @Transient
    public String getMstPicpictures() {
        return this.mstPicpictures;
    }
    
    @Transient
    public void setMstPicpictures(String mstPicpictures) {
        this.mstPicpictures= mstPicpictures;
    }
    
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mststylepicture other = (Mststylepicture) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (mstPicpictures == null) {
			if (other.mstPicpictures != null)
				return false;
		} else if (!mstPicpictures.equals(other.mstPicpictures))
			return false;
		if (sequenceNo == null) {
			if (other.sequenceNo != null)
				return false;
		} else if (!sequenceNo.equals(other.sequenceNo))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((mstPicpictures == null) ? 0 : mstPicpictures.hashCode());
		result = prime * result
				+ ((sequenceNo == null) ? 0 : sequenceNo.hashCode());
		return result;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Mststylepicture [id=");
		builder.append(id);
		builder.append(", mstPicpictures=");
		builder.append(mstPicpictures);
		builder.append(", sequenceNo=");
		builder.append(sequenceNo);
		builder.append("]");
		return builder.toString();
	}

}
