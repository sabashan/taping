<%@ include file="/common/taglibs.jsp"%>

<menu:useMenuDisplayer name="Velocity" config="navbarMenu.vm" permissions="rolesAdapter">
<div class="collapse navbar-collapse" id="navbar">
<ul class="list-unstyled has-dropdown">
    <c:if test="${empty pageContext.request.remoteUser}">
        <li class="active">
            <a href="<c:url value="/login"/>"><fmt:message key="login.title"/></a>
        </li>
    </c:if><!--  -->
    <menu:displayMenu name="Home"/>
    <%-- <menu:displayMenu name="UserMenu"/> --%>
<%--     <menu:displayMenu name="AdminMenu"/>  --%>
    <menu:displayMenu name="MststyleheaderMenu"/>
    <menu:displayMenu name="Logout"/>
    <!--Mststylewippoints-START-->
<%--     <menu:displayMenu name="MststylewippointsMenu"/> --%>
    <!--Mststylewippoints-END-->
    <!--Mststylewippointitemtype-START-->
<%--     <menu:displayMenu name="MststylewippointitemtypeMenu"/> --%>
    <!--Mststylewippointitemtype-END-->
    <!--Merprecostsheet-START-->
<%--    <menu:displayMenu name="MerprecostsheetMenu"/>--%>
    <!--Merprecostsheet-END-->
    <!--Mercostsheethdr-START-->
    <menu:displayMenu name="MercostsheethdrMenu"/>
    <!--Mercostsheethdr-END-->
    <!--Merordersheethdr-START-->
    <menu:displayMenu name="MerordersheethdrMenu"/>
    <!--Merordersheethdr-END-->
    <!--Merordersheetorder-START-->
    <menu:displayMenu name="MerordersheetorderMenu"/>
    <!--Merordersheetorder-END-->
</ul>
</div>
</menu:useMenuDisplayer>
