<%@ include file="/common/taglibs.jsp" %>

<head>
    <title><fmt:message key="mststyleheaderDetail.title"/></title>
    <meta name="heading" content="<fmt:message key='mststyleheaderDetail.heading'/>"/>
</head>
<script type="text/javascript" src="scripts/applicationjs/mststylehdr.js"> </script>
<c:set var="delObject" scope="request">
	<fmt:message key="mststyleheaderList.mststyleheader"/></c:set>
<script type="text/javascript">var msgDelConfirm =
   "<fmt:message key="delete.confirm"><fmt:param value="${delObject}"/></fmt:message>";
</script>



	<%-- <div class="col-sm-2">
		<h2><fmt:message key="mststyleheaderDetail.heading"/></h2>
		<fmt:message key="mststyleheaderDetail.message"/>
	</div> --%>
	<div id="styleHeadderadd">
		<div id="page-content-wrapper" class="container" > <!--MAIN CONTENT-->
			<div class="row marginTop10" id="wizard">
				<div class="col-xs-8"><h2>
					<c:if test="${mststyleheader.id.styleId == null}"><fmt:message key="mststyleheader.titleAdd"/></c:if>
					<c:if test="${mststyleheader.id.styleId != null}"><fmt:message key="mststyleheader.titleEdit"/></c:if></h2>
				</div>
				<div class="col-xs-4 hrline">
					<ul class="nav nav-justified setup-panel">
						<li class="active">
							<a href="#step-1">
								<button id="sec1" type="button" class="btn btn-default btn-circle">
									<span class="glyphicon glyphicon-th-list"></span>
								</button>
								<p class="list-group-item-text">General Details</p>
							</a>
						</li>
						<li id="step2-btn"  class="disabled">
							<a href="#step-2">
								<button id="sec2" type="button" class="btn btn-default btn-circle" >
									<span class="glyphicon glyphicon-th-large"></span>
								</button>
								<p class="list-group-item-text">Components & Colors</p>
							</a>
						</li>
						<li  id="step3-btn" class="disabled">
							<a href="#step-3">
								<button id="sec3" type="button" class="btn btn-default btn-circle" >
									<span class="glyphicon glyphicon-fullscreen">
								</button>
								<p class="list-group-item-text">Size Dimensions </p>
							</a>
						</li>
					</ul>
				</div>
			</div>
			
			
			<!-- disabled='disabled' -->
			<form:errors path="*" cssClass="alert alert-danger alert-dismissable" element="div"/>
			<form:form commandName="mststyleheader" method="post" action="mststyleheaderform" id="mststyleheaderform" >
			<div class="setup-content" id="step-1"> <!-- General Details Page -->
				
				<div class="row"> <!--View Page start-->
					<div class="col-sm-12 col-md-12">
						<h3 class="marginbottom5">General Details</h3>
						<hr>
					</div>
				</div>
				<div>
					<div class="row" >
						<div class="col-md-4">
							<spring:bind path="mststyleheader.id.locationCode">
							<div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''} formwithsearch">
							</spring:bind>
							<appfuse:label key="mststyleheader.locationCode" styleClass="control-label"/>
									<c:if test="${mststyleheader.id.locationCode == null}">
										<select required="true" tabindex="1"  Class="form-control" id="sid_locationCode" name="id.locationCode" path="id.locationCode" onfocus="getOptions('sid_locationCode','mstlocations')">
											<%-- <option  selected="selected" >${mststyleheader.id.locationCode}</option> --%>
											<c:forEach items="${mstparam}" var="mstparams">
												<c:if test="${mststyleheader.id.locationCode == null}">
													<option selected="selected">${mstparams.locationCode}</option>
												</c:if>
											</c:forEach>
											<c:if test="${mststyleheader.id.locationCode != null}">
												<option selected="selected">${mststyleheader.id.locationCode}</option>
											</c:if>
											
										</select>
										<c:set var="disabledparams" scope="session" value=""/>
									</c:if>
									
									<c:if test="${mststyleheader.id.locationCode != null}">
										<input readonly="readonly" Class="form-control" id="sid_locationCode" name="id.locationCode" path="id.locationCode" value="${mststyleheader.id.locationCode}"/>  
										<c:set var="disabledparams" scope="session" value="disabled='disabled'"/>
									</c:if>
									
									<div class="feedback"></div>
				          	</div>
				          	<div class="btn-group formsearchbtn btn-model-select-div">
								<button ${disabledparams} onclick="$('#sid_locationCode').trigger('onfocus');addmodalpopup('sid_locationCode');" type="button" class="btn btn-primary btn-xs dropdown-toggle " data-toggle="modal" data-target="#schmodalpopup" ><span class="glyphicon glyphicon-search"></span></button>
							</div>
							<div class="clearfix"></div>
							
							<spring:bind path="mststyleheader.id.custCode">
							<div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''} formwithsearch">
							</spring:bind>
									<appfuse:label key="mststyleheader.custCode" styleClass="control-label"/>
									<c:if test="${mststyleheader.id.custCode == null}">
										<select required="true"  tabindex="4" Class="form-control" id="sid_custCode" name="id.custCode" path="id.custCode" onfocus="getOptions('sid_custCode','mstcustomer')">
											<option  >${mststyleheader.id.custCode}</option>
										</select>
										<c:set var="disabledparams" scope="session" value=""/>
									</c:if>
									
									<c:if test="${mststyleheader.id.custCode != null}">
										<input readonly="readonly" Class="form-control" id="sid_custCode" name="id.custCode" path="id.custCode" value="${mststyleheader.id.custCode}"/>  
										<c:set var="disabledparams" scope="session" value="disabled='disabled'"/>
									</c:if>
									
									<div class="feedback"></div>
							</div>
							<div class="btn-group formsearchbtn btn-model-select-div">
								<button ${disabledparams} onclick="$('#sid_custCode').trigger('onfocus');addmodalpopup('sid_custCode');" type="button" class="btn btn-primary btn-xs dropdown-toggle " data-toggle="modal" data-target="#schmodalpopup" ><span class="glyphicon glyphicon-search"></span></button>
							</div>
							<div class="clearfix"></div>   
							
							<spring:bind path="mststyleheader.id.styleId">
							<div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''} formwithsearch">
							</spring:bind>
									<appfuse:label key="mststyleheader.styleId" styleClass="control-label"/>
									<c:if test="${mststyleheader.id.styleId == null}">
										<input value="${mststyleheader.id.styleId}" tabindex="5"   onkeypress="return CheckNumeric(event)" ondrop="return false;" onpaste="return false;" class="form-control" name="id.styleId"  required="true" id="sid_styleId" maxlength="10" style="text-transform:uppercase;" onkeyup="this.value=removeSpaces(this.value);this.value=this.value.toUpperCase();" onblur="getstylecheaker()"/>
										<c:set var="disabledparams" scope="session" value=""/>
									</c:if>
									
									<c:if test="${mststyleheader.id.styleId != null}">
										<input value="${mststyleheader.id.styleId}" readonly="readonly"  class="form-control" name="id.styleId"  required="true" id="sid_styleId" maxlength="10" style="text-transform:uppercase;" />
										<c:set var="disabledparams" scope="session" value="disabled='disabled'"/>
									</c:if>

								
								<div class="feedback"></div>
							</div>
							<div class="clearfix"></div>
							
							<spring:bind path="mststyleheader.costSheetMethod">
							<div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''} formwithsearch">
							</spring:bind>
								<appfuse:label key="mststyleheader.costSheetMethod" styleClass="control-label"/>
								 <select Class="form-control" tabindex="7"  id="costSheetMethod" name="costSheetMethod" path="costSheetMethod">
									<c:if test="${ mststyleheader.costSheetMethod !='Size Wise' }">
										<option  selected="selected" Value="Average" >Average</option>
										<option  Value="Size Wise" >Size Wise</option>
									</c:if>
									<c:if test="${ mststyleheader.costSheetMethod =='Size Wise' }">
										<option  Value="Average" >Average</option>
										<option selected="selected" Value="Size Wise" >Size Wise</option>
									</c:if>
								</select>
								
								<div class="feedback"></div>
							</div>
							<div class="clearfix"></div> 
	
							<spring:bind path="mststyleheader.productRange">
							<div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''} formwithsearch">
							</spring:bind>
									<appfuse:label key="mststyleheader.productRange" styleClass="control-label"/>
									<select id="productRange" tabindex="9" name="productRange" class="form-control"  path="productRange" onfocus="optionsforgencodes('productRange','')">
										<option selected="selected" >${mststyleheader.productRange}</option>
									 </select>
									 
									<div class="feedback"></div>

							</div>
							<div class="btn-group formsearchbtn btn-model-select-div">
								<button  onclick="$('#productRange').trigger('onfocus');addmodalpopup('productRange');" type="button" class="btn btn-primary btn-xs dropdown-toggle " data-toggle="modal" data-target="#schmodalpopup" ><span class="glyphicon glyphicon-search"></span></button>
							</div>
							<div class="clearfix"></div>
	
							<spring:bind path="mststyleheader.packingMethod">
							<div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''} formwithsearch">
							</spring:bind>
									<appfuse:label key="mststyleheader.packingMethod" styleClass="control-label"/>
									<select id="packingMethod" tabindex="11" name="packingMethod" class="form-control" path="packingMethod" onfocus="optionsforgencodes('packingMethod','')" >
										<option selected="selected" >${mststyleheader.packingMethod}</option>										
									 </select>
									 
									<div class="feedback"></div>
							</div>
							<div class="btn-group formsearchbtn btn-model-select-div">
								<button onclick="$('#packingMethod').trigger('onfocus');addmodalpopup('packingMethod');" type="button" class="btn btn-primary btn-xs dropdown-toggle " data-toggle="modal" data-target="#schmodalpopup" ><span class="glyphicon glyphicon-search"></span></button>
							</div>	
							<div class="clearfix"></div>
										
							<spring:bind path="mststyleheader.comments">
							<div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''} formwithsearch">
							</spring:bind>
								<appfuse:label key="mststyleheader.comments" styleClass="control-label"/>
								<form:input cssClass="form-control" tabindex="13" path="comments" id="comments"  maxlength="255"  />
								<div class="feedback"></div>
							</div>
							<div class="clearfix"></div>  
						
						</div>
						<div class="col-md-4">
							<spring:bind path="mststyleheader.id.depCode">
							<div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''} formwithsearch">	
							</spring:bind>
									<appfuse:label key="mststyleheader.depCode" styleClass="control-label"/>
								 	<c:if test="${mststyleheader.id.depCode == null}">
										<select required="true" tabindex="2"  id="sid_depCode" name="id.depCode" class="form-control" path="id.depCode"  onfocus="optionsforgencodes('sid_depCode','')">
								 			<option selected="selected" >${mststyleheader.id.depCode}</option>	
										</select>
										<c:set var="disabledparams" scope="session" value=""/>
									</c:if>
									
									<c:if test="${mststyleheader.id.depCode != null}">
										<input readonly="readonly"  id="sid_depCode" name="id.depCode" class="form-control" path="id.depCode" value="${mststyleheader.id.depCode}"/>  
										<c:set var="disabledparams" scope="session" value="disabled='disabled'"/>
									</c:if>
								 	
								 	
									
						 			<div class="feedback"></div>		
							</div>
							<div class="btn-group formsearchbtn btn-model-select-div">
								<button ${disabledparams} onclick="$('#sid_depCode').trigger('onfocus');addmodalpopup('sid_depCode');" type="button" class="btn btn-primary btn-xs dropdown-toggle " data-toggle="modal" data-target="#schmodalpopup" ><span class="glyphicon glyphicon-search"></span></button>
							</div>
							<div class="clearfix"></div>   
								
							<spring:bind path="mststyleheader.id.compCode">
							<div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''} formwithsearch">
							</spring:bind>
								<appfuse:label key="mststyleheader.compCode" styleClass="control-label"/>
								
								<c:if test="${mststyleheader.id.compCode == null}">
									<select required="true" tabindex="4"  Class="form-control" id="sid_compCode" name="id.compCode" path="id.compCode" onfocus="getOptions('sid_compCode','mstcompany')">
										<option  selected="selected" >${mststyleheader.id.compCode}</option>
									</select>	
									<c:set var="disabledparams" scope="session" value=""/>
								</c:if>
								
								<c:if test="${mststyleheader.id.compCode != null}">
									<input readonly="readonly"   Class="form-control" id="sid_compCode" name="id.compCode" path="id.compCode" value="${mststyleheader.id.compCode}"/>  
									<c:set var="disabledparams" scope="session" value="disabled='disabled'"/>
								</c:if>
								
								
								
								<div class="feedback"></div>
							</div>
							<div class="btn-group formsearchbtn btn-model-select-div">
								<button ${disabledparams} onclick="$('#sid_compCode').trigger('onfocus');addmodalpopup('sid_compCode');" type="button" class="btn btn-primary btn-xs dropdown-toggle " data-toggle="modal" data-target="#schmodalpopup" ><span class="glyphicon glyphicon-search"></span></button>
							</div>
							<div class="clearfix"></div>
							
							<spring:bind path="mststyleheader.styleDescription">
							<div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''} formwithsearch">
							</spring:bind>
								<appfuse:label key="mststyleheader.styleDescription" styleClass="control-label"/>
								<form:input cssClass="form-control" tabindex="6" path="styleDescription" id="styleDescription"  maxlength="45"  />
								<div class="feedback"></div>
							</div>
							<div class="clearfix"></div> 
							 
							<spring:bind path="mststyleheader.designReference">
							<div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''} formwithsearch">
							</spring:bind>
								<appfuse:label key="mststyleheader.designReference" styleClass="control-label"/>
								<form:input cssClass="form-control" tabindex="8" path="designReference" id="designReference"  maxlength="10"  />
								<div class="feedback"></div>
							</div>
							<div class="clearfix"></div>
							
							<spring:bind path="mststyleheader.svmType">
							<div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''} formwithsearch">
							</spring:bind>
								<appfuse:label key="mststyleheader.svmType" styleClass="control-label"/>
								 <select id="svmType" tabindex="10" name="svmType" Class="form-control" path="svmType">
									<c:if test="${ mststyleheader.svmType !='Size Wise' }">
										<option  Value="Average" selected="selected"> Average</option>
										<option   Value="Size Wise" > Size Wise</option>
									</c:if>
									<c:if test="${ mststyleheader.svmType =='Size Wise' }">
										<option   selected="selected" Value="Size Wise" > Size Wise</option>
										<option  Value="Average" > Average</option>
									</c:if>
									<!-- <option  Value="Size Wise" > Size Wise</option> -->
									
								</select>
									
								<div class="feedback"></div>
							</div>
							<div class="clearfix"></div> 
							
							
							<spring:bind path="mststyleheader.userId">
							<div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''} formwithsearch">
							</spring:bind>
									<appfuse:label key="mststyleheader.userId" styleClass="control-label"/>	
									<select  Class="form-control" tabindex="12" id="userId" name="userId" path="userId" onfocus="getOptions('userId','mstuser')">
										<option  selected="selected" >${mststyleheader.userId}</option>
									</select>	
									
									<div class="feedback"></div>
							</div>
							<div class="btn-group formsearchbtn btn-model-select-div">
								<button onclick="$('#userId').trigger('onfocus');addmodalpopup('userId');" type="button" class="btn btn-primary btn-xs dropdown-toggle " data-toggle="modal" data-target="#schmodalpopup" ><span class="glyphicon glyphicon-search"></span></button>
							</div>
							<div class="clearfix"></div> 
							
							
						</div>
						<div class="col-md-4">
						<form action="fileupload" class="dropzone" id="my-awesome-dropzone" ></form>
							<div class="draganddropupload">
							
							<form method="post" action="fileupload" class="dropzone" id="my-awesome-dropzone" ></form>
							
