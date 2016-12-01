var styleRouteId="";
function  getStylerours(){

	custCode=document.getElementById("id_custCode").value;
	locationCode=document.getElementById("id_locationCode").value;
	depCode=document.getElementById("id_depCode").value;
	styleId=document.getElementById("id_styleId").value;
	compCode=document.getElementById("id_compCode").value;
	query=document.getElementById("query1").value;
	if(custCode==null || locationCode==null || depCode==null || styleId==null || compCode==null || custCode=="" || locationCode=="" ||  depCode=="" ||  styleId=="" ||  compCode=="" ){
		alert("Please Select all Style fileds befor search");
	}
	else if(query==null || query==""){
		alert("Please Add Search String");
	}
	else{
		window.location.replace("mststylerouteoperations?custCode="+custCode+"&locationCode="+locationCode+"&depCode="+depCode+"&styleId="+styleId+"&compCode="+compCode+"&q="+query);
	}

}
//http://localhost:8080/tops-web/mststylerouteoperations?rop_locationCode=HC&rop_compCode=Redln&rop_custCode=THILAK&rop_depCode=TRANS&rop_styleId=STX022&rop_Style_Description=&rop_Style_Component=Shert&rop_mainColor=Red&rop_styleRouteId=3&rop_id_search=true
function  getStyleroursOperation(){

	custCode=document.getElementById("rop_id_custCode").value;
	locationCode=document.getElementById("rop_id_locationCode").value;
	depCode=document.getElementById("rop_id_depCode").value;
	styleId=document.getElementById("rop_id_styleId").value;
	compCode=document.getElementById("rop_id_compCode").value;
	style_Component=document.getElementById("rop_id_componentId").value;
	mainColor=document.getElementById("rop_id_mainColor").value;
	styleRouteId=document.getElementById("rop_id_styleRouteId").value;
	
	query=document.getElementById("query2").value;
	if(custCode==null || locationCode==null || depCode==null || styleId==null || compCode==null || style_Component ==null || mainColor ==null ||styleRouteId == null  || custCode=="" || locationCode=="" ||  depCode=="" ||  styleId=="" ||  compCode=="" || style_Component=="" || mainColor=="" || styleRouteId==""){
		alert("Please Select all Route fileds befor search");
	}
	else if(query==null || query==""){
		alert("Please Add Search String");
	}
	else{
		window.location.replace("mststylerouteoperations?rop_custCode="+custCode+"&rop_locationCode="+locationCode+"&rop_depCode="+depCode+"&rop_styleId="+styleId+"&rop_compCode="+compCode+"&rop_Style_Component="+style_Component+"&rop_mainColor="+mainColor+"&rop_styleRouteId="+styleRouteId+"&q="+query+"&rop_id_search=true");
	}

}

function addNewRoute(){
	var r=true;
	if(iseditepressed){
		r = confirm("Unsaved form need to reset");
	}	
    if (r == true) {    
		custCode=document.getElementById("id_custCode").value;
		locationCode=document.getElementById("id_locationCode").value;
		depCode=document.getElementById("id_depCode").value;
		styleId=document.getElementById("id_styleId").value;
		compCode=document.getElementById("id_compCode").value;
		
		if(custCode==null || locationCode==null || depCode==null || styleId==null || compCode==null || custCode=="" || locationCode=="" ||  depCode=="" ||  styleId=="" ||  compCode=="" ){
			alert("Please Select all Style fileds befor search");
		}else{
			hideRouteGrid();
			showAddRoute();
			clearRouteForm();
			$('#rtHeading').html("Add Style Route");
		}
		iseditepressed=false;
    }
	
}

/**
 * 
 */
