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
public class MststylerouteoperationId extends BaseObject implements
		Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer opeartionNo;
	private Long styleRouteId;

	public MststylerouteoperationId() {
		super();
	}

	public MststylerouteoperationId(int opeartionNo, Long styleRouteId) {
		super();
		this.opeartionNo = opeartionNo;
		this.styleRouteId = styleRouteId;
	}

	
	@Column(name = "opeartion_no", nullable = false, precision = 5, scale = 0, columnDefinition = "DECIMAL(5,0)")
	@Field
	public Integer getOpeartionNo() {
		return opeartionNo;
	}

	public void setOpeartionNo(Integer opeartionNo) {
		this.opeartionNo = opeartionNo;
	}

	@Column(name = "style_route_id", nullable = false, columnDefinition = "BIGINT(20)")
	@Field
	public Long getStyleRouteId() {
		return this.styleRouteId;
	}

	public void setStyleRouteId(Long styleRouteId) {
		this.styleRouteId = styleRouteId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((opeartionNo == null) ? 0 : opeartionNo.hashCode());
		result = prime * result
				+ ((styleRouteId == null) ? 0 : styleRouteId.hashCode());
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
		MststylerouteoperationId other = (MststylerouteoperationId) obj;
		if (opeartionNo == null) {
			if (other.opeartionNo != null)
				return false;
		} else if (!opeartionNo.equals(other.opeartionNo))
			return false;
		if (styleRouteId == null) {
			if (other.styleRouteId != null)
				return false;
		} else if (!styleRouteId.equals(other.styleRouteId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MststylerouteoperationId [opeartionNo=");
		builder.append(opeartionNo);
		builder.append(", styleRouteId=");
		builder.append(styleRouteId);
		builder.append("]");
		return builder.toString();
	}

}
