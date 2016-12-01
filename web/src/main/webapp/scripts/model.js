var oldvalue="";
/**
 * @author Raminda 
 * @param id for corasponding sch box perant
 * @author Raminda
 * @discription  modal popup populator for any case you need to give id and create case for it
 */
function  getContent(id){
	console.info(id);
	if(id=="schmodelroutfinder"){
		document.getElementById("stuleroutecopytbody").innerHTML="";
	}
	else if(id=="schmodelroutopfinder"){
		document.getElementById("stulerouteopeartioncopytbody").innerHTML="";
	}
	else{
		
		document.getElementById("tableBId_"+id).innerHTML="";
		//document.getElementById("tableft_"+id).innerHTML="";
	}
	
	var rop="";
	var quary
	if(id=="schmodelroutfinder" || id =="schmodelroutopfinder"){
		//do nothing
	}
	else{
		quary=document.getElementById("search"+id).value 
	}
	
	var div="";
	var tr1='<tr onclick="document.getElementById(\''+id+'\').value=\'';//ondblclick
	var tr2='\';"  ondblclick="$(this).trigger(\'click\'); $(\'addtotable_'+id+'\').trigger(\'click\');"> ';//$(\'#btncls'+id+'\').trigger(\'click\'); document.getElementById(\'tableBId_'+id+'\').innerHTML=\'\'
	var bott='<button style="display: none;" id="btncls'+id+'" type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>';
	var json=null;
	var urI="";
	if(id == "operation"){				
		var type=document.getElementById("operationType").value;
		if (type == null || type=="" ){
			//urI="services/api/mstoperation.json";
			alert("Please select Operation Type");
			return false;
		}
		else if(quary == null || quary=="" ){
			urI="services/api/mstoperation/getbyType/"+type+".json";
		}
		else{
			urI="services/api/mstoperation/getbyTypeAnd/"+type+"/"+quary+".json";
		}
        var my=AjaxCall("POST","",urI);
        if (my.readyState==4 && my.status==200){
            json = JSON.parse(my.responseText);
        } else{
			return true;
		}
		div=div+'<tr>';
		div=div+	'<th>Operation No</th>';
		div=div+	'<th>Operation Desc</th>';
		div=div+	'<th>Sewing Operation</th>';
		div=div+	'<th>Machine Type Default';
		div=div+		bott;
		div=div+	'</th>'
		div=div+'</tr>';
		for(var i=0;i<json.length;i++){       
        	div=div+ tr1 + json[i].operationNo  + "' ; selectedId  = '"+json[i].operationNo+ tr2;
        	div=div+	'<td>'+json[i].operationNo+'</td>';
        	div=div+	'<td>'+json[i].operationDesc+'</td> ';
        	div=div+	'<td>'+json[i].sewingOperation+'</td>';
        	div=div+	'<td>'+json[i].machineTypeDefault+'</td> ';
        	div=div+'</tr>';
	    }
		
	}
	else if(id =="supplierCode"){
		var my;
		if(quary == null || quary=="" ){
			my=AjaxCall("POST","","services/api/mstsupplier/getAll/"+mstlocation+".json");
		}
		else {
			my=AjaxCall("POST","","services/api/mstsupplier/getAllq/"+mstlocation+"/"+quary+".json");
		}

        if (my.readyState==4 && my.status==200){
            json = JSON.parse(my.responseText);
        } else{
			return true;
		}
		div=div+'<tr>';
		div=div+	'<th>Supplyer Code</th>';
		div=div+	'<th>Company Code</th>';
		div=div+	'<th>suppName</th>';
		div=div+	'<th>suppAddress</th>';
		div=div+	'<th>telNo</th>';
		div=div+	'<th>faxNo</th>';
		div=div+	'<th>tlxNo</th>';
		div=div+	'<th>emailAddr</th>';
		div=div+	'<th>contactName</th>';
		div=div+	'<th>purchGlCode</th>';
		div=div+	'<th>glCtrlAcc</th>';
		div=div+	'<th>crTerm</th>';
		div=div+	'<th>recType</th>';
		div=div+	'<th>supType</th>';
		div=div+	'<th>suppGstNumber</th>';
		div=div+	'<th>Bank Name';
		div=div+		bott;
		div=div+	'</th>'
		div=div+'</tr>';
		for(var i=0;i<json.length;i++){       
	    	div=div+ tr1 + json[i].id.suppCode + "' ; selectedId  = '"+json[i].id.suppCode+ tr2;
	    	div=div+	'<td>'+json[i].id.suppCode+'</td>';
	    	div=div+	'<td>'+json[i].id.compCode+'</td>';
	    	div=div+	'<td>'+json[i].suppName+'</td>';
	    	div=div+	'<td>'+json[i].telNo+'</td>';
	    	div=div+	'<td>'+json[i].faxNo+'</td>';
	    	div=div+	'<td>'+json[i].tlxNo+'</td>';
			div=div+	'<td>'+json[i].emailAddr+'</td>';
	    	div=div+	'<td>'+json[i].contactName+'</td>';
	    	div=div+	'<td>'+json[i].purchGlCode+'</td>';
	    	div=div+	'<td>'+json[i].customCurRate+'</td>';
			div=div+	'<td>'+json[i].glCtrlAcc+'</td>';
	    	div=div+	'<td>'+json[i].crTerm+'</td>';
	    	div=div+	'<td>'+json[i].recType+'</td>';
	    	div=div+	'<td>'+json[i].supType+'</td>';
			div=div+	'<td>'+json[i].suppGstNumber+'</td>';
	    	div=div+	'<td>'+json[i].bankName+'</td>';
	    	div=div+'</tr>';
	    }
	
	}
	else if (id=="currency"){
		var my;
		if(quary == null || quary=="" ){
			my=AjaxCall("GET","","services/api/mstcurrency.json");
		}
		else {
			my=AjaxCall("POST","","services/api/mstcurrency/getAllq/"+quary+".json");
		}

        if (my.readyState==4 && my.status==200){
            json = JSON.parse(my.responseText);
        } else{
			return true;
		}
		div=div+'<tr>';
		div=div+	'<th>Curtomer Code</th>';
		div=div+	'<th>Curtomer Name</th>';
		div=div+	'<th>Curtomer Rate</th>';
		div=div+	'<th>valid Until</th>';
		div=div+	'<th>Dec Name</th>';
		div=div+	'<th>Curtomer Currency Rate';
		div=div+		bott;
		div=div+	'</th>'
		div=div+'</tr>';
		for(var i=0;i<json.length;i++){       
	    	div=div+ tr1 + json[i].curCode + "' ; selectedId  = '"+json[i].curCode+ tr2;
	    	div=div+	'<td>'+json[i].curCode+'</td>';
	    	div=div+	'<td>'+json[i].curName+'</td>';
	    	div=div+	'<td>'+json[i].curRate+'</td>';
	    	div=div+	'<td>'+json[i].decName+'</td>';
	    	div=div+	'<td>'+json[i].decName+'</td>';
	    	div=div+	'<td>'+json[i].customCurRate+'</td>';
	    	div=div+'</tr>';
	    }
	
	}
	else if(id == "userId" || id == "merchandiser"){
		var my;
		if(quary == null || quary=="" ){
			my=AjaxCall("GET","","services/api/mstuser.json");
		}
		else {
			my=AjaxCall("POST","","services/api/mstuser/getAllbyq/"+quary+".json");
		}

        if (my.readyState==4 && my.status==200){
            json = JSON.parse(my.responseText);
        } else{
			return true;
		}
		div=div+'<tr>';
		div=div+	'<th>User Id</th>';
		div=div+	'<th>Email Address</th>';
		div=div+	'<th>User Group</th>';	
		div=div+	'<th>User Name</th>';
		div=div+	'<th>User Signature</th>';
		div=div+	'<th>User Type';
		div=div+		bott;
		div=div+	'</th>'
		div=div+'</tr>';
		for(var i=0;i<json.length;i++){       
	    	div=div+ tr1 + json[i].userId  +"' ; selectedId  = '"+json[i].userId + tr2;
	    	div=div+	'<td>'+json[i].userId+'</td>';
	    	div=div+	'<td>'+json[i].EMailAddress+'</td>';
	    	div=div+	'<td>'+json[i].userGroup+'</td>';
	    	div=div+	'<td>'+json[i].userName+'</td>';
	    	div=div+	'<td>'+json[i].userSignature+'</td>';
	    	div=div+	'<td>'+json[i].userType+'</td>';
	    	div=div+'</tr>';
	    }
	}
	else if(id=="rop_id_styleRouteId" || id=="wrop_id_styleRouteId"){
		
		URL= tableofrootOp(id,"Mststyleroute")+"/Mststyleroute";
		if(!URL){
			return false;
		}
		if(quary == null || quary=="" ){
			my=AjaxCall("POST","","services/api/styleroute/MststylerouteoperationrouteByparamquery"+URL+"/NOT.json");
		}
		else {
			my=AjaxCall("POST","","services/api/styleroute/MststylerouteoperationrouteByparamquery"+URL+"/"+quary+".json");
		}
		//var my=AjaxCall("POST","",urI);
        if (my.readyState==4 && my.status==200){
            json = JSON.parse(my.responseText);
        } else{
			return true;
		}
        div=div+'<tr>';
        div=div+	'<th>Style Route Id</th>';
        div=div+	'<th>Style Route Name</th>';
        div=div+	'<th>Style Id</th>';
        div=div+	'<th>Location Code</th>';
        div=div+	'<th>Department Code</th>';
        div=div+	'<th>Company Code</th>';
        div=div+	'<th>Customer Code</th>';
        div=div+	'<th>Component Id</th>';
        div=div+	'<th>Main Color</th>';
        div=div+	'<th>Assign Location</th>';
        div=div+	'<th>Buyer Dept</th>';
        div=div+	'<th>Product Type</th>';
        div=div+	'<th>No Of Pcs</th>';
        div=div+	'<th>Order Qty</th>';
        div=div+	'<th>No Of Machines</th>';
        div=div+	'<th>No Of Wokers</th>';
        div=div+	'<th>No Of Healpers</th>';
        div=div+	'<th>Work Mins</th>';
        div=div+	'<th>Cycle Time</th>';
        div=div+	'<th>TargetDate</th>';
        div=div+	'<th>Remarks</th>';
        div=div+	'<th>Approved By</th>';
        div=div+	'<th>Approved On</th>';
        div=div+	'<th>Route Status</th>';
        div=div+	'<th>Total SMV</th>';
        div=div+	'<th>createdOn</th>';
        div=div+	'<th>createdBy</th>';
        div=div+	'<th>createdAt</th>';
        div=div+	'<th>modifiedOn</th>';
        div=div+	'<th>modifiedBy</th>';
        div=div+	'<th>modifiedAt';
		div=div+		bott;
		div=div+	'</th>'
		div=div+'</tr>';
		for(var i=0;i<json.length;i++){
			div=div+ tr1+json[i].styleRouteId + "' ; selectedId  = '"+json[i].styleRouteId + tr2;
			div=div+	'<td>'+json[i].styleRouteId+'</td>';
			div=div+	'<td>'+json[i].styleRouteName+'</td>';
			div=div+	'<td>'+json[i].mststyleheader.id.styleId+'</td>';
			div=div+	'<td>'+json[i].mststyleheader.id.locationCode+'</td>';
			div=div+	'<td>'+json[i].mststyleheader.id.depCode+'</td>';
			div=div+	'<td>'+json[i].mststyleheader.id.compCode+'</td>';
			div=div+	'<td>'+json[i].mststyleheader.id.custCode+'</td>';
			div=div+	'<td>'+json[i].componentId+'</td> ';
			div=div+	'<td>'+json[i].mainColor+'</td>';
			div=div+	'<td>'+json[i].assignLocation+'</td>';
			div=div+	'<td>'+json[i].buyerDept+'</td>';
			div=div+	'<td>'+json[i].productType+'</td>';
			div=div+	'<td>'+json[i].noOfPcs+'</td>';
			div=div+	'<td>'+json[i].orderQty+'</td>';
			div=div+	'<td>'+json[i].noOfMachines+'</td> ';
			div=div+	'<td>'+json[i].noOfWokers+'</td>';
			div=div+	'<td>'+json[i].noOfHealpers+'</td>';
			div=div+	'<td>'+json[i].workMins+'</td>';
			div=div+	'<td>'+json[i].cycleTime+'</td>';
			div=div+	'<td>'+json[i].targetDate+'</td>';
			div=div+	'<td>'+json[i].remarks+'</td>';
			div=div+	'<td>'+json[i].approvedBy+'</td> ';
			div=div+	'<td>'+json[i].approvedOn+'</td>';
			div=div+	'<td>'+json[i].routeStatus+'</td>';
			div=div+	'<td>'+json[i].totalSMV+'</td>';
			div=div+	'<td>'+json[i].createdOn+'</td>';
			div=div+	'<td>'+json[i].createdBy+'</td>';
			div=div+	'<td>'+json[i].createdAt+'</td>';
			div=div+	'<td>'+json[i].modifiedOn+'</td>';
			div=div+	'<td>'+json[i].modifiedBy+'</td>';
			div=div+	'<td>'+json[i].modifiedAt;+'</td>';
			div=div+'</tr>';
		}
        
	}
	else if(id =="id_mainColor"){
		if(quary == null || quary==""){
			urI="services/api/stylemainColor/getAllbyId"+StyleContents("","")+"/NOT.json";
		}
		else{
			urI="services/api/stylemainColor/getAllbyId"+StyleContents("","")+"/"+quary+".json";
		}
		
		var my=AjaxCall("POST","",urI);
        if (my.readyState==4 && my.status==200){
            json = JSON.parse(my.responseText);
        } else{
			return true;
		}
        div=div+'<tr>';
		div=div+	'<th>Main Color</th>';
		div=div+	'<th>Location Code';
		div=div+	'<th>StyleId</th>';
		div=div+	'<th>Company Code</th>';
		div=div+	'<th>Buyer Code</th>';
		div=div+	'<th>Department Code</th>';
		div=div+	'<th>Pack Qty';
		div=div+		bott;
		div=div+	'</th>'
		div=div+'</tr>';
		
		
		div=div+ tr1+"General" + tr2;
    	div=div+	'<td>General</td>';
    	div=div+	'<td>'+document.getElementById("id_locationCode").value+'</td>';
    	div=div+	'<td>'+document.getElementById("id_styleId").value+'</td>';
    	div=div+	'<td>'+document.getElementById("id_compCode").value+'</td>';
    	div=div+	'<td>'+document.getElementById("id_custCode").value+'</td>';
    	div=div+	'<td>'+document.getElementById("id_depCode").value+'</td>';
    	div=div+	'<td>1</td> ';
    	div=div+'</tr>';
		for(var i=0;i<json.length;i++){
	    	div=div+ tr1+json[i].id.mainColor + "' ; selectedId  = '"+json[i].id.mainColor + tr2;
	    	div=div+	'<td>'+json[i].id.mainColor+'</td>';
	    	div=div+	'<td>'+json[i].id.locationCode+'</td>';
	    	div=div+	'<td>'+json[i].id.styleId+'</td>';
	    	div=div+	'<td>'+json[i].id.compCode+'</td>';
	    	div=div+	'<td>'+json[i].id.custCode+'</td>';
	    	div=div+	'<td>'+json[i].id.depCode+'</td>';
	    	div=div+	'<td>'+json[i].packQty+'</td> ';
	    	div=div+'</tr>';
	    }
	}
	/*  get by gencodes */ 
	else if( id=="orderType" ||  id=="season" || id=="cs_season" || id == "cs_id_depCode" || id == "process" || id == "operationType" || id=="pcs_season" || id == "costsheetType" || id=="delivery_team" ||id =="shipment_mode" ||id =="destination_country" || id == "baseBody" || id=="itemColor" || id =="costsheetType" ||  id == "pcs_id_depCode" || id == "grade"|| id == "operationtype" || id == "workAid" || id=="sid_depCode" || id=="id_depCode" || id =="wrop_id_depCode" || id =="rop_id_depCode" || id== "rop_id_mainColor" || id=="packingMethod" || id == "productRange" || id=="inputmaincolor" || id.indexOf("child-color-name")>-1 ){
		var type=gencodemapper(id)
		/* get gencods js veriabale */ 
		if(quary == null || quary=="" ){
			urI="services/api/gencodes/type_id/"+type+".json"
		}
		else{
			urI="services/api/gencodes/type_idlike/"+type+"/"+quary+".json"
		}
        var my=AjaxCall("POST","",urI);
        if (my.readyState==4 && my.status==200){
            json = JSON.parse(my.responseText);
        } else{
			return true;
		}
        div=div+'<tr>';
		div=div+	'<th>Code</th>';
		//div=div+	'<th>Desc</th>';
		div=div+	'<th>Description';
		div=div+		bott;
		div=div+	'</th>'
		div=div+'</tr>';
		for(var i=0;i<json.length;i++){
	        if(type==json[i].id.type){
	        	//code  desc uomDenom
	        	div=div+ tr1+json[i].id.code + "' ; selectedId  = '"+ json[i].id.code +tr2;
	        	div=div+	'<td>'+json[i].id.code+'</td>';
	        	div=div+	'<td>'+json[i].desc+'</td>';
	        	//div=div+	'<td>'+json[i].uomDenom+'</td> ';
	        	div=div+'</tr>';
	        }
	    }
	}
	
	else if (id == "assignLocation" || id =="sid_locationCode" || id=="id_locationCode"|| id =="wrop_id_locationCode" || id =="rop_id_locationCode" || id =="pcs_id_locationCode" || id =="cs_id_locationCode"  ){
		var my;
		
		if(quary == null || quary=="" ){
			my=AjaxCall("GET","","services/api/mstlocations.json");
		}
		else {
			my=AjaxCall("POST","","services/api/mstlocations/getcodeByquery/"+quary+".json");
		}
		
        if (my.readyState==4 && my.status==200){
            json = JSON.parse(my.responseText);
        } else{
			return true;
		}
		div=div+'<tr>';
		div=div+	'<th>Location Code</th>';
		div=div+	'<th>Location Name</th>';
		div=div+	'<th>Location Address</th>';
		div=div+	'<th>Location Type</th>';
		div=div+	'<th>Contact Name</th>';
		div=div+	'<th>Tel No</th>';
		div=div+	'<th>Email Address';
		div=div+		bott;
		div=div+	'</th>'
		div=div+'</tr>';
		for(var i=0;i<json.length;i++){       
	    	div=div+ tr1 + json[i].locationCode  +"' ; selectedId  = '"+json[i].locationCode + tr2;
	    	div=div+	'<td>'+json[i].locationCode+'</td>';
	    	div=div+	'<td>'+json[i].locationName+'</td>';
	    	div=div+	'<td>'+json[i].locationAddr+'</td>';
	    	div=div+	'<td>'+json[i].locationType+'</td> ';
	    	div=div+	'<td>'+json[i].contactName+'</td> ';
	    	div=div+	'<td>'+json[i].telNo+'</td>';
	    	div=div+	'<td>'+json[i].emailAddr+'</td>';
	    	div=div+'</tr>';
	    }
	}
	else if (id=="id_custCode" || id =="wrop_id_custCode" || id =="rop_id_custCode" || id =="sid_custCode" || id =="pcs_id_custCode" || id =="cs_id_custCode"){
		
		var my;
		
		
		if(quary == null || quary=="" ){
			my=AjaxCall("GET","","services/api/mstcustomer.json");
		}
		else {
			my=AjaxCall("POST","","services/api/mstcustomer/getcustomerq/"+quary+".json");
		}
		
		
		
        if (my.readyState==4 && my.status==200){
            json = JSON.parse(my.responseText);
        } 
        else{
			return true;
		}
		div=div+'<tr>';
		div=div+	'<th>Buyer Code</th>';
		div=div+	'<th>Buyer Email</th>';
		//div=div+	'<th>Cr Term</th>';
		div=div+	'<th>Buyer Address</th>';
		div=div+	'<th>Contact Name</th>';
		div=div+	'<th>Tel No</th>';
		div=div+		bott;
		div=div+	'</th>'
		div=div+'</tr>';
		for(var i=0;i<json.length;i++){       
	    	div=div+ tr1 + json[i].custCode  +"' ; selectedId  = '"+json[i].custCode+ tr2;
	    	div=div+	'<td>'+json[i].custCode+'</td>';
	    	div=div+	'<td>'+json[i].buyerEmail+'</td>';
	    	//div=div+	'<td>'+json[i].crTerm+'</td>';
	    	div=div+	'<td>'+json[i].custAddress+'</td> ';
	    	div=div+	'<td>'+json[i].contactName+'</td> ';
	    	div=div+	'<td>'+json[i].telNo+'</td>';
	    	div=div+'</tr>';
	    }
	}
	else if (id=="wrop_id_componentId" || id=="rop_id_componentId" || id =="id_componentId"){
		
		var my;
		if (id =="rop_id_componentId"){
			URL= tableofrootOp("rop_id_componentId","mststylecomponent")+"/mststylecomponent";
			if(!URL){
				return false;
			}
			if(quary == null || quary=="" ){
				my=AjaxCall("POST","","services/api/styleroute/MststylecomponentrouteByparamquery"+URL+"/NOT.json");
			}
			else {
				my=AjaxCall("POST","","services/api/styleroute/MststylecomponentrouteByparamquery"+URL+"/"+quary+".json");
			}
		}
		else{
			URL= StyleContents("id_componentId","mststylecomponent");
			if(quary == null || quary=="" ){
				my=AjaxCall("POST","","services/api/stylecomponent/getbyAllId"+URL+"/NOT.json");
			}
			else {
				my=AjaxCall("POST","","services/api/stylecomponent/getbyAllId"+URL+"/"+quary+".json");
			}
		}
		
        if (my.readyState==4 && my.status==200){
            json = JSON.parse(my.responseText);
        } else{
			return true;
		}
		div=div+'<tr>';
		div=div+	'<th>Component Id</th>';
		div=div+	'<th>Product Type</th>';
		div=div+	'<th>Component Ratio';
		div=div+		bott;
		div=div+	'</th>'
		div=div+'</tr>';
		for(var i=0;i<json.length;i++){       
	    	div=div+ tr1 + json[i].id.componentId  +"' ; selectedId  = '"+json[i].id.componentId+ tr2;
	    	div=div+	'<td>'+json[i].id.componentId+'</td>';
	    	div=div+	'<td>'+json[i].productType+'</td>';
	    	div=div+	'<td>'+json[i].compRatio+'</td>';
	    	div=div+'</tr>';
	    }
	}
	
	else if (id=="sid_compCode" || id =="rop_id_compCode" || id =="wrop_id_compCode"  || id =="pcs_id_compCode" || id =="cs_id_compCode" || id =="id_compCode" ){
		
		var my;
		if(quary == null || quary=="" ){
			my=AjaxCall("GET","","services/api/mstcompany.json");
		}
		else {
			my=AjaxCall("POST","","services/api/mstcompany/getAllbyquery/"+quary+".json");
		}

        if (my.readyState==4 && my.status==200){
            json = JSON.parse(my.responseText);
        } else{
			return true;
		}
		div=div+'<tr>';
		div=div+	'<th>Company Code</th>';
		div=div+	'<th>Audit Company Address</th>';
		div=div+	'<th>Company Address</th>';	
		div=div+	'<th>Email Address';
		div=div+		bott;
		div=div+	'</th>'
		div=div+'</tr>';
		for(var i=0;i<json.length;i++){       
	    	div=div+ tr1 + json[i].compCode  +"' ; selectedId  = '"+json[i].compCode+ tr2;
	    	div=div+	'<td>'+json[i].compCode+'</td>';
	    	div=div+	'<td>'+json[i].auditCompAddress+'</td>';
	    	div=div+	'<td>'+json[i].compAddress+'</td>';
	    	div=div+	'<td>'+json[i].emailAddress+'</td>';
	    	div=div+'</tr>';
	    }
	}
	else if (id=="id_styleId"|| id =="wrop_id_styleId"  || id =="rop_id_styleId" || id =="pcs_id_styleId" || id =="cs_id_styleId"){
		var my;
		 
		URL=StyleContents(id,'mststyleheader')+"/mststyleheader";
		if(quary == null || quary=="" ){
			my=AjaxCall("POST","","services/api/mststyleheader/MststyleheaderByparam"+URL+"/NOT.json");
		}
		else {
			my=AjaxCall("POST","","services/api/mststyleheader/MststyleheaderByparam"+URL+"/"+quary+".json");
		}
		
		if(id == "pcs_id_styleId"){
			rop="pcs_";
		}
		else if(id == "cs_id_styleId"){
			rop="cs_";
		}
		else if (id =="rop_id_styleId"){
			rop="rop_";
			
		}
		else if (id =="wrop_id_styleId"){
			rop="wrop_";
		}
		else if (id =="id_styleId"){
			rop="";
		}
        if (my.readyState==4 && my.status==200){
            json = JSON.parse(my.responseText);
        } else{
			return true;
		}
		div=div+'<tr>';
		div=div+	'<th class="textcenter">Style Id</th>';
		div=div+	'<th class="textcenter">Location Code</th>';
		div=div+	'<th class="textcenter">Department Code</th>';
		div=div+	'<th class="textcenter">Company Code</th>';
		div=div+	'<th class="textcenter">Buyer Code</th>';
		div=div+	'<th class="textcenter">Product Range</th>';
		div=div+	'<th class="textcenter">User Id</th>';
		div=div+	'<th class="textcenter">Packing Method';
		div=div+		bott;
		div=div+	'</th>'
		div=div+'</tr>';
		for(var i=0;i<json.length;i++){       
	    	div=div+ tr1 + json[i].id.styleId +"' ; selectedId  = '"+json[i].id.styleId;
	    		div=div+"';$('#"+rop+"id_custCode').trigger('onfocus'); document.getElementById('"+rop+"id_custCode').value='"+json[i].id.custCode
		    	div=div+"';$('#"+rop+"id_locationCode').trigger('onfocus'); document.getElementById('"+rop+"id_locationCode').value='"+json[i].id.locationCode ; 
		    	div=div+"';$('#"+rop+"id_depCode').trigger('onfocus'); document.getElementById('"+rop+"id_depCode').value='"+json[i].id.depCode ; 
		    	div=div+"';$('#"+rop+"id_compCode').trigger('onfocus'); document.getElementById('"+rop+"id_compCode').value='"+json[i].id.compCode ;
		    	div=div+"'; document.getElementById('"+rop+"styleDescription').value='"+json[i].styleDescription  ;
		    	div=div+ tr2;
	    	div=div+	'<td class="textcenter">'+json[i].id.styleId+'</td>';
	    	div=div+	'<td class="textcenter">'+json[i].id.locationCode+'</td>';
	    	div=div+	'<td class="textcenter">'+json[i].id.depCode+'</td>';
	    	div=div+	'<td class="textcenter">'+json[i].id.compCode+'</td> ';
	    	div=div+	'<td class="textcenter">'+json[i].id.custCode+'</td> ';
	    	div=div+	'<td class="textcenter">'+json[i].productRange+'</td>';
	    	div=div+	'<td class="textcenter">'+json[i].userId+'</td> ';
	    	div=div+	'<td class="textcenter">'+json[i].packingMethod+'</td>';
	    	div=div+'</tr>';
	    }
	}
	else if(id == "schmodelroutfinder"){
		//schmodelBuyerDip  schmodelBuyer schmodelStyle
		schmodelBuyerDip=document.getElementById("schmodelBuyerDip").value;
		schmodelBuyer=document.getElementById("schmodelBuyer").value;
		schmodelStyle=document.getElementById("schmodelStyle").value;
		var url="services/api/styleroute/routesch/"+schmodelBuyerDip+"/"+schmodelStyle+"/"+schmodelBuyer+".json";
		var my=AjaxCall("POST","",url);
	    
		if (my.readyState==4 && my.status==200){
	        json = JSON.parse(my.responseText);
	    }
		else{
			return true;
		}
		for(var i=0;i<json.length;i++){       
			div=div+'<tr onclick="styleRouteName=\''+json[i].styleRouteName+'\';styleRouteID=\''+json[i].styleRouteId +'\'; getContent(\'schmodelroutopfinder\')">';
	    	div=div+	'<td>'+json[i].styleRouteId+'</td>';
	    	div=div+	'<td>'+json[i].styleRouteName+'</td>';
	    	div=div+	'<td>'+json[i].mststyleheader.id.styleId+'</td>';
	    	div=div+'</tr>';
	    }
	}
	else if (id =="schmodelroutopfinder"){
		var url="services/api/mststyleoperation/routeopsch/"+styleRouteID+"/"+styleRouteName+"/"+schmodelBuyerDip+"/"+schmodelStyle+"/"+schmodelBuyer+".json";
		var my=AjaxCall("POST","",url);
	    
		if (my.readyState==4 && my.status==200){
	        json = JSON.parse(my.responseText);
	    }
		else{
			return true;
		}
		for(var i=0;i<json.length;i++){       
			div=div+'<tr>';
	    	div=div+	'<td>'+json[i].id.opeartionNo+'</td>';
	    	div=div+	'<td>'+json[i].componentId+'</td>';
	    	div=div+	'<td>'+json[i].mainColor+'</td>';
	    	div=div+	'<td>'+json[i].operationType+'</td>';
	    	div=div+	'<td>'+json[i].operationDescBref+'</td>';
	    	div=div+'</tr>';
	    }
	}
	else if(id == "machineTypeDefault"){
		if(quary == null || quary=="" ){
			url="services/api/mstmachinetype.json";
			var my=AjaxCall("GET","",url);
		}
		else {
			url="services/api/mstmachinetype/getmachintype/"+quary+".json";
			var my=AjaxCall("POST","",url);
		}
		
	    
		if (my.readyState==4 && my.status==200){
	        json = JSON.parse(my.responseText);
	    } else{
			return true;
		}
		div=div+'<tr>';
		div=div+	'<th>Type Code</th>';
		div=div+	'<th>Description</th>';
		div=div+	'<th>Operation Std. Length</th>';
		div=div+	'<th>Operation Std. Length Uom</th>';
		div=div+	'<th>User Id</th>';
		div=div+	'<th>Manual Opt';
		div=div+		bott;
		div=div+	'</th>'
		div=div+'</tr>';
		for(var i=0;i<json.length;i++){       
	    	div=div+ tr1 + json[i].typeCode  +"' ; selectedId  = '"+json[i].typeCode+ tr2;
	    	div=div+	'<td>'+json[i].typeCode+'</td>';
	    	div=div+	'<td>'+json[i].description+'</td>';
	    	div=div+	'<td>'+json[i].operationStdLength+'</td>';
	    	div=div+	'<td>'+json[i].operationStdLengthUom+'</td> ';
	    	div=div+	'<td>'+json[i].userId+'</td>';
	    	div=div+	'<td>'+json[i].manualOpt+'</td>';
	    	div=div+'</tr>';
	    }
	}
	
	
	else if(id == "preCostSheetNo"){
		custCode=document.getElementById("pcs_id_custCode").value;
		locationCode=document.getElementById("pcs_id_locationCode").value;
		depCode=document.getElementById("pcs_id_depCode").value;
		styleId=document.getElementById("pcs_id_styleId").value;
		compCode=document.getElementById("pcs_id_compCode").value;
		season=document.getElementById("pcs_season").value;
		costsheetType=document.getElementById("costsheetType").value;
		if(custCode=="" || locationCode=="" || depCode=="" || styleId=="" || compCode=="" || costsheetType=="" || season=="" || costsheetType ==""){
			custCode="NOT";locationCode="NOT";depCode="NOT";styleId="NOT";compCode="NOT";costsheetType="NOT";season="NOT";costsheetType="NOT";
		}
		if(quary == null || quary=="" ){
			url="services/api/merprecostsheet/getAll/"+compCode+"/"+locationCode+"/"+custCode+"/"+depCode+"/"+styleId+"/"+season+"/"+costsheetType+"/"+"NOT.json";
		}
		else {
			url="services/api/merprecostsheet/getAll/"+compCode+"/"+locationCode+"/"+custCode+"/"+depCode+"/"+styleId+"/"+season+"/"+costsheetType+"/"+quary+".json";
		}
		var my=AjaxCall("POST","",url);
		if (my.readyState==4 && my.status==200){
	        json = JSON.parse(my.responseText);
	    } else{
			return true;
		}
		div=div+'<tr>';
		div=div+	'<th>Item Type</th>';
		div=div+	'<th> Item Group</th>';
		div=div+	'<th> Type 1 Name</th>';
		div=div+	'<th> Type 2 Name</th>';
		div=div+	'<th> Type 3 Name</th>';
		div=div+	'<th> Type 4 Name</th>';
		div=div+	'<th> Type 5 Name</th>';
		div=div+	'<th> Type 6 Name</th>';
		div=div+	'<th> Category </th>';
		div=div+	'<th> Acc Code</th>';
		div=div+	'<th> n-avision Task code</th>';
		div=div+	'<th> Item Type Desc';
		div=div+		bott;
		div=div+	'</th>';
		div=div+'</tr>';
		for(var i=0;i<json.length;i++){       
	    	div=div+ tr1 + json[i].itemType + "' ; selectedId  = '"+json[i].itemType+  tr2;
	    	div=div+	'<td>'+json[i].itemType+'</td>';
	    	div=div+	'<td>'+json[i].itemGroup+'</td>';
	    	div=div+	'<td>'+json[i].type1Name+'</td>';
	    	div=div+	'<td>'+json[i].type2Name+'</td> ';
	    	div=div+	'<td>'+json[i].type3Name+'</td>';
	    	div=div+	'<td>'+json[i].type4Name+'</td>';
			div=div+	'<td>'+json[i].type5Name+'</td>';
	    	div=div+	'<td>'+json[i].type6Name+'</td>';
	    	div=div+	'<td>'+json[i].category+'</td> ';
	    	div=div+	'<td>'+json[i].navisionTaskcode+'</td>';
	    	div=div+	'<td>'+json[i].itemTypeDesc+'</td>';
	    	div=div+'</tr>';
	    }
	}
	
	
	else if(id == "planingOrdersheetNo"){		
		
		custCode=document.getElementById("id_custCode").value;
		locationCode=document.getElementById("id_locationCode").value;
		depCode=document.getElementById("id_depCode").value;
		styleId=document.getElementById("id_styleId").value;
		compCode=document.getElementById("id_compCode").value;
		season=document.getElementById("season").value;		
		if(custCode=="")
		    custCode="NOT";
		if(locationCode=="")
		    locationCode="NOT";
		if(depCode=="")
			depCode="NOT";
		if(styleId=="")
		    styleId="NOT" ;
		if(compCode=="")
			compCode="NOT";
		if(season=="")
			season="NOT";
		
		
		if(quary == null || quary=="" ){
			url="services/api/merordersheethdr/getAll/"+compCode+"/"+locationCode+"/"+custCode+"/"+depCode+"/"+styleId+"/"+season+"/"+"NOT.json";
		}
		else {
			url="services/api/merordersheethdr/getAll/"+compCode+"/"+locationCode+"/"+custCode+"/"+depCode+"/"+styleId+"/"+season+"/"+quary+".json";
		}
		var my=AjaxCall("POST","",url);
		if (my.readyState==4 && my.status==200){
	        json = JSON.parse(my.responseText);
	    } else{
			return true;
		}
		div=div+'<tr>';
		div=div+	'<th> planingOrdersheetNo</th>';
		div=div+	'<th> buyer</th>';
		div=div+	'<th> locationCode</th>';
		div=div+	'<th> styleId</th>';
		div=div+	'<th> compCode</th>';
		div=div+	'<th> depCode</th>';
		div=div+		bott;
		div=div+	'</th>';
		div=div+'</tr>';
		for(var i=0;i<json.length;i++){       
	    	div=div+ tr1 + json[i].id.planingOrdersheetNo +"' ; selectedId  = '"+json[i].id.planingOrdersheetNo;	    	
	    	div=div+"';$('#planingOrdersheetNo').trigger('onfocus'); document.getElementById('planingOrdersheetNo').value='"+json[i].id.planingOrdersheetNo;
	    	div=div+"';$('#"+rop+"id_locationCode').trigger('onfocus'); document.getElementById('"+rop+"id_locationCode').value='"+json[i].mststyleheader.id.locationCode; 
	    	div=div+"';$('#"+rop+"id_depCode').trigger('onfocus'); document.getElementById('"+rop+"id_depCode').value='"+json[i].mststyleheader.id.depCode ; 
	    	div=div+"';$('#"+rop+"id_compCode').trigger('onfocus'); document.getElementById('"+rop+"id_compCode').value='"+json[i].mststyleheader.id.compCode ;
	    	div=div+"';$('#"+rop+"season').trigger('onfocus'); document.getElementById('"+rop+"season').value='"+json[i].season ;
	    	div=div+"';$('#"+rop+"id_styleId').trigger('onfocus'); document.getElementById('"+rop+"id_styleId').value='"+json[i].mststyleheader.id.styleId ;
	    	div=div+"';$('#"+rop+"id_custCode').trigger('onfocus'); document.getElementById('"+rop+"id_custCode').value='"+json[i].buyer ;
	    	div=div+"'; document.getElementById('"+rop+"styleDescription').value='"+json[i].mststyleheader.styleDescription  ;
	    	div=div+ tr2;
	        div=div+	'<td>'+json[i].id.planingOrdersheetNo+'</td>';
	    	div=div+	'<td>'+json[i].buyer+'</td>';
	    	div=div+	'<td>'+json[i].mststyleheader.id.locationCode+'</td>';
	    	div=div+	'<td>'+json[i].mststyleheader.id.styleId+'</td> ';
	    	div=div+	'<td>'+json[i].mststyleheader.id.compCode+'</td>';
	    	div=div+	'<td>'+json[i].mststyleheader.id.depCode+'</td>';
			div=div+'</tr>';
			
	    }
	}
	
	
	
	
	
	
	else if(id == "itemType"){
		
		if(quary == null || quary=="" ){
			url="services/api/mstitemtype/getAll/"+selecteditemcategory+".json";
		}
		else {
			url="services/api/mstitemtype/getAllq/"+selecteditemcategory+"/"+quary+".json";
		}
		var my=AjaxCall("POST","",url);
	    
		if (my.readyState==4 && my.status==200){
	        json = JSON.parse(my.responseText);
	    } else{
			return true;
		}
		div=div+'<tr>';
		div=div+	'<th>Item Type</th>';
		div=div+	'<th> Item Group</th>';
		div=div+	'<th> Type 1 Name</th>';
		div=div+	'<th> Type 2 Name</th>';
		div=div+	'<th> Type 3 Name</th>';
		div=div+	'<th> Type 4 Name</th>';
		div=div+	'<th> Type 5 Name</th>';
		div=div+	'<th> Type 6 Name</th>';
		div=div+	'<th> Category </th>';
		div=div+	'<th> Acc Code</th>';
		div=div+	'<th> n-avision Task code</th>';
		div=div+	'<th> Item Type Desc';
		div=div+		bott;
		div=div+	'</th>';
		div=div+'</tr>';
		for(var i=0;i<json.length;i++){       
	    	div=div+ tr1 + json[i].itemType + "' ; selectedId  = '"+json[i].itemType+ tr2;
	    	div=div+	'<td>'+json[i].itemType+'</td>';
	    	div=div+	'<td>'+json[i].itemGroup+'</td>';
	    	div=div+	'<td>'+json[i].type1Name+'</td>';
	    	div=div+	'<td>'+json[i].type2Name+'</td> ';
	    	div=div+	'<td>'+json[i].type3Name+'</td>';
	    	div=div+	'<td>'+json[i].type4Name+'</td>';
			div=div+	'<td>'+json[i].type5Name+'</td>';
	    	div=div+	'<td>'+json[i].type6Name+'</td>';
	    	div=div+	'<td>'+json[i].category+'</td> ';
	    	div=div+	'<td>'+json[i].navisionTaskcode+'</td>';
	    	div=div+	'<td>'+json[i].itemTypeDesc+'</td>';
	    	div=div+'</tr>';
	    }
	}
	else if(id == "itemCode"){
		if(selecteditemtype != null && selecteditemtype!="" ){
			if(quary == null || quary=="" ){
				url="services/api/mstitem/getAll/"+selecteditemtype+".json";
			}
			else {
				url="services/api/mstitem/getAllq/"+selecteditemtype+"/"+quary+".json";
			}
			var my=AjaxCall("POST","",url);
		    
			if (my.readyState==4 && my.status==200){
		        json = JSON.parse(my.responseText);
		    }
			else{
				return true;
			}
			div=div+'<tr>';
			div=div+	'<td>Item Type</th>';
			div=div+	'<td>Item Code</th>';
			div=div+	'<td>itemDesc</th>';
			div=div+	'<td>uom</th>';
			div=div+	'<td>designNo</th>';
			div=div+	'<td>userId</th>';
			div=div+	'<td>itemGroup</th>';
			div=div+	'<td>type1Code</th>';
			div=div+	'<td>type2Code</th>';
			div=div+	'<td>type3Code</th>';
			div=div+	'<td>type4Code</th>';
			div=div+	'<td>type5Code</th>';
			div=div+	'<td>type6Code</th>';
			div=div+	'<td>glCodePurch</th>';
			div=div+	'<td>glCodeSales</th>';
			div=div+	'<td>glCodeStock</th>';
			div=div+	'<td>buyerCode</th>';
			div=div+	'<td>styleId</th>';
			div=div+	'<td>createdBy</th>';
			div=div+	'<td>createdOn</th>';
			div=div+	'<td>createdAt</th>';
			div=div+	'<td>modifiedBy</th>';
			div=div+	'<td>modifiedOn</th>';
			div=div+	'<td>modifiedAt</th>';
			div=div+	'<td>curCode';
			div=div+		bott;
			div=div+	'</th>';	
			
			for(var i=0;i<json.length;i++){       
		    	div=div+ tr1 + json[i].id.itemCode +"';document.getElementById('itemDescription').value='"+json[i].itemDesc+"' ; selectedId  = '"+json[i].id.itemCode+ tr2;
		    	div=div+	'<td>'+json[i].id.itemType+'</td>';
		    	div=div+	'<td>'+json[i].id.itemCode+'</td>';
		    	div=div+	'<td>'+json[i].itemDesc+'</td>';
		    	div=div+	'<td>'+json[i].uom+'</td> ';
		    	div=div+	'<td>'+json[i].designNo+'</td>';
		    	div=div+	'<td>'+json[i].userId+'</td>';
				div=div+	'<td>'+json[i].itemGroup+'</td>';
		    	div=div+	'<td>'+json[i].type1Code+'</td>';
		    	div=div+	'<td>'+json[i].type2Code+'</td> ';
		    	div=div+	'<td>'+json[i].type3Code+'</td>';
		    	div=div+	'<td>'+json[i].type4Code+'</td>';
				div=div+	'<td>'+json[i].type5Code+'</td>';
		    	div=div+	'<td>'+json[i].type6Code+'</td>';
		    	div=div+	'<td>'+json[i].glCodePurch+'</td>';
		    	div=div+	'<td>'+json[i].glCodeSales+'</td> ';
		    	div=div+	'<td>'+json[i].glCodeStock+'</td>';
		    	div=div+	'<td>'+json[i].buyerCode+'</td>';
				div=div+	'<td>'+json[i].styleId+'</td>';
		    	div=div+	'<td>'+json[i].createdBy+'</td>';
		    	div=div+	'<td>'+json[i].createdOn+'</td> ';
		    	div=div+	'<td>'+json[i].modifiedBy+'</td>';
		    	div=div+	'<td>'+json[i].modifiedAt+'</td>';
				div=div+	'<td>'+json[i].curCode+'</td>';
		    	div=div+'</tr>';
		    }
		}
		else{
			alert("Select An Item Type first");
			return true;
		}
	}
	
	else{
		console.log("No ID "+ id);
		return false;
	}
	
	
	
	/*
	 * new  id's goes here
	 */
	if(json==null){
		div=div+'<tr>';
		div=div+'<td>Nothing to display</td>';
		div=div+'</tr>';
	}	
	if(id=="schmodelroutfinder"){
		document.getElementById("stuleroutecopytbody").innerHTML=div;
	}
	else if(id=="schmodelroutopfinder"){
		document.getElementById("stulerouteopeartioncopytbody").innerHTML=div;
	}
	
	else{
		//console.log(document.getElementById('tableft_'+id).innerHTML + "   -   "+id);
		document.getElementById("tableBId_"+id).innerHTML=div;
		if(document.getElementById('tableft_'+id).innerHTML!=""){
			console.log("***");
			 $('.footable').trigger('footable_redraw');//$('table').initialize();
		}
		else{
		$(function () {
				$('table').footable();

	            $('.clear-filter').click(function (e) {
	                e.preventDefault();
	                $('table.demo').trigger('footable_clear_filter');
					$('.filter-status').val('');
	            });

	            $('.filter-status').change(function (e) {
	                e.preventDefault();
					var filter = $(this).val();
	                $('#filter').val($(this).text());
	                $('table.demo').trigger('footable_filter', {filter: filter});
	            });
	            $('.footable_redraw').click(function(e) {
	                e.preventDefault();
	                $('.footable').trigger('footable_redraw'); //force a redraw
	            });
	        });
		}

	}
	
	console.log('tableId_'+rop+id+'>tbody>tr');//#tableId_'+rop+id+'>tbody>tr
	$('#tableId_'+id+'>tbody>tr').click(function(event) {
	    $('#tableId_'+id+'>tbody>tr').not(this).removeClass('clicked');
	    $(this).toggleClass('clicked'); 
	});
	/*$("table") 
    .tablesorter({widthFixed: true, widgets: ['zebra']}) 
    .tablesorterPager({container: $("#pager")});*/
}

