<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="userProfile.title"/></title>
    <meta name="menu" content="UserMenu"/>
</head>

<c:set var="delObject" scope="request"><fmt:message key="userList.user"/></c:set>
<script type="text/javascript">var msgDelConfirm =
   "<fmt:message key="delete.confirm"><fmt:param value="${delObject}"/></fmt:message>";
</script>

<div class="col-sm-12 col-md-12">
    <h1><fmt:message key="userProfile.heading"/></h1>
</div>

<div class="row paddingleft20"> <!--View Page start-->
  <div class="col-sm-12 col-md-12">

    <h3 class="marginbottom5">
    <c:choose>
        <c:when test="${param.from == 'list'}">
            <fmt:message key="userProfile.admin.message"/>
        </c:when>
        <c:otherwise>
            <fmt:message key="userProfile.message"/>
        </c:otherwise>
    </c:choose></h3>
    <hr>
  </div>
</div>

<div class="col-sm-7">
    <spring:bind path="user.*">
        <c:if test="${not empty status.errorMessages}">
            <div class="alert alert-danger alert-dismissable">
                <a href="#" data-dismiss="alert" class="close">&times;</a>
                <c:forEach var="error" items="${status.errorMessages}">
                    <c:out value="${error}" escapeXml="false"/><br/>
                </c:forEach>
            </div>
        </c:if>
    </spring:bind>

    <form:errors path="*" cssClass="alert alert-danger alert-dismissable" element="div"/>
	<form:form commandName="mstuser" method="post" action="userform" cssClass="well"
           id="mstuserForm" onsubmit="return validateUser(this)">
