<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="merordersheetorderDetail.title"/></title>
    <meta name="heading" content="<fmt:message key='merordersheetorderDetail.heading'/>"/>
</head>


<c:set var="delObject" scope="request">
	<fmt:message key="merordersheetorderList.merordersheetorder"/>
</c:set>

<script type="text/javascript">
	var msgDelConfirm = "<fmt:message key="delete.confirm"><fmt:param value="${delObject}"/></fmt:message>";
</script>


<div class="row form-group paddingleft20"> <!-- NAVIGATION PILLS -->
	<div class="col-xs-7">
		<h2>Order Sheet - Processing Order</h2>
	</div>

	<div class="col-xs-5 styletoure-hrline-fcs">
		<ul class="nav nav-justified setup-panel" id="myTab">
			<li class="active"><a href="#addNewFinalCostSheet" data-toggle="tab">
				<button type="button" class="btn btn-default btn-circle"><span class="fa fa-dollar"></span></button>
				<p class="list-group-item-text">Add Final Cost Sheet</p> </a>
			</li>
			<li><a href="#quantitiyallocation" data-toggle="tab">
				<button type="button" class="btn btn-default btn-circle"><span class="fa  fa-cube"></span></button>
				<p class="list-group-item-text">Quantity Allocation</p></a>
			</li>
			<li><a href="#bomcreation" data-toggle="tab">
				<button type="button" class="btn btn-default btn-circle"><span class="fa fa-file-text-o"></span></button>
				<p class="list-group-item-text">BOM Creation</p></a>
			</li>
			<li><a href="#indent" data-toggle="tab">
				<button type="button" class="btn btn-default btn-circle"><span class="fa fa-indent"></span></button>
				<p class="list-group-item-text">Indent</p></a>
			</li>
		</ul>
	</div>
      
</div>  <!-- NAVIGATION PILLS END-->
 
<div class="tab-content">  <!-- TAB CONTENT MAIN -->
	<div class="tab-pane active" id="addNewFinalCostSheet">
		<form:errors path="*" cssClass="alert alert-danger alert-dismissable" element="div"/>
		<form:form commandName="merordersheetorder" method="GET" action="merordersheetorderform" cssClass="well"
           id="merordersheetorderForm" onsubmit="return validateMerordersheetorder(this)">
		<div class="row paddingleft20">
	  	
			<div class="col-sm-4 col-md-4 "> <!-- begin first column -->
		  
				<div class="form-group formwithsearch marginbottom20"> <!-- begin buyer serch -->
					<div class="icon-addon addon-md">
						<label for="exampleInputEmail1">Buyer </label>
						<select required="required" class="form-control"  type="text" name="custCode" id="id_custCode" onfocus="getOptions('id_custCode','mstcustomer')" >
							<c:if test="${mststyleheader.id.custCode!=null}">
								<option selected="selected">${mststyleheader.id.custCode}</option>
							</c:if>
							<c:if test="${mststyleheader.id.custCode ==null}">
								<option selected="selected">${param.custCode}</option>
							</c:if>
						</select>					
					</div>		  
				</div> 
			
				<div>
					<button type="button" class="btn btn-primary btn-xs formsearchbtn " ${disabled2} onclick="$('#id_custCode').trigger('onfocus'); addmodalpopup('id_custCode')" type="button" class="btn btn-primary btn-xs dropdown-toggle " data-toggle="modal" data-target="#schmodalpopup" ><span class="glyphicon glyphicon-search"></span> </Button>
				</div>
			
				<div class="clearfix"></div>	<!-- end buyer serch -->

				<div class="form-group formwithsearch marginbottom20">	<!-- begin style location serch -->
					<div class="icon-addon addon-md">
						<label for="exampleInputEmail1">Style Location</label>
						<select  required="required" type="text" name="locationCode" id="id_locationCode" class="form-control" onfocus="getOptions('id_locationCode','mstlocations')"> 
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
				</div> 
			
				<div>
					<button type="button" class="btn btn-primary btn-xs formsearchbtn " ${disabled} onclick="$('#id_locationCode').trigger('onfocus'); addmodalpopup('id_locationCode')" type="button" class="btn btn-primary btn-xs dropdown-toggle " data-toggle="modal" data-target="#schmodalpopup" ><span class="glyphicon glyphicon-search"></span></button>
				</div>
				<div class="clearfix"></div>
			</div> <!-- end first column -->

			<div class="col-sm-4 col-md-4 "> <!-- begin second column -->                                          
			 
				<div class="form-group formwithsearch marginbottom20"> <!-- begin buyer department serch -->
					<div class="icon-addon addon-md">
						<label for="exampleInputEmail1">Buyer Department</label>
						<select  required="required" type="text" name="depCode" id="id_depCode" onfocus="optionsforgencodes('id_depCode','BUYDEM')" class="form-control" >
								<c:if test="${mststyleheader.id.depCode!=null}">
									<option selected="selected">${mststyleheader.id.depCode}</option>
								</c:if>
								<c:if test="${mststyleheader.id.depCode ==null}">
									<option selected="selected">${param.depCode}</option>
								</c:if>
						</select>
					</div>
				</div>  
				<div>
					<button type="button" class="btn btn-primary btn-xs formsearchbtn " ${disabled}  onclick="$('#id_depCode').trigger('onfocus'); addmodalpopup('id_depCode')" type="button" class="btn btn-primary btn-xs dropdown-toggle " data-toggle="modal" data-target="#schmodalpopup" ><span class="glyphicon glyphicon-search"></span></button>
				</div>
				<div class="clearfix"></div>  <!-- end buyer department serch -->

				<div class="form-group formwithsearch marginBottom20"> <!-- begin style serch -->
					<div class="icon-addon addon-md">
						<label for="exampleInputEmail1">Style</label>
						<div class="input-group">
						<input ${disabled}  required="required" type="text" name="styleId" id="id_styleId"  class="form-control" class="typeahead form-control" data-provide="typeahead" value='<c:if test="${mststyleheader.id.styleId!=null}">${mststyleheader.id.styleId}</c:if><c:if test="${mststyleheader.id.styleId ==null}"> <c:if test="${mststyleheader.id.styleId!=null}">${mststyleheader.id.styleId}</c:if><c:if test="${mststyleheader.id.styleId==null}">${param.styleId}</c:if></c:if>' 
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
				<div>
					<button type="button" class="btn btn-primary btn-xs formsearchbtn " onclick="addmodalpopup('id_styleId')" type="button" class="btn btn-primary btn-xs dropdown-toggle " data-toggle="modal" data-target="#schmodalpopup" ><span class="glyphicon glyphicon-search"></span></button>
				</div>
				<div class="clearfix"></div>  <!-- end style serch -->
			</div> <!-- end second column --> 
		
			<div class="col-sm-4 col-md-4 ">  <!-- begin company -->
				<div class="form-group formwithsearch marginbottom20">
					<div class="icon-addon addon-md">
						<label for="exampleInputEmail1">Company</label>
						<c:if test="${mststyleheader.id.compCode !=null}">
							<input ${disabled}  required="required" class="form-control" type="text" name="compCode" id="id_compCode" value="${mststyleheader.id.compCode}"/>
						</c:if>						
						<c:if test="${mststyleheader.id.compCode ==null}">
							<select  required="required" type="text" name="compCode" id="id_compCode" onfocus="getOptions('id_compCode','mstcompany')" class="form-control">
								<option selected="selected">${param.compCode}</option>
							</select>
						</c:if>
					</div>
				</div>  
				<div>
					<button type="button" class="btn btn-primary btn-xs formsearchbtn " ${disabled}  onclick="$('#id_compCode').trigger('onfocus'); addmodalpopup('id_compCode')" type="button" class="btn btn-primary btn-xs dropdown-toggle " data-toggle="modal" data-target="#schmodalpopup" ><span class="glyphicon glyphicon-search"></span></button>  
				</div>
				<div class="clearfix"></div>
			</div>                                                             <!-- end company -->

			<div class="col-sm-4 col-md-4 ">                                    <!-- begin style description -->
				<div class="form-group formwithsearch marginbottom20">
					<div class="icon-addon addon-md">
						<label for="exampleInputEmail1">Style Description</label>
						<input  type="text" name="styleDescription" id="styleDescription" value='<c:if test="${mststyleheader.styleDescription!=null}">${mststyleheader.styleDescription}</c:if><c:if test="${mststyleheader.styleDescription ==null}"><c:if test="${mststyleheader.styleDescription!=null}"> ${mststyleheader.styleDescription}</c:if><c:if test="${mststyleheader.styleDescription==null}">${param.styleDescription}</c:if></c:if>' class="form-control" readonly="readonly">
					</div>
				</div>
				<div class="clearfix"></div>
			</div> <!-- end style description -->
        

			<div class="col-sm-4 col-md-4">
				<div class="form-group formwithsearch marginbottom20">
					<div class="icon-addon addon-md">
						<label for="exampleInputEmail1">Season</label>
						<select required="required" name="season" id="season" class="form-control" onfocus="optionsforgencodes('season','SEASON');" >
							<c:if test="${merordersheethdr.season!=null}">
								<option selected="selected">${merordersheethdr.season}</option>
							</c:if>
							<c:if test="${merordersheethdr.season ==null}">
								<option selected="selected">${param.season}</option>
							</c:if>
						</select>
					</div>
				</div>  
				<div>
					<button type="button" class="btn btn-primary btn-xs formsearchbtn" ${disabled3} onclick="$('#season').trigger('onfocus'); addmodalpopup('season')" type="button" class="btn btn-primary btn-xs dropdown-toggle " data-toggle="modal" data-target="#schmodalpopup" ><span class="glyphicon glyphicon-search"></span></button>
				</div>
				<div class="clearfix"></div>     
			</div>  
		
			<div class="col-sm-4 col-md-4 ">
				<div class="form-group formwithsearch marginbottom20">
					<div class="icon-addon addon-md">
						<label for="exampleInputEmail1">Planning Order Sheet Number</label>
						<c:if test="${merordersheethdr.id.planingOrdersheetNo !=null}">
							<input ${disabled}  required="required" class="form-control" type="text" name="planingOrdersheetNo" id="planingOrdersheetNo" value="${merordersheethdr.id.planingOrdersheetNo}"/>
						</c:if>						
						<c:if test="${merordersheethdr.id.planingOrdersheetNo ==null}">
							<select  required="required" type="text" name="planingOrdersheetNo" id="planingOrdersheetNo" onfocus="getOptions('planingOrdersheetNo','merordersheethdr')" class="form-control">
								<option selected="selected">${param.planingOrdersheetNo}</option>
							</select>
						</c:if>
					</div>
				</div>  
				<div>
					<button type="button" class="btn btn-primary btn-xs formsearchbtn" ${disabled3} onclick="$('#planingOrdersheetNo').trigger('onfocus'); addmodalpopup('planingOrdersheetNo')" type="button" class="btn btn-primary btn-xs dropdown-toggle " data-toggle="modal" data-target="#schmodalpopup" ><span class="glyphicon glyphicon-search"></span></button>
				</div>
				<div class="clearfix"></div>
			</div>
        
			<div class="col-sm-4 col-md-4">
				<button type="submit" class="btn btn-info btn-embossed search-routes-btn"><span class="fa fa-file-o"></span>&nbsp; Create Processing Order</button>
				<button type="button" class="reset  replace-data btn btn-defalt btn-embossed search-routes-btn"><span class="glyphicon glyphicon-refresh"></span>  Reset</button>
			</div>
      
		</div> 
		</form:form>
	 
	 
	 
	 
	 
<div class="row paddingleft20">
       <div class="col-sm-12 col-md-12">
        <div class="panel-group" id="fcsgdetails">
          <div class="panel panel-default">
            <div class="panel-heading" data-toggle="collapse" data-parent="#fcsgdetailsn" data-target="#fcsgdetailsn">
              <h4 class="panel-title">
              <a data-toggle="collapse" data-parent="#fcsgdetailsn" href="#fcsgdetailsn"> 
                 </a><a class="accordion-toggle"> <span class="pull-right slideupdowntoggle glyphicon glyphicon-chevron-up"></span>Planning Order Details</a>  
            </h4>
          </div>
          <div id="fcsgdetailsn" class="panel-collapse collapse" style="height: auto;">
			<div class="panel-body">
			  <div class="row paddingleft20">                 
					<div class="col-sm-5 col-md-5 ">
						<div class="form-group formwithsearch marginbottom20">
							<div class="icon-addon addon-md">
								<label for="exampleInputEmail1">Total Quantity: </label>
								<input type="text" class="form-control"/>
							</div>
						</div>  
							
					<div class="clearfix"></div> 
									   
						<div class="form-group formwithsearch marginbottom20">
							<div class="icon-addon addon-md">
								<label for="exampleInputEmail1">Remarks: </label>
								<textarea class="form-control" rows="3"></textarea>
							 </div>
						</div>  
					<div class="clearfix"></div> 
							  
			</div>
			<div class="col-sm-5 col-md-5 ">
			<div class="form-group formwithsearch marginbottom20">
							<div class="icon-addon addon-md">
								<label for="exampleInputEmail1">Payment Type: </label>
								<select type="text" class="form-control"></select>
							</div>
						</div>  
			</div>
			</div>
			<div class="clearfix"></div>

            </div> <!-- pannel body ends -->
          </div>
        </div>
      </div> 
      </div> 
    </div>		 
				  
	 <div class="row paddingleft20">
      <div class="col-sm-12 col-md-12">
        <div class="panel-group" id="stylebrowser">
          <div class="panel panel-default">
            <div class="panel-heading" data-toggle="collapse" data-parent="#stylebrowser" data-target="#styleBrowserBody">
              <h4 class="panel-title">
              <a data-toggle="collapse" data-parent="#stylebrowser" href="#styleBrowserBody"> 
                 <a class="accordion-toggle"> <span class="pull-right slideupdowntoggle glyphicon glyphicon-chevron-up"></span>Assign Final Cost Sheet</a> </a> 
            </h4>
          </div>
          <div id="styleBrowserBody" class="panel-collapse collapse">
            <div class="panel-body">
                <div class="row">
                    
                    <div class="pull-right margin-addstyleroute">
                      <div class="input-group custom-search-form " style="width: 390px;">
                        <input type="text" class="form-control search_text_box" placeholder="Search and Filter">
                        <span class="input-group-btn-search">
                          <button class="btn btn-info search-form-btn" type="button">
                            <span class="glyphicon glyphicon-search"></span>
                          </button>
                        </span>
                      <a  class="btn btn-warning btn-embossed pull-right addFCS"><span class="glyphicon glyphicon-plus marginRight4"></span>Add FCS</a></div><!-- /input-group -->
                        
                    </div>                   
                </div>
               <div class="dataTables_wrapper">
                <section>
                  <table id="route" class="fcsRout display table table-striped table-bordered" cellspacing="0" >
                      <thead>
                        <tr>
                          <th class="textcenter">Final CS Number</th>
                          <th class="textcenter">Type</th>
                          <th class="textcenter">Component Wise Costing</th>
                          <th class="textcenter">Size Wise</th>
                          <th class="textcenter">Country Wise</th>
                          <th class="textcenter">Average</th>
                        </tr>
                      </thead>
                      <tbody>
                        <tr class="gradeX">                        
                          <td class="textcenter">209657</td>
                          <td class="textcenter">HO</td>
                          <td class="textcenter">YES</td>
                          <td class="textcenter">YES </td>
                          <td class="textcenter">NO</td>
                          <td class="textcenter">YES</td>
                        </tr>              
                      </tbody>
                    </table>
                  </section>
              </div>
            </div>
          </div>
        </div>
      </div> 

      </div> 
    </div>
