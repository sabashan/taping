package com.excelsoft.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.search.annotations.Field;

@Embeddable
@XmlRootElement
public class MercostsheetunapprovedlogedId extends BaseObject implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 2311366846829031745L;
	private Long logedId;
    private String costSheetNo;
    private Long versionNo;
    private String costSheetType;

    public MercostsheetunapprovedlogedId() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MercostsheetunapprovedlogedId(Long logedId, String costSheetNo,
			Long versionNo, String costSheetType) {
		super();
		this.logedId = logedId;
		this.costSheetNo = costSheetNo;
		this.versionNo = versionNo;
		this.costSheetType = costSheetType;
	}

	@Column(name="loged_id", nullable=false)
    @Field
    public Long getLogedId() {
        return this.logedId;
    }
    
    public void setLogedId(Long logedId) {
        this.logedId = logedId;
    }

    @Column(name="cost_sheet_no", nullable=false, length=15, columnDefinition="CHAR(15)")
    @Field
    public String getCostSheetNo() {
        return this.costSheetNo;
    }
    
    public void setCostSheetNo(String costSheetNo) {
        this.costSheetNo = costSheetNo;
    }

    @Column(name="version_no", nullable=false, precision=10, scale=0, columnDefinition="DECIMAL(10,0)")
    @Field
    public Long getVersionNo() {
        return this.versionNo;
    }
    
    public void setVersionNo(Long versionNo) {
        this.versionNo = versionNo;
    }

    @Column(name="cost_sheet_type", nullable=false, length=10, columnDefinition="CHAR(10)")
    @Field
    public String getCostSheetType() {
        return this.costSheetType;
    }
    
    public void setCostSheetType(String costSheetType) {
        this.costSheetType = costSheetType;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MercostsheetunapprovedlogedId pojo = (MercostsheetunapprovedlogedId) o;

        if (logedId != null ? !logedId.equals(pojo.logedId) : pojo.logedId != null) return false;
        if (costSheetNo != null ? !costSheetNo.equals(pojo.costSheetNo) : pojo.costSheetNo != null) return false;
        if (versionNo != null ? !versionNo.equals(pojo.versionNo) : pojo.versionNo != null) return false;
        if (costSheetType != null ? !costSheetType.equals(pojo.costSheetType) : pojo.costSheetType != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = 31 * result + (logedId != null ? logedId.hashCode() : 0);
        result = (costSheetNo != null ? costSheetNo.hashCode() : 0);
        result = 31 * result + (versionNo != null ? versionNo.hashCode() : 0);
        result = 31 * result + (costSheetType != null ? costSheetType.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("logedId").append("='").append(getLogedId()).append("', ");
        sb.append("costSheetNo").append("='").append(getCostSheetNo()).append("', ");
        sb.append("versionNo").append("='").append(getVersionNo()).append("', ");
        sb.append("costSheetType").append("='").append(getCostSheetType()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

}
