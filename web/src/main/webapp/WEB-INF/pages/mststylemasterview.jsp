<%@ include file="/common/taglibs.jsp"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<head>
<title><fmt:message key="mststyleheaderList.title" /></title>
<meta name="menu" content="MststyleheaderMenu" />
</head>
<script type="text/javascript" src="scripts/applicationjs/mststylehdr.js"> </script>
<c:set var="delObject" scope="request">
	<fmt:message key="mststyleheaderList.mststyleheader" />
</c:set>
<script type="text/javascript">
	var msgDelConfirm = "<fmt:message key="delete.confirm"><fmt:param value="${delObject}"/></fmt:message>";
</script>

<div class="row paddingleft20">
	<div class="col-sm-12 col-md-12">

		<h1>
			<fmt:message key="mststyleheaderList.heading" />
		</h1>

		<div class="panel-group" id="stylebrowser">
			<div class="panel panel-default">
				<div class="panel-heading" data-toggle="collapse"
					data-parent="#stylebrowser" data-target="#styleBrowserBody">
					<h4 class="panel-title">
						<a class="accordion-toggle"> <span
							class="pull-right slideupdowntoggle glyphicon glyphicon-chevron-up"></span>
							Style Browser
						</a>
					</h4>
				</div>
				<div id="styleBrowserBody" class="panel-collapse collapse in">
					<div class="panel-body">
							<div class="table-responsive Scroll-for-datatable-2">
								<section>
									<display:table  name="mststyleheaderList" class="datatable routId table table-striped table-bordered" requestURI="" id="mststyleheaderList" export="true" pagesize="25">
									
										<display:column > 
											<img  src="data:image/jpg;base64,${mststyleheaderList.mststylepicture}" alt="NO picture" style="width: 30px;height: 30px"/>
										</display:column>
										<display:column property="id.custCode" sortable="true" headerClass="textcenter" class="textcenter" titleKey="mststyleheader.custCode" />
										<display:column property="id.locationCode" sortable="true" headerClass="textcenter" class="textcenter" titleKey="mststyleheader.locationCode" />
										<display:column property="id.compCode" sortable="true" headerClass="textcenter" class="textcenter" titleKey="mststyleheader.compCode"/>
										<display:column property="id.depCode" sortable="true" headerClass="textcenter" class="textcenter" titleKey="mststyleheader.depCode"/>
										<display:column property="id.styleId" sortable="true" headerClass="textcenter" class="textcenter" titleKey="mststyleheader.styleId" />
										<display:column property="id" media="csv excel xml pdf" headerClass="textcenter" class="textcenter" titleKey="mststyleheader.id" />
										<display:column property="userId" sortable="true" headerClass="textcenter" class="textcenter" titleKey="mststyleheader.userId"/>
										<display:column property="flag" sortable="true" headerClass="textcenter" class="textcenter" titleKey="mststyleheader.flag"/>
										<display:column media="html" class="textcenter headcol2" headerClass="headcol2 style_view_page_openasnew" titleKey="<a>Open as new</a>">
										<div class="middle-align">
											<div class="operations-toggle">
							                    <a href="mststyleheaderform?OpenAS=true&styleId=${mststyleheaderList.id.styleId}&locationCode=${mststyleheaderList.id.locationCode}&compCode=${mststyleheaderList.id.compCode}&custCode=${mststyleheaderList.id.custCode}&depCode=${mststyleheaderList.id.depCode}"><span class="glyphicon glyphicon-folder-open marginRight5"></span>  Open as new </a>
							                 </div>	
							            </div>
						        </display:column>
	
								<display:column media="html" class="textcenter headcol3" headerClass="headcol3 textcenter style_view_page_action" titleKey="<a>Actions</a>">
									<div class="middle-align">
										 <div class="edit-toggle">
						                    <a href="mststyleheaderform?styleId=${mststyleheaderList.id.styleId}&locationCode=${mststyleheaderList.id.locationCode}&compCode=${mststyleheaderList.id.compCode}&custCode=${mststyleheaderList.id.custCode}&depCode=${mststyleheaderList.id.depCode}"><span class="glyphicon glyphicon-pencil"></span> Edit</a>
						                 </div>
						                 <div class="view-toggle">
						                    <a href="mststylemasterview?styleId=${mststyleheaderList.id.styleId}&locationCode=${mststyleheaderList.id.locationCode}&compCode=${mststyleheaderList.id.compCode}&custCode=${mststyleheaderList.id.custCode}&depCode=${mststyleheaderList.id.depCode}"><span class="glyphicon glyphicon-eye-open"></span> View </a>
						                 </div>
						                 <div class="delete-toggle">
	                                        <a onclick="  if ( confirm('do you really need to delete this ?') == true) {deleteStyle('styleId=${mststyleheaderList.id.styleId}&locationCode=${mststyleheaderList.id.locationCode}&compCode=${mststyleheaderList.id.compCode}&custCode=${mststyleheaderList.id.custCode}&depCode=${mststyleheaderList.id.depCode}')}"><span
	                                                class="glyphicon glyphicon-remove"></span> Delete </a>
	                                    </div>
						                
						              </div>			
						        </display:column>
										<display:setProperty name="paging.banner.item_name"><fmt:message key="mststyleheaderList.mststyleheader" /></display:setProperty>
										<display:setProperty name="paging.banner.items_name"><fmt:message key="mststyleheaderList.mststyleheaders" /></display:setProperty>
				
										<display:setProperty name="export.excel.filename"><fmt:message key="mststyleheaderList.title" />.xls</display:setProperty>
										<display:setProperty name="export.csv.filename"><fmt:message key="mststyleheaderList.title" />.csv</display:setProperty>
										<display:setProperty name="export.pdf.filename"><fmt:message key="mststyleheaderList.title" />.pdf</display:setProperty>
									
								
									</display:table>
							
									</section>	
								</div>

					</div>
					<!-- Panel body -->
				</div>
			</div>
			<!-- Panel Default -->
		</div>
		<!-- Panel Group -->

	</div>
	<!-- 12 Collum -->