<!--add content for Add Group here -->

    <div class="row paddingleft20">
      <div class="col-sm-12 col-md-12">
      <div class="panel-group" id="createGroups">
        <div class="panel panel-default">
          <div class="panel-heading" data-toggle="collapse" data-parent="#creatG" data-target="#creatG">
            <h4 class="panel-title">
             <a data-toggle="collapse" data-parent="#createGroups" href="#creatG"> 
               </a><a class="accordion-toggle"> <span class="pull-right slideupdowntoggle glyphicon glyphicon-chevron-up"></span>Groups</a>
          
            </h4>
          </div>
          <div id="creatG" class="panel-collapse collapse" style="height: auto;">
        <div class="panel-body">

        <div class="row">
                    
            <div class="pull-right margin-addstyleroute">
              <div class="input-group custom-search-form " style="width: 390px;">
                
              <a href="#" data-toggle="modal" data-target=".drop-down-add-groups" class="btn btn-warning btn-embossed pull-right"><span class="glyphicon glyphicon-plus marginRight4"></span>Add Group</a></div><!-- /input-group -->
                
            </div>                   
        </div>
        <div class="row"> 

          <div class="col-sm-12 col-md-12">
             <div class="dataTables_wrapper">
              <section>
                <table id="route" class="display table table-striped table-bordered" cellspacing="0">
                    <thead>
                      <tr>
                        <th class="textcenter">Group Name</th>
                        <th class="textcenter">Country</th> 
                        <th class="textcenter">Advance Combination</th>
                        <th class="textcenter">Actions</th>
                      </tr>
                    </thead>
                    <tbody>
                      

                      <tr class="gradeX">
                        <td class="textcenter">
                          Size range 1-5
                        </td>
                        <td class="textcenter">
                          UK
                        </td>
                        <td class="textcenter">
                          <div class="advance-comb">
                              <a class="edit" href="javascript:;"><span class="fa fa-list-alt marginRight3"></span>View Combinations</a>
                            </div>
                        </td>
                        <td class="center">
                          <div class="middle-align-editable">
                            <div class="edit-toggle">
                              <a class="edit" href="javascript:;"><span class="glyphicon glyphicon-pencil"></span> Edit</a>
                            </div>
                            <div class="delete-toggle">
                              <a class="delete" href="javascript:;"><span class="glyphicon glyphicon-remove"></span> Delete </a> 
                            </div>
                          </div>
                        </td>
                      </tr>

                      <tr class="gradeX">
                        <td class="textcenter">
                         Size range 6-7
                        </td>
                        <td class="textcenter">
                          USA
                        </td>
                        <td class="textcenter">
                          <div class="advance-comb">
                              <a class="edit" href="javascript:;"><span class="fa fa-list-alt marginRight3"></span>View Combinations</a>
                            </div>
                        </td>
                        <td class="center">
                          <div class="middle-align-editable">
                            <div class="edit-toggle">
                              <a class="edit" href="javascript:;"><span class="glyphicon glyphicon-pencil"></span> Edit</a>
                            </div>
                            <div class="delete-toggle">
                              <a class="delete" href="javascript:;"><span class="glyphicon glyphicon-remove"></span> Delete </a> 
                            </div>
                          </div>
                        </td>
                      </tr>

                    </tbody>
                  </table>
                </section>
            </div>
          </div>
         </div><!--  row ends  -->

        </div><!-- panel body end  -->


        </div>

      </div>
    </div> 
    </div>

    </div> <!-- end of row -->

	
	<div class="row paddingleft20">
      <div class="col-sm-12 col-md-12">
        <div class="panel-group" id="cGroups">
          <div class="panel panel-default">
          <div class="panel-heading" data-toggle="collapse" data-parent="#createGroBody" data-target="#createGroBody">
              <h4 class="panel-title">
              <a data-toggle="collapse" data-parent="#cGroups" href="#createGroBody"> 
               </a><a class="accordion-toggle"> <span class="pull-right slideupdowntoggle glyphicon glyphicon-chevron-up"></span>Create Group</a>

             </h4>
           </div>
           <div id="createGroBody" class="panel-collapse collapse" style="height: auto;">
            <div class="panel-body">

            <div class="row paddingleft20">

               <div class="col-sm-6 col-md-6 pull-left">
                <div class="form-group formwithsearch marginbottom20">
                  <div class="icon-addon addon-md">
                    <div class="col-sm-5 col-md-5 ">
                      <label for="exampleInputEmail1">Group Name: </label>
                    </div>
                    <div class="col-sm-7 col-md-7 ">
                      <input type="text" class="form-control" />
                    </div>
                  </div>
                </div>  

                <div class="clearfix"></div> 
                
                <div class="form-group formwithsearch marginbottom20">
                  <div class="icon-addon addon-md">
                    <div class="col-sm-5 col-md-5 ">
                      <label for="exampleInputEmail1">Select Country: </label>
                    </div>
                    <div class="col-sm-7 col-md-7 ">
                    <select type="text" class="form-control"></select>
                    </div>
                  </div>
                </div>  
                <div class="clearfix"></div> 

              </div>
              <div class="clearfix"></div>

              </div>  <!-- ROW ENDS -->

              <div class="row"> 

                <div class="col-sm-12 col-md-12">
                 <div class="dataTables_wrapper">
                  <section>
                    <table id="route" class="display table table-striped table-bordered" cellspacing="0">
                      <thead>
                        <tr>
                          <th class="textcenter">Component</th>
                          <th class="textcenter">Color</th> 
                          <th class="textcenter">Size Dimensions</th>
                          <th class="textcenter">Actions</th>
                        </tr>
                      </thead>
                      <tbody>
                        

                        <tr class="gradeX">
                          <td class="textcenter">
                            <select type="text" class="form-control"></select>
                          </td>
                          <td class="textcenter fcstdChosen">
                              <select data-placeholder="Select Color" class="chosen-select" multiple style="width:100%;" tabindex="4" style="width: 104px !important;">
                                <option value=""></option>
                                <option value="1">Red</option>
                                <option value="2">Gree</option>
                                <option value="2">Blue</option>
                                <option value="2">Black</option>
                                <option value="2">Yellow</option>
                              </select>  
                          </td>
                          <td class="textcenter">
                            <div class="advance-comb2">
                              <a class="edit" href="javascript:;"><span class="fa fa-crop marginRight3"></span>Set Size wise dimentions</a>
                            </div>
                          </td>
                          <td class="center">
                            <div class="middle-align-editable">
                              <div class="edit-toggle view-btn">
                                <a class="edit" href="javascript:;"><span class="glyphicon glyphicon-plus"></span> Add</a>
                              </div>
                              <div class="delete-toggle">
                                <a class="delete" href="javascript:;"><span class="glyphicon glyphicon-remove-sign"></span>  Clear</a> 
                              </div>
                              
                            </div>
                          </td>
                        </tr>

                        <tr class="gradeX">
                          <td class="textcenter">
                            Shirt
                          </td>
                          <td class="textcenter">
                            Red
                          </td>
                          <td class="textcenter">
                            <div class="advance-comb2">
                              <a class="edit" href="javascript:;"><span class="fa fa-crop marginRight3"></span>Set Size wise dimentions</a>
                            </div>
                          </td>
                          <td class="center">
                            <div class="middle-align-editable">
                              <div class="edit-toggle">
                                <a class="edit" href="javascript:;"><span class="glyphicon glyphicon-pencil"></span> Edit</a>
                              </div>
                              <div class="delete-toggle">
                                <a class="delete" href="javascript:;"><span class="glyphicon glyphicon-remove"></span> Delete </a> 
                              </div>
                            </div>
                          </td>
                        </tr>

                      </tbody>
                    </table>
                  </section>
                </div>
              </div>
              </div> <!-- row ends -->
	 <div class="row paddingleft20">
      <div class="col-sm-12 col-md-12 advance-comb ">
            <a class="table_show_hide" href="javascript:;"><span class="fa fa-chevron-right marginRight3"></span>View Group Combination</a>
      </div>
    </div> <!-- row ends -->
<div class="row paddingleft20 showHideTable">
      <div class="col-sm-12 col-md-12">
            <table class="table table-bordered">
                <thead>
                  <tr>
                    <th>Country</th>
                    <th>Component</th>
                    <th>Color</th>
                    <th>Fit</th>
                    <th colspan="14" style="text-align:center">Size</th>
                  </tr>
                  </thead>
                  <tbody>
                  <tr>
                    <td rowspan="10">UK</td>
                    <td rowspan="10">Shirt</td>
                    <td rowspan="5">Blue</td>
                    <td></td>
                    <td class="table-size-header">XS</td>
                    <td class="table-size-header">S</td>
                    <td class="table-size-header">M</td>
                    <td class="table-size-header">L</td>
                    <td class="table-size-header">XL</td>
                    <td class="table-size-header">XXl</td>
                  </tr>
                  <tr>
                    <td>BB</td>
                    <td>
                          <input type="checkbox" class="" />
                        </td>
                    <td><input type="checkbox" class="" /></td>
                    <td><input type="checkbox" class="" /></td>
                    <td><input type="checkbox" class="" /></td>
                    <td><input type="checkbox" class="" /></td>
                    <td><input type="checkbox" class="" /></td>
                  </tr>
                  <tr>
                    <td>D</td>
                    <td><input type="checkbox" class="" /></td>
                    <td><input type="checkbox" class="" /></td>
                    <td><input type="checkbox" class="" /></td>
                    <td><input type="checkbox" class="" /></td>
                    <td><input type="checkbox" class="" /></td>
                    <td><input type="checkbox" class="" /></td>
                  </tr>
                  <tr>

                    <td>DD</td>
                    <td><input type="checkbox" class="" /></td>
                    <td><input type="checkbox" class="" /></td>
                    <td><input type="checkbox" class="" /></td>
                    <td><input type="checkbox" class="" /></td>
                    <td><input type="checkbox" class="" /></td>
                    <td><input type="checkbox" class="" /></td>
                  </tr>
                  <tr>
                    <td>C</td>
                    <td><input type="checkbox" class="" /></td>
                    <td><input type="checkbox" class="" /></td>
                    <td><input type="checkbox" class="" /></td>
                    <td><input type="checkbox" class="" /></td>
                    <td><input type="checkbox" class="" /></td>
                    <td><input type="checkbox" class="" /></td>
                  </tr>
                  <tr>
				    <td rowspan="5">Green</td>
                    <td>G</td>
                    <td><input type="checkbox" class="" /></td>
                    <td><input type="checkbox" class="" /></td>
                    <td><input type="checkbox" class="" /></td>
                    <td><input type="checkbox" class="" /></td>
                    <td><input type="checkbox" class="" /></td>
                    <td><input type="checkbox" class="" /></td>
                  </tr>
                  <tr>
                    <td rowspan="4" style="display:none;">Sleeve</td>
                    <td>A</td>
                    <td><input type="checkbox" class="" /></td>
                    <td><input type="checkbox" class="" /></td>
                    <td><input type="checkbox" class="" /></td>
                    <td><input type="checkbox" class="" /></td>
                    <td><input type="checkbox" class="" /></td>
                    <td><input type="checkbox" class="" /></td>
                  </tr>
                  <tr>
                    <td>B</td>
                    <td><input type="checkbox" class="" /></td>
                    <td><input type="checkbox" class="" /></td>
                    <td><input type="checkbox" class="" /></td>
                    <td><input type="checkbox" class="" /></td>
                    <td><input type="checkbox" class="" /></td>
                    <td><input type="checkbox" class="" /></td>
                  </tr>
                  <tr>
                    <td>C</td>
                    <td><input type="checkbox" class="" /></td>
                    <td><input type="checkbox" class="" /></td>
                    <td><input type="checkbox" class="" /></td>
                    <td><input type="checkbox" class="" /></td>
                    <td><input type="checkbox" class="" /></td>
                    <td><input type="checkbox" class="" /></td>
                  </tr>
                  <tr>
                    <td>D</td>
                    <td><input type="checkbox" class="" /></td>
                    <td><input type="checkbox" class="" /></td>
                    <td><input type="checkbox" class="" /></td>
                    <td><input type="checkbox" class="" /></td>
                    <td><input type="checkbox" class="" /></td>
                    <td><input type="checkbox" class="" /></td>
                  </tr>
                  </tbody>
                </table> 
          </div>
        </div>
		
		 <div id="submision" class="submit-button styl-rt-submission-btn pull-right marginRight0 marginTop30">
          <button class="btn btn-info btn-lg btn-embossed submitBtn">Submit</button>
		 <a><button id="back3" class="btn btn-default btn-lg">Clear All</button></a>
        </div>
            </div><!-- panel body end  -->


          </div>

        </div>
      </div> 
    </div>

    </div> <!-- row ends -->

   
     <div class="row paddingleft20">
          <div class="col-sm-12 col-md-12">
          </div>

          <div class="clearfix"></div>

          <div class="col-sm-8 col-md-8 col-xs-8 marginTop30">
              <div class="aprovedby">
                  <span class="glyphicon glyphicon-ok aprovedicon"></span>
                  <div class="aprovedbytitle">
                      Created By: Jhon Doe<br>
                      Created On: dd/mm/yyyy
                  </div>
              </div>
              <div class="createdby">
                  <span class="glyphicon glyphicon-edit createdicon"></span>
                  <div class="aprovedbytitle">
                      Modified By: Jhon Doe<br>
                      Modified On: dd/mm/yyyy
                  </div>
              </div>
              <div class="modifiedby">
                  <span class="glyphicon glyphicon-refresh modifiedicon"></span>
                  <div class="aprovedbytitle">
                      Approved By: Jhon Doe<br>
                      Approved On: dd/mm/yyyy
                  </div>
              </div>
          </div>

          <div id="submision" class="submit-button styl-rt-submission-btn pull-right marginRight0 marginTop30">
              <a><button id="back3" class="btn btn-default btn-lg">Back</button></a>
              <button class="btn btn-info btn-lg btn-embossed">Next</button>
          </div>
      </div> <!-- row ends -->
   </div><!-- end of tab content 1 -->
   
   
    <!-- Start of tab content 2 -->  
