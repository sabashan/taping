package com.excelsoft.webapp.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.excelsoft.dao.SearchException;
import com.excelsoft.model.Mercostsheetdemmap;
import com.excelsoft.model.Mercostsheetgroup;
import com.excelsoft.model.Mercostsheetgroupcolor;
import com.excelsoft.model.Mercostsheetgroupdemmap;
import com.excelsoft.model.Mercostsheetgroupsetting;
import com.excelsoft.model.Mercostsheethdr;
import com.excelsoft.model.MercostsheethdrId;
import com.excelsoft.model.Merprecostsheet;
import com.excelsoft.model.Mstparameter;
import com.excelsoft.model.Mststyledem;
import com.excelsoft.model.MststyledemId;
import com.excelsoft.model.Mststyledemmap;
import com.excelsoft.model.MststyledemmapId;
import com.excelsoft.model.Mststyleheader;
import com.excelsoft.service.MercostsheetcountryManager;
import com.excelsoft.service.MercostsheetcurrencyManager;
import com.excelsoft.service.MercostsheetdemmapManager;
import com.excelsoft.service.MercostsheetgroupManager;
import com.excelsoft.service.MercostsheetgroupcolorManager;
import com.excelsoft.service.MercostsheetgroupdemmapManager;
import com.excelsoft.service.MercostsheetgroupsettingManager;
import com.excelsoft.service.MercostsheethdrManager;
import com.excelsoft.service.MercostsheetrowmaterialManager;
import com.excelsoft.service.MercostsheetsmvManager;
import com.excelsoft.service.MerprecostsheetManager;
import com.excelsoft.service.MerprecostsheetrowmaterialsManager;
import com.excelsoft.service.MstcurrencyManager;
import com.excelsoft.service.MstgencodesManager;
import com.excelsoft.service.MstlocationManager;
import com.excelsoft.service.MstnumbersManager;
import com.excelsoft.service.MstparameterManager;
import com.excelsoft.service.MststylecomponentManager;
import com.excelsoft.service.MststyledemManager;
import com.excelsoft.service.MststyledemmapManager;
import com.excelsoft.service.MststyleheaderManager;
import com.excelsoft.service.MststylerouteManager;
import com.excelsoft.service.MstsupplierManager;
import com.excelsoft.util.ConvertUtil;

@Controller
@RequestMapping("/mercostsheethdrview*")
public class MercostsheethdrviewController extends BaseFormController {
	private MercostsheethdrManager mercostsheethdrManager = null;
    private MercostsheetcurrencyManager mercostsheetcurrencyManager=null;
    private MercostsheetrowmaterialManager mercostsheetrowmaterialManager=null;
	private MercostsheetdemmapManager mercostsheetdemmapManager = null;
    private MercostsheetsmvManager mercostsheetsmvManager=null;
  	private MercostsheetgroupManager mercostsheetgroupManager=null;
  	private MercostsheetgroupsettingManager mercostsheetgroupsettingManager=null;
    private MercostsheetcountryManager mercostsheetcountryManager = null;
    private MercostsheetgroupdemmapManager mercostsheetgroupdemmapManager = null;
	private MercostsheetgroupcolorManager mercostsheetgroupcolorManager = null;
	private Mstparameter mstparameter=new Mstparameter();
	
	private MerprecostsheetManager merprecostsheetManager=null;
	private MerprecostsheetrowmaterialsManager merprecostsheetrowmaterialsManager=null;
	
	private MstnumbersManager mstnumbersManager=null;
    private MstparameterManager mstparametermanager =null;
    private MstcurrencyManager mstcurrencyManager=null;
    private MstgencodesManager mstgencodesManager =null;
    private MstlocationManager mstlocationManager=null;
    private MstsupplierManager  mstsupplierManager=null;
     
