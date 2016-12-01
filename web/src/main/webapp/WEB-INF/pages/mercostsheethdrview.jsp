<%@ include file="/common/taglibs.jsp" %>
    <script src="scripts/applicationjs/mercostsheethdr.js"></script>
    
    <head>
        <title>
            <fmt:message key="mercostsheethdrDetail.title" />
        </title>
        <meta name="heading" content="<fmt:message key='mercostsheethdrDetail.heading'/>" />
    </head>

    <c:set var="delObject" scope="request">
        <fmt:message key="mercostsheetshdrList.mercostsheethdr" />
    </c:set>
    <script type="text/javascript">
        var msgDelConfirm ="<fmt:message key="delete.confirm"><fmt:param value="$ {delObject}"/></fmt:message>";
    </script>
    

<div class="row form-group paddingleft20"> <!-- NAVIGATION PILLS -->
    <div class="col-xs-7"><h2>Final Cost Sheet</h2></div>
</div>
    
<div class="row paddingleft20">
				<form method="get" action="${ctx}/mercostsheethdrview" id="searchForm" class="form-inline">
					<div class="col-sm-4 col-md-4 ">
						<div class="form-group formwithsearch marginbottom20">
							<div class="icon-addon addon-md">
								<label for="exampleInputEmail1">Buyer </label>
								<select required="required"  name="custCode" id="cs_id_custCode" onfocus="getOptions('cs_id_custCode','mstcustomer')" class="form-control" >
										<c:if test="${mststyleheader.id.custCode!=null}">
											<option selected="selected">${mststyleheader.id.custCode}</option>
										</c:if>
										<c:if test="${mststyleheader.id.custCode ==null}">
											<c:if test="${param.custCode !=null}">
												<option selected="selected">${param.custCode}</option>
											</c:if>
											<c:if test="${param.custCode ==null}">
												<c:forEach items="${mstparam}" var="mstparams">	
														<option selected="selected">${mstparams.commonCompCode}</option>
												</c:forEach>
											</c:if>
										</c:if>
								</select>								
							</div>
                           <div class="feedback"></div>
						</div>  
						<div class="btn-group formsearchbtn btn-model-select-div">
							<button onclick="$('#cs_id_custCode').trigger('onfocus'); addmodalpopup('cs_id_custCode')" type="button" class="btn btn-primary btn-xs dropdown-toggle " data-toggle="modal" data-target="#schmodalpopup" ><span class="glyphicon glyphicon-search"></span></button>
						</div>
						<div class="clearfix"></div> 
						<div class="form-group formwithsearch marginbottom20">
							<div class="icon-addon addon-md">
								<label for="exampleInputEmail1">Style Location</label>
								<select required="required"  name="locationCode" id="cs_id_locationCode" class="form-control" onfocus="getOptions('cs_id_locationCode','mstlocations')"> 
									<c:if test="${mststyleheader.id.locationCode!=null}">
											<option selected="selected">${mststyleheader.id.locationCode}</option>
									</c:if>
									<c:if test="${mststyleheader.id.locationCode ==null}">
										<c:if test="${param.locationCode!=null}">
											<option selected="selected">${param.locationCode}</option>
										</c:if>
										<c:if test="${param.locationCode ==null}">
											<c:forEach items="${mstparam}" var="mstparams">	
													<option selected="selected">${mstparams.locationCode}</option>
											</c:forEach>
										</c:if>
									</c:if>
								</select>								
							</div>
                          <div class="feedback"></div>
						</div>  
						<div class="btn-group formsearchbtn btn-model-select-div">
							<button onclick="$('#cs_id_locationCode').trigger('onfocus'); addmodalpopup('cs_id_locationCode')" type="button" class="btn btn-primary btn-xs dropdown-toggle " data-toggle="modal" data-target="#schmodalpopup" ><span class="glyphicon glyphicon-search"></span></button>
						</div>
						<div class="clearfix"></div> 
					</div>	
					<div class="col-sm-4 col-md-4 ">
						<div class="form-group formwithsearch marginbottom20">
							<div class="icon-addon addon-md">
								<label for="exampleInputEmail1">Buyer Department</label>
								<select required="required" type="text" name="depCode" id="cs_id_depCode" onfocus="optionsforgencodes('cs_id_depCode','BUYDEM')" class="form-control" >
										<c:if test="${mststyleheader.id.depCode!=null}">
											<option selected="selected">${mststyleheader.id.depCode}</option>
										</c:if>
										<c:if test="${mststyleheader.id.depCode ==null}">
											<option selected="selected">${param.depCode}</option>
										</c:if>
								</select>							
							</div>
                          <div class="feedback"></div>
						</div>  
						<div class="btn-group formsearchbtn btn-model-select-div">
							<button onclick="$('#cs_id_depCode').trigger('onfocus'); addmodalpopup('cs_id_depCode')" type="button" class="btn btn-primary btn-xs dropdown-toggle " data-toggle="modal" data-target="#schmodalpopup" ><span class="glyphicon glyphicon-search"></span></button>
						</div>
						<div class="clearfix"></div> 
						<div class="form-group formwithsearch marginBottom20">
							<div class="icon-addon addon-md">
								<label for="exampleInputEmail1">Style</label>
								<div class="input-group">
									<c:if test="${mststyleheader.id.styleId!=null}">
										<input required="required" type="text" name="styleId" id="cs_id_styleId"  class="form-control" class="typeahead form-control" data-provide="typeahead" value='${mststyleheader.id.styleId}' onfocus="typaheadforStyle('cs_id_styleId','id.styleId')" >
									</c:if>
									<c:if test="${mststyleheader.id.styleId ==null}">
										<input required="required" type="text" name="styleId" id="cs_id_styleId"  class="form-control" class="typeahead form-control" data-provide="typeahead" value='${param.styleId}' onfocus="typaheadforStyle('cs_id_styleId','id.styleId')" >
									</c:if>
									<span class="caret dropdowncaret dropdowncaret-withbuttoneye"></span>
									<span class="input-group-btn">
										<a class="btn btn-info buttonwithEye " id="buttonwithEye" target="_blank" onclick="openstyle()" data-toggle="tooltip" data-placement="bottom" title="View Style">
											<span class="glyphicon glyphicon-eye-open"></span>
										</a>
									</span>
								</div><!-- /input-group    -->
							</div>
                          <div class="feedback"></div>
						</div>  
						<div class="btn-group formsearchbtn btn-model-select-div">
							<button onclick="addmodalpopup('cs_id_styleId')" type="button" class="btn btn-primary btn-xs dropdown-toggle " data-toggle="modal" data-target="#schmodalpopup" ><span class="glyphicon glyphicon-search"></span></button>
						</div>
						<div class="clearfix"></div> 		
					</div>	
					<div class="col-sm-4 col-md-4 ">
						<div class="form-group formwithsearch marginbottom20">
							<div class="icon-addon addon-md">
								<label for="exampleInputEmail1">Company</label>
								<select  required="required"  name="compCode" id="cs_id_compCode" onfocus="getOptions('cs_id_compCode','mstcompany')" class="form-control" >
										<c:if test="${mststyleheader.id.compCode!=null}">
											<option selected="selected">${mststyleheader.id.compCode}</option>
										</c:if>
										<c:if test="${mststyleheader.id.compCode ==null}">
											<option selected="selected">${param.compCode}</option>
										</c:if>
								</select>								
							</div>
                        <div class="feedback"></div>
						</div>  
						<div class="btn-group formsearchbtn btn-model-select-div">
							<button onclick="$('#cs_id_compCode').trigger('onfocus'); addmodalpopup('cs_id_compCode')" type="button" class="btn btn-primary btn-xs dropdown-toggle " data-toggle="modal" data-target="#schmodalpopup" ><span class="glyphicon glyphicon-search"></span></button>
						</div>
						<div class="clearfix"></div>
					</div>
					<div class="col-sm-4 col-md-4 ">
						<div class="form-group formwithsearch marginbottom20">
							<div class="icon-addon addon-md">
								<label for="exampleInputEmail1">Style Description</label>
								<c:if test="${mststyleheader.styleDescription!=null}">
									<input  type="text" name="styleDescription" id="cs_styleDescription" value='${mststyleheader.styleDescription}' class="form-control" readonly="readonly">
								</c:if>
								<c:if test="${mststyleheader.styleDescription ==null}">
									<input  type="text" name="styleDescription" id="cs_styleDescription" value='${param.styleDescription}' class="form-control" readonly="readonly">
								</c:if>
							</div>
                          <div class="feedback"></div>
						</div>  
						<div class="clearfix"></div>
					</div>	       
					<div class="col-sm-4 col-md-4">
						<div class="form-group formwithsearch marginbottom20">
							<div class="icon-addon addon-md">
								<label for="exampleInputEmail1">Season</label>
								<select required="required"  name="season" id="cs_season" class="form-control" onfocus="optionsforgencodes('cs_season','SEASON')" >
									<c:if test="${mercostsheethdr.season!=null}">
										<option selected="selected">${mercostsheethdr.season}</option>
									</c:if>
									<c:if test="${mercostsheethdr.season ==null}">
										<option selected="selected">${param.season}</option>
									</c:if>
								</select>								
							</div>
                          <div class="feedback"></div>
						</div>  
						<div class="btn-group formsearchbtn btn-model-select-div">
							<button onclick="$('#cs_season').trigger('onfocus'); addmodalpopup('cs_season')" type="button" class="btn btn-primary btn-xs dropdown-toggle " data-toggle="modal" data-target="#schmodalpopup" ><span class="glyphicon glyphicon-search"></span></button>
						</div>
						<div class="clearfix"></div> 			  
					</div>
					
					 <div class="col-sm-4 col-md-4">
					     <div class="form-group formwithsearch marginbottom20">
					         <div class="icon-addon addon-md">
					             <label for="exampleInputEmail1">Cost Sheet No.</label>
					             <select name="versionNo" id="versionNo" class="form-control" >
									<c:if test="${mercostsheethdr.id.versionNo!=null}">
										<option selected="selected">${mercostsheethdr.id.versionNo}</option>
									</c:if>
									<c:if test="${mercostsheethdr.id.versionNo ==null}">
										<option selected="selected">${param.versionNo}</option>
									</c:if>
								</select>
					         </div>
					     </div>
					     <div>
					     </div>
					     <div class="clearfix"></div>
					 </div>	
					 				
					<div class="col-sm-4 col-md-4">
						<button type="submit" name="costsheet" class="btn btn-info btn-embossed search-routes-btn"><span class="glyphicon glyphicon-search"></span>   Search FCS</button>
						<button type="button"  class="reset  replace-data btn btn-defalt btn-embossed search-routes-btn"><span class="glyphicon glyphicon-refresh"></span>  Reset</button>
					</div>
                     <div class="col-sm-4 col-md-4">&nbsp;</div>
				</form>
            </div>
            

