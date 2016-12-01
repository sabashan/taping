<!DOCTYPE html>
<%@ include file="/common/taglibs.jsp"%>
<html lang="en">

<head>
<meta http-equiv="Cache-Control" content="no-store" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" href="<c:url value=" /images/favicon.ico "/>" />
<link href="styles/bootstrap.min.css" rel="stylesheet">
<link href="styles/simple-sidebar.css" rel="stylesheet" type="text/css">
<!--<link href="styles/flat-ui.css" rel="stylesheet" type="text/css">-->
<link href="styles/flat-ui.css" rel="stylesheet" type="text/css">
<link href="styles/bootstrap-switch.min.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="styles/font-awesome-4.2.0/css/font-awesome.min.css" type="text/css">
<!-- <link href="styles/chosen.min.css" rel="stylesheet" type="text/css"> -->
<!-- <link href="styles/bootstrap-checkbox.css" rel="stylesheet" type="text/css">  -->

<decorator:head />
<%--         <t:assets /> --%>
<!-- <link href="styles/typeaheadjs.css" rel="stylesheet" type="text/css" >  -->
<!-- <link href="styles/dropzone.css" rel="stylesheet"> -->
<link rel="stylesheet" href="styles/selectize.bootstrap3.css">
<link href="styles/custom.css" rel="stylesheet">
<link href="styles/dev-custom.css" rel="stylesheet">
<link rel="shortcut icon" href="images/favicon.ico">
	
<!-- HTML5 shim, for IE6-8 support of HTML5 elements. All other JS at the end of file. -->
<!--[if lt IE 9]>
      <script src="scripts/html5shiv.js"></script>
    <![endif]-->

<!-- Fav and touch icons -->
<link rel="shortcut icon" href="ico/favicon.png">

<title><decorator:title />| <fmt:message key="webapp.name" />
</title>


<script src="scripts/jquery-1.11.0.min.js"></script>
<script src="scripts/jquery.validate.min.js"></script>
<script src="scripts/jquery-ui.min.js"></script> 
<script src="scripts/bootstrap.min.js"></script>
<script src="scripts/chosen.jquery.min.js"></script>
<script src="scripts/my.js"></script>
<script src="scripts/model.js"></script>
<script src="scripts/dateTimeFormatter.js"></script>
<script src="scripts/bootstrap3-typeahead.min.js"></script>
<script src="scripts/selectize.js"></script>
  <!-- <script src="scripts/bootstrap3-typeahead.min.js"></script> -->
<!--   <script src="scripts/bootstrap3-typeahead.js"></script> -->
  <script type="text/javascript" src="scripts/bootstrap-datepicker.js"></script> 
<script type="text/javascript" src="scripts/bootstrap-switch.min.js"></script>
  <script type="text/javascript" src="scripts/site_scripts.js"></script> 
  
  
</head>
<body
	<decorator:getProperty property="body.id" writeEntireProperty="true" />
	<decorator:getProperty property="body.class" writeEntireProperty="true" />>


	<div id="wrapper">

		<div>
			<%@ include file="/common/slidebar.jsp"%>
		</div>


		<div id="page-content-wrapper" class="container-fluid">
			<!--MAIN CONTENT-->
				<%@ include file="/common/messages.jsp"%>
				<decorator:body />

				<c:if test="${currentMenu == 'AdminMenu'}">
					<div class="col-sm-2">
						<menu:useMenuDisplayer name="Velocity" config="navlistMenu.vm"
							permissions="rolesAdapter">
							<menu:displayMenu name="AdminMenu" />
						</menu:useMenuDisplayer>
					</div>
				</c:if>

			
			<!--End of Row-->
		</div>
		<!--End of Fluid Container-->


	</div>


	<%-- <div id="footer" class="container navbar-fixed-bottom">
        <span class="col-sm-6 text-left"><fmt:message key="webapp.version"/>
            <c:if test="${pageContext.request.remoteUser != null}">
            | <fmt:message key="user.status"/> ${pageContext.request.remoteUser}
            </c:if>
        </span>
        <span class="col-sm-6 text-right">
            &copy; <fmt:message key="copyright.year"/> <a href="<fmt:message key="company.url"/>"><fmt:message key="company.name"/></a>
        </span>
        </div>--%>
	<%=(request.getAttribute( "scripts") !=null) ? request .getAttribute( "scripts") : ""%>

	
	<script src="scripts/multiselect.js"></script>
	<script src="scripts/custom.js"></script>

<script src="scripts/jquery-migrate-1.2.1.min.js"></script>
<!-- <script src="scripts/wizard.js"></script>-->
<script src="scripts/jquery.searchable-1.0.0.min.js"></script>
<!-- <script src="scripts/DT_bootstrap.js"></script> -->
<script src="scripts/editable-table.js"></script>
<script src="scripts/bootstrap-checkbox.js"></script>

<script src="scripts/dropzone.js"></script>
<script src="scripts/chosen.jquery.min.js"></script>

<script src="scripts/footable.js" type="text/javascript"></script>
<script src="scripts/footable.paginate.js" type="text/javascript"></script>
<!-- 
<script src="scripts/bootstrap3-typeahead.min.js"></script> -->

</body>

</html>
