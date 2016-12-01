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

					
    <div class="row form-group paddingleft20"><!-- NAVIGATION PILLS -->
        <div class="col-xs-7">
            <h2>Final Cost Sheet</h2>
        </div>
<%--     ${mststyledems} --%>
<!--     </br> -->
<%--     ${mststyledemmaps} --%>
        <div class="col-xs-5 styletoure-hrline-fcs">
            <ul class="nav nav-justified setup-panel" id="myTab">
                <li class="active">
                    <a href="#addNewFinalCostSheet">
                        <button type="button" class="btn btn-default btn-circle"><span class="fa fa-info-circle"></span>
                        </button>
                        <p class="list-group-item-text">General Details</p>
                    </a>
                </li>
                <li id="tabBtn2" class="disabled" data-toggle="tab">
                    <a href="#createGroups">
                        <button type="button" class="btn btn-default btn-circle"><span class="fa  fa-cubes"></span>
                        </button>
                        <p class="list-group-item-text">Create Groups</p>
                    </a>
                </li>
                <li id="tabBtn3" class="disabled" data-toggle="tab">
                    <a href="#addRowMat">
                        <button type="button" class="btn btn-default btn-circle"><span class="fa fa-thumb-tack"></span>
                        </button>
                        <p class="list-group-item-text">Add Row Materials</p>
                    </a>
                </li>
                <li id="tabBtn4" class="disabled" data-toggle="tab">
                    <a href="#creatGCsheet">
                        <button type="button" class="btn btn-default btn-circle"><span class="fa fa-th-list"></span>
                        </button>
                        <p class="list-group-item-text">Create General Cost Sheets</p>
                    </a>
                </li>
            </ul>
        </div>
    </div><!-- NAVIGATION PILLS END mststyleheader-->


    <div class="tab-content"><!-- TAB CONTENT MAIN -->
        <div class="tab-pane active" id="addNewFinalCostSheet">
            <div class="row paddingleft20">
				<form method="get" action="${ctx}/mercostsheethdrform" id="searchForm" class="form-inline">
					<div class="col-sm-4 col-md-4 ">
						<div class="form-group formwithsearch marginbottom20">
							<div class="icon-addon addon-md">
								<label for="exampleInputEmail1">Buyer </label>
								<select required="required"  name="custCode" id="cs_id_custCode" onfocus="getOptions('cs_id_custCode','mstcustomer')" class="form-control" >
										<c:if test="${mststyleheader.id.custCode != null}">
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
										<input required="required" type="text" name="styleId" id="cs_id_styleId"  autocomplete="off" class="form-control" class="typeahead form-control" data-provide="typeahead" value='${param.styleId}' onfocus="typaheadforStyle('cs_id_styleId','id.styleId')" >
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
						<button type="submit" name="costsheet" class="btn btn-info btn-embossed search-routes-btn"><span class="glyphicon glyphicon-search"></span>   Search FCS</button>
						<button type="button"  class="reset  replace-data btn btn-defalt btn-embossed search-routes-btn"><span class="glyphicon glyphicon-refresh"></span>  Reset</button>
					</div>
                     <div class="col-sm-4 col-md-4">&nbsp;</div>
				</form>
            </div>
            <div class="row paddingleft20">
                <div class="col-sm-6 col-md-6">
                    <div class="panel-group" id="FCStype">
                        <div class="panel panel-default">
                            <div class="panel-heading" data-toggle="collapse" data-parent="#FCStype" data-target="#FCStypeBody">
                                <h4 class="panel-title">
              						<a data-toggle="collapse" data-parent="#FCStype" href="#FCStypeBody"> 
                 						<a class="accordion-toggle">
                 							<span class="pull-right slideupdowntoggle glyphicon glyphicon-chevron-up"></span>
                 							Final Cost Sheet Type
                 						</a>
                 					</a> 
            					</h4>
                            </div>
                            <div id="FCStypeBody" class="panel-collapse collapse">
                            <c:if test="${mststylecomponentList !=null}">
                            <form:form method="post" action="mstcostsheetForm" id="costSheetTypeForm" >
                                <div class="panel-body">
                                    <div class="row">
                                        <div class="col-sm-5 col-md-5">
                                            <p>Component wise Costing :</p>
                                        </div>
                                        <c:if test="${mercostsheethdr.compWiseCost == true}">
                                        	<input class="yesNocheckBox" id="compWiseCost" type="checkbox" checked="checked" name="compWiseCost">
                                        </c:if>
                                        <c:if test="${mercostsheethdr.compWiseCost == false || mercostsheethdr.compWiseCost == null}">
                                        	<input class="yesNocheckBox" id="compWiseCost" type="checkbox" name="compWiseCost">
                                        </c:if>

                                    </div>
                                    <div class="row">
                                        <div class="col-sm-5 col-md-5">
                                            <p>Costing Method :</p>
                                        </div>

                                        <div class="col-sm-7 col-md-7">
                                        	<c:if test="${mercostsheethdr.averageWiseCost == true}">
	                                        	<input onchange="costingMethod();" class="normal pull-left" id="averageWiseCost" type="checkbox" checked="checked" name="averageWiseCost">
	                                        </c:if>
	                                        <c:if test="${mercostsheethdr.averageWiseCost == false || mercostsheethdr.averageWiseCost == null}">
	                                        	<input onchange="costingMethod();" class="normal pull-left" id="averageWiseCost" type="checkbox" name="averageWiseCost">
	                                        </c:if>
                                            
                                            <label class="pull-left marginLeft5">Average</label>
                                        </div>

                                        <div class="col-sm-7 col-md-7 pull-right">
                                        	<c:if test="${mercostsheethdr.sizeWiseCost == true}">
	                                        	<input onchange="costingMethod();" class="normal pull-left" id="sizeWiseCost" type="checkbox" checked="checked" name="sizeWiseCost">
	                                        </c:if>
	                                        <c:if test="${mercostsheethdr.sizeWiseCost == false || mercostsheethdr.sizeWiseCost == null}">
	                                        	<input onchange="costingMethod();" class="normal pull-left" id="sizeWiseCost" type="checkbox" name="sizeWiseCost">
	                                        </c:if>
                                            
                                            <label class="pull-left marginLeft5">Size Wise</label>
                                        </div>

                                        <div class="col-sm-7 col-md-7 pull-right">
                                        	<c:if test="${mercostsheethdr.countryWiseCost == true}">
	                                        	<input onchange="costingMethod();" class="normal pull-left" id="countryWiseCost" type="checkbox" checked="checked" name="countryWiseCost" >
	                                        </c:if>
	                                        <c:if test="${mercostsheethdr.countryWiseCost == false || mercostsheethdr.countryWiseCost == null}">
	                                        	<input onchange="costingMethod();" class="normal pull-left" id="countryWiseCost" type="checkbox" name="countryWiseCost" >
	                                        </c:if>
                                            
                                            <label class="pull-left marginLeft5">Country Wise</label>
                                        </div>
                                    </div>
                                </div><!-- pannel body ends -->
                            </form:form>
                            </c:if>
                            </div>
                        </div>
                    </div>
                </div><!-- </ div>  --><!-- end of row -->

                <!-- < div class="row paddingleft20"> -->
                <div class="col-sm-6 col-md-6">
                    <div class="panel-group" id="bssDetails">
                        <div class="panel panel-default">
                            <div class="panel-heading" data-toggle="collapse" data-parent="#bssDetails" data-target="#bssDetailsBody">
                                <h4 class="panel-title">
					            	<a data-toggle="collapse" data-parent="#bssDetails" href="#bssDetailsBody"> 
					                 	<a class="accordion-toggle"> 
					                 	<span class="pull-right slideupdowntoggle glyphicon glyphicon-chevron-up"></span>Base Cost Sheet Details
					                 	</a>
									</a> 
					            </h4>
                            </div>
                            <div id="bssDetailsBody" class="panel-collapse collapse">

                            	<c:if test="${merprecostsheet.id == null}">
                            		<div class="panel-body">
                                         <div class="bs-example">
                                            <div class="alert alert-info" role="alert">
                                            <strong>Note!</strong>&nbsp; Not Applicable
                                            </div>
                                         </div>
                            		</div><!-- pannel body ends -->  
                            	</c:if>
								<c:if test="${merprecostsheet.id != null}">
									<div class="panel-body">
	                                    <div class="row">
	                                        <div class="col-sm-3 col-md-3 pull-left">
	                                            <label class="pull-left  paddingleft10"><strong>Cost Sheet No</strong>
	                                            </label>
	                                        </div>
	
	                                        <div class="col-sm-3 col-md-3 pull-left">
	                                            <label class="pull-left" id="preCostSheetNo">${merprecostsheet.id.preCostSheetNo}</label>
	                                        </div>
											<div class="col-sm-3 col-md-3 pull-left">
	                                            <label class="pull-left "><strong>Version</strong>
	                                            </label>
	                                        </div>
	
	                                        <div class="col-sm-3 col-md-3 pull-left">
	                                            <label class="pull-left " id="versionNo">${merprecostsheet.id.versionNo}</label>
	                                        </div>
	                                    </div>

	                                    <div class="row">
	
	                                        <div class="col-sm-3 col-md-3 pull-left">
	                                            <label class="pull-right "  ><strong>Cost Sheet Type</strong>
	                                            </label>
	                                        </div>
	                                        <div class="col-sm-3 col-md-3 pull-left">
	                                            <label class="pull-left " id="preCostSheetType">${merprecostsheet.id.costsheetType}</label>
	                                        </div>
	                                        <div class="col-sm-3 col-md-3 pull-left">
	                                            <label class="pull-left "><strong>Order Qty</strong>
	                                            </label>
	                                        </div>
	                                        <div class="col-sm-3 col-md-3 pull-left">
	                                            <label class="pull-left ">${merprecostsheet.orderQty}</label>
	                                        </div>
	                                    </div>
	                                    <div class="row">
	                                        <div class="col-sm-3 col-md-3 pull-left">
	                                            <label class="pull-left paddingleft10"><strong>Merchandiser</strong>
	                                            </label>
	                                        </div>
	                                        <div class="col-sm-3 col-md-3 pull-left">
	                                            <label class="pull-left ">${merprecostsheet.merchandiser.userId}</label>
	                                        </div>
											<div class="col-sm-3 col-md-3 pull-left">
	                                            <label class="pull-left "><strong>Create Date</strong>
	                                            </label>
	                                        </div>
	
	                                        <div class="col-sm-3 col-md-3 pull-left">
	                                            <label class="pull-left ">${merprecostsheet.createdOn}</label>
	                                        </div>
	                                    </div>
                                   </div><!-- pannel body ends -->  
								</c:if>
                               
                            </div>
                        </div>
                    </div>
                </div>
            </div>
			<div class="row paddingleft20" >
				<div class="col-sm-12 col-md-12">
					<div class="panel-group" id="stylebrowser">
					<form:form method="post" action="mstcostsheetForm" id="costSheetGeneralForm" >
						<div class="panel panel-default">
							<div class="panel-heading" data-toggle="collapse" data-parent="#stylebrowser" data-target="#styleBrowserBody">
							  <h4 class="panel-title">
							  <a data-toggle="collapse" data-parent="#stylebrowser" href="#styleBrowserBody" > 
								 </a><a class="accordion-toggle"> <span class="pull-right slideupdowntoggle glyphicon glyphicon-chevron-up"></span>General Details</a>  
							</h4>
							</div>
							<c:if test="${mststylecomponentList !=null}">
								<div id="styleBrowserBody" class="panel-collapse collapse out" style="height: auto;">
									<div class="panel-body">
										<div class="col-sm-4 col-md-4 ">
											<div class="form-group formwithsearch marginbottom20">
												<div class="icon-addon addon-md">
													<div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
														<appfuse:label key="mercostsheethdr.costSheetType" styleClass="control-label"/>
														<select required="required"  type="text" name="id.costSheetType" id="costSheetType" class="form-control" onfocus="optionsforgencodes('costSheetType','COSTYP')" >
															<c:if test="${mercostsheethdr.id.costSheetType ==null}">
																<c:forEach items="${mstparam}" var="mstparams">
																	<option selected="selected">${mstparams.locationCode}</option>
																</c:forEach>
															</c:if>
															<c:if test="${mercostsheethdr.id.costSheetType !=null}">
																<option selected="selected">${mercostsheethdr.id.costSheetType}</option>
															</c:if>
														</select>
													</div>
												</div>
											</div>
											<div class="btn-group formsearchbtn btn-model-select-div">
												<button  onclick="$('#costSheetType').trigger('onfocus'); addmodalpopup('costSheetType')" type="button" class="btn btn-primary btn-xs dropdown-toggle " data-toggle="modal" data-target="#schmodalpopup" ><span class="glyphicon glyphicon-search"></span></button>
											</div>
											
											<div class="clearfix"></div> 
											<div class="form-group formwithsearch marginbottom20">
												<div class="icon-addon addon-md">
													<div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
														<appfuse:label key="mercostsheethdr.versionNo" styleClass="control-label"/>
														<input onkeypress="return IsNumeric(event,this.id)" ondrop="return false;" onpaste="return false;" name="id.versionNo" id="versionNo" Class="form-control" value="${mercostsheethdr.id.versionNo}" readonly="readonly"/>
														<span id="errorversionNo" style="color: Red; display: none">* Input digits (0 - 9)</span>
													</div>
												</div>
											</div>  
											<div class="clearfix"></div> 
											<div class="col-sm-12 col-md-12 col-xs-12 pull-left padding0 marginTop10">
												<div class="form-group fcsmulti formwithsearch marginbottom20">
													<div class="icon-addon addon-md">
														<label for="exampleInputEmail1">Country</label>

														<select data-placeholder="Select Country" onchange="setCountry();" 
														required="required" class="form-control chosen-select" multiple style="width:100%;" tabindex="4" id="destination_country" name="destinationCountry" >
															<c:forEach items="${mercostsheethdrcountryList}" var="mercostsheethdrcountry">
																<option value="${mercostsheethdrcountry.id.country}" selected='selected' >${mercostsheethdrcountry.id.country}</option>
															</c:forEach>
														</select>
													</div>
												</div>
											</div>
										</div>
										
										<div class="col-sm-4 col-md-4 ">
											<div class="form-group formwithsearch marginbottom20">
												<div class="icon-addon addon-md">
													<div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
														<appfuse:label key="mercostsheethdr.costSheetNo" styleClass="control-label"/>
														<input  name="id.costSheetNo" id="costSheetNo" Class="form-control" value="${mercostsheethdr.id.costSheetNo}" readonly="readonly"/>
													</div>
												</div>
											</div>  
											<div class="clearfix"></div> 
											<div class="form-group formwithsearch marginBottom20">
												<div class="icon-addon addon-md">
													<div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
														<appfuse:label key="Audit.createdOn" styleClass="control-label"/>
														<input Class="form-control" name="createdOn" id="createdOn" value="${mercostsheethdr.createdOn}" readonly="readonly"/>
													</div>
												</div>
											</div>  
											<div class="clearfix"></div> 
										</div>
										
										<div class="col-sm-4 col-md-4">
											<div class="form-group formwithsearch marginbottom20">
												<div class="icon-addon addon-md">
													<div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
														<appfuse:label key="mercostsheethdr.merchandiser" styleClass="control-label"/>
														<select required="required" Class="form-control" tabindex="12" id="merchandiser" name="merchandiser"  onfocus="getOptions('merchandiser','mstuser')">
															<option  selected="selected" >${mercostsheethdr.merchandiser}</option>
														</select>
													</div>
												</div>
											</div>  
											<div class="btn-group formsearchbtn btn-model-select-div">
												<button onclick="$('#merchandiser').trigger('onfocus'); addmodalpopup('merchandiser')" type="button" class="btn btn-primary btn-xs dropdown-toggle " data-toggle="modal" data-target="#schmodalpopup" ><span class="glyphicon glyphicon-search"></span></button>
											</div>
											<div class="clearfix"></div>
											<div class="form-group formwithsearch marginBottom20">
												<div class="icon-addon addon-md">
													<div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
														<appfuse:label key="mercostsheethdr.orderQty" styleClass="control-label"/>
														<input onkeypress="return IsNumeric(event,this.id)" ondrop="return false;" onpaste="return false;" required="required" Class="form-control" name="orderQty" value="${mercostsheethdr.orderQty}" id="orderQty"  maxlength="14"/>
														<span id="errororderQty" style="color: Red; display: none">* Input digits (0 - 9)</span>
													</div>
												</div>
											</div>  
										</div>
									</div> <!-- pannel body ends -->
								</div>
							</c:if>
                            <input type="hidden" name="preCostSheetNo" value="${merprecostsheet.id.preCostSheetNo}"/>
                            <input type="hidden" name="preVersionNo" value="${merprecostsheet.id.versionNo}"/>
                            <input type="hidden" name="preCostsheetType" value="${merprecostsheet.id.costsheetType}"/>
						</div>
					</form:form>
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
										<div class="dataTables_wrapper scrollxonly" style="">
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
															<th class="textcenter">Line Efficiency</th>
															<th class="textcenter">FMV Category</th>
															<th class="textcenter">FMV</th>
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
																<td class="textcenter">
																	<div class="icon-addon addon-md">
																		<select required="required" type="text" id ="${mststylecomponent.id.componentId}_styleRouteName" onchange="createSMV(this.options[this.selectedIndex].value,'${mststylecomponent.id.componentId}')" class="form-control" onfocus="getStyleRouteName('${mststylecomponent.id.componentId}','${mststylecomponent.id.styleId}','${mststylecomponent.id.locationCode}','${mststylecomponent.id.depCode}','${mststylecomponent.id.compCode}','${mststylecomponent.id.custCode}')"></select>
																	</div>
																</td>
																<td class="textcenter">
																	<div class="icon-addon addon-md">
																		<input required="required" onkeypress="return IsNumericdecimal(event,this.id)" ondrop="return false;" onpaste="return false;" Class="form-control" name="lineEfficiency" id="${mststylecomponent.id.componentId}_lineEfficiency" value="" maxlength="255"/>
																	</div>
																</td>
																<td class="textcenter">
																	<div class="icon-addon addon-md">
																		<select required="required" Class="form-control" name="fmvCategory" onchange="changefmv(this.options[this.selectedIndex].value,'${mststylecomponent.id.componentId}')"  onfocus="getOptions('${mststylecomponent.id.componentId}_fmvCategory','mstsmvrates')" id="${mststylecomponent.id.componentId}_fmvCategory"  maxlength="10">
																			<option selected></option>
																		</select>
																	</div>
																</td>
																<td class="textcenter">
																	<div class="icon-addon addon-md">
																		<input readonly="readonly" Class="form-control"   name="fmv" id="${mststylecomponent.id.componentId}_fmv"  maxlength="255"/>
																	</div>
																</td>
																<%-- <td> <div class="icon-addon addon-md" id ="${mststylecomponent.id.componentId}_CM"></div> </td> --%>
																<td class="textcenter">
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
													<div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
														<appfuse:label key="mercostsheethdr.totalSmv" styleClass="col-sm-6 control-label"/>
														 <div class="col-sm-6">
															<input readonly="readonly" Class="form-control" name="totalSmv" id="totalSmv"  maxlength="255" />
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
							<form method="post" action="mstcostsheetForm" id="costSheetCurrencyForm" >
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
															<spring:bind path="mercostsheethdr.costSheetCurrency">
															<div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''} formwithsearch marginbottom20">
															</spring:bind>
																<%-- <appfuse:label key="mercostsheethdr.costSheetCurrency" styleClass="col-sm-6 control-label"/> --%>
																 <div class="icon-addon addon-md">
																	<label for="exampleInputEmail1">Cost Sheet Currency: </label>
																	<select required="required" Class="form-control" name="costSheetCurrency.curCode" id="costSheetCurrency"  maxlength="255" onfocus="getOptions('costSheetCurrency','mstcurrency')">
																		<option selected="selected">${mercostsheethdr.costSheetCurrency.curCode}</option>
																	</select>
																	<form:errors path="costSheetCurrency" cssClass="help-block"/>
																</div>
															</div>				
															<div class="clearfix"></div> 
															<spring:bind path="mercostsheethdr.dftRmCurrency">
															<div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''} formwithsearch marginbottom20">
															</spring:bind>
																<%-- <appfuse:label key="mercostsheethdr.dftRmCurrency" styleClass="col-sm-6 control-label"/> --%>
																 <div class="icon-addon addon-md">
																	<label for="exampleInputEmail1">Default RM Currenty: </label>
																	<select required="required" Class="form-control" name="dftRmCurrency.curCode" id="dftRmCurrency"  maxlength="255" onfocus="getOptions('dftRmCurrency','mstcurrency')">
																		<option selected="selected">${mercostsheethdr.dftRmCurrency.curCode}</option>
																	</select>
																	<form:errors path="dftRmCurrency" cssClass="help-block"/>
																</div>
															</div>
															<div class="clearfix"></div> 											  
														</div>
														<div class="col-sm-5 col-md-5 ">
															<spring:bind path="mercostsheethdr.costSheetExchangeRate">
															<div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''} formwithsearch marginbottom20">
															</spring:bind>
																<%-- <appfuse:label key="mercostsheethdr.costSheetExchangeRate" styleClass="col-sm-6 control-label"/> --%>
																 <div class="icon-addon addon-md">
																 <label for="exampleInputEmail1">Exchange Rate (to convert to CS Currency) :</label>
																	<input required="required" value="${mercostsheethdr.costSheetExchangeRate}" onkeypress="return IsNumericdecimal(event,this.id)" ondrop="return false;" onpaste="return false;" Class="form-control" name="costSheetExchangeRate" id="costSheetExchangeRate"  maxlength="255" />
																	<span id="errorcostSheetExchangeRate" style="color: Red; display: none">* Input digits (0 - 9)</span>
																	<form:errors path="costSheetExchangeRate" cssClass="help-block"/>
																</div>
															</div>
															<div class="clearfix"></div> 
															<spring:bind path="mercostsheethdr.dftRmExchangeRate">
															<div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''} formwithsearch marginbottom20">
															</spring:bind>
																<%-- <appfuse:label key="mercostsheethdr.dftRmExchangeRate" styleClass="col-sm-6 control-label"/> --%>
																 <div class="icon-addon addon-md">
																 <label for="exampleInputEmail1">Other Exchange Rates againts Cost Sheet Currency :</label>
																	<input required="required" Class="form-control"onkeypress="return IsNumericdecimal(event,this.id)" ondrop="return false;" onpaste="return false;"  name="dftRmExchangeRate" value="${mercostsheethdr.dftRmExchangeRate}" id="dftRmExchangeRate"  maxlength="255" />
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
												<div> <!-- ADD SHOW HIDE CLASS HERE -->
													<div class="row paddingleft20">
														<div class="col-md-12"><h3 class="add-styl-rt">Other Exchange Rates against Cost Sheet Currency:</h3><hr></div>
													</div>
												</div> 
												<div class="row paddingleft20">	
													<div class="col-sm-5 col-md-5 ">
														<spring:bind path="mercostsheethdr.costSheetCurrency">
														<div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''} formwithsearch marginbottom20">
														</spring:bind>
															<%-- <appfuse:label key="mercostsheethdr.costSheetCurrency" styleClass="col-sm-6 control-label"/> --%>
															 <div class="icon-addon addon-md">
																<label for="exampleInputEmail1">Cost Sheet Currency: </label>
																<select Class="form-control" name="costSheetCurrency.curCode" id="costSheetCurrency"  maxlength="255" onfocus="getOptions('costSheetCurrency','mstcurrency')" >
																	<option selected="selected">${mercostsheethdr.costSheetCurrency.curCode}</option>
																</select>
																
																<form:errors path="costSheetCurrency" cssClass="help-block"/>
															</div>
														</div>  									
														<div class="clearfix"></div> 
														<spring:bind path="mercostsheethdr.dftRmCurrency">
														<div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''} formwithsearch marginbottom20">
														</spring:bind>
															<%-- <appfuse:label key="mercostsheethdr.dftRmCurrency" styleClass="col-sm-6 control-label"/> --%>
															 <div class="icon-addon addon-md">
																<label for="exampleInputEmail1">Default RM Currency: </label>
																<select Class="form-control" name="dftRmCurrency.curCode" id="dftRmCurrency"  maxlength="255"  onfocus="getOptions('dftRmCurrency','mstcurrency')">
																	<option selected="selected">${mercostsheethdr.dftRmCurrency.curCode}</option>
																</select>
																
																<form:errors path="dftRmCurrency" cssClass="help-block"/>
															</div>
														</div>  
														<div class="clearfix"></div> 
													</div>
													<div class="col-sm-4 col-md-4 ">
														<spring:bind path="mercostsheethdr.costSheetExchangeRate">
														<div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''} formwithsearch marginbottom20">
														</spring:bind>
															<%-- <appfuse:label key="mercostsheethdr.costSheetExchangeRate" styleClass="col-sm-6 control-label"/> --%>
															 <div class="icon-addon addon-md">
															 <label for="exampleInputEmail1">Exchange Rate (to convert to CS Currency) :</label>
																<input Class="form-control" onkeypress="return IsNumericdecimal(event,this.id)" ondrop="return false;" onpaste="return false;" name="costSheetExchangeRate" id="costSheetExchangeRate"  value="${mercostsheethdr.costSheetExchangeRate}" maxlength="255" />
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
											</c:if>	
									</c:forEach>
										 <!-- ADD SHOW HIDE CLASS ENDS -->
										<!-- ADD SHOW HIDE CLASS DIV ENDS -->
									<div class="row paddingleft20">	 </div> <!-- panel body end  -->
									</div>
								</div>
							</form>
							</c:if>
						</div>
					</div>
				</div>
		   </div><!-- end of row-->

            <div class="row paddingleft20">
                <div class="col-sm-12 col-md-12">
				<div class="panel-group" id="fcsT1bP">
                        <div class="panel panel-default">
                            <div class="panel-heading" data-toggle="collapse" data-parent="#fcsT1bP" data-target="#fcsT1bPBody">
                                <h4 class="panel-title">
                              <a data-toggle="collapse" data-parent="#fcsgdetails" href="#fcsT1bPBody">
                              </a><a class="accordion-toggle"> <span class="pull-right slideupdowntoggle glyphicon glyphicon-chevron-up"></span>Set Size Dimensions</a>
								</h4>
                            </div>
                            <div id="fcsT1bPBody" class="panel-collapse collapse" style="height: auto;">
							<c:if test="${mststylecomponentList !=null}">
                                <div class="panel-body">
									<div class="row ">
										<div class="col-sm-6 col-md-6">
                                            <div class="panel-group" id="FCStype2">
                                                <div class="panel panel-default">
                                                    <div class="panel-heading" data-toggle="collapse" data-parent="#FCStype2" data-target="#FCStypeBody2">
                                                        <h4 class="panel-title">
														<a data-toggle="collapse" data-parent="#FCStype" href="#FCStypeBody2"></a>
														<a class="accordion-toggle"> <span class="pull-right slideupdowntogglex glyphicon glyphicon-chevron-up"></span>Set Size Dimensions 1</a></h4>
                                                    </div>
                                                    <div id="FCStypeBody2" class="panel-collapse collapse" style="height: auto;">
                                                        <div class="panel-body">
                                                            <div class="row">
                                                                <div class=" ">
                                                                    <div class="form-group formwithsearch marginbottom20">
                                                                        <div class="icon-addon addon-md">
                                                                            <div class="col-sm-5 col-md-5 ">
                                                                                <label for="exampleInputEmail1">Select Dimensions:</label>
                                                                            </div>
                                                                            <div class="col-sm-7 col-md-7 ">
