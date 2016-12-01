
/**
 * create table grid for added component 
 */
function addtbl() {
	/** get current components input field values */
    var cmpV = document.getElementById("cmpV").value;//Component value
    var prdV = document.getElementById("prdV").value; // Product  Value   
    var compR = document.getElementById("compR").value; // Component ratio  
   
    /** check  current component is  contain name duplications  values  ['cmpV'+document.getElementById("cmpV").value] is uniqe for component */
    if(cmpV == null || cmpV == "" || prdV ==null  || prdV =="" || compR=="" || compR == null){
    	 alert(" null Values Not Allowed");
    }
    else{
	    if (document.getElementById('cmpV' + document.getElementById("cmpV").value) == null){
	    	
    	 /** add to array for ajax data */
	        dataComponent[iCom++]= cmpV + ":" +  prdV+":" + compR;
	    	/** create div */
	        var inp1 = '<td class="textcenter"><div value="" id="cmpV' + cmpV + '">' + cmpV + '</div></td>';
	        var inp2 = '<td class="textcenter"><div value="" id="prdV' + cmpV + '">' + prdV + '</div></td>';
	        var inp3 = '<td class="textcenter"><div value="" id="compR' + cmpV + '">' + compR + '</div></td>';
	        /** add row with component value as parameter , remove data in component array */
	        var inp4 = '<td><div class="edit-toggle components_edit_eidt" onclick="AddRow(\'' + cmpV + '\');dataComponent.splice(dataComponent.indexOf(\''+cmpV + ":" +  prdV+":" + compR+'\'),1);iCom--; console.log(dataComponent);"><a ><span class="glyphicon glyphicon-pencil"></span>Edit </a></div> ';
	       /** delete tr data and remove from array */
	        var inp5 = ' <div class="delete-toggle components_edit_delete"><a onclick="dataComponent.splice(dataComponent.indexOf(\'' +cmpV + ":" +  prdV+":" + compR+'\'),1);iCom--; console.log(dataComponent);  toggle_visibility(\'tr' + cmpV + '\');"><span class="glyphicon glyphicon-remove"></span> Delete</a></div></td>';
	       /** check previos tr creation if true apped to it */
	        
	        if(document.getElementById('tr'+ cmpV)!=null){
	        	$("#tr" + cmpV).append( inp1 + inp2 + inp3 + inp4 + inp5);
	        }
	        /** else create new one */
	        else{
	        	$("#Ceditable-sample").append("<tr id='tr" + cmpV + "'>" + inp1 + inp2 + inp3 + inp4 + inp5 + "</tr>");
	        }
	    	
	    } else {
	        alert("duplicates Component ");
	    }
	    
	    /** null input feldes and recrete empty input */
	    document.getElementById("editable-sample").innerHTML = "";
	    /** 1 for create new parameter */
	    AddRow('*New Field*');
    }
   
}

/**
 * 
 * @param obj component id 
 */
