<%@ include file="/common/taglibs.jsp"%>
<head>
    <title><fmt:message key="mststylerouteoperationList.title"/></title>
    <meta name="menu" content="MststylerouteoperationMenu"/>
</head>

<c:if test="{'$'}{not empty searchError}">
	<div class="alert alert-danger alert-dismissable">
		<a href="#" data-dismiss="alert" class="close">&times;</a>
		<c:out value="{'$'}{searchError}"/>
	</div>
</c:if>

<div class="col-xs-8"><h2>Style Routes</h2></div>  
<div class="col-xs-4 styletoure-hrline">
	<ul class="nav nav-justified setup-panel" id="myTab">
		<li id="homeTab" class="active" onclick="stylerotenavigation('home')">
			<a href="#home" data-toggle="tab">
				<button type="button" class="btn btn-default btn-circle">
					<span class="glyphicon glyphicon-th-list" ></span>
				</button>
				<p class="list-group-item-text">Style Route</p>
			</a>
		</li>
		<li id="profileTab" onclick="stylerotenavigation('profile')">
			<a href="#profile" data-toggle="tab">
				<button type="button" class="btn btn-default btn-circle">
					<span class="glyphicon glyphicon-th-large" ></span>
				</button>
				<p class="list-group-item-text">Style Operations</p>
			</a>
		</li>
		<li id="Wip-PointsTab" onclick="stylerotenavigation('Wip-Points')">
			<a href="#Wip-Points" data-toggle="tab">
				<button type="button" class="btn btn-default btn-circle">
					<span class="glyphicon glyphicon-sort-by-attributes" ></span>
				</button>
				<p class="list-group-item-text">Assign WIP Points</p>
			</a>
		</li>
	</ul>
