<%@ include file="/common/taglibs.jsp"%>

<head>
<title><fmt:message key="mststyleheaderList.title" /></title>
<meta name="menu" content="MststyleheaderMenu" />
</head>
<script type="text/javascript" src="scripts/applicationjs/mststylehdr.js"> </script>
<c:if test="{'$'}{not empty searchError}">
	<div class="alert alert-danger alert-dismissable">
		<a href="#" data-dismiss="alert" class="close">&times;</a>
		<c:out value="{'$'}{searchError}" />
	</div>
</c:if>
<div class="col-sm-12 col-md-12">
<h2>
	<fmt:message key="mststyleheaderList.heading" />
</h2>

<div class="panel-group" id="stylebrowser">
	<div class="panel panel-default">
		<div class="panel-heading" data-toggle="collapse"
			data-parent="#stylebrowser" data-target="#styleBrowserBody">
			<h4 class="panel-title">
				<a class="accordion-toggle"> 
					<span class="pull-right slideupdowntoggle glyphicon glyphicon-chevron-up"></span>
					Style Browser
				</a>
			</h4>
		</div>
		<div id="styleBrowserBody" class="panel-collapse collapse">
			<div class="panel-body">
				<form method="get" action="${ctx}/mststyleheaders" id="searchForm" class="form-inline">
					<div class="row"> 
	                    <div class="pull-right margin-addstyleroute">
	                      <div class="input-group custom-search-form " style="width: 370px;margin-left:-3.1%">
	                        <!-- <input type="text" class="form-control" placeholder="Search and Filter"> -->
	                        <input type="text" size="20" name="q" id="query" value="${param.q}" placeholder="<fmt:message key="search.enterTerms"/>"  class="form-control" placeholder="Search and Filter">
	                        <span class="input-group-btn">
	                          <button class="btn btn-info search-form-btn" type="submit">
	                            <span class="glyphicon glyphicon-search"></span>
	                          </button>
	                        </span>
	                      	<a href='<c:url value="/mststyleheaderform"/>'  class="btn btn-warning btn-embossed pull-right" >
	                       		<span class="glyphicon glyphicon-plus"></span>  <fmt:message key="button.add" /> Style
	                       </a>
	                      </div><!-- /input-group  -->
	                        
	                    </div>                   
	                </div>
                </form>
				
                   <div class="table-responsive Scroll-for-datatable-2">
						<section class="sectionnewclass">
	                        <display:table name="mststyleheaderList" class="datatable routId table table-striped table-bordered"
	                                       requestURI="" id="mststyleheaderList" export="true" pagesize="25">
								<display:setProperty name="export.csv.include_header" value="true" />
	                            <display:column media="html">
									<img  src="data:image/jpg;base64,${mststyleheaderList.mststylepicture}" alt="NO picture" style="width: 30px;height: 30px"/>
								</display:column>
								<display:column property="id.custCode" sortable="true" class="textcenter" headerClass="textcenter" titleKey="mststyleheader.custCode"/>
								<display:column property="id.locationCode" sortable="true" class="textcenter" headerClass="textcenter" titleKey="mststyleheader.locationCode"/>
								<display:column property="id.compCode" sortable="true" class="textcenter" headerClass="textcenter" titleKey="mststyleheader.compCode"/>
								<display:column property="id.depCode" sortable="true" class="textcenter" headerClass="textcenter" titleKey="mststyleheader.depCode"/>
								<display:column property="id.styleId" sortable="true" class="textcenter" headerClass="textcenter" titleKey="mststyleheader.styleId"/>
								<display:column property="flag" sortable="true" titleKey="mststyleheader.flag" class="textcenter" headerClass="textcenter" />
	                            <%--<display:column property="id" media="csv excel xml pdf" titleKey="mststyleheader.id" />--%>
								<display:column property="userId" sortable="true" titleKey="mststyleheader.userId" class="textcenter" headerClass="textcenter" />
								<display:column media="html" class="textcenter headcol2 aditional" headerClass="headcol2 textcenter aditional style_broswer_openasnew" titleKey="<a>Open as new</a>">
									<div class="middle-align">
										<div class="operations-toggle">
						                     <a href="mststyleheaderform?OpenAS=true&styleId=${mststyleheaderList.id.styleId}&locationCode=${mststyleheaderList.id.locationCode}&compCode=${mststyleheaderList.id.compCode}&custCode=${mststyleheaderList.id.custCode}&depCode=${mststyleheaderList.id.depCode}"><span class="glyphicon glyphicon-folder-open marginRight5"></span>  Open as new </a>
						                </div>	
						            </div>
						        </display:column>
								<display:column media="html" class="textcenter headcol3" headerClass="headcol3 textcenter style_broswer_openasnew" titleKey="<a>Actions</a>">
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
		</div>
	</div>