function AddRow(obj){
    var aData;
     var compV =null;
     var prdv =null;
     var compR=null;
    if (obj == '*New Field*') {
    	/** new input felds then create array using empty values */
        aData = ["", "", "", "Save", "Clear"];
    } 
    else {
    	/** in edit case take div values by geting inner html  */
        compV = document.getElementById("cmpV" + obj).innerHTML;
        prdv = document.getElementById("prdV" + obj).innerHTML;
        compR = document.getElementById("compR" + obj).innerHTML;
        /** add to array */
        aData = [compV, prdv, compR, "Update", "Delete"];
        console.log(aData);
    }
    /** if null component name or no value or new value in input felds then */
    if ( document.getElementById("cmpV") == null || document.getElementById("cmpV").value=="" || obj == "*New Field*" ) {
    	
        var inp1 = '<td><input maxlength="6" onkeypress="return CheckNumeric(event)" ondrop="return false;" onpaste="return false;" type="text" id="cmpV" class="form-control small" value="' + aData[0] + '"></td>';
        var inp2 = '<td>';
        inp2 = inp2 + '<select class="form-control" id="prdV" onfocus="optionsforgencodes(\'prdV\',\'PROTYP\')"><option>'+aData[1]+'</option></select></td>';
        var inp3 = '<td><input  onkeypress="return IsNumeric(event,\'compR\')" ondrop="return false;" onpaste="return false;" type="text" id="compR" class="form-control small" value="' + aData[2] + '">';
            inp3 = inp3 + '<span id="errorcompR" style="color: Red; display: none">* Input digits (0 - 9)</span></td>';
        var inp4 = '<td style="padding-left: 5%;"><div class="components_save save-toggle marginLeft19per" onclick="addtbl();"><a ><span class="glyphicon glyphicon-floppy-disk"></span>' + aData[3] + '</a></div> ';
        var inp5 = '<div class="components_delete delete-toggle"><a  onclick="AddRow(\'*New Field*\');" ><span class="glyphicon glyphicon-remove"></span> ' + aData[4] + '</a</div></div></td>';
        document.getElementById("editable-sample").innerHTML = "<tr>" + inp1 + inp2 + inp3 + inp4 + inp5 + "</tr>";

        if (document.getElementById('tr' + obj) != null) {
           toggle_visibility('tr' + obj);
        }
        else{
        	console.log("no tr found : tr"+obj);
        }
    } 
    else {
        alert("Upadate the current editing field");
        
    }
}

/** main color */

function  addnewmaincolor() {
    /** empty color or main color */
	var colorobj=document.getElementById("inputmaincolor");
	var color=colorobj.value;
	var obj=color;
    if(color!="" && color !=null){
        /** duplicate color */ 
        if(document.getElementById("mdiv" + color )==null){
            dataCol[iCol] = color;
            obj=obj.replace(" ","");
            iCol++;
            var large = "";
            large = large + '<div class="panel-group col-md-11 col-md-offset-1" id="mdiv' + obj + '">';
            large = large + '<div class="main-color-bar pull-left" id="remove-maincolor' + obj + '">';
            large = large + '<div class="pull-left">' + obj + '</div>';
            large = large + '<a href="#mdiv' + obj + '" onclick=" if(removecolor(\''+ obj +'\')){ var index=dataCol.indexOf(\'' + obj+ '\');dataCol.splice(index,1);if(index>=0){iCol--; removedbymaincolor(\''+obj+'\');} toggle_visibility(\'mdiv' + obj + '\'); console.log(dataCol);}">';
            large = large + '<span class="glyphicon glyphicon-remove pull-right remove-bar"></span></a><div class="pack-qty-lable pull-right" >Pack Qty ';
            large = large + '<span id="pqt' + obj + '">1</span>';
            large = large + '</div></div><button type="button" class="btn btn-default btn-lg pull-right" onclick="addchilde(\'' + obj + '\')">';
            large = large + '<span class="glyphicon glyphicon-plus"></span> Add Child Color';
            large = large + '</button><div style="display: none;" id="Vdiv' + obj + '">1</div>';
            large = large + '<div class="clearfix"></div> </div>';
            $("#new1").append(large);
            colorobj.value = "";       
           console.log(dataCol);
        }
        else{
            alert("Duplicates");
            colorobj.value = ""; 
        }
    }
    else{
        alert("Null colour not allowded");
    }
}

/**
 * 
 * @param Maincolor 
 */