</div> <%--  NAVIGATION PILLS END  --%> 
<div class="tab-content marginTop80"  > <%--  TAB CONTENT MAIN --%> 
	<div class="tab-pane active" id="home"> <%--  Start of tab content 1 onsubmit="return checkvalues('id_styleId',0)"  --%> 
		<div class="row paddingleft20">
			<form action="mststylerouteoperations" method="get" id="mststylerouteoperationsForm" autocomplete="off"  >
				<div class="col-sm-4 col-md-4 ">
					<c:if test="${mststyleheader.id.styleId == null}">
						<c:set var="disabled" scope="session" value=""/>
					</c:if>
					<c:if test="${mststyleheader.id.styleId != null}">
						<c:set var="disabled" scope="session" value="readonly"/>
					</c:if>
					<div class="form-group formwithsearch marginbottom20">
						<div class="icon-addon addon-md">
							<label for="exampleInputEmail1">Location </label>
							<c:if test="${disabled == 'readonly'}">
								<input ${disabled} type="text" value="${mststyleheader.id.locationCode}" name="locationCode" id="id_locationCode" class="typeahead form-control"/>
							</c:if>
							<c:if test="${disabled != 'readonly'}">
								<select ${disabled} id="id_locationCode" tabindex="1" type="text" name="locationCode" class="typeahead form-control" data-provide="typeahead" value="${mststyleheader.id.locationCode}" onfocus="getOptions('id_locationCode','mstlocations');">							
									<c:if test="${mststyleheader.id.locationCode == null}">
										<c:forEach items="${mstparam}" var="mstparams">							
											<option selected="selected">${mstparams.locationCode}</option>
										</c:forEach>
									</c:if>
									<c:if test="${mststyleheader.id.locationCode != null}">
										<option selected="selected">${mststyleheader.id.locationCode}</option>
									</c:if>
								</select>
							</c:if>							
						</div>
					</div>
					<div class="btn-group formsearchbtn btn-model-select-div">
						<button ${disabled} <c:if test="${disabled != 'readonly'}">onclick="$('#id_locationCode').trigger('onfocus');addmodalpopup('id_locationCode');" data-toggle="modal" data-target="#schmodalpopup" </c:if>	type="button" class="btn btn-primary btn-xs dropdown-toggle " ><span class="glyphicon glyphicon-search"></span></button>
					</div>
					<div class="clearfix"></div> 
					<div class="form-group formwithsearch marginbottom20">
						<div class="icon-addon addon-md">
							<label for="exampleInputEmail1">Buyer Department</label>
							<c:if test="${disabled == 'readonly'}">
								<input ${disabled} type="text" value="${mststyleheader.id.depCode}" name="depCode" id="id_depCode" class="typeahead form-control"/>
							</c:if>
							<c:if test="${disabled != 'readonly'}">
								<select ${disabled} id="id_depCode" type="text" name="depCode" class="typeahead form-control" data-provide="typeahead" tabindex="3" value="${mststyleheader.id.depCode}" onfocus="optionsforgencodes('id_depCode','BUYDEM')" >
									<option>${mststyleheader.id.depCode}</option>
								</select>
							</c:if>
						</div>
					</div>  
					<div class="btn-group formsearchbtn btn-model-select-div">
						<button ${disabled} <c:if test="${disabled != 'readonly'}">onclick="$('#id_depCode').trigger('onfocus');addmodalpopup('id_depCode');"  data-toggle="modal" data-target="#schmodalpopup"</c:if> type="button" class="btn btn-primary btn-xs dropdown-toggle " ><span class="glyphicon glyphicon-search"></span></button>
					</div>
					<div class="clearfix"></div>
                <div class="form-group formwithsearch marginbottom30 marginleft10 style_routs_submit_button">
                <button  type="Submit" tabindex="6"  class="btn btn-info btn-embossed search-routes-btn"><span class="glyphicon glyphicon-search"></span> Search Routes</button>
                <button type="reset" onclick="this.form.reset();" class="reset  replace-data btn btn-defalt btn-embossed search-routes-btn"><span class="glyphicon glyphicon-refresh"></span>Reset</button>
                </div>
				</div>
				<div class="col-sm-3 col-md-3 col-xs-3" ><!--style="display:  none;" -->
					<div class="form-group formwithsearch marginbottom20">
						<div class="icon-addon addon-md">
							<label for="exampleInputEmail1">Company</label>
							<c:if test="${disabled == 'readonly'}">
								<input ${disabled} type="text" value="${mststyleheader.id.compCode}" name="compCode" id="id_compCode" class="typeahead form-control"/>
							</c:if>
							<c:if test="${disabled != 'readonly'}">
								<select ${disabled} id="id_compCode" type="text" name="compCode" class="typeahead form-control" data-provide="typeahead" onfocus="getOptions('id_compCode','mstcompany');" >
									<c:if test="${mststyleheader.id.compCode == null}">
										<c:forEach items="${mstparam}" var="mstparams">
											<option >${mstparams.commonCompCode}</option>									
										</c:forEach>
									</c:if>
									<c:if test="${mststyleheader.id.compCode != null}">
										<option selected="selected" >${mststyleheader.id.compCode}</option>
									</c:if>
								</select>
							</c:if>
						</div>
					</div>
					<div class="btn-group formsearchbtn btn-model-select-div">
						<button  ${disabled} <c:if test="${disabled != 'readonly'}">onclick="$('#id_compCode').trigger('onfocus');addmodalpopup('id_compCode');" data-toggle="modal" data-target="#schmodalpopup"</c:if> type="button" class="btn btn-primary btn-xs dropdown-toggle "  ><span class="glyphicon glyphicon-search"></span></button>
					</div>
					<div class="clearfix"></div> 
					<div class="form-group formwithsearch marginBottom20">
						<div class="icon-addon addon-md">
							<label for="exampleInputEmail1">Style</label>
							<input ${disabled}  id="id_styleId" tabindex="4" type="text" name="styleId" required="true" class="typeahead form-control" data-provide="typeahead" value="${mststyleheader.id.styleId}" onfocus="getStyleparams('id_styleId','id.styleId');" />    <!-- onblur="checkvalues(this,0)" -->
							<div class="feedback"></div>
						</div>
					</div>  
					<div class="btn-group formsearchbtn btn-model-select-div">
						<button ${disabled} <c:if test="${disabled != 'readonly'}"> onclick="$('#id_styleId').trigger('onfocus');addmodalpopup('id_styleId');" data-toggle="modal" data-target="#schmodalpopup" </c:if> type="button" class="btn btn-primary btn-xs dropdown-toggle " ><span class="glyphicon glyphicon-search"></span></button>
					</div>
					<div class="clearfix"></div> 
				</div>
				<div class="col-sm-4 col-md-4 ">
					<div class="form-group formwithsearch marginbottom20">
						<div class="icon-addon addon-md">
							<label for="exampleInputEmail1">Buyer</label>
							<c:if test="${disabled == 'readonly'}">
								<input ${disabled} type="text" value="${mststyleheader.id.custCode}" name="custCode" id="id_custCode" class="typeahead form-control"/>
							</c:if>
							<c:if test="${disabled != 'readonly'}">
								<select ${disabled} id="id_custCode" type="text" name="custCode"  class="typeahead form-control" tabindex="2" data-provide="typeahead" value="${mststyleheader.id.custCode}" onfocus="getOptions('id_custCode','mstcustomer');">
									<option>${mststyleheader.id.custCode}</option>
								</select>
							</c:if>
							
						</div>
					</div>  
					<div class="btn-group formsearchbtn btn-model-select-div">
						<button ${disabled} <c:if test="${disabled != 'readonly'}"> onclick="$('#id_custCode').trigger('onfocus');addmodalpopup('id_custCode');"  data-toggle="modal" data-target="#schmodalpopup" </c:if> type="button" class="btn btn-primary btn-xs dropdown-toggle " ><span class="glyphicon glyphicon-search"></span></button>
					</div>
					<div class="clearfix"></div> 
					<div class="form-group formwithsearch marginbottom20">
						<div class="icon-addon addon-md">
							<label for="exampleInputEmail1">Style Description</label>
							<input  readonly="readonly" id="styleDescription" type="text" name="styleDescription" class="typeahead form-control"  value="${mststyleheader.styleDescription}" />
						</div>
					</div>
					<div class="clearfix"></div> 
				</div>
			</form>
		</div>
		<div class="row paddingleft20">
			<div class="col-sm-12 col-md-12">
				<div class="panel-group" id="stylebrowser">
					<div class="panel panel-default">
						<div class="panel-heading collapsed" data-toggle="collapse" data-parent="#stylebrowser" data-target="#styleBrowserBody">
							<h4 class="panel-title">
							<a data-toggle="collapse" data-parent="#stylebrowser" href="#styleBrowserBody"> 
							<a class="accordion-toggle"><span class="pull-right slideupdowntoggle glyphicon glyphicon-chevron-up"></span>Available Routes</a> </a> 
							</h4>
						</div>
						<div id="styleBrowserBody" class="panel-collapse collapse in">
							<div class="panel-body">
								
								<form method="get" action="${ctx}/mststylerouteoperations" id="searchForm" class="form-inline">
									<div class="row">
										<div class="pull-right margin-addstyleroute">
											<div class="input-group custom-search-form " style="width: 370px;">
												<input type="text" tabindex="7" size="20" name="q" id="query1" value="${param.q}" placeholder="<fmt:message key="search.enterTerms"/>"  class="form-control" placeholder="Search and Filter"/>
												<span class="input-group-btn">
													<button tabindex="8" class="btn btn-info search-form-btn" onclick="getStylerours()" type="button">
														<span class="glyphicon glyphicon-search"></span>
													</button>
												</span>
												<a tabindex="9" class="btn btn-warning btn-embossed pull-right" onclick="addNewRoute()"><span class="glyphicon glyphicon-plus"></span>	Add New Route</a>
											</div><%--  /input-group --%> 
										</div>                   
									</div>
								</form>
									<c:if test="${mststylerouteoperationList!='[]'}">
									<div class="dataTables_wrapper Scroll-for-datatable">
										<section class="datatable_two mewadd">
											<display:table name="mststylerouteoperationList" class="display table table-striped table-bordered" cellspacing="0" requestURI="" id="mststylerouteoperationList" export="true" pagesize="25">
												<display:column property="styleRouteName" headerClass="textcenter" class="textcenter" sortable="true" titleKey="mststylerouteoperation.styleRouteName"/>
												<display:column property="assignLocation" headerClass="textcenter" class="textcenter" sortable="true" titleKey="mststylerouteoperation.assignLocation"/>
												<display:column property="componentId" headerClass="textcenter" class="textcenter" sortable="true" titleKey="mststylerouteoperation.id.componentId"/>
												<display:column property="productType" headerClass="textcenter" class="textcenter" sortable="true" titleKey="mststylerouteoperation.productType"/>
												<display:column property="mainColor" headerClass="textcenter" class="textcenter" sortable="true" titleKey="mststylerouteoperation.id.mainColor"/>
												<display:column property="noOfPcs" headerClass="textcenter" class="textcenter" sortable="true" titleKey="mststylerouteoperation.noOfPcs"/>
												<display:column property="orderQty" headerClass="textcenter" class="textcenter" sortable="true" titleKey="mststylerouteoperation.orderQty"/>
												<display:column property="noOfMachines" headerClass="textcenter" class="textcenter" sortable="true" titleKey="mststylerouteoperation.noOfMachines"/>
												<display:column property="noOfWokers" headerClass="textcenter" class="textcenter" sortable="true" titleKey="mststylerouteoperation.noOfWokers"/>
												<display:column property="noOfHealpers" headerClass="textcenter" class="textcenter" sortable="true" titleKey="mststylerouteoperation.noOfHealpers"/>
												<display:column property="workMins" headerClass="textcenter" class="textcenter" sortable="true" titleKey="mststylerouteoperation.workMins"/>
												<display:column property="cycleTime" headerClass="textcenter" class="textcenter" sortable="true" titleKey="mststylerouteoperation.cycleTime"/>
												<display:column sortProperty="targetDate" headerClass="textcenter" class="textcenter" sortable="true" titleKey="mststylerouteoperation.targetDate">
													<fmt:formatDate value="${mststylerouteoperationList.targetDate}" pattern="${datePattern}"/>
												</display:column>
												<display:column style="display:none;" property="routeStatus" titleKey="Status" headerClass="displayNone"></display:column>
												<display:column class="headcol newwidthbrush_text textcenter" headerClass="headcol newwidthbrush textcenter" sortable="true" titleKey="Status" media="html">
													<c:if test="${mststylerouteoperationList.routeStatus == 'Incomplete'}">
														<div class="pdnIncomplete">${mststylerouteoperationList.routeStatus}</div>
													</c:if>
													
													<c:if test="${mststylerouteoperationList.routeStatus == 'Completed'}">
														<div class="pdnCompleted">${mststylerouteoperationList.routeStatus}</div>
													</c:if>
													
													<c:if test="${mststylerouteoperationList.routeStatus == 'Pending'}">
														<div class="pdnApproval">${mststylerouteoperationList.routeStatus}</div>
													</c:if>
												</display:column>
												
												<display:column class="headcol2 textcenter" headerClass="headcol2 textcenter avalable_routs_header" media="html" titleKey="<a>Add Oparations</a>">
													<div class="operations-toggle">
													  <a onclick="addNewOperation('${mststyleheader.id.locationCode}','${mststyleheader.id.compCode}','${mststyleheader.id.custCode}','${mststyleheader.id.depCode}','${mststyleheader.id.styleId}','${mststylerouteoperationList.componentId}','${mststylerouteoperationList.mainColor}','${mststylerouteoperationList.styleRouteId}');$('#rop_id_search').trigger('click'); ">
													  <span class="glyphicon glyphicon-wrench"></span> Operations</a>
													</div>
												</display:column>
												
												<display:column class="textcenter headcol3" media="html" headerClass="textcenter headcol3 avalable_routs_header" titleKey="<a>Action</a>">
													<div class="middle-align">
														<div class="edit-toggle avalable_routs_header_edit">
															<a onclick="editRouteOperation('${mststylerouteoperationList.styleRouteId}');">
															<span class="glyphicon glyphicon-pencil"></span> Edit</a>
														</div>
														<div class="view-toggle avalable_routs_header_action_buttons">
															<a href="mststylerouteview?styleRouteId=${mststylerouteoperationList.styleRouteId}">
															<span class="glyphicon glyphicon-eye-open"></span> View </a>
														</div>
														<div class="delete-toggle avalable_routs_header_action_buttons">
															<a href="mststylerouteview?delete=true&styleRouteId=${mststylerouteoperationList.styleRouteId}">
															<span class="glyphicon glyphicon-remove"></span> Delete </a> 
														</div>
													</div>								
												</display:column>															
												<display:setProperty name="paging.banner.item_name"><fmt:message key="mststylerouteoperationList.mststylerouteoperation"/></display:setProperty>
												<display:setProperty name="paging.banner.items_name"><fmt:message key="mststylerouteoperationList.mststylerouteoperations"/></display:setProperty>
												<display:setProperty name="export.excel.filename"><fmt:message key="mststylerouteoperationList.title"/>.xls</display:setProperty>
												<display:setProperty name="export.csv.filename"><fmt:message key="mststylerouteoperationList.title"/>.csv</display:setProperty>
												<display:setProperty name="export.pdf.filename"><fmt:message key="mststylerouteoperationList.title"/>.pdf</display:setProperty>
											</display:table>
										</section>
									</div>
								</c:if>
							</div>
						</div>
					</div>
				</div> 
			</div> 
		</div>
 
		<div class="row paddingleft20">
			<div class="col-sm-12 col-md-12">
				<div class="panel-group" id="stylebrowser">
					<div class="panel panel-default">
						<div class="panel-heading" data-toggle="collapse" data-parent="#addstyleroute" data-target="#addstyleroute">
							<h4 class="panel-title">
								<a data-toggle="collapse" data-parent="#stylebrowser" href="#addstyleroute"> 
									<a class="accordion-toggle"> <span class="pull-right slideupdowntoggle glyphicon glyphicon-chevron-up"></span>  <div id="rtHeading"> Add Style Route</div></a>
								</a> 
							</h4>
						</div>
						<div id="addstyleroute" class="panel-collapse collapse in">
							<div class="panel-body">
								<form:errors path="*" cssClass="alert alert-danger alert-dismissable" element="div"/>
								<form:form commandName="mststylerouteoperation" method="post" action="mststylerouteoperationform" id="mststylerouteoperationForm">
									<input type="hidden" name="createdOn" id="createdOn" value="${mststylerouteoperation.createdOn}">
									<input type="hidden" name="createdBy" id="createBy" value="${mststylerouteoperation.createdBy}">
									<input type="hidden" name="createdAt" id="createAt" value="${mststylerouteoperation.createdAt}">
									<input type="hidden" name="routeStatus" id="routeStatus" value="${mststylerouteoperation.routeStatus}">
									
									<div class="row paddingleft20">
										<h3 class="add-styl-rt"> Define Style Route</h3>
										<hr>
										
										<div class="col-md-4 col-xs-4">
											<div class="form-group formwithsearch">
												<div class="icon-addon addon-md">
													<spring:bind path="mststylerouteoperation.styleRouteName">
													<div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
													</spring:bind>
													<appfuse:label key="mststylerouteoperation.styleRouteName" styleClass="control-label"/>
													<form:input tabindex="10" cssClass="form-control" path="styleRouteName" id="styleRouteName"  maxlength="30"/>
													<form:errors path="styleRouteName" cssClass="help-block"/>
													<div class="feedback"></div>
													</div>
												</div>
											</div>  
											<div></div>
											<div class="clearfix"></div> 

											<div class="form-group formwithsearch">
												<div class="icon-addon addon-md">
													<spring:bind path="mststylerouteoperation.productType">
													<div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
													</spring:bind>
													<appfuse:label key="mststylerouteoperation.productType" styleClass="control-label"/>
													<form:input cssClass="form-control" path="productType" id="productType"  maxlength="30" />
													<form:errors path="productType" cssClass="help-block"/>
													<div class="feedback"></div>
													</div>
												</div>
											</div>  
											<div></div>
											<div class="clearfix"></div> 
										</div>
										
										<div class="col-sm-4 col-md-4 col-xs-4">
											<div class="form-group formwithsearch">
												<div class="icon-addon addon-md">
													<spring:bind path="mststylerouteoperation.assignLocation">
													<div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
													</spring:bind>
														<appfuse:label key="mststylerouteoperation.assignLocation" styleClass="control-label"/>
														<%-- <form:input cssClass="form-group form-control" path="assignLocation" id="assignLocation"  maxlength="6" onblur="checkCorrValues(this,jsnrootop);" /> --%>
														<select tabindex="11" required="true" id="assignLocation" path="assignLocation" type="text" name="assignLocation" class="typeahead form-control" data-provide="typeahead" value="${mststylerouteoperation.assignLocation}" onfocus="getOptions('assignLocation','mstlocations')">
															<option>${mststylerouteoperation.assignLocation}</option>
														</select>
														<form:errors path="assignLocation" cssClass="help-block"/>
														<div class="feedback"></div>
													</div>
												</div>
											</div>
											<div class="btn-group formsearchbtn btn-model-select-div">
												<button onclick="$('#assignLocation').trigger('onfocus');addmodalpopup('assignLocation');" type="button" class="btn btn-primary btn-xs dropdown-toggle " data-toggle="modal" data-target="#schmodalpopup" ><span class="glyphicon glyphicon-search"></span></button>
											</div>	
											<div class="clearfix"></div> 

											<div class="form-group formwithsearch">
												<div class="icon-addon addon-md">
													<spring:bind path="mststylerouteoperation.mainColor">
													<div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
													</spring:bind>
													<appfuse:label key="mststylerouteoperation.id.mainColor" styleClass="control-label"/>
													<%-- <form:input cssClass="form-group form-control" path="id.mainColor" id="id_mainColor" required="true" onblur="checkCorrValues(this);"/> --%>
														<select tabindex="14" id="id_mainColor" path="mainColor" type="text" name="mainColor" required="true" class="typeahead form-control" data-provide="typeahead" onfocus="getOptions('id_mainColor','stylemainColor')">
															<option selected="selected">General</option>
														</select>
													<form:errors path="mainColor" cssClass="help-block"/>
													<div class="feedback"></div>
													</div>
												</div>
											</div>
											<div class="btn-group formsearchbtn btn-model-select-div">
												<button onclick="$('#id_mainColor').trigger('onfocus');addmodalpopup('id_mainColor');" type="button" class="btn btn-primary btn-xs dropdown-toggle " data-toggle="modal" data-target="#schmodalpopup" ><span class="glyphicon glyphicon-search"></span></button>
											</div>
											<div class="clearfix"></div> 
										</div>
										
										<div class="col-sm-4 col-md-4 col-xs-4">
											<div class="form-group formwithsearch">
												<div class="icon-addon addon-md">
													<spring:bind path="mststylerouteoperation.componentId">
													<div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
													</spring:bind>
														<appfuse:label key="mststylerouteoperation.id.componentId" styleClass="control-label"/>
														<select tabindex="13" id="id_componentId" path="componentId" type="text" name="componentId" required="true" class="typeahead form-control" data-provide="typeahead" value="${mststylerouteoperation.componentId}" onfocus="getOptions('id_componentId','stylecomponent')" onchange="checkCorrValues(this);">
															<option>${mststylerouteoperation.componentId}</option>
														</select>
														<form:errors path="componentId" cssClass="help-block"/>
														<div class="feedback"></div>
													</div>
												</div>
											</div>
											<div class="btn-group formsearchbtn btn-model-select-div">
												<button onclick="$('#id_componentId').trigger('onfocus');addmodalpopup('id_componentId');" type="button" class="btn btn-primary btn-xs dropdown-toggle " data-toggle="modal" data-target="#schmodalpopup" ><span class="glyphicon glyphicon-search"></span></button>
											</div>
											<div class="clearfix"></div> 
										</div>
									</div>

									<%--  Secttion 1 --%> 

									<div class="row paddingleft20">
										<h3 class="add-styl-rt"> Assign Quantities</h3>
										<hr>
										<div class="col-sm-4 col-md-4 col-xs-4">
											<div class="form-group formwithsearch">
												<div class="icon-addon addon-md">
													<spring:bind path="mststylerouteoperation.noOfPcs">
													<div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
													</spring:bind>
														<appfuse:label key="mststylerouteoperation.noOfPcs" styleClass="control-label"/>
														<input tabindex="15" onkeypress="return IsNumeric(event,this.id)" ondrop="return false;" onpaste="return false;" required="true"  class="form-control"  name="noOfPcs" id="noOfPcs" maxlength="255" >
														<form:errors path="noOfPcs" cssClass="help-block"/>
														<span id="errornoOfPcs" style="color: Red; display: none">* Input digits (0 - 9)</span>
														<div class="feedback"></div>
													</div>
												</div>
											</div>  
											<div class="clearfix"></div> 

											<div class="form-group formwithsearch">
												<div class="icon-addon addon-md">
													<spring:bind path="mststylerouteoperation.noOfWokers">
													<div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
													</spring:bind>
														<appfuse:label key="mststylerouteoperation.noOfWokers" styleClass="control-label"/>
														<input tabindex="18" onkeypress="return IsNumeric(event,this.id)" ondrop="return false;" onpaste="return false;" Class="form-control" name="noOfWokers" id="noOfWokers"  maxlength="255"/>
														<form:errors path="noOfWokers" cssClass="help-block"/>
														<span id="errornoOfWokers" style="color: Red; display: none">* Input digits (0 - 9)</span>
														<div class="feedback"></div>
													</div>
												</div>
											</div>  
											<div class="clearfix"></div> 
										
											<div class="form-group formwithsearch">
												<div class="icon-addon addon-md">
													<spring:bind path="mststylerouteoperation.cycleTime">
													<div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
													</spring:bind>
														<appfuse:label key="mststylerouteoperation.cycleTime" styleClass="control-label"/>
														<input tabindex="20" onkeypress="return IsNumeric(event,this.id)" ondrop="return false;" onpaste="return false;" Class="form-control" name="cycleTime" id="cycleTime"  maxlength="255"/>
														<form:errors path="cycleTime" cssClass="help-block"/>
														<span id="errorcycleTime" style="color: Red; display: none">* Input digits (0 - 9)</span>
														<div class="feedback"></div>
													</div>
												</div>
											</div>  
											<div class="clearfix"></div> 
										</div>
										
										<div class="col-sm-4 col-md-4 col-xs-4">
											<div class="form-group formwithsearch">
												<div class="icon-addon addon-md">
													<spring:bind path="mststylerouteoperation.orderQty">
													<div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
													</spring:bind>
														<appfuse:label key="mststylerouteoperation.orderQty" styleClass="control-label"/>
														<input tabindex="16" onkeypress="return IsNumeric(event,this.id)" ondrop="return false;" onpaste="return false;" Class="form-control" name="orderQty" id="orderQty"  maxlength="255"/>
														<form:errors path="orderQty" cssClass="help-block"/>
														<span id="errororderQty" style="color: Red; display: none">* Input digits (0 - 9)</span>
														<div class="feedback"></div>
													</div>
												</div>
											</div>  
											<div class="clearfix"></div>

											<div class="form-group formwithsearch">
												<div class="icon-addon addon-md">
													<spring:bind path="mststylerouteoperation.noOfHealpers">
													<div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
													</spring:bind>
														<appfuse:label key="mststylerouteoperation.noOfHealpers" styleClass="control-label"/>
														<input tabindex="18" onkeypress="return IsNumeric(event,this.id)" ondrop="return false;" onpaste="return false;" Class="form-control" name="noOfHealpers" id="noOfHealpers"  maxlength="255"/>
														<form:errors path="noOfHealpers" cssClass="help-block"/>
														<span id="errornoOfHealpers" style="color: Red; display: none">* Input digits (0 - 9)</span>
														<div class="feedback"></div>
													</div>
												</div>
											</div>  
											<div class="clearfix"></div> 
										
											<div class="form-group formwithsearch">
												<div class="icon-addon addon-md">
										   
													<spring:bind path="mststylerouteoperation.targetDate">
													<div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
													</spring:bind>
														<appfuse:label key="mststylerouteoperation.targetDate" styleClass="control-label"/>
														<div id="datetimepicker" class="input-append date">
														<form:input tabindex="21" cssClass="form-control targetDate" path="targetDate" id="targetDate" size="11" title="date" />
															<span class="add-on">
															<i data-time-icon="icon-time" data-date-icon="icon-calendar"></i>
															</span>
														</div>
														<form:errors path="targetDate" cssClass="help-block"/>
														<div class="feedback"></div>
													</div>
												</div>
											</div> 
											<div class="clearfix"></div> 
										</div>
										
										<div class="col-sm-4 col-md-4 col-xs-4">
											<div class="form-group formwithsearch">
												<div class="icon-addon addon-md">

													<spring:bind path="mststylerouteoperation.noOfMachines">
													<div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
													</spring:bind>
														<appfuse:label key="mststylerouteoperation.noOfMachines" styleClass="control-label"/>
														<input tabindex="17" onkeypress="return IsNumeric(event,this.id)" ondrop="return false;" onpaste="return false;" Class="form-control" name="noOfMachines" id="noOfMachines"  maxlength="255"/>
														<form:errors path="noOfMachines" cssClass="help-block"/>
														<span id="errornoOfMachines" style="color: Red; display: none">* Input digits (0 - 9)</span>
														<div class="feedback"></div>
													</div>

												</div>
											</div>  
											<div class="clearfix"></div>

											<div class="form-group formwithsearch">
												<div class="icon-addon addon-md">

													<spring:bind path="mststylerouteoperation.workMins">
													<div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
													</spring:bind>
													   <appfuse:label key="mststylerouteoperation.workMins" styleClass="control-label"/>
													   <input tabindex="19" onkeypress="return IsNumeric(event,this.id)" ondrop="return false;" onpaste="return false;" Class="form-control" name="workMins" id="workMins"  maxlength="255"/>
													   <form:errors path="workMins" cssClass="help-block"/>
													   <span id="errorworkMins" style="color: Red; display: none">* Input digits (0 - 9)</span>
													   <div class="feedback"></div>
													</div>

												</div>
											 </div>  
											<div class="clearfix"></div>

											<div class="form-group formwithsearch">
												<div class="icon-addon addon-md styl-rt-remarks">

													<spring:bind path="mststylerouteoperation.remarks">
													<div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
													</spring:bind>
														<appfuse:label key="mststylerouteoperation.remarks" styleClass="control-label"/>
														<form:textarea tabindex="22" cssClass="form-control" path="remarks" id="remarks"  maxlength="100"/>
														<form:errors path="remarks" cssClass="help-block"/>
														<div class="feedback"></div>
													</div>
												</div>
											</div>
											<div class="clearfix"></div> 
										</div>
									</div>  

									<%--  Secttion 1 --%> 

									<div class="row paddingleft20">
										<div class="col-sm-8 col-md-8 col-xs-8" id="error-win">
											  <div class="alert alert-danger fade in">
												<button type="button" class="close" data-dismiss="alert" aria-hidden="true">�</button>
												<h3>Oh snap! You got an error!</h3>
												<p>Error! You didn't fill some required fields. Please fill correctly and try it again.</p>
											  </div>
										</div>
										<div class="clearfix"></div> 
													 
										<div class="col-sm-8 col-md-8 col-xs-8 marginTop30">
											<div class="aprovedby">
												<span class="glyphicon glyphicon-ok aprovedicon"></span> 
												<div class="aprovedbytitle" id="createDiv">
													Created By: ${mststylerouteoperation.createdBy}<br>
													Created On: ${mststylerouteoperation.createdOn}
												</div>  
											</div>
											<div class="createdby">
												<span class="glyphicon glyphicon-edit createdicon"></span> 
												<div class="aprovedbytitle" id="modifyDiv">
													Modified By: ${mststylerouteoperation.modifiedBy}<br>
													Modified On: ${mststylerouteoperation.modifiedOn}
												</div>  
											</div>
											<div class="modifiedby">
												<span class="glyphicon glyphicon-refresh modifiedicon"></span> 
												<div class="aprovedbytitle" id="approvDiv">
													Approved By: ${mststylerouteoperation.approvedBy}<br>
													Approved On: ${mststylerouteoperation.approvedOn}
												</div>
											</div>
										</div>

										<%--  <div class="col-sm-4 col-md-4 col-xs-4"></div> --%> 
										<div id="submision" class="submit-button styl-rt-submission-btn pull-right marginRight20 marginTop30 style_routs_submits">
										  <button type="button" tabindex="24" onclick="saveAjxStyleRoute();" id="btnSaveRoute" class="btn btn-info btn-lg btn-embossed">Submit</button>
    <a><button tabindex="23" type="button"  onclick="resetform();" id="back3" class="btn btn-default btn-lg">Reset</button></a>
                                        </div>
														
									</div>
								</form:form>
							</div> <%--  panel body end  --%> 
						</div>
					</div>
				</div>
			</div> 
		</div>
	</div> <%--  end of tab content 1 --%> 


	<div class="tab-pane" id="profile"> <%--  Start of tab content 2 --%> 
		<form action="mststylerouteoperations" method="get" id="mststyleoperationForm">
			<c:if test="${mststylerouteoperation.componentId == null}">
				<c:set var="disabled" scope="session" value=""/>
			</c:if>
			<c:if test="${mststylerouteoperation.componentId != null}">
				<c:set var="disabled" scope="session" value="readonly"/>
			</c:if>
			<div class="row paddingleft20 ">
				<div class="col-sm-3 col-md-3 col-xs-3">
					<div class="form-group formwithsearch marginbottom20">
						<div class="icon-addon addon-md">
							<label for="exampleInputEmail1">Location </label>
							<c:if test="${disabled == 'readonly'}">
								<input required ${disabled} type="text" value="${mststyleheader.id.locationCode}" name="rop_locationCode" id="rop_id_locationCode" class="typeahead form-control"/>
							</c:if>
							<c:if test="${disabled != 'readonly'}">
								<select ${disabled}  required  tabindex="1" id="rop_id_locationCode" type="text" name="rop_locationCode" class="typeahead form-control" data-provide="typeahead"  onfocus="getOptions('rop_id_locationCode','mstlocations')">
									<c:if test="${mststyleheader.id.locationCode == null}">
										<c:forEach items="${mstparam}" var="mstparams">							
											<option selected="selected">${mstparams.locationCode}</option>
										</c:forEach>
									</c:if>
									<c:if test="${mststyleheader.id.locationCode != null}">
										<option selected="selected">${mststyleheader.id.locationCode}</option>
									</c:if>
									
								</select>
							</c:if>
						</div>
					</div>
					<div class="btn-group formsearchbtn btn-model-select-div">
						<button <c:if test="${disabled != 'readonly'}"> onclick="$('#rop_id_locationCode').trigger('onfocus');addmodalpopup('rop_id_locationCode');"   data-toggle="modal" data-target="#schmodalpopup" </c:if> type="button" class="btn btn-primary btn-xs dropdown-toggle " ><span class="glyphicon glyphicon-search"></span></button>
					</div>	
					<div class="clearfix"></div> 
				</div>
				<div class="col-sm-3 col-md-3 col-xs-3">
					<div class="form-group formwithsearch marginbottom20">
						<div class="icon-addon addon-md">
							<label for="exampleInputEmail1">Company</label>
							<c:if test="${disabled == 'readonly'}">
								<input   required ${disabled} type="text" value="${mststyleheader.id.compCode}" name="rop_compCode" id="rop_id_compCode" class="typeahead form-control"/>
							</c:if>
							<c:if test="${disabled != 'readonly'}">
								<select  required ${disabled} id="rop_id_compCode" type="text" name="rop_compCode" class="typeahead form-control" data-provide="typeahead" onfocus="getOptions('rop_id_compCode','mstcompany')">
									<option></option>
									<c:if test="${mststyleheader.id.compCode == null}">
										<c:forEach items="${mstparam}" var="mstparams">
											<option >${mstparams.commonCompCode}</option>
										</c:forEach>
									</c:if>									
									<c:if test="${mststyleheader.id.compCode != null}">
										<option selected="selected" >${mststyleheader.id.compCode}</option>
									</c:if>
								</select>
							</c:if>
						</div>
					</div>	
					<div class="btn-group formsearchbtn btn-model-select-div">
						<button <c:if test="${disabled != 'readonly'}"> onclick="$('#rop_id_compCode').trigger('onfocus');addmodalpopup('rop_id_compCode');"   data-toggle="modal" data-target="#schmodalpopup" </c:if> type="button" class="btn btn-primary btn-xs dropdown-toggle " ><span class="glyphicon glyphicon-search"></span></button>
					</div>						
					<div class="clearfix"></div> 
				</div>
				<div class="col-sm-3 col-md-3 col-xs-3">
				  <div class="form-group formwithsearch marginbottom20">
						<div class="icon-addon addon-md">
							<label for="exampleInputEmail1">Buyer</label>
							<c:if test="${disabled == 'readonly'}">
								<input required ${disabled} type="text" value="${mststyleheader.id.custCode}" name="rop_custCode" id="rop_id_custCode" class="typeahead form-control"/>
							</c:if>
							<c:if test="${disabled != 'readonly'}">
								<select required ${disabled} tabindex="2" id="rop_id_custCode" type="text" name="rop_custCode" class="typeahead form-control" data-provide="typeahead" onfocus="getOptions('rop_id_custCode','mstcustomer');">
									<option>${mststyleheader.id.custCode}</option>
								</select>
							</c:if>
						</div>
					</div>
					<div class="btn-group formsearchbtn btn-model-select-div">
						<button <c:if test="${disabled != 'readonly'}">onclick="$('#rop_id_custCode').trigger('onfocus');addmodalpopup('rop_id_custCode');"  data-toggle="modal" data-target="#schmodalpopup" </c:if> type="button" class="btn btn-primary btn-xs dropdown-toggle " ><span class="glyphicon glyphicon-search"></span></button>
					</div>	
					<div class="clearfix"></div> 
				</div>

				<div class="col-sm-3 col-md-3 col-xs-3">
					<div class="form-group formwithsearch marginbottom20">
						<div class="icon-addon addon-md">
							<label for="exampleInputEmail1">Buyer Department</label>
							<c:if test="${disabled == 'readonly'}">
								<input required ${disabled} type="text" value="${mststyleheader.id.depCode}" name="rop_depCode" id="rop_id_depCode" class="typeahead form-control"/>
							</c:if>
							<c:if test="${disabled != 'readonly'}">
								<select  required ${disabled} tabindex="3" id="rop_id_depCode" type="text" name="rop_depCode" class="typeahead form-control" data-provide="typeahead"  onfocus="optionsforgencodes('rop_id_depCode','BUYDEM')">
									<option>${mststyleheader.id.depCode}</option>
								</select>
							</c:if>
						</div>
					</div>
					<div class="btn-group formsearchbtn btn-model-select-div">
						<button <c:if test="${disabled != 'readonly'}">onclick="$('#rop_id_depCode').trigger('onfocus');addmodalpopup('rop_id_depCode');"	  data-toggle="modal" data-target="#schmodalpopup" </c:if> type="button" class="btn btn-primary btn-xs dropdown-toggle " ><span class="glyphicon glyphicon-search"></span></button>
					</div>
					<div class="clearfix"></div> 
				</div>				
			</div>
			<div class="row paddingleft20 margintop-20">
				<div class="col-sm-3 col-md-3 col-xs-3">
					<div class="form-group formwithsearch marginbottom20">
						<div class="icon-addon addon-md">
							<label for="exampleInputEmail1">Style</label>
							<input required ${disabled} tabindex="4"  id="rop_id_styleId" type="text" name="rop_styleId" required="true" class="typeahead form-control" data-provide="typeahead" value="${mststyleheader.id.styleId}" onfocus="typaheadforrootOp('rop_id_styleId','mststyleheader.id.styleId')">
						</div>
					</div>  
					<div class="btn-group formsearchbtn btn-model-select-div">
						<button <c:if test="${disabled != 'readonly'}"> onclick="$('#rop_id_styleId').trigger('onfocus');addmodalpopup('rop_id_styleId');"  data-toggle="modal" data-target="#schmodalpopup" </c:if> type="button" class="btn btn-primary btn-xs dropdown-toggle " ><span class="glyphicon glyphicon-search"></span></button>
					</div>
					<div class="clearfix"></div> 
				</div>
				<div class="col-sm-3 col-md-3 col-xs-3">
					<div class="form-group formwithsearch marginbottom20">
						<div class="icon-addon addon-md">
							<label for="exampleInputEmail1">Style Description</label>
							<input  readonly="readonly"  id="rop_styleDescription" type="text" name="rop_Style_Description" class="typeahead form-control" data-provide="typeahead" value="${mststyleheader.styleDescription}" >
							
						</div>
					</div>  
					<div class="clearfix"></div>
				</div>
				<div class="col-sm-3 col-md-3 col-xs-3">
					<div class="form-group formwithsearch marginbottom20">
						<div class="icon-addon addon-md">
							<label for="exampleInputEmail1">Style Component</label>
							<c:if test="${disabled == 'readonly'}">
								<input  required ${disabled} type="text" value="${mststylerouteoperation.componentId}" name="rop_Style_Component" id="rop_id_componentId" class="typeahead form-control"/>
							</c:if>
							<c:if test="${disabled != 'readonly'}">
								<select required ${disabled} tabindex="5" id="rop_id_componentId" type="text" name="rop_Style_Component" class="typeahead form-control" data-provide="typeahead" value="${mststylerouteoperation.componentId}" onfocus="typaheadforrootOp('rop_id_componentId','componentId')">
									<option>${mststylerouteoperation.componentId}</option>
								</select>
							</c:if>
						</div>
					</div>
					<div class="btn-group formsearchbtn btn-model-select-div">
						<button <c:if test="${disabled != 'readonly'}">onclick="$('#rop_id_componentId').trigger('onfocus');addmodalpopup('rop_id_componentId');"  data-toggle="modal" data-target="#schmodalpopup" </c:if> type="button" class="btn btn-primary btn-xs dropdown-toggle " ><span class="glyphicon glyphicon-search"></span></button>
					</div>
					<div class="clearfix"></div> 
				</div>
				
				<div class="col-sm-3 col-md-3 col-xs-3">
					<div class="form-group formwithsearch marginbottom20">
					<div class="icon-addon addon-md">
						<label for="exampleInputEmail1">Main Color</label>
							<c:if test="${disabled == 'readonly'}">
								<input required ${disabled} type="text" value="${mststylerouteoperation.mainColor}" name="rop_mainColor" id="rop_id_mainColor" class="typeahead form-control"/>
							</c:if>
							<c:if test="${disabled != 'readonly'}">
								<select required ${disabled} tabindex="6" id="rop_id_mainColor" type="text" name="rop_mainColor" class="typeahead form-control" data-provide="typeahead" value="${mststylerouteoperation.mainColor}" onfocus="typaheadforrootOp('rop_id_mainColor','mainColor')">
									<option>${mststylerouteoperation.mainColor}</option>
								</select>
							</c:if>
						</div>
					</div>
					<div class="btn-group formsearchbtn btn-model-select-div">
						<button <c:if test="${disabled != 'readonly'}">onclick="$('#rop_id_mainColor').trigger('onfocus');addmodalpopup('rop_id_mainColor');"  data-toggle="modal" data-target="#schmodalpopup" </c:if> type="button" class="btn btn-primary btn-xs dropdown-toggle " ><span class="glyphicon glyphicon-search"></span></button>
					</div>
					<div class="clearfix"></div> 
				</div>
				
				<div class="col-sm-3 col-md-3 col-xs-3">
					<div class="form-group formwithsearch marginbottom20">
						<div class="icon-addon addon-md">
						  <label for="exampleInputEmail1">Style Route</label>
							<select required ${disabled} tabindex="7" id="rop_id_styleRouteId" type="text" name="rop_styleRouteId" class="typeahead form-control" data-provide="typeahead" onchange="getroute(this.options[this.selectedIndex].value,'')" value="${mststylerouteoperation.styleRouteId}" <c:if test="${disabled != 'readonly'}"> onfocus="typaheadforrootOp('rop_id_styleRouteId','styleRouteId,r.styleRouteName')" </c:if>>
								<option value="${mststylerouteoperation.styleRouteId}">${mststylerouteoperation.styleRouteName}</option>
							</select>	
						</div>
					</div>
					<div class="btn-group formsearchbtn btn-model-select-div">
						<button <c:if test="${disabled != 'readonly'}">onclick="$('#rop_id_styleRouteId').trigger('onfocus');addmodalpopup('rop_id_styleRouteId');"  data-toggle="modal" data-target="#schmodalpopup" </c:if> type="button" class="btn btn-primary btn-xs dropdown-toggle " ><span class="glyphicon glyphicon-search"></span></button>
					</div>
					<div class="clearfix"></div> 
				</div>
				<div class="col-sm-4 col-md-4">
					<button tabindex="8" onclick="" type="submit" class="btn btn-info btn-embossed search-routes-btn" id="rop_id_search" name="rop_id_search" value="true"><span class="glyphicon glyphicon-search">
					</span> Search Oprt</button>
					<button type="reset" onclick="resetFrm('rop_id_search');" class="btn btn-defalt btn-embossed search-routes-btn"><span class="glyphicon glyphicon-refresh"></span>Reset</button>
				</div>
				
			</div> <!-- end of row   -->
		</form>
	
		<div class="row paddingleft20">
			<div class="col-sm-12 col-md-12">
				<div class="panel-group" id="oparations-header">
					<div class="panel panel-default">
						<div class="panel-heading" data-toggle="collapse" data-parent="#oparations-header" data-target="#operationsBody_avalable_operations">
							<h4 class="panel-title">
								<a data-toggle="collapse" data-parent="oparations-header" href="#operationsBody_avalable_operations">
								<a class="accordion-toggle"> <span class="pull-right slideupdowntoggle glyphicon glyphicon-chevron-up"></span>Available Operations</a> </a> 
							</h4>
						</div>

						<div id="operationsBody_avalable_operations" class="panel-collapse collapse in">
							<div class="panel-body">
								<div class="row">
									<div class="col-sm-6 col-md-6 col-xs-6 pull-left">
										<button type="button" id="duplicate-opat-btn" class="btn btn-info btn-embossed pull-left"><span class="glyphicon glyphicon-file marginRight5"></span> Duplicate Opat.</button>
										<button <c:if test="${mststyleoperationLists != '[]'}">onclick="alert('Please delete all operations before copy operations from another style ...');"
										</c:if><c:if test="${mststyleoperationLists == '[]'}">onclick="gendupOperationfrmrout('routoperation'); " data-toggle="modal" data-target="#schmodalpopup"
										</c:if>  type="button" class="btn btn-info btn-embossed pull-left marginLeft15">
										<span class="glyphicon glyphicon-folder-open marginRight5"></span> Copy From Style Route</button>
										
									</div>	
									<div class="pull-right margin-addstyleroute">
									<div class="input-group custom-search-form " style="width: 370px;">
										<input value="${param.q}" tabindex="9" type="text" id="query2" class="form-control" placeholder="Search and Filter" />
										<span class="input-group-btn">
											<button tabindex="10" class="btn btn-info search-form-btn" type="button" onclick="getStyleroursOperation()" >
											<span class="glyphicon glyphicon-search"></span>
											</button>
										</span>
										<a tabindex="11" onclick=" $('#routoperationreset').trigger('click');showOpHideOpGrid();makeHeader();getoperationid() ;" class="btn btn-warning btn-embossed pull-right">Add Operation</a></div><%--  /input-group --%>
									</div>                   
								</div>
								<div class="dataTables_wrapper Scroll-for-oparations-grid" >
									<section class="">
										<display:table name="mststyleoperationLists" class="display table table-striped table-bordered table-hover" cellspacing="0" requestURI="" id="mststyleoperationLists" export="true" pagesize="25">
											
											<%-- <display:column property="id.opeartionNo" titleKey="mststyleoperation.opeartionNo" class="mynewidclass"/> --%>
											<display:column property="sequenceNo" class="textcenter" headerClass="textcenter" sortable="true" titleKey="mststyleoperation.sequenceNo"/>
											<display:column property="process" class="textcenter" headerClass="textcenter" sortable="true" titleKey="mststyleoperation.process"/>
											<display:column property="operationType" class="textcenter" headerClass="textcenter" sortable="true" titleKey="mststyleoperation.operationType"/>
											<display:column property="operation" sortable="true" class="textcenter" headerClass="textcenter" titleKey="mststyleoperation.operation"/>
											<display:column property="grade" sortable="true" class="textcenter" headerClass="textcenter" titleKey="mststyleoperation.grade"/>
											<display:column property="averageSmv" class="textcenter" headerClass="textcenter" sortable="true" titleKey="mststyleoperation.averageSmv"/>
											<display:column style="display:none;" property="calc" headerClass="displayNone" titleKey="mststyleoperation.calc"></display:column>
											<display:column sortable="false" titleKey="mststyleoperation.calc" headerClass="center" class="center" media="html">
												<c:if test="${mststyleoperationLists.calc == true}">
													<input disabled="disabled" checked="checked" type="checkbox">
												</c:if>
												<c:if test="${mststyleoperationLists.calc == false}">
													<input disabled="disabled" type="checkbox">
												</c:if>
											</display:column>
											<display:column property="revision1" sortable="true" class="textcenter" headerClass="textcenter" titleKey="mststyleoperation.revision1"/>
											<display:column property="revision2" sortable="true" class="textcenter" headerClass="textcenter" titleKey="mststyleoperation.revision2"/>
											<display:column property="revision3" sortable="true" class="textcenter" headerClass="textcenter" titleKey="mststyleoperation.revision3"/>
											<display:column property="revision4" sortable="true" class="textcenter" headerClass="textcenter" titleKey="mststyleoperation.revision4"/>
											<display:column property="revision5" sortable="true" class="textcenter" headerClass="textcenter" titleKey="mststyleoperation.revision5"/>
											<display:column property="machineTypeDefault" class="textcenter" headerClass="textcenter" sortable="true" titleKey="mststyleoperation.machineTypeDefault"/>
											<display:column property="workAid" sortable="true" class="textcenter" headerClass="textcenter" titleKey="mststyleoperation.workAid"/>
											<display:column style="display:none;" property="manual" headerClass="displayNone" titleKey="mststyleoperation.manual"></display:column>
											<display:column sortable="false" titleKey="mststyleoperation.manual" headerClass="center" class="center" media="html">
												<c:if test="${mststyleoperationLists.manual == true}">
													<input disabled="disabled" checked="checked" type="checkbox">
												</c:if>
												<c:if test="${mststyleoperationLists.manual == false}">
													<input disabled="disabled" type="checkbox">
												</c:if>
											</display:column>
											<display:column property="wipPoints" sortable="true" class="textcenter" headerClass="textcenter" titleKey="mststyleoperation.wipPoints"/>
											<display:column style="display:none;" property="printBundleTicket" headerClass="displayNone" titleKey="mststyleoperation.printBundleTicket"></display:column>
											<display:column sortable="false" titleKey="mststyleoperation.printBundleTicket" headerClass="center" class="center" media="html">
												<c:if test="${mststyleoperationLists.printBundleTicket == true}">
													<input disabled="disabled" checked="checked" type="checkbox">
												</c:if>
												<c:if test="${mststyleoperationLists.printBundleTicket == false}">
													<input disabled="disabled" type="checkbox">
												</c:if>
											</display:column>

											<display:column class="center headcol avalable_operations_actions_buttons" headerClass="headcol textcenter avalable_operations_actions" media="html" titleKey="<a>Action</a>">
												<div class="middle-align">
													<div class="edit-toggle-styl-rt edit-toggle edit-toggle avalable_operations_actions_edit">
														<a onclick=" $('#routoperationreset').trigger('click');getstyleroutoperation('${mststyleoperationLists.id.opeartionNo}', '${mststyleoperationLists.id.styleRouteId}','update');"><span class="glyphicon glyphicon-pencil"></span>Edit </a>
													</div>
													<div class="delete-toggle-styl-rt delete-toggle delete-toggle avalable_operations_actions_delete">
														<a onclick="if ( confirm('Do you really need to delete this ?') == true) {getstyleroutoperation('${mststyleoperationLists.id.opeartionNo}', '${mststyleoperationLists.id.styleRouteId}','delete')}"><span class="glyphicon glyphicon-remove"></span>Delete</a> 
													</div>
												</div>								
											</display:column>
											<display:setProperty name="paging.banner.item_name"><fmt:message key="mststyleoperationLists.mststyleoperation"/></display:setProperty>
											<display:setProperty name="paging.banner.items_name"><fmt:message key="mststyleoperationLists.mststyleoperation"/></display:setProperty>
											<display:setProperty name="export.excel.filename"><fmt:message key="mststyleoperationLists.title"/>.xls</display:setProperty>
											<display:setProperty name="export.csv.filename"><fmt:message key="mststyleoperationLists.title"/>.csv</display:setProperty>
											<display:setProperty name="export.pdf.filename"><fmt:message key="mststyleoperationLists.title"/>.pdf</display:setProperty>
										</display:table>
									</section>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div> 
		</div>

	<%--  start point --%> 
		<div class="row paddingleft20">
			<div class="col-sm-12 col-md-12">
				<div class="panel-group" id="oparations_group">
					<div class="panel panel-default">
						<div class="panel-heading" data-toggle="collapse" data-parent="#addoperation" data-target="#addoperation">
							<h4 class="panel-title">
								<a data-toggle="collapse" data-parent="#addoperation" href="#addoperation"> 
									<a class="accordion-toggle"> <span class="pull-right slideupdowntoggle glyphicon glyphicon-chevron-up"></span> <div id="rtopHeading">Add Operations</div></a>
								</a> 
							</h4>
						</div>
						
						<div id="addoperation" class="panel-collapse collapse">
							<form:form commandName="mststyleoperation" method="post" action="mststyleoperationform" id="mststyleoperationsForm" onsubmit="return validateMststyleoperation(this)">
								<div id="ids" style="display: none;">
									
									<spring:bind path="mststyleoperation.id.opeartionNo">
									<div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
									</spring:bind>
										<appfuse:label key="mststyleoperation.id.opeartionNo" styleClass="control-label"/>
										<form:input cssClass="form-control" path="id.opeartionNo" id="id_opeartionNo"  maxlength="255" value="${mststyleoperation.id.opeartionNo}"/>
										<form:errors path="id.opeartionNo" cssClass="help-block"/>
									</div>
									<input type="hidden" id="createByOp" name="createdByOperation">
									<input type="hidden" id="createdOnOp" name="createdOnOperation">
									<input type="hidden" id="createAtOp" name="createdAtOperation">
									<input type="hidden" id="wipPoints" name="wipPoints">
								</div>
								<div class="panel-body">
									<div class="row paddingleft20"><h3 class="add-styl-rt"> Section 1</h3>
										<hr>
										<div class="col-sm-4 col-md-4 col-xs-4">
											<spring:bind path="mststyleoperation.sequenceNo">
											<div class="form-group formwithsearch marginbottom20 ${(not empty status.errorMessage) ? ' has-error' : ''}">
											</spring:bind>
												<appfuse:label key="mststyleoperation.sequenceNo" styleClass="control-label"/>
												<div class="icon-addon addon-md">
													<input tabindex="12" Class="form-control" onblur="chkoperationid()" onkeypress="return IsNumeric(event,this.id)" ondrop="return false;" onpaste="return false;" name="sequenceNo" id="sequenceNo"  maxlength="255"/>
												</div>
												<form:errors path="sequenceNo" cssClass="help-block"/>
												<span id="errorsequenceNo" style="color: Red; display: none">* Input digits (0 - 9)</span>
												<div class="feedback"></div>
											</div>
											<div class="clearfix"></div>
											<spring:bind path="mststyleoperation.operation">
											<div class="form-group formwithsearch marginbottom20 ${(not empty status.errorMessage) ? ' has-error' : ''}">
											</spring:bind>
												<appfuse:label key="mststyleoperation.operation" styleClass="control-label"/>
												<div class="icon-addon addon-md">
													<select tabindex="15" Class="form-control" name="operation" id="operation"  maxlength="45" onfocus="getOptions('operation','mstoperation');" >
														<option>${mststyleoperation.operation}</option>
													</select>
												</div>
												<form:errors path="operation" cssClass="help-block"/>
												<div class="feedback"></div>
											</div> 
											<div class="btn-group formsearchbtn btn-model-select-div">
												<button onclick="$('#operation').trigger('onfocus');addmodalpopup('operation');" type="button" class="btn btn-primary btn-xs dropdown-toggle " data-toggle="modal" data-target="#schmodalpopup" ><span class="glyphicon glyphicon-search"></span></button>
											</div>											
											<div class="clearfix"></div>	 
										</div>
										
										<div class="col-sm-4 col-md-4 col-xs-4">
											<spring:bind path="mststyleoperation.process">
											<div class="form-group formwithsearch marginbottom20 ${(not empty status.errorMessage) ? ' has-error' : ''}">
											</spring:bind>
												<appfuse:label key="mststyleoperation.process" styleClass="control-label"/>
												<div class="icon-addon addon-md">
													<select tabindex="15" Class="form-control" name="process" id="process"  maxlength="45" onfocus="optionsforgencodes('process','PROPRO')" >
														<option>${mststyleoperation.process}</option>
													</select>
												</div>
												<form:errors path="process" cssClass="help-block"/>
												<div class="feedback"></div>
											</div> 
											<div class="btn-group formsearchbtn btn-model-select-div">
												<button onclick="$('#process').trigger('onfocus');addmodalpopup('process');" type="button" class="btn btn-primary btn-xs dropdown-toggle " data-toggle="modal" data-target="#schmodalpopup" ><span class="glyphicon glyphicon-search"></span></button>
											</div>	
											<div class="clearfix"></div>
											<spring:bind path="mststyleoperation.grade">
											<div class="form-group formwithsearch marginbottom20 ${(not empty status.errorMessage) ? ' has-error' : ''}">
											</spring:bind>
												<appfuse:label key="mststyleoperation.grade" styleClass="control-label"/>
												<div class="icon-addon addon-md">
													<select tabindex="15" Class="form-control" name="grade" id="grade"  maxlength="45" onfocus="optionsforgencodes('grade','GRADE')" >
														<option>${mststyleoperation.grade}</option>
													</select>
												</div>
												<form:errors path="grade" cssClass="help-block"/>
												<div class="feedback"></div>
											</div>   
											<div class="btn-group formsearchbtn btn-model-select-div">
												<button onclick="$('#grade').trigger('onfocus');addmodalpopup('grade');" type="button" class="btn btn-primary btn-xs dropdown-toggle " data-toggle="modal" data-target="#schmodalpopup" ><span class="glyphicon glyphicon-search"></span></button>
											</div>	
											<div class="clearfix"></div>  										
										</div>
										<div class="col-sm-4 col-md-4 col-xs-4">
											<spring:bind path="mststyleoperation.operationType">
											<div class="form-group formwithsearch marginbottom20 ${(not empty status.errorMessage) ? ' has-error' : ''}">
											</spring:bind>
												<appfuse:label key="mststyleoperation.operationType" styleClass="control-label"/>
												<div class="icon-addon addon-md">
													<select tabindex="15" Class="form-control" name="operationType" id="operationType"  maxlength="45" onfocus="optionsforgencodes('operationType','OPTTYP')" >
														<option>${mststyleoperation.operationType}</option>
													</select>
												</div>
												<form:errors path="operationType" cssClass="help-block"/>
												<div class="feedback"></div>
											</div> 
											<div class="btn-group formsearchbtn btn-model-select-div">
												<button onclick="$('#operationType').trigger('onfocus');addmodalpopup('operationType');" type="button" class="btn btn-primary btn-xs dropdown-toggle " data-toggle="modal" data-target="#schmodalpopup" ><span class="glyphicon glyphicon-search"></span></button>
											</div>	
											<div class="clearfix"></div> 
											<div class="form-group formwithsearch">
												<div class="icon-addon addon-md">
													<spring:bind path="mststyleoperation.averageSmv">
													<div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
													</spring:bind>
														<appfuse:label key="mststyleoperation.averageSmv" styleClass="control-label"/>
														<form:input tabindex="17" cssClass="form-control" path="averageSmv" id="averageSmv" maxlength="255" onblur="setFourDec(this);"/>
														<form:errors path="averageSmv" cssClass="help-block"/>
														<div class="feedback"></div>
													</div>
												</div>
											</div>  
											
											<div class="clearfix"></div>
										</div>
                                            <div class="col-sm-4 col-md-4 col-xs-4">
                                              <div class="form-group formwithsearch marginbottom20">
                                               <div class="icon-addon addon-md">
                                                    <spring:bind path="mststyleoperation.calc">
                                                    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
                                                    </spring:bind>
                                                    <appfuse:label key="mststyleoperation.calc" styleClass="control-label"/>
                                                    <form:checkbox tabindex="26" path="calc" id="calc" cssClass="lable-with-checkbox"/>
                                                    <form:errors path="calc" cssClass="help-block"/>
                                                  <div class="feedback"></div>
                                                </div>
                                               </div>
                                              </div>
                                            <div class="clearfix"></div>
                                           </div>
									</div><%--  Secttion 1 --%>	


									<div class="row paddingleft20"><h3 class="add-styl-rt"> Secrion 2</h3>
										<hr>
										<div class="col-sm-4 col-md-4 col-xs-4">
											<spring:bind path="mststyleoperation.machineTypeDefault">
											<div class="form-group formwithsearch marginbottom20 ${(not empty status.errorMessage) ? ' has-error' : ''}">
											</spring:bind>
												<appfuse:label key="mststyleoperation.machineTypeDefault" styleClass="control-label"/>
												<div class="icon-addon addon-md">
													<select tabindex="15" Class="form-control" name="machineTypeDefault" id="machineTypeDefault"  maxlength="45" onfocus="getOptions('machineTypeDefault','mstmachinetype');">
														<option>${mststyleoperation.machineTypeDefault}</option>
													</select>
												</div>
												<form:errors path="machineTypeDefault" cssClass="help-block"/>
												<div class="feedback"></div>
											</div> 
											<div class="btn-group formsearchbtn btn-model-select-div">
												<button onclick="$('#machineTypeDefault').trigger('onfocus');addmodalpopup('machineTypeDefault');" type="button" class="btn btn-primary btn-xs dropdown-toggle " data-toggle="modal" data-target="#schmodalpopup" ><span class="glyphicon glyphicon-search"></span></button>
											</div>	
											<div class="clearfix"></div>
										</div>
										<div class="col-sm-4 col-md-4 col-xs-4">
											<spring:bind path="mststyleoperation.workAid">
											<div class="form-group formwithsearch marginbottom20 ${(not empty status.errorMessage) ? ' has-error' : ''}">
											</spring:bind>
												<appfuse:label key="mststyleoperation.workAid" styleClass="control-label"/>
												<div class="icon-addon addon-md">
													<select tabindex="15" Class="form-control" name="workAid" id="workAid"  maxlength="45" onfocus="optionsforgencodes('workAid','ATTMNT');">
														<option>${mststyleoperation.workAid}</option>
													</select>
												</div>
												<form:errors path="workAid" cssClass="help-block"/>
												<div class="feedback"></div>
											</div>
											<div class="btn-group formsearchbtn btn-model-select-div">
												<button onclick="$('#workAid').trigger('onfocus');addmodalpopup('workAid');" type="button" class="btn btn-primary btn-xs dropdown-toggle " data-toggle="modal" data-target="#schmodalpopup" ><span class="glyphicon glyphicon-search"></span></button>
											</div>
											<div class="clearfix"></div>
										</div>
									</div>

                                    <div class="row paddingleft20">
                                        <div class="col-sm-4 col-md-4 col-xs-4">
                                            <div class="form-group formwithsearch marginbottom20">
                                                <div class="icon-addon addon-md">
                                                    <spring:bind path="mststyleoperation.printBundleTicket">
                                                    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
                                                    </spring:bind>
                                                    <appfuse:label key="mststyleoperation.printBundleTicket" styleClass="control-label"/>
                                                    <form:checkbox tabindex="24" path="printBundleTicket" id="printBundleTicket" cssClass="lable-with-checkbox"/>
                                                    <form:errors path="printBundleTicket" cssClass="help-block"/>
                                                  <div class="feedback"></div>
                                                </div>
                                            </div>
                                         </div>
                                       <div class="clearfix"></div>
                                    </div>

                                        <div class="col-sm-4 col-md-4 col-xs-4">
                                             <div class="form-group formwithsearch marginbottom20">
                                                 <div class="icon-addon addon-md">
                                                        <spring:bind path="mststyleoperation.manual">
                                                        <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
                                                        </spring:bind>
                                                        <appfuse:label key="mststyleoperation.manual" styleClass="control-label"/>
                                                        <form:checkbox tabindex="25" path="manual" id="manual" cssClass="lable-with-checkbox"/>
                                                        <form:errors path="manual" cssClass="help-block"/>
                                                    <div class="feedback"></div>
                                                  </div>
                                               </div>
                                        </div>
                                        <div class="clearfix"></div>
                                        </div>
                                </div>

									<div class="row paddingleft20">
										<div id="sizeSMV">
											<h3 class="add-styl-rt">Size Wise SMVs</h3>
											<hr>
										
											<div id="submision" class="submit-button smw-text-btn-div pull-right">
												<label for="exampleInputEmail1">Default SMV</label>
												<input tabindex="27" type="text" class="apply-form-textbox" id="DefaultSMW">
												<button tabindex="28" type="button" onclick="ApplyDefaultSMW();" class="btn btn-info btn-lg btn-embossed">Apply</button>
											</div>  
										
											<div class="table-responsive" id="smv-matrix">
											</div>
										</div>
										<div class="col-sm-8 col-md-8 col-xs-8" id="error-win-operation">
											<div class="alert alert-danger fade in">
												<button type="button" class="close" data-dismiss="alert" aria-hidden="true">�</button>
												<h3>Oh snap! You got an error!</h3>
												<p>Error! You didn't fill some required fields. Please fill correctly and try it again.</p>
											</div>
										</div>
										<div class="col-sm-8 col-md-8 col-xs-8" id="smvMessageDiv">
										</div>
										<div class="clearfix"></div>
										<div class="col-sm-8 col-md-8 col-xs-8 marginTop30">
											<div class="aprovedby">
												<span class="glyphicon glyphicon-ok aprovedicon"></span> 
												<div class="aprovedbytitle" id="createDivOp">
													Created By:<br>
													Created On:
												</div>  
											</div>
											<div class="createdby">
												<span class="glyphicon glyphicon-edit createdicon"></span> 
												<div class="aprovedbytitle" id="modifyDivOp">
													Modified By:<br>
													Modified On:
												</div>  
											</div>
											<div class="modifiedby">
												<span class="glyphicon glyphicon-refresh modifiedicon"></span> 
												<div class="aprovedbytitle" id="approvDivOp">
													Approved By:<br>
													Approved On:
												</div>
											</div>
										</div>
									
										<div id="submision" class="submit-button styl-right-submission-btn pull-right">
                                            <button tabindex="29" type="button" onclick="saveAjxSmv();" id="opSmvSaveBtn" class="btn btn-info btn-lg btn-embossed">Submit</button>
											<a><button type="reset" tabindex="28" id="routoperationreset" class="btn btn-default btn-lg">Refresh All</button></a>
										</div>
									   </div>

								</div> <%--  panel body end  --%> 
							</form:form>
						</div>
					</div>
				</div>
			</div>
		</div>
	
	</div>
	<%--  THIS IS THE END of tab too--%> 


