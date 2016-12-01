package com.excelsoft.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

@Entity
@Table(name="mstoperation")
@Indexed
@XmlRootElement
public class Mstoperation extends BaseObject implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -3963326586270448735L;
	private Integer operationNo;
    private String locationCode;
    private String operationDesc;
    private String operationDescBref;
    private String operationType;
    private String machineTypeDefault;
    private Character sewingOperation;
    

    @Id  @DocumentId 
    @Column(name="operation_no")
    public Integer getOperationNo() {
        return this.operationNo;
    }
    
    public void setOperationNo(Integer operationNo) {
        this.operationNo = operationNo;
    }
    
    @Column(name="location_code", length=6 ,columnDefinition="CHAR(6)")
    @Field
    public String getLocationCode() {
        return this.locationCode;
    }
    
    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }
    
    @Column(name="operation_desc", length=50 ,columnDefinition="CHAR(50)")
    @Field
    public String getOperationDesc() {
        return this.operationDesc;
    }
    
    public void setOperationDesc(String operationDesc) {
        this.operationDesc = operationDesc;
    }
    
    @Column(name="operation_desc_bref", length=20 ,columnDefinition="CHAR(20)")
    @Field
    public String getOperationDescBref() {
        return this.operationDescBref;
    }
    
    public void setOperationDescBref(String operationDescBref) {
        this.operationDescBref = operationDescBref;
    }
    
    @Column(name="operation_type", length=10)
    @Field
    public String getOperationType() {
        return this.operationType;
    }
    
    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }
    
    @Column(name="machine_type_default", length=6 ,columnDefinition="CHAR(6)")
    @Field
    public String getMachineTypeDefault() {
        return this.machineTypeDefault;
    }
    
    public void setMachineTypeDefault(String machineTypeDefault) {
        this.machineTypeDefault = machineTypeDefault;
    }
    
    @Column(name="sewing_operation", length=1)
    @Field
    public Character getSewingOperation() {
        return this.sewingOperation;
    }
    
    public void setSewingOperation(Character sewingOperation) {
        this.sewingOperation = sewingOperation;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mstoperation pojo = (Mstoperation) o;

        if (locationCode != null ? !locationCode.equals(pojo.locationCode) : pojo.locationCode != null) return false;
        if (operationDesc != null ? !operationDesc.equals(pojo.operationDesc) : pojo.operationDesc != null) return false;
        if (operationDescBref != null ? !operationDescBref.equals(pojo.operationDescBref) : pojo.operationDescBref != null) return false;
        if (operationType != null ? !operationType.equals(pojo.operationType) : pojo.operationType != null) return false;
        if (machineTypeDefault != null ? !machineTypeDefault.equals(pojo.machineTypeDefault) : pojo.machineTypeDefault != null) return false;
        if (sewingOperation != null ? !sewingOperation.equals(pojo.sewingOperation) : pojo.sewingOperation != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (locationCode != null ? locationCode.hashCode() : 0);
        result = 31 * result + (operationDesc != null ? operationDesc.hashCode() : 0);
        result = 31 * result + (operationDescBref != null ? operationDescBref.hashCode() : 0);
        result = 31 * result + (operationType != null ? operationType.hashCode() : 0);
        result = 31 * result + (machineTypeDefault != null ? machineTypeDefault.hashCode() : 0);
        result = 31 * result + (sewingOperation != null ? sewingOperation.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("operationNo").append("='").append(getOperationNo()).append("', ");
        sb.append("locationCode").append("='").append(getLocationCode()).append("', ");
        sb.append("operationDesc").append("='").append(getOperationDesc()).append("', ");
        sb.append("operationDescBref").append("='").append(getOperationDescBref()).append("', ");
        sb.append("operationType").append("='").append(getOperationType()).append("', ");
        sb.append("machineTypeDefault").append("='").append(getMachineTypeDefault()).append("', ");
        sb.append("sewingOperation").append("='").append(getSewingOperation()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

}