function addchilde(obj) {
	obj=obj.replace(" ","");
	obj=obj.trim();
    id = document.getElementById("Vdiv" + obj).innerHTML;
    document.getElementById("Vdiv" + obj).innerHTML = (parseInt(id) + 1);
    
		  var large = '<div class="panel child-color-bar" id="removes' + obj + id + '">';
		    large = large + '<div class="panel-heading" id="remove' + obj + id + '">';
		        large = large + '<h4 class="panel-title">';
		            large = large + '<a id="cl' + obj + id + '"></a>';
		            large = large + '<a class="pack-qty-lable " id="clpqt' + obj + id + '"></a>';
		        large = large + '</h4>';
		        large = large + '<a href="#mdiv' + obj + '" onclick="removechild(\'' + obj + id + '\',\''+obj+'\')">';
		        large = large +'<span class="glyphicon glyphicon-remove pull-right child-color-remove"></span></a>';
		        large = large + '<a data-toggle="collapse" data-parent="#mdiv' + obj + '" href="#child-color1-body' + obj + id + '"> <span class="child-color-panel glyphicon glyphicon-chevron-down pull-right child-color-collaps"></span></a>';
		     large = large + '</div>';
		     large = large + '<div class="panel-body padding0" id="body' + obj + id + '">';
		        large = large + '<div id="child-color1-body' + obj + id + '" class="panel-collapse collapse in">';
		            large = large + '<div class="panel-body">';
		                large = large + '<div class="form-group row">';
		                    large = large + '<label for="inputEmail3" class="col-sm-4 control-label">Child Color Name</label>';
		                    large = large + '<div class="col-sm-8">';
		                      	large = large + '<select class="form-control" id="child-color-name' + obj + id + '" onfocus="coloronfocus(\'' + id+'\',\''+obj+'\',\'C\'); optionsforgencodes(\'child-color-name' +obj+ id + '\',\'\')"  onblur="colorononblur(\'' + id+'\',\''+obj+'\',\'C\');">';
			            		large = large + '</select>';
			            		large = large + '<span class="caret dropdowncaret"></span>';
			            		large = large + '<div class="feedback"></div>';
		                    large = large + '</div>';
		                large = large + '</div>';
		                large = large + '<div class="form-group row margintop20">';
		                    large = large + '<label for="inputEmail3" class="col-sm-4 control-label">Pack Qty.</label>';
		                    large = large + '<div class="col-sm-4 offset-sm-4">';
		                        large = large + '<input type="text" class="form-control" id="child-color-qty' + obj + id + '" value = "1" onkeypress="return styleChildColorVal(event,\'' + obj + id + '\');" ondrop="return false;" onpaste="return false;"   onfocus="coloronfocus(\'' + id+'\',\''+obj+'\',\'Q\');"  onblur="colorononblur(\'' + id+'\',\''+obj+'\',\'Q\');">';
		                        large = large + '<span id="error' + obj + id + '" style="color: Red; display: none">* Input digits (1 - 9)</span>';
		                    large = large + '</div>';
		                    large = large + '<div>';
		                        large = large + '<a data-toggle="collapse" data-parent="#mdiv' + obj + '" href="#child-color1-body' + obj + id + '">';                                                         
		                        large = large + '<button class="btn btn-info btn-lg btn-embossed" id="child-color-btn' + obj + id + '" onClick="add_color(\''+id+'\' , \''+obj +'\')"';
		                        	large = large + '>Add Color</button></a>';
		                    large = large + '</div>';
		                large = large + '</div>';
		            large = large + '</div>';
		        large = large + '</div>';
		    large = large + '</div>';
		    large = large + '</div>';

    $("#mdiv" + obj).append(large);    
};


/**
 * 
 * @param e
 * @param varb
 * @returns {Boolean}
 */
function styleChildColorVal(e, varb) {
    var keyCode = e.which ? e.which : e.keyCode;
    console.info(keyCode);
    if(document.getElementById("child-color-qty" + varb).value == ''){
    	var ret = ((keyCode > 48 && keyCode <= 57) || specialKeys.indexOf(keyCode) != -1 );
    }
    else{
    	var ret = ((keyCode >= 48 && keyCode <= 57) || specialKeys.indexOf(keyCode) != -1 );
    }
    document.getElementById("error" + varb).style.display = ret ? "none" : "inline";
    return ret;
}


/** main color function */

/**
 * 
 * @param maincolor + id 
 * @param maincolor
 */