<div class="tab-pane" id="quantitiyallocation">	 
      <!--add content for Add Group here -->
	  
	<div class="row paddingleft20">
      <div class="col-sm-12 col-md-12">
        <div class="panel-group" id="createdorders">
          <div class="panel panel-default">
            <div class="panel-heading" data-toggle="collapse" data-parent="#createdorders" data-target="#createdordersBody">
              <h4 class="panel-title">
              <a data-toggle="collapse" data-parent="#createdorders" href="#createdordersBody"> 
                 <a class="accordion-toggle"> <span class="pull-right slideupdowntoggle glyphicon glyphicon-chevron-up"></span>Created Orders</a> </a> 
            </h4>
          </div>
          <div id="createdordersBody" class="panel-collapse collapse">
            <div class="panel-body">
                <div class="row">
                    
                    <div class="pull-right marginBottom20 margin-addstyleroute">
                      <div class="input-group custom-search-form " style="width: 390px;">
                        <input type="text" class="form-control" placeholder="Search and Filter">
                        <span class="input-group-btn">
                          <button class="btn btn-info search-form-btn" type="button">
                            <span class="glyphicon glyphicon-search"></span>
                          </button>
                        </span>
                      <a  class="btn btn-warning btn-embossed pull-right addFCS"><span class="glyphicon glyphicon-plus marginRight4"></span>Add Order</a></div><!-- /input-group -->
                        
                    </div>                   
                </div>
               <div class="dataTables_wrapper Scroll-for-datatable">
                <section class="fcsSectioncost">
                  <table id="route" class="fcsRout display table table-striped table-bordered" cellspacing="0" >
                      <thead>
                        <tr>
                          <th style="text-align:center">Sales Order</th>
                          <th style="text-align:center">Buyer PO Number</th>
                          <th style="text-align:center">Quantity</th>
                          <th style="text-align:center">Size Breakup</th>
                          <th style="text-align:center">Delivery Type</th>
                          <th style="text-align:center">Order Status</th>
						  <th class="headcol textcenter headcolnewclass">View Deliveries</th>
                          <th class="headcol1 textcenter">Add to BOM</th>
                          <th class="headcol2 textcenter openasnew">Open as new</th>                      
                          <th class="textcenter headcol3 actionwidth">Actions</th>
                        </tr>
                      </thead>
                      <tbody>
                        <tr class="gradeX">                        
                          <td style="text-align:center">31102014-001</td>
                          <td style="text-align:center">PO31102014</td>
                          <td style="text-align:center">20000</td>
                          <td style="text-align:center">Ratio</td>
                          <td style="text-align:center">Local</td>
                          <td style="text-align:center">Complete</td>
                          <td class="headcol headcolnewclass">
						  <div class="advance-comb">
                               <a class="edit" href="#" data-toggle="modal" data-target=".drop-down-select-models"><span class="fa fa-list-alt marginRight3"></span>View Deliveries</a>
							   </div>
                          </td>
						 <td class="headcol1 textcenter">
                                <a href="#"><span class="glyphicon glyphicon-plus"></span> Add to BOM</a>
						  </td>
                          <td class="headcol2 openasnew">
                                <div class="operations-toggle">
                                <a href="#"><span class="glyphicon glyphicon-folder-open"></span> Open as new </a>
                              </div>
                          </td>                         
                          <td class="center headcol3 actionwidth"><div class="middle-align">
                              <div class="edit-toggle-styl-rt edit-toggle edit-toggle">
                                <a href="#"><span class="glyphicon glyphicon-pencil"></span> Edit</a>
								</div>
                              <div class="delete-toggle-styl-rt delete-toggle delete-toggle">
                                  <a href="#" data-toggle="modal" data-target=".delete-confirmation"><span class="glyphicon glyphicon-remove"></span> Delete </a> 
                              </div>
                            </div></td>
                        </tr>

                        <tr class="gradeX">                        
                          <td style="text-align:center">31102014-002</td>
                          <td style="text-align:center">PO31102015</td>
                          <td style="text-align:center">10000</td>
                          <td style="text-align:center">Non-Ratio</td>
                          <td style="text-align:center">Local</td>
                          <td style="text-align:center">Complete</td>
                          <td class="headcol headcolnewclass">
						  <div class="advance-comb">
                            <a class="edit" href="javascript:;"><span class="fa fa-list-alt marginRight3"></span>View Deliveries</a>
							</div>
                          </td>
						  <td class="headcol1 textcenter">
                                <a href="#"><span class="glyphicon glyphicon-plus"></span> Add to BOM</a>
						  </td>
                          <td class="headcol2 openasnew">
                              <div class="operations-toggle">
                                <a href="#"><span class="glyphicon glyphicon-folder-open"></span> Open as new </a>
                              </div>
                          </td>                         
                          <td class="center headcol3 actionwidth"><div class="middle-align">
                              <div class="edit-toggle-styl-rt edit-toggle edit-toggle">
                                <a href="#"><span class="glyphicon glyphicon-pencil"></span> Edit</a>
                              </div>
                              <div class="delete-toggle-styl-rt delete-toggle delete-toggle">
                                  <a href="#" data-toggle="modal" data-target=".delete-confirmation"><span class="glyphicon glyphicon-remove"></span> Delete </a> 
                              </div>
                            </div></td>
                        </tr>             
                      </tbody>
                    </table>
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
      <div class="panel-group" id="addOrder">
        <div class="panel panel-default">
          <div class="panel-heading" data-toggle="collapse" data-parent="#creatO" data-target="#creatO">
            <h4 class="panel-title">
             <a data-toggle="collapse" data-parent="#addOrder" href="#creatO"> 
               </a><a class="accordion-toggle"> <span class="pull-right slideupdowntoggle glyphicon glyphicon-chevron-up"></span>Add Order</a>
          
            </h4>
          </div>
     <div id="creatO" class="panel-collapse collapse" style="height: auto;">
        <div class="panel-body">
        <div class="row"> 
          <div class="col-sm-12 col-md-12">
             <div class="col-sm-4 col-md-4 ">
			  <div class="form-group formwithsearch marginbottom20">
			   <div class="icon-addon addon-md">
					<label for="exampleInputEmail1">Order Number</label>
					<input type="text" class="form-control" disabled="disabled">
			   </div>
			  </div>  
			<div class="clearfix"></div> 
			
			
			<div class="form-group formwithsearch marginbottom20">
					  <div class="icon-addon addon-md">
						<label for="exampleInputEmail1">Buy Number</label>
						<input type="text" class="form-control">
					  </div>
					</div>  
					<div class="clearfix"></div> 

					<div class="form-group formwithsearch marginbottom20">
					  <div class="icon-addon addon-md">
						<label for="exampleInputEmail1">Size Breakup</label>
						<select class="form-control">
							  <option value="1">Ratio</option>
							  <option value="2">Non-Ratio</option>
						  </select>
					  </div>
					</div>  
					<div class="clearfix"></div> 
					</div>

					<div class="col-sm-4 col-md-4 ">
					  <div class="form-group formwithsearch marginbottom20">
					  <div class="icon-addon addon-md">
						<label for="exampleInputEmail1">Buyer PO</label>
						<input type="text" class="form-control">
						<span class="caret dropdowncaret"></span>
					  </div>
					</div>  
					<div class="clearfix"></div> 
					
					<div class="form-group formwithsearch marginbottom20">
					  <div class="icon-addon addon-md">
						<label for="exampleInputEmail1">Planning Cut</label>
						<input type="text" class="form-control">
						<span class="caret dropdowncaret"></span>
					  </div>
					</div>  
					<div class="clearfix"></div> 

					<div class="form-group formwithsearch marginBottom20">
					  <div class="icon-addon addon-md">
						<label for="exampleInputEmail1">Order Status</label>
						  <select class="form-control">
							  <option value="1">Confirmed</option>
							  <option value="2">Not Confirmed</option>
						  </select>
					  </div>
					</div>  
					<div class="clearfix"></div> 
					</div>
		
        <div class="col-sm-4 col-md-4 ">
            <div class="form-group formwithsearch marginbottom20">
            <div class="icon-addon addon-md">
              <label for="exampleInputEmail1">Quantity</label>
              <input type="text" class="form-control">
              <span class="caret dropdowncaret"></span>
            </div>
          </div>  
          <div class="clearfix"></div>
        </div>

        <div class="col-sm-4 col-md-4 ">
            <div class="form-group formwithsearch marginbottom20">
            <div class="icon-addon addon-md">
              <label for="exampleInputEmail1">Allocation</label>
              <select class="form-control">
			      <option value="1">Ratio Allocation</option>
				  <option value="2">Equally Allocation</option>
				  <option value="3">Custom Allocation</option>
			  </select>
            </div>
          </div>  
          <div class="clearfix"></div>
		  
		  
		 <div id="submision" class="submit-button styl-rt-submission-btn pull-left marginLeft15 marginTop30">
          <a><button id="back3" class="btn btn-info btn-md btn-embossed submitBtn">Allocate</button></a>
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button class="btn btn-default btn-md">Clear</button>
        </div>
        </div>
	
	
		<div class="row">
          <div class="col-md-12"><h3 class="add-styl-rt">Quantities</h3><hr></div>
        </div>
		
		 <div class="col-sm-12 col-md-12">
	       <div class="dataTables_wrapper Scroll-for-datatable">
				  <section class="sectioncostsheet">
				     <table class="table table-bordered" id="route">
								<thead>
								<tr>
									<th class="headcolx">Country</th>
									<th class="headcoly">Component</th>
									<th class="headcolz">Color</th>
									<th class="headcolzx">Fit</th>
									<th colspan="14"><div class="sizechange">Size</div></th>
								</tr>
								</thead>
								<tbody>
								<tr>
									<td rowspan="10" class="headcolx1"><div class="heights">UK</div></td>
									<td rowspan="6" class="headquantity_component"><div class="textshirt_top">Shirt</div></td>
									<td rowspan="3" class="colorblue_quantity"><div class="textclass" style="margin-top:89%">Blue</div></td>
									<td class="headcolzx" style="display:none"></td>
									<td class="table-size-header">XS</td>
									<td class="table-size-header">S</td>
									<td class="table-size-header">M</td>
									<td class="table-size-header">L</td>
									<td class="table-size-header">XL</td>
									<td class="table-size-header">XXL</td>
								</tr>
								<tr>
									<td  class="headcolzx">BB</td>
									<td>
										<input type="textbox" class="newtextbox" />
									</td>
									<td><input type="textbox" class="newtextbox" /></td>
									<td><input type="textbox" class="newtextbox" /></td>
									<td><input type="textbox" class="newtextbox" /></td>
									<td><input type="textbox" class="newtextbox" /></td>
									<td><input type="textbox" class="newtextbox" /></td>
								</tr>
								<tr>
									<td class="headcolzx">D</td>
									<td><input type="textbox" class="newtextbox" /></td>
									<td><input type="textbox" class="newtextbox" /></td>
									<td><input type="textbox" class="newtextbox" /></td>
									<td><input type="textbox" class="newtextbox" /></td>
									<td><input type="textbox" class="newtextbox" /></td>
									<td><input type="textbox" class="newtextbox" /></td>
								</tr>
								<tr>
									<td rowspan="3" class="clorgreen_quantity"><div class="textclass" style="margin-top: 40%;">Green<div></td>
									<td  class="headcolzx">DD</td>
									<td><input type="textbox" class="newtextbox" /></td>
									<td><input type="textbox" class="newtextbox" /></td>
									<td><input type="textbox" class="newtextbox" /></td>
									<td><input type="textbox" class="newtextbox" /></td>
									<td><input type="textbox" class="newtextbox" /></td>
									<td><input type="textbox" class="newtextbox" /></td>
								</tr>
								<tr>
									<td class="headcolzx">C</td>
									<td><input type="textbox" class="newtextbox" /></td>
									<td><input type="textbox" class="newtextbox" /></td>
									<td><input type="textbox" class="newtextbox" /></td>
									<td><input type="textbox" class="newtextbox" /></td>
									<td><input type="textbox" class="newtextbox" /></td>
									<td><input type="textbox" class="newtextbox" /></td>
								</tr>
								<tr>
									<td class="headcolzx">G</td>
									<td><input type="textbox" class="newtextbox" /></td>
									<td><input type="textbox" class="newtextbox" /></td>
									<td><input type="textbox" class="newtextbox" /></td>
									<td><input type="textbox" class="newtextbox" /></td>
									<td><input type="textbox" class="newtextbox" /></td>
									<td><input type="textbox" class="newtextbox" /></td>
								</tr>
								<tr>
									<td rowspan="4" class="headcoly1x1" style="display:none;"><div class="heights1">Sleeve</div></td>
									<td rowspan="2"  class="headcolz2" style="display:none;"><div class="textclass1">Red</div></td>
									<td class="headcolzx">A</td>
									<td><input type="textbox" class="newtextbox" /></td>
									<td><input type="textbox" class="newtextbox" /></td>
									<td><input type="textbox" class="newtextbox" /></td>
									<td><input type="textbox" class="newtextbox" /></td>
									<td><input type="textbox" class="newtextbox" /></td>
									<td><input type="textbox" class="newtextbox" /></td>
								</tr>
								<tr>
									<td class="headcolzx">B</td>
									<td><input type="textbox" class="newtextbox" /></td>
									<td><input type="textbox" class="newtextbox" /></td>
									<td><input type="textbox" class="newtextbox" /></td>
									<td><input type="textbox" class="newtextbox" /></td>
									<td><input type="textbox" class="newtextbox" /></td>
									<td><input type="textbox" class="newtextbox" /></td>
								</tr>
								<tr>
									<td rowspan="2" class="headcolz2" style="display:none;"><div class="textclass1">White</div></td>
									<td class="headcolzx">C</td>
									<td><input type="textbox" class="newtextbox" /></td>
									<td><input type="textbox" class="newtextbox" /></td>
									<td><input type="textbox" class="newtextbox" /></td>
									<td><input type="textbox" class="newtextbox" /></td>
									<td><input type="textbox" class="newtextbox" /></td>
									<td><input type="textbox" class="newtextbox" /></td>
								</tr>
								<tr>
									<td class="headcolzx">D</td>
									<td><input type="textbox" class="newtextbox" /></td>
									<td><input type="textbox" class="newtextbox" /></td>
									<td><input type="textbox" class="newtextbox" /></td>
									<td><input type="textbox" class="newtextbox" /></td>
									<td><input type="textbox" class="newtextbox" /></td>
									<td><input type="textbox" class="newtextbox" /></td>
								</tr>
								</tbody>
							</table>
					   </section>
                </div>					   
             </div><!--data table end-->
			 
			 
		<div class="row">
          <div class="col-md-12"><h3 class="add-styl-rt">Add Deliveries</h3><hr></div>
        </div>
		
    <div class="dataTables_wrapper Scroll-for-datatable-add-row-matirials">
          <section>
              <table id="route" class="display table table-striped table-bordered" cellspacing="0">
                  <thead>
                  <tr>
                      <th>Deliv. Quantitiy</th>
                      <th>Delivery Date</th>
                      <th>Country</th>
                      <th>Minimum Allow %</th>
                      <th>Maxumum Allow %</th>
                      <th>Port</th>
                      <th>Payment Types</th>
                      <th>Delivery Term</th>
                      <th>Shipping Mode</th>
                      <th>Agent Mode</th>
                      <th>Currency Code</th>
					  <th>Exchange Rate %</th>
                      <th>Merchandiser</th>
                      <th class="textcenter headcol3">Actions</th>
                  </tr>
                  </thead>
                  <tbody>
                  <tr class="gradeX">
                      <td style="text-align:center">1000</td>
                      <td style="text-align:center">1/31/2015</td>
                      <td style="text-align:center">USA</td>
                      <td style="text-align:center">20</td>
                      <td style="text-align:center">15</td>
                      <td style="text-align:center">Local</td>
                      <td style="text-align:center">TT</td>
                      <td style="text-align:center">FOB</td>
                      <td style="text-align:center">Sea</td>
                      <td style="text-align:center">Tommy Hilfiger</td>
                      <td style="text-align:center">USD</td>
					  <td style="text-align:center">1.3</td>
                      <td style="text-align:center">Tommy Hilfiger</td>
                      <td class="center headcol3"><div class="middle-align">
                          <div class="edit-toggle-styl-rt edit-toggle edit-toggle marginLeft20">
                              <a href="#"><span class="glyphicon glyphicon-pencil"></span> Edit</a>
                          </div>

                          <div class="delete-toggle-styl-rt delete-toggle delete-toggle pull-right marginRight48">
                              <a href="#" data-toggle="modal" data-target=".delete-confirmation"><span class="glyphicon glyphicon-remove"></span> Delete </a>
                          </div>
                      </div></td>
                  </tr>

                  <tr class="gradeX">
                      <td style="text-align:center">2000</td>
                      <td style="text-align:center">4/20/2015</td>
                      <td style="text-align:center">USA</td>
                      <td style="text-align:center">25</td>
                      <td style="text-align:center">10</td>
                      <td style="text-align:center">Local</td>
                      <td style="text-align:center">TT</td>
                      <td style="text-align:center">FOB</td>
                      <td style="text-align:center">Sea</td>
                      <td style="text-align:center">Tommy Hilfiger</td>
                      <td style="text-align:center">EURO</td>
					  <td style="text-align:center">1.5</td>
                      <td style="text-align:center">Tommy Hilfiger</td>
                      <td class="center headcol3"><div class="middle-align">
                          <div class="edit-toggle-styl-rt edit-toggle edit-toggle marginLeft20">
                              <a href="#"><span class="glyphicon glyphicon-pencil"></span> Edit</a>
                          </div>

                          <div class="delete-toggle-styl-rt delete-toggle delete-toggle pull-right marginRight48">
                              <a href="#" data-toggle="modal" data-target=".delete-confirmation"><span class="glyphicon glyphicon-remove"></span> Delete </a>
                          </div>
                      </div></td>
                    </tr>
                  </tbody>
              </table>
          </section>
      </div>
	  
	  		<div class="row margin-top30" style="margin-top:5%">
		<div class="col-sm-4 col-md-4 ">
          <div class="form-group formwithsearch marginbottom20">
              <div class="icon-addon addon-md">
                  <label for="exampleInputEmail1">Deliv.Quantity</label>
                  <input type="text" class="form-control">
              </div>
          </div>
          <div class="clearfix"></div>
      </div>

      <div class="col-sm-4 col-md-4 ">
          <div class="form-group formwithsearch marginbottom20">
              <div class="icon-addon addon-md">
                  <label for="exampleInputEmail1">Delivery Date</label>
                  <input type="text" class="form-control targetDate">
				  <span class="glyphicon glyphicon-calendar dropdowncaret"></span>
              </div>
          </div>
          <div class="clearfix"></div>
      </div>

      <div class="col-sm-4 col-md-4 ">
          <div class="form-group formwithsearch marginbottom20">
              <div class="icon-addon addon-md">
                  <label for="exampleInputEmail1">Country </label>
                  <input type="text" class="form-control">
              </div>
          </div>
          <div class="clearfix"></div>
      </div>

      <div class="col-sm-4 col-md-4 ">
          <div class="form-group formwithsearch marginbottom20">
              <div class="icon-addon addon-md">
                  <label for="exampleInputEmail1">Minimum Allow %</label>
                  <input type="text" class="form-control">
              </div>
          </div>
          <div class="clearfix"></div>
      </div>

      <div class="col-sm-4 col-md-4 ">
          <div class="form-group formwithsearch marginbottom20">
              <div class="icon-addon addon-md">
                  <label for="exampleInputEmail1">Maximum Allow %</label>
                  <input type="text" class="form-control">
              </div>
          </div>
          <div>

          </div>
          <div class="clearfix"></div>
      </div>

      <div class="col-sm-4 col-md-4 ">
          <div class="form-group formwithsearch marginbottom20">
              <div class="icon-addon addon-md">
                  <label for="exampleInputEmail1">Port</label>
                  <input type="text" class="form-control">
              </div>
          </div>
          <div>

          </div>
          <div class="clearfix"></div>
      </div>

      <div class="col-sm-4 col-md-4 ">
          <div class="form-group formwithsearch marginbottom20">
              <div class="icon-addon addon-md">
                  <label for="exampleInputEmail1">Payment Type</label>
                   <select type="text" class="form-control"></select>
              </div>
          </div>
          <div>

          </div>
          <div class="clearfix"></div>
      </div>

      <div class="col-sm-4 col-md-4 ">
          <div class="form-group formwithsearch marginbottom20">
              <div class="icon-addon addon-md">
                  <label for="exampleInputEmail1">Delivery Term</label>
                  <select type="text" class="form-control"></select>
              </div>
          </div>
          <div class="clearfix"></div>
      </div>

      <div class="col-sm-4 col-md-4 ">
          <div class="form-group formwithsearch marginbottom20">
              <div class="icon-addon addon-md">
                  <label for="exampleInputEmail1">Shipping Mode</label>
                  <select type="text" class="form-control"></select>
              </div>

          </div>
          <div class="clearfix"></div>
      </div>

      <div class="col-sm-4 col-md-4 ">
          <div class="form-group formwithsearch marginbottom20">
              <div class="icon-addon addon-md">
                  <label for="exampleInputEmail1">Agent Code</label>
                  <input type="text" class="form-control">
              </div>
          </div>

          <div class="clearfix"></div>
      </div>

      <div class="col-sm-4 col-md-4 ">
          <div class="form-group formwithsearch marginbottom20">
              <div class="icon-addon addon-md">
                  <label for="exampleInputEmail1">Currency Code</label>
                  <select type="text" class="form-control"></select>
              </div>
          </div>
          <div class="clearfix"></div>
      </div>

      <div class="col-sm-4 col-md-4 ">
          <div class="form-group formwithsearch marginbottom20">
              <div class="icon-addon addon-md">
                  <label for="exampleInputEmail1">Exchange Rate</label>
                  <select type="text" class="form-control"></select>
              </div>
          </div>
          <div class="clearfix"></div>
      </div>

      <div class="col-sm-4 col-md-4 ">
          <div class="form-group formwithsearch marginbottom20">
              <div class="icon-addon addon-md">
                  <label for="exampleInputEmail1">Merchandiser</label>
                  <select type="text" class="form-control"></select>
              </div>
          </div>

          <div class="clearfix"></div>
      </div> 
	  
	  <div class="col-sm-4 col-md-4 ">
          <div class="form-group formwithsearch marginbottom20">
              <div class="icon-addon addon-md" style="margin-top:12%;">
                 <a><button id="back3" class="btn btn-info btn-lg btn-embossed submitBtn">Add Deliveries</button></a>
                  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button class="btn btn-default btn-lg">Clear All</button>
              </div>
          </div>

          <div class="clearfix"></div>
          </div> 
		</div>
	  
				<div id="submision" class="submit-button styl-rt-submission-btn pull-right marginLeft10 marginTop30 newbuttonsettingsordersheet">
				  <button id="back3" class="btn btn-info btn-lg btn-embossed submitBtn">Submit Order</button>
				  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button class="btn btn-default btn-lg">Refresh Form</button>
				</div>
			   </div>
            </div><!--  row ends  -->

        </div><!-- panel body end  -->
        </div>
      </div>
     </div> 
    </div>
