package com.excelsoft.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;

@Entity
@Table(name = "mstnumbers")
@XmlRootElement
public class Mstnumbers extends BaseObject implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MstnumbersId id;
	private Integer trnNo;
	private Character generateNos;

	public Mstnumbers(MstnumbersId id) {
		super();
		this.id = id;
	}
	
	public Mstnumbers(MstnumbersId id, Integer trnNo, Character generateNos) {
		super();
		this.id = id;
		this.trnNo = trnNo;
		this.generateNos = generateNos;
	}

	public Mstnumbers() {
		super();
	}

	@EmbeddedId
	@DocumentId
	public MstnumbersId getId() {
		return this.id;
	}

	public void setId(MstnumbersId id) {
		this.id = id;
	}

	@Column(name = "trn_no", nullable = false, precision = 8, scale = 0, columnDefinition = "DECIMAL(8,0)")
	@Field
	public Integer getTrnNo() {
		return this.trnNo;
	}

	public void setTrnNo(Integer trnNo) {
		this.trnNo = trnNo;
	}

	@Column(name = "generate_nos", length = 1, columnDefinition = "CHAR(1)")
	@Field
	public Character getGenerateNos() {
		return this.generateNos;
	}

	public void setGenerateNos(Character generateNos) {
		this.generateNos = generateNos;
	}

	@Override
	public int hashCode() {
		final Integer prime = 31;
		Integer result = 1;
		result = prime * result
				+ ((generateNos == null) ? 0 : generateNos.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + trnNo;
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
		Mstnumbers other = (Mstnumbers) obj;
		if (generateNos == null) {
			if (other.generateNos != null)
				return false;
		} else if (!generateNos.equals(other.generateNos))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (trnNo != other.trnNo)
			return false;
		return true;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer(getClass().getSimpleName());

		sb.append(" [");
		sb.append("id").append("='").append(getId()).append("', ");
		sb.append("trnNo").append("='").append(getTrnNo()).append("', ");
		sb.append("generateNos").append("='").append(getGenerateNos())
				.append("'");
		sb.append("]");

		return sb.toString();
	}

}
