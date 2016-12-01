<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="mstcustomerList.title"/></title>
    <meta name="menu" content="MstcustomerMenu"/>
</head>

<c:if test="{'$'}{not empty searchError}">
    <div class="alert alert-danger alert-dismissable">
        <a href="#" data-dismiss="alert" class="close">&times;</a>
        <c:out value="{'$'}{searchError}"/>
    </div>
</c:if>

<div class="col-sm-12 col-md-12">
    <h1><fmt:message key="mstcustomerList.heading"/></h1>

    <div id="actions" class="btn-group">
        <a href='<c:url value="/mstcustomerform"/>' class="btn btn-primary">
            <i class="icon-plus icon-white"></i> <fmt:message key="button.add"/></a>
        <a href='<c:url value="/home"/>' class="btn btn-default"><i class="icon-ok"></i> <fmt:message key="button.done"/></a>
    </div>
    
<%--     <form method="get" action="${ctx}/mstcustomers" id="searchForm" class="form-inline"> --%>
<!--     <div id="search" class="text-right"> -->
<!--         <span class="col-sm-9"> -->
<%--             <input type="text" size="20" name="q" id="query" value="${param.q}" --%>
<%--                    placeholder="<fmt:message key="search.enterTerms"/>" class="form-control input-sm"/> --%>
<!--         </span> -->
<!--         <button id="button.search" class="btn btn-default" type="submit"> -->
<%--             <i class="icon-search"></i> <fmt:message key="button.search"/> --%>
<!--         </button> -->
<!--     </div> -->
<!--     </form> -->

<%--     <fmt:message key="mstcustomerList.message"/> --%>
<div class="panel-group" id="stylebrowser">
        <div class="panel panel-default">
          <div class="panel-heading" data-toggle="collapse" data-parent="#stylebrowser" data-target="#styleBrowserBody">
            <h4 class="panel-title">
              
               <a class="accordion-toggle"> <span class="pull-right slideupdowntoggle glyphicon glyphicon-chevron-up"></span> Customer Browser</a>
            
            </h4>
          </div>
          <div id="styleBrowserBody" class="panel-collapse collapse">
            <div class="panel-body">

<div class="panel-group" id="stylebrowser">
<display:table name="mstcustomerList" class="datatable table table-striped table-bordered dataTable" requestURI="" id="mstcustomerList" export="true" pagesize="25">
    <display:column property="id" media="csv excel xml pdf" titleKey="mstcustomer.id"/>
    <display:column property="boiRegno" sortable="true" titleKey="mstcustomer.boiRegno"/>
<%--     <display:column property="buyerEmail" sortable="true" titleKey="mstcustomer.buyerEmail"/> --%>
<%--     <display:column property="chequeName" sortable="true" titleKey="mstcustomer.chequeName"/> --%>
    <display:column property="contactName" sortable="true" titleKey="mstcustomer.contactName"/>
