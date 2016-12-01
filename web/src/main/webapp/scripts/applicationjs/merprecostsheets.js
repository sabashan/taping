var programId="4006";
var trnType="PCST";
var Currency=new Array();
var formdatatemp=null;
var SMV =new Array();
var selecteditemcategory="";
var selecteditemtype =""
var smvarray=0; 
var orgckkqty;

/**  new operation number*/
var newid;
/**
 * 
 * @param jsnrobj
 * @returns {String}
 */
function optioncreator(jsnrobj) {
	var div="<option></option>";
	for(var i =0;i<jsnrobj.length;i++){
		div=div+"<option>"+jsnrobj[i]+"</option>";
	}
	return div;
}


/**
 * 
 * @param ar
 */
function pcs_triger(ar){
	var str=new Array();
	var jsn;
	for(var i=0;i<ar.length;i++){
		var str2 = ar[i].split(":");
		str.push(str2[1].trim());
	}
	my=AjaxCall("POST","","services/api/mststyleheader/MststyleheaderByparam/"+str[4]+"/"+str[1]+"/"+str[3]+"/"+str[0]+"/"+str[2]+"/mststyleheader/NOT.json");
	if (my.readyState==4 && my.status==200){
	    json = JSON.parse(my.responseText);
	} 
	else{
		console.log("some thing wrong");
	}
	locationCode = document.getElementById("pcs_id_locationCode").value;
	custCode = document.getElementById("pcs_id_custCode").value;
	styleId = document.getElementById("pcs_id_styleId").value;
	depCode = document.getElementById("pcs_id_depCode").value;
	compCode = document.getElementById("pcs_id_compCode").value;
	
	if(json.length>0){
		$('#pcs_id_locationCode').trigger('onfocus'); document.getElementById('pcs_id_locationCode').value=json[0].id.locationCode;
		$('#pcs_id_depCode').trigger('onfocus'); document.getElementById('pcs_id_depCode').value=json[0].id.depCode;
		$('#pcs_id_compCode').trigger('onfocus'); document.getElementById('pcs_id_compCode').value=json[0].id.compCode;
		$('#pcs_id_custCode').trigger('onfocus'); document.getElementById('pcs_id_custCode').value=json[0].id.custCode;
		document.getElementById('pcs_styleDescription').value=json[0].styleDescription;
	}
	else{
		alert("wrong selection");
	}
}


function checkenter(e){
 var keyCode = e.which ? e.which : e.keyCode;
 if(keyCode==13){
 getCostsheets();
 }
}

/**
 * open a style which contain all style details in view mode
 */
function openstyle(){
	
	locationCode = document.getElementById("pcs_id_locationCode").value;
	custCode = document.getElementById("pcs_id_custCode").value;
	styleId = document.getElementById("pcs_id_styleId").value;
	depCode = document.getElementById("pcs_id_depCode").value;
	compCode = document.getElementById("pcs_id_compCode").value;
	
	if(locationCode !="" && custCode !="" && styleId  !="" && depCode !="" &&  compCode !="" ){
		var url = "mststylemasterview?styleId=" + styleId +
			"&locationCode=" + locationCode + "&compCode=" + compCode +  "&custCode=" + custCode + "&depCode=" + depCode;
		window.open(url,'_blank');
	}
	else if(locationCode =="" || custCode ==""  || depCode =="" ||  compCode =="" ){
		alert("Please select upper fildes");
	}
	else{
		alert("Please select Style ");
		
	}
}

/**
 * 
 * @param Component Id
 * @param Style Id
 * @param Location Code
 * @param Department Code
 * @param Company Code
 * @param Buyer Code
 * @returns style route  options  for given style 
 */
function getStyleRouteName(componentId,styleId,locationCode,depCode,compCode,custCode){
	var tsmv=0;
	var tsmv2=0;
	try{
		tsmv=document.getElementById("totalSmv").value;
		tsmv2= document.getElementById(componentId+"_SMV").value;
		if(tsmv!="" && tsmv !=null)
			tsmv=parseInt(tsmv);
		else
			tsmv=0;
		
		if(tsmv2!="" && tsmv2 !=null)
			tsmv2=parseInt(tsmv2);
		else
			tsmv2=0;
		document.getElementById("totalSmv").value = tsmv-tsmv2;
	}
	catch (e) {
		 console.log("some things wrong : "+ e);
	}
	_location=document.getElementById(componentId+"_location").value;
	if(_location==null || _location==""){
		alert("Select Location first");
		return false;
	}
	document.getElementById(componentId+"_SMV").value="";
	my=AjaxCall("POST","","services/api/styleroute/MststylerouteByparamquery/"+depCode+"/"+styleId+"/"+custCode+"/"+locationCode+"/NOT/NOT/"+componentId+"/"+compCode+"/"+_location+"/NOT/NOT.json");
	if (my.readyState==4 && my.status==200){
    	json = JSON.parse(my.responseText);
    }
    else{
        console.log("some things wrong");
    }//onclick='getStyleRouteName(\""+componentId+"\",\""+styleId+"\",\""+locationCode+"\",\""+depCode+"\",\""+compCode+"\",\""+custCode+"\")'
	var div="<option ></option>";
	for(var i =0;i<json.length;i++){
		div=div+"<option value='"+json[i].styleRouteId+"' >"+json[i].styleRouteName+"</option>";
	} 
    document.getElementById(componentId+"_styleRouteName").innerHTML=div;
}

/**
 * 
 * @param Url style parameters 
 * @param id smv box id
 * @returns smv value for given route 
 */
function  createSMV(Url,id){
	var tsmv=0;
	var tsmv2=0;
	if(Url!=null && Url!=""){
		my=AjaxCall("POST","","services/api/styleroute/routeSearchById/"+Url+".json");
		if (my.readyState==4 && my.status==200){
			jsons = JSON.parse(my.responseText);
			 document.getElementById(id+"_location").innerHTML="<option value='"+jsons.assignLocation+"'>"+jsons.assignLocation+"</option>"
		}
		
		if(Url!=null && Url!=""){
			try{
				tsmv=document.getElementById("totalSmv").value;
				tsmv2= document.getElementById(id+"_SMV").value;
				if(tsmv!="" && tsmv !=null)
					tsmv=parseInt(tsmv);
				else
					tsmv=0;
				if(tsmv2!="" && tsmv2 !=null)
					tsmv2=parseInt(tsmv2);
				else
					tsmv2=0;
			}
			catch (e) {
				 console.log("some things wrong : "+ e);
			}
			my=AjaxCall("POST","","services/api/mststyleoperation/getSMV/"+Url+".json");
			if (my.readyState==4 && my.status==200){
				jsons = JSON.parse(my.responseText);
				var json=0;
				for(var k=0;k<jsons.length;k++){
					json+=jsons[k];
				}
				console.log("pvalue " +tsmv2+" js : "+ json + " tsmv : " + tsmv);
				tsmv = tsmv-tsmv2;
				document.getElementById(id+"_SMV").value=json;
				document.getElementById("totalSmv").value = json+tsmv;
			}
			else{
				console.log("some things wrong");
				document.getElementById("totalSmv").value = tsmv-tsmv2;
				document.getElementById(id+"_SMV").value="";
			   
			}	
		}
	}
}

/**
 * 
 * @param location
 * @param id
 */
function createLinneff(location,id){
	if(location!="" || location!=null){
		my=AjaxCall("POST","","services/api/mstlocations/getByidfild/"+location+"/minuteValue.json");
		if (my.readyState==4 && my.status==200){
			jsons = JSON.parse(my.responseText);
			
		}
		else{
			document.getElementById(id+"_lineEfficiency").value=0;
			console.log("some things wrong");
			return false;
		}
		document.getElementById(id+"_lineEfficiency").value=jsons;
		document.getElementById(id+"_styleRouteName").innerHTML="";
	}
}