<div class="tab-pane" id="Wip-Points"><%--  THIS IS THE Start of the Wip-Points tab three--%> 
	<form action="mststylerouteoperations" method="get" id="mststyleoperationForm">
		<c:if test="${mststylerouteoperation.componentId == null}">
				<c:set var="disabled" scope="session" value=""/>
			</c:if>
			<c:if test="${mststylerouteoperation.componentId != null}">
				<c:set var="disabled" scope="session" value="readonly"/>
			</c:if>
		<div class="row paddingleft20 ">
			
			<div class="col-sm-3 col-md-3 col-xs-3">
				<div class="form-group formwithsearch marginbottom20">
					<div class="icon-addon addon-md">
						<label for="exampleInputEmail1">Location </label>
						<c:if test="${disabled == 'readonly'}">
							<input required ${disabled} type="text" value="${mststyleheader.id.locationCode}" name="rop_locationCode" id="wrop_id_locationCode" class="typeahead form-control"/>
						</c:if>
						<c:if test="${disabled != 'readonly'}">
							<select required ${disabled}  tabindex="1" id="wrop_id_locationCode" type="text" name="rop_locationCode" class="typeahead form-control" data-provide="typeahead"  onfocus="getOptions('wrop_id_locationCode','mstlocations')">
								<c:if test="${mststyleheader.id.locationCode == null}">
									<c:forEach items="${mstparam}" var="mstparams">							
										<option selected="selected">${mstparams.locationCode}</option>
									</c:forEach>
								</c:if>
								<c:if test="${mststyleheader.id.locationCode != null}">
									<option selected="selected">${mststyleheader.id.locationCode}</option>
								</c:if>
							</select>
						</c:if>
					</div>
				</div>
				<div class="btn-group formsearchbtn btn-model-select-div">
					<button <c:if test="${disabled != 'readonly'}"> onclick="$('#wrop_id_locationCode').trigger('onfocus');addmodalpopup('wrop_id_locationCode');"   data-toggle="modal" data-target="#schmodalpopup" </c:if> type="button" class="btn btn-primary btn-xs dropdown-toggle " ><span class="glyphicon glyphicon-search"></span></button>
				</div>	
				<div class="clearfix"></div> 
			</div>
			<div class="col-sm-3 col-md-3 col-xs-3">
			  <div class="form-group formwithsearch marginbottom20">
					<div class="icon-addon addon-md">
						<label for="exampleInputEmail1">Company</label>
						<c:if test="${disabled == 'readonly'}">
							<input required ${disabled} type="text" value="${mststyleheader.id.compCode}" name="rop_compCode" id="wrop_id_compCode" class="typeahead form-control"/>
						</c:if>
						<c:if test="${disabled != 'readonly'}">
							<select required ${disabled} id="wrop_id_compCode" type="text" name="rop_compCode" class="typeahead form-control" data-provide="typeahead" onfocus="getOptions('wrop_id_compCode','mstcompany')">
								<c:forEach items="${mstparam}" var="mstparams">
								<option></option>
									<c:if test="${mststyleheader.id.compCode == null}">
										<option >${mstparams.commonCompCode}</option>
									</c:if>
								</c:forEach>
								<c:if test="${mststyleheader.id.compCode != null}">
									<option selected="selected" >${mststyleheader.id.compCode}</option>
								</c:if>
							</select>
						</c:if>
					</div>
				</div>	
				<div class="btn-group formsearchbtn btn-model-select-div">
					<button <c:if test="${disabled != 'readonly'}"> onclick="$('#wrop_id_compCode').trigger('onfocus');addmodalpopup('wrop_id_compCode');"   data-toggle="modal" data-target="#schmodalpopup" </c:if> type="button" class="btn btn-primary btn-xs dropdown-toggle " ><span class="glyphicon glyphicon-search"></span></button>
				</div>						
				<div class="clearfix"></div> 
			</div>
			<div class="col-sm-3 col-md-3 col-xs-3">
			  <div class="form-group formwithsearch marginbottom20">
					<div class="icon-addon addon-md">
						<label for="exampleInputEmail1">Buyer</label>
						<c:if test="${disabled == 'readonly'}">
							<input required ${disabled} type="text" value="${mststyleheader.id.custCode}" name="rop_custCode" id="wrop_id_custCode" class="typeahead form-control"/>
						</c:if>
						<c:if test="${disabled != 'readonly'}">
							<select required ${disabled} tabindex="2" id="wrop_id_custCode" type="text" name="rop_custCode" class="typeahead form-control" data-provide="typeahead" onfocus="getOptions('wrop_id_custCode','mstcustomer');">
								<option>${mststyleheader.id.custCode}</option>
							</select>
						</c:if>
					</div>
				</div>
				<div class="btn-group formsearchbtn btn-model-select-div">
					<button <c:if test="${disabled != 'readonly'}">onclick="$('#wrop_id_custCode').trigger('onfocus');addmodalpopup('wrop_id_custCode');"  data-toggle="modal" data-target="#schmodalpopup" </c:if> type="button" class="btn btn-primary btn-xs dropdown-toggle " ><span class="glyphicon glyphicon-search"></span></button>
				</div>	
				<div class="clearfix"></div> 
			</div>

			<div class="col-sm-3 col-md-3 col-xs-3">
				<div class="form-group formwithsearch marginbottom20">
					<div class="icon-addon addon-md">
						<label for="exampleInputEmail1">Buyer Department</label>
						<c:if test="${disabled == 'readonly'}">
							<input required ${disabled} type="text" value="${mststyleheader.id.depCode}" name="rop_depCode" id="wrop_id_depCode" class="typeahead form-control"/>
						</c:if>
						<c:if test="${disabled != 'readonly'}">
							<select required ${disabled} tabindex="3" id="wrop_id_depCode" type="text" name="rop_depCode" class="typeahead form-control" data-provide="typeahead"  onfocus="optionsforgencodes('wrop_id_depCode','BUYDEM')">
								<option>${mststyleheader.id.depCode}</option>
							</select>
						</c:if>
					</div>
				</div>
				<div class="btn-group formsearchbtn btn-model-select-div">
					<button <c:if test="${disabled != 'readonly'}">onclick="$('#wrop_id_depCode').trigger('onfocus');addmodalpopup('wrop_id_depCode');"	  data-toggle="modal" data-target="#schmodalpopup" </c:if> type="button" class="btn btn-primary btn-xs dropdown-toggle " ><span class="glyphicon glyphicon-search"></span></button>
				</div>
				<div class="clearfix"></div> 
			</div>				
		</div>
		<div class="row paddingleft20 margintop-20">
			<div class="col-sm-3 col-md-3 col-xs-3">
				<div class="form-group formwithsearch marginbottom20">
					<div class="icon-addon addon-md">
						<label for="exampleInputEmail1">Style</label>
						<input required ${disabled} tabindex="4"  id="wrop_id_styleId" type="text" name="rop_styleId" required="true" class="typeahead form-control" data-provide="typeahead" value="${mststyleheader.id.styleId}" onfocus="typaheadforrootOp('rop_id_styleId','mststyleheader.id.styleId')">
					</div>
				</div>  
				<div class="btn-group formsearchbtn btn-model-select-div">
					<button <c:if test="${disabled != 'readonly'}"> onclick="$('#wrop_id_styleId').trigger('onfocus');addmodalpopup('wrop_id_styleId');"  data-toggle="modal" data-target="#schmodalpopup" </c:if> type="button" class="btn btn-primary btn-xs dropdown-toggle " ><span class="glyphicon glyphicon-search"></span></button>
				</div>
				<div class="clearfix"></div> 
			</div>
			<div class="col-sm-3 col-md-3 col-xs-3">
				<div class="form-group formwithsearch marginbottom20">
					<div class="icon-addon addon-md">
						<label for="exampleInputEmail1">Style Description</label>
						<input  readonly="readonly"  id="wrop_styleDescription" type="text" name="rop_Style_Description" class="typeahead form-control" data-provide="typeahead" value="${mststyleheader.styleDescription}" >
						
					</div>
				</div>  
				<div class="clearfix"></div>
			</div>
			<div class="col-sm-3 col-md-3 col-xs-3">
				<div class="form-group formwithsearch marginbottom20">
					<div class="icon-addon addon-md">
						<label for="exampleInputEmail1">Style Component</label>
						<c:if test="${disabled == 'readonly'}">
							<input required ${disabled} type="text" value="${mststylerouteoperation.componentId}" name="rop_Style_Component" id="wrop_id_componentId" class="typeahead form-control"/>
						</c:if>
						<c:if test="${disabled != 'readonly'}">
							<select required ${disabled} tabindex="5" id="wrop_id_componentId" type="text" name="rop_Style_Component" class="typeahead form-control" data-provide="typeahead" value="${mststylerouteoperation.componentId}" onfocus="typaheadforrootOp('wrop_id_componentId','componentId')">
								<option>${mststylerouteoperation.componentId}</option>
							</select>
						</c:if>
					</div>
				</div>
				<div class="btn-group formsearchbtn btn-model-select-div">
					<button <c:if test="${disabled != 'readonly'}">onclick="$('#wrop_id_componentId').trigger('onfocus');addmodalpopup('wrop_id_componentId');"  data-toggle="modal" data-target="#schmodalpopup" </c:if> type="button" class="btn btn-primary btn-xs dropdown-toggle " ><span class="glyphicon glyphicon-search"></span></button>
				</div>
				<div class="clearfix"></div> 
			</div>
			
			<div class="col-sm-3 col-md-3 col-xs-3">
				<div class="form-group formwithsearch marginbottom20">
				<div class="icon-addon addon-md">
					<label for="exampleInputEmail1">Main Color</label>
						<c:if test="${disabled == 'readonly'}">
							<input required ${disabled} type="text" value="${mststylerouteoperation.mainColor}" name="rop_mainColor" id="wrop_id_mainColor" class="typeahead form-control"/>
						</c:if>
						<c:if test="${disabled != 'readonly'}">
							<select required ${disabled} tabindex="6" id="wrop_id_mainColor" type="text" name="rop_mainColor" class="typeahead form-control" data-provide="typeahead" value="${mststylerouteoperation.mainColor}" onfocus="typaheadforrootOp('wrop_id_mainColor','mainColor')">
								<option>${mststylerouteoperation.mainColor}</option>
							</select>
						</c:if>
					</div>
				</div>
				<div class="btn-group formsearchbtn btn-model-select-div">
					<button <c:if test="${disabled != 'readonly'}">onclick="$('#wrop_id_mainColor').trigger('onfocus');addmodalpopup('wrop_id_mainColor');"  data-toggle="modal" data-target="#schmodalpopup" </c:if> type="button" class="btn btn-primary btn-xs dropdown-toggle " ><span class="glyphicon glyphicon-search"></span></button>
				</div>
				<div class="clearfix"></div> 
			</div>
			
			<div class="col-sm-3 col-md-3 col-xs-3">
				<div class="form-group formwithsearch marginbottom20">
					<div class="icon-addon addon-md">
					  <label for="exampleInputEmail1">Style Route</label>
						<select required ${disabled} tabindex="7" id="wrop_id_styleRouteId" type="text" name="rop_styleRouteId" class="typeahead form-control" data-provide="typeahead" onchange="getroute(this.options[this.selectedIndex].value,'w')" value="${mststylerouteoperation.styleRouteId}" <c:if test="${disabled != 'readonly'}"> onfocus="typaheadforrootOp('wrop_id_styleRouteId','styleRouteId,r.styleRouteName')" </c:if>>
							<option value="${mststylerouteoperation.styleRouteId}">${mststylerouteoperation.styleRouteName}</option>
						</select>
					</div>
				</div>
				<div class="btn-group formsearchbtn btn-model-select-div">
					<button <c:if test="${disabled != 'readonly'}">onclick="$('#wrop_id_styleRouteId').trigger('onfocus');addmodalpopup('wrop_id_styleRouteId');"  data-toggle="modal" data-target="#schmodalpopup" </c:if> type="button" class="btn btn-primary btn-xs dropdown-toggle " ><span class="glyphicon glyphicon-search"></span></button>
				</div>
				<div class="clearfix"></div> 
			</div>
			<div class="col-sm-4 col-md-4">
				<button tabindex="8" onclick="" type="submit" class="btn btn-info btn-embossed search-routes-btn" id="wrop_id_search" name="wipsearch" value="true"><span class="glyphicon glyphicon-search">
				</span> Search Oprt</button>
				<button type="reset" onclick="resetFrm('wipsearch');" class="btn btn-defalt btn-embossed search-routes-btn"><span class="glyphicon glyphicon-refresh"></span>  Reset</button>				
			</div>
			
		</div><!-- end of row   -->
	</form>

	
    <div class="row paddingleft20">
        <div class="col-sm-12 col-md-12">
			<div class="panel-group" id="Wip-header">
				<div class="panel panel-default">
					<div class="panel-heading" data-toggle="collapse" data-parent="#Wip-header" data-target="#WipBody">
						<h4 class="panel-title">
							<a data-toggle="collapse" data-parent="Wip-header" href="#WipBody"> 
							<a class="accordion-toggle"> <span class="pull-right slideupdowntoggle glyphicon glyphicon-chevron-up"></span>Assign Wip Points to Operations</a> </a> 
						</h4>
					</div>

					<div id="WipBody" class="panel-collapse collapse">
						<div class="panel-body">