function saveAjxSmv(){
	/*var styleId = document.getElementById("styleId").value;
	var locationCode = document.getElementById("locationCode").value;
	var compCode = document.getElementById("compCode").value;
	var custCode = document.getElementById("custCode").value;
	var depCode = document.getElementById("depCode").value;
	//var componentId = document.getElementById("componentId").value;
	var styleRouteId = document.getElementById("rop_id_styleRouteId").value;*/
	//var operation = document.getElementById("operation").value;
	
	var smvValueArr = new Array();
	/*if(document.getElementById("id_styleRouteId").value == ''){
		document.getElementById("id_styleRouteId").value = document.getElementById("rop_id_styleRouteId").value;
	}*/
    /*request.addParameter("mainColor", "Blue");
    request.addParameter("horizontalDem", "FIT");
    request.addParameter("verticalDem", "INSEAM");
    request.addParameter("horizontalValue", "AA");
    request.addParameter("verticalValue", "12");*/
	if(document.getElementById("averageSmv").readOnly){
		var averageSmvValue = 0;
		var options = document.getElementsByClassName("smvmatrix");
		for (var j = 0; j < smvSelected.length; j++) {
			try{
			var textVal = document.getElementById(smvSelected[j]).value;
			if(textVal==null || textVal==""){
				alert("Please Enter SMVs !");
				return false;
			}
			var temp = [smvHorizontal, smvVertical, smvSelected[j],textVal];
			smvValueArr.push(temp);
			averageSmvValue += parseFloat(textVal);
			}
			catch (e) {
				//  handle exception
				console.info(e);
			}
		}
		if(smvSelected.length > 0){
			if(averageSmvValue > 0){
				document.getElementById("averageSmv").value = averageSmvValue/(smvValueArr.length);
			}
			else{
				document.getElementById("averageSmv").value = 0;
			}
		}
	}

	var success = $('#mststyleoperationsForm').valid();
	if(success){
	/*for(var j = 0; j < smvValueArr.length; j++){
		console.info(smvValueArr);
	}/opSmvSaveBtn*/
		document.getElementById("opSmvSaveBtn").disabled=true;
		var formdata = jQuery("#mststyleoperationsForm").serialize(); 
		formdata += jQuery("#mststyleoperationForm").serialize();
		formdata += '&smvValueArr='+smvValueArr;
		rop_id_styleRouteId=document.getElementById("rop_id_styleRouteId").value
		formdata += '&id.styleRouteId='+rop_id_styleRouteId;
		$.ajax({
			type: "POST",
	        url: "mststyleoperationform",
	        data: formdata,
	        success: function(data) {
	        	document.getElementById('smvMessageDiv').innHTML = "";
//	            $("#smvMessageDiv").html("<div class='alert alert-warning fade in' role='alert'>" +
//	            		"<button type='button' class='close' data-dismiss='alert'><span aria-hidden='true'>×" +
//	            		"</span><span class='sr-only'>Close</span></button>" +
//	            		"<strong>Success!!</strong> All SMV values are saved successfully ..! </div>");
//	            $('#smvMessageDiv').show();
	        	alert("Style route operation is saved successfully ..!");
	            location.replace(window.location.href);
	        },
	        error: function(data){
	        	document.getElementById('smvMessageDiv').innHTML = "";
	            $("#smvMessageDiv").html("<div class='alert alert-error fade in' role='alert'>" +
	            		"<button type='button' class='close' data-dismiss='alert'><span aria-hidden='true'>×" +
	            		"</span><span class='sr-only'>Close</span></button>" +
	            		"<strong>Error!!</strong> Oh snap! You got an error! Please refresh this page and try again! </div>");
	            $('#smvMessageDiv').show();
	            document.getElementById("opSmvSaveBtn").disabled=false;
	        }
	      });
	}
	else{
		$('#error-win-operation').show();
	}
}
function showRouteGrid(){
	$('#styleBrowserBody').collapse('show');
	document.getElementById('styleBrowserBody').className = "panel-collapse collapse in";
}
function showAddRoute(){
	$('#addstyleroute').collapse('show');
	document.getElementById('addstyleroute').className = "panel-collapse collapse in";
}
function hideRouteGrid(){
	$('#styleBrowserBody').collapse('hide');
	document.getElementById('styleBrowserBody').className = "panel-collapse collapse";
}
function hideAddRoute(){
	$('#addstyleroute').collapse('hide');
	document.getElementById('addstyleroute').className = "panel-collapse collapse";
}
function checkCorrValues(component){
	value = component.value;
	if(component.id == "assignLocation"){
		for (var i = 0; i < locationCodes.length; i++) {
			if(value == locationCodes[i]){
				return true;
			}
		}
	}
	if(component.id == "id_mainColor"){
		for (var i = 0; i < mainColors.length; i++) {
			if(value == mainColors[i]){
				return true;
			}
		}
	}
	if(component.id == "id_componentId"){
		var location =document.getElementById("id_locationCode").value;
		var buyer=document.getElementById("id_custCode").value;
		var department=document.getElementById("id_depCode").value;
		var style =document.getElementById("id_styleId").value;
		var company=document.getElementById("id_compCode").value;
		var componentId=document.getElementById("id_componentId").value;
		
		jsnroot = AjaxCall("POST", "", "services/api/stylecomponent/getbyparamid/"+location+"/"+buyer+"/"+department+"/"+style+"/"+company+"/"+componentId+".json");
		if (jsnroot.readyState == 4 && jsnroot.status == 200) {
			jsnroot = JSON.parse(jsnroot.responseText);
		} else {
			console.log("some things wrong");
		}
		document.getElementById("productType").value = jsnroot.productType;
		return true;
		
	}
	document.getElementById(component.id).value = "";
}
var iseditepressed=false;
function saveAjxStyleRoute(){
	if(document.getElementById("id_styleId").value == ""){
		alert('Please select a style first!');
	}
	else{
		success = $('#mststylerouteoperationForm').valid();
		var formdata = jQuery("#mststylerouteoperationForm").serialize()+"&"+jQuery("#mststylerouteoperationsForm").serialize() ;
		formdata+="&styleRouteId="+styleRouteId;
		if(success){
			document.getElementById("btnSaveRoute").disabled=true;
			$.ajax({
		    	type: "POST",
		        url: "mststylerouteoperationform",
		        data: formdata,
		        success: function(data) {
		        	var pathArray = window.location.href.split('&');
		       		var index = pathArray.indexOf("edit=editmode");
		       		if(index > -1){
		       			pathArray.splice(index, 1);
		       		}
					var newUrl = pathArray[0];
					for (var i = 1; i < pathArray.length; i++) {
						newUrl = newUrl +'&'+ pathArray[i]
					}
					console.info(newUrl);
					location.reload(true)
		       	}
			});
		 }
		 else{
			 $('#error-win').show();
			 console.info(success);
		 }
		return false;
	}
}
function checkEditMode(){
	var pathArray = window.location.href.split('&');
	var index = pathArray.indexOf("edit=editmode");
	if(index > -1){
		showRouteGrid();
		hideRouteGrid();
		showAddRoute();
	}
}