<div class="row paddingleft20">
<div class="col-sm-12 col-md-12">
<div class="panel-group" id="stylebrowser">
<div class="panel panel-default">
<div class="panel-heading" data-toggle="collapse" data-parent="#stylebrowser"
     data-target="#styleBrowserBody">
    <h4 class="panel-title">
        <a data-toggle="collapse" data-parent="#stylebrowser" href="#styleBrowserBody">
        </a><a class="accordion-toggle"> <span
            class="pull-right slideupdowntoggle glyphicon glyphicon-chevron-up"></span>Final Cost Sheet
        General Details</a>
    </h4>
</div>
<div id="styleBrowserBody" class="panel-collapse collapse" style="height: auto;">
<div class="panel-body">

<div class="col-sm-2 col-md-2 col-xs-2 pull-right padding0 ">
    <a href="#" class="editSectionLink pull-right"><span class="glyphicon glyphicon-edit marginRighgt6"></span>Edit Section</a>
</div>

<div class="row marginTop40">

    <div class="col-sm-4 col-md-4 col-xs-4 padding0">
        <div class="col-sm-6 col-md-6 col-xs-6 textAlignLeft">
            <span class="typeHeading">Final Cost Sheet Type:</span>
        </div>

        <div class="col-sm-6 col-md-6 col-xs-6 padding0">
            <span>${mercostsheethdr.id.costSheetType}</span>

        </div>
    </div>

    <div class="col-sm-4 col-md-4 col-xs-4 padding0">
        <div class="col-sm-6 col-md-6 col-xs-6 textAlignLeft">
            <span class="typeHeading">Final Cost Sheet No:</span>
        </div>

        <div class="col-sm-6 col-md-6 col-xs-6 padding0">
            <span>${mercostsheethdr.id.costSheetNo}</span>
        </div>
    </div>

    <div class="col-sm-4 col-md-4 col-xs-4 padding0">
        <div class="col-sm-6 col-md-6 col-xs-6 textAlignLeft date_final_cost_sheet">
            <span class="typeHeading">Date:</span>
        </div>

        <div class="col-sm-6 col-md-6 col-xs-6 padding0">
            <span>${mercostsheethdr.createDate}</span>
        </div>
    </div>

