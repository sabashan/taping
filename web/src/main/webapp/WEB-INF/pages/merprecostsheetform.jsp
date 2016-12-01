<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="merprecostsheetDetail.title"/></title>
    <meta name="heading" content="<fmt:message key='merprecostsheetDetail.heading'/>"/>
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
<div class="row form-group paddingleft20"> <!-- NAVIGATION PILLS -->
	<div class="col-xs-8"><h2>Add Pre Cost Sheet</h2></div>
	
	<div class="col-xs-4 hrline">
		<ul class="nav nav-justified setup-panel">
			<li class="active"  id="nhome">
				<a href="#home" >
					<button id="sec1"  onclick="pagenavigation('home')" type="button" class="btn btn-default btn-circle">
						<span class="glyphicon glyphicon-th-list"></span>
					</button>
					<p class="list-group-item-text">General Details</p>
				</a>
			</li>
			<li id="nprofile"  class="disabled">
				<a href="#profile">
					<button id="sec2" onclick="pagenavigation('profile')" type="button" class="btn btn-default btn-circle" >
						<span class="glyphicon glyphicon-th-large"></span>
					</button>
					<p class="list-group-item-text">Components & Colors</p>
				</a>
			</li>
			<li  id="nPricing" class="disabled">
				<a href="#Pricing">
					<button id="sec3" onclick="pagenavigation('Pricing')" type="button" class="btn btn-default btn-circle" >
						<span class="glyphicon glyphicon-fullscreen">
					</button>
					<p class="list-group-item-text">Size Dimensions </p>
				</a>
			</li>
		</ul>
	</div>
	<!-- <div class="col-xs-4 styletoure-hrline">
		<ul class="nav nav-justified setup-panel" id="myTab">
			<li class="active" id="nhome" ><a href="#home" data-toggle="tab">
				<button type="button" class="btn btn-default btn-circle"><span class="glyphicon glyphicon-info-sign"></span></button>
				<p class="list-group-item-text">General Details</p> </a>
			</li>
			<li id="nprofile" class="disabled" ><a href="#profile" data-toggle="tab">
				<button  disabled type="button" class="btn btn-default btn-circle" ><span class="glyphicon glyphicon-pushpin"></span></button>
				<p class="list-group-item-text">Add Raw Materials</p></a>
			</li>
			<li id="nPricing" class="disabled" ><a href="#Pricing" data-toggle="tab">
				<button disabled type="button" class="btn btn-default btn-circle" ><span class="glyphicon glyphicon-th-list"></span></button>
				<p class="list-group-item-text">Pricing Details</p></a>
			</li>
		</ul>
	</div>-->
