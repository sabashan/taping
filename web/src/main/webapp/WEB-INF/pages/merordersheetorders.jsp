<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="merordersheetorderList.title"/></title>
    <meta name="menu" content="MerordersheetorderMenu"/>
</head>

<c:if test="{'$'}{not empty searchError}">
    <div class="alert alert-danger alert-dismissable">
        <a href="#" data-dismiss="alert" class="close">&times;</a>
        <c:out value="{'$'}{searchError}"/>
    </div>
</c:if>

<div class="col-sm-10">
    <h2><fmt:message key="merordersheetorderList.heading"/></h2>

    <form method="get" action="${ctx}/merordersheetorders" id="searchForm" class="form-inline">
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

    <fmt:message key="merordersheetorderList.message"/>

    <div id="actions" class="btn-group">
        <a href='<c:url value="/merordersheetorderform"/>' class="btn btn-primary">
            <i class="icon-plus icon-white"></i> <fmt:message key="button.add"/></a>
        <a href='<c:url value="/home"/>' class="btn btn-default"><i class="icon-ok"></i> <fmt:message key="button.done"/></a>
    </div>

<display:table name="merordersheetorderList" class="table table-condensed table-striped table-hover" requestURI="" id="merordersheetorderList" export="true" pagesize="25">
    <display:column property="id" sortable="true" href="merordersheetorderform" media="html"
        paramId="id" paramProperty="id" titleKey="merordersheetorder.id"/>
    <display:column property="id" media="csv excel xml pdf" titleKey="merordersheetorder.id"/>
    <display:column property="allocation" sortable="true" titleKey="merordersheetorder.allocation"/>
    <display:column property="buyerPo" sortable="true" titleKey="merordersheetorder.buyerPo"/>
    <display:column property="orderNo" sortable="true" titleKey="merordersheetorder.orderNo"/>
    <display:column property="orderStatus" sortable="true" titleKey="merordersheetorder.orderStatus"/>
    <display:column property="ordersheetCategory" sortable="true" titleKey="merordersheetorder.ordersheetCategory"/>
    <display:column property="qty" sortable="true" titleKey="merordersheetorder.qty"/>
    <display:column property="salesOrderNo" sortable="true" titleKey="merordersheetorder.salesOrderNo"/>
    <display:column property="sizeBackup" sortable="true" titleKey="merordersheetorder.sizeBackup"/>

    <display:setProperty name="paging.banner.item_name"><fmt:message key="merordersheetorderList.merordersheetorder"/></display:setProperty>
    <display:setProperty name="paging.banner.items_name"><fmt:message key="merordersheetorderList.merordersheetorders"/></display:setProperty>

    <display:setProperty name="export.excel.filename"><fmt:message key="merordersheetorderList.title"/>.xls</display:setProperty>
    <display:setProperty name="export.csv.filename"><fmt:message key="merordersheetorderList.title"/>.csv</display:setProperty>
    <display:setProperty name="export.pdf.filename"><fmt:message key="merordersheetorderList.title"/>.pdf</display:setProperty>
</display:table>