/**
 * 
 * @param id
 * @returns {Boolean}
 */
function savecostsheet(id){
	if(isstyleselect!="NO"){
		if(id=="COST1"){
			success = $('#merprecostsheetForm').valid();
			var formdata = jQuery("#merprecostsheetForm").serialize() +'&'+ jQuery("#merprecostsheetForm3").serialize(); 
			if(success){
				if(formdatatemp!=formdata){
				 console.log( componets.length);
						// set section 
					formdata += '&section=section1';
					//formdata += '&compWiseCost='+document.getElementById("compWiseCost").checked;
					// get all smv details 
					for(var i=0;i<componets.length;i++){
						var ritio=document.getElementById(componets[i]+"_Ratio").value;
						var location=document.getElementById(componets[i]+"_location").value;
						var styleRouteName=document.getElementById(componets[i]+"_styleRouteName").value
						var linedff=document.getElementById(componets[i]+"_lineEfficiency").value;
						var fmvCat=document.getElementById(componets[i]+"_pfmvCategory").value;
						var fmv=document.getElementById(componets[i]+"_fmv").value;
						var smv=document.getElementById(componets[i]+"_SMV").value
						
						if(linedff!=null && fmvCat!=null && fmv!=null && linedff!="" && fmvCat!="" && fmv!="" && ritio!=null && location!=null && smv!=null && smv!="" && styleRouteName!=null && ritio!="" && location!="" && styleRouteName!=""){
							var args=styleRouteName + ":" + location + ":"+ritio +":"+linedff+":"+fmvCat+":"+fmv+":"+smv;
							SMV.push(args)
						}
						else{
							alert("Please Fill SMV details");
							return false;
						}	
					}
					if(document.getElementById("preCostSheetNo").value==''  || document.getElementById("preCostSheetNo").value==null){
						//get next next costsheet no 
						/*var my=  AjaxCall("POST", "", "services/api/mstnumbers/getnexttrnNo/"+mstlocation+"/"+programId+"/"+trnType+".json"); 
						if (my.readyState == 4 && my.status == 200) {
							newid = JSON.parse(my.responseText);
						}
						else{
							 console.log("Some things wrong");
						}*/
					}
					else{
						newid=document.getElementById("preCostSheetNo").value;
					}
					// add smv array and curency array
					formdata +="&smvvalues="+SMV;
					formdata +="&currency="+Currency;
					
					var success=  AjaxCall("POST", formdata, "merprecostsheetform");
					if (success.readyState == 4 && success.status == 200) {
						document.getElementById("versionNo").value=0;
						//alert(success.responseXML)
						newid=getCookie("preCostSheetNo"); 
						costsheetType=document.getElementById("costsheetType").value;
						if(newid>0){
							window.location.replace("merprecostsheetform?preCostSheetNo="+(newid)+"&versionNo=0&costsheetType="+costsheetType+"&edit=editmode&section=COST1");
						}
						else if(document.getElementById("preCostSheetNo").value>0){
							for(var i=itemtypecatogery.length-1;i>-1;i--){
								 navigterowMat(itemtypecatogery[i]);
								 console.log(itemtypecatogery[i]);
							}
							selecteditemcategory=itemtypecatogery[0];
						 	precostsheetnavigation("profile");
						}
					}
					else{
						alert("Some things wrong")
						location.reload();
					}
				}
				else{
					console.log("same");
					for(var i=itemtypecatogery.length-1;i>-1;i--){
						 navigterowMat(itemtypecatogery[i]);
						 console.log(itemtypecatogery[i]);
					}
					selecteditemcategory=itemtypecatogery[0];
				 	precostsheetnavigation("profile");
				 }
			 }
			 else{
				 alert("Please Fill  Required details");
					return false;
			 }
			 
			 
			 
		}
		else if(id=="COST2"){
			var formdata = jQuery("#merprecostsheetForm").serialize() +'&'+ jQuery("#merprecostsheetForm3").serialize() +'&'+ jQuery("#merprecostsheetForm2").serialize(); 
			var suss=$('#merprecostsheetForm2').valid();
			if(suss){
				var consmptions =new Array();
				if(document.getElementById("compWiseCost").checked){
					var status=false;
					for(var i=0;i<componets.length;i++){
						var consumption=document.getElementById(componets[i]+"com_consumption").value;
						var UMO=document.getElementById(componets[i]+"_UMO").value;
						var allowance=document.getElementById(componets[i]+"com_allowance").value;
						if(UMO!=null && consumption!=null && UMO!="" && consumption!="" ){
							console.log(componets[i]+":"+consumption+":"+UMO+":"+allowance);
							if(allowance=="" || allowance==null){
								allowance=0;
							}
							consmptions.push(componets[i]+":"+consumption+":"+UMO+":"+allowance);
							status=true;
						}
						
					}
					if(!status){
							alert("Please Fill atleast one SMV details");
							return false;
					}
					formdata += '&consmptions='+consmptions;
				 }
				else{
					formdata += '&consmptions='+componets;
				}
			}
			else{
				alert("Please Fill Mandetory  details");
				return false;
			}
			formdata += '&section=section2';
			formdata += '&itemcategory='+selecteditemcategory;
			var success=  AjaxCall("POST", formdata, "merprecostsheetform");
			if (success.readyState == 4 && success.status == 200) {
				navigterowMat(selecteditemcategory,"");
			
				HideAddRow_mat();showRow_matGrid();
				
			}
			else{
				alert("Some things wrong");
				location.reload();
			}
			
		}
		else if(id=="COST3"){
			var formdata = jQuery("#merprecostsheetForm").serialize() +'&'+ jQuery("#merprecostsheetForm3").serialize(); 
			if(formdatatemp!=formdata){
				formdata += '&section=section3';
				formdata += '&shellFabric='+shellFabric;
				formdata += '&itemcategory='+selecteditemcategory;
				var success=  AjaxCall("POST", formdata, "merprecostsheetform");
				if (success.readyState == 4 && success.status == 200) {
					navigterowMat(selecteditemcategory,"");
					formdatatemp=formdata;
					versionNo=document.getElementById("versionNo").value;
					preCostSheetNo=document.getElementById("preCostSheetNo").value;
					costsheetType=document.getElementById("costsheetType").value;
					window.location.replace("merprecostsheetsview?preCostSheetNo="+preCostSheetNo+"&versionNo="+versionNo+"&costsheetType="+costsheetType);					
				
				}
				else{
					alert("Some things wrong");
					location.reload();
				}
			}
			else{
				window.location.replace("merprecostsheetsview?preCostSheetNo="+preCostSheetNo+"&versionNo="+versionNo+"&costsheetType="+costsheetType);					
				
			}
		}
		else if(id=="COST22"){
			var formdata = jQuery("#merprecostsheetForm").serialize() +'&'+ jQuery("#merprecostsheetForm3").serialize() +'&'+ jQuery("#merprecostsheetForm2").serialize(); 
			var consmptions =new Array();
			var consumption=document.getElementById(editmodeComponent+"com_consumption").value;
			var UMO=document.getElementById(editmodeComponent+"_UMO").value;
			var allowance=document.getElementById(editmodeComponent+"com_allowance").value;
			if(allowance!=null && UMO!=null && consumption!=null){
				formdata += '&allowance='+allowance; 
				formdata += '&consumption='+consumption;
				formdata += '&UMO='+UMO; 
			}
			else{
				alert("Please Fill SMV details");
				return false;
			}
			itemType=document.getElementById("itemType").value;
			formdata += '&itemType='+itemType;
			formdata += '&section=section2&editRowMat=true';
			formdata +='&precostsheetRowMatCode='+editmodeprecostsheetRowMatCode;
			formdata += '&itemcategory='+selecteditemcategory;
			formdata += '&component='+editmodeComponent;
			var success=  AjaxCall("POST", formdata, "merprecostsheetform");
			if (success.readyState == 4 && success.status == 200) {
				versionNo=document.getElementById("versionNo").value;
				preCostSheetNo=document.getElementById("preCostSheetNo").value;
				costsheetType=document.getElementById("costsheetType").value;
				window.location.replace("merprecostsheetform?preCostSheetNo="+preCostSheetNo+"&versionNo="+versionNo+"&costsheetType="+costsheetType+"&edit=editmode&section=COST1");
				
			}
			else{
				alert("Some things wrong");
				location.reload();
			}
			
		}
	}
	else{
		alert("Please select Style before proceed ");
	}
}