</div> <!-- row ends -->

   
     <div class="row paddingleft20">
          <div class="col-sm-12 col-md-12">
          </div>
          <div class="clearfix"></div>
          <div class="col-sm-8 col-md-8 col-xs-8 marginTop30">
              <div class="aprovedby">
                  <span class="glyphicon glyphicon-ok aprovedicon"></span>
                  <div class="aprovedbytitle">
                      Created By: Jhon Doe<br>
                      Created On: dd/mm/yyyy
                  </div>
              </div>
              <div class="createdby">
                  <span class="glyphicon glyphicon-edit createdicon"></span>
                  <div class="aprovedbytitle">
                      Modified By: Jhon Doe<br>
                      Modified On: dd/mm/yyyy
                  </div>
              </div>
              <div class="modifiedby">
                  <span class="glyphicon glyphicon-refresh modifiedicon"></span>
                  <div class="aprovedbytitle">
                      Approved By: Jhon Doe<br>
                      Approved On: dd/mm/yyyy
                  </div>
              </div>
          </div>

          <div id="submision" class="submit-button styl-rt-submission-btn pull-right marginRight0 marginTop30">
              <a><button id="back3" class="btn btn-default btn-lg">Back</button></a>
              <button class="btn btn-info btn-lg btn-embossed">Next</button>
          </div>
      </div> <!-- row ends -->
    </div>	
	<!-- end of tab content 2 -->  
	<div class="tab-pane" id="bomcreation">
	<div class="row paddingleft20">
      <div class="col-sm-12 col-md-12">
        <div class="panel-group" id="Addedmeterial">
          <div class="panel panel-default">
            <div class="panel-heading" data-toggle="collapse" data-parent="#Addedmeterial" data-target="#AddedmeterialBody">
              <h4 class="panel-title">
              <a data-toggle="collapse" data-parent="#Addedmeterial" href="#AddedmeterialBody"> 
                 <a class="accordion-toggle"> <span class="pull-right slideupdowntoggle glyphicon glyphicon-chevron-up"></span>Added Material Items</a> </a> 
            </h4>
          </div>
          <div id="AddedmeterialBody" class="panel-collapse collapse">
     <div class="panel-body">
      <div class="row">

          <div class="col-sm-6 col-md-6 col-lg-6 marginTop7">
              <ul class="nav nav-pills nav-pills-jq ">
                  <li class="active"><a>FABRIC <span class="badge">6</span></a></li>
                  <li class=""><a>TRIMS <span class="badge">3</span></a></li>
                  <li class=""><a>PACKING <span class="badge">3</span></a></li>
                  <li class=""><a>SERVICES <span class="badge">3</span></a></li>
              </ul>
          </div>

          <div class="pull-right margin-addstyleroute">
              <div class="input-group custom-search-form " style="width: 390px;">
                  <input type="text" class="form-control" placeholder="Search and Filter">
                        <span class="input-group-btn">
                          <button class="btn btn-info search-form-btn" type="button">
                              <span class="glyphicon glyphicon-search"></span>
                          </button>
                        </span>
                  <a href="#" class="btn btn-warning btn-embossed pull-right"><span class="glyphicon glyphicon-plus marginRight4"></span>Add Raw Material</a></div><!-- /input-group -->
          </div>
      </div>
      <div class="dataTables_wrapper Scroll-for-datatable-add-row-matirials">
          <section>
              <table id="route" class="display table table-striped table-bordered" cellspacing="0">
                  <thead>
                  <tr>
				      <th><input type="checkbox" class="margin0 thCheckboxWidth"></th>
                      <th class="textcenter">Item Type</th>
					  <th class="textcenter">Item Code</th>
                      <th class="textcenter">Item Description</th>
                      <th class="textcenter">Color</th>
                      <th class="textcenter">Width</th>
                      <th class="textcenter">Imp/Local</th>
                      <th class="textcenter">Consumption</th>
                      <th class="textcenter">Ext atrib 1/2</th>
					  <th class="textcenter">UOM</th>
                      <th class="textcenter headcol3">Actions</th>
                  </tr>
                  </thead>
                  <tbody>
                  <tr class="gradeX">
				       <td><input type="checkbox" class="margin0"></td>
                      <td class="textcenter">Fabric</td>
                      <td class="textcenter">KCOTNEP0001</td>
					  <td class="textcenter">98% COTTON 2% POLYESTER NEP</td>
                      <td class="textcenter">Green</td>
                      <td class="textcenter">12 inches</td>
                      <td class="textcenter">Import</td>
                      <td class="textcenter">12</td>
					  <td></td>
                      <td class="textcenter"><div class="textcenter">YRD</div></td>

                      <td class="center headcol3"><div class="middle-align">
                          <div class="edit-toggle-styl-rt edit-toggle edit-toggle marginLeft20">
                              <a href="#"><span class="glyphicon glyphicon-pencil"></span> Edit</a>
                          </div>

                          <div class="delete-toggle-styl-rt delete-toggle delete-toggle pull-right marginRight48">
                              <a href="#" data-toggle="modal" data-target=".delete-confirmation"><span class="glyphicon glyphicon-remove"></span> Delete </a>
                          </div>
                      </div></td>
                  </tr>
                  <tr class="gradeX">
				       <td class="textcenter padding0"><input type="checkbox" class="margin0"></td>
                      <td class="textcenter">Fabric</td>
                      <td class="textcenter">KCOTNEP0002</td>
					  <td class="textcenter">60% COTTON 40% POLYESTER NEP</td>
                      <td class="textcenter">Blue</td>
                      <td class="textcenter">12 inches</td>
                      <td class="textcenter">Import</td>
                      <td class="textcenter">12</td>
					  <td></td>
                      <td class="textcenter"><div class="textcenter">YRD</div></td>

                      <td class="center headcol3"><div class="middle-align">
                          <div class="edit-toggle-styl-rt edit-toggle edit-toggle marginLeft20">
                              <a href="#"><span class="glyphicon glyphicon-pencil"></span> Edit</a>
                          </div>

                          <div class="delete-toggle-styl-rt delete-toggle delete-toggle pull-right marginRight48">
                              <a href="#" data-toggle="modal" data-target=".delete-confirmation"><span class="glyphicon glyphicon-remove"></span> Delete </a>
                          </div>
                      </div></td>
                  </tr>
                  </tbody>
              </table>
          </section>
        </div>
      </div>
          </div>
        </div>
      </div> 

      </div> 
    </div>
