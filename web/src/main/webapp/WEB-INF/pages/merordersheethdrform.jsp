<%@ include file="/common/taglibs.jsp"%>
<script src="scripts/applicationjs/merordersheethdr.js"></script>

<head>
    <title><fmt:message key="merordersheethdrDetail.title"/></title>
    <meta name="heading" content="<fmt:message key='merordersheethdrDetail.heading'/>"/>
</head>
 <script src="scripts/applicationjs/ordersheet.js"></script>
<c:set var="delObject" scope="request"><fmt:message key="merordersheethdrList.merordersheethdr"/></c:set>
<script type="text/javascript">var msgDelConfirm =
   "<fmt:message key="delete.confirm"><fmt:param value="${delObject}"/></fmt:message>";
</script>

<div class="row form-group paddingleft20"> <!-- NAVIGATION PILLS -->
	<div class="col-xs-8"><h2>Order Sheet-Planing Order</h2></div>   
</div>  <!-- NAVIGATION PILLS END-->

<!--  <div class="tab-content"> --> <!-- TAB CONTENT MAIN -->
	<div class="tab-pane active" id="home">
       <form  method="get" action="merordersheethdrform" class="" id="merordersheethdrsfrm" >
			<div class="row paddingleft20">	
				
				<c:if test="${mststyleheader.id.styleId == null}">
					<c:set var="disabled" scope="session" value=""/>
					<c:if test="${merordersheethdr.buyer == null}">
						<c:if test="${pram.buyer != null}">
							<c:set var="disabled2" scope="session" value="readonly"/>
							<c:set var="disabled9" scope="session" value="disabled"/>
						</c:if>
						<c:if test="${pram.buyer == null}">
							<c:set var="disabled2" scope="session" value=""/>
							<c:set var="disabled9" scope="session" value=""/>
						</c:if>
					</c:if>
					<c:if test="${merordersheethdr.buyer != null}">
						<c:set var="disabled2" scope="session" value="readonly"/>
						<c:set var="disabled9" scope="session" value="disabled"/>
					</c:if>
				</c:if>
				<c:if test="${mststyleheader.id.styleId != null}">
					<c:set var="disabled" scope="session" value="readonly"/>
					<c:set var="disabled2" scope="session" value="readonly"/>
					<c:set var="disabled9" scope="session" value="disabled"/>
				</c:if>	
				
				<c:if test="${merordersheethdr.season == null}">
					<c:set var="disabled3" scope="session" value=""/>
					<c:set var="disabled9" scope="session" value=""/>
				</c:if>
				<c:if test="${merordersheethdr.season != null}">
					<c:if test="${merordersheethdr.season == ''}">
						<c:set var="disabled3" scope="session" value=""/>
						<c:set var="disabled9" scope="session" value=""/>
					</c:if>
					<c:if test="${merordersheethdr.season != ''}">
						<c:set var="disabled3" scope="session" value="readonly"/>
						<c:set var="disabled9" scope="session" value=""/>
					</c:if>
				</c:if>
				
				<c:if test="${param.view != null}">
					<c:set var="disabled3" scope="session" value="disabled"/>
					<c:set var="disabled" scope="session" value="disabled"/>
					<c:set var="disabled2" scope="session" value="disabled"/>
					<c:set var="disabled1" scope="session" value="disabled"/>
					<c:set var="disabled9" scope="session" value="disabled"/>
				</c:if>
				${merordersheethdr}
				<div class="col-sm-4 col-md-4 ">
					<div class="form-group formwithsearch marginbottom20">
						<div class="icon-addon addon-md">
							<label for="exampleInputEmail1">Buyer </label>
							<c:if test="${merordersheethdr.buyer !=null}">
								<input  readonly required="required"  class="form-control"  type="text" name="custCode" id="id_custCode" value="${mststyleheader.id.custCode}"/>
							</c:if>						
							<c:if test="${merordersheethdr.buyer == null}">
								<c:if test="${mststyleheader.id.custCode !=null}">
									<input  readonly required="required" class="form-control"  type="text" name="custCode" id="id_custCode" value="${mststyleheader.id.custCode}"/>
								</c:if>						
								<c:if test="${mststyleheader.id.custCode ==null}">
									<c:if test="${param.custCode !=null}">
										<input  readonly required="required" class="form-control"  type="text" name="custCode" id="id_custCode" value="${param.custCode}"/>
									</c:if>	
									<c:if test="${param.custCode ==null}">
										<select  ${disabled2} required="required" class="form-control"  type="text" name="custCode" id="id_custCode" onfocus="getOptions('id_custCode','mstcustomer')" >
											<option selected="selected"></option>
										</select>
									</c:if>	
								</c:if>	
							</c:if>
							
							
						</div>
					</div>  
					<div class="btn-group formsearchbtn btn-model-select-div">
						<button ${disabled9} onclick="$('#id_custCode').trigger('onfocus'); addmodalpopup('id_custCode')" type="button" class="btn btn-primary btn-xs dropdown-toggle " data-toggle="modal" data-target="#schmodalpopup" ><span class="glyphicon glyphicon-search"></span></button>
					</div>
					<div class="clearfix"></div> 
					<div class="form-group formwithsearch marginbottom20">
						<div class="icon-addon addon-md">
							<label for="exampleInputEmail1">Style Location</label>
							<c:if test="${mststyleheader.id.locationCode !=null}">
								<input ${disabled} required="required" type="text" name="locationCode" id="id_locationCode" value="${mststyleheader.id.locationCode}" class="form-control" />
							</c:if>
							<c:if test="${mststyleheader.id.locationCode == null}">
								<select  ${disabled} type="text" name="locationCode" id="id_locationCode" class="form-control" onfocus="getOptions('id_locationCode','mstlocations')"> 						
									<c:forEach items="${mstparam}" var="mstparams">	
										<option  selected="selected">${mstparams.locationCode}</option>
									</c:forEach>
								</select>
							</c:if>
							
						</div>
					</div>  
					<div class="btn-group formsearchbtn btn-model-select-div">
						<button  ${disabled9} onclick="$('#id_locationCode').trigger('onfocus'); addmodalpopup('id_locationCode')" type="button" class="btn btn-primary btn-xs dropdown-toggle " data-toggle="modal" data-target="#schmodalpopup" ><span class="glyphicon glyphicon-search"></span></button>
					</div>
					<div class="clearfix"></div> 
				</div>
		
				<div class="col-sm-4 col-md-4 ">
					<div class="form-group formwithsearch marginbottom20">
						<div class="icon-addon addon-md">
							<label for="exampleInputEmail1">Buyer Department</label>
							<c:if test="${mststyleheader.id.depCode !=null}">
								<input  ${disabled}  required="required" class="form-control" type="text" name="depCode" id="id_depCode" value="${mststyleheader.id.depCode}"/>
							</c:if>						
							<c:if test="${mststyleheader.id.depCode ==null}">
								<select ${disabled}  type="text" name="depCode" id="id_depCode" onfocus="optionsforgencodes('id_depCode','BUYDEM')" class="form-control" >
									<option selected="selected">${param.depCode}</option>
								</select>
							</c:if>
						
							
						</div>
					</div>  
					<div class="btn-group formsearchbtn btn-model-select-div">
						<button ${disabled9}  onclick="$('#id_depCode').trigger('onfocus'); addmodalpopup('id_depCode')" type="button" class="btn btn-primary btn-xs dropdown-toggle " data-toggle="modal" data-target="#schmodalpopup" ><span class="glyphicon glyphicon-search"></span></button>
					</div>
					<div class="clearfix"></div> 

					<div class="form-group formwithsearch marginBottom20">
						<div class="icon-addon addon-md">
							<label for="exampleInputEmail1">Style</label>
							<div class="input-group">
								<input ${disabled}   type="text" name="styleId" id="id_styleId"  class="form-control" class="typeahead form-control" data-provide="typeahead" value='<c:if test="${merordersheethdr.mststyleheader.id.styleId!=null}">${merordersheethdr.mststyleheader.id.styleId}</c:if><c:if test="${merordersheethdr.mststyleheader.id.styleId ==null}"> <c:if test="${mststyleheader.id.styleId!=null}">${mststyleheader.id.styleId}</c:if><c:if test="${mststyleheader.id.styleId==null}">${param.styleId}</c:if></c:if>' 
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
						<button ${disabled9} onclick="addmodalpopup('id_styleId')" type="button" class="btn btn-primary btn-xs dropdown-toggle " data-toggle="modal" data-target="#schmodalpopup" ><span class="glyphicon glyphicon-search"></span></button>
					</div>
					<div class="clearfix"></div> 

				</div>
		
				<div class="col-sm-4 col-md-4 ">
					<div class="form-group formwithsearch marginbottom20">
						<div class="icon-addon addon-md">
							<label for="exampleInputEmail1">Company</label>
							<c:if test="${mststyleheader.id.compCode !=null}">
								<input ${disabled}  required="required" class="form-control" type="text" name="compCode" id="id_compCode" value="${mststyleheader.id.compCode}"/>
							</c:if>						
							<c:if test="${mststyleheader.id.compCode ==null}">
								<select ${disabled} type="text" name="compCode" id="id_compCode" onfocus="getOptions('id_compCode','mstcompany')" class="form-control">
									<c:if test="${param.custCode == null}">
										<c:forEach items="${mstparam}" var="mstparams">	
												<option selected="selected">${mstparams.commonCompCode}</option>
										</c:forEach>
									</c:if>
									<c:if test="${param.custCode !=null}">
										<option selected="selected">${param.compCode}</option>
									</c:if>
								</select>
							</c:if>
						</div>
					</div>  
					<div class="btn-group formsearchbtn btn-model-select-div">
						<button ${disabled9}  onclick="$('#id_compCode').trigger('onfocus'); addmodalpopup('id_compCode')" type="button" class="btn btn-primary btn-xs dropdown-toggle " data-toggle="modal" data-target="#schmodalpopup" ><span class="glyphicon glyphicon-search"></span></button>
					</div>
					<div class="clearfix"></div>
				</div>

				<div class="col-sm-4 col-md-4 ">
					<div class="form-group formwithsearch marginbottom20">
						<div class="icon-addon addon-md">
							<label for="exampleInputEmail1">Style Description</label>
							<input  type="text" name="styleDescription" id="styleDescription" value='<c:if test="${merordersheethdr.mststyleheader.styleDescription!=null}">${merordersheethdr.mststyleheader.styleDescription}</c:if><c:if test="${merordersheethdr.mststyleheader.styleDescription ==null}"><c:if test="${mststyleheader.styleDescription!=null}"> ${mststyleheader.styleDescription}</c:if><c:if test="${mststyleheader.styleDescription==null}">${param.styleDescription}</c:if></c:if>' class="form-control" readonly="readonly">
						</div>
					</div>  
					<div class="clearfix"></div>
				</div>
				
		
				<div class="col-sm-4 col-md-4">
					<div class="form-group formwithsearch marginbottom20">
						<div class="icon-addon addon-md">
							<label for="exampleInputEmail1">Season</label>
								<c:if test="${merordersheethdr.season !=null}">
									<c:if test="${merordersheethdr.season != ''}">
										<input ${disabled3} required="required" type="text" name="season" id="season" class="form-control" value="${merordersheethdr.season}"/>
									</c:if>	
									<c:if test="${merordersheethdr.season == ''}">
										<select ${disabled3}  type="text" name="season" id="season" class="form-control" <c:if test="${disabled3 != 'readonly'}"> onfocus="optionsforgencodes('season','SEASON')" </c:if>>							
											<option selected="selected">${param.season}</option>
										</select>
									</c:if>	
								</c:if>	
								<c:if test="${merordersheethdr.season == null}">
									<select ${disabled3}   type="text" name="season" id="season" class="form-control" <c:if test="${disabled3 != 'readonly'}"> onfocus="optionsforgencodes('season','SEASON')" </c:if>>							
										<option selected="selected">${param.season}</option>
									</select>
								</c:if>								
						</div>
					</div> 		
					<div class="btn-group formsearchbtn btn-model-select-div">
						<button  ${disabled9} onclick="$('#season').trigger('onfocus'); addmodalpopup('season')" type="button" class="btn btn-primary btn-xs dropdown-toggle " data-toggle="modal" data-target="#schmodalpopup" ><span class="glyphicon glyphicon-search"></span></button>
					</div>					
					<div class="clearfix"></div> 
				</div>
				<div class="col-sm-4 col-md-4">
					<button ${disabled1} type="submit" class="btn btn-info btn-embossed search-routes-btn" ><span class="glyphicon glyphicon-search"></span>Create Planning Order</button>
					<button ${disabled1} type="reset" class="reset replace-data btn btn-defalt btn-embossed search-routes-btn"><span class="glyphicon glyphicon-refresh"></span>Reset</button>
				</div>
			</div>
		</form>
		<div class="row paddingleft20">
			<div class="col-sm-12 col-md-12">
				<div class="panel-group" id="quallocationsscreeen">
					<div class="panel panel-default">
						<div class="panel-heading" data-toggle="collapse" data-parent="#quallocationsscreeen" data-target="#quallocationsBody1">
							<h4 class="panel-title">
								<a data-toggle="collapse" data-parent="#quallocationsscreeen" href="#quallocationsBody1"> 
								</a><a class="accordion-toggle"> <span class="pull-right slideupdowntoggle glyphicon glyphicon-chevron-up"></span>Allocate Quantity</a>  
							</h4>
						</div>
						<div id="quallocationsBody1" class="panel-collapse collapse" style="height: auto;">
							<c:if test="${NO != 'NO'}">
								<div class="panel-body">
									 <form  method="post" action="merordersheethdrform" class="" id="merordersheethdrsfrmhdr" >
										<div class="row paddingleft20"> 
											<div class="col-sm-5 col-md-5 ">
												<div class="form-group formwithsearch marginbottom20">
													<div class="icon-addon addon-md">
														<spring:bind path="merordersheethdr.id.orderType">
														<div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
														</spring:bind>
															<appfuse:label key="merordersheethdr.orderType" styleClass="control-label"/>
															<select ${disabled3} required="required"  type="text" name="id.orderType" id="orderType" class="form-control" onfocus="optionsforgencodes('orderType','ORDTYP')" >
																<option selected="selected">${merordersheethdr.id.orderType}</option>
															</select>
															<form:errors path="id.orderType" cssClass="help-block"/>
														</div>
													</div>
												</div> 
												<div class="btn-group formsearchbtn btn-model-select-div">
													<button  ${disabled9} onclick="$('#orderType').trigger('onfocus'); addmodalpopup('orderType')" type="button" class="btn btn-primary btn-xs dropdown-toggle " data-toggle="modal" data-target="#schmodalpopup" ><span class="glyphicon glyphicon-search"></span></button>
												</div>
												<div class="clearfix"></div> 
												 <spring:bind path="merordersheethdr.totalQty">
												<div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''} formwithsearch marginbottom20">
												</spring:bind>
													<div class="icon-addon addon-md">
														<appfuse:label key="merordersheethdr.totalQty" styleClass="control-label"/>
														<input ${disabled1} onkeypress="return IsNumeric(event,this.id)" ondrop="return false;" onpaste="return false;" class="form-control" name="totalQty" id="totalQty"  value="${merordersheethdr.totalQty}" maxlength="13"/>
														<form:errors path="totalQty" cssClass="help-block"/>
														<span id="errortotalQty" style="color: Red; display: none">* Input digits (0 - 9)</span>
													</div>
												</div>  

												<div class="clearfix"></div>
										
												<spring:bind path="merordersheethdr.remarks">
												<div class="form-group${(not empty status.errorMessage) ? ' has-error' : '' } formwithsearch marginbottom20">
												</spring:bind>
													<appfuse:label key="merordersheethdr.remarks" styleClass="control-label"/>
													<textarea ${disabled1} Class="form-control"  name="remarks" id="remarks"  maxlength="255">${merordersheethdr.remarks}</textarea>
													<form:errors path="remarks" cssClass="help-block"/>
												</div> 

											</div>
											<div class="clearfix"></div>
											<div id="submision" class="submit-button styl-rt-submission-btn pull-left marginnewtop90 marginLeft20">
												<button ${disabled1} type="button" id="planingsubmit" onclick="saveplanningorder(this.id)" class="btn btn-info btn-lg btn-embossed">Submit</button>
                                                <a><button ${disabled1} type="reset" id="back3" class="btn btn-default btn-lg">Clear All</button></a>
											</div>
										</div>
										<div class="clearfix"></div>
									</form>	
								</div> 
							</c:if>
										
							<!-- pannel body ends -->
						</div>
					</div>
				</div> 
			</div> 
		</div>
		<div class="clearfix"></div>
	</div>
	<div class="tab-pane " id="addRowMat">
		<div class="row paddingleft20">
			<div class="col-sm-12 col-md-12">
				<div class="panel-group" id="rowMaterialScreen2">
					<c:if test="${merordersheethdr.id.planingOrdersheetNo !=null}">
						<div class="panel panel-default">
							<div class="panel-heading" data-toggle="collapse" data-parent="#rowMaterialScreen2" data-target="#rowMaterialScreenBody2">
								<h4 class="panel-title">
								<a data-toggle="collapse" data-parent="#rowMaterialScreen2" href="#rowMaterialScreenBody2">
								</a><a class="accordion-toggle"> <span class="pull-right slideupdowntoggle glyphicon glyphicon-chevron-up"></span>Apply Raw Meterials</a>
								</h4>
							</div>
							<div id="rowMaterialScreenBody2" class="panel-collapse collapse in" style="height: auto;">
								<div class="col-md-6 paddingleft20">
								<br>
									<div class="col-sm-12 col-md-12">
										<ul class="nav nav-pills nav-pills-jq ">
											<li class="active">
											<script type="text/javascript">
												var itemtypecatogery=new Array();
											</script>
											<c:if test="${disabled1 == 'disabled'}">
												<c:set var="view" scope="session" value="View"/>
											</c:if>
											<c:forEach items="${mstitemtypeCatogory}" var="mstitemtypecatogory">
												<a onclick="navigterowMat('${mstitemtypecatogory}','${view}')">${mstitemtypecatogory} <span class="badge" id="bage${mstitemtypecatogory}"></span></a></li><li>
												<script type="text/javascript">
													itemtypecatogery.push('${mstitemtypecatogory}');
												</script>
											</c:forEach>
											</li>
										</ul>
									</div>
								</div>
								<div class="panel-group" id="rowMaterialScreen">
								<!--  dyanemic table-->
								</div> 
							</div>
						</div>
					</c:if>
				</div>
			</div>
		</div><!-- END OF ROW-->
		<c:if test="${disabled1 != 'disabled'}">
			<div class="row paddingleft20">
				<div class="col-sm-12 col-md-12">
					<div class="panel-group" id="fcsgdetails">
						<div class="panel panel-default">
							<div class="panel-heading" data-toggle="collapse" data-parent="#fcsgdetails" data-target="#fcsgdetailsBody">
								<h4 class="panel-title">
									<a data-toggle="collapse" data-parent="#fcsgdetails" href="#fcsgdetailsBody"> 
									</a><a class="accordion-toggle"> <span class="pull-right slideupdowntoggle glyphicon glyphicon-chevron-up"></span>BOM Creation</a>  
								</h4>
							</div>
							<div id="fcsgdetailsBody" class="panel-collapse collapse in" style="height: auto;">
								<c:if test="${merordersheethdr.id.planingOrdersheetNo !=null}">
									
										<form  method="POST" action="merordersheethdrform" class="well" id="merordersheethdrsfrmrm" >
											<div class="panel-body">
												<div class="col-sm-4 col-md-4 ">
													<spring:bind path="merordersheetrawmaterial.mstitemtype">
													<div class="form-group${(not empty status.errorMessage) ? ' has-error' : '' } formwithsearch marginbottom20">
													</spring:bind>
															<div class="icon-addon addon-md">
															<appfuse:label key="merordersheetrawmaterial.mstitemtype" styleClass="control-label"/><!-- onchange="inputenbler('costsheet','itemType')" -->
															<select required="required" onblur ="inputenbler('ordersheet','itemType')"  onchange="inputenbler('ordersheet','itemType')" type="text" class="form-control" name="itemType" id="itemType"  onfocus="getOptions('itemType','mstitemtype')"></select>
															<form:errors path="mstitemtype" cssClass="help-block"/>
														</div>
													</div> 
													<div class="btn-group formsearchbtn btn-model-select-div">
														<button onclick="$('#itemType').trigger('onfocus');addmodalpopup('itemType');" type="button" class="btn btn-primary btn-xs dropdown-toggle " data-toggle="modal" data-target="#schmodalpopup" ><span class="glyphicon glyphicon-search"></span></button>
													</div>
													<div class="clearfix"></div> 
													<spring:bind path="merordersheetrawmaterial.itemColor">
													<div class="form-group${(not empty status.errorMessage) ? ' has-error' : '' } formwithsearch marginbottom20">
													</spring:bind>
														<div class="icon-addon addon-md">
															<appfuse:label key="merordersheetrawmaterial.itemColor" styleClass="control-label"/><!-- onchange="inputenbler('costsheet','itemType')" -->
															<select required="required" type="text" class="form-control" id="itemColor" name ="itemColor"onfocus="optionsforgencodes('itemColor','')"> </select>		
															<!-- <input type="text" class="form-control" name="itemColor" id="itemColor"> -->
															<form:errors path="itemColor" cssClass="help-block"/>
														</div>
													</div> 
													<div class="clearfix"></div>
													<spring:bind path="merordersheetrawmaterial.additionalAttribute1">
													<div class="form-group${(not empty status.errorMessage) ? ' has-error' : '' } formwithsearch marginbottom20">
													</spring:bind>
														<div class="icon-addon addon-md">
															<appfuse:label key="merordersheetrawmaterial.additionalAttribute1" styleClass="control-label"/><!-- onchange="inputenbler('costsheet','itemType')" -->
															<input type="text" class="form-control" name="additionalAttribute1" id="additionalAttribute1">
															<form:errors path="additionalAttribute1" cssClass="help-block"/>
														</div>
													</div>   
													<div class="clearfix"></div> 
													
												</div>
												<div class="col-sm-4 col-md-4 ">
													<spring:bind path="merordersheetrawmaterial.itemCode">
													<div class="form-group${(not empty status.errorMessage) ? ' has-error' : '' } formwithsearch marginbottom20">
													</spring:bind>
														<div class="icon-addon addon-md">
															<appfuse:label key="merordersheetrawmaterial.itemCode" styleClass="control-label"/><!-- onchange="inputenbler('costsheet','itemType')" -->
															<select required="required" disabled onchange="getOptions('itemDescription','mstitem')"  type="text" class="form-control" id="itemCode"  name="itemCode" onfocus="getOptions('itemCode','mstitem')" ></select>
															<form:errors path="itemCode" cssClass="help-block"/>
														</div>
													</div>
													<div class="btn-group formsearchbtn btn-model-select-div">
														<button id="itemCodemodel" disabled="disabled" onclick="$('#itemCode').trigger('onfocus');addmodalpopup('itemCode');" type="button" class="btn btn-primary btn-xs dropdown-toggle " data-toggle="modal" data-target="#schmodalpopup" ><span class="glyphicon glyphicon-search"></span></button>
													</div>											
													<div class="clearfix"></div> 
													<spring:bind path="merordersheetrawmaterial.itemWidth">
													<div class="form-group${(not empty status.errorMessage) ? ' has-error' : '' } formwithsearch marginbottom20">
													</spring:bind>
														<div class="icon-addon addon-md">
															<appfuse:label key="merordersheetrawmaterial.itemWidth" styleClass="control-label"/><!-- onchange="inputenbler('costsheet','itemType')" -->
															<input  type="text"  class="form-control" name="itemWidth" id="itemWidth"> <!-- onkeypress="return IsNumericSpecial(event,this.id)" ondrop="return false;" onpaste="return false;" -->
															<form:errors path="itemWidth" cssClass="help-block"/>
														</div>
													</div> 
													<div class="clearfix"></div> 
													<spring:bind path="merordersheetrawmaterial.isRelease">
													<div class="form-group${(not empty status.errorMessage) ? ' has-error' : '' } formwithsearch marginbottom20">
													</spring:bind>
														<div class="icon-addon addon-md marginTop30">
															<appfuse:label key="merordersheetrawmaterial.isRelease" styleClass="control-label"/><!-- onchange="inputenbler('costsheet','itemType')" -->
															&nbsp;<input class="pull-left marginTop10 yesNocheckBox" id="isRelease" type="checkbox" name="isRelease" >
															<form:errors path="isRelease" cssClass="help-block"/>
														</div>
													</div>						
													<div class="clearfix"></div> 
												</div>
												<div class="col-sm-4 col-md-4">
													<spring:bind path="merordersheetrawmaterial.itemDescription">
													<div class="form-group${(not empty status.errorMessage) ? ' has-error' : '' } formwithsearch marginbottom20">
													</spring:bind>
														<div class="icon-addon addon-md">
															<appfuse:label key="merordersheetrawmaterial.itemDescription" styleClass="control-label"/><!-- onchange="inputenbler('costsheet','itemType')" -->
															<input readonly="readonly" type="text" class="form-control" name="itemDescription" id="itemDescription">
															<form:errors path="itemDescription" cssClass="help-block"/>
														</div>
													</div>	
													<div class="clearfix"></div> 
													
													<spring:bind path="merordersheetrawmaterial.additionalAttribute2">
													<div class="form-group${(not empty status.errorMessage) ? ' has-error' : '' } formwithsearch marginbottom20">
													</spring:bind>
														<div class="icon-addon addon-md">
															<appfuse:label key="merordersheetrawmaterial.additionalAttribute2" styleClass="control-label"/><!-- onchange="inputenbler('costsheet','itemType')" -->
															<input type="text" class="form-control" name="additionalAttribute2" id="additionalAttribute2">
															<form:errors path="additionalAttribute2" cssClass="help-block"/>
														</div>
													</div>  
													<div class="clearfix"></div>
												</div>

												<div id="submision" class="submit-button styl-rt-submission-btn pull-left marginnewtop90 marginLeft20">
                                                    <button id="rowsubmit" type="button" onclick="addrowmatToPlaning()" class="btn btn-info btn-lg btn-embossed">Submit</button>
													<a><button type="button" onclick="clear_form_elements(this.form);" class="btn btn-default btn-lg">Clear All</button></a>
												</div>
											</div> <!-- pannel body ends -->
										</form>	
									
								</c:if>
							</div>
						</div>
					</div> 
				</div> 
			</div> <!-- row ends -->
		</c:if>
	</div>
	<div class="col-sm-8 col-md-8 col-xs-8 marginTop30 marginBottom20">
		<div class="createdby">
			<span class="glyphicon glyphicon-ok aprovedicon"></span>
			<div class="aprovedbytitle">
				Created By: ${merordersheethdre.createdBy}<br>
				Created At: ${merordersheethdre.createdAt}<br>
				Created On: ${merordersheethdre.createdOn}
			</div>
		</div>
		<div class="modifiedby">
			<span class="glyphicon glyphicon-edit createdicon"></span>
			<div class="aprovedbytitle">
				Modified By: ${merordersheethdre.createdBy}<br>
				Modified At: ${merordersheethdre.modifiedAt}<br>
				Modified On: ${merordersheethdre.createdOn}
			</div>
		</div>
		<div class="aprovedby">
			<span class="glyphicon glyphicon-refresh modifiedicon"></span>
			<div class="aprovedbytitle">
				<!-- Approved By: <br>
				Approved On: dd/mm/yyyy -->
			</div>
		</div>
	</div>
	<div id="submision" class="submit-button styl-rt-submission-btn pull-right marginRight0 marginTop30">
		<%--<a><button id="back3" class="btn btn-default btn-lg">Back</button></a>--%>
		<button id="planingconform" onclick="saveplanningorder(this.id)" class="btn btn-info btn-lg btn-embossed">Conform</button>
	</div>