    private MststylecomponentManager mststylecomponentManager=null;
    private MststyleheaderManager mststyleheaderManager=null;
    private MststyledemManager mststyledemManager = null;
    private MststyledemmapManager mststyledemmapManager = null;
    private MststylerouteManager mststylerouteManager=null;
//    private String location="";
//    final short programID=4007;
//    final String trntype="FCST";
//    final String trnGroupType="FCSG";
//    private String flag ="Incomplete";
    
    
    @Autowired
    public void setMerprecostsheetrowmaterialsManager(
			MerprecostsheetrowmaterialsManager merprecostsheetrowmaterialsManager) {
		this.merprecostsheetrowmaterialsManager = merprecostsheetrowmaterialsManager;
	}

	@Autowired
    public void setMststylerouteManager(MststylerouteManager mststylerouteManager) {
		this.mststylerouteManager = mststylerouteManager;
	}
    
    @Autowired
	public void setMstsupplierManager(MstsupplierManager mstsupplierManager) {
		this.mstsupplierManager = mstsupplierManager;
	}

	@Autowired
    public void setMerprecostsheetManager(
			MerprecostsheetManager merprecostsheetManager) {
		this.merprecostsheetManager = merprecostsheetManager;
	}
	@Autowired
	public void setMercostsheetgroupsettingManager(
			MercostsheetgroupsettingManager mercostsheetgroupsettingManager) {
		this.mercostsheetgroupsettingManager = mercostsheetgroupsettingManager;
	}
	@Autowired
	public void setMercostsheetgroupManager(
			MercostsheetgroupManager mercostsheetgroupManager) {
		this.mercostsheetgroupManager = mercostsheetgroupManager;
	}
	@Autowired
    public void setMercostsheetcurrencyManager(
			MercostsheetcurrencyManager mercostsheetcurrencyManager) {
		this.mercostsheetcurrencyManager = mercostsheetcurrencyManager;
	}
    @Autowired
	public void setMercostsheetrowmaterialManager(
			MercostsheetrowmaterialManager mercostsheetrowmaterialManager) {
		this.mercostsheetrowmaterialManager = mercostsheetrowmaterialManager;
	}
    @Autowired
	public void setMercostsheetsmvManager(
			MercostsheetsmvManager mercostsheetsmvManager) {
		this.mercostsheetsmvManager = mercostsheetsmvManager;
	}
	@Autowired
    public void setMercostsheethdrManager(MercostsheethdrManager mercostsheethdrManager) {
        this.mercostsheethdrManager = mercostsheethdrManager;
    }
    @Autowired
    public void setMstgencodesManager(MstgencodesManager mstgencodesManager) {
		this.mstgencodesManager = mstgencodesManager;
	}
    @Autowired
	public void setMercostsheetdemmapManager(
			MercostsheetdemmapManager mercostsheetdemmapManager) {
		this.mercostsheetdemmapManager = mercostsheetdemmapManager;
	}

    @Autowired
    public void setMstparametermanager(MstparameterManager mstparametermanager) {
		this.mstparametermanager = mstparametermanager;
	}
    @Autowired
	public void setMstcurrencyManager(MstcurrencyManager mstcurrencyManager) {
		this.mstcurrencyManager = mstcurrencyManager;
	}
	
    @Autowired
    public void setMstnumbersManager(
			MstnumbersManager mstnumbersManager) {
		this.mstnumbersManager = mstnumbersManager;
	}
    @Autowired
    public void setMstlocationManager(MstlocationManager mstlocationManager) {
		this.mstlocationManager = mstlocationManager;
	}
    @Autowired
	public void setMststyleheaderManager(MststyleheaderManager mststyleheaderManager) {
		this.mststyleheaderManager = mststyleheaderManager;
	}

    @Autowired
    public void setMststylecomponentManager(MststylecomponentManager mststylecomponentManager) {
        this.mststylecomponentManager = mststylecomponentManager;
    }
    @Autowired
	public void setMststyledemManager(MststyledemManager mststyledemManager) {
		this.mststyledemManager = mststyledemManager;
	}
    @Autowired
	public void setMststyledemmapManager(MststyledemmapManager mststyledemmapManager) {
		this.mststyledemmapManager = mststyledemmapManager;
	}
    @Autowired
	public void setMercostsheetcountryManager(MercostsheetcountryManager mercostsheetcountryManager) {
		this.mercostsheetcountryManager = mercostsheetcountryManager;
	}

