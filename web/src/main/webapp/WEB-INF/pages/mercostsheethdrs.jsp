<style>
    .buyer_approved_precost_sheet_action{
    height: 105px !important;
    padding-top: 45px !important;
    }

    .buyer_approved_precost_sheet_action_icons{
    height: 34px !important;
    padding-left: 83px !important;
    }

    .style_order{
    height:34px !important;
    }
    </style>
    <%@ include file="/common/taglibs.jsp"%>
<script src="scripts/applicationjs/mercostsheethdr.js"></script>
<head>
    <title><fmt:message key="mercostsheethdrList.title"/></title>
    <meta name="menu" content="MercostsheethdrMenu"/>
</head>
<c:if test="{'$'}{not empty searchError}">
    <div class="alert alert-danger alert-dismissable">
        <a href="#" data-dismiss="alert" class="close">&times;</a>
        <c:out value="{'$'}{searchError}"/>
    </div>
</c:if>

<div class="row form-group paddingleft20"> <!-- NAVIGATION PILLS -->
	<div class="col-xs-8"><h2>Final Cost Sheet</h2></div>
	<div class="col-xs-4 styletoure-hrline">
		<ul class="nav nav-justified setup-panel" id="myTab">
			<li id="fcsmain1Tab" class="active" onclick="navigateFinalSheet('fcsmain1');">
              <a href="#addNewFinalCostSheet" data-toggle="tab">
				<button type="button" class="btn btn-default btn-circle"><span class="fa fa-file-text-o"></span></button>
				<p class="list-group-item-text">Add New Final Cost Sheet</p> </a>
			</li>
			<li id="fcsmain2Tab" onclick="navigateFinalSheet('fcsmain2');">
               <a href="#addFinalCS" data-toggle="tab">
				<button type="button" class="btn btn-default btn-circle"><span class="fa fa-file-powerpoint-o"></span></button>
				<p class="list-group-item-text">Add Final Cost Sheet with </br> Pre Cost Sheet</p></a>
			</li>
		</ul>
	</div>    
</div>  <!-- NAVIGATION PILLS END-->
<div class="tab-content"> <!-- TAB CONTENT MAIN -->
	<div class="tab-pane active" id="fcsmain1">
		<div class="row paddingleft20">
			<form method="get" action="${ctx}/mercostsheethdrs" id="searchFormInit" class="form-inline">
				<div class="col-sm-4 col-md-4 ">
					<div class="form-group formwithsearch marginbottom20">
						<div class="icon-addon addon-md">
							<label for="exampleInputEmail1">Buyer </label>
							<select required name="custCode" id="cs_id_custCode" onfocus="getOptions('cs_id_custCode','mstcustomer')" class="form-control" >
									<option selected="selected">${param.custCode}</option>
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
							<select required name="locationCode" id="cs_id_locationCode" class="form-control" onfocus="getOptions('cs_id_locationCode','mstlocations')"> 
								<c:if test="${param.locationCode!=null}">
								<option selected="selected">${param.locationCode}</option>
								</c:if>
								<c:if test="${param.locationCode ==null}">
									<c:forEach items="${mstparam}" var="mstparams">	
											<option selected="selected">${mstparams.locationCode}</option>
									</c:forEach>
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
							<select required type="text" name="depCode" id="cs_id_depCode" onfocus="optionsforgencodes('cs_id_depCode','BUYDEM')" class="form-control" >
									<option selected="selected">${param.depCode}</option>
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
								<input required type="text" name="styleId" id="cs_id_styleId"  class="form-control" class="typeahead form-control" autocomplete="off" data-provide="typeahead" value='${param.styleId}' onfocus="typaheadforStyle('cs_id_styleId','id.styleId')" >
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
							<select required name="compCode" id="cs_id_compCode" onfocus="getOptions('cs_id_compCode','mstcompany')" class="form-control" >
									<option selected="selected">${param.compCode}</option>
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
							<input type="text" name="styleDescription" id="cs_styleDescription" value='${param.styleDescription}' class="form-control" readonly="readonly">
						</div>
                     <div class="feedback"></div>
					</div>  
					<div class="clearfix"></div>
				</div>	       
				<div class="col-sm-4 col-md-4">
					<div class="form-group formwithsearch marginbottom20">
						<div class="icon-addon addon-md">
							<label for="exampleInputEmail1">Season</label>
							<select required name="season" id="cs_season" class="form-control" onfocus="optionsforgencodes('cs_season','SEASON')" >
									<option selected="selected">${param.season}</option>
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
					<button type="submit" name="costsheet" class="btn btn-info btn-embossed search-routes-btn" onclick="$('#searchFormInit').valid();"><span class="glyphicon glyphicon-search"></span>&nbsp;Search FCS</button>
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
								<a class="accordion-toggle"> <span class="pull-right slideupdowntoggle glyphicon glyphicon-chevron-up"></span>Available Final Cost Sheets</a> </a> 
							</h4>
						</div>
						<div id="styleBrowserBody" class="panel-collapse collapse">
							<div class="panel-body">
								<div class="row">              
									<div class="pull-right marginBottom20 margin-addstyleroute">
										<div class="input-group custom-search-form " style="width: 390px;">
											<c:if test="${mercostsheethdrList != null}">
												<input  type="text" onkeypress="checkenter(event)" size="20" name="q" id="query"  value="${param.q}" class="form-control" placeholder="Search and Filter"/>
												<span class="input-group-btn">
													<button onclick="getCostsheets()" id="button.search" type="button" class="btn btn-info search-form-btn" type="submit">
														<span class="glyphicon glyphicon-search"></span>
													</button>
												</span>
											</c:if>
											<a onclick="addNewCostSheetWithStyle()" class="btn btn-warning btn-embossed pull-right"><span class="glyphicon glyphicon-plus marginRight4"></span>Add Final Cost Sheet</a>
										</div><!-- /input-group -->
									</div>                   
								</div>
								<div class="dataTables_wrapper Scroll-for-datatable">
									<section class="final_cost_sheet_sestion">
									
										<display:table name="mercostsheethdrList" class="fcsRout routId display table table-striped table-bordered" requestURI="" id="mercostsheethdrList" export="true" pagesize="25">
											<display:column property="id.costSheetNo" headerClass="textcenter" class="textcenter" sortable="true" titleKey="mercostsheethdr.id.costSheetNo"/>
											<display:column property="createDate" sortable="true" headerClass="textcenter" class="textcenter" titleKey="mercostsheethdr.createDate"/>
											<display:column property="compWiseCost" sortable="true" headerClass="textcenter" class="textcenter" titleKey="mercostsheethdr.compWiseCost"/>
											<display:column property="totalSmv" sortable="true" headerClass="textcenter" class="textcenter" titleKey="mercostsheethdr.totalSmv"/>
											<display:column property="dftRmExchangeRate" headerClass="textcenter" class="textcenter" sortable="true" titleKey="mercostsheethdr.mstcurrencyByDftRmCurrency"/>
											<display:column property="costSheetExchangeRate" headerClass="textcenter" class="textcenter" sortable="true" titleKey="mercostsheethdr.mstcurrencyByCostSheetCurrency"/>
