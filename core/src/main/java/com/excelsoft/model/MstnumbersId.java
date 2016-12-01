package com.excelsoft.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

@Embeddable
@Indexed
@XmlRootElement
public class MstnumbersId extends BaseObject implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String compCode;
	private short programId;
	private String trnType;

	public MstnumbersId() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MstnumbersId(String compCode, short programId, String trnType) {
		super();
		this.compCode = compCode;
		this.programId = programId;
		this.trnType = trnType;
	}

	@Column(name = "comp_code", nullable = false, length = 10, columnDefinition = "CHAR(10)")
	@Field
	public String getCompCode() {
		return this.compCode;
	}

	public void setCompCode(String compCode) {
		this.compCode = compCode;
	}

	@Column(name = "program_id", nullable = false, precision = 4, scale = 0, columnDefinition = "DECIMAL(4,0)")
	@Field
	public short getProgramId() {
		return this.programId;
	}

	public void setProgramId(short programId) {
		this.programId = programId;
	}

	@Column(name = "trn_type", nullable = false, length = 4, columnDefinition = "CHAR(4)")
	@Field
	public String getTrnType() {
		return this.trnType;
	}

	public void setTrnType(String trnType) {
		this.trnType = trnType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((compCode == null) ? 0 : compCode.hashCode());
		result = prime * result + programId;
		result = prime * result + ((trnType == null) ? 0 : trnType.hashCode());
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
		MstnumbersId other = (MstnumbersId) obj;
		if (compCode == null) {
			if (other.compCode != null)
				return false;
		} else if (!compCode.equals(other.compCode))
			return false;
		if (programId != other.programId)
			return false;
		if (trnType == null) {
			if (other.trnType != null)
				return false;
		} else if (!trnType.equals(other.trnType))
			return false;
		return true;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer(getClass().getSimpleName());

		sb.append(" [");
		sb.append("compCode").append("='").append(getCompCode()).append("', ");
		sb.append("programId").append("='").append(getProgramId())
				.append("', ");
		sb.append("trnType").append("='").append(getTrnType()).append("'");
		sb.append("]");

		return sb.toString();
	}

}