<!-- 								<form action="upload.php" class="dropzone" id="my-awesome-dropzone" onsubmit="alert('hi')"></form> -->
							</div>
							<div class="slider-custom"> 
							<!-- <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev"></a>  glyphicon-chevron-left   glyphicon-chevron-right 1 of 16 -->
								 <div class="image-count"> 
  									<span class="glyphicon " style="margin-right: 40px;" id="imagetagsize"></span>
  									<span class="glyphicon " style="margin-left: 40px;"></span>
  								</div> 
							<!-- <a class="right carousel-control" href="#carousel-example-generic" data-slide="next"> </a> <input type="file" class="btn btn-info btn-embossed">-->
							</div>
							
							<c:if test="${mststylepictureList != null && mststylepictureList != '[]'}">
							<div class="view-files-btn">View Attached Files&nbsp;
								<button  type="button" class="btn btn-info btn-embossed" data-toggle="modal" data-target="#myModal">
								  Open Files
								</button>
							</div>
							<div class="modal fade bs-example-modal-lg" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
								<div class="modal-dialog modal-lg">
							    	<div class="modal-content">
							      		<div class="modal-header">
							        		<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
							        		<h4 class="modal-title" id="myModalLabel">Attached Files</h4>
							      		</div>
							      		<div class="panel-body"><!-- modal-body-->
								        	<div class="row">
												<script type="text/javascript">
															var ImgLengt=0;
												</script>
												<div class="sortable">
													<c:forEach items="${mststylepictureList}" var="mststylepicture">
														<div  class="imagegallary thumbnail" id="pic-${mststylepicture.id.picCode}"> 
															<a onclick="if ( confirm('do you really need to delete this ?') == true) {removestylepic('${mststylepicture.id.picCode}','${mststylepicture.id.styleId}','${mststylepicture.id.locationCode}','${mststylepicture.id.compCode}','${mststylepicture.id.custCode}','${mststylepicture.id.depCode}','${param.OpenAS}')}">	              		
																<span class="glyphicon glyphicon-remove pull-right closeimg"></span>
															</a>   
															<img class="gallaryimg" src="data:image/jpg;base64,${mststylepicture.mstPicpictures}" alt="${mststylepicture.id.picCode}" id="${mststylepicture.id.picCode}" />
														</div>
														<div >    </div>
														<script type="text/javascript">
															dataImg[ImgLengt++]="${mststylepicture.id.picCode}";
														</script>
													</c:forEach>
												</div>
												<!-- <h3><span id="sortable-text"></span></h3>   -->
								      		</div>
								      		<div class="modal-footer">
									        	<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
									        	<button type="button" onclick="savepicsequence()" class="btn btn-info" data-dismiss="modal">Save changes</button>
									      	</div>
								    	</div>
							  		</div>
								</div>
							</div>
							</c:if>
							<div class="alert alert-danger fade in" id="error-win">
								<button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
								<h3>Oh snap! You got an error!</h3>
								<p>Error! You didn't fill some required fields. Please fill correctly and try it again.</p>
							</div>
						</div>
					</div>