</div>

<div class="row ">

    <div class="col-sm-4 col-md-4 col-xs-4 padding0">
        <div class="col-sm-6 col-md-6 col-xs-6 textAlignLeft">
            <span class="typeHeading">Merchandiser</span>
        </div>

        <div class="col-sm-6 col-md-6 col-xs-6 padding0">
            <span>${mercostsheethdr.merchandiser}</span>

        </div>
    </div>

    <div class="col-sm-4 col-md-4 col-xs-4 padding0">
        <div class="col-sm-6 col-md-6 col-xs-6 textAlignLeft">
            <span class="typeHeading">Current Version:</span>
        </div>

        <div class="col-sm-6 col-md-6 col-xs-6 padding0">
            <span>${mercostsheethdr.id.versionNo}</span>
        </div>
    </div>

    <div class="col-sm-4 col-md-4 col-xs-4 padding0">
        <div class="col-sm-6 col-md-6 col-xs-6 textAlignLeft date_final_cost_sheet">
            <span class="typeHeading">Order Qty:</span>
        </div>

        <div class="col-sm-6 col-md-6 col-xs-6 padding0">
            <span>${mercostsheethdr.orderQty}</span>
        </div>
    </div>

</div>

<div class="row ">

    <div class="col-sm-4 col-md-4 col-xs-4 padding0">
        <div class="col-sm-6 col-md-6 col-xs-6 textAlignLeft">
            <span class="typeHeading">Component wise Costing: </span>
        </div>

        <div class="col-sm-6 col-md-6 col-xs-6 padding0">
			<c:if test="${mercostsheethdr.compWiseCost == true}">
            	<span>YES</span>
            </c:if>
            <c:if test="${mercostsheethdr.compWiseCost == false || mercostsheethdr.compWiseCost == null}">
            	<span>NO</span>
            </c:if>
        </div>
    </div>

    <div class="col-sm-4 col-md-4 col-xs-4 padding0">
        <div class="col-sm-6 col-md-6 col-xs-6 textAlignLeft">
            <span class="typeHeading">Costing Method </span>
        </div>

        <div class="col-sm-6 col-md-6 col-xs-6 padding0">
        	<c:if test="${mercostsheethdr.averageWiseCost == true}">
            	<input class="marginTop6 pull-left" type="checkbox" disabled="disabled" checked="checked"><label for="check1"
            	class="pull-left marginTop-3 marginLeft7">Average</label>
            </c:if>
            <c:if test="${mercostsheethdr.averageWiseCost == false || mercostsheethdr.averageWiseCost == null}">
            	<input class="marginTop6 pull-left" type="checkbox" disabled="disabled"><label for="check1"
            	class="pull-left marginTop-3 marginLeft7">Average</label>
            </c:if>
            
            <div class="clearfix"></div>
            <c:if test="${mercostsheethdr.sizeWiseCost == true}">
            	<input class="marginTop6 pull-left" type="checkbox" disabled="disabled" checked="checked"><label for="check2"
				class="pull-left marginTop-3 marginLeft7">Size Wise</label>
            </c:if>
            <c:if test="${mercostsheethdr.sizeWiseCost == false || mercostsheethdr.sizeWiseCost == null}">
            	<input class="marginTop6 pull-left" type="checkbox" disabled="disabled"><label for="check2"
				class="pull-left marginTop-3 marginLeft7">Size Wise</label>
            </c:if>

            <div class="clearfix"></div>
            <c:if test="${mercostsheethdr.countryWiseCost == true}">
            	<input class="marginTop6 pull-left" type="checkbox" disabled="disabled" checked="checked"><label for="check3" 
            	class="pull-left marginTop-3 marginLeft7">Country Wise</label>
            </c:if>
            <c:if test="${mercostsheethdr.countryWiseCost == false || mercostsheethdr.countryWiseCost == null}">
            	<input class="marginTop6 pull-left" type="checkbox" disabled="disabled"><label for="check3" 
            	class="pull-left marginTop-3 marginLeft7">Country Wise</label>
            </c:if>
            
        </div>
    </div>

