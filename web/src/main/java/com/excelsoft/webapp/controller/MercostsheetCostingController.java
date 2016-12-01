package com.excelsoft.webapp.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.excelsoft.model.Mercostsheetrowmaterial;
import com.excelsoft.service.MercostsheethdrManager;
import com.excelsoft.service.MercostsheetrowmaterialManager;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/mercostsheetcosting*")
public class MercostsheetCostingController {
	protected final transient Log log = LogFactory.getLog(getClass());
    @SuppressWarnings("unused")
	private MercostsheethdrManager mercostsheethdrManager;
    private MercostsheetrowmaterialManager mercostsheetrowmaterialManager;

        
    @Autowired
    public void setMercostsheethdrManager(
			MercostsheethdrManager mercostsheethdrManager) {
		this.mercostsheethdrManager = mercostsheethdrManager;
	}

    @Autowired
	public void setMercostsheetrowmaterialManager(
			MercostsheetrowmaterialManager mercostsheetrowmaterialManager) {
		this.mercostsheetrowmaterialManager = mercostsheetrowmaterialManager;
	}



	
	@RequestMapping(method = RequestMethod.POST)
    public Model handleRequest(HttpServletRequest request,HttpServletResponse response)
    throws Exception {
        Model model = new ExtendedModelMap();
        String country = request.getParameter("country") ;
        String colours = request.getParameter("colours") ;
        String components = request.getParameter("components") ;
        String group = request.getParameter("group") ;
        //String dem2 = request.getParameter("dem2") ;
        
        String costSheetNo= request.getParameter("costSheetNo");
        String versionNo= request.getParameter("versionNo");
        String costsheetType= request.getParameter("costsheetType");
        
        String[]  Acolours =null;
        String[]  Acomponents =null;
    	int k=0;
    	List < List<Mercostsheetrowmaterial>  >mercostsheetrowmaterials = new ArrayList<>();
        if(country!=null ||  colours!=null || components!=null || group!=null){
        	
        	if(colours!=""){
        		 Acolours =colours.split(",");
            }
        	if(components!=""){
        		Acomponents =components.split(",");
            }
        
        	
        	log.debug("country="+country+"   colours="+colours+"  components="+colours+"  group="+group);
        	if(country!="" &&  colours!="" && components!="" && group!=""){
        		String[] types={"country","colours","components","group"};
        		for(int i=0;i<Acolours.length;i++){
        			for(int j=0;j<Acomponents.length;j++){
        				String[] values={country,Acolours[i],Acomponents[j],group};
        	        	//log.debug(Arrays.toString(values));
        	        	//log.debug(Arrays.toString(types));
        				List<Mercostsheetrowmaterial>  mercostsheetrowmaterialss;
        				mercostsheetrowmaterialss = mercostsheetrowmaterialManager.getAll(costSheetNo, versionNo, costsheetType,types,values);
        				//log.debug(mercostsheetrowmaterialss.get(0).getId().getCostSheetNo());
        				mercostsheetrowmaterials.add(k++, mercostsheetrowmaterialss);
            		}
        		}
            }
        	else if(country!="" &&  colours!="" && components!="" ){
        		String[] types={"country","colours","components"};
        		for(int i=0;i<Acolours.length;i++){
        			for(int j=0;j<Acomponents.length;j++){
        				String[] values={country,Acolours[i],Acomponents[j]};
        				List<Mercostsheetrowmaterial>  mercostsheetrowmaterialss;
        				mercostsheetrowmaterialss = mercostsheetrowmaterialManager.getAll(costSheetNo, versionNo, costsheetType,types,values);
        				mercostsheetrowmaterials.add(k++, mercostsheetrowmaterialss);
            		}
        		}
            }
        	else if(country!="" &&  colours!="" && group!="" ){
        		String[] types={"country","colours","group"};
        		for(int i=0;i<Acolours.length;i++){
    				String[] values={country,Acolours[i],group};
    				List<Mercostsheetrowmaterial>  mercostsheetrowmaterialss;
    				mercostsheetrowmaterialss = mercostsheetrowmaterialManager.getAll(costSheetNo, versionNo, costsheetType,types,values);
    				mercostsheetrowmaterials.add(k++, mercostsheetrowmaterialss);
        		}
            }
        	else if(country!="" &&  components!="" && group!="" ){
        		String[] types={"country","components","group"};
    			for(int j=0;j<Acomponents.length;j++){
    				String[] values={country,Acomponents[j],group};
    				List<Mercostsheetrowmaterial>  mercostsheetrowmaterialss;
    				mercostsheetrowmaterialss = mercostsheetrowmaterialManager.getAll(costSheetNo, versionNo, costsheetType,types,values);
    				mercostsheetrowmaterials.add(k++, mercostsheetrowmaterialss);
        		}
            }
        	else if(colours!="" &&  components!="" && group!="" ){
        		String[] types={"colours","components","group"};
        		for(int i=0;i<Acolours.length;i++){
        			for(int j=0;j<Acomponents.length;j++){
        				String[] values={Acolours[i],Acomponents[j],group};
        				List<Mercostsheetrowmaterial>  mercostsheetrowmaterialss;
        				mercostsheetrowmaterialss = mercostsheetrowmaterialManager.getAll(costSheetNo, versionNo, costsheetType,types,values);
        				mercostsheetrowmaterials.add(k++, mercostsheetrowmaterialss);
            		}
        		}
            }
        	else if(country!="" &&  colours!=""){
        		String[] types={"country","colours"};
        		for(int i=0;i<Acolours.length;i++){
    				String[] values={country,Acolours[i]};
    				List<Mercostsheetrowmaterial>  mercostsheetrowmaterialss;
    				mercostsheetrowmaterialss = mercostsheetrowmaterialManager.getAll(costSheetNo, versionNo, costsheetType,types,values);
    				mercostsheetrowmaterials.add(k++, mercostsheetrowmaterialss);    
        		}
            }
        	else if(country!="" &&  components!=""){
        		String[] types={"country","components"};
    			for(int j=0;j<Acomponents.length;j++){
    				String[] values={country,Acomponents[j]};
    				List<Mercostsheetrowmaterial>  mercostsheetrowmaterialss;
    				mercostsheetrowmaterialss = mercostsheetrowmaterialManager.getAll(costSheetNo, versionNo, costsheetType,types,values);
    				mercostsheetrowmaterials.add(k++, mercostsheetrowmaterialss);
        		}
            }
        	else if(country!="" &&  group!=""){
        		String[] types={"country","group"};
				String[] values={country,group};
				List<Mercostsheetrowmaterial>  mercostsheetrowmaterialss;
				mercostsheetrowmaterialss = mercostsheetrowmaterialManager.getAll(costSheetNo, versionNo, costsheetType,types,values);
				mercostsheetrowmaterials.add(k++, mercostsheetrowmaterialss);
            }
        	else if(group!="" &&  colours!=""){
        		String[] types={"colours","group"};
        		for(int i=0;i<Acolours.length;i++){
    				String[] values={Acolours[i],group};
    				List<Mercostsheetrowmaterial>  mercostsheetrowmaterialss;
    				mercostsheetrowmaterialss = mercostsheetrowmaterialManager.getAll(costSheetNo, versionNo, costsheetType,types,values);
    				mercostsheetrowmaterials.add(k++, mercostsheetrowmaterialss);
        		}
            }
        	else if(group!="" &&  components!=""){
        		String[] types={"components","group"};
    			for(int j=0;j<Acomponents.length;j++){
    				String[] values={Acomponents[j],group};
    				List<Mercostsheetrowmaterial>  mercostsheetrowmaterialss;
    				mercostsheetrowmaterialss = mercostsheetrowmaterialManager.getAll(costSheetNo, versionNo, costsheetType,types,values);
    				mercostsheetrowmaterials.add(k++, mercostsheetrowmaterialss);

        		}
            }
        	else if(colours!="" &&  components!=""){
        		String[] types={"colours","components"};
        		for(int i=0;i<Acolours.length;i++){
        			for(int j=0;j<Acomponents.length;j++){
        				String[] values={Acolours[i],Acomponents[j]};
        				List<Mercostsheetrowmaterial>  mercostsheetrowmaterialss;
        				mercostsheetrowmaterialss = mercostsheetrowmaterialManager.getAll(costSheetNo, versionNo, costsheetType,types,values);
        				mercostsheetrowmaterials.add(k++, mercostsheetrowmaterialss);
            		}
        		}
            }
        	else if(country!=""){
        		String[] types={"country"};
				String[] values={country};
				List<Mercostsheetrowmaterial>  mercostsheetrowmaterialss;
				mercostsheetrowmaterialss = mercostsheetrowmaterialManager.getAll(costSheetNo, versionNo, costsheetType,types,values);
				mercostsheetrowmaterials.add(k++, mercostsheetrowmaterialss);

            }
			else if(components!=""){
				String[] types={"components"};
    			for(int j=0;j<Acomponents.length;j++){
    				String[] values={Acomponents[j]};
    				List<Mercostsheetrowmaterial>  mercostsheetrowmaterialss;
    				mercostsheetrowmaterialss = mercostsheetrowmaterialManager.getAll(costSheetNo, versionNo, costsheetType,types,values);
    				mercostsheetrowmaterials.add(k++, mercostsheetrowmaterialss);
        		}
            }
			else if(colours!=""){
				String[] types={"colours"};
        		for(int i=0;i<Acolours.length;i++){
    				String[] values={Acolours[i]};
    				List<Mercostsheetrowmaterial>  mercostsheetrowmaterialss;
    				mercostsheetrowmaterialss = mercostsheetrowmaterialManager.getAll(costSheetNo, versionNo, costsheetType,types,values);
    				mercostsheetrowmaterials.add(k++, mercostsheetrowmaterialss);
        		}
			}
			else if(group!=""){
				String[] types={"group"};
				String[] values={group};
				List<Mercostsheetrowmaterial>  mercostsheetrowmaterialss;
				mercostsheetrowmaterialss = mercostsheetrowmaterialManager.getAll(costSheetNo, versionNo, costsheetType,types,values);
				mercostsheetrowmaterials.add(k++, mercostsheetrowmaterialss);
			}
        	
        }
        model.addAttribute("mercostsheetrowmaterialslists",mercostsheetrowmaterials);
        model.addAttribute("k",k);
        log.debug(model);
        return model;
    }
}