<%-- 											<display:column property="totalCost" sortable="true" titleKey="mercostsheethdr.totalCost"/> --%>
<%-- 											<display:column property="sellingPrice" sortable="true" titleKey="mercostsheethdr.sellingPrice"/> --%>
<%-- 											<display:column property="sellingPrice" sortable="true" titleKey="mercostsheethdr.preCostSheet"/> --%>
											
											<display:column media="html" class="headcol textcenter final_cost_sheet_status_text" headerClass="headcol textcenter final_cost_sheet_status" titleKey="<a>Status</a>">
												<c:if test="${mercostsheethdrList.flag == 'Incomplete'}">
													<div class="pdnIncomplete">${mercostsheethdrList.flag}</div>
												</c:if>
												
												<c:if test="${mercostsheethdrList.flag == 'Completed'}">
													<div class="pdnCompleted">${mercostsheethdrList.flag}</div>
												</c:if>
												
												<c:if test="${mercostsheethdrList.flag == 'Rejected'}">
													<div class="pdnApproval">${mercostsheethdrList.flag}</div>
												</c:if>
											</display:column>
											
											<display:column media="html" class="textcenter headcol2 final_cost_sheet_opasnew_text" headerClass="headcol2 textcenter final_cost_sheet_opasnew" titleKey="<a>Open as new</a>">
												<div class="middle-align">
													<div class="operations-toggle">
														<a href="mercostsheethdrform?costSheetNo=${mercostsheethdrList.id.costSheetNo}&costSheetType=${mercostsheethdrList.id.costSheetType}&versionNo=${mercostsheethdrList.id.versionNo}&openas=true"><span class="glyphicon glyphicon-folder-open marginRight5"></span> Open as new </a>
													</div>	
												</div>
											</display:column>
											<display:column media="html" class="textcenter headcol3 final_cost_sheet_action_text" headerClass="headcol3 textcenter final_cost_sheet_action" titleKey="<a>Actions</a>">
												<div class="middle-align">
													 <div class="edit-toggle">
															<a href="mercostsheethdrform?costSheetNo=${mercostsheethdrList.id.costSheetNo}&costSheetType=${mercostsheethdrList.id.costSheetType}&versionNo=${mercostsheethdrList.id.versionNo}&editmode=true"><span class="glyphicon glyphicon-pencil"></span> Edit</a>
														</div>
														<div class="view-toggle">
														   <a href="mercostsheethdrview?costSheetNo=${mercostsheethdrList.id.costSheetNo}&costSheetType=${mercostsheethdrList.id.costSheetType}&versionNo=${mercostsheethdrList.id.versionNo}&view=true"><span class="glyphicon glyphicon-eye-open"></span> View </a>
													   </div>
														<div class="delete-toggle">
															<a href="mercostsheethdrview?costSheetNo=${mercostsheethdrList.id.costSheetNo}&costSheetType=${mercostsheethdrList.id.costSheetType}&versionNo=${mercostsheethdrList.id.versionNo}&delete=true" data-toggle="modal" data-target=".delete-confirmation"><span class="glyphicon glyphicon-remove"></span> Delete </a>
														</div>
													 </div>			
											</display:column>
											<display:setProperty name="paging.banner.item_name"><fmt:message key="mercostsheethdrList.mercostsheethdr"/></display:setProperty>
											<display:setProperty name="paging.banner.items_name"><fmt:message key="mercostsheethdrList.mercostsheethdrs"/></display:setProperty>

											<display:setProperty name="export.excel.filename"><fmt:message key="mercostsheethdrList.title"/>.xls</display:setProperty>
											<display:setProperty name="export.csv.filename"><fmt:message key="mercostsheethdrList.title"/>.csv</display:setProperty>
											<display:setProperty name="export.pdf.filename"><fmt:message key="mercostsheethdrList.title"/>.pdf</display:setProperty>
										</display:table>
									</section>
								</div>
							</div>
						</div>
					</div>
				</div> 
			</div> 
		</div>

		<div class="row paddingleft20">
			<div class="col-sm-12 col-md-12">
				<div class="panel-group" id="styleBrowser2">
					<div class="panel panel-default">
						<div class="panel-heading" data-toggle="collapse" data-parent="#styleBrowser2" data-target="#styleBrowser2Body" style="background-color: #d63b3f;">
							<h4 class="panel-title">
								<a data-toggle="collapse" data-parent="#styleBrowser2" href="#styleBrowser2Body">
								<a class="accordion-toggle"> <span class="pull-right slideupdowntogglered glyphicon glyphicon-chevron-up"></span>Final Cost Sheets That Need Your Attention</a> </a>
							</h4>
						</div>
						<div id="styleBrowser2Body" class="panel-collapse collapse">
							<div class="panel-body">
								<div class="dataTables_wrapper margintop20">

										<display:table name="mercostsheethdrdueList" class="fcsRout display table table-striped table-bordered" requestURI="" id="mercostsheethdrdueList" export="true" pagesize="25">
											<display:column property="id.costSheetNo" headerClass="textcenter" class="textcenter" sortable="true" titleKey="mercostsheethdr.id.costSheetNo"/>
											<display:column property="createDate" headerClass="textcenter" sortable="true" titleKey="mercostsheethdr.createDate" class="tablemin textcenter"/>
											<display:column property="compWiseCost" headerClass="textcenter" sortable="true" titleKey="mercostsheethdr.compWiseCost" class="tablemin textcenter"/>
											<display:column property="totalSmv" headerClass="textcenter" sortable="true" titleKey="mercostsheethdr.totalSmv" class="tablemin textcenter"/>
											<%-- <display:column property="mstcurrencyByDftRmCurrency" sortable="true" titleKey="mercostsheethdr.mstcurrencyByDftRmCurrency"/>--%>
