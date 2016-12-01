<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="mststyleoperationDetail.title"/></title>
    <meta name="heading" content="<fmt:message key='mststyleoperationDetail.heading'/>"/>
</head>

<c:set var="delObject" scope="request"><fmt:message key="mststyleoperationList.mststyleoperation"/></c:set>
<script type="text/javascript">var msgDelConfirm =
   "<fmt:message key="delete.confirm"><fmt:param value="${delObject}"/></fmt:message>";
</script>

<div class="col-sm-2">
    <h2><fmt:message key="mststyleoperationDetail.heading"/></h2>
    <fmt:message key="mststyleoperationDetail.message"/>
</div>

<div class="col-sm-7">
<form:errors path="*" cssClass="alert alert-danger alert-dismissable" element="div"/>
<form:form commandName="mststyleoperation" method="post" action="mststyleoperationform" cssClass="well"
           id="mststyleoperationForm" onsubmit="return validateMststyleoperation(this)">
<ul>
    <spring:bind path="mststyleoperation.id">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mststyleoperation.id" styleClass="control-label"/>
        <form:input path="id" id="id"/>
        <form:errors path="id" cssClass="help-block"/>
    </div>
    <spring:bind path="mststyleoperation.averageSmv">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mststyleoperation.averageSmv" styleClass="control-label"/>
        <form:input cssClass="form-control" path="averageSmv" id="averageSmv"  maxlength="255"/>
        <form:errors path="averageSmv" cssClass="help-block"/>
    </div>
    <spring:bind path="mststyleoperation.calc">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mststyleoperation.calc" styleClass="control-label"/>
        <form:checkbox path="calc" id="calc" cssClass="checkbox"/>
        <form:errors path="calc" cssClass="help-block"/>
    </div>
    <spring:bind path="mststyleoperation.defaultSmv">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mststyleoperation.defaultSmv" styleClass="control-label"/>
        <form:input cssClass="form-control" path="defaultSmv" id="defaultSmv"  maxlength="255"/>
        <form:errors path="defaultSmv" cssClass="help-block"/>
    </div>
    <spring:bind path="mststyleoperation.grade">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mststyleoperation.grade" styleClass="control-label"/>
        <form:input cssClass="form-control" path="grade" id="grade"  maxlength="45"/>
        <form:errors path="grade" cssClass="help-block"/>
    </div>
    <spring:bind path="mststyleoperation.machineTypeDefault">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mststyleoperation.machineTypeDefault" styleClass="control-label"/>
        <form:input cssClass="form-control" path="machineTypeDefault" id="machineTypeDefault"  maxlength="6"/>
        <form:errors path="machineTypeDefault" cssClass="help-block"/>
    </div>
    <spring:bind path="mststyleoperation.manual">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mststyleoperation.manual" styleClass="control-label"/>
        <form:checkbox path="manual" id="manual" cssClass="checkbox"/>
        <form:errors path="manual" cssClass="help-block"/>
    </div>
    <!-- todo: change this to read the identifier field from the other pojo -->
    <%-- <form:select cssClass="form-control" path="mststylerouteoperation" items="mststylerouteoperationList" itemLabel="label" itemValue="value"/>
    <!-- todo: change this to read the identifier field from the other pojo -->
    <form:select cssClass="form-control" path="mststylerouteoperation" items="mststylerouteoperationList" itemLabel="label" itemValue="value"/>
    <!-- todo: change this to read the identifier field from the other pojo -->
    <form:select cssClass="form-control" path="mststylerouteoperation" items="mststylerouteoperationList" itemLabel="label" itemValue="value"/>
    <!-- todo: change this to read the identifier field from the other pojo -->
    <form:select cssClass="form-control" path="mststylerouteoperation" items="mststylerouteoperationList" itemLabel="label" itemValue="value"/>
    <!-- todo: change this to read the identifier field from the other pojo -->
    <form:select cssClass="form-control" path="mststylerouteoperation" items="mststylerouteoperationList" itemLabel="label" itemValue="value"/>
    <!-- todo: change this to read the identifier field from the other pojo -->
    <form:select cssClass="form-control" path="mststylerouteoperation" items="mststylerouteoperationList" itemLabel="label" itemValue="value"/>
    <!-- todo: change this to read the identifier field from the other pojo -->
    <form:select cssClass="form-control" path="mststylerouteoperation" items="mststylerouteoperationList" itemLabel="label" itemValue="value"/>
    <!-- todo: change this to read the identifier field from the other pojo -->
    <form:select cssClass="form-control" path="mststylerouteoperation" items="mststylerouteoperationList" itemLabel="label" itemValue="value"/>
     --%><spring:bind path="mststyleoperation.operation">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mststyleoperation.operation" styleClass="control-label"/>
        <form:input cssClass="form-control" path="operation" id="operation"  maxlength="45"/>
        <form:errors path="operation" cssClass="help-block"/>
    </div>
    <spring:bind path="mststyleoperation.operationDesc">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mststyleoperation.operationDesc" styleClass="control-label"/>
        <form:input cssClass="form-control" path="operationDesc" id="operationDesc"  maxlength="50"/>
        <form:errors path="operationDesc" cssClass="help-block"/>
    </div>
    <spring:bind path="mststyleoperation.operationDescBref">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mststyleoperation.operationDescBref" styleClass="control-label"/>
        <form:input cssClass="form-control" path="operationDescBref" id="operationDescBref"  maxlength="20"/>
        <form:errors path="operationDescBref" cssClass="help-block"/>
    </div>
    <spring:bind path="mststyleoperation.operationType">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mststyleoperation.operationType" styleClass="control-label"/>
        <form:input cssClass="form-control" path="operationType" id="operationType"  maxlength="10"/>
        <form:errors path="operationType" cssClass="help-block"/>
    </div>
    <spring:bind path="mststyleoperation.printBundleTicket">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mststyleoperation.printBundleTicket" styleClass="control-label"/>
        <form:checkbox path="printBundleTicket" id="printBundleTicket" cssClass="checkbox"/>
        <form:errors path="printBundleTicket" cssClass="help-block"/>
    </div>
    <spring:bind path="mststyleoperation.process">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mststyleoperation.process" styleClass="control-label"/>
        <form:input cssClass="form-control" path="process" id="process"  maxlength="45"/>
        <form:errors path="process" cssClass="help-block"/>
    </div>
    <spring:bind path="mststyleoperation.revision1">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mststyleoperation.revision1" styleClass="control-label"/>
        <form:input cssClass="form-control" path="revision1" id="revision1"  maxlength="255"/>
        <form:errors path="revision1" cssClass="help-block"/>
    </div>
    <spring:bind path="mststyleoperation.revision2">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mststyleoperation.revision2" styleClass="control-label"/>
        <form:input cssClass="form-control" path="revision2" id="revision2"  maxlength="255"/>
        <form:errors path="revision2" cssClass="help-block"/>
    </div>
    <spring:bind path="mststyleoperation.revision3">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mststyleoperation.revision3" styleClass="control-label"/>
        <form:input cssClass="form-control" path="revision3" id="revision3"  maxlength="255"/>
        <form:errors path="revision3" cssClass="help-block"/>
    </div>
    <spring:bind path="mststyleoperation.revision4">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mststyleoperation.revision4" styleClass="control-label"/>
        <form:input cssClass="form-control" path="revision4" id="revision4"  maxlength="255"/>
        <form:errors path="revision4" cssClass="help-block"/>
    </div>
    <spring:bind path="mststyleoperation.revision5">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mststyleoperation.revision5" styleClass="control-label"/>
        <form:input cssClass="form-control" path="revision5" id="revision5"  maxlength="255"/>
        <form:errors path="revision5" cssClass="help-block"/>
    </div>
    <spring:bind path="mststyleoperation.sequenceNo">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mststyleoperation.sequenceNo" styleClass="control-label"/>
        <form:input cssClass="form-control" path="sequenceNo" id="sequenceNo"  maxlength="255"/>
        <form:errors path="sequenceNo" cssClass="help-block"/>
    </div>
    <spring:bind path="mststyleoperation.sewingOperation">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mststyleoperation.sewingOperation" styleClass="control-label"/>
        <form:input cssClass="form-control" path="sewingOperation" id="sewingOperation"  maxlength="1"/>
        <form:errors path="sewingOperation" cssClass="help-block"/>
    </div>
    <spring:bind path="mststyleoperation.sizeWiseSmvMatrix">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mststyleoperation.sizeWiseSmvMatrix" styleClass="control-label"/>
        <form:input cssClass="form-control" path="sizeWiseSmvMatrix" id="sizeWiseSmvMatrix"  maxlength="255"/>
        <form:errors path="sizeWiseSmvMatrix" cssClass="help-block"/>
    </div>
    <spring:bind path="mststyleoperation.wipPoints">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mststyleoperation.wipPoints" styleClass="control-label"/>
        <form:input cssClass="form-control" path="wipPoints" id="wipPoints"  maxlength="45"/>
        <form:errors path="wipPoints" cssClass="help-block"/>
    </div>
    <spring:bind path="mststyleoperation.workAid">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mststyleoperation.workAid" styleClass="control-label"/>
        <form:input cssClass="form-control" path="workAid" id="workAid"  maxlength="45"/>
        <form:errors path="workAid" cssClass="help-block"/>
    </div>

    <div class="form-group">
        <button type="submit" class="btn btn-primary" name="save" onclick="bCancel=false">
            <i class="icon-ok icon-white"></i> <fmt:message key="button.save"/>
        </button>
        <c:if test="${not empty mststyleoperation.id}">
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

<v:javascript formName="mststyleoperation" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<c:url value='/scripts/validator.jsp'/>"></script>

<script type="text/javascript">
    $(document).ready(function() {
        $("input[type='text']:visible:enabled:first", document.forms['mststyleoperationForm']).focus();
    });
</script>