<ul>
    <spring:bind path="mstuser.userId">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mstuser.userId" styleClass="control-label"/>
        <form:input path="userId" id="userId" cssClass="form-control"/>
        <form:errors path="userId" cssClass="help-block"/>
    </div>
    <spring:bind path="mstuser.EMailAddress">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mstuser.EMailAddress" styleClass="control-label"/>
        <form:input cssClass="form-control" path="EMailAddress" id="EMailAddress"  maxlength="50"/>
        <form:errors path="EMailAddress" cssClass="help-block"/>
    </div>
    <spring:bind path="mstuser.activeInactiveFlag">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mstuser.activeInactiveFlag" styleClass="control-label"/>
        <form:input cssClass="form-control" path="activeInactiveFlag" id="activeInactiveFlag"  maxlength="1"/>
        <form:errors path="activeInactiveFlag" cssClass="help-block"/>
    </div>
    <spring:bind path="mstuser.createdAt">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mstuser.createdAt" styleClass="control-label"/>
        <form:input cssClass="form-control" path="createdAt" id="createdAt"  maxlength="10"/>
        <form:errors path="createdAt" cssClass="help-block"/>
    </div>
    <spring:bind path="mstuser.createdBy">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mstuser.createdBy" styleClass="control-label"/>
        <form:input cssClass="form-control" path="createdBy" id="createdBy"  maxlength="10"/>
        <form:errors path="createdBy" cssClass="help-block"/>
    </div>
    <spring:bind path="mstuser.createdOn">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mstuser.createdOn" styleClass="control-label"/>
        <form:input cssClass="form-control" path="createdOn" id="createdOn"  maxlength="19"/>
        <form:errors path="createdOn" cssClass="help-block"/>
    </div>
    <spring:bind path="mstuser.lastLoginDate">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mstuser.lastLoginDate" styleClass="control-label"/>
        <form:input cssClass="form-control" path="lastLoginDate" id="lastLoginDate"  maxlength="19"/>
        <form:errors path="lastLoginDate" cssClass="help-block"/>
    </div>
    <spring:bind path="mstuser.lastLoginDetails">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mstuser.lastLoginDetails" styleClass="control-label"/>
        <form:input cssClass="form-control" path="lastLoginDetails" id="lastLoginDetails"  maxlength="150"/>
        <form:errors path="lastLoginDetails" cssClass="help-block"/>
    </div>
    <spring:bind path="mstuser.locationCode">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mstuser.locationCode" styleClass="control-label"/>
        <form:input cssClass="form-control" path="locationCode" id="locationCode"  maxlength="6"/>
        <form:errors path="locationCode" cssClass="help-block"/>
    </div>
    <spring:bind path="mstuser.modifiedAt">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mstuser.modifiedAt" styleClass="control-label"/>
        <form:input cssClass="form-control" path="modifiedAt" id="modifiedAt"  maxlength="10"/>
        <form:errors path="modifiedAt" cssClass="help-block"/>
    </div>
    <spring:bind path="mstuser.modifiedBy">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mstuser.modifiedBy" styleClass="control-label"/>
        <form:input cssClass="form-control" path="modifiedBy" id="modifiedBy"  maxlength="10"/>
        <form:errors path="modifiedBy" cssClass="help-block"/>
    </div>
    <spring:bind path="mstuser.modifiedOn">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mstuser.modifiedOn" styleClass="control-label"/>
        <form:input cssClass="form-control" path="modifiedOn" id="modifiedOn"  maxlength="19"/>
        <form:errors path="modifiedOn" cssClass="help-block"/>
    </div>
    <spring:bind path="mstuser.multistkLocation">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mstuser.multistkLocation" styleClass="control-label"/>
        <form:input cssClass="form-control" path="multistkLocation" id="multistkLocation"  maxlength="6"/>
        <form:errors path="multistkLocation" cssClass="help-block"/>
    </div>
    <spring:bind path="mstuser.reason">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mstuser.reason" styleClass="control-label"/>
        <form:input cssClass="form-control" path="reason" id="reason"  maxlength="255"/>
        <form:errors path="reason" cssClass="help-block"/>
    </div>
    <spring:bind path="mstuser.userGroup">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mstuser.userGroup" styleClass="control-label"/>
        <form:input cssClass="form-control" path="userGroup" id="userGroup"  maxlength="10"/>
        <form:errors path="userGroup" cssClass="help-block"/>
    </div>
    <spring:bind path="mstuser.userName">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mstuser.userName" styleClass="control-label"/>
        <form:input cssClass="form-control" path="userName" id="userName"  maxlength="20"/>
        <form:errors path="userName" cssClass="help-block"/>
    </div>
    <spring:bind path="mstuser.userPw">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mstuser.userPw" styleClass="control-label"/>
        <form:input cssClass="form-control" path="userPw" id="userPw"  maxlength="20"/>
        <form:errors path="userPw" cssClass="help-block"/>
    </div>
    <spring:bind path="mstuser.userSignature">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mstuser.userSignature" styleClass="control-label"/>
        <form:input cssClass="form-control" path="userSignature" id="userSignature"  maxlength="255"/>
        <form:errors path="userSignature" cssClass="help-block"/>
    </div>
    <spring:bind path="mstuser.userType">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mstuser.userType" styleClass="control-label"/>
        <form:input cssClass="form-control" path="userType" id="userType"  maxlength="6"/>
        <form:errors path="userType" cssClass="help-block"/>
    </div>

    <div class="form-group">
        <button type="submit" class="btn btn-primary" name="save" onclick="bCancel=false">
            <i class="icon-ok icon-white"></i> <fmt:message key="button.save"/>
        </button>
        <c:if test="${not empty mstuser.userId}">
            <button type="submit" class="btn btn-warning" name="delete" onclick="bCancel=true;return confirmMessage(msgDelConfirm)">
                <i class="icon-trash icon-white"></i> <fmt:message key="button.delete"/>
            </button>
        </c:if>

        <button type="submit" class="btn btn-default" name="cancel" onclick="bCancel=true">
            <i class="icon-remove"></i> <fmt:message key="button.cancel"/>
        </button>
    </div>
</form:form>
</div>


<c:set var="scripts" scope="request">
<script type="text/javascript">
// This is here so we can exclude the selectAll call when roles is hidden
function onFormSubmit(theForm) {
    return validateUser(theForm);
}
</script>
</c:set>

<v:javascript formName="mstuser" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<c:url value='/scripts/validator.jsp'/>"></script>

<script type="text/javascript">
    $(document).ready(function() {
        $("input[type='text']:visible:enabled:first", document.forms['mstuserForm']).focus();
    });
</script>




