<%@ include file="/common/taglibs.jsp" %>

<head>
    <title><fmt:message key="activeUsers.title"/></title>
    <meta name="menu" content="AdminMenu"/>
</head>
<body id="activeUsers">

<div class="col-sm-12 col-md-12">
<h1><fmt:message key="activeUsers.heading"/></h1>

<%--     <p><fmt:message key="activeUsers.message"/></p> --%>

    <div id="actions" class="form-group">
        <a href="${ctx}/home" class="btn btn-primary">
            <i class="icon-ok icon-white"></i> <fmt:message key="button.done"/></a>
    </div>

<div class="panel-group" id="stylebrowser">
    <display:table name="applicationScope.userNames" id="user" cellspacing="0" cellpadding="0"
                   defaultsort="1" class="datatable table table-striped table-bordered dataTable" pagesize="50" requestURI="">
        <display:column property="username" escapeXml="true" style="width: 30%" titleKey="user.username"
                        sortable="true"/>
        <display:column titleKey="activeUsers.fullName" sortable="true">
            <c:out value="${user.userName}" escapeXml="true"/>
            <c:if test="${not empty user.EMailAddress}">
                <a href="mailto:<c:out value="${user.EMailAddress}"/>">
                    <img src="<c:url value="/images/iconEmail.gif"/>"
                         alt="<fmt:message key="icon.email"/>" class="icon"/></a>
            </c:if>
        </display:column>

        <display:setProperty name="paging.banner.item_name" value="user"/>
        <display:setProperty name="paging.banner.items_name" value="users"/>
    </display:table>
</div>
</div>
</body>