<!-- 					id="activate-step-2"  -->
					<div class="submit-button pull-right">
						<button type="button" id="back1" class="btn btn-default btn-lg" disabled="disabled" >Back</button>
						<button tabindex="14" id="activate-step-2" type="button" class="btn btn-info btn-lg btn-embossed" onclick="viewPages('P2')">Next</button>
					</div>
				</div>
			</div>
			<div class="setup-content" id="step-2">
			
				<div class="row">
					<!--View Page start-->
					<div class="col-sm-12 col-md-12">
						<h3 class="marginbottom5">Components</h3>
						<hr>
					</div>
				</div>
			
				<div class="row">
					<div class="col-sm-12 col-md-12">
						<div class="widget-container">
							<header>Components</header>
							<div class="adv-table editable-table ">
								<div class="clearfix">
									<div class="addnewbtn-margin pull-right">
										<!-- <button id="editable-sample_new" class="btn btn-warning btn-embossed" type="button" onclick=" AddRow(1)">
											<span class="glyphicon glyphicon-plus"></span> Add New Component
										</button> -->
									</div>
								</div>
								<div class="space15" id="editblrow"></div>
			
								<div class="table-responsive">
								
									<table class="table table-striped table-bordered" id="Ceditable-sample">
										<thead>
											<tr>
												<th class="textcenter">Component</th>
												<th class="textcenter">Product Type</th>
												<th class="textcenter">Component Ratio</th>
												<th class="textcenter">Actions</th>
											</tr>
										</thead>
										<tr id="editable-sample"></tr> <!-- Took off small style  -->
										
										<c:forEach items="${mststylecomponentList}" var="mststylecomponent">
											<tr id="tr${mststylecomponent.id.componentId}">
												<td class="textcenter"><div tabindex="15" id="cmpV${mststylecomponent.id.componentId}">${mststylecomponent.id.componentId}</div></td>
										        <td class="textcenter"><div id="prdV${mststylecomponent.id.componentId}">${mststylecomponent.productType}</div></td>
										        <td class="textcenter"><div id="compR${mststylecomponent.id.componentId}" class="textcenter">${mststylecomponent.compRatio}</div></td>
										       	<td class="textcenter">
                                                  <div class="middle-align textcenter">
                                                    <div class="edit-toggle marginLeft19per components_save" onclick="AddRow('${mststylecomponent.id.componentId}');dataComponent.splice(dataComponent.indexOf('${mststylecomponent.id.componentId}:${mststylecomponent.productType}:${mststylecomponent.compRatio}'),1);iCom--;console.log(dataComponent);">
										       			<a><span class="glyphicon glyphicon-pencil"></span>Edit </a>
										       		</div>
											       	<div class="delete-toggle components_delete">
											       		<a onclick="toggle_visibility('tr${mststylecomponent.id.componentId}');dataComponent.splice(dataComponent.indexOf('${mststylecomponent.id.componentId}:${mststylecomponent.productType}:${mststylecomponent.compRatio}'),1);iCom--;console.log(dataComponent);">
											       			<span class="glyphicon glyphicon-remove"></span> Delete
											       		</a>
											       	</div>
                                                 </div>
										      	</td>
       					 					</tr>
       					 					<script type="text/javascript">
       					 							dataComponent[iCom++]= "${mststylecomponent.id.componentId}:${mststylecomponent.productType}:${mststylecomponent.compRatio}";	;
       					 					</script>
										</c:forEach>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
			
				<div class="row paddingleft20">
					<!--View Page start-->
					<div class="col-sm-12 col-md-12">
						<h3 class="marginbottom5">Colors</h3>
						<hr>
					</div>
				   
				</div>
				<div class="row paddingleft20">
					<div class="col-md-5">
						<div class="widget-container">
							<header>Main Colors</header>
							<div class="widget-inner">
								<%--<strong>Add main Color</strong> --%>
								<div class="form-group maincolorformwithsearch">
								<div class="form-group">
									<label for="addmaincolor" class="col-sm-5 control-label">Main Color Name</label>
									<div class="col-sm-7">
										<!-- <input id="inputmaincolor" type="text" class="typeahead form-control" data-provide="typeahead" onblur="checkvalue(this)"> -->
										<select class="form-control" id="inputmaincolor" onfocus="optionsforgencodes('inputmaincolor','')">
	            						</select>
	            						<div class="feedback"></div>
	            						
									</div>
									<div class="btn-group formsearchbtn btn-model-select-div maincolor">
										<button onclick="$('#inputmaincolor').trigger('onfocus'); addmodalpopup('inputmaincolor')" type="button" class="btn btn-primary btn-xs dropdown-toggle " data-toggle="modal" data-target="#schmodalpopup" ><span class="glyphicon glyphicon-search"></span></button>
									</div>
								</div>
								<div class="clearfix"></div>
								<div class="add_color_button pull-right">
									<button type="button" id="add-new-maincolor" class="btn btn-warning btn-embossed" onclick="addnewmaincolor()">
										<span class="glyphicon glyphicon-plus"></span> Add Main Color
									</button>
								</div>
							</div>
						</div>
					</div>
                 </div>
					<div class="col-md-7 res-margintop40">
						<div class="widget-container">
							<header>Child Colors</header>
							<span class="widget-inner" id="new1">
								<c:forEach items="${mststylemaincolorList}" var="mststylemainColor">
						           <div class="panel-group col-md-11 col-md-offset-1" id="mdiv${mststylemainColor.id.mainColor}">
						           		<div class="main-color-bar pull-left" id="remove-maincolor${mststylemainColor.id.mainColor}">
						           			<div class="pull-left">${mststylemainColor.id.mainColor}</div>
						            		<a href="#mdiv${mststylemainColor.id.mainColor}" onclick="if(removecolor('${mststylemainColor.id.mainColor}')){var index=dataCol.indexOf('${mststylemainColor.id.mainColor}');dataCol.splice(index,1);if(index>=0){iCol--; removedbymaincolor('${mststylemainColor.id.mainColor}');} toggle_visibility('mdiv${mststylemainColor.id.mainColor}');console.log(dataCol);}">
