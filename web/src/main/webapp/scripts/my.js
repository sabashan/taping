
/* Main color and child color  */
var dataChiledColor =new Array();
var MainvsChiledColor =new Array();
var main_childs=new Array();
/* Main color and child color  array increment*/
var icmColor=0;
var icColor=0;
var MinColor  =0;
var chcolor="";
var chcolorqt="";

/* image number in mststyleheader form image dropzone pic box */
var imagenumber=0;

/**
 reset Binding for any form
 @touse reset button contain reset class and if it contain  replace-data class it will relord the page 
*/
$(document).ready(function() {
	$(".reset").click(function() {
		clear_form_elements(this.form);
		if($(".reset").hasClass( "replace-data" )){
			 window.location.replace(location.pathname);
		}
		else{
		 console.log("No relord");
		}
	});

    /*window.setInterval(function(){
     tab_view();
     }, 500);*/


});

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
	else if(progrm == 'ordersheet'){
		if(id =="itemType"){
			nextid=['itemCode','itemCodemodel'];
			enbldisble(id,nextid,true);
			selecteditemtype=document.getElementById(id).value;
		}
	}

}


/**
 * form clear function 
 * clear all the sub input elements in given element
 * @param ele
 */
function clear_form_elements(ele) {
    $(ele).find(':input').each(function() {
        switch(this.type) {
            case 'password':
            case 'select-multiple':
            case 'select-one':
				this.selectedIndex=-1;
				break;
            case 'text':
				$(this).val('');
                break;
            case 'textarea':
                $(this).val('');
				break;
            case 'checkbox':
				this.checked = false;
				break;
            case 'radio':
                this.checked = false;
				break;
        }
    });
   // $(ele).reset();
}




/**
 * 
 * @param Maincolor
 * @param childecolor
 * @param pqty
 */

/**
 * 
 */
function arrange() {
    $("#fit1").hide();
    operationSelect[0] = "select-size1";
    $("#size2").hide();
    operationSelect[1] = "select-fit2";
    $("#size-fit-matrix").html("<h3>Please select dimention 01 and dimention 02</h3>");
}
/**
 * 
 * @param now_id
 * @param next_id
 * @param isclear need to clear values
 */
function enbldisble(now_id,next_id,isclear){
	console.log(now_id+" - "+next_id+" - "+isclear);
	//get value of this 
	var now_value=$( "#"+now_id).val();
	//check the value
	console.log(now_value);
	if (now_value!="" && now_value!=null) {
		//activate next input box
		for(var i=0;i<next_id.length;i++){
			$('#'+next_id[i]).prop('disabled', false);
		}
		// if need then clear it
		if(isclear){
			$("#"+next_id[0]).empty();
		}
	}
	else {
		for(var i=0;i<next_id.length;i++){
			$('#'+next_id[i]).prop('disabled', 'disabled');
		}
		$("#"+next_id[0]).empty();
	}
}
/**
 * 
 * @param id 
 * @description remove corresponding element 
 * 
 */
function toggle_visibility(id) {
	console.log(id);
    var e = document.getElementById(id);
    $("#" + id).html("");
    document.getElementById(id).innerHTML = "";
    $("#" + id).remove();
}
/**
 * 
 * @param value
 * @param operation
 */
function optioncreator(value, operation) {
	console.info(value);
	var oper = document.getElementById("selectbasic-h").getElementsByTagName("option");
	oper[0].disabled = false;
	var oper = document.getElementById("selectbasic-v").getElementsByTagName("option");
	oper[0].disabled = false;
//	$(".vertical_divs").show();
//    $(".horizontal_divs").show();
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
//		$(".vertical_divs").hide();
//        $(".horizontal_divs").hide();
	    try{
	    	op = document.getElementById("selectbasic-h").getElementsByTagName("option");
	        for (var i = 1; i < op.length; i++) {
	        	if(op[i].disabled == true){
	        		op[i].disabled = false;
	        	}
	        }
	        
	        op = document.getElementById("selectbasic-v").getElementsByTagName("option");
	        for (var i = 1; i < op.length; i++) {
	        	if(op[i].disabled == true){
	        		op[i].disabled = false;
	        	}
	        }
	        
	    	index = document.getElementById("selectbasic-h").selectedIndex;
	    	document.getElementById("selectbasic-v").options[index].disabled=true;
	    	index = document.getElementById("selectbasic-v").selectedIndex;
	    	document.getElementById("selectbasic-h").options[index].disabled=true;
	    }catch(e){}
	}
    bindMatrix("");
    //$("#size-fit-matrix").html("<h3>Please select dimention 01 and dimention 02</h3>");
}
var dimensionRemove = new Array();
var horizontalRemove = new Array();
var verticalRemove = new Array();
var matrixRemove = new Array();

var dimension = new Array();
var dataCol = new Array();
var dataImg = new Array();
var dataImgfulldata = new Array();
var imgfulindex=0;
var iCol = 0;
var operationSelect = new Array();
var dataComponent = new Array();
var iCom = 0;


/**
 * 
 */
function updateDisplay() {
    var isChecked = $checkbox.is(':checked');

    // Set the button's state
    $button.data('state', (isChecked) ? "on" : "off");

    // Set the button's icon
    $button.find('.state-icon')
        .removeClass()
        .addClass('state-icon ' + settings[$button.data('state')].icon);

    // Update the button's color
    if (isChecked) {
        $button
            .removeClass('btn-default')
            .addClass('btn-' + color + ' active');
    } else {
        $button
            .removeClass('btn-' + color + ' active')
            .addClass('btn-default');
    }
}
/**
 * 
 * @param method
 */
function bindMatrix(method) {
    options = document.getElementById(operationSelect[0]);
    if(options == null){
        //return;
    	options = "";
    }
    var e = document.getElementById("selectbasic-v");
    if(e.selectedIndex == 0){
    	dim1 = " ";
    }
    else{
    	dim1 = e.options[e.selectedIndex].value;
    }
    
    dimension[0]=dim1;
    valuesFit = [];
    var fit = 0;
    var size = 0;
    for (var i = 0; i < options.length; i++) {
        if (options[i].selected) {
            valuesFit.push(options[i].value);
            fit++;
        }
    }
    if(fit == 0){
//    	$("#size-fit-matrix").html("<h3>Please select dimention 01 and dimention 02</h3>");
//    	return;
    	valuesFit = ["*"];
    }
    
    options = document.getElementById(operationSelect[1]);
    if(options == null){
        //return;
    	options = "";
    }
    var e = document.getElementById("selectbasic-h");
    if(e.selectedIndex == 0){
    	dim2 = " ";
    }else{
    	dim2 = e.options[e.selectedIndex].value;
    }
    
    dimension[1]=dim2;
    valuesSize = [];
    for (var i = 0; i < options.length; i++) {
        if (options[i].selected) {
            valuesSize.push(options[i].value);
            size++;
        }
    }
    if(size == 0){
    	valuesSize = ["*"];
    }
    if(size == 0 && fit == 0){
    	$("#size-fit-matrix").html("<h3>Please select dimention 01 and dimention 02</h3>");
    	return;
    }
    
   /* 
    var all = document.getElementsByClassName('matcheck');
    for (var i = 0; i < all.length; i++) {
      var current = all[i];
      if (current.checked) {
        // Logic here
    	  console.info(current.id);
    	  tempMarked.push(current.id);
      }
    }*/
     
    if(method === "view"){
        method = "disabled='disabled'";
    }
    
    var matrix = "<table class='table table-bordered'><thead><tr><th class='textcenter'>Component</th>";
    rowspans = fit + 1;
    rows = fit;
    if (fit != 0) {
        matrix += "<th class='textcenter'>" + dim1 + "</th>";
    } else {
        rowspans = 2;
        rows = 1;
    }

    if (size == 0) {
        size = 1;
    }

    matrix += "<th colspan=" + size + " class='textcenter'>" + dim2 + "</th></tr></thead><tbody>";

    matrix += "<tr><td class ='textcenter' rowspan=" + (rowspans) + ">General</td>";

    if (fit != 0) {
        matrix += "<td>&nbsp;</td>";
    }

    for (i = 0; i < size; i++) {
    	var titleSize = valuesSize[i];
    	if(titleSize == "*"){
    		titleSize = "";
    	}
        matrix += "<td class='table-size-header textcenter'>" + titleSize + "</td>";
    }
    matrix += "</tr>";

    for (j = 0; j < rows; j++) {
        matrix += "<tr>";
        if (fit != 0) {
        	var titleFit = valuesFit[j];
        	if(titleFit == "*"){
        		titleFit = "";
        	}
            matrix += "<td class='textcenter'>" + titleFit + "</td>";
        }
        for (i = 0; i < size; i++) {
            matrix += "<td class='cernter-x'><span class='button-checkbox'>" +
            //GCOLOR==genarl
                "<input class='matcheck' value='GCOLOR:"+valuesFit[j]+':'+valuesSize[i]+"'" +method
                +"id='GCOLOR:"+valuesFit[j]+':'+valuesSize[i]+"' type='checkbox' onchange='checkMatrix(this);'/></span></td>";
            //matrix += "<td class='table-size-header'>"+j+" "+i+"</td>";
        }
        matrix += "</tr>";
    }

    for (k = 0; k < iCol; k++) {
        matrix += "<tr><td class='textcenter' rowspan=" + (rowspans) + ">" + dataCol[k] + "</td>";

        for (j = 0; j < rows; j++) {
            matrix += "<tr>";
            if (fit != 0) {
                matrix += "<td class='textcenter'>" + valuesFit[j] + "</td>";
            }
            for (i = 0; i < size; i++) {
                matrix += "<td class='cernter-x'><span class='button-checkbox'>" +
                "<input class='matcheck' "+method+" value='"+dataCol[k]+':'+valuesFit[j]+':'+valuesSize[i]
                +"' id='"+dataCol[k]+':'+valuesFit[j]+':'+valuesSize[i]+"' type='checkbox' onchange='checkMatrix(this);'/></span></td>";
                //matrix += "<td class='table-size-header'>"+j+" "+i+"</td>";
            }
            matrix += "</tr>";
        }
    }
    matrix += "</tbody></table>";
    document.getElementById('size-fit-matrix').innHTML = "";
    $("#size-fit-matrix").html(matrix);
    
    for(i=0; i<tempMarked.length; i++){
    	try{
    		document.getElementById(tempMarked[i]).checked = true;
    	}catch(e){//splice if dont want to marked removes**
    	}
    }
    

}