function removechild(id,maincolor){
	var qtyobj = document.getElementById('child-color-qty'+ id);
	var Clrobj = document.getElementById('child-color-name' + id );
	
	
	
	index =arrayindex(MainvsChiledColor,maincolor+':'+Clrobj.value)
	console.log(maincolor+':'+Clrobj.value+ ": indx : "+index);	
	if(index>=0){
		MainvsChiledColor.splice(index,1);
		MinColor--;
		if(dataChiledarrayremove(maincolor+':'+Clrobj.value+':'+qtyobj.value)){
			icColor--;
			
		} 
		addpqt('1',qtyobj,maincolor);
	}
	else{
		console.log("Nothing to remove in array");
	}
	
	
	toggle_visibility('removes' + id );
	console.log(MainvsChiledColor)
	console.log(dataChiledColor);
}

/**
 * 
 * @param type 1 means remove 2 means Add
 * @param Pack Quantity 
 * @param Main color 
 * for add pack quntity to selected main color 
 */
function addpqt(type,qtyobj,maincolor) {
    var doc = document.getElementById('pqt' + maincolor);
    var myhtml = parseInt(doc.innerHTML);
    Keyword=maincolor +":" ;
	index =arrayindex(MainvsChiledColor,Keyword);
	console.log("Keyword "+Keyword+"   index "+index);
    if (type == 1) {
    	/** remove value part*/
        if (myhtml > 1 || index>-1) {
            console.log("rm : has prv values in main color : " + myhtml + " Child color : " + qtyobj.value);
            if (parseInt(qtyobj.value) > 0)
                myhtml = myhtml - parseInt(qtyobj.value);
            else
                console.log("rm to nothing in Child color");
        } else {
            console.log("rm : no  prv values in main color : " + myhtml + " Child color : " + qtyobj.value);
            if (parseInt(qtyobj.value) > 0)
                myhtml = myhtml - parseInt(qtyobj.value) + 1;
            else
                console.log("rm to nothing in Child color");
        }

    } else {
    	/** Add part*/
        if (myhtml > 1 || index>-1) {
            console.log("Add : has prv values in main color :" + myhtml + " Child color : " + qtyobj.value);
            if (qtyobj.value > 0)
                myhtml = myhtml + parseInt(qtyobj.value);
            else
                console.log("add to nothing in Child color");
        } else {
            console.log("Add : no prv values in main color : " + myhtml + " Child color : " + qtyobj.value);
            if (qtyobj.value > 0)
                myhtml = myhtml + parseInt(qtyobj.value) - 1;
            else
                console.log("add to nothing in Child color");
        }
    }
    if (parseInt(myhtml) <1) {
        myhtml = 1;
    }
    doc.innerHTML = myhtml;
}

/**
 * 
 * @param array
 * @param Keyword
 */
function dataChiledarrayremove(Keyword){
	index =arrayindex(dataChiledColor,Keyword)
	console.log(Keyword+ ": indx : "+index);	
	if(index>=0){
		dataChiledColor.splice(index,1);
		return true;
	}
	else{
		console.log("Nothing to remove in array");
		return false;
	}
}


/**
 * 
 * @param id (number)
 * @param maincolor NAME
 * @param type Q means Quantity C means Color
 */
var tempcolor=null;
var temcpqty=null;
function coloronfocus(id,maincolor,type){
	//get fildes objects
	var childclr=document.getElementById("child-color-name"+maincolor+id);
	var childqty= document.getElementById("child-color-qty"+maincolor+id); 
	//if type quantity
	if(type=="Q"){
		if(childqty.value!=null && childqty.value!="" ){
		//get tempoty values 
			temcpqty=childqty.value;		
		}
		else{
			temcpqty="";
			console.log("null childqty");
		}
	}
	//if type color
	else if(type=="C"){
		if( childclr.value!=null && childclr.value!=""){
		//get tempoty values 
			tempcolor=childclr.value;	
		}
		else{
			tempcolor="";
			console.log("null childclr");
		}
	}
	else{
		console.log("Nothing");
	}
}

