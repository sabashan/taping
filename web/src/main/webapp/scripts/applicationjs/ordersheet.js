//var editmodeprecostsheetRowMatCode="";
var editmodeprecostsheetRowMatCode=0000;




/**
 * open a style which contain all style details in view mode
 */
function openstyle(){
	
	locationCode = document.getElementById("id_locationCode").value;
	custCode = document.getElementById("id_custCode").value;
	styleId = document.getElementById("id_styleId").value;
	depCode = document.getElementById("id_depCode").value;
	compCode = document.getElementById("id_compCode").value;
	
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
 * @param e
 * @param condition
 */
function checkenter(e,condition){
	 var keyCode = e.which ? e.which : e.keyCode;
	 if(keyCode==13){
		 getCostsheets(condition);
	 }
}
/**
 * 
 * @param type
 */
function AddOrdersheet(type){
	
	
	custCode=document.getElementById(type+"id_custCode").value;
	locationCode=document.getElementById(type+"id_locationCode").value;
	depCode=document.getElementById(type+"id_depCode").value;
	styleId=document.getElementById(type+"id_styleId").value;
	compCode=document.getElementById(type+"id_compCode").value;
	season=document.getElementById(type+"season").value;
	
	if(custCode==null || locationCode==null || depCode==null || styleId==null || compCode==null ||  season==null || custCode=="" || locationCode=="" ||  depCode=="" ||  styleId=="" ||  compCode=="" ||  season=="" ){
		alert("Please Select all filed search ");
	}
	else{
		window.location.replace("merordersheethdrform?custCode="+custCode+"&locationCode="+locationCode+"&depCode="+depCode+"&styleId="+styleId+"&season="+season+"&compCode="+compCode+"&costsheet=");
		
	}
	
	
}

/**
 * 
 * @param typeid
 */
function schOrdersheet(typeid){
	var type=typeid;
	var query;
	var last="";
	if(type=="Incomplete"){
		typeid="";
		query="dquery="+document.getElementById("dquery").value;
	}
	else{
		query="q="+document.getElementById(typeid+"query").value;
	}
	custCode=document.getElementById(typeid+"id_custCode").value;
	locationCode=document.getElementById(typeid+"id_locationCode").value;
	depCode=document.getElementById(typeid+"id_depCode").value;
	styleId=document.getElementById(typeid+"id_styleId").value;
	compCode=document.getElementById(typeid+"id_compCode").value;
	season=document.getElementById(typeid+"season").value;
	
	if(custCode==null || locationCode==null || depCode==null || styleId==null || compCode==null ||  season==null || custCode=="" || locationCode=="" ||  depCode=="" ||  styleId=="" ||  compCode=="" ||  season=="" ){
		if(query!=null && query!="" && type=="Incomplete"){
			window.location.replace("merordersheethdrs?"+query);
		}
		else{
			alert("Please Select all fileds before Add Pre Cost Sheet")
		}
	}
	else{
		if(query!=null && query!=""){
			window.location.replace("merordersheethdrs?"+query+"&custCode="+custCode+"&locationCode="+locationCode+"&depCode="+depCode+"&styleId="+styleId+"&season="+season+"&compCode="+compCode);
		}
		else{
			window.location.replace("merordersheethdrs?custCode="+custCode+"&locationCode="+locationCode+"&depCode="+depCode+"&styleId="+styleId+"&season="+season+"&compCode="+compCode);
		}
	}	
}

/**
 * 
 * @param id
 */
function ordersheetnavigation(id){
	try{
		//if(isstyleselect!="NO"){
			$('#addFinalCS').hide();
			$('#addNewFinalCostSheet').hide();
			$('#naddFinalCS').removeClass( "active" );
			$('#addNewFinalCostSheet').removeClass( "active" );
			//$('#naddNewFinalCostSheet').addClass( "disabled" );
			//$('#naddFinalCS').addClass( "disabled" );
			$('#'+id).show();
			//$('#n'+id).removeClass( "disabled" );
	        $('#n'+id).addClass( "active" );
		//}
		//else{
			//alert("Please select Style before proceed ");
		//}
	}
	catch(e){
		console.log(e)
	}
	//console.log("dfghjk");
}


function saveplanningorder(id){
	//planingOrdersheetNo  orderType
	if(jQuery("#merordersheethdrsfrmhdr").valid()){
		var formdata = jQuery("#merordersheethdrsfrm").serialize();
		totalQty=document.getElementById("totalQty").value;
		remarks=document.getElementById("remarks").value;
		orderType=document.getElementById("orderType").value;
		custCode=document.getElementById("id_custCode").value;
		var status="Incomplete";
		var isProcess=false;
		if(id=="planingconform"){
			status="Complete";
		}
		
		if(custCode!=null && custCode!=""){
			if(id =="planingconform" && (totalQty == null ||  totalQty == "" || isstyleselect =="NO" || !jQuery("#merordersheethdrsfrm").valid()) ){
				if(!jQuery("#merordersheethdrsfrm").valid()){
					alert("Please add style field before confirm");
					return false;
				}
				else{
					alert("Please add total quntity field before confirm");
					return false;
				}
			}
			else{
				if(planingOrdersheetNo==""|| planingOrdersheetNo==null)
					planingOrdersheetNo="****"
				formdata=formdata+"&section=section01&status="+status+"&isProcess="+isProcess+"&totalQty="+totalQty+"&remarks="+remarks+"&id.planingOrdersheetNo="+planingOrdersheetNo+"&id.orderType="+orderType;
				var success=  AjaxCall("POST", formdata, "merordersheethdrform");
				if (success.readyState == 4 && success.status == 200) {
					newid=getCookie("planingOrdersheetNo"); 
					if(newid>0){
						window.location.replace("merordersheethdrform?planingOrdersheetNo="+(newid)+"&orderType="+orderType);
					}
				}
			}
		}
		else{
			alert("please add Buyer");
		}
	}
	else{
		alert("please add required Field");
	}
}


/**
 * 
 * @param id
 * @returns rowmaterial grid for selected rowmaterial type 
 */
function navigterowMat(id,stsus){
	//planingOrdersheetNo=document.getElementById("preCostSheetNo").value;
	orderType=document.getElementById("orderType").value;
	//costsheetType=document.getElementById("costsheetType").value;
	if(planingOrdersheetNo==""||orderType=="" || planingOrdersheetNo==null ||orderType==""){
		
	}
	else{	
	var div="";
	console.log(stsus);
	
		div +='<div >';
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
								div  +='<input type="text" id="rowmatgridsch" class="form-control" placeholder="Search and Filter">';
								div  +='<span class="input-group-btn">';
									div  +='<button class="btn btn-info search-form-btn" type="button"  onclick="getRowmat(\''+id+'\')">';
										div  +='<span class="glyphicon glyphicon-search"></span>';
									div  +='</button>';
								div  +='</span>';
								if(stsus!="View")
								div  +='<a onclick="HideRow_matGrid(); HideAddplaning_mat();showAddRow_mat();document.getElementById(\'merordersheethdrsfrmrm\').reset();editmodeprecostsheetRowMatCode=0000;" class="btn btn-warning btn-embossed pull-right"><span class="glyphicon glyphicon-plus marginRight4"></span>Add  Row Material</a>';
							div  +='</div>';
						div  +='</div>';                   
					div  +='</div>';
					div  +='<div class="dataTables_wrapper Scroll-for-datatable-add-row-matirials">';
						div  +='<section>';
							div  +='<table id="route" class="display table table-striped table-bordered" cellspacing="0">';
								div  +='<thead>';
									div  +='<tr>';
										div  +='<th class="textcenter">Raw Material No</th>';
										div  +='<th class="textcenter">Order Type</th>';
										div  +='<th class="textcenter">Item Type</th>';
										div  +='<th class="textcenter">ItemCode</th>';
										div  +='<th class="textcenter">Item Description</th>';
										div  +='<th class="textcenter">Color</th>';
										div  +='<th class="textcenter">Width</th>';
										div  +='<th class="textcenter">Is Release</th>';
										div  +='<th class="textcenter">Additional Attribute 1</th>';
										div  +='<th class="textcenter">Additional Attribute 2</th>';
										div  +='<th class="textcenter headcol3 order_sheet_apply_row_action">Actions</th>';
									div  +='</tr>';
								div  +='</thead>';
								div  +='<tbody id="rawmateriatablelbody">';  
									
									var my=  AjaxCall("POST", "", "services/api/merordersheetrawmaterial/GetAllByid/"+planingOrdersheetNo+"/"+orderType+"/"+id+".json"); 
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
											div  +='<td class="textcenter">'+jsn[k].id.rowMaterialNo+'</td>';
											div  +='<td class="textcenter">'+jsn[k].id.orderType+'</td>';
											div  +='<td class="textcenter">'+jsn[k].mstitemtype.itemType+'</td>';
											div  +='<td class="textcenter">'+jsn[k].itemCode+'</td>';
											div  +='<td class="textcenter">'+jsn[k].itemDescription+' </td>';
											div  +='<td class="textcenter">'+jsn[k].itemColor+'</td>';
											div  +='<td class="textcenter">'+jsn[k].itemWidth+'</td>';
											var isRelease="";
											if(jsn[k].isRelease==true){
												isRelease="Yes";
											}
											else{
												isRelease="No";
											}
											div  +='<td class="textcenter">'+isRelease+'</td>';
											div  +='<td class="textcenter">'+jsn[k].additionalAttribute1+'</td>';
											div  +='<td class="textcenter">'+jsn[k].additionalAttribute2+'</td>';
											div  +='<td class="center headcol3">';
												div  +='<div class="middle-align">';
													div  +='<div class="edit-toggle-styl-rt edit-toggle edit-toggle marginLeft20">';
														div  +='<a ';
														if(stsus!="View"){
															div  +=' onclick="editrowmaterials( \''+id+'\',\''+jsn[k].id.planingOrdersheetNo+'\',\''+ jsn[k].id.orderType+'\',\''+ jsn[k].id.rowMaterialNo+'\')"';
														}
														div  +=' ><span class="glyphicon glyphicon-pencil"></span> Edit</a>';
													div  +='</div>';	
													
													div  +='<div class="delete-toggle-styl-rt delete-toggle delete-toggle pull-right marginRight48">';
														div  +='<a ';
														if(stsus!="View"){
															div  +='onclick="if ( confirm(\'do you really need to delete this ?\') == true) {deleterowmaterials(\''+id+'\',\''+jsn[k].id.planingOrdersheetNo+'\',\''+ jsn[k].id.orderType+'\',\''+ jsn[k].id.rowMaterialNo+'\');}"';
														}
														else{
															div  +='disabled ';
														}
														div  +='data-toggle="modal" data-target=".delete-confirmation"><span class="glyphicon glyphicon-remove"></span> Delete </a>'; 
													div  +='</div>';
													
												div  +='</div>';
											div  +='</td>';
										div  +='</tr>';
									}
								div  +='</tbody>';
							div  +='</table>';
						div  +='</section>';
					div  +='</div>	';	
				div  +='</div>';
			div  +='</div>';
		div  +='</div>';
		document.getElementById("rowMaterialScreen").innerHTML=div;
		document.getElementById("bage"+id).innerHTML=jsn.length;
		if(stsus!="View"){
			document.getElementById("merordersheethdrsfrmrm").reset();
			selecteditemcategory=id;
		}		
	}
}

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
function editrowmaterials(id,planingOrdersheetNo, orderType ,rowMaterialNo ){
	//GetByid/{planingOrdersheetNo}/{orderType}/{rowMaterialNo}
	url ="services/api/merordersheetrawmaterial/GetByid/"+planingOrdersheetNo+"/"+orderType+"/"+rowMaterialNo+".json";
	var my=  AjaxCall("POST", "", url);
	if (my.readyState == 4 && my.status == 200) {
		//navigterowMat(selecteditemcategory,"");
		jsn = JSON.parse(my.responseText);
		$('#itemType').prop('readonly', true);
		$('#itemCode').prop('disabled', false);
		document.getElementById("itemType").innerHTML="<option value="+jsn.mstitemtype.itemType+">"+jsn.mstitemtype.itemType+"</option>";
		selecteditemtype=jsn.mstitemtype.itemType;
		document.getElementById("itemDescription").value=jsn.itemDescription;
		document.getElementById("itemCode").innerHTML="<option value="+jsn.itemCode+">"+jsn.itemCode+"</option>";
		document.getElementById("itemColor").innerHTML="<option value="+jsn.itemColor+">"+jsn.itemColor+"</option>";
		document.getElementById("itemWidth").value=jsn.itemWidth;
		if(jsn.isRelease){
			//document.getElementById("isRelease").cheked="cheked";
			 document.getElementById("isRelease").checked = true;
		}
		console.log(jsn.isRelease);
		document.getElementById("itemWidth").value=jsn.itemWidth;
		document.getElementById("additionalAttribute1").value=jsn.additionalAttribute1;
		document.getElementById("additionalAttribute2").value=jsn.additionalAttribute2;
		
		//document.getElementById("rowsubmit").style.display="none";
		//document.getElementById("rowUpdate").style.display="inline";
		editmodeprecostsheetRowMatCode=rowMaterialNo;
		//HideRow_matGrid();showAddRow_mat();
		
	}
	else{
		return false;
	}
}