var tempMarked = new Array();

/**
 * 
 * @param selectCheck
 */
function checkMatrix(selectCheck){
	if(selectCheck.checked){
		tempMarked.push(selectCheck.id);
		var str = selectCheck.id.split(":");
		document.getElementById(operationSelect[0]+str[1]).className = "";
		document.getElementById(operationSelect[1]+str[2]).className = "";
	}
	else{
		for (var i = 0; i < tempMarked.length; i++) {
			if(tempMarked[i] == selectCheck.id){
				tempMarked.splice(i, 1);
				break;
			}
		}
		removeManage(selectCheck);
	}
	makeDimention();
}

function makeDimention(){
	if(tempMarked.length > 0){
		document.getElementById("selectbasic-h").disabled = true;
		document.getElementById("selectbasic-v").disabled = true;
	}
	else{
		document.getElementById("selectbasic-h").disabled = false;
		document.getElementById("selectbasic-v").disabled = false;
	}
}

function removeManage(selectCheck){
	var horiFound = false;
	var vertFound = false;
	var str = selectCheck.id.split(":");
	for (var i = 0; i < tempMarked.length; i++) {
		var temStr = tempMarked[i].split(":");
		if(temStr[1] == str[1]){
			horiFound = true;
		}
		if(temStr[2] == str[2]){
			vertFound = true;
		}
	}
	if(!horiFound){
		document.getElementById(operationSelect[0]+str[1]).className = "search-choice-close";
	}
	else{
		document.getElementById(operationSelect[0]+str[1]).className = "";
	}
	if(!vertFound){
		document.getElementById(operationSelect[1]+str[2]).className = "search-choice-close";
	}
	else{
		document.getElementById(operationSelect[1]+str[2]).className = "";
	}
}

/**
 * 
 */
function SMVDivContent(){
	/** Comment */
	document.getElementById('smv-matrix').innHTML = "";
    $("#smv-matrix").html("<div class='alert alert-warning fade in' role='alert'>" +
    		"<button type='button' class='close' data-dismiss='alert'><span aria-hidden='true'>×" +
    		"</span><span class='sr-only'>Close</span></button>" +
    		"<strong>Error!!</strong> No assigned size dimensions to display for this style.. </div>");
}

/**
 * 
 * @param method
 */
function SMVMatrix(method) {
	/*smvVertical = "FIT";
	smvHorizontal = "SIZE";
	smvVerDemValue = ["AA","LG","XL"];
	smvHorDemValue = ["12","16","18","20"];
	smvSelected = ["GCOLOR:AA:12","GCOLOR:AA:16","RED:LG:12","GCOLOR:XL:20","OFFWITE:XL:16","BLUE:XL:18"];
	*/
	try{
		if(smvVerDemValue.length == 0){
			SMVDivContent();
			console.info("1");
			return;
		}
		if(smvHorDemValue.length == 0){
			SMVDivContent();
			console.info("2");
			return;
		}
		if(smvSelected.length == 0){
			SMVDivContent();
			console.info("3");
			return;
		}
		if(smvMainColors.length == 0){
			SMVDivContent();
			console.info("4");
			return;
		}
	}catch (e) {
		SMVDivContent();
		console.info(e);
		return;
	}
	
	var mainSeleColor = document.getElementById('rop_id_mainColor').value;
	var k = 0;
	for (; k < smvMainColors.length; k++) {
		if(mainSeleColor == smvMainColors[k]){
			break;
		}
	}
	rowspan = smvVerDemValue.length + 1 ;
	var matrix = "<table class='table table-bordered'><thead><tr><th>Color</th>";
	matrix += "<th>" + smvVertical + "</th>";
	matrix += "<th colspan=" + smvHorDemValue.length + " style='text-align:center'>" + smvHorizontal + "</th></tr></thead><tbody>";
	matrix += "<tr><td rowspan=" + rowspan + "> "+smvMainColors[k]+"</td><td>&nbsp;</td>";
	for (i = 0; i < smvHorDemValue.length; i++) {
        matrix += "<td class='table-size-header'>";
        var titl = smvHorDemValue[i];
        if(smvHorDemValue[i] == '*'){
        	titl = "&nbsp;";
        }
        matrix += titl + "</td>";
    }
	matrix += "</tr>";
	
	var colId = smvMainColors[k];
	if(k == 0){
		colId = "GCOLOR";
	}
	for (j = 0; j < smvVerDemValue.length; j++) {
		matrix += "<tr><td>" + smvVerDemValue[j] + "</td>";
        for (i = 0; i < smvHorDemValue.length; i++) {
        	var index = smvSelected.indexOf(colId+":"+smvVerDemValue[j]+":"+smvHorDemValue[i]); 
        	if(index > -1){
        		matrix += "<td class='center-x'><input class='small-table-textbox smvmatrix' type='text' " +
        				"id='"+colId+":"+smvVerDemValue[j]+':'+smvHorDemValue[i]+"' onkeypress=\"return IsNumericdecimal(event,'"+i+""+j+"');\" " +
        				"onblur='setFourDec(this);' >" +
        				"<span id='error"+i+""+j+"' class='error-message displayNone'></span></td>";
        	}
        	else{
        		matrix += "<td class='center-x'><input type='checkbox' disabled='disabled'></td>";
        	}
        }
        matrix += "</tr>";
    }
	/*
	for (k = 1; k < smvMainColors.length; k++) {
        matrix += "<tr><td rowspan=" + rowspan + ">" + smvMainColors[k] + "</td>";
        for (j = 0; j < smvVerDemValue.length; j++) {
            matrix += "<tr><td>" + smvVerDemValue[j] + "</td>";
            for (i = 0; i < smvHorDemValue.length; i++) {
            	var index = smvSelected.indexOf(smvMainColors[k]+":"+smvVerDemValue[j]+":"+smvHorDemValue[i]); 
            	if(index > -1){
            		matrix += "<td class='center-x'><input class='small-table-textbox smvmatrix' type='text' " +
            				"id='"+smvMainColors[k]+':'+smvVerDemValue[j]+':'+smvHorDemValue[i]+"'></td>";
            	}
            	else{
            		matrix += "<td class='center-x'><input type='checkbox' disabled='disabled'></td>";
            	}
            }
            matrix += "</tr>";
        }
    }*/
	
	matrix += "</tbody></table>";
    document.getElementById('smv-matrix').innHTML = "";
    $("#smv-matrix").html(matrix);
    
}

