var Currency=new Array();
var selecteditemcategory="";
var selecteditemtype =""
var	rowmatcom=new Array();
var SMV=new Array();
var Growmatcom=new Array();
var costsheetRowMatCodes=new Array();
var components = new Array();
var iseRow_matdite=false;
var smvarray=0; 

function conformation(){
	//var formdata = jQuery("#mercostsheethdrForm4").serialize();
	var formdata=jQuery("#searchForm").serialize()+"&";
	formdata+="section=section6&";
	formdata+=jQuery("#costSheetGeneralForm").serialize()+"&"+jQuery("#costSheetTypeForm").serialize();
	var success=  AjaxCall("POST", formdata, "mercostsheethdrform");
	if(success.readyState == 4 && success.status == 200){
	
	}
	else{
		
	}
}  

function addshellfab(){
	jsons=updatejsn;
	var div="";
	if(updatejsn && document.getElementById(jsons.itemCode)==null){
		try{
			div +='<tr class="gradeX" id="'+jsons.itemCode+'">';
				div +='<td class="textcenter">'+jsons.itemCode;
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
						div +='<a class="delete" onclick="deleteshellfab(\''+jsons.itemCode+'\',\''+jsons.mstitemtype.itemType+'\')"><span class="glyphicon glyphicon-remove"></span>  Delete</a> ';
						div +='</div>';
					div +='</div>';
				div +='</td>';
			div +='</tr>';
			shellFabric.push(jsons.mstitemtype.itemType+":"+jsons.itemCode);
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
//get/{costSheetNo}/{versionNo}/{costsheetType}/{costSheetRowMatCode}/{component}/{groupId}
function selectshellfabric(CostSheetNo,versionNo,costsheetType,costsheetRowMatCode,component,groupId,itemCode){
	if(document.getElementById(itemCode)==null && itemCode){
		var my=  AjaxCall("POST", "", "services/api/mercostsheetrowmaterial/get/"+CostSheetNo+"/"+versionNo+"/"+costsheetType+"/"+costsheetRowMatCode+"/"+component+"/"+groupId+".json");
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

/**
 * 
 */
function getsheelfab(id){
	var costSheetNo=document.getElementById("costSheetNo").value;
	var versionNo=document.getElementById("versionNo").value;
	var costsheetType=document.getElementById("costSheetType").value;
	var my=  AjaxCall("POST", "", "services/api/mercostsheetrowmaterial/GetAllfrm/"+costSheetNo+"/"+versionNo+"/"+costsheetType+"/FABRIC/id,itemCode.json");
	var div='<option onclick=\'selectshellfabric("","","","","",null)\'></option>';
  	if (my.readyState == 4 && my.status == 200) {
		jsons = JSON.parse(my.responseText);
    	for(var k=0;k<jsons.length;k++){
    		div+='<option onclick=\'selectshellfabric("'+jsons[k][0].costSheetNo+'","'+jsons[k][0].versionNo+'","'+jsons[k][0].costSheetType+'","'+jsons[k][0].costSheetRowMatCode+'","'+jsons[k][0].component+'","'+jsons[k][0].groupId+'","'+jsons[k][1]+'")\' >' + jsons[k][1] +'</option>';
		}
		document.getElementById(id).innerHTML=div;
	}
	
}

function initComponent(){
	var yesNoCheckBox = $('#compWiseCost'); // checking yesNoCheckBox is inside the body
    if(yesNoCheckBox.hasClass("yesNocheckBox") ){
	     $.fn.bootstrapSwitch.defaults.onText = 'Yes';
	     $.fn.bootstrapSwitch.defaults.offText = 'No';
	     $("[name='my-checkbox']").bootstrapSwitch();
	}
	
    /**
     * Following content came for final costing groups
     */
    hideAddForm();
    showGrid();
    addedGroupGrid();

    //$('#destination_country').empty();
    $('#destination_country').trigger("chosen:updated");
    /**
     * END of final costing groups
     */
    /*example of panel show hide ends*/
    if($('select').hasClass("chosen-select") ){
      $(".chosen-select").chosen();
    } //Chosen countries
    //$(".showHideTable").hide();
    $('.table_show_hide').click(function(){
   //   $(".showHideTable").toggle(350);
    });
    
    var e = document.getElementById("dim-vertical-type");
    console.info(e);
    var value = e.options[e.selectedIndex].value;
    console.info(value);
    selectDim(value,'Vertical');
    
    var e = document.getElementById("dim-horizontal-type");
    console.info(e);
    var value = e.options[e.selectedIndex].value;
    console.info(value);
    selectDim(value,'Horizontal');
    
    calculateSellingPrice();
}

/**
 * Following content came for final costing general page
 */
function costingMethod(){
	console.info(document.getElementById("compWiseCost").checked);
	if(document.getElementById("averageWiseCost").checked){
		document.getElementById("sizeWiseCost").disabled = true;
		document.getElementById("countryWiseCost").disabled = true;
	}
	else{
		document.getElementById("sizeWiseCost").disabled = false;
		document.getElementById("countryWiseCost").disabled = false;
	}
	
	if(document.getElementById("sizeWiseCost").checked || document.getElementById("countryWiseCost").checked){
		document.getElementById("averageWiseCost").disabled = true;
	}
	else{
		document.getElementById("averageWiseCost").disabled = false;
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
		console.log(componets[smvarray]+"_fmvCategory "+fmvCategory +" " +componets[smvarray]);
		document.getElementById(componets[smvarray]+"_location").innerHTML="<option value='"+routeLocation+"'>"+routeLocation+"</option>";
		document.getElementById(componets[smvarray]+"_styleRouteName").innerHTML="<option value='"+styleRouteId+"'>"+styleRouteName+"</option>";
		document.getElementById(componets[smvarray]+"_Ratio").value=ratio;
		
		document.getElementById(componets[smvarray]+"_fmv").value=fmv;
		document.getElementById(componets[smvarray]+"_lineEfficiency").value=lineEfficency;
		document.getElementById(componets[smvarray]+"_fmvCategory").innerHTML="<option value='"+fmvCategory+"'>"+fmvCategory+"</option>";
		//document.getElementById(componets[smvarray]+"_SMV").value=smv;
		console.log(styleRouteId);
		createSMV(styleRouteId,componets[smvarray]);
		
	}catch (e) {
		console.log(e);
	}
	smvarray++;			
}

/**
 * End of final costing general page
 */

/**
 * Following content came for final costing groups
 */

function showGrid(){
	$('#creatG').collapse('show');
}
function showAddForm(){
	$('#createGroBody').collapse('show');
}
function hideGrid(){
	 $('#creatG').collapse('hide');
}
function hideAddForm(){
	$('#createGroBody').collapse('hide');
}

function initTemplate(){
	colors = ArrNoDupe(colors);
	$(".vertical_divs").hide();
	$(".horizontal_divs").hide();
	
	var index = document.getElementById("dim-vertical-type").selectedIndex;
	var option = document.getElementById("dim-vertical-type").options[index];
	$("#Vertical_"+option.value).show();
	index = document.getElementById("dim-horizontal-type").selectedIndex;
	option = document.getElementById("dim-horizontal-type").options[index];
	$("#Horizontal_"+option.value).show();
	templateMatrix();
}
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


function calculatesellingprice(){
	success = $('#searchFormInit').valid();

	if(success){
		var formdata = jQuery("#mercostsheethdrForm4").serialize();
		formdata+=jQuery("#searchForm").serialize()+"&";
		formdata+="section=section4&";
		formdata+=jQuery("#costSheetGeneralForm").serialize()+"&"+jQuery("#costSheetTypeForm").serialize()+"&";
		if(selectedgrouptype=="None"){
			group=document.getElementById("SelectGroup").value;
			formdata+="group="+group;
		}
		else{
			formdata+="group=All";
		}
	}
}
var selectedgrouptype="";
/**
 * caculate cost fomulas
 */
function calculatepricing(){
	if(document.getElementById("compWiseCost").checked == false && document.getElementById("averageWiseCost").checked){
		getGroupVsCosting("All");
		$("#divSelectGroup").hide();
		$("#divSelectGroup2").show();
		selectedgrouptype="All";
		document.getElementById("SelectGroup2").value="All";
	}
	else{
		$("#divSelectGroup").show();
		$("#divSelectGroup").hide();
		selectedgrouptype="none";
	}	
}

function getGroupVsCosting(groupname){
	
	
	services_cost=getrowmat_totalcost("SERVICE",groupname);
	fabric=getrowmat_totalcost("FABRIC",groupname);
	packing=getrowmat_totalcost("PACKING",groupname);
	trims=getrowmat_totalcost("TRIMS",groupname);
	finance=getrowmat_totalcost("NOT",groupname);
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


function getrowmat_totalcost(type ,groupName) {
	
	costSheetNo=document.getElementById("costSheetNo").value;
	costSheetType=document.getElementById("costSheetType").value;
	versionNo=document.getElementById("versionNo").value;
	
	var my=  AjaxCall("POST", "", "services/api/mercostsheetrowmaterial/GetAllfrmfld/"+costSheetNo+"/"+versionNo+"/"+costsheetType+"/"+type+"/"+groupName+".json");
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
function showBack(page){
	$('#addNewFinalCostSheet').hide();
	$('#createGroups').hide();
	$('#addRowMat').hide();
	$('#creatGCsheet').hide();
	if(page == 1){
		if(addedGroups.length == 0){
			$('#addNewFinalCostSheet').show();
			document.getElementById('tabBtn1').className="active";
		}
		else{
			$('#createGroups').show();
			alert("Please remove all groups before go back");
		}
		
	}else if(page == 2){
		if(document.getElementById("compWiseCost").checked == false && document.getElementById("averageWiseCost").checked){
			$('#addNewFinalCostSheet').show();
			document.getElementById('tabBtn1').className="active";
		}
		else{
			$('#createGroups').show();
			document.getElementById('tabBtn2').className="active";
		}
	}else if(page == 3){
		$('#addRowMat').show();
		document.getElementById('tabBtn3').className="active";
	}
	else if(page == 4){
		$('#creatGCsheet').show();
		
		var formdata = 'shellFabric='+shellFabric;
		formdata += '&itemcategory='+selecteditemcategory+"&";
		formdata+=jQuery("#searchForm").serialize()+"&";
		formdata+="section=section4&";//Othercostindg
		formdata+=jQuery("#costSheetGeneralForm").serialize()+"&"+jQuery("#costSheetTypeForm").serialize()+"&"+jQuery("#Othercostindg").serialize();
		
		var success=  AjaxCall("POST", formdata, "mercostsheethdrform");
		if(success.readyState == 4 && success.status == 200){
		navigterowMat(selecteditemcategory,'');
		 navigterowMatGroup(selecteditemcategory,"grouprowMaterialScreen");
		 iseRow_matdite=false;
		}
		else{
			
		}
		calculatepricing();
		document.getElementById('tabBtn4').className="active";
	}
	else{
		$('#creatGCsheet').show();
		formdata=jQuery("#searchForm").serialize()+"&";
		formdata+="section=section5&";//Othercostindg
		formdata+=jQuery("#costSheetGeneralForm").serialize()+"&"+jQuery("#mercostsheethdrForm4").serialize()+"&"+jQuery("#costSheetTypeForm").serialize()+"&"+jQuery("#Othercostindg").serialize();
		var success=  AjaxCall("POST", formdata, "mercostsheethdrform");
		if(success.readyState == 4 && success.status == 200){
		//navigterowMat(selecteditemcategory,'');
			console.log(selectedgrouptype);
			getcostingvary(selectedgrouptype);
		// iseRow_matdite=false;
		}
		else{
			
		}
	}
}
var addedgroupvariance=new Array();
function getcostingvary(groupname){
	if(arrayindex(addedgroupvariance, groupname)==-1){
		var div ="  ";
		costSheetNo=document.getElementById("costSheetNo").value;
		costSheetType=document.getElementById("costSheetType").value;
		versionNo=document.getElementById("versionNo").value;
		//getprecost/{costsheetNo}/{version}/{costsheetType}
		div +='<table id="route'+groupname+'" class="display table table-striped table-bordered widthChangeHeadcol2" cellspacing="0">';
			div +='<thead>';
				div +='<tr>';
					div +='<th></th>';
					div +='<th>Group Name</th>';
					div +='<th>Services</th>';
					div +='<th>CM</th>';
					div +='<th>CMT</th>';
					div +='<th>Finance cost</th>';
					div +='<th>Total cost</th>';
					div +='<th>Mark up ammount</th>';
					div +='<th>Buyer commission</th>';
					div +='<th>Our price</th>';
					div +='<th class="textcenter headcol2">External commission</th>';
					div +='<th class="textcenter headcol3">Selling Price</th>';
				div +='</tr>';
			div +='</thead>';
		div +='<tbody >';
             
		var url="services/api/mercostsheetgroup/get/"+costSheetNo+"/"+versionNo+"/"+costSheetType+"/"+groupname+".json"; 
		var success=  AjaxCall("POST", "", url);
		var gjsons;
		if(success.readyState == 4 && success.status == 200){
			gjsons = JSON.parse(success.responseText);
			div +='<tr class="gradeX">';
				div +='<td>Final Cost Sheet</td>';
				div +='<td>'+(gjsons.groupName)+'</td>';
				div +='<td>'+(0+gjsons.serviceValue)+'</td>';
				div +='<td>'+(0+gjsons.cm)+'</td>';
				div +='<td>'+(0+gjsons.cmt)+'</td>';
				div +='<td>'+(0+gjsons.financeCost)+'</td>';
		     	div +='<td>'+(0+gjsons.totalCost)+'</td>';
		 		div +='<td>'+(0+gjsons.markupAmount)+'</td>';
				div +='<td>'+(0+gjsons.buyerCommission)+'</td>';
				div +='<td>'+(0+gjsons.ourPrice)+'</td>';
				div +='<td>'+(0+gjsons.externalCommission)+'</td>';
				div +='<td>'+(0+gjsons.sellingPrice)+'</td>';
	 		div +='</tr>';
	 		addedgroupvariance.push(groupname);
		}
		else{
			div +='<tr class="gradeX">';
				div +='<td>Final Cost Sheet</td>';
			div +='</tr>';
		}
		var pjsons;
		var url="services/api/mercostsheethdr/getprecost/"+costSheetNo+"/"+versionNo+"/"+costSheetType+".json";
		var success=  AjaxCall("POST", "", url);
		if(success.readyState == 4 && success.status == 200){
			pjsons = JSON.parse(success.responseText);
			div +='<tr class="gradeX">';
				div +='<td>Pre Cost Sheet</td>';
				div +='<td></td>';
				div +='<td>'+(0+pjsons.serviceValue)+'</td>';
				div +='<td>'+(0+pjsons.cm)+'</td>';
				div +='<td>'+(0+pjsons.cmt)+'</td>';
				div +='<td>'+(0+pjsons.financeCost)+'</td>';
		     	div +='<td>'+(0+pjsons.totalCost)+'</td>';
		 		div +='<td>'+(0+pjsons.markupAmount)+'</td>';
				div +='<td>'+(0+pjsons.buyerCommission)+'</td>';
				div +='<td>'+(0+pjsons.ourPrice)+'</td>';
				div +='<td>'+(0+pjsons.externalCommission)+'</td>';
				div +='<td>'+(0+pjsons.sellingPrice)+'</td>';
	 		div +='</tr>';
		}	
		else{
			div +='<tr class="gradeX">';
				div +='<td>PreSheet</td>';
			div +='</tr>';
		}
		
		div +='<tr class="gradeX">';
			div +='<td>Varient</td>';
			div +='<td></td>';
			div +='<td>'+(gjsons.serviceValue- pjsons.serviceValue)+'</td>';
			div +='<td>'+(gjsons.cm- pjsons.cm)+'</td>';
			div +='<td>'+(gjsons.cmt -pjsons.cmt)+'</td>';
			div +='<td>'+(gjsons.financeCost- pjsons.financeCost)+'</td>';
	     	div +='<td>'+(gjsons.totalCost- pjsons.totalCost)+'</td>';
	 		div +='<td>'+(gjsons.markupAmount -pjsons.markupAmount)+'</td>';
			div +='<td>'+(gjsons.buyerCommission -pjsons.buyerCommission)+'</td>';
			div +='<td>'+(gjsons.ourPrice- pjsons.ourPrice)+'</td>';
			div +='<td>'+(gjsons.externalCommission-pjsons.externalCommission)+'</td>';
			div +='<td>'+(gjsons.sellingPrice-pjsons.sellingPrice)+'</td>';
		div +='</tr>';
		div +='</tbody>';
	div +='</table>';
		document.getElementById("varitbody").innerHTML=document.getElementById("varitbody").innerHTML+div;
	}
	else{
		console.log(arrayindex(addedgroupvariance, groupname));
		}
	
}

/*$('#myTab a').click(function (e) {
    if($(this).parent('li').hasClass('active')){
        $( $(this).attr('href') ).hide();
    }
    else {
        e.preventDefault();
        $(this).tab('show');
    }
});*/


var countries = [];
var demVerti = ["AA","BB"];
var demHori = ["12","14","18","20","55"];
var demtypeVerti = "Fit";
var demtypeHori = "Size";

function setCountry(){
	countries = [];
	var list = document.getElementById('destination_country');

	for (i = 0; i < list.options.length; i++) {
	    if (list.options[i].selected) {
	    	countries.push(list.options[i].value);
	    	console.info(list.options[i].value);
	    }
	}
}

function addNewCostSheetWithStyle(){
	success = $('#searchFormInit').valid();

	if(success){
		var formdata = jQuery("#searchFormInit").serialize();
		window.location.replace('mercostsheethdrform?'+formdata);
	}
	else{
		alert("Please select a style and season first...");
	}
}

function saveCostSheet(pageId){
	var formdata = jQuery("#costSheetGeneralForm").serialize();
	if(pageId == 1){
		//save first page information via ajax
		//collect first form data
		var averageWiseCost = document.getElementById("averageWiseCost").checked;
		var sizeWiseCost = document.getElementById("sizeWiseCost").checked;
		var countryWiseCost = document.getElementById("countryWiseCost").checked;
		//validate
		if( !(averageWiseCost || sizeWiseCost || countryWiseCost)){
			alert("Please select at least one of costing method...");
			return;
		}
		if(countries.length == 0){
			alert("Please select at least one country...");
			return;
		}
		var success = $('#costSheetGeneralForm').valid();
		if(success){
			var templateDemmap = [];
			$(".templateCheck").each(function() {
				templateDemmap.push([this.id+":"+this.checked]);
		    });
			for(var i=0;i<componets.length;i++){
				var ritio=document.getElementById(componets[i]+"_Ratio").value;
				var location=document.getElementById(componets[i]+"_location").value;
				var styleRouteName=document.getElementById(componets[i]+"_styleRouteName").value
				var linedff=document.getElementById(componets[i]+"_lineEfficiency").value;
				var fmvCat=document.getElementById(componets[i]+"_fmvCategory").value;
				var fmv=document.getElementById(componets[i]+"_fmv").value
				if(linedff!=null && fmvCat!=null && fmv!=null && linedff!="" && fmvCat!="" && fmv!="" && ritio!=null && location!=null && styleRouteName!=null && ritio!="" && location!="" && styleRouteName!=""){
					var args=styleRouteName + ":" + location + ":"+ritio +":"+linedff+":"+fmvCat+":"+fmv;
					SMV.push(args)
				}
				else{
					alert("Please Fill SMV...");
					return false;
				}	
			}
			/*var select = document.getElementById('destination_country');
			var country = [];
			for (var i = 0; i < select.options.length; i++) {
			  if (select.options[i].selected) {
				  country.push(select.options[i].value);
			  }
			}*/
			
			formdata = formdata +'&'+ jQuery("#costSheetTypeForm").serialize();;
			formdata = formdata +'&'+ jQuery("#costSheetCurrencyForm").serialize();
			formdata = formdata +'&'+ jQuery("#searchForm").serialize();
			
			formdata += '&currency='+Currency;
			formdata += '&demVerti='+demVerti;
			formdata += '&demHori='+demHori;
			formdata += '&demtypeVerti='+demtypeVerti;
			formdata += '&demtypeHori='+demtypeHori;
			formdata += '&templateDemmap='+templateDemmap;
			formdata += '&country='+countries;
			var smvarr = new Array();
			for(var i=0;i<componets.length;i++){
				var ritio=document.getElementById(componets[i]+"_Ratio").value;
				var location=document.getElementById(componets[i]+"_location").value;
				var styleRouteName=document.getElementById(componets[i]+"_styleRouteName").value
				var linedff=document.getElementById(componets[i]+"_lineEfficiency").value;
				var fmvCat=document.getElementById(componets[i]+"_fmvCategory").value;
				var fmv=document.getElementById(componets[i]+"_fmv").value
				var smv=document.getElementById(componets[i]+"_SMV").value
				if(linedff!=null && fmvCat!=null && fmv!=null && linedff!="" && smv!=null && smv!="" && fmvCat!="" && fmv!="" && ritio!=null && location!=null && styleRouteName!=null && ritio!="" && location!="" && styleRouteName!=""){
					var args=styleRouteName + ":" + location + ":"+ritio +":"+linedff+":"+fmvCat+":"+fmv+":"+smv;
					smvarr.push(args)
				}
				else{
					alert("Please Fill SMV details");
					return false;
				}	
			}
			formdata += '&smvarr='+smvarr;
			formdata += '&section=section'+pageId;
			
			var success=  AjaxCall("POST", formdata, "mercostsheethdrform");
			if (success.readyState == 4 && success.status == 200) {
				document.getElementById("versionNo").value=0;
				//alert(success.responseXML)
				var newid = getCookie("costSheetNo");
				console.info(newid);
				document.getElementById("costSheetNo").value = newid;
				
				if(document.getElementById("compWiseCost").checked == false && document.getElementById("averageWiseCost").checked){
					//show third page
					//add group
					for(var i=itemtypecatogery.length-1;i>-1;i--){
						 navigterowMat(itemtypecatogery[i]);
						 console.log(itemtypecatogery[i]);
					}
					selecteditemcategory=itemtypecatogery[0];
					navigterowMat(selecteditemcategory,'');
					createGroupRawmat2();
					showBack(3);
					document.getElementById('tabBtn2').className="disabled";
				}
				else{
					//show second page.
					showBack(2);
				}
			}else{
				alert("Server error occurred. Please contact the administrator");
			}
		}
		else{
			alert("Please fill final cost-sheet ");
		}
	}
	if(pageId == 2){
		var groups = []
		/*for (var i = 0; i < addedGroups.length; i++) {
			/*console.info(addedGroups[i][3][0][2]);
			var colors = "";
			var demmaps = "";
			var row = [];
			for (var j = 0; j < addedGroups[i][3].length; j++) {
				for (var k = 0; k < addedGroups[i][3][j][2].length; k++) {
					colors += addedGroups[i][3][j][2][k];
					if(k != (addedGroups[i][3][j][2].length - 1)){
						colors += ":";
					}
				}
				for (var k = 0; k < addedGroups[i][3][j][3].length; k++) {
					demmaps += addedGroups[i][3][j][3][k];
					if(k != (addedGroups[i][3][j][3].length - 1)){
						demmaps += ":";
					}
				}
				row.push([":",addedGroups[i][3][j][0],addedGroups[i][3][j][1],colors,demmaps])
			}
			
			
			/*for (var j = 0; j < addedGroups[i][3][0][2].length; j++) {
				colors += addedGroups[i][3][0][2][j];
				if(j != (addedGroups[i][3][0][2].length - 1)){
					colors += ":";
				}
			}*
			
			groups.push([addedGroups[i][0],addedGroups[i][1],addedGroups[i][2],row,"-"]);
		}*/
		
		var json = JSON.stringify(addedGroups);
		console.info(json);
		//formdata += {group:json};
		formdata += '&addedGroups='+json;
		formdata += '&demtypeVerti='+demtypeVerti;
		formdata += '&demtypeHori='+demtypeHori;
		formdata += '&section=section'+pageId;
		var success=  AjaxCall("POST", formdata, "mercostsheethdrform");
		if (success.readyState == 4 && success.status == 200) {
			document.getElementById("versionNo").value=0;
			var newid = getCookie("costSheetNo");
			console.info(newid);
			document.getElementById("costSheetNo").value = newid;
			//show third page
			showBack(3);
			for(var i=itemtypecatogery.length-1;i>-1;i--){
				 navigterowMat(itemtypecatogery[i]);
				 console.log(itemtypecatogery[i]);
			}
			selecteditemcategory=itemtypecatogery[0];
			if(document.getElementById("compWiseCost").checked == false && document.getElementById("averageWiseCost").checked == false){
				createGroupRawmat1();
				console.info("***");
			}
			else{
				createGroupRawmat();
				console.info("0000");
			}
		}else{
			alert("Server error occurred. Please contact the administrator");
		}
	}
	if(pageId == 3){
		
	}
	if(pageId == 4){
		
	}
}

function savecostsheets(type){
	
	formdata=jQuery("#searchForm").serialize()+"&";
	formdata+="section=section3&";
	formdata+=jQuery("#costSheetGeneralForm").serialize()+"&"+jQuery("#costSheetTypeForm").serialize()+"&";
	if(selectedBulkaction==2){
		formdata+="bulkActions=AlltoSelct";
		formdata+="&dataid="+rowmaterialid;
	}
	else{
		if( $('#mercostsheethdrForm3').valid()){
			formdata+="bulkActions=OneoSelct&";
			formdata+=jQuery("#mercostsheethdrForm3").serialize();
		}
		else{
			alert("Validation failed");
			return false;
		}
	}
	
	var groupid=new Array();
	var consmptions =new Array();
	if(document.getElementById("compWiseCost").checked && document.getElementById("averageWiseCost").checked ==null){
		var status=false;
		for(var i=0;i<componets.length;i++){
			var consumption=document.getElementById(componets[i]+"com_consumption").value;
			var UOM=document.getElementById(componets[i]+"_UOM").value;
			var allowance=document.getElementById(componets[i]+"com_allowance").value;
			var groupel=document.getElementById(componets[i]+"_group");
			var group =getSelectedOptions(groupel);
			if(UOM!=null && group!=null && consumption!=null && UOM!="" && consumption!=""  && group!=""){
				console.log(componets[i]+":"+group+":"+consumption+":"+UOM+":"+allowance);
				if(allowance=="" || allowance==null){
					allowance=0;
				}
				groupid.push(group);
				consmptions.push(componets[i]+":"+group+":"+consumption+":"+UOM+":"+allowance);
				status=true;
			}
			
		}
		if(!status){
				alert("Please Fill atleast one SMV details");
				return false;
		}
		formdata += '&consmptions='+consmptions;
	 }
	else if(document.getElementById("compWiseCost").checked == false && document.getElementById("averageWiseCost").checked){
		formdata += '&consmptions='+componets;
	}
	else{
		var groupel=document.getElementById("group");
		var group =getSelectedOptions(groupel);
		formdata += '&consmptions='+componets;
		formdata += '&groupid='+group;
	}
	if(document.getElementById("compWiseCost").checked == false && document.getElementById("averageWiseCost").checked){
		formdata += '&groupid=All';
	}
	else{
		formdata += '&groupid='+groupid;
	}
	if(iseRow_matdite){
		formdata += '&editRowMat=true';
		formdata+="&costsheetRowMatCode="+editmodeprecostsheetRowMatCode;
		formdata+="&component="+editmodeComponent;
	}
	var success=  AjaxCall("POST", formdata, "mercostsheethdrform");
	if(success.readyState == 4 && success.status == 200){
	navigterowMat(selecteditemcategory,'');
	 navigterowMatGroup(selecteditemcategory,"grouprowMaterialScreen");
	 iseRow_matdite=false;
	}
	else{
		
	}
} 
/**
 * 
 * @param matrixType
 */
function generateMatrix(matrixType){
	//matrixType {template, grid}
	var matrix = '<table class="table table-bordered tab1panelTalbe">'
	matrix += '<thead>';
	matrix += '<tr>';

	if(matrixType != "template"){
		matrix += '<th class="textcenter">Country</th>';
	}
	matrix += '<th class="textcenter">Component</th>';
	matrix += '<th class="textcenter">Color</th>';
	matrix += '<th class="textcenter">'+demtypeVerti+'</th>';
	matrix += '<th colspan="'+demHori.length+'" style="text-align:center">'+demtypeHori+'</th>';
	matrix += '</tr>';
	matrix += '</thead>';
	matrix += '<tbody>';
	
	var rowsPanCol = 0;
	var rowsPanComp = 0;
	
	matrix += '<tr>';
	if(matrixType != "template"){
		matrix += '<td></td>';
	}
	matrix += '<td class="textcenter"></td>';
	matrix += '<td class="textcenter"></td>';
	matrix += '<td class="textcenter"></td>';
	for (var k = 0; k < demHori.length; k++) {
		matrix += '<td class="table-size-header textcenter">'+demHori[k]+'</td>';
	}
	matrix += '</tr>';
	
	if(matrixType == "template"){
		for (var i = 0; i < components.length; i++) {
			rowsPanComp = demVerti.length * colors.length;
			
			for (var j = 0; j < colors.length; j++) {
				rowsPanCol = demVerti.length;
				
				for (var a = 0; a < demVerti.length; a++) {
					matrix += '<tr>';
					if(matrixType != "template" && i == 0 && a == 0 && j == 0){
						var rowsPanCountry = (demVerti.length * colors.length * components.length);
						matrix += '<td rowspan="'+rowsPanCountry+'" class="textcenter">'+countries[h]+'</td>';
					}
					if(a == 0 && j == 0){
						matrix += '<td class="textcenter" rowspan="'+rowsPanComp+'">'+components[i]+'</td>';
					}
					if(a == 0){
						matrix += '<td class="textcenter" rowspan="'+rowsPanCol+'">'+colors[j]+'</td>';
					}
					matrix += '<td class="textcenter">'+demVerti[a]+'</td>';
					for (var b = 0; b < demHori.length; b++) {
//						if(matrixType == "template"){
//							matrix += '<td class="cernter-x"><span class="glyphicon glyphicon-remove"></span></td>';
//						}
//						else{
						matrix += '<td class="cernter-x"><input class="templateCheck" type="checkbox" id="'+components[i]+":"+colors[j]+":"+demVerti[a]+":"+demHori[b]+'"></td>';
//						}
					}
					matrix += '</tr>';
				}
			}
		}
	}
	else{
		for (var h = 0; h < countries.length; h++) {
			for (var i = 0; i < components.length; i++) {
				rowsPanComp = demVerti.length * colors.length;
				
				for (var j = 0; j < colors.length; j++) {
					rowsPanCol = demVerti.length;
					
					for (var a = 0; a < demVerti.length; a++) {
						matrix += '<tr>';
						if(i == 0 && a == 0 && j == 0){
							var rowsPanCountry = (demVerti.length * colors.length * components.length);
							matrix += '<td rowspan="'+rowsPanCountry+'" class="textcenter">'+countries[h]+'</td>';
						}
						if(a == 0 && j == 0){
							matrix += '<td rowspan="'+rowsPanComp+'" class="textcenter">'+components[i]+'</td>';
						}
						if(a == 0){
							matrix += '<td rowspan="'+rowsPanCol+'" class="textcenter">'+colors[j]+'</td>';
						}
						matrix += '<td class="textcenter">'+demVerti[a]+'</td>';
						for (var b = 0; b < demHori.length; b++) {
							matrix += '<td class="cernter-x textcenter"><input disabled="disabled" type="checkbox" ';
							matrix += 'id="'+countries[h]+":"+components[i]+":"+colors[j]+":"+demVerti[a]+":"+demHori[b]+'exl"></td>';
						}
						matrix += '</tr>';
					}
				}
			}
		}
	}
	
    
	matrix += '</tbody></table>';
    $("#"+matrixType).html("");
    $("#"+matrixType).html(matrix);
    

    if(matrixType == "template"){
    	for (var i = 0; i < components.length; i++) {
    		for (var j = 0; j < mststyledemmaps.length; j++) {
    			try{
//		    		console.info(components[i]+":"+mststyledemmaps[j][0]+":"+mststyledemmaps[j][3]+":"+mststyledemmaps[j][4]);
		    		document.getElementById(components[i]+":"+mststyledemmaps[j][0]+":"+mststyledemmaps[j][3]+":"+mststyledemmaps[j][4]).checked = true;
		    	}
		    	catch(e){
		    		
		    	}
    		}
		}
	}
//	for (var j = 0; j < addedGroups.length; j++) {
//    	for (var i = 0; i < addedGroups[j][3].length; i++) {
//    		for (var k = 0; k < addedGroups[j][3][i][3].length; k++) {
//	    	
//			}
//    	}
//    }
    try{
    	for (var j = 0; j < addedGroups.length; j++) {
	    	for (var i = 0; i < addedGroups[j][3].length; i++) {
	    		for (var k = 0; k < addedGroups[j][3][i][3].length; k++) {
		    	try{
		    		//console.info(addedGroups[j][3][i][3][k]+'exl');
		    		document.getElementById(addedGroups[j][3][i][3][k]+'exl').checked = true;
		    	}
		    	catch(e){console.info('second try ' + e)}
	    		}
			}
    	}
    }catch(e){console.info('first try ' + e)}
    
}
/**
 * 
 * @param mode - edit/view
 * @param array - added/create
 * @param rowNumber - array position number
 */
function popupMatrix(mode, useArray, rowNumber){
	
	//rowNumber = rowNumber -1;
	array = [];
	if(useArray == "addedGroups"){
		for (var i = 0; i < addedGroups.length; i++) {
			if(addedGroups[i][0] == rowNumber){
				rowNumber = i;
				break;
			}
		}
		array.push(addedGroups[rowNumber][2], addedGroups[rowNumber][3][0][1], addedGroups[rowNumber][3][0][2], addedGroups[rowNumber][3][0][3]);
	}
	else if(useArray == "createdGroups"){
		var select = document.getElementById('groupCountry');
		var groupCountry = '';
		for (var i = 0; i < select.options.length; i++) {
		  if (select.options[i].selected) {
			  groupCountry = select.options[i].value;
			  break;
		  }
		}
		for (var i = 0; i < createdGroups.length; i++) {
			if(createdGroups[i][0] == rowNumber){
				rowNumber = i;
				break;
			}
		}
		console.info(rowNumber);
		array.push(groupCountry, createdGroups[rowNumber][1], createdGroups[rowNumber][2], createdGroups[rowNumber][3]);
	}
	else{
		var select = document.getElementById('groupCountry');
		var groupCountry = '';
		for (var i = 0; i < select.options.length; i++) {
		  if (select.options[i].selected) {
			  groupCountry = select.options[i].value;
			  break;
		  }
		}
		if(groupCountry == ''){
			alert("Please select country...");
			return;
		}
		
		var select = document.getElementById("groupGridComponent");
		var component = select.options[select.selectedIndex].value;
		if(component == ''){
			alert("Please select component...");
			return;
		}
		
		var select = document.getElementById('groupGridColor');
		var colors = [];
		for (var i = 0; i < select.options.length; i++) {
		  if (select.options[i].selected) {
			  colors.push(select.options[i].value);
		  }
		}
		if(colors.length == 0){
			alert("Please select atleast one color...");
			return;
		}
		
		array.push(groupCountry, component, colors);
	}
	var disable = '';
	$("#popupback3").show();
	if(mode == 'view'){
		$("#popupback3").hide();
		disable = ' disabled="disabled"';
	}
	//matrixType {template, grid}
	var matrix = '<table class="table table-bordered tab1panelTalbe">'
	matrix += '<thead>';
	matrix += '<tr>';
	matrix += '<th class="textcenter">Country</th>';
	matrix += '<th class="textcenter">Component</th>';
	matrix += '<th class="textcenter">Color</th>';
	matrix += '<th class="textcenter">'+demtypeVerti+'</th>';
	matrix += '<th colspan="'+demHori.length+'" style="text-align:center">'+demtypeHori+'</th>';
	matrix += '</tr>';
	matrix += '</thead>';
	matrix += '<tbody>';
	
	var rowsPanCol = 0;
	var rowsPanComp = 0;
	
	matrix += '<tr>';
	matrix += '<td></td>';
	matrix += '<td></td>';
	matrix += '<td></td>';
	matrix += '<td></td>';
	for (var k = 0; k < demHori.length; k++) {
		matrix += '<td class="table-size-header">'+demHori[k]+'</td>';
	}
	matrix += '</tr>';
	
	rowsPanComp = demVerti.length * array[2].length;
	
	for (var j = 0; j < array[2].length; j++) {
		rowsPanCol = demVerti.length;
		
		for (var a = 0; a < demVerti.length; a++) {
			matrix += '<tr>';
			if(a == 0 && j == 0){
				//var rowsPanCountry = (demVerti.length * array[2].length * components.length);
				matrix += '<td rowspan="'+rowsPanComp+'">'+array[0]+'</td>';
				matrix += '<td rowspan="'+rowsPanComp+'">'+array[1]+'</td>';
			}
			if(a == 0){
				matrix += '<td rowspan="'+rowsPanCol+'">'+array[2][j]+'</td>';
			}
			matrix += '<td>'+demVerti[a]+'</td>';
			for (var b = 0; b < demHori.length; b++) {
//						if(matrixType == "template"){
//				matrix += '<td class="cernter-x"><span class="glyphicon glyphicon-remove"></span></td>';
//						}
//						else{
				matrix += '<td class="cernter-x"><input '+disable+' type="checkbox" id="'+array[0]+":"+array[1]+":"+array[2][j]+":"+demVerti[a]+":"+demHori[b]+'" class="sizeMatrix"></td>';
//						}
			}
			matrix += '</tr>';
		}
	}

	matrix += '</tbody></table>';
    //$("#popupGroupGrid").html("");
    //$("#popupGroupGrid").html(matrix);
    document.getElementById("popupGroupGrid").innerHTML=matrix;
    
    
    if(useArray == "addedGroups"){
    	try{
        	for (var j = 0; j < addedGroups.length; j++) {
    	    	for (var i = 0; i < addedGroups[j][3].length; i++) {
    	    		for (var k = 0; k < addedGroups[j][3][i][3].length; k++) {
    		    	try{
    		    		console.info(addedGroups[j][3][i][3][k]+'exl');
    		    		document.getElementById(addedGroups[j][3][i][3][k]).checked = true;
    		    	}
    		    	catch(e){console.info('second try ' + e)}
    	    		}
    			}
        	}
        }catch(e){console.info('first try ' + e)}
    }
    
    try{
    	for (var j = 0; j < createdGroups.length; j++) {
	    	for (var i = 0; i < createdGroups[j][3].length; i++) {
		    	try{
		    		document.getElementById(createdGroups[j][3][i]).disabled = true;
		    		if(mode == 'view'){
		    			document.getElementById(createdGroups[rowNumber][3][i]).checked = true;
		    		}
		    	}
		    	catch(e){console.info('second try ' + e)}
			}
    	}
    	try{
        	for (var j = 0; j < addedGroups.length; j++) {
    	    	for (var i = 0; i < addedGroups[j][3].length; i++) {
    	    		for (var k = 0; k < addedGroups[j][3][i][3].length; k++) {
    		    	try{
    		    		document.getElementById(addedGroups[j][3][i][3][k]).disabled = true;
    		    		if(mode == 'view'){
    		    			document.getElementById(addedGroups[j][3][i][3][k]).checked = true;
    		    		}
    		    	}
    		    	catch(e){console.info('second try ' + e)}
    	    		}
    			}
        	}
        }catch(e){console.info('first try ' + e)}
    }catch(e){console.info('first try ' + e)}
    
	if(mode == 'edit'){
	    try{
	    	var counter = rowNumber;
	    	for (var i = 0; i < createdGroups.length; i++) {
	    		if(createdGroups[i][0] == rowNumber){
	    			rowNumber = i;
	    			console.info(i);
	    			break;
	    		}
	    	}
		    for (var i = 0; i < createdGroups[rowNumber][3].length; i++) {
		    	try{
		    		if(useArray == "" && counter > 0){
		    			document.getElementById(createdGroups[rowNumber][3][i]).checked = true;
		    			document.getElementById(createdGroups[rowNumber][3][i]).disabled = false;
		    		}
		    	}
		    	catch(e){}
			}
	    }catch(e){}
    }
	
	if(document.getElementById("sizeWiseCost").checked == false){
		$(".sizeMatrix").each(function() {
			this.checked = true;
			this.disabled = true;
	    });
	}
	
}

var checkBoxes = new Array();
function saveMatrix(){
//	sizeMatrix
	checkBoxes = new Array();
	$(".sizeMatrix:checked").each(function() {
		checkBoxes.push(this.id);
    });
	$('#schmodalpopup').modal('toggle');
//	var checkBoxes = document.getElementsByClassName("sizeMatrix");
//	for (var i = 0; i < checkBoxes.length; i++) {
//		console.info(checkBoxes[i]);
//	}
}
/**
 * 
 * @param e
 */
function addedGroupGrid(){
	var grid = '';
	grid += '<table id="route" class="display table table-striped table-bordered" cellspacing="0">';
	grid += '<thead><tr>';
	grid += '<th class="textcenter">Group Name</th>';
	grid += '<th class="textcenter">Country</th> ';
	grid += '<th class="textcenter">Advance Combination</th>';
	grid += '<th class="textcenter">Actions</th>';
	grid += '</tr></thead>';
	grid += '<tbody>';

	if(addedGroups.length == 0){
		grid += '<tr class="gradeX"><td colspan="4" class="textcenter">There are no groups...</td></tr>'
	}
	for (var i = 0; i < addedGroups.length; i++) {
		grid += '<tr class="gradeX"><td class="textcenter">'+addedGroups[i][1];
		grid += '</td><td class="textcenter">'+addedGroups[i][2]+'</td>';
		grid += '<td class="textcenter"><div class="advance-comb">';
		grid += '<a onclick="popupMatrix(\'view\', \'addedGroups\', '+addedGroups[i][0]+')" class="edit"';//
		grid += 'data-toggle="modal" data-target=".drop-down-select-model"><span class="fa fa-list-alt marginRight3"></span>View Combinations</a>';
		grid += '</div></td><td class="center"><div class="middle-align-editable"><div class="edit-toggle">';
		grid += '<a class="edit" onclick="editAddedGroup('+addedGroups[i][0]+');"><span class="glyphicon glyphicon-pencil"></span> Edit</a></div>';
		grid += '<div class="delete-toggle"><a class="delete" onclick="deleteAddedGroup('+addedGroups[i][0]+');">';
		grid += '<span class="glyphicon glyphicon-remove"></span> Delete </a></div></div></td></tr>';
	}
	grid += '</tbody>';
	grid += '</table>';

	$("#addedGroupGrid").html("");
	$("#addedGroupGrid").html(grid);
}

function showGroupGrid(){
	var grid = '';
	grid += '<table id="route" class="display table table-striped table-bordered" cellspacing="0">';
	grid += '<thead><tr>';
	grid += '<th class="textcenter">Group Name</th>';
	grid += '<th class="textcenter">Country</th> ';
	grid += '<th class="textcenter">Advance Combination</th>';
	grid += '</tr></thead>';
	grid += '<tbody>';

	if(addedGroups.length == 0){
		grid += '<tr class="gradeX"><td colspan="4" class="textcenter">There are no groups...</td></tr>'
	}
	for (var i = 0; i < addedGroups.length; i++) {
		grid += '<tr class="gradeX"><td class="textcenter">'+addedGroups[i][1];
		grid += '</td><td class="textcenter">'+addedGroups[i][2]+'</td>';
		grid += '<td class="textcenter"><div class="advance-comb">';
		grid += '<a onclick="popupMatrix(\'view\', \'addedGroups\', '+addedGroups[i][0]+')" class="edit"';//
		grid += 'data-toggle="modal" data-target=".drop-down-select-model"><span class="fa fa-list-alt marginRight3"></span>View Combinations</a>';
		grid += '</div></td></tr>';
	}
	grid += '</tbody>';
	grid += '</table>';

	$("#groupGridView").html("");
	$("#groupGridView").html(grid);
}


function createGroupGrid(editRow){
	//generate heading  averageWiseCost  compWiseCost  sizeWiseCost  countryWiseCost
	console.info("*****");
	var buttonAdd = "Add";
	var buttonClear = "Clear";
	
	if(editRow > -1){
		for (var i = 0; i < createdGroups.length; i++) {
			if(createdGroups[i][0] == editRow){
				editRow = i;
				buttonAdd = "Save";
				buttonClear = "Cancel";
				break;
			}
		}
	}
	var grid = '';
	grid += '<table id="route" class="display table table-striped table-bordered" cellspacing="0">';
    grid += '<thead><tr><th class="textcenter">Component</th><th class="textcenter">Color</th> ';
    grid += '<th class="textcenter">Size Dimensions</th><th class="textcenter">Actions</th></tr>';
    grid += '</thead><tbody>';
    
    
    //generate first row
    if(document.getElementById("compWiseCost").checked == false){
    	grid += '<tr class="gradeX"><td class="textcenter"><select type="text" id="groupGridComponent" disabled class="form-control">';
    	grid += '<option disabled value="All" selected>All</option>';
    }
    else{
    	grid += '<tr class="gradeX"><td class="textcenter"><select type="text" id="groupGridComponent" class="form-control">';
      	for (var i = 0; i < components.length; i++) {
      		var select = "";
      		if(editRow > -1){
    	  		if(createdGroups[editRow][1] == components[i]){
    	  			select = "selected";
    	  		}
      		}
      		grid += '<option value="'+components[i]+'" '+select+'>'+components[i]+'</option>';
    	}
    }

    grid += '</select></td><td class="textcenter fcstdChosen">';
    grid += '<select data-placeholder="Select Color" id="groupGridColor" class="chosen-select" multiple style="width:100%;" tabindex="4">';
//    grid += '<option value=""></option>';
    for (var i = 0; i < colors.length; i++) {
    	var select = "";
    	if(editRow > -1){
    		for (var j = 0; j < createdGroups[editRow][2].length; j++) {
    			if(colors[i] == createdGroups[editRow][2][j]){
    				select = "selected";
    				break;
    			}
    		}
    	}
    	grid += '<option value="'+colors[i]+'" '+select+'>'+colors[i]+'</option>';
	}
    var clickEvent = 'popupMatrix(\'edit\', \'\', 0);';
    if(editRow > -1){
    	clickEvent = 'popupMatrix(\'edit\', \'\', '+createdGroups[editRow][0]+');';
    }
    
    grid += '</select></td><td class="textcenter"><div class="advance-comb">';
    grid += '<a onclick="addmodalpopup33(\'cs_id_styleId\');'+clickEvent+'" type="button"';
    grid += 'class="btn-md dropdown-toggle " data-toggle="modal" data-target="#schmodalpopup" >';
    //grid += '<span class="glyphicon glyphicon-search"></span></a>';
   	
    /*
    grid += '<a class="edit" href="javascript:;" ';
    if(editRow > -1){
    	grid += 'onclick="popupMatrix(\'edit\', \'\', '+createdGroups[editRow][0]+');"';
    }else{
    	grid += 'onclick="popupMatrix(\'edit\', \'\', 0);"';
    }*/
//    "
    //grid += 'class="btn btn-primary btn-xs dropdown-toggle " data-toggle="modal" data-target=".drop-down-select-model-pop">';
    grid += '<span class="fa fa-crop marginRight3"></span>Set Size wise dimensions</a></div></td>';
    grid += '<td class="center"><div class="middle-align-editable"><div class="edit-toggle view-btn"><a onclick="addNewGroup('+editRow+');" class="edit">';
    grid += '<span class="glyphicon glyphicon-plus"></span> '+buttonAdd+'</a></div><div class="delete-toggle"><a onclick="clearNewGroup();" ';
    grid += 'class="delete"><span class="glyphicon glyphicon-remove-sign"></span> '+buttonClear+'</a></div></div></td></tr>';

    console.info(editRow);
    for (var i = 0; i < createdGroups.length; i++) {
		if(i != editRow){
			grid += '<tr class="gradeX"><td class="textcenter">'+createdGroups[i][1]+'</td>';
		    grid += '<td class="textcenter">';
		    for (var j = 0; j < createdGroups[i][2].length; j++) {
		    	grid += createdGroups[i][2][j];
		    	if(j != (createdGroups[i][2].length-1)){
		    		grid += ", ";
		    	}
		    }
		    grid += '</td><td class="textcenter"><div class="advance-comb2">';
		    grid += '<a class="edit" href="javascript:;" onclick="popupMatrix(\'view\', \'createdGroups\', '+createdGroups[i][0]+');" data-toggle="modal" ';
		    grid += 'data-target=".drop-down-select-model"><span class="fa fa-crop marginRight3"></span>Set Size wise dimensions</a></div>';
		    grid += '</td><td class="center"><div class="middle-align-editable"><div class="edit-toggle">';
		    grid += '<a class="edit" onclick="editNewGroup('+createdGroups[i][0]+');"><span class="glyphicon glyphicon-pencil"></span> Edit</a>';
		    grid += '</div><div class="delete-toggle"><a class="delete" onclick="deleteNewGroup('+createdGroups[i][0]+');"><span class="glyphicon glyphicon-remove">';
		    grid += '</span> Delete </a></div></div></td></tr>';
		}
    }
    
    grid += '</tbody>';
    grid += '</table>';

	$("#groupGrid").html("");
	$("#groupGrid").html(grid);
	
    var option = document.createElement("option");
	option.text = "All";
	option.value = "All";
	document.getElementById("groupCountry").disabled = false;
	document.getElementById("groupGridComponent").disabled = false;
	if(!(document.getElementById("compWiseCost").checked)){ //compWiseCost
		var x = document.getElementById("groupGridComponent");
		x.add(option);
		x.disabled = true;
	}
	if(!(document.getElementById("countryWiseCost").checked)){ //country wise
		var y = document.getElementById("groupCountry");
		y.add(option);
		y.disabled = true;
	}
	
}

function editAddedGroup(lineNumber){
	console.info("editAddedGroup "+lineNumber);
	for (var i = 0; i < addedGroups.length; i++) {
		if(addedGroups[i][0] == lineNumber){
			//createdGroups.splice(i, 1);
			//createGroupGrid(-1);
			createdGroups = [];
			for (var j = 0; j < addedGroups[i][3].length; j++) {
				createdGroups[j] = addedGroups[i][3][j];
			}
			//groupName
			//groupCountry
			hideGrid();showAddForm();
			createGroupGrid(-1);
			console.info(addedGroups[i]);
			break;
		}
	}
	//createGroupGrid(lineNumber);
}

function deleteAddedGroup(lineNumber){
	console.info("deleteAddedGroup "+lineNumber);
	var del = confirm("Do you really want to delete this group?");
	if (del && lineNumber > -1) {
		for (var i = 0; i < addedGroups.length; i++) {
			if(addedGroups[i][0] == lineNumber){
				addedGroups.splice(i, 1);
				addedGroupGrid();
				break;
			}
		}
	}
}

function clearNewGroup(){
	console.info("clearNewGroup");
	createGroupGrid(-1);
}

function editNewGroup(lineNumber){
	console.info("editNewGroup");
	createGroupGrid(lineNumber);
}

function deleteNewGroup(lineNumber){
	console.info("deleteNewGroup");
	var del = confirm("Do you really want to delete this group combination?");
	if (del && lineNumber > -1) {
		for (var i = 0; i < createdGroups.length; i++) {
			if(createdGroups[i][0] == lineNumber){
				createdGroups.splice(i, 1);
				createGroupGrid(-1);
				break;
			}
		}
	}
}

var addedGroups = new Array();
var createdGroups = new Array();
function addNewGroup(editRow){
//	 check component and color is null, can't add null component and color
	if(document.getElementById("sizeWiseCost").checked == false){
		$(".sizeMatrix").each(function() {
			this.checked = true;
			this.disabled = true;
	    });
	}
	
	var select = document.getElementById("groupGridComponent");
	var component = select.options[select.selectedIndex].value;
	
	var select = document.getElementById('groupCountry');
	var groupCountry = '';
	for (var i = 0; i < select.options.length; i++) {
	  if (select.options[i].selected) {
		  groupCountry = select.options[i].value;
		  break;
	  }
	}
	if(groupCountry == ''){
		alert("Please select country...");
		return;
	}
	//headcol sortable ui-sortable
	var select = document.getElementById('groupGridColor');
	var colors = [];
	for (var i = 0; i < select.options.length; i++) {
	  if (select.options[i].selected) {
		  colors.push(select.options[i].value);
	  }
	}
	if(component == ''){
		alert("Please select component...");
		return;
	}
	
	if(colors.length == 0){
		alert("Please select atleast one color...");
		return;
	}
	
	var tempCheckArr = new Array();
	$(".sizeMatrix:checked").each(function() {
		tempCheckArr.push(this.id);
    });
	if(tempCheckArr.length == 0){
		alert("Please select \"Set size wise dimensions\" before add this component for group...");
		return;
	}
	
	if(editRow > -1){
		var nextId = editRow
		checkBoxes = new Array();
		$(".sizeMatrix:checked").each(function() {
			checkBoxes.push(this.id);
	    });
		createdGroups[nextId] = [nextId, component, colors, checkBoxes];
	}
	else{
		var nextId = getNextId(createdGroups);
		checkBoxes = new Array();
		if(document.getElementById("sizeWiseCost").checked == false){
			//***************************************
			if(createdGroups.length > 0 || addedGroups > 0){
				alert("You are already assigned all combinations of group...");
				return;
			}
			else{
				for (var i = 0; i < colors.length; i++) {
					for (var j = 0; j < demVerti.length; j++) {
						for (var k = 0; k < demHori.length; k++) {
							checkBoxes.push([groupCountry+":"+component+":"+colors[i]+":"+demVerti[j]+":"+demHori[k]]);
						}
					}
				}
			}
		}else{
			$(".sizeMatrix:checked").each(function() {
				checkBoxes.push(this.id);
		    });
		}
		createdGroups.push([nextId, component, colors, checkBoxes]);
	}
	console.info("addNewGroup");
	checkBoxes = new Array();
	createGroupGrid(-1);
}

function applyNewGroup(){
	
	console.info("51998999");
	var success = true;
	var groupName = document.getElementById('groupName').value;
	if(groupName == '' || groupName == null){
		alert("Please enter group name...");
		return;
	}
	else{
		for (var i = 0; i < addedGroups.length; i++) {
			if(addedGroups[i][1] == groupName){
				alert("\" "+groupName+" \" is already used. Please enter different group name...");
				return;
			}
		}
	}
	var select = document.getElementById('groupCountry');
	var groupCountry = '';
	for (var i = 0; i < select.options.length; i++) {
	  if (select.options[i].selected) {
		  groupCountry = select.options[i].value;
		  break;
	  }
	}
	
	if(groupCountry == '' || groupCountry == null){
		alert("Please select group country...");
		return;
	}
	
	var nextId = getNextId(addedGroups);
	addedGroups.push([nextId, groupName, groupCountry, createdGroups]);
	hideAddForm();
    showGrid();
	addedGroupGrid();
	if(document.getElementById("countryWiseCost").checked == false ||(document.getElementById("countryWiseCost").checked && 
			document.getElementById("compWiseCost").checked && document.getElementById("sizeWiseCost").checked)){
		var x = document.getElementById("groupCountry");
		var option = document.createElement("option");
		option.text = "All";
		option.value = "All";
		x.add(option);
		document.getElementById("groupCountry").disabled = true;
	}
	else{
		fillSelectedCountry();
	}
	
	clearCreateGroupGrid();
	document.getElementById('groupName').value = '';
	generateMatrix('grid');
}

function clearCreateGroupGrid(){
	createdGroups = new Array();
	createGroupGrid(-1);
}

function fillSelectedCountry(){
	var comboBox = document.getElementById("groupCountry");
	while(comboBox.options.length > 0){                
	    comboBox.remove(0);
	}
	var x = document.getElementById("groupCountry");
	var option = document.createElement("option");
	option.text = "";
	option.value = "";
	x.add(option);
	//var options = document.getElementById("countryies");
	for (var i = 0; i < countries.length; i++) {
//		if(options[i].selected){
			var option = document.createElement("option");
			option.text = countries[i];//options[i].value;
			option.value = countries[i];//options[i].value;
			x.add(option);
//		}
	}

}

function getNextId(array){
	try{
		return array[(array.length-1)][0] + 1;
	}
	catch(e){
		return 1;
	}
}

function selectDim(value, operation) {
		console.info(value);
		var oper = document.getElementById("dim-vertical-type").getElementsByTagName("option");
		oper[0].disabled = false;
		var oper = document.getElementById("dim-horizontal-type").getElementsByTagName("option");
		oper[0].disabled = false;
//		$(".vertical_divs").show();
//	    $(".horizontal_divs").show();
		if(operation == "Vertical"){
	        $(".vertical_divs").hide();
	        $("#"+operation+"_"+value).show();
	        operationSelect[0] = "V-select-"+value;
	    }
	    if(operation == "Horizontal"){
	        $(".horizontal_divs").hide();
	        $("#"+operation+"_"+value).show();
	        operationSelect[1] = "H-select-"+value;//​​​​
	    }
	    if(operation == "Hide"){
	        $(".vertical_divs").hide();
	        $(".horizontal_divs").hide();
	    }
		if(value != "-- Select an option --"){
//			$(".vertical_divs").hide();
//	        $(".horizontal_divs").hide();
		    try{
		    	op = document.getElementById("dim-horizontal-type").getElementsByTagName("option");
		        for (var i = 1; i < op.length; i++) {
		        	if(op[i].disabled == true){
		        		op[i].disabled = false;
		        	}
		        }
		        
		        op = document.getElementById("dim-vertical-type").getElementsByTagName("option");
		        for (var i = 1; i < op.length; i++) {
		        	if(op[i].disabled == true){
		        		op[i].disabled = false;
		        	}
		        }
		        
		    	index = document.getElementById("dim-horizontal-type").selectedIndex;
		    	document.getElementById("dim-horizontal-type").options[index].disabled=true;
		    	index = document.getElementById("dim-vertical-type").selectedIndex;
		    	document.getElementById("dim-vertical-type").options[index].disabled=true;
		    }catch(e){
		    	console.info(e);
		    }
		}
	}


function templateMatrix(){
	var select = document.getElementById('dim-vertical-type');
	for (var i = 0; i < select.options.length; i++) {
	  if (select.options[i].selected) {
		  demtypeVerti = select.options[i].value;
		  break;
	  }
	}
	select = document.getElementById('dim-horizontal-type');
	for (var i = 0; i < select.options.length; i++) {
	  if (select.options[i].selected) {
		  demtypeHori = select.options[i].value;
		  break;
	  }
	}
	
	var index = document.getElementById("dim-vertical-type").selectedIndex;
	var option = document.getElementById("dim-vertical-type").options[index];
	demVerti = new Array();
	select = document.getElementById('V-select-'+option.value);
	for (var i = 0; i < select.options.length; i++) {
	  if (select.options[i].selected) {
		  demVerti.push(select.options[i].value);
	  }
	}
	
	index = document.getElementById("dim-horizontal-type").selectedIndex;
	option = document.getElementById("dim-horizontal-type").options[index];
	demHori = new Array();
	select = document.getElementById('H-select-'+option.value);
	for (var i = 0; i < select.options.length; i++) {
	  if (select.options[i].selected) {
		  demHori.push(select.options[i].value);
	  }
	}
	

//	var demVerti = ["AA","BB"];
//	var demHori = ["12","14","18","20","55"];
	generateMatrix('template');
}

/**
 * End of the final costing grouping
 */

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
 * open a style which contain all style details in view mode
 */
function openstyle(){
	
	locationCode = document.getElementById("cs_id_locationCode").value;
	custCode = document.getElementById("cs_id_custCode").value;
	styleId = document.getElementById("cs_id_styleId").value;
	depCode = document.getElementById("cs_id_depCode").value;
	compCode = document.getElementById("cs_id_compCode").value;
	
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
function changefmv(fmv,id){
	buyerCode=document.getElementById("cs_id_custCode").value;
	d_Dates=document.getElementById("createdOn").value;
	Volume=document.getElementById("orderQty").value;
	if(Volume=="" ||  buyerCode=="" || d_Dates==""){
		alert("Please Add Order Quantity");
		return fmv;
		//pcs_id_custCode="NOT"; createdOn="NOT";orderQty="NOT";
	}
	else if(fmv==null || fmv==""){
		alert("Please Add FMV Category");
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
			document.getElementById(id+"_fmv").value=fmvrt[0];
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
function checkenter(e){
	 var keyCode = e.which ? e.which : e.keyCode;
	 if(keyCode==13){
		 getCostsheets();
	 }
}

function getCostsheets(){
	
	custCode=document.getElementById("cs_id_custCode").value;
	locationCode=document.getElementById("cs_id_locationCode").value;
	depCode=document.getElementById("cs_id_depCode").value;
	styleId=document.getElementById("cs_id_styleId").value;
	compCode=document.getElementById("cs_id_compCode").value;
	season=document.getElementById("cs_season").value;
	styleDescription=document.getElementById("cs_styleDescription").value;
	query=document.getElementById("query").value;
	
	if(custCode==null || locationCode==null || depCode==null || styleId==null || compCode==null ||  season==null || custCode=="" || locationCode=="" ||  depCode=="" ||  styleId=="" ||  compCode=="" ||  season=="" ){
		alert("Please Select all filed search ");
	}
	else{
		if(query!=null && query!=""){
			//mercostsheethdrs?custCode=KANDY&locationCode=HO&depCode=FINAN&styleId=ST1022&compCode=Hamdia&styleDescription=nothing&season=PS&costsheet=
		window.location.replace("mercostsheethdrs?q="+query+"&custCode="+custCode+"&styleDescription="+styleDescription+"&locationCode="+locationCode+"&depCode="+depCode+"&styleId="+styleId+"&season="+season+"&compCode="+compCode+"&costsheet=");
		}
		else{
			window.location.replace("mercostsheethdrs?custCode="+custCode+"&styleDescription="+styleDescription+"&locationCode="+locationCode+"&depCode="+depCode+"&styleId="+styleId+"&season="+season+"&compCode="+compCode+"&costsheet=");
		
		}
	}	
}

function getpreCostsheets(id){
	custCode=document.getElementById("pcs_id_custCode").value;
	locationCode=document.getElementById("pcs_id_locationCode").value;
	depCode=document.getElementById("pcs_id_depCode").value;
	styleId=document.getElementById("pcs_id_styleId").value;
	compCode=document.getElementById("pcs_id_compCode").value;
	season=document.getElementById("pcs_season").value;
	styleDescription=document.getElementById("pcs_styleDescription").value;
	query=document.getElementById("pquery"+id).value;
	
	if(custCode==null || locationCode==null || depCode==null || styleId==null || compCode==null ||  season==null || custCode=="" || locationCode=="" ||  depCode=="" ||  styleId=="" ||  compCode=="" ||  season=="" ){
		alert("Please Select all filed search ");
	}
	else{
		if(query!=null && query!=""){
			//mercostsheethdrs?custCode=KANDY&locationCode=HO&depCode=FINAN&styleId=ST1022&compCode=Hamdia&styleDescription=nothing&season=PS&costsheet=
		window.location.replace("mercostsheethdrs?q="+query+"&custCode="+custCode+"&styleDescription="+styleDescription+"&locationCode="+locationCode+"&depCode="+depCode+"&styleId="+styleId+"&season="+season+"&compCode="+compCode+"&grid="+id+"&precostsheet=");
		}
		else{
			window.location.replace("mercostsheethdrs?custCode="+custCode+"&styleDescription="+styleDescription+"&locationCode="+locationCode+"&depCode="+depCode+"&styleId="+styleId+"&season="+season+"&compCode="+compCode+"&precostsheet=");
		
		}
	}
}
var precostsheetRowMatCodes=new Array();
/**
 * 
 */
function showAddRow_mat(){
	$('#pannel2Body').collapse('show');
	document.getElementById('pannel2Body').className = "panel-collapse collapse in";
	$("#detailsrawmat").show()
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
	console.log(id);
	selecteditemcategory=id;
	precostsheetRowMatCodes=new Array();
	rowmatcom=new Array();
	var preCostSheetNo="";
	var versionNo="";
	var costsheetType="";
	try{
	preCostSheetNo=document.getElementById("preCostSheetNo").innerHTML;
	versionNo=document.getElementById("versionNo").innerHTML;
	costsheetType=document.getElementById("preCostSheetType").innerHTML;
	}catch(e){
		console.log(e);
	}
	/*preCostSheetNo="2";
	versionNo="0";
	costsheetType="HO";*/
	console.log(preCostSheetNo);
	var div="";
	if(preCostSheetNo==""||versionNo==""||costsheetType=="" ){
		console.log(preCostSheetNo+ " " +versionNo+ "  "+costsheetType);
		div  +='<div class="row button_fix_final_cost_sheet">';
			div  +='<div class="pull-right margin-addstyleroute">';
				div  +='<div class="input-group custom-search-form " style="width: 390px;">';
					div  +='<a onclick="document.getElementById(\'pannel2Body2\').style.display=\'inline\';document.getElementById(\'detailsrawmat\').style.display=\'inline\';HideRow_matGrid();showAddRow_mat();document.getElementById(\'mercostsheethdrForm3\').reset();" class="btn btn-warning btn-embossed pull-right"><span class="glyphicon glyphicon-plus marginRight4"></span>Add  Row Material</a>';
				div  +='</div>';
			div  +='</div>';                   
		div  +='</div>';
		div  +='<div class="row">';
		div +='No Raw materials attached';
		div  +='</div>';
		document.getElementById("rowMaterialScreen").innerHTML=div;
		document.getElementById("bulkActions").style.display="none";
		document.getElementById("bage"+id).innerHTML=0;
		
	}
	else{	
			div  +='<div class="row">';
				div  +='<div class="pull-right margin-addstyleroute" style="margin-top: -5%;">';
					div  +='<div class="input-group custom-search-form " style="width: 390px;">';
						div  +='<input type="text" class="form-control" placeholder="Search and Filter">';
						div  +='<span class="input-group-btn">';
							div  +='<button class="btn btn-info search-form-btn" type="button"  onclick="getRowmat(\''+id+'\')">';
								div  +='<span class="glyphicon glyphicon-search"></span>';
							div  +='</button>';
						div  +='</span>';
						if(stsus!="View")
						div  +='<a onclick="document.getElementById(\'pannel2Body2\').style.display=\'inline\';document.getElementById(\'detailsrawmat\').style.display=\'inline\';HideRow_matGrid();showAddRow_mat();document.getElementById(\'mercostsheethdrForm3\').reset();selectedBulkaction=0;" class="btn btn-warning btn-embossed pull-right"><span class="glyphicon glyphicon-plus marginRight4"></span>Add  Raw Material</a>';
					div  +='</div>';
				div  +='</div>';                   
			div  +='</div>';
			div  +='<div class="dataTables_wrapper Scroll-for-datatable-add-row-matirials">';
				div  +='<section class="sectionsnewwidth">';
					div  +='<table id="route" class="display table table-striped table-bordered" cellspacing="0">';
						div  +='<thead>';
							div  +='<tr>';
								div  +='<th class="textcenter"><input id="rowmatall" type="checkbox" onclick="Checkall()"  class="margin0 thCheckboxWidth" /></th>';
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
								div  +='<th class="textcenter headcol3 actionbuttonsdisplay">Actions</th>';
								div  +='<th class="textcenter headcol3 actionbuttonsdisplay">Actions</th>';
							div  +='</tr>';
						div  +='</thead>';
						div  +='<tbody>';  
						//var my=  AjaxCall("POST", "", "services/api/mercostsheetrowmaterial/GetByid/"+costSheetNo+"/"+versionNo+"/"+costsheetType+"/"+id+".json"); 
							var my=  AjaxCall("POST", "", "services/api/merprecostsheetrowmaterial/GetByid/"+preCostSheetNo+"/"+versionNo+"/"+costsheetType+"/"+id+".json"); 
						//	var jsn;
						//var my=  AjaxCall("POST", "", "http://localhost:8080/tops-web/services/api/merprecostsheetrowmaterial/GetByid/2/0/HO/FABRIC.json"); 
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
								div  +='<tr class="gradeX">'
									div  +='<td><input type="checkbox" onchange="checkthis(\''+jsn[k].id.precostsheetRowMatCode+'\',\''+jsn[k].id.component+'\')" class="margin0" id="chk'+jsn[k].id.precostsheetRowMatCode+'"/></td>';
								precostsheetRowMatCodes.push(jsn[k]);
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
									div  +='<td class="center headcol3 actionbuttonsdisplay1">';
									div  +='<div class="middle-align">';
										div  +='<div class="edit-toggle-styl-rt edit-toggle edit-toggle">';
											div  +='<a onclick="editrowmaterials( \''+id+'\',\''+jsn[k].id.preCostSheetNo+'\',\''+ jsn[k].id.versionNo+'\',\''+ jsn[k].id.costsheetType+'\',\''+  jsn[k].id.precostsheetRowMatCode+'\',\''+ jsn[k].id.component+'\')"><span class="glyphicon glyphicon-pencil"></span> Edit</a>';
										div  +='</div>';	
										if(stsus!="View"){													
											div  +='<div class="delete-toggle-styl-rt delete-toggle delete-toggle">';
												div  +='<a onclick="if ( confirm(\'do you really need to delete this ?\') == true) {deleterowmaterials(\''+id+'\',\''+jsn[k].id.preCostSheetNo+'\',\''+ jsn[k].id.versionNo+'\',\''+ jsn[k].id.costsheetType+'\',\''+  jsn[k].id.precostsheetRowMatCode+'\',\''+ jsn[k].id.component+'\');}" data-toggle="modal" data-target=".delete-confirmation"><span class="glyphicon glyphicon-remove"></span> Delete </a>'; 
											div  +='</div>';
										}
										div  +='</div>';
									div  +='</td>';
								div  +='</tr>';
								rowmatcom.push(jsn[k].id.precostsheetRowMatCode);
							}
						div  +='</tbody>';
					div  +='</table>';
				div  +='</section>';
			div  +='</div>	';	
		document.getElementById("rowMaterialScreen").innerHTML=div;
		document.getElementById("bage"+id).innerHTML=jsn.length;
		document.getElementById("bulkActions").style.display="inline";
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
	        });
		if(stsus!="View"){
			document.getElementById("mercostsheethdrForm3").reset();
			selecteditemcategory=id;
		}	
		console.log(selecteditemcategory);
		navigterowMatGroup(selecteditemcategory,"grouprowMaterialScreen");
	}
}
var rowmaterialid= new Array();
function Checkall(){
	//'chk'+jsn[k].id.component;
	
	if(!document.getElementById('rowmatall').checked){
		for(var i=0;i<rowmatcom.length;i++){
			document.getElementById('chk'+precostsheetRowMatCodes[i].id.precostsheetRowMatCode).checked = false;
		}
		rowmaterialid=new Array();
	}
	else{
		for(var i=0;i<rowmatcom.length;i++){
			index =arrayindex(rowmaterialid,precostsheetRowMatCodes[i].id.precostsheetRowMatCode+":"+precostsheetRowMatCodes[i].id.component);
			document.getElementById('chk'+precostsheetRowMatCodes[i].id.precostsheetRowMatCode).checked = true;	
			if(index<0)
			rowmaterialid.push(precostsheetRowMatCodes[i].id.precostsheetRowMatCode+":"+precostsheetRowMatCodes[i].id.component);
		}
	}
}

function checkthis (precostsheetRowMatCode,component){
	var sts=document.getElementById('chk'+precostsheetRowMatCode).checked;
	index =arrayindex(rowmaterialid,precostsheetRowMatCode+":"+component);
	if(sts){
		if(index<0)
		rowmaterialid.push(precostsheetRowMatCode+":"+component);
	}
	else{
		if(index>0)
			rowmaterialid.splice(index,1);
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
					div +='<select required="required" type="text" name="UOM" id ="UOM" class="form-control" onfocus="getUOM(\'UOM\')"></select>';			
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
var editmodeComponent="";
var editmodeprecostsheetRowMatCode="";

/*function editrowmaterials(id,preCostSheetNo, versionNo ,costsheetType , precostsheetRowMatCode ,component){
	
	url ="services/api/merprecostsheetrowmaterial/GetByid/"+preCostSheetNo+"/"+versionNo+"/"+costsheetType+"/"+precostsheetRowMatCode+"/"+component+".json";
	var my=  AjaxCall("POST", "", url);
	if (my.readyState == 4 && my.status == 200) {
		jsn = JSON.parse(my.responseText);
		//$('#itemCode').prop('disabled', false);
		//$('#itemType').prop('disabled', true);
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
		document.getElementById(jsn.id.component+"_UOM").innerHTML="<option>"+jsn.uom+"</option>";
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
		//iseRow_matdite=true;
	}
	else{
		return false;
	}
}*/

var selectedBulkaction=0;
function bulkActions(){
	select=document.getElementById("bulk_actions");
	
	if(select.options[0].selected){
		alert("Please select an action");
		selectedBulkaction=0;
	}
	else if(select.options[1].selected){
		//mercostsheethdrform searchForm
		if(rowmaterialid!=null && rowmaterialid!=''){
			selectedBulkaction=1;
			formdata=jQuery("#searchForm").serialize()+"&";
			formdata+=jQuery("#costSheetGeneralForm").serialize()+"&"+jQuery("#costSheetTypeForm").serialize()+"&";
			formdata+="section=section3";
			formdata+="&bulkActions=AlltoAll";
			formdata+="&dataid="+rowmaterialid;
			var success=  AjaxCall("POST", formdata, "mercostsheethdrform");
		}
		else{
			alert("Nothing selected");
			return 0;
		}
		
		//window.relord();
	}
	else if(select.options[2].selected){
		
		if(document.getElementById("compWiseCost").checked == false && document.getElementById("averageWiseCost").checked){
			alert("This Function is not applicapble Reson ~ Component Wise Costing = No and Average Wise Costting = yes ");
			return 0;
		}
		else if(document.getElementById("compWiseCost").checked == false && document.getElementById("averageWiseCost").checked == false ){
			selectedBulkaction=2;
			document.getElementById("pannel2Body2").style.display="inline";
			createGroupRawmat1();
			showAddRow_mat();
			//HideRow_matGrid();
			//$("#detailsrawmat").hide();
			document.getElementById("detailsrawmat").style.display="none";
		}
		else{
		//groupid AlltoSelct
			selectedBulkaction=2;
			document.getElementById("pannel2Body2").style.display="inline";
			createGroupRawmat();
			showAddRow_mat();
			HideRow_matGrid();
			//$("#detailsrawmat").hide();
			document.getElementById("detailsrawmat").style.display="none";
		}
	}
	else if (select.options[3].selected){
		//alert("4"+select.value);
	}
}
function delteGroupRawmat(){
	$("#grouprawmat").html("");
}
var grouparray=new Array();

function checkthisG(id){
	var sts=document.getElementById(id+'chk').checked;
	index =arrayindex(grouparray,id);
	if(sts){
		if(index<0)
			grouparray.push(id);
	}
	else{
		if(index>-1)
			grouparray.splice(index,1);
	}
	getchusen();
}
function checkallg(){
	//'chk'+jsn[k].id.component;
	if(document.getElementById('grpall').checked){
		for(var i=0;i<addedGroups.length;i++){
			document.getElementById(addedGroups[i][1]+'chk').checked = false;
			index =arrayindex(grouparray,addedGroups[i][1]);
			grouparray.splice(index,1);
		}
	}
	else{
		for(var i=0;i<addedGroups.length;i++){
			document.getElementById(addedGroups[i][1]+'chk').checked = true;	
			grouparray.push(addedGroups[i][1]);
		}
	}
	getchusen();
}
/**
 * 
 * @param id
 * @returns component wise costing table
 */
function createGroupRawmat2() {
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
					div +='<select required="required" onfocus="optionsforgencodes(\'UMO\',\'UOM\');"  type="text" name="UMO" id ="UMO" class="form-control" onfocus="getUOM(\'UMO\')"></select>';			
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
		
		$("#grouprawmatroute").html("");
		$("#compvscostCon1").html("");
		$("#compvscostCon1").html(div);
		$("#compvscostCon2").html("");
		
}


function createGroupRawmat1() {
	

		var div ='<div class="col-sm-4 col-md-4 ">';
			div +='<div class="form-group formwithsearch marginbottom20">';
				div +='<div class="icon-addon addon-md">';
					div +='<label for="exampleInputEmail1">Consumption </label>';
					div +='<select id="group" data-placeholder="Select Color"  class="chosen-select" multiple style="width:100%;" tabindex="4">';
					for (var i = 0; i < addedGroups.length; i++) {
						div +='<option value="'+addedGroups[i][1]+'">'+addedGroups[i][1]+'</option>';
					}
					div +='</select>';
			div +='</div>';
		div +='</div>  ';
		div +='	<div class="clearfix"></div> ';
		div +='</div>';
		div +='<div class="col-sm-4 col-md-4 ">';
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
					div +='<select required="required" onfocus="optionsforgencodes(\'UMO\',\'UOM\');"  type="text" name="UMO" id ="UMO" class="form-control" onfocus="getUOM(\'UMO\')"></select>';			
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
		
		$("#grouprawmatroute").html("");
		$("#compvscostCon1").html("");
		$("#compvscostCon1").html(div);
		$("#compvscostCon2").html("");
		
}
function createGroupRawmat(){
		var grid = '';
		if(addedGroups.length == 0){
			grid += '<tr class="gradeX"><td colspan="4" class="textcenter">There are no groups...</td></tr>'
		}
		for (var i = 0; i < addedGroups.length; i++) {
			grid += '<tr class="gradeX">';
			grid +=		'<td class="textcenter padding0"><input onchange="checkthisG(\''+addedGroups[i][1]+'\')"  type="checkbox" id="'+addedGroups[i][1]+'chk" class="margin0" ></td>';
			grid +=		'<td class="textcenter">'+addedGroups[i][1]+'</td>';
			grid += 	'<td class="textcenter">'+addedGroups[i][2]+'</td>';
			grid += 	'<td class="textcenter"><div class="advance-comb">';
			grid += 		'<a onclick="popupMatrix(\'view\', \'addedGroups\', '+addedGroups[i][0]+')" class="edit"';//
			grid += 			'data-toggle="modal" data-target=".drop-down-select-model">';
			grid += 			'<span class="fa fa-list-alt marginRight3"></span>';
			grid += 		'View Combinations</a>';
			grid += 	'</div></td></tr>';
		}

		$("#grouprawmat").html("");
		$("#grouprawmat").html(grid);
}

/**
 * 
 * @param id
 * @returns rowmaterial grid for selected rowmaterial type 
 */
function navigterowMatGroup(id,stsus){
	console.log(stsus);
	document.getElementById("pannel2Body2").style.display="inline";
	costsheetRowMatCodes=new Array();
	Growmatcom=new Array();
	CostSheetNo=document.getElementById("costSheetNo").value;
	versionNo=document.getElementById("versionNo").value;
	costsheetType=document.getElementById("costSheetType").value;
	/*CostSheetNo="S1";
	versionNo="1";
	costsheetType="ST1";*/
	console.log(costsheetType+ " - "+versionNo+" - " +CostSheetNo);
	if(CostSheetNo ==""|| costsheetType ==""){
		console.log(costsheetType+ " - "+versionNo+" - " +CostSheetNo);
	}
	else{	
	var div="";
	console.log(stsus);
			 
	//var my=  AjaxCall("POST", "", "services/api/mercostsheetrowmaterial/GetByid/"+costSheetNo+"/"+versionNo+"/"+costsheetType+"/"+id+".json"); 
		var my=  AjaxCall("POST", "", "services/api/mercostsheetrowmaterial/GetByid/"+CostSheetNo+"/"+versionNo+"/"+costsheetType+"/"+id+".json"); 
	//	var jsn;
	//var my=  AjaxCall("POST", "", "http://localhost:8080/tops-web/services/api/merprecostsheetrowmaterial/GetByid/2/0/HO/FABRIC.json"); 
		var jsn;
		if (my.readyState == 4 && my.status == 200) {
			jsn = JSON.parse(my.responseText);
		}
		else{
			return false;
		}
		for(var k=0;k<jsn.length;k++){
			div  +='<tr class="gradeX">'
			costsheetRowMatCodes.push(jsn[k].id.costSheetRowMatCode);
				div  +='<td class="textcenter">'+jsn[k].id.groupId+'</td>';
				div  +='<td class="textcenter">'+jsn[k].id.component+'</td>';
				div  +='<td class="textcenter">'+jsn[k].mstitemtype.itemType+'</td>';
				div  +='<td class="textcenter">'+jsn[k].itemCode+'</td>';
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
				div  +='<td class="textcenter">'+jsn[k].uom+'</td>';
				div  +='<td class="textcenter">'+jsn[k].consStockUom+'</td>';
				div  +='<td class="textcenter">'+jsn[k].priceStockUom+'</td>';
				div  +='<td class="textcenter headcol2 opensnew1">';
					div  +='<div class="operations-toggle">';
						div  +='<a onclick="copyrowmaterials( \''+id+'\',\''+jsn[k].id.costSheetNo+'\',\''+ jsn[k].id.versionNo+'\',\''+ jsn[k].id.costSheetType+'\',\''+  jsn[k].id.costSheetRowMatCode+'\',\''+ jsn[k].id.component+'\',\''+ jsn[k].id.groupId+'\')"><span class="glyphicon glyphicon-folder-open marginRight5"></span> Open as new </a>';
					div  +='</div>';
				div  +='</td>';
				div  +='<td class="center headcol3 actionbuttonsset">';
					div  +='<div class="middle-align">';
						div  +='<div class="edit-toggle-styl-rt edit-toggle edit-toggle">';
							div  +='<a onclick="editrowmaterials( \''+id+'\',\''+jsn[k].id.costSheetNo+'\',\''+ jsn[k].id.versionNo+'\',\''+ jsn[k].id.costSheetType+'\',\''+  jsn[k].id.costSheetRowMatCode+'\',\''+ jsn[k].id.component+'\',\''+ jsn[k].id.groupId+'\')"><span class="glyphicon glyphicon-pencil"></span> Edit</a>';
						div  +='</div>';	
					if(stsus!="View"){													
						div  +='<div class="delete-toggle-styl-rt delete-toggle delete-toggle">';
							div  +='<a onclick="if ( confirm(\'do you really need to delete this ?\') == true) {deleterowmaterials(\''+id+'\',\''+jsn[k].id.costSheetNo+'\',\''+ jsn[k].id.versionNo+'\',\''+ jsn[k].id.costSheetType+'\',\''+  jsn[k].id.costSheetRowMatCode+'\',\''+ jsn[k].id.component+'\',\''+ jsn[k].id.groupId+'\');}" data-toggle="modal" data-target=".delete-confirmation"><span class="glyphicon glyphicon-remove"></span> Delete </a>'; 
						div  +='</div>';
					}
					div  +='</div>';
				div  +='</td>';
			div  +='</tr>';
			Growmatcom.push(jsn[k].id.precostsheetRowMatCode);
		}		
		document.getElementById("grouprowMaterialScreen").innerHTML=div;
		//document.getElementById("bage"+id).innerHTML=jsn.length;
		if(stsus!="View"){
			document.getElementById("mercostsheethdrForm3").reset();
			selecteditemcategory=id;
		}	
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
	        });
	}
}

function getchusen(){
	var div="";
	var grup=new Array();
	console.log( "Component Length : "+ components.length);
	console.log("addedGroups Length : "+addedGroups.length);
	for(var l=0;l<components.length;l++){
		component=components[l];
		for(var i=0;i<addedGroups.length;i++){
			console.log("addedGroups Components Length : "+addedGroups[i][3].length);
			for(var j=0;j<addedGroups[i][3].length;j++)	{
				console.log("group component "+addedGroups[i][3][j][1] + " - component " + component +" - array index of "+addedGroups[i][1] +" -"+arrayindex(grouparray, addedGroups[i][1]));
				if( (addedGroups[i][3][j][1] == component  || addedGroups[i][3][j][1] =="All" ) &&  arrayindex(grouparray, addedGroups[i][1])>-1 && arrayindex(grup, addedGroups[i][1])==-1){//arrayindex(grup, addedGroups[i][1])<0
					grup.push(addedGroups[i][1]);
					console.log("added");
					div+='<option value="'+addedGroups[i][1]+'">'+addedGroups[i][1]+'</option>';
				}
				else{
					console.log("addedGroups "+ arrayindex(grup, addedGroups[i][1])+"  - groupadded to select "+grup);
					console.log("not added");
				}
			}
		}
		document.getElementById(component+'_group').innerHTML=div;
		
		if($('#'+component+'_group').hasClass("chosen-select") ){
		     $('#'+component+'_group').chosen();
		}
	}
	// $(".chosen-select").chosen();
	
}

var editmodeComponent="";
var editmodeprecostsheetRowMatCode="";
function editrowmaterials(id,CostSheetNo, versionNo ,costsheetType , costsheetRowMatCode ,component,group){
	if(!iseRow_matdite){
	url ="services/api/mercostsheetrowmaterial/get/"+CostSheetNo+"/"+versionNo+"/"+costsheetType+"/"+costsheetRowMatCode+"/"+component+"/"+group+".json";
		var my=  AjaxCall("POST", "", url);
		if (my.readyState == 4 && my.status == 200) {
			jsn = JSON.parse(my.responseText);
			$('#itemType').prop('readonly', true);
			//$('#itemType').prop('disabled', true);
			document.getElementById("itemType").innerHTML="<option selected  value='"+jsn.mstitemtype.itemType+"' >"+jsn.mstitemtype.itemType+"</option>";
			document.getElementById("itemCode").innerHTML="<option selected value='"+jsn.itemCode+"'>"+jsn.itemCode+"</option>";
			document.getElementById("itemDecription").value=jsn.itemDecription;
			document.getElementById("itemColor").innerHTML="<option selected value='"+jsn.itemColor+"'>"+jsn.itemColor+"</option>";
			document.getElementById("itemWidth").value=jsn.itemWidth;
			document.getElementById("shipingType").value=jsn.shipingType;
			document.getElementById("supplierCode").innerHTML="<option selected value='"+jsn.mstsupplier.id.suppCode+"'>"+jsn.mstsupplier.id.suppCode+"</option>";
			document.getElementById("currency").innerHTML="<option selected value='"+jsn.mstcurrency.curCode+"'>"+jsn.mstcurrency.curCode+"</option>";
			document.getElementById("exchangeRate").value=jsn.exchangeRate;
			document.getElementById("price").value=jsn.price;
			document.getElementById("finance").value=jsn.finance;
			if(document.getElementById("compWiseCost").checked == false && document.getElementById("averageWiseCost").checked){
				  
				document.getElementById("consumption").value=jsn.allowance;
				document.getElementById("UMO").innerHTML="<option selected value='"+jsn.uom+"'>"+jsn.uom+"</option>";
				document.getElementById("allowance").value=jsn.allowance;
			}
			else{
				document.getElementById(jsn.id.component+"com_consumption").value=jsn.consumption;
				document.getElementById(jsn.id.component+"_UOM").innerHTML="<option selected value='"+jsn.uom+"'>"+jsn.uom+"</option>";
				document.getElementById(jsn.id.component+"com_allowance").value=jsn.allowance;
				for(var i=0;i<componets.length;i++){
					if(componets[i]!=jsn.id.component)
					document.getElementById("contr"+componets[i]).style.display="none";	
				}
			}
			selecteditemtype=jsn.mstitemtype.itemType;
			//document.getElementById("rowsubmit").style.display="none";
			//document.getElementById("rowUpdate").style.display="inline";
			editmodeComponent=jsn.id.component;
			editmodeprecostsheetRowMatCode=costsheetRowMatCode;
			HideRow_matGrid();showAddRow_mat();
			iseRow_matdite=true;
		}
		else{
			return false;
		}
	}
	else{
		alert("please finished current prosess");
	}
}

/**
 * 
 * @param pre-CostSheet No
 * @param version No
 * @param costsheet Type
 * @param precostsheet RowMaterial Code
 */
function deleterowmaterials(id,preCostSheetNo, versionNo ,costsheetType , precostsheetRowMatCode ,component ,group){
	var formdata = jQuery("#costSheetGeneralForm").serialize() ;//+'&'+ jQuery("#merprecostsheetForm3").serialize(); 
	console.log(formdata);
	formdata +="&section=section3&bulkActions=OneoSelct&deleteRowMat=true&costsheetRowMatCode="+precostsheetRowMatCode+"&component="+component+"&groupId="+group;
	var my=  AjaxCall("POST", formdata, "mercostsheethdrform");
	var jsn;
	if (my.readyState == 4 && my.status == 200) {
		navigterowMat(id,"");
	}
	else{
		alert("Not deleted");
	}
	
}

function navigateFinalSheet(id){
	document.getElementById("fcsmain2").style.display="none";
	document.getElementById("fcsmain1").style.display="none";

	$("#fcsmain2").removeClass("active");
	$("#fcsmain1").removeClass("active");

	document.getElementById(id).style.display="block";
	document.getElementById(id+"Tab").className = "active";
	$(id).addClass("active");
}

function finalWithPre(){
	var formdata = jQuery("#searchFormPreCS").serialize()+'&precostsheet=true&fcsmain2=true';
	console.info(formdata);
	window.location.replace("mercostsheethdrs?"+formdata);
}

function finalWithPreReset(){
	window.location.replace("mercostsheethdrs?fcsmain2=true");
}

function calculateSellingPrice(){
	
	var grid = '';
	grid += '<table id="route" class="display table table-striped table-bordered" cellspacing="0">';
	grid += '<thead><tr>';
	grid += '<th class="textcenter">Details</th>';
	grid += '<th class="textcenter">Component A</th>';
//	grid += '<th class="textcenter">Component B</th>';
//	grid += '<th class="textcenter">Genaral CS</th>';
	grid += '</tr></thead>';
	grid += '<tbody>';

//	if(addedGroups.length == 0){
//		grid += '<tr class="gradeX"><td colspan="4" class="textcenter">There are no groups...</td></tr>'
//	}
//	for (var i = 0; i < addedGroups.length; i++) {
//		grid += '<tr class="gradeX"><td class="textcenter">'+addedGroups[i][1];
//		grid += '</td><td class="textcenter">'+addedGroups[i][2]+'</td>';
//		grid += '<td class="textcenter"><div class="advance-comb">';
//		grid += '<a onclick="popupMatrix(\'view\', \'addedGroups\', '+addedGroups[i][0]+')" class="edit"';//
//		grid += 'data-toggle="modal" data-target=".drop-down-select-model"><span class="fa fa-list-alt marginRight3"></span>View Combinations</a>';
//		grid += '</div></td><td class="center"><div class="middle-align-editable"><div class="edit-toggle">';
//		grid += '<a class="edit" onclick="editAddedGroup('+addedGroups[i][0]+');"><span class="glyphicon glyphicon-pencil"></span> Edit</a></div>';
//		grid += '<div class="delete-toggle"><a class="delete" onclick="deleteAddedGroup('+addedGroups[i][0]+');">';
//		grid += '<span class="glyphicon glyphicon-remove"></span> Delete </a></div></div></td></tr>';
//	}
	grid += '</tbody>';
	grid += '</table>';

	$("#cellingPriceTable").html("");
	$("#cellingPriceTable").html(grid);
	
}

function getcostingsummery(){
	/*
	 *  String country = request.getParameter("country") ;
        String colours = request.getParameter("colours") ;
        String components = request.getParameter("components") ;
        String group = request.getParameter("group") ;
         String costSheetNo= request.getParameter("costSheetNo");
        String versionNo= request.getParameter("versionNo");
        String costsheetType= request.getParameter("costsheetType");
	 */
	var colours=new Array();
	var components=new Array();
	components.push("CAP");
	components.push("1");
	colours.push("GCOLOR");
	var  country="UK";
	var  group="GDF";
	
	var formdata="";
	formdata +="country="+country;
	formdata +="&colours="+colours;
	formdata +="&components="+components;
	formdata +="&group="+group;
	
	costSheetNo="5";
	versionNo="0";
	costsheetType="OGL";
	
	formdata +="&costSheetNo="+costSheetNo;
	formdata +="&versionNo="+versionNo;
	formdata +="&costsheetType="+costsheetType+"";
	
	var my=  AjaxCall("POST", formdata, "mercostsheetcosting?&ajax=true");
	
	if (my.readyState == 4 && my.status == 200) {
		navigterowMat(id,"");
	}
	else{
		alert("Not deleted");
	}
}

$(function() {
    $('#costSheetBody .exportlinks').insertAfter('#costSheetBody .dataTables_wrapper');
});


function makeGroupArray(groups){
	addedGroups = [];
	var jq_groups = groups.split('-');
	for (var i = 0; i < jq_groups.length; i++) {

		var jq_lines = jq_groups[i].split('+');
		var jq_setting = jq_lines[1].split('*');
		var settingRows = [];
		for (var j = 0; j < jq_setting.length; j++) {
			var jq_setLines = jq_setting[j].split('_');
			var ticks = [];
			var colors = [];
			var tick = jq_setLines[2].split(',');
			for (var a = 0; a < tick.length; a++) {
				ticks.push(tick[a]);
			}
			var color = jq_setLines[1].split(',');
			for (var a = 0; a < color.length; a++) {
				colors.push(color[a]);
			}
			var lineFirst = jq_setLines[0].split(',');
			settingRows.push([lineFirst[0],lineFirst[1],colors,ticks])
			
		}
		var groupsLine = jq_lines[0].split(',');
		addedGroups.push([parseInt(groupsLine[0]),groupsLine[1],groupsLine[2],settingRows,groupsLine[3]]);
	}
	
}


