<%@ include file="/common/taglibs.jsp"%>
<script src="scripts/applicationjs/mststylewippoints.js"></script>

<head>
    <title><fmt:message key="mststylewippointsList.title"/></title>
    <meta name="menu" content="MststylewippointsMenu"/>
</head>

<c:if test="{'$'}{not empty searchError}">
    <div class="alert alert-danger alert-dismissable">
        <a href="#" data-dismiss="alert" class="close">&times;</a>
        <c:out value="{'$'}{searchError}"/>
    </div>
</c:if>

<div class="row form-group paddingleft20">
	<!-- NAVIGATION PILLS -->
	<div class="col-xs-8">
		<h2><fmt:message key="mststylewippointsList.title"/></h2>
	</div>
	<div class="col-xs-4 styletoure-hrline">
		<ul class="nav nav-justified " id="myTab">
			<li id="step1-btn" class="active" onclick="showFWip('1');">
				<a href="#home2" data-toggle="tab">
					<button type="button" class="btn btn-default btn-circle"><span class="glyphicon glyphicon-sort-by-order"></span>
					</button>
					<p class="list-group-item-text"><fmt:message key="mststylewippointsList.title"/></p>
				</a>
			</li>
			<li id="step2-btn" onclick="showFWip('2');">
				<a href="#profile2" data-toggle="tab">
					<button type="button" class="btn btn-default btn-circle"><span class="glyphicon glyphicon-pushpin"></span>
					</button>
					<p class="list-group-item-text"><fmt:message key="mststylewippoints.AssignRowMaterials"/></p>
				</a>
			</li>
		</ul>
	</div>
</div>
<!-- NAVIGATION PILLS END-->

<div class="tab-content">
	<!-- TAB CONTENT MAIN -->
	<div class="tab-pane active" id="home2">
		<div class="row paddingleft20 margintop20">
			<div class="col-sm-12 col-md-12">
				<div class="panel-group" id="stylebrowser">
					<div class="panel panel-default">
						<div class="panel-heading" data-toggle="collapse" data-parent="#stylebrowser" data-target="#wipPointBody">
							<h4 class="panel-title">
								<a data-toggle="collapse" data-parent="#stylebrowser" href="#wipPointBody"> 
								<a class="accordion-toggle">
								<span class="pull-right slideupdowntoggle glyphicon glyphicon-chevron-up"></span><fmt:message key="mststylewippoints.AvailableWIPPoints"/></a>
								</a> 
							</h4>
						</div>
						<div id="wipPointBody" class="panel-collapse collapse">
							<div class="panel-body">
								<div class="row">
								<form method="get" action="/mststylewippointss" id="searchForm" class="form-inline">
									<div class="pull-right margin-addstyleroute">
										<div class="input-group custom-search-form " style="width: 370px;">
											<input type="text" class="form-control" name="q" placeholder="Search and Filter"/>
											<span class="input-group-btn">
											<button class="btn btn-info search-form-btn" type="submit">
											<span class="glyphicon glyphicon-search"></span>
											</button>
											</span>

											<button type="button" onclick="addNewWippoint();" class="btn btn-warning btn-embossed YNClickEvent pull-right">
												<span class="glyphicon glyphicon-plus">
												</span><fmt:message key="mststylewippoints.AddWIPPoint"/>
											</button>
										</div>
									</div>
								</form>
								</div>

								<div class="dataTables_wrapper">
									<section>