/**
 * 
 * @param pre-CostSheet No
 * @param version No
 * @param costsheet Type
 * @param precostsheet RowMaterial Code
 */
function deleterowmaterials(id,planingOrdersheetNo, orderType ,rowMaterialNo ){
	var formdata = jQuery("#merordersheethdrsfrmhdr").serialize() +'&'+ jQuery("#merordersheethdrsfrmrm").serialize(); 
	
	formdata +="&section=section02&deleteRowMat=true&id.rowMaterialNo="+rowMaterialNo+"&id.planingOrdersheetNo="+planingOrdersheetNo;
	var my=  AjaxCall("POST", formdata, "merordersheethdrform");
	var jsn;
	if (my.readyState == 4 && my.status == 200) {
		navigterowMat(selecteditemcategory,"");
	}
	else{
		alert("Not deleted");
	}
	
}

function addrowmatToPlaning(){
	var sucsess= jQuery("#merordersheethdrsfrmrm").valid();
	if(sucsess){
		var formdata = jQuery("#merordersheethdrsfrmhdr").serialize() +'&'+ jQuery("#merordersheethdrsfrmrm").serialize(); 
		
		formdata +="&section=section02&id.rowMaterialNo="+editmodeprecostsheetRowMatCode+"&id.planingOrdersheetNo="+planingOrdersheetNo;
		var my=  AjaxCall("POST", formdata, "merordersheethdrform");
		var jsn;
		if (my.readyState == 4 && my.status == 200) {
			navigterowMat(selecteditemcategory,"");
			//HideRow_matGrid(); //HideAddplaning_mat();//showAddRow_mat();
			document.getElementById('merordersheethdrsfrmrm').reset();
			editmodeprecostsheetRowMatCode=0000;
		}
		else{
			alert("Not Added");
		}
	}
	else{
		alert("Please Fill all required Filed");
	}
}