/**
 * 
 * @param id
 * @returns component wise costing table
 */
function addcomvscost1(id) {
	var div ='<div class="col-sm-4 col-md-4 ">';
	 		div +='<div class="form-group formwithsearch marginbottom20">';
	 			div +='<div class="icon-addon addon-md">';
	 				div +='<label for="exampleInputEmail1">Consumption </label>';
 					div +='<input type="text" class="form-control" id="consumption" name="consumption">';
				div +='</div>';
			div +='</div>  ';
			div +='	<div class="clearfix"></div> ';
		div +='</div>';
		div +='<div class="col-sm-4 col-md-4 ">';
			div +='<div class="form-group formwithsearch marginbottom20">';
				div +='<div class="icon-addon addon-md">';
					div +='	<label for="exampleInputEmail1">UOM </label>';
					div +='<select required="required" type="text" name="UMO" id ="UMO" class="form-control" onfocus="getUOM(\'UMO\')"></select>';			
					div +='<span class="caret dropdowncaret"></span>';
				div +='	</div>';
			div +='	</div>  ';
			div +='	<div class="clearfix"></div> ';
		div +='</div>';
		div +='<div class="col-sm-4 col-md-4 ">';
			div +='<div class="form-group formwithsearch marginbottom20">';
				div +='	<div class="icon-addon addon-md">';
					div +='<label for="exampleInputEmail1">Allowance % </label>';
					div +='<input type="text" class="form-control" id="allowance" name="allowance">';
				div +='	</div>';
			div +='</div>  ';
			div +='<div class="clearfix"></div> ';
		div +='</div>';
		div +='<div class="clearfix"></div> ';
		
		 document.getElementById(id).innerHTML=div;
}
/**
 * @returns currency table
 */
function addcurrencytable(){
	var div ='';
			div +='<td class="textcenter">';
				div +='<div class="icon-addon addon-md">';
					div +='<select id="curencycode" type="text" class="form-control" onfocus="getOptions(\'curencycode\',\'mstcurrency\')">';
						
					div +='	</select>';
					div +='<span class="caret dropdowncaret"></span>';
				div +='</div>'; 
			div +='</td>';
			div +='<td class="textcenter">';
				div +='<div class="icon-addon addon-md">';
					div +='<input onkeypress="return IsNumericdecimal(event,this.id)" ondrop="return false;" onpaste="return false;" id="curencyrate" type="text" class="form-control">';
						div +='<span id="errorcurencyrate" style="color: Red; display: none">* Input digits (0 - 9)</span>';
				div +=' </div>';
			div +='</td>';
			div +=' <td class="center">';
				div +='<div class="middle-align-editable">';
					div +='<div class="edit-toggle view-btn">';
						div +='<a class="edit" onclick="AddCurency()"><span class="glyphicon glyphicon-plus"></span> Add</a>';
					div +='</div>';
					div +='<div class="delete-toggle">';
						div +='<a class="delete" onclick="if ( confirm(\'do you really need to delete this ?\') == true) {addcurrencytable()}"><span class="glyphicon glyphicon-remove"></span> Clear </a> ';
					div +='</div>';
				div +='</div>';
			div +='</td>';
			 console.log("add to table")
		 document.getElementById("editablecur").innerHTML=div;
}
/**
 * add currency to currenct array 
 */
function AddCurency(){
	var curencycode = document.getElementById("curencycode").value;
	var curencyrate = document.getElementById("curencyrate").value;
	 console.log("add to table");
	
	if(curencycode!=null  && curencycode!="" &&  curencyrate!=null &&  curencyrate!=""){
		
		if(document.getElementById("code" + curencycode )==null){
			
			creartcurtable(curencycode,curencyrate);
		}
		else{
			alert("Duplicates");
		}
	}
	else{
		alert("null values not allowed !");
	}
}
/**
 * 
 * @param curencycode
 * @param curencyrate
 * @returns create currency table
 */
function creartcurtable(curencycode,curencyrate){
	var key=curencycode+":"+curencyrate;
	Currency.push(key);
	var div ='<tr id="code'+curencycode +'">';
	div +='<td class="textcenter">';
		div +='<div class="icon-addon addon-md">';
			div +='<lable>'+curencycode+'</lable>';
		div +='</div>'; 
	div +='</td>';
	div +='<td class="textcenter">';
		div +='<div class="icon-addon addon-md">';
			div +='<lable>'+curencyrate+'</lable>';
		div +=' </div>';
	div +='</td>';
	div +=' <td class="center">';
		div +='<div class="middle-align-editable">';
			div +='<div class="edit-toggle view-btn">';
				div +='<a class="edit" onclick="EditCurency(\''+curencycode+'\',\''+curencyrate+'\')"><span class="glyphicon glyphicon-plus"></span> Edit</a>';
			div +='</div>';
			div +='<div class="delete-toggle">';
				div +='<a class="delete" onclick=" if ( confirm(\'do you really need to delete this ?\') == true) {deletecurrency(\''+curencycode+'\',\''+curencyrate+'\')}"><span class="glyphicon glyphicon-remove"></span> Delete </a> ';
			div +='</div>';
		div +='</div>';
	div +='</td>';
div +='</tr>';

$("#currencytable").append(div); 
addcurrencytable();
}

/**
 * 
 * @param curencycode
 * @param curencyrate
 * delete currency in currency array
 */
function  deletecurrency(curencycode,curencyrate) {
	toggle_visibility('code'+curencycode);
	Currency.splice(Currency.indexOf(curencycode+':'+curencyrate));
}

/**
 * 
 * @param curencycode
 * @param curencyrate
 * currency edite mode function
 */
