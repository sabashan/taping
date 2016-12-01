<%@ include file="/common/taglibs.jsp"%>
	
	<style type="text/css" class="init">
    	th, td { white-space: nowrap; }
    	#example_filter.dataTables_filter>label{float: left;}
    	div.dataTables_wrapper { width:100%;}
  </style>
<head>
    <title><fmt:message key="merprecostsheetList.title"/></title>
    <meta name="menu" content="MerprecostsheetMenu"/>
</head>

<c:if test="{'$'}{not empty searchError}">
    <div class="alert alert-danger alert-dismissable">
        <a href="#" data-dismiss="alert" class="close">&times;</a>
        <c:out value="{'$'}{searchError}"/>
    </div>
</c:if>

 <div class="row form-group paddingleft20"> <!-- NAVIGATION PILLS -->
      <div class="col-xs-8"><h2>Pre Cost Sheet</h2></div>  
   </div> 
	<div class="tab-content"> <!-- TAB CONTENT MAIN -->
		<div class="tab-pane active" id="home">
			<div class="row paddingleft20">
				<form method="get" action="${ctx}/merprecostsheets" id="searchForm" class="form-inline">
					<c:if test="${merprecostsheet.mststyleheader.id.styleId == null}">
						<c:set var="disabled" scope="session" value=""/>
					</c:if>
					<c:if test="${merprecostsheet.mststyleheader.id.styleId != null}">
						<c:set var="disabled" scope="session" value="readonly"/>
					</c:if>
					<div class="col-sm-4 col-md-4 ">
						<div class="form-group formwithsearch marginbottom20">
							<div class="icon-addon addon-md">
								<label for="exampleInputEmail1">Buyer </label>
								<select ${disabled} required="required" type="text" name="custCode" id="pcs_id_custCode" onfocus="getOptions('pcs_id_custCode','mstcustomer')" class="form-control" >
									<c:if test="${merprecostsheet.mststyleheader.id.custCode!=null}">
										<option selected="selected">${merprecostsheet.mststyleheader.id.custCode}</option>
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
						</div>  
						<div class="btn-group formsearchbtn btn-model-select-div">
							<button onclick="$('#pcs_id_custCode').trigger('onfocus'); addmodalpopup('pcs_id_custCode')" type="button" class="btn btn-primary btn-xs dropdown-toggle " data-toggle="modal" data-target="#schmodalpopup" ><span class="glyphicon glyphicon-search"></span></button>
						</div>
						
						<div class="clearfix"></div> 
						<div class="form-group formwithsearch marginbottom20">
							<div class="icon-addon addon-md">
								<label for="exampleInputEmail1">Style Location</label>
								<select ${disabled} required="required" type="text" name="locationCode" id="pcs_id_locationCode" class="form-control" onfocus="getOptions('pcs_id_locationCode','mstlocations')"> 
									<c:if test="${merprecostsheet.mststyleheader.id.locationCode!=null}">
										<option selected="selected">${merprecostsheet.mststyleheader.id.locationCode}</option>
									</c:if>
									<c:if test="${merprecostsheet.mststyleheader.id.locationCode ==null}">
										<c:if test="${param.locationCode !=null}">
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
								<select ${disabled}  required="required" type="text" name="depCode" id="pcs_id_depCode" onfocus="optionsforgencodes('pcs_id_depCode','BUYDEM')" class="form-control" >
									<c:if test="${merprecostsheet.mststyleheader.id.depCode!=null}">
										<option selected="selected">${merprecostsheet.mststyleheader.id.depCode}</option>
									</c:if>
									<c:if test="${merprecostsheet.mststyleheader.id.depCode ==null}">
										<option selected="selected">${param.depCode}</option>
									</c:if>
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
									<input ${disabled}  required="required" type="text" name="styleId" id="pcs_id_styleId"  class="form-control" class="typeahead form-control" data-provide="typeahead" value='<c:if test="${merprecostsheet.mststyleheader.id.styleId!=null}"> ${merprecostsheet.mststyleheader.id.styleId}</c:if><c:if test="${merprecostsheet.mststyleheader.id.styleId ==null}"> ${param.styleId}</c:if>' onfocus="typaheadforStyle('pcs_id_styleId','id.styleId')" >
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
								<select ${disabled}  required="required" type="text" name="compCode" id="pcs_id_compCode" onfocus="getOptions('pcs_id_compCode','mstcompany')" class="form-control" >
									<c:if test="${merprecostsheet.mststyleheader.id.compCode!=null}">
										<option selected="selected">${merprecostsheet.mststyleheader.id.compCode}</option>
									</c:if>
									<c:if test="${merprecostsheet.mststyleheader.id.compCode ==null}">
										<option selected="selected">${param.compCode}</option>
									</c:if>
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
								<input  type="text" name="styleDescription" id="pcs_styleDescription" value='<c:if test="${merprecostsheet.mststyleheader.styleDescription!=null}"> ${merprecostsheet.mststyleheader.styleDescription}</c:if><c:if test="${merprecostsheet.mststyleheader.styleDescription ==null}"> ${param.styleDescription}</c:if>' class="form-control" readonly="readonly">
							</div>
						</div>  
						<div class="clearfix"></div>
					</div>
				
		
					<div class="col-sm-4 col-md-4">
						<div class="form-group formwithsearch marginbottom20">
							<div class="icon-addon addon-md">
								<label for="exampleInputEmail1">Season</label>
								<select required="required" type="text" name="season" id="pcs_season" class="form-control" onfocus="optionsforgencodes('pcs_season','SEASON')" >
									<c:if test="${merprecostsheet.season!=null}">
										<option selected="selected">${merprecostsheet.season}</option>
									</c:if>
									<c:if test="${merprecostsheet.season ==null}">
										<option selected="selected">${param.season}</option>
									</c:if>
								</select>							
							</div>
						</div> 		
						<div class="btn-group formsearchbtn btn-model-select-div">
							<button onclick="$('#pcs_season').trigger('onfocus'); addmodalpopup('pcs_season')" type="button" class="btn btn-primary btn-xs dropdown-toggle " data-toggle="modal" data-target="#schmodalpopup" ><span class="glyphicon glyphicon-search"></span></button>
						</div>					
						<div class="clearfix"></div> 
					</div>
	        		 
					<div class="col-sm-4 col-md-4">
						<button type="submit" class="btn btn-info btn-embossed search-routes-btn"><span class="glyphicon glyphicon-search"></span>Search PCS</button>
						<button type="button"  class="reset  replace-data btn btn-defalt btn-embossed search-routes-btn"><span class="glyphicon glyphicon-refresh"></span>  Reset</button>
					</div>
				</form>
			</div>
    
			<div class="row paddingleft20">
				<div class="col-sm-12 col-md-12">
					<div class="panel-group" id="stylebrowser">
						<div class="panel panel-default">
							<div class="panel-heading" data-toggle="collapse" data-parent="#stylebrowser" data-target="#styleBrowserBody">
								<h4 class="panel-title">
									<a data-toggle="collapse" data-parent="#stylebrowser" href="#styleBrowserBody"> 
										<a class="accordion-toggle"> <span class="pull-right slideupdowntoggle glyphicon glyphicon-chevron-up"></span>Available Pre Cost Sheets</a> 
									</a> 
								</h4>
							</div>
							<c:if test="${added != null}">
								<div id="styleBrowserBody" class="panel-collapse collapse out" style="height: auto;">
									<div class="panel-body">
										<!-- <form method="get" action="${ctx}/merprecostsheets" id="searchForm" class="form-inline"> -->
											<!-- <div class="row">
												<input type="hidden" size="20" name="custCode" id="scustCode=" value="${param.custCode}" class="form-control" placeholder="Search and Filter"/>
												<input type="hidden" size="20" name="locationCode" id="slocationCode" value="${param.locationCode}" class="form-control" placeholder="Search and Filter"/>
												<input type="hidden" size="20" name="depCode" id="sdepCode" value="${param.depCode}" class="form-control" placeholder="Search and Filter"/>
												<input type="hidden" size="20" name="styleId" id="sstyleId" value="${param.styleId}" class="form-control" placeholder="Search and Filter"/>
												<input type="hidden" size="20" name="season" id="sseason" value="${param.season}" class="form-control" placeholder="Search and Filter"/>
												<input type="hidden" size="20" name="compCode" id="scompCode" value="${param.compCode}" class="form-control" placeholder="Search and Filter"/>
												<input type="hidden" size="20" name="styleDescription" id="sstyleDescription" value="${param.styleDescription}" class="form-control" placeholder="Search and Filter"/>
											</div> -->			
											<div class="row">
												<div class="pull-right marginBottom20 margin-addstyleroute">
													<div class="input-group custom-search-form " style="width: 390px;">
														<c:if test="${merprecostsheetList != null}">
															<input  type="text" onkeypress="checkenter(event)" size="20" name="q" id="query"  value="${param.q}" class="form-control" placeholder="Search and Filter"/>
															<span class="input-group-btn">
																<button onclick="getCostsheets()" id="button.search" type="button" class="btn btn-info search-form-btn" type="submit">
																	<span class="glyphicon glyphicon-search"></span>
																</button>
															</span>
														</c:if>
														
														<a onclick="selectStyle()" class="btn btn-warning btn-embossed pull-right"><span class="glyphicon glyphicon-plus marginRight4"></span>Add Pre Cost Sheet</a>
													</div><!-- /input-group -->
												</div>  
											</div>											
										<!-- </form> -->											
										
										<div class='<c:if test="${merprecostsheetList != null}">dataTables_wrapper Scroll-for-datatable</c:if>' >
											<section class="precostsheet_section">
												<display:table name="merprecostsheetList" class="display table table-striped table-bordered" requestURI="" id="merprecostsheetList" export="true" pagesize="25">
													 <display:setProperty name="export.csv.include_header" value="true" />
													<display:column property="id.preCostSheetNo" class="textcenter" headerClass="textcenter" sortable="true" titleKey="merprecostsheet.id.preCostSheetNo"/>
													<display:column property="id.versionNo" class="textcenter" headerClass="textcenter" sortable="true" titleKey="merprecostsheet.id.versionNo"/>
													<display:column property="mstcurrencyByCostSheetCurrency.curName" class="textcenter" headerClass="textcenter" sortable="true" titleKey="merprecostsheet.mstcurrencyByCostSheetCurrency"/>
													<%-- <display:column property="baseBody" sortable="true" titleKey="merprecostsheet.baseBody"/>
													<display:column property="buyerCommission" sortable="true" titleKey="merprecostsheet.buyerCommission"/>
													<display:column property="buyerReference" sortable="true" titleKey="merprecostsheet.buyerReference"/>
													<display:column property="cm" sortable="true" titleKey="merprecostsheet.cm"/>
													<display:column property="cmt" sortable="true" titleKey="merprecostsheet.cmt"/> --%>
													<display:column property="compWiseCost" class="textcenter" headerClass="textcenter" sortable="true" titleKey="merprecostsheet.compWiseCost"/>
													<display:column property="costSheetExchangeRate" class="textcenter" headerClass="textcenter" sortable="true" titleKey="merprecostsheet.costSheetExchangeRate"/>
													<display:column property="id.costsheetType" class="textcenter" headerClass="textcenter" sortable="true" titleKey="merprecostsheet.costsheetType"/>
													<display:column property="createdOn" class="textcenter" headerClass="textcenter" sortable="true" titleKey="merprecostsheet.createDate"/>
													<%-- <display:column property="deliveryTerm" sortable="true" titleKey="merprecostsheet.deliveryTerm"/>
													<display:column property="destinationCountry" sortable="true" titleKey="merprecostsheet.destinationCountry"/>
													<display:column property="dftRmExchangeRate" sortable="true" titleKey="merprecostsheet.dftRmExchangeRate"/>
													<display:column property="externalCommission" sortable="true" titleKey="merprecostsheet.externalCommission"/>
													<display:column property="financeCost" sortable="true" titleKey="merprecostsheet.financeCost"/> --%>
													<display:column media="html" class="headcol textcenter" headerClass="headcol textcenter" sortable="true" titleKey="Status">
														<c:if test="${merprecostsheetList.flag == 'Completed'}">
															<div class="pdnCompleted">${merprecostsheetList.flag}</div>
														</c:if>
														<c:if test="${merprecostsheetList.flag == 'Pending'}">
															<div class="pdnApproval">${merprecostsheetList.flag}</div>
														</c:if>
													</display:column>
													<%-- <display:column property="flag" sortable="true" titleKey="merprecostsheet.flag"/> --%>
													<%-- <display:column property="markupAmount" sortable="true" titleKey="merprecostsheet.markupAmount"/>
													<display:column property="merchandiser.userId" sortable="true" titleKey="merprecostsheet.merchandiser"/>
													<display:column property="ourPrice" sortable="true" titleKey="merprecostsheet.ourPrice"/>
													<display:column property="remarks" sortable="true" titleKey="merprecostsheet.remarks"/>
													<display:column property="rowMaterialValue" sortable="true" titleKey="merprecostsheet.rowMaterialValue"/>
													<display:column property="season" sortable="true" titleKey="merprecostsheet.season"/> --%>
													<display:column property="sellingPrice" class="textcenter" headerClass="textcenter" sortable="true" titleKey="merprecostsheet.sellingPrice"/>
													<%-- <display:column property="serviceValue" sortable="true" titleKey="merprecostsheet.serviceValue"/>
													<display:column property="shipmentMode" sortable="true" titleKey="merprecostsheet.shipmentMode"/> --%>
													<display:column property="totalCost" class="textcenter" headerClass="textcenter" sortable="true" titleKey="merprecostsheet.totalCost"/>
													<display:column property="totalSmv" class="textcenter" headerClass="textcenter" sortable="true" titleKey="merprecostsheet.totalSmv"/>
													<%-- <display:column property="validTill" sortable="true" titleKey="merprecostsheet.validTill"/> --%>
													
													<display:column media="html" class="headcol2" headerClass="headcol2" titleKey="<a>Add Oparations</a>">
														<div class="operations-toggle">
															<a href="merprecostsheetform?OpenAs=true&preCostSheetNo=${merprecostsheetList.id.preCostSheetNo}&versionNo=${merprecostsheetList.id.versionNo}&costsheetType=${merprecostsheetList.id.costsheetType}&edit=editmode"><span class="glyphicon glyphicon-folder-open marginRight5"></span> Open as new </a>
														</div>
													</display:column>
													
													<display:column media="html" class="textcenter headcol3" headerClass="textcenter headcol3" titleKey="<a>Action</a>">
														<div class="middle-align">
															<div class="edit-toggle avalable_pre_cost_sheets_edit">
																<c:if test="${merprecostsheetList.id.versionNo=='0'}"><a  href="merprecostsheetform?preCostSheetNo=${merprecostsheetList.id.preCostSheetNo}&versionNo=${merprecostsheetList.id.versionNo}&costsheetType=${merprecostsheetList.id.costsheetType}&edit=editmode"><span class="glyphicon glyphicon-pencil disabled "></span> Edit</a></c:if> 
																
															</div>
															<div  class="view-toggle avalable_pre_cost_sheets_view">
																<a href="merprecostsheetsview?preCostSheetNo=${merprecostsheetList.id.preCostSheetNo}&versionNo=${merprecostsheetList.id.versionNo}&costsheetType=${merprecostsheetList.id.costsheetType}">
																<span class="glyphicon glyphicon-eye-open"></span> View </a>
															</div>
															<div class="delete-toggle avalable_pre_cost_sheets_delete">
																<a href="merprecostsheetsview?delete=true&preCostSheetNo=${merprecostsheetList.id.preCostSheetNo}&versionNo=${merprecostsheetList.id.versionNo}&costsheetType=${merprecostsheetList.id.costsheetType}">
																<span class="glyphicon glyphicon-remove"></span> Delete </a> 
															</div>
														</div>								
													</display:column>
													<display:setProperty name="paging.banner.item_name"><fmt:message key="merprecostsheetList.merprecostsheet"/></display:setProperty>
													<display:setProperty name="paging.banner.items_name"><fmt:message key="merprecostsheetList.merprecostsheets"/></display:setProperty>

													<display:setProperty name="export.excel.filename"><fmt:message key="merprecostsheetList.title"/>.xls</display:setProperty>
													<display:setProperty name="export.csv.filename"><fmt:message key="merprecostsheetList.title"/>.csv</display:setProperty>
													<display:setProperty name="export.pdf.filename"><fmt:message key="merprecostsheetList.title"/>.pdf</display:setProperty>
												</display:table>
											</section>
										</div>
									</div>
								</div>
							</c:if>
						</div>
					</div> 

				</div> 
			</div>

			<div class="row paddingleft20">
				<div class="col-sm-12 col-md-12">
					<div class="panel-group" id="styleBrowser2">
						<div class="panel panel-default">
							<div class="panel-heading" data-toggle="collapse" data-parent="#styleBrowser2" data-target="#styleBrowserBody_new" style="background-color: #d63b3f;">
								<h4 class="panel-title">
									<a data-toggle="collapse" data-parent="#styleBrowser2" href="#styleBrowserBody_new">
										<a class="accordion-toggle"> <span class="pull-right slideupdowntogglered glyphicon glyphicon-chevron-up"></span>Pre Cost Sheet That Need Your Attention</a> 
									</a> 
								</h4>
							</div>
							<div id="styleBrowserBody_new" class="panel-collapse collapse">
								<div class="panel-body">
									<div class='<c:if test="${merprecostsheetListdue != null}">dataTables_wrapper Scroll-for-datatable</c:if>' >
										<section class="pre_cost_sheets_need_attention_section">
											<display:table name="merprecostsheetListdue" class="display table table-striped table-bordered" requestURI="" id="merprecostsheetListdue" export="true" pagesize="10">
												 <display:setProperty name="export.csv.include_header" value="true" />
												<display:column property="id.preCostSheetNo" sortable="true" class="textcenter" headerClass="textcenter" titleKey="merprecostsheet.id.preCostSheetNo"/>
												<display:column property="id.versionNo" sortable="true" class="textcenter" headerClass="textcenter" titleKey="merprecostsheet.id.versionNo"/>
												<display:column property="mstcurrencyByCostSheetCurrency.curName" class="textcenter" headerClass="textcenter" sortable="true" titleKey="merprecostsheet.mstcurrencyByCostSheetCurrency"/>
												<%-- <display:column property="id" media="csv excel xml pdf" titleKey="merprecostsheet.id"/> --%>
												<%-- <display:column property="baseBody" sortable="true" titleKey="merprecostsheet.baseBody"/>
												<display:column property="buyerCommission" sortable="true" titleKey="merprecostsheet.buyerCommission"/>
												<display:column property="buyerReference" sortable="true" titleKey="merprecostsheet.buyerReference"/>
												<display:column property="cm" sortable="true" titleKey="merprecostsheet.cm"/>
												<display:column property="cmt" sortable="true" titleKey="merprecostsheet.cmt"/> --%>
												<display:column property="compWiseCost" class="textcenter" headerClass="textcenter" sortable="true" titleKey="merprecostsheet.compWiseCost"/>
												<%-- <display:column property="costSheetExchangeRate" sortable="true" titleKey="merprecostsheet.costSheetExchangeRate"/>--%>
												<display:column property="id.costsheetType" class="textcenter" headerClass="textcenter" sortable="true" titleKey="merprecostsheet.costsheetType"/>
												<display:column property="createdOn" class="textcenter" headerClass="textcenter" sortable="true" titleKey="merprecostsheet.createDate"/>
												<%-- <display:column property="deliveryTerm" sortable="true" titleKey="merprecostsheet.deliveryTerm"/>
												<display:column property="destinationCountry" sortable="true" titleKey="merprecostsheet.destinationCountry"/>
												<display:column property="dftRmExchangeRate" sortable="true" titleKey="merprecostsheet.dftRmExchangeRate"/>
												<display:column property="externalCommission" sortable="true" titleKey="merprecostsheet.externalCommission"/>
												<display:column property="financeCost" sortable="true" titleKey="merprecostsheet.financeCost"/> --%>
												
												<display:column media="html" property="flag" sortable="true" titleKey="merprecostsheet.flag" class="textcenter headcol2 precostsheetsnew sectionclass" headerClass="textcenter headcol2 precostsheetsnew sectionclass">
													<div class="pdnIncomplete">${merprecostsheetListdue.flag}</div>
												</display:column>
												<%-- <display:column property="markupAmount" sortable="true" titleKey="merprecostsheet.markupAmount"/>
												<display:column property="merchandiser.userId" sortable="true" titleKey="merprecostsheet.merchandiser"/>
												<display:column property="ourPrice" sortable="true" titleKey="merprecostsheet.ourPrice"/>
												<display:column property="remarks" sortable="true" titleKey="merprecostsheet.remarks"/>
												<display:column property="rowMaterialValue" sortable="true" titleKey="merprecostsheet.rowMaterialValue"/>
												<display:column property="season" sortable="true" titleKey="merprecostsheet.season"/> --%>
												<display:column property="sellingPrice" class="textcenter" headerClass="textcenter" sortable="true" titleKey="merprecostsheet.sellingPrice"/>
												<%-- <display:column property="serviceValue" sortable="true" titleKey="merprecostsheet.serviceValue"/>
												<display:column property="shipmentMode" sortable="true" titleKey="merprecostsheet.shipmentMode"/> --%>
												<display:column property="totalCost" class="textcenter" headerClass="textcenter" sortable="true" titleKey="merprecostsheet.totalCost"/>
												<display:column property="totalSmv" class="textcenter" headerClass="textcenter" sortable="true" titleKey="merprecostsheet.totalSmv"/>
												<%-- <display:column property="validTill" sortable="true" titleKey="merprecostsheet.validTill"/> --%>
												<display:column media="html" class="textcenter headcol3" headerClass="textcenter headcol3" titleKey="<a>Action</a>">
													<div class="middle-align">
														<div class="edit-toggle editoggleevent">
															<a <c:if test="${merprecostsheetListdue.id.versionNo=='0'}"> href="merprecostsheetform?preCostSheetNo=${merprecostsheetListdue.id.preCostSheetNo}&versionNo=${merprecostsheetListdue.id.versionNo}&costsheetType=${merprecostsheetListdue.id.costsheetType}&edit=editmode"</c:if> <c:if test="${merprecostsheetListdue.id.versionNo!='0'}">class="disabled" </c:if> ><span class="glyphicon glyphicon-pencil "></span> Edit</a>
															
														</div>
														<div class="view-toggle view_button_fix">
															<a href="merprecostsheetsview?preCostSheetNo=${merprecostsheetListdue.id.preCostSheetNo}&versionNo=${merprecostsheetListdue.id.versionNo}&costsheetType=${merprecostsheetListdue.id.costsheetType}">
															<span class="glyphicon glyphicon-eye-open"></span> View </a>
														</div>
                                                       <div class="delete-toggle editoggleevent">
															<a href="merprecostsheetsview?delete=true&preCostSheetNo=${merprecostsheetListdue.id.preCostSheetNo}&versionNo=${merprecostsheetListdue.id.versionNo}&costsheetType=${merprecostsheetListdue.id.costsheetType}">
															<span class="glyphicon glyphicon-remove"></span> Delete </a> 
														</div>
													</div>								
												</display:column>
												<display:setProperty name="paging.banner.item_name"><fmt:message key="merprecostsheetList.merprecostsheet"/></display:setProperty>
												<display:setProperty name="paging.banner.items_name"><fmt:message key="merprecostsheetList.merprecostsheets"/></display:setProperty>

												<display:setProperty name="export.excel.filename"><fmt:message key="merprecostsheetList.title"/>.xls</display:setProperty>
												<display:setProperty name="export.csv.filename"><fmt:message key="merprecostsheetList.title"/>.csv</display:setProperty>
												<display:setProperty name="export.pdf.filename"><fmt:message key="merprecostsheetList.title"/>.pdf</display:setProperty>
											</display:table>
										</section>
									</div>
								</div>
							</div>
						</div>
					</div> 
				</div> 
			</div>
		</div><!-- end of tab content 1 -->    
	</div>
 <script>$('#nav-dropdown .dropdown-menu').on({
    "click":function(e){
      e.stopPropagation();
    }
 });
 $(document).ready(function(){
	
		});
 </script>   

   <script src="scripts/applicationjs/merprecostsheets.js"></script>




