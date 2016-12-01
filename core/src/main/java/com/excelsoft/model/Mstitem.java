package com.excelsoft.model;

import com.excelsoft.model.BaseObject;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;

@Entity
@Table(name="mstitem")
@XmlRootElement
public class Mstitem extends BaseObject implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -3454033292917537138L;
	private MstitemId id;
	private Mstitemtype mstitemtype;
    private String itemDesc;
    private String uom;
    private String designNo;
    private String userId;
    private Date createDate;
    private String itemGroup;
    private String type1Code;
    private String type2Code;
    private String type3Code;
    private String type4Code;
    private String type5Code;
    private String type6Code;
    private String glCodePurch;
    private String glCodeSales;
    private Character stockItem;
    private Long reOrdLevel;
    private String glCodeStock;
    private Long reorderLevel;
    private String buyerCode;
    private String styleId;
    private Long srlNo;
    private String createdBy;
    private Date createdOn;
    private String createdAt;
    private String modifiedBy;
    private Date modifiedOn;
    private String modifiedAt;
    private Character itemStatus;
    private Character isAssetIdCompulsory;
    private String curCode;
    private Long price;
    private Long wastagePercentage;
    private Integer navisionItemNumber;
    
    public Mstitem(MstitemId id) {
		super();
		this.id = id;
	}
    public Mstitem() {
		super();
	}
    
	@EmbeddedId @DocumentId    
    public MstitemId getId() {
        return this.id;
    }
    
    public void setId(MstitemId id) {
        this.id = id;
    }
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="item_type", referencedColumnName="item_type",nullable=true, insertable=false, updatable=false)
    @JsonIgnore
    public Mstitemtype getMstitemtype() {
		return mstitemtype;
	}
	public void setMstitemtype(Mstitemtype mstitemtype) {
		this.mstitemtype = mstitemtype;
	}
	@Column(name="item_desc", nullable=false, length=100 ,columnDefinition="CHAR(100)")
    @Field
    public String getItemDesc() {
        return this.itemDesc;
    }
    
    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }
    
    @Column(name="uom", nullable=false, length=6 ,columnDefinition="CHAR(6)")
    @Field
    public String getUom() {
        return this.uom;
    }
    
    public void setUom(String uom) {
        this.uom = uom;
    }
    
    @Column(name="design_no", nullable=false, length=20 ,columnDefinition="CHAR(20)")
    @Field
    public String getDesignNo() {
        return this.designNo;
    }
    
    public void setDesignNo(String designNo) {
        this.designNo = designNo;
    }
    
    @Column(name="user_id", nullable=false, length=10 ,columnDefinition="CHAR(10)")
    @Field
    public String getUserId() {
        return this.userId;
    }
    
    public void setUserId(String userId) {
        this.userId = userId;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="create_date", nullable=false, length=19 )
    @Field
    public Date getCreateDate() {
        return this.createDate;
    }
    
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    
    @Column(name="item_group", nullable=false, length=10 ,columnDefinition="CHAR(10)")
    @Field
    public String getItemGroup() {
        return this.itemGroup;
    }
    
    public void setItemGroup(String itemGroup) {
        this.itemGroup = itemGroup;
    }
    
    @Column(name="type_1_code", nullable=false, length=30 ,columnDefinition="CHAR(30)")
    @Field
    public String getType1Code() {
        return this.type1Code;
    }
    
    public void setType1Code(String type1Code) {
        this.type1Code = type1Code;
    }
    
    @Column(name="type_2_code", nullable=false, length=30 ,columnDefinition="CHAR(30)")
    @Field
    public String getType2Code() {
        return this.type2Code;
    }
    
    public void setType2Code(String type2Code) {
        this.type2Code = type2Code;
    }
    
    @Column(name="type_3_code", nullable=false, length=30 ,columnDefinition="CHAR(30)")
    @Field
    public String getType3Code() {
        return this.type3Code;
    }
    
    public void setType3Code(String type3Code) {
        this.type3Code = type3Code;
    }
    
    @Column(name="type_4_code", nullable=false, length=30 ,columnDefinition="CHAR(30)")
    @Field
    public String getType4Code() {
        return this.type4Code;
    }
    
    public void setType4Code(String type4Code) {
        this.type4Code = type4Code;
    }
    
    @Column(name="type_5_code", nullable=false, length=30 ,columnDefinition="CHAR(30)")
    @Field
    public String getType5Code() {
        return this.type5Code;
    }
    
    public void setType5Code(String type5Code) {
        this.type5Code = type5Code;
    }
    
    @Column(name="type_6_code", nullable=false, length=30 ,columnDefinition="CHAR(30)")
    @Field
    public String getType6Code() {
        return this.type6Code;
    }
    
    public void setType6Code(String type6Code) {
        this.type6Code = type6Code;
    }
    
    @Column(name="gl_code_purch", length=10 ,columnDefinition="CHAR(10)")
    @Field
    public String getGlCodePurch() {
        return this.glCodePurch;
    }
    
    public void setGlCodePurch(String glCodePurch) {
        this.glCodePurch = glCodePurch;
    }
    
    @Column(name="gl_code_sales", length=10 ,columnDefinition="CHAR(10)")
    @Field
    public String getGlCodeSales() {
        return this.glCodeSales;
    }
    
    public void setGlCodeSales(String glCodeSales) {
        this.glCodeSales = glCodeSales;
    }
    
    @Column(name="stock_item", length=1 ,columnDefinition="CHAR(1)")
    @Field
    public Character getStockItem() {
        return this.stockItem;
    }
    
    public void setStockItem(Character stockItem) {
        this.stockItem = stockItem;
    }
    
    @Column(name="re_ord_level", precision=20, scale=6 ,columnDefinition="DECIMAL(20)")
    @Field
    public Long getReOrdLevel() {
        return this.reOrdLevel;
    }
    
    public void setReOrdLevel(Long reOrdLevel) {
        this.reOrdLevel = reOrdLevel;
    }
    
    @Column(name="gl_code_stock", length=10 ,columnDefinition="CHAR(10)")
    @Field
    public String getGlCodeStock() {
        return this.glCodeStock;
    }
    
    public void setGlCodeStock(String glCodeStock) {
        this.glCodeStock = glCodeStock;
    }
    
    @Column(name="reorder_level", precision=20, scale=6 ,columnDefinition="DECIMAL(20)")
    @Field
    public Long getReorderLevel() {
        return this.reorderLevel;
    }
    
    public void setReorderLevel(Long reorderLevel) {
        this.reorderLevel = reorderLevel;
    }
    
    @Column(name="buyer_code", length=10 ,columnDefinition="CHAR(10)")
    @Field
    public String getBuyerCode() {
        return this.buyerCode;
    }
    
    public void setBuyerCode(String buyerCode) {
        this.buyerCode = buyerCode;
    }
    
    @Column(name="style_id", length=20 ,columnDefinition="CHAR(20)")
    @Field
    public String getStyleId() {
        return this.styleId;
    }
    
    public void setStyleId(String styleId) {
        this.styleId = styleId;
    }
    
    @Column(name="srl_no", precision=2, scale=0 ,columnDefinition="DECIMAL(2)")
    @Field
    public Long getSrlNo() {
        return this.srlNo;
    }
    
    public void setSrlNo(Long srlNo) {
        this.srlNo = srlNo;
    }
    
    @Column(name="created_by", length=10 ,columnDefinition="CHAR(10)")
    @Field
    public String getCreatedBy() {
        return this.createdBy;
    }
    
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created_on", length=19)
    @Field
    public Date getCreatedOn() {
        return this.createdOn;
    }
    
    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }
    
    @Column(name="created_at", length=10 ,columnDefinition="CHAR(10)")
    @Field
    public String getCreatedAt() {
        return this.createdAt;
    }
    
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
    
    @Column(name="modified_by", length=10 ,columnDefinition="CHAR(10)")
    @Field
    public String getModifiedBy() {
        return this.modifiedBy;
    }
    
    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="modified_on", length=19)
    @Field
    public Date getModifiedOn() {
        return this.modifiedOn;
    }
    
    public void setModifiedOn(Date modifiedOn) {
        this.modifiedOn = modifiedOn;
    }
    
    @Column(name="modified_at", length=10 ,columnDefinition="CHAR(10)")
    @Field
    public String getModifiedAt() {
        return this.modifiedAt;
    }
    
    public void setModifiedAt(String modifiedAt) {
        this.modifiedAt = modifiedAt;
    }
    
    @Column(name="item_status", length=1 ,columnDefinition="char(1)")
    @Field
    public Character getItemStatus() {
        return this.itemStatus;
    }
    
    public void setItemStatus(Character itemStatus) {
        this.itemStatus = itemStatus;
    }
    
    @Column(name="is_asset_id_compulsory", length=1 ,columnDefinition="char(1)")
    @Field
    public Character getIsAssetIdCompulsory() {
        return this.isAssetIdCompulsory;
    }
    
    public void setIsAssetIdCompulsory(Character isAssetIdCompulsory) {
        this.isAssetIdCompulsory = isAssetIdCompulsory;
    }
    
    @Column(name="cur_code", length=4 ,columnDefinition="char(4)")
    @Field
    public String getCurCode() {
        return this.curCode;
    }
    
    public void setCurCode(String curCode) {
        this.curCode = curCode;
    }
    
    @Column(name="price", precision=20, scale=6 ,columnDefinition="DECIMAL(20)")
    @Field
    public Long getPrice() {
        return this.price;
    }
    
    public void setPrice(Long price) {
        this.price = price;
    }
    
    @Column(name="wastage_percentage", precision=10, scale=6 ,columnDefinition="DECIMAL(10)")
    @Field
    public Long getWastagePercentage() {
        return this.wastagePercentage;
    }
    
    public void setWastagePercentage(Long wastagePercentage) {
        this.wastagePercentage = wastagePercentage;
    }
    
    @Column(name="navision_item_number", precision=5, scale=0 ,columnDefinition="DECIMAL(5)")
    @Field
    public Integer getNavisionItemNumber() {
        return this.navisionItemNumber;
    }
    
    public void setNavisionItemNumber(Integer navisionItemNumber) {
        this.navisionItemNumber = navisionItemNumber;
    }


    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mstitem pojo = (Mstitem) o;

        if (itemDesc != null ? !itemDesc.equals(pojo.itemDesc) : pojo.itemDesc != null) return false;
        if (uom != null ? !uom.equals(pojo.uom) : pojo.uom != null) return false;
        if (designNo != null ? !designNo.equals(pojo.designNo) : pojo.designNo != null) return false;
        if (userId != null ? !userId.equals(pojo.userId) : pojo.userId != null) return false;
        if (createDate != null ? !createDate.equals(pojo.createDate) : pojo.createDate != null) return false;
        if (itemGroup != null ? !itemGroup.equals(pojo.itemGroup) : pojo.itemGroup != null) return false;
        if (type1Code != null ? !type1Code.equals(pojo.type1Code) : pojo.type1Code != null) return false;
        if (type2Code != null ? !type2Code.equals(pojo.type2Code) : pojo.type2Code != null) return false;
        if (type3Code != null ? !type3Code.equals(pojo.type3Code) : pojo.type3Code != null) return false;
        if (type4Code != null ? !type4Code.equals(pojo.type4Code) : pojo.type4Code != null) return false;
        if (type5Code != null ? !type5Code.equals(pojo.type5Code) : pojo.type5Code != null) return false;
        if (type6Code != null ? !type6Code.equals(pojo.type6Code) : pojo.type6Code != null) return false;
        if (glCodePurch != null ? !glCodePurch.equals(pojo.glCodePurch) : pojo.glCodePurch != null) return false;
        if (glCodeSales != null ? !glCodeSales.equals(pojo.glCodeSales) : pojo.glCodeSales != null) return false;
        if (stockItem != null ? !stockItem.equals(pojo.stockItem) : pojo.stockItem != null) return false;
        if (reOrdLevel != null ? !reOrdLevel.equals(pojo.reOrdLevel) : pojo.reOrdLevel != null) return false;
        if (glCodeStock != null ? !glCodeStock.equals(pojo.glCodeStock) : pojo.glCodeStock != null) return false;
        if (reorderLevel != null ? !reorderLevel.equals(pojo.reorderLevel) : pojo.reorderLevel != null) return false;
        if (buyerCode != null ? !buyerCode.equals(pojo.buyerCode) : pojo.buyerCode != null) return false;
        if (styleId != null ? !styleId.equals(pojo.styleId) : pojo.styleId != null) return false;
        if (srlNo != null ? !srlNo.equals(pojo.srlNo) : pojo.srlNo != null) return false;
        if (createdBy != null ? !createdBy.equals(pojo.createdBy) : pojo.createdBy != null) return false;
        if (createdOn != null ? !createdOn.equals(pojo.createdOn) : pojo.createdOn != null) return false;
        if (createdAt != null ? !createdAt.equals(pojo.createdAt) : pojo.createdAt != null) return false;
        if (modifiedBy != null ? !modifiedBy.equals(pojo.modifiedBy) : pojo.modifiedBy != null) return false;
        if (modifiedOn != null ? !modifiedOn.equals(pojo.modifiedOn) : pojo.modifiedOn != null) return false;
        if (modifiedAt != null ? !modifiedAt.equals(pojo.modifiedAt) : pojo.modifiedAt != null) return false;
        if (itemStatus != null ? !itemStatus.equals(pojo.itemStatus) : pojo.itemStatus != null) return false;
        if (isAssetIdCompulsory != null ? !isAssetIdCompulsory.equals(pojo.isAssetIdCompulsory) : pojo.isAssetIdCompulsory != null) return false;
        if (curCode != null ? !curCode.equals(pojo.curCode) : pojo.curCode != null) return false;
        if (price != null ? !price.equals(pojo.price) : pojo.price != null) return false;
        if (wastagePercentage != null ? !wastagePercentage.equals(pojo.wastagePercentage) : pojo.wastagePercentage != null) return false;
        if (navisionItemNumber != null ? !navisionItemNumber.equals(pojo.navisionItemNumber) : pojo.navisionItemNumber != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (itemDesc != null ? itemDesc.hashCode() : 0);
        result = 31 * result + (uom != null ? uom.hashCode() : 0);
        result = 31 * result + (designNo != null ? designNo.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (itemGroup != null ? itemGroup.hashCode() : 0);
        result = 31 * result + (type1Code != null ? type1Code.hashCode() : 0);
        result = 31 * result + (type2Code != null ? type2Code.hashCode() : 0);
        result = 31 * result + (type3Code != null ? type3Code.hashCode() : 0);
        result = 31 * result + (type4Code != null ? type4Code.hashCode() : 0);
        result = 31 * result + (type5Code != null ? type5Code.hashCode() : 0);
        result = 31 * result + (type6Code != null ? type6Code.hashCode() : 0);
        result = 31 * result + (glCodePurch != null ? glCodePurch.hashCode() : 0);
        result = 31 * result + (glCodeSales != null ? glCodeSales.hashCode() : 0);
        result = 31 * result + (stockItem != null ? stockItem.hashCode() : 0);
        result = 31 * result + (reOrdLevel != null ? reOrdLevel.hashCode() : 0);
        result = 31 * result + (glCodeStock != null ? glCodeStock.hashCode() : 0);
        result = 31 * result + (reorderLevel != null ? reorderLevel.hashCode() : 0);
        result = 31 * result + (buyerCode != null ? buyerCode.hashCode() : 0);
        result = 31 * result + (styleId != null ? styleId.hashCode() : 0);
        result = 31 * result + (srlNo != null ? srlNo.hashCode() : 0);
        result = 31 * result + (createdBy != null ? createdBy.hashCode() : 0);
        result = 31 * result + (createdOn != null ? createdOn.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (modifiedBy != null ? modifiedBy.hashCode() : 0);
        result = 31 * result + (modifiedOn != null ? modifiedOn.hashCode() : 0);
        result = 31 * result + (modifiedAt != null ? modifiedAt.hashCode() : 0);
        result = 31 * result + (itemStatus != null ? itemStatus.hashCode() : 0);
        result = 31 * result + (isAssetIdCompulsory != null ? isAssetIdCompulsory.hashCode() : 0);
        result = 31 * result + (curCode != null ? curCode.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (wastagePercentage != null ? wastagePercentage.hashCode() : 0);
        result = 31 * result + (navisionItemNumber != null ? navisionItemNumber.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("id").append("='").append(getId()).append("', ");
        sb.append("itemDesc").append("='").append(getItemDesc()).append("', ");
        sb.append("uom").append("='").append(getUom()).append("', ");
        sb.append("designNo").append("='").append(getDesignNo()).append("', ");
        sb.append("userId").append("='").append(getUserId()).append("', ");
        sb.append("createDate").append("='").append(getCreateDate()).append("', ");
        sb.append("itemGroup").append("='").append(getItemGroup()).append("', ");
        sb.append("type1Code").append("='").append(getType1Code()).append("', ");
        sb.append("type2Code").append("='").append(getType2Code()).append("', ");
        sb.append("type3Code").append("='").append(getType3Code()).append("', ");
        sb.append("type4Code").append("='").append(getType4Code()).append("', ");
        sb.append("type5Code").append("='").append(getType5Code()).append("', ");
        sb.append("type6Code").append("='").append(getType6Code()).append("', ");
        sb.append("glCodePurch").append("='").append(getGlCodePurch()).append("', ");
        sb.append("glCodeSales").append("='").append(getGlCodeSales()).append("', ");
        sb.append("stockItem").append("='").append(getStockItem()).append("', ");
        sb.append("reOrdLevel").append("='").append(getReOrdLevel()).append("', ");
        sb.append("glCodeStock").append("='").append(getGlCodeStock()).append("', ");
        sb.append("reorderLevel").append("='").append(getReorderLevel()).append("', ");
        sb.append("buyerCode").append("='").append(getBuyerCode()).append("', ");
        sb.append("styleId").append("='").append(getStyleId()).append("', ");
        sb.append("srlNo").append("='").append(getSrlNo()).append("', ");
        sb.append("createdBy").append("='").append(getCreatedBy()).append("', ");
        sb.append("createdOn").append("='").append(getCreatedOn()).append("', ");
        sb.append("createdAt").append("='").append(getCreatedAt()).append("', ");
        sb.append("modifiedBy").append("='").append(getModifiedBy()).append("', ");
        sb.append("modifiedOn").append("='").append(getModifiedOn()).append("', ");
        sb.append("modifiedAt").append("='").append(getModifiedAt()).append("', ");
        sb.append("itemStatus").append("='").append(getItemStatus()).append("', ");
        sb.append("isAssetIdCompulsory").append("='").append(getIsAssetIdCompulsory()).append("', ");
        sb.append("curCode").append("='").append(getCurCode()).append("', ");
        sb.append("price").append("='").append(getPrice()).append("', ");
        sb.append("wastagePercentage").append("='").append(getWastagePercentage()).append("', ");
        sb.append("navisionItemNumber").append("='").append(getNavisionItemNumber()).append("', ");
        
        sb.append("]");
      
        return sb.toString();
    }

}