<%-- 											<display:column property="mstcurrencyByCostSheetCurrency.curName" sortable="true" titleKey="mercostsheethdr.mstcurrencyByCostSheetCurrency"/> --%>
<%-- 											<display:column property="totalCost" sortable="true" titleKey="mercostsheethdr.totalCost" class="tablemin"/> --%>
<%-- 											<display:column property="sellingPrice" sortable="true" titleKey="mercostsheethdr.sellingPrice" class="tablemin"/> --%>
<%-- 											<display:column property="sellingPrice" sortable="true" titleKey="mercostsheethdr.preCostSheet" class="tablemin"/> --%>
											
											<display:column media="html" class="headcol2 textcenter" headerClass="headcol textcenter statuschange" titleKey="<a>Status</a>">
												<c:if test="${mercostsheethdrdueList.flag == 'Incomplete'}">
													<div class="pdnIncomplete">${mercostsheethdrdueList.flag}</div>
												</c:if>
												
												<c:if test="${mercostsheethdrdueList.flag == 'Completed'}">
													<div class="pdnCompleted">${mercostsheethdrdueList.flag}</div>
												</c:if>
												
												<c:if test="${mercostsheethdrdueList.flag == 'Rejected'}">
													<div class="pdnApproval">${mercostsheethdrdueList.flag}</div>
												</c:if>
											</display:column>
										   
											<display:column media="html" class="textcenter headcol3 actionsfinalcost1" headerClass="headcol3 textcenter actionsfinalcost" titleKey="<a>Actions</a>">
												<div class="middle-align">
													 <div class="edit-toggle editicons order_sheet_avalable_planning_action">
															<a href="mercostsheethdrform?costSheetNo=${mercostsheethdrdueList.id.costSheetNo}&costSheetType=${mercostsheethdrdueList.id.costSheetType}&versionNo=${mercostsheethdrdueList.id.versionNo}&editmode=true"><span class="glyphicon glyphicon-pencil"></span> Edit</a>
														</div>
														<div class="view-toggle">
														   <a href="mercostsheethdrview?costSheetNo=${mercostsheethdrdueList.id.costSheetNo}&costSheetType=${mercostsheethdrdueList.id.costSheetType}&versionNo=${mercostsheethdrdueList.id.versionNo}&view=true"><span class="glyphicon glyphicon-eye-open"></span> View </a>
													   </div>
														<div class="delete-toggle editicons order_sheet_avalable_planning_action">
															<a href="mercostsheethdrview?costSheetNo=${mercostsheethdrdueList.id.costSheetNo}&costSheetType=${mercostsheethdrdueList.id.costSheetType}&versionNo=${mercostsheethdrdueList.id.versionNo}&delete=true" data-toggle="modal" data-target=".delete-confirmation"><span class="glyphicon glyphicon-remove"></span> Delete </a>
														</div>
													 </div>			
											   </display:column>
											<display:setProperty name="paging.banner.item_name"><fmt:message key="mercostsheethdrList.mercostsheethdr"/></display:setProperty>
											<display:setProperty name="paging.banner.items_name"><fmt:message key="mercostsheethdrList.mercostsheethdrs"/></display:setProperty>

											<display:setProperty name="export.excel.filename"><fmt:message key="mercostsheethdrList.title"/>.xls</display:setProperty>
											<display:setProperty name="export.csv.filename"><fmt:message key="mercostsheethdrList.title"/>.csv</display:setProperty>
											<display:setProperty name="export.pdf.filename"><fmt:message key="mercostsheethdrList.title"/>.pdf</display:setProperty>
										</display:table>

								</div>
							</div>
						</div>
					</div>
				</div> 
			</div> 
		</div>
	</div><!-- end of tab content 1 -->

	<div class="tab-pane " id="fcsmain2">
        <div class="row paddingleft20">
			<form method="get" action="${ctx}/mercostsheethdrs" id="searchFormPreCS" class="form-inline">
				<div class="col-sm-4 col-md-4 ">
					<div class="form-group formwithsearch marginbottom20">
						<div class="icon-addon addon-md">
							<label for="exampleInputEmail1">Buyer </label>
							<select required="required"  name="custCode" id="pcs_id_custCode" onfocus="getOptions('pcs_id_custCode','mstcustomer')" class="form-control" >
									<option selected="selected">${param.custCode}</option>
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
							<select required="required"  name="locationCode" id="pcs_id_locationCode" class="form-control" onfocus="getOptions('pcs_id_locationCode','mstlocations')"> 
								<c:if test="${param.locationCode!=null}">
								<option selected="selected">${param.locationCode}</option>
								</c:if>
								<c:if test="${param.locationCode ==null}">
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
							<select required="required" type="text" name="depCode" id="pcs_id_depCode" onfocus="optionsforgencodes('pcs_id_depCode','BUYDEM')" class="form-control" >
									<option selected="selected">${param.depCode}</option>
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
								<input required="required" type="text" name="styleId" id="pcs_id_styleId"  class="form-control" class="typeahead form-control" data-provide="typeahead" value='${param.styleId}' onfocus="typaheadforStyle('pcs_id_styleId','id.styleId')" >
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
							<select  required="required"  name="compCode" id="pcs_id_compCode" onfocus="getOptions('pcs_id_compCode','mstcompany')" class="form-control" >
									<option selected="selected">${param.compCode}</option>
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
							<input  type="text" name="styleDescription" id="pcs_styleDescription" value='${param.styleDescription}' class="form-control" readonly="readonly">
						</div>
					</div>  
					<div class="clearfix"></div>
				</div>
				<div class="col-sm-4 col-md-4">
					<div class="form-group formwithsearch marginbottom20">
						<div class="icon-addon addon-md">
							<label for="exampleInputEmail1">Season</label>
							<select required="required"  name="season" id="pcs_season" class="form-control" onfocus="optionsforgencodes('pcs_season','SEASON')" >
								<option selected="selected">${param.season}</option>
							</select>						
						</div>
					</div>  
					<div class="btn-group formsearchbtn btn-model-select-div">
						<button onclick="$('#pcs_season').trigger('onfocus'); addmodalpopup('pcs_season')" type="button" class="btn btn-primary btn-xs dropdown-toggle " data-toggle="modal" data-target="#schmodalpopup" ><span class="glyphicon glyphicon-search"></span></button>
					</div>
					<div class="clearfix"></div> 		  
				</div> 
				<div class="col-sm-4 col-md-4">
					<button type="button" onclick="finalWithPre();" name="precostsheet" class="btn btn-info btn-embossed search-routes-btn"><span class="glyphicon glyphicon-search"></span>&nbsp;Search PCS</button>
					<button type="button" onclick="finalWithPreReset();" class="replace-data btn btn-defalt btn-embossed search-routes-btn"><span class="glyphicon glyphicon-refresh"></span> Reset</button>
				</div>
			</form>
		</div>

		<div class="row paddingleft20">
			<div class="col-sm-12 col-md-12">
				<div class="panel-group" id="costSheet">
					<div class="panel panel-default">
						<div class="panel-heading" data-toggle="collapse" data-parent="#costSheet" data-target="#costSheetBody">
							<h4 class="panel-title">
								<a data-toggle="collapse" data-parent="#costSheet" href="#costSheetBody"> 
								</a><a class="accordion-toggle"> <span class="pull-right slideupdowntoggle glyphicon glyphicon-chevron-up"></span>Create Final cost sheet with Pre cost sheet</a>  
							</h4>
						</div>
						<div id="costSheetBody" class="panel-collapse collapse" style="height: auto;">
							<div class="panel-body">
								<div class="row">
									<div class="pull-right margin-addstyleroute">
										<div class="input-group custom-search-form " style="width: 390px;">
											<c:if test="${merprecostsheethdrAppList != null}">
												<input  type="text" onkeypress="checkenter(event)" size="20" name="q" id="pquery1"  value="${param.q}" class="form-control" placeholder="Search and Filter"/>
												<span class="input-group-btn">
													<button onclick="getpreCostsheets(1)" id="button.search" type="button" class="btn btn-info search-form-btn" type="submit">
														<span class="glyphicon glyphicon-search"></span>
													</button>
												</span>
											</c:if>
										</div><!-- /input-group -->

									</div>                   
								</div>
								<div class="dataTables_wrapper Scroll-for-datatable">
									<section class="masterclass">
										<display:table name="merprecostsheethdrList" class="display table table-striped table-bordered" requestURI="" id="merprecostsheetList" export="true" pagesize="25">
											 <display:setProperty name="export.csv.include_header" value="true" />
											<display:column property="id.preCostSheetNo" sortable="true"   titleKey="merprecostsheet.id.preCostSheetNo" class="precostsheetsnew" headerClass="precostsheetsnew"/>
											<display:column property="id.versionNo" sortable="true" headerClass="textcenter" class="textcenter" titleKey="merprecostsheet.id.versionNo"/>
											<display:column property="baseBody" sortable="true" headerClass="textcenter" class="textcenter" titleKey="merprecostsheet.baseBody"/>
											<display:column property="buyerCommission" sortable="true" headerClass="textcenter" class="textcenter" titleKey="merprecostsheet.buyerCommission"/>
											<display:column property="buyerReference" sortable="true" headerClass="textcenter" class="textcenter" titleKey="merprecostsheet.buyerReference"/>
											<display:column property="cm" sortable="true" headerClass="textcenter" class="textcenter" titleKey="merprecostsheet.cm"/>
											<display:column property="cmt" sortable="true" headerClass="textcenter" class="textcenter" titleKey="merprecostsheet.cmt"/>
											<display:column property="compWiseCost" sortable="true" headerClass="textcenter" class="textcenter" titleKey="merprecostsheet.compWiseCost"/>
											<display:column property="costSheetExchangeRate" sortable="true" headerClass="textcenter" class="textcenter" titleKey="merprecostsheet.costSheetExchangeRate"/>
											<display:column property="id.costsheetType" sortable="true" headerClass="textcenter" class="textcenter" titleKey="merprecostsheet.costsheetType"/>
											<display:column property="createdOn" sortable="true" headerClass="textcenter" class="textcenter" titleKey="merprecostsheet.createDate"/>
											<display:column property="deliveryTerm" sortable="true" headerClass="textcenter" class="textcenter" titleKey="merprecostsheet.deliveryTerm"/>
											<display:column property="destinationCountry" sortable="true" headerClass="textcenter" class="textcenter" titleKey="merprecostsheet.destinationCountry"/>
											<display:column property="dftRmExchangeRate" sortable="true" headerClass="textcenter" class="textcenter" titleKey="merprecostsheet.dftRmExchangeRate"/>
											<display:column property="externalCommission" sortable="true" headerClass="textcenter" class="textcenter" titleKey="merprecostsheet.externalCommission"/>
											<display:column property="financeCost" sortable="true" class="textcenter valied_till_text" headerClass="textcenter" titleKey="merprecostsheet.financeCost"/>
											<display:column media="html" class="headcol newone1 textcenter" headerClass="headcol newone textcenter" sortable="true" titleKey="Status">
												<c:if test="${merprecostsheetList.flag == 'Completed'}">
													<div class="pdnCompleted">${merprecostsheetList.flag}</div>
												</c:if>
												<c:if test="${merprecostsheetList.flag == 'Pending'}">
													<div class="pdnApproval">${merprecostsheetList.flag}</div>
												</c:if>
											</display:column>
											<%-- <display:column property="flag" sortable="true" titleKey="merprecostsheet.flag"/> --%>
											<display:column property="markupAmount" sortable="true" headerClass="textcenter" class="textcenter" titleKey="merprecostsheet.markupAmount"/>
											<display:column property="merchandiser.userId" sortable="true" headerClass="textcenter" class="textcenter" titleKey="merprecostsheet.merchandiser"/>
											<display:column property="ourPrice" sortable="true" headerClass="textcenter" class="textcenter" titleKey="merprecostsheet.ourPrice"/>
											<display:column property="remarks" sortable="true" headerClass="textcenter" class="textcenter" titleKey="merprecostsheet.remarks"/>
											<display:column property="rowMaterialValue" headerClass="textcenter" class="textcenter" sortable="true" titleKey="merprecostsheet.rowMaterialValue"/>
											<display:column property="season" sortable="true" headerClass="textcenter" class="textcenter" titleKey="merprecostsheet.season"/>