<%-- 						            		dataCol.splice(dataCol.indexOf('${mststylemainColor.id.mainColor}'),1);iCol--; toggle_visibility('mdiv${mststylemainColor.id.mainColor}');console.log(dataCol);"> --%>
						            			<span class="glyphicon glyphicon-remove pull-right remove-bar"></span>
						            		</a>
						            		<div class="pack-qty-lable pull-right" >Pack Qty 
						            			<span id="pqt${mststylemainColor.id.mainColor}">${mststylemainColor.packQty}</span>
						            		</div>
					            		</div>
					            		<button type="button" class="btn btn-default btn-lg pull-right" onclick="addchilde('${mststylemainColor.id.mainColor}')">
						            		<span class="glyphicon glyphicon-plus"></span> Add Child Color
						            	</button>
					            		<div style="display: none;" id="Vdiv${mststylemainColor.id.mainColor}">1</div>
						            	<div class="clearfix"></div>     	
					            		<c:forEach items="${mststylechildcolorList}" var="mststylechildColor">
											<c:if test="${ mststylechildColor.id.mainColor == mststylemainColor.id.mainColor}">					            	
										  		<div class="panel child-color-bar " id="removes${mststylechildColor.id.mainColor}${mststylechildColor.id.childColor}">
												    <div class="panel-heading" id="remove${mststylechildColor.id.mainColor}${mststylechildColor.id.childColor}">
												    	<h4 class="panel-title">
												   			<a id="cl${mststylechildColor.id.mainColor}${mststylechildColor.id.childColor}">${mststylechildColor.id.childColor}</a>
												   			<a class="pack-qty-lable " id="clpqt${mststylechildColor.id.mainColor}${mststylechildColor.id.childColor}">Pack Qty : ${mststylechildColor.packQty}</a>
												   		</h4>
												   		<a href="#mdiv${mststylechildColor.id.mainColor}" onclick="removechild('${mststylechildColor.id.mainColor}${mststylechildColor.id.childColor}','${mststylechildColor.id.mainColor}')"><span class="glyphicon glyphicon-remove pull-right child-color-remove"></span></a>
												    	<a data-toggle="collapse" data-parent="#mdiv${mststylechildColor.id.mainColor}" href="#child-color1-body${mststylechildColor.id.mainColor}${mststylechildColor.id.childColor}"> <span class="child-color-panel glyphicon glyphicon-chevron-down pull-right child-color-collaps"></span></a>
												   	</div>
												   	 <div class="panel-body padding0" id="body${mststylechildColor.id.mainColor}${mststylechildColor.id.childColor}">
												    	<div id="child-color1-body${mststylechildColor.id.mainColor}${mststylechildColor.id.childColor}" class="panel-collapse collapse in">
												   	 		<div class="panel-body">
												    			<div class="form-group row">
												    				<label for="child-color-name${mststylechildColor.id.mainColor}${mststylechildColor.id.childColor}" class="col-sm-4 control-label">Child Color Name</label>
												   					<div class="col-sm-8">
												   						<select class="form-control" id="child-color-name${mststylechildColor.id.mainColor}${mststylechildColor.id.childColor}" onfocus="coloronfocus('${mststylechildColor.id.childColor}','${mststylechildColor.id.mainColor}','C'); optionsforgencodes('child-color-name${mststylechildColor.id.childColor}','')"  onblur="colorononblur('${mststylechildColor.id.mainColor}${mststylechildColor.id.childColor}','${mststylechildColor.id.mainColor}','C');">
												            				<option selected="selected">${mststylechildColor.id.childColor}</option>
												            			</select>
												            			
												            			<div class="feedback"></div>
												            			
												    				</div>		   			
												    			</div>
												    			<div class="form-group row">
												    				<label for="child-color-qty${mststylechildColor.id.mainColor}${mststylechildColor.id.childColor}" class="col-sm-4 control-label">Pack Qty.</label>
												    				<div class="col-sm-4 offset-sm-4">
												    					<input type="text" value="${mststylechildColor.packQty}" class="form-control" id="child-color-qty${mststylechildColor.id.mainColor}${mststylechildColor.id.childColor}"  onkeypress="return styleChildColorVal(event,'${mststylechildColor.id.mainColor}${mststylechildColor.id.childColor}');" ondrop="return false;" onpaste="return false;" onfocus="coloronfocus('${mststylechildColor.id.childColor}','${mststylechildColor.id.mainColor}','Q');" onblur="colorononblur('${mststylechildColor.id.childColor}','${mststylechildColor.id.mainColor}','Q');"/>
												    					<span id="error${mststylechildColor.id.mainColor}${mststylechildColor.id.childColor}" style="color: Red; display: none">* Input digits (0 - 9)</span>
												        			</div>
												        			<a data-toggle="collapse" data-parent="#mdiv${mststylechildColor.id.mainColor}" href="#child-color1-body${mststylechildColor.id.mainColor}${mststylechildColor.id.childColor}">'
												        				<button class="btn btn-info btn-lg btn-embossed" id="child-color-btn${mststylechildColor.id.mainColor}${mststylechildColor.id.childColor}"  onClick="add_color('${mststylechildColor.id.mainColor}${mststylechildColor.id.childColor}','${mststylechildColor.id.mainColor}')">Add Color</button>												        																																																																																	
												        			</a>
												        		</div>
												        	</div>
											       		</div>
								    				</div>
									   			</div>
											   	<script type="text/javascript">
	       					 						dataChiledColor[icColor++]= "${ mststylechildColor.id.mainColor}:${mststylechildColor.id.childColor}:${mststylechildColor.packQty}";
	       					 						MainvsChiledColor[MinColor++]= "${ mststylechildColor.id.mainColor}:${mststylechildColor.id.childColor}";		
												</script>
									   		</c:if>
								   		</c:forEach>	
									</div>
									<script type="text/javascript">
											dataCol[iCol++] = "${mststylemainColor.id.mainColor}";         					 		
	     					 		</script>
								</c:forEach>
							</span> 
						</div>
					</div>
				</div>
			
				<div class="submit-button pull-right">
					<button id="back2" type="button" onclick="viewPages('P1')" class="btn btn-default btn-lg">Back</button>
					<button id="activate-step-3" type="button" onclick="viewPages('P3')" class="btn btn-info btn-lg btn-embossed">Next</button>
				</div>
				
			</div>
			<div class="setup-content" id="step-3">
			
				<div class="row paddingleft20">
					<!--View Page start-->
					<div class="col-sm-12 col-md-12">
						<h3 class="marginbottom5">Add Dimension</h3>
						<hr>
					</div>
				</div>
			
				<div class="row paddingleft20">
					<div class="col-md-6">
						<div class="widget-container">
							<header>Dimension 1</header>
							<div class="widget-inner">
								<div class="row form-group">
									<label class="col-md-4 control-label" for="selectbasic">Select Basic</label>
									<div class="col-md-8">
										<select id="selectbasic-v" name="selectbasic" class="form-control" onchange="optioncreator(this.value,'Vertical');">
										<option selected> -- Select an option -- </option>
											<c:forEach items="${gencodes}" var="gencode">
												<c:if test="${gencode.id.type=='SIZDEM'}">
													<% String var = ""; %>
													<c:if test="${mststyledemList != null}">
														<c:forEach items="${mststyledemList}" var="mststyledem">
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
										</select>
									</div>
								</div>
								<!-- Select Multiple -->
								<div class="row form-group margintop20">
									<label class="col-md-4 control-label" for="selectmultiple">Select..</label>
									<c:forEach items="${gencodes}" var="gencode">
										<c:if test="${gencode.id.type=='SIZDEM'}">
											<div class="col-md-8 vertical_divs" id="Vertical_${gencode.id.code}">
												<select data-placeholder="Select Values" id="V-select-${gencode.id.code}" class="chosen-select" multiple style="width:100%;" tabindex="4" onchange="bindMatrix('');">
													<c:forEach items="${gencodes}" var="dim_v">
														<c:if test="${dim_v.id.type == gencode.id.code }">
															<% String var = ""; %>
															<c:if test="${mststyledemList != null}">
																<c:forEach items="${mststyledemList}" var="mststyledem">
																	<c:if test="${mststyledem.dimention == 'Vertical'}">
																		<c:if test="${mststyledem.id.demValue == dim_v.id.code}">
																			<% var = "selected='selected'"; %>
																		</c:if>
																	</c:if>
																</c:forEach>
															</c:if>
															<option <%=var%> id="v-${dim_v.id.code}" value="${dim_v.id.code}">${dim_v.id.code}</option>
														</c:if>
													</c:forEach>
												</select>
