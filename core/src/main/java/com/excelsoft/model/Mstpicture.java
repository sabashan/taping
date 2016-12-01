package com.excelsoft.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

@SuppressWarnings("serial")
@Entity
@Table(name = "mstpicture")
@Indexed
@XmlRootElement
public class Mstpicture extends BaseObject implements Serializable {
	private String picCode;
	private String picName;
	private byte[] picture;

	public Mstpicture() {
		super();
		
	}

	public Mstpicture(String picCode, String picName, byte[] picture) {
		super();
		this.picCode = picCode;
		this.picName = picName;
		this.picture = picture;
	}

	@Id
	@DocumentId
	@Column(name = "pic_code" ,columnDefinition="CHAR(255)", length=255)
	public String getPicCode() {
		return this.picCode;
	}

	public void setPicCode(String picCode) {
		this.picCode = picCode;
	}

	@Column(name = "pic_name", length = 50 ,columnDefinition="CHAR(50)")
	@Field
	public String getPicName() {
		return this.picName;
	}

	public void setPicName(String picName) {
		this.picName = picName;
	}

	@Column(name = "picture")
	@Lob
	public byte[] getPicture() {
		return this.picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Mstpicture pojo = (Mstpicture) o;

		if (picName != null ? !picName.equals(pojo.picName)
				: pojo.picName != null)
			return false;
		if (picture != null ? !picture.equals(pojo.picture)
				: pojo.picture != null)
			return false;

		return true;
	}

	public int hashCode() {
		int result = 0;
		result = (picName != null ? picName.hashCode() : 0);
		result = 31 * result + (picture != null ? picture.hashCode() : 0);

		return result;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer(getClass().getSimpleName());

		sb.append(" [");
		sb.append("picCode").append("='").append(getPicCode()).append("', ");
		sb.append("picName").append("='").append(getPicName()).append("', ");
		sb.append("picture").append("='").append(getPicture()).append("'");
		sb.append("]");

		return sb.toString();
	}

}