</div>
<c:if test="${mststyleheader != '[]'}">	
	<div class="row paddingleft20">
		<!--View Page start-->
		<div class="col-sm-12 col-md-12">
			<h3 class="marginbottom40">			
				Style : <b>${mststyleheader.id.styleId}</b> &nbsp;&nbsp; 
				Style Description : <b>${mststyleheader.styleDescription}</b> &nbsp;&nbsp;
				This style is "${mststyleheader.flag}"! 
			</h3>
			<h3 class="edittitle">General Details</h3>
			<div class="pull-right editsection">
				<a href="mststyleheaderform?sec=1&styleId=${mststyleheader.id.styleId}&locationCode=${mststyleheader.id.locationCode}&compCode=${mststyleheader.id.compCode}&custCode=${mststyleheader.id.custCode}&depCode=${mststyleheader.id.depCode}"><span class="glyphicon glyphicon-pencil"></span> Edit
					Section</a>
			</div>
			<div class="clearfix"></div>
			<hr>
		</div>
	
	</div>
	
	<div class="row paddingleft20">
		<!--View Page start-->
		<div class="tan pull-left">
			<div id="displaytable">
				<div style="display: table-row;">
					<div class="table-cell table-fixwidth">
					<strong>Location: </strong>
					</div>
					<div class="table-cell" style="width: 122px;">${mststyleheader.id.locationCode}</div>
					<div class="table-cell">&nbsp;</div>
					<div class="table-cell">&nbsp;</div>
					<div class="table-cell">&nbsp;</div>
					<div class="table-cell">&nbsp;</div>
				</div>
	
				<div style="display: table-row;">
					<div class="table-cell table-fixwidth">
						<strong>Buyer: </strong>
					</div>
					<div class="table-cell ">${mststyleheader.id.custCode}</div>
					<div class="table-cell table-fixwidth">
						<strong>Buyer Department:</strong>
					</div>
					<div class="table-cell" style="width: 150px;">${mststyleheader.id.depCode}</div>
					<div class="table-cell">
						<strong>Company:</strong>
					</div>
					<div class="table-cell">${mststyleheader.id.compCode}</div>
				</div>
	
				<div style="display: table-row;">
					<div class="table-cell">
						<strong>Style: </strong>
					</div>
					<div class="table-cell">${mststyleheader.id.styleId}</div>
					<div class="table-cell">
						<strong>Description:</strong>
					</div>
					<div class="table-cell">${mststyleheader.styleDescription}</div>
					<div class="table-cell table-fixwidth" style="width: 132px;">
						<strong>Cost sheet Method:</strong>
					</div>
					<div class="table-cell">${mststyleheader.costSheetMethod}</div>
					
				</div>
	
				<div style="display: table-row;">
					<div class="table-cell">
						<strong>Packing method:
						</strong>
					</div>
					<div class="table-cell">${mststyleheader.packingMethod}</div>
					<div class="table-cell">
						<strong>Product Range:</strong>
					</div>
					<div class="table-cell">${mststyleheader.productRange}</div>
					<div class="table-cell">
						<strong>SMV Type:</strong>
					</div>
					<div class="table-cell">${mststyleheader.svmType}</div>
				</div>
				
				<div style="display: table-row;">
					<div class="table-cell">
						<strong> Design <br>Referance:</strong>
					</div>
					<div class="table-cell">${mststyleheader.designReference}</div>
					<div class="table-cell">
						<strong>Requested By:</strong>
					</div>
					<div class="table-cell">${mststyleheader.userId}</div>
					<div class="table-cell">
						<strong>Comments:</strong>
					</div>
					<div class="table-cell">${mststyleheader.comments}</div>
					
				</div>
	
			</div>
		</div>
	
		<div class="ts">
			<div id="carousel-example-generic" class="carousel slide"
				data-ride="carousel">
				<!-- Wrapper for slides -->
				<div class="carousel-inner">
					
					<% int imgcount=0; %>
						<c:forEach items="${mststylepictureList}" var="mststylepicture">
							
							<% String me="";
								if(imgcount==0){
									me="<div class='item active'>";
								}
								else{
									me="<div class='item'>";
								}
							%>	
							<%= me %>
							<%-- <c:out value="${mststylepicture}" /> --%>
							<img class="carousel-img" src="data:image/jpg;base64,${mststylepicture.mstPicpictures}"
								alt="NO picture" />
								<%  imgcount++; %>
							</div>
						</c:forEach>
	
				</div>
	
				<!-- Controls -->
				<div class="slider-custom">
					<a class="left carousel-control" href="#carousel-example-generic"
						data-slide="prev"> <span
						class="glyphicon glyphicon-chevron-left"></span>
					</a>
					<div class="image-count"><%= imgcount %> image/s attached</div>
					<a class="right carousel-control" href="#carousel-example-generic" data-slide="next"> <span
						class="glyphicon glyphicon-chevron-right"></span>
					</a>
	
				</div>
	
			</div>	
		</div>
	
	
		<div class="clearfix"></div>
	
	</div>
	<!-- row container end  -->
	
	
	<div class="row paddingleft20">
		<div class="col-sm-12 col-md-12">
			<h3 class="edittitle">Components & Colors</h3>
			<div class="pull-right editsection">
				<a href="mststyleheaderform?sec=2&styleId=${mststyleheader.id.styleId}&locationCode=${mststyleheader.id.locationCode}&compCode=${mststyleheader.id.compCode}&custCode=${mststyleheader.id.custCode}&depCode=${mststyleheader.id.depCode}"><span class="glyphicon glyphicon-pencil"></span> Edit
					Section</a>
			</div>
			<div class="clearfix"></div>
			<hr>
		</div>
	</div>
	
	<div class="row  paddingleft20">
		<div class="col-sm-6 col-md-6">
			<div class="widget-container">
				<header>Components</header>
				<div class="table-responsive">
					<table class="table table-bordered">
						<thead>
							<tr>
								<th class="textcenter">Component</th>
								<th class="textcenter">Product Type</th>
								<th class="textcenter">Comp. Ratio</th>
	
							</tr>
						</thead>
						<!--                        	 <td>Component 1</td>  <td>Prduct Type 1</td> <td>1:3</td> -->
						<tbody>
							<c:forEach items="${mststylecomponentList}"
								var="mststylecomponent">
								<tr>
									<td class="textcenter">${mststylecomponent.id.componentId}</td>
									<td class="textcenter">${mststylecomponent.productType}</td>
									<td class="textcenter">${mststylecomponent.compRatio}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	
	
		<div class="col-sm-6 col-md-6">
			<div class="widget-container">
				<header>Colors</header>
				<div class="table-responsive">
					<table class="table table-bordered">
						<thead>
							<tr>
								<th class="textcenter">Main Color</th>
								<th class="textcenter">Pack Qty.</th>
								<th class="textcenter">Child Colors</th>
								<th class="textcenter">Pack Size</th>
							</tr>
						</thead>
						<!--                           <tr> <td rowspan="4">Main Color 1</td>  <td rowspan="4">10</td><td>Child Color 1</td><td>1</td> </tr> -->
						<!--                           <tr><td>Child Color 2</td> <td>2</td>  </tr> -->
						<tbody>
							<c:forEach items="${mststylemaincolorList}"
								var="mststylemaincolor">
								<tr>
									<td class="textcenter">${mststylemaincolor.id.mainColor}</td>
									<td class="textcenter">${mststylemaincolor.packQty}</td>
									<td colspan="2"  class="textcenter"><c:forEach
											items="${mststylechildcolorList}" var="mststylechildcolor">
											<c:if
												test="${ mststylemaincolor.id.mainColor == mststylechildcolor.id.mainColor}">
												<div class="pull-left" style="width: 50%;">${mststylechildcolor.id.childColor}</div>
												<div class="textcenter pull-right" style="width: 50%;">${mststylechildcolor.packQty}</div>
											</c:if>
										</c:forEach></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	
	</div>
	
	<div class="row paddingleft20">
		<div class="col-sm-12 col-md-12">
			<h3 class="edittitle">Dimension Matrix</h3>
			<div class="pull-right editsection">
				<a href="mststyleheaderform?sec=3&styleId=${mststyleheader.id.styleId}&locationCode=${mststyleheader.id.locationCode}&compCode=${mststyleheader.id.compCode}&custCode=${mststyleheader.id.custCode}&depCode=${mststyleheader.id.depCode}"><span class="glyphicon glyphicon-pencil"></span> Edit
					Section</a>
			</div>
			<div class="clearfix"></div>
			<hr>
		</div>
	</div>
	
	<div class="row  paddingleft20">
		<div class="col-sm-12 col-md-12">
			<div class="widget-container">
				<header>Dimension Matrix</header>
				<div class="table-responsive" id="size-fit-matrix"></div>
				<!-- table responsive-->
	
			</div>
			<!-- widget -->
	
		</div>
		<div class="row paddingleft20" style="display: none;">
			<div class="col-md-6">
				<div class="widget-container">
					<header>Size Dimension 1</header>
					<div class="widget-inner">
						<div class="row form-group">
							<label class="col-md-4 control-label" for="selectbasic">Select
								Basic</label>
							<div class="col-md-8">
								<select id="selectbasic-v" name="selectbasic"
									class="form-control"
									onchange="optioncreator(this.value,'Vertical');">
									<option disabled="disabled" selected>-- Select an
										option --</option>
									<c:forEach items="${gencodes}" var="gencode">
										<c:if test="${gencode.id.type=='SIZDEM'}">
											<%
												String var = "";
											%>
											<c:if test="${mststyledemList != null}">
												<c:forEach items="${mststyledemList}" var="mststyledem">
													<c:if test="${mststyledem.dimention == 'Vertical'}">
														<c:if test="${mststyledem.id.demType == gencode.id.code}">
															<%
																var = "selected='selected'";
															%>
														</c:if>
													</c:if>
												</c:forEach>
											</c:if>
											<option <%=var%> value="${gencode.id.code}">${gencode.id.code}</option>
											<%
												var = "";
											%>
										</c:if>
									</c:forEach>
								</select>
							</div>
						</div>
						<!-- Select Multiple -->
						<div class="row form-group">
							<label class="col-md-4 control-label" for="selectmultiple">Select..</label>
							<c:forEach items="${gencodes}" var="gencode">
								<c:if test="${gencode.id.type=='SIZDEM'}">
									<div class="col-md-8 vertical_divs"
										id="Vertical_${gencode.id.code}">
										<select data-placeholder="Select Values"
											id="V-select-${gencode.id.code}" class="chosen-select"
											multiple style="width: 100%;" tabindex="4"
											onchange="bindMatrix('view');">
											<c:forEach items="${gencodes}" var="dim_v">
												<c:if test="${dim_v.id.type == gencode.id.code }">
													<%
														String var = "";
													%>
													<c:if test="${mststyledemList != null}">
														<c:forEach items="${mststyledemList}" var="mststyledem">
															<c:if test="${mststyledem.dimention == 'Vertical'}">
																<c:if test="${mststyledem.id.demValue == dim_v.id.code}">
																	<%
																		var = "selected='selected'";
																	%>
																</c:if>
															</c:if>
														</c:forEach>
													</c:if>
													<option <%=var%> value="${dim_v.id.code}">${dim_v.id.code}</option>
												</c:if>
											</c:forEach>
										</select>