<!-- 							<div class="pull-right marginBottom20 margin-searchfilter"> -->
<!-- 								<div class="input-group width-of-search-form " style="width: 370px;"> -->
<!-- 									<input type="text" class="form-control" placeholder="Search and Filter"> -->
<!-- 									<span class="input-group-btn"> -->
<!-- 									  <button class="btn btn-info search-form-btn" type="button"> -->
<!-- 										<span class="glyphicon glyphicon-search"></span> -->
<!-- 									  </button> -->
<!-- 									</span>               -->
<!-- 								</div>                    -->
<!-- 							</div> -->

							<div class="clearfix"></div>

							<div class="dataTables_wrapper">
								<section>

									<display:table name="mststyleoperationLists" class="display table table-striped table-bordered table-hover" cellspacing="0" requestURI="" id="Mststyleoperation" export="true" pagesize="25">

										<display:column property="sequenceNo" sortable="true" class="textcenter" headerClass="textcenter" titleKey="mststyleoperation.sequenceNo"/>
										<display:column property="operation" sortable="true"  class="textcenter" headerClass="textcenter" titleKey="mststyleoperation.operation"/>
										<display:column property="operationType" sortable="true"  class="textcenter" headerClass="textcenter" titleKey="mststyleoperation.operationType"/>

										<display:column style="display:none;" property="wipPoints" headerClass="displayNone"></display:column>
										<display:column class="gradeX textcenter" headerClass="textcenter" media="html" titleKey="<a>Wip Points</a>">
											<select class="select-control" id="WIPAssignId${Mststyleoperation.sequenceNo}" onchange="WIPAssign('${Mststyleoperation.sequenceNo}',this,'${Mststyleoperation.id.opeartionNo}','${Mststyleoperation.id.styleRouteId}')" 
											data-toggle="tooltip" data-placement="top" title="" data-original-title="" >
												<option class="select-option" value=""></option>
												<c:forEach items="${mststylewippoints}" var="root">
												<% String var = "";%>
												<c:if test="${Mststyleoperation.wipPoints == root.wippointCode}">
													<% var = "selected='selected'"; %>
													<script type="text/javascript">
													var assignwip = [parseInt("${Mststyleoperation.sequenceNo}"), parseInt("${root.sequnceNo}"), parseInt("${root.wippointCode}"), "${Mststyleoperation.id}"];
													AssignWIPPoints.push(assignwip);
													</script>
												</c:if>
													<option <%=var%> class="WIPOption${root.sequnceNo}" value="${root.sequnceNo}:${root.wippointCode}">${root.sequnceNo} - ${root.wippoint}</option>
												</c:forEach>
											</select>
										</display:column>

										<display:setProperty name="paging.banner.item_name"><fmt:message key="mststylerouteoperationList.mststylerouteoperation"/></display:setProperty>
										<display:setProperty name="paging.banner.items_name"><fmt:message key="mststylerouteoperationList.mststylerouteoperations"/></display:setProperty>

										<display:setProperty name="export.excel.filename"><fmt:message key="mststylerouteoperationList.title"/>.xls</display:setProperty>
										<display:setProperty name="export.csv.filename"><fmt:message key="mststylerouteoperationList.title"/>.csv</display:setProperty>
										<display:setProperty name="export.pdf.filename"><fmt:message key="mststylerouteoperationList.title"/>.pdf</display:setProperty>
									</display:table>
								</section>
							</div>

							<div class="col-sm-9 col-md-9 col-xs-9">
								<div class="alert alert-danger fade in" id="error-win-wip-Points">
									<button type="button" class="close" data-dismiss="alert" aria-hidden="true">�</button>
									<h3>Oh snap! You got an error!</h3>
									<p>Please select all mandatory WIP points for this operation!</p>
								</div>
								<div class="alert alert-success fade in" role="alert" id="WIPSucAlert">
							      	<button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">�</span><span class="sr-only">Close</span></button>
							      	<strong>Success!! </strong> WIP Point has been successfully assined. 
							    </div>
							</div>

							<div id="submision" class="submit-button styl-right-submission-btn pull-right marginTop50 marginRight30">
    <button type="button" tabindex="11" onclick="wipPointAjx();" class="btn btn-info btn-lg btn-embossed marginRight0 marginLeft20">Submit</button><span class="marginLeft20"></span>
								<a><button tabindex="10" id="back3" class="btn btn-default btn-lg">Refresh-All</button></a>
							</div> 

						</div> <%--  Pannel Body Ends --%> 
					</div>
				</div> 

			</div> 
        </div>
	</div>

	<c:forEach items="${mststylewippoints}" var="root">
		<script>
			var wips = ["${root.wippointCode}", "${root.name}", "${root.sequnceNo}", "${root.mandetory}", "${root.wippoint}", "${root.description}"];
			WIPPoints.push(wips);
		</script>
	</c:forEach>
	
