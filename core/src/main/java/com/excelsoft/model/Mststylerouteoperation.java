package com.excelsoft.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;

@Entity
@Table(name = "mststylerouteoperation")
@XmlRootElement
public class Mststylerouteoperation extends AuditFields implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5774397403419811581L;
	private MststylerouteoperationId id;
	private Mststyleroute mststyleroute;
	private String operationDesc;
	private String operationDescBref;
	private String operationType;
	private String machineTypeDefault;
	private Character sewingOperation;
	private String operation;
	private String process;
	private String grade;
	private BigDecimal averageSmv;
	private BigDecimal revision1;
	private BigDecimal revision2;
	private BigDecimal revision3;
	private BigDecimal revision4;
	private BigDecimal revision5;
	private Boolean calc;
	private String workAid;
	private Boolean manual;
	private String wipPoints;
	private Boolean printBundleTicket;
	private BigDecimal defaultSmv;
	private Long sizeWiseSmvMatrix;
	private Long sequenceNo;

	@EmbeddedId
	@DocumentId
	public MststylerouteoperationId getId() {
		return this.id;
	}

	public void setId(MststylerouteoperationId id) {
		this.id = id;
	}

	@ManyToOne(fetch=FetchType.LAZY )
	@JoinColumn(name = "style_route_id", nullable = false, insertable = false, updatable = false)
	@JsonIgnore
	public Mststyleroute getMststyleroute() {
		return this.mststyleroute;
	}

	public void setMststyleroute(Mststyleroute mststyleroute) {
		this.mststyleroute = mststyleroute;
	}

	@Column(name = "operation_desc", length = 50, columnDefinition = "CHAR(50)")
	@Field
	public String getOperationDesc() {
		return this.operationDesc;
	}

	public void setOperationDesc(String operationDesc) {
		this.operationDesc = operationDesc;
	}

	@Column(name = "operation_desc_bref", length = 20, columnDefinition = "CHAR(20)")
	@Field
	public String getOperationDescBref() {
		return this.operationDescBref;
	}

	public void setOperationDescBref(String operationDescBref) {
		this.operationDescBref = operationDescBref;
	}

	@Column(name = "operation_type", length = 10, columnDefinition = "CHAR(10)")
	@Field
	public String getOperationType() {
		return this.operationType;
	}

	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}

	@Column(name = "machine_type_default", length = 6, columnDefinition = "CHAR(6)")
	@Field
	public String getMachineTypeDefault() {
		return this.machineTypeDefault;
	}

	public void setMachineTypeDefault(String machineTypeDefault) {
		this.machineTypeDefault = machineTypeDefault;
	}

	@Column(name = "sewing_operation", length = 1, columnDefinition = "CHAR(1)")
	@Field
	public Character getSewingOperation() {
		return this.sewingOperation;
	}

	public void setSewingOperation(Character sewingOperation) {
		this.sewingOperation = sewingOperation;
	}

	@Column(name = "operation", length = 45, columnDefinition = "CHAR(45)")
	@Field
	public String getOperation() {
		return this.operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	@Column(name = "process", nullable = false, length = 45, columnDefinition = "CHAR(45)")
	@Field
	public String getProcess() {
		return this.process;
	}

	public void setProcess(String process) {
		this.process = process;
	}

	@Column(name = "grade", length = 45, columnDefinition = "CHAR(45)")
	@Field
	public String getGrade() {
		return this.grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Column(name = "average_smv", precision = 20, scale = 4, columnDefinition = "DECIMAL(20,4)")
	@Field
	public BigDecimal getAverageSmv() {
		return this.averageSmv;
	}

	public void setAverageSmv(BigDecimal averageSmv) {
		this.averageSmv = averageSmv;
	}

	@Column(name = "revision1", precision = 20, scale = 4, columnDefinition = "DECIMAL(20,4)")
	@Field
	public BigDecimal getRevision1() {
		return this.revision1;
	}

	public void setRevision1(BigDecimal revision1) {
		this.revision1 = revision1;
	}

	@Column(name = "revision2", precision = 20, scale = 4, columnDefinition = "DECIMAL(20,4)")
	@Field
	public BigDecimal getRevision2() {
		return this.revision2;
	}

	public void setRevision2(BigDecimal revision2) {
		this.revision2 = revision2;
	}

	@Column(name = "revision3", precision = 20, scale = 4, columnDefinition = "DECIMAL(20,4)")
	@Field
	public BigDecimal getRevision3() {
		return this.revision3;
	}

	public void setRevision3(BigDecimal revision3) {
		this.revision3 = revision3;
	}

	@Column(name = "revision4", precision = 20, scale = 4, columnDefinition = "DECIMAL(20,4)")
	@Field
	public BigDecimal getRevision4() {
		return this.revision4;
	}

	public void setRevision4(BigDecimal revision4) {
		this.revision4 = revision4;
	}

	@Column(name = "revision5", precision = 20, scale = 4, columnDefinition = "DECIMAL(20,4)")
	@Field
	public BigDecimal getRevision5() {
		return this.revision5;
	}

	public void setRevision5(BigDecimal revision5) {
		this.revision5 = revision5;
	}

	@Column(name = "calc")
	@Field
	public Boolean getCalc() {
		return this.calc;
	}

	public void setCalc(Boolean calc) {
		this.calc = calc;
	}

	@Column(name = "work_aid", length = 45, columnDefinition = "CHAR(45)")
	@Field
	public String getWorkAid() {
		return this.workAid;
	}

	public void setWorkAid(String workAid) {
		this.workAid = workAid;
	}

	@Column(name = "manual")
	@Field
	public Boolean getManual() {
		return this.manual;
	}

	public void setManual(Boolean manual) {
		this.manual = manual;
	}

	@Column(name = "wip_points", length = 45, columnDefinition = "CHAR(45)")
	@Field
	public String getWipPoints() {
		return this.wipPoints;
	}

	public void setWipPoints(String wipPoints) {
		this.wipPoints = wipPoints;
	}

	@Column(name = "print_bundle_ticket")
	@Field
	public Boolean getPrintBundleTicket() {
		return this.printBundleTicket;
	}

	public void setPrintBundleTicket(Boolean printBundleTicket) {
		this.printBundleTicket = printBundleTicket;
	}

	@Column(name = "default_smv")
	@Field
	public BigDecimal getDefaultSmv() {
		return this.defaultSmv;
	}

	public void setDefaultSmv(BigDecimal defaultSmv) {
		this.defaultSmv = defaultSmv;
	}

	@Column(name = "size_wise_smv_matrix")
	@Field
	public Long getSizeWiseSmvMatrix() {
		return this.sizeWiseSmvMatrix;
	}

	public void setSizeWiseSmvMatrix(Long sizeWiseSmvMatrix) {
		this.sizeWiseSmvMatrix = sizeWiseSmvMatrix;
	}

	@Column(name = "sequence_no")
	@Field
	public Long getSequenceNo() {
		return this.sequenceNo;
	}

	public void setSequenceNo(Long sequenceNo) {
		this.sequenceNo = sequenceNo;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mststylerouteoperation other = (Mststylerouteoperation) obj;
		if (averageSmv == null) {
			if (other.averageSmv != null)
				return false;
		} else if (!averageSmv.equals(other.averageSmv))
			return false;
		if (calc == null) {
			if (other.calc != null)
				return false;
		} else if (!calc.equals(other.calc))
			return false;
		if (defaultSmv == null) {
			if (other.defaultSmv != null)
				return false;
		} else if (!defaultSmv.equals(other.defaultSmv))
			return false;
		if (grade == null) {
			if (other.grade != null)
				return false;
		} else if (!grade.equals(other.grade))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (machineTypeDefault == null) {
			if (other.machineTypeDefault != null)
				return false;
		} else if (!machineTypeDefault.equals(other.machineTypeDefault))
			return false;
		if (manual == null) {
			if (other.manual != null)
				return false;
		} else if (!manual.equals(other.manual))
			return false;
		if (operation == null) {
			if (other.operation != null)
				return false;
		} else if (!operation.equals(other.operation))
			return false;
		if (operationDesc == null) {
			if (other.operationDesc != null)
				return false;
		} else if (!operationDesc.equals(other.operationDesc))
			return false;
		if (operationDescBref == null) {
			if (other.operationDescBref != null)
				return false;
		} else if (!operationDescBref.equals(other.operationDescBref))
			return false;
		if (operationType == null) {
			if (other.operationType != null)
				return false;
		} else if (!operationType.equals(other.operationType))
			return false;
		if (printBundleTicket == null) {
			if (other.printBundleTicket != null)
				return false;
		} else if (!printBundleTicket.equals(other.printBundleTicket))
			return false;
		if (process == null) {
			if (other.process != null)
				return false;
		} else if (!process.equals(other.process))
			return false;
		if (revision1 == null) {
			if (other.revision1 != null)
				return false;
		} else if (!revision1.equals(other.revision1))
			return false;
		if (revision2 == null) {
			if (other.revision2 != null)
				return false;
		} else if (!revision2.equals(other.revision2))
			return false;
		if (revision3 == null) {
			if (other.revision3 != null)
				return false;
		} else if (!revision3.equals(other.revision3))
			return false;
		if (revision4 == null) {
			if (other.revision4 != null)
				return false;
		} else if (!revision4.equals(other.revision4))
			return false;
		if (revision5 == null) {
			if (other.revision5 != null)
				return false;
		} else if (!revision5.equals(other.revision5))
			return false;
		if (sequenceNo == null) {
			if (other.sequenceNo != null)
				return false;
		} else if (!sequenceNo.equals(other.sequenceNo))
			return false;
		if (sewingOperation == null) {
			if (other.sewingOperation != null)
				return false;
		} else if (!sewingOperation.equals(other.sewingOperation))
			return false;
		if (sizeWiseSmvMatrix == null) {
			if (other.sizeWiseSmvMatrix != null)
				return false;
		} else if (!sizeWiseSmvMatrix.equals(other.sizeWiseSmvMatrix))
			return false;
		if (wipPoints == null) {
			if (other.wipPoints != null)
				return false;
		} else if (!wipPoints.equals(other.wipPoints))
			return false;
		if (workAid == null) {
			if (other.workAid != null)
				return false;
		} else if (!workAid.equals(other.workAid))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((averageSmv == null) ? 0 : averageSmv.hashCode());
		result = prime * result + ((calc == null) ? 0 : calc.hashCode());
		result = prime * result
				+ ((defaultSmv == null) ? 0 : defaultSmv.hashCode());
		result = prime * result + ((grade == null) ? 0 : grade.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime
				* result
				+ ((machineTypeDefault == null) ? 0 : machineTypeDefault
						.hashCode());
		result = prime * result + ((manual == null) ? 0 : manual.hashCode());
		result = prime * result
				+ ((operation == null) ? 0 : operation.hashCode());
		result = prime * result
				+ ((operationDesc == null) ? 0 : operationDesc.hashCode());
		result = prime
				* result
				+ ((operationDescBref == null) ? 0 : operationDescBref
						.hashCode());
		result = prime * result
				+ ((operationType == null) ? 0 : operationType.hashCode());
		result = prime
				* result
				+ ((printBundleTicket == null) ? 0 : printBundleTicket
						.hashCode());
		result = prime * result + ((process == null) ? 0 : process.hashCode());
		result = prime * result
				+ ((revision1 == null) ? 0 : revision1.hashCode());
		result = prime * result
				+ ((revision2 == null) ? 0 : revision2.hashCode());
		result = prime * result
				+ ((revision3 == null) ? 0 : revision3.hashCode());
		result = prime * result
				+ ((revision4 == null) ? 0 : revision4.hashCode());
		result = prime * result
				+ ((revision5 == null) ? 0 : revision5.hashCode());
		result = prime * result
				+ ((sequenceNo == null) ? 0 : sequenceNo.hashCode());
		result = prime * result
				+ ((sewingOperation == null) ? 0 : sewingOperation.hashCode());
		result = prime
				* result
				+ ((sizeWiseSmvMatrix == null) ? 0 : sizeWiseSmvMatrix
						.hashCode());
		result = prime * result
				+ ((wipPoints == null) ? 0 : wipPoints.hashCode());
		result = prime * result + ((workAid == null) ? 0 : workAid.hashCode());
		return result;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Mststylerouteoperation [id=");
		builder.append(id);
		builder.append(", operationDesc=");
		builder.append(operationDesc);
		builder.append(", operationDescBref=");
		builder.append(operationDescBref);
		builder.append(", operationType=");
		builder.append(operationType);
		builder.append(", machineTypeDefault=");
		builder.append(machineTypeDefault);
		builder.append(", sewingOperation=");
		builder.append(sewingOperation);
		builder.append(", operation=");
		builder.append(operation);
		builder.append(", process=");
		builder.append(process);
		builder.append(", grade=");
		builder.append(grade);
		builder.append(", averageSmv=");
		builder.append(averageSmv);
		builder.append(", revision1=");
		builder.append(revision1);
		builder.append(", revision2=");
		builder.append(revision2);
		builder.append(", revision3=");
		builder.append(revision3);
		builder.append(", revision4=");
		builder.append(revision4);
		builder.append(", revision5=");
		builder.append(revision5);
		builder.append(", calc=");
		builder.append(calc);
		builder.append(", workAid=");
		builder.append(workAid);
		builder.append(", manual=");
		builder.append(manual);
		builder.append(", wipPoints=");
		builder.append(wipPoints);
		builder.append(", printBundleTicket=");
		builder.append(printBundleTicket);
		builder.append(", defaultSmv=");
		builder.append(defaultSmv);
		builder.append(", sizeWiseSmvMatrix=");
		builder.append(sizeWiseSmvMatrix);
		builder.append(", sequenceNo=");
		builder.append(sequenceNo);
		builder.append("]");
		return builder.toString();
	}

}