function EditCurency(curencycode,curencyrate){
	var curencycode2 = document.getElementById("curencycode").value;
	var curencyrate2 = document.getElementById("curencyrate").value;
	if(curencycode2!=null  && curencycode2!="" &&  curencyrate2!=null &&  curencyrate2!=""){
		alert("Please save uncomplete currency befor proceed ");
	}
	else{
		console.log("code  "+curencycode);
		toggle_visibility("code"+curencycode);
		Currency.splice(Currency.indexOf(curencycode+":"+curencyrate));
		var div ='';
		div +='<td class="textcenter">';
			div +='<div class="icon-addon addon-md">';
				div +='<select id="curencycode" type="text" value="'+curencycode+'" class="form-control"  onfocus="getOptions(\'curencycode\',\'mstcurrency\')"  >';
				div +='<option>'+curencycode+'</option>';
				div +='</select>';
				div +='<span class="caret dropdowncaret"></span>';
			div +='</div>'; 
		div +='</td>';
		div +='<td class="textcenter">';
			div +='<div class="icon-addon addon-md">';
				div +='<input id="curencyrate" onkeypress="return IsNumericdecimal(event,this.id)" ondrop="return false;" onpaste="return false;" value="'+curencyrate+'" type="text" class="form-control">';
					div +='<span id="errorcurencyrate" style="color: Red; display: none">* Input digits (0 - 9)</span>';
			div +=' </div>';
		div +='</td>';
		div +=' <td class="center">';
			div +='<div class="middle-align-editable">';
				div +='<div class="edit-toggle view-btn">';
					div +='<a class="edit" onclick="AddCurency()"><span class="glyphicon glyphicon-plus"></span> Update</a>';
				div +='</div>';
				div +='<div class="delete-toggle">';
					div +='<a class="delete" onclick="addcurrencytable(\'editablecur\')"><span class="glyphicon glyphicon-remove"></span> Clear </a> ';
				div +='</div>';
			div +='</div>';
		div +='</td>';
	
	 document.getElementById("editablecur").innerHTML=div;
	}
}
/**
 * 
 * @param styleRouteId
 * @param ratio
 * @param routeLocation
 */
function addsmv(styleRouteId,ratio,routeLocation,styleRouteName,lineEfficency,fmvCategory,fmv,smv) {
	try{
		console.log(componets[smvarray]+"_pfmvCategory "+fmvCategory +" " +componets[smvarray]);
		document.getElementById(componets[smvarray]+"_location").innerHTML="<option value='"+routeLocation+"'>"+routeLocation+"</option>";
		document.getElementById(componets[smvarray]+"_styleRouteName").innerHTML="<option value='"+styleRouteId+"'>"+styleRouteName+"</option>";
		document.getElementById(componets[smvarray]+"_Ratio").value=ratio;
		
		document.getElementById(componets[smvarray]+"_fmv").value=fmv;
		document.getElementById(componets[smvarray]+"_lineEfficiency").value=lineEfficency;
		document.getElementById(componets[smvarray]+"_pfmvCategory").innerHTML="<option value='"+fmvCategory+"'>"+fmvCategory+"</option>";
		
		createSMV(styleRouteId,componets[smvarray]);
		//document.getElementById(componets[smvarray]+"_SMV").value=smv;
		
		
		
	}catch (e) {
		console.log(e);
	}
	smvarray++;			
}
/**
 * 
 * @param id
 */
function precostsheetnavigation(id){
	if(isstyleselect!="NO"){
		$('#home').hide();
		$('#profile').hide();
		$('#Pricing').hide();
		
		$('#'+id).show();
		$('#n'+id).removeClass( "disabled" );
        $('#n'+id).addClass( "active" );
	}
	else{
		alert("Please select Style before proceed ");
	}
	if(id=="Pricing"){
		calculatepricing();
		
	}
}


var services_cost=0;
var fabric=0;
var packing=0;
var trims=0;
var finance=0;
var MarkupV=0;
var external_commissionV=0;
var buyer_commissionV=0;
var MarkupP=0;
var external_commissionP=0;
var buyer_commissionP=0;
var fmv=0;
var totalSmv=0;
var lineEfficiency=0;
var Selling_price=0;
var total_cost=0;
var Markupavg=0 ;

/**
 * caculate cost fomulas
 */
function calculatepricing(){
	services_cost=getrowmat_totalcost("SERVICE","NOT");
	fabric=getrowmat_totalcost("FABRIC","NOT");
	packing=getrowmat_totalcost("PACKING","NOT");
	trims=getrowmat_totalcost("TRIMS","NOT");
	finance=getrowmat_totalcost("NOT","NOT");
	console.log(services_cost +" - "+fabric +" - "+ packing+" - "+ trims+" - "+ finance);
	
	
	MarkupV=converttoflot(document.getElementById("markupV").value);
	//MarkupP=converttoflot(document.getElementById("markupP").value);
	external_commissionV=converttoflot(document.getElementById("external_commissionV").value);
	//external_commissionP=converttoflot(document.getElementById("external_commissionP").value);
	buyer_commissionV=converttoflot(document.getElementById("buyer_commissionV").value);
	//buyer_commissionP=converttoflot(document.getElementById("buyer_commissionP").value);
	//fmv=converttoflot(document.getElementById("fmv").value);
	totalSmv=converttoflot(document.getElementById("totalSmv").value);
	lineEfficiency=0;
	cm=0;
	totalSmv=0;
	fmv=0;
	console.log(componets.length);
	for(var k=0;k<componets.length;k++){
		
		_lineEfficiency=converttoflot(document.getElementById(componets[k]+"_lineEfficiency").value);
		_SMV=converttoflot(document.getElementById(componets[k]+"_SMV").value);
		_fmv=converttoflot(document.getElementById(componets[k]+"_fmv").value)
		lineEfficiency +=_lineEfficiency;
		cm +=_SMV*_fmv*_lineEfficiency;
		console.log(cm +" "+_SMV+" "+_fmv+" "+_lineEfficiency);
		totalSmv +=_SMV;
		fmv +=_fmv;
	}
	//lineEfficiency=converttoflot(document.getElementById("lineEfficiency").value);
	lineEfficiency=lineEfficiency/componets.length;
	
	console.log(totalSmv+" - "+fmv+" - "+lineEfficiency+" - "+MarkupV+" - "+packing+" - "+services_cost+" - "+trims);
	//cmt=totalSmv*fmv*lineEfficiency+MarkupV+(packing+services_cost+trims);
	cmt=cm+MarkupV+(packing+services_cost+trims);
	Rmcost=packing+fabric+trims;
	total_cost=Rmcost+ services_cost+ cm+ finance;
	Markupamount= total_cost+MarkupV;
	Markupavg=(MarkupV+100)/100.000;
	Selling_price= (total_cost+MarkupV)+ buyer_commissionV+ external_commissionV;
	our_price= (total_cost+MarkupV)+ buyer_commissionV;
	
	document.getElementById("finance_cost").value=finance;
	document.getElementById("raw_material_cost").value=Rmcost;
	document.getElementById("services_cost").value=services_cost;
	document.getElementById("CM").value=cm;
	document.getElementById("CMT").value=cmt;
	document.getElementById("total_cost").value=total_cost
	document.getElementById("popover_content_wrapper").innerHTML=getcostingmodal(services_cost,fabric,trims,finance);
	
	document.getElementById("selling_price").value=Selling_price;
	document.getElementById("our_price").value=our_price;
	
	MarkupP=(MarkupV/total_cost)*100;
	document.getElementById("markupP").value=MarkupP;
	buyer_commissionP=(external_commissionV/total_cost)*100;
	document.getElementById("buyer_commissionP").value=buyer_commissionP;
	external_commissionP=(external_commissionV/total_cost)*100;
	document.getElementById("external_commissionP").value=external_commissionP;

	document.getElementById("markupV").value=MarkupV;
	document.getElementById("buyer_commissionV").value=buyer_commissionV;
	document.getElementById("external_commissionV").value=external_commissionV;
	
	console.log(external_commissionP +" - "+buyer_commissionP +" - "+ MarkupP+" - "+ trims+" - "+ finance);
}

/**
 * 
 */
