<%@ include file="/common/taglibs.jsp"%>
<div class="row form-group paddingleft20"> <!-- NAVIGATION PILLS -->
	<div class="col-xs-8"><h2>Pre Cost Sheet</h2></div>     
</div>  <!-- NAVIGATION PILLS END-->
<div class="tab-content"> <!-- TAB CONTENT MAIN -->
	<div class="tab-pane active" id="home">
		
		<div class="row paddingleft20">
			<form:errors path="*" cssClass="alert alert-danger alert-dismissable" element="div"/>
			<form:form commandName="merprecostsheet" method="get" action="merprecostsheetsview" cssClass="well" id="merprecostsheetsview" onsubmit="return validateMerprecostsheet(this)">
				
				<div class="col-sm-4 col-md-4 ">
					<div class="form-group formwithsearch marginbottom20">
						<div class="icon-addon addon-md">
							<label for="exampleInputEmail1">Buyer </label>
							<select required="required" type="text"  id="pcs_id_custCode" onfocus="getOptions('pcs_id_custCode','mstcustomer')" class="form-control" >
								<option selected="selected">${merprecostsheet.mststyleheader.id.custCode}</option>
							</select>						
						</div>
					</div>  
					<div class="btn-group formsearchbtn btn-model-select-div">
						<button onclick="$('#pcs_id_custCode').trigger('onfocus'); addmodalpopup('pcs_id_custCode')" type="button" class="btn btn-primary btn-xs dropdown-toggle " data-toggle="modal" data-target="#schmodalpopup" ><span class="glyphicon glyphicon-search"></span></button>
					</div>
					<div class="clearfix"></div> 
					<div class="form-group formwithsearch marginbottom20">
						<div class="icon-addon addon-md">
							<label for="exampleInputEmail1">Style Location</label>
							<select required="required" type="text" id="pcs_id_locationCode" class="form-control" onfocus="getOptions('pcs_id_locationCode','mstlocations')"> 
								<c:if test="${merprecostsheet.mststyleheader.id.locationCode!=null}">
									<option selected="selected">${merprecostsheet.mststyleheader.id.locationCode}</option>
								</c:if>
								<c:if test="${merprecostsheet.mststyleheader.id.locationCode ==null}">
									<c:forEach items="${mstparam}" var="mstparams">	
											<option selected="selected">${mstparams.locationCode}</option>
									</c:forEach>
								</c:if>
							</select>
							
						</div>
					</div>  
					<div class="btn-group formsearchbtn btn-model-select-div">
						<button onclick="$('#pcs_id_locationCode').trigger('onfocus'); addmodalpopup('pcs_id_locationCode')" type="button" class="btn btn-primary btn-xs dropdown-toggle " data-toggle="modal" data-target="#schmodalpopup" ><span class="glyphicon glyphicon-search"></span></button>
					</div>
					<div class="clearfix"></div> 
				</div>
				<div class="col-sm-4 col-md-4 ">
					<div class="form-group formwithsearch marginbottom20">
						<div class="icon-addon addon-md">
							<label for="exampleInputEmail1">Buyer Department</label>
							<select required="required" type="text"  id="pcs_id_depCode" onfocus="optionsforgencodes('pcs_id_depCode','BUYDEM')" class="form-control" >
								<option selected="selected">${merprecostsheet.mststyleheader.id.depCode}</option>
							</select>					
						</div>
					</div>  
					<div class="btn-group formsearchbtn btn-model-select-div">
						<button onclick="$('#pcs_id_depCode').trigger('onfocus'); addmodalpopup('pcs_id_depCode')" type="button" class="btn btn-primary btn-xs dropdown-toggle " data-toggle="modal" data-target="#schmodalpopup" ><span class="glyphicon glyphicon-search"></span></button>
					</div>
					<div class="clearfix"></div> 
					<div class="form-group formwithsearch marginBottom20">
						<div class="icon-addon addon-md">
							<label for="exampleInputEmail1">Style</label>
							<div class="input-group">
								<input required="required" type="text"   id="pcs_id_styleId"  class="form-control" class="typeahead form-control" data-provide="typeahead" value="${merprecostsheet.mststyleheader.id.styleId}" onfocus="typaheadforStyle('pcs_id_styleId','id.styleId')" >
								<span class="caret dropdowncaret dropdowncaret-withbuttoneye"></span>
								<span class="input-group-btn">
									<a class="btn btn-info buttonwithEye " id="buttonwithEye" target="_blank" onclick="openstyle()" data-toggle="tooltip" data-placement="bottom" title="View Style">
										<span class="glyphicon glyphicon-eye-open"></span>
									</a>
								</span>
							</div><!-- /input-group    -->
						</div>
					</div>  
					<div class="btn-group formsearchbtn btn-model-select-div">
						<button onclick="addmodalpopup('pcs_id_styleId')" type="button" class="btn btn-primary btn-xs dropdown-toggle " data-toggle="modal" data-target="#schmodalpopup" ><span class="glyphicon glyphicon-search"></span></button>
					</div> 
					<div class="clearfix"></div> 
				</div>
				<div class="col-sm-4 col-md-4 ">
					<div class="form-group formwithsearch marginbottom20">
						<div class="icon-addon addon-md">
							<label for="exampleInputEmail1">Company</label>
							<select  required="required" type="text"   id="pcs_id_compCode" onfocus="getOptions('pcs_id_compCode','mstcompany')" class="form-control" >
								<option selected="selected">${merprecostsheet.mststyleheader.id.compCode}</option>
							</select>					
						</div>
					</div>  
					<div class="btn-group formsearchbtn btn-model-select-div">
						<button onclick="$('#pcs_id_compCode').trigger('onfocus'); addmodalpopup('pcs_id_compCode')" type="button" class="btn btn-primary btn-xs dropdown-toggle " data-toggle="modal" data-target="#schmodalpopup" ><span class="glyphicon glyphicon-search"></span></button>
					</div>
					<div class="clearfix"></div>
				</div>
				<div class="col-sm-4 col-md-4 ">
					<div class="form-group formwithsearch marginbottom20">
						<div class="icon-addon addon-md">
							<label for="exampleInputEmail1">Style Description</label>
							<input  type="text"   id="pcs_styleDescription" value='<c:if test="${merprecostsheet.mststyleheader.styleDescription!=null}"> ${merprecostsheet.mststyleheader.styleDescription}</c:if><c:if test="${merprecostsheet.mststyleheader.styleDescription ==null}"> ${param.styleDescription}</c:if>' class="form-control" readonly="readonly">
						</div>
					</div>  
					<div class="clearfix"></div>
				</div>     
				<div class="col-sm-4 col-md-4">
					<div class="form-group formwithsearch marginbottom20">
						<div class="icon-addon addon-md">
							<label for="exampleInputEmail1">Season</label>
							<select required="required" type="text"   id="pcs_season" class="form-control" onfocus="optionsforgencodes('pcs_season','SEASON')" >
								<option selected="selected">${merprecostsheet.season}</option>
							</select>	
						</div>
					</div> 
					<div class="btn-group formsearchbtn btn-model-select-div">
						<button onclick="$('#pcs_season').trigger('onfocus'); addmodalpopup('pcs_season')" type="button" class="btn btn-primary btn-xs dropdown-toggle " data-toggle="modal" data-target="#schmodalpopup" ><span class="glyphicon glyphicon-search"></span></button>
					</div>
					<div class="clearfix"></div> 
				  
				</div>
				<div class="col-sm-4 col-md-4">
					<div class="form-group formwithsearch marginbottom20">
						<div class="icon-addon addon-md">
							<label for="exampleInputEmail1">Costsheet Type :</label>
							<select required="required"  type="text" name="costsheetType" id="costsheetType" class="form-control" onfocus="optionsforgencodes('costsheetType','COSTYP')" >
								<c:if test="${merprecostsheet.id.costsheetType ==null}">
									<c:forEach items="${mstparam}" var="mstparams">
										<option selected="selected">${mstparams.locationCode}</option>
									</c:forEach>
								</c:if>
								<c:if test="${merprecostsheet.id.costsheetType !=null}">
									<option selected="selected">${merprecostsheet.id.costsheetType}</option>
								</c:if>
							</select>
						</div>						
					</div>
					<div class="btn-group formsearchbtn btn-model-select-div">
						<button onclick="$('#costsheetType').trigger('onfocus'); addmodalpopup('costsheetType')" type="button" class="btn btn-primary btn-xs dropdown-toggle " data-toggle="modal" data-target="#schmodalpopup" ><span class="glyphicon glyphicon-search"></span></button>
					</div>
				</div> 
				<div class="col-sm-4 col-md-4">
					<div class="form-group formwithsearch marginbottom20">
						<div class="icon-addon addon-md">
							<label for="exampleInputEmail1">CostSheet No :</label>
							<select  required="required" type="text" name="preCostSheetNo" id="preCostSheetNo" onfocus="getOptions('preCostSheetNo','merprecostsheet')" class="form-control" >
								<c:if test="${merprecostsheet.id.preCostSheetNo!=null}">
									<option selected="selected">${merprecostsheet.id.preCostSheetNo}</option>
								</c:if>
								<c:if test="${merprecostsheet.id.preCostSheetNo ==null}">
									<option selected="selected">${param.preCostSheetNo}</option>
								</c:if>
							</select>					
						</div>
					</div>  
					<div class="btn-group formsearchbtn btn-model-select-div">
						<button onclick="$('#preCostSheetNo').trigger('onfocus'); addmodalpopup('preCostSheetNo')" type="button" class="btn btn-primary btn-xs dropdown-toggle " data-toggle="modal" data-target="#schmodalpopup" ><span class="glyphicon glyphicon-search"></span></button>
					</div>
					<div class="clearfix"></div>           
				</div>
				<div class="col-sm-4 col-md-4">
					<div class="form-group formwithsearch marginbottom20">
						<div class="icon-addon addon-md">
							<label for="exampleInputEmail1">Version No :</label>
							<select  required="required" type="text" name="versionNo" id="versionNo" onfocus="getOptions('versionNo','merprecostsheet')" class="form-control" >
								<option selected="selected">${merprecostsheet.id.versionNo}</option>
							</select>
						</div>
					</div>  
					<div class="btn-group formsearchbtn btn-model-select-div">
						<button onclick="$('#versionNo').trigger('onfocus'); addmodalpopup('versionNo')" type="button" class="btn btn-primary btn-xs dropdown-toggle " data-toggle="modal" data-target="#schmodalpopup" ><span class="glyphicon glyphicon-search"></span></button>
					</div>
					<div class="clearfix"></div>          
				</div>

				<div class="col-sm-4 col-md-4">
					<button type="submit" class="btn btn-info btn-embossed search-routes-btn"><span class="glyphicon glyphicon-search"></span> Search PCS</button>
					<button type="reset" class="btn btn-defalt btn-embossed search-routes-btn"><span class="glyphicon glyphicon-refresh"></span>Reset</button>
				</div>
			</form:form>
		</div>
		
			<div class="row paddingleft20">
				
				<div class="col-sm-12 col-md-12">
					<div class="panel-group" id="stylebrowser">
						<div class="panel panel-default">
							<div class="panel-heading" data-toggle="collapse" data-parent="#stylebrowser" data-target="#styleBrowserBody">
								<h4 class="panel-title">
									<a data-toggle="collapse" data-parent="#stylebrowser" href="#styleBrowserBody"> 
									<a class="accordion-toggle"> <span class="pull-right slideupdowntoggle glyphicon glyphicon-chevron-up"></span>Pre Cost Sheet General Details</a> </a> 
								</h4>
							</div>
							<div id="styleBrowserBody" class="panel-collapse collapse <c:if test="${merprecostsheet.id.preCostSheetNo == null}">in </c:if>">
								<div class="panel-body">					
									<div class="col-sm-2 col-md-2 col-xs-2 pull-right padding0 ">
										<a href="#" class="editSectionLink pull-right"><span class="glyphicon glyphicon-edit marginRighgt6"></span>Edit Section</a>  
									</div>
									<div class="row marginTop40">
										<div class="col-sm-4 col-md-4 col-xs-4 padding0">
											<div class="col-sm-6 col-md-6 col-xs-6 textAlignLeft pre_cost_sheet_costsheet_type_text">
												<span class="typeHeading">Cost Sheet Type:</span>
											</div>
											<div class="col-sm-6 col-md-6 col-xs-6 padding0">
												<span name="costsheetType">${merprecostsheet.id.costsheetType}</span>
											</div>
										</div>
										<div class="col-sm-4 col-md-4 col-xs-4 padding0">
											<div class="col-sm-6 col-md-6 col-xs-6 textAlignLeft pre_cost_sheet_costsheet_csn_text">
												<span class="typeHeading">Cost Sheet No:</span>
											</div>
	
											<div class="col-sm-6 col-md-6 col-xs-6 padding0">
												<span name="preCostSheetNo">${merprecostsheet.id.preCostSheetNo}</span>
											</div>
										</div>
										<div class="col-sm-4 col-md-4 col-xs-4 padding0">
											<div class="col-sm-6 col-md-6 col-xs-6 textAlignLeft pre_cost_sheet_costsheet_merchent_text">
												<span class="typeHeading">Merchandiser:</span>
											</div>
	
											<div class="col-sm-6 col-md-6 col-xs-6 padding0">
												<span>${merprecostsheet.merchandiser.userId}</span>
											</div>
										</div>       
									</div>
									<div class="row ">
										<div class="col-sm-4 col-md-4 col-xs-4 padding0">
											<div class="col-sm-6 col-md-6 col-xs-6 textAlignLeft pre_cost_sheet_costsheet_cv_text">
												<span class="typeHeading">Current Version:</span>
											</div>
											<div class="col-sm-6 col-md-6 col-xs-6 padding0">
												<span name="versionNo">${merprecostsheet.id.versionNo}</span>
	
											</div>
										</div>
										<div class="col-sm-4 col-md-4 col-xs-4 padding0">
											<div class="col-sm-6 col-md-6 col-xs-6 textAlignLeft pre_cost_sheet_costsheet_date_text">
												<span class="typeHeading">Date:</span>
											</div>
	
											<div class="col-sm-6 col-md-6 col-xs-6 padding0">
												<span>${merprecostsheet.createdOn}</span>
											</div>
										</div>
										<div class="col-sm-4 col-md-4 col-xs-4 padding0">
											<div class="col-sm-6 col-md-6 col-xs-6 textAlignLeft pre_cost_sheet_costsheet_order_text">
												<span class="typeHeading">Order Qty:</span>
											</div>
	
											<div class="col-sm-6 col-md-6 col-xs-6 padding0">
												<span>${merprecostsheet.orderQty}</span>
											</div>
										</div>       
									</div>
									<div class="row ">
										<div class="col-sm-4 col-md-4 col-xs-4 padding0">
											<div class="col-sm-6 col-md-6 col-xs-6 textAlignLeft pre_cost_sheet_costsheet_cwt_text">
												<span class="typeHeading">Component wise Costing: </span>
											</div>
	
											<div class="col-sm-6 col-md-6 col-xs-6 padding0">
												<span>${merprecostsheet.compWiseCost}</span>
											</div>
										</div>                                         
									</div>
									<div class="row">
										<div class="col-md-12"><h3 class="add-styl-rt">SMV Details</h3><hr></div>
									</div>
									<div class="row">
										<div class="col-sm-12 col-md-12">
											<div class="dataTables_wrapper Scroll-for-datatable-add-row-matirials">
												<section class="viewprecostsheet">
													<script>
														var componets=new Array();
														var cmp=0;
													</script>
													<table class="display table table-striped table-bordered" cellspacing="0"  id="mststylerouteoperationList" export="true" pagesize="25">
														<thead>
															<tr>
																<th class="textcenter">Component Id</th>
																<th class="textcenter">Product Type</th>
																<th class="textcenter">Ratio</th>
																<th class="textcenter">Route Location</th>
																<th class="textcenter">Style Route Name</th>
																<th class="textcenter">SMV</th>
																<th class="textcenter">line Efficiency</th>
																<th class="textcenter">fmv Category</th>
																<th class="textcenter">fmv</th>
																<th class="textcenter headcol3 viewprecostsheetactions">View Component wise Cost Sheet</th>
															</tr>
														</thead>
														<tbody>
															<c:forEach items="${merprecostsheetsmvList}" var="smv">
																<tr class="gradeX">
																	<td class="textcenter">
																	  ${smv.styleRouteId.componentId}
																	</td>
																	<td class="textcenter">
																	   ${smv.styleRouteId.productType}
																	</td>
																	<td class="textcenter">
																	  ${smv.ratio}
																	</td>
																	<td class="textcenter">
																	   ${smv.routeLocation}
																	</td>
																	<td class="textcenter">
																	   ${smv.styleRouteId.styleRouteName}
																	</td>
																	<td class="textcenter">
																	   ${smv.styleRouteId.totalSMV}
																	</td>
																	<td class="textcenter">
																	   ${smv.lineEfficency}
																	</td>
																	<td class="textcenter">
																	   ${smv.fmvCategory}
																	</td>
																	<td class="textcenter">
																	   ${smv.fmv}
																	</td>
																	<td class="textcenter headcol3 viewprecostsheetactionsview">
																		<div class="middle-align-editable">
																			<div class="view-toggle deleteBtnMargin">
																				<a class="" href="javascript:;"><span class="glyphicon glyphicon-eye-open"></span>  View</a> 
																			</div>
																		</div>
																	</td>
																</tr>	
															</c:forEach>
														</tbody>
													</table>
												</section>
											</div>
										</div>
									</div>
									<div class="row margintop30">
										
										<div class="col-sm-3 col-md-3 col-xs-3 padding0">
											<div class="col-sm-6 col-md-6 col-xs-6 textcenter">
												<span class="typeHeading">Total SMV:</span>
											</div>
	
											<div class="col-sm-6 col-md-6 col-xs-6 padding0">
												<span>${merprecostsheet.totalSmv}</span>
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12"><h3 class="add-styl-rt">Currency Details</h3><hr></div>
									</div>
									<c:forEach items="${mstparam}" var="mstparams">
										<script type="text/javascript">	
											var mstlocation="${mstparams.locationCode}";
											var currencyMethod="${mstparams.currencyMethod}";
										</script>									
										<div class="row ">
											<div class="col-sm-4 col-md-4 col-xs-4 padding0">
												<div class="col-sm-6 col-md-6 col-xs-6 currency_details_cost_sheet">
													<span class="typeHeading">Cost Sheet Currency:</span>
												</div>
	
												<div class="col-sm-6 col-md-6 col-xs-6 padding0">
													<span>${merprecostsheet.mstcurrencyByCostSheetCurrency.curCode}</span>
												</div>
											</div>
											<div class="col-sm-4 col-md-4 col-xs-4 padding0">
												<div class="col-sm-6 col-md-6 col-xs-6">
													<span class="typeHeading">Exchange Rate:</span>
												</div>
	
												<div class="col-sm-6 col-md-6 col-xs-6 padding0">
													<span>${merprecostsheet.costSheetExchangeRate}</span>
												</div>
											</div>                        
										</div>
										<div class="row ">
											<div class="col-sm-4 col-md-4 col-xs-4 padding0">
												<div class="col-sm-6 col-md-6 col-xs-6 currency_details_dr_sheet">
													<span class="typeHeading">Default RM Currency:</span>
												</div>
	
												<div class="col-sm-6 col-md-6 col-xs-6 padding0">
													<span>${merprecostsheet.mstcurrencyByCostSheetCurrency.curCode}</span>
												</div>
											</div>
											<c:if test="${mstparams.currencyMethod=='Dynamic'}">									
												<div class="col-sm-4 col-md-4 col-xs-4 padding0">
													<div class="col-sm-6 col-md-6 col-xs-6">
														<span class="typeHeading">Exchange Rate:</span>
													</div>
	
													<div class="col-sm-6 col-md-6 col-xs-6 padding0">
														<span>${merprecostsheet.dftRmExchangeRate}</span>
													</div>
												</div>
											</c:if>
										</div>
										
										<c:if test="${mstparams.currencyMethod=='Static'}">
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
																	<c:forEach items="${merprecostsheetcurrencyList}" var="merprecostsheetcurrency">
																		<tr class="gradeX">
																			<td class="textcenter">
																			${merprecostsheetcurrency.mstcurrency.curCode}
																			</td>
																			<td class="textcenter">
																			${merprecostsheetcurrency.exchangeRate}
																			</td>   
																		</tr>
																	</c:forEach>
																</tbody>
															</table>
														</section>
													</div>
												</div>
											</div>
										</c:if>				
									</c:forEach>
								</div> <!-- end of pannel body -->
							</div>
						</div>
					</div> 
				</div> <!-- end of panel contain col-sm-12 col-md-12 div --> 
			</div> <!-- end of pannel contain row -->
			<div class="row paddingleft20">
				<div class="col-sm-12 col-md-12">
					<div class="panel-group" id="preCostsheetGeneralDetails">
						<div class="panel panel-default">
							<div class="panel-heading" data-toggle="collapse" data-parent="#preCostsheetGeneralDetails" data-target="#preCostsheetGeneralDetailsBody">
								<h4 class="panel-title">
									<a data-toggle="collapse" data-parent="#preCostsheetGeneralDetails" href="#preCostsheetGeneralDetailsBody"> 
									</a><a class="accordion-toggle"> <span class="pull-right slideupdowntoggle glyphicon glyphicon-chevron-up"></span>Pre Cost Sheet Row Materials Details</a>  
								</h4>
							</div>
							<div id="preCostsheetGeneralDetailsBody" class="panel-collapse collapse  <c:if test="${merprecostsheet.id.preCostSheetNo == null}"> in </c:if>" style="height: auto;">
								<div class="panel-body">
									<div class="row">
										<div class="col-sm-6 col-md-6">
											<ul class="nav nav-pills nav-pills-jq ">
												<li class="active">
												<script type="text/javascript">
													var itemtypecatogery=new Array();
												</script>
												<c:forEach items="${mstitemtypeCatogory}" var="mstitemtypecatogory">
													<a onclick="navigterowMat('${mstitemtypecatogory}','View')">${mstitemtypecatogory} <span class="badge" id="bage${mstitemtypecatogory}"></span></a></li><li>
													<script type="text/javascript">
														itemtypecatogery.push('${mstitemtypecatogory}');
													</script>
												</c:forEach>
												</li>
											</ul>
										</div> 

									<div class="row paddingleft20">
										<div class="col-sm-12 col-md-12">
											<div class="panel-group" id="rowMaterialScreen">
											<!--  dyanemic table-->
											</div> 
										</div> 
									</div>
                               </div>
									<div class="row margintop20">
										<div class="col-sm-3 col-md-3 col-xs-3 padding0 total_price_precostsheet_padding">
											<div class="col-sm-8 col-md-8 col-xs-8">
												<span class="typeHeading">Total Item Amount:</span>
											</div>
											<div class="col-sm-4 col-md-4 col-xs-4 padding0">
												<span>${merprecostsheet.totalCost}</span>
											</div>
										</div>
										<div class="col-sm-3 col-md-3 col-xs-3 padding0">
											<div class="col-sm-8 col-md-8 col-xs-8">
												<span class="typeHeading">Finance Amount:</span>
											</div>
											<div class="col-sm-4 col-md-4 col-xs-4 padding0">
												<span>${merprecostsheet.financeCost}</span>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div> 
				</div> 
			</div>
			<div class="row paddingleft20">
				<div class="col-sm-12 col-md-12">
					<div class="panel-group" id="preCostSheetPannel3">
						<div class="panel panel-default">
							<div class="panel-heading" data-toggle="collapse" data-parent="#preCostSheetPannel3" data-target="#preCostSheetPannel3Body">
								<h4 class="panel-title">
									<a data-toggle="collapse" data-parent="#preCostSheetPannel3" href="#preCostSheetPannel3Body"> 
									</a><a class="accordion-toggle"> <span class="pull-right slideupdowntoggle glyphicon glyphicon-chevron-up"></span>Pre Cost Sheet Other Details</a>  
								</h4>
							</div>
							<div id="preCostSheetPannel3Body" class="panel-collapse collapse <c:if test="${merprecostsheet.id.preCostSheetNo == null}">in </c:if>" style="height: auto;">
								<div class="panel-body">
									<div class="col-sm-2 col-md-2 col-xs-2 pull-right padding0 ">
										<a href="#" class="editSectionLink pull-right"><span class="glyphicon glyphicon-edit marginRighgt6"></span>Edit Section</a>  
									</div>
									<div class="row marginTop9">
										<div class="col-md-12"><h3 class="add-styl-rt">Cost Details</h3><hr></div>
									</div>
									<div class="row ">
										<div class="col-sm-4 col-md-4 col-xs-4 padding0">
											<div class="col-sm-5 col-md-5 col-xs-5 textAlignLeft cost_details_rm">
												<span class="typeHeading">Row Materials:</span>
											</div>
											<div class="col-sm-7 col-md-7 col-xs-7 padding0">
												<span>${merprecostsheet.rowMaterialValue}
													<button type="button" class="btn btn-primary btn-xs formsearchbtn infoBtn danger pull-right buttonprecost" data-placement="above" title="" data-original-title="Breakdown"> <span class="glyphicon glyphicon-info-sign"></span>
													</button>
												</span>
											</div>
										</div>
										<div class="col-sm-4 col-md-4 col-xs-4 padding0">
											<div class="col-sm-6 col-md-6 col-xs-6 textAlignRight ">
												<span class="typeHeading">Services:</span>
											</div>
											<div class="col-sm-6 col-md-6 col-xs-6 padding0">
												<span>${merprecostsheet.serviceValue}</span>
											</div>
										</div>
										<div class="col-sm-4 col-md-4 col-xs-4 padding0">
											<div class="col-sm-6 col-md-6 col-xs-6 textAlignRight">
												<span class="typeHeading">CM:</span>
											</div>
											<div class="col-sm-6 col-md-6 col-xs-6 padding0">
												<span>${merprecostsheet.cm}</span>
											</div>
										</div>
									</div>
									<div class="row ">
										<div class="col-sm-4 col-md-4 col-xs-4 padding0">
											<div class="col-sm-5 col-md-5 col-xs-5 textAlignRight">
												<span class="typeHeading">CMT:</span>
											</div>
	
											<div class="col-sm-7 col-md-7 col-xs-7 padding0">
												<span>${merprecostsheet.cmt}</span>
											</div>
										</div>
										<div class="col-sm-4 col-md-4 col-xs-4 padding0">
											<div class="col-sm-6 col-md-6 col-xs-6 textAlignRight ">
												<span class="typeHeading">Finance Cost:</span>
											</div>
											<div class="col-sm-6 col-md-6 col-xs-6 padding0">
												<span>${merprecostsheet.financeCost}</span>
											</div>
										</div>
										<div class="col-sm-4 col-md-4 col-xs-4 padding0">
											<div class="col-sm-6 col-md-6 col-xs-6 textAlignRight">
												<span class="typeHeading">Total Cost:</span>
											</div>
	
											<div class="col-sm-6 col-md-6 col-xs-6 padding0">
												<span>${merprecostsheet.totalCost}</span>
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12"><h3 class="add-styl-rt">Pricing</h3><hr></div>
									</div>
									<div class="row ">
										<div class="col-sm-4 col-md-4 col-xs-4 padding0">
											<div class="col-sm-6 col-md-6 col-xs-6 textAlignRight">
												<span class="typeHeading">Markup Amount & % :</span>
											</div>
											<div class="col-sm-6 col-md-6 col-xs-6 padding0">
												<span>${merprecostsheet.markupAmount}</span>
											</div>
										</div>
										<div class="col-sm-4 col-md-4 col-xs-4 padding0">
											<div class="col-sm-6 col-md-6 col-xs-6 textAlignRight ">
												<span class="typeHeading">Buyer Commission:</span>
											</div>
											<div class="col-sm-6 col-md-6 col-xs-6 padding0">
												<span>${merprecostsheet.buyerCommission}</span>
											</div>
										</div>
										<div class="col-sm-4 col-md-4 col-xs-4 padding0">
											<div class="col-sm-6 col-md-6 col-xs-6 textAlignRight">
												<span class="typeHeading">Our Price:</span>
											</div>
											<div class="col-sm-6 col-md-6 col-xs-6 padding0">
												<span>${merprecostsheet.ourPrice}</span>
											</div>
										</div>       
									</div>
									<div class="row ">
										<div class="col-sm-4 col-md-4 col-xs-4 padding0">
											<div class="col-sm-6 col-md-6 col-xs-6 textAlignRight">
												<span class="typeHeading">External Commission:</span>
											</div>
											<div class="col-sm-6 col-md-6 col-xs-6 padding0">
												<span>${merprecostsheet.externalCommission}</span>
											</div>
										</div>
										<div class="col-sm-4 col-md-4 col-xs-4 padding0">
											<div class="col-sm-6 col-md-6 col-xs-6 textAlignRight ">
												<span class="typeHeading">Selling Price:</span>
											</div>
											<div class="col-sm-6 col-md-6 col-xs-6 padding0">
												<span>${merprecostsheet.sellingPrice}</span>
											</div>
										</div>    
									</div>
									<div class="row ">
										<div class="col-md-12"><h3 class="add-styl-rt">Other Costing Details</h3><hr></div>
									</div>
									<div class="row ">
										<div class="col-sm-4 col-md-4 col-xs-4 padding0">
											<div class="col-sm-4 col-md-4 col-xs-4 textAlignRight">
												<span class="typeHeading">Base Body:</span>
											</div>
											<div class="col-sm-8 col-md-8 col-xs-8 padding0">
												<span>${merprecostsheet.baseBody}</span>
											</div>
										</div>
										<div class="col-sm-4 col-md-4 col-xs-4 padding0">
											<div class="col-sm-6 col-md-6 col-xs-6 textAlignRight ">
												<span class="typeHeading">Buyer Reference:</span>
											</div>
	
											<div class="col-sm-6 col-md-6 col-xs-6 padding0">
												<span>${merprecostsheet.buyerReference}</span>
											</div>
										</div>    
									</div>
									<div class="row ">
										<div class="col-sm-12 col-md-12">
											<div class="dataTables_wrapper">
												<section class="precostviewtable">
													<table id="route" class="display table table-striped table-bordered" cellspacing="0">
														<thead>
														<tr>
															<th class="textcenter">Item Code</th>
															<th class="textcenter">Item Description</th> 
															<th class="textcenter">Color</th>
															<th class="textcenter">Width</th>
	
														</tr>
														</thead>
														<tbody>
															<c:forEach items="${rowmaterials}" var="shellfab">
																<tr class="gradeX">
																	<td class="textcenter">
																		${shellfab.itemColor}
																	</td>
																	<td class="textcenter">
																		${shellfab.itemDecription}
																	</td>
																	<td class="textcenter">
																		${shellfab.itemColor}
																	</td>
																	<td class="textcenter">
																		${shellfab.itemWidth}
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
										<div class="col-md-12"><h3 class="add-styl-rt">Delivery Details</h3><hr></div>
									</div>
									<div class="row ">
										<div class="col-sm-4 col-md-4 col-xs-4 padding0">
											<div class="col-sm-6 col-md-6 col-xs-6 textAlignRight">
												<span class="typeHeading">Destination Country:</span>
											</div>
											<div class="col-sm-6 col-md-6 col-xs-6 padding0">
												<span>${merprecostsheet.destinationCountry}</span>
											</div>
										</div>
										<div class="col-sm-4 col-md-4 col-xs-4 padding0">
											<div class="col-sm-6 col-md-6 col-xs-6 textAlignRight">
												<span class="typeHeading">Shipment Mode:</span>
											</div>
	
											<div class="col-sm-6 col-md-6 col-xs-6 padding0">
												<span>${merprecostsheet.shipmentMode}</span>
											</div>
										</div>
										<div class="col-sm-4 col-md-4 col-xs-4 padding0">
											<div class="col-sm-6 col-md-6 col-xs-6 textcenter ">
												<span class="typeHeading">Delivery Term:</span>
											</div>
	
											<div class="col-sm-6 col-md-6 col-xs-6 padding0">
												<span>${merprecostsheet.deliveryTerm}</span>
											</div>
										</div>    
									</div>
									<div class="row ">
										<div class="col-md-12"><h3 class="add-styl-rt">Validity Period</h3><hr></div>
									</div>
									<div class="row ">
										<div class="col-sm-4 col-md-4 col-xs-4 padding0">
											<div class="col-sm-4 col-md-4 col-xs-4 textAlignRight">
												<span class="typeHeading">Valid Til:</span>
											</div>
											<div class="col-sm-6 col-md-6 col-xs-6 padding0">
												<span>${merprecostsheet.validTill}</span>
											</div>
										</div>
										<div class="col-sm-6 col-md-6 col-xs-6 padding0">
											<div class="col-sm-4 col-md-4 col-xs-4 textAlignRight ">
												<span class="typeHeading">Remarks:</span>
											</div>
	
											<div class="col-sm-8 col-md-8 col-xs-8 padding0">
												<span>${merprecostsheet.remarks}</span>
											</div>
										</div>
									</div>
								</div> <!-- pannel body ends -->
							</div>
						</div>
					</div> 
	
				</div> 
			</div>

