/**
 * 
 */
$(document).ready(function() {
    $("#WipMasterError").hide();
    showWipGrid();
    hideAddWip();

    $.fn.bootstrapSwitch.defaults.onText = 'Yes';
    $.fn.bootstrapSwitch.defaults.offText = 'No';

    $("#mandetory").bootstrapSwitch();
    
    $.fn.bootstrapSwitch.defaults.onText = 'Yes';
    $.fn.bootstrapSwitch.defaults.offText = 'No';
    
    $("#activeWip").bootstrapSwitch();

	$("#activeWip").bootstrapSwitch('state', true);
    generateSecondPage();
    
    $('#mststylewippointsForm').validate({ // initialize the plugin
        rules: {
        	sequnceNo:{
    			required: true,
    			number: true
    		},
    		wippoint:{
    			required: true,
    			lettersonly: true
    		},
    		description:{
    			lettersonly: true
    		}
        },
        errorPlacement: function(error,element){
			parentDiv = element.parents('.addon-md');
    		errorDiv = parentDiv.children(".feedback");
    		error.appendTo(errorDiv);
    		$('#WipMasterError').show();
    		console.info("Window");
    	}
    });
    
    $WIPselect = $('#newItemType').selectize({
		create: false,
		sortField: {
			field: 'text',
			direction: 'asc'
		},
		dropdownParent: 'body'
	});

	/*$('.slideupdowntoggle.glyphicon').click(function () {
        var el = $(this).parents(".panel-title").children(".glyphicon");
        if ($(this).hasClass("glyphicon-chevron-up")) {
            $(this).removeClass("glyphicon-chevron-up").addClass("glyphicon-chevron-down");
            el.slideUp(200);
        } else {
            $(this).removeClass("glyphicon-chevron-down").addClass("glyphicon-chevron-up");
            el.slideDown(200); }
    });*/

	$('.panel-heading').click(function () {
    	var el = $(this).children().find( "span" ).hasClass("glyphicon-chevron-up");
       if(el){
       	$(this).children().find( "span" ).removeClass("glyphicon-chevron-up").addClass("glyphicon-chevron-down");
       }else{
       	$(this).children().find( "span" ).removeClass("glyphicon-chevron-down").addClass("glyphicon-chevron-up");
       }
    });

    
});

/**
 * 
 */
function showWipGrid(){
	//$('#wipPointBody').collapse('show');
	//document.getElementById('wipPointBody').className = "panel-collapse collapse in";
	$('#wipPointBody').collapse('show');
}
/**
 * 
 */
function showAddWip(){
	//$('#addWipPoint').collapse('show');
	//document.getElementById('addWipPoint').className = "panel-collapse collapse in";
	$('#addstyleroute').collapse('show');
}
/**
 * 
 */
function hideWipGrid(){
	//$('#wipPointBody').collapse('hide');
	//document.getElementById('wipPointBody').className = "panel-collapse collapse";
	 $('#wipPointBody').collapse('hide');
}
/**
 * 
 */
function hideAddWip(){
	//$('#addWipPoint').collapse('hide');
	//document.getElementById('addWipPoint').className = "panel-collapse collapse";
	$('#addstyleroute').collapse('hide');
}

/**
 * 
 * @returns
 */
function saveWipMaster(){
	if(document.getElementById("wippointCode").value == ''){
		//return $('#mststylewippointsForm').valid();
		for (var i = 0; i < wipPointArr.length; i++) {
			if(document.getElementById("sequnceNo").value == wipPointArr[i][1]){
				alert("'"+wipPointArr[i][1]+"' Sequence Number is already exist.");
				success = false;
				return false;
				break;
			}
			if(document.getElementById("wippoint").value == wipPointArr[i][3]){
				alert("'"+wipPointArr[i][3]+"' Wip point is already exist.");
				success = false;
				return false;
				break;
			}
		}
	}
	
	jQuery.validator.addMethod("lettersonly", function(value, element) {
		  return this.optional(element) || /^[a-z," "]+$/i.test(value);
		}, "This field allow only characters"); 
	var success = $('#mststylewippointsForm').valid();

	var wippoint2Code = document.getElementById("wippointCode").value;
	if(!(document.getElementById("activeWip").checked)){
		for (var j = 0; j < itemTypeArr.length; j++) {
			if(itemTypeArr[j].id.wippointCode == wippoint2Code){
				success = false;
				alert("This Wip point has allocated to items. Please remove all allocated items and please try again to deactivate this.");
				break;
			}
		}
	}
	if(success){
		$('#WipMasterError').hide();
		//document.getElementById("WipMasterError").removeAttribute("style");
	}
	return success;
}