var selectedId;
/**
 * 
 * @param id
 * @author Raminda 
 * @discription  modal popup base strc create here
 */
function  addmodalpopup(id){
	oldvalue=document.getElementById(id).value;
	console.info(id);
	console.info(document.getElementById(id).value);
	selectedId="";
	var div="";
	div=div+		'<div class="modal-dialog modal-lg">';
	div=div+			'<div class="modal-content model-popup-padding">';
	div=div+				'<div class="modal-header modal-header-custom">';
	div=div+					'<button onclick="document.getElementById(\''+id+'\').value=oldvalue;" type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>';
	div=div+				'</div>';
	div=div+				'<div class="">';
	div=div+					'<div>';
	div=div+						'<div class="row" style="padding-top:20px;"> ';
	div=div+							'<div class="col-md-11">';
	div=div+								'<input type="text" id="search'+id+'" value="" class="form-control" placeholder="">';
	div=div+							'</div>';
	div=div+							'<div class="col-md-1 "> ';
	div=div+								'<button type="button" class="btn btn-info btn-embossed pull-right" onclick="getContent(\''+id+'\')"  >Search</button>';
	div=div+							'</div>';
	div=div+						'</div>';
	div=div+						'<div class="table-wrapper-modal">';
	div=div+							'<table data-page-navigation=".pagination" class=" display table table-striped table-bordered table-hover" id="tableId_'+id+'">';
	div=div+								'<tbody id="tableBId_'+id+'">';
	div=div+									"<tr><td>Search Please</td></tr>";
	div=div+								'</tbody>';
	div=div+								'<tfoot  >';
	div=div+									'<tr>';
	div=div+										'<td colspan="12" style="border-color:none">';
	div=div+											'<div class="pagination pagination-centered hide-if-no-paging" id="tableft_'+id+'"></div>';
	div=div+										'</td>';
	div=div+									'</tr>';
	div=div+								'</tfoot>';
	div=div+							'</table>';
	div=div+						'</div>';
	div=div+					'</div>';
	div=div+				'</div>';
	div=div+				'<div class="">';
	div=div+					'<button id="addtotable_'+id+'"';
	div=div+						' onclick="if(selectedId!=\'\'){';
	div=div+							' document.getElementById(\''+id+'\').value=selectedId;';
	div=div+							' $(\'#'+id+'\' ).trigger(\'change\');';
	if(id != 'inputmaincolor'){
		div=div+						'try{$(\'#'+id+'\').valid();}catch(e){console.log(e);}';
	}
	div=div+							' $(\'#btncls'+id+'\').trigger(\'click\'); ';
	div=div+ 							' document.getElementById(\'tableBId_'+id+'\').innerHTML=\'\';';	
	if(id == 'id_componentId'){
		div=div+					'checkCorrValues(document.getElementById(\''+id+'\'));';
	}
	div=div+						'}else{';
	div=div+							'alert(\'Please Select an Item \')';
	div=div+						'}';
	div=div+   						'" type="button" class="btn btn-info pull-right select_table_value_button">Select</button>'
	div=div+				'</div>';
	div=div+			'</div>';
	div=div+		'</div>';
	document.getElementById("schmodalpopup").innerHTML=div;
	
}