<!-- 										<div class="pull-right" style="margin-top: 20px"> -->
<!-- 											<button type="button" class="btn">Clear All</button> -->
<!-- 											<button type="button" class="btn btn-info" -->
<!-- 												onclick="bindMatrix('view')">Apply</button> -->
<!-- 										</div> -->
									</div>
								</c:if>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
	
			<div class="col-md-6">
				<div class="widget-container">
					<header>Size Dimension 2</header>
					<div class="widget-inner">
						<div class="row form-group">
							<label class="col-md-4 control-label" for="selectbasic">Select
								Basic</label>
							<div class="col-md-8">
								<select id="selectbasic-h" name="selectbasic"
									class="form-control"
									onchange="optioncreator(this.value,'Horizontal');">
									<option disabled="disabled" selected>-- Select an
										option --</option>
									<c:forEach items="${gencodes}" var="gencode">
										<c:if test="${gencode.id.type=='SIZDEM'}">
											<%
												String var = "";
											%>
											<c:if test="${mststyledemList != null}">
												<c:forEach items="${mststyledemList}" var="mststyledem">
													<c:if test="${mststyledem.dimention == 'Horizontal'}">
														<c:if test="${mststyledem.id.demType == gencode.id.code}">
															<%
																var = "selected='selected'";
															%>
														</c:if>
													</c:if>
												</c:forEach>
											</c:if>
											<option <%=var%> id="${gencode.id.code}" value="${gencode.id.code}">${gencode.id.code}</option>
											<%
												var = "";
											%>
										</c:if>
									</c:forEach>
								</select>
							</div>
						</div>
	
						<!-- Select Multiple -->
						<div class="row form-group">
							<label class="col-md-4 control-label" for="selectmultiple">Select...</label>
							<c:forEach items="${gencodes}" var="gencode">
								<c:if test="${gencode.id.type=='SIZDEM'}">
									<div class="col-md-8 horizontal_divs"
										id="Horizontal_${gencode.id.code}">
										<select data-placeholder="Select Values"
											id="H-select-${gencode.id.code}" class="chosen-select"
											multiple style="width: 100%;" tabindex="4"
											onchange="bindMatrix('view');">
											<c:forEach items="${gencodes}" var="dim_h">
												<c:if test="${dim_h.id.type == gencode.id.code }">
													<%
														String var = "";
													%>
													<c:if test="${mststyledemList != null}">
														<c:forEach items="${mststyledemList}" var="mststyledem">
															<c:if test="${mststyledem.dimention == 'Horizontal'}">
																<c:if test="${mststyledem.id.demValue == dim_h.id.code}">
																	<%
																		var = "selected='selected'";
																	%>
																</c:if>
															</c:if>
														</c:forEach>
													</c:if>
													<option <%=var%> id="${dim_h.id.code}" value="${dim_h.id.code}">${dim_h.id.code}</option>
												</c:if>
											</c:forEach>
										</select>