function viewSMV(opeartionNo, styleRouteId){
	var elements = [] ;
    elements = document.getElementsByClassName("smvmatrix");
    for(var i=0; i<elements.length ; i++){
       elements[i].value = "" ;
    }

	var jsnrootDemMaps = AjaxCall("POST", "", "services/api/mststylerouteopdemmap/getAllOpDemMaps/"+opeartionNo+"/"+styleRouteId+"/"+".json");
	if (jsnrootDemMaps.readyState == 4 && jsnrootDemMaps.status == 200) {
		jsnrootDemMaps = JSON.parse(jsnrootDemMaps.responseText);
		for (var i = 0; i < jsnrootDemMaps.length; i++) {
			var id = jsnrootDemMaps[i].id;
			try{
				document.getElementById(id.mainColor+":"+id.verticalValue+":"+id.horizontalValue).value = jsnrootDemMaps[i].smvValue;
			}catch (e) {}
		}
	}
}

var WIPPoints = new Array();
var AssignWIPPoints = new Array();
var AssignWIPPointsRemove = new Array();
/**
 * 
 * @param sequenceNo
 * @param selectBox
 * @param operationId
 */
function WIPAssign(sequenceNo, selectBox, operationId, styleRouteId){
	
	var value = selectBox.options[selectBox.selectedIndex].value;
	var str = value.split(":");
	var wipSqu = parseInt(str[0]);
	var wipId = parseInt(str[1]);
	if(selectBox.selectedIndex == 0){
		for (var i = 0; i < AssignWIPPoints.length; i++) {
			console.info();
			if(AssignWIPPoints[i][0] == parseInt(sequenceNo)){
				AssignWIPPointsRemove.push(AssignWIPPoints[i]);
				options = document.getElementsByClassName("WIPOption"+AssignWIPPoints[i][1]);
				console.info(options);
				for (var j = 0; j < options.length; j++) {
					options[j].disabled = false;
				}
				AssignWIPPoints.splice(i,1);
			}
		}
		return;
	}
	if(wipSqu == NaN){
		selectBox.selectedIndex = 0;
		return;
	}
	var clsName = selectBox.options[selectBox.selectedIndex].className;
	//assignWipPoint [sequenceNo, WipPointSquence, WIP ID, OperationId, styleRouteId]
	var assignwip = [parseInt(sequenceNo), wipSqu, wipId, operationId, styleRouteId];
	
	var tempAssign = AssignWIPPoints;

	for (var i = 0; i < tempAssign.length; i++) {
		if(tempAssign[i][0] == sequenceNo){
			//enable deselect option
			var options = document.getElementsByClassName("WipOption"+tempAssign[i][1]);
			for (var j = 0; j < options.length; j++) {
				options[j].disabled = false;
			}
			tempAssign.splice(i,1);
		}
	}
	tempAssign.push(assignwip);
	//Check WIP point sequence order
	tempAssign.sort(function sortFunction(a, b) {
	    if (a[0] === b[0]) {
	        return 0;
	    }
	    else {
	        return (a[0] < b[0]) ? -1 : 1;
	    }
	});

	
	var selectBoxId = "WIPAssignId"+tempAssign[0][0];
	try{
		document.getElementById(selectBoxId).title = "";
		//console.info(document.getElementById(selectBoxId));
		document.getElementById(selectBoxId).setAttribute('data-original-title','');
		document.getElementById(selectBoxId).className = "select-control";
		$("#"+selectBoxId).tooltip('show');
	}
	catch (e) {
	}
	for (var i = 1; i < tempAssign.length; i++) {
		var selectBoxId = "WIPAssignId"+tempAssign[i][0];
		if(tempAssign[i-1][1] > tempAssign[i][1]){
			document.getElementById(selectBox.id).title = "Please select correct Wip points order!";
			document.getElementById(selectBox.id).className = "select-control select-error";
			$("#"+selectBox.id).tooltip('show');
		}
		else{
			try{
				document.getElementById(selectBoxId).title = "";
				//console.info(document.getElementById(selectBoxId));
				document.getElementById(selectBoxId).setAttribute('data-original-title','');
				document.getElementById(selectBoxId).className = "select-control";
				$("#"+selectBoxId).tooltip('show');
			}
			catch (e) {
			}
		}
	}
	AssignWIPPoints = tempAssign;
	
	//dissable all selected options
	options = document.getElementsByClassName("WIPOption"+wipSqu);
	for (var i = 0; i < options.length; i++) {
		options[i].disabled = true;
	}
	$('#error-win-wip-Points').hide();
}
/**
 * 
 * @returns {Boolean}
 */
function wipPointAjx(){
	//Check WIP point sequence order
	WIPPoints.sort(function sortFunction(a, b) {
	    if (a[0] === b[0]) {
	        return 0;
	    }
	    else {
	        return (a[0] < b[0]) ? -1 : 1;
	    }
	});
	for (var j = 0; j < WIPPoints.length; j++) {
		var foundMandetory = false;
		var mandetory = false;
		if(WIPPoints[j][3] == "true"){
			mandetory = true;
		}
		for (var i = 1; i < AssignWIPPoints.length; i++) {
			var selectBoxId = "WIPAssignId"+AssignWIPPoints[i][0];
			if(AssignWIPPoints[i-1][1] > AssignWIPPoints[i][1]){
				document.getElementById(selectBoxId).title = "Please select correct WIP points order!";
				document.getElementById(selectBoxId).className = "select-control select-error";
				$("#"+selectBoxId).tooltip('show');
				return false;
			}
			if(mandetory){
				if(parseInt(WIPPoints[j][2]) == AssignWIPPoints[AssignWIPPoints.length-1][1]){
					foundMandetory = true;
					break;
				}
				if(parseInt(WIPPoints[j][2]) == AssignWIPPoints[i-1][1]){
					foundMandetory = true;
					break;
				}
			}
		}
		if(mandetory){
			if(!foundMandetory){
				$('#error-win-wip-Points').show();
				return false;
			}
		}
	}
	
	var formdata = 'AssignWIPPoints=';//+AssignWIPPoints;
	for (var i = 0; i < AssignWIPPoints.length; i++) {
		formdata += AssignWIPPoints[i]+":";
	}
	formdata += '&AssignWIPPointsRemove=';
	for (var i = 0; i < AssignWIPPointsRemove.length; i++) {
		formdata += AssignWIPPointsRemove[i]+":";
	}
	console.info(formdata);
	$.ajax({
	         type: "POST",
	         url: "mststyleoperationform",
	         data: formdata,
	         success: function(data) {
	        	 $('#WIPSucAlert').show();
	         },
	         error:function(data){
	        	 $('#error-win-wip-Points').show();
	         }
	  });
}
/**
 * 
 */
function disableWipOptions(){
	for (var i = 0; i < AssignWIPPoints.length; i++) {
		try{
			options = document.getElementsByClassName("WIPOption"+AssignWIPPoints[i][1]);
			for (var j = 0; j < options.length; j++) {
				options[j].disabled = true;
			}
		}catch (e) {
			console.info(e);
		}
	}
}

/**
 * 
 * @param textFeild
 */
function setFourDec(textFeild){
	if(textFeild.value != ''){
		var value = parseFloat(textFeild.value).toFixed(4);
		document.getElementById(textFeild.id).value = value;
	}
}
/**
 * 
 */
function ApplyDefaultSMW(){
	var defaultSMW = document.getElementById('DefaultSMW').value;
	if(isNaN(defaultSMW)){
		alert("Please enter valid number!");
		document.getElementById('DefaultSMW').value = "";
	}
	else{
		defaultSMW = parseFloat(defaultSMW);
		defaultSMW = defaultSMW.toFixed(4);
		for (var i = 0; i < smvSelected.length; i++) {
			try{
				document.getElementById(smvSelected[i]).value = defaultSMW;
			}catch(e){}
		}
		document.getElementById('DefaultSMW').value = "";
	}
}


/**
 * 
 * @param array
 * @param Keyword
 */
function arrayindex(array,Keyword){
	return array.indexOf(Keyword);
	
}
/**
 * validator for number fileds 
 */
var specialKeys = new Array();
specialKeys.push(8); //Backspace

/**
 * 
 * @param e
 * @param varb
 * @returns {Boolean}
 */