<!-- 												<div class="pull-right" style="margin-top:20px"> -->
<%-- 													<button type="button" class="btn" onclick="clearAllSelect('V-select-${gencode.id.code}');">Clear All</button> --%>
<!-- 													<button type="button" class="btn btn-info" onclick="bindMatrix('')">Apply</button> -->
<!-- 												</div> -->
											</div>
										</c:if>
									</c:forEach>
								</div>
							</div>
						</div>
					</div>
			
					<div class="col-md-6">
						<div class="widget-container">
							<header>Dimension 2</header>
							<div class="widget-inner">
								<div class="row form-group">
									<label class="col-md-4 control-label" for="selectbasic">Select Basic</label>
									<div class="col-md-8">
										<select id="selectbasic-h" name="selectbasic" class="form-control" onchange="optioncreator(this.value,'Horizontal');">
											<option selected> -- Select an option -- </option>
											<c:forEach items="${gencodes}" var="gencode">
												<c:if test="${gencode.id.type=='SIZDEM'}">
													<% String var = ""; %>
													<c:if test="${mststyledemList != null}">
														<c:forEach items="${mststyledemList}" var="mststyledem">
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
			
								<!-- Select Multiple -->
								<div class="row form-group margintop20">
									<label class="col-md-4 control-label" for="selectmultiple">Select...</label>
									<c:forEach items="${gencodes}" var="gencode">
										<c:if test="${gencode.id.type =='SIZDEM'}">
											<div class="col-md-8 horizontal_divs" id="Horizontal_${gencode.id.code}">
												<select data-placeholder="Select Values" id="H-select-${gencode.id.code}" class="chosen-select" multiple style="width:100%;" tabindex="4" onchange="bindMatrix('');">
													<c:forEach items="${gencodes}" var="dim_h">
														<c:if test="${dim_h.id.type == gencode.id.code }">
															<% String var = ""; %>
															<c:if test="${mststyledemList != null}">
																<c:forEach items="${mststyledemList}" var="mststyledem">
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
					</div>
				</div>
			
				<div class="row paddingleft20">
					<!--View Page start-->
					<div class="col-sm-12 col-md-12">
						<h3 class="marginbottom5">Dimension Matrix</h3>
						<hr>
						
					</div>
				</div>
				<div class="row  paddingleft20">
					<div class="col-sm-12 col-md-12">
						<div class="widget-container">
							<header>Dimension Matrix</header>
							<button type="button" class="margindimentionbtn btn btn-info" onclick="copyAsThis();">Apply same patern</button>
							<button type="button" class="margindimentionbtn marginLeft0 btn btn-info" onclick="bindMatrix('');">Regenerate Grid Again</button>
							<div class="table-responsive" id="size-fit-matrix">
							
							</div>
							<!-- table responsive-->
						</div>
						<!-- widget -->
					</div>
				</div>
			
			
				<div id="submision" class="submit-button pull-right">
					<a>
						<button id="back3" type="button" onclick="viewPages('P2-Back')" class="btn btn-default btn-lg">Back</button>
					</a>
					<button type="button" class="btn btn-info btn-lg btn-embossed" onclick="saveStyleMaster('mststyleheaderform','mststyleheaderform');">Save</button>
				</div>
			</div>	
			<div class="col-sm-8 col-md-8 col-xs-8 paddingBottom10">
                <div class="aprovedby">
			  <span class="glyphicon glyphicon-ok aprovedicon"></span> 
			  <div class="aprovedbytitle">
				Created By: ${mststyleheader.createdBy}<br>
				Created On: ${mststyleheader.createdOn}
			  </div>  
		  </div>
		  <div class="createdby">
		  <span class="glyphicon glyphicon-edit createdicon"></span> 
			  <div class="aprovedbytitle">
				Modified By: ${mststyleheader.modifiedBy}<br>
				Modified On: ${mststyleheader.modifiedOn}
			  </div>  
		  </div>
            </div>
			</form:form>
		</div>
	</div>
	<!-- Main container end  -->
    <script type="text/javascript">
	    $('.dropdown-menu input, .dropdown-menu label').click(function (e) {
	        e.stopPropagation();
	    });      
        $(".chosen-select").chosen();
        $('#back3').on('click', function (e) {
            $('#submision a[href="#step-2"]').trigger('click');
        });
        $(".alert").alert();
       
    </script>
   
    <script>
        AddRow('*New Field*');
      		/* var maincol=Gencodetyphead('STYCLR')
			$("#inputmaincolor").typeahead({ source: maincol}); */

        $(document).ready(function(){
        	//dimensionRemove = dimension;
        	arrange();
        	optioncreator("null", "Hide");
        	if(document.getElementById("selectbasic-v").value != null){
        		optioncreator(document.getElementById("selectbasic-v").value,'Vertical');
        	}
        	if(document.getElementById("selectbasic-h").value != null){
        		optioncreator(document.getElementById("selectbasic-h").value,'Horizontal');
        	}
        	dimensionRemove[0] = document.getElementById("selectbasic-h").value;
        	dimensionRemove[1] = document.getElementById("selectbasic-v").value;
        	
        	try{
        		bindMatrix('');
        		tempMarked = matrixRemove;
        	}catch (e) {}
        	try{
        		fname();
        	}catch (e) {}
			try{
				horizontalRemove = valuesSize;
        	}catch(e){}
			try{
				verticalRemove = valuesFit;
        	}catch(e){}
        	
        	for(i=0; i<tempMarked.length; i++){
    			//console.info(tempMarked[i]);
    			try{
    				removeManage(document.getElementById(tempMarked[i]));//.checked = true;checkMatrix
    	    	}catch(e){//splice if dont want to marked removes**
    	    		console.info(e);
    	    	}
    		}
        	
        	makeDimention();
        	
            $('#mststyleheaderform').validate({ // initialize the plugin
                rules: {
                	id_styleId:{
                		required: true
                	},
                	sid_locationCode:{
                		required: true
                    },
                    sid_depCode:{
                		required: true
                    },
                    sid_custCode:{
                		required: true
                    },
                    sid_compCode:{
                		required: true
                    },
                    userId: {
                    	required: true
            		}, 
            		styleDescription:{
            			required: true
            		}
                }
	            ,errorPlacement: function(error,element){
	        		parentDiv = element.parents('.form-group');
	        		//parentDiv.wrapInner('<div class="error"></div>');
	        		errorDiv = parentDiv.children(".feedback");
	        		error.appendTo(errorDiv);
	        	},
                success: function( label ) {
                	$('#error-win').hide();
                }
            });
            
            $('#error-win').hide();
           /*  var tables=new Array();
            tables=["table_id_locationCode","table_id_custCode","table_id_depCode","table_userId","table_id_compCode","table_id_packingMethod","table_id_productRange"];
            search=new Array();
            search=["L","C","D","U","Co","Pm","Pr"]
			for(var i=0;i<tables.length;i++){ id="sec1"
				stylefuzzy(tables[i],"search"+search[i]);
			} */	
            
        });
        $('#myModal').modal({  show: false });
    </script>
    <script >
	    function fname(){
	    	<c:forEach items="${mststyledemmapList}" var="mststyledemmap">
	    		document.getElementById("${mststyledemmap.id.mainColor}:${mststyledemmap.id.demValue1}:${mststyledemmap.id.demValue2}").checked = true;
	    		matrixRemove.push("${mststyledemmap.id.mainColor}:${mststyledemmap.id.demValue1}:${mststyledemmap.id.demValue2}");
	        </c:forEach>
	    }
	    document.getElementById("step-1").style.display="block";  
	    document.getElementById("step-2").style.display="none";
	    document.getElementById("step-3").style.display="none";

	    
		<c:if test="${param.sec=='2'}">
		document.getElementById("step-1").style.display="none";
	    document.getElementById("step-2").style.display="block";
	    document.getElementById('step2-btn').className="active";
	    document.getElementById("step-3").style.display="none";
		console.log('${param.sec}');
		</c:if>
		<c:if test="${param.sec=='3'}">
		document.getElementById("step-1").style.display="none";
	    document.getElementById("step-2").style.display="none";
	    document.getElementById('step2-btn').className="active";
	    document.getElementById("step-3").style.display="block";
	    document.getElementById('step3-btn').className="active";
		console.log('${param.sec}');
		</c:if>
    </script>