</div>
<div class="tab-content"><!-- TAB CONTENT MAIN -->
	<div class="tab-pane active" id="home">	
		<form:errors path="*" cssClass="alert alert-danger alert-dismissable" element="div"/>
		<form:form commandName="merprecostsheet" method="post" action="merprecostsheetform" id="merprecostsheetForm" onsubmit="return validateMerprecostsheet(this)">
			<div class="row paddingleft20">
				<c:if test="${merprecostsheet.mststyleheader.id.styleId == null}">
					<c:set var="disabled" scope="session" value=""/>
				</c:if>
				<c:if test="${merprecostsheet.mststyleheader.id.styleId != null}">
					<c:if test="${mststyleheader.id.styleId == null}">
						<c:set var="disabled" scope="session" value=""/>
					</c:if>
					<c:if test="${mststyleheader.id.styleId != null}">
						<c:set var="disabled" scope="session" value="readonly"/>
					</c:if>
				</c:if>
				
				<div class="col-sm-4 col-md-4 ">
					<div class="form-group formwithsearch marginbottom20">
						<div class="icon-addon addon-md">
							<label for="exampleInputEmail1">Buyer </label>
							<select ${disabled} required="required" type="text" name="custCode" id="pcs_id_custCode" onfocus="getOptions('pcs_id_custCode','mstcustomer')" class="form-control" >
								<c:if test="${merprecostsheet.mststyleheader.id.custCode!=null}">
									<option selected="selected">${merprecostsheet.mststyleheader.id.custCode}</option>
								</c:if>
								<c:if test="${merprecostsheet.mststyleheader.id.custCode == null}">
									<c:if test="${mststyleheader.id.custCode !=null}">
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
								<c:if test="${merprecostsheet.mststyleheader.id.locationCode == null}">
									<c:if test="${mststyleheader.id.locationCode !=null}">
										<option selected="selected">${mststyleheader.id.locationCode}</option>
									</c:if>						
									<c:if test="${mststyleheader.id.locationCode ==null}">
										<c:if test="${param.locationCode !=null}">
											<option selected="selected">${param.locationCode}</option>
										</c:if>
										<c:if test="${param.locationCode ==null}">
											<c:forEach items="${mstparam}" var="mstparams">	
												<option selected="selected">${mstparams.locationCode}</option>
											</c:forEach>
										</c:if>
										
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
								<c:if test="${merprecostsheet.mststyleheader.id.depCode != null}">
									<option selected="selected">${merprecostsheet.mststyleheader.id.depCode}</option>
								</c:if>
								<c:if test="${merprecostsheet.mststyleheader.id.depCode == null}">
									<c:if test="${mststyleheader.id.depCode !=null}">
										<option selected="selected">${mststyleheader.id.depCode}</option>
									</c:if>						
									<c:if test="${mststyleheader.id.depCode ==null}">
										<option selected="selected">${param.depCode}</option>
									</c:if>
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
								<input ${disabled}  required="required" type="text" name="styleId" id="pcs_id_styleId"  class="form-control" class="typeahead form-control" data-provide="typeahead" value='<c:if test="${merprecostsheet.mststyleheader.id.styleId!=null}">${merprecostsheet.mststyleheader.id.styleId}</c:if><c:if test="${merprecostsheet.mststyleheader.id.styleId ==null}"> <c:if test="${mststyleheader.id.styleId!=null}">${mststyleheader.id.styleId}</c:if><c:if test="${mststyleheader.id.styleId==null}">${param.styleId}</c:if></c:if>' 
								 onfocus="typaheadforStyle('pcs_id_styleId','id.styleId')" >
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
								<c:if test="${merprecostsheet.mststyleheader.id.compCode == null}">
									<c:if test="${mststyleheader.id.compCode !=null}">
										<option selected="selected">${mststyleheader.id.compCode}</option>
									</c:if>						
									<c:if test="${mststyleheader.id.compCode ==null}">
										<option selected="selected">${param.compCode}</option>
									</c:if>
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
							<input  type="text" name="styleDescription" id="pcs_styleDescription" value='<c:if test="${merprecostsheet.mststyleheader.styleDescription!=null}">${merprecostsheet.mststyleheader.styleDescription}</c:if><c:if test="${merprecostsheet.mststyleheader.styleDescription ==null}"><c:if test="${mststyleheader.styleDescription!=null}"> ${mststyleheader.styleDescription}</c:if><c:if test="${mststyleheader.styleDescription==null}">${param.styleDescription}</c:if></c:if>' class="form-control" readonly="readonly">
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
					<button type="button" class="btn btn-info btn-embossed search-routes-btn" onclick="selectStyle()"><span class="glyphicon glyphicon-search"></span>Select Style</button>
					<button type="button" class="reset replace-data btn btn-defalt btn-embossed search-routes-btn"><span class="glyphicon glyphicon-refresh"></span>Reset</button>
				</div>
			</div>	
			<div class="row paddingleft20" >
				<div class="col-sm-12 col-md-12">
					<div class="panel-group" id="stylebrowser">
						<div class="panel panel-default">
							<div class="panel-heading" data-toggle="collapse" data-parent="#stylebrowser" data-target="#styleBrowserBody">
								<h4 class="panel-title">
								<a data-toggle="collapse" data-parent="#stylebrowser" href="#styleBrowserBody" > 
								</a>
								<a class="accordion-toggle"> <span class="pull-right slideupdowntoggle glyphicon glyphicon-chevron-up"></span>General Details</a>  
							</h4>
							</div>
							<c:if test="${mststylecomponentList !=null}">
								<div id="styleBrowserBody" class="panel-collapse collapse out" style="height: auto;">
									<div class="panel-body">
										<div class="col-sm-4 col-md-4 ">
											<div class="form-group formwithsearch marginbottom20">
												<div class="icon-addon addon-md">
													<spring:bind path="merprecostsheet.id.costsheetType">
													<div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
													</spring:bind>
														<appfuse:label key="merprecostsheet.costsheetType" styleClass="control-label"/>
														<select required="required"  type="text" name="id.costsheetType" id="costsheetType" class="form-control" onfocus="optionsforgencodes('costsheetType','COSTYP')" >
															<c:if test="${merprecostsheet.id.costsheetType ==null}">
																<c:forEach items="${mstparam}" var="mstparams">
																	<option selected="selected">${mstparams.locationCode}</option>
																</c:forEach>
															</c:if>
															<c:if test="${merprecostsheet.id.costsheetType !=null}">
																<option selected="selected">${merprecostsheet.id.costsheetType}</option>
															</c:if>
														</select>
														<form:errors path="id.costsheetType" cssClass="help-block"/>
													</div>
													
												</div>
											</div>  
											<div class="btn-group formsearchbtn btn-model-select-div">
												<button  onclick="$('#costsheetType').trigger('onfocus'); addmodalpopup('costsheetType')" type="button" class="btn btn-primary btn-xs dropdown-toggle " data-toggle="modal" data-target="#schmodalpopup" ><span class="glyphicon glyphicon-search"></span></button>
											</div>
											<div class="clearfix"></div> 
											<div class="form-group formwithsearch marginbottom20">
												<div class="icon-addon addon-md">
													<spring:bind path="merprecostsheet.id.versionNo">
													<div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
													</spring:bind>
														<appfuse:label key="merprecostsheet.id.versionNo" styleClass="control-label"/>
														<input onkeypress="return IsNumeric(event,this.id)" ondrop="return false;" onpaste="return false;" name="id.versionNo" id="versionNo" Class="form-control" value="${merprecostsheet.id.versionNo}" readonly="readonly"/>
														<span id="errorversionNo" style="color: Red; display: none">* Input digits (0 - 9)</span>
														<form:errors path="id.versionNo" cssClass="help-block"/>
													</div>
												</div>
											</div>  
											<div class="clearfix"></div> 				
											<div class="col-sm-12 col-md-12 col-xs-12 pull-left padding0 marginTop10">
												<spring:bind path="merprecostsheet.compWiseCost">
												<div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
												</spring:bind>
													<p class="pull-left marginRight15 paddingTop4">Component wise Costing: </p>
													<c:if test="${merprecostsheet.compWiseCost ==null}">
														<input  class="pull-left marginTop10 yesNocheckBox" id="compWiseCost" type="checkbox" name="compWiseCost" checked="" >
													</c:if>
													<c:if test="${merprecostsheet.compWiseCost =='false'}">
														<input  class="pull-left marginTop10 yesNocheckBox" id="compWiseCost" type="checkbox" readonly="readonly" name="compWiseCost"  >
													</c:if>
													<c:if test="${merprecostsheet.compWiseCost =='true'}">
														<input class="pull-left marginTop10 yesNocheckBox"  id="compWiseCost" type="checkbox" readonly="readonly" name="compWiseCost" checked="checked" >
													</c:if>
													<form:errors path="compWiseCost" cssClass="help-block"/>
												</div>
											</div>
										</div>
										<div class="col-sm-4 col-md-4 ">
											<div class="form-group formwithsearch marginbottom20">
												<div class="icon-addon addon-md">
													<spring:bind path="merprecostsheet.id.preCostSheetNo">
													<div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
													</spring:bind>
														<appfuse:label key="merprecostsheet.id.preCostSheetNo" styleClass="control-label"/>
														<input  name="id.preCostSheetNo" id="preCostSheetNo" Class="form-control" value="${merprecostsheet.id.preCostSheetNo}" readonly="readonly"/>
														<form:errors path="id.preCostSheetNo" cssClass="help-block"/>
													</div>
												</div>
											</div>  
											<div class="clearfix"></div> 
											<div class="form-group formwithsearch marginBottom20">
												<div class="icon-addon addon-md">
													<spring:bind path="merprecostsheet.createdOn">
													<div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
													</spring:bind>
														<appfuse:label key="Audit.createdOn" styleClass="control-label"/>
														<input Class="form-control" name="createdOn" id="createdOn" value="${merprecostsheet.createdOn}" readonly="readonly"/>
														<form:errors path="createdOn" cssClass="help-block"/>
													</div>
												</div>
											</div>  
											<div class="clearfix"></div> 
										</div>
										<div class="col-sm-4 col-md-4">
											<div class="form-group formwithsearch marginbottom20">
												<div class="icon-addon addon-md">
													<spring:bind path="merprecostsheet.merchandiser">
													<div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
													</spring:bind>
														<appfuse:label key="merprecostsheet.merchandiser" styleClass="control-label"/>
														<select required="required" Class="form-control" tabindex="12" id="merchandiser" name="merchandiser"  onfocus="getOptions('merchandiser','mstuser')">
															<option  selected="selected" >${merprecostsheet.merchandiser.userId}</option>
														</select>
														<form:errors path="merchandiser" cssClass="help-block"/>
													</div>
												</div>
											</div>  
											<div class="btn-group formsearchbtn btn-model-select-div">
												<button onclick="$('#merchandiser').trigger('onfocus'); addmodalpopup('merchandiser')" type="button" class="btn btn-primary btn-xs dropdown-toggle " data-toggle="modal" data-target="#schmodalpopup" ><span class="glyphicon glyphicon-search"></span></button>
											</div>
											<div class="clearfix"></div>
											<div class="form-group formwithsearch marginBottom20">
												<div class="icon-addon addon-md">
													<spring:bind path="merprecostsheet.orderQty">
													<div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
													</spring:bind>
														<appfuse:label key="merprecostsheet.orderQty" styleClass="control-label"/>
														<input onblur="ckkqty('b')" onfocus="ckkqty('f')" onkeypress="return IsNumeric(event,this.id)" ondrop="return false;" onpaste="return false;" required="required" Class="form-control" name="orderQty" value="${merprecostsheet.orderQty}" id="orderQty"  maxlength="10"/>
														<span id="errororderQty" style="color: Red; display: none">* Input digits (0 - 9)</span>
														<form:errors path="orderQty" cssClass="help-block"/>
													</div>
												</div>
											</div>  
										</div>
									</div> <!-- pannel body ends -->
								</div>
							</c:if>
						</div>
					</div> 
				</div> 
			</div>
			<div class="row paddingleft20">
				<div class="col-sm-12 col-md-12">
					<div class="panel-group" id="stylebrowsersmv">
						<div class="panel panel-default">
							<div class="panel-heading" data-toggle="collapse" data-parent="#stylebrowsersmv" data-target="#styleSMVBody">
								<h4 class="panel-title">
									<a data-toggle="collapse" data-parent="#stylebrowsersmv" href="#styleSMVBody"  > 
									<a class="accordion-toggle"> <span class="pull-right slideupdowntoggle glyphicon glyphicon-chevron-up"></span>SMV Details</a> </a> 
								</h4>
							</div>
							<c:if test="${mststylecomponentList !=null}">
								<div id="styleSMVBody" class="panel-collapse collapse">
									<div class="panel-body">
										<div class="row"> 
										</div>
										<div class="dataTables_wrapper scrollxonly">
											<section>
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
															<th class="textcenter">lineEfficiency</th>
															<th class="textcenter">fmvCategory</th>
															<th class="textcenter">fmv</th>
															<!-- <th>CM</th> -->
															<th class="textcenter">SMV</th>
														</tr>
													</thead>
													<tbody>
														<c:forEach items="${mststylecomponentList}" var="mststylecomponent">
															<tr id="tr${mststylecomponent.id.componentId}">
																<td class="textcenter"><div tabindex="15" class="icon-addon addon-md">${mststylecomponent.id.componentId}</div></td>
																<td class="textcenter"><div class="icon-addon addon-md">${mststylecomponent.productType}</div></td>
																<td class="textcenter">
																	<div class="icon-addon addon-md">
																		<input  required="required" onkeypress="return IsNumericdecimal(event,this.id)" ondrop="return false;" onpaste="return false;" type="text" id ="${mststylecomponent.id.componentId}_Ratio" class="form-control" value="${mststylecomponent.compRatio}"/>
																		<span id="error${mststylecomponent.id.componentId}_Ratio" style="color: Red; display: none">* Input digits (0 - 9)</span>
																	</div>
																</td>
																<td class="textcenter">
																	<div class="icon-addon addon-md">
																		<select required="required" type="text" id ="${mststylecomponent.id.componentId}_location" class="form-control" onfocus="getOptions('${mststylecomponent.id.componentId}_location','mstlocations')" onchange="createLinneff(this.options[this.selectedIndex].value,'${mststylecomponent.id.componentId}')"></select>
																	</div>
																</td>
																<td>
																	<div class="icon-addon addon-md">
																		<select required="required" type="text" id ="${mststylecomponent.id.componentId}_styleRouteName" onchange="createSMV(this.options[this.selectedIndex].value,'${mststylecomponent.id.componentId}')" class="form-control" onfocus="getStyleRouteName('${mststylecomponent.id.componentId}','${mststylecomponent.id.styleId}','${mststylecomponent.id.locationCode}','${mststylecomponent.id.depCode}','${mststylecomponent.id.compCode}','${mststylecomponent.id.custCode}')"></select>
																	</div>
																</td>
																<td class="textcenter">
																	<div class="icon-addon addon-md">
																		<input required="required" onkeypress="return IsNumericdecimal(event,this.id)" ondrop="return false;" onpaste="return false;" Class="form-control" name="lineEfficiency" id="${mststylecomponent.id.componentId}_lineEfficiency" value="" maxlength="255"/>
																	</div>
																</td>
																<td>
																	<div class="icon-addon addon-md">
																		<select required="required" Class="form-control" name="fmvCategory" onchange="changefmv(this.options[this.selectedIndex].value,'${mststylecomponent.id.componentId}')"  onfocus="getOptions('${mststylecomponent.id.componentId}_pfmvCategory','mstsmvrates')" id="${mststylecomponent.id.componentId}_pfmvCategory"  maxlength="10">
																			<option selected></option>
																		</select>
																	</div>
																</td>
																<td>
																	<div class="icon-addon addon-md">
																		<input readonly="readonly" Class="form-control"   name="fmv" id="${mststylecomponent.id.componentId}_fmv"  maxlength="255"/>
																	</div>
																</td>
																<%-- <td> <div class="icon-addon addon-md" id ="${mststylecomponent.id.componentId}_CM"></div> </td> --%>
																<td>
																	<div class="icon-addon addon-md" >
																		<input  Class="form-control"   name="smv" id="${mststylecomponent.id.componentId}_SMV"  maxlength="255"/>
																	</div>
																</td>																
															</tr>	
															<script type="text/javascript">
																componets[cmp++]= "${mststylecomponent.id.componentId}";
															</script>
														</c:forEach>
													</tbody>
												</table>
											</section>
										</div>
										<div class="row paddingleft20 marginTop30">
											<div class="form-horizontal" role="form">		
												<div class="form-group col-sm-3">
													<spring:bind path="merprecostsheet.totalSmv">
													<div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
													</spring:bind>
														<appfuse:label key="merprecostsheet.totalSmv" styleClass="col-sm-6 control-label"/>
														 <div class="col-sm-6">
															<input readonly="readonly" Class="form-control" name="totalSmv" id="totalSmv"  maxlength="255" />
															<form:errors path="totalSmv" cssClass="help-block"/>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div> <!-- pannel body ends -->
								</div>
							</c:if>
						</div>
					</div> 
				</div> 
			</div>			
			<div class="row paddingleft20">
				<div class="col-sm-12 col-md-12">
					<div class="panel-group" id="stylebrowser2">
						<div class="panel panel-default">
							<div class="panel-heading" data-toggle="collapse" data-parent="#addstyleroute" data-target="#addstyleroute">
								<h4 class="panel-title">
									<a data-toggle="collapse"   data-parent="#stylebrowser2" href="#addstyleroute"  > 
										<a class="accordion-toggle"> <span class="pull-right slideupdowntoggle glyphicon glyphicon-chevron-up"></span> Currency Details</a>
									</a> 
								</h4>
							</div>
							<c:if test="${mststylecomponentList !=null}">
								<div id="addstyleroute" class="panel-collapse collapse">
									<div class="panel-body">
										<c:forEach items="${mstparam}" var="mstparams">
											<script type="text/javascript">	
												var mstlocation="${mstparams.locationCode}";
												var currencyMethod="${mstparams.currencyMethod}";
											</script>	
											<c:if test="${mstparams.currencyMethod=='Dynamic'}">
												<div class=""> <!-- ADD SHOW HIDE CLASS HERE -->
													<div class="row paddingleft20">
														<div class="col-sm-5 col-md-5 ">
															<spring:bind path="merprecostsheet.mstcurrencyByCostSheetCurrency">
															<div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''} formwithsearch marginbottom20">
															</spring:bind>
																<%-- <appfuse:label key="merprecostsheet.mstcurrencyByCostSheetCurrency" styleClass="col-sm-6 control-label"/> --%>
																 <div class="icon-addon addon-md">
																	<label for="exampleInputEmail1">Cost Sheet Currency: </label>
																	<select required="required" Class="form-control" name="mstcurrencyByCostSheetCurrency.curCode" id="mstcurrencyByCostSheetCurrency"  maxlength="255" onfocus="getOptions('mstcurrencyByCostSheetCurrency','mstcurrency')">
																		<option selected="selected">${merprecostsheet.mstcurrencyByCostSheetCurrency.curCode}</option>
																	</select>
																	<form:errors path="mstcurrencyByCostSheetCurrency" cssClass="help-block"/>
																</div>
															</div>				
															<div class="clearfix"></div> 
															<spring:bind path="merprecostsheet.mstcurrencyByDftRmCurrency">
															<div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''} formwithsearch marginbottom20">
															</spring:bind>
																<%-- <appfuse:label key="merprecostsheet.mstcurrencyByDftRmCurrency" styleClass="col-sm-6 control-label"/> --%>
																 <div class="icon-addon addon-md">
																	<label for="exampleInputEmail1">Default RM Currenty: </label>
																	<select required="required" Class="form-control" name="mstcurrencyByDftRmCurrency.curCode" id="mstcurrencyByDftRmCurrency"  maxlength="255" onfocus="getOptions('mstcurrencyByDftRmCurrency','mstcurrency')">
																		<option selected="selected">${merprecostsheet.mstcurrencyByDftRmCurrency.curCode}</option>
																	</select>
																	<form:errors path="mstcurrencyByDftRmCurrency" cssClass="help-block"/>
																</div>
															</div>
															<div class="clearfix"></div> 											  
														</div>
														<div class="col-sm-4 col-md-4 ">
															<spring:bind path="merprecostsheet.costSheetExchangeRate">
															<div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''} formwithsearch marginbottom20">
															</spring:bind>
																<%-- <appfuse:label key="merprecostsheet.costSheetExchangeRate" styleClass="col-sm-6 control-label"/> (to convert to CS Currency) : --%>
																 <div class="icon-addon addon-md">
																 <label for="exampleInputEmail1">Exchange Rate </label>
																	<input required="required" value="${merprecostsheet.costSheetExchangeRate}" onkeypress="return IsNumericdecimal(event,this.id)" ondrop="return false;" onpaste="return false;" Class="form-control" name="costSheetExchangeRate" id="costSheetExchangeRate"  maxlength="255" />
																	<span id="errorcostSheetExchangeRate" style="color: Red; display: none">* Input digits (0 - 9)</span>
																	<form:errors path="costSheetExchangeRate" cssClass="help-block"/>
																</div>
															</div>
															<div class="clearfix"></div> 
															<spring:bind path="merprecostsheet.dftRmExchangeRate">
															<div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''} formwithsearch marginbottom20">
															</spring:bind>
																<%-- <appfuse:label key="merprecostsheet.dftRmExchangeRate" styleClass="col-sm-6 control-label"/> --%>
																 <div class="icon-addon addon-md">
																 <label for="exampleInputEmail1">Exchange Rate </label>
																	<input required="required" Class="form-control"onkeypress="return IsNumericdecimal(event,this.id)" ondrop="return false;" onpaste="return false;"  name="dftRmExchangeRate" value="${merprecostsheet.dftRmExchangeRate}" id="dftRmExchangeRate"  maxlength="255" />
																	<span id="errordftRmExchangeRate" style="color: Red; display: none">* Input digits (0 - 9)</span>
																	<form:errors path="dftRmExchangeRate" cssClass="help-block"/>
																</div>
															</div> 
															<div class="clearfix"></div> 										
														</div>
													</div>
												</div>
											</c:if>
											<c:if test="${mstparams.currencyMethod=='Static'}">
												<div > <!-- ADD SHOW HIDE CLASS HERE -->
													<div class="row paddingleft20">
														<div class="col-md-12"><h3 class="add-styl-rt">Other Exchange Rates against Cost Sheet Currency:</h3><hr></div>
													</div>
													<div class="row paddingleft20">												 
														<div class="col-sm-5 col-md-5 ">
															<spring:bind path="merprecostsheet.mstcurrencyByCostSheetCurrency">
															<div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''} formwithsearch marginbottom20">
															</spring:bind>
																<%-- <appfuse:label key="merprecostsheet.mstcurrencyByCostSheetCurrency" styleClass="col-sm-6 control-label"/> --%>
																 <div class="icon-addon addon-md">
																	<label for="exampleInputEmail1">Cost Sheet Currency: </label>
																	<select Class="form-control" name="mstcurrencyByCostSheetCurrency.curCode" id="mstcurrencyByCostSheetCurrency"  maxlength="255" onfocus="getOptions('mstcurrencyByCostSheetCurrency','mstcurrency')" >
																		<option selected="selected">${merprecostsheet.mstcurrencyByCostSheetCurrency.curCode}</option>
																	</select>
																	
																	<form:errors path="mstcurrencyByCostSheetCurrency" cssClass="help-block"/>
																</div>
															</div>  									
															<div class="clearfix"></div> 
															<spring:bind path="merprecostsheet.mstcurrencyByDftRmCurrency">
															<div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''} formwithsearch marginbottom20">
															</spring:bind>
																<%-- <appfuse:label key="merprecostsheet.mstcurrencyByDftRmCurrency" styleClass="col-sm-6 control-label"/> --%>
																 <div class="icon-addon addon-md">
																	<label for="exampleInputEmail1">Default RM Currency: </label>
																	<select Class="form-control" name="mstcurrencyByDftRmCurrency.curCode" id="mstcurrencyByDftRmCurrency"  maxlength="255"  onfocus="getOptions('mstcurrencyByDftRmCurrency','mstcurrency')">
																		<option selected="selected">${merprecostsheet.mstcurrencyByDftRmCurrency.curCode}</option>
																	</select>
																	
																	<form:errors path="mstcurrencyByDftRmCurrency" cssClass="help-block"/>
																</div>
															</div>  
															<div class="clearfix"></div> 
														</div>
														<div class="col-sm-4 col-md-4 ">
															<spring:bind path="merprecostsheet.costSheetExchangeRate">
															<div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''} formwithsearch marginbottom20">
															</spring:bind>
																<%-- <appfuse:label key="merprecostsheet.costSheetExchangeRate" styleClass="col-sm-6 control-label"/> --%>
																 <div class="icon-addon addon-md">
																 <label for="exampleInputEmail1">Exchange Rate (to convert to CS Currency) :</label>
																	<input Class="form-control" onkeypress="return IsNumericdecimal(event,this.id)" ondrop="return false;" onpaste="return false;" name="costSheetExchangeRate" id="costSheetExchangeRate"  value="${merprecostsheet.costSheetExchangeRate}" maxlength="255" />
																	<span id="errorcostSheetExchangeRate" style="color: Red; display: none">* Input digits (0 - 9)</span>
																	<form:errors path="costSheetExchangeRate" cssClass="help-block"/>
																</div>
															</div>
															<div class="clearfix"></div>
														</div>
														<div class="clearfix"></div>
														<div class="col-sm-6 col-md-6 ">
															<h3 class="h3-inside-pannel">Other Exchange Rates againts Cost Sheet Currency :</h3>
														</div>
			
													</div>
								
													<div class="col-sm-12 col-md-12">
														<div class="dataTables_wrapper">
															<section>
																<table id="route" class="display table table-striped table-bordered" cellspacing="0">
																	<thead>
																		<tr>
																			<th class="textcenter">Country Code</th>
																			<th class="textcenter">Rate (to convert to CS Currency)</th> 
																			<th class="textcenter">Actions</th>
																		</tr>
																	</thead>
																	<tbody id="currencytable">
																		<tr class="gradeX" id="editablecur">
																		</tr>
																	</tbody>
																</table>
															</section>
														</div>
													</div>
			
												</div> 
											</c:if>				
										</c:forEach>
										 <!-- ADD SHOW HIDE CLASS ENDS -->
										<!-- ADD SHOW HIDE CLASS DIV ENDS -->
										<div class="row paddingleft20">	 </div> <!-- panel body end  -->
									</div>
								</div>
							</c:if>
						</div>
					</div> 
				</div>
			</div>
			<div class="clearfix"></div> 
			<c:if test="${mststylecomponentList !=null}">
    <div class="row marginLeft30">
				<div class="col-sm-8 col-md-8 col-xs-8 marginTop30">
					<div class="aprovedby">
						<span class="glyphicon glyphicon-ok aprovedicon"></span> 
						<div class="aprovedbytitle">
						Created By: ${merprecostsheet.createdOn} <br>
						Created On: ${merprecostsheet.createdOn}
						</div>  
					</div>
					<div class="createdby">
						<span class="glyphicon glyphicon-edit createdicon"></span> 
						<div class="aprovedbytitle">
						Modified By: ${merprecostsheet.modifiedBy}<br>
						Modified On: ${merprecostsheet.modifiedBy} 
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
				<div id="submision" class="submit-button styl-rt-submission-btn pull-right marginRight0 marginTop30">
					<!-- <a><button type="button"  onclick="precostsheetnavigation('home')" class="btn btn-default btn-lg">Back</button></a> -->
					<button type="button" onclick="savecostsheet('COST1')" class="btn btn-info btn-lg btn-embossed">Next</button>
				</div>
            </div>
			</c:if>
		</form:form>	
	</div>
	<div class="tab-pane" id="profile"> <!-- Start of tab content 2 -->
		<form:errors path="*" cssClass="alert alert-danger alert-dismissable" element="div"/>
		<form:form commandName="merprecostsheet" method="post" action="merprecostsheetform" cssClass="well" id="merprecostsheetForm2" onsubmit="return validateMerprecostsheet(this)">
			<c:if test="${mststylecomponentList !=null}">
				<div class="row paddingleft20 marginBottom15">
					<div class="col-sm-12 col-md-12">
						<ul class="nav nav-pills nav-pills-jq ">
							<li class="active">
							<script type="text/javascript">
								var itemtypecatogery=new Array();
							</script>
							<c:forEach items="${mstitemtypeCatogory}" var="mstitemtypecatogory">
								<a onclick="navigterowMat('${mstitemtypecatogory}','')">${mstitemtypecatogory} <span class="badge" id="bage${mstitemtypecatogory}"></span></a></li><li>
								<script type="text/javascript">
									itemtypecatogery.push('${mstitemtypecatogory}');
								</script>
							</c:forEach>
							</li>
						</ul>
					</div>
				</div>
				<div class="row paddingleft20">
					<div class="col-sm-12 col-md-12">
						<div class="panel-group" id="rowMaterialScreen">
						<!--  dyanemic table-->
						</div> 
					</div> 
				</div>
				<div class="row paddingleft20">
					<div class="col-sm-12 col-md-12">
						<div class="panel-group" id="pannel2">
							<div class="panel panel-default">
								<div class="panel-heading" data-toggle="collapse" data-parent="#pannel2" data-target="#pannel2Body">
								  <h4 class="panel-title">
								  <a data-toggle="collapse"   data-parent="#pannel2" href="#pannel2Body"  > 
									 </a><a class="accordion-toggle"> <span class="pull-right slideupdowntoggle glyphicon glyphicon-chevron-up"></span>Add Raw Material Screen</a>  
								</h4>
								</div>
								<div id="pannel2Body" class="panel-collapse collapse in" style="height: auto;">
									<div class="panel-body">
										<div class="col-sm-4 col-md-4 ">
											<div class="form-group formwithsearch marginbottom20">
												<div class="icon-addon addon-md">
													<label for="exampleInputEmail1">Item Type</label>
													<select required="required" type="text" onblur ="inputenbler('ordersheet','itemType')" onchange="inputenbler('costsheet','itemType')" class="form-control" name="itemType" id="itemType"  onfocus="getOptions('itemType','mstitemtype')"></select>
													
												</div>
											</div>  
											<div class="btn-group formsearchbtn btn-model-select-div">
												<button onclick="$('#itemType').trigger('onfocus');addmodalpopup('itemType');" type="button" class="btn btn-primary btn-xs dropdown-toggle " data-toggle="modal" data-target="#schmodalpopup" ><span class="glyphicon glyphicon-search"></span></button>
											</div>
											<div class="clearfix"></div> 
										</div>
										<div class="col-sm-4 col-md-4 ">
											<div class="form-group formwithsearch marginbottom20">
												<div class="icon-addon addon-md">
													<label for="exampleInputEmail1">Item Code</label>
													<select onchange="getOptions('itemDescription','mstitem')" disabled type="text" class="form-control" id="itemCode"  name="itemCode" onfocus="getOptions('itemCode','mstitem')" ></select>
													
												</div>
											</div>  
											<div class="btn-group formsearchbtn btn-model-select-div">
												<button id="itemCodemodel" disabled="disabled" onclick="$('#itemCode').trigger('onfocus');addmodalpopup('itemCode');" type="button" class="btn btn-primary btn-xs dropdown-toggle " data-toggle="modal" data-target="#schmodalpopup" ><span class="glyphicon glyphicon-search"></span></button>
											</div>
											<div class="clearfix"></div> 
										</div>
										<div class="col-sm-4 col-md-4 ">
											<div class="form-group formwithsearch marginbottom20">
												<div class="icon-addon addon-md">
													<label for="exampleInputEmail1">Description </label>
													<input readonly="" type="text" class="form-control" id="itemDescription" name="itemDecription"> 
												</div>
											</div>  
											<div class="clearfix"></div> 
										</div>
										<div class="col-sm-4 col-md-4 ">
											<div class="form-group formwithsearch marginbottom20">
												<div class="icon-addon addon-md">
													<label for="exampleInputEmail1">Item Color </label>
													<select type="text" class="form-control" id="itemColor" name ="itemColor"onfocus="optionsforgencodes('itemColor','')"> </select>
													
												</div>
											</div>  
											<div class="btn-group formsearchbtn btn-model-select-div">
												<button onclick="$('#itemColor').trigger('onfocus');addmodalpopup('itemColor');" type="button" class="btn btn-primary btn-xs dropdown-toggle " data-toggle="modal" data-target="#schmodalpopup" ><span class="glyphicon glyphicon-search"></span></button>
											</div>
											<div class="clearfix"></div> 
										</div>
										<div class="col-sm-4 col-md-4 ">
											<div class="form-group formwithsearch marginbottom20">
												<div class="icon-addon addon-md">
													<label for="exampleInputEmail1">Item Width </label>
													<input type="text" onkeypress="return IsNumericSpecial(event,this.id)" ondrop="return false;" onpaste="return false;" class="form-control" name="itemWidth" id="itemWidth">
													<span id="erroritemWidth" style="color: Red; display: none">* Input digits (A-Z ,a-z ,0 - 9)</span>
												</div>
											</div>  
											<div>		 
											</div>
											<div class="clearfix"></div> 
										</div>
										<div class="col-sm-4 col-md-4 ">
											<div class="form-group formwithsearch marginbottom20">
												<div class="icon-addon addon-md">
													<label for="exampleInputEmail1">Imp / Local </label>
													<select required="required" type="text" class="form-control" id="shipingType" name="shipingType">
														<option>Import</option>
														<option>Local</option>
													</select>
													
												</div>
											</div>  
											<div class="clearfix"></div> 
										</div>
										<div class="col-sm-4 col-md-4 ">
											<div class="form-group formwithsearch marginbottom20">
												<div class="icon-addon addon-md">
													<label for="exampleInputEmail1">Supplier </label>
													<select type="text" class="form-control" id="supplierCode" name="supplierCode" onfocus="getOptions('supplierCode','mstsupplier')"></select>
													
												</div>
											</div>  
											<div class="btn-group formsearchbtn btn-model-select-div">
												<button onclick="$('#supplierCode').trigger('onfocus');addmodalpopup('supplierCode');" type="button" class="btn btn-primary btn-xs dropdown-toggle " data-toggle="modal" data-target="#schmodalpopup" ><span class="glyphicon glyphicon-search"></span></button>
											</div>
											<div class="clearfix"></div> 
										</div>
										<div class="col-sm-4 col-md-4 ">
											<div class="form-group formwithsearch marginbottom20">
												<div class="icon-addon addon-md">
													<label for="exampleInputEmail1">Currency </label>
													<select  required="required" type="text" class="form-control" id="currency" name="currency" onfocus="getOptions('currency','mstcurrency')"></select>
													
												</div>
											</div>  
											<div class="btn-group formsearchbtn btn-model-select-div">
												<button onclick="$('#currency').trigger('onfocus');addmodalpopup('currency');" type="button" class="btn btn-primary btn-xs dropdown-toggle " data-toggle="modal" data-target="#schmodalpopup" ><span class="glyphicon glyphicon-search"></span></button>
											</div>
											<div class="clearfix"></div> 
										</div>
										<div class="col-sm-4 col-md-4 ">
											<div class="form-group formwithsearch marginbottom20">
												<div class="icon-addon addon-md">
													<label for="exampleInputEmail1">Exchange Rate </label>
													<input required="required" onkeypress="return IsNumericdecimal(event,this.id)" ondrop="return false;" onpaste="return false;"  type="text" class="form-control" name="exchangeRate" id="exchangeRate">
													<span id="errorexchangeRate" style="color: Red; display: none">* Input digits (0 - 9)</span>
												</div>
											</div>  
											<div class="clearfix"></div> 
										</div>
										<div class="col-sm-4 col-md-4 ">
											<div class="form-group formwithsearch marginbottom20">
												<div class="icon-addon addon-md">
													<label for="exampleInputEmail1">Price </label>
													<input required="required" type="text" onkeypress="return IsNumericdecimal(event,this.id)" ondrop="return false;" onpaste="return false;" class="form-control" id="price" name="price">
													<span id="errorprice" style="color: Red; display: none">* Input digits (0 - 9)</span>
												</div>
											</div> 
											<div class="clearfix"></div> 
										</div>
										<div class="col-sm-4 col-md-4 ">
											<div class="form-group formwithsearch marginbottom20">
												<div class="icon-addon addon-md">
													<label for="exampleInputEmail1">Finance % </label>
													<input  onkeypress="return IsNumericdecimal(event,this.id)" value="0" ondrop="return false;" onpaste="return false;" type="text" class="form-control" id="finance" name="finance">
													<span id="errorfinance" style="color: Red; display: none">* Input digits (0 - 9)</span>
												</div>
											</div>  
											<div class="clearfix"></div> 
										</div>
										<div class="row paddingleft20">
											<div class="col-md-12"><h3 class="add-styl-rt">Consumption Details: </h3><hr></div>
										</div>
										
										<div  id="compvscostCon1">
											
										</div>
										<div class="clearfix"></div> 
										<div class="dataTables_wrapper margintop20" id="compvscostCon2">
											<section>
												<table id="route" class="display table table-striped table-bordered" cellspacing="0">
													<thead>
														<tr>
														  <th class="textcenter">Component</th>
														  <th class="textcenter">Consumption</th> 
														  <th class="textcenter">UOM</th>
														  <th class="textcenter">Allowance %</th>
														</tr>
													</thead>
													<tbody id="tbodyConsumption">
														<c:forEach items="${mststylecomponentList}" var="mststylecomponent">
															<tr class="gradeX" id="contr${mststylecomponent.id.componentId}">
																<td><div tabindex="15" class="icon-addon addon-md">${mststylecomponent.id.componentId}</div></td>
																<td>
																	<div class="icon-addon addon-md">
																		<input required="required" onkeypress="return IsNumeric(event,this.id)" ondrop="return false;" onpaste="return false;" required="required"  type="text" id ="${mststylecomponent.id.componentId}com_consumption" class="form-control" value=""/>
																		<span id="error${mststylecomponent.id.componentId}com_consumption" style="color: Red; display: none">* Input digits (0 - 9)</span>
																	</div>
																</td>
																<td>
																	<div class="icon-addon addon-md">
																		<select required="required" id ="${mststylecomponent.id.componentId}_UMO" class="form-control" onfocus="getUOM('${mststylecomponent.id.componentId}_UMO')"></select>					
																	</div>
																</td>
																<td>
																	<div class="icon-addon addon-md">
																		<input onkeypress="return IsNumericdecimal(event,this.id)" ondrop="return false;" onpaste="return false;"  required="required"  type="text" id ="${mststylecomponent.id.componentId}com_allowance" class="form-control" value=""/>
																		<span id="error${mststylecomponent.id.componentId}com_allowance" style="color: Red; display: none">* Input digits (0 - 9)</span>
																	</div>
																</td>																										
															</tr>	
														</c:forEach>
													</tbody>
												</table>
											</section>
										</div>								
										<div id="submision" class="submit-button styl-rt-submission-btn pull-right marginRight0 marginTop30">
											<a><button id="back3" type="button" onclick="clear_form_elements(this.form);" class="btn btn-default btn-lg">Clear All</button></a>
											<button  type="button" onclick="savecostsheet('COST2')" class="btn btn-info btn-lg btn-embossed submitBtn" id="rowsubmit">Submit</button>
											<button  type="button" style="display: none;" onclick="savecostsheet('COST22')" class="btn btn-info btn-lg btn-embossed submitBtn" id="rowUpdate">Update</button>
										</div>
									</div> <!-- pannel body ends -->
								</div>
							</div> 
						</div> 
					</div>
				</div>
				<div class="clearfix"></div>
    <div class="row marginLeft30">
				<div class="col-sm-8 col-md-8 col-xs-8">
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
						Modified By: ${merprecostsheet.modifiedBy}<br>
						Modified On: ${merprecostsheet.modifiedBy} 
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
				<div id="submision" class="submit-button styl-rt-submission-btn pull-right marginRight0">
					<a><button id="back3" type="button" onclick="precostsheetnavigation('home')" class="btn btn-default btn-lg">Back</button></a>
					<button type="button" onclick="precostsheetnavigation('Pricing')" class="btn btn-info btn-lg btn-embossed submitBtn">Next</button>
				</div>
           </div>
			</c:if>	
		</form:form>	
	</div>
	<div class="tab-pane" id="Pricing"><!-- THIS IS THE Start of the Wip-Points tab three-->
		<form:errors path="*" cssClass="alert alert-danger alert-dismissable" element="div"/>
		<form:form commandName="merprecostsheet" method="post" action="merprecostsheetform" cssClass="well" id="merprecostsheetForm3" onsubmit="return validateMerprecostsheet(this)">
			<c:if test="${mststylecomponentList !=null}">
				<div class="col-sm-12 col-md-12">
					<div class="panel-group" id="costDetailPannel3">
						<div class="panel panel-default">
							<div class="panel-heading" data-toggle="collapse"  data-parent="#costDetailPannel3" data-target="#costDetailPannel3Body"  >
								<h4 class="panel-title">
									<a data-toggle="collapse" data-parent="#costDetailPannel3" href="#costDetailPannel3Body"></a>
									<a class="accordion-toggle"> <span class="pull-right slideupdowntoggle glyphicon glyphicon-chevron-up"></span>Cost Details</a>  
								</h4>
							</div>
							<div id="costDetailPannel3Body" class="panel-collapse collapse out" style="height: auto;">
								<div class="panel-body">
									<div class="col-md-12"><h3 class="add-styl-rt">Cost Details</h3><hr>
									</div>
									<div class="col-sm-4 col-md-4 ">
										<spring:bind path="merprecostsheet.rowMaterialValue">
										<div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}  formwithsearch marginbottom20">
										</spring:bind>
											<div class="icon-addon addon-md">
												<appfuse:label key="merprecostsheet.rowMaterialValue" styleClass="control-label exampleInputEmail1"/>
												<input type="text" class="form-control"  id="raw_material_cost" name-="rowMaterialValue" readonly>
											</div>
											<form:errors path="rowMaterialValue" cssClass="help-block"/>
										</div> 
										<div class="clearfix"></div> 
									</div>
									<div class="col-sm-4 col-md-4 ">
										<spring:bind path="merprecostsheet.serviceValue">
										<div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''} formwithsearch marginbottom20">
										</spring:bind>
											<div class="icon-addon addon-md">
												<appfuse:label key="merprecostsheet.serviceValue" styleClass="control-label exampleInputEmail1"/>
												<input type="text" class="form-control" id="services_cost"    name="serviceValue" readonly>
											</div>
											<form:errors path="serviceValue" cssClass="help-block"/>
										</div>  
										<div class="clearfix"></div> 
									</div>
									<div class="col-sm-4 col-md-4 ">
									<spring:bind path="merprecostsheet.cm">
										<div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''} formwithsearch marginbottom20">
									</spring:bind>
											<div class="icon-addon addon-md">
												<appfuse:label key="merprecostsheet.cm" styleClass="control-label exampleInputEmail1"/>
												<input type="text" class="form-control" id="CM" name="cm" readonly>
											</div>
											<form:errors path="cm" cssClass="help-block"/>
										</div>  
										<div class="clearfix"></div> 
									</div>
			
									<div class="col-sm-4 col-md-4 ">								
									<spring:bind path="merprecostsheet.cmt">
										<div class="formwithsearch marginbottom20 form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
									</spring:bind>
											<div class="icon-addon addon-md">
												<label for="exampleInputEmail1">CMT</label>
												<input type="text" class="form-control"  id="CMT" name="cmt" readonly>
											</div>
											<form:errors path="cmt" cssClass="help-block"/>
										</div>  
										<div class="clearfix"></div> 
									</div>
									<div class="col-sm-4 col-md-4 ">								
										<spring:bind path="merprecostsheet.financeCost">
										<div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''} formwithsearch marginbottom20">
										</spring:bind>
											<div class="icon-addon addon-md">
												<appfuse:label key="merprecostsheet.financeCost" styleClass="control-label exampleInputEmail1"/>
												<input type="text" class="form-control" id="finance_cost" name="financeCost" readonly>
											</div>
											<form:errors path="financeCost" cssClass="help-block"/>
										</div>  
										<div class="clearfix"></div> 
									</div>
									<div class="col-sm-4 col-md-4 ">
									<spring:bind path="merprecostsheet.totalCost">
										<div class="formwithsearch marginbottom20 form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
									</spring:bind>
											<div class="icon-addon addon-md">
												<appfuse:label key="merprecostsheet.totalCost" styleClass="control-label exampleInputEmail1"/>
												<input type="text" class="form-control extraBorder" name="totalCost" id="total_cost" readonly>
											</div>
											<form:errors path="totalCost" cssClass="help-block"/>
										</div>  
										<div class="clearfix"></div> 
									</div>
									<div class="col-md-12"><h3 class="add-styl-rt">Pricing</h3><hr>
									</div>
									<div class="col-sm-4 col-md-4 "> 
									<spring:bind path="merprecostsheet.markupAmount">
										<div class="formwithsearch marginbottom20 form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
									</spring:bind>
											<div class="icon-addon addon-md">
												<appfuse:label key="merprecostsheet.markupAmount" styleClass="control-label exampleInputEmail1"/>
												<div class="col-sm-8 col-md-8 padding0"> 
													<input onkeypress="return IsNumericdecimal(event,this.id)" ondrop="return false;" onpaste="return false;"  type="text" id="markupV" name="markupAmount" value="${merprecostsheet.markupAmount}" onblur="refigercost('markupV')" class="form-control"/>
													<span id="errormarkupV" style="color: Red; display: none">* Input digits (0 - 9)</span>
												</div>
												<div class="col-sm-4 col-md-4 paddingleft10"> 
													<input onkeypress="return IsNumericdecimal(event,this.id)" ondrop="return false;" onpaste="return false;" type="text"  class="form-control" id="markupP" onblur="refigercost('markupP')"  placeholder="%" style="direction: ltr; text-align: center; padding-right: 10px;"/>
													<span id="errormarkupP" style="color: Red; display: none">* Input digits (0 - 9)</span>
												</div>
												<form:errors path="markupAmount" cssClass="help-block"/>
											</div>
										</div>  
										<div class="clearfix"></div> 
									</div>
									<div class="col-sm-4 col-md-4 ">
									<spring:bind path="merprecostsheet.buyerCommission">
										<div class="formwithsearch marginbottom20 formwithsearch marginbottom20 form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
									</spring:bind>
											<div class="icon-addon addon-md">
												<appfuse:label key="merprecostsheet.buyerCommission" styleClass="control-label exampleInputEmail1"/>
												<div class="col-sm-8 col-md-8 padding0"> 
													<input onkeypress="return IsNumericdecimal(event,this.id)" ondrop="return false;" onpaste="return false;" type="text" name="buyerCommission" value="${merprecostsheet.buyerCommission}" class="form-control" onblur="refigercost('buyer_commissionV')" id="buyer_commissionV" ></div>
													<span id="errorbuyer_commissionV" style="color: Red; display: none">* Input digits (0 - 9)</span>
												<div class="col-sm-4 col-md-4 paddingleft10"> 
													<input onkeypress="return IsNumericdecimal(event,this.id)" ondrop="return false;" onpaste="return false;" type="text" class="form-control" onblur="refigercost('buyer_commissionP')" id="buyer_commissionP" placeholder="%" style="direction: ltr; text-align: center; padding-right: 10px;">
													<span id="errorbuyer_commissionP" style="color: Red; display: none">* Input digits (0 - 9)</span>
												</div>
												<form:errors path="buyerCommission" cssClass="help-block"/>
											</div>
										</div>  
										<div class="clearfix"></div> 
									</div>
									<div class="col-sm-4 col-md-4 ">
									<spring:bind path="merprecostsheet.ourPrice">
									<div class="formwithsearch marginbottom20 form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
									</spring:bind>
										<div class="icon-addon addon-md">
											<appfuse:label key="merprecostsheet.ourPrice" styleClass="control-label exampleInputEmail1"/>
											<input onkeypress="return IsNumericdecimal(event,this.id)" ondrop="return false;" onpaste="return false;" type="text" class="form-control" name="ourPrice" value="${merprecostsheet.ourPrice}" id="our_price" readonly>
											<span id="errorour_price" style="color: Red; display: none">* Input digits (0 - 9)</span>
										</div>
										<form:errors path="ourPrice" cssClass="help-block"/>
									</div>  
										<div class="clearfix"></div> 
									</div>
									<div class="col-sm-4 col-md-4 ">
									<spring:bind path="merprecostsheet.externalCommission">
										<div class="formwithsearch marginbottom20 form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
									</spring:bind>
											<div class="icon-addon addon-md">
												<appfuse:label key="merprecostsheet.externalCommission" styleClass="control-label exampleInputEmail1"/>
												<div class="col-sm-8 col-md-8 padding0"> 
													<input onkeypress="return IsNumericdecimal(event,this.id)" ondrop="return false;" onpaste="return false;" type="text"  value="${merprecostsheet.externalCommission}" class="form-control" onblur="refigercost('external_commissionV')" id="external_commissionV" name="externalCommission"></div>
												<span id="errorexternal_commissionV" style="color: Red; display: none">* Input digits (0 - 9)</span>
												<div class="col-sm-4 col-md-4 paddingleft10"> 
													<input onkeypress="return IsNumericdecimal(event,this.id)" ondrop="return false;" onpaste="return false;" type="text" class="form-control" onblur="refigercost('external_commissionP')" id="external_commissionP"  placeholder="%" style="direction: ltr; text-align: center; padding-right: 10px;">
												<span id="errorexternal_commissionP" style="color: Red; display: none">* Input digits (0 - 9)</span>
												</div>
											</div>
											<form:errors path="externalCommission" cssClass="help-block"/>								
										</div>  
										<div class="clearfix"></div> 
									</div>
									<div class="col-sm-4 col-md-4 ">
									<spring:bind path="merprecostsheet.sellingPrice">
										<div class="formwithsearch marginbottom20 form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
									</spring:bind>
											<div class="icon-addon addon-md">
												<appfuse:label key="merprecostsheet.sellingPrice" styleClass="control-label exampleInputEmail1"/>
												<input  onkeypress="return IsNumericdecimal(event,this.id)" ondrop="return false;" onpaste="return false;"type="text" class="form-control extraBorder" value="${merprecostsheet.sellingPrice}" id="selling_price" name="sellingPrice" onblur="refigercost('selling_price')">
												<span id="errorselling_price" style="color: Red; display: none">* Input digits (0 - 9)</span>
											</div>
										</div>
										<form:errors path="sellingPrice" cssClass="help-block"/>	  
										<div class="clearfix"></div> 
									</div>
								</div> <!-- pannel body ends -->
							</div>
						</div>
					</div> 
				</div> 
				<div class="col-sm-12 col-md-12 margintop20">
					<div class="panel-group" id="stylebrowser2">
						<div class="panel panel-default">
							<div class="panel-heading" data-toggle="collapse"   data-parent="#otherCostingPannel" data-target="#otherCostingPannel"  >
								<h4 class="panel-title">
									<a data-toggle="collapse" data-parent="#stylebrowser2" href="#otherCostingPannel"> </a>
									<a class="accordion-toggle"> <span class="pull-right slideupdowntoggle glyphicon glyphicon-chevron-up"></span> Other Costing Details</a>
								</h4>
							</div>
							<div id="otherCostingPannel" class="panel-collapse collapse out" style="height: auto;">
								<div class="panel-body">
									<div class="row paddingleft20">
										<div class="col-sm-4 col-md-4 ">
										<spring:bind path="merprecostsheet.baseBody">
											<div class="formwithsearch marginbottom20 form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
										</spring:bind>
												<div class="icon-addon addon-md">
													<appfuse:label key="merprecostsheet.baseBody" styleClass="control-label exampleInputEmail1"/>
													<select required="required" type="text" name="baseBody" id="baseBody" onfocus="optionsforgencodes('baseBody','BASBOD')" class="form-control" >
														<option selected="selected">${merprecostsheet.baseBody}</option>
													</select>
												</div>
												<form:errors path="baseBody" cssClass="help-block"/>
											</div>  
											<div class="btn-group formsearchbtn btn-model-select-div">
												<button onclick="$('#baseBody').trigger('onfocus'); addmodalpopup('baseBody')" type="button" class="btn btn-primary btn-xs dropdown-toggle " data-toggle="modal" data-target="#schmodalpopup" ><span class="glyphicon glyphicon-search"></span></button>
											</div>
											<div class="clearfix"></div> 
										</div>
										<div class="col-sm-4 col-md-4 ">
										<spring:bind path="merprecostsheet.buyerReference">
											<div class="formwithsearch marginbottom20 form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
										</spring:bind>
												<div class="icon-addon addon-md">
													<appfuse:label key="merprecostsheet.buyerReference" styleClass="control-label exampleInputEmail1"/>
													<input type="text"  name="buyerReference" value="${merprecostsheet.buyerReference}" id="buyerReference" class="form-control">								
												</div>
												<form:errors path="buyerReference" cssClass="help-block"/>
											</div>  
											<div class="clearfix"></div> 
										</div>
									</div>
    <div class="col-md-12"><h3 class="add-styl-rt">Add Shell Fabric</h3><hr>
    </div>
									<div class=" paddingleft20 marginBottom10">
										<div class="form-group col-sm-5 pull-right">
											<label class="col-sm-4 control-label textAlignRight">Add Shell Fabric</label>
											<div class="col-sm-6 padding0">
												<select required="required" type="text" name="shellfabric" id="shellfabric" onfocus="getsheelfab('shellfabric')" class="form-control" >
												</select>
												<span class="caret dropdowncaret marginRight0"></span>
											</div>
											<!--In original UI this search option is not avalable-->
											
											<!--<div class="btn-group formsearchbtn btn-model-select-div">
												<button onclick="$('#shellfabric').trigger('onfocus'); addmodalpopup('shellfabric')" type="button" class="btn btn-primary btn-xs dropdown-toggle " data-toggle="modal" data-target="#schmodalpopup" ><span class="glyphicon glyphicon-search"></span></button>
											</div>-->
											<div class="col-sm-2 col-md-2 padding0 ">
												<button type="button" onclick="addshellfab()" class="btn btn-warning btn-xs formsearchbtn warningBtn-bg margin0 paddingRight9 pull-right"><span class="glyphicon glyphicon-plus"></span>
												</button>
											</div>
										</div>
										<div class="clearfix"></div>
									</div>
									<div class="col-sm-12 col-md-12">
										<div class="dataTables_wrapper">
											<section>
												<table id="route" class="display table table-striped table-bordered" cellspacing="0">
													<thead>
														<tr>
															<th class="textcenter">Item Code</th>
															<th class="textcenter">Item Description</th> 
															<th class="textcenter">Color</th>
															<th class="textcenter">Width</th>
															<th class="textcenter">Actions</th>
														</tr>
													</thead>
													<tbody id="shellFabbody">
														
													</tbody>
												</table>
											</section>
										</div>
									</div>
									<div class="col-md-12 margintop20"><h3 class="add-styl-rt">Delivery Details</h3><hr>
									</div>
									<div class="col-sm-4 col-md-4 ">
									<spring:bind path="merprecostsheet.destinationCountry">
										<div class="formwithsearch marginbottom20 form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
									</spring:bind>
											<div class="icon-addon addon-md">
												<appfuse:label key="merprecostsheet.destinationCountry" styleClass="control-label exampleInputEmail1"/>
												<select type="text" id="destination_country" name="destinationCountry"  class="form-control" onfocus="optionsforgencodes('destination_country','CONTRY')">
												<option selected="selected">${merprecostsheet.destinationCountry}</option>	
												</select>
											</div>
											<form:errors path="destinationCountry" cssClass="help-block"/>
										</div>  
										<div class="btn-group formsearchbtn btn-model-select-div">
											<button onclick="$('#destination_country').trigger('onfocus'); addmodalpopup('destination_country')" type="button" class="btn btn-primary btn-xs dropdown-toggle " data-toggle="modal" data-target="#schmodalpopup" ><span class="glyphicon glyphicon-search"></span></button>
										</div>
										<div class="clearfix"></div> 
									</div>
									<div class="col-sm-4 col-md-4 ">
										<spring:bind path="merprecostsheet.shipmentMode">
											<div class="formwithsearch marginbottom20 form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
										</spring:bind>
											<div class="icon-addon addon-md">
												<appfuse:label key="merprecostsheet.shipmentMode" styleClass="control-label exampleInputEmail1"/>
												<select type="text" id="shipment_mode" name="shipmentMode" class="form-control" onfocus="optionsforgencodes('shipment_mode','SHPMOD')">
													<option selected="selected">${merprecostsheet.shipmentMode}</option>
												</select>
											</div>
											<form:errors path="shipmentMode" cssClass="help-block"/>
										</div>  
										<div class="btn-group formsearchbtn btn-model-select-div">
											<button onclick="$('#shipment_mode').trigger('onfocus'); addmodalpopup('shipment_mode')" type="button" class="btn btn-primary btn-xs dropdown-toggle " data-toggle="modal" data-target="#schmodalpopup" ><span class="glyphicon glyphicon-search"></span></button>
										</div>
										<div class="clearfix"></div> 
									</div>
									<div class="col-sm-4 col-md-4 ">
									<spring:bind path="merprecostsheet.deliveryTerm">
										<div class="formwithsearch marginbottom20 form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
									</spring:bind>
											<div class="icon-addon addon-md">
												<appfuse:label key="merprecostsheet.deliveryTerm" styleClass="control-label exampleInputEmail1"/>
												<select type="text"id="delivery_team" name="deliveryTerm" class="form-control" onfocus="optionsforgencodes('delivery_team','DELTER')">
													<option selected="selected">${merprecostsheet.deliveryTerm}</option>
												</select>	
											</div>
											<form:errors path="deliveryTerm" cssClass="help-block"/>
										</div>  
										<div class="btn-group formsearchbtn btn-model-select-div">
											<button onclick="$('#delivery_team').trigger('onfocus'); addmodalpopup('delivery_team')" type="button" class="btn btn-primary btn-xs dropdown-toggle " data-toggle="modal" data-target="#schmodalpopup" ><span class="glyphicon glyphicon-search"></span></button>
										</div>
										<div class="clearfix"></div> 
									</div>
									<div class="col-md-12 "><h3 class="add-styl-rt">Validity Period</h3><hr>
									</div>
									<div class="col-sm-4 col-md-4 ">
									 <spring:bind path="merprecostsheet.validTill"> 
										<div class="formwithsearch marginbottom20 form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
									 </spring:bind> 
											<div class="icon-addon addon-md">
												<appfuse:label key="merprecostsheet.validTill" styleClass="control-label exampleInputEmail1"/>
												<input type="text"  size="11" value="" format="mm/dd/yyyy" datepicker="true" tabindex="21" title="date" class="form-control targetDate" name="validTill" id="valid_till">
												<span class="glyphicon glyphicon-calendar dropdowncaret"></span>
											</div>
											<form:errors path="validTill" cssClass="help-block"/>								
										</div>  
										<div class="clearfix"></div> 
									</div>
									<div class="col-sm-4 col-md-4 ">
									<spring:bind path="merprecostsheet.remarks">
										<div class="formwithsearch marginbottom20 form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
									</spring:bind>
											<div class="icon-addon addon-md">
												<appfuse:label key="merprecostsheet.remarks" styleClass="control-label exampleInputEmail1"/>
												<textarea class="form-control" rows="3" name="remarks" value="${merprecostsheet.remarks}" >${merprecostsheet.remarks}</textarea>
											</div>
											<form:errors path="remarks" cssClass="help-block"/>	
										</div> 
										<div class="clearfix"></div> 
									</div>
								</div> <!-- panel body end  -->
							</div>
						</div>
					</div> <!-- pannel group ends -->
				</div> <!-- pannel group container col-md-12 div ends -->

				<div class="clearfix"></div>
             <div class="row">
				<div class="col-sm-8 col-md-8 col-xs-8 marginBottom20">
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
						Modified By: ${merprecostsheet.modifiedBy}<br>
						Modified On: ${merprecostsheet.modifiedBy} 
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
				<div id="submision" class="submit-button styl-rt-submission-btn pull-right marginRight0 marginBottom20">
					<a><button id="back3" class="btn btn-default btn-lg" onclick="precostsheetnavigation('profile')">Back</button></a>
					<button type="button"  onclick="savecostsheet('COST3')" class="btn btn-info btn-lg btn-embossed">Save</button>
				</div>
            </div>
			</c:if>
		</form:form>	
	</div>
	
	
	<div class="col-sm-8 col-md-8 col-xs-8" id="errors">
		<div class="alert alert-danger d-alert" role="alert">
			<button type="button" class="close" data-dismiss="alert" aria-hidden="true">�</button>
			<span class="error_heading">Error! </span> Change a few things up and try submitting again.
		</div>	  
	</div>
	<div id="popover_content_wrapper" style="display: none">
		
	</div>