</div>

<div class="row">
    <div class="col-md-12"><h3 class="add-styl-rt">Currency Details</h3>
        <hr>
    </div>
</div>

<div class="row ">

    <div class="col-sm-4 col-md-4 col-xs-4 padding0">
        <div class="col-sm-6 col-md-6 col-xs-6">
            <span class="typeHeading">Cost Sheet Currency:</span>
        </div>

        <div class="col-sm-6 col-md-6 col-xs-6 padding0">
            <span>${mercostsheethdr.costSheetCurrency.curCode}</span>
        </div>
    </div>

    <div class="col-sm-4 col-md-4 col-xs-4 padding0">
        <div class="col-sm-6 col-md-6 col-xs-6">
            <span class="typeHeading">Exchange Rate:</span>
        </div>

        <div class="col-sm-6 col-md-6 col-xs-6 padding0">
            <span>${mercostsheethdr.costSheetExchangeRate}</span>
        </div>
    </div>


</div>

<div class="row ">

    <div class="col-sm-4 col-md-4 col-xs-4 padding0">
        <div class="col-sm-6 col-md-6 col-xs-6">
            <span class="typeHeading">Default RM Currency:</span>
        </div>

        <div class="col-sm-6 col-md-6 col-xs-6 padding0">
            <span>${mercostsheethdr.dftRmCurrency.curCode}</span>
        </div>
    </div>

    <div class="col-sm-4 col-md-4 col-xs-4 padding0">
        <div class="col-sm-6 col-md-6 col-xs-6">
            <span class="typeHeading">Exchange Rate:</span>
        </div>

        <div class="col-sm-6 col-md-6 col-xs-6 padding0">
            <span>${mercostsheethdr.dftRmExchangeRate}</span>
        </div>
    </div>