<%--                                                                             	<% boolean var = true; %> --%>
                                                                            	<select id="dim-vertical-type" onchange="selectDim(this.value,'Vertical');" class="form-control">
<%-- 	                                                                            <c:if test="${mststyledems != null}"> --%>
<%-- 	                                                                            	<c:forEach items="${mststyledems}" var="dimen"> --%>
<%-- 	                                                                            		<c:if test="${dimen.dimention == 'Vertical'}"> --%>
<%-- 		                                                                            		<c:if test="<%=var%>"> --%>
<%-- 		                                                                            			<option selected value="${dimen.id.demType}">${dimen.id.demType}</option> --%>
<%-- 		                                                                            			<% var = false; %> --%>
<%-- 		                                                                            		</c:if> --%>
<%-- 	                                                                            		</c:if> --%>
<%-- 																					</c:forEach> --%>
<%-- 	                                                                            </c:if> --%>
											<c:forEach items="${gencodes}" var="gencode">
												<c:if test="${gencode.id.type=='SIZDEM'}">
													<% String var = ""; %>
													<c:if test="${mststyledems != null}">
														<c:forEach items="${mststyledems}" var="mststyledem">
															<c:if test="${mststyledem.dimention == 'Vertical'}">
																<c:if test="${mststyledem.id.demType == gencode.id.code}">
																	<% var = "selected='selected'"; %>
																</c:if>
															</c:if>
														</c:forEach>
													</c:if>
													<option <%=var%> value="${gencode.id.code}">${gencode.id.code}</option>
													<% var = ""; %>
												</c:if>
											</c:forEach>