<!--add content for Add Group here -->

    <div class="row paddingleft20">
      <div class="col-sm-12 col-md-12">
      <div class="panel-group" id="AddRB">
        <div class="panel panel-default">
          <div class="panel-heading" data-toggle="collapse" data-parent="#AddRBA" data-target="#AddRBA">
            <h4 class="panel-title">
             <a data-toggle="collapse" data-parent="#AddRB" href="#AddRBA"> 
               </a><a class="accordion-toggle"> <span class="pull-right slideupdowntoggle glyphicon glyphicon-chevron-up"></span>Add Raw Materials to BOM</a>
          
            </h4>
          </div>
          <div id="AddRBA" class="panel-collapse collapse" style="height: auto;">
        <div class="panel-body">
      <div class="col-sm-4 col-md-4 ">
          <div class="form-group formwithsearch marginbottom20">
              <div class="icon-addon addon-md">
                  <label for="exampleInputEmail1">Item Type</label>
                  <select type="text" class="form-control"></select>
              </div>
          </div>
          <div>
              <button type="button" class="btn btn-primary btn-xs formsearchbtn "><span class="glyphicon glyphicon-search"></span>
              </button>
          </div>
          <div class="clearfix"></div>
      </div>

      <div class="col-sm-4 col-md-4 ">
          <div class="form-group formwithsearch marginbottom20">
              <div class="icon-addon addon-md">
                  <label for="exampleInputEmail1">Item Code</label>
                  <select type="text" class="form-control"></select>
              </div>
          </div>
          <div>
              <button type="button" class="btn btn-primary btn-xs formsearchbtn "><span class="glyphicon glyphicon-search"></span>
              </button>
          </div>
          <div class="clearfix"></div>
      </div>

      <div class="col-sm-4 col-md-4 ">
          <div class="form-group formwithsearch marginbottom20">
              <div class="icon-addon addon-md">
                  <label for="exampleInputEmail1">Description </label>
                  <input type="text" class="form-control">
              </div>
          </div>
          <div class="clearfix"></div>
      </div>

      <div class="col-sm-4 col-md-4 ">
          <div class="form-group formwithsearch marginbottom20">
              <div class="icon-addon addon-md">
                  <label for="exampleInputEmail1">Item Color </label>
                  <select type="text" class="form-control"></select>
              </div>
          </div>
          <div>
              <button type="button" class="btn btn-primary btn-xs formsearchbtn "><span class="glyphicon glyphicon-search"></span>
              </button>
          </div>
          <div class="clearfix"></div>
      </div>

      <div class="col-sm-4 col-md-4 ">
          <div class="form-group formwithsearch marginbottom20">
              <div class="icon-addon addon-md">
                  <label for="exampleInputEmail1">Item Width </label>
                  <input type="text" class="form-control">
              </div>
          </div>
          <div>

          </div>
          <div class="clearfix"></div>
      </div>

      <div class="col-sm-4 col-md-4 ">
          <div class="form-group formwithsearch marginbottom20">
              <div class="icon-addon addon-md">
                  <label for="exampleInputEmail1">Additional Attribute 1 </label>
                  <input type="text" class="form-control">
              </div>
          </div>
          <div>

          </div>
          <div class="clearfix"></div>
      </div>

      <div class="col-sm-4 col-md-4 ">
          <div class="form-group formwithsearch marginbottom20">
              <div class="icon-addon addon-md">
                  <label for="exampleInputEmail1">Additional Attribute 2 </label>
                  <input type="text" class="form-control">
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
                  <select type="text" class="form-control"></select>
              </div>
          </div>
          <div>
              <button type="button" class="btn btn-primary btn-xs formsearchbtn "><span class="glyphicon glyphicon-search"></span>
              </button>
          </div>
          <div class="clearfix"></div>
      </div>

      <div class="col-sm-4 col-md-4 ">
          <div class="form-group formwithsearch marginbottom20">
              <div class="icon-addon addon-md">
                  <label for="exampleInputEmail1">Supplier </label>
                  <select type="text" class="form-control"></select>
              </div>

          </div>
          <div>
              <button type="button" class="btn btn-primary btn-xs formsearchbtn "><span class="glyphicon glyphicon-search"></span>
              </button>
          </div>

          <div class="clearfix"></div>
      </div>
	  
	        <div class="col-sm-4 col-md-4 ">
          <div class="form-group formwithsearch marginbottom20">
              <div class="icon-addon addon-md">
                  <label for="exampleInputEmail1">Price </label>
                  <select type="text" class="form-control"></select>
              </div>

          </div>
          <div>
              <button type="button" class="btn btn-primary btn-xs formsearchbtn "><span class="glyphicon glyphicon-search"></span>
              </button>
          </div>

          <div class="clearfix"></div>
      </div>

      <div class="col-sm-4 col-md-4 ">
          <div class="form-group formwithsearch marginbottom20">
              <div class="icon-addon addon-md">
                  <label for="exampleInputEmail1">Currency Code</label>
                  <select type="text" class="form-control"></select>
              </div>
          </div>

          <div class="clearfix"></div>
      </div>

      <div class="col-sm-4 col-md-4 ">
          <div class="form-group formwithsearch marginbottom20">
              <div class="icon-addon addon-md">
                  <label for="exampleInputEmail1">Allow % </label>
                  <select type="text" class="form-control"></select>

              </div>
          </div>

          <div class="clearfix"></div>
      </div>
	  
	    <div class="col-sm-4 col-md-4 ">
          <div class="form-group formwithsearch marginbottom20">
              <div class="icon-addon addon-md">
                  <label for="exampleInputEmail1">Exchange Rate % </label>
                  <select type="text" class="form-control"></select>

              </div>
          </div>

          <div class="clearfix"></div>
      </div>

      <div class="col-sm-4 col-md-4 ">
          <div class="form-group formwithsearch marginbottom20">
              <div class="icon-addon addon-md">
                  <label for="exampleInputEmail1">UOM </label>
                  <input type="text" class="form-control">
              </div>
          </div>

          <div class="clearfix"></div>
      </div>
	  
	   <div class="col-sm-4 col-md-4 ">
          <div class="form-group formwithsearch marginbottom20">
              <div class="icon-addon addon-md">
                  <label for="exampleInputEmail1">PO Unit</label>
                  <input type="text" class="form-control">
              </div>
          </div>

          <div class="clearfix"></div>
      </div>
	   
	   <div class="col-sm-4 col-md-4 ">
          <div class="form-group formwithsearch marginbottom20">
              <div class="icon-addon addon-md">
                  <label for="exampleInputEmail1">BOM Placement</label>
                  <input type="text" class="form-control">
              </div>
          </div>

          <div class="clearfix"></div>
      </div>
	  
	  	<div class="col-sm-4 col-md-4 ">
          <div class="form-group formwithsearch marginbottom20">
              <div class="icon-addon addon-md">
                  <label for="exampleInputEmail1">Size Wise Indent</label>
                  <select type="text" class="form-control"></select>
              </div>
          </div>

          <div class="clearfix"></div>
      </div>

      <div class="row">

          <div class="col-sm-12 col-md-12">
		  <div class="row paddingleft20">
			  <div class="col-md-12"><h3 class="add-styl-rt">Add Item Consumption</h3><hr></div>
		  </div>
		        <div class="dataTables_wrapper margintop20">
          <section>
              <table id="route" class="display table table-striped table-bordered" cellspacing="0">
                  <thead>
                  <tr>
                      <th class="textcenter"><input type="checkbox" class="margin0 thCheckboxWidth"></th>
                      <th class="textcenter">Group Name</th>
                      <th class="textcenter">Consumption</th>
                      <th class="textcenter">Advance Combination</th>

                  </tr>
                  </thead>
                  <tbody>
                  <tr class="gradeX">
                      <td class="textcenter padding0"><input type="checkbox" class="margin0"></td>
                      <td class="textcenter">Size range 1-5</td>
                      <td class="textcenter"><select type="text" class="form-control"></select></td>
                      <td class="textcenter">
                          <div class="advance-comb">
                              <a class="edit" href="#" data-toggle="modal" data-target=".drop-down-select-model"><span class="fa fa-list-alt marginRight3"></span>View Size Wise Consumptions</a>
                          </div>
                      </td>
                  </tr>

                  <tr class="gradeX">
                      <td class="textcenter padding0"><input type="checkbox" class="margin0"></td>
                      <td class="textcenter">Size range 6-7</td>
                      <td class="textcenter"><select type="text" class="form-control"></select></td>
                      <td class="textcenter">
                          <div class="advance-comb">
                              <a class="edit" href="javascript:;"><span class="fa fa-list-alt marginRight3"></span>View Size Wise Consumptions</a>
                          </div>
                      </td>
                  </tr>
                  </tbody>
              </table>
          </section>
		   <div id="submision" class="submit-button styl-rt-submission-btn pull-right marginLeft10 marginTop30 newbuttonsettingsordersheet1">
          &nbsp;&nbsp;<button class="btn btn-info btn-lg btn-embossed submitBtn">Add To BOM</button>
        </div>
         </div>
        </div>
      </div>

      <div class="clearfix"></div>
               </div><!-- panel body end  -->
             </div>
           </div>
         </div> 
 
  </div>
</div> <!-- row ends -->

	<div class="row paddingleft20">
      <div class="col-sm-12 col-md-12">
        <div class="panel-group" id="NameN">
          <div class="panel panel-default">
            <div class="panel-heading" data-toggle="collapse" data-parent="#NameN" data-target="#NameNA">
              <h4 class="panel-title">
              <a data-toggle="collapse" data-parent="#NameN" href="#NameNA"> 
                 <a class="accordion-toggle"> <span class="pull-right slideupdowntoggle glyphicon glyphicon-chevron-up"></span>BOM</a> </a> 
            </h4>
          </div>
          <div id="NameNA" class="panel-collapse collapse">
     <div class="panel-body">
      <div class="row">

          <div class="col-sm-6 col-md-6 col-lg-6 marginTop7">
              <ul class="nav nav-pills nav-pills-jq ">
                  <li class="active"><a>FABRIC <span class="badge">6</span></a></li>
                  <li class=""><a>TRIMS <span class="badge">3</span></a></li>
                  <li class=""><a>PACKING <span class="badge">3</span></a></li>
                  <li class=""><a>SERVICES <span class="badge">3</span></a></li>
              </ul>
          </div>

          <div class="pull-right margin-addstyleroute">
              <div class="input-group custom-search-form " style="width: 390px;">
                  <input type="text" class="form-control" placeholder="Search and Filter">
                        <span class="input-group-btn">
                          <button class="btn btn-info search-form-btn" type="button">
                              <span class="glyphicon glyphicon-search"></span>
                          </button>
                        </span>
                  <a href="#" class="btn btn-warning btn-embossed pull-right"><span class="glyphicon glyphicon-plus marginRight4"></span>Add Raw Material</a></div><!-- /input-group -->
          </div>
      </div>
      <div class="dataTables_wrapper Scroll-for-datatable-add-row-matirials">
          <section class="ordersheetsection">
                <table id="route" class="display table table-striped table-bordered" cellspacing="0">
                  <thead>
                  <tr>
				      <th><input type="checkbox" class="margin0 thCheckboxWidth"></th>
                      <th class="textcenter">Item Type</th>
					  <th class="textcenter">Item Code</th>
                      <th class="textcenter">Item Description</th>
                      <th class="textcenter">Color</th>
                      <th class="textcenter">Width</th>
                      <th class="textcenter">Imp/Local</th>
					  <th class="textcenter">Supplier</th>
                      <th class="textcenter">Consumption</th>
                      <th class="textcenter">Ext atrib 1</th>
					  <th class="textcenter">Ext atrib 2</th>
					  <th class="textcenter">Exchange Rate</th>
					  <th class="textcenter">UOM</th>
					  <th class="textcenter">PO Unit</th>
					  <th class="headcol2 textcenter openasnewordersheet">Open as new</th> 
                      <th class="textcenter headcol3">Actions</th>
                  </tr>
                  </thead>
                  <tbody>
                  <tr class="gradeX">
				       <td><input type="checkbox" class="margin0"></td>
					  <td>Fabric</td>
					  <td>KCOTNEP0001</td>
					  <td>98% COTTON 2% POLYESTER NEP</td>
                      <td>Blue</td>
                      <td>12 inches</td>
                      <td>Import</td>
					  <td>Excelsoft (Pvt) Ltd</td>
					  <td>12</td>
                      <td></td>
					  <td></td>
					  <td>12</td>
					  <td>YRD</td>
                      <td class=""><div class="textcenter">YRD</div></td>
                      <td class="headcol2 openasnewordersheet">
                          <div class="operations-toggle">
                            <a href="#"><span class="glyphicon glyphicon-folder-open"></span> Open as new </a>
                          </div>
                       </td> 
                      <td class="center headcol3"><div class="middle-align">
                          <div class="edit-toggle-styl-rt edit-toggle edit-toggle marginLeft20">
                              <a href="#"><span class="glyphicon glyphicon-pencil"></span> Edit</a>
                          </div>

                          <div class="delete-toggle-styl-rt delete-toggle delete-toggle pull-right marginRight48">
                              <a href="#" data-toggle="modal" data-target=".delete-confirmation"><span class="glyphicon glyphicon-remove"></span> Delete </a>
                          </div>
                      </div></td>
                  </tr>
                  <tr class="gradeX">
				       <td><input type="checkbox" class="margin0"></td>
					  <td>Fabric</td>
					  <td>KCOTNEP0002</td>
					  <td>98% COTTON 2% POLYESTER NEP</td>
                      <td>Green</td>
                      <td>12 inches</td>
                      <td>Local</td>
					  <td>Excelsoft (Pvt) Ltd</td>
					  <td>12</td>
                      <td></td>
					  <td></td>
					  <td>15</td>
					  <td>YRD</td>
                      <td class=""><div class="textcenter">YRD</div></td>
                      <td class="headcol2 openasnewordersheet">
                          <div class="operations-toggle">
                            <a href="#"><span class="glyphicon glyphicon-folder-open"></span> Open as new </a>
                          </div>
                       </td>
                      <td class="center headcol3"><div class="middle-align">
                          <div class="edit-toggle-styl-rt edit-toggle edit-toggle marginLeft20">
                              <a href="#"><span class="glyphicon glyphicon-pencil"></span> Edit</a>
                          </div>

                          <div class="delete-toggle-styl-rt delete-toggle delete-toggle pull-right marginRight48">
                              <a href="#" data-toggle="modal" data-target=".delete-confirmation"><span class="glyphicon glyphicon-remove"></span> Delete </a>
                          </div>
                      </div></td>
                  </tr>
                  </tbody>
              </table>
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
          </div>

          <div class="clearfix"></div>

          <div class="col-sm-8 col-md-8 col-xs-8 marginTop30">
              <div class="aprovedby">
                  <span class="glyphicon glyphicon-ok aprovedicon"></span>
                  <div class="aprovedbytitle">
                      Created By: Jhon Doe<br>
                      Created On: dd/mm/yyyy
                  </div>
              </div>
              <div class="createdby">
                  <span class="glyphicon glyphicon-edit createdicon"></span>
                  <div class="aprovedbytitle">
                      Modified By: Jhon Doe<br>
                      Modified On: dd/mm/yyyy
                  </div>
              </div>
              <div class="modifiedby">
                  <span class="glyphicon glyphicon-refresh modifiedicon"></span>
                  <div class="aprovedbytitle">
                      Approved By: Jhon Doe<br>
                      Approved On: dd/mm/yyyy
                  </div>
              </div>
          </div>

          <div id="submision" class="submit-button styl-rt-submission-btn pull-right marginRight0 marginTop30">
              <a><button id="back3" class="btn btn-default btn-lg">Back</button></a>
              <button class="btn btn-info btn-lg btn-embossed">Next</button>
          </div>

      </div> <!-- row ends -->
</div>

