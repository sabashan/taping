<%@ include file="/common/taglibs.jsp"%>
<head>
    <title><fmt:message key="mststylerouteoperationList.title"/></title>
    <meta name="menu" content="MststylerouteoperationMenu"/>
</head>


<c:set var="delObject" scope="request"><fmt:message key="merprecostsheetList.merprecostsheet"/></c:set>
<script type="text/javascript">var msgDelConfirm =
   "<fmt:message key="delete.confirm"><fmt:param value="${delObject}"/></fmt:message>";
</script>
<style type="text/css" class="init">  
    th, td { white-space: nowrap; }
    #example_filter.dataTables_filter>label{float: left;}
    div.dataTables_wrapper { width:100%;}
</style>

<div class="row form-group paddingleft20">
	<!-- NAVIGATION PILLS -->
	<div class="col-xs-8">
		<h2>View Style Routes</h2>
	</div>
</div>

<!-- NAVIGATION PILLS END-->
<c:if test="${rederect == '[]'}">	
	<script>
		if(confirm('Nothing to display here Prese yes to rederct  page ?') == true){
			//location.replace("mststylerouteoperations?locationCode=${mststylerouteoperation.mststyleheader.id.locationCode}&compCode=${mststylerouteoperation.mststyleheader.id.compCode}&custCode=${mststylerouteoperation.mststyleheader.id.custCode}&depCode=${mststylerouteoperation.mststyleheader.id.depCode}&styleId=${mststylerouteoperation.mststyleheader.id.styleId}");
		}
		else{
	
		}
	</script>
</c:if>

