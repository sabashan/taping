package com.excelsoft.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

@Entity
@Table(name = "mstitemtype")
@Indexed
@XmlRootElement
public class Mstitemtype extends AuditFields implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String itemType;
	private String itemGroup;
	private String type1Name;
	private String type2Name;
	private String type3Name;
	private String type4Name;
	private String type5Name;
	private String type6Name;
	private BigDecimal codeLength;
	private Character sizewiseIndent;
	private Character consPerPiece;
	private BigDecimal sortOrder;
	private Character stockItem;
	private String category ;
	private Character requiredBoc;
	private BigDecimal itlPercentage;
	private BigDecimal itlExcessPercentage;
	private Character isService;
	private BigDecimal type1CodeLen;
	private BigDecimal type2CodeLen;
	private BigDecimal type3CodeLen;
	private BigDecimal type4CodeLen;
	private BigDecimal type5CodeLen;
	private BigDecimal type6CodeLen;
	private Character colorWisePricelist;
	private Character sizeWisePricelist;
	private Character requiredStockRequisition;
	private Character showInPreshipment;
	private Character importLocal;
	private Character relatedGsp;
	private String accCode;
	private Boolean fabricTrim;
	private Boolean fabricTrimOth;
	private BigDecimal excessGrnPercentage;
	private Character bulkOrder;
	private Character maintainWidthSize;
	private Character requiredProgram;
	private String navisionTaskcode;
	private String itemTypeDesc;

	

	public Mstitemtype() {
		super();
	}

	public Mstitemtype(String itemType) {
		super();
		this.itemType = itemType;
	}

	public Mstitemtype(String itemType, String itemGroup, String type1Name,
			String type2Name, String type3Name, String type4Name,
			String type5Name, String type6Name, BigDecimal codeLength,
			Character sizewiseIndent, Character consPerPiece,
			BigDecimal sortOrder, Character stockItem, String category,
			Character requiredBoc, BigDecimal itlPercentage,
			BigDecimal itlExcessPercentage, Character isService,
			BigDecimal type1CodeLen, BigDecimal type2CodeLen,
			BigDecimal type3CodeLen, BigDecimal type4CodeLen,
			BigDecimal type5CodeLen, BigDecimal type6CodeLen,
			Character colorWisePricelist, Character sizeWisePricelist,
			Character requiredStockRequisition, Character showInPreshipment,
			Character importLocal, Character relatedGsp, String accCode,
			Boolean fabricTrim, Boolean fabricTrimOth,
			BigDecimal excessGrnPercentage, Character bulkOrder,
			Character maintainWidthSize, Character requiredProgram,
			String navisionTaskcode, String itemTypeDesc) {
		super();
		this.itemType = itemType;
		this.itemGroup = itemGroup;
		this.type1Name = type1Name;
		this.type2Name = type2Name;
		this.type3Name = type3Name;
		this.type4Name = type4Name;
		this.type5Name = type5Name;
		this.type6Name = type6Name;
		this.codeLength = codeLength;
		this.sizewiseIndent = sizewiseIndent;
		this.consPerPiece = consPerPiece;
		this.sortOrder = sortOrder;
		this.stockItem = stockItem;
		this.category = category;
		this.requiredBoc = requiredBoc;
		this.itlPercentage = itlPercentage;
		this.itlExcessPercentage = itlExcessPercentage;
		this.isService = isService;
		this.type1CodeLen = type1CodeLen;
		this.type2CodeLen = type2CodeLen;
		this.type3CodeLen = type3CodeLen;
		this.type4CodeLen = type4CodeLen;
		this.type5CodeLen = type5CodeLen;
		this.type6CodeLen = type6CodeLen;
		this.colorWisePricelist = colorWisePricelist;
		this.sizeWisePricelist = sizeWisePricelist;
		this.requiredStockRequisition = requiredStockRequisition;
		this.showInPreshipment = showInPreshipment;
		this.importLocal = importLocal;
		this.relatedGsp = relatedGsp;
		this.accCode = accCode;
		this.fabricTrim = fabricTrim;
		this.fabricTrimOth = fabricTrimOth;
		this.excessGrnPercentage = excessGrnPercentage;
		this.bulkOrder = bulkOrder;
		this.maintainWidthSize = maintainWidthSize;
		this.requiredProgram = requiredProgram;
		this.navisionTaskcode = navisionTaskcode;
		this.itemTypeDesc = itemTypeDesc;
	}

	@Id
	@DocumentId
	@Column(name = "item_type", nullable = false, length = 10, columnDefinition = "CHAR(10)")
	public String getItemType() {
		return this.itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	@Column(name = "item_group", nullable = false, length = 10, columnDefinition = "CHAR(10)")
	@Field
	public String getItemGroup() {
		return this.itemGroup;
	}

	public void setItemGroup(String itemGroup) {
		this.itemGroup = itemGroup;
	}

	@Column(name = "category", nullable = false, length = 10, columnDefinition = "CHAR(10)")
	@Field
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Column(name = "type_1_name", nullable = false, length = 20, columnDefinition = "CHAR(20)")
	@Field
	public String getType1Name() {
		return this.type1Name;
	}

	public void setType1Name(String type1Name) {
		this.type1Name = type1Name;
	}

	@Column(name = "type_2_name", nullable = false, length = 20, columnDefinition = "CHAR(20)")
	@Field
	public String getType2Name() {
		return this.type2Name;
	}

	public void setType2Name(String type2Name) {
		this.type2Name = type2Name;
	}

	@Column(name = "type_3_name", nullable = false, length = 20, columnDefinition = "CHAR(20)")
	@Field
	public String getType3Name() {
		return this.type3Name;
	}

	public void setType3Name(String type3Name) {
		this.type3Name = type3Name;
	}

	@Column(name = "type_4_name", nullable = false, length = 20, columnDefinition = "CHAR(20)")
	@Field
	public String getType4Name() {
		return this.type4Name;
	}

	public void setType4Name(String type4Name) {
		this.type4Name = type4Name;
	}

	@Column(name = "type_5_name", nullable = false, length = 20, columnDefinition = "CHAR(20)")
	@Field
	public String getType5Name() {
		return this.type5Name;
	}

	public void setType5Name(String type5Name) {
		this.type5Name = type5Name;
	}

	@Column(name = "type_6_name", nullable = false, length = 20, columnDefinition = "CHAR(20)")
	@Field
	public String getType6Name() {
		return this.type6Name;
	}

	public void setType6Name(String type6Name) {
		this.type6Name = type6Name;
	}

	@Column(name = "code_length", nullable = false, precision = 2, scale = 0, columnDefinition = "DECIMAL(2,0)")
	@Field
	public BigDecimal getCodeLength() {
		return this.codeLength;
	}

	public void setCodeLength(BigDecimal codeLength) {
		this.codeLength = codeLength;
	}

	@Column(name = "sizewise_indent", length = 1, columnDefinition = "CHAR(1)")
	@Field
	public Character getSizewiseIndent() {
		return this.sizewiseIndent;
	}

	public void setSizewiseIndent(Character sizewiseIndent) {
		this.sizewiseIndent = sizewiseIndent;
	}

	@Column(name = "cons_per_piece", length = 1, columnDefinition = "CHAR(1)")
	@Field
	public Character getConsPerPiece() {
		return this.consPerPiece;
	}

	public void setConsPerPiece(Character consPerPiece) {
		this.consPerPiece = consPerPiece;
	}

	@Column(name = "sort_order", precision = 5)
	@Field
	public BigDecimal getSortOrder() {
		return this.sortOrder;
	}

	public void setSortOrder(BigDecimal sortOrder) {
		this.sortOrder = sortOrder;
	}

	@Column(name = "stock_item", length = 1, columnDefinition = "CHAR(1)")
	@Field
	public Character getStockItem() {
		return this.stockItem;
	}

	public void setStockItem(Character stockItem) {
		this.stockItem = stockItem;
	}

	
	@Column(name = "required_boc", length = 1, columnDefinition = "CHAR(1)")
	@Field
	public Character getRequiredBoc() {
		return this.requiredBoc;
	}

	public void setRequiredBoc(Character requiredBoc) {
		this.requiredBoc = requiredBoc;
	}

	@Column(name = "itl_percentage", precision = 20, scale = 6)
	@Field
	public BigDecimal getItlPercentage() {
		return this.itlPercentage;
	}

	public void setItlPercentage(BigDecimal itlPercentage) {
		this.itlPercentage = itlPercentage;
	}

	@Column(name = "itl_excess_percentage", precision = 20, scale = 6)
	@Field
	public BigDecimal getItlExcessPercentage() {
		return this.itlExcessPercentage;
	}

	public void setItlExcessPercentage(BigDecimal itlExcessPercentage) {
		this.itlExcessPercentage = itlExcessPercentage;
	}

	@Column(name = "is_service", length = 1, columnDefinition = "CHAR(1)")
	@Field
	public Character getIsService() {
		return this.isService;
	}

	public void setIsService(Character isService) {
		this.isService = isService;
	}

	@Column(name = "type_1_code_len", precision = 2, scale = 0, columnDefinition = "DECIMAL(2,0)")
	@Field
	public BigDecimal getType1CodeLen() {
		return this.type1CodeLen;
	}

	public void setType1CodeLen(BigDecimal type1CodeLen) {
		this.type1CodeLen = type1CodeLen;
	}

	@Column(name = "type_2_code_len", precision = 2, scale = 0, columnDefinition = "DECIMAL(2,0)")
	@Field
	public BigDecimal getType2CodeLen() {
		return this.type2CodeLen;
	}

	public void setType2CodeLen(BigDecimal type2CodeLen) {
		this.type2CodeLen = type2CodeLen;
	}

	@Column(name = "type_3_code_len", precision = 2, scale = 0, columnDefinition = "DECIMAL(2,0)")
	@Field
	public BigDecimal getType3CodeLen() {
		return this.type3CodeLen;
	}

	public void setType3CodeLen(BigDecimal type3CodeLen) {
		this.type3CodeLen = type3CodeLen;
	}

	@Column(name = "type_4_code_len", precision = 2, scale = 0, columnDefinition = "DECIMAL(2,0)")
	@Field
	public BigDecimal getType4CodeLen() {
		return this.type4CodeLen;
	}

	public void setType4CodeLen(BigDecimal type4CodeLen) {
		this.type4CodeLen = type4CodeLen;
	}

	@Column(name = "type_5_code_len", precision = 2, scale = 0, columnDefinition = "DECIMAL(2,0)")
	@Field
	public BigDecimal getType5CodeLen() {
		return this.type5CodeLen;
	}

	public void setType5CodeLen(BigDecimal type5CodeLen) {
		this.type5CodeLen = type5CodeLen;
	}

	@Column(name = "type_6_code_len", precision = 2, scale = 0, columnDefinition = "DECIMAL(2,0)")
	@Field
	public BigDecimal getType6CodeLen() {
		return this.type6CodeLen;
	}

	public void setType6CodeLen(BigDecimal type6CodeLen) {
		this.type6CodeLen = type6CodeLen;
	}

	@Column(name = "color_wise_pricelist", length = 1, columnDefinition = "CHAR(1)")
	@Field
	public Character getColorWisePricelist() {
		return this.colorWisePricelist;
	}

	public void setColorWisePricelist(Character colorWisePricelist) {
		this.colorWisePricelist = colorWisePricelist;
	}

	@Column(name = "size_wise_pricelist", length = 1, columnDefinition = "CHAR(1)")
	@Field
	public Character getSizeWisePricelist() {
		return this.sizeWisePricelist;
	}

	public void setSizeWisePricelist(Character sizeWisePricelist) {
		this.sizeWisePricelist = sizeWisePricelist;
	}

	@Column(name = "required_stock_requisition", length = 1, columnDefinition = "CHAR(1)")
	@Field
	public Character getRequiredStockRequisition() {
		return this.requiredStockRequisition;
	}

	public void setRequiredStockRequisition(Character requiredStockRequisition) {
		this.requiredStockRequisition = requiredStockRequisition;
	}

	@Column(name = "show_in_preshipment", length = 1, columnDefinition = "CHAR(1)")
	@Field
	public Character getShowInPreshipment() {
		return this.showInPreshipment;
	}

	public void setShowInPreshipment(Character showInPreshipment) {
		this.showInPreshipment = showInPreshipment;
	}

	@Column(name = "import_local", length = 1, columnDefinition = "CHAR(1)")
	@Field
	public Character getImportLocal() {
		return this.importLocal;
	}

	public void setImportLocal(Character importLocal) {
		this.importLocal = importLocal;
	}

	@Column(name = "related_gsp", length = 1, columnDefinition = "CHAR(1)")
	@Field
	public Character getRelatedGsp() {
		return this.relatedGsp;
	}

	public void setRelatedGsp(Character relatedGsp) {
		this.relatedGsp = relatedGsp;
	}

	@Column(name = "acc_code", length = 10, columnDefinition = "CHAR(10)")
	@Field
	public String getAccCode() {
		return this.accCode;
	}

	public void setAccCode(String accCode) {
		this.accCode = accCode;
	}

	@Column(name = "fabric_trim", precision = 1, scale = 0)
	@Field
	public Boolean getFabricTrim() {
		return this.fabricTrim;
	}

	public void setFabricTrim(Boolean fabricTrim) {
		this.fabricTrim = fabricTrim;
	}

	@Column(name = "fabric_trim_oth", precision = 1, scale = 0)
	@Field
	public Boolean getFabricTrimOth() {
		return this.fabricTrimOth;
	}

	public void setFabricTrimOth(Boolean fabricTrimOth) {
		this.fabricTrimOth = fabricTrimOth;
	}

	@Column(name = "excess_grn_percentage", precision = 20, scale = 6)
	@Field
	public BigDecimal getExcessGrnPercentage() {
		return this.excessGrnPercentage;
	}

	public void setExcessGrnPercentage(BigDecimal excessGrnPercentage) {
		this.excessGrnPercentage = excessGrnPercentage;
	}

	@Column(name = "bulk_order", length = 1, columnDefinition = "CHAR(1)")
	@Field
	public Character getBulkOrder() {
		return this.bulkOrder;
	}

	public void setBulkOrder(Character bulkOrder) {
		this.bulkOrder = bulkOrder;
	}

	@Column(name = "maintain_width_size", length = 1, columnDefinition = "CHAR(1)")
	@Field
	public Character getMaintainWidthSize() {
		return this.maintainWidthSize;
	}

	public void setMaintainWidthSize(Character maintainWidthSize) {
		this.maintainWidthSize = maintainWidthSize;
	}

	@Column(name = "required_program", length = 1, columnDefinition = "CHAR(1)")
	@Field
	public Character getRequiredProgram() {
		return this.requiredProgram;
	}

	public void setRequiredProgram(Character requiredProgram) {
		this.requiredProgram = requiredProgram;
	}

	@Column(name = "navision_taskcode", length = 20, columnDefinition = "CHAR(20)")
	@Field
	public String getNavisionTaskcode() {
		return this.navisionTaskcode;
	}

	public void setNavisionTaskcode(String navisionTaskcode) {
		this.navisionTaskcode = navisionTaskcode;
	}

	@Column(name = "item_type_desc", length = 50, columnDefinition = "CHAR(50)")
	@Field
	public String getItemTypeDesc() {
		return this.itemTypeDesc;
	}

	public void setItemTypeDesc(String itemTypeDesc) {
		this.itemTypeDesc = itemTypeDesc;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Mstitemtype [itemType=").append(itemType)
				.append(", itemGroup=").append(itemGroup)
				.append(", type1Name=").append(type1Name)
				.append(", type2Name=").append(type2Name)
				.append(", type3Name=").append(type3Name)
				.append(", type4Name=").append(type4Name)
				.append(", type5Name=").append(type5Name)
				.append(", type6Name=").append(type6Name)
				.append(", codeLength=").append(codeLength)
				.append(", sizewiseIndent=").append(sizewiseIndent)
				.append(", consPerPiece=").append(consPerPiece)
				.append(", sortOrder=").append(sortOrder)
				.append(", stockItem=").append(stockItem).append(", category=")
				.append(category).append(", requiredBoc=").append(requiredBoc)
				.append(", itlPercentage=").append(itlPercentage)
				.append(", itlExcessPercentage=").append(itlExcessPercentage)
				.append(", isService=").append(isService)
				.append(", type1CodeLen=").append(type1CodeLen)
				.append(", type2CodeLen=").append(type2CodeLen)
				.append(", type3CodeLen=").append(type3CodeLen)
				.append(", type4CodeLen=").append(type4CodeLen)
				.append(", type5CodeLen=").append(type5CodeLen)
				.append(", type6CodeLen=").append(type6CodeLen)
				.append(", colorWisePricelist=").append(colorWisePricelist)
				.append(", sizeWisePricelist=").append(sizeWisePricelist)
				.append(", requiredStockRequisition=")
				.append(requiredStockRequisition)
				.append(", showInPreshipment=").append(showInPreshipment)
				.append(", importLocal=").append(importLocal)
				.append(", relatedGsp=").append(relatedGsp)
				.append(", accCode=").append(accCode).append(", fabricTrim=")
				.append(fabricTrim).append(", fabricTrimOth=")
				.append(fabricTrimOth).append(", excessGrnPercentage=")
				.append(excessGrnPercentage).append(", bulkOrder=")
				.append(bulkOrder).append(", maintainWidthSize=")
				.append(maintainWidthSize).append(", requiredProgram=")
				.append(requiredProgram).append(", navisionTaskcode=")
				.append(navisionTaskcode).append(", itemTypeDesc=")
				.append(itemTypeDesc).append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((accCode == null) ? 0 : accCode.hashCode());
		result = prime * result
				+ ((bulkOrder == null) ? 0 : bulkOrder.hashCode());
		result = prime * result
				+ ((category == null) ? 0 : category.hashCode());
		result = prime * result
				+ ((codeLength == null) ? 0 : codeLength.hashCode());
		result = prime
				* result
				+ ((colorWisePricelist == null) ? 0 : colorWisePricelist
						.hashCode());
		result = prime * result
				+ ((consPerPiece == null) ? 0 : consPerPiece.hashCode());
		result = prime
				* result
				+ ((excessGrnPercentage == null) ? 0 : excessGrnPercentage
						.hashCode());
		result = prime * result
				+ ((fabricTrim == null) ? 0 : fabricTrim.hashCode());
		result = prime * result
				+ ((fabricTrimOth == null) ? 0 : fabricTrimOth.hashCode());
		result = prime * result
				+ ((importLocal == null) ? 0 : importLocal.hashCode());
		result = prime * result
				+ ((isService == null) ? 0 : isService.hashCode());
		result = prime * result
				+ ((itemGroup == null) ? 0 : itemGroup.hashCode());
		result = prime * result
				+ ((itemType == null) ? 0 : itemType.hashCode());
		result = prime * result
				+ ((itemTypeDesc == null) ? 0 : itemTypeDesc.hashCode());
		result = prime
				* result
				+ ((itlExcessPercentage == null) ? 0 : itlExcessPercentage
						.hashCode());
		result = prime * result
				+ ((itlPercentage == null) ? 0 : itlPercentage.hashCode());
		result = prime
				* result
				+ ((maintainWidthSize == null) ? 0 : maintainWidthSize
						.hashCode());
		result = prime
				* result
				+ ((navisionTaskcode == null) ? 0 : navisionTaskcode.hashCode());
		result = prime * result
				+ ((relatedGsp == null) ? 0 : relatedGsp.hashCode());
		result = prime * result
				+ ((requiredBoc == null) ? 0 : requiredBoc.hashCode());
		result = prime * result
				+ ((requiredProgram == null) ? 0 : requiredProgram.hashCode());
		result = prime
				* result
				+ ((requiredStockRequisition == null) ? 0
						: requiredStockRequisition.hashCode());
		result = prime
				* result
				+ ((showInPreshipment == null) ? 0 : showInPreshipment
						.hashCode());
		result = prime
				* result
				+ ((sizeWisePricelist == null) ? 0 : sizeWisePricelist
						.hashCode());
		result = prime * result
				+ ((sizewiseIndent == null) ? 0 : sizewiseIndent.hashCode());
		result = prime * result
				+ ((sortOrder == null) ? 0 : sortOrder.hashCode());
		result = prime * result
				+ ((stockItem == null) ? 0 : stockItem.hashCode());
		result = prime * result
				+ ((type1CodeLen == null) ? 0 : type1CodeLen.hashCode());
		result = prime * result
				+ ((type1Name == null) ? 0 : type1Name.hashCode());
		result = prime * result
				+ ((type2CodeLen == null) ? 0 : type2CodeLen.hashCode());
		result = prime * result
				+ ((type2Name == null) ? 0 : type2Name.hashCode());
		result = prime * result
				+ ((type3CodeLen == null) ? 0 : type3CodeLen.hashCode());
		result = prime * result
				+ ((type3Name == null) ? 0 : type3Name.hashCode());
		result = prime * result
				+ ((type4CodeLen == null) ? 0 : type4CodeLen.hashCode());
		result = prime * result
				+ ((type4Name == null) ? 0 : type4Name.hashCode());
		result = prime * result
				+ ((type5CodeLen == null) ? 0 : type5CodeLen.hashCode());
		result = prime * result
				+ ((type5Name == null) ? 0 : type5Name.hashCode());
		result = prime * result
				+ ((type6CodeLen == null) ? 0 : type6CodeLen.hashCode());
		result = prime * result
				+ ((type6Name == null) ? 0 : type6Name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mstitemtype other = (Mstitemtype) obj;
		if (accCode == null) {
			if (other.accCode != null)
				return false;
		} else if (!accCode.equals(other.accCode))
			return false;
		if (bulkOrder == null) {
			if (other.bulkOrder != null)
				return false;
		} else if (!bulkOrder.equals(other.bulkOrder))
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (codeLength == null) {
			if (other.codeLength != null)
				return false;
		} else if (!codeLength.equals(other.codeLength))
			return false;
		if (colorWisePricelist == null) {
			if (other.colorWisePricelist != null)
				return false;
		} else if (!colorWisePricelist.equals(other.colorWisePricelist))
			return false;
		if (consPerPiece == null) {
			if (other.consPerPiece != null)
				return false;
		} else if (!consPerPiece.equals(other.consPerPiece))
			return false;
		if (excessGrnPercentage == null) {
			if (other.excessGrnPercentage != null)
				return false;
		} else if (!excessGrnPercentage.equals(other.excessGrnPercentage))
			return false;
		if (fabricTrim == null) {
			if (other.fabricTrim != null)
				return false;
		} else if (!fabricTrim.equals(other.fabricTrim))
			return false;
		if (fabricTrimOth == null) {
			if (other.fabricTrimOth != null)
				return false;
		} else if (!fabricTrimOth.equals(other.fabricTrimOth))
			return false;
		if (importLocal == null) {
			if (other.importLocal != null)
				return false;
		} else if (!importLocal.equals(other.importLocal))
			return false;
		if (isService == null) {
			if (other.isService != null)
				return false;
		} else if (!isService.equals(other.isService))
			return false;
		if (itemGroup == null) {
			if (other.itemGroup != null)
				return false;
		} else if (!itemGroup.equals(other.itemGroup))
			return false;
		if (itemType == null) {
			if (other.itemType != null)
				return false;
		} else if (!itemType.equals(other.itemType))
			return false;
		if (itemTypeDesc == null) {
			if (other.itemTypeDesc != null)
				return false;
		} else if (!itemTypeDesc.equals(other.itemTypeDesc))
			return false;
		if (itlExcessPercentage == null) {
			if (other.itlExcessPercentage != null)
				return false;
		} else if (!itlExcessPercentage.equals(other.itlExcessPercentage))
			return false;
		if (itlPercentage == null) {
			if (other.itlPercentage != null)
				return false;
		} else if (!itlPercentage.equals(other.itlPercentage))
			return false;
		if (maintainWidthSize == null) {
			if (other.maintainWidthSize != null)
				return false;
		} else if (!maintainWidthSize.equals(other.maintainWidthSize))
			return false;
		if (navisionTaskcode == null) {
			if (other.navisionTaskcode != null)
				return false;
		} else if (!navisionTaskcode.equals(other.navisionTaskcode))
			return false;
		if (relatedGsp == null) {
			if (other.relatedGsp != null)
				return false;
		} else if (!relatedGsp.equals(other.relatedGsp))
			return false;
		if (requiredBoc == null) {
			if (other.requiredBoc != null)
				return false;
		} else if (!requiredBoc.equals(other.requiredBoc))
			return false;
		if (requiredProgram == null) {
			if (other.requiredProgram != null)
				return false;
		} else if (!requiredProgram.equals(other.requiredProgram))
			return false;
		if (requiredStockRequisition == null) {
			if (other.requiredStockRequisition != null)
				return false;
		} else if (!requiredStockRequisition
				.equals(other.requiredStockRequisition))
			return false;
		if (showInPreshipment == null) {
			if (other.showInPreshipment != null)
				return false;
		} else if (!showInPreshipment.equals(other.showInPreshipment))
			return false;
		if (sizeWisePricelist == null) {
			if (other.sizeWisePricelist != null)
				return false;
		} else if (!sizeWisePricelist.equals(other.sizeWisePricelist))
			return false;
		if (sizewiseIndent == null) {
			if (other.sizewiseIndent != null)
				return false;
		} else if (!sizewiseIndent.equals(other.sizewiseIndent))
			return false;
		if (sortOrder == null) {
			if (other.sortOrder != null)
				return false;
		} else if (!sortOrder.equals(other.sortOrder))
			return false;
		if (stockItem == null) {
			if (other.stockItem != null)
				return false;
		} else if (!stockItem.equals(other.stockItem))
			return false;
		if (type1CodeLen == null) {
			if (other.type1CodeLen != null)
				return false;
		} else if (!type1CodeLen.equals(other.type1CodeLen))
			return false;
		if (type1Name == null) {
			if (other.type1Name != null)
				return false;
		} else if (!type1Name.equals(other.type1Name))
			return false;
		if (type2CodeLen == null) {
			if (other.type2CodeLen != null)
				return false;
		} else if (!type2CodeLen.equals(other.type2CodeLen))
			return false;
		if (type2Name == null) {
			if (other.type2Name != null)
				return false;
		} else if (!type2Name.equals(other.type2Name))
			return false;
		if (type3CodeLen == null) {
			if (other.type3CodeLen != null)
				return false;
		} else if (!type3CodeLen.equals(other.type3CodeLen))
			return false;
		if (type3Name == null) {
			if (other.type3Name != null)
				return false;
		} else if (!type3Name.equals(other.type3Name))
			return false;
		if (type4CodeLen == null) {
			if (other.type4CodeLen != null)
				return false;
		} else if (!type4CodeLen.equals(other.type4CodeLen))
			return false;
		if (type4Name == null) {
			if (other.type4Name != null)
				return false;
		} else if (!type4Name.equals(other.type4Name))
			return false;
		if (type5CodeLen == null) {
			if (other.type5CodeLen != null)
				return false;
		} else if (!type5CodeLen.equals(other.type5CodeLen))
			return false;
		if (type5Name == null) {
			if (other.type5Name != null)
				return false;
		} else if (!type5Name.equals(other.type5Name))
			return false;
		if (type6CodeLen == null) {
			if (other.type6CodeLen != null)
				return false;
		} else if (!type6CodeLen.equals(other.type6CodeLen))
			return false;
		if (type6Name == null) {
			if (other.type6Name != null)
				return false;
		} else if (!type6Name.equals(other.type6Name))
			return false;
		return true;
	}



	

}