</div>

<div class="row ">
    <div class="col-sm-12 col-md-12">
        <div class="dataTables_wrapper">
            <section>
                <table id="route" class="display table table-striped table-bordered" cellspacing="0">
                    <thead>
                    <tr>
                        <th class="textcenter">Currency Code</th>
                        <th class="textcenter">Rate (to convert to CS currency)</th>
                    </tr>
                    </thead>
                    <tbody>

					<c:forEach items="${mercostsheethdrcurrencyList}" var="currency">
						<tr class="gradeX">
                        <td class="textcenter">
                            ${currency.id.currencyCode}
                        </td>
                        <td class="textcenter">
                            ${currency.exchangeRate}
                        </td>
                    </tr>
					</c:forEach>
					
                    </tbody>
                </table>
            </section>
        </div>
    </div>
</div>

<div class="row ">

    <div class="col-md-12"><h3 class="add-styl-rt">Size Dimention Combinations</h3>
        <hr>
    </div>
</div>

<div class="row">
    <div class="col-md-12 normal">
    	<div id="grid"></div>
        
    </div>

</div>


</div>
<!-- end of pannel body -->

</div>
</div>
</div>

</div>
<!-- end of panel contain col-sm-12 col-md-12 div -->
</div>

<div class="row paddingleft20">
    <div class="col-sm-12 col-md-12">
        <div class="panel-group" id="createGroups">
            <div class="panel panel-default">
                <div class="panel-heading" data-toggle="collapse" data-parent="#creatG" data-target="#creatG">
                    <h4 class="panel-title">
                        <a data-toggle="collapse" data-parent="#createGroups" href="#creatG">
                        </a><a class="accordion-toggle"> <span
                            class="pull-right slideupdowntoggle glyphicon glyphicon-chevron-up"></span>Available Groups</a>

                    </h4>
                </div>
                <div id="creatG" class="panel-collapse collapse " style="height: auto;">
                    <div class="panel-body">

                        <div class="row">

                            <div class="col-sm-2 col-md-2 col-xs-2 pull-right  ">
                                <a href="#" class="editSectionLink pull-right"><span
                                        class="glyphicon glyphicon-edit marginRighgt6"></span>Edit Section</a>
                            </div>
                        </div>
                        <div class="row">

                            <div class="col-sm-12 col-md-12">
                                <div class="dataTables_wrapper">
                                    <section>
                                    	<div id="groupGridView"></div>
                                    </section>
                                </div>
                            </div>
                        </div>
                        <!--  row ends  -->

                    </div>
                    <!-- panel body end  -->


                </div>

            </div>
        </div>
    </div>