/**
 * 
 * @param wippointCode
 */
function editWipPoint(wippointCode){
	var jsnrootWipPoint = AjaxCall("POST", "", "services/api/mststylewippoints/getWipPointById/"+wippointCode+".json");
	if (jsnrootWipPoint.status == 200) {
		jsnrootWipPoint = JSON.parse(jsnrootWipPoint.responseText);
		console.info(jsnrootWipPoint.mandetory);
		console.info(jsnrootWipPoint.activeWip);
		$('#mandetory').bootstrapSwitch('readonly', false);
		document.getElementById("wippointCode").value = jsnrootWipPoint.wippointCode;
		document.getElementById("sequnceNo").value = jsnrootWipPoint.sequnceNo;
		document.getElementById("wippoint").value = jsnrootWipPoint.wippoint;
		document.getElementById("description").value = jsnrootWipPoint.description;
		if(jsnrootWipPoint.mandetory){
			$("#mandetory").bootstrapSwitch('state', true);
		}else{
			$("#mandetory").bootstrapSwitch('state', false);
		}
		if(jsnrootWipPoint.activeWip){
			$("#activeWip").bootstrapSwitch('state', true);
		}else{
			$("#activeWip").bootstrapSwitch('state', false);
		}
//		$("#mandetory").bootstrapSwitch('setActive', false);
		document.getElementById("sequnceNo").readOnly = true;
		document.getElementById("wippoint").readOnly = true;
		$('#mandetory').bootstrapSwitch('readonly', true);
		//****disable clear all
		showAddWip();
		hideWipGrid();
		document.getElementById("WIPEditTitle").innerHTML = "Edit Wip Point";
	}
}

/**
 * 
 */
function addNewWippoint(){
	showAddWip();
	hideWipGrid();
	document.getElementById("WIPEditTitle").innerHTML = "Add Wip Point";
	document.getElementById("wippointCode").value = "";
	document.getElementById("sequnceNo").value = "";
	document.getElementById("wippoint").value = "";
	document.getElementById("description").value = "";
	document.getElementById("sequnceNo").readOnly = false;
	document.getElementById("wippoint").readOnly = false;
	//$('#mandetory ').bootstrapSwitch('toggleReadonly');
	$("#mandetory").bootstrapSwitch('state', false);
    /*var readonly = $('#mandetory').attr('readonly');
    if(readonly){
       $( "#mandetory").bind( "click" );
    }*/
	$("#activeWip").bootstrapSwitch('state', true);
	$("#mandetory").bootstrapSwitch('state', false);
	$('#mandetory').bootstrapSwitch('readonly', false);
	$("#mandetory").bootstrapSwitch('state', false);
	//**enable clear all
}

/**
 * 
 */
function resetForm(){
	var wippointCode = document.getElementById("wippointCode").value;
	if(wippointCode == ""){
		addNewWippoint();
	}
	else{
		editWipPoint(wippointCode);
	}
}

/**
 * 
 * @param wippointCode
 * @returns {Boolean}
 */
//var delWipCode = "";
function deleteWipPoint(wippointCode){
	var delWipCode = wippointCode;
	
	for (var j = 0; j < itemTypeArr.length; j++) {
		if(itemTypeArr[j].id.wippointCode == wippointCode && itemTypeArr[j].attached > 0){
			//document.getElementById("CBWIPDelete").style.display = "none";
			alert("This Wip point has allocated to items. Please remove all allocated items and please try again to DELETE this.");
			//modal fade delete-confirmation model-popup-fix in
			//aria-hidden="true" 
			return false;
			break;
		}
	}
	var r = confirm("Are you sure you want to permanently delete this?");
    if (r) {
    	var formdata = 'delete="delete"&wippointCode='+delWipCode;
    	$.ajax({
             type: "POST",
             url: "mststylewippointsform",
             data: formdata,
             success: function(data) {
            	 alert("Wip Point is deleted successfully!");
            	 location.replace("mststylewippointss");
             }
    	});
    }
}

//function confirmDelWipPoint(){
//
//}

/**
 * 
 */