function getsheelfab(id){
	var my=  AjaxCall("POST", "", "services/api/merprecostsheetrowmaterial/GetAllfrmfld/"+preCostSheetNo+"/"+versionNo+"/"+costsheetType+"/FABRIC/id,mstitem.id.itemCode.json");
	var div='<option onclick=\'selectshellfabric("","","","","",null)\'></option>';
  	if (my.readyState == 4 && my.status == 200) {
		jsons = JSON.parse(my.responseText);
    	for(var k=0;k<jsons.length;k++){
    		div+='<option onclick=\'selectshellfabric("'+jsons[k][0].preCostSheetNo+'","'+jsons[k][0].versionNo+'","'+jsons[k][0].costsheetType+'","'+jsons[k][0].precostsheetRowMatCode+'","'+jsons[k][0].component+'","'+jsons[k][1]+'")\' >' + jsons[k][1] +'</option>';
		}
		document.getElementById(id).innerHTML=div;
	}
	
}
var shellFabric =new Array();
var updatejsn=null;
/**
 * 
 * @param preCostSheetNo
 * @param versionNo
 * @param costsheetType
 * @param precostsheetRowMatCode
 * @param component
 * @param itemCode
 */
function selectshellfabric(preCostSheetNo,versionNo,costsheetType,precostsheetRowMatCode,component,itemCode){
	if(document.getElementById(itemCode)==null && itemCode){
		var my=  AjaxCall("POST", "", "services/api/merprecostsheetrowmaterial/GetByid/"+preCostSheetNo+"/"+versionNo+"/"+costsheetType+"/"+precostsheetRowMatCode+"/"+component+".json");
	  	if (my.readyState == 4 && my.status == 200) {
	  		updatejsn = JSON.parse(my.responseText);	
	  	}
	  	else{
	  		updatejsn=null;
	  	}
	  	 
	}
	else{
		updatejsn=null;
	}
  	//shellFabbody
}
function addshellfab(){
	jsons=updatejsn;
	var div="";
	if(updatejsn && document.getElementById(jsons.mstitem.id.itemCode)==null){
		try{
			div +='<tr class="gradeX" id="'+jsons.mstitem.id.itemCode+'">';
				div +='<td class="textcenter">'+jsons.mstitem.id.itemCode;
				div +='</td>';
				div +='<td class="textcenter">'+jsons.itemDecription;
				div +='</td>';
				div +='<td class="textcenter">'+jsons.itemColor;
				div +='</td>';
				div +='<td class="textcenter">'+jsons.itemWidth;
				div +='</td>';
				div +='<td class="center">';
					div +='<div class="middle-align-editable">';
						div +='<div class="delete-toggle deleteBtnMargin">';
						div +='<a class="delete" onclick="deleteshellfab(\''+jsons.mstitem.id.itemCode+'\',\''+jsons.mstitem.id.itemType+'\')"><span class="glyphicon glyphicon-remove"></span>  Delete</a> ';
						div +='</div>';
					div +='</div>';
				div +='</td>';
			div +='</tr>';
			shellFabric.push(jsons.mstitem.id.itemType+":"+jsons.mstitem.id.itemCode);
		}
		catch (e) {
			console.log(e);
		}
		$("#shellFabbody").append(div);
	}
	else{
		if(jsons!=null)
		alert("duplicates : "+ jsons.mstitem.id.itemCode);
	}
}
/**
 * 
 * @param itemCode
 * @param itemType
 */
function deleteshellfab(itemCode,itemType){
	index =arrayindex(shellFabric,itemType+':'+itemCode)	
	if(index>=0){
		shellFabric.splice(index,1);
		toggle_visibility(itemCode );
	}
	else{
		console.log(itemCode+':'+itemCode+ ": indx : "+index);	
	}
}


/*
 * 
 */
function refigercost(type) {
	
	tour_price=converttoflot(document.getElementById("our_price").value);
	tSelling_price=converttoflot(document.getElementById("selling_price").value);
	tmarkupV=converttoflot(document.getElementById("markupV").value);
	tmarkupP=converttoflot(document.getElementById("markupP").value);
	tbuyer_commissionV=converttoflot(document.getElementById("buyer_commissionV").value);
	tbuyer_commissionP=converttoflot(document.getElementById("buyer_commissionP").value);
	texternal_commissionV=converttoflot(document.getElementById("external_commissionV").value);
	texternal_commissionP=converttoflot(document.getElementById("external_commissionP").value);
	
	if(type=='selling_price'){
		markupV= tSelling_price -(buyer_commissionV+ external_commissionV +total_cost);
		if(tSelling_price!=Selling_price){
			total_costs=(-1)*total_cost;
			if(markupV>=total_costs){
				Selling_price=tSelling_price;
				markupP=(markupV/total_cost)*100;
				our_price= (total_cost+markupV)+ buyer_commissionV;
				document.getElementById("our_price").value=our_price;
				document.getElementById("markupV").value=markupV;
				document.getElementById("markupP").value=markupP;
				
			}
			else{
				alert("Minimum Our price  should be 0");
				document.getElementById("selling_price").value=Selling_price;
			}
		}	
	}
	else if(type=='markupV'){
		if(tmarkupV!=markupV){
			total_costs=(-1)*total_cost;
			if(tmarkupV>=total_costs){
				markupV=tmarkupV;
				markupP=(markupV/total_cost)*100;
				Selling_price= (total_cost+markupV)+ buyer_commissionV+ external_commissionV;
				our_price= (total_cost+markupV)+ buyer_commissionV;
				
				document.getElementById("our_price").value=our_price;
				document.getElementById("selling_price").value=Selling_price;
				document.getElementById("markupP").value=markupP;
			}
			else{
				alert("Minimum Our price  should be 0 ");
				document.getElementById("selling_price").value=markupV;
			}
		}
	}
	else if(type=='markupP'){
		if(tmarkupP!=markupP){
			if(tmarkupP>=-100 ){
				markupP=tmarkupP;
				markupV=(markupP*total_cost)/100.0;
				Selling_price= (total_cost+markupV)+ buyer_commissionV+ external_commissionV;
				our_price= (total_cost+markupV)+ buyer_commissionV;
				
				document.getElementById("our_price").value=our_price;
				document.getElementById("selling_price").value=Selling_price;
				document.getElementById("markupV").value=markupV;
			}
			else{
				alert("Percentage should be greater than 0 and less than 100");
				document.getElementById("markupP").value=tmarkupP;
			}
		}
	}
	else if(type=='buyer_commissionV'){
		if(tbuyer_commissionV!=buyer_commissionV){
			if(tbuyer_commissionV>=0){
				buyer_commissionV=tbuyer_commissionV;
				Selling_price= (total_cost+markupV)+ buyer_commissionV+ external_commissionV;
				our_price= (total_cost+markupV)+ buyer_commissionV;
				buyer_commissionP=(buyer_commissionV/total_cost)*100.0;
				
				document.getElementById("our_price").value=our_price;
				document.getElementById("selling_price").value=Selling_price;
				document.getElementById("buyer_commissionP").value=buyer_commissionP;
			}
			else{
				alert("buyer commission  should be greater than 0 ");
				document.getElementById("buyer_commissionV").value=buyer_commissionV;
			}
		}
			
	}
	else if(type=='buyer_commissionP'){
		if(tbuyer_commissionP!=buyer_commissionP){
			if(tbuyer_commissionP>=0 && tbuyer_commissionP<=100 ){
				buyer_commissionP=tbuyer_commissionP;
				buyer_commissionV=(buyer_commissionP*total_cost)/100.0;
				Selling_price= (total_cost+markupV)+ buyer_commissionV+ external_commissionV;
				our_price= (total_cost+markupV)+ buyer_commissionV;
				
				document.getElementById("our_price").value=our_price;
				document.getElementById("selling_price").value=Selling_price;
				document.getElementById("buyer_commissionV").value=buyer_commissionV;
			}
			else{
				alert("Percentage should be greater than 0 and less than 100");
				document.getElementById("buyer_commissionP").value=buyer_commissionP;
			}
		}
	}
	else if(type=='external_commissionV'){
		if(texternal_commissionV!=external_commissionV){
			if(texternal_commissionV>=0){
				external_commissionV=texternal_commissionV;
				Selling_price= (total_cost+markupV)+ buyer_commissionV+ external_commissionV;
				our_price= (total_cost+markupV)+ buyer_commissionV;
				external_commissionP=(external_commissionV/total_cost)*100.0;
			
				document.getElementById("our_price").value=our_price;
				document.getElementById("selling_price").value=Selling_price;
				document.getElementById("external_commissionP").value=external_commissionP;
			}
			else{
				alert("external commission  should be greater than 0 ");
				document.getElementById("external_commissionV").value=external_commissionV;
			}
		}
	}
	else if(type=='external_commissionP'){
		if(external_commissionP!=texternal_commissionP){
			if(texternal_commissionP>=0 && texternal_commissionP<=100 ){
				external_commissionP=texternal_commissionP;
				external_commissionV=(external_commissionP*total_cost)/100.0;
				Selling_price= (total_cost+markupV)+ buyer_commissionV+ external_commissionV;
				our_price= (total_cost+markupV)+ external_commissionV;
			
				document.getElementById("our_price").value=our_price;
				document.getElementById("selling_price").value=Selling_price;
				document.getElementById("external_commissionV").value=external_commissionV;
			}
			else{
				alert("Percentage should be greater than 0 and less than 100");
				document.getElementById("external_commissionP").value=external_commissionP;
			}
		}
	}
	else{
		
	}
	
} 
/**
 * 
 * @param services_cost
 * @param fabric
 * @param trims
 * @param finance
 * @returns {String}
 */