</div>

<script>
	$('#errors').hide();
	$(document).ready(function() {
	
		<c:if test="${mststylecomponentList !=null}">
			<c:if test="${param.edit=='editmode'}">
				isedit=true;
				formdatatemp = jQuery("#merprecostsheetForm").serialize()+"&"+jQuery("#merprecostsheetForm3").serialize(); 
				formdatatemp2 = jQuery("#merprecostsheetForm2").serialize(); 	
			</c:if>	
			if(currencyMethod=="Static"){
				
				<c:forEach items="${merprecostsheetcurrencyList}" var="merprecostsheetcurrency">
					var curcode="${merprecostsheetcurrency.id.currencyCode}";
					var currate="${merprecostsheetcurrency.exchangeRate}";
					creartcurtable(curcode,currate)
				</c:forEach>	
				addcurrencytable();
			}
			<c:forEach items="${merprecostsheetsmvList}" var="merprecostsheetsmv">	
				var styleRouteId="${merprecostsheetsmv.id.styleRouteId}";
				var styleRouteName="${merprecostsheetsmv.styleRouteId.styleRouteName}";
				var ratio="${merprecostsheetsmv.ratio}";
				var routeLocation="${merprecostsheetsmv.routeLocation}";
				var lineEfficency="${merprecostsheetsmv.lineEfficency}";
				var fmvCategory="${merprecostsheetsmv.fmvCategory}";
				var fmv="${merprecostsheetsmv.fmv}";
				var smv="${merprecostsheetsmv.styleRouteId.totalSMV}";
					//console.log("${merprecostsheetsmv}");
				addsmv(styleRouteId,ratio,routeLocation,styleRouteName,lineEfficency,fmvCategory,fmv,smv); 
			</c:forEach>
			<c:forEach items="${rowmaterials}" var="shellfab">
				selectshellfabric('${shellfab.id.preCostSheetNo}','${shellfab.id.versionNo}','${shellfab.id.costsheetType}','${shellfab.id.precostsheetRowMatCode}','${shellfab.id.component}','${shellfab.mstitem.id.itemCode}');
				addshellfab();
			</c:forEach>
			$("input[type='text']:visible:enabled:first", document.forms['merprecostsheetForm']).focus();
			
			var isedit=false;
			<c:if test="${mststylecomponentList !=null}">
			
				if(document.getElementById("compWiseCost").checked){
					 $("#compvscostCon1").hide();
					 $("#compvscostCon2").show();
				 }
				 else{
					 $("#compvscostCon2").hide();
					 $("#compvscostCon1").show();
					 addcomvscost1("compvscostCon1");
		
				 }
			 </c:if>
			 <c:if test="${param.section=='COST1'}">
				for(var i=itemtypecatogery.length-1;i>-1;i--){
					 navigterowMat(itemtypecatogery[i]);
					 console.log(itemtypecatogery[i]);
				}
				 selecteditemcategory=itemtypecatogery[0];
				 precostsheetnavigation("profile");
				 document.getElementById('nprofile').className="active";
			</c:if>
			<c:if test="${merprecostsheet.createdOn==null}">
				var day=new Date();
				document.getElementById("createdOn").value=(day.getMonth()+1)+"/"+day.getDate() +"/"+day.getFullYear();
			</c:if>
			<c:if test="${merprecostsheet.createdOn!=null}">
				var d="${merprecostsheet.createdOn}";
				var str = d.split(" ");
				str = str[0].split("-");
				document.getElementById("createdOn").value=str[1]+"/"+str[2]+"/"+str[0];
			</c:if>
			<c:if test="${merprecostsheet.validTill!=null}">
				var d="${merprecostsheet.validTill}";
				var str = d.split(" ");
				str = str[0].split("-");
				document.getElementById("valid_till").value=str[1]+"/"+str[2]+"/"+str[0];
			</c:if>
			<c:if test="${validTill!=null}">
				var d="${validTill}";
				document.getElementById("valid_till").value=d;
			</c:if>
			<c:if test="${param.section=='COST2'}">
			for(var i=itemtypecatogery.length-1;i>-1;i--){
					 navigterowMat(itemtypecatogery[i]);
					 console.log(itemtypecatogery[i]);
				}
				 selecteditemcategory=itemtypecatogery[0];
				 precostsheetnavigation("Pricing");
				 document.getElementById('Pricing').className="active";
			</c:if>
			<c:if test="${param.OpenAs=='true'}">
				document.getElementById("preCostSheetNo").value=""
			</c:if>
		</c:if>
		
			
			
			
	});
</script>

<v:javascript formName="merprecostsheet" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<c:url value='/scripts/validator.jsp'/>"></script>
<script>
var isstyleselect="${NO}";
	$('#nav-dropdown .dropdown-menu').on({
	    "click":function(e){
	      e.stopPropagation();
	    }
	 });
</script>  
<script src="scripts/applicationjs/merprecostsheets.js"></script>