<display:column href="mstcustomerform" paramId="id" paramProperty="id" media="html">Edit</display:column>
<%--     <display:column property="crTerm" sortable="true" titleKey="mstcustomer.crTerm"/> --%>
<%--     <display:column property="createdAt" sortable="true" titleKey="mstcustomer.createdAt"/> --%>
<%--     <display:column property="createdBy" sortable="true" titleKey="mstcustomer.createdBy"/> --%>
<%--     <display:column property="createdOn" sortable="true" titleKey="mstcustomer.createdOn"/> --%>
<%--     <display:column property="creditLimit" sortable="true" titleKey="mstcustomer.creditLimit"/> --%>
<%--     <display:column property="custAddress" sortable="true" titleKey="mstcustomer.custAddress"/> --%>
<%--     <display:column property="custName" sortable="true" titleKey="mstcustomer.custName"/> --%>
<%--     <display:column property="custReference" sortable="true" titleKey="mstcustomer.custReference"/> --%>
<%--     <display:column property="custType" sortable="true" titleKey="mstcustomer.custType"/> --%>
<%--     <display:column property="dtFormat" sortable="true" titleKey="mstcustomer.dtFormat"/> --%>
<%--     <display:column property="emailAddress" sortable="true" titleKey="mstcustomer.emailAddress"/> --%>
<%--     <display:column property="extDiscPer" sortable="true" titleKey="mstcustomer.extDiscPer"/> --%>
<%--     <display:column property="factoryDayvalue" sortable="true" titleKey="mstcustomer.factoryDayvalue"/> --%>
<%--     <display:column property="faxNo" sortable="true" titleKey="mstcustomer.faxNo"/> --%>
<%--     <display:column property="financeAmt" sortable="true" titleKey="mstcustomer.financeAmt"/> --%>
<%--     <display:column property="fobValue" sortable="true" titleKey="mstcustomer.fobValue"/> --%>
<%--     <display:column property="glCtrlAcc" sortable="true" titleKey="mstcustomer.glCtrlAcc"/> --%>
<%--     <display:column property="importFr" sortable="true" titleKey="mstcustomer.importFr"/> --%>
<%--     <display:column property="intDiscPer" sortable="true" titleKey="mstcustomer.intDiscPer"/> --%>
<%--     <display:column property="invCustCode" sortable="true" titleKey="mstcustomer.invCustCode"/> --%>
<%--     <display:column property="markupPercentage" sortable="true" titleKey="mstcustomer.markupPercentage"/> --%>
<%--     <display:column property="maxQtyallowPcn" sortable="true" titleKey="mstcustomer.maxQtyallowPcn"/> --%>
<%--     <display:column property="minimumPack" sortable="true" titleKey="mstcustomer.minimumPack"/> --%>
<%--     <display:column property="modifiedAt" sortable="true" titleKey="mstcustomer.modifiedAt"/> --%>
<%--     <display:column property="modifiedBy" sortable="true" titleKey="mstcustomer.modifiedBy"/> --%>
<%--     <display:column property="modifiedOn" sortable="true" titleKey="mstcustomer.modifiedOn"/> --%>
<%--     <display:column property="numberofDecimal" sortable="true" titleKey="mstcustomer.numberofDecimal"/> --%>
<%--     <display:column property="ocdComm" sortable="true" titleKey="mstcustomer.ocdComm"/> --%>
<%--     <display:column property="othComm" sortable="true" titleKey="mstcustomer.othComm"/> --%>
<%--     <display:column property="ownerShip" sortable="true" titleKey="mstcustomer.ownerShip"/> --%>
<%--     <display:column property="salesGlCode" sortable="true" titleKey="mstcustomer.salesGlCode"/> --%>
<%--     <display:column property="taxNo" sortable="true" titleKey="mstcustomer.taxNo"/> --%>
<%--     <display:column property="telNo" sortable="true" titleKey="mstcustomer.telNo"/> --%>
<%--     <display:column property="tlxNo" sortable="true" titleKey="mstcustomer.tlxNo"/> --%>
<%--     <display:column property="tqbNo" sortable="true" titleKey="mstcustomer.tqbNo"/> --%>
<%--     <display:column property="trackingReference" sortable="true" titleKey="mstcustomer.trackingReference"/> --%>

    <display:setProperty name="paging.banner.item_name"><fmt:message key="mstcustomerList.mstcustomer"/></display:setProperty>
    <display:setProperty name="paging.banner.items_name"><fmt:message key="mstcustomerList.mstcustomers"/></display:setProperty>

    <display:setProperty name="export.excel.filename"><fmt:message key="mstcustomerList.title"/>.xls</display:setProperty>
    <display:setProperty name="export.csv.filename"><fmt:message key="mstcustomerList.title"/>.csv</display:setProperty>
    <display:setProperty name="export.pdf.filename"><fmt:message key="mstcustomerList.title"/>.pdf</display:setProperty>
</display:table>
</div>
			</div>
          </div>
        </div>
      </div>
</div>