</div>

<div class="row paddingleft20">
    <div class="col-sm-12 col-md-12">
        <div class="panel-group" id="createGroups3">
            <div class="panel panel-default">
                <div class="panel-heading" data-toggle="collapse" data-parent="#creatG3" data-target="#creatG3">
                    <h4 class="panel-title">
                        <a data-toggle="collapse" data-parent="#createGroups3" href="#creatG3">
                        </a><a class="accordion-toggle"> <span
                            class="pull-right slideupdowntoggle glyphicon glyphicon-chevron-up"></span>Raw Material
                        Attached for groups</a>

                    </h4>
                </div>
                <div id="creatG3" class="panel-collapse collapse" style="height: auto;">
                    <div class="panel-body">

                        <div class="row">

                            <div class="col-sm-2 col-md-2 col-xs-2 pull-right  ">
                                <a href="#" class="editSectionLink pull-right"><span
                                        class="glyphicon glyphicon-edit marginRighgt6"></span>Edit Section</a>
                            </div>
                        </div>
                        <div class="row">

                            <div class="col-sm-12 col-md-12">
                                <div class="dataTables_wrapper">
                                    <section>
                                        <div class="col-sm-6 col-md-6 marginTop7">
											<ul class="nav nav-pills nav-pills-jq ">
												<li class="active">
													<script type="text/javascript">
														var itemtypecatogery=new Array();
													</script>
													<c:forEach items="${mstitemtypeCatogory}" var="mstitemtypecatogory">
														<a onclick="navigterowMat('${mstitemtypecatogory}','');navigterowMatGroup('${mstitemtypecatogory}','');if( !document.getElementById('compWiseCost').value && document.getElementById.value('averageWiseCost').value)getchusen()">${mstitemtypecatogory} <span class="badge" id="bage${mstitemtypecatogory}"></span></a></li><li>
														<script type="text/javascript">
															itemtypecatogery.push('${mstitemtypecatogory}');
														</script>
													</c:forEach>
												</li>
											</ul>
										</div>
                                    </section>
                                </div>
                            </div>
                        </div>
                        <!--  row ends  -->

                    </div>
                    <!-- panel body end  -->


                </div>

            </div>
        </div>
    </div>

</div>