</div>

<div class="panel-group" id="stylebrowsertempory">
	<div class="panel panel-default">
		<div class="panel-heading" style="background-color: #d63b3f;">
			<h4 class="panel-title">
				<a data-toggle="collapse" data-parent="#stylebrowsertempory"
					href="#styleBrowserBody2"> <span
					class="slideupdowntogglered pull-right glyphicon glyphicon-chevron-up"></span>
					Styles that need your attention
				</a>
			</h4>
		</div>

		<div id="styleBrowserBody2" class="panel-collapse collapse">
			<div class="panel-body">
				<div class="table-responsive Scroll-for-datatable-2 style-temporytable ">
					<section class="sectionremove">
					
						<display:table name="mststyleheaderdueList" class="datatable routId table table-striped table-bordered" requestURI="" id="mststyleheaderdueList" export="true" pagesize="25">
							<display:setProperty name="export.csv.include_header" value="true" />
							<display:column media="html"> 
									<img  src="data:image/jpg;base64,${mststyleheaderdueList.mststylepicture}" alt="NO picture" style="width: 30px;height: 30px"/>
							</display:column>
							<display:column property="id.custCode" sortable="true" class="textcenter" headerClass="textcenter" titleKey="mststyleheader.custCode" />
							<display:column property="id.locationCode" sortable="true" class="textcenter" headerClass="textcenter" titleKey="mststyleheader.locationCode" />
							<display:column property="id.compCode" sortable="true" class="textcenter" headerClass="textcenter" titleKey="mststyleheader.compCode"/>
							<display:column property="id.depCode" sortable="true" class="textcenter" headerClass="textcenter" titleKey="mststyleheader.depCode"/>
							<display:column property="id.styleId" sortable="true" class="textcenter" headerClass="textcenter" titleKey="mststyleheader.styleId" />
<%-- 							<display:column property="id" media="csv excel xml pdf" titleKey="mststyleheader.id" /> --%>
							<display:column property="comments"  class="textcenter" headerClass="textcenter" sortable="true" titleKey="mststyleheader.comments" />
							<display:column property="flag" class="textcenter" headerClass="textcenter" sortable="true" titleKey="mststyleheader.flag"/>
							<display:column property="userId" class="textcenter" headerClass="textcenter" sortable="true" titleKey="mststyleheader.userId"/>
<%-- 							<display:column media="html" class="textcenter headcol2" headerClass="headcol2 textcenter" titleKey="<a>Open as new</a>"> --%>
<!-- 									<div class="middle-align"> -->
<!-- 										<div class="operations-toggle"> -->
<%-- 						                    <a href="mststyleheaderform?OpenAS=true&styleId=${mststyleheaderdueList.id.styleId}&locationCode=${mststyleheaderdueList.id.locationCode}&compCode=${mststyleheaderdueList.id.compCode}&custCode=${mststyleheaderdueList.id.custCode}&depCode=${mststyleheaderdueList.id.depCode}"><span class="glyphicon glyphicon-folder-open marginRight5"></span>  Open as new </a> --%>
<!-- 						                 </div>	 -->
<!-- 						            </div> -->
<%-- 					        </display:column> --%>

							<display:column media="html" class="textcenter headcol3 actionsin newwidth" headerClass="headcol3 textcenter actionsin newwidth style_broswer_openasnew" titleKey="<a>Actions</a>">
								<div class="middle-align">
									 <div class="edit-toggle">
					                    <a href="mststyleheaderform?styleId=${mststyleheaderdueList.id.styleId}&locationCode=${mststyleheaderdueList.id.locationCode}&compCode=${mststyleheaderdueList.id.compCode}&custCode=${mststyleheaderdueList.id.custCode}&depCode=${mststyleheaderdueList.id.depCode}"><span class="glyphicon glyphicon-pencil"></span> Edit</a>
					                 </div>
					                 <div class="view-toggle">
					                    <a href="mststylemasterview?styleId=${mststyleheaderdueList.id.styleId}&locationCode=${mststyleheaderdueList.id.locationCode}&compCode=${mststyleheaderdueList.id.compCode}&custCode=${mststyleheaderdueList.id.custCode}&depCode=${mststyleheaderdueList.id.depCode}"><span class="glyphicon glyphicon-eye-open"></span> View </a>
					                 </div>
					                 <div class="delete-toggle">
                                        <a onclick="  if ( confirm('do you really need to delete this ?') == true) {deleteStyle('styleId=${mststyleheaderdueList.id.styleId}&locationCode=${mststyleheaderdueList.id.locationCode}&compCode=${mststyleheaderdueList.id.compCode}&custCode=${mststyleheaderdueList.id.custCode}&depCode=${mststyleheaderdueList.id.depCode}')}"><span
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
		</div>
	</div>
  </div>
</div>