    @Autowired
	public void setMercostsheetgroupcolorManager(MercostsheetgroupcolorManager mercostsheetgroupcolorManager) {
		this.mercostsheetgroupcolorManager = mercostsheetgroupcolorManager;
	}
    @Autowired
	public void setMercostsheetgroupdemmapManager(MercostsheetgroupdemmapManager mercostsheetgroupdemmapManager) {
		this.mercostsheetgroupdemmapManager = mercostsheetgroupdemmapManager;
	}
    
    
	public MercostsheethdrviewController() {
		setCancelView("redirect:mercostsheethdrview");
        setSuccessView("redirect:mercostsheethdrview");
	}

	@ModelAttribute
    @RequestMapping(method = RequestMethod.GET)
    protected Model showForm(HttpServletRequest request) throws Exception {
		Model model = new ExtendedModelMap();
		
		String costSheetNo = request.getParameter("costSheetNo");
        String costSheetType = request.getParameter("costSheetType");
        String sversionNo = request.getParameter("versionNo");
        
        try {
	        model.addAttribute("mstitemtypeCatogory",mstgencodesManager.getcode("ITMCAT"));
	        log.debug("mst-item type Catogory : "+ model); 
        }
    	catch (SearchException se) {
	        model.addAttribute("Item Catogory  Error", se.getMessage());
	        log.debug(se.getMessage());  
	    }
        Mercostsheethdr mercostsheethdr = new Mercostsheethdr();
        Merprecostsheet merprecostsheet = new Merprecostsheet();
        Mststyleheader mststyleheader = null;
        // check is parameters blank
        if (!StringUtils.isBlank(costSheetNo) && !StringUtils.isBlank(sversionNo) && !StringUtils.isBlank(costSheetType)) {
        	log.debug("With cost sheet");  
        	
        	try {
        		// convert string to long
        		BigDecimal versionNo=ConvertUtil.getDecimal(sversionNo);
//        		if(sversionNo.equals("0")){
        		// get costsheethdr
	        		mercostsheethdr = mercostsheethdrManager.get(new MercostsheethdrId(costSheetNo, versionNo,costSheetType));
	        		if(mercostsheethdr.getId().getCostSheetNo().equals(costSheetNo)){
	    				// add cost sheet to model
		        		mststyleheader = mercostsheethdrManager.getStyle(new MercostsheethdrId(costSheetNo, versionNo,costSheetType));
		        		// add line efficiency using location
		        		model.addAttribute("mststyleheader",mststyleheader);
		        		model.addAttribute("Lineeff",mstlocationManager.get(mststyleheader.getId().getLocationCode()).getMinuteValue());
		        		// get component list 
		        		model.addAttribute("mststylecomponentList", mststylecomponentManager.getAll(mststyleheader));
		        		model.addAttribute("mercostsheethdrcurrencyList",mercostsheetcurrencyManager.getAll(mercostsheethdr));
		        		model.addAttribute("mercostsheethdrcountryList",mercostsheetcountryManager.getAll(mercostsheethdr));
		        		// get smv list
	        			model.addAttribute("mercostsheethdrsmvList",mercostsheetsmvManager.getAll(mercostsheethdr));
	        			try{
	        			model.addAttribute("rowmaterials",mercostsheetrowmaterialManager.getAllShell(mercostsheethdr, "FABRIC"));
        			}catch(Exception e){
        				log.debug(e.toString());
        			}
	        			
        			merprecostsheet = new Merprecostsheet();
        			try{
        				merprecostsheet = mercostsheethdrManager.getprecostsheet(mercostsheethdr.getId());
        			}catch(Exception e){
        				log.debug(e);
        			}
        		}
	    		else{
	            	log.debug("With no Costsheet"); 
	            	model.addAttribute("NO", "NO");
	            }
//        		}
//        		else{
//               	 	log.debug("With none editable Costsheet" + versionNo); 
//               	 	model.addAttribute("NO", "NO");
//                }
        	} catch (SearchException se) {
 	            model.addAttribute("searchError", se.getMessage());
 	            log.debug(se.getMessage());  
 	        }
        	model.addAttribute(mercostsheethdr);
        	
        	//Add style dimensions and dimension values
        	List<Mststyledem> mststyledems = new ArrayList<Mststyledem>();
        	List<Mststyledemmap> mststyledemmaps = new ArrayList<Mststyledemmap>();
        	
        	List<Mercostsheetdemmap> mercostsheetdemmaps = new ArrayList<Mercostsheetdemmap>();
        	try{
        		
        		mercostsheetdemmaps = mercostsheetdemmapManager.getDemmapsFromCosting(mercostsheethdr);
        		log.debug(mercostsheetdemmaps.toString());
        		String[][] demTypesHori = new String[mercostsheetdemmaps.size()][2];
        		String[][] demTypesVerti = new String[mercostsheetdemmaps.size()][2];
        		int i = 0;
        		for (Iterator iterator = mercostsheetdemmaps.iterator(); iterator.hasNext();) {
					Mercostsheetdemmap mercostsheetdemmap = (Mercostsheetdemmap) iterator.next();
					
					demTypesHori[i][0] = mercostsheetdemmap.getId().getDemType2();
					demTypesHori[i][1] = mercostsheetdemmap.getId().getDemValue2();
					demTypesVerti[i][0] = mercostsheetdemmap.getId().getDemType1();
					demTypesVerti[i][1] = mercostsheetdemmap.getId().getDemValue1();
					/*MststyledemId mststyledemId = new MststyledemId(demType, mststyleheader.getId().getStyleId(),
							mststyleheader.getId().getLocationCode(), mststyleheader.getId().getCompCode(),
							mststyleheader.getId().getCustCode(), mststyleheader.getId().getDepCode(), demValue);
					Mststyledem mststyledem = new Mststyledem(mststyledemId, mststyleheader, dimention);
					mststyledems.add(mststyledem);*/
					MststyledemmapId mststyledemmapId = new MststyledemmapId(mststyleheader.getId().getStyleId(),
							mststyleheader.getId().getLocationCode(), mststyleheader.getId().getCompCode(), mststyleheader.getId().getCustCode(),
							mststyleheader.getId().getDepCode(), mercostsheetdemmap.getId().getDemType1(), mercostsheetdemmap.getId().getDemType2(),
							mercostsheetdemmap.getId().getDemValue1(), mercostsheetdemmap.getId().getDemValue2(), mercostsheetdemmap.getId().getMainColor());
					Mststyledemmap mststyledemmap = new Mststyledemmap(mststyledemmapId, mststyleheader);
					//mststyledemmaps.add(mststyledemmap);
					log.debug(mercostsheetdemmap.toString());
					i++;
				}
        		
        		mststyledems = mststyledemManager.getAll(mststyleheader);
        		mststyledemmaps = mststyledemmapManager.getAll(mststyleheader);
            }
        	catch(Exception e){
        		log.debug(e);
        		
        	}
        	
        	if(mststyleheader != null && mercostsheetdemmaps.isEmpty()){
        		mststyledems = mststyledemManager.getAll(mststyleheader);
        		mststyledemmaps = mststyledemmapManager.getAll(mststyleheader);
        	}
        	model.addAttribute("mststyledems", mststyledems);
        	model.addAttribute("mststyledemmaps", mststyledemmaps);
        	//add groups for model 
        	model.addAttribute("groups", getGroups(request));
        	/** hard corded precostsheet ** removed */
        	//merprecostsheet = merprecostsheetManager.get(new MerprecostsheetId("1", new BigDecimal(0), "HC"));
        	model.addAttribute("merprecostsheet", merprecostsheet);
        	
        }
		return model;
	}
	