<div class="tab-pane" id="indent">
	 <div class="row paddingleft20">
      <div class="col-sm-12 col-md-12">
        <div class="panel-group" id="Orderlist">
          <div class="panel panel-default">
            <div class="panel-heading" data-toggle="collapse" data-parent="#Orderlist" data-target="#OrderlistA">
              <h4 class="panel-title">
              <a data-toggle="collapse" data-parent="#Orderlist" href="#OrderlistA"> 
                 <a class="accordion-toggle"> <span class="pull-right slideupdowntoggle glyphicon glyphicon-chevron-up"></span>Order List</a> </a> 
            </h4>
          </div>
		  
          <div id="OrderlistA" class="panel-collapse collapse">
            <div class="panel-body">
			     <div class="row">
                    <div class="pull-right margin-addstyleroute">
                      <div class="input-group custom-search-form " style="width: 390px;">
                        <input type="text" class="form-control" placeholder="Search and Filter">
                        <span class="input-group-btn">
                          <button class="btn btn-info search-form-btn" type="button">
                            <span class="glyphicon glyphicon-search"></span>
                          </button>
                        </span>
                      </div><!-- /input-group -->                       
                    </div>                   
                </div>
               <div class="dataTables_wrapper Scroll-for-datatable margintop20">
                 
                <section class="fcsSection">
                  <table id="route" class="fcsRout display table table-striped table-bordered" cellspacing="0" >
                      <thead>
                        <tr>
						 <th class="textcenter"><input type="checkbox" class="margin0 thCheckboxWidth"></th>
                          <th class="textcenter">Sales Order</th>
                          <th class="textcenter">Quantity</th>
                          <th class="textcenter">No of PO</th>
                          <th class="textcenter">PO added to BOM </th>
                          <th class="headcol textcenter">Status</th>
                          <th class="headcol2 textcenter">View Deliveries</th>                      
                          <th class="textcenter headcol3">Approve</th>
                        </tr>
                      </thead>
                      <tbody>
                        <tr class="gradeX">                        
                          <td class="textcenter"><input type="checkbox"></td>                        
                          <td class="textcenter">31102014-001</td>
                          <td class="textcenter">200</td>
                          <td class="textcenter">12 </td>
                          <td class="textcenter">10</td>
                          <td class="headcol headcol_status">
                              <div class="pdnCompleted">Approved</div>
                          </td>
                          <td class="headcol2 headcol1_viewDel">
                              <div class="operations-toggle">
                                  <a class="edit" href="javascript:;"><span class="fa fa-list-alt marginRight3"></span>View Deliveries</a>
                              </div>
                          </td>                         
                          <td class="center headcol3 headcol_Approve">
						  <div class="middle-align">
                         <button type="button" class="btn btn-info btn-xs">Approve</button>
                            </div>
							</td>
                        </tr>

                        <tr class="gradeX">                        
                          <td class="textcenter"><input type="checkbox"></td>  						
                          <td class="textcenter">31102014-002</td>
                          <td class="textcenter">100</td>
                          <td class="textcenter">15 </td>
                          <td class="textcenter">10</td>
                          <td class="headcol headcol_status">
                            <div id="pdnApproval">Pending Approvel</div>
                          </td>
                          <td class="headcol2 headcol1_viewDel">
                              <div class="operations-toggle">
                                <a class="edit" href="javascript:;"><span class="fa fa-list-alt marginRight3"></span>View Deliveries</a>
                              </div>
                          </td>                         
                          <td class="center headcol3 headcol_Approve"><div class="middle-align">
                              <button type="button" class="btn btn-info btn-xs">Approve</button>
                            </div></td>
                        </tr>                     
                      </tbody>
                    </table>
                  </section>
				 <div class="col-sm-4 col-md-4 col-xs-4 pull-left padding0 margintop20">
					  <button type="button" class="btn btn-info btn-embossed marginLeft10 pull-left">Generate Indent</button>
				  </div>
              </div>
            </div>
          </div>
        </div>
      </div> 
      </div> 
	  
    </div>
	
	<div class="row paddingleft20">
      <div class="col-sm-12 col-md-12">
        <div class="panel-group" id="AddedBOM">
          <div class="panel panel-default">
            <div class="panel-heading" data-toggle="collapse" data-parent="#AddedBOM" data-target="#AddedBOMB">
              <h4 class="panel-title">
              <a data-toggle="collapse" data-parent="#AddedBOM" href="#AddedBOMB"> 
                 <a class="accordion-toggle"> <span class="pull-right slideupdowntoggle glyphicon glyphicon-chevron-up"></span>Added BOM</a> </a> 
            </h4>
          </div>
          <div id="AddedBOMB" class="panel-collapse collapse">
     <div class="panel-body">
      <div class="row">

          <div class="col-sm-6 col-md-6 col-lg-6 marginTop7">
              <ul class="nav nav-pills nav-pills-jq ">
                  <li class="active"><a>FABRIC <span class="badge">6</span></a></li>
                  <li class=""><a>TRIMS <span class="badge">3</span></a></li>
                  <li class=""><a>PACKING <span class="badge">3</span></a></li>
                  <li class=""><a>SERVICES <span class="badge">3</span></a></li>
              </ul>
          </div>

          <div class="pull-right margin-addstyleroute">
              <div class="input-group custom-search-form " style="width: 390px;">
                  <input type="text" class="form-control" placeholder="Search and Filter">
                        <span class="input-group-btn">
                          <button class="btn btn-info search-form-btn" type="button">
                              <span class="glyphicon glyphicon-search"></span>
                          </button>
                        </span>
                  </div><!-- /input-group -->
          </div>
      </div>
      <div class="dataTables_wrapper Scroll-for-datatable-add-row-matirials">
          <section class="sectionset" style="margin-right: 384px !important;">
              <table id="route" class="display table table-striped table-bordered" cellspacing="0">
                  <thead>
                  <tr>
                      <th class="textcenter">Item Type</th>
                      <th class="textcenter">Item Description</th>
                      <th class="textcenter">Color</th>
                      <th class="textcenter">Width</th>
                      <th class="textcenter">Ext atrib 1</th>
					  <th class="textcenter">Ext atrib 2</th>
					  <th class="textcenter">Item Code</th>
					  <th class="textcenter">Total Requirement</th>
					  <th class="textcenter">Quantity Released for PO</th>
					  <th class="textcenter">Quantity to be Released for PO</th>
					  <th class="textcenter">Supplier</th>
					  <th class="textcenter">Release PO</th>
					  <th class="textcenter headcol2">View PO History</th>
                      <th class="textcenter headcol3">Release For PO</th>
                  </tr>
                  </thead>
                  <tbody>
                  <tr class="gradeX">
                      <td class="textcenter">Fabric</td>
					  <td class="textcenter">98% COTTON 2% POLYESTER NEP</td>
                      <td class="textcenter">Blue</td>
                      <td class="textcenter">12 inches</td>
                      <td class="textcenter"></td>
					  <td class="textcenter"></td>
                      <td class="textcenter">KCOTNEP0001</td>
					  <td class="textcenter">1600</td>
					  <td class="textcenter">1000</td>
                      <td class="textcenter">600</td>
					  <td class="textcenter">J.K Agencies (Pvt) Ltd</td>
					   <td><input type="text" class="form-control" style="width:100px;" value="600"></td>
                      <td class="textcenter headcol2 advance-comb" style="height:53px !important;"><a href="#"><span class="glyphicon glyphicon-time"></span> View PO History</a></td>

                      <td class="center headcol3"  style="height:53px !important;"><div class="advance-comb">
                     <a href="#"><span class="fa fa-reply"></span> Release for PO</a>
                      </div></td>
                  </tr>
                  <tr class="gradeX">
                      <td class="textcenter">Fabric</td>
					  <td class="textcenter">98% COTTON 2% POLYESTER NEP</td>
                      <td class="textcenter">Green</td>
                      <td class="textcenter">12 inches</td>
                      <td class="textcenter"></td>
					  <td class="textcenter"></td>
                      <td class="textcenter">KCOTNEP0002</td>
					  <td class="textcenter">300</td>
					  <td class="textcenter">200</td>
                      <td class="textcenter">100</td>
					  <td class="textcenter">J.K Agencies (Pvt) Ltd</td>
					   <td><input type="text" class="form-control" style="width:100px;" value="100"></td>
                      <td class="textcenter headcol2 advance-comb" style="height:53px !important;"><a href="#"><span class="glyphicon glyphicon-time"></span> View PO History</a></td>
                      <td class="center headcol3" style="height:53px !important;"><div class="advance-comb">
                          <a href="#"><span class="fa fa-reply"></span> Release for PO</a>
                      </div>
					  </td>
                  </tr>
                  </tbody>
              </table>
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
        <div class="panel-group" id="createGroups4">
            <div class="panel panel-default">
                <div class="panel-heading" data-toggle="collapse" data-parent="#creatG4" data-target="#creatG4">
                    <h4 class="panel-title">
                        <a data-toggle="collapse" data-parent="#createGroups4" href="#creatG4">
                        </a><a class="accordion-toggle"> <span
                            class="pull-right slideupdowntoggle glyphicon glyphicon-chevron-up"></span>PO History</a>

                    </h4>
                </div>
                <div id="creatG4" class="panel-collapse collapse" style="height: auto;">
                    <div class="panel-body">
                        <div class="row">
						          <div class="pull-right margin-addstyleroute margin margin-bottom20">
							  <div class="input-group custom-search-form " style="width: 390px;">
								  <input type="text" class="form-control" placeholder="Search and Filter">
										<span class="input-group-btn">
										  <button class="btn btn-info search-form-btn" type="button">
											  <span class="glyphicon glyphicon-search"></span>
										  </button>
										</span>
								  </div><!-- /input-group -->
						  </div>

                            <div class="col-sm-12 col-md-12">
                                <div class="dataTables_wrapper scrollxonly">
                                    <section>
                                        <table id="route" class="display table table-striped table-bordered"
                                               cellspacing="0">
                                            <thead>
                                            <tr>
                                                <th class="textcenter">PO Number</th>
                                                <th class="textcenter">Order Quantity</th>
                                                <th class="textcenter">Release Quantity</th>
                                                <th class="textcenter">Balance to Be Released</th>
                                                <th class="textcenter">Supplier</th>
                                                <th class="textcenter">Target Order Date</th>
                                                <th class="textcenter">Target Ship Date</th>
                                                <th class="textcenter">Ship Date</th>
                                                <th class="textcenter">PO Status</th>
                                            </tr>
                                            </thead>
                                            <tbody>


                                            <tr class="gradeX">
                                                <td class="textcenter">PO31102014-001</td>
                                                <td class="textcenter">10000</td>
                                                <td class="textcenter">7000</td>
                                                <td class="textcenter">3000</td>
                                                <td class="textcenter">J.K Agencies (Pvt) Ltd</td>
                                                <td class="textcenter">1/31/2015</td>
                                                <td class="textcenter">12/1/2014</td>
                                                <td class="textcenter">12/2/2014</td>
                                                <td class="textcenter">Processed</td>

                                            </tr>

                                            <tr class="gradeX">
                                                <td class="textcenter">PO31102014-001</td>
                                                <td class="textcenter">10000</td>
                                                <td class="textcenter">0</td>
                                                <td class="textcenter">10000</td>
                                                <td class="textcenter">J.K Agencies (Pvt) Ltd</td>
                                                <td class="textcenter">2/28/2015</td>
                                                <td class="textcenter">12/31/2014</td>
                                                <td class="textcenter">1/2/2014</td>
                                                <td class="textcenter">Processed</td>

                                            </tr>
                                            </tbody>
                                        </table>
                                    </section>
                                </div>
                            </div>
                         </div>


                    </div>
                    <!-- panel body end  -->


                </div>

            </div>
        </div>
    </div>

</div>


<div class="row paddingleft20">
    <div class="col-sm-12 col-md-12">
        <div class="panel-group" id="OtherSID">
            <div class="panel panel-default">
                <div class="panel-heading" data-toggle="collapse" data-parent="#OtherSIDD" data-target="#OtherSIDD">
                    <h4 class="panel-title">
                        <a data-toggle="collapse" data-parent="#OtherSID" href="#OtherSIDD">
                        </a><a class="accordion-toggle"> <span
                            class="pull-right slideupdowntoggle glyphicon glyphicon-chevron-up"></span>Order Specific Inventory Details</a>

                    </h4>
                </div>
                <div id="OtherSIDD" class="panel-collapse collapse" style="height: auto;">
                    <div class="panel-body">
                        <div class="row">
						          <div class="pull-right margin-addstyleroute margin-bottom20">
							  <div class="input-group custom-search-form " style="width: 390px;">
								  <input type="text" class="form-control" placeholder="Search and Filter">
										<span class="input-group-btn">
										  <button class="btn btn-info search-form-btn" type="button">
											  <span class="glyphicon glyphicon-search"></span>
										  </button>
										</span>
								  </div><!-- /input-group -->
						  </div>

                            <div class="col-sm-12 col-md-12">
                                <div class="dataTables_wrapper scrollxonly">
                                    <section>
                                        <table id="route" class="display table table-striped table-bordered"
                                               cellspacing="0">
                                            <thead>
                                            <tr>
                                                <th class="textcenter">Location</th>
                                                <th class="textcenter">UOM</th>
                                                <th class="textcenter">Reserved from Supplier</th>
                                                <th class="textcenter">Reserved from Location</th>
                                                <th class="textcenter">Other Receipt</th>
                                                <th class="textcenter">Total Receipt</th>
                                                <th class="textcenter">Issued to Location</th>
                                                <th class="textcenter">Issued to Production</th>
                                                <th class="textcenter">Other Issues</th>
												<th class="textcenter">Reserved</th>
												<th class="textcenter">Total Issued</th>
												<th class="textcenter">Balanced Quantity</th>
												<th class="textcenter">Last Update</th>
												<th class="textcenter">Reserved from General Stock</th>
												<th class="textcenter">Reserved from Other Orders</th>
												<th class="textcenter">Reserved from Gen Orders</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <tr class="gradeX">
                                                <td class="textcenter">Colombo</td>
                                                <td class="textcenter">YRD</td>
                                                <td class="textcenter">10000</td>
                                                <td class="textcenter">1000</td>
                                                <td class="textcenter">5000</td>
                                                <td class="textcenter">16000</td>
                                                <td class="textcenter">10000</td>
                                                <td class="textcenter">2000</td>
                                                <td class="textcenter">1000</td>
												<td class="textcenter">500</td>
                                                <td class="textcenter">13500</td>
                                                <td class="textcenter">25000</td>
                                                <td class="textcenter">10/31/2014</td>
                                                <td class="textcenter">10000</td>
                                                <td class="textcenter">0</td>
                                                <td class="textcenter">0</td>
                                            </tr>

                                            <tr class="gradeX">
                                                <td class="textcenter">Colombo</td>
                                                <td class="textcenter">YRD</td>
                                                <td class="textcenter">20000</td>
                                                <td class="textcenter">1000</td>
                                                <td class="textcenter">5000</td>
                                                <td class="textcenter">16000</td>
                                                <td class="textcenter">10000</td>
                                                <td class="textcenter">2000</td>
                                                <td class="textcenter">1000</td>
												<td class="textcenter">500</td>
                                                <td class="textcenter">13500</td>
                                                <td class="textcenter">25000</td>
                                                <td class="textcenter">11/1/2014</td>
                                                <td class="textcenter">10000</td>
                                                <td class="textcenter">0</td>
												<td class="textcenter">0</td>
                                            </tr>
                                            </tbody>
                                        </table>
                                    </section>
                                </div>
                            </div>
                         </div>


                    </div>
                    <!-- panel body end  -->


                </div>

            </div>
        </div>
    </div>

</div>