<display:table name="mststylewippointsList" class="display table table-striped table-bordered table-hover wip-points-tb" cellspacing="0" requestURI="" id="mststylewippointsList" export="true" pagesize="25">
    <display:setProperty name="export.csv.include_header" value="true" />
    <display:column property="sequnceNo" sortable="true" titleKey="mststylewippoints.sequnceNo" headerClass="textcenter" class="textcenter"/>
    <display:column property="wippointCode" sortable="true" titleKey="mststylewippoints.wippointCode" headerClass="textcenter" class="textcenter"/>
    <display:column property="wippoint" sortable="true" titleKey="mststylewippoints.wippoint" headerClass="textcenter" class="textcenter"/>
    <display:column property="description" sortable="true" titleKey="mststylewippoints.description" headerClass="textcenter" class="textcenter"/>
    <display:column style="display:none;" titleKey="mststylewippoints.mandetory"  property="mandetory" headerClass="displayNone"></display:column>
    <display:column sortable="true" titleKey="mststylewippoints.mandetory" headerClass="textcenter" class="textcenter" media="html">
    	<c:if test="${mststylewippointsList.mandetory == true}">
			<input disabled="disabled" checked="checked" type="checkbox">
		</c:if>
		
		<c:if test="${mststylewippointsList.mandetory == false}">
			<input disabled="disabled" type="checkbox">
		</c:if>
    	
    </display:column>
    <display:column style="display:none;" titleKey="mststylewippoints.activeWip" property="activeWip" headerClass="displayNone"></display:column>
    <display:column sortable="true" titleKey="mststylewippoints.activeWip" class="center" media="html">
    	<c:if test="${mststylewippointsList.activeWip == true}">
			<input disabled="disabled" checked="checked" type="checkbox">
		</c:if>
		
		<c:if test="${mststylewippointsList.activeWip == false}">
			<input disabled="disabled" type="checkbox">
		</c:if>
    </display:column>
    
    <display:column headerClass="textcenter" titleKey="<a>Actions</a>" media="html">
    	<div class="middle-align">
         	<div class="edit-toggle-styl-rt edit-toggle edit-toggle">
           		<a onclick="editWipPoint(${mststylewippointsList.wippointCode});"><span class="glyphicon glyphicon-pencil"></span> Edit</a>
         	</div>
         	<div class="delete-toggle-styl-rt delete-toggle delete-toggle">
               <a onclick="deleteWipPoint(${mststylewippointsList.wippointCode})" data-toggle="modal"><span class="glyphicon glyphicon-remove"></span> Delete </a> 
           </div>
       	</div>
    </display:column>