	private String getGroups(HttpServletRequest request) throws Exception {
		String costSheetNo = request.getParameter("costSheetNo");
        String costSheetType = request.getParameter("costSheetType");
        String versionNo = request.getParameter("versionNo");
        Mercostsheethdr mercostsheethdr = new Mercostsheethdr();
        
        String groups = new String();
        if (!StringUtils.isBlank(costSheetNo) && !StringUtils.isBlank(versionNo) && !StringUtils.isBlank(costSheetType)) {
        	try {
        		BigDecimal bversionNo=ConvertUtil.getDecimal(versionNo);
        		//get cost sheet using params
        		mercostsheethdr = mercostsheethdrManager.get(new MercostsheethdrId(costSheetNo, bversionNo, costSheetType));
        		log.debug(mercostsheethdr.toString());
        		if(mercostsheethdr.getId().getCostSheetNo().equalsIgnoreCase(costSheetNo)){
        			//get cost sheet groups using cost sheet
        			List<Mercostsheetgroup> mercostsheetgroups = mercostsheetgroupManager.getAll(costSheetNo, versionNo, costSheetType);
        			int groupId = mercostsheetgroups.size();
        			for (Iterator iterator = mercostsheetgroups.iterator(); iterator.hasNext();) {
						Mercostsheetgroup mercostsheetgroup = (Mercostsheetgroup) iterator.next();

						//get cost sheet group settings using cost sheet groups
						List<Mercostsheetgroupsetting> mercostsheetgroupsettings = mercostsheetgroupsettingManager.getAll(mercostsheetgroup);
						
						int SettingId = mercostsheetgroupsettings.size();
						String groupSetting = "";
						for (Iterator iterator2 = mercostsheetgroupsettings.iterator(); iterator2.hasNext();) {
							Mercostsheetgroupsetting mercostsheetgroupsetting = (Mercostsheetgroupsetting) iterator2.next();
							
							List<Mercostsheetgroupdemmap> mercostsheetgroupdemmaps = mercostsheetgroupdemmapManager.getAll(mercostsheetgroupsetting);
							String demmaps = "";
							//get cost sheet group demmaps using cost sheet group settings
							int i = mercostsheetgroupdemmaps.size();
							for (Iterator iterator3 = mercostsheetgroupdemmaps.iterator(); iterator3.hasNext();) {
								Mercostsheetgroupdemmap mercostsheetgroupdemmap = (Mercostsheetgroupdemmap) iterator3.next();

								demmaps += mercostsheetgroup.getCountry()+":"+mercostsheetgroupsetting.getComponent()+":"+mercostsheetgroupdemmap.getColor()+":"+
										mercostsheetgroupdemmap.getId().getVerticalDem()+":"+mercostsheetgroupdemmap.getId().getHorizontalDem();
								i--;
								if(i != 0){
									demmaps += ",";
								}
							}
							//get cost sheet group colors using cost sheet group settings
							List<Mercostsheetgroupcolor> mercostsheetgroupcolors = mercostsheetgroupcolorManager.getAll(mercostsheetgroupsetting);
							String colors = "";
							i = mercostsheetgroupcolors.size();
							for (Iterator iterator3 = mercostsheetgroupcolors.iterator(); iterator3.hasNext();) {
								Mercostsheetgroupcolor mercostsheetgroupcolor = (Mercostsheetgroupcolor) iterator3.next();
								colors += ""+mercostsheetgroupcolor.getId().getColor()+"";
								i--;
								if(i != 0){
									colors += ",";
								}
							}
							
							groupSetting += mercostsheetgroupsetting.getLineNo()+","+mercostsheetgroupsetting.getComponent()+"_"+
									colors+"_"+demmaps;
							SettingId--;
							if(SettingId != 0){
								groupSetting += "*";
							}
						}
						log.debug(groupSetting);
												
						if(groupId != 0){
							groups += mercostsheetgroup.getId().getGroupId()+","+mercostsheetgroup.getGroupName()+","+mercostsheetgroup.getCountry()
									+","+mercostsheetgroup.getMerprecostsheethdr().getId().getPreCostSheetNo()+"+"+groupSetting;
						}
						groupId--;
						if(groupId != 0){
							groups += "-";
						}
						log.debug(groups);
					}
        		}
        	}catch(Exception e){
        		log.debug(e);
        		log.debug(e.getMessage());
        	}
        }
        return groups;
	}
}