function getcostingmodal(services_cost,fabric,trims,finance){
		var div ='<div class="popover-content">';
				div+='<ul class="first">';
					div+='<li>Fabric - '+fabric+'</li>';
					div+='<li>Services  - '+services_cost+'</li>';
				div+='</ul>';
			div+='</div>';
			div+='<div class="clearfix">';
				div+='<ul class="second">';
					div+='<li>finance - '+finance+'</li>';
					div+='<li>Trims - '+trims+'</li>';
				div+='</ul>';
			div+='</div>';
	return div;
}
/**
 * 
 * @param type
 * @param fld
 * @returns
 */
function getrowmat_totalcost(type ,fld) {

	var my=  AjaxCall("POST", "", "services/api/merprecostsheetrowmaterial/GetAllfrmfld/"+preCostSheetNo+"/"+versionNo+"/"+costsheetType+"/"+type+"/"+fld+".json");
	if (my.readyState==4 && my.status==200){
    	jsons = JSON.parse(my.responseText);
    	var json=0;
    	for(var k=0;k<jsons.length;k++){
    		if(type!="NOT")
    			json+=jsons[k].price*(jsons[k].consumption+(jsons[k].consumption*jsons[k].allowance/100.0));
    		else{
    			//alert("fin "+( jsons[k].price*(jsons[k].consumption+(jsons[k].consumption*jsons[k].allowance)))*jsons[k].finance);
    			json+=(jsons[k].price*(jsons[k].consumption+(jsons[k].consumption*jsons[k].allowance/100.0)))*jsons[k].finance/100.0;
    		}
    		console.log(type+"  "+ json);
    	}
    	
    }
    else{
        console.log("some things wrong"); 
    }
	return converttoflot(json);
}
/**
 * 
 */
function showAddRow_mat(){
	$('#pannel2Body').collapse('show');
	document.getElementById('pannel2Body').className = "panel-collapse collapse in";
}
/**
 * 
 */
function HideAddRow_mat(){
	$('#pannel2Body').collapse('show');
	document.getElementById('pannel2Body').className = "panel-collapse collapse";
}
/**
 * 
 */
function showRow_matGrid(){
	$('#rowMaterialScreenBody').collapse('show');
	document.getElementById('rowMaterialScreenBody').className = "panel-collapse collapse in";
}
/**
 * 
 */
function HideRow_matGrid(){
	$('#rowMaterialScreenBody').collapse('show');
	document.getElementById('rowMaterialScreenBody').className = "panel-collapse collapse";
}


/**
 * 
 * @param id
 * @returns rowmaterial grid for selected rowmaterial type 
 */