function IsNumeric(e, varb) {
	
    var keyCode = e.which ? e.which : e.keyCode;
    console.log(keyCode)
    var ret = ((keyCode >= 48 && keyCode <= 57) || keyCode==8 ||  keyCode==9 ||  specialKeys.indexOf(keyCode) != -1);
    document.getElementById("error" + varb).style.display = ret ? "none" : "inline";
    return ret;
}
/**
 * 
 * @param e
 * @param varb
 * @returns {Boolean}
 */
function IsNumericdecimal(e, varb) {
    var keyCode = e.which ? e.which : e.keyCode;
    var ret = ((keyCode >= 48 && keyCode <= 57) || keyCode==8 || keyCode == 46 || keyCode==9 ||  specialKeys.indexOf(keyCode) != -1);
    document.getElementById("error" +varb).innerHTML = "* Input digits (0 - 9)";
    document.getElementById("error" +varb).style.display = ret ? "none" : "inline";
    return ret;
}
/**
 * 
 * @param e
 * @param varb
 * @returns {Boolean}
 */
function IsNumericSpecial(e, varb) {
    var keyCode = e.which ? e.which : e.keyCode;
    var ret = ((keyCode >= 48 && keyCode <= 57) ||(keyCode >= 97 && keyCode <= 112) ||   (keyCode >= 65 && keyCode <= 90) ||  keyCode==9 ||  keyCode==8 || keyCode == 46 || specialKeys.indexOf(keyCode) != -1);
    document.getElementById("error" +varb).innerHTML = "* Input digits (A-Z ,a-z ,0 - 9)";
    document.getElementById("error" +varb).style.display = ret ? "none" : "inline";
    return ret;
}
/**
 * 
 * @param e
 * @returns {Boolean}
 */
function CheckNumeric(e){
	var keyCode = e.which ? e.which : e.keyCode;
	var ret = ((keyCode >= 48 && keyCode <= 57) || (keyCode >= 65 && keyCode <= 90) || (keyCode >= 97 && keyCode <= 122)  ||  keyCode==9 ||  specialKeys.indexOf(keyCode) != -1);
	return ret;
}

/**
 * 
 * @param type
 * @param data
 * @param url
 * @returns {___anonymous_xmlhttp}
 */
function AjaxCall(type,data,url){
    xmlhttp=xmlhttpcration();
    
    if(type=="GET"){
        url=url+"?"+data;
        data="";
    }
    xmlhttp.open(type,url,false);
    xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    xmlhttp.send(data);
    return xmlhttp;
}

/**
 * 
 * @returns {___anonymous_xmlhttp}
 */