/**
 * 
 */
function showAddplaning_mat(){
	//$('#quallocationsscreeen').collapse('show');
	document.getElementById('quallocationsBody1').className = "panel-collapse collapse in";
}

/**
 * 
 */
function HideAddplaning_mat(){
	//$('#quallocationsscreeen').collapse('show');
	document.getElementById('quallocationsBody1').className = "panel-collapse collapse";
}

/**
 * 
 */
function showAddRow_mat(){
	//$('#fcsgdetailsBody').collapse('show');
	document.getElementById('fcsgdetailsBody').className = "panel-collapse collapse in";
	//HideRow_matGrid();
}
/**
 * 
 */
function HideAddRow_mat(){
	//$('#fcsgdetailsBody').collapse('show');
	document.getElementById('fcsgdetailsBody').className = "panel-collapse collapse";
}
/**
 * 
 */
function showRow_matGrid(){
	//$('#rowMaterialScreenBody2').collapse('show');
	document.getElementById('rowMaterialScreenBody2').className = "panel-collapse collapse in";
//HideAddRow_mat();
}
/**
 * 
 */
function HideRow_matGrid(){
	//$('#rowMaterialScreenBody2').collapse('show');
	document.getElementById('rowMaterialScreenBody2').className = "panel-collapse collapse";
}