function navigterowMat(id,stsus){
	preCostSheetNo=document.getElementById("preCostSheetNo").value;
	versionNo=document.getElementById("versionNo").value;
	costsheetType=document.getElementById("costsheetType").value;
	if(preCostSheetNo==""||versionNo==""||costsheetType==""){
		
	}
	else{	
	var div="";
	console.log(stsus);
		if(stsus!="View"){
		div +='<div class="panel panel-default">';
			div  +='<div id="'+id+'colps"  class="panel-heading" data-toggle="collapse" data-parent="#rowMaterialScreen" data-target="#rowMaterialScreenBody">';
				div  +='<h4 class="panel-title">';
					div  +='<a  data-toggle="collapse" data-parent="#rowMaterialScreen" href="#rowMaterialScreenBody"></a>';
					div  +='<a class="accordion-toggle"> <span  class="pull-right slideupdowntoggle glyphicon glyphicon-chevron-up"></span>Added Raw Material Items</a>';  
				div  +='</h4>';
			div  +='</div>';
			}
		else{
			div +='<div >';
		}
		if(stsus!="View"){
			div  +='<div id="rowMaterialScreenBody" class="panel-collapse collapse in" style="height: auto;">';
				div  +='<div class="panel-body">';
		}
		else{
			div +='<div >';
				div +='<div >';
		}
					div  +='<div class="row">';
						div  +='<div class="pull-right margin-addstyleroute">';
							div  +='<div class="input-group custom-search-form " style="width: 390px;">';
								div  +='<input type="text" class="form-control" placeholder="Search and Filter">';
								div  +='<span class="input-group-btn">';
									div  +='<button class="btn btn-info search-form-btn" type="button"  onclick="getRowmat(\''+id+'\')">';
										div  +='<span class="glyphicon glyphicon-search"></span>';
									div  +='</button>';
								div  +='</span>';
								if(stsus!="View")
								div  +='<a onclick="HideRow_matGrid();showAddRow_mat();document.getElementById(\'merprecostsheetForm2\').reset();" class="btn btn-warning btn-embossed pull-right"><span class="glyphicon glyphicon-plus marginRight4"></span>Add  Row Material</a>';
							div  +='</div>';
						div  +='</div>';
					div  +='</div>';
					div  +='<div class="dataTables_wrapper Scroll-for-datatable-add-row-matirials">';
						div  +='<section class="pre_cost_sheet_row_section_new">';
							div  +='<table id="route" class="display table table-striped table-bordered" cellspacing="0">';
								div  +='<thead>';
									div  +='<tr>';
										div  +='<th class="textcenter">Component</th>';
										div  +='<th class="textcenter">Item Type</th>';
										div  +='<th class="textcenter">Item Code</th>';
										div  +='<th class="textcenter">Item Description</th>';
										div  +='<th class="textcenter">Color</th>';
										div  +='<th class="textcenter">Width</th>';
										div  +='<th class="textcenter">Imp / Local</th>';
										div  +='<th class="textcenter">Supplier</th>';
										div  +='<th class="textcenter">Consumption</th>';
										div  +='<th class="textcenter">UOM</th>';
										div  +='<th class="textcenter">Allow %</th>';
										div  +='<th class="textcenter">Currency</th>';
										div  +='<th class="textcenter">Exchange Rate</th>';
										div  +='<th class="textcenter">Price</th>';
										div  +='<th class="textcenter">Item Amount</th>';
										div  +='<th class="textcenter">Finance %</th>';
										div  +='<th class="textcenter">Finance Amount</th>';
										div  +='<th class="textcenter">Stock UOM</th>';
										div  +='<th class="textcenter">Cons. in Stock UOM</th>';
										div  +='<th class="textcenter">Price in Stock UOM</th>   ';
										div  +='<th class="textcenter headcol3 pre_cost_sheet_row_actions_new">Actions</th>';
									div  +='</tr>';
								div  +='</thead>';
								div  +='<tbody>';  
									
									var my=  AjaxCall("POST", "", "services/api/merprecostsheetrowmaterial/GetByid/"+preCostSheetNo+"/"+versionNo+"/"+costsheetType+"/"+id+".json"); 
									var jsn;
									if (my.readyState == 4 && my.status == 200) {
										jsn = JSON.parse(my.responseText);
									}
									else{
										return false;
									}
									var total_finance=0;
									var total_Amount=0;
									for(var k=0;k<jsn.length;k++){
										div  +='<tr class="gradeX">';
											div  +='<td class="textcenter">'+jsn[k].id.component+'</td>';
											div  +='<td class="textcenter">'+jsn[k].mstitem.id.itemType+'</td>';
											div  +='<td class="textcenter">'+jsn[k].mstitem.id.itemCode+'</td>';
											div  +='<td class="textcenter">'+jsn[k].itemDecription+' </td>';
											div  +='<td class="textcenter">'+jsn[k].itemColor+'</td>';
											div  +='<td class="textcenter">'+jsn[k].itemWidth+'</td>';
											div  +='<td class="textcenter">'+jsn[k].shipingType+'</td>';
											div  +='<td class="textcenter">'+jsn[k].supplierCode+'</td>';
											div  +='<td class="textcenter">'+jsn[k].consumption+'</td>';
											div  +='<td class="textcenter">'+jsn[k].uom+'</td>';
											div  +='<td class="textcenter">'+jsn[k].allowance+'</td>';
											div  +='<td class="textcenter">'+jsn[k].currency+'</td>';
											div  +='<td class="textcenter">'+jsn[k].exchangeRate+'</td>';
											div  +='<td class="textcenter">'+jsn[k].price+'</td>';
											div  +='<td class="textcenter">'+(jsn[k].consumption+(jsn[k].consumption*jsn[k].allowance/100.0))*jsn[k].price+'</td>';
											div  +='<td class="textcenter">'+jsn[k].finance+'</td>';
											div  +='<td class="textcenter">'+(jsn[k].consumption+(jsn[k].consumption*jsn[k].allowance/100.0))*jsn[k].price/100.0+'</td>';
											div  +='<td class="textcenter">'+jsn[k].mstitem.uom+'</td>';
											div  +='<td class="textcenter">'+jsn[k].consStockUom+'</td>';
											div  +='<td class="textcenter">'+jsn[k].priceStockUom+'</td>';
											div  +='<td class="center headcol3 pre_cost_sheet_row_actions_icons_new">';
												div  +='<div class="middle-align">';
													div  +='<div class="edit-toggle-styl-rt edit-toggle edit-toggle marginLeft20">';
														div  +='<a onclick="editrowmaterials( \''+id+'\',\''+jsn[k].id.preCostSheetNo+'\',\''+ jsn[k].id.versionNo+'\',\''+ jsn[k].id.costsheetType+'\',\''+  jsn[k].id.precostsheetRowMatCode+'\',\''+ jsn[k].id.component+'\')"><span class="glyphicon glyphicon-pencil"></span> Edit</a>';
													div  +='</div>';	
													if(stsus!="View"){													
														div  +='<div class="delete-toggle-styl-rt delete-toggle delete-toggle pull-right marginRight48">';
															div  +='<a onclick="if ( confirm(\'do you really need to delete this ?\') == true) {deleterowmaterials(\''+id+'\',\''+jsn[k].id.preCostSheetNo+'\',\''+ jsn[k].id.versionNo+'\',\''+ jsn[k].id.costsheetType+'\',\''+  jsn[k].id.precostsheetRowMatCode+'\',\''+ jsn[k].id.component+'\');}" data-toggle="modal" data-target=".delete-confirmation"><span class="glyphicon glyphicon-remove"></span> Delete </a>'; 
														div  +='</div>';
													}
												div  +='</div>';
											div  +='</td>';
										div  +='</tr>';
										if(stsus!="View"){
											total_Amount+=(jsn[k].consumption+(jsn[k].consumption/100 + jsn[k].allowance/100.0))*jsn[k].price;
											total_finance+=(jsn[k].consumption/100 +jsn[k].allowance/100.0)*jsn[k].finance*jsn[k].price/100.00;
										}
									}
								div  +='</tbody>';
							div  +='</table>';
						div  +='</section>';
					div  +='</div>	';	
					if(stsus!="View"){
						div  +='<div class="col-sm-3 col-md-3 col-xs-3 pull-leftpadding0 margintop20">';
							div  +='<p class="pull-left marginRight15 paddingTop4 pull-left ">Total Item Amount</p>';
							div  +='<input type="text" value="'+total_Amount+'" class="form-control pull-left floatedTextbox RawMaterialwidth40">';
						div  +='</div>';

                        div  +='<div class="col-sm-5 col-md-5 col-xs-5 pull-left padding0 margintop20">';
                        div  +='<p class="pull-left marginRight15 paddingTop4 pull-left marginLeft40">Finance Amount</p>';
                        div  +='<input type="text"  value="'+total_finance+'" class="form-control pull-left floatedTextbox RawMaterialwidth40">';
                        div  +='</div>';
					}
				div  +='</div>';
			div  +='</div>';
		div  +='</div>';
		document.getElementById("rowMaterialScreen").innerHTML=div;
		document.getElementById("bage"+id).innerHTML=jsn.length;
		if(stsus!="View"){
			document.getElementById("merprecostsheetForm2").reset();
			selecteditemcategory=id;
		}		
	}
}
/**
 * 
 * @param pre-CostSheet No
 * @param version No
 * @param costsheet Type
 * @param precostsheet RowMaterial Code
 */
function deleterowmaterials(id,preCostSheetNo, versionNo ,costsheetType , precostsheetRowMatCode ,component){
	var formdata = jQuery("#merprecostsheetForm").serialize() +'&'+ jQuery("#merprecostsheetForm3").serialize(); 
	formdata +="&section=section2&deleteRowMat=true&precostsheetRowMatCode="+precostsheetRowMatCode+"&component="+component;
	var my=  AjaxCall("POST", formdata, "merprecostsheetform");
	var jsn;
	if (my.readyState == 4 && my.status == 200) {
		navigterowMat(id,"");
	}
	else{
		alert("Not deleted");
	}
	
}
var editmodeComponent="";
var editmodeprecostsheetRowMatCode="";
/**
 * 
 * @param id
 * @param preCostSheetNo
 * @param versionNo
 * @param costsheetType
 * @param precostsheetRowMatCode
 * @param component
 * @returns {Boolean}
 */