/**
 * 
 * @param  id (number)
 * @param maincolor
 * @param type
 * @returns {Number}
 */
function colorononblur(id,maincolor,type){
	var doc = document.getElementById('pqt' + maincolor);
	var myhtml = parseInt(doc.innerHTML);
	var childclr=document.getElementById("child-color-name"+maincolor+id);
	var childqty= document.getElementById("child-color-qty"+maincolor+id);
//if type color	
	if(type=="C"){
	//if value not null
		if(childclr.value!=null && childclr.value!=""){
		//if no changes happen to value
			if(childclr.value==tempcolor){
				console.log("Nothing Child color name are same");			
			}
			else{
				index1 =arrayindex(MainvsChiledColor,maincolor+':'+childclr.value);
				console.log(index1);	
				//if value equal to main color
				//************************************ removed BA req
				/*if(maincolor==childclr.value){
					if(tempcolor!=null){
						childclr.innerHTML="<option>"+tempcolor+"</option>";
					}
					else{
						childclr.innerHTML="";
					}
					alert("Main Color and Child color shuld not equal");
				}
				//if duplicate child color
				else */
				//*********************************
				if(index1>-1){
					if(tempcolor!=null){
						childclr.innerHTML="<option>"+tempcolor+"</option>";
					}
					else{
						childclr.innerHTML="";
					}
					alert("Duplicate Child color");
				}
				else{
					tempcolor="";
				}
			}
		}
		else{
			//if now value is null then set back to previous value 
			if(tempcolor!=null){	
				childclr.innerHTML="<option>"+tempcolor+"</option>";
			}
			else{
				childclr.innerHTML="";
			}
			alert('Null Child Color  Not Allowed');
		}
	}
	//if type quantity	
	else if(type=="Q"){
		if(childqty.value!=null && childqty.value!="" && parseInt(childqty.value)>0){
		//if no changes happen to value and not equal default qty
			if(childqty.value==temcpqty && temcpqty>1){
				console.log("Nothing to do same color Qty");
			}
			else{				
				temcpqty="";
			}
		}
		else{
			if( temcpqty!=null){
			//set to priveous value
				childqty.value=temcpqty;
			}
			else{
				alert('Null Quantity Not Allowed');
			}
		}
	}	
	//change value in main color qty
	
	
}
//
		

/**
 * 
 * @param id
 * @param maincolor
 */
 //MainvsChiledColor
 //dataChiledColor