function  xmlhttpcration() {
    var xmlhttp;
    if (window.XMLHttpRequest) {
    	// code for IE7+, Firefox, Chrome, Opera, Safari
        xmlhttp=new XMLHttpRequest();
    }
    else{
    	// code for IE6, IE5
        xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    
return xmlhttp;
}

/**
 * 
 * @param dim
 */
function clearAllSelect(dim){
	console.info(dim);
	var elements = document.getElementById(dim).selectedOptions;
	console.info(elements);
    for(var i = 0; i < elements.length; i++){
      elements[i].selected = false;
    }
}

var checkedMat = new Array();
/**
 * 
 */
function copyAsThis(){
	checkedMat.length = 0
	$(".matcheck:checked").each(function() {
		checkedMat.push(this.value);
    });
	for (var j = 0; j < dataCol.length; j++) {
		for (var k = 0; k < valuesFit.length; k++) {
			for (var l = 0; l < valuesSize.length; l++) {
				document.getElementById(dataCol[j]+":"+valuesFit[k]+":"+valuesSize[l]).checked = false;
			}
		}
	}
	tempMarked = checkedMat;
	for (var i = 0; i < checkedMat.length; i++) {
		var res = checkedMat[i].split(":");
		if(res[0] == 'GCOLOR'){
			for (var j = 0; j < dataCol.length; j++) {
				document.getElementById(dataCol[j]+":"+res[1]+":"+res[2]).checked = true;
				tempMarked.push(dataCol[j]+":"+res[1]+":"+res[2]);
			}
		}
	}
	
}

var jsnroot;
var jsnrootop;
/**
 * 
 * @param obj
 * @param jsnobj
 * @returns {Array}
 */
function jsonrecetors(obj,jsnobj) {
	var arobj = new Array();
	$.each(jsnobj, function(index, value) {		
			arobj.push(value.itemType);
	});
	return ArrNoDupe(arobj);
}
/**
 * 
 * @param id
 *            of corosponding object
 */
function typaheadforroot(id,code) {
	
	var URL=StyleContents(id,code);

	jsnroot = AjaxCall("POST", "", "services/api/mststyleheader/StylesByparam"+URL +"/"+code +".json");

	if (jsnroot.readyState == 4 && jsnroot.status == 200) {
		jsnroot = JSON.parse(jsnroot.responseText);
	} else {
		console.log("some things wrong");
	}
	if(id!="id_styleId"){
		var div="<option></option>";
		jsnroot = jsonrecetor(id,jsnroot);
		if(id=="id_compCode"){
			div='<option selected="selected">'+jsnroot[0]+'</option>';
		}
		
		else{
			for(var i =0;i<jsnroot.length;i++){
				div=div+"<option>"+jsnroot[i]+"</option>";
			}
		}
		document.getElementById(id).innerHTML=div;
	}
	else if(id!=null){
		//var jsnobj =new Array();
		jsnroot = jsonrecetor(id,jsnroot);
		$("#" + id).typeahead('destroy');
		$("#" + id).typeahead({
			source : jsnroot,
			
		});
	}
}



function optionsforgencodes(id,code) {
	var type="";
	if(code == "UOM")
		type="UOM";
	else
		type=gencodemapper(id);
	var jsnrobj;
	jsnroot = AjaxCall("POST", "", "services/api/gencodes/getcode/"+type+".json");

	if (jsnroot.readyState == 4 && jsnroot.status == 200) {
		jsnrobj = JSON.parse(jsnroot.responseText);
	} else {
		console.log("some things wrong");
	}
	var div="<option></option>";
	for(var i =0;i<jsnrobj.length;i++){
		div=div+"<option>"+jsnrobj[i]+"</option>";
	}
	document.getElementById(id).innerHTML=div;
}

/**
 * 
 * @param obj
 *            DOCUMENT OBJECT
 * @returns {Array}
 */
var styletypheadarray=new Array();

function jsonrecetor(obj,jsnobj) {
	var arobj = new Array();
	if(obj=="pcs_id_styleId"){
		$.each(jsnobj, function(index, value) {		
			arobj.push("Style : "+value.id.styleId +",Buyer : "+ value.id.custCode+",Company : "+ value.id.compCode +",Department : "+ value.id.depCode +",Location : "+ value.id.locationCode);
		});
	}
	else{
		$.each(jsnobj, function(index, value) {		
				arobj.push(value);
		});
	}
	return ArrNoDupe(arobj);
}
/**
 * 
 * @param code
 * @returns code if null or empty string then return null
 */
function getvalue(code) {
	
	if (code != "" && code != null) { return code.trim(); } else { return null;}
}

/**
 * 
 * @param id
 *            of corosponding object
 */
function typaheadforrootOp(id,code) {
	
	var URL=tableofrootOp(id,code);
	
	if(!URL){
		alert("Style is missing");
		return false;
	}
	jsnrootop = AjaxCall("POST", "","services/api/styleroute/routeByparam"+ URL + "/"+code+".json");
	
	if (jsnrootop.readyState == 4 && jsnrootop.status == 200) {
		jsnroot= JSON.parse(jsnrootop.responseText);
		if(id!="rop_id_styleRouteId" && id!="wrop_id_styleRouteId"){
			jsnroot = jsonrecetor(id,jsnroot);
		}
	} else {
		console.log("some things wrong");
		return false;
	}
	if(id!="rop_id_styleId"){
		var div="<option></option>";
		if(id=="rop_id_compCode"){
			
				div='<option selected="selected">'+jsnroot[0]+'</option>';
			
		}else{
			if(id=="rop_id_mainColor"){
				//div=div+'<option >General</option>';
			}
			for(var i =0;i<jsnroot.length;i++){
				if(id=="rop_id_styleRouteId" || id=="wrop_id_styleRouteId"){
					div=div+"<option value='"+jsnroot[i][0]+"'>"+jsnroot[i][1]+"</option>";
				}
				else{
					div=div+"<option>"+jsnroot[i]+"</option>";
				}
			}
			
		}
		document.getElementById(id).innerHTML=div;
	}
	else if(id!=null){
		$("#" + id).typeahead('destroy');
		$("#" + id).typeahead({
			source : jsnroot
		});
	}
}
/**
 * 
 * @param a array with duplicates
 * @returns {Array} without duplicats
 */
function ArrNoDupe(a) {
	var temp = {};
	for (var i = 0; i < a.length; i++)
		temp[a[i]] = true;
	var r = [];
	for ( var k in temp)
		r.push(k);
	return r;
}


/**
 *  getById/{opeartionNo},{componentId},{mainColor},
							{styleRouteId},{styleCode},{locationCode},{custCode},
							{compCode},{depCode}
 */
function stylerotenavigation(id){
	
	document.getElementById("home").style.display="none";
	document.getElementById("profile").style.display="none";
	document.getElementById('Wip-Points').style.display="none";
	$("#homeTab").removeClass("active");
	$("#profileTab").removeClass("active");
	$("#Wip-PointsTab").removeClass("active");
	document.getElementById(id).style.display="block";
	document.getElementById(id+"Tab").className = "active";
	$(id).addClass("active");
}



/**
 * 
 * @param opeartionNo opeartion number in srtle route
 * @param componentId component it in style
 * @param mainColor main colors in style
 * @param styleRouteId style route code
 * @param styleCode style code
 * @param locationCode location code 
 * @param custCode customer code
 * @param compCode company code
 * @param depCode department code
 * 
 * @discription  popup style opeartion form with corasponding style route opeartion
 */
var rop_styleRouteId;
function getstyleroutoperation(opeartionNo, styleRouteId, status){
	//getById/{opeartionNo},{componentId},{mainColor,Long styleRouteId,String styleCode,String locationCode,String custCode,String compCode,String depCode
	if(status=="update"){
		var jsnrootopeartion = AjaxCall("POST", "", "services/api/mststyleoperation/getById/"+opeartionNo+"/"+styleRouteId+".json");
		if (jsnrootopeartion.readyState == 4 && jsnrootopeartion.status == 200) {
			jsnrootopeartion = JSON.parse(jsnrootopeartion.responseText);

					console.log(jsnrootopeartion.calc);
					document.getElementById("id_opeartionNo").value=jsnrootopeartion.id.opeartionNo;
					document.getElementById("operation").innerHTML="<option>"+jsnrootopeartion.operation+"</option>";
					//document.getElementById("operationDesc").value=jsnrootopeartion.operationDesc;
					//document.getElementById("operationDescBref").value=jsnrootopeartion.operationDescBref;
					document.getElementById("process").innerHTML="<option>"+jsnrootopeartion.process+"</option>";
					document.getElementById("grade").innerHTML="<option>"+jsnrootopeartion.grade+"</option>";
					document.getElementById("sequenceNo").value=jsnrootopeartion.sequenceNo;
					document.getElementById("operationType").innerHTML="<option>"+jsnrootopeartion.operationType+"</option>";
					document.getElementById("averageSmv").value=jsnrootopeartion.averageSmv;
					document.getElementById("machineTypeDefault").innerHTML="<option>"+jsnrootopeartion.machineTypeDefault+"</option>";
					//document.getElementById('wipPoints').value = route.wipPoints;
					/*document.getElementById("wipPoints").hidden="false";*/
					document.getElementById("printBundleTicket").checked=jsnrootopeartion.printBundleTicket;
					document.getElementById("workAid").innerHTML="<option>"+jsnrootopeartion.workAid+"</option>";
					document.getElementById("DefaultSMW").value=jsnrootopeartion.defaultSmv;
					//document.getElementById("sewingOperation").value=jsnrootopeartion.sewingOperation;
					document.getElementById("manual").checked=jsnrootopeartion.manual;
					document.getElementById("calc").checked=jsnrootopeartion.calc;
					
					
					//document.getElementById("id_depCode").value=jsnrootopeartion.id.depCode;
					//document.getElementById("id_componentId").value=jsnrootopeartion.id.componentId;
					//document.getElementById("id_mainColor").value=jsnrootopeartion.id.mainColor;
					
					//document.getElementById("id_styleId").value=jsnrootopeartion.id.styleId;
					//document.getElementById("id_locationCode").value=jsnrootopeartion.id.locationCode;
					//document.getElementById("id_custCode").value=jsnrootopeartion.id.custCode;
					//document.getElementById("id_compCode").value=jsnrootopeartion.id.compCode;
					
					//document.getElementById("operationDesc").value=jsnrootopeartion.operationDesc;
					//document.getElementById("operationDescBref").value=jsnrootopeartion.operationDescBref;
					//document.getElementById("sewingOperation").value=jsnrootopeartion.sewingOperation;
					//document.getElementById("wipPoints").value=jsnrootopeartion.wipPoints;
					//document.getElementById("wipPoints").hidden="false";
					/*rop_styleRouteId=jsnrootopeartion.id.styleRouteId;
					
					document.getElementById("operation").value=jsnrootopeartion.operation;
					document.getElementById("process").innHTML=jsnrootopeartion.process;
					document.getElementById("grade").value=jsnrootopeartion.grade;
					document.getElementById("sequenceNo").value=jsnrootopeartion.sequenceNo;
					document.getElementById("operationType").value=jsnrootopeartion.operationType;
					document.getElementById("averageSmv").value=jsnrootopeartion.averageSmv;
					document.getElementById("machineTypeDefault").value=jsnrootopeartion.machineTypeDefault;
					document.getElementById("printBundleTicket").checked=jsnrootopeartion.printBundleTicket;
					document.getElementById("workAid").value=jsnrootopeartion.workAid;
					document.getElementById("DefaultSMW").value=jsnrootopeartion.defaultSmv;
					
					document.getElementById("manual").checked=jsnrootopeartion.manual;
					document.getElementById("calc").checked=jsnrootopeartion.calc;*/
					
					
					var cBy = jsnrootopeartion.createdBy; var mBy = jsnrootopeartion.modifiedBy; var aBy = jsnrootopeartion.approvedBy;
					var cOn = jsnrootopeartion.createdOn; var mOn = jsnrootopeartion.modifiedOn; var aOn = jsnrootopeartion.approvedOn;
					if(cBy == null){ cBy = ''; }
					if(mBy == null){ mBy = ''; }
					if(aBy == null){ aBy = ''; }
					if(cOn == null){ cOn = ''; } else{ cOn = new Date(cOn); cOn = cOn.format(); }
					if(mOn == null){ mOn = ''; } else{ mOn = new Date(mOn); mOn = mOn.format(); }
					if(aOn == null){ aOn = ''; } else{ aOn = new Date(aOn); aOn = aOn.format(); }
					console.info(cBy);console.info(cOn);console.info(mBy);console.info(mOn);console.info(aBy);console.info(aOn);
					$('#createDivOp').html("Created By: "+cBy+"<br>Created On: "+cOn);
					$('#modifyDivOp').html("Modified By: "+mBy+"<br>Modified On: "+mOn);
					$('#approvDivOp').html("Approved By: "+aBy+"<br>Approved On: "+aOn);
					document.getElementById('createdOnOp').value = cOn;
					document.getElementById('createByOp').value = cBy;
					document.getElementById('createAtOp').value = jsnrootopeartion.createdAt;
					$('#rtopHeading').html("Edit Operations");
					showOpHideOpGrid();
				}
			else if(jsnrootopeartion.status == 500){
				alert("Server is not responds ");
			}
			else {
				console.log("some things wrong");
			}
		viewSMV(opeartionNo, styleRouteId);
	}
	else if (status=="delete"){
		
		
		getstyleroutoperation(opeartionNo, styleRouteId, "update");
		showOpGidHideOp();
		var formdata = jQuery("#mststyleoperationsForm").serialize();
		formdata += "&"+jQuery("#mststylerouteoperationsForm").serialize();
		formdata += '&id.styleRouteId='+styleRouteId+'&bCancel=false';
		//formdata += '&id.opeartionNo='+opeartionNo;
		formdata=formdata+"&delete=true";
		$.ajax({
           type: "POST",
           url: "mststyleoperationform",
           data: formdata,
           success: function(data) {
        	   $("#routoperationreset").trigger('click');
        	   location .reload();     
           }
		
	     });
		
	}
}

function copyopeartions(){
	
	schmodelBuyerDip=document.getElementById("schmodelBuyerDip").value;
	schmodelBuyer=document.getElementById("schmodelBuyer").value;
	schmodelStyle=document.getElementById("schmodelStyle").value;
	
	var url="services/api/mststyleoperation/routeopsch/"+styleRouteID+"/"+styleRouteName+"/"+schmodelBuyerDip+"/"+schmodelStyle+"/"+schmodelBuyer+".json";
	var my=AjaxCall("POST","",url);
  
	if (my.readyState==4 && my.status==200){
        json = JSON.parse(my.responseText);
    }
	var jsnrootopeartion=json;
	for(var i=0;i<json.length;i++){
		var jsnrootopeartion=json[i];
		if(jsnrootopeartion!=null && jsnrootopeartion!="" && jsnrootopeartion!="[]"){
			console.log(jsnrootopeartion.calc);
			
			var rop_styleRouteId=document.getElementById("rop_id_styleRouteId").value;
			document.getElementById("operation").innerHTML="<option>"+jsnrootopeartion.operation+"</option>";
			//document.getElementById("operationDesc").value=jsnrootopeartion.operationDesc;
			//document.getElementById("operationDescBref").value=jsnrootopeartion.operationDescBref;
			document.getElementById("process").innerHTML="<option>"+jsnrootopeartion.process+"</option>";
			document.getElementById("grade").innerHTML="<option>"+jsnrootopeartion.grade+"</option>";
			document.getElementById("sequenceNo").value=jsnrootopeartion.sequenceNo;
			document.getElementById("operationType").innerHTML="<option>"+jsnrootopeartion.operationType+"</option>";
			document.getElementById("averageSmv").value=jsnrootopeartion.averageSmv;
			document.getElementById("machineTypeDefault").innerHTML="<option>"+jsnrootopeartion.machineTypeDefault+"</option>";
			//document.getElementById('wipPoints').value = route.wipPoints;
			/*document.getElementById("wipPoints").hidden="false";*/
			document.getElementById("printBundleTicket").checked=jsnrootopeartion.printBundleTicket;
			document.getElementById("workAid").innerHTML="<option>"+jsnrootopeartion.workAid+"</option>";
			document.getElementById("DefaultSMW").value=jsnrootopeartion.defaultSmv;
			//document.getElementById("sewingOperation").value=jsnrootopeartion.sewingOperation;
			document.getElementById("manual").checked=jsnrootopeartion.manual;
			document.getElementById("calc").checked=jsnrootopeartion.calc;
			//showOpHideOpGrid();
			var formdata = jQuery("#mststyleoperationsForm").serialize();
			 formdata += "&"+jQuery("#mststylerouteoperationsForm").serialize();
			formdata += '&id.styleRouteId='+rop_styleRouteId+'&bCancel=false';
			 console.log(formdata);
			 
			 AjaxCall("POST", formdata, "mststyleoperationform")

		}
	}
	alert("Copied Sucsses ")
	location .reload();
}
/**
 * @author Raminda
 * @discription  save operations by geting form details
 */
function saveopeartion() {
	var formdata = jQuery("#mststyleoperationsForm").serialize();
	formdata += "&"+jQuery("#mststylerouteoperationsForm").serialize();
	formdata += '&id.styleRouteId='+rop_styleRouteId+'&bCancel=false';
	formdata += '&bCancel=false';
	 console.log(formdata);
	$.ajax({
         type: "POST",
         url: "mststyleoperationform",
         data: formdata,
         success: function(data) {
        	$("#routoperationreset").trigger('click');
        	 location .reload();
    
         }
	  });

}

function showOpHideOpGrid(){
	hideOpGrid();
	showAddOp();
	
}

function showOpGidHideOp(){
	showOpGrid();
	HideAddOp();
}

function showOpGrid(){
	$('#operationsBody').collapse('show');
	document.getElementById('operationsBody').className = "panel-collapse collapse in";
	
}
function showAddOp(){
	$('#addoperation').collapse('show');
	document.getElementById('addoperation').className = "panel-collapse collapse in";
}
function HideAddOp(){
	$('#addoperation').collapse('show');
	document.getElementById('addoperation').className = "panel-collapse collapse";
}
function hideOpGrid(){
	$('#operationsBody').collapse('hide');
	document.getElementById('operationsBody').className = "panel-collapse collapse";
}
var styleRouteName;
var styleRouteID;



/**
 * 
 * @param id
 * @param code
 */
function typaheadforStyle(id,code) {
	
	var URL=StyleContents(id,code);
	jsnroot=AjaxCall("POST","","services/api/mststyleheader/MststyleheaderByparam"+URL+"/NOT/NOT.json");
	if (jsnroot.readyState == 4 && jsnroot.status == 200) {
		jsnroot = JSON.parse(jsnroot.responseText);
	} else {
		console.log("some things wrong");
	}
	if(id!=null){
		jsnroot = jsonrecetor(id,jsnroot);
		$("#" + id).typeahead('destroy');
		$("#" + id).typeahead({
			source : jsnroot,
			updater: function(item){
			      console.log(item);
			      var str = item.split(",");
			      var str2 = str[0].split(":");
			      pcs_triger(str);
			      return str2[1].trim();
			  }
		});
	}
}
/**
 * 
 * @param id
 *            of corosponding object
 */
function StyleContents(id,code) {
	
	var URL = "";
	var param = new Array();
	var locationCode;var custCode;var styleId;var depCode ;var compCode ;
	if(id=="schmodelBuyer" || id=="schmodelStyle" || id=="schmodelBuyerDip"){
		//locationCode = document.getElementById("id_locationCode").value;
		custCode = document.getElementById("schmodelBuyer").value;
		styleId = document.getElementById("schmodelStyle").value;
		depCode = document.getElementById("schmodelBuyerDip").value;
	}
	else if(id == 'pcs_id_styleId' ){
		locationCode = document.getElementById("pcs_id_locationCode").value;
		custCode = document.getElementById("pcs_id_custCode").value;
		styleId = document.getElementById("pcs_id_styleId").value;
		depCode = document.getElementById("pcs_id_depCode").value;
		compCode = document.getElementById("pcs_id_compCode").value;
	}
	else if(id == 'cs_id_styleId'){
		locationCode = document.getElementById("cs_id_locationCode").value;
		custCode = document.getElementById("cs_id_custCode").value;
		styleId = document.getElementById("cs_id_styleId").value;
		depCode = document.getElementById("cs_id_depCode").value;
		compCode = document.getElementById("cs_id_compCode").value;
	}
	else if(id == 'rop_id_styleId'){
		locationCode = document.getElementById("rop_id_locationCode").value;
		custCode = document.getElementById("rop_id_custCode").value;
		styleId = document.getElementById("rop_id_styleId").value;
		depCode = document.getElementById("rop_id_depCode").value;
		compCode = document.getElementById("rop_id_compCode").value;
	}
	else if(id == 'wrop_id_styleId'){
		locationCode = document.getElementById("wrop_id_locationCode").value;
		custCode = document.getElementById("wrop_id_custCode").value;
		styleId = document.getElementById("wrop_id_styleId").value;
		depCode = document.getElementById("wrop_id_depCode").value;
		compCode = document.getElementById("wrop_id_compCode").value;
	}
	else{
		locationCode = document.getElementById("id_locationCode").value;
		custCode = document.getElementById("id_custCode").value;
		styleId = document.getElementById("id_styleId").value;
		depCode = document.getElementById("id_depCode").value;
		compCode = document.getElementById("id_compCode").value;
	}
	
	locationCode = getvalue(locationCode);
	custCode = getvalue(custCode);
	depCode = getvalue(depCode);
	styleId = getvalue(styleId);
	compCode=getvalue(compCode);
	
	if (locationCode && !(id=="id_locationCode" || id =="pcs_id_locationCode")) {
		param.push("/"+locationCode);
	} else {
		param.push("/NOT");
	}
	if (custCode && !(id=="id_custCode" || id =="pcs_id_custCode")) {
		param.push("/"+custCode);
	} else {
		param.push("/NOT");
	}
	if (depCode && id!="id_depCode") {
		param.push("/"+depCode);
	} else {
		param.push("/NOT");
	}
	if (styleId && !(id=="id_styleId" || id == 'cs_id_styleId' || id =="pcs_id_styleId" || id=="wrop_id_styleId" || id=="rop_id_styleId")) {
		param.push("/"+styleId);
	} else {
		param.push( "/NOT");
	}
	
	
	if(  compCode && !(id=="pcs_id_compCode" || id =='cs_id_compCode' || id =='rop_id_compCode' || id== 'id_compCode' || id =='wrop_id_compCode' )){
		param.push("/"+compCode);
	}
	else{
		param.push( "/NOT");
	}

	for (var i = 0; i < param.length; i++) {
		URL = URL + param[i];
	}
	
	return URL;	
}

function tableofrootOp(id,code) {
	var locationCode ;
	var custCode ;
	var styleId ;
	var depCode;
	var componentId ;
	var mainColor ;
	var styleDescription;
	var styleRouteId ;
	
	if(id.indexOf("wrop_id")>-1){
		wip="w";
	}
	else{
		wip="";
	}
	
	locationCode = document.getElementById(wip+"rop_id_locationCode").value;
	compCode = document.getElementById(wip+"rop_id_compCode").value;
	custCode = document.getElementById(wip+"rop_id_custCode").value;
	styleId = document.getElementById(wip+"rop_id_styleId").value;
	depCode = document.getElementById(wip+"rop_id_depCode").value;
	componentId = document.getElementById(wip+"rop_id_componentId").value;
	mainColor = document.getElementById(wip+"rop_id_mainColor").value;
	styleDescription = document.getElementById(wip+"rop_styleDescription").value;
	styleRouteId = document.getElementById(wip+"rop_id_styleRouteId").value;
	
	
	locationCode = getvalue(locationCode);
	custCode = getvalue(custCode);
	depCode = getvalue(depCode);
	styleId = getvalue(styleId);
	componentId = getvalue(componentId);
	mainColor = getvalue(mainColor);
	styleRouteId = getvalue(styleRouteId);
	styleDescription = getvalue(styleDescription);
	compCode=getvalue(compCode);
	
	var param = new Array();
	var URL = "";
	var wip="";
	
	if((id!=wip+"rop_id_styleId") && (styleId==null || styleId=="" || locationCode ==null || custCode ==null || depCode==null ||  compCode==null || locationCode =="" || custCode =="" || depCode==""  || compCode=="")){
		
		return false;
	}
	
	if (depCode && id!=wip+"rop_id_depCode") {
		param.push( "/" + depCode);
	} else {
		param.push( "/NOT");
	}
	if (styleId && id!=wip+"rop_id_styleId") {
		param.push("/" + styleId);
	} else {
		param.push( "/NOT");
	}
	if (custCode && id!=wip+"rop_id_custCode") {
		param.push( "/" + custCode);
	} else {
		param.push( "/NOT");
	}
	if (locationCode && id!=wip+"rop_id_locationCode") {
		param.push( "/" + locationCode);
	} else {
		param.push( "/NOT");
	}
	if (styleRouteId && id!=wip+"rop_id_styleRouteId") {
		param.push( "/" + styleRouteId);
	} else {
		param.push( "/NOT");
	}
	if (mainColor && id!=wip+"rop_id_mainColor") {
		param.push( "/" + mainColor);
	} else {
		param.push("/NOT");
	}
	if (componentId && id!=wip+"rop_id_componentId") {
		param.push("/" + componentId);
	} else {
		param.push( "/NOT");
	}
		param.push( "/NOT");

	
	for (var i = 0; i < param.length; i++) {
		URL = URL + param[i];
	}
	
	return URL
	
}
function setSelectedValue(selectObj, valueToSet) {
    for (var i = 0; i < selectObj.options.length; i++) {
        if (selectObj.options[i].text== valueToSet) {
            selectObj.options[i].selected = true;
            return;
        }
    }
}

function getOptions(id,tbl){
	/****/
	oldvalue=document.getElementById(id).value;
	if(id=="operation"){
		var type=document.getElementById("operationType").value;
		if (type == null || type=="" ){
			//urI="services/api/mstoperation.json";
			alert("Please select Operation Type");
			return false;
		}
		else{
			jsnroot = AjaxCall("POST", "", "services/api/"+ tbl+"/getcode/"+type+".json");
		}
	}
	else if(id =="id_mainColor" || id =="id_componentId" ){	
		jsnroot = AjaxCall("POST", "", "services/api/"+ tbl+"/getbyId"+StyleContents("","")+".json");
	}
	else if(id =="itemType"){
		jsnroot = AjaxCall("POST", "", "services/api/"+ tbl+"/getcode/"+selecteditemcategory+".json");
	}
	else if(id =="itemCode"){
		if(selecteditemtype != null && selecteditemtype!="" ){
			jsnroot = AjaxCall("POST", "", "services/api/"+ tbl+"/getcode/"+selecteditemtype+".json");
		}
		else{
			alert("Select An Item Type first");
			return true;
		}
	}
	else if(id =="supplierCode"){
		jsnroot = AjaxCall("POST", "", "services/api/"+ tbl+"/getcode/"+mstlocation+".json");
	}
	else if(id=='itemDescription'){
		itemCode=document.getElementById("itemCode").value;
		itemType=document.getElementById("itemType").value;
		
		if(itemCode=="" || itemType=="" && itemCode==null || itemType==null  ){
			custCode="NOT";locationCode="NOT";depCode="NOT";styleId="NOT";compCode="NOT";costsheetType="NOT";pcs_season="NOT";
		}
		jsnroot = AjaxCall("POST", "", "services/api/"+ tbl+'/getById/'+itemType+'/'+itemCode+'.json');
	
	}
	else if(id == "preCostSheetNo"){
		custCode=document.getElementById("pcs_id_custCode").value;
		locationCode=document.getElementById("pcs_id_locationCode").value;
		depCode=document.getElementById("pcs_id_depCode").value;
		styleId=document.getElementById("pcs_id_styleId").value;
		compCode=document.getElementById("pcs_id_compCode").value;
		pcs_season=document.getElementById("pcs_season").value;
		costsheetType=document.getElementById("costsheetType").value;
		if(custCode=="" || locationCode=="" || depCode=="" || styleId=="" || compCode=="" || costsheetType=="" || pcs_season=="" ){
			custCode="NOT";locationCode="NOT";depCode="NOT";styleId="NOT";compCode="NOT";costsheetType="NOT";pcs_season="NOT";
		}
		jsnroot = AjaxCall("POST", "", "services/api/"+ tbl+"/getAllids/"+compCode+"/"+locationCode+"/"+custCode+"/"+depCode+"/"+styleId+"/"+pcs_season+"/"+costsheetType+".json");
	}
	else if(id == "versionNo"){
		costsheetType=document.getElementById("costsheetType").value;
		preCostSheetNo=document.getElementById("preCostSheetNo").value;
		if(costsheetType=="" || preCostSheetNo==""){
			costsheetType="NOT"; preCostSheetNo="NOT";
		}
		jsnroot = AjaxCall("POST", "", "services/api/"+ tbl+"/getAllVersion/"+costsheetType+"/"+preCostSheetNo+".json");
	}
	else if(id == "userId" || id == "merchandiser"){
		jsnroot = AjaxCall("POST", "", "services/api/"+ tbl+"/getuserId.json");
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
	
		jsnroot = AjaxCall("POST", "", "services/api/"+ tbl+"/GetByid/"+custCode+"/"+locationCode+"/"+depCode+"/"+styleId+"/"+compCode+"/"+season+".json");
		
		console.log(custCode+" - "+locationCode+" - "+depCode+" - "+styleId+" - "+compCode+" - "+season);
	}
	
		
	else if(id.indexOf("fmvCategory")>-1){//id == "fmvCategory"
		if(id.indexOf("pfmvCategory")>-1){
			pcs_id_custCode=document.getElementById("pcs_id_custCode").value;
		}
		else{
			pcs_id_custCode=document.getElementById("cs_id_custCode").value;
		}
		createdOn=document.getElementById("createdOn").value;
		Volume=document.getElementById("orderQty").value;
		console.log(pcs_id_custCode+" = "+ createdOn+ " = "+ Volume);
		if(pcs_id_custCode=="" ){
			alert("Invalid Style");
			return false;
		}
		else if(createdOn==""){
			alert("System  error Refresh the page");
			return false;
		}
		else if( Volume==""){
			alert("Please Add Order Qty");
			return false;
		}
		jsnroot = AjaxCall("POST", "", "services/api/"+ tbl+"/getAll/"+pcs_id_custCode+"/"+createdOn+".json");
	}
	
	else{
		jsnroot = AjaxCall("POST", "", "services/api/"+ tbl+"/getcode.json");
	}
	

	if (jsnroot.readyState == 4 && jsnroot.status == 200) {
		jsnroot = JSON.parse(jsnroot.responseText);
	} else {
		console.log("some things wrong");
		return false
	}
	
	var div="";
	if(oldvalue!=null && oldvalue!=""){
		div=div+"<option></option>";
		div=div+"<option selected value='"+oldvalue+"'>"+oldvalue+"</option>";
	}
	else{
		div=div+"<option></option>";
	}
	
	
	
	
	if(id=='itemDescription'){
		document.getElementById(id).value=jsnroot.itemDesc;
	}else{
		
		if(id=="id_mainColor"){
			div=div+"<option value='General'>General</option>";
		}
		if (id.indexOf("fmvCategory")>-1){
			for(var i =0;i<jsnroot.length;i++){
				div=div+"<option value='"+jsnroot[i][0]+"'>"+jsnroot[i][0]+"</option>";//+jsnroot[i][0]+" - "
			}
		}
		else{
			jsnroot = jsonrecetor(id,jsnroot);
			for(var i =0;i<jsnroot.length;i++){
				if(oldvalue!=jsnroot[i])
				div=div+"<option value='"+jsnroot[i]+"'>"+jsnroot[i]+"</option>";
			}
		}
	}
	document.getElementById(id).innerHTML=div;

}

function addNewOperation(locationCode,compCode,custCode,depCode,styleId,componentId,mainColor,styleRouteId){
	console.info(locationCode+" "+compCode+" "+custCode+" "+depCode+" "+styleId+" "+componentId+" "+mainColor+" "+styleRouteId);
	$('#rop_id_locationCode').trigger('onfocus');
	$('#rop_id_locationCode').val(locationCode);
	$('#rop_id_custCode').trigger('onfocus');
	$('#rop_id_custCode').val(custCode);
	$('#rop_id_depCode').trigger('onfocus');
	$('#rop_id_depCode').val(depCode);
	$('#rop_id_compCode').trigger('onfocus');
	$('#rop_id_compCode').val(compCode);
	$('#rop_id_styleId').trigger('onfocus');
	$('#rop_id_styleId').val(styleId);
	$('#rop_id_componentId').trigger('onfocus');
	$('#rop_id_componentId').val(componentId);
	$('#rop_id_mainColor').trigger('onfocus');
	$('#rop_id_mainColor').val(mainColor);
	$('#rop_id_styleRouteId').trigger('onfocus');
	$('#rop_id_styleRouteId').val(styleRouteId);
	
	
	//$('#rop_id_search').trigger('click');
	//stylerotenavigation('profile');
}
function removeSpaces(string) {
	 return string.split(' ').join('');
}
function gencodemapper(id){
	var type="";
	if(id.indexOf("child-color-name")>-1 ){
		type="STYCLR";
	}
	else{
		switch (id) {
		case 'UMO' :
			type="UMO";
		break;
		case "grade":
			type="GRADE";
			break;
		case "itemColor":
			type="ITMCLR";
			break;
		case "process":
			type="PROPRO";
			break;
		case "operationtype":
			type="OPTTYP";
			break;
		case "operationType":
			type="OPTTYP";
			break;
		case "workAid":
			type="ATTMNT";
			break;
		case "id_depCode":
			type ="BUYDEM";
			break;
		case "sid_depCode":
			type ="BUYDEM";
			break;
		case "pcs_id_depCode":
			type ="BUYDEM";
			break;
		case "cs_id_depCode":
			type ="BUYDEM";
			break;
		case "rop_id_depCode":
			type ="BUYDEM";
			break;
		case "id_mainColor":
			type ="STYCLR";
			break;
		case "rop_id_mainColor":
			type ="STYCLR";
			break;
		case "packingMethod":
			type="PAKMTD";
			break;
		case "productRange":
			type="PRORNG";
			break;
		case "baseBody":
			type="BASBOD";
			break;
		case "inputmaincolor":
			type="STYCLR";
			break;
		case "prdV":
			type="PROTYP";
			break;
		case "pcs_season":
			type="SEASON";
			break;
		case "cs_season":
			type="SEASON";
			break;
		case "season":
			type="SEASON";
			break;
		case "costsheetType":
			type="COSTYP";
			break;
		case "costSheetType":
			type="COSTYP";
			break;
		case "destination_country":
			type="CONTRY";
			break;
		case "shipment_mode":
			type="SHPMOD";
			break;
		case "delivery_team":
			type="DELTER";
			break;
		case "orderType":
			type="ORDTYP";
			break;
		default:
			type="NOT";
			break;
		}
	}
	return type;
}






function getstylecheaker(){
	
	locationCode = document.getElementById("sid_locationCode").value;
	custCode = document.getElementById("sid_custCode").value;
	styleId = document.getElementById("sid_styleId").value;
	depCode = document.getElementById("sid_depCode").value;
	compCode = document.getElementById("sid_compCode").value;

	locationCode = getvalue(locationCode);
	custCode = getvalue(custCode);
	depCode = getvalue(depCode);
	styleId = getvalue(styleId);
	compCode=getvalue(compCode);
	var jsnroot;
	if(!locationCode && !custCode && !depCode && !styleId  && !compCode){
		document.getElementById("sid_styleId").value="";
		alert("Plece Select other Primery Values first")
	}
	else{
		jsnroot = AjaxCall("POST", "", "services/api/mststyleheader/StylesAllparam/"+locationCode+"/"+compCode+"/"+custCode+"/"+depCode+"/"+styleId+".json");
		if (jsnroot.readyState == 4 && jsnroot.status == 200) {
			jsnroot = JSON.parse(jsnroot.responseText);
			if(styleId==jsnroot.id.styleId){
				alert("Duplicte Style id ");
				document.getElementById("sid_styleId").value="";
			}
		} else {
			//alert("some things wrong");
		}
	
	}	
}
	
	function deleteRoute(url,url2){
		jsnroot = AjaxCall("POST", url+url2, "mststylerouteview");
		for(var i=0;i<7;i++){
			url=url.replace("id.", "");
		}
		if (jsnroot.readyState == 4 && jsnroot.status == 200) {
			window.location.replace("mststylerouteoperations?"+url);
		}
	}	
	
	function selectcompany(id){
		$('#'+id).val($('#'+id +' option').last().html())
	}
	
	function getCookie(cname) {
	    var name = cname + "=";
	    var ca = document.cookie.split(';');
	    for(var i=0; i<ca.length; i++) {
	        var c = ca[i];
	        while (c.charAt(0)==' ') c = c.substring(1);
	        if (c.indexOf(name) != -1) return c.substring(name.length,c.length);
	    }
	    return "";
	}
	function setCookie(cname, cvalue, exdays) {
	    var d = new Date();
	    d.setTime(d.getTime() + (exdays*24*60*60*1000));
	    var expires = "expires="+d.toUTCString();
	    document.cookie = cname + "=" + cvalue + "; " + expires;
	}
	
	function pagenavigation(id){
		if($("#n"+id).hasClass("active")){
			precostsheetnavigation(id);
		}
		else{
			console.log("foo");
		}
	}
	function converttoflot(json){
		if(json!=null && json!=""){
			try{
				json=parseFloat(json);
			}
			catch (e) {
				json=0;
			}
		}
		else{
			json=0;
		}
		return json;
	}

function tab_view(){

    var nav =  $('#myTab');
    var nav_li = nav.children('li');

    var nav_li_length = nav_li.length;
    console.log(nav_li_length);

    $('#myTab li').each(function(i) {
        $(this).addClass("item" + (i+1));
    });

    var ulactive = $('#myTab').find('.active');
    ulactive.addClass('activated');

    var tabcontent = $('.tab-content');
    $(tabcontent).children('div:visible').addClass('activated');

    $(tabcontent).children('div').removeClass('currently_active')
    $(tabcontent).children('div:visible').addClass('currently_active');

}

function getSelectedOptions(sel) {
    var opts=new Array() ;
    var opt="";
    len=sel.options.length;
    console.log("Select length : "+len);
    for (var i=0; i<len; i++) {
        opt = sel.options[i];
        // check if selected
        if ( opt.selected ) {
            // add to array of option elements to return from this function
            opts.push(opt.value); 
        }
        console.log("options value : "+opt.value +" is select " +opt.selected);
    }
    var options="";
    for(var k=0;k<opts.length;k++){
    	options+=opts[k];
    	if(k<opts.length-1)
    		options+=";";
    }
    //opts=""+options+"";
    console.log("options  : "+options);
    // return array containing references to selected option elements
    return options;
}