<!-- 										<div class="pull-right" style="margin-top: 20px"> -->
<!-- 											<button type="button" class="btn">Clear All</button> -->
<!-- 											<button type="button" class="btn btn-info" -->
<!-- 												onclick="bindMatrix('view')">Apply</button> -->
<!-- 										</div> -->
									</div>
								</c:if>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
		</div>
    <div class="row paddingleft20 marginTopx">
		<div id="submision" class="submit-button pull-right">
			<form action="mststylemasterview" method="post" id="styleView">
			<input type="hidden" name="id.styleId" value="${mststyleheader.id.styleId}">
			<input type="hidden" name="id.locationCode" value="${mststyleheader.id.locationCode}">
			<input type="hidden" name="id.compCode" value="${mststyleheader.id.compCode}">
			<input type="hidden" name="id.custCode" value="${mststyleheader.id.custCode}">
			<input type="hidden" name="id.depCode" value="${mststyleheader.id.depCode}">
			<input type="hidden" name="confirm" value="confirm">
			
				<c:if test="${param.delete == 'true'}">
					<button type="button" onclick="deletconformStyle('${mststyleheader.id.styleId}','${mststyleheader.id.locationCode}','${mststyleheader.id.compCode}','${mststyleheader.id.custCode}','${mststyleheader.id.depCode}')" class="btn btn-info btn-lg btn-embossed marginRight10">Delete</button>
				</c:if>
				
				<c:if test="${param.delete != 'true'}">
					<c:if test="${mststyleheader.flag != 'Complete'}">
					<button type="button" onclick="confirmStyleMaster();" class="btn btn-info btn-lg btn-embossed confirm_style_button">Confirm</button>
				</c:if>
				</c:if>
				
			</form>
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
<!-- 	  <div class="modifiedby"> -->
<!-- 		<span class="glyphicon glyphicon-refresh modifiedicon"></span>  -->
<!-- 		  <div class="aprovedbytitle"> -->
<%-- 			Approved By: ${mststyleheader.flag}<br> --%>
<%-- 			Approved On: ${mststyleheader.flag} --%>
<!-- 		  </div> -->
<!-- 	  </div> -->
	   </div>
	</div>