function clearRouteForm(){
	$('#mststylerouteoperationForm').trigger("reset");
	//document.getElementById("mststylerouteoperationForm").reset();
	document.getElementById('id_componentId').value = "";
	document.getElementById('id_mainColor').value = "";
	//document.getElementById('styleRouteId').value = "";
	document.getElementById('styleRouteName').value = "";
	document.getElementById('productType').value = "";
	document.getElementById('assignLocation').value = "";
	document.getElementById('id_mainColor').value = "General";
	document.getElementById('id_componentId').value = "";
	document.getElementById('noOfWokers').value = "";
	document.getElementById('cycleTime').value = "";
	document.getElementById('orderQty').value = "";
	document.getElementById('noOfHealpers').value = "";
	document.getElementById('targetDate').value = "";
	document.getElementById('noOfMachines').value = "";
	document.getElementById('workMins').value = "";
	document.getElementById('remarks').value = "";
	document.getElementById('noOfPcs').value = 1;
	$('#createDiv').html("Created By:<br>Created On:");
	$('#modifyDiv').html("Modified By:<br>Modified On:");
	$('#approvDiv').html("Approved By:<br>Approved On:");
	document.getElementById('createdOn').value = "";
	document.getElementById('createBy').value = "";
	document.getElementById('createAt').value = "";
}

function fillRouteForm(route){
	getOptions('assignLocation','mstlocations');
	getOptions('id_componentId','stylecomponent');
	getOptions('id_mainColor','stylemainColor');
	document.getElementById('id_componentId').value = route.componentId;
	document.getElementById('id_mainColor').value = route.mainColor;
	//document.getElementById('styleRouteId').value = route.styleRouteId;
	styleRouteId=route.styleRouteId;
	document.getElementById('styleRouteName').value = route.styleRouteName;
	document.getElementById('productType').value = route.productType;
	document.getElementById('assignLocation').value = route.assignLocation;
	document.getElementById('noOfWokers').value = route.noOfWokers;
	document.getElementById('cycleTime').value = route.cycleTime;
	document.getElementById('orderQty').value = route.orderQty;
	document.getElementById('noOfPcs').value = route.noOfPcs;
	document.getElementById('noOfHealpers').value = route.noOfHealpers;
	document.getElementById('targetDate').value = route.targetDate;
	document.getElementById('noOfMachines').value = route.noOfMachines;
	document.getElementById('workMins').value = route.workMins;
	document.getElementById('remarks').value = route.remarks;
	document.getElementById('routeStatus').value = route.routeStatus;
	var cBy = route.createdBy; var mBy = route.modifiedBy; var aBy = route.approvedBy;
	var cOn = route.createdOn; var mOn = route.modifiedOn; var aOn = route.approvedOn;
	if(cBy == null){ cBy = ''; }
	if(mBy == null){ mBy = ''; }
	if(aBy == null){ aBy = ''; }
	if(cOn == null){ cOn = ''; } else{ cOn = new Date(cOn); cOn = cOn.format(); }
	if(mOn == null){ mOn = ''; } else{ mOn = new Date(mOn); mOn = mOn.format(); }
	if(aOn == null){ aOn = ''; } else{ aOn = new Date(aOn); aOn = aOn.format(); }
	$('#createDiv').html("Created By: "+cBy+"<br>Created On: "+cOn);
	$('#modifyDiv').html("Modified By: "+mBy+"<br>Modified On: "+mOn);
	$('#approvDiv').html("Approved By: "+aBy+"<br>Approved On: "+aOn);
	document.getElementById('createdOn').value = cOn;
	document.getElementById('createBy').value = cBy;
	document.getElementById('createAt').value = route.createdAt;	
}