<div class="row paddingleft20">
    <div class="col-sm-12 col-md-12">
        <div class="panel-group" id="createGroups4">
            <div class="panel panel-default">
                <div class="panel-heading" data-toggle="collapse" data-parent="#creatG4" data-target="#creatG4">
                    <h4 class="panel-title">
                        <a data-toggle="collapse" data-parent="#createGroups4" href="#creatG4">
                        </a><a class="accordion-toggle"> <span
                            class="pull-right slideupdowntoggle glyphicon glyphicon-chevron-up"></span>Size Dimention Combinations</a>

                    </h4>
                </div>
                <div id="creatG4" class="panel-collapse collapse" style="height: auto;">
                    <div class="panel-body">

                        <div class="row">

                            <div class="col-sm-2 col-md-2 col-xs-2 pull-right  ">
                                <a href="#" class="editSectionLink pull-right"><span
                                        class="glyphicon glyphicon-edit marginRighgt6"></span>Edit Section</a>
                            </div>
                        </div>
                        <div class="row">

                            <div class="col-sm-12 col-md-12">
                                <div class="dataTables_wrapper scrollxonly">
                                    <section>
                                        <table id="route" class="display table table-striped table-bordered"
                                               cellspacing="0">
                                            <thead>
                                            <tr>
                                                <th class="textcenter">Cost Sheet Type</th>
                                                <th class="textcenter">Services</th>
                                                <th class="textcenter">CM</th>
                                                <th class="textcenter">CMT</th>
                                                <th class="textcenter">Finance cost</th>
                                                <th class="textcenter">Total cost</th>
                                                <th class="textcenter">Mark up amount</th>
                                                <th class="textcenter">Buyer commission</th>
                                                <th class="textcenter">Our price</th>
                                                <th class="textcenter">External commission</th>
                                                <th class="textcenter">Selling price</th>
                                            </tr>
                                            </thead>
                                            <tbody>


                                            <tr class="gradeX">
                                                <td class="textcenter">Final Cost Sheet</td>
                                                <td class="textcenter">Lorem ipsum</td>
                                                <td class="textcenter">Lorem ipsum</td>
                                                <td class="textcenter">Lorem ipsum</td>
                                                <td class="textcenter">1234567</td>
                                                <td class="textcenter">Lorem ipsum</td>
                                                <td class="textcenter">Lorem ipsum</td>
                                                <td class="textcenter">1234567</td>
                                                <td class="textcenter">1234567</td>
                                                <td class="textcenter">1234567</td>
                                                <td class="textcenter">1234567</td>

                                            </tr>

                                            <tr class="gradeX">
                                                <td class="textcenter">Pre Cost Sheet</td>
                                                <td class="textcenter">Lorem ipsum</td>
                                                <td class="textcenter">Lorem ipsum</td>
                                                <td class="textcenter">Lorem ipsum</td>
                                                <td class="textcenter">1234567</td>
                                                <td class="textcenter">Lorem ipsum</td>
                                                <td class="textcenter">Lorem ipsum</td>
                                                <td class="textcenter">1234567</td>
                                                <td class="textcenter">1234567</td>
                                                <td class="textcenter">1234567</td>
                                                <td class="textcenter">1234567</td>

                                            </tr>

                                            <tr class="gradeX">
                                                <td class="textcenter">Varient</td>
                                                <td class="textcenter">Lorem ipsum</td>
                                                <td class="textcenter">Lorem ipsum</td>
                                                <td class="textcenter">Lorem ipsum</td>
                                                <td class="textcenter">1234567</td>
                                                <td class="textcenter">Lorem ipsum</td>
                                                <td class="textcenter">Lorem ipsum</td>
                                                <td class="textcenter">1234567</td>
                                                <td class="textcenter">1234567</td>
                                                <td class="textcenter">1234567</td>
                                                <td class="textcenter">1234567</td>

                                            </tr>


                                            </tbody>
                                        </table>
                                    </section>
                                </div>
                            </div>

                            <div class="col-sm-12 col-md-12 marginTop30">
                                <button href="#" type="button"  class="btn btn-info btn-embossed pull-right" data-toggle="modal" data-target=".drop-down-select-model2" data-backdrop="static">
                                    <span class="glyphicon glyphicon-search" ></span>
                                    Compair Pricing
                                </button>
                            </div>
                         </div>
                    </div>
                    <!-- panel body end  -->
                </div>
            </div>
        </div>
    </div>

</div>

<div class="col-sm-8 col-md-8 col-xs-8 marginTop30 marginBottom20">
    <div class="aprovedby">
        <span class="glyphicon glyphicon-ok aprovedicon"></span>
        <div class="aprovedbytitle">
            Created By: ${mercostsheethdr.createdBy}<br>
            Created On: ${mercostsheethdr.createdOn}
        </div>
    </div>
    <div class="createdby">
        <span class="glyphicon glyphicon-edit createdicon"></span>
        <div class="aprovedbytitle">
            Modified By: ${mercostsheethdr.modifiedBy}<br>
			Modified On: ${mercostsheethdr.modifiedOn} 
        </div>
    </div>
    <div class="modifiedby">
        <span class="glyphicon glyphicon-refresh modifiedicon"></span>
        <div class="aprovedbytitle">
            Approved By: <br>
			Approved On: 
        </div>
    </div>