<!--                                                                             check costSheet size-fit, style header size-fit -->
                                                                                </select>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="clearfix"></div>

                                                                <div class="form-group formwithsearch marginbottom20">
                                                                    <div class="icon-addon addon-md">
                                                                        <div class="col-sm-5 col-md-5 ">
                                                                            <label for="exampleInputEmail1">Select Attributes:</label>
                                                                        </div>
                                                                        <div class="col-sm-7 col-md-7 ">
									<c:forEach items="${gencodes}" var="gencode">
										<c:if test="${gencode.id.type =='SIZDEM'}">
											<div class="vertical_divs" id="Vertical_${gencode.id.code}">
												<select data-placeholder="Select Values" id="V-select-${gencode.id.code}" class="chosen-select" multiple style="width:100%;" tabindex="4" onchange="templateMatrix();">
													<c:forEach items="${gencodes}" var="dim_h">
														<c:if test="${dim_h.id.type == gencode.id.code }">
															<% String var = ""; %>
															<c:if test="${mststyledems != null}">
																<c:forEach items="${mststyledems}" var="mststyledem">
																	<c:if test="${mststyledem.dimention == 'Vertical'}">
																		<c:if test="${mststyledem.id.demValue == dim_h.id.code}">
																			<% var = "selected='selected'"; %>
																		</c:if>
																	</c:if>
																</c:forEach>
															</c:if>
															<option <%=var%> id="h-${dim_h.id.code}" value="${dim_h.id.code}">${dim_h.id.code}</option>
														</c:if>
													</c:forEach>
												</select>