<%-- 											<display:column property="sellingPrice" sortable="true" titleKey="merprecostsheet.sellingPrice"/> --%>
											<display:column property="serviceValue" sortable="true" headerClass="textcenter" class="textcenter" titleKey="merprecostsheet.serviceValue"/>
											<display:column property="shipmentMode" sortable="true" headerClass="textcenter" class="textcenter" titleKey="merprecostsheet.shipmentMode"/>
											<display:column property="totalCost" sortable="true" headerClass="textcenter" class="textcenter" titleKey="merprecostsheet.totalCost"/>
											<display:column property="totalSmv" sortable="true" headerClass="textcenter" class="textcenter" titleKey="merprecostsheet.totalSmv"/>
											<display:column property="validTill" sortable="true" headerClass="textcenter" class="textcenter" titleKey="merprecostsheet.validTill"/>
											<display:column media="html" class="headcol newone1" headerClass="headcol newone" sortable="true" titleKey="Status">
												<c:if test="${merprecostsheetList.flag == 'Completed'}">
													<div class="pdnCompleted">${merprecostsheetList.flag}</div>
												</c:if>
												<c:if test="${merprecostsheetList.flag == 'Pending'}">
													<div class="pdnApproval">${merprecostsheetList.flag}</div>
												</c:if>
											</display:column>
											<%-- <display:column property="flag" sortable="true" titleKey="merprecostsheet.flag"/> --%>
											
											<display:column media="html" class="headcol2 textcenter" headerClass="headcol2 newoney textcenter" titleKey="<a>Create final Cost Sheet</a>">
												<div class="operations-toggle">
													<a  href="mercostsheethdrform?preCostSheetNo=${merprecostsheetList.id.preCostSheetNo}&preVersionNo=${merprecostsheetList.id.versionNo}&preCostsheetType=${merprecostsheetList.id.costsheetType}&custCode=${merprecostsheetList.mststyleheader.id.custCode}&locationCode=${merprecostsheetList.mststyleheader.id.locationCode}&depCode=${merprecostsheetList.mststyleheader.id.depCode}&styleId=${merprecostsheetList.mststyleheader.id.styleId}&compCode=${merprecostsheetList.mststyleheader.id.compCode}&styleDescription=${merprecostsheetList.mststyleheader.styleDescription}&season=${merprecostsheetList.season}&edit=editmode">
													<span class="fa fa-wrench marginRight5"></span> Create Final CS</a> 
