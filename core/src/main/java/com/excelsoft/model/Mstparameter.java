package com.excelsoft.model;

import java.io.Serializable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.search.annotations.Indexed;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the mstparameter database table.
 * 
 */
@Entity
@Indexed
@Table(name = "mstparameter")
@XmlRootElement
public class Mstparameter extends BaseObject implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="comp_name", columnDefinition="CHAR(40)", length=40)
	private String compName;

	@Column(name="allow_pd_and_ms_charges" ,columnDefinition="CHAR(1)", length=1)
	private String allowPdAndMsCharges;

	@Column(name="approval_for_oth_po" ,columnDefinition="CHAR(1)", length=1)
	private String approvalForOthPo;

	@Column(name="approve_wo" ,columnDefinition="CHAR(1)", length=1)
	private String approveWo;

	@Column(name="base_cur" ,columnDefinition="CHAR(4)", length=4)
	private String baseCur;

	@Column(name="bin_alloc_mandatory" ,columnDefinition="CHAR(1)", length=1)
	private String binAllocMandatory;

	@Column(name="boc_app_val_tgt" ,columnDefinition="CHAR(1)", length=1)
	private String bocAppValTgt;
	
	@Column(name="BOC_approval_to_PO",columnDefinition="CHAR(1)", length=1)
	private String BOCapprovaltoPO;

	@Column(name="boc_edit_compcode" ,columnDefinition="CHAR(1)", length=1)
	private String bocEditCompcode;

	@Column(name="boc_po_lock" ,columnDefinition="CHAR(1)", length=1)
	private String bocPoLock;

	@Column(name="boc_porq_lock" ,columnDefinition="CHAR(1)", length=1)
	private String bocPorqLock;

	@Column(name="boc_version" ,columnDefinition="CHAR(1)", length=1)
	private String bocVersion;

	@Column(name="bulk_cheque_printing" ,columnDefinition="CHAR(1)", length=1)
	private String bulkChequePrinting;

	@Column(name="chars_inglcode")
	private BigDecimal charsInglcode;
	
	@Column(name="currency_method" ,columnDefinition="CHAR(10)", length=10)
	private String  currencyMethod;
	
	@Column(name="checkcostsheet_appin_po" ,columnDefinition="CHAR(1)", length=1)
	private String checkcostsheetAppinPo;

	@Column(name="chk_explccomp_boc" ,columnDefinition="CHAR(1)", length=1)
	private String chkExplccompBoc;

	@Column(name="cm_devideby_lifeoff" ,columnDefinition="CHAR(1)", length=1)
	private String cmDevidebyLifeoff;

	@Column(name="cm_value")
	private BigDecimal cmValue;

	@Column(name="common_comp_code" ,columnDefinition="CHAR(6)", length=6)
	private String commonCompCode;

	@Column(name="COMPANY_ID_SEAMS" ,columnDefinition="CHAR(10)", length=10)
	private String companyIdSeams;

	@Column(name="consum_use_workorder" ,columnDefinition="CHAR(1)", length=1)
	private String consumUseWorkorder;

	@Column(name="consumption_unit")
	private BigDecimal consumptionUnit;

	@Column(name="consumption_varience" )
	private BigDecimal consumptionVarience;

	@Column(name="control_printing" ,columnDefinition="CHAR(1)", length=1)
	private String controlPrinting;

	@Column(name="country_using_tops" ,columnDefinition="CHAR(3)", length=3)
	private String countryUsingTops;

	@Column(name="cpa_multiple_plan" ,columnDefinition="CHAR(1)", length=1)
	private String cpaMultiplePlan;

	@Column(name="cs_prtct_itm_desc" ,columnDefinition="CHAR(1)", length=1)
	private String csPrtctItmDesc;

	@Column(name="cusdec_preprint" ,columnDefinition="CHAR(1)", length=1)
	private String cusdecPreprint;

	@Column(name="cuttingdep_code" ,columnDefinition="CHAR(10)", length=10)
	private String cuttingdepCode;

	@Column(name="cuttingticket_boccon" ,columnDefinition="CHAR(20)", length=20)
	private String cuttingticketBoccon;

	@Column(name="doc_our_ref" ,columnDefinition="CHAR(1)", length=1)
	private String docOurRef;

	@Column(name="edit_multi_user_program_entry" ,columnDefinition="CHAR(1)", length=1)
	private String editMultiUserProgramEntry;

	@Column(name="edit_purchase_lc" ,columnDefinition="CHAR(1)", length=1)
	private String editPurchaseLc;

	@Column(name="editable_target" ,columnDefinition="CHAR(1)", length=1)
	private String editableTarget;

	@Column(name="emb_plan_percent")
	private BigDecimal embPlanPercent;

	@Column(name="enable_audit" ,columnDefinition="CHAR(1)", length=1)
	private String enableAudit;

	@Column(name="enable_workflow" ,columnDefinition="CHAR(1)", length=1)
	private String enableWorkflow;

	@Column(name="enhance_inventry" ,columnDefinition="CHAR(1)", length=1)
	private String enhanceInventry;

	@Column(name="excess_issue_pcnt")
	private BigDecimal excessIssuePcnt;

	@Column(name="excess_po_pcnt" )
	private BigDecimal excessPoPcnt;

	@Column(name="exchange_rate" ,columnDefinition="CHAR(1)", length=1)
	private String exchangeRate;

	@Column(name="extd_num_lay_rpt" ,columnDefinition="CHAR(1)", length=1)
	private String extdNumLayRpt;

	@Column(name="fabric_type" ,columnDefinition="CHAR(10)", length=10)
	private String fabricType;

	@Column(name="fin_structure" ,length=1)
	private String finStructure;

	@Column(name="final_process" ,columnDefinition="CHAR(10)", length=10)
	private String finalProcess;

	@Column(name="finance_location" ,columnDefinition="CHAR(6)", length=6)
	private String financeLocation;

	@Column(name="generate_asset" ,columnDefinition="CHAR(1)", length=1)
	private String generateAsset;

	@Column(name="imp_exp" ,columnDefinition="CHAR(10)", length=10)
	private String impExp;

	@Column(name="int_trf_price_edit" ,columnDefinition="CHAR(1)", length=1)
	private String intTrfPriceEdit;

	@Column(name="inv_boc_lock" ,columnDefinition="CHAR(1)", length=1)
	private String invBocLock;

	@Column(name="inv_unitprice_decimal")
	private BigDecimal invUnitpriceDecimal;

	@Column(name="invalid_characters" ,length=50)
	private String invalidCharacters;

	@Column(name="last_run_no")
	private int lastRunNo;

	@Column(name="line_style")
	private BigDecimal lineStyle;

	@Column(name="loadingplan_option" ,columnDefinition="CHAR(1)", length=1)
	private String loadingplanOption;

	@Column(name="location_code" ,columnDefinition="CHAR(6)", length=6)
	private String locationCode;

	@Column(name="LOCATION_CODE_SEAMS" ,columnDefinition="CHAR(10)", length=10)
	private String locationCodeSeams;
	
	@Column(name="location_SysId")
	private BigDecimal locationSysId;

	@Column(name="lock_boc_bom" ,columnDefinition="CHAR(1)", length=1)
	private String lockBocBom;

	@Column(name="lock_boc_dates" ,columnDefinition="CHAR(1)", length=1)
	private String lockBocDates;

	@Column(name="lock_cominv_oth_dept" ,columnDefinition="CHAR(1)", length=1)
	private String lockCominvOthDept;

	@Column(name="lock_modify" ,columnDefinition="CHAR(1)", length=1)
	private String lockModify;

	@Column(name="main_location" ,columnDefinition="CHAR(6)", length=6)
	private String mainLocation;

	@Column(name="merchandiser_app" ,columnDefinition="CHAR(1)", length=1)
	private String merchandiserApp;

	@Column(name="modify_BOMItem_Cons" ,columnDefinition="CHAR(1)", length=1)
	private String modifyBOMItemCons;

	@Column(name="muli_grn_for_supinv" ,columnDefinition="CHAR(1)", length=1)
	private String muliGrnForSupinv;

	@Column(name="multi_stock_room" ,columnDefinition="CHAR(1)", length=1)
	private String multiStockRoom;

	@Column(name="one_wo_for_boc" ,columnDefinition="CHAR(1)", length=1)
	private String oneWoForBoc;

	@Column(name="opt_1_desc" ,columnDefinition="CHAR(10)", length=10)
	private String opt1Desc;

	@Column(name="opt_2_desc" ,columnDefinition="CHAR(6)", length=6)
	private String opt2Desc;

	@Column(name="opt_3_desc" ,columnDefinition="CHAR(6)", length=6)
	private String opt3Desc;

	@Column(name="opt_4_desc",columnDefinition="CHAR(6)", length=6)
	private String opt4Desc;

	@Column(name="opt_5_desc" ,columnDefinition="CHAR(6)", length=6)
	private String opt5Desc;

	@Column(name="order_program" ,columnDefinition="CHAR(1)", length=1)
	private String orderProgram;

	@Column(name="orderbook_option" ,columnDefinition="CHAR(1)", length=1)
	private String orderbookOption;

	@Column(name="packlist_mod" ,columnDefinition="CHAR(1)", length=1)
	private String packlistMod;

	@Column(name="pd_location" ,columnDefinition="CHAR(6)", length=6)
	private String pdLocation;

	@Column(name="po_dual_app" ,columnDefinition="CHAR(1)", length=1)
	private String poDualApp;

	@Column(name="porq_dual_app_for_po" ,columnDefinition="CHAR(1)", length=1)
	private String porqDualAppForPo;

	@Column(name="porq_val_boc" ,columnDefinition="CHAR(1)", length=1)
	private String porqValBoc;

	@Column(name="prd_process" ,columnDefinition="CHAR(10)", length=10)
	private String prdProcess;

	@Column(name="print_comp_hdr" ,columnDefinition="CHAR(1)", length=1)
	private String printCompHdr;

	@Column(name="print_cusdec_comp" ,columnDefinition="CHAR(1)", length=1)
	private String printCusdecComp;

	@Column(name="production_process" ,columnDefinition="CHAR(1)", length=1)
	private String productionProcess;

	@Column(name="prog_excs_allowqty_pcnt")
	private BigDecimal progExcsAllowqtyPcnt;

	@Column(name="protect_exch_rate" ,columnDefinition="CHAR(1)", length=1)
	private String protectExchRate;

	@Column(name="purge_no_months")
	private int purgeNoMonths;

	@Column(name="qta_trfr_per")
	private BigDecimal qtaTrfrPer;

	@Column(name="qtarsrv_byapp" ,columnDefinition="MEDIUMTEXT")
	private String qtarsrvByapp;

	@Column(name="qtyprdcd_smvof")
	private BigDecimal qtyprdcdSmvof;

	@Lob
	@Column(name="rep_view_url" ,columnDefinition="CHAR(1)", length=1)
	private String repViewUrl;

	@Column(name="replicate_yn" ,columnDefinition="CHAR(1)", length=1)
	private String replicateYn;

	@Column(name="reporting_cm_value")
	private BigDecimal reportingCmValue;

	@Column(name="reserve_quota",columnDefinition="CHAR(1)", length=1 )
	private String reserveQuota;

	@Column(name="set_zerovalue" ,columnDefinition="CHAR(1)", length=1)
	private String setZerovalue;

	@Column(name="smv_based_costsheet" ,columnDefinition="CHAR(1)", length=1)
	private String smvBasedCostsheet;

	@Column(name="status_update_qty_check",columnDefinition="CHAR(1)", length=1)
	private String statusUpdateQtyCheck;

	@Column(name="stk_mntend_value_method",columnDefinition="CHAR(1)", length=1)
	private String stkMntendValueMethod;

	@Temporal(TemporalType.DATE)
	private Date stk_Value_Startdate;

	@Column(name="stock_transfer_excess_qty_check" ,columnDefinition="CHAR(1)", length=1)
	private String stockTransferExcessQtyCheck;

	@Column(name="stock_updatein_app" ,columnDefinition="CHAR(1)", length=1)
	private String stockUpdateinApp;

	@Column(name="stock_Value_Mechanism",columnDefinition="CHAR(6)", length=6)
	private String stockValueMechanism;

	@Column(name="sub_holding_ext" ,columnDefinition="CHAR(1)", length=1)
	private String subHoldingExt;

	@Column(name="sup_inv_bulk_entry" ,columnDefinition="CHAR(1)", length=1)
	private String supInvBulkEntry;

	@Column(name="supinv_dtlgl" ,columnDefinition="CHAR(1)", length=1)
	private String supinvDtlgl;

	@Column(name="unit_conv_rate_for_value_base")
	private BigDecimal unitConvRateForValueBase;

	@Column(name="update_gl_from_grn" ,columnDefinition="CHAR(1)", length=1)
	private String updateGlFromGrn;

	@Column(name="us_dollar_cur_code" ,columnDefinition="CHAR(4)", length=4)
	private String usDollarCurCode;
	
	@Column(name="use_CustAgent" ,columnDefinition="CHAR(1)", length=1)
	private String useCustAgent;

	@Column(name="use_loading_plan" ,columnDefinition="CHAR(1)", length=1)
	private String useLoadingPlan;
	
	@Column(name="use_SuppAgent" ,columnDefinition="CHAR(1)", length=1)
	private String useSuppAgent;

	@Column(name="version_no" ,columnDefinition="CHAR(20)", length=20)
	private String versionNo;

	@Column(name="visa_lock" ,columnDefinition="CHAR(1)", length=1)
	private String visaLock;

	@Column(name="wf_time_enterval" ,columnDefinition="CHAR(1)", length=1)
	private String wfTimeEnterval;

	@Column(name="workorder_stktrfr" ,columnDefinition="CHAR(1)", length=1)
	private String workorderStktrfr;

	public Mstparameter() {
	}

	

	public String getCompName() {
		return compName;
	}




	public void setCompName(String compName) {
		this.compName = compName;
	}




	public String getAllowPdAndMsCharges() {
		return allowPdAndMsCharges;
	}




	public void setAllowPdAndMsCharges(String allowPdAndMsCharges) {
		this.allowPdAndMsCharges = allowPdAndMsCharges;
	}




	public String getApprovalForOthPo() {
		return approvalForOthPo;
	}




	public void setApprovalForOthPo(String approvalForOthPo) {
		this.approvalForOthPo = approvalForOthPo;
	}




	public String getApproveWo() {
		return approveWo;
	}




	public void setApproveWo(String approveWo) {
		this.approveWo = approveWo;
	}




	public String getBaseCur() {
		return baseCur;
	}




	public void setBaseCur(String baseCur) {
		this.baseCur = baseCur;
	}




	public String getBinAllocMandatory() {
		return binAllocMandatory;
	}




	public void setBinAllocMandatory(String binAllocMandatory) {
		this.binAllocMandatory = binAllocMandatory;
	}




	public String getBocAppValTgt() {
		return bocAppValTgt;
	}




	public void setBocAppValTgt(String bocAppValTgt) {
		this.bocAppValTgt = bocAppValTgt;
	}




	public String getBOCapprovaltoPO() {
		return BOCapprovaltoPO;
	}




	public void setBOCapprovaltoPO(String bOCapprovaltoPO) {
		BOCapprovaltoPO = bOCapprovaltoPO;
	}




	public String getBocEditCompcode() {
		return bocEditCompcode;
	}




	public void setBocEditCompcode(String bocEditCompcode) {
		this.bocEditCompcode = bocEditCompcode;
	}




	public String getBocPoLock() {
		return bocPoLock;
	}




	public void setBocPoLock(String bocPoLock) {
		this.bocPoLock = bocPoLock;
	}




	public String getBocPorqLock() {
		return bocPorqLock;
	}




	public void setBocPorqLock(String bocPorqLock) {
		this.bocPorqLock = bocPorqLock;
	}




	public String getBocVersion() {
		return bocVersion;
	}




	public void setBocVersion(String bocVersion) {
		this.bocVersion = bocVersion;
	}




	public String getBulkChequePrinting() {
		return bulkChequePrinting;
	}




	public void setBulkChequePrinting(String bulkChequePrinting) {
		this.bulkChequePrinting = bulkChequePrinting;
	}




	public BigDecimal getCharsInglcode() {
		return charsInglcode;
	}




	public void setCharsInglcode(BigDecimal charsInglcode) {
		this.charsInglcode = charsInglcode;
	}




	public String getCurrencyMethod() {
		return currencyMethod;
	}




	public void setCurrencyMethod(String currencyMethod) {
		this.currencyMethod = currencyMethod;
	}




	public String getCheckcostsheetAppinPo() {
		return checkcostsheetAppinPo;
	}




	public void setCheckcostsheetAppinPo(String checkcostsheetAppinPo) {
		this.checkcostsheetAppinPo = checkcostsheetAppinPo;
	}




	public String getChkExplccompBoc() {
		return chkExplccompBoc;
	}




	public void setChkExplccompBoc(String chkExplccompBoc) {
		this.chkExplccompBoc = chkExplccompBoc;
	}




	public String getCmDevidebyLifeoff() {
		return cmDevidebyLifeoff;
	}




	public void setCmDevidebyLifeoff(String cmDevidebyLifeoff) {
		this.cmDevidebyLifeoff = cmDevidebyLifeoff;
	}




	public BigDecimal getCmValue() {
		return cmValue;
	}




	public void setCmValue(BigDecimal cmValue) {
		this.cmValue = cmValue;
	}




	public String getCommonCompCode() {
		return commonCompCode;
	}




	public void setCommonCompCode(String commonCompCode) {
		this.commonCompCode = commonCompCode;
	}




	public String getCompanyIdSeams() {
		return companyIdSeams;
	}




	public void setCompanyIdSeams(String companyIdSeams) {
		this.companyIdSeams = companyIdSeams;
	}




	public String getConsumUseWorkorder() {
		return consumUseWorkorder;
	}




	public void setConsumUseWorkorder(String consumUseWorkorder) {
		this.consumUseWorkorder = consumUseWorkorder;
	}




	public BigDecimal getConsumptionUnit() {
		return consumptionUnit;
	}




	public void setConsumptionUnit(BigDecimal consumptionUnit) {
		this.consumptionUnit = consumptionUnit;
	}




	public BigDecimal getConsumptionVarience() {
		return consumptionVarience;
	}




	public void setConsumptionVarience(BigDecimal consumptionVarience) {
		this.consumptionVarience = consumptionVarience;
	}




	public String getControlPrinting() {
		return controlPrinting;
	}




	public void setControlPrinting(String controlPrinting) {
		this.controlPrinting = controlPrinting;
	}




	public String getCountryUsingTops() {
		return countryUsingTops;
	}




	public void setCountryUsingTops(String countryUsingTops) {
		this.countryUsingTops = countryUsingTops;
	}




	public String getCpaMultiplePlan() {
		return cpaMultiplePlan;
	}




	public void setCpaMultiplePlan(String cpaMultiplePlan) {
		this.cpaMultiplePlan = cpaMultiplePlan;
	}




	public String getCsPrtctItmDesc() {
		return csPrtctItmDesc;
	}




	public void setCsPrtctItmDesc(String csPrtctItmDesc) {
		this.csPrtctItmDesc = csPrtctItmDesc;
	}




	public String getCusdecPreprint() {
		return cusdecPreprint;
	}




	public void setCusdecPreprint(String cusdecPreprint) {
		this.cusdecPreprint = cusdecPreprint;
	}




	public String getCuttingdepCode() {
		return cuttingdepCode;
	}




	public void setCuttingdepCode(String cuttingdepCode) {
		this.cuttingdepCode = cuttingdepCode;
	}




	public String getCuttingticketBoccon() {
		return cuttingticketBoccon;
	}




	public void setCuttingticketBoccon(String cuttingticketBoccon) {
		this.cuttingticketBoccon = cuttingticketBoccon;
	}




	public String getDocOurRef() {
		return docOurRef;
	}




	public void setDocOurRef(String docOurRef) {
		this.docOurRef = docOurRef;
	}




	public String getEditMultiUserProgramEntry() {
		return editMultiUserProgramEntry;
	}




	public void setEditMultiUserProgramEntry(String editMultiUserProgramEntry) {
		this.editMultiUserProgramEntry = editMultiUserProgramEntry;
	}




	public String getEditPurchaseLc() {
		return editPurchaseLc;
	}




	public void setEditPurchaseLc(String editPurchaseLc) {
		this.editPurchaseLc = editPurchaseLc;
	}




	public String getEditableTarget() {
		return editableTarget;
	}




	public void setEditableTarget(String editableTarget) {
		this.editableTarget = editableTarget;
	}




	public BigDecimal getEmbPlanPercent() {
		return embPlanPercent;
	}




	public void setEmbPlanPercent(BigDecimal embPlanPercent) {
		this.embPlanPercent = embPlanPercent;
	}




	public String getEnableAudit() {
		return enableAudit;
	}




	public void setEnableAudit(String enableAudit) {
		this.enableAudit = enableAudit;
	}




	public String getEnableWorkflow() {
		return enableWorkflow;
	}




	public void setEnableWorkflow(String enableWorkflow) {
		this.enableWorkflow = enableWorkflow;
	}




	public String getEnhanceInventry() {
		return enhanceInventry;
	}




	public void setEnhanceInventry(String enhanceInventry) {
		this.enhanceInventry = enhanceInventry;
	}




	public BigDecimal getExcessIssuePcnt() {
		return excessIssuePcnt;
	}




	public void setExcessIssuePcnt(BigDecimal excessIssuePcnt) {
		this.excessIssuePcnt = excessIssuePcnt;
	}




	public BigDecimal getExcessPoPcnt() {
		return excessPoPcnt;
	}




	public void setExcessPoPcnt(BigDecimal excessPoPcnt) {
		this.excessPoPcnt = excessPoPcnt;
	}




	public String getExchangeRate() {
		return exchangeRate;
	}




	public void setExchangeRate(String exchangeRate) {
		this.exchangeRate = exchangeRate;
	}




	public String getExtdNumLayRpt() {
		return extdNumLayRpt;
	}




	public void setExtdNumLayRpt(String extdNumLayRpt) {
		this.extdNumLayRpt = extdNumLayRpt;
	}




	public String getFabricType() {
		return fabricType;
	}




	public void setFabricType(String fabricType) {
		this.fabricType = fabricType;
	}




	public String getFinStructure() {
		return finStructure;
	}




	public void setFinStructure(String finStructure) {
		this.finStructure = finStructure;
	}




	public String getFinalProcess() {
		return finalProcess;
	}




	public void setFinalProcess(String finalProcess) {
		this.finalProcess = finalProcess;
	}




	public String getFinanceLocation() {
		return financeLocation;
	}




	public void setFinanceLocation(String financeLocation) {
		this.financeLocation = financeLocation;
	}




	public String getGenerateAsset() {
		return generateAsset;
	}




	public void setGenerateAsset(String generateAsset) {
		this.generateAsset = generateAsset;
	}




	public String getImpExp() {
		return impExp;
	}




	public void setImpExp(String impExp) {
		this.impExp = impExp;
	}




	public String getIntTrfPriceEdit() {
		return intTrfPriceEdit;
	}




	public void setIntTrfPriceEdit(String intTrfPriceEdit) {
		this.intTrfPriceEdit = intTrfPriceEdit;
	}




	public String getInvBocLock() {
		return invBocLock;
	}




	public void setInvBocLock(String invBocLock) {
		this.invBocLock = invBocLock;
	}




	public BigDecimal getInvUnitpriceDecimal() {
		return invUnitpriceDecimal;
	}




	public void setInvUnitpriceDecimal(BigDecimal invUnitpriceDecimal) {
		this.invUnitpriceDecimal = invUnitpriceDecimal;
	}




	public String getInvalidCharacters() {
		return invalidCharacters;
	}




	public void setInvalidCharacters(String invalidCharacters) {
		this.invalidCharacters = invalidCharacters;
	}




	public int getLastRunNo() {
		return lastRunNo;
	}




	public void setLastRunNo(int lastRunNo) {
		this.lastRunNo = lastRunNo;
	}




	public BigDecimal getLineStyle() {
		return lineStyle;
	}




	public void setLineStyle(BigDecimal lineStyle) {
		this.lineStyle = lineStyle;
	}




	public String getLoadingplanOption() {
		return loadingplanOption;
	}




	public void setLoadingplanOption(String loadingplanOption) {
		this.loadingplanOption = loadingplanOption;
	}




	public String getLocationCode() {
		return locationCode;
	}




	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}




	public String getLocationCodeSeams() {
		return locationCodeSeams;
	}




	public void setLocationCodeSeams(String locationCodeSeams) {
		this.locationCodeSeams = locationCodeSeams;
	}




	public BigDecimal getLocationSysId() {
		return locationSysId;
	}




	public void setLocationSysId(BigDecimal locationSysId) {
		this.locationSysId = locationSysId;
	}




	public String getLockBocBom() {
		return lockBocBom;
	}




	public void setLockBocBom(String lockBocBom) {
		this.lockBocBom = lockBocBom;
	}




	public String getLockBocDates() {
		return lockBocDates;
	}




	public void setLockBocDates(String lockBocDates) {
		this.lockBocDates = lockBocDates;
	}




	public String getLockCominvOthDept() {
		return lockCominvOthDept;
	}




	public void setLockCominvOthDept(String lockCominvOthDept) {
		this.lockCominvOthDept = lockCominvOthDept;
	}




	public String getLockModify() {
		return lockModify;
	}




	public void setLockModify(String lockModify) {
		this.lockModify = lockModify;
	}




	public String getMainLocation() {
		return mainLocation;
	}




	public void setMainLocation(String mainLocation) {
		this.mainLocation = mainLocation;
	}




	public String getMerchandiserApp() {
		return merchandiserApp;
	}




	public void setMerchandiserApp(String merchandiserApp) {
		this.merchandiserApp = merchandiserApp;
	}




	public String getModifyBOMItemCons() {
		return modifyBOMItemCons;
	}




	public void setModifyBOMItemCons(String modifyBOMItemCons) {
		this.modifyBOMItemCons = modifyBOMItemCons;
	}




	public String getMuliGrnForSupinv() {
		return muliGrnForSupinv;
	}




	public void setMuliGrnForSupinv(String muliGrnForSupinv) {
		this.muliGrnForSupinv = muliGrnForSupinv;
	}




	public String getMultiStockRoom() {
		return multiStockRoom;
	}




	public void setMultiStockRoom(String multiStockRoom) {
		this.multiStockRoom = multiStockRoom;
	}




	public String getOneWoForBoc() {
		return oneWoForBoc;
	}




	public void setOneWoForBoc(String oneWoForBoc) {
		this.oneWoForBoc = oneWoForBoc;
	}




	public String getOpt1Desc() {
		return opt1Desc;
	}




	public void setOpt1Desc(String opt1Desc) {
		this.opt1Desc = opt1Desc;
	}




	public String getOpt2Desc() {
		return opt2Desc;
	}




	public void setOpt2Desc(String opt2Desc) {
		this.opt2Desc = opt2Desc;
	}




	public String getOpt3Desc() {
		return opt3Desc;
	}




	public void setOpt3Desc(String opt3Desc) {
		this.opt3Desc = opt3Desc;
	}




	public String getOpt4Desc() {
		return opt4Desc;
	}




	public void setOpt4Desc(String opt4Desc) {
		this.opt4Desc = opt4Desc;
	}




	public String getOpt5Desc() {
		return opt5Desc;
	}




	public void setOpt5Desc(String opt5Desc) {
		this.opt5Desc = opt5Desc;
	}




	public String getOrderProgram() {
		return orderProgram;
	}




	public void setOrderProgram(String orderProgram) {
		this.orderProgram = orderProgram;
	}




	public String getOrderbookOption() {
		return orderbookOption;
	}




	public void setOrderbookOption(String orderbookOption) {
		this.orderbookOption = orderbookOption;
	}




	public String getPacklistMod() {
		return packlistMod;
	}




	public void setPacklistMod(String packlistMod) {
		this.packlistMod = packlistMod;
	}




	public String getPdLocation() {
		return pdLocation;
	}




	public void setPdLocation(String pdLocation) {
		this.pdLocation = pdLocation;
	}




	public String getPoDualApp() {
		return poDualApp;
	}




	public void setPoDualApp(String poDualApp) {
		this.poDualApp = poDualApp;
	}




	public String getPorqDualAppForPo() {
		return porqDualAppForPo;
	}




	public void setPorqDualAppForPo(String porqDualAppForPo) {
		this.porqDualAppForPo = porqDualAppForPo;
	}




	public String getPorqValBoc() {
		return porqValBoc;
	}




	public void setPorqValBoc(String porqValBoc) {
		this.porqValBoc = porqValBoc;
	}




	public String getPrdProcess() {
		return prdProcess;
	}




	public void setPrdProcess(String prdProcess) {
		this.prdProcess = prdProcess;
	}




	public String getPrintCompHdr() {
		return printCompHdr;
	}




	public void setPrintCompHdr(String printCompHdr) {
		this.printCompHdr = printCompHdr;
	}




	public String getPrintCusdecComp() {
		return printCusdecComp;
	}




	public void setPrintCusdecComp(String printCusdecComp) {
		this.printCusdecComp = printCusdecComp;
	}




	public String getProductionProcess() {
		return productionProcess;
	}




	public void setProductionProcess(String productionProcess) {
		this.productionProcess = productionProcess;
	}




	public BigDecimal getProgExcsAllowqtyPcnt() {
		return progExcsAllowqtyPcnt;
	}




	public void setProgExcsAllowqtyPcnt(BigDecimal progExcsAllowqtyPcnt) {
		this.progExcsAllowqtyPcnt = progExcsAllowqtyPcnt;
	}




	public String getProtectExchRate() {
		return protectExchRate;
	}




	public void setProtectExchRate(String protectExchRate) {
		this.protectExchRate = protectExchRate;
	}




	public int getPurgeNoMonths() {
		return purgeNoMonths;
	}




	public void setPurgeNoMonths(int purgeNoMonths) {
		this.purgeNoMonths = purgeNoMonths;
	}




	public BigDecimal getQtaTrfrPer() {
		return qtaTrfrPer;
	}




	public void setQtaTrfrPer(BigDecimal qtaTrfrPer) {
		this.qtaTrfrPer = qtaTrfrPer;
	}




	public String getQtarsrvByapp() {
		return qtarsrvByapp;
	}




	public void setQtarsrvByapp(String qtarsrvByapp) {
		this.qtarsrvByapp = qtarsrvByapp;
	}




	public BigDecimal getQtyprdcdSmvof() {
		return qtyprdcdSmvof;
	}




	public void setQtyprdcdSmvof(BigDecimal qtyprdcdSmvof) {
		this.qtyprdcdSmvof = qtyprdcdSmvof;
	}




	public String getRepViewUrl() {
		return repViewUrl;
	}




	public void setRepViewUrl(String repViewUrl) {
		this.repViewUrl = repViewUrl;
	}




	public String getReplicateYn() {
		return replicateYn;
	}




	public void setReplicateYn(String replicateYn) {
		this.replicateYn = replicateYn;
	}




	public BigDecimal getReportingCmValue() {
		return reportingCmValue;
	}




	public void setReportingCmValue(BigDecimal reportingCmValue) {
		this.reportingCmValue = reportingCmValue;
	}




	public String getReserveQuota() {
		return reserveQuota;
	}




	public void setReserveQuota(String reserveQuota) {
		this.reserveQuota = reserveQuota;
	}




	public String getSetZerovalue() {
		return setZerovalue;
	}




	public void setSetZerovalue(String setZerovalue) {
		this.setZerovalue = setZerovalue;
	}




	public String getSmvBasedCostsheet() {
		return smvBasedCostsheet;
	}




	public void setSmvBasedCostsheet(String smvBasedCostsheet) {
		this.smvBasedCostsheet = smvBasedCostsheet;
	}




	public String getStatusUpdateQtyCheck() {
		return statusUpdateQtyCheck;
	}




	public void setStatusUpdateQtyCheck(String statusUpdateQtyCheck) {
		this.statusUpdateQtyCheck = statusUpdateQtyCheck;
	}




	public String getStkMntendValueMethod() {
		return stkMntendValueMethod;
	}




	public void setStkMntendValueMethod(String stkMntendValueMethod) {
		this.stkMntendValueMethod = stkMntendValueMethod;
	}




	public Date getStk_Value_Startdate() {
		return stk_Value_Startdate;
	}




	public void setStk_Value_Startdate(Date stk_Value_Startdate) {
		this.stk_Value_Startdate = stk_Value_Startdate;
	}




	public String getStockTransferExcessQtyCheck() {
		return stockTransferExcessQtyCheck;
	}




	public void setStockTransferExcessQtyCheck(String stockTransferExcessQtyCheck) {
		this.stockTransferExcessQtyCheck = stockTransferExcessQtyCheck;
	}




	public String getStockUpdateinApp() {
		return stockUpdateinApp;
	}




	public void setStockUpdateinApp(String stockUpdateinApp) {
		this.stockUpdateinApp = stockUpdateinApp;
	}




	public String getStockValueMechanism() {
		return stockValueMechanism;
	}




	public void setStockValueMechanism(String stockValueMechanism) {
		this.stockValueMechanism = stockValueMechanism;
	}




	public String getSubHoldingExt() {
		return subHoldingExt;
	}




	public void setSubHoldingExt(String subHoldingExt) {
		this.subHoldingExt = subHoldingExt;
	}




	public String getSupInvBulkEntry() {
		return supInvBulkEntry;
	}




	public void setSupInvBulkEntry(String supInvBulkEntry) {
		this.supInvBulkEntry = supInvBulkEntry;
	}




	public String getSupinvDtlgl() {
		return supinvDtlgl;
	}




	public void setSupinvDtlgl(String supinvDtlgl) {
		this.supinvDtlgl = supinvDtlgl;
	}




	public BigDecimal getUnitConvRateForValueBase() {
		return unitConvRateForValueBase;
	}




	public void setUnitConvRateForValueBase(BigDecimal unitConvRateForValueBase) {
		this.unitConvRateForValueBase = unitConvRateForValueBase;
	}




	public String getUpdateGlFromGrn() {
		return updateGlFromGrn;
	}

	public void setUpdateGlFromGrn(String updateGlFromGrn) {
		this.updateGlFromGrn = updateGlFromGrn;
	}

	public String getUsDollarCurCode() {
		return usDollarCurCode;
	}

	public void setUsDollarCurCode(String usDollarCurCode) {
		this.usDollarCurCode = usDollarCurCode;
	}

	public String getUseCustAgent() {
		return useCustAgent;
	}

	public void setUseCustAgent(String useCustAgent) {
		this.useCustAgent = useCustAgent;
	}

	public String getUseLoadingPlan() {
		return useLoadingPlan;
	}

	public void setUseLoadingPlan(String useLoadingPlan) {
		this.useLoadingPlan = useLoadingPlan;
	}

	public String getUseSuppAgent() {
		return useSuppAgent;
	}

	public void setUseSuppAgent(String useSuppAgent) {
		this.useSuppAgent = useSuppAgent;
	}

	public String getVersionNo() {
		return versionNo;
	}

	public void setVersionNo(String versionNo) {
		this.versionNo = versionNo;
	}

	public String getVisaLock() {
		return visaLock;
	}

	public void setVisaLock(String visaLock) {
		this.visaLock = visaLock;
	}

	public String getWfTimeEnterval() {
		return wfTimeEnterval;
	}

	public void setWfTimeEnterval(String wfTimeEnterval) {
		this.wfTimeEnterval = wfTimeEnterval;
	}

	public String getWorkorderStktrfr() {
		return workorderStktrfr;
	}

	public void setWorkorderStktrfr(String workorderStktrfr) {
		this.workorderStktrfr = workorderStktrfr;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((BOCapprovaltoPO == null) ? 0 : BOCapprovaltoPO.hashCode());
		result = prime
				* result
				+ ((allowPdAndMsCharges == null) ? 0 : allowPdAndMsCharges
						.hashCode());
		result = prime
				* result
				+ ((approvalForOthPo == null) ? 0 : approvalForOthPo.hashCode());
		result = prime * result
				+ ((approveWo == null) ? 0 : approveWo.hashCode());
		result = prime * result + ((baseCur == null) ? 0 : baseCur.hashCode());
		result = prime
				* result
				+ ((binAllocMandatory == null) ? 0 : binAllocMandatory
						.hashCode());
		result = prime * result
				+ ((bocAppValTgt == null) ? 0 : bocAppValTgt.hashCode());
		result = prime * result
				+ ((bocEditCompcode == null) ? 0 : bocEditCompcode.hashCode());
		result = prime * result
				+ ((bocPoLock == null) ? 0 : bocPoLock.hashCode());
		result = prime * result
				+ ((bocPorqLock == null) ? 0 : bocPorqLock.hashCode());
		result = prime * result
				+ ((bocVersion == null) ? 0 : bocVersion.hashCode());
		result = prime
				* result
				+ ((bulkChequePrinting == null) ? 0 : bulkChequePrinting
						.hashCode());
		result = prime * result
				+ ((charsInglcode == null) ? 0 : charsInglcode.hashCode());
		result = prime
				* result
				+ ((checkcostsheetAppinPo == null) ? 0 : checkcostsheetAppinPo
						.hashCode());
		result = prime * result
				+ ((chkExplccompBoc == null) ? 0 : chkExplccompBoc.hashCode());
		result = prime
				* result
				+ ((cmDevidebyLifeoff == null) ? 0 : cmDevidebyLifeoff
						.hashCode());
		result = prime * result + ((cmValue == null) ? 0 : cmValue.hashCode());
		result = prime * result
				+ ((commonCompCode == null) ? 0 : commonCompCode.hashCode());
		result = prime * result
				+ ((compName == null) ? 0 : compName.hashCode());
		result = prime * result
				+ ((companyIdSeams == null) ? 0 : companyIdSeams.hashCode());
		result = prime
				* result
				+ ((consumUseWorkorder == null) ? 0 : consumUseWorkorder
						.hashCode());
		result = prime * result
				+ ((consumptionUnit == null) ? 0 : consumptionUnit.hashCode());
		result = prime
				* result
				+ ((consumptionVarience == null) ? 0 : consumptionVarience
						.hashCode());
		result = prime * result
				+ ((controlPrinting == null) ? 0 : controlPrinting.hashCode());
		result = prime
				* result
				+ ((countryUsingTops == null) ? 0 : countryUsingTops.hashCode());
		result = prime * result
				+ ((cpaMultiplePlan == null) ? 0 : cpaMultiplePlan.hashCode());
		result = prime * result
				+ ((csPrtctItmDesc == null) ? 0 : csPrtctItmDesc.hashCode());
		result = prime * result
				+ ((currencyMethod == null) ? 0 : currencyMethod.hashCode());
		result = prime * result
				+ ((cusdecPreprint == null) ? 0 : cusdecPreprint.hashCode());
		result = prime * result
				+ ((cuttingdepCode == null) ? 0 : cuttingdepCode.hashCode());
		result = prime
				* result
				+ ((cuttingticketBoccon == null) ? 0 : cuttingticketBoccon
						.hashCode());
		result = prime * result
				+ ((docOurRef == null) ? 0 : docOurRef.hashCode());
		result = prime
				* result
				+ ((editMultiUserProgramEntry == null) ? 0
						: editMultiUserProgramEntry.hashCode());
		result = prime * result
				+ ((editPurchaseLc == null) ? 0 : editPurchaseLc.hashCode());
		result = prime * result
				+ ((editableTarget == null) ? 0 : editableTarget.hashCode());
		result = prime * result
				+ ((embPlanPercent == null) ? 0 : embPlanPercent.hashCode());
		result = prime * result
				+ ((enableAudit == null) ? 0 : enableAudit.hashCode());
		result = prime * result
				+ ((enableWorkflow == null) ? 0 : enableWorkflow.hashCode());
		result = prime * result
				+ ((enhanceInventry == null) ? 0 : enhanceInventry.hashCode());
		result = prime * result
				+ ((excessIssuePcnt == null) ? 0 : excessIssuePcnt.hashCode());
		result = prime * result
				+ ((excessPoPcnt == null) ? 0 : excessPoPcnt.hashCode());
		result = prime * result
				+ ((exchangeRate == null) ? 0 : exchangeRate.hashCode());
		result = prime * result
				+ ((extdNumLayRpt == null) ? 0 : extdNumLayRpt.hashCode());
		result = prime * result
				+ ((fabricType == null) ? 0 : fabricType.hashCode());
		result = prime * result
				+ ((finStructure == null) ? 0 : finStructure.hashCode());
		result = prime * result
				+ ((finalProcess == null) ? 0 : finalProcess.hashCode());
		result = prime * result
				+ ((financeLocation == null) ? 0 : financeLocation.hashCode());
		result = prime * result
				+ ((generateAsset == null) ? 0 : generateAsset.hashCode());
		result = prime * result + ((impExp == null) ? 0 : impExp.hashCode());
		result = prime * result
				+ ((intTrfPriceEdit == null) ? 0 : intTrfPriceEdit.hashCode());
		result = prime * result
				+ ((invBocLock == null) ? 0 : invBocLock.hashCode());
		result = prime
				* result
				+ ((invUnitpriceDecimal == null) ? 0 : invUnitpriceDecimal
						.hashCode());
		result = prime
				* result
				+ ((invalidCharacters == null) ? 0 : invalidCharacters
						.hashCode());
		result = prime * result + lastRunNo;
		result = prime * result
				+ ((lineStyle == null) ? 0 : lineStyle.hashCode());
		result = prime
				* result
				+ ((loadingplanOption == null) ? 0 : loadingplanOption
						.hashCode());
		result = prime * result
				+ ((locationCode == null) ? 0 : locationCode.hashCode());
		result = prime
				* result
				+ ((locationCodeSeams == null) ? 0 : locationCodeSeams
						.hashCode());
		result = prime * result
				+ ((locationSysId == null) ? 0 : locationSysId.hashCode());
		result = prime * result
				+ ((lockBocBom == null) ? 0 : lockBocBom.hashCode());
		result = prime * result
				+ ((lockBocDates == null) ? 0 : lockBocDates.hashCode());
		result = prime
				* result
				+ ((lockCominvOthDept == null) ? 0 : lockCominvOthDept
						.hashCode());
		result = prime * result
				+ ((lockModify == null) ? 0 : lockModify.hashCode());
		result = prime * result
				+ ((mainLocation == null) ? 0 : mainLocation.hashCode());
		result = prime * result
				+ ((merchandiserApp == null) ? 0 : merchandiserApp.hashCode());
		result = prime
				* result
				+ ((modifyBOMItemCons == null) ? 0 : modifyBOMItemCons
						.hashCode());
		result = prime
				* result
				+ ((muliGrnForSupinv == null) ? 0 : muliGrnForSupinv.hashCode());
		result = prime * result
				+ ((multiStockRoom == null) ? 0 : multiStockRoom.hashCode());
		result = prime * result
				+ ((oneWoForBoc == null) ? 0 : oneWoForBoc.hashCode());
		result = prime * result
				+ ((opt1Desc == null) ? 0 : opt1Desc.hashCode());
		result = prime * result
				+ ((opt2Desc == null) ? 0 : opt2Desc.hashCode());
		result = prime * result
				+ ((opt3Desc == null) ? 0 : opt3Desc.hashCode());
		result = prime * result
				+ ((opt4Desc == null) ? 0 : opt4Desc.hashCode());
		result = prime * result
				+ ((opt5Desc == null) ? 0 : opt5Desc.hashCode());
		result = prime * result
				+ ((orderProgram == null) ? 0 : orderProgram.hashCode());
		result = prime * result
				+ ((orderbookOption == null) ? 0 : orderbookOption.hashCode());
		result = prime * result
				+ ((packlistMod == null) ? 0 : packlistMod.hashCode());
		result = prime * result
				+ ((pdLocation == null) ? 0 : pdLocation.hashCode());
		result = prime * result
				+ ((poDualApp == null) ? 0 : poDualApp.hashCode());
		result = prime
				* result
				+ ((porqDualAppForPo == null) ? 0 : porqDualAppForPo.hashCode());
		result = prime * result
				+ ((porqValBoc == null) ? 0 : porqValBoc.hashCode());
		result = prime * result
				+ ((prdProcess == null) ? 0 : prdProcess.hashCode());
		result = prime * result
				+ ((printCompHdr == null) ? 0 : printCompHdr.hashCode());
		result = prime * result
				+ ((printCusdecComp == null) ? 0 : printCusdecComp.hashCode());
		result = prime
				* result
				+ ((productionProcess == null) ? 0 : productionProcess
						.hashCode());
		result = prime
				* result
				+ ((progExcsAllowqtyPcnt == null) ? 0 : progExcsAllowqtyPcnt
						.hashCode());
		result = prime * result
				+ ((protectExchRate == null) ? 0 : protectExchRate.hashCode());
		result = prime * result + purgeNoMonths;
		result = prime * result
				+ ((qtaTrfrPer == null) ? 0 : qtaTrfrPer.hashCode());
		result = prime * result
				+ ((qtarsrvByapp == null) ? 0 : qtarsrvByapp.hashCode());
		result = prime * result
				+ ((qtyprdcdSmvof == null) ? 0 : qtyprdcdSmvof.hashCode());
		result = prime * result
				+ ((repViewUrl == null) ? 0 : repViewUrl.hashCode());
		result = prime * result
				+ ((replicateYn == null) ? 0 : replicateYn.hashCode());
		result = prime
				* result
				+ ((reportingCmValue == null) ? 0 : reportingCmValue.hashCode());
		result = prime * result
				+ ((reserveQuota == null) ? 0 : reserveQuota.hashCode());
		result = prime * result
				+ ((setZerovalue == null) ? 0 : setZerovalue.hashCode());
		result = prime
				* result
				+ ((smvBasedCostsheet == null) ? 0 : smvBasedCostsheet
						.hashCode());
		result = prime
				* result
				+ ((statusUpdateQtyCheck == null) ? 0 : statusUpdateQtyCheck
						.hashCode());
		result = prime
				* result
				+ ((stkMntendValueMethod == null) ? 0 : stkMntendValueMethod
						.hashCode());
		result = prime
				* result
				+ ((stk_Value_Startdate == null) ? 0 : stk_Value_Startdate
						.hashCode());
		result = prime
				* result
				+ ((stockTransferExcessQtyCheck == null) ? 0
						: stockTransferExcessQtyCheck.hashCode());
		result = prime
				* result
				+ ((stockUpdateinApp == null) ? 0 : stockUpdateinApp.hashCode());
		result = prime
				* result
				+ ((stockValueMechanism == null) ? 0 : stockValueMechanism
						.hashCode());
		result = prime * result
				+ ((subHoldingExt == null) ? 0 : subHoldingExt.hashCode());
		result = prime * result
				+ ((supInvBulkEntry == null) ? 0 : supInvBulkEntry.hashCode());
		result = prime * result
				+ ((supinvDtlgl == null) ? 0 : supinvDtlgl.hashCode());
		result = prime
				* result
				+ ((unitConvRateForValueBase == null) ? 0
						: unitConvRateForValueBase.hashCode());
		result = prime * result
				+ ((updateGlFromGrn == null) ? 0 : updateGlFromGrn.hashCode());
		result = prime * result
				+ ((usDollarCurCode == null) ? 0 : usDollarCurCode.hashCode());
		result = prime * result
				+ ((useCustAgent == null) ? 0 : useCustAgent.hashCode());
		result = prime * result
				+ ((useLoadingPlan == null) ? 0 : useLoadingPlan.hashCode());
		result = prime * result
				+ ((useSuppAgent == null) ? 0 : useSuppAgent.hashCode());
		result = prime * result
				+ ((versionNo == null) ? 0 : versionNo.hashCode());
		result = prime * result
				+ ((visaLock == null) ? 0 : visaLock.hashCode());
		result = prime * result
				+ ((wfTimeEnterval == null) ? 0 : wfTimeEnterval.hashCode());
		result = prime
				* result
				+ ((workorderStktrfr == null) ? 0 : workorderStktrfr.hashCode());
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
		Mstparameter other = (Mstparameter) obj;
		if (BOCapprovaltoPO == null) {
			if (other.BOCapprovaltoPO != null)
				return false;
		} else if (!BOCapprovaltoPO.equals(other.BOCapprovaltoPO))
			return false;
		if (allowPdAndMsCharges == null) {
			if (other.allowPdAndMsCharges != null)
				return false;
		} else if (!allowPdAndMsCharges.equals(other.allowPdAndMsCharges))
			return false;
		if (approvalForOthPo == null) {
			if (other.approvalForOthPo != null)
				return false;
		} else if (!approvalForOthPo.equals(other.approvalForOthPo))
			return false;
		if (approveWo == null) {
			if (other.approveWo != null)
				return false;
		} else if (!approveWo.equals(other.approveWo))
			return false;
		if (baseCur == null) {
			if (other.baseCur != null)
				return false;
		} else if (!baseCur.equals(other.baseCur))
			return false;
		if (binAllocMandatory == null) {
			if (other.binAllocMandatory != null)
				return false;
		} else if (!binAllocMandatory.equals(other.binAllocMandatory))
			return false;
		if (bocAppValTgt == null) {
			if (other.bocAppValTgt != null)
				return false;
		} else if (!bocAppValTgt.equals(other.bocAppValTgt))
			return false;
		if (bocEditCompcode == null) {
			if (other.bocEditCompcode != null)
				return false;
		} else if (!bocEditCompcode.equals(other.bocEditCompcode))
			return false;
		if (bocPoLock == null) {
			if (other.bocPoLock != null)
				return false;
		} else if (!bocPoLock.equals(other.bocPoLock))
			return false;
		if (bocPorqLock == null) {
			if (other.bocPorqLock != null)
				return false;
		} else if (!bocPorqLock.equals(other.bocPorqLock))
			return false;
		if (bocVersion == null) {
			if (other.bocVersion != null)
				return false;
		} else if (!bocVersion.equals(other.bocVersion))
			return false;
		if (bulkChequePrinting == null) {
			if (other.bulkChequePrinting != null)
				return false;
		} else if (!bulkChequePrinting.equals(other.bulkChequePrinting))
			return false;
		if (charsInglcode == null) {
			if (other.charsInglcode != null)
				return false;
		} else if (!charsInglcode.equals(other.charsInglcode))
			return false;
		if (checkcostsheetAppinPo == null) {
			if (other.checkcostsheetAppinPo != null)
				return false;
		} else if (!checkcostsheetAppinPo.equals(other.checkcostsheetAppinPo))
			return false;
		if (chkExplccompBoc == null) {
			if (other.chkExplccompBoc != null)
				return false;
		} else if (!chkExplccompBoc.equals(other.chkExplccompBoc))
			return false;
		if (cmDevidebyLifeoff == null) {
			if (other.cmDevidebyLifeoff != null)
				return false;
		} else if (!cmDevidebyLifeoff.equals(other.cmDevidebyLifeoff))
			return false;
		if (cmValue == null) {
			if (other.cmValue != null)
				return false;
		} else if (!cmValue.equals(other.cmValue))
			return false;
		if (commonCompCode == null) {
			if (other.commonCompCode != null)
				return false;
		} else if (!commonCompCode.equals(other.commonCompCode))
			return false;
		if (compName == null) {
			if (other.compName != null)
				return false;
		} else if (!compName.equals(other.compName))
			return false;
		if (companyIdSeams == null) {
			if (other.companyIdSeams != null)
				return false;
		} else if (!companyIdSeams.equals(other.companyIdSeams))
			return false;
		if (consumUseWorkorder == null) {
			if (other.consumUseWorkorder != null)
				return false;
		} else if (!consumUseWorkorder.equals(other.consumUseWorkorder))
			return false;
		if (consumptionUnit == null) {
			if (other.consumptionUnit != null)
				return false;
		} else if (!consumptionUnit.equals(other.consumptionUnit))
			return false;
		if (consumptionVarience == null) {
			if (other.consumptionVarience != null)
				return false;
		} else if (!consumptionVarience.equals(other.consumptionVarience))
			return false;
		if (controlPrinting == null) {
			if (other.controlPrinting != null)
				return false;
		} else if (!controlPrinting.equals(other.controlPrinting))
			return false;
		if (countryUsingTops == null) {
			if (other.countryUsingTops != null)
				return false;
		} else if (!countryUsingTops.equals(other.countryUsingTops))
			return false;
		if (cpaMultiplePlan == null) {
			if (other.cpaMultiplePlan != null)
				return false;
		} else if (!cpaMultiplePlan.equals(other.cpaMultiplePlan))
			return false;
		if (csPrtctItmDesc == null) {
			if (other.csPrtctItmDesc != null)
				return false;
		} else if (!csPrtctItmDesc.equals(other.csPrtctItmDesc))
			return false;
		if (currencyMethod == null) {
			if (other.currencyMethod != null)
				return false;
		} else if (!currencyMethod.equals(other.currencyMethod))
			return false;
		if (cusdecPreprint == null) {
			if (other.cusdecPreprint != null)
				return false;
		} else if (!cusdecPreprint.equals(other.cusdecPreprint))
			return false;
		if (cuttingdepCode == null) {
			if (other.cuttingdepCode != null)
				return false;
		} else if (!cuttingdepCode.equals(other.cuttingdepCode))
			return false;
		if (cuttingticketBoccon == null) {
			if (other.cuttingticketBoccon != null)
				return false;
		} else if (!cuttingticketBoccon.equals(other.cuttingticketBoccon))
			return false;
		if (docOurRef == null) {
			if (other.docOurRef != null)
				return false;
		} else if (!docOurRef.equals(other.docOurRef))
			return false;
		if (editMultiUserProgramEntry == null) {
			if (other.editMultiUserProgramEntry != null)
				return false;
		} else if (!editMultiUserProgramEntry
				.equals(other.editMultiUserProgramEntry))
			return false;
		if (editPurchaseLc == null) {
			if (other.editPurchaseLc != null)
				return false;
		} else if (!editPurchaseLc.equals(other.editPurchaseLc))
			return false;
		if (editableTarget == null) {
			if (other.editableTarget != null)
				return false;
		} else if (!editableTarget.equals(other.editableTarget))
			return false;
		if (embPlanPercent == null) {
			if (other.embPlanPercent != null)
				return false;
		} else if (!embPlanPercent.equals(other.embPlanPercent))
			return false;
		if (enableAudit == null) {
			if (other.enableAudit != null)
				return false;
		} else if (!enableAudit.equals(other.enableAudit))
			return false;
		if (enableWorkflow == null) {
			if (other.enableWorkflow != null)
				return false;
		} else if (!enableWorkflow.equals(other.enableWorkflow))
			return false;
		if (enhanceInventry == null) {
			if (other.enhanceInventry != null)
				return false;
		} else if (!enhanceInventry.equals(other.enhanceInventry))
			return false;
		if (excessIssuePcnt == null) {
			if (other.excessIssuePcnt != null)
				return false;
		} else if (!excessIssuePcnt.equals(other.excessIssuePcnt))
			return false;
		if (excessPoPcnt == null) {
			if (other.excessPoPcnt != null)
				return false;
		} else if (!excessPoPcnt.equals(other.excessPoPcnt))
			return false;
		if (exchangeRate == null) {
			if (other.exchangeRate != null)
				return false;
		} else if (!exchangeRate.equals(other.exchangeRate))
			return false;
		if (extdNumLayRpt == null) {
			if (other.extdNumLayRpt != null)
				return false;
		} else if (!extdNumLayRpt.equals(other.extdNumLayRpt))
			return false;
		if (fabricType == null) {
			if (other.fabricType != null)
				return false;
		} else if (!fabricType.equals(other.fabricType))
			return false;
		if (finStructure == null) {
			if (other.finStructure != null)
				return false;
		} else if (!finStructure.equals(other.finStructure))
			return false;
		if (finalProcess == null) {
			if (other.finalProcess != null)
				return false;
		} else if (!finalProcess.equals(other.finalProcess))
			return false;
		if (financeLocation == null) {
			if (other.financeLocation != null)
				return false;
		} else if (!financeLocation.equals(other.financeLocation))
			return false;
		if (generateAsset == null) {
			if (other.generateAsset != null)
				return false;
		} else if (!generateAsset.equals(other.generateAsset))
			return false;
		if (impExp == null) {
			if (other.impExp != null)
				return false;
		} else if (!impExp.equals(other.impExp))
			return false;
		if (intTrfPriceEdit == null) {
			if (other.intTrfPriceEdit != null)
				return false;
		} else if (!intTrfPriceEdit.equals(other.intTrfPriceEdit))
			return false;
		if (invBocLock == null) {
			if (other.invBocLock != null)
				return false;
		} else if (!invBocLock.equals(other.invBocLock))
			return false;
		if (invUnitpriceDecimal == null) {
			if (other.invUnitpriceDecimal != null)
				return false;
		} else if (!invUnitpriceDecimal.equals(other.invUnitpriceDecimal))
			return false;
		if (invalidCharacters == null) {
			if (other.invalidCharacters != null)
				return false;
		} else if (!invalidCharacters.equals(other.invalidCharacters))
			return false;
		if (lastRunNo != other.lastRunNo)
			return false;
		if (lineStyle == null) {
			if (other.lineStyle != null)
				return false;
		} else if (!lineStyle.equals(other.lineStyle))
			return false;
		if (loadingplanOption == null) {
			if (other.loadingplanOption != null)
				return false;
		} else if (!loadingplanOption.equals(other.loadingplanOption))
			return false;
		if (locationCode == null) {
			if (other.locationCode != null)
				return false;
		} else if (!locationCode.equals(other.locationCode))
			return false;
		if (locationCodeSeams == null) {
			if (other.locationCodeSeams != null)
				return false;
		} else if (!locationCodeSeams.equals(other.locationCodeSeams))
			return false;
		if (locationSysId == null) {
			if (other.locationSysId != null)
				return false;
		} else if (!locationSysId.equals(other.locationSysId))
			return false;
		if (lockBocBom == null) {
			if (other.lockBocBom != null)
				return false;
		} else if (!lockBocBom.equals(other.lockBocBom))
			return false;
		if (lockBocDates == null) {
			if (other.lockBocDates != null)
				return false;
		} else if (!lockBocDates.equals(other.lockBocDates))
			return false;
		if (lockCominvOthDept == null) {
			if (other.lockCominvOthDept != null)
				return false;
		} else if (!lockCominvOthDept.equals(other.lockCominvOthDept))
			return false;
		if (lockModify == null) {
			if (other.lockModify != null)
				return false;
		} else if (!lockModify.equals(other.lockModify))
			return false;
		if (mainLocation == null) {
			if (other.mainLocation != null)
				return false;
		} else if (!mainLocation.equals(other.mainLocation))
			return false;
		if (merchandiserApp == null) {
			if (other.merchandiserApp != null)
				return false;
		} else if (!merchandiserApp.equals(other.merchandiserApp))
			return false;
		if (modifyBOMItemCons == null) {
			if (other.modifyBOMItemCons != null)
				return false;
		} else if (!modifyBOMItemCons.equals(other.modifyBOMItemCons))
			return false;
		if (muliGrnForSupinv == null) {
			if (other.muliGrnForSupinv != null)
				return false;
		} else if (!muliGrnForSupinv.equals(other.muliGrnForSupinv))
			return false;
		if (multiStockRoom == null) {
			if (other.multiStockRoom != null)
				return false;
		} else if (!multiStockRoom.equals(other.multiStockRoom))
			return false;
		if (oneWoForBoc == null) {
			if (other.oneWoForBoc != null)
				return false;
		} else if (!oneWoForBoc.equals(other.oneWoForBoc))
			return false;
		if (opt1Desc == null) {
			if (other.opt1Desc != null)
				return false;
		} else if (!opt1Desc.equals(other.opt1Desc))
			return false;
		if (opt2Desc == null) {
			if (other.opt2Desc != null)
				return false;
		} else if (!opt2Desc.equals(other.opt2Desc))
			return false;
		if (opt3Desc == null) {
			if (other.opt3Desc != null)
				return false;
		} else if (!opt3Desc.equals(other.opt3Desc))
			return false;
		if (opt4Desc == null) {
			if (other.opt4Desc != null)
				return false;
		} else if (!opt4Desc.equals(other.opt4Desc))
			return false;
		if (opt5Desc == null) {
			if (other.opt5Desc != null)
				return false;
		} else if (!opt5Desc.equals(other.opt5Desc))
			return false;
		if (orderProgram == null) {
			if (other.orderProgram != null)
				return false;
		} else if (!orderProgram.equals(other.orderProgram))
			return false;
		if (orderbookOption == null) {
			if (other.orderbookOption != null)
				return false;
		} else if (!orderbookOption.equals(other.orderbookOption))
			return false;
		if (packlistMod == null) {
			if (other.packlistMod != null)
				return false;
		} else if (!packlistMod.equals(other.packlistMod))
			return false;
		if (pdLocation == null) {
			if (other.pdLocation != null)
				return false;
		} else if (!pdLocation.equals(other.pdLocation))
			return false;
		if (poDualApp == null) {
			if (other.poDualApp != null)
				return false;
		} else if (!poDualApp.equals(other.poDualApp))
			return false;
		if (porqDualAppForPo == null) {
			if (other.porqDualAppForPo != null)
				return false;
		} else if (!porqDualAppForPo.equals(other.porqDualAppForPo))
			return false;
		if (porqValBoc == null) {
			if (other.porqValBoc != null)
				return false;
		} else if (!porqValBoc.equals(other.porqValBoc))
			return false;
		if (prdProcess == null) {
			if (other.prdProcess != null)
				return false;
		} else if (!prdProcess.equals(other.prdProcess))
			return false;
		if (printCompHdr == null) {
			if (other.printCompHdr != null)
				return false;
		} else if (!printCompHdr.equals(other.printCompHdr))
			return false;
		if (printCusdecComp == null) {
			if (other.printCusdecComp != null)
				return false;
		} else if (!printCusdecComp.equals(other.printCusdecComp))
			return false;
		if (productionProcess == null) {
			if (other.productionProcess != null)
				return false;
		} else if (!productionProcess.equals(other.productionProcess))
			return false;
		if (progExcsAllowqtyPcnt == null) {
			if (other.progExcsAllowqtyPcnt != null)
				return false;
		} else if (!progExcsAllowqtyPcnt.equals(other.progExcsAllowqtyPcnt))
			return false;
		if (protectExchRate == null) {
			if (other.protectExchRate != null)
				return false;
		} else if (!protectExchRate.equals(other.protectExchRate))
			return false;
		if (purgeNoMonths != other.purgeNoMonths)
			return false;
		if (qtaTrfrPer == null) {
			if (other.qtaTrfrPer != null)
				return false;
		} else if (!qtaTrfrPer.equals(other.qtaTrfrPer))
			return false;
		if (qtarsrvByapp == null) {
			if (other.qtarsrvByapp != null)
				return false;
		} else if (!qtarsrvByapp.equals(other.qtarsrvByapp))
			return false;
		if (qtyprdcdSmvof == null) {
			if (other.qtyprdcdSmvof != null)
				return false;
		} else if (!qtyprdcdSmvof.equals(other.qtyprdcdSmvof))
			return false;
		if (repViewUrl == null) {
			if (other.repViewUrl != null)
				return false;
		} else if (!repViewUrl.equals(other.repViewUrl))
			return false;
		if (replicateYn == null) {
			if (other.replicateYn != null)
				return false;
		} else if (!replicateYn.equals(other.replicateYn))
			return false;
		if (reportingCmValue == null) {
			if (other.reportingCmValue != null)
				return false;
		} else if (!reportingCmValue.equals(other.reportingCmValue))
			return false;
		if (reserveQuota == null) {
			if (other.reserveQuota != null)
				return false;
		} else if (!reserveQuota.equals(other.reserveQuota))
			return false;
		if (setZerovalue == null) {
			if (other.setZerovalue != null)
				return false;
		} else if (!setZerovalue.equals(other.setZerovalue))
			return false;
		if (smvBasedCostsheet == null) {
			if (other.smvBasedCostsheet != null)
				return false;
		} else if (!smvBasedCostsheet.equals(other.smvBasedCostsheet))
			return false;
		if (statusUpdateQtyCheck == null) {
			if (other.statusUpdateQtyCheck != null)
				return false;
		} else if (!statusUpdateQtyCheck.equals(other.statusUpdateQtyCheck))
			return false;
		if (stkMntendValueMethod == null) {
			if (other.stkMntendValueMethod != null)
				return false;
		} else if (!stkMntendValueMethod.equals(other.stkMntendValueMethod))
			return false;
		if (stk_Value_Startdate == null) {
			if (other.stk_Value_Startdate != null)
				return false;
		} else if (!stk_Value_Startdate.equals(other.stk_Value_Startdate))
			return false;
		if (stockTransferExcessQtyCheck == null) {
			if (other.stockTransferExcessQtyCheck != null)
				return false;
		} else if (!stockTransferExcessQtyCheck
				.equals(other.stockTransferExcessQtyCheck))
			return false;
		if (stockUpdateinApp == null) {
			if (other.stockUpdateinApp != null)
				return false;
		} else if (!stockUpdateinApp.equals(other.stockUpdateinApp))
			return false;
		if (stockValueMechanism == null) {
			if (other.stockValueMechanism != null)
				return false;
		} else if (!stockValueMechanism.equals(other.stockValueMechanism))
			return false;
		if (subHoldingExt == null) {
			if (other.subHoldingExt != null)
				return false;
		} else if (!subHoldingExt.equals(other.subHoldingExt))
			return false;
		if (supInvBulkEntry == null) {
			if (other.supInvBulkEntry != null)
				return false;
		} else if (!supInvBulkEntry.equals(other.supInvBulkEntry))
			return false;
		if (supinvDtlgl == null) {
			if (other.supinvDtlgl != null)
				return false;
		} else if (!supinvDtlgl.equals(other.supinvDtlgl))
			return false;
		if (unitConvRateForValueBase == null) {
			if (other.unitConvRateForValueBase != null)
				return false;
		} else if (!unitConvRateForValueBase
				.equals(other.unitConvRateForValueBase))
			return false;
		if (updateGlFromGrn == null) {
			if (other.updateGlFromGrn != null)
				return false;
		} else if (!updateGlFromGrn.equals(other.updateGlFromGrn))
			return false;
		if (usDollarCurCode == null) {
			if (other.usDollarCurCode != null)
				return false;
		} else if (!usDollarCurCode.equals(other.usDollarCurCode))
			return false;
		if (useCustAgent == null) {
			if (other.useCustAgent != null)
				return false;
		} else if (!useCustAgent.equals(other.useCustAgent))
			return false;
		if (useLoadingPlan == null) {
			if (other.useLoadingPlan != null)
				return false;
		} else if (!useLoadingPlan.equals(other.useLoadingPlan))
			return false;
		if (useSuppAgent == null) {
			if (other.useSuppAgent != null)
				return false;
		} else if (!useSuppAgent.equals(other.useSuppAgent))
			return false;
		if (versionNo == null) {
			if (other.versionNo != null)
				return false;
		} else if (!versionNo.equals(other.versionNo))
			return false;
		if (visaLock == null) {
			if (other.visaLock != null)
				return false;
		} else if (!visaLock.equals(other.visaLock))
			return false;
		if (wfTimeEnterval == null) {
			if (other.wfTimeEnterval != null)
				return false;
		} else if (!wfTimeEnterval.equals(other.wfTimeEnterval))
			return false;
		if (workorderStktrfr == null) {
			if (other.workorderStktrfr != null)
				return false;
		} else if (!workorderStktrfr.equals(other.workorderStktrfr))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Mstparameter [compName=").append(compName)
				.append(", allowPdAndMsCharges=").append(allowPdAndMsCharges)
				.append(", approvalForOthPo=").append(approvalForOthPo)
				.append(", approveWo=").append(approveWo).append(", baseCur=")
				.append(baseCur).append(", binAllocMandatory=")
				.append(binAllocMandatory).append(", bocAppValTgt=")
				.append(bocAppValTgt).append(", BOCapprovaltoPO=")
				.append(BOCapprovaltoPO).append(", bocEditCompcode=")
				.append(bocEditCompcode).append(", bocPoLock=")
				.append(bocPoLock).append(", bocPorqLock=").append(bocPorqLock)
				.append(", bocVersion=").append(bocVersion)
				.append(", bulkChequePrinting=").append(bulkChequePrinting)
				.append(", charsInglcode=").append(charsInglcode)
				.append(", currencyMethod=").append(currencyMethod)
				.append(", checkcostsheetAppinPo=")
				.append(checkcostsheetAppinPo).append(", chkExplccompBoc=")
				.append(chkExplccompBoc).append(", cmDevidebyLifeoff=")
				.append(cmDevidebyLifeoff).append(", cmValue=").append(cmValue)
				.append(", commonCompCode=").append(commonCompCode)
				.append(", companyIdSeams=").append(companyIdSeams)
				.append(", consumUseWorkorder=").append(consumUseWorkorder)
				.append(", consumptionUnit=").append(consumptionUnit)
				.append(", consumptionVarience=").append(consumptionVarience)
				.append(", controlPrinting=").append(controlPrinting)
				.append(", countryUsingTops=").append(countryUsingTops)
				.append(", cpaMultiplePlan=").append(cpaMultiplePlan)
				.append(", csPrtctItmDesc=").append(csPrtctItmDesc)
				.append(", cusdecPreprint=").append(cusdecPreprint)
				.append(", cuttingdepCode=").append(cuttingdepCode)
				.append(", cuttingticketBoccon=").append(cuttingticketBoccon)
				.append(", docOurRef=").append(docOurRef)
				.append(", editMultiUserProgramEntry=")
				.append(editMultiUserProgramEntry).append(", editPurchaseLc=")
				.append(editPurchaseLc).append(", editableTarget=")
				.append(editableTarget).append(", embPlanPercent=")
				.append(embPlanPercent).append(", enableAudit=")
				.append(enableAudit).append(", enableWorkflow=")
				.append(enableWorkflow).append(", enhanceInventry=")
				.append(enhanceInventry).append(", excessIssuePcnt=")
				.append(excessIssuePcnt).append(", excessPoPcnt=")
				.append(excessPoPcnt).append(", exchangeRate=")
				.append(exchangeRate).append(", extdNumLayRpt=")
				.append(extdNumLayRpt).append(", fabricType=")
				.append(fabricType).append(", finStructure=")
				.append(finStructure).append(", finalProcess=")
				.append(finalProcess).append(", financeLocation=")
				.append(financeLocation).append(", generateAsset=")
				.append(generateAsset).append(", impExp=").append(impExp)
				.append(", intTrfPriceEdit=").append(intTrfPriceEdit)
				.append(", invBocLock=").append(invBocLock)
				.append(", invUnitpriceDecimal=").append(invUnitpriceDecimal)
				.append(", invalidCharacters=").append(invalidCharacters)
				.append(", lastRunNo=").append(lastRunNo)
				.append(", lineStyle=").append(lineStyle)
				.append(", loadingplanOption=").append(loadingplanOption)
				.append(", locationCode=").append(locationCode)
				.append(", locationCodeSeams=").append(locationCodeSeams)
				.append(", locationSysId=").append(locationSysId)
				.append(", lockBocBom=").append(lockBocBom)
				.append(", lockBocDates=").append(lockBocDates)
				.append(", lockCominvOthDept=").append(lockCominvOthDept)
				.append(", lockModify=").append(lockModify)
				.append(", mainLocation=").append(mainLocation)
				.append(", merchandiserApp=").append(merchandiserApp)
				.append(", modifyBOMItemCons=").append(modifyBOMItemCons)
				.append(", muliGrnForSupinv=").append(muliGrnForSupinv)
				.append(", multiStockRoom=").append(multiStockRoom)
				.append(", oneWoForBoc=").append(oneWoForBoc)
				.append(", opt1Desc=").append(opt1Desc).append(", opt2Desc=")
				.append(opt2Desc).append(", opt3Desc=").append(opt3Desc)
				.append(", opt4Desc=").append(opt4Desc).append(", opt5Desc=")
				.append(opt5Desc).append(", orderProgram=")
				.append(orderProgram).append(", orderbookOption=")
				.append(orderbookOption).append(", packlistMod=")
				.append(packlistMod).append(", pdLocation=").append(pdLocation)
				.append(", poDualApp=").append(poDualApp)
				.append(", porqDualAppForPo=").append(porqDualAppForPo)
				.append(", porqValBoc=").append(porqValBoc)
				.append(", prdProcess=").append(prdProcess)
				.append(", printCompHdr=").append(printCompHdr)
				.append(", printCusdecComp=").append(printCusdecComp)
				.append(", productionProcess=").append(productionProcess)
				.append(", progExcsAllowqtyPcnt=").append(progExcsAllowqtyPcnt)
				.append(", protectExchRate=").append(protectExchRate)
				.append(", purgeNoMonths=").append(purgeNoMonths)
				.append(", qtaTrfrPer=").append(qtaTrfrPer)
				.append(", qtarsrvByapp=").append(qtarsrvByapp)
				.append(", qtyprdcdSmvof=").append(qtyprdcdSmvof)
				.append(", repViewUrl=").append(repViewUrl)
				.append(", replicateYn=").append(replicateYn)
				.append(", reportingCmValue=").append(reportingCmValue)
				.append(", reserveQuota=").append(reserveQuota)
				.append(", setZerovalue=").append(setZerovalue)
				.append(", smvBasedCostsheet=").append(smvBasedCostsheet)
				.append(", statusUpdateQtyCheck=").append(statusUpdateQtyCheck)
				.append(", stkMntendValueMethod=").append(stkMntendValueMethod)
				.append(", stk_Value_Startdate=").append(stk_Value_Startdate)
				.append(", stockTransferExcessQtyCheck=")
				.append(stockTransferExcessQtyCheck)
				.append(", stockUpdateinApp=").append(stockUpdateinApp)
				.append(", stockValueMechanism=").append(stockValueMechanism)
				.append(", subHoldingExt=").append(subHoldingExt)
				.append(", supInvBulkEntry=").append(supInvBulkEntry)
				.append(", supinvDtlgl=").append(supinvDtlgl)
				.append(", unitConvRateForValueBase=")
				.append(unitConvRateForValueBase).append(", updateGlFromGrn=")
				.append(updateGlFromGrn).append(", usDollarCurCode=")
				.append(usDollarCurCode).append(", useCustAgent=")
				.append(useCustAgent).append(", useLoadingPlan=")
				.append(useLoadingPlan).append(", useSuppAgent=")
				.append(useSuppAgent).append(", versionNo=").append(versionNo)
				.append(", visaLock=").append(visaLock)
				.append(", wfTimeEnterval=").append(wfTimeEnterval)
				.append(", workorderStktrfr=").append(workorderStktrfr)
				.append("]");
		return builder.toString();
	}

}