<%--     <display:column property="wippointCode" sortable="true" href="mststylewippointsform" media="html" --%>
<%--         paramId="wippointCode" paramProperty="wippointCode" titleKey="mststylewippoints.wippointCode"/> --%>
<%--     <display:column property="wippointCode" media="csv excel xml pdf" titleKey="mststylewippoints.wippointCode"/> --%>
    <display:setProperty name="paging.banner.item_name"><fmt:message key="mststylewippointsList.mststylewippoints"/></display:setProperty>
    <display:setProperty name="paging.banner.items_name"><fmt:message key="mststylewippointsList.mststylewippointss"/></display:setProperty>
    <display:setProperty name="export.excel.filename"><fmt:message key="mststylewippointsList.title"/>.xls</display:setProperty>
    <display:setProperty name="export.csv.filename"><fmt:message key="mststylewippointsList.title"/>.csv</display:setProperty>
    <display:setProperty name="export.pdf.filename"><fmt:message key="mststylewippointsList.title"/>.pdf</display:setProperty>
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
				<div class="panel-group" id="stylebrowser">
					<div class="panel panel-default">
						<div class="panel-heading" data-toggle="collapse" data-parent="#addstyleroute" data-target="#addstyleroute">
							<h4 class="panel-title">
							<a data-toggle="collapse" data-parent="#stylebrowser" href="#addstyleroute"> 
							  <a class="accordion-toggle"> 
							  <span class="pull-right slideupdowntoggle glyphicon glyphicon-chevron-up"></span><a id="WIPEditTitle"><fmt:message key="mststylewippoints.AddWIPPoint"/></a></a>
							</a> 
						  </h4>
						</div>
						<div id="addstyleroute" class="panel-collapse collapse">
							<form:form commandName="mststylewippoints" method="post" action="mststylewippointsform" id="mststylewippointsForm" onsubmit="return saveWipMaster();">
							 <form:hidden cssClass="form-control" path="wippointCode" id="wippointCode"  maxlength="255"/>
							<div class="panel-body" id="addWipPoint">
								<div class="row paddingleft20">
									 <h3 class="add-styl-rt"><fmt:message key="mststylewippoints.DefineWIPPoint"/></h3>
									 <hr>
									<div class="col-md-4 col-xs-4">
										<div class="form-group formwithsearch">
											<div class="icon-addon addon-md">
												<spring:bind path="mststylewippoints.sequnceNo">
												<div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
													</spring:bind>
													<appfuse:label key="mststylewippoints.sequnceNo" styleClass="control-label"/>
													<form:input cssClass="form-control" path="sequnceNo" id="sequnceNo"  maxlength="255"/>
													<form:errors path="sequnceNo" cssClass="help-block"/>
												</div>
												<div class="feedback"></div>
											</div>
										</div>
										<div class="clearfix"></div>
									</div>
									<div class="col-sm-4 col-md-4 col-xs-4">
										<div class="form-group formwithsearch">
											<div class="icon-addon addon-md">
												<spring:bind path="mststylewippoints.wippoint">
												<div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
													</spring:bind>
													<appfuse:label key="mststylewippoints.wippoint" styleClass="control-label"/>
													<form:input cssClass="form-control" path="wippoint" id="wippoint"  maxlength="10"/>
													<form:errors path="wippoint" cssClass="help-block"/>
												</div>
												<div class="feedback"></div>
											</div>
										</div>
										<div class="clearfix"></div>
									</div>
									<div class="col-sm-4 col-md-4 col-xs-4">
										<div class="form-group formwithsearch">
											<div class="icon-addon addon-md">
											<spring:bind path="mststylewippoints.description">
											<div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
											</spring:bind>
												<appfuse:label key="mststylewippoints.description" styleClass="control-label"/>
												<form:input cssClass="form-control" path="description" id="description"  maxlength="50"/>
												<form:errors path="description" cssClass="help-block"/>
											</div>
											<div class="feedback"></div>
											</div>
										</div>
										<div class="clearfix"></div>
									</div>
								</div>

								<div class="row paddingleft20">
									<div class="col-sm-4 col-md-4 col-xs-4 pull-left">
									<spring:bind path="mststylewippoints.mandetory">
									<div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
									</spring:bind>
										<appfuse:label key="mststylewippoints.mandetory" styleClass="control-label pull-left marginRight15 paddingTop4"/>
										<form:checkbox path="mandetory" id="mandetory" cssClass="checkbox pull-left"/>
										<form:errors path="mandetory" cssClass="help-block"/>
									</div>
								</div>
									<div class="col-sm-4 col-md-4 col-xs-4 pull-left">
									<spring:bind path="mststylewippoints.activeWip">
									<div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
									</spring:bind>
										<appfuse:label key="mststylewippoints.activeWip" styleClass="control-label pull-left marginRight15 paddingTop4"/>
										<form:checkbox path="activeWip" id="activeWip" cssClass="checkbox pull-left" value="true" />
										<form:errors path="mandetory" cssClass="help-block"/>
									</div>
									</div>
									<div id="WipMasterError">
									<div class="alert alert-danger d-alert" role="alert">
							          <button type="button" class="close" data-dismiss="alert" aria-hidden="true">�</button>
							          <span class="error_heading">Error! </span> <fmt:message key="mststylewippoints.error"/>
							        </div>
							        </div>
									
									 <div id="submision" class="submit-button styl-rt-submission-btn pull-left marginLeft20 marginTop0">
										 <button class="btn btn-info btn-lg btn-embossed"><fmt:message key="button.submit"/></button>
                                        <a>
                                        <button type="button" id="back3" class="btn btn-default btn-lg" onclick="resetForm();"><fmt:message key="button.refresh"/></button>
                                        </a>
									 </div>
								</div>
							</div>
							</form:form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- end of tab content 1 -->
	
	<div class="tab-pane" id="profile2">
		<!-- Start of tab content 2 -->
		<div class="row paddingleft20 ">
			<div class="col-sm-12 col-md-12 margintop20">
				<div class="panel-group overflow-visible" id="stylebrower-available-routes">
					<div class="panel panel-default overflow-visible">
						<div class="panel-heading" data-toggle="collapse" data-parent="#stylebrower-available-routes" data-target="#stylebrower-available-routesBody">
							<h4 class="panel-title">
							<a data-toggle="collapse" data-parent="#stylebrower-available-routes" href="#stylebrower-available-routesBody"> 
							</a><a class="accordion-toggle"> <span class="pull-right slideupdowntoggle glyphicon glyphicon-chevron-up"></span><fmt:message key="mststylewippoints.AvailableItemTypes"/></a> 
							</h4>
						</div>
						<div id="stylebrower-available-routesBody" class="panel-collapse collapse out" style="height: auto;">
							<div class="panel-body">
								<div class="input-group custom-search-form custom-search-formRight" style="width: 370px;">
			<select id="newItemType" class="demo-default" placeholder="Select an item...">
				<option value="">Select an item...</option>
			</select>
			<span class="input-group-btn"></span>
			

			<button type="button" class="btn btn-warning btn-embossed pull-right marginRight15 marginLeft15" onclick="addItemType();">
				<span class="glyphicon glyphicon-plus"></span> Add Item Type 
			</button>
								</div>
								<div class="dataTables_wrapper">
									<section id="itemGrid">

									</section>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	
		<div class="row paddingleft20 ">
			<div class="col-sm-12 col-md-12 marginTop10">
				<div class="panel-group" id="wip-points-panel">
					<div class="panel panel-default">
						<div class="panel-heading" data-toggle="collapse" data-parent="#wip-points-panel" data-target="#wip-points-panelBody">
							<h4 class="panel-title">
							<a data-toggle="collapse" data-parent="#wip-points-panel" href="#wip-points-panelBody"> 
							</a><a class="accordion-toggle"> <span class="pull-right slideupdowntoggle glyphicon glyphicon-chevron-up"></span><fmt:message key="mststylewippoints.AttachedWIPpoints"/></a>
							</h4>
						</div>
						<div id="wip-points-panelBody" class="panel-collapse out collapse out" style="height: auto;">
							<div class="panel-body">
								<div class="col-sm-5 col-md-5 marginTop10 pull-left">
								<span class="glyphicon glyphicon-exclamation-sign pull-left quick-tip-ico"></span><h3 class="quick-tip-heading pull-left"><fmt:message key="label.quickTip"/></h3>
								<div class="clearfix"></div>
								<p class="marginTop10"><fmt:message key="mststylewippointsList.message"/></p>
								</div>
								<div class="col-sm-7 col-md-7 pull-right" id="wipItemGrid">
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<div id="CBWIPDelete" class="modal fade delete-confirmation model-popup-fix" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
 <div class="modal-dialog modal-sm">
   <div class="modal-content delete-conf-content">
	 <div class="alert alert-danger fade in delete-conf-alert-danger" role="alert">
	   <button type="button" class="close delete-model-close-x-btn" ><span aria-hidden="true" class="">�</span><span class="sr-only "><fmt:message key="button.close"/></span></button>
	   <h4 class="delete-confirm-heading"><fmt:message key="label.deleteWarning"/></h4>
	   <p><fmt:message key="label.deleteWarningMessage"/></p>
		 <button type="button" onclick="confirmDelWipPoint();" class="btn btn-danger"><fmt:message key="button.delete"/></button>
		 <button type="button" class="btn btn-default delete-model-close-x-btn"><fmt:message key="button.cancel"/></button>
	   </p>
	 </div>
   </div>
 </div>
</div>

<script>
$('#nav-dropdown .dropdown-menu').on({"click":function(e){
		e.stopPropagation();
	}
});
</script>   

<script>
	var wipPointArr = new Array();
	<c:forEach items="${mstStyleWippointsForItem}" var="root">
		wipPointArr.push(["${root.wippointCode}", "${root.sequnceNo}", "${root.mandetory}", "${root.wippoint}", "${root.description}", "${root.activeWip}"]);
	</c:forEach>
	
	<c:if test="${param.sec=='2'}">
		document.getElementById("home2").style.display="none";
	    document.getElementById("profile2").style.display="block";
	    document.getElementById('step2-btn').className="active";
	    document.getElementById('step1-btn').className="";
	</c:if>
	
	function showFWip(page){
		if(page == "1"){
			document.getElementById("home2").style.display="block";
			document.getElementById("profile2").style.display="none";
		}
		else{
			document.getElementById("home2").style.display="none";
		    document.getElementById("profile2").style.display="block";
		}
		
	}
</script>


<script src="scripts/site_scripts.js"></script>
<script src="scripts/custom.js"></script> 
