<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="mststyleoperationList.title"/></title>
    <meta name="menu" content="MststyleoperationMenu"/>
</head>

<c:if test="{'$'}{not empty searchError}">
    <div class="alert alert-danger alert-dismissable">
        <a href="#" data-dismiss="alert" class="close">&times;</a>
        <c:out value="{'$'}{searchError}"/>
    </div>
</c:if>

<div class="col-sm-10">
    <h2><fmt:message key="mststyleoperationList.heading"/></h2>

    <form method="get" action="${ctx}/mststyleoperations" id="searchForm" class="form-inline">
    <div id="search" class="text-right">
        <span class="col-sm-9">
            <input type="text" size="20" name="q" id="query" value="${param.q}"
                   placeholder="<fmt:message key="search.enterTerms"/>" class="form-control input-sm"/>
        </span>
        <button id="button.search" class="btn btn-default" type="submit">
            <i class="icon-search"></i> <fmt:message key="button.search"/>
        </button>
    </div>
    </form>

    <fmt:message key="mststyleoperationList.message"/>

    <div id="actions" class="btn-group">
        <a href='<c:url value="/mststyleoperationform"/>' class="btn btn-primary">
            <i class="icon-plus icon-white"></i> <fmt:message key="button.add"/></a>
        <a href='<c:url value="/home"/>' class="btn btn-default"><i class="icon-ok"></i> <fmt:message key="button.done"/></a>
    </div>

<display:table name="mststyleoperationList" class="table table-condensed table-striped table-hover" requestURI="" id="mststyleoperationList" export="true" pagesize="25">
    <display:column property="id" sortable="true" href="mststyleoperationform" media="html"
        paramId="id" paramProperty="id" titleKey="mststyleoperation.id"/>
    <display:column property="id" media="csv excel xml pdf" titleKey="mststyleoperation.id"/>
    <display:column property="averageSmv" sortable="true" titleKey="mststyleoperation.averageSmv"/>
    <display:column property="calc" sortable="true" titleKey="mststyleoperation.calc"/>
    <display:column property="defaultSmv" sortable="true" titleKey="mststyleoperation.defaultSmv"/>
    <display:column property="grade" sortable="true" titleKey="mststyleoperation.grade"/>
    <display:column property="machineTypeDefault" sortable="true" titleKey="mststyleoperation.machineTypeDefault"/>
    <display:column property="manual" sortable="true" titleKey="mststyleoperation.manual"/>
    <display:column property="operation" sortable="true" titleKey="mststyleoperation.operation"/>
    <display:column property="operationDesc" sortable="true" titleKey="mststyleoperation.operationDesc"/>
    <display:column property="operationDescBref" sortable="true" titleKey="mststyleoperation.operationDescBref"/>
    <display:column property="operationType" sortable="true" titleKey="mststyleoperation.operationType"/>
    <display:column property="printBundleTicket" sortable="true" titleKey="mststyleoperation.printBundleTicket"/>
    <display:column property="process" sortable="true" titleKey="mststyleoperation.process"/>
    <display:column property="revision1" sortable="true" titleKey="mststyleoperation.revision1"/>
    <display:column property="revision2" sortable="true" titleKey="mststyleoperation.revision2"/>
    <display:column property="revision3" sortable="true" titleKey="mststyleoperation.revision3"/>
    <display:column property="revision4" sortable="true" titleKey="mststyleoperation.revision4"/>
    <display:column property="revision5" sortable="true" titleKey="mststyleoperation.revision5"/>
    <display:column property="sequenceNo" sortable="true" titleKey="mststyleoperation.sequenceNo"/>
    <display:column property="sewingOperation" sortable="true" titleKey="mststyleoperation.sewingOperation"/>
    <display:column property="sizeWiseSmvMatrix" sortable="true" titleKey="mststyleoperation.sizeWiseSmvMatrix"/>
    <display:column property="wipPoints" sortable="true" titleKey="mststyleoperation.wipPoints"/>
    <display:column property="workAid" sortable="true" titleKey="mststyleoperation.workAid"/>

    <display:setProperty name="paging.banner.item_name"><fmt:message key="mststyleoperationList.mststyleoperation"/></display:setProperty>
    <display:setProperty name="paging.banner.items_name"><fmt:message key="mststyleoperationList.mststyleoperations"/></display:setProperty>

    <display:setProperty name="export.excel.filename"><fmt:message key="mststyleoperationList.title"/>.xls</display:setProperty>
    <display:setProperty name="export.csv.filename"><fmt:message key="mststyleoperationList.title"/>.csv</display:setProperty>
    <display:setProperty name="export.pdf.filename"><fmt:message key="mststyleoperationList.title"/>.pdf</display:setProperty>
</display:table>