/**
 * function for duplicates operaions
 * @param id
 */
function gendupOperationfrmrout(id){
	var div="";
	div=div+'<div class="modal-dialog modal-lg">';
		div=div+'<div class="modal-content model-popup-padding">';
			div=div+'<div class="modal-header modal-header-custom">';
				div=div+'<button  type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>';
			div=div+'</div>';
			div=div+'<div class="col-sm-3 col-md-3 col-xs-3 padding0">';
				div=div+'<div class="form-group formwithsearch marginbottom20">';
					div=div+'<div class="icon-addon addon-md">';
						div=div+'<label for="exampleInputEmail1">Buyer</label>';
						div=div+'<select id="schmodelBuyer" class="form-control" name="schmodelBuyer"  onfocus="typaheadforroot(\'schmodelBuyer\',\'id.custCode\')">';
							div=div+'<option></option>';
						div=div+'</select>';
						//div=div+'<input type="text" class="form-control" id="schmodelBuyer">';
						div=div+'<span class="caret dropdowncaret"></span>';
					div=div+'</div>';
				div=div+'</div>';          
				div=div+'<div class="clearfix"></div>';       
			div=div+'</div>';
			div=div+'<div class="col-sm-3 col-md-3 col-xs-3 padding0">';
				div=div+'<div class="form-group formwithsearch marginbottom20">';
					div=div+'<div class="icon-addon addon-md">';
						div=div+'<label for="exampleInputEmail1">Buyer Department</label>';
						div=div+'<select id="schmodelBuyerDip"  class="form-control" name="schmodelBuyerDip"  onfocus="typaheadforroot(\'schmodelBuyerDip\',\'id.depCode\')">';
							div=div+'<option></option>';
						div=div+'</select>';
						//div=div+'<input type="text" class="form-control" id="schmodelBuyerDip">';
						div=div+'<span class="caret dropdowncaret"></span>';
					div=div+'</div>';
				div=div+'</div>';          
				div=div+'<div class="clearfix"></div>';  
			div=div+'</div>';
			div=div+'<div class="col-sm-3 col-md-3 col-xs-3 padding0">';
				div=div+'<div class="form-group formwithsearch marginbottom20">';
					div=div+'<div class="icon-addon addon-md">';
						div=div+'<label for="exampleInputEmail1">Style</label>';
						div=div+'<select id="schmodelStyle" class="form-control" name="schmodelStyle"  onfocus="typaheadforroot(\'schmodelStyle\',\'id.styleId\')">';
							div=div+'<option></option>';
						div=div+'</select>';
						//div=div+'<input type="text" class="form-control" id="schmodelStyle">';
						div=div+'<span class="caret dropdowncaret"></span>';
					div=div+'</div>';
				div=div+'</div>  ';        
				div=div+'<div class="clearfix"></div>   ';    
			div=div+'</div>';
			div=div+'<div class="col-sm-2 col-md-2 col-xs-2 pull-left marginTop35">';
				div=div+'<button onclick="getContent(\'schmodelroutfinder\')" type="button" class="btn btn-info btn-embossed marginbottom20 pull-right resopnsive-fix-search-oprt"><span class="glyphicon glyphicon-search marginRight6">';
				div=div+'</span> Search Routes</button>';
			div=div+'</div>';
			div=div+'<div class="dataTables_wrapper">';
				div=div+'<section>';
					//div=div+'<div class="table-wrapper-modal">';
					div=div+'<table id="style-operations-popup" class="display table table-striped table-bordered table-hover" cellspacing="0">';
						div=div+'<thead>';
							div=div+'<tr>';
								div=div+'<th>Route ID</th>';
								div=div+'<th>Route Name</th>';
								div=div+'<th>Style</th>';                        
							div=div+'</tr>';
						div=div+'</thead>';
						div=div+'<tbody id="stuleroutecopytbody"> ';
	                      //  <tr class="gradeX"> <td>1254783 </td>  <td>Lorem Ipsum </td> <td>Lorem Ipsum </td> </tr>  
						div=div+'</tbody>';
					div=div+'</table>';
				//	div=div+'</div>';
				div=div+'</section>';
			div=div+'</div>';
			div=div+'<div class="col-sm-2 col-md-2 col-xs-2 pull-left marginTop33 padding0">';
				div=div+'<button type="button" class="btn btn-embossed marginbottom20 resopnsive-fix-search-oprt remove-btn-bg-styles view-style-operations-jq paddingOnlyBottom"><span class="glyphicon glyphicon glyphicon-chevron-right marginRight6">';
				div=div+'</span>View Style Operations</button>';
				div=div+'<div class="clearfix"></div>';
			div=div+'</div>';
			div=div+'<div class="dataTables_wrapper table-toggle-jquery" > ';//style="display: none;"
				div=div+'<section>';
				//div=div+'<div class="table-wrapper-modal">';
					div=div+'<table id="style-operations-popup-2" class="display table table-striped table-bordered table-hover" cellspacing="0">';
						div=div+'<thead>';
							div=div+'<tr>';
								div=div+'<th>Opeartion No</th><th>Component Id</th><th>Main Color</th><th>operation Type</th><th>operation Description </th> ';           
							div=div+'</tr>';
						div=div+'</thead>';
						div=div+'<tbody id="stulerouteopeartioncopytbody">';
		                    	//<tr class="gradeX"> <td>1254783 </td>  <td>Lorem Ipsum </td> <td>Lorem Ipsum </td> </tr> --%>          
						div=div+'</tbody>';
					div=div+'</table>';
				//	div=div+'</div>';
				div=div+'</section>';
			div=div+'</div>';
			div=div+'<div id="submision" class="submit-button copy-cancel-bnts pull-right">';
				div=div+'<a><button id="back3" data-dismiss="modal" class="btn btn-default btn-lg">Cancel</button></a>';
				div=div+'<button class="btn btn-info btn-lg btn-embossed marginRight0" onclick="copyopeartions()" >Copy</button>';
			div=div+'</div>';
			div=div+'<div class="clearfix"></div>';
		div=div+'</div>';
	div=div+'</div>';
	
	document.getElementById("schmodalpopup").innerHTML=div;
	$('#style-operations-popup>tbody>tr').click(function(event) {
	    $('#style-operations-popup>tbody>tr').not(this).removeClass('clicked');
	    $(this).toggleClass('clicked'); 
	});
}