<%-- 													<a href="merprecostsheetform?OpenAs=true&preCostSheetNo=${merprecostsheetList.id.preCostSheetNo}&versionNo=${merprecostsheetList.id.versionNo}&costsheetType=${merprecostsheetList.id.costsheetType}&edit=editmode">--%>
												</div>
											</display:column>

											<display:column media="html" class="textcenter headcol3 create_finalcostsheet_action_view" headerClass="textcenter headcol3 newonez " titleKey="<a>Action</a>">
												<div class="middle-align">
													<div  class="view-toggle">
														<a href="merprecostsheetsview?preCostSheetNo=${merprecostsheetList.id.preCostSheetNo}&versionNo=${merprecostsheetList.id.versionNo}&costsheetType=${merprecostsheetList.id.costsheetType}">
														<span class="glyphicon glyphicon-eye-open"></span> View </a>
													</div>
<!-- 													<div class="delete-toggle"> -->
<%-- 														<a href="merprecostsheetsview?delete=true&preCostSheetNo=${merprecostsheetList.id.preCostSheetNo}&versionNo=${merprecostsheetList.id.versionNo}&costsheetType=${merprecostsheetList.id.costsheetType}"> --%>
<!-- 														<span class="glyphicon glyphicon-remove"></span> Delete </a>  -->
<!-- 													</div> -->
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

		<div class="row paddingleft20">
			<div class="col-sm-12 col-md-12">
				<div class="panel-group" id="buyerApprovedPCS">
					<div class="panel panel-default">
						<div class="panel-heading" data-toggle="collapse" data-parent="#buyerApprovedPCS" data-target="#buyerApprovedPCSBody" >
							<h4 class="panel-title">
								<a data-toggle="collapse" data-parent="#buyerApprovedPCS" href="#buyerApprovedPCSBody" class="collapsed"> 
								</a><a class="accordion-toggle"> <span class="pull-right slideupdowntoggle glyphicon glyphicon-chevron-up"></span>Buyer approved Pre cost sheets</a>  
							</h4>
						</div>
						<div id="buyerApprovedPCSBody" class="panel-collapse collapse" style="height: auto;">
							<div class="panel-body">

								<div class="row">

									<div class="pull-right margin-addstyleroute">
										<div class="input-group custom-search-form " style="width: 390px;">
											<c:if test="${merprecostsheethdrAppList != null}">
												<input  type="text" onkeypress="checkenter(event)" size="20" name="q" id="pquery2"  value="${param.q}" class="form-control" placeholder="Search and Filter"/>
												<span class="input-group-btn">
													<button onclick="getpreCostsheets(2)" id="button.search" type="button" class="btn btn-info search-form-btn" type="submit">
														<span class="glyphicon glyphicon-search"></span>
													</button>
												</span>
											</c:if>
										</div><!-- /input-group -->

									</div>                   
								</div>

								<div class="dataTables_wrapper Scroll-for-datatable margintop20">
									<section class="finalcost_sheet_approve">
										<display:table name="merprecostsheethdrAppList" class="display routId table table-striped table-bordered" requestURI="" id="merprecostsheethdrAppList" export="true" pagesize="25">
											 <display:setProperty name="export.csv.include_header" value="true" />
											<display:column property="id.preCostSheetNo" sortable="true" headerClass="textcenter" class="textcenter" titleKey="merprecostsheet.id.preCostSheetNo"/>
											<display:column property="id.versionNo" sortable="true" headerClass="textcenter" class="textcenter" titleKey="merprecostsheet.id.versionNo"/>
											<display:column property="baseBody" sortable="true" headerClass="textcenter" class="textcenter" titleKey="merprecostsheet.baseBody"/>
											<display:column property="buyerCommission" sortable="true" headerClass="textcenter" class="textcenter" titleKey="merprecostsheet.buyerCommission"/>
											<display:column property="buyerReference" sortable="true" headerClass="textcenter" class="textcenter" titleKey="merprecostsheet.buyerReference"/>
											<display:column property="cm" sortable="true" headerClass="textcenter" class="textcenter" titleKey="merprecostsheet.cm"/>
											<display:column property="cmt" sortable="true" headerClass="textcenter" class="textcenter" titleKey="merprecostsheet.cmt"/>
											<display:column property="compWiseCost" sortable="true" headerClass="textcenter" class="textcenter" titleKey="merprecostsheet.compWiseCost"/>
											<display:column property="costSheetExchangeRate" sortable="true" headerClass="textcenter" class="textcenter" titleKey="merprecostsheet.costSheetExchangeRate"/>
											<display:column property="id.costsheetType" sortable="true" headerClass="textcenter" class="textcenter" titleKey="merprecostsheet.costsheetType"/>
											<display:column property="createdOn" sortable="true" headerClass="textcenter" class="textcenter" titleKey="merprecostsheet.createDate"/>
											<display:column property="deliveryTerm" sortable="true" headerClass="textcenter" class="textcenter" titleKey="merprecostsheet.deliveryTerm"/>
											<display:column property="destinationCountry" sortable="true" headerClass="textcenter" class="textcenter" titleKey="merprecostsheet.destinationCountry"/>
											<display:column property="dftRmExchangeRate" sortable="true" headerClass="textcenter" class="textcenter" titleKey="merprecostsheet.dftRmExchangeRate"/>
											<display:column property="externalCommission" sortable="true" headerClass="textcenter" class="textcenter" titleKey="merprecostsheet.externalCommission"/>
											<display:column property="financeCost" sortable="true" headerClass="textcenter" class="textcenter" titleKey="merprecostsheet.financeCost"/>
											<%-- <display:column property="flag" sortable="true" titleKey="merprecostsheet.flag"/> --%>
											<display:column property="markupAmount" sortable="true" headerClass="textcenter" class="textcenter" titleKey="merprecostsheet.markupAmount"/>
											<display:column property="merchandiser.userId" sortable="true" headerClass="textcenter" class="textcenter" titleKey="merprecostsheet.merchandiser"/>
											<display:column property="ourPrice" sortable="true" headerClass="textcenter" class="textcenter" titleKey="merprecostsheet.ourPrice"/>
											<display:column property="remarks" sortable="true" headerClass="textcenter" class="textcenter" titleKey="merprecostsheet.remarks"/>
											<display:column property="rowMaterialValue" sortable="true" headerClass="textcenter" class="textcenter" titleKey="merprecostsheet.rowMaterialValue"/>
											<display:column property="season" sortable="true" headerClass="textcenter" class="textcenter" titleKey="merprecostsheet.season"/>
