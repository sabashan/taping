package com.excelsoft.model;



import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;

@Entity
@Table(name="mststyleheader")
@XmlRootElement
public class Mststyleheader extends AuditFields implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -2627399922993038667L;
	private MststyleheaderId id;
    private Mstcustomer mstcustomer;
    private Mstlocation mstlocation;
    private Mstcompany mstcompany;
    private String productRange;
    private String flag;
    private String packingMethod;
    private String userId;
    private String styleDescription;
    private String costSheetMethod;
    private String designReference;
    private String svmType;
    private String comments;
    private String mststylepicture;
    
    
    

	public Mststyleheader(MststyleheaderId id) {
		super();
		this.id = id;
	}

	public Mststyleheader() {
		super();
	}

	@EmbeddedId @DocumentId    
    public MststyleheaderId getId() {
        return this.id;
    }
    
    public void setId(MststyleheaderId id) {
        this.id = id;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="cust_code", nullable=false, insertable=false, updatable=false)
	@Fetch(FetchMode.SELECT)
@JsonIgnore
    public Mstcustomer getMstcustomer() {
        return this.mstcustomer;
    }
    
    public void setMstcustomer(Mstcustomer mstcustomer) {
        this.mstcustomer = mstcustomer;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="location_code", nullable=false, insertable=false, updatable=false)
	@Fetch(FetchMode.SELECT)
@JsonIgnore
    public Mstlocation getMstlocation() {
        return this.mstlocation;
    }
    
    public void setMstlocation(Mstlocation mstlocation) {
        this.mstlocation = mstlocation;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="comp_code", nullable=false, insertable=false, updatable=false)
	@Fetch(FetchMode.SELECT)
@JsonIgnore
    public Mstcompany getMstcompany() {
        return this.mstcompany;
    }
    
    public void setMstcompany(Mstcompany mstcompany) {
        this.mstcompany = mstcompany;
    }
  
    @Column(name="product_range", nullable=false, length=6 ,columnDefinition="CHAR(10)")
    @Field
    public String getProductRange() {
        return this.productRange;
    }
    
    public void setProductRange(String productRange) {
        this.productRange = productRange;
    }
    
    @Column(name="flag", nullable=false, length=12 ,columnDefinition="CHAR(12)")
    @Field
    public String getFlag() {
        return this.flag;
    }
    
    public void setFlag(String flag) {
        this.flag = flag;
    }
    
    @Column(name="packing_method", length=6 ,columnDefinition="CHAR(10)")
    @Field
    public String getPackingMethod() {
        return this.packingMethod;
    }
    
    public void setPackingMethod(String packingMethod) {
        this.packingMethod = packingMethod;
    }
    
    @Column(name="user_id", nullable=false, length=50 ,columnDefinition="CHAR(50)")
    @Field
    public String getUserId() {
        return this.userId;
    }
    
    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    @Column(name="style_description", length=45 ,columnDefinition="CHAR(45)")
    @Field
    public String getStyleDescription() {
        return this.styleDescription;
    }
    
    public void setStyleDescription(String styleDescription) {
        this.styleDescription = styleDescription;
    }
    
    @Column(name="cost_sheet_method", length=10 ,columnDefinition="CHAR(10)")
    @Field
    public String getCostSheetMethod() {
        return this.costSheetMethod;
    }
    
    public void setCostSheetMethod(String costSheetMethod) {
        this.costSheetMethod = costSheetMethod;
    }
    
    @Column(name="design_reference", length=10 ,columnDefinition="CHAR(10)")
    @Field
    public String getDesignReference() {
        return this.designReference;
    }
    
    public void setDesignReference(String designReference) {
        this.designReference = designReference;
    }
    
    @Column(name="svm_type", length=10 ,columnDefinition="CHAR(10)")
    @Field
    public String getSvmType() {
        return this.svmType;
    }
    
    public void setSvmType(String svmType) {
        this.svmType = svmType;
    }
    
    @Column(name="comments" )
    @Field
    public String getComments() {
        return this.comments;
    }
    
    public void setComments(String comments) {
        this.comments = comments;
    }
	
	 @Transient
	public String getMststylepicture() {
		return mststylepicture;
	}
	 @Transient
	public void setMststylepicture(String mststylepicture) {
		this.mststylepicture = mststylepicture;
	}

	 @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mststyleheader other = (Mststyleheader) obj;
		if (comments == null) {
			if (other.comments != null)
				return false;
		} else if (!comments.equals(other.comments))
			return false;
		if (costSheetMethod == null) {
			if (other.costSheetMethod != null)
				return false;
		} else if (!costSheetMethod.equals(other.costSheetMethod))
			return false;
		if (designReference == null) {
			if (other.designReference != null)
				return false;
		} else if (!designReference.equals(other.designReference))
			return false;
		if (flag == null) {
			if (other.flag != null)
				return false;
		} else if (!flag.equals(other.flag))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (packingMethod == null) {
			if (other.packingMethod != null)
				return false;
		} else if (!packingMethod.equals(other.packingMethod))
			return false;
		if (productRange == null) {
			if (other.productRange != null)
				return false;
		} else if (!productRange.equals(other.productRange))
			return false;
		if (styleDescription == null) {
			if (other.styleDescription != null)
				return false;
		} else if (!styleDescription.equals(other.styleDescription))
			return false;
		if (svmType == null) {
			if (other.svmType != null)
				return false;
		} else if (!svmType.equals(other.svmType))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	    @Override
		public int hashCode() {
			final int prime = 31;
			int result = super.hashCode();
			result = prime * result
					+ ((comments == null) ? 0 : comments.hashCode());
			result = prime
					* result
					+ ((costSheetMethod == null) ? 0 : costSheetMethod
							.hashCode());
			result = prime
					* result
					+ ((designReference == null) ? 0 : designReference
							.hashCode());
			result = prime * result + ((flag == null) ? 0 : flag.hashCode());
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			result = prime * result
					+ ((packingMethod == null) ? 0 : packingMethod.hashCode());
			result = prime * result
					+ ((productRange == null) ? 0 : productRange.hashCode());
			result = prime
					* result
					+ ((styleDescription == null) ? 0 : styleDescription
							.hashCode());
			result = prime * result
					+ ((svmType == null) ? 0 : svmType.hashCode());
			result = prime * result
					+ ((userId == null) ? 0 : userId.hashCode());
			return result;
		}

	    @Override
		public String toString() {
			return "Mststyleheader [id=" + id + ", productRange="
					+ productRange + ", flag=" + flag + ", packingMethod="
					+ packingMethod + ", userId=" + userId
					+ ", styleDescription=" + styleDescription
					+ ", costSheetMethod=" + costSheetMethod
					+ ", designReference=" + designReference + ", svmType="
					+ svmType + ", comments=" + comments + ", mststylepicture="
					+ mststylepicture + "]";
		}


	

}