function generateSecondPage(){
	itemTypeArr = null;
	itemTypeArr = new Array();
	var jsnrootDemMaps = AjaxCall("POST", "", "services/api/wippointitemtype/getAllWippointitemtype.json");
    if (jsnrootDemMaps.readyState == 4 && jsnrootDemMaps.status == 200) {
		jsnrootDemMaps = JSON.parse(jsnrootDemMaps.responseText);
		for (var i = 0; i < jsnrootDemMaps.length; i++) {
			try{
				itemTypeArr.push(jsnrootDemMaps[i]);
			}catch (e) {
				// TODO: handle exception
			}
		}
	}
    itemTypeSearch();
    createWipItemGrid();
    createItemGrid();
}

/**
 * 
 */
var itemTypeArr = new Array();
var itemTypeTemp = new Array();
var allItemTypes = new Array();
function createItemGrid(){
	var grid = '<table id="oparations-grid" class="display table table-striped table-bordered table-hover wip-points-tb" cellspacing="0">';
	grid += '<thead><tr><th class="center"></th><th class="center"><a>Item Type</a></th><th class="center"><a>Item Group</a></th>';
	grid += '<th class="center"><a>Attached %</a></th><th class=" textcenter"><a>Actions</a></th></tr></thead><tbody>';
	itemTypeTemp = null;
	itemTypeTemp = new Array();
	for(var i = 0; i < itemTypeArr.length; i++){
		var el = itemTypeArr[i];
		var found = false;
		var j = 0;
		for(; j < itemTypeTemp.length; j++){
			if(el.mstitemtype.itemType === itemTypeTemp[j].mstitemtype.itemType){
				found = true;
				break;
			}
		}
		if(found){
			itemTypeTemp[j].attached = itemTypeTemp[j].attached + el.attached;
		}
		else{
			itemTypeTemp.push(el);
		}
	}

	for (var i = 0; i < itemTypeTemp.length; i++) {
		var subgrid = '<tr class="gradeX">';
		subgrid += '<td class="center"><a class="addit-btn"><span class="glyphicon glyphicon-plus"></span></a></td>';
		subgrid += '<td class="center">'+itemTypeTemp[i].mstitemtype.itemType+'</td>';
		subgrid += '<td class="center">'+itemTypeTemp[i].mstitemtype.itemGroup+'</td>';
		subgrid += '<td class="center">'+itemTypeTemp[i].attached+'</td>';
		subgrid += '<td class="center "><div class="middle-align"><div class="delete-toggle-styl-rt delete-toggle delete-toggle only-delete-in-action">';
		subgrid += '<a onclick="deleteItemType(';
		subgrid += "'"+itemTypeTemp[i].mstitemtype.itemType+"',"+i+","+itemTypeTemp[i].id.wippointCode;
		subgrid += ');"><span class="glyphicon glyphicon-remove "></span> Delete </a></div></div></td></tr>';
		subgrid += '<tr class="gradeX displayNone"><td class="" colspan="12"><div class="col-sm-1 col-md-1"></div>';
		subgrid += '<div class="col-sm-4 col-md-4"><label class="pull-left" for="exampleInputEmail1">Attach</label>';
		subgrid += '<input type="text" id="attached'+i+'" onkeypress="return IsNumeric(event,';
		subgrid += "'attached"+i+""+j+"')" ;subgrid +='" maxlength="3" max="100" class="form-control pull-left inside-table-textbox attachC" name="attacName" tabindex="1" >';
		subgrid += '<label class="pull-left" for="exampleInputEmail1">%</label><span class="errorInput" id="errorattached'+i+''+j+'" style="color: Red; display: none;">* Input digits (0 - 9)</span>';
		subgrid += '<div class="clearfix"></div></div><div class="col-sm-4 col-md-4">';
		subgrid += '<label class="pull-left" for="exampleInputEmail1">Wip Point</label><select id="wipPoint'+i+'" class="form-control pull-left inside-table-textbox WPointC">';
		for (var j = 0; j < wipPointArr.length; j++) {
			subgrid += '<option value="'+wipPointArr[j][3]+'">'+wipPointArr[j][3]+'</option>';
		}
		subgrid += '</select><span class="caret dropdowncaret dropdowncaret-inside-table"></span><div class="clearfix"></div></div>';
		subgrid += '<div class="col-sm-3 col-md-3"><button class="btn btn-info btn-lg btn-embossed marginLeft27per" onclick="addWipToItem(';
		subgrid += "'"+itemTypeTemp[i].mstitemtype.itemType+"',"+i;
		subgrid += ');">Confirm</button></div></td></tr>';
		grid += subgrid;
	}
//	grid += '<tr class="gradeA"><td class="center"></td><td class="center"><div class="form-group "><div class="icon-addon addon-md">';
//	grid += '<div class="control-group">';
//	grid += '<select id="newItemType" class="demo-default" placeholder="Select a item..."><option value="">Select a item...</option>';
	//console.info(allItemTypes.length);
	//console.info(allItemTypes);
//	for (var j = 0; j < allItemTypes.length; j++) {
//		grid += '<option value="'+allItemTypes[j].itemType+'">'+allItemTypes[j].itemType+'</option>';
//	}
	//grid += '</select><input type="text" id="newItemType" data-provide="typeahead" onkeyup="itemTypeSearch();" class="typeahead form-control valid form-control form-control-TB-custom" tabindex="1">';
//	grid += '</div><span class="caret dropdowncaret"></span></div>';
//	grid += '</div></div></td><td class="center"></td><td class="center"></td>';
//	grid += '<td class="center "><div class="middle-align"><div class="edit-toggle-styl-rt edit-toggle"><a onclick="addItemType();">';
//	grid += '<span class="glyphicon glyphicon-plus"></span> Add</a></div><div class="delete-toggle-styl-rt delete-toggle delete-toggle ">';
//	grid += '<a onclick="removeItemType();"><span class="glyphicon glyphicon-remove"></span> Delete </a></div></div></td></tr>';
  
    grid += '</tbody></table>';
    document.getElementById('itemGrid').innHTML = "";
    $("#itemGrid").html("");
    $("#itemGrid").html(grid);
}