<%-- 											<display:column property="sellingPrice" sortable="true" titleKey="merprecostsheet.sellingPrice"/> --%>
											<display:column property="serviceValue" sortable="true" headerClass="textcenter" class="textcenter" titleKey="merprecostsheet.serviceValue"/>
											<display:column property="shipmentMode" sortable="true" headerClass="textcenter" class="textcenter" titleKey="merprecostsheet.shipmentMode"/>
											<display:column property="totalCost" sortable="true" headerClass="textcenter" class="textcenter" titleKey="merprecostsheet.totalCost"/>
											<display:column property="totalSmv" sortable="true" headerClass="textcenter" class="textcenter" titleKey="merprecostsheet.totalSmv"/>
											<display:column property="validTill" sortable="true" headerClass="textcenter" class="textcenter" titleKey="merprecostsheet.validTill"/>
											<display:column media="html" class="headcol buyer_approved_precost_sheet_text" headerClass="headcol buyer_approved_precost_sheet" sortable="true" titleKey="Status">
												<c:if test="${merprecostsheetList.flag == 'Approved'}">
													<div class="pdnCompleted">${merprecostsheetList.flag}</div>
												</c:if>
											</display:column>
											<display:column media="html" class="headcol2 style_order" headerClass="headcol2 buyer_approved_precost_sheet_action" titleKey="<a>Create final Cost Sheet</a>">
												<div class="operations-toggle">
													<a  href="mercostsheethdrform?preCostSheetNo=${merprecostsheethdrAppList.id.preCostSheetNo}&preVersionNo=${merprecostsheethdrAppList.id.versionNo}&preCostsheetType=${merprecostsheethdrAppList.id.costsheetType}&custCode=${merprecostsheethdrAppList.mststyleheader.id.custCode}&locationCode=${merprecostsheethdrAppList.mststyleheader.id.locationCode}&depCode=${merprecostsheethdrAppList.mststyleheader.id.depCode}&styleId=${merprecostsheethdrAppList.mststyleheader.id.styleId}&compCode=${merprecostsheethdrAppList.mststyleheader.id.compCode}&styleDescription=${merprecostsheethdrAppList.mststyleheader.styleDescription}&season=${merprecostsheethdrAppList.season}&edit=editmode">
													<span class="fa fa-wrench marginRight5"></span>Create Final CS</a>
												</div>
											</display:column>
											
											<display:column media="html" class="textcenter headcol3 buyer_approved_precost_sheet_action_icons" headerClass="textcenter headcol3 buyer_approved_precost_sheet_action" titleKey="<a>Action</a>">
												<div class="middle-align">
													<div  class="view-toggle">
														<a href="merprecostsheetsview?preCostSheetNo=${merprecostsheethdrAppList.id.preCostSheetNo}&versionNo=${merprecostsheethdrAppList.id.versionNo}&costsheetType=${merprecostsheethdrAppList.id.costsheetType}">
														<span class="glyphicon glyphicon-eye-open"></span> View </a>
													</div>
													