</c:if> 
<c:if test="${mststyleheader == '[]'}">	
		<script>
		if(confirm('Nothing to display here Prese yes to rederct Main Style page ?') == true){
			location.replace("mststyleheaders");
		}
		else{
	
		}
			 
		</script>
Nothing to Dispaly
			
</c:if> 
<!-- Main container end  -->
<c:if test="${mststyleheader != '[]'}">	
<script>
	var $win = $(window);

	function checkScroll() {
		if ($win.scrollTop() > 100) {
			$win.off('scroll', checkScroll);
			$('.topbar').fadeIn(2000);
		}
	}

	$win.scroll(checkScroll);
	
	function confirmStyleMaster(){
		var data = jQuery("#styleView").serialize();
		$.ajax({
	           type: "POST",
	           url: "mststylemasterview",
	           data: data,
	           success: function(data) {
	               location.replace("mststyleheaders");
	           }
	       });
	}
</script>

<script>
	$("#menu-toggle").click(function(e) {
		e.preventDefault();
		$(".topbar-controls,#wrapper,#sidebar-wrapper").toggleClass("active");
	});
</script>

<script>
	$('.collapse').collapse()
</script>

<script type="text/javascript">
	$(document).ready(function() {
// 						$('.datatable').dataTable({
// 							"sPaginationType" : "bs_full"
// 						});
// 						$('.datatable')
// 								.each(
// 										function() {
// 											var datatable = $(this);
// 											// SEARCH - Add the placeholder for Search and Turn this into in-line form control
// 											var search_input = datatable
// 													.closest(
// 															'.dataTables_wrapper')
// 													.find(
// 															'div[id$=_filter] input');
// 											search_input.attr('placeholder',
// 													'Filter and Search');
// 											search_input
// 													.addClass('search-query form-control stylesearch');
// 											// LENGTH - Inline-Form control
// 											var length_sel = datatable
// 													.closest(
// 															'.dataTables_wrapper')
// 													.find(
// 															'div[id$=_length] select');
// 											length_sel
// 													.addClass('form-control input-sm ');
// 										});

						$(".process_status").html("<a href='#' class='btn btn-warning btn-embossed'>Add New Syle</a>");

						optioncreator("null", "Hide");
						if (document.getElementById("selectbasic-v").value != null) {
							optioncreator(document.getElementById("selectbasic-v").value,'Vertical');
						}
						if (document.getElementById("selectbasic-h").value != null) {
							optioncreator(document.getElementById("selectbasic-h").value,'Horizontal');
						}
						try {
							getCol();
							bindMatrix('view');
						} catch (e) {
						}
						try {
							fname();
						} catch (e) {
						}
						fname();
					});