/**
 * 
 */
function createWipItemGrid(){
	var grid = '';
	for (var i = 0; i < wipPointArr.length; i++) {
		grid += '<div class="col-sm-12 col-md-12 "><div class="panel child-color-bar"><div class="panel-heading main-color-bar-wip" id="remove">';
		grid += '<h4 class="panel-title"><a>'+wipPointArr[i][3]+'</a></h4></div></div></div>';
		
		for (var j = 0; j < itemTypeArr.length; j++) {
			if(itemTypeArr[j].id.wippointCode == wipPointArr[i][0]){
				var subGrid = '<div class="col-sm-11 col-md-11 pull-right"><div class="panel child-color-bar"><div class="panel-heading" id="remove">';
				subGrid += '<h4 class="panel-title pull-left"><a>'+itemTypeArr[j].mstitemtype.itemType+'</a></h4>';
				subGrid += '<p class="panel-title2 pull-right">'+itemTypeArr[j].attached+'%</p><div class="clearfix"></div><a onclick="toggle_visibility(';
				subGrid += "'"+wipPointArr[i][0]+"','"+itemTypeArr[j].mstitemtype.itemType+"',"+i+","+j;
				subGrid += ');"><span class="glyphicon glyphicon-remove pull-right child-color-remove"></span></a>';
				subGrid += '<a data-toggle="collapse" data-parent="#child-color'+i+''+j+'" href="#child-color'+i+''+j+'-body" class="collapsed">';
				subGrid += ' <span class="child-color-panel glyphicon glyphicon-chevron-down pull-right child-color-collaps"></span></a>';
				subGrid += '<div class="clearfix"></div></div><div id="child-color'+i+''+j+'-body" class="panel-collapse collapse out" style="height: 0px;"><div class="panel-body">';                                           
				subGrid += '<div class="form-group row"><label for="inputEmail3" class="col-sm-4 control-label">Change</label>';
				subGrid += '<div class="col-sm-4 offset-sm-4"><input type="text" value="'+itemTypeArr[j].attached+'" onkeypress="return IsNumericWIP(event,';
				subGrid += "'errortextAttach"+i+""+j+"')" ;
				subGrid += '" maxlength="3" max="100" class="form-control" id="textAttach'+i+''+j+'"> <input type="hidden" id="textHideAttach'+i+''+j+'" value='+itemTypeArr[j].attached;
				subGrid += '><span id="errortextAttach'+i+''+j+'" class="error-message displayNone">* Input digits (0 - 9)</span>';
				subGrid += '</div><div class="col-sm-4 offset-sm-4"><button onclick="addWipItem(';
				subGrid += "'"+wipPointArr[i][0]+"','"+itemTypeArr[j].mstitemtype.itemType+"','"+i+"','"+j+"')";
				subGrid += '" class="btn btn-info btn-lg btn-embossed">Submit</button></div></div></div></div></div></div>';
				grid += subGrid;
			}
		}
	}

    document.getElementById('wipItemGrid').innHTML = "";
    $("#wipItemGrid").html("");
    $("#wipItemGrid").html(grid);
}