function add_color(id,maincolor){
	var doc = document.getElementById('pqt' + maincolor);
	var myhtml = parseInt(doc.innerHTML);
	var childclrobj=document.getElementById('child-color-name'+maincolor+id)
	var childclrname=childclrobj.value;
	var clrpqtyobj=document.getElementById('child-color-qty'+maincolor+id) ;
	console.log("Main color " +maincolor +" main color qty "+myhtml );
	index1 =arrayindex(MainvsChiledColor,maincolor+':'+childclrname);
	index2 =arrayindex(dataChiledColor,dataChiledColor[index1]);
	
	if(childclrname!=null && childclrname!="" && clrpqtyobj.value!=null && clrpqtyobj.value!=""){
		var clrpqty=parseInt(clrpqtyobj.value);
		if(clrpqty>0){
			//************************** removed BA req
			//if( childclrname!=maincolor ){
			if( index1<0 || childclrname == document.getElementById('cl'+maincolor+id).innerHTML){
					var index=-1;
					Keyword=maincolor +":" ;
					for(var k=0;k<MainvsChiledColor.length;k++){
						console.log(MainvsChiledColor[k]);
						index=MainvsChiledColor[k].indexOf(Keyword);
						if(index>-1){
							k=MainvsChiledColor.length
						}
					}
					console.log("is this is 1st child "+index);
					if(index==-1){
						myhtml=parseInt(myhtml)-1;
						console.log(" 1st child "+myhtml);
					}
					else{
						console.log("not 1st child "+myhtml);
					}
					if(parseInt(myhtml)<0){
						myhtml=0;
					}					
					console.log("is this is editmode "+index1);
					if(index1>-1){
						console.log("edit child ");
						var qty= dataChiledColor[index1].split(":");
						console.log("not new child color "+dataChiledColor[index1]+" main pqty "+myhtml+ " child pqty befor" +qty[2] +" Main vs Ch "+MainvsChiledColor[index1]);
						myhtml = parseInt(myhtml) - parseInt(qty[2]);
						if(dataChiledarrayremove(dataChiledColor[index1])){
							icColor--;
							MainvsChiledColor.splice(index1,1);
							MinColor--;
							console.log("remove child "+dataChiledColor[index1]);
							console.log("remove Mvschild "+MainvsChiledColor[index1]);
						}
					}
					else{
						console.log("new child ");
					}
					document.getElementById('cl'+maincolor+id).innerHTML=childclrname;
					document.getElementById('clpqt'+maincolor+id).innerHTML='Pack Qty : '+clrpqty ;
					myhtml = parseInt(myhtml) + clrpqty;
					var indx=addchildtoarray(maincolor,childclrname,clrpqty);
					doc.innerHTML = myhtml;
					console.log("new child index "+ indx);
					
				}
				else{
					alert("Duplicate Child color");
					return false;
				}
			//******************************** removed BA req
		//	}
			//else{
			//	alert("Child color is not equal to main color ");
				//return false;
		//	}
			//*********************
		}
		else{
			alert("Pack quantity should greater than 0");
			return false;
		}
	}
	else{
		alert("Null value Not allowed");
		return false;
	}
				
	 
}

/** 
 * 
 * @param Maincolor
 * @param childecolor
 * @param pack quantity
 */
function addchildtoarray(Maincolor,childecolor,pqty){
	Keyword=Maincolor +":"+childecolor +':'+pqty;
	index =arrayindex(dataChiledColor,Keyword);
	console.log(Keyword+":  _ "+icColor +"_ & "+index);
	console.log(dataChiledColor);
	if(index<0){
		console.log(icColor);
		dataChiledColor[icColor]=Keyword;
		icColor++;
	}
	Keyword=Maincolor +":"+childecolor ;
	index =arrayindex(MainvsChiledColor,Keyword);
	if(index<0){
		console.log(MinColor);
		MainvsChiledColor[MinColor]=Keyword;
		MinColor++;
	}
	console.log(dataChiledColor);
	console.log(MainvsChiledColor);
	return index;
}
/**
 * 
 * @param maincol maincolor
 */
function removedbymaincolor(maincol){
	var colenth=dataChiledColor.length;
	console.log("Child color lenth : "+colenth);
	var temparray=new Array();
	var tempcol=0;
	for(var i=0; i<colenth;i++){
		temparray[i]=dataChiledColor[i].split(":");
	}
	console.log(temparray);
	for(var i=0; i<dataChiledColor.length;i++){
		Keyword=maincol+":"+temparray[i][1]+":"+temparray[i][2];
		index =arrayindex(dataChiledColor,Keyword)
		console.log("Sch : " +Keyword+ ": indx : "+index);
		if(index>=0){
			console.log("Removed"+temparray[i][1]);
			dataChiledColor.splice(index,1);
			icColor--;
			i=0;
		}
		else{
			console.log("Nothing to remove in array");
		}
	}
}



/**
 * 
 * @param id
 * @returns {Boolean}
 */