<!-- 													<div class="edit-toggle"> -->
<%-- 														<c:if test="${merprecostsheetList.id.versionNo=='0'}"><a  href="merprecostsheetform?preCostSheetNo=${merprecostsheetList.id.preCostSheetNo}&versionNo=${merprecostsheetList.id.versionNo}&costsheetType=${merprecostsheetList.id.costsheetType}&edit=editmode"><span class="glyphicon glyphicon-pencil disabled "></span> Edit</a></c:if> 													 --%>
<!-- 													</div> -->
<!-- 													<div class="delete-toggle"> -->
<%-- 														<a href="merprecostsheetsview?delete=true&preCostSheetNo=${merprecostsheetList.id.preCostSheetNo}&versionNo=${merprecostsheetList.id.versionNo}&costsheetType=${merprecostsheetList.id.costsheetType}"> --%>
<!-- 														<span class="glyphicon glyphicon-remove"></span> Delete </a>  -->
<!-- 													</div> -->
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
	</div>  <!-- tab pain two ends -->    
</div>

 <script>$('#nav-dropdown .dropdown-menu').on({
    "click":function(e){
      e.stopPropagation();
    }
 });
 
 $(document).ready(function(){
 	if("${fcsmain2}"=="true"){
		navigateFinalSheet('fcsmain2');
	}
 	$('#searchFormInit').validate({ // initialize the plugin
        rules: {
        	cs_id_custCode:{
        		required: true
        	},
        	cs_id_depCode: {
            	required: true
    		},
    		cs_id_compCode: {
    			required: true
    		},
    		cs_id_locationCode:{
    			required: true
    		},
    		cs_id_styleId:{
    			required: true
    		},
    		cs_season :{
    			required: true
        	}
        }
        ,errorPlacement: function(error,element){
        	parentDiv = element.parents('.form-group');
    		errorDiv = parentDiv.children(".feedback");
    		error.appendTo(errorDiv);
    	},
        success: function( label ) {
        	
        }
    });
 	
 	$('#costSheetGeneralForm').validate({ // initialize the plugin
        rules: {
        	costSheetType:{
        		required: true
        	},
        	merchandiser: {
            	required: true
    		},
    		orderQty: {
    			required: true
    		},
    		destination_country_chosen:{
    			required: true
    		}
        }
        ,errorPlacement: function(error,element){
        	parentDiv = element.parents('.form-group');
    		errorDiv = parentDiv.children(".feedback");
    		error.appendTo(errorDiv);
    	},
        success: function( label ) {
        	
        }
    });
 });
 
 </script>  