<div class="row paddingleft20">
    <div class="col-sm-12 col-md-12">
        <div class="panel-group" id="GeneralID">
            <div class="panel panel-default">
                <div class="panel-heading" data-toggle="collapse" data-parent="#GeneralIDS" data-target="#GeneralIDS">
                    <h4 class="panel-title">
                        <a data-toggle="collapse" data-parent="#GeneralID" href="#GeneralIDS">
                        </a><a class="accordion-toggle"> <span
                            class="pull-right slideupdowntoggle glyphicon glyphicon-chevron-up"></span>General Inventory Details</a>

                    </h4>
                </div>
                <div id="GeneralIDS" class="panel-collapse collapse" style="height: auto;">
                    <div class="panel-body">
                        <div class="row">
						  <div class="pull-right margin-addstyleroute margin-bottom20">
							  <div class="input-group custom-search-form " style="width: 390px;">
								  <input type="text" class="form-control" placeholder="Search and Filter">
										<span class="input-group-btn">
										  <button class="btn btn-info search-form-btn" type="button">
											  <span class="glyphicon glyphicon-search"></span>
										  </button>
										</span>
								  </div><!-- /input-group -->
						  </div>

                            <div class="col-sm-12 col-md-12">
                                <div class="dataTables_wrapper">
                                    <section>
                                        <table id="route" class="display table table-striped table-bordered"
                                               cellspacing="0">
                                            <thead>
                                            <tr>
                                                <th class="textcenter">Location</th>
                                                <th class="textcenter">Company</th>
                                                <th class="textcenter">Item Type</th>
												<th class="textcenter">Item Code</th>
                                                <th class="textcenter">Item Colour</th>
                                                <th class="textcenter">Available Qty</th>
                                                <th class="textcenter">UOM</th>
                                                <th class="textcenter">Reserved Quantity</th>
												<th class="textcenter">Available Qty. for Transfer</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <tr class="gradeX">
                                                <td class="textcenter">Colombo </td>
                                                <td class="textcenter">Excelsoft (Pvt) Ltd</td>
												<td class="textcenter">Fabric</td>
                                                <td class="textcenter">KCOTNEP0001</td>
                                                <td class="textcenter">Green</td>
                                                <td class="textcenter">10000</td>
                                                <td class="textcenter">YRD</td>
                                                <td class="textcenter">6000</td>
												<td class="textcenter">4000</td>

                                            </tr>

                                            <tr class="gradeX">
                                                <td class="textcenter">Koggala</td>
                                                <td class="textcenter">Excelsoft (Pvt) Ltd</td>
												<td class="textcenter">Fabric</td>
                                                <td class="textcenter">KCOTNEP0002</td>
                                                <td class="textcenter">Blue</td>
                                                <td class="textcenter">12000</td>
                                                <td class="textcenter">YRD</td>
                                                <td class="textcenter">8000</td>
												<td class="textcenter">4000</td>

                                            </tr>
                                            </tbody>
                                        </table>
                                    </section>
                                </div>
                            </div>
                         </div>


                    </div>
                    <!-- panel body end  -->


                </div>

            </div>
        </div>
    </div>

</div>
     <div class="row paddingleft20">
          <div class="col-sm-12 col-md-12">
          </div>

          <div class="clearfix"></div>

          <div class="col-sm-8 col-md-8 col-xs-8 marginTop30">
              <div class="aprovedby">
                  <span class="glyphicon glyphicon-ok aprovedicon"></span>
                  <div class="aprovedbytitle">
                      Created By: Jhon Doe<br>
                      Created On: dd/mm/yyyy
                  </div>
              </div>
              <div class="createdby">
                  <span class="glyphicon glyphicon-edit createdicon"></span>
                  <div class="aprovedbytitle">
                      Modified By: Jhon Doe<br>
                      Modified On: dd/mm/yyyy
                  </div>
              </div>
              <div class="modifiedby">
                  <span class="glyphicon glyphicon-refresh modifiedicon"></span>
                  <div class="aprovedbytitle">
                      Approved By: Jhon Doe<br>
                      Approved On: dd/mm/yyyy
                  </div>
              </div>
          </div>

          <div id="submision" class="submit-button styl-rt-submission-btn pull-right marginRight0 marginTop30">
              <a><button id="back3" class="btn btn-default btn-lg">Back</button></a>
              <button class="btn btn-info btn-lg btn-embossed">Confirm</button>
          </div>

      </div> <!-- row ends -->
	
	</div>
	</div>
	
 </div>   
</div>




<!-- Add deliveries pop up Starts-->
<div class="modal fade drop-down-select-models model-popup-fix addedFCS" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-lg">

                <div class="modal-content model-popup-padding">

                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
                        <h5 class="modal-title">Add Deliveries</h5>
                    </div>
					
					<div class="dataTables_wrapper">
                <section class="">
                  <table id="route" class="fcsRout display table table-striped table-bordered" cellspacing="0" >
                      <thead>
                        <tr>
                          <th style="text-align:center">Sales Order</th>
                          <th style="text-align:center">Buyer PO Number</th>
                          <th style="text-align:center">Quantity</th>
                          <th style="text-align:center">Size Breakup</th>
                          <th style="text-align:center">Delivery Type</th>
                          <th style="text-align:center">Order Status</th>
                        </tr>
                      </thead>
                      <tbody>
                        <tr class="gradeX">                        
                          <td style="text-align:center">31102014-001</td>
                          <td style="text-align:center">PO31102014</td>
                          <td style="text-align:center">20000</td>
                          <td style="text-align:center">Ratio</td>
                          <td style="text-align:center">Local</td>
                          <td style="text-align:center">Complete</td>
                          </td>
                        </tr>

                        <tr class="gradeX">                        
                          <td style="text-align:center">31102014-002</td>
                          <td style="text-align:center">PO31102015</td>
                          <td style="text-align:center">10000</td>
                          <td style="text-align:center">Non-Ratio</td>
                          <td style="text-align:center">Local</td>
                          <td style="text-align:center">Complete</td>
                         </td>
                        </tr>             
                      </tbody>
                    </table>
                  </section>
              </div>
                   
                    <div id="submision" class="submit-button styl-rt-submission-btn pull-right marginRight0 marginTop30">
                        <button class="btn btn-default btn-lg btn-embossed mdlclose">Close</button>
                    </div>

                    <div class="clearfix"></div>  			
    </div>
</div>         <!-- END TAB CONTENT MAIN -->

<div class="modal fade drop-down-select-model model-popup-fix addedFCS" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-lg">

                <div class="modal-content model-popup-padding">

                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
                        <h5 class="modal-title">Size Wise Consumption</h5>
                    </div>
					
                    <div class="row" style="margin-bottom:-10%">
					            <div class="col-md-3">
                                      <div class="form-group fcsmulti formwithsearch marginbottom20 ">
                                          <div class="icon-addon addon-md">
                                              <label for="exampleInputEmail1">Main Color</label>
                                              <div class="clearfix"></div>
                                              <select data-placeholder="Color" class="chosen-select" multiple style="width:100%;" tabindex="4">
                                                  <option value=""></option>
                                                  <option value="2">red</option>
                                                  <option value="2">green</option>
                                                  <option value="2">blue</option>
                                                  <option value="2">White</option>
                                              </select>
                                          </div>
                                      </div>
                                      <div class="clearfix"></div>
                                    </div>

                                      <div class="col-md-3">
                                          <div class="form-group fcsmulti formwithsearch marginbottom20 ">
                                              <div class="icon-addon addon-md">
                                                  <label for="exampleInputEmail1">Child Color</label>
                                                  <div class="clearfix"></div>
                                                  <select data-placeholder="Color" class="chosen-select" multiple style="width:100%;" tabindex="4">
                                                      <option value=""></option>
                                                      <option value="2">red</option>
                                                      <option value="2">green</option>
                                                      <option value="2">blue</option>
                                                      <option value="2">White</option>
                                                  </select>
                                              </div>
                                          </div>
                                          <div class="clearfix"></div>
                                      </div>

                                      <div class="col-md-3">
                                          <div class="form-group fcsmulti formwithsearch marginbottom20 ">
                                              <div class="icon-addon addon-md">
											  <button type="button" class="btn btn-info btn-embossed marginLeft10 pull-left" style="margin-top:13%">Generate Grid</button>
                                              </div>
                                          </div>
                                          <div class="clearfix"></div>
                                      </div>
					</div>
					
                   <section class="popupsizewiseconsuption">
                      <table class="table table-bordered" id="route">
								<thead>
								<tr>
									<th class="headcolpop1">Country</th>
									<th class="headcolpop2">Component</th>
									<th class="headcolpop3">Color</th>
									<th class="headcolpop4">Fit</th>
									<th colspan="14"><div class="sizechange">Size</div></th>
								</tr>
								</thead>
								<tbody>
								<tr>
									<td rowspan="10" class="headcolpop1x"><div class="heights">UK</div></td>
									<td rowspan="6" class="popup_sizeconsuption_component"><div class="popup_sizeconsuption_component_text">Genaral</div></td>
									<td rowspan="3" class="popupsizeconsumptioncolorblue"><div class="textclass">Blue</div></td>
									<td class="headcolpop4" style="display:none"></td>
									<td class="table-size-header">XS</td>
									<td class="table-size-header">S</td>
									<td class="table-size-header">M</td>
									<td class="table-size-header">L</td>
									<td class="table-size-header">XL</td>
									<td class="table-size-header">XXL</td>
								</tr>
								<tr>
									<td  class="headcolpop4">BB</td>
									<td>
										<input type="textbox" class="newtextbox" />
									</td>
									<td><input type="textbox" class="newtextbox" /></td>
									<td><input type="textbox" class="newtextbox" /></td>
									<td><input type="textbox" class="newtextbox" /></td>
									<td><input type="textbox" class="newtextbox" /></td>
									<td><input type="textbox" class="newtextbox" /></td>
								</tr>
								<tr>
									<td class="headcolpop4">D</td>
									<td><input type="textbox" class="newtextbox" /></td>
									<td><input type="textbox" class="newtextbox" /></td>
									<td><input type="textbox" class="newtextbox" /></td>
									<td><input type="textbox" class="newtextbox" /></td>
									<td><input type="textbox" class="newtextbox" /></td>
									<td><input type="textbox" class="newtextbox" /></td>
								</tr>
								<tr>
									<td rowspan="3" class="popupsizeconsumptioncolorred"><div class="textclass">Green<div></td>
									<td  class="headcolpop4">DD</td>
									<td><input type="textbox" class="newtextbox" /></td>
									<td><input type="textbox" class="newtextbox" /></td>
									<td><input type="textbox" class="newtextbox" /></td>
									<td><input type="textbox" class="newtextbox" /></td>
									<td><input type="textbox" class="newtextbox" /></td>
									<td><input type="textbox" class="newtextbox" /></td>
								</tr>
								<tr>
									<td class="headcolpop4">C</td>
									<td><input type="textbox" class="newtextbox" /></td>
									<td><input type="textbox" class="newtextbox" /></td>
									<td><input type="textbox" class="newtextbox" /></td>
									<td><input type="textbox" class="newtextbox" /></td>
									<td><input type="textbox" class="newtextbox" /></td>
									<td><input type="textbox" class="newtextbox" /></td>
								</tr>
								<tr>
									<td class="headcolpop4">G</td>
									<td><input type="textbox" class="newtextbox" /></td>
									<td><input type="textbox" class="newtextbox" /></td>
									<td><input type="textbox" class="newtextbox" /></td>
									<td><input type="textbox" class="newtextbox" /></td>
									<td><input type="textbox" class="newtextbox" /></td>
									<td><input type="textbox" class="newtextbox" /></td>
								</tr>
								<tr>
									<td rowspan="4" class="headcolpop2y" style="display:none;"><div class="heights1">Sleeve</div></td>
									<td rowspan="2"  class="headcolpop3z" style="display:none;"><div class="textclass1">Red</div></td>
									<td class="headcolpop4">A</td>
									<td><input type="textbox" class="newtextbox" /></td>
									<td><input type="textbox" class="newtextbox" /></td>
									<td><input type="textbox" class="newtextbox" /></td>
									<td><input type="textbox" class="newtextbox" /></td>
									<td><input type="textbox" class="newtextbox" /></td>
									<td><input type="textbox" class="newtextbox" /></td>
								</tr>
								<tr>
									<td class="headcolpop4">B</td>
									<td><input type="textbox" class="newtextbox" /></td>
									<td><input type="textbox" class="newtextbox" /></td>
									<td><input type="textbox" class="newtextbox" /></td>
									<td><input type="textbox" class="newtextbox" /></td>
									<td><input type="textbox" class="newtextbox" /></td>
									<td><input type="textbox" class="newtextbox" /></td>
								</tr>
								<tr>
									<td rowspan="2" class="headcolpop3a" style="display:none;"><div class="textclass1">White</div></td>
									<td class="headcolpop4">C</td>
									<td><input type="textbox" class="newtextbox" /></td>
									<td><input type="textbox" class="newtextbox" /></td>
									<td><input type="textbox" class="newtextbox" /></td>
									<td><input type="textbox" class="newtextbox" /></td>
									<td><input type="textbox" class="newtextbox" /></td>
									<td><input type="textbox" class="newtextbox" /></td>
								</tr>
								<tr>
									<td class="headcolpop4">D</td>
									<td><input type="textbox" class="newtextbox" /></td>
									<td><input type="textbox" class="newtextbox" /></td>
									<td><input type="textbox" class="newtextbox" /></td>
									<td><input type="textbox" class="newtextbox" /></td>
									<td><input type="textbox" class="newtextbox" /></td>
									<td><input type="textbox" class="newtextbox" /></td>
								</tr>
								</tbody>
							</table>
							</section>
                    <div id="submision" class="submit-button styl-rt-submission-btn pull-right marginRight0 marginTop30">
                        <a><button id="back3" class="btn btn-info btn-lg">Save</button></a>
                        <button class="btn btn-default btn-lg btn-embossed mdlclose">Close</button>
                    </div>

                    <div class="clearfix"></div>

                </div>
            </div>
        </div>
	<!-- Group pop up ends-->	
<!-- Size vice dimension pop up start-->