<!--  <div class="clearfix"></div> -->

			<div class="col-sm-8 col-md-8 col-xs-8  marginBottom20">
				<div class="aprovedby">
					<span class="glyphicon glyphicon-ok aprovedicon"></span> 
					<div class="aprovedbytitle">
					Created By: ${merprecostsheet.createdBy} <br>
					Created On: ${merprecostsheet.createdOn}
					</div>  
				</div>
				<div class="createdby">
					<span class="glyphicon glyphicon-edit createdicon"></span> 
					<div class="aprovedbytitle">
					Modified By: ${merprecostsheet.createdBy}<br>
					Modified On: ${merprecostsheet.createdOn} 
					</div>  
				</div>
				<div class="modifiedby">
					<span class="glyphicon glyphicon-refresh modifiedicon"></span> 
					<div class="aprovedbytitle">
					Approved By: ${merprecostsheet.modifiedBy}<br>
					Approved On: ${merprecostsheet.modifiedOn}
					</div>
				</div>
			</div>
		<form:errors path="*" cssClass="alert alert-danger alert-dismissable" element="div"/>
		<form:form commandName="merprecostsheet" method="post" action="merprecostsheetsview?preCostSheetNo=${param.preCostSheetNo}&costsheetType=${param.costsheetType}&versionNo=${param.versionNo}" cssClass="well" id="merprecostsheetsview" >
					
			<div id="submision" class="submit-button styl-rt-submission-btn pull-right marginRight0 marginTop30 marginBottom20">
				<c:if test="${param.delete == null}">
					<c:if test="${merprecostsheet.flag == 'Incomplete'}">
						<button type="submit" name = "conform" class="btn btn-info btn-lg btn-embossed">Confirm</button>
					</c:if>
					<c:if test="${merprecostsheet.flag == 'Completed'}">
						<button type="submit" name = "Approved" class="btn btn-info btn-lg btn-embossed">Approved</button>
					</c:if>
					<c:if test="${merprecostsheet.flag == 'Approved'}">
						<button type="submit" name = "UnApproved" class="btn btn-info btn-lg btn-embossed">UnApproved</button>
					</c:if>
				</c:if>
				<c:if test="${param.delete !=null}">
					<button type="submit" name = "delete"  class="btn btn-info btn-lg btn-embossed">Delete</button>
				</c:if>
				
			</div>
		</form:form>
	</div><!-- end of tab content 1 -->
      
</div>
<div id="popover_content_wrapper" style="display: none">
</div>
<script>
	$(document).ready(function() {
		for(var i=itemtypecatogery.length-1;i>-1;i--){
			 navigterowMat(itemtypecatogery[i],"View");
			 console.log(itemtypecatogery[i]);
		}
	});
</script>
 <script>
	 $('#nav-dropdown .dropdown-menu').on({
		"click":function(e){
		  e.stopPropagation();
		}
	 });
 </script>   
 <script src="scripts/applicationjs/merprecostsheets.js"></script>