<!-- 												<div class="pull-right" style="margin-top:20px"> -->
<%-- 													<button type="button" class="btn" onclick="clearAllSelect('H-select-${gencode.id.code}');">Clear All</button> --%>
<!-- 													<button type="button" class="btn btn-info" onclick="bindMatrix('')">Apply</button> -->
<!-- 												</div> -->
											</div>
										</c:if>
									</c:forEach>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="clearfix"></div>
                                                                
                                                                <a onclick="templateMatrix()" class="btn btn-warning btn-embossed pull-left marginLeft15 newbuttonfinalcostfix"><span class="glyphicon glyphicon-plus marginRight4"></span>Add to Metrix</a>
                                                            </div>

                                                        </div>
                                                        <!-- pannel body ends -->
                                                    </div>
                                                </div>
                                            </div>

                                        </div>
                                        <!-- end of row -->
										
										<div class="col-sm-6 col-md-6">
                                            <div class="panel-group" id="bssDetails2">
                                                <div class="panel panel-default">
                                                    <div class="panel-heading" data-toggle="collapse" data-parent="#bssDetails2" data-target="#bssDetailsBody2">
                                                        <h4 class="panel-title">
                                                      <a data-toggle="collapse" data-parent="#bssDetails" href="#bssDetailsBody2">
                                                      </a><a class="accordion-toggle"> <span class="pull-right slideupdowntogglex glyphicon glyphicon-chevron-up"></span>Set Size Dimensions 2</a>
                                                  </h4>
                                                    </div>
                                                    <div id="bssDetailsBody2" class="panel-collapse collapse" style="height: auto;">
                                                        <div class="panel-body">
                                                            <div class="row">
                                                                <div class=" ">
                                                                    <div class="form-group formwithsearch marginbottom20">
                                                                        <div class="icon-addon addon-md">
                                                                            <div class="col-sm-5 col-md-5 ">
                                                                                <label for="exampleInputEmail1">Select Dimensions:</label>
                                                                            </div>
                                                                            <div class="col-sm-7 col-md-7 ">
                                                                                <select id="dim-horizontal-type" onchange="selectDim(this.value,'Horizontal');" class="form-control">
											<c:forEach items="${gencodes}" var="gencode">
												<c:if test="${gencode.id.type=='SIZDEM'}">
													<% String var = ""; %>
													<c:if test="${mststyledems != null}">
														<c:forEach items="${mststyledems}" var="mststyledem">
															<c:if test="${mststyledem.dimention == 'Horizontal'}">
																<c:if test="${mststyledem.id.demType == gencode.id.code}">
																	<% var = "selected='selected'"; %>
																</c:if>
															</c:if>
														</c:forEach>
													</c:if>
													<option <%=var%> value="${gencode.id.code}">${gencode.id.code}</option>
													<% var = ""; %>
												</c:if>
											</c:forEach>
	                                                                            </select>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="clearfix"></div>

                                                                <div class="form-group formwithsearch marginbottom20">
                                                                    <div class="icon-addon addon-md">
                                                                        <div class="col-sm-5 col-md-5 ">
                                                                            <label for="exampleInputEmail1">Select Attributes:</label>
                                                                        </div>
                                                                        <div class="col-sm-7 col-md-7 ">
									<c:forEach items="${gencodes}" var="gencode">
										<c:if test="${gencode.id.type =='SIZDEM'}">
											<div class="horizontal_divs" id="Horizontal_${gencode.id.code}">
												<select data-placeholder="Select Values" id="H-select-${gencode.id.code}" class="chosen-select" multiple style="width:100%;" tabindex="4" onchange="templateMatrix();">
													<c:forEach items="${gencodes}" var="dim_h">
														<c:if test="${dim_h.id.type == gencode.id.code }">
															<% String var = ""; %>
															<c:if test="${mststyledems != null}">
																<c:forEach items="${mststyledems}" var="mststyledem">
																	<c:if test="${mststyledem.dimention == 'Horizontal'}">
																		<c:if test="${mststyledem.id.demValue == dim_h.id.code}">
																			<% var = "selected='selected'"; %>
																		</c:if>
																	</c:if>
																</c:forEach>
															</c:if>
															<option <%=var%> id="h-${dim_h.id.code}" value="${dim_h.id.code}">${dim_h.id.code}</option>
														</c:if>
													</c:forEach>
												</select>