function removecolor(id){
	var bool1=gridVsColor(id);
	console.log(bool1);
	if(bool1){
		var  index =arrayindex(MainvsChiledColor.toString().toUpperCase(),id.toUpperCase()+":");
		console.log(MainvsChiledColor.toString() + " " +index + " " + id.toUpperCase()+":");
		if(index>-1){
			alert("Please Remove Child colors in "+ id.toUpperCase() +" !");
			return false;
		}
		else{
			return true;
		}
	}
	else
		alert("Please deselect Main color "+ id.toUpperCase() +"in Dimension Matrix !");
		return false;
    
} 


function gridVsColor(id){
	var checkedMatches = new Array();
    $(".matcheck:checked").each(function() {
        checkedMatches.push(this.value);
    });
    for (var i = 0; i < checkedMatches.length; i++) {
    	 index =arrayindex(checkedMatches[i].toString().toUpperCase(),id.toUpperCase()+":");
    	 if(index>-1){
    		 console.log(checkedMatches[i].toString().toUpperCase() + " + " + id.toUpperCase() + "- "+ index);
    		 return false;
    	 }
    	 else{
    		 console.log(checkedMatches[i].toString().toUpperCase() + " + " + id.toUpperCase() + "- "+ index); 
    	 }
	}
    return true;
}




function  deleteStyle(url){
	url="mststylemasterview?delete=true&"+url;
	window.location.replace(url);
}

function deletconformStyle(styleId,locationCode,compCode,custCode,depCode){
	url="delete=true&id.styleId="+styleId+"&id.locationCode="+locationCode+"&id.compCode="+compCode+"&id.custCode="+custCode+"&id.depCode="+depCode+"";
	console.log(url);
	var success=AjaxCall('POST',url,'mststyleheaderform');
	if (success.readyState == 4 && success.status == 200) {
		locationCode = getvalue(locationCode);
		custCode = getvalue(custCode);
		depCode = getvalue(depCode);
		styleId = getvalue(styleId);
		compCode=getvalue(compCode);
		var jsnroot;
		
		jsnroot = AjaxCall("POST", "", "services/api/mststyleheader/StylesAllparam/"+locationCode+"/"+compCode+"/"+custCode+"/"+depCode+"/"+styleId+".json");
		if (jsnroot.readyState == 4 && jsnroot.status == 200) {
			jsnroot = JSON.parse(jsnroot.responseText);
			if(styleId==jsnroot.id.styleId){
				alert("This style is used for other purpose Please remove that relation before proceeding ");
			}
			else {
				alert("Deleted");	
			}
		} 
		else {
			console.log("Somethings Wrong");
		}
		window.location.replace('mststyleheaders');
	}
	else {
		alert("Somethings Wrong");
	}
	
}
function removestylepic( picCode, styleId, locationCode, compCode, custCode, depCode,bool){
	/*
	 * index =arrayindex(dataChiledColor,Keyword)
			dataChiledColor.splice(index,1);
	 */
	if(!bool){
		var formdata = jQuery("#mststyleheaderform").serialize();
		formdata=formdata+"&delete=true&deletePic=true&picCode="+picCode;
		console.info(formdata);
		var xmilobj=AjaxCall("POST", formdata, "mststyleheaderform");
		if (xmilobj.readyState == 4 && xmilobj.status == 200) {
			console.log("Done");
		} else {
			console.log("some things wrong");
		}
	}
	
	var index = arrayindex(dataImg,picCode);
	console.log("index is "+index);
	dataImg.splice(index,1);
	toggle_visibility("pic-"+picCode);
	document.getElementById("pic-"+picCode).style.display="none";
}


/**
 * 
 * @param p
 * @returns {Boolean}
 */