</div> <%--  THIS IS THE End of the Wip-Points tab three--%> 


</div>

<c:if test="${mststylerouteoperation.mststyleheader.svmType == 'Size Wise'}">
	<script>
		$('#averageSmv').attr('readonly', true);
	</script>
</c:if>
<c:if test="${mststylerouteoperation.mststyleheader.svmType != 'Size Wise'}">
	<script>
		document.getElementById("sizeSMV").style.display = 'none';
	</script>
</c:if>

<script>
	smvVertical = "${smvVertical}";
	smvHorizontal = "${smvHorizontal}";
	smvVerDemValue = [];
	smvHorDemValue = [];
	smvSelected = [];
	smvMainColors = [];
	
	<c:forEach items="${smvVerDemValue}" var="root">
		smvVerDemValue.push("${root}");
	</c:forEach>
	
	<c:forEach items="${smvHorDemValue}" var="root">
		smvHorDemValue.push("${root}");
	</c:forEach>
	
	<c:forEach items="${smvSelected}" var="root">
		smvSelected.push("${root}");
	</c:forEach>
	
	<c:forEach items="${mststylemainColors}" var="root">
		smvMainColors.push("${root.id.mainColor}");
	</c:forEach>
	
</script>
<script>

	$(window).bind("load", function() {
		checkEditMode();
		SMVMatrix('method');
	});
	$(document).ready(function(){
	
	 if("${ropsearch}"=="true"){
		stylerotenavigation('profile');
	 }
	 else if("${wipsearch}"=="true"){
		stylerotenavigation('Wip-Points')
	 }
	else {
		console.log("${ropsearch}");
	} 
	 
	 var nowTemp = new Date();
	 var now = new Date(nowTemp.getFullYear(), nowTemp.getMonth(), nowTemp.getDate(), 0, 0, 0, 0);
	 $('#datetimepicker').datepicker({
	    format: 'yyyy-mm-dd',
	    startDate: now
	 });
	 
	/* $('.datepicker').datepicker({
		 onRender: function(date) {
			 
		 	return date.valueOf() < now.valueOf() ? 'disabled' : '';
		 }
	})
	 //$( ".datepicker" ).datepicker({ minDate: 0});
	 
	 /*$('#targetDate').datepicker({
		startDate: new Date(2014, 9, 5)
	})*/
		
	 disableWipOptions();
		$('#mststylerouteoperationsForm').validate({
			rules: {
				id_styleId:{
		    		required: true
		    	}
			},errorPlacement: function(error,element){
				console.info(element);
				parentDiv = element.parents('.addon-md');
				errorDiv = parentDiv.children(".feedback");
				error.appendTo(errorDiv);
			}
		});
		$('#mststylerouteoperationForm').validate({ // initialize the plugin
            rules: {
            	styleRouteName:{
            		required: true
            	},
            	id_componentId: {
                	required: true
        		},
        		assignLocation:{
        			required: true
        		},
        		id_mainColor:{
        			required: true
        		},
        		noOfPcs:{
        			required: true,
        			number: true
        		},
		    	assignLocation :{
        			required: true
            	},
            	orderQty:{
        			number: true
        		},
        		noOfMachines:{
        			number: true
        		},
        		noOfWokers:{
        			number: true
        		},
        		noOfHealpers:{
        			number: true
        		},
        		workMins:{
        			number: true
        		},
        		cycleTime:{
        			number: true
        		}
            	/* targetDate :{
            		min: -7
                } */
            }
            ,errorPlacement: function(error,element){
        		parentDiv = element.parents('.form-group');
        		errorDiv = parentDiv.children(".feedback");
        		error.appendTo(errorDiv);
        	},
            success: function( label ) {
            	$('#error-win').hide();
            }
        });
        
		$('#mststyleoperationsForm').validate({ // initialize the plugin
            rules: {
            	sequenceNo:{
            		required: true,
        			number: true
            	},
            	process: {
                	required: true
        		},
        		operationType: {
        			required: true
        		},
        		operation:{
        			required: true
        		},
        		averageSmv:{
        			required: true,
        			number: true
        		},
        		machineTypeDefault :{
        			required: true
            	}
//             	,grade :{
//             		required: true
//                 }
            }
            ,errorPlacement: function(error,element){
        		parentDiv = element.parents('.form-group');
        		errorDiv = parentDiv.children(".feedback");
        		error.appendTo(errorDiv);
        	},
            success: function( label ) {
            	$('#error-win-operation').hide();
            }
        });
		
        $('#error-win').hide();
        $('#smvMessageDiv').hide();
        $('#error-win-operation').hide();
        $('#error-win-wip-Points').hide();
        $('#WIPSucAlert').hide();
        $('#productType').attr('readonly', true);
        

	 	var tables=new Array();
        tables=["table_id_styleId"];//"table_id_locationCode","table_id_custCode","table_id_depCode","table_id_compCode",
        search=new Array();
        search=["S"];//"L","C","D","Co",
		for(var i=0;i<tables.length;i++){
			stylefuzzy(tables[i],"search"+search[i]);
		}
		tables=["rop_table_id_styleId"];
		search=["S"];
		for(var i=0;i<tables.length;i++){
				stylefuzzy(tables[i],"rop_search"+search[i]);
		}
        /* tables=["rop_table_id_locationCode","rop_table_id_custCode","rop_table_id_depCode","rop_table_id_compCode","rop_table_id_styleDescription","rop_table_id_componentId","rop_table_id_mainColor","rop_table_id_styleRouteId"];
        search=new Array();
        search=["L","C","D","Co","Sd","Ci","Mc","Sr"]
		for(var i=0;i<tables.length;i++){
			stylefuzzy(tables[i],"rop_search"+search[i]);
		} */

        /* tables=["table_id_process","table_id_optype","table_id_grade","table_id_workAid"];
        search=new Array();
        search=["pr","opty","gd","wa"]
		for(var i=0;i<tables.length;i++){
			stylefuzzy(tables[i],"search"+search[i]);
		} */
       // process
         $('#myModal').modal({  show: false });
		//rop_styleIds=
		//$("#rop_id_styleId").typeahead({ source: rop_styleIds});
        //typaheadforrootOp(null,"NOT");
      	//getStyleparams(null); 
      	
      	/** Comment*/
		/*if(document.getElementById('id_mainColor').value == ""){
			document.getElementById('id_mainColor').value = "General";
			
		}
		$('#addoperation').collapse('hide');
		document.getElementById('addoperation').className = "panel-collapse collapse";
		*/
		<c:if test="${mststylerouteoperationList != null}">

			showRouteGrid();
		</c:if>
		<c:if test="${param.styleRouteId != null}">
			editRouteOperation('${param.styleRouteId}');
		</c:if>
		
	});
	
	
</script>




<script src="scripts/applicationjs/mststyleroute.js"></script>
