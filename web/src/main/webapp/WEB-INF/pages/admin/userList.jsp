<%@ include file="/common/taglibs.jsp" %>

<head>
    <title><fmt:message key="userList.title"/></title>
    <meta name="menu" content="AdminMenu"/>
</head>

<c:if test="${not empty searchError}">
    <div class="alert alert-danger alert-dismissable">
        <a href="#" data-dismiss="alert" class="close">&times;</a>
        <c:out value="${searchError}"/>
    </div>
</c:if>

     <div class="col-sm-12 col-md-12">
    <h1><fmt:message key="userList.heading"/></h1>

<%--     <form method="get" action="${ctx}/admin/users" id="searchForm" class="form-inline"> --%>
<!--     <div id="search" class="text-right"> -->
<!--         <span class="col-sm-9"> -->
<%--             <input type="text" size="20" name="q" id="query" value="${param.q}" --%>
<%--                    placeholder="<fmt:message key="search.enterTerms"/>" class="form-control input-sm"> --%>
<!--         </span> -->
<!--         <button id="button.search" class="btn btn-default btn-sm" type="submit"> -->
<%--             <i class="icon-search"></i> <fmt:message key="button.search"/> --%>
<!--         </button> -->
<!--     </div> -->
<!--     </form> -->

    <div id="actions" class="btn-group">
        <a class="btn btn-primary" href="<c:url value='/userform?method=Add&from=list'/>">
            <i class="icon-plus icon-white"></i> <fmt:message key="button.add"/></a>

        <a class="btn btn-default" href="<c:url value='/home'/>">
            <i class="icon-ok"></i> <fmt:message key="button.done"/></a>
    </div>

<div class="panel-group" id="stylebrowser">

    <display:table name="mstuserList" cellspacing="0" cellpadding="0" requestURI=""
                   defaultsort="1" id="mstuserList" pagesize="25" class="datatable table table-striped table-bordered dataTable" export="true">
        <display:column property="userName" escapeXml="true" sortable="true" titleKey="user.username" style="width: 25%"
                        url="/userform?from=list" paramId="id" paramProperty="userId"/>
        <display:column property="userName" escapeXml="true" sortable="true" titleKey="activeUsers.fullName"
                        style="width: 34%"/>
        <display:column property="EMailAddress" sortable="true" titleKey="user.email" style="width: 25%" autolink="true"
                        media="html"/>
        <display:column property="EMailAddress" titleKey="user.email" media="csv xml excel pdf"/>
        <display:column sortProperty="activeInactiveFlag" sortable="true" titleKey="user.enabled"
                        style="width: 16%; padding-left: 15px" media="html">${user} 1 
            <input type="checkbox" disabled="disabled" <c:if test="${Mstuser.activeInactiveFlag == 'F'}">checked="checked"</c:if>/>
        </display:column>
        <display:column property="activeInactiveFlag" titleKey="user.enabled" media="csv xml excel pdf"/>

        <display:setProperty name="paging.banner.item_name"><fmt:message key="mstuserList.Mstuser"/></display:setProperty>
        <display:setProperty name="paging.banner.items_name"><fmt:message key="mstuserList.Mstuser"/></display:setProperty>

        <display:setProperty name="export.excel.filename" value="Mstuser List.xls"/>
        <display:setProperty name="export.csv.filename" value="Mstuser List.csv"/>
        <display:setProperty name="export.pdf.filename" value="Mstuser List.pdf"/>
    </display:table>
    
</div>

</div>