<!-- </div> -->
	<div class="col-sm-8 col-md-8 col-xs-8" id="errors" style="display:none">
		<div class="alert alert-danger d-alert" role="alert">
			<button type="button" class="close" data-dismiss="alert" aria-hidden="true">�</button>
			<span class="error_heading">Error! </span> Change a few things up and try submitting again.
		</div>	  
	</div>
<v:javascript formName="merordersheethdr" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<c:url value='/scripts/validator.jsp'/>"></script>

<script type="text/javascript">
    $('#errors').hide();
	//var orderType="${merordersheethdr.id.orderType}";
	var planingOrdersheetNo="${merordersheethdr.id.planingOrdersheetNo}";
	var isstyleselect="${NO}";
	$(document).ready(function() {
        $("input[type='text']:visible:enabled:first", document.forms['merordersheethdrForm']).focus();
		
		if(planingOrdersheetNo!="" && planingOrdersheetNo!=null){
			for(var i=itemtypecatogery.length-1;i>-1;i--){
				 <c:if test="${disabled1 != 'disabled'}">							
				 navigterowMat(itemtypecatogery[i],'');
				 </c:if>
				 <c:if test="${disabled1 == 'disabled'}">							
				 navigterowMat(itemtypecatogery[i],'View');
				 </c:if>
				
				 console.log(itemtypecatogery[i]);
			}
			selecteditemcategory=itemtypecatogery[0];
		}
    });
</script>
<script>
    $("[name='isRelease']").bootstrapSwitch();
    </script>