<div class="modal fade drop-down-add-groups model-popup-fix addedFCS" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-lg">

                <div class="modal-content model-popup-padding">

                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
                        <h5 class="modal-title">Size Consumption</h5>
                    </div>
					
                              <div class="row ">
                                  <div class="col-sm-6 col-md-6">
                                      <div class="panel-group" id="FCStype2">
                                          <div class="panel panel-default">
                                              <div class="panel-heading"  data-parent="#FCStype2" data-target="#FCStypeBody2">
                                                  <h4 class="panel-title">
                                                      <a data-toggle="collapse" data-parent="#FCStype" href="#FCStypeBody2">
                                                      </a><a class="accordion-toggle">Set Size Dimention 1</a>
                                                  </h4>
                                              </div>
                                              <div id="FCStypeBody2" class="panel-collapse collapse" style="height: auto;">
                                                  <div class="panel-body">
                                                      <div class="row">
                                                          <div class=" ">
                                                              <div class="form-group formwithsearch marginbottom20">
                                                                  <div class="icon-addon addon-md">
                                                                      <div class="col-sm-5 col-md-5 ">
                                                                          <label for="exampleInputEmail1">Select Dimention: </label>
                                                                      </div>
                                                                      <div class="col-sm-7 col-md-7 ">
                                                                          <select type="text" class="form-control"></select>

                                                                      </div>
                                                                  </div>
                                                              </div>
                                                          </div>
                                                          <div class="clearfix"></div>

                                                          <div class="form-group formwithsearch marginbottom20">
                                                              <div class="icon-addon addon-md">
                                                                  <div class="col-sm-5 col-md-5 ">
                                                                      <label for="exampleInputEmail1">Select Attributes: </label>
                                                                  </div>
                                                                  <div class="col-sm-7 col-md-7 ">
                                                                      <select data-placeholder="Select Country" class="chosen-select" multiple style="width:100%;" tabindex="4">
                                                                          <option value=""></option>
                                                                          <option value="2">red</option>
                                                                          <option value="2">green</option>
                                                                          <option value="2">blue</option>
                                                                          <option value="2">White</option>
                                                                      </select>
                                                                  </div>
                                                              </div>
                                                          </div>
                                                          <div class="clearfix"></div>


                                                          <a href="#" class="btn btn-warning btn-embossed pull-left buttonpopupfix"><span class="glyphicon glyphicon-plus marginRight4"></span>Add to Metrix</a>
                                                      </div>

                                                  </div><!-- pannel body ends -->
                                              </div>
                                          </div>
                                      </div>

                                  </div>
                                  <!-- </div>  --><!-- end of row -->

                                  <!-- <div class="row paddingleft20"> -->
                                  <div class="col-sm-6 col-md-6">
                                      <div class="panel-group" id="bssDetails2">
                                          <div class="panel panel-default">
                                              <div class="panel-heading"  data-parent="#bssDetails2" data-target="#bssDetailsBody2">
                                                  <h4 class="panel-title">
                                                      <a data-toggle="collapse" data-parent="#bssDetails" href="#bssDetailsBody2">
                                                      </a><a class="accordion-toggle">Set Size Dimention 2</a>
                                                  </h4>
                                              </div>
                                              <div id="bssDetailsBody2" class="panel-collapse collapse" style="height: auto;">
                                                  <div class="panel-body">
                                                      <div class="row">
                                                          <div class=" ">
                                                              <div class="form-group formwithsearch marginbottom20">
                                                                  <div class="icon-addon addon-md">
                                                                      <div class="col-sm-5 col-md-5 ">
                                                                          <label for="exampleInputEmail1">Select Dimention: </label>
                                                                      </div>
                                                                      <div class="col-sm-7 col-md-7 ">
                                                                          <select type="text" class="form-control"></select>

                                                                      </div>
                                                                  </div>
                                                              </div>
                                                          </div>
                                                          <div class="clearfix"></div>

                                                          <div class="form-group formwithsearch marginbottom20">
                                                              <div class="icon-addon addon-md">
                                                                  <div class="col-sm-5 col-md-5 ">
                                                                      <label for="exampleInputEmail1">Select Attributes: </label>
                                                                  </div>
                                                                  <div class="col-sm-7 col-md-7 ">
                                                                      <select data-placeholder="Select Country" class="chosen-select" multiple style="width:100%;" tabindex="4">
                                                                          <option value=""></option>
                                                                          <option value="2">red</option>
                                                                          <option value="2">green</option>
                                                                          <option value="2">blue</option>
                                                                          <option value="2">White</option>
                                                                      </select>
                                                                  </div>
                                                              </div>
                                                          </div>
                                                          <div class="clearfix"></div>


                                                          <a href="#" class="btn btn-warning btn-embossed pull-left buttonpopupfix"><span class="glyphicon glyphicon-plus marginRight4"></span>Add to Metrix</a>
                                                      </div>



                                                  </div><!-- pannel body ends -->
                                              </div>
                                          </div>
                                      </div>

                                  </div>
                              </div> 
					            <table class="table table-bordered">
									<thead>
									  <tr>
										<th>Country</th>
										<th>Component</th>
										<th>Color</th>
										<th>Fit</th>
										<th colspan="14" style="text-align:center">Size</th>
									  </tr>
									  </thead>
									  <tbody>
									  <tr>
										<td rowspan="10">UK</td>
										<td rowspan="10">Shirt</td>
										<td rowspan="5">Blue</td>
										<td></td>
										<td class="table-size-header">XS</td>
										<td class="table-size-header">S</td>
										<td class="table-size-header">M</td>
										<td class="table-size-header">L</td>
										<td class="table-size-header">XL</td>
										<td class="table-size-header">XXl</td>
									  </tr>
									  <tr>
										<td>BB</td>
										<td>
											  <input type="checkbox" class="" />
											</td>
										<td><input type="checkbox" class="" /></td>
										<td><input type="checkbox" class="" /></td>
										<td><input type="checkbox" class="" /></td>
										<td><input type="checkbox" class="" /></td>
										<td><input type="checkbox" class="" /></td>
									  </tr>
									  <tr>
										<td>D</td>
										<td><input type="checkbox" class="" /></td>
										<td><input type="checkbox" class="" /></td>
										<td><input type="checkbox" class="" /></td>
										<td><input type="checkbox" class="" /></td>
										<td><input type="checkbox" class="" /></td>
										<td><input type="checkbox" class="" /></td>
									  </tr>
									  <tr>

										<td>DD</td>
										<td><input type="checkbox" class="" /></td>
										<td><input type="checkbox" class="" /></td>
										<td><input type="checkbox" class="" /></td>
										<td><input type="checkbox" class="" /></td>
										<td><input type="checkbox" class="" /></td>
										<td><input type="checkbox" class="" /></td>
									  </tr>
									  <tr>
										<td>C</td>
										<td><input type="checkbox" class="" /></td>
										<td><input type="checkbox" class="" /></td>
										<td><input type="checkbox" class="" /></td>
										<td><input type="checkbox" class="" /></td>
										<td><input type="checkbox" class="" /></td>
										<td><input type="checkbox" class="" /></td>
									  </tr>
									  <tr>
										<td rowspan="5">Green</td>
										<td>G</td>
										<td><input type="checkbox" class="" /></td>
										<td><input type="checkbox" class="" /></td>
										<td><input type="checkbox" class="" /></td>
										<td><input type="checkbox" class="" /></td>
										<td><input type="checkbox" class="" /></td>
										<td><input type="checkbox" class="" /></td>
									  </tr>
									  <tr>
										<td rowspan="4" style="display:none;">Sleeve</td>
										<td>A</td>
										<td><input type="checkbox" class="" /></td>
										<td><input type="checkbox" class="" /></td>
										<td><input type="checkbox" class="" /></td>
										<td><input type="checkbox" class="" /></td>
										<td><input type="checkbox" class="" /></td>
										<td><input type="checkbox" class="" /></td>
									  </tr>
									  <tr>
										<td>B</td>
										<td><input type="checkbox" class="" /></td>
										<td><input type="checkbox" class="" /></td>
										<td><input type="checkbox" class="" /></td>
										<td><input type="checkbox" class="" /></td>
										<td><input type="checkbox" class="" /></td>
										<td><input type="checkbox" class="" /></td>
									  </tr>
									  <tr>
										<td>C</td>
										<td><input type="checkbox" class="" /></td>
										<td><input type="checkbox" class="" /></td>
										<td><input type="checkbox" class="" /></td>
										<td><input type="checkbox" class="" /></td>
										<td><input type="checkbox" class="" /></td>
										<td><input type="checkbox" class="" /></td>
									  </tr>
									  <tr>
										<td>D</td>
										<td><input type="checkbox" class="" /></td>
										<td><input type="checkbox" class="" /></td>
										<td><input type="checkbox" class="" /></td>
										<td><input type="checkbox" class="" /></td>
										<td><input type="checkbox" class="" /></td>
										<td><input type="checkbox" class="" /></td>
									  </tr>
									  </tbody>
									</table> 
                    <div id="submision" class="submit-button styl-rt-submission-btn pull-right marginRight0 marginTop30">
                        <a><button id="back3" class="btn btn-default btn-lg">Refresh</button></a>
                        <button class="btn btn-info btn-lg mdlclose">Save & Close</button>
                    </div>

                    <div class="clearfix"></div>

                </div>
            </div>
        </div>	

<!-- <!-- Size vice dimension pop up End-->		 -->

<!-- <script type="text/javascript" language="javascript" src="js/jquery-1.11.0.min.js"></script> -->
<!-- <script type="text/javascript" language="javascript" src="js/bootstrap.min.js"></script>  -->
<!-- <script type="text/javascript" language="javascript" src="js/typeahead.jquery.min.js"></script> -->
<!-- <script type="text/javascript" language="javascript" src="js/multiselect.js"></script> -->
<!-- <script type="text/javascript" language="javascript" src="js/typeahead.jquery.min.js"></script>  -->
<!-- <script type="text/javascript" language="javascript" src="js/typeahead.jquery.min.js"></script> -->
<!-- <script type="text/javascript" language="javascript" src="js/the-basic-typeahead.js"></script> -->
<!-- <script type="text/javascript" language="javascript" src="js/bootstrap-datepicker.js"></script>  -->
<!-- <script type="text/javascript" language="javascript" src="js/bootstrap-switch.min.js"></script> -->
<!-- <script src="js/chosen.jquery.js" type="text/javascript"></script> -->
<!-- <script src="js/checkbox.js"></script> -->


<!-- <script type="text/javascript" language="javascript" src="js/jquery.dataTables.js"></script>
<script type="text/javascript" language="javascript" src="js/dataTables.bootstrap.js"></script>
<script type="text/javascript" language="javascript" src="js/dataTables.fixedColumns.js"></script> -->


 <script>$('#nav-dropdown .dropdown-menu').on({
    "click":function(e){
	      e.stopPropagation();
	    }
	 });
 </script>   

 <script type="text/javascript"> </script>

 <!--script type="text/javascript" language="javascript"> /*------Datatable genaration------*/
 $(document).ready( function () {

  var table = $('#oparations-grid , #route').DataTable( {
    "sScrollX": "100%",
    "lengthChange": false,

    "language": {
      "search": ""
    }
  }); /*APPEND BUTTONS TO THE TOP ROW DATA TABLE*/
  $("<a href='#' class='btn btn-warning btn-embossed pull-right'>Add New Operation</a>").appendTo('div#route_filter');
  $("<a href='#' class='btn btn-warning btn-embossed pull-right'>Add New Route</a>").appendTo('div#oparations-grid_filter');
  $("<div class='pull-left'><a href='#' class='btn btn-info btn-embossed'><span class='glyphicon glyphicon-file'></span> Duplicate Opr.</a> <a href='#' class='btn btn-info btn-embossed marginLeft10'><span class='glyphicon glyphicon-th-list'></span> Copy from Style Rt.</a> </div>").appendTo('#oparations-grid_wrapper > .row > .col-xs-6 > .right-btn-group');

  new $.fn.dataTable.FixedColumns( table, { "leftColumns":0, "rightColumns":1}); 
  

});
 </script-->
<!--   <script src="js/site_scripts.js"></script> -->
<!--   <script src="js/custom.js"></script>  -->

 
<%--
<div class="col-sm-7">
<form:errors path="*" cssClass="alert alert-danger alert-dismissable" element="div"/>
<form:form commandName="merordersheetorder" method="post" action="merordersheetorderform" cssClass="well"
           id="merordersheetorderForm" onsubmit="return validateMerordersheetorder(this)">
<ul>

    <spring:bind path="merordersheetorder.id">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}"></div>
    </spring:bind>
        <appfuse:label key="merordersheetorder.id" styleClass="control-label"/>
        <form:input path="id" id="id"/>
        <form:errors path="id" cssClass="help-block"/>
        
    
    <spring:bind path="merordersheetorder.allocation">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}"></div>
    </spring:bind>
        <appfuse:label key="merordersheetorder.allocation" styleClass="control-label"/>
        <form:input cssClass="form-control" path="allocation" id="allocation"  maxlength="45"/>
        <form:errors path="allocation" cssClass="help-block"/>
        
    
    <spring:bind path="merordersheetorder.buyerPo">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}"></div>
    </spring:bind>
        <appfuse:label key="merordersheetorder.buyerPo" styleClass="control-label"/>
        <form:input cssClass="form-control" path="buyerPo" id="buyerPo"  maxlength="20"/>
        <form:errors path="buyerPo" cssClass="help-block"/>
        --%>
   
   <%--  <!-- todo: change this to read the identifier field from the other pojo -->
    <form:select cssClass="form-control" path="merordersheethdr" items="merordersheethdrList" itemLabel="label" itemValue="value"/>
    <!-- todo: change this to read the identifier field from the other pojo -->
    <form:select cssClass="form-control" path="merordersheethdr" items="merordersheethdrList" itemLabel="label" itemValue="value"/> --%>
<%--    
    <spring:bind path="merordersheetorder.orderNo">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}"> </div>
    </spring:bind>
        <appfuse:label key="merordersheetorder.orderNo" styleClass="control-label"/>
        <form:input cssClass="form-control" path="orderNo" id="orderNo"  maxlength="15"/>
        <form:errors path="orderNo" cssClass="help-block"/>
    
    <spring:bind path="merordersheetorder.orderStatus">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}"></div>
    </spring:bind>
        <appfuse:label key="merordersheetorder.orderStatus" styleClass="control-label"/>
        <form:input cssClass="form-control" path="orderStatus" id="orderStatus"  maxlength="10"/>
        <form:errors path="orderStatus" cssClass="help-block"/>
    
    <spring:bind path="merordersheetorder.ordersheetCategory">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}"> </div>
    </spring:bind>
        <appfuse:label key="merordersheetorder.ordersheetCategory" styleClass="control-label"/>
        <form:input cssClass="form-control" path="ordersheetCategory" id="ordersheetCategory"  maxlength="10"/>
        <form:errors path="ordersheetCategory" cssClass="help-block"/>

    <spring:bind path="merordersheetorder.qty">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}"></div>
    </spring:bind>
        <appfuse:label key="merordersheetorder.qty" styleClass="control-label"/>
        <form:input cssClass="form-control" path="qty" id="qty"  maxlength="255"/>
        <form:errors path="qty" cssClass="help-block"/>

    <spring:bind path="merordersheetorder.salesOrderNo">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}"></div>
    </spring:bind>
        <appfuse:label key="merordersheetorder.salesOrderNo" styleClass="control-label"/>
        <form:input cssClass="form-control" path="salesOrderNo" id="salesOrderNo"  maxlength="15"/>
        <form:errors path="salesOrderNo" cssClass="help-block"/>
 
    <spring:bind path="merordersheetorder.sizeBackup">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}"></div>
    </spring:bind>
        <appfuse:label key="merordersheetorder.sizeBackup" styleClass="control-label"/>
        <form:input cssClass="form-control" path="sizeBackup" id="sizeBackup"  maxlength="10"/>
        <form:errors path="sizeBackup" cssClass="help-block"/>
    

    <div class="form-group">
        <button type="submit" class="btn btn-primary" name="save" onclick="bCancel=false">
            <i class="icon-ok icon-white"></i> <fmt:message key="button.save"/>
        </button>
        <c:if test="${not empty merordersheetorder.id}">
            <button type="submit" class="btn btn-warning" name="delete" onclick="bCancel=true;return confirmMessage(msgDelConfirm)">
                <i class="icon-trash icon-white"></i> <fmt:message key="button.delete"/>
            </button>
        </c:if>

        <button type="submit" class="btn btn-default" name="cancel" onclick="bCancel=true">
            <i class="icon-remove"></i> <fmt:message key="button.cancel"/>
        </button>
    </div>
    
</ul> 
</form:form>
</div>

<v:javascript formName="merordersheetorder" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<c:url value='/scripts/validator.jsp'/>"></script>

<script type="text/javascript">
    $(document).ready(function() {
        $("input[type='text']:visible:enabled:first", document.forms['merordersheetorderForm']).focus();
    });
</script>

--%>