function addmodalpopup33(id){
	div='';
	div += '<div class="modal-dialog modal-lg">';
	div += '<div class="modal-content model-popup-padding">';
	div += '<div class="modal-header">';
	div += '<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">x</span><span class="sr-only">Close</span>';
	div += '</button>';
	div += '<h5 class="modal-title">View Combinations</h5>';
	div += '</div>';
	div += '<div class="row ">';
	div += '<div class="col-md-12">';
	div += '<h3 class="add-styl-rt">Select Size Dimensions Combinations</h3>';
	div += '<hr>';
	div += '</div>';
	div += '</div>';
	div += '<div id="popupGroupGrid"></div>';
	div=div+'<div id="submision" class="submit-button copy-cancel-bnts pull-right">';
	div=div+'<a><button id="back3" data-dismiss="modal" class="btn btn-default btn-lg">Close</button></a>';
	div=div+'<button class="btn btn-info btn-lg btn-embossed marginRight0" onclick="saveMatrix();" >Add</button>';
	div=div+'</div>';

	//div += '<div id="submision" class="submit-button styl-rt-submission-btn pull-right marginRight0 marginTop30">';
	//div += '<a><button id="popupback3" onclick="saveMatrix();" class="btn btn-default btn-lg">Save &amp; Close</button></a>';
	//div += '<button class="btn btn-info btn-lg btn-embossed mdlclose">Close</button>';
	//div += '</div>';
	div += '<div class="clearfix"></div>';
	div += '</div>';
	div += '</div>';
	document.getElementById("schmodalpopup").innerHTML=div;
}