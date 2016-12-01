<%@ include file="/common/taglibs.jsp"%>
<script src="scripts/applicationjs/merordersheethdr.js"></script>

<head>
    <title><fmt:message key="merordersheethdrList.title"/></title>
    <meta name="menu" content="MerordersheethdrMenu"/>
</head>
<script src="scripts/applicationjs/ordersheet.js"></script>
<c:if test="{'$'}{not empty searchError}">
    <div class="alert alert-danger alert-dismissable">
        <a href="#" data-dismiss="alert" class="close">&times;</a>
        <c:out value="{'$'}{searchError}"/>
    </div>
</c:if>

<div class="row form-group paddingleft20"> <!-- NAVIGATION PILLS -->
	<div class="col-xs-8"><h2>Order Sheets - Order Planning Sheets</h2></div>
	<div class="col-xs-4 styletoure-hrline">
		<ul class="nav nav-justified setup-panel" id="myTab">
			<li id="naddNewFinalCostSheet" class="active"><a  data-toggle="tab">
				<button onclick="ordersheetnavigation('addNewFinalCostSheet');" type="button" class="btn btn-default btn-circle"><span class="fa fa-slideshare"></span></button>
				<p class="list-group-item-text">Planning Order</p> </a>
			</li>
			<li id="naddFinalCS" ><a  data-toggle="tab">
				<button  onclick="ordersheetnavigation('addFinalCS');" type="button" class="btn btn-default btn-circle"><span class="fa fa-spinner"></span></button>
				<p class="list-group-item-text">Processing Order</p></a>
			</li>     
		</ul>
	</div>
</div>  <!-- NAVIGATION PILLS END-->