<!-- 												<div class="pull-right" style="margin-top:20px"> -->
<%-- 													<button type="button" class="btn" onclick="clearAllSelect('H-select-${gencode.id.code}');">Clear All</button> --%>
<!-- 													<button type="button" class="btn btn-info" onclick="bindMatrix('')">Apply</button> -->
<!-- 												</div> -->
											</div>
										</c:if>
									</c:forEach>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="clearfix"></div>
                                                                <a class="btn btn-warning btn-embossed pull-left marginLeft15 newbuttonfinalcostfix" onclick="templateMatrix()"><span class="glyphicon glyphicon-plus marginRight4"></span>Add to Metrix</a>
                                                            </div>
                                                        </div>
                                                        <!-- pannel body ends -->
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
										
									</div>
                                    <!--end of row-->
								
									<div class="row ">
                                        <div class="col-md-12">
                                            <h3 class="add-styl-rt">Select Size Dimension Combinations</h3>
                                            <hr>
                                        </div>
                                    </div>

                                    <div id="template">
                                    </div>
									
								</div>
                                <!-- pannel body ends -->
                            </c:if>
                            </div>
                        </div>
                    </div>
				 </div>

                <div class="clearfix"></div>
				<div class="row paddingleft20">
					<div class="col-sm-8 col-md-8 col-xs-8 marginTop30">
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

					<div id="submision" class="submit-button styl-rt-submission-btn pull-right marginRight10 marginTop30">
						<a class="disablebutton"> <button id="back1" disabled class="btn btn-default btn-lg">Back</button></a>
						<button class="btn btn-info btn-lg btn-embossed" onclick="saveCostSheet(1);">Next</button>
					</div>
				</div>
            </div>
            <!-- row ends -->
        </div>
        <!-- end of tab content 1 -->
		
		<div class="tab-pane " id="createGroups">
            <div class="row paddingleft20">
                <div class="col-sm-12 col-md-12">
                    <div class="panel-group" id="createGroups">
                        <div class="panel panel-default">
                            <div class="panel-heading" data-toggle="collapse" data-parent="#creatG" data-target="#creatG">
                                <h4 class="panel-title">
             						<a data-toggle="collapse" data-parent="#createGroups" href="#creatG"></a>
             						<a class="accordion-toggle">
             						 <span class="pull-right slideupdowntoggle glyphicon glyphicon-chevron-up"></span>Added Groups
             						</a>
            					</h4>
                            </div>
                            <div id="creatG" class="panel-collapse collapse" style="height: auto;">
                                <div class="panel-body">
                                    <div class="row">
                                        <div class="pull-right margin-addstyleroute">
                                            <div class="input-group custom-search-form " style="width: 390px;">
                                                <a onclick="hideGrid();showAddForm();createGroupGrid(-1);" class="btn btn-warning btn-embossed pull-right"><span class="glyphicon glyphicon-plus marginRight4"></span>Add Group</a>
                                            </div><!-- /input-group -->
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-12 col-md-12">
                                            <div class="dataTables_wrapper">
                                                <section>
                                                    <div id="addedGroupGrid"></div>
                                                </section>
                                            </div>
                                        </div>
                                    </div><!--  row ends  -->
                                </div><!-- panel body end  -->
                            </div>
                        </div>
                    </div>
                </div>
            </div><!-- end of row -->

            <div class="row paddingleft20">
                <div class="col-sm-12 col-md-12">
                    <div class="panel-group" id="cGroups">
                        <div class="panel panel-default">
                            <div class="panel-heading" data-toggle="collapse" data-parent="#createGroBody" data-target="#createGroBody">
                                <h4 class="panel-title">
									<a data-toggle="collapse" data-parent="#cGroups" href="#createGroBody"></a>
									<a class="accordion-toggle"> <span class="pull-right slideupdowntoggle glyphicon glyphicon-chevron-up"></span>Create Group</a>
								 </h4>
                            </div>
                            <div id="createGroBody" class="panel-collapse collapse" style="height: auto;">
                                <div class="panel-body">
                                    <div class="row paddingleft20">
                                        <div class="col-sm-6 col-md-6 pull-left">
                                            <div class="form-group formwithsearch marginbottom20">
                                                <div class="icon-addon addon-md">
                                                    <div class="col-sm-5 col-md-5 ">
                                                        <label for="exampleInputEmail1">Group Name:</label>
                                                    </div>
                                                    <div class="col-sm-7 col-md-7 ">
                                                        <input id="groupName" type="text" class="form-control" />
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="clearfix"></div>
                                            <div class="form-group formwithsearch marginbottom20">
                                                <div class="icon-addon addon-md">
                                                    <div class="col-sm-5 col-md-5 ">
                                                        <label for="exampleInputEmail1">Select Country:</label>
                                                    </div>
                                                    <div class="col-sm-7 col-md-7 ">

                                                        <select onfocus="fillSelectedCountry();" id="groupCountry" type="text" class="form-control"></select>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="clearfix"></div>
                                        </div>
										<div class="col-sm-6 col-md-6 pull-left">
                                            <div class="form-group formwithsearch marginbottom20">
                                                <div class="icon-addon addon-md">
                                                    <div class="col-sm-5 col-md-5 ">
                                                        <label for="exampleInputEmail1">Pre-Cost Sheet Number:</label>
                                                    </div>
                                                    <div class="col-sm-7 col-md-7 ">
                                                        <select id="grPreCostSheetNo" type="text" class="form-control"></select>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="clearfix"></div>
                                            <div class="form-group formwithsearch marginbottom20">
                                                <div class="icon-addon addon-md">
                                                    <div class="col-sm-5 col-md-5 ">
                                                        <label for="exampleInputEmail1"></label>
                                                    </div>
                                                    <div class="col-sm-7 col-md-7 ">
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="clearfix"></div>
                                        </div>
                                        <div class="clearfix"></div>
                                    </div><!-- ROW ENDS -->
                                    <div class="row">
                                        <div class="col-sm-12 col-md-12">
                                            <div class="dataTables_wrapper">
                                                <section>
                                                	<div id="groupGrid"></div>
                                                </section>
                                            </div>
                                        </div>
                                    </div><!-- row ends -->
                                    <div id="submision" class="submit-button styl-rt-submission-btn pull-right marginRight0 marginTop10">
                                        <button onclick="applyNewGroup();" class="btn btn-info btn-lg btn-embossed submitBtn">Save group</button>
                                    </div>
                                </div><!-- panel body end  -->
                            </div>
                        </div>
                    </div>
                </div>
            </div><!-- row ends -->

            <div class="row paddingleft20">
                <div class="col-sm-12 col-md-12 advance-comb ">
                    <a class="table_show_hide" onclick="generateMatrix('grid');" href="javascript:;"><span class="fa fa-chevron-right marginRight3"></span>View Group Combination</a>
                </div>
            </div>
            <!-- row ends -->

            <div class="row paddingleft20 showHideTable">
                <div class="col-sm-12 col-md-12">
                	<div id="grid"></div>
                </div>
            </div>
			<div class="row paddingleft20">
				<div class="col-sm-8 col-md-8 col-xs-8 marginTop30">
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
					<a> <button onclick="showBack(1);" class="btn btn-default btn-lg">Back</button></a>
					<button class="btn btn-info btn-lg btn-embossed" onclick="saveCostSheet(2);">Next</button>
				</div>
			</div>
        </div>
        <!-- tab pain two ends -->
		<div class="tab-pane " id="addRowMat">
			<form:errors path="*" cssClass="alert alert-danger alert-dismissable" element="div"/>
			<form:form commandName="mercostsheethdr" method="post" action="mercostsheethdrForm"  id="mercostsheethdrForm3" onsubmit="return validateMercostsheethdrForm(this)">
				<c:if test="${mststylecomponentList !=null}">
					<div class="row paddingleft20">
						<div class="col-sm-12 col-md-12">
							<div class="panel-group" id="rowMaterialScreen2">
								<div class="panel panel-default">
									<div class="panel-heading" data-toggle="collapse" data-parent="#rowMaterialScreen2" data-target="#rowMaterialScreenBody">
										<h4 class="panel-title">
											<a data-toggle="collapse" data-parent="#rowMaterialScreen2" href="#rowMaterialScreenBody"></a>
											<a class="accordion-toggle"> <span class="pull-right slideupdowntoggle glyphicon glyphicon-chevron-up"></span>Added Material Items</a>
										</h4>
									</div>
									<div id="rowMaterialScreenBody" class="panel-collapse collapse"  style="height: auto;">
										<div class="panel-body">
											<div class="row final_cost_sheet_AMI">
												<div class="col-sm-6 col-md-6 marginTop7">
													<ul class="nav nav-pills nav-pills-jq ">
														<li class="active">
															<script type="text/javascript">
																var itemtypecatogery=new Array();
															</script>
															<c:forEach items="${mstitemtypeCatogory}" var="mstitemtypecatogory">
																<a onclick="navigterowMat('${mstitemtypecatogory}','');if( !document.getElementById('compWiseCost').value && document.getElementById.value('averageWiseCost').value)getchusen()">${mstitemtypecatogory} <span class="badge" id="bage${mstitemtypecatogory}"></span></a></li><li>
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

											<div class="col-sm-4 col-md-4 col-xs-4 pull-left padding0 margintop20" id="bulkActions" style="display:none">


												<select id="bulk_actions" type="text" class="form-control pull-left floatedTextbox ">
													<option value="0">Bulk Actions</option>
													<option value="1">Add to all groups</option>
													<option value="2">Add to Selected Groups</option>
												</select>

												<button onclick="bulkActions();" type="button" class="btn btn-info btn-embossed marginLeft10 pull-left">Apply</button>
											</div>

										</div>
									</div>
								</div>
							</div>

						</div>
					</div>
					<!-- END OF ROW-->

					<div class="row paddingleft20">
						<div class="col-sm-12 col-md-12">
							<div class="panel-group" id="pannel2">
								<div class="panel panel-default" >
									<div class="panel-heading" data-toggle="collapse" data-parent="#pannel2" data-target="#pannel2Body">
									  <h4 class="panel-title">
									  <a data-toggle="collapse"   data-parent="#pannel2" href="#pannel2Body"  > 
										 </a><a class="accordion-toggle"> <span class="pull-right slideupdowntoggle glyphicon glyphicon-chevron-up"></span>Added Raw Material Screen</a>  
									</h4>
									</div>
									<div id="pannel2Body" class="panel-collapse collapse in" style="height: auto;">
										<div class="panel-body" id="pannel2Body2">
										
											<div id="detailsrawmat"> 
												<div class="col-sm-4 col-md-4 ">
													<div class="form-group formwithsearch marginbottom20">
														<div class="icon-addon addon-md">
															<label for="exampleInputEmail1">Item Type</label>
															<select type="text" onblur ="inputenbler('ordersheet','itemType')" onchange="inputenbler('costsheet','itemType')" class="form-control" name="itemType" id="itemType"  onfocus="getOptions('itemType','mstitemtype')"></select>
															
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
															<select disabled type="text" onchange="getOptions('itemDescription','mstitem')"  class="form-control" id="itemCode"  name="itemCode" onfocus="getOptions('itemCode','mstitem')" ></select>
															
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
															<input type="text" readonly="readonly" class="form-control" id="itemDescription" name="itemDecription"> 
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
															<input type="text" class="form-control" name="itemWidth" id="itemWidth">
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
															<select type="text" class="form-control" id="shipingType" name="shipingType">
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
															<select type="text" class="form-control" id="currency" name="currency" onfocus="getOptions('currency','mstcurrency')"></select>
															
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
															<input onkeypress="return IsNumericdecimal(event,this.id)" ondrop="return false;" onpaste="return false;"  type="text" class="form-control" name="exchangeRate" id="exchangeRate">
															<span id="errorexchangeRate" style="color: Red; display: none">* Input digits (0 - 9)</span>
														</div>
													</div>  
													<div class="clearfix"></div> 
												</div>
												<div class="col-sm-4 col-md-4 ">
													<div class="form-group formwithsearch marginbottom20">
														<div class="icon-addon addon-md">
															<label for="exampleInputEmail1">Price </label>
															<input type="text" onkeypress="return IsNumericdecimal(event,this.id)" ondrop="return false;" onpaste="return false;" class="form-control" id="price" name="price">
															<span id="errorprice" style="color: Red; display: none">* Input digits (0 - 9)</span>
														</div>
													</div> 
													<div class="clearfix"></div> 
												</div>
												<div class="col-sm-4 col-md-4 ">
													<div class="form-group formwithsearch marginbottom20">
														<div class="icon-addon addon-md">
															<label for="exampleInputEmail1">Finance % </label>
															<input  onkeypress="return IsNumericdecimal(event,this.id)" ondrop="return false;" onpaste="return false;" type="text" class="form-control" id="finance" name="finance">
															<span id="errorfinance" style="color: Red; display: none">* Input digits (0 - 9)</span>
														</div>
													</div>  
													<div class="clearfix"></div> 
												</div>
											</div>
											
											<div class="dataTables_wrapper margintop20">
												  <section>
													  <table id="grouprawmatroute" class="display table table-striped table-bordered" cellspacing="0">
														  <thead>
														  	<tr>
															  	<th id="grpall" class="textcenter"><input type="checkbox" onchange="checkallg()" class="margin0 thCheckboxWidth"></th>
															  	<th class="textcenter">Group Name</th>
															  	<th class="textcenter">Country</th>
															  	<th class="textcenter">Advance Combination</th>
														  	</tr>
														  </thead>
														  <tbody id="grouprawmat">
														  
														  </tbody>
													  </table>
												  </section>
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
															  <th class="textcenter">Groups</th> 
															  <th class="textcenter">Consumption</th> 
															  <th class="textcenter">UMO</th>
															  <th class="textcenter">Allowance %</th>
															</tr>
														</thead>
														<tbody id="tbodyConsumption">
															<c:forEach items="${mststylecomponentList}" var="mststylecomponent">
																<tr class="gradeX" id="contr${mststylecomponent.id.componentId}">
																	<td><div tabindex="15" class="icon-addon addon-md">${mststylecomponent.id.componentId}</div></td>
																	<td class="textcenter fcstdChosen">
																		<select id="${mststylecomponent.id.componentId}_group" data-placeholder="Select Color"  class="chosen-select" multiple style="width:100%;" tabindex="4">
																			<option value=""></option>
																		</select>
																	</td>
																	<td>
																		<div class="icon-addon addon-md">
																			<input onkeypress="return IsNumeric(event,this.id)" ondrop="return false;" onpaste="return false;" required="required"  type="text" id ="${mststylecomponent.id.componentId}com_consumption" class="form-control" value=""/>
																			<span id="error${mststylecomponent.id.componentId}com_consumption" style="color: Red; display: none">* Input digits (0 - 9)</span>
																		</div>
																	</td>
																	<td>
																		<div class="icon-addon addon-md">
																			<select required="required" id ="${mststylecomponent.id.componentId}_UOM" class="form-control" onfocus="optionsforgencodes('${mststylecomponent.id.componentId}_UOM','UOM');"></select>
																		</div>
																	</td>
																	<td>
																		<div class="icon-addon addon-md">
																			<input onkeypress="return IsNumericdecimal(event,this.id)" ondrop="return false;" onpaste="return false;"  required="required"  type="text" id ="${mststylecomponent.id.componentId}com_allowance" class="form-control" value=""/>
																			<span id="error${mststylecomponent.id.componentId}com_allowance" style="color: Red; display: none">* Input digits (0 - 9)</span>
																		</div>
																	</td>																										
																</tr>	
																<script>
																	getchusen('${mststylecomponent.id.componentId}');
																</script>
															</c:forEach>
														</tbody>
													</table>
												</section>
											</div>								
											<div id="submision" class="submit-button styl-rt-submission-btn pull-right marginRight0 marginTop30">
												<a><button type="button" onclick="clear_form_elements(this.form);" class=" btn btn-default btn-lg">Clear All</button></a>
												<button  type="button" onclick="savecostsheets('COST2')" class="btn btn-info btn-lg btn-embossed submitBtn" id="rowsubmit">Submit</button>
												<button  type="button" style="display: none;" onclick="savecostsheets('COST22')" class="btn btn-info btn-lg btn-embossed submitBtn" id="rowUpdate">Update</button>
											</div>
										</div> <!-- pannel body ends -->
									</div>
								</div> 
							</div>
						</div>
					</div>
					<div class="row paddingleft20">
						<div class="col-sm-12 col-md-12 margintop20">
							<div class="panel-group" id="stylebrowser3">
								<div class="panel panel-default">
									<div class="panel-heading" data-toggle="collapse"   data-parent="#rawmaterialgrid" data-target="#rawmaterialgrid"  >
										<h4 class="panel-title">
											<a data-toggle="collapse" data-parent="#stylebrowser3" href="#rawmaterialgrid"> </a>
											<a class="accordion-toggle"> <span class="pull-right slideupdowntoggle glyphicon glyphicon-chevron-up"></span> Added Raw Material Items to Cost Groups:</a>
										</h4>
									</div>
									<div id="rawmaterialgrid" class="panel-collapse collapse out" style="height: auto;">
										<div class="panel-body">
											<div class="row">
												<div class="pull-right margin-addstyleroute">
													<div class="input-group custom-search-form " style="width: 290px;">
														<input type="text" class="form-control" placeholder="Search and Filter">
														<span class="input-group-btn">
														  <button class="btn btn-info search-form-btn" type="button">
															  <span class="glyphicon glyphicon-search"></span>
														</button>
														</span>
													</div>

												</div>
											</div>

										</div>
									</div>

									<div class="row paddingleft20">
										<div class="col-md-12">
											<div class="dataTables_wrapper Scroll-for-datatable-add-row-matirials">
												<section class="marginRight384 adedclass">
													<table data-page-navigation=".pagination"  id="route" class="display table table-striped table-bordered" cellspacing="0">
														<thead>
															<tr>
																<th class="textcenter">Cost Group</th>
																<th class="textcenter">Component </th>
																<th class="textcenter">Item Type</th>
																<th class="textcenter">Item Code</th>
																<th class="textcenter">Item Description</th>
																<th class="textcenter">Color</th>
																<th class="textcenter">Width</th>
																<th class="textcenter">Imp / Local</th>
																<th class="textcenter">Supplier</th>
																<th class="textcenter">Consumption</th>
																<th class="textcenter">UOM</th>
																<th class="textcenter">Allow %</th>
																<th class="textcenter">Currency</th>
																<th class="textcenter">Exchange Rate</th>
																<th class="textcenter">Price</th>
																<th class="textcenter">Item Amount</th>
																<th class="textcenter">Finance %</th>
																<th class="textcenter">Finance Amount</th>
																<th class="textcenter">Stock UOM</th>
																<th class="textcenter">Cons. in Stock UOM</th>
																<th class="textcenter">Price in Stock UOM</th>
																<th class="textcenter headcol2 opensnew">Open as new</th>
																<th class="textcenter headcol3 openaction">Actions</th>
															</tr>
														</thead>
														<tbody id="grouprowMaterialScreen">
																							
														</tbody>
													</table>
												</section>
											</div>
										</div>
									</div>
								</div>
								<div class="row paddingleft20">
									<div class="col-sm-12 col-md-12 margintop20">
										<div class="panel-group" id="stylebrowser2">
											<div class="panel panel-default">
												<div class="panel-heading" data-toggle="collapse"   data-parent="#otherCostingPannel" data-target="#otherCostingPannel"  >
													<h4 class="panel-title">
														<a data-toggle="collapse" data-parent="#stylebrowser2" href="#otherCostingPannel"> </a>
														<a class="accordion-toggle"> <span class="pull-right slideupdowntoggle glyphicon glyphicon-chevron-up"></span> Other Costing Details</a>
													</h4>
												</div>
												<div id="otherCostingPannel" class="panel-collapse collapse in" style="height: auto;">
													<div class="panel-body">
														<form action="" method="POST" id="Othercostindg"> 
															<div class="row paddingleft20">
																<div class="col-sm-4 col-md-4 ">
																<spring:bind path="mercostsheethdr.baseBody">
																	<div class="formwithsearch marginbottom20 form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
																</spring:bind>
																		<div class="icon-addon addon-md">
																			<appfuse:label key="mercostsheethdr.baseBody" styleClass="control-label exampleInputEmail1"/>
																			<select required="required" type="text" name="baseBody" id="baseBody" onfocus="optionsforgencodes('baseBody','BASBOD')" class="form-control" >
																				<option selected="selected">${mercostsheethdr.baseBody}</option>
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
																<spring:bind path="mercostsheethdr.buyerReference">
																	<div class="formwithsearch marginbottom20 form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
																</spring:bind>
																		<div class="icon-addon addon-md">
																			<appfuse:label key="mercostsheethdr.buyerReference" styleClass="control-label exampleInputEmail1"/>
																			<input type="text"  name="buyerReference" value="${mercostsheethdr.buyerReference}" id="buyerReference" class="form-control">								
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
														</form>	
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
													</div> <!-- panel body end  -->
												</div>
											</div>
										</div> <!-- pannel group ends -->
									</div> 
								</div> 
								<div class="row paddingleft20">
									<div class="col-sm-8 col-md-8 col-xs-8 marginTop30">
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
										<a> <button onclick="showBack(2);" class="btn btn-default btn-lg">Back</button></a>
										<button class="btn btn-info btn-lg btn-embossed" onclick="showBack(4)">Next</button>
									</div>
								</div>
							</div>
						</div>
					</div>
				</c:if>
			</form:form>
		</div>
        <!-- tab pain three ends -->
		
		<div class="tab-pane " id="creatGCsheet">
            <div class="row paddingleft20">
                <div class="col-sm-12 col-md-12">
					<div class="panel-group" id="stylebrowser3">
						<div class="panel panel-default">
							<div class="panel-heading" data-toggle="collapse" data-parent="#stylebrowser3" data-target="#styleBrowserBody3">
								<h4 class="panel-title">
                                  <a data-toggle="collapse" data-parent="#stylebrowser3" href="#styleBrowserBody3">
                                  </a><a class="accordion-toggle"> <span class="pull-right slideupdowntoggle glyphicon glyphicon-chevron-up"></span>Prepare Genaral Cost Sheet</a>
								</h4>
							</div>
							<div id="styleBrowserBody3" class="panel-collapse collapse " style="height: auto;">
								<form  method="post" action="mercostsheethdrForm"  id="mercostsheethdrForm4" onsubmit="return validateMercostsheethdrForm(this)">
									<div class="panel-body">
										<div id="divSelectGroup">
											<div class="row" >
												<div class="col-sm-4 col-md-4 ">
													<div class="form-group formwithsearch marginbottom20">
														<div class="icon-addon addon-md">
															<label for="exampleInputEmail1">Select Group </label>
															<select type="text" name="SelectGroup" id="SelectGroup" class="form-control" onchange="getGroupVsCosting(this.value)" onfocus="getOptions(this.id)"></select>
														</div>
													</div>
												</div>
											</div><hr>
										</div>
										<div id="divSelectGroup2">
											<div class="row" >
												<div class="col-sm-4 col-md-4 ">
													<div class="form-group formwithsearch marginbottom20">
														<div class="icon-addon addon-md">
															<label for="exampleInputEmail1">Select Group </label>
															<input name="SelectGroup2" id="SelectGroup2" class="form-control" readonly/>
														</div>
													</div>
												</div>
											</div><hr>
										</div>
										<div class="col-md-12"><h3 class="add-styl-rt">Cost Details: </h3><hr></div>

										<div class="col-sm-4 col-md-4 ">
											<div class="form-group  formwithsearch marginbottom20">
												<div class="icon-addon addon-md">
													<appfuse:label key="merprecostsheet.rowMaterialValue" styleClass="control-label exampleInputEmail1"/>
													<input type="text" class="form-control"  id="raw_material_cost" name-="rowMaterialValue" readonly>
												</div>
											</div> 
											<div class="clearfix"></div> 

											<div class="clearfix"></div>

											<div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''} formwithsearch marginbottom20">
												<div class="icon-addon addon-md">
													<appfuse:label key="merprecostsheet.cm" styleClass="control-label exampleInputEmail1"/>
													<input type="text" class="form-control" id="CM" name="cm" readonly>
												</div>
											</div>
											<div class="clearfix"></div>


										</div>

										<div class="col-sm-4 col-md-4 ">
											<div class="form-group formwithsearch marginbottom20">
												<div class="icon-addon addon-md">
													<appfuse:label key="merprecostsheet.serviceValue" styleClass="control-label exampleInputEmail1"/>
													<input type="text" class="form-control" id="services_cost"    name="serviceValue" readonly>
												</div>
											</div>  
											<div class="clearfix"></div> 

											<div class="form-group formwithsearch marginbottom20">
												<div class="icon-addon addon-md">
													<appfuse:label key="merprecostsheet.financeCost" styleClass="control-label exampleInputEmail1"/>
													<input type="text" class="form-control" id="finance_cost" name="financeCost" readonly>
												</div>
											</div>

											<div class="clearfix"></div>
										</div>
										<div class="col-sm-4 col-md-4">
											<div class="formwithsearch marginbottom20 form-group">
												<div class="icon-addon addon-md">
													<label for="exampleInputEmail1">CMT</label>
													<input type="text" class="form-control"  id="CMT" name="cmt" readonly>
												</div>
											</div> 

											<div class="clearfix"></div>

											<div class="formwithsearch marginbottom20 form-group">
												<div class="icon-addon addon-md">
													<appfuse:label key="merprecostsheet.totalCost" styleClass="control-label exampleInputEmail1"/>
													<input type="text" class="form-control extraBorder" name="totalCost" id="total_cost" readonly>
												</div>
											</div> 

										</div>

										<div class="col-md-12"><h3 class="add-styl-rt">Pricing </h3><hr></div>

										<div class="col-sm-4 col-md-4">
											<div class="form-group formwithsearch marginbottom20">
												<div class="icon-addon addon-md">
													<label for="exampleInputEmail1">Mark up amount</label>
													<div class="clearfix"></div>
													<div class="row">
													<div class="col-sm-7 col-md-7">
														<div class="input-group">
															<input onkeypress="return IsNumericdecimal(event,this.id)" ondrop="return false;" onpaste="return false;"  type="text" id="markupV" name="markupAmount" onblur="refigercost('markupV')" type="text" class="form-control">
															<span id="errormarkupV" style="color: Red; display: none">* Input digits (0 - 9)</span>
														</div>
													</div>
													<div class="col-sm-5 col-md-5">
														<div class="input-group">
															<input onkeypress="return IsNumericdecimal(event,this.id)" ondrop="return false;" onpaste="return false;" type="text"   id="markupP" onblur="refigercost('markupP')"  class="form-control paddingRight5">
															<span class="input-group-addon paddingBottom7">%</span>
															<span id="errormarkupP" style="color: Red; display: none">* Input digits (0 - 9)</span>
														</div>
													</div>
													</div>
												</div>
											</div>
										</div>

										<div class="col-sm-4 col-md-4">
											<div class="form-group formwithsearch marginbottom20">
												<div class="icon-addon addon-md">
													<label for="exampleInputEmail1">Buyer commission</label>
													<div class="clearfix"></div>
													<div class="row">
														<div class="col-sm-7 col-md-7">
															<div class="input-group">
																<input onblur="refigercost('buyer_commissionV')" id="buyer_commissionV"  onkeypress="return IsNumericdecimal(event,this.id)" ondrop="return false;" onpaste="return false;" type="text" name="buyerCommission" type="text" class="form-control">
																<span id="errorbuyer_commissionV" style="color: Red; display: none">* Input digits (0 - 9)</span>
															</div>
														</div>
														<div class="col-sm-5 col-md-5">
															<div class="input-group">
																<input onblur="refigercost('buyer_commissionP')" id="buyer_commissionP" onkeypress="return IsNumericdecimal(event,this.id)" ondrop="return false;" onpaste="return false;" type="text" class="form-control paddingRight5">
																<span class="input-group-addon paddingBottom7">%</span>
																<span id="errorbuyer_commissionP" style="color: Red; display: none">* Input digits (0 - 9)</span>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>

										<div class="col-sm-4 col-md-4">
											<div class="form-group formwithsearch marginbottom20">
												<div class="icon-addon addon-md">
													<label for="exampleInputEmail1">Our price</label>
													<input onkeypress="return IsNumericdecimal(event,this.id)" ondrop="return false;" onpaste="return false;" type="text" class="form-control" id="our_price" name="ourPrice" readonly>
													<span id="errorour_price" style="color: Red; display: none">* Input digits (0 - 9)</span>
												</div>
											</div>
										</div>
										<div class="clearfix"></div>

										<div class="col-sm-4 col-md-4">
											<div class="form-group formwithsearch marginbottom20">
												<div class="icon-addon addon-md">
													<label for="exampleInputEmail1">External commission</label>
													<div class="clearfix"></div>
													<div class="row">
														<div class="col-sm-7 col-md-7">
															<div class="input-group">
																<input onblur="refigercost('external_commissionV')" id="external_commissionV" name="externalCommission" onkeypress="return IsNumericdecimal(event,this.id)" ondrop="return false;" onpaste="return false;" type="text" class="form-control">
																<span id="errorexternal_commissionV" style="color: Red; display: none">* Input digits (0 - 9)</span>
															</div>
														</div>
														<div class="col-sm-5 col-md-5">
															<div class="input-group">
																<input onblur="refigercost('external_commissionP')" id="external_commissionP" onkeypress="return IsNumericdecimal(event,this.id)" ondrop="return false;" onpaste="return false;" type="text" class="form-control paddingRight5">
																<span class="input-group-addon paddingBottom7">%</span>
																<span id="errorexternal_commissionP" style="color: Red; display: none">* Input digits (0 - 9)</span>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>

										<div class="col-sm-4 col-md-4">
											<div class="form-group formwithsearch marginbottom20">
												<div class="icon-addon addon-md">
													<label for="exampleInputEmail1">Selling price</label>
													<input id="selling_price" name="sellingPrice" onblur="refigercost('selling_price')" onkeypress="return IsNumericdecimal(event,this.id)" ondrop="return false;" onpaste="return false;" type="text" class="form-control">
													<span id="errorselling_price" style="color: Red; display: none">* Input digits (0 - 9)</span>
												</div>
											</div>
										</div>
										<div class="clearfix"></div>


										<div class="col-sm-4 col-md-4 pull-right ">
											<button onclick="showBack(5)" type="button" class="btn btn-info btn-embossed pull-right marginRight55"> Calculate Selling Price</button>
										</div>
									</div> <!-- pannel body ends -->
								</form>
							</div>
						</div>
					</div>

				</div>
            </div>

            <div class="row paddingleft20">
                <div class="col-md-12">
                    <h3 class="add-styl-rt">Varient Analysis</h3>
                    <hr>
                </div>
            </div>

            <div class="row paddingleft20">
                <div class="col-md-12">
                    <div class="dataTables_wrapper Scroll-for-datatable-add-row-matirials">
                        <section class="marginRight402" id="varitbody">
                            
                        </section>
                    </div>
                </div>
            </div>
            <div class="clearfix"></div>
			<div class="row paddingleft20">
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
					<a> <button onclick="showBack(3);" class="btn btn-default btn-lg">Back</button></a>
					<button class="btn btn-info btn-lg btn-embossed" onclick="conformation()">Save</button>
				</div>
			</div>
        </div>
        <!-- tab pain four ends -->
		
    </div>
    <!-- Main container end  -->

    <div id="model_popup_size_diemention" class="modal fade drop-down-select-model-pop model-popup-fix addedFCS" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg">
            <div class="modal-content model-popup-padding">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">x</span><span class="sr-only">Close</span>
                    </button>
                    <h5 class="modal-title">Set Size Dimensions</h5>
                </div>
                <div id="submision" class="submit-button styl-rt-submission-btn pull-right marginRight0 marginTop30">
                    <a>
                        <button id="back3" class="btn btn-default btn-lg">Refresh</button>
                    </a>
                    <button class="btn btn-info btn-lg btn-embossed">Confirm</button>
                </div>

                <div class="clearfix"></div>

            </div>
        </div>
    </div>
    <!-- drop-down-select-model pop up end -->

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
                        <h3 class="add-styl-rt">Select Size Dimensions Combinations</h3>
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
    
    <!-- drop-down-select-model pop up end -->
    
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
		console.info("ffffffffffffff");
		$( "#destination_country_chosen" ).click(function() {
			$('.chosen-select').trigger('chosen:updated');
		
		});
		/* $( ".default" ).click(function() {
		 $('.chosen-select').trigger('chosen:updated')
		}); */
		
		initComponent();
		var day=new Date();

		initTemplate();
		
		document.getElementById("createdOn").value=(day.getMonth()+1)+"/"+day.getDate() +"/"+day.getFullYear();
		
		<c:if test="${mststylecomponentList !=null}">	
			optionsforgencodes('destination_country','CONTRY');		
			if(currencyMethod=="Static")
				addcurrencytable();
			<c:forEach items="${mercostsheethdrcurrencyList}" var="mercostsheethdrcurrency">
				var curcode="${mercostsheethdrcurrency.id.currencyCode}";
				var currate="${mercostsheethdrcurrency.exchangeRate}";
				creartcurtable(curcode,currate)
			</c:forEach>	
			<c:if test="${merprecostsheet.createdOn==null}">
				var day=new Date();
				document.getElementById("createdOn").value=(day.getMonth()+1)+"/"+day.getDate() +"/"+day.getFullYear();
			</c:if>
			
			$("input[type='text']:visible:enabled:first", document.forms['merprecostsheetForm']).focus();
		</c:if>
		<c:forEach items="${mercostsheethdrsmvList}" var="mercostsheethdrsmv">	
				var styleRouteId="${mercostsheethdrsmv.id.styleRouteId}";
				var styleRouteName="${mercostsheethdrsmv.styleRouteId.styleRouteName}";
				var ratio="${mercostsheethdrsmv.ratio}";
				var routeLocation="${mercostsheethdrsmv.styleRouteId.assignLocation}";
				var lineEfficency="${mercostsheethdrsmv.lineEfficency}";
				var fmvCategory="${mercostsheethdrsmv.fmvCategory}";
				var fmv="${mercostsheethdrsmv.fmv}";
				var smv="${merprecostsheetsmv.styleRouteId.totalSMV}";
				addsmv(styleRouteId,ratio,routeLocation,styleRouteName,lineEfficency,fmvCategory,fmv,smv); 
			</c:forEach>
		<c:if test="${param.section=='COST1'}">
			if(document.getElementById("compWiseCost").checked){
				 $("#compvscostCon1").hide();
				 $("#compvscostCon2").show();
			 }
			 else{
				 $("#compvscostCon2").hide();
				 $("#compvscostCon1").show();
				 addcomvscost1("compvscostCon1");
			 }
			for(var i=itemtypecatogery.length-1;i>-1;i--){
				 navigterowMat(itemtypecatogery[i]);
				 console.log(itemtypecatogery[i]);
			}
			 selecteditemcategory=itemtypecatogery[0];
			 precostsheetnavigation("profile");
			 document.getElementById('nprofile').className="active";
		</c:if>
		

		
		<c:if test="${param.OpenAs=='true'}">
		document.getElementById("costSheetNo").value="";
		document.getElementById("pannel2Body2").style.display="none";
		</c:if>
	

	});
</script>

<script>

	var groups = "${groups}";
	makeGroupArray(groups);

</script>