/**
 * 
 * @param e
 * @param varb
 * @returns {Boolean}
 */
function IsNumericWIP(e, varb) {
    var keyCode = e.which ? e.which : e.keyCode;
    var ret = ((keyCode >= 48 && keyCode <= 57) || specialKeys.indexOf(keyCode) != -1);
    document.getElementById(varb).innerHTML = "* Input digits (0 - 9)";
    document.getElementById(varb).style.display = ret ? "none" : "inline";
    return ret;
}

/**
 * 
 * @param wipPoint
 * @param itemType
 * @param i
 * @param j
 * @returns {Boolean}
 */
function addWipItem(wipPoint, itemType, i, j){
	//validate val>100
	var attach = parseInt(document.getElementById("textAttach"+i+""+j).value);
	var currentValue = parseInt(document.getElementById("textHideAttach"+i+""+j).value);
	for (var k = 0; k < itemTypeArr.length; k++) {
		if(itemTypeArr[k].id.itemType == itemType && (attach-currentValue+itemTypeArr[k].attached) > 100){
			alert("Item attachment can't exceed 100%. You remaining only "+((100-itemTypeArr[k].attached)+currentValue)+"% to assign");
			return false;
			break;
		}
	}
	//check item type from item array/*
	if(document.getElementById("textAttach"+i+""+j).value == ''){
	    document.getElementById("errortextAttach"+i+""+j).innerHTML = "This field is required.";
	    document.getElementById("errortextAttach"+i+""+j).style.display = "inline";
		return false;
	}
	else{
	    //document.getElementById("errortextAttach"+i+""+j).style.display = "none";
	    
		//attach += parseInt(document.getElementById("textHideAttach"+i+""+j).value);
		var formdata = 'wipPoint='+wipPoint+'&itemType='+itemType+'&attach='+attach;
		$.ajax({
	         type: "POST",
	         url: "mststylewippointitemtypeform",
	         data: formdata,
	         success: function(data) {
	        	 //location.replace("mststylewippointss");
	        	 alert("Wip Point updated successfuly!");
	        	 generateSecondPage();
	        	 showHideTr();
	         }
		});
	}
}

/**
 * 
 * @param itemType
 * @param i
 * @returns {Boolean}
 */
function addWipToItem(itemType, i){
	
	if(document.getElementById("attached"+i).value == ''){
		alert("Item attachment value is required!");
		return false;
	}
	var attach = parseInt(document.getElementById("attached"+i).value);
	var wipPoint = document.getElementById("wipPoint"+i).value;
	var found = false;
	for (var j = 0; j < wipPointArr.length; j++) {
		if(wipPointArr[j][3] == wipPoint){
			wipPoint = wipPointArr[j][0];
			found = true;
			break;
		}
	}
	
	for (var j = 0; j < itemTypeArr.length; j++) {
		if(itemTypeArr[j].id.itemType == itemType && (attach+itemTypeArr[j].attached) > 100){
			alert("Item attachment can't exceed 100%. You remaining only "+(100-itemTypeArr[j].attached)+"% to assign");
			return false;
			break;
		}
		if(itemTypeArr[j].id.itemType == itemType && itemTypeArr[j].id.wippointCode == "0"){
			var formdata = 'wipPoint='+itemTypeArr[j].id.wippointCode+'&itemType='+itemType+'&delete=delete';
			$.ajax({
		         type: "POST",
		         url: "mststylewippointitemtypeform",
		         data: formdata,
		         success: function(data) {
		         }
			});
			break;
		}
	}
	if(found){
		console.info(wipPoint);
		var formdata = 'wipPoint='+wipPoint+'&itemType='+itemType+'&attach='+attach;
		$.ajax({
	         type: "POST",
	         url: "mststylewippointitemtypeform",
	         data: formdata,
	         success: function(data) {
	        	 //location.replace("mststylewippointss");
	        	 alert("Wip Point assign success!");
	        	 generateSecondPage();
	        	 showHideTr();
	         }
		});
	}
	else{
		console.info(wipPoint+" not found");
		alert("Wip Point \""+wipPoint+"\" is not valid Wip point. Please try again!");
	}
	
	console.info(attach);
	console.info(wipPoint);
	
}