function deleteordersheet (url){
	var my=  AjaxCall("POST", "", url);
	window.location.replace('merordersheethdrs');
} 

function calculatesellingprice(){
	
}

function getRowmat (){
	query=document.getElementById("rowmatgridsch").value;
	orderType=document.getElementById("orderType").value;
	var id =selecteditemcategory;
	if(query!=null && query!=""){
		url ="services/api/merordersheetrawmaterial/GetAllByidquery/"+planingOrdersheetNo+"/"+orderType+"/"+selecteditemcategory+"/"+query+".json";
		var my=  AjaxCall("POST", "", url);
		if (my.readyState == 4 && my.status == 200) {
			jsn = JSON.parse(my.responseText);
		}
		else{
			return false;
		}
		var total_finance=0;
		var total_Amount=0;
		div="";
		for(var k=0;k<jsn.length;k++){
			div  +='<tr class="gradeX">';
				div  +='<td class="textcenter">'+jsn[k].id.rowMaterialNo+'</td>';
				div  +='<td class="textcenter">'+jsn[k].id.orderType+'</td>';
				div  +='<td class="textcenter">'+jsn[k].mstitemtype.itemType+'</td>';
				div  +='<td class="textcenter">'+jsn[k].itemCode+'</td>';
				div  +='<td class="textcenter">'+jsn[k].itemDescription+' </td>';
				div  +='<td class="textcenter">'+jsn[k].itemColor+'</td>';
				div  +='<td class="textcenter">'+jsn[k].itemWidth+'</td>';
				var isRelease="";
				if(jsn[k].isRelease==true){
					isRelease="Yes";
				}
				else{
					isRelease="No";
				}
				div  +='<td class="textcenter">'+isRelease+'</td>';
				div  +='<td class="textcenter">'+jsn[k].additionalAttribute1+'</td>';
				div  +='<td class="textcenter">'+jsn[k].additionalAttribute2+'</td>';
				div  +='<td class="center headcol3">';
					div  +='<div class="middle-align">';
						div  +='<div class="edit-toggle-styl-rt edit-toggle edit-toggle marginLeft20">';
							div  +='<a ';
								div  +=' onclick="editrowmaterials( \''+id+'\',\''+jsn[k].id.planingOrdersheetNo+'\',\''+ jsn[k].id.orderType+'\',\''+ jsn[k].id.rowMaterialNo+'\')"';
							div  +=' ><span class="glyphicon glyphicon-pencil"></span> Edit</a>';
						div  +='</div>';	
						
						div  +='<div class="delete-toggle-styl-rt delete-toggle delete-toggle pull-right marginRight48">';
							div  +='<a ';
								div  +='onclick="if ( confirm(\'do you really need to delete this ?\') == true) {deleterowmaterials(\''+id+'\',\''+jsn[k].id.planingOrdersheetNo+'\',\''+ jsn[k].id.orderType+'\',\''+ jsn[k].id.rowMaterialNo+'\');}"';
							div  +='data-toggle="modal" data-target=".delete-confirmation"><span class="glyphicon glyphicon-remove"></span> Delete </a>'; 
						div  +='</div>';
						
					div  +='</div>';
				div  +='</td>';
			div  +='</tr>';
		
			
		}
		document.getElementById("rawmateriatablelbody").innerHTML=div;
	}
}
//merordersheetrawmaterial/GetAllByidquery/{planingOrdersheetNo}/{orderType}/{category}/{query}