function editrowmaterials(id,preCostSheetNo, versionNo ,costsheetType , precostsheetRowMatCode ,component){
	
	url ="services/api/merprecostsheetrowmaterial/GetByid/"+preCostSheetNo+"/"+versionNo+"/"+costsheetType+"/"+precostsheetRowMatCode+"/"+component+".json";
	var my=  AjaxCall("POST", "", url);
	if (my.readyState == 4 && my.status == 200) {
		jsn = JSON.parse(my.responseText);
		$('#itemCode').prop('disabled', false);
		$('#itemType').prop('disabled', true);
		document.getElementById("itemType").innerHTML="<option>"+jsn.mstitem.id.itemType+"</option>";
		document.getElementById("itemCode").innerHTML="<option>"+jsn.mstitem.id.itemCode+"</option>";
		document.getElementById("itemDecription").value=jsn.itemDecription;
		document.getElementById("itemColor").innerHTML="<option>"+jsn.itemColor+"</option>";
		document.getElementById("itemWidth").value=jsn.itemWidth;
		document.getElementById("shipingType").value=jsn.shipingType;
		document.getElementById("supplierCode").innerHTML="<option>"+jsn.supplierCode+"</option>";
		document.getElementById("currency").innerHTML="<option>"+jsn.currency+"</option>";
		document.getElementById("exchangeRate").value=jsn.exchangeRate;
		document.getElementById("price").value=jsn.price;
		document.getElementById("finance").value=jsn.finance;
		
		document.getElementById(jsn.id.component+"com_consumption").value=jsn.consumption;
		document.getElementById(jsn.id.component+"_UMO").innerHTML="<option>"+jsn.uom+"</option>";
		document.getElementById(jsn.id.component+"com_allowance").value=jsn.allowance;
		for(var i=0;i<componets.length;i++){
			if(componets[i]!=jsn.id.component)
			document.getElementById("contr"+componets[i]).style.display="none";	
		}
		selecteditemtype=jsn.mstitem.id.itemType;
		document.getElementById("rowsubmit").style.display="none";
		document.getElementById("rowUpdate").style.display="inline";
		editmodeComponent=jsn.id.component;
		editmodeprecostsheetRowMatCode=precostsheetRowMatCode;
		HideRow_matGrid();showAddRow_mat();
	}
	else{
		return false;
	}
}

/**
 * 
 * @param progrm
 * @param id
 * @returns enable desable inputs 
 */
function inputenbler(progrm,id){
	console.log(progrm+ " - "+id);
	var nextid=new Array();
	if(progrm == 'costsheet'){
		if(id =="itemType"){
			nextid=['itemCode','itemCodemodel'];
			enbldisble(id,nextid,true);
			selecteditemtype=document.getElementById(id).value;
		}
	}

}
/**
 * 
 * @param id
 */
function  getUOM(id) {
	var my=AjaxCall("POST","","services/api/gencodes/getcode/UOM.json");
	 var json ;
  if (my.readyState==4 && my.status==200){
  	json = JSON.parse(my.responseText);
  }
  else{
      console.log("some things wrong");
  }
  var div=optioncreator(json);
  
  document.getElementById(id).innerHTML=div;
}

function selectStyle() {
	custCode=document.getElementById("pcs_id_custCode").value;
	locationCode=document.getElementById("pcs_id_locationCode").value;
	depCode=document.getElementById("pcs_id_depCode").value;
	styleId=document.getElementById("pcs_id_styleId").value;
	compCode=document.getElementById("pcs_id_compCode").value;
	season=document.getElementById("pcs_season").value;
	styleDescription=document.getElementById("pcs_styleDescription").value;
	
	if(custCode==null || locationCode==null || depCode==null || styleId==null || compCode==null ||  season==null || custCode=="" || locationCode=="" ||  depCode=="" ||  styleId=="" ||  compCode=="" ||  season=="" ){
		alert("Please Select all fileds before Add Pre Cost Sheet")
	}
	else{
		window.location.replace("merprecostsheetform?custCode="+custCode+"&styleDescription="+styleDescription+"&locationCode="+locationCode+"&depCode="+depCode+"&styleId="+styleId+"&season="+season+"&compCode="+compCode);
	}
}

function getCostsheets(){
	
	custCode=document.getElementById("pcs_id_custCode").value;
	locationCode=document.getElementById("pcs_id_locationCode").value;
	depCode=document.getElementById("pcs_id_depCode").value;
	styleId=document.getElementById("pcs_id_styleId").value;
	compCode=document.getElementById("pcs_id_compCode").value;
	season=document.getElementById("pcs_season").value;
	styleDescription=document.getElementById("pcs_styleDescription").value;
	query=document.getElementById("query").value;
	
	if(custCode==null || locationCode==null || depCode==null || styleId==null || compCode==null ||  season==null || custCode=="" || locationCode=="" ||  depCode=="" ||  styleId=="" ||  compCode=="" ||  season=="" ){
		alert("Please Select all filed search ");
	}
	else{
		if(query!=null && query!=""){
		window.location.replace("merprecostsheets?q="+query+"&custCode="+custCode+"&styleDescription="+styleDescription+"&locationCode="+locationCode+"&depCode="+depCode+"&styleId="+styleId+"&season="+season+"&compCode="+compCode);
		}
		else{
			window.location.replace("merprecostsheets?custCode="+custCode+"&styleDescription="+styleDescription+"&locationCode="+locationCode+"&depCode="+depCode+"&styleId="+styleId+"&season="+season+"&compCode="+compCode);
		
		}
	}	
}
/**
 * 
 * @param fmv
 * @param id
 * @returns
 */
function changefmv(fmv,id){
	buyerCode=document.getElementById("pcs_id_custCode").value;
	d_Dates=document.getElementById("createdOn").value;
	Volume=document.getElementById("orderQty").value;
	if(Volume=="" ||  buyerCode=="" || d_Dates==""){
		alert("Plsase Add Order Qty");
		return fmv;
		//pcs_id_custCode="NOT"; createdOn="NOT";orderQty="NOT";
	}
	else if(fmv==null || fmv==""){
		alert("Plsase Add FMV Category");
		return false;
	}
	else{
		my = AjaxCall("POST", "", "services/api/mstsmvvoulmerates/getsmvrate/"+buyerCode+"/"+d_Dates+"/"+fmv+"/"+Volume+".json");
	 	if (my.readyState==4 && my.status==200){
	 		fmvrt = JSON.parse(my.responseText);
	 	}
	 	else{
	      console.log("some things wrong");
	      return false;
	 	}
	 	console.log(fmvrt+" - "+my.responseText );
		if(fmvrt !=null && fmvrt!=""){
			document.getElementById(id+"_fmv").value=fmvrt[0].smvValue;
		}
		else if(my.responseText=="[]"){
			jsnroot = AjaxCall("POST", "", "services/api/mstsmvrates/getsmv/"+pcs_id_custCode+"/"+createdOn+"/"+fmv+".json");
			if (jsnroot.readyState==4 && my.status==200){
		 		fmvrt = JSON.parse(jsnroot.responseText);
		 	}
		 	else{
		      console.log("some things wrong");
		      return false;
		 	}
			console.log(fmvrt);
			if(fmvrt !=null && fmvrt!=""){
				document.getElementById(id+"_fmv").value=fmvrt[0];
			}
			else{
				document.getElementById(id+"_fmv").value=0;
			}
		}
		else{
			document.getElementById(id+"_fmv").value=0;
		}
	}
}

function ckkqty(type){
	if(type=='b'){
		console.log(document.getElementById("orderQty").value+ " = "+orgckkqty);
		if(orgckkqty!=document.getElementById("orderQty").value){
			console.log(componets.length);
			for(var i=0;i<componets.length;i++){
				document.getElementById(componets[i]+"_pfmvCategory").innerHTML="";
				document.getElementById(componets[i]+"_fmv").value="";
			}
		}
	}
	else if(type=='f'){
		orgckkqty=document.getElementById("orderQty").value;
	}
}

$(function() {
    $('#styleBrowser2Body .exportlinks').insertAfter('#styleBrowser2Body .dataTables_wrapper');
});

$(function() {
    $('#styleBrowserBody_new .exportlinks').insertAfter('#styleBrowserBody_new .dataTables_wrapper');
});