<div class="tab-content">
	<!-- TAB CONTENT MAIN -->
	<div class="tab-pane active" id="home">
		<form action="mststylerouteview" method="get" id="stylerouteview">
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
								<input required ${disabled} type="text" value="${mststylerouteoperation.mststyleheader.id.locationCode}" name="rop_locationCode" id="rop_id_locationCode" class="typeahead form-control"/>
							</c:if>
							<c:if test="${disabled != 'readonly'}">
								<select ${disabled}  required  tabindex="1" id="rop_id_locationCode" type="text" name="rop_locationCode" class="typeahead form-control" data-provide="typeahead"  onfocus="getOptions('rop_id_locationCode','mstlocations')">
									<c:if test="${mststylerouteoperation.mststyleheader.id.locationCode == null}">
										<c:forEach items="${mstparam}" var="mstparams">							
											<option selected="selected">${mstparams.locationCode}</option>
										</c:forEach>
									</c:if>
									<c:if test="${mststylerouteoperation.mststyleheader.id.locationCode != null}">
										<option selected="selected">${mststylerouteoperation.mststyleheader.id.locationCode}</option>
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
								<input   required ${disabled} type="text" value="${mststylerouteoperation.mststyleheader.id.compCode}" name="rop_compCode" id="rop_id_compCode" class="typeahead form-control"/>
							</c:if>
							<c:if test="${disabled != 'readonly'}">
								<select  required ${disabled} id="rop_id_compCode" type="text" name="rop_compCode" class="typeahead form-control" data-provide="typeahead" onfocus="getOptions('rop_id_compCode','mstcompany')">
									<c:if test="${mststylerouteoperation.mststyleheader.id.compCode == null}">
										<c:forEach items="${mstparam}" var="mstparams">
											<option >${mstparams.commonCompCode}</option>
										</c:forEach>
									</c:if>
									<c:if test="${mststylerouteoperation.mststyleheader.id.compCode != null}">
										<option selected="selected" >${mststylerouteoperation.mststyleheader.id.compCode}</option>
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
								<input required ${disabled} type="text" value="${mststylerouteoperation.mststyleheader.id.custCode}" name="rop_custCode" id="rop_id_custCode" class="typeahead form-control"/>
							</c:if>
							<c:if test="${disabled != 'readonly'}">
								<select required ${disabled} tabindex="2" id="rop_id_custCode" type="text" name="rop_custCode" class="typeahead form-control" data-provide="typeahead" onfocus="getOptions('rop_id_custCode','mstcustomer');">
									<option>${mststylerouteoperation.mststyleheader.id.custCode}</option>
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
								<input required ${disabled} type="text" value="${mststylerouteoperation.mststyleheader.id.depCode}" name="rop_depCode" id="rop_id_depCode" class="typeahead form-control"/>
							</c:if>
							<c:if test="${disabled != 'readonly'}">
								<select  required ${disabled} tabindex="3" id="rop_id_depCode" type="text" name="rop_depCode" class="typeahead form-control" data-provide="typeahead"  onfocus="optionsforgencodes('rop_id_depCode','BUYDEM')">
									<option>${mststylerouteoperation.mststyleheader.id.depCode}</option>
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
							<input required ${disabled} tabindex="4"  id="rop_id_styleId" type="text" name="rop_styleId" required="true" class="typeahead form-control" data-provide="typeahead" value="${mststylerouteoperation.mststyleheader.id.styleId}" onfocus="typaheadforrootOp('rop_id_styleId','mststyleheader.id.styleId')">
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
							<input  readonly="readonly"  id="rop_styleDescription" type="text" name="rop_Style_Description" class="typeahead form-control" data-provide="typeahead" value="${mststylerouteoperation.mststyleheader.styleDescription}" >
							
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
							<select required ${disabled} tabindex="7" id="rop_id_styleRouteId" type="text" name="styleRouteId" class="typeahead form-control" data-provide="typeahead" onchange="getroute(this.options[this.selectedIndex].value,'')" value="${mststylerouteoperation.styleRouteId}" <c:if test="${disabled != 'readonly'}"> onfocus="typaheadforrootOp('rop_id_styleRouteId','styleRouteId,r.styleRouteName')" </c:if>>
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
					</span> View Route Details</button>
					<button type="reset" onclick="this.form.reset();" class="reset  replace-data btn btn-defalt btn-embossed search-routes-btn"><span class="glyphicon glyphicon-refresh"></span>Reset</button>
				</div>
			</div> <%--  end of row  --%> 
		</form>
			<!-- End of row -->
			
		<div class="row paddingleft20">
			<div class="col-sm-12 col-md-12">
				<div class="panel-group" id="StyleRoutes">
					<div class="panel panel-default">
						<div class="panel-heading" data-toggle="collapse"
							data-parent="#StyleRoutes" data-target="#styleRoutesBody">
							<h4 class="panel-title">
								<a data-toggle="collapse" data-parent="#StyleRoutes"
									href="#styleBrowserBody"> </a><a class="accordion-toggle">
									<span
									class="pull-right slideupdowntoggle glyphicon glyphicon-chevron-up"></span>Style Routes
								</a>
							</h4>
						</div>
						<div id="styleRoutesBody" class="panel-collapse collapse out" style="height: auto;">
							<div class="panel-body">
								<div
									class="col-sm-1 col-md-1 col-xs-1 padding0 marginbottom20 ">
									<p class="div-table-heading">Route Name</p>
								</div>

								<div
									class="col-sm-2 col-md-2 col-xs-2 div-table-text-position marginbottom20">
									<p class="div-table-heading">${mststylerouteoperation.styleRouteName}</p>
								</div>

								<div class="clearfix"></div>

								<div class="col-sm-1 col-md-1 col-xs-1 padding0 ">
									<p class="div-table-heading">Component</p>
								</div>

								<div class="col-sm-2 col-md-2 col-xs-2 div-table-text-position">
									<p class="div-table-normal-text">${mststylerouteoperation.componentId}</p>
								</div>

								<div class="col-sm-1 col-md-1 col-xs-1 padding0">
									<p class="div-table-heading">Color</p>
								</div>

								<div class="col-sm-2 col-md-2 col-xs-2 div-table-text-position">
									<p class="div-table-normal-text">${mststylerouteoperation.mainColor}</p>
								</div>

								<div class="col-sm-1 col-md-1 col-xs-1 padding0">
									<p class="div-table-heading">Order Qty</p>
								</div>

								<div class="col-sm-2 col-md-2 col-xs-2 div-table-text-position">
									<p class="div-table-normal-text">${mststylerouteoperation.orderQty} </p>
								</div>

								<div class="col-sm-1 col-md-1 col-xs-1 padding0">
									<p class="div-table-heading">Assigned Location</p>
								</div>

								<div class="col-sm-2 col-md-2 col-xs-2 div-table-text-position">
									<p class="div-table-normal-text">${mststylerouteoperation.assignLocation} </p>
								</div>

								<div class="clearfix"></div>

								<div class="col-sm-1 col-md-1 col-xs-1 padding0">
									<p class="div-table-heading">Product Type</p>
								</div>

								<div class="col-sm-2 col-md-2 col-xs-2 div-table-text-position">
									<p class="div-table-normal-text">${mststylerouteoperation.productType} </p>
								</div>

								<div class="col-sm-1 col-md-1 col-xs-1 padding0">
									<p class="div-table-heading">No of Pcs</p>
								</div>

								<div class="col-sm-2 col-md-2 col-xs-2 div-table-text-position">
									<p class="div-table-normal-text">${mststylerouteoperation.noOfPcs} </p>
								</div>

								<div class="col-sm-1 col-md-1 col-xs-1 padding0">
									<p class="div-table-heading">Status</p>
								</div>

								<div class="col-sm-2 col-md-2 col-xs-2 div-table-text-position">
									<p class="div-table-normal-text">${mststylerouteoperation.totalSMV} </p>
								</div>

                                    <div class="col-sm-1 col-md-1 col-xs-1 padding0">
                                    <p class="div-table-heading">No of Machines</p>
                                    </div>

                                    <div class="col-sm-2 col-md-2 col-xs-2 div-table-text-position">
                                    <p class="div-table-normal-text">${mststylerouteoperation.totalSMV} </p>
                                    </div>

                                <div class="clearfix"></div>

                                    <div class="col-sm-1 col-md-1 col-xs-1 padding0">
                                    <p class="div-table-heading">No of Workers</p>
                                    </div>

                                    <div class="col-sm-2 col-md-2 col-xs-2 div-table-text-position">
                                    <p class="div-table-normal-text">${mststylerouteoperation.totalSMV} </p>
                                    </div>

                                    <div class="col-sm-1 col-md-1 col-xs-1 padding0">
                                    <p class="div-table-heading">No of Helpers</p>
                                    </div>

                                    <div class="col-sm-2 col-md-2 col-xs-2 div-table-text-position">
                                    <p class="div-table-normal-text">${mststylerouteoperation.totalSMV} </p>
                                    </div>

                                    <div class="col-sm-1 col-md-1 col-xs-1 padding0">
                                    <p class="div-table-heading">Work Minutes</p>
                                    </div>

                                    <div class="col-sm-2 col-md-2 col-xs-2 div-table-text-position">
                                    <p class="div-table-normal-text">${mststylerouteoperation.totalSMV} </p>
                                    </div>

                                    <div class="col-sm-1 col-md-1 col-xs-1 padding0">
                                    <p class="div-table-heading">Cycle Time</p>
                                    </div>

                                    <div class="col-sm-2 col-md-2 col-xs-2 div-table-text-position">
                                    <p class="div-table-normal-text">${mststylerouteoperation.totalSMV} </p>
                                    </div>

                                    <div class="clearfix"></div>

                                    <div class="col-sm-1 col-md-1 col-xs-1 padding0">
                                    <p class="div-table-heading">Target Date</p>
                                    </div>

                                    <div class="col-sm-2 col-md-2 col-xs-2 div-table-text-position">
                                    <p class="div-table-normal-text">${mststylerouteoperation.totalSMV} </p>
                                    </div>

								<div class="col-sm-2 col-md-2 col-xs-2 pull-right margintop30 textAlignRight">
									<a  href="mststylerouteoperations?styleRouteId=${mststylerouteoperation.styleRouteId}&locationCode=${mststylerouteoperation.mststyleheader.id.locationCode}&depCode=${mststylerouteoperation.mststyleheader.id.depCode}&compCode=${mststylerouteoperation.mststyleheader.id.compCode}&styleId=${mststylerouteoperation.mststyleheader.id.styleId}&custCode=${mststylerouteoperation.mststyleheader.id.custCode}&#mststylerouteoperationForm">	
										<button type="button" class="btn btn-info btn-embossed marginbottom20 resopnsive-fix-search-oprt">
											<span class="glyphicon glyphicon-pencil"> </span> Edit
											Section
										</button>
									</a>
								</div>
								<div class="clearfix"></div>
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
						<div class="panel-heading" data-toggle="collapse"
							data-parent="#stylebrowser" data-target="#styleBrowserBody">
							<h4 class="panel-title">
								<a data-toggle="collapse" data-parent="#stylebrowser"
									href="#styleBrowserBody"> <a class="accordion-toggle">
										<span
										class="pull-right slideupdowntoggle glyphicon glyphicon-chevron-up"></span>Style
										Oparations
								</a>
								</a>
							</h4>
						</div>
						<div id="styleBrowserBody" class="panel-collapse collapse">
							<div class="panel-body">
								<div class="dataTables_wrapper Scroll-for-oparations-grid">
									<section>
										<display:table name="mststyleoperationLists" class="display table table-striped table-bordered table-hover" cellspacing="0" requestURI="" id="mststyleoperationLists" export="true" pagesize="25">
											
											<display:column property="id.opeartionNo" sortable="true" headerClass="textcenter" class="textcenter" titleKey="mststyleoperation.opeartionNo"/>
											<display:column property="process" sortable="true" headerClass="textcenter" class="textcenter" titleKey="mststyleoperation.process"/>
											<display:column property="operationType" sortable="true" headerClass="textcenter" class="textcenter" titleKey="mststyleoperation.operationType"/>
											<display:column property="operation" sortable="true" headerClass="textcenter" class="textcenter" titleKey="mststyleoperation.operation"/>
											<display:column property="grade" sortable="true" headerClass="textcenter" class="textcenter" titleKey="mststyleoperation.grade"/>
											<display:column property="averageSmv" sortable="true" headerClass="textcenter" class="textcenter" titleKey="mststyleoperation.averageSmv"/>
											<display:column property="calc" sortable="true" headerClass="textcenter" class="textcenter" titleKey="mststyleoperation.calc"/>
											<display:column property="revision1" sortable="true" headerClass="textcenter" class="textcenter" titleKey="mststyleoperation.revision1"/>
											<display:column property="machineTypeDefault" sortable="true" headerClass="textcenter" class="textcenter" titleKey="mststyleoperation.machineTypeDefault"/>
											<display:column property="workAid" sortable="true" headerClass="textcenter" class="textcenter" titleKey="mststyleoperation.workAid"/>
											<display:column property="manual" sortable="true" headerClass="textcenter" class="textcenter" titleKey="mststyleoperation.manual"/>
											<display:column property="wipPoints" sortable="true" headerClass="textcenter" class="textcenter" titleKey="mststyleoperation.wipPoints"/>
											<display:column property="printBundleTicket" sortable="true" headerClass="textcenter" class="textcenter" titleKey="mststyleoperation.printBundleTicket"/>
						
											<display:column class="center headcol textcenter style_operations_action" headerClass="headcol textcenter style_operations_action_title" media="html" titleKey="<a>Action</a>">
												<div class="middle-align">
													<div class="edit-toggle-styl-rt edit-toggle edit-toggle">
														<a onclick=" $('#routoperationreset').trigger('click');getstyleroutoperation('${mststyleoperationLists.id.opeartionNo}', '${mststyleoperationLists.id.styleRouteId}', 'update')"><span class="glyphicon glyphicon-pencil"></span>Edit </a>
													</div>
													<div class="delete-toggle-styl-rt delete-toggle delete-toggle">
														<a onclick="if ( confirm('do you really need to delete this ?') == true) {getstyleroutoperation('${mststyleoperationLists.id.opeartionNo}', '${mststyleoperationLists.id.styleRouteId}', 'delete')}"><span class="glyphicon glyphicon-remove"></span>Delete</a> 
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
								<div class="col-sm-8 col-md-8 col-xs-8" id="smvMessageDiv">
								</div>
								<div class="clearfix"></div>
								<div class="col-sm-8 col-md-8 col-xs-8 marginTop30">
									<div class="aprovedby">
										<span class="glyphicon glyphicon-ok aprovedicon"></span> 
										<div class="aprovedbytitle" id="createDivOp">
											Created By:${mststylerouteoperation.createdBy}<br>
											Created On:${mststylerouteoperation.createdOn}
										</div>  
									</div>
									<div class="createdby">
										<span class="glyphicon glyphicon-edit createdicon"></span> 
										<div class="aprovedbytitle" id="modifyDivOp">
											Modified By:${mststylerouteoperation.modifiedBy}<br>
											Modified On:${mststylerouteoperation.modifiedOn}
										</div>  
									</div>
								</div>
								<div id="submision"
									class="submit-button styl-rt-submission-btn pull-right marginRight0 marginTop30">
									<c:if test="${routeDelete == 'true'}">
										<button type="button" onclick="if ( confirm('do you really need to delete this ?') == true){deleteRoute('id.locationCode=${mststylerouteoperation.mststyleheader.id.locationCode}&id.compCode=${mststylerouteoperation.mststyleheader.id.compCode}&id.custCode=${mststylerouteoperation.mststyleheader.id.custCode}&id.depCode=${mststylerouteoperation.mststyleheader.id.depCode}&id.styleId=${mststylerouteoperation.mststyleheader.id.styleId}','&id.componentId=${mststylerouteoperation.componentId}&id.mainColor=${mststylerouteoperation.mainColor}&id.styleRouteId=${mststylerouteoperation.styleRouteId}&delete=true')}" class="btn btn-info btn-lg btn-embossed marginRight0">Delete</button>
									</c:if>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
			
	</div>
</div>

<v:javascript formName="mststyleroute" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<c:url value='/scripts/validator.jsp'/>"></script>
<script>
var isstyleselect="${NO}";
	$('#nav-dropdown .dropdown-menu').on({
	    "click":function(e){
	      e.stopPropagation();
	    }
	 });
</script>  
<script src="scripts/applicationjs/mststyleroute.js"></script>