<div class="tab-content"> <!-- TAB CONTENT MAIN -->
	<div class="tab-pane active" id="addNewFinalCostSheet">
		
		<form  method="get" action="merordersheethdrs" class="well" id="merordersheethdrsfrm" >
			<div class="row paddingleft20">
					<c:if test="${mststyleheader.id.styleId == null}">
						<c:set var="disabled" scope="session" value=""/>
					</c:if>
					<c:if test="${mststyleheader.id.styleId != null}">
						<c:set var="disabled" scope="session" value="readonly"/>
					</c:if>
					
				<div class="col-sm-4 col-md-4 ">
					<div class="form-group formwithsearch marginbottom20">
						<div class="icon-addon addon-md">
							<label for="exampleInputEmail1">Buyer </label>
							<select ${disabled} required="required" type="text" name="custCode" id="id_custCode" onfocus="getOptions('id_custCode','mstcustomer')" class="form-control" >
								<c:if test="${mststyleheader.id.custCode!=null}">
									<option selected="selected">${mststyleheader.id.custCode}</option>
								</c:if>
								<c:if test="${mststyleheader.id.custCode ==null}">
										<option selected="selected">${param.custCode}</option>									
								</c:if>
							</select>
							
						</div>
					</div>  
					<div class="btn-group formsearchbtn btn-model-select-div">
						<button onclick="$('#id_custCode').trigger('onfocus'); addmodalpopup('id_custCode')" type="button" class="btn btn-primary btn-xs dropdown-toggle " data-toggle="modal" data-target="#schmodalpopup" ><span class="glyphicon glyphicon-search"></span></button>
					</div>
					
					<div class="clearfix"></div> 
					<div class="form-group formwithsearch marginbottom20">
						<div class="icon-addon addon-md">
							<label for="exampleInputEmail1">Style Location</label>
							<select ${disabled} required="required" type="text" name="locationCode" id="id_locationCode" class="form-control" onfocus="getOptions('id_locationCode','mstlocations')"> 
								<c:if test="${mststyleheader.id.locationCode!=null}">
									<option selected="selected">${mststyleheader.id.locationCode}</option>
								</c:if>
								<c:if test="${mststyleheader.id.locationCode == null}">		
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
						<button onclick="$('#id_locationCode').trigger('onfocus'); addmodalpopup('id_locationCode')" type="button" class="btn btn-primary btn-xs dropdown-toggle " data-toggle="modal" data-target="#schmodalpopup" ><span class="glyphicon glyphicon-search"></span></button>
					</div>
					<div class="clearfix"></div> 
				</div>
		
				<div class="col-sm-4 col-md-4 ">
					<div class="form-group formwithsearch marginbottom20">
						<div class="icon-addon addon-md">
							<label for="exampleInputEmail1">Buyer Department</label>
							<select ${disabled}  required="required" type="text" name="depCode" id="id_depCode" onfocus="optionsforgencodes('id_depCode','BUYDEM')" class="form-control" >
								<c:if test="${mststyleheader.id.depCode != null}">
									<option selected="selected">${mststyleheader.id.depCode}</option>
								</c:if>
								<c:if test="${mststyleheader.id.depCode == null}">		
									<option selected="selected">${param.depCode}</option>
								</c:if>
							</select>
							
						</div>
					</div>  
					<div class="btn-group formsearchbtn btn-model-select-div">
						<button onclick="$('#id_depCode').trigger('onfocus'); addmodalpopup('id_depCode')" type="button" class="btn btn-primary btn-xs dropdown-toggle " data-toggle="modal" data-target="#schmodalpopup" ><span class="glyphicon glyphicon-search"></span></button>
					</div>
					<div class="clearfix"></div> 

					<div class="form-group formwithsearch marginBottom20">
						<div class="icon-addon addon-md">
							<label for="exampleInputEmail1">Style</label>
							<div class="input-group">
								<input ${disabled}  required="required" type="text" name="styleId" id="id_styleId"  class="form-control" class="typeahead form-control" data-provide="typeahead" value='<c:if test="${mststyleheader.id.styleId!=null}">${mststyleheader.id.styleId}</c:if><c:if test="${mststyleheader.id.styleId ==null}"> ${param.styleId}</c:if>' 
								 onfocus="typaheadforStyle('id_styleId','id.styleId')" >
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
						<button onclick="addmodalpopup('id_styleId')" type="button" class="btn btn-primary btn-xs dropdown-toggle " data-toggle="modal" data-target="#schmodalpopup" ><span class="glyphicon glyphicon-search"></span></button>
					</div>
					<div class="clearfix"></div> 

				</div>
		
				<div class="col-sm-4 col-md-4 ">
					<div class="form-group formwithsearch marginbottom20">
						<div class="icon-addon addon-md">
							<label for="exampleInputEmail1">Company</label>
							<select ${disabled}  required="required" type="text" name="compCode" id="id_compCode" onfocus="getOptions('id_compCode','mstcompany')" class="form-control" >
								<c:if test="${mststyleheader.id.compCode!=null}">
									<option selected="selected">${mststyleheader.id.compCode}</option>
								</c:if>
								<c:if test="${mststyleheader.id.compCode == null}">
									<c:if test="${param.custCode == null}">
										<c:forEach items="${mstparam}" var="mstparams">	
												<option selected="selected">${mstparams.commonCompCode}</option>
										</c:forEach>
									</c:if>
									<c:if test="${param.custCode != null}">
										<option selected="selected">${param.compCode}</option>
									</c:if>
								</c:if>
							</select>
							
						</div>
					</div>  
					<div class="btn-group formsearchbtn btn-model-select-div">
						<button onclick="$('#id_compCode').trigger('onfocus'); addmodalpopup('id_compCode')" type="button" class="btn btn-primary btn-xs dropdown-toggle " data-toggle="modal" data-target="#schmodalpopup" ><span class="glyphicon glyphicon-search"></span></button>
					</div>
					<div class="clearfix"></div>
				</div>

				<div class="col-sm-4 col-md-4 ">
					<div class="form-group formwithsearch marginbottom20">
						<div class="icon-addon addon-md">
							<label for="exampleInputEmail1">Style Description</label>
							<input  type="text" name="styleDescription" id="id_styleDescription" value='<c:if test="${mststyleheader.styleDescription!=null}">${mststyleheader.styleDescription}</c:if><c:if test="${mststyleheader.styleDescription ==null}">${param.styleDescription}</c:if>' class="form-control" readonly="readonly">
						</div>
					</div>  
					<div class="clearfix"></div>
				</div>	
				<div class="col-sm-4 col-md-4">
					<div class="form-group formwithsearch marginbottom20">
						<div class="icon-addon addon-md">
							<label for="exampleInputEmail1">Season</label>
							<select required="required" type="text" name="season" id="season" class="form-control" onfocus="optionsforgencodes('season','SEASON')" >
								<c:if test="${season!=null}">
									<option selected="selected">${season}</option>
								</c:if>
								<c:if test="${season ==null}">
									<option selected="selected">${param.season}</option>
								</c:if>
							</select>							
						</div>
					</div> 		
					<div class="btn-group formsearchbtn btn-model-select-div">
						<button onclick="$('#season').trigger('onfocus'); addmodalpopup('season')" type="button" class="btn btn-primary btn-xs dropdown-toggle " data-toggle="modal" data-target="#schmodalpopup" ><span class="glyphicon glyphicon-search"></span></button>
					</div>					
					<div class="clearfix"></div> 
				</div>
				<div class="col-sm-4 col-md-4">
					<button type="submit" class="btn btn-info btn-embossed search-routes-btn" ><span class="glyphicon glyphicon-search"></span>Select Style</button>
					<button type="button" class="reset replace-data btn btn-defalt btn-embossed search-routes-btn"><span class="glyphicon glyphicon-refresh"></span>Reset</button>
				</div>
			</div>
		</form>
		<div class="row paddingleft20">
			<div class="col-sm-12 col-md-12">
				<div class="panel-group" id="stylebrowsers">
					<div class="panel panel-default">
						<div class="panel-heading" data-toggle="collapse" data-parent="#stylebrowsers" data-target="#styleBrowserBody">
							<h4 class="panel-title">
								<a data-toggle="collapse" data-parent="#stylebrowsers" href="#styleBrowserBody"> 
								<a class="accordion-toggle"> <span class="pull-right slideupdowntoggle glyphicon glyphicon-chevron-up"></span>Available Planning Order</a> </a> 
							</h4>
						</div>
						<div id="styleBrowserBody" class="panel-collapse collapse">
							<div class="panel-body">
								<div class="row">                    
									<div class="pull-right margin-addstyleroute">
										<div class="input-group custom-search-form " style="width: 390px;">
											<c:if test="${merordersheethdrList != null}">
												<input  type="text" onkeypress="checkenter(event,'')" size="20" name="q" id="query"  value="${param.q}" class="form-control" placeholder="Search and Filter"/>
												<span class="input-group-btn">
													<button onclick="schOrdersheet('')" id="button.search" type="button" class="btn btn-info search-form-btn" type="submit">
														<span class="glyphicon glyphicon-search"></span>
													</button>
												</span>
											</c:if>
											<a onclick="AddOrdersheet('')" class="btn btn-warning btn-embossed pull-right"><span class="glyphicon glyphicon-plus marginRight4"></span>Add Processing Order</a>
										</div><!-- /input-group -->                       
									</div>                   
								</div>
								<div class="dataTables_wrapper Scroll-for-datatable">
									<section class="posSection_data">
									<!--<th class="textcenter">Buyer</th>
													<th class="textcenter">Style Description</th>
													<th class="headcol2 textcenter">Create Processing Order</th>                      
													<th class="textcenter headcol3">Actions</th>-->    
										<display:table name="merordersheethdrList" class="table table-condensed table-striped table-hover table-bordered" requestURI="" id="merordersheethdrList" export="true" pagesize="25">
											<display:column property="buyer" headerClass="textcenter" class="textcenter" sortable="true" titleKey="merordersheethdr.Buyer"/>
											<display:column property="mststyleheader.id.styleId" headerClass="textcenter" class="textcenter" sortable="true" titleKey="merordersheethdr.Style"/>
											<display:column property="id" media="csv excel xml pdf" headerClass="textcenter" class="textcenter" titleKey="merordersheethdr.id.planingOrdersheetNo"/>
											<display:column property="remarks" headerClass="textcenter" class="textcenter" sortable="true" titleKey="merordersheethdr.remarks"/>
											<display:column property="status" headerClass="textcenter" class="textcenter" sortable="true" titleKey="merordersheethdr.status"/>
											<display:column property="totalQty" headerClass="textcenter" class="textcenter" sortable="true" titleKey="merordersheethdr.totalQty"/>
											<display:column property="createdBy" headerClass="textcenter" class="textcenter" sortable="true" titleKey="createdBy"/>
											<display:column property="createdOn" headerClass="textcenter" class="textcenter" sortable="true" titleKey="createdOn"/>
											<display:column media="html" class="headcol2 textcenter" headerClass="headcol2 textcenter" titleKey="Create Processing Order">
												<div class="operations-toggle order_sheet_avalable_planning_order textcenter">
													<a href="merordersheetorderform?newprossess=true&custCode=${merordersheethdrList.buyer}&locationCode=${merordersheethdrList.mststyleheader.id.locationCode}&depCode=${merordersheethdrList.mststyleheader.id.depCode}&styleId=${merordersheethdrList.mststyleheader.id.styleId}&compCode=${merordersheethdrList.mststyleheader.id.compCode}&styleDescription=${merordersheethdrList.mststyleheader.styleDescription}&season=${merordersheethdrList.season}&planingOrdersheetNo=${merordersheethdrList.id.planingOrdersheetNo}&orderType=${merordersheethdrList.id.orderType}"><span class="fa fa-wrench marginRight5"></span> Create Processing Order</a>
												</div>
											</display:column>
											<display:column media="html" class="textcenter headcol3" headerClass="headcol3 textcenter" titleKey="Actions">
											  
												<div class="middle-align">
													<div class="edit-toggle-styl-rt edit-toggle order_sheet_avalable_planning_action">
														<a href="merordersheethdrform?editmode=true&planingOrdersheetNo=${merordersheethdrList.id.planingOrdersheetNo}&orderType=${merordersheethdrList.id.orderType}"><span class="glyphicon glyphicon-pencil order_sheet_edit"></span> Edit</a>
													</div>
													<div class="view-toggle">
														<a href="merordersheethdrform?view=true&planingOrdersheetNo=${merordersheethdrList.id.planingOrdersheetNo}&orderType=${merordersheethdrList.id.orderType}"><span class="glyphicon glyphicon-eye-open"></span> View </a>
													</div>
													<!-- <div class="delete-toggle-styl-rt delete-toggle order_sheet_avalable_planning_action">
														<a href="merordersheethdrform?delete=true&planingOrdersheetNo=${merordersheethdrList.id.planingOrdersheetNo}&orderType=${merordersheethdrList.id.orderType}" data-toggle="modal" data-target=".delete-confirmation"><span class="glyphicon glyphicon-remove"></span> Delete </a> 
													</div> -->
													<div class="delete-toggle">
														<a onclick="  if ( confirm('do you really need to delete this ?') == true) {deleteordersheet('delete=true&planingOrdersheetNo=${merordersheethdrList.id.planingOrdersheetNo}&orderType=${merordersheethdrList.id.orderType}')}"><span
																class="glyphicon glyphicon-remove"></span> Delete </a>
													</div>
												</div>		
											</display:column>
											<display:setProperty name="paging.banner.item_name"><fmt:message key="merordersheethdrList.merordersheethdr"/></display:setProperty>
											<display:setProperty name="paging.banner.items_name"><fmt:message key="merordersheethdrList.merordersheethdrs"/></display:setProperty>

											<display:setProperty name="export.excel.filename"><fmt:message key="merordersheethdrList.title"/>.xls</display:setProperty>
											<display:setProperty name="export.csv.filename"><fmt:message key="merordersheethdrList.title"/>.csv</display:setProperty>
											<display:setProperty name="export.pdf.filename"><fmt:message key="merordersheethdrList.title"/>.pdf</display:setProperty>
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
						<div class="panel-heading" data-toggle="collapse" data-parent="#buyerApprovedPCS" data-target="#buyerApprovedPCSBody" style="background-color: #d63b3f;">
							<h4 class="panel-title">
								<a data-toggle="collapse" data-parent="#buyerApprovedPCS" href="#buyerApprovedPCSBody" class="collapsed"> 
								</a><a class="accordion-toggle"> <span class="pull-right slideupdowntoggle glyphicon glyphicon-chevron-up" style="border-left: 2px solid #C0392B;"></span>Planning Orders That need your Attention</a>  
							</h4>
						</div>
						<div id="buyerApprovedPCSBody" class="panel-collapse collapse" style="height: auto;">
							<div class="panel-body">

								<div class="row">

									<div class="pull-right margin-addstyleroute">
										<div class="input-group custom-search-form " style="width: 390px;">
											<c:if test="${merordersheethdrdueList != null}">
												<input  type="text" onkeypress="checkenter(event,'Incomplete')" size="20" name="dquery" id="dquery"  value="${param.dquery}" class="form-control" placeholder="Search and Filter"/>
												<span class="input-group-btn">
													<button onclick="schOrdersheet('Incomplete')" id="button.search" type="button" class="btn btn-info search-form-btn" type="submit">
														<span class="glyphicon glyphicon-search"></span>
													</button>
												</span>
											</c:if>
										</div><!-- /input-group -->
									</div>                   
								</div>

								<div class="dataTables_wrapper">
									<section class="posSection">
										<display:table name="merordersheethdrdueList" class="table table-condensed table-striped table-hover table-bordered" requestURI="" id="merordersheethdrdueList" export="true" pagesize="25">
											<display:column property="buyer" sortable="true" headerClass="textcenter" class="textcenter" titleKey="merordersheethdr.Buyer"/>
											<display:column property="mststyleheader.id.styleId" headerClass="textcenter" class="textcenter" sortable="true" titleKey="merordersheethdr.Style"/>
											<display:column property="id" media="csv excel xml pdf" headerClass="textcenter" class="textcenter" titleKey="merordersheethdr.id.planingOrdersheetNo"/>
											<display:column property="remarks" sortable="true" headerClass="textcenter" class="textcenter" titleKey="merordersheethdr.remarks"/>
											<display:column property="status" sortable="true" headerClass="textcenter" class="textcenter" titleKey="merordersheethdr.status"/>
											<display:column property="totalQty" sortable="true" headerClass="textcenter" class="textcenter" titleKey="merordersheethdr.totalQty"/>
											<display:column property="createdBy" sortable="true" headerClass="textcenter" class="textcenter" titleKey="createdBy"/>
											<display:column property="createdOn" sortable="true" headerClass="textcenter" class="textcenter" titleKey="createdOn"/>
											<display:column media="html" class="textcenter headcol3" headerClass="headcol3 textcenter" titleKey="<a>Actions</a>">
												<div class="middle-align">
													<div class="edit-toggle-styl-rt edit-toggle order_sheet_avalable_planning_action">
														<a href="merordersheethdrform?editmode=true&planingOrdersheetNo=${merordersheethdrdueList.id.planingOrdersheetNo}&orderType=${merordersheethdrdueList.id.orderType}"><span class="glyphicon glyphicon-pencil order_sheet_edit"></span> Edit</a>
													</div>
													<div class="view-toggle">
														<a href="merordersheethdrform?view=true&planingOrdersheetNo=${merordersheethdrdueList.id.planingOrdersheetNo}&orderType=${merordersheethdrdueList.id.orderType}"><span class="glyphicon glyphicon-eye-open"></span> View </a>
													</div>
													<!--<div class="delete-toggle-styl-rt delete-toggle order_sheet_avalable_planning_action">
														<a href="merordersheethdrform?delete=true&planingOrdersheetNo=${merordersheethdrdueList.id.planingOrdersheetNo}&orderType=${merordersheethdrdueList.id.orderType}" data-toggle="modal" data-target=".delete-confirmation"><span class="glyphicon glyphicon-remove"></span> Delete </a> 
													</div> -->
													<div class="delete-toggle">
														<a onclick="  if ( confirm('do you really need to delete this ?') == true) {deleteordersheet('merordersheethdrform?delete=true&id.planingOrdersheetNo=${merordersheethdrdueList.id.planingOrdersheetNo}&id.orderType=${merordersheethdrdueList.id.orderType}')}"><span
																class="glyphicon glyphicon-remove"></span> Delete </a>
													</div>
												</div>		
											</display:column>
											<display:setProperty name="paging.banner.item_name"><fmt:message key="merordersheethdrList.merordersheethdr"/></display:setProperty>
											<display:setProperty name="paging.banner.items_name"><fmt:message key="merordersheethdrList.merordersheethdrs"/></display:setProperty>

											<display:setProperty name="export.excel.filename"><fmt:message key="merordersheethdrList.title"/>.xls</display:setProperty>
											<display:setProperty name="export.csv.filename"><fmt:message key="merordersheethdrList.title"/>.csv</display:setProperty>
											<display:setProperty name="export.pdf.filename"><fmt:message key="merordersheethdrList.title"/>.pdf</display:setProperty>
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

	<div class="tab-pane " id="addFinalCS">
		<form  method="get" action="merordersheethdrs" class="well" id="merordersheethdrsfrm" >
			<div class="row paddingleft20">
				<c:if test="${mststyleheader.id.styleId == null}">
					<c:set var="disabled" scope="session" value=""/>
				</c:if>
				<c:if test="${mststyleheader.id.styleId != null}">
					<c:set var="disabled" scope="session" value="readonly"/>
				</c:if>
					
				<div class="col-sm-4 col-md-4 ">
					<div class="form-group formwithsearch marginbottom20">
						<div class="icon-addon addon-md">
							<label for="exampleInputEmail1">Buyer </label>
							<select ${disabled} required="required" type="text" name="custCode" id="p_id_custCode" onfocus="getOptions('p_id_custCode','mstcustomer')" class="form-control" >
								<c:if test="${mststyleheader.id.custCode!=null}">
									<option selected="selected">${mststyleheader.id.custCode}</option>
								</c:if>
								<c:if test="${mststyleheader.id.custCode == null}">
									<option selected="selected">${param.custCode}</option>
								</c:if>
							</select>
							
						</div>
					</div>  
					<div class="btn-group formsearchbtn btn-model-select-div">
						<button onclick="$('#p_id_custCode').trigger('onfocus'); addmodalpopup('p_id_custCode')" type="button" class="btn btn-primary btn-xs dropdown-toggle " data-toggle="modal" data-target="#schmodalpopup" ><span class="glyphicon glyphicon-search"></span></button>
					</div>
					
					<div class="clearfix"></div> 
					<div class="form-group formwithsearch marginbottom20">
						<div class="icon-addon addon-md">
							<label for="exampleInputEmail1">Style Location</label>
							<select ${disabled} required="required" type="text" name="locationCode" id="p_id_locationCode" class="form-control" onfocus="getOptions('p_id_locationCode','mstlocations')"> 
								<c:if test="${mststyleheader.id.locationCode!=null}">
									<option selected="selected">${mststyleheader.id.locationCode}</option>
								</c:if>
								<c:if test="${mststyleheader.id.locationCode == null}">		
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
						<button onclick="$('#p_id_locationCode').trigger('onfocus'); addmodalpopup('p_id_locationCode')" type="button" class="btn btn-primary btn-xs dropdown-toggle " data-toggle="modal" data-target="#schmodalpopup" ><span class="glyphicon glyphicon-search"></span></button>
					</div>
					<div class="clearfix"></div> 
				</div>

				<div class="col-sm-4 col-md-4 ">
					<div class="form-group formwithsearch marginbottom20">
						<div class="icon-addon addon-md">
							<label for="exampleInputEmail1">Buyer Department</label>
							<select ${disabled}  required="required" type="text" name="depCode" id="p_id_depCode" onfocus="optionsforgencodes('p_id_depCode','BUYDEM')" class="form-control" >
								<c:if test="${mststyleheader.id.depCode != null}">
									<option selected="selected">${mststyleheader.id.depCode}</option>
								</c:if>
								<c:if test="${mststyleheader.id.depCode == null}">		
									<option selected="selected">${param.depCode}</option>
								</c:if>
							</select>
							
						</div>
					</div>  
					<div class="btn-group formsearchbtn btn-model-select-div">
						<button onclick="$('#p_id_depCode').trigger('onfocus'); addmodalpopup('p_id_depCode')" type="button" class="btn btn-primary btn-xs dropdown-toggle " data-toggle="modal" data-target="#schmodalpopup" ><span class="glyphicon glyphicon-search"></span></button>
					</div>
					<div class="clearfix"></div> 

					<div class="form-group formwithsearch marginBottom20">
						<div class="icon-addon addon-md">
							<label for="exampleInputEmail1">Style</label>
							<div class="input-group">
								<input ${disabled}  required="required" type="text" name="styleId" id="p_id_styleId"  class="form-control" class="typeahead form-control" data-provide="typeahead" value='<c:if test="${mststyleheader.id.styleId!=null}">${mststyleheader.id.styleId}</c:if><c:if test="${mststyleheader.id.styleId ==null}"> ${param.styleId}</c:if>' onfocus="typaheadforStyle('p_id_styleId','id.styleId')" >
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
						<button onclick="addmodalpopup('p_id_styleId')" type="button" class="btn btn-primary btn-xs dropdown-toggle " data-toggle="modal" data-target="#schmodalpopup" ><span class="glyphicon glyphicon-search"></span></button>
					</div>
					<div class="clearfix"></div> 

				</div>

				<div class="col-sm-4 col-md-4 ">
					<div class="form-group formwithsearch marginbottom20">
						<div class="icon-addon addon-md">
							<label for="exampleInputEmail1">Company</label>
							<select ${disabled}  required="required" type="text" name="compCode" id="p_id_compCode" onfocus="getOptions('p_id_compCode','mstcompany')" class="form-control" >
								<c:if test="${mststyleheader.id.compCode!=null}">
									<option selected="selected">${mststyleheader.id.compCode}</option>
								</c:if>
								<c:if test="${mststyleheader.id.compCode == null}">
									<option selected="selected">${param.compCode}</option>
								</c:if>
							</select>
							
						</div>
					</div>  
					<div class="btn-group formsearchbtn btn-model-select-div">
						<button onclick="$('#p_id_compCode').trigger('onfocus'); addmodalpopup('p_id_compCode')" type="button" class="btn btn-primary btn-xs dropdown-toggle " data-toggle="modal" data-target="#schmodalpopup" ><span class="glyphicon glyphicon-search"></span></button>
					</div>
					<div class="clearfix"></div>
				</div>

				<div class="col-sm-4 col-md-4 ">
					<div class="form-group formwithsearch marginbottom20">
						<div class="icon-addon addon-md">
							<label for="exampleInputEmail1">Style Description</label>
							<input  type="text" name="styleDescription" id="p_id_styleDescription" value='<c:if test="${mststyleheader.styleDescription!=null}">${mststyleheader.styleDescription}</c:if><c:if test="${mststyleheader.styleDescription ==null}">${param.styleDescription}</c:if>' class="form-control" readonly="readonly">
						</div>
					</div>  
					<div class="clearfix"></div>
				</div>	
				<div class="col-sm-4 col-md-4">
					<div class="form-group formwithsearch marginbottom20">
						<div class="icon-addon addon-md">
							<label for="exampleInputEmail1">Season</label>
							<select required="required" type="text" name="season" id="p_season" class="form-control" onfocus="optionsforgencodes('p_season','SEASON')" >
								<c:if test="${season!=null}">
									<option selected="selected">${season}</option>
								</c:if>
								<c:if test="${season ==null}">
									<option selected="selected">${param.season}</option>
								</c:if>
							</select>							
						</div>
					</div> 		
					<div class="btn-group formsearchbtn btn-model-select-div">
						<button onclick="$('#p_season').trigger('onfocus'); addmodalpopup('p_season')" type="button" class="btn btn-primary btn-xs dropdown-toggle " data-toggle="modal" data-target="#schmodalpopup" ><span class="glyphicon glyphicon-search"></span></button>
					</div>					
					<div class="clearfix"></div> 
				</div>
				<div class="col-sm-4 col-md-4">
					<button type="submit"  name="section" class="btn btn-info btn-embossed search-routes-btn" ><span class="glyphicon glyphicon-search"></span>Select Style</button>
					<button type="button" class="reset replace-data btn btn-defalt btn-embossed search-routes-btn"><span class="glyphicon glyphicon-refresh"></span>Reset</button>
				</div>
			</div>
		</form>
		<div class="row paddingleft20">
			<div class="col-sm-12 col-md-12">
				<div class="panel-group" id="costSheet">
					<div class="panel panel-default">
						<div class="panel-heading" data-toggle="collapse" data-parent="#costSheet" data-target="#costSheetBody">
							<h4 class="panel-title">
								<a data-toggle="collapse" data-parent="#costSheet" href="#costSheetBody"> 
								</a><a class="accordion-toggle"> <span class="pull-right slideupdowntoggle glyphicon glyphicon-chevron-up"></span>Avalable Processing Orders</a>  
							</h4>
						</div>
						<div id="costSheetBody" class="panel-collapse collapse" style="height: auto;">
							<div class="panel-body">  
								<div class="dataTables_wrapper">
									<div class="row">                    
										<div class="pull-right margin-addstyleroute">
											<div class="input-group custom-search-form " style="width: 390px;">
												<c:if test="${merordersheethdrproList != null}">
													<input  type="text" onkeypress="checkenter(event,'p_')" size="20" name="pquery" id="p_query"  value="${param.dquery}" class="form-control" placeholder="Search and Filter"/>
													<span class="input-group-btn">
														<button onclick="schOrdersheet('p_')" id="button.search" type="button" class="btn btn-info search-form-btn" type="submit">
															<span class="glyphicon glyphicon-search"></span>
														</button>
													</span>
												</c:if>
												<a onclick="AddOrdersheet('p_')" class="btn btn-warning btn-embossed pull-right"><span class="glyphicon glyphicon-plus marginRight4"></span>Add Processing Order</a>
											</div><!-- /input-group -->                       
										</div>                   
									</div>
									<section class="posSection">
										<display:table name="merordersheethdrproList" class="table table-condensed table-striped table-hover table-bordered" requestURI="" id="merordersheethdrproList" export="true" pagesize="25">
											<display:column property="buyer" sortable="true" headerClass="textcenter" class="textcenter" titleKey="merordersheethdr.Buyer"/>
											<display:column property="mststyleheader.id.styleId" headerClass="textcenter" class="textcenter" sortable="true" titleKey="merordersheethdr.Style"/>
											<display:column property="id" media="csv excel xml pdf" headerClass="textcenter" class="textcenter" titleKey="merordersheethdr.id.planingOrdersheetNo"/>
											<display:column property="remarks" sortable="true" headerClass="textcenter" class="textcenter" titleKey="merordersheethdr.remarks"/>
											<display:column property="status" sortable="true" headerClass="textcenter" class="textcenter" titleKey="merordersheethdr.status"/>
											<display:column property="totalQty" sortable="true" headerClass="textcenter" class="textcenter" titleKey="merordersheethdr.totalQty"/>
											<display:column property="createdBy" sortable="true" headerClass="textcenter" class="textcenter" titleKey="createdBy"/>
											<display:column property="createdOn" sortable="true" headerClass="textcenter" class="textcenter" titleKey="createdOn"/>
											<display:column media="html" class="textcenter headcol3" headerClass="headcol3 textcenter" titleKey="<a>Actions</a>">
												<div class="middle-align">
													<div class="edit-toggle-styl-rt edit-toggle edit-toggle edit_fix">
														<a href="merordersheetorderform?editmode=true&planingOrdersheetNo=${merordersheethdrproList.id.planingOrdersheetNo}&orderType=${merordersheethdrproList.id.orderType}"><span class="glyphicon glyphicon-pencil order_sheet_edit"></span> Edit</a>
													</div>
													<div class="view-toggle">
														<a href="merordersheethdrview?view=true&planingOrdersheetNo=${merordersheethdrproList.id.planingOrdersheetNo}&orderType=${merordersheethdrproList.id.orderType}"><span class="glyphicon glyphicon-eye-open"></span> View </a>
													</div>
													<div class="delete-toggle-styl-rt delete-toggle delete-toggle order_sheet_edit delete_fix">
														<a href="merordersheethdrform?delete=true&planingOrdersheetNo=${merordersheethdrproList.id.planingOrdersheetNo}&orderType=${merordersheethdrproList.id.orderType}" data-toggle="modal" data-target=".delete-confirmation"><span class="glyphicon glyphicon-remove"></span> Delete </a> 
													</div>
												</div>		
											</display:column>
											<display:setProperty name="paging.banner.item_name"><fmt:message key="merordersheethdrList.merordersheethdr"/></display:setProperty>
											<display:setProperty name="paging.banner.items_name"><fmt:message key="merordersheethdrList.merordersheethdrs"/></display:setProperty>

											<display:setProperty name="export.excel.filename"><fmt:message key="merordersheethdrList.title"/>.xls</display:setProperty>
											<display:setProperty name="export.csv.filename"><fmt:message key="merordersheethdrList.title"/>.csv</display:setProperty>
											<display:setProperty name="export.pdf.filename"><fmt:message key="merordersheethdrList.title"/>.pdf</display:setProperty>
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
<script>
	$('#errors').hide();
	var isstyleselect="${NO}";
	$(document).ready(function() {
		<c:if test="${param.section!=null}">
			 ordersheetnavigation("addFinalCS");
			// document.getElementById('addFinalCS').className="active";
		</c:if>
			
	});
</script>