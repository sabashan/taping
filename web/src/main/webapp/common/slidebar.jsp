	<div id="sidebar-wrapper" class="style-3"> <!--SIDEBAR CONTENT-->
    	<div class="logo"></div>
        <div class="sidebar-nav">
          <div class="accordion" id="accordion2">
              <div class="accordion-group">
                <div class="accordion-heading">
                  <a class="accordion-toggle accordion-toggle-hover" href="home">
                    <span class="menuheader menuheader-sidebar"><span class=" fa fa-home  glyphicon-position"></span> Home </span>
                  </a>
                </div>
              </div>
			  
			  <div class="accordion-group">
                <div class="accordion-heading">
                  <a class="accordion-toggle accordion-toggle-hover" data-toggle="collapse" data-parent="#accordion2" href="#collapseOne">
                    <span class="menuheader menuheader-sidebar"><span class=" fa fa-strikethrough  glyphicon-position"></span> Style Master </span>
                  </a>
                </div>
                <div id="collapseOne" class="accordion-body accordion-body-sidebar collapse in">
                  <div class="accordion-inner">
                   <ul class="list-unstyled">
                       <li><a href="mststyleheaders">Retrieve Styles</a></li>
                       <li><a href="mststyleheaderform">Add Styles</a></li>
                   </ul>
                  </div>
                </div>
              </div>

              <div class="accordion-group">
                <div class="accordion-heading">
                  <a class="accordion-toggle accordion-toggle-hover" data-toggle="collapse" data-parent="#accordion2" href="#collapseThree">
                    <span class="menuheader menuheader-sidebar"><span class=" fa fa-road  glyphicon-position"></span>Style Route </span>
                  </a>
                </div>
                <div id="collapseThree" class="accordion-body accordion-body-sidebar collapse in">
                  <div class="accordion-inner">
                   <ul class="list-unstyled">
                       <li><a href="mststylerouteoperations">Add Style Route</a></li>
                      	<li><a href="mststylerouteoperations?rop_id_search=true">Add Style Operations</a></li> 
                       <li><a href="mststylerouteoperations?wipsearch=true">Assign WIP Points</a></li> 
                       <li><a href="mststylerouteview">View Style Route</a></li> 
                   </ul>
                  </div>
                </div>
              </div>

              <div class="accordion-group">
                <div class="accordion-heading">
                  <a class="accordion-toggle accordion-toggle-hover" data-toggle="collapse" data-parent="#accordion2" href="#collapse4">
                    <span class="menuheader menuheader-sidebar"><span class=" fa fa-sort-numeric-asc  glyphicon-position"></span>WIP Point Master </span>
                  </a>
                </div>
                <div id="collapse4" class="accordion-body accordion-body-sidebar collapse in">
                  <div class="accordion-inner">
                   <ul class="list-unstyled">
                       <li><a href="mststylewippointss">Available WIP Points</a></li>
                       <li><a href="mststylewippointss?sec=2">Assign Items to WIP Points</a></li>
                       
                   </ul>
                  </div>
                </div>
              </div>
              
              <div class="accordion-group">
                <div class="accordion-heading">
                  <a class="accordion-toggle accordion-toggle-hover" data-toggle="collapse" data-parent="#accordion2" href="#collapse5">
                    <span class="menuheader menuheader-sidebar"><span class=" fa fa-strikethrough  glyphicon-position"></span> Pre-Cost Sheet </span>
                  </a>
                </div>
                <div id="collapse5" class="accordion-body accordion-body-sidebar collapse in">
                  <div class="accordion-inner">
                   <ul class="list-unstyled">
                       <li><a href="merprecostsheets">Retrieve  Pre-Cost Sheet</a></li>
                       <li><a href="merprecostsheetform">Add  Pre-Cost Sheet</a></li>
                       <li><a href="merprecostsheetsview">View Pre-Cost Sheet</a></li>
                   </ul>
                  </div>
                </div>
              </div>
              
              <div class="accordion-group">
                <div class="accordion-heading">
                  <a class="accordion-toggle accordion-toggle-hover" data-toggle="collapse" data-parent="#accordion2" href="#collapse6">
                    <span class="menuheader menuheader-sidebar"><span class=" fa fa-strikethrough  glyphicon-position"></span> Final Cost Sheet </span>
                  </a>
                </div>
                <div id="collapse6" class="accordion-body accordion-body-sidebar collapse in">
                  <div class="accordion-inner">
                   <ul class="list-unstyled">
                       <ul class="list-unstyled">
                       <li><a href="mercostsheethdrs">Retrieve Final Cost Sheet</a></li>
                       <li><a href=mercostsheethdrform>Add New Final Cost Sheet</a></li>
                   </ul>
                   </ul>
                  </div>
                </div>
              </div>
              <div class="accordion-group">
                <div class="accordion-heading">
                  <a class="accordion-toggle accordion-toggle-hover" data-toggle="collapse" data-parent="#accordion2" href="#collapse7">
                    <span class="menuheader menuheader-sidebar"><span class=" fa fa-strikethrough  glyphicon-position"></span> Order Sheet </span>
                  </a>
                </div>
                <div id="collapse7" class="accordion-body accordion-body-sidebar collapse in">
                  <div class="accordion-inner">
                   <ul class="list-unstyled">
                       <li><a href="merordersheethdrs">Retrieve Planing Order</a></li>
                       <li><a href="merordersheethdrform">Add Planing Order</a></li>
                       <li><a href="merordersheetorderform">Add Processing Order</a></li>
                  </ul>
                  </div>
                </div>
              </div>
               <div class="accordion-group">
                <div class="accordion-heading">
                  <a class="accordion-toggle accordion-toggle-hover" href="logout">
                    <span class="menuheader menuheader-sidebar"><span class=" fa fa-sign-out  glyphicon-position"></span> Sign Out </span>
                  </a>
                </div>
              </div>
            </div> 
                
        </div>  <!-- end of side bar nav -->
    
    </div>
    <div class="topbar container-fluid">
        <div class="topbaricon pull-left " id="menu-toggle"><span class="icons-menus"></span></div>
       
       <div class="topbar-controls">
            <div class="admin-dropdown topbaricon pull-right">
            <span class="icons-users"></span> <span class="topbar-text" >  
            		${pageContext.request.remoteUser}</span> <span class="caret"></span>
            </div>         
            <div class="topbaricon pull-right"><span class="icons-cogs"></span></div>
            <div class="topbaricon pull-right"><span class="icons-searchs"></span></div>
            <div class=" pull-right"></div>
            </div>
        
    </div>
    <div class="brdcrmbar">
        <ol class="breadcrumb">
          <li><a href="home"><span class="glyphicon glyphicon-home"></span>&nbsp;&nbsp; Home</a></li>
          <c:if test="${pageContext.request.servletPath !='/home'}">
           		<c:if test="${pageContext.request.servletPath =='/mststyleheaders'}">
           		  	<li class="active"> 
			          	<a href="${pageContext.request.requestURL}">
			          		<span class="glyphicon"></span>
			          			&nbsp;&nbsp; Styles
			          	</a>
		          	</li>
	          	 </c:if>
	          	 <c:if test="${pageContext.request.servletPath =='/mststyleheaderform'}">
	          	   <li > 
			          	<a href="mststyleheaders">
			          		<span class="glyphicon"></span>
			          			&nbsp;&nbsp; Styles
			          	</a>
		          	</li>
	          	   <li class="active"> 
			          	<a href="mststyleheaderform">
			          		<span class="glyphicon"></span>
			          			&nbsp;&nbsp; Style Form
			          	</a>
		          	</li>
	          	 </c:if>
	          	 <c:if test="${pageContext.request.servletPath =='/mststylemasterview'}">
	          	   	<li > 
			          	<a href="mststyleheaders">
			          		<span class="glyphicon"></span>
			          			&nbsp;&nbsp; Styles
			          	</a>
		          	</li>
	          	   	<li class="active"> 
			          	<a href="mststylemasterview">
			          		<span class="glyphicon"></span>
			          			&nbsp;&nbsp; Style View
			          	</a>
		          	</li>
	          	 </c:if>
	          	 
	          	 <c:if test="${pageContext.request.servletPath =='/mststylerouteoperations'}">
	          	   	<li class="active"> 
			          	<a href="mststylerouteoperations">
			          		<span class="glyphicon"></span>
			          			&nbsp;&nbsp; Style Routes
			          	</a>
		          	</li>
	          	 </c:if>
	          	 <c:if test="${pageContext.request.servletPath =='/mststylerouteoperationform'}">
	          	   	<li > 
			          	<a href="mststylerouteoperations">
			          		<span class="glyphicon"></span>
			          			&nbsp;&nbsp; Style Routes
			          	</a>
		          	</li>
	          	   	<li class="active"> 
			          	<a href="mststylerouteoperationform">
			          		<span class="glyphicon"></span>
			          			&nbsp;&nbsp; Style Routes form
			          	</a>
		          	</li>
	          	 </c:if>
	          	 <c:if test="${pageContext.request.servletPath =='/mststylerouteview'}">
	          	   	<li > 
			          	<a href="mststylerouteoperations">
			          		<span class="glyphicon"></span>
			          			&nbsp;&nbsp; Style Routes
			          	</a>
		          	</li>
	          	   	<li class="active"> 
			          	<a href="mststylerouteoperationform">
			          		<span class="glyphicon"></span>
			          			&nbsp;&nbsp; Style Route view
			          	</a>
		          	</li>
	          	 </c:if>
	          	 <c:if test="${pageContext.request.servletPath =='/merprecostsheets'}">
	          	   	<li class="active"> 
			          	<a href="merprecostsheets">
			          		<span class="glyphicon"></span>
			          			&nbsp;&nbsp; Pre-Cost Sheets
			          	</a>
		          	</li>
	          	   	
	          	 </c:if>
	          	 <c:if test="${pageContext.request.servletPath =='/merprecostsheetsview'}">
	          	   	<li > 
			          	<a href="merprecostsheets">
			          		<span class="glyphicon"></span>
			          			&nbsp;&nbsp; Pre-Cost Sheets
			          	</a>
		          	</li>
	          	   	<li class="active"> 
			          	<a href="merprecostsheetsview">
			          		<span class="glyphicon"></span>
			          			&nbsp;&nbsp;View Pre-Cost Sheets
			          	</a>
		          	</li>
	          	 </c:if>
	          	 <c:if test="${pageContext.request.servletPath =='/merprecostsheetform'}">
	          	   	<li > 
			          	<a href="merprecostsheets">
			          		<span class="glyphicon"></span>
			          			&nbsp;&nbsp; Pre Cost Sheets
			          	</a>
		          	</li>
	          	   	<li class="active"> 
			          	<a href="merprecostsheetform">
			          		<span class="glyphicon"></span>
			          			&nbsp;&nbsp; Pre Cost Sheets form
			          	</a>
		          	</li>
	          	 </c:if>
	          	 <c:if test="${pageContext.request.servletPath =='/mststylewippointss'}">
	          	   	<li class="active"> 
			          	<a href="mststylewippointss">
			          		<span class="glyphicon"></span>
			          			&nbsp;&nbsp; WIP Point Master
			          	</a>
		          	</li>
	          	 </c:if>
	          	 <c:if test="${pageContext.request.servletPath =='/mercostsheethdrs'}">
	          	   	<li class="active"> 
			          	<a href="mercostsheethdrs">
			          		<span class="glyphicon"></span>
			          			&nbsp;&nbsp; Final Cost Sheet
			          	</a>
		          	</li>
	          	 </c:if>
	          	 <c:if test="${pageContext.request.servletPath =='/mercostsheethdrform'}">
	          	   	<li class="active"> 
			          	<a href="mercostsheethdrform">
			          		<span class="glyphicon"></span>
			          			&nbsp;&nbsp; Final Cost Sheet Form
			          	</a>
		          	</li>
	          	 </c:if>
	          	 <c:if test="${pageContext.request.servletPath =='/mercostsheethdrview'}">
		          	<li class="active"> 
			          	<a href="mercostsheethdrs">
			          		<span class="glyphicon"></span>
			          			&nbsp;&nbsp; Final Cost Sheet
			          	</a>
		          	</li>
	          	 </c:if>
	          	  <c:if test="${pageContext.request.servletPath =='/merordersheethdrform'}">
	          	   	<li class="active"> 
			          	<a href="merordersheethdrform">
			          		<span class="glyphicon"></span>
			          			&nbsp;&nbsp; Order Sheet
			          	</a>
		          	</li>
	          	 </c:if>
	          	  <c:if test="${pageContext.request.servletPath =='/merordersheethdrs'}">
		          	<li class="active"> 
			          	<a href="merordersheethdrs">
			          		<span class="glyphicon"></span>
			          			&nbsp;&nbsp; Planning Sheets
			          	</a>
		          	</li>
	          	 </c:if>
	          	 
	          	
	          	<%-- <%out.println(request.getServletPath());%>
		          <c:if test="${request.getServletPath() == '/mststyleheaders'}"> /mststylerouteoperations
		          	<%out.println("Style Master");%>
		          </c:if> --%>
          </c:if>
        </ol>
    </div>
    <div class="modal fade drop-down-select-model model-popup-fix" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true" id="schmodalpopup"></div>									
    