</div>

<div id="submision" class="submit-button styl-rt-submission-btn pull-right marginRight0 marginTop30">
    <a href="mercostsheethdrs?custCode=${mststyleheader.id.custCode}&locationCode=${mststyleheader.id.locationCode}&depCode=${mststyleheader.id.depCode}
    &styleId=${mststyleheader.id.styleId}&compCode=${mststyleheader.id.compCode}&styleDescription=${mststyleheader.styleDescription}
    &season=${mercostsheethdr.season}"><button type="button" id="back3" class="btn btn-default btn-lg">Close</button></a>
    <c:if test="${param.delete !=null}">
    	<c:if test="${mercostsheethdr.flag != 'Approved'}">
			<button type="button" name="delete" onclick="delFCS()" class="btn btn-info btn-lg btn-embossed">Delete</button>
		</c:if>
		<c:if test="${mercostsheethdr.flag == 'Approved'}">
			
		</c:if>
	</c:if>
	
	<c:if test="${param.view !=null}">
		<c:if test="${mercostsheethdr.flag == 'Completed'}">
			<button type="button" name="conform" onclick="confirmFCS()" class="btn btn-info btn-lg btn-embossed">Confirm</button>
		</c:if>
	</c:if>
    
</div>


    <!-- drop-down-select-model pop up start -->
    <div class="modal fade model-popup-fix addedFCS" id="select-model" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg">
            <div class="modal-content model-popup-padding">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">x</span><span class="sr-only">Close</span>
                    </button>
                    <h5 class="modal-title">View Combinations</h5>
                </div>
                <div class="row ">
                    <div class="col-md-12">
                        <h3 class="add-styl-rt">Select Size Dimention Combinations</h3>
                        <hr>
                    </div>
                </div>
				<div id="popupGroupGrid"></div>
                <div id="submision" class="submit-button styl-rt-submission-btn pull-right marginRight0 marginTop30">
                    <a><button id="popupback3" onclick="saveMatrix();" class="btn btn-default btn-lg">Save &amp; Close</button></a>
                    <button class="btn btn-info btn-lg btn-embossed mdlclose">Close</button>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>
		<div id="popover_content_wrapper" style="display: none">
		
		</div>
    </div>
	



<script>
	countries=[];
	<c:forEach items="${mercostsheethdrcountryList}" var="country">
	countries.push("${country.id.country}");
	</c:forEach>

	components = new Array();;//["com1","com2"];
	<c:forEach items="${mststylecomponentList}" var="mststylecomponent">
		components.push("${mststylecomponent.id.componentId}");
	</c:forEach>
		
	colors = [];
	mststyledemmaps = [];
	<c:forEach items="${mststyledemmaps}" var="demmap">
		mststyledemmaps.push(["${demmap.id.mainColor}", "${demmap.id.demType1}", "${demmap.id.demType2}", "${demmap.id.demValue1}", "${demmap.id.demValue2}"]);
		colors.push("${demmap.id.mainColor}");
	</c:forEach>
	
</script>

<script>
	$('#errors').hide();
	$(document).ready(function() {
		$( ".default" ).focus(function() {
		 $('.chosen-select').trigger('chosen:updated')
		});

		generateMatrix('grid');
		showGroupGrid();
		//initComponent();
		//var day=new Date();
		/*var formdata = "costSheetNo=91&costSheetType=OGL&versionNo=0&view=true";
		$.ajax({
	         type: "POST",
	         url: "mercostsheetgroup",
	         data: formdata,
	         success: function(data) {
	        	 console.info("Success");
	        	 console.info(data);
	         },
	         error:function(data){
	        	 console.info("Error");
	        	 console.info(data);
	         }
	  });*/
		//initTemplate();
		
	});
</script>

<script>
try{
	var groups = "${groups}";
	makeGroupArray(groups);
}catch (e) {
	// TODO: handle exception
}
</script>