</script>

<script language=javascript>
	function fname() {
		<c:forEach items="${mststyledemmapList}" var="mststyledemmap">
		document.getElementById('${mststyledemmap.id.mainColor}:${mststyledemmap.id.demValue1}:${mststyledemmap.id.demValue2}').checked = true;
		</c:forEach>
	}

	function getCol() {
		<c:forEach items="${mststylemaincolorList}" var="mststylemaincolor">
		dataCol.push('${mststylemaincolor.id.mainColor}');
		iCol++;
		</c:forEach>
	}
</script>

<script type="text/javascript">
	$('.slideupdowntoggle.glyphicon')
			.click(
					function() {
						var el = $(this).parents(".panel-title").children(
								".glyphicon");
						if ($(this).hasClass("glyphicon-chevron-up")) {
							$(this).removeClass("glyphicon-chevron-up")
									.addClass("glyphicon-chevron-down");
							el.slideUp(200);
						} else {
							$(this).removeClass("glyphicon-chevron-down")
									.addClass("glyphicon-chevron-up");
							el.slideDown(200);
						}
					});
</script>

<script>
	$(document)
			.ready(
					function() {

						var navListItems = $('ul.setup-panel li a'), allWells = $('.setup-content');

						allWells.hide();

						navListItems.click(function(e) {
							e.preventDefault();
							var $target = $($(this).attr('href')), $item = $(
									this).closest('li');

							if (!$item.hasClass('disabled')) {
								navListItems.closest('li')
										.removeClass('active');
								$item.addClass('active');
								allWells.hide();
								$target.show();
							}
						});

						$('ul.setup-panel li.active a').trigger('click');

						// DEMO ONLY //
						$('#activate-step-2').on(
								'click',
								function(e) {
									$('ul.setup-panel li:eq(1)').removeClass(
											'disabled');
									$('ul.setup-panel li a[href="#step-2"]')
											.trigger('click');
									$(this).remove();
								})
					});
</script>

</c:if> 