function editRouteOperation(styleRouteId){
	if(!iseditepressed){
		clearRouteForm();
		var jsnrootopeartion = AjaxCall("POST", "", "services/api/styleroute/routeSearchById/"+styleRouteId + ".json");
		if (jsnrootopeartion.readyState == 4 && jsnrootopeartion.status == 200) {
			jsnrootopeartion = JSON.parse(jsnrootopeartion.responseText);
			if(jsnrootopeartion!=null && jsnrootopeartion!="" && jsnrootopeartion!="[]"){
				fillRouteForm(jsnrootopeartion);
				showRouteGrid();
				hideRouteGrid();
				showAddRoute();
				$('#rtHeading').html("Edit Style Route");
				iseditepressed=true;
				$('#mststylerouteoperationForm').valid();
			}
		}
	}
	else{
		alert("finished Unseved form ");
	}
}

function makeHeader(){
	$('#rtopHeading').html("Add Operations");
	document.getElementById("printBundleTicket").checked = true;
	document.getElementById("manual").checked = true;
}

function  getoperationid(){
	
	var styleRouteId=document.getElementById("rop_id_styleRouteId").value;
	var my = AjaxCall("POST", "", "services/api/mststyleoperation/getnextop/"+styleRouteId+".json");
	if (my.readyState == 4 && my.status == 200) {
		jsnrootopeartion = JSON.parse(my.responseText);
		jsnrootopeartion=((jsnrootopeartion/10) + 1)*10;
		console.log(jsnrootopeartion);
		document.getElementById("sequenceNo").value=jsnrootopeartion;
	}
}

function chkoperationid(){
	var styleRouteId=document.getElementById("rop_id_styleRouteId").value;
	var sequenceNo =document.getElementById("sequenceNo").value;
	if(sequenceNo !="" && sequenceNo!=null && sequenceNo>0){
		var my = AjaxCall("POST", "", "services/api/mststyleoperation/chkoperation/"+styleRouteId+"/"+sequenceNo+".json");
		if (my.readyState == 4 && my.status == 200) {
			jsnrootopeartion = JSON.parse(my.responseText);
			
			console.log(jsnrootopeartion);
			if(!jsnrootopeartion){
				alert("Invalide Sequence No ")
				document.getElementById("sequenceNo").value="";
			}
			
		}
	}
}

function resetFrm(id){
	location.replace("mststylerouteoperations?"+id+"=true");
}

function resetform(){
	if(iseditepressed){
		iseditepressed=false;
		editRouteOperation(styleRouteId);
	}
	else{
		document.getElementById("mststylerouteoperationForm").reset();
		//$('#mststylerouteoperationForm').reset();
	}
	
}

function getroute(routeId,id){
	var jsnrootopeartion = AjaxCall("POST", "", "services/api/styleroute/routeSearchById/"+routeId + ".json");
	if (jsnrootopeartion.readyState == 4 && jsnrootopeartion.status == 200) {
		jsnrootopeartion = JSON.parse(jsnrootopeartion.responseText);
		document.getElementById(id+"rop_id_mainColor").innerHTML="<option value='"+jsnrootopeartion.mainColor+"'>"+jsnrootopeartion.mainColor+"</option>";
		document.getElementById(id+"rop_id_componentId").innerHTML="<option value='"+jsnrootopeartion.componentId+"'>"+jsnrootopeartion.componentId+"</option>";
		
		
	}
	else{
		
	}
}


//$(function() {
//
//    document.cookie ="var  i = 1";
//
//    if(i == 1 ){
//        $('#oparations-header .exportlinks').insertAfter('.dataTables_wrapper');
//        i++;
//    }
//
//});

$(function() {
    $('#operationsBody_avalable_operations .exportlinks').insertAfter('#operationsBody_avalable_operations .dataTables_wrapper');
});