function viewPages(p){
	if(p=="P1"){
		$('#step-1').show();
		$('#step-2').hide();
		$('#step-3').hide();
	}
	if(p == "P2") {
		 success = $('#mststyleheaderform').valid();
		 var formdata = jQuery("#mststyleheaderform").serialize();
		 var userId=document.getElementById('userId').value;

		 if(success){
			 
			 formdata += '&section=Section01';
			 formdata += '&dataImg='+dataImg;
			
			var success=  AjaxCall("POST", formdata, "mststyleheaderform");
			if (success.readyState == 4 && success.status == 200) {
				//console.log(success.responseText);
				$('#id_styleId').attr('readonly', true);
				$('#id_locationCode').attr('readonly', true);
				$('#id_depCode').attr('readonly', true);
				$('#id_custCode').attr('readonly', true);
        	   	$('#id_compCode').attr('readonly', true);
        	   	$('#error-win').hide();
        	   	
        	   	$('#step-1').hide();
        	   	document.getElementById('step2-btn').className="active";
        	   	$('#step-2').show();
        	   	$('#step-3').hide();
			}
			else{
				alert("Some things wrong")
				location.reload();
			}
		 }
		 else{
			 $('#error-win').show();
			 console.info(success);
		 }
	}
	if(p == "P3"){
		if(dataComponent.length>0){
			var formdata = jQuery("#mststyleheaderform").serialize();
			formdata += '&section=Section02';
			formdata += '&dataCcolor='+dataChiledColor;
	        formdata += '&dataComponent='+dataComponent;
	        formdata += '&colors='+dataCol;
			
	        var success=  AjaxCall("POST", formdata, "mststyleheaderform");
			if (success.readyState == 4 && success.status == 200) {
				$('#step-1').hide();
				$('#step-2').hide();
				$('#step-3').show();
				document.getElementById('step3-btn').className="active";
			}
			else{
				alert("Some things wrong")
				location.reload();
			}
		} 
		else{
			 $('#error-win').show();
			alert("Please add at least one component");
		 }
	}
	if(p == "P2-Back"){
		$('#step-1').hide();
		$('#step-3').hide();
		$('#step-2').show();
	}
	return false;
}
/**
 * 
 * @param frmId formID in form
 * @param url url need to submit
 */
function saveStyleMaster(frmId,url) {
            
    var checkedMatches = [];
    $(".matcheck:checked").each(function() {
        checkedMatches.push(this.value);
    });
    if(checkedMatches.length == 0){
    	alert("Please make size fit dimension grid");
    	return;
    }
    /** Required filed id (id.name)*/
    var idarray=["styleId","locationCode","depCode","custCode","compCode"];
    var valuearray=new Array();
    var styleurl="";
    for(var k=0;k<5;k++){
        valuearray[k]=document.getElementById("sid_"+idarray[k]).value;
        styleurl=styleurl+""+idarray[k]+"="+valuearray[k];
        if(k<4){
            styleurl=styleurl+"&";
        }
    }
   
    var formdata = jQuery("#"+frmId).serialize();
    try{
    	
        formdata += '&matrix='+checkedMatches;
        formdata += '&horizontal='+valuesSize;
        formdata += '&vertical='+valuesFit;
        formdata += '&dimension='+dimension;
        formdata += '&section=Section03';
        formdata += '&dimensionRemove='+dimensionRemove;
        formdata += '&horizontalRemove='+horizontalRemove;
        formdata += '&verticalRemove='+verticalRemove;
        formdata += '&matrixRemove='+matrixRemove;
    }
    catch (e){
        console.log(e);
    }

    var success=AjaxCall("POST", formdata, url)
    if(success.readyState ==4 && success.status== 200){
    	location.replace("mststylemasterview?"+styleurl);
    }
   /* $.ajax({
           type: "POST",
           url: url,
           data: formdata,
           success: function(data) {
               //location.replace("mststylemasterview?"+styleurl);
           }
       });*/
    
}
/**
 * reset Img order
 */
function savepicsequence(){
	console.log(dataImg);
	dataImg=productOrder;
	console.log(dataImg);
}

/**
 * 
 * @param actual
 * @returns {Array}
 */
function cleanArray(actual){
	var newArray = new Array();
	for(var i = 0; i<actual.length; i++){
      if (actual[i]){
	 actual[i]=actual[i].replace("pic-", "");
        newArray.push(actual[i]);
    }
  }
  return newArray;
}