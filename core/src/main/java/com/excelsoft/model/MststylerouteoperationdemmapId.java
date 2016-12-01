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
public class MststylerouteoperationdemmapId extends BaseObject implements
		Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int opeartionNo;
	private Long styleRouteId;
	private String verticalDem;
	private String horizontalDem;
	private String horizontalValue;
	private String verticalValue;
	private String mainColor;

	public MststylerouteoperationdemmapId() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MststylerouteoperationdemmapId(int opeartionNo, Long styleRouteId,
			String verticalDem, String horizontalDem, String horizontalValue,
			String verticalValue,String mainColor) {
		super();
		this.opeartionNo = opeartionNo;
		this.styleRouteId = styleRouteId;
		this.verticalDem = verticalDem;
		this.horizontalDem = horizontalDem;
		this.horizontalValue = horizontalValue;
		this.verticalValue = verticalValue;
		this.mainColor = mainColor;
	}

	@Column(name = "opeartion_no", nullable = false, columnDefinition = "DECIMAL(5,0)")
	@Field
	public int getOpeartionNo() {
		return this.opeartionNo;
	}

	public void setOpeartionNo(int opeartionNo) {
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

	@Column(name = "vertical_dem", nullable = false, length = 45, columnDefinition = "CHAR(45)")
	@Field
	public String getVerticalDem() {
		return this.verticalDem;
	}

	public void setVerticalDem(String verticalDem) {
		this.verticalDem = verticalDem;
	}

	@Column(name = "horizontal_dem", nullable = false, length = 45, columnDefinition = "CHAR(45)")
	@Field
	public String getHorizontalDem() {
		return this.horizontalDem;
	}

	public void setHorizontalDem(String horizontalDem) {
		this.horizontalDem = horizontalDem;
	}

	@Column(name = "horizontal_value", nullable = false, length = 45, columnDefinition = "CHAR(45)")
	@Field
	public String getHorizontalValue() {
		return this.horizontalValue;
	}

	public void setHorizontalValue(String horizontalValue) {
		this.horizontalValue = horizontalValue;
	}

	@Column(name = "vertical_value", nullable = false, length = 45, columnDefinition = "CHAR(45)")
	@Field
	public String getVerticalValue() {
		return this.verticalValue;
	}

	public void setVerticalValue(String verticalValue) {
		this.verticalValue = verticalValue;
	}
	
	@Column(name = "main_color", nullable = false, length = 10, columnDefinition = "char(10)")
	@Field
	public String getMainColor() {
		return mainColor;
	}

	public void setMainColor(String mainColor) {
		this.mainColor = mainColor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((horizontalDem == null) ? 0 : horizontalDem.hashCode());
		result = prime * result
				+ ((horizontalValue == null) ? 0 : horizontalValue.hashCode());
		result = prime * result
				+ ((mainColor == null) ? 0 : mainColor.hashCode());
		result = prime * result + opeartionNo;
		result = prime * result
				+ ((styleRouteId == null) ? 0 : styleRouteId.hashCode());
		result = prime * result
				+ ((verticalDem == null) ? 0 : verticalDem.hashCode());
		result = prime * result
				+ ((verticalValue == null) ? 0 : verticalValue.hashCode());
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
		MststylerouteoperationdemmapId other = (MststylerouteoperationdemmapId) obj;
		if (horizontalDem == null) {
			if (other.horizontalDem != null)
				return false;
		} else if (!horizontalDem.equals(other.horizontalDem))
			return false;
		if (horizontalValue == null) {
			if (other.horizontalValue != null)
				return false;
		} else if (!horizontalValue.equals(other.horizontalValue))
			return false;
		if (mainColor == null) {
			if (other.mainColor != null)
				return false;
		} else if (!mainColor.equals(other.mainColor))
			return false;
		if (opeartionNo != other.opeartionNo)
			return false;
		if (styleRouteId == null) {
			if (other.styleRouteId != null)
				return false;
		} else if (!styleRouteId.equals(other.styleRouteId))
			return false;
		if (verticalDem == null) {
			if (other.verticalDem != null)
				return false;
		} else if (!verticalDem.equals(other.verticalDem))
			return false;
		if (verticalValue == null) {
			if (other.verticalValue != null)
				return false;
		} else if (!verticalValue.equals(other.verticalValue))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MststylerouteoperationdemmapId [opeartionNo=" + opeartionNo
				+ ", styleRouteId=" + styleRouteId + ", verticalDem="
				+ verticalDem + ", horizontalDem=" + horizontalDem
				+ ", horizontalValue=" + horizontalValue + ", verticalValue="
				+ verticalValue + ", mainColor=" + mainColor + "]";
	}

}