/**
 * 
 * @param itemType
 * @param i
 * @param wipPoint
 * @returns {Boolean}
 */
function deleteItemType(itemType, i,wipPoint){
	//document.getElementById('deleteWip').className = "modal fade delete-confirmation model-popup-fix in";
	//var wipPoint = "";
	for (var j = 0; j < itemTypeArr.length; j++) {
		if(itemTypeArr[j].mstitemtype.itemType == itemType){
			wipPoint = itemTypeArr[j].id.wippointCode;
			if(itemTypeArr[j].attached > 0){
				r = true;
				alert("'"+itemType+"' item type is assigned to a Wip point. Please remove from assigned WIP points and try again to delete this.");
				return false;
				break;
			}
		}
	}
	console.info(wipPoint);
	var r = confirm("Are you sure you want to permanently delete this?");
    if (r) {
		var formdata = 'wipPoint='+wipPoint+'&itemType='+itemType+'&permenent&delete=delete';
		$.ajax({
	         type: "POST",
	         url: "mststylewippointitemtypeform",
	         data: formdata,
	         success: function(data) {
	        	 //location.replace("mststylewippointss");
	        	 alert(" Item Type is deleted successfully!");
	        	 generateSecondPage();
	        	 showHideTr();
	         }
		});
    }
}

/**
 * 
 */
function addItemType(){
	var itemType = document.getElementById("newItemType").value;
	console.info(itemType);
	if(itemType== ""){
		alert("Please select item from the drop down list!");
		return;
	}
	var found = false;
	for (var j = 0; j < itemTypeArr.length; j++) {
		if(itemTypeArr[j].mstitemtype.itemType == itemType){
			found = true;
			console.info(itemTypeArr[j].mstitemtype.itemType);
			console.info(itemType);
			break;
		}
	}
	if(found){
		alert("'"+itemType+"' is already added for 'Available Item Types'");
		
	}else{
		var formdata = 'wipPoint=0&itemType='+itemType+'&attach=0';
		$.ajax({
	         type: "POST",
	         url: "mststylewippointitemtypeform",
	         data: formdata,
	         success: function(data) {
	        	 //location.replace("mststylewippointss");
	        	 alert("Item Type added successfully!");
	        	 var controll = $WIPselect[0].selectize;
	        	 controll.clear();
	        	 generateSecondPage();
	        	 showHideTr();
	         },
	         error: function(){
	        	 alert("Error! Item Type not added successfully!");
	        	 showHideTr();
	         }
		});
		
	}
}

/**
 * 
 * @param wipPoint
 * @param itemType
 * @param i
 * @param j
 */
function toggle_visibility(wipPoint, itemType, i, j){
	var r = confirm("Are you sure you want to permanently delete this?");
    if (r == true) {
    	var formdata = 'wipPoint='+wipPoint+'&itemType='+itemType+'&delete=delete';
    	$.ajax({
             type: "POST",
             url: "mststylewippointitemtypeform",
             data: formdata,
             success: function(data) {
            	 alert("Attached Item is deleted successfully!");
            	 generateSecondPage();
            	 showHideTr();
             }
    	});
    }
}

/**
 * 
 */
function itemTypeSearch(){
    var jsnrootitemTypes = AjaxCall("POST", "", "services/api/mstitemtype/getItems.json");
	if (jsnrootitemTypes.status == 200) {
		jsnrootitemTypes = JSON.parse(jsnrootitemTypes.responseText);
		for (var i = 0; i < jsnrootitemTypes.length; i++) {
			try{
				allItemTypes.push(jsnrootitemTypes[i]);
			}catch (e) {
				// TODO: handle exception
			}
		}
	}
	var newItemType = document.getElementById("newItemType");
	for (var j = 0; j < allItemTypes.length; j++) {
		var option = document.createElement("option");
		option.value = allItemTypes[j].itemType;
		option.text = allItemTypes[j].itemType;
		newItemType.add(option);
	}
}

	


