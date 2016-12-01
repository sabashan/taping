<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="mststylerouteoperationDetail.title"/></title>
    <meta name="heading" content="<fmt:message key='mststylerouteoperationDetail.heading'/>"/>
</head>

<c:set var="delObject" scope="request"><fmt:message key="mststylerouteoperationList.mststylerouteoperation"/></c:set>
<script type="text/javascript">var msgDelConfirm =
   "<fmt:message key="delete.confirm"><fmt:param value="${delObject}"/></fmt:message>";
</script>

<div class="col-sm-2">
    <h2><fmt:message key="mststylerouteoperationDetail.heading"/></h2>
    <fmt:message key="mststylerouteoperationDetail.message"/>
</div>

<div class="col-sm-7">
<form:errors path="*" cssClass="alert alert-danger alert-dismissable" element="div"/>
<form:form commandName="mststylerouteoperation" method="post" action="mststylerouteoperationform" cssClass="well"
           id="mststylerouteoperationForm" onsubmit="return validateMststylerouteoperation(this)">
<ul>
    <spring:bind path="mststylerouteoperation.id">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mststylerouteoperation.id" styleClass="control-label"/>
        <form:input path="id" id="id"/>
        <form:errors path="id" cssClass="help-block"/>
    </div>
    <spring:bind path="mststylerouteoperation.createAt">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mststylerouteoperation.createAt" styleClass="control-label"/>
        <form:input cssClass="form-control" path="createAt" id="createAt"  maxlength="255"/>
        <form:errors path="createAt" cssClass="help-block"/>
    </div>
    <spring:bind path="mststylerouteoperation.createBy">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mststylerouteoperation.createBy" styleClass="control-label"/>
        <form:input cssClass="form-control" path="createBy" id="createBy"  maxlength="10"/>
        <form:errors path="createBy" cssClass="help-block"/>
    </div>
    <spring:bind path="mststylerouteoperation.createdOn">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mststylerouteoperation.createdOn" styleClass="control-label"/>
        <form:input cssClass="form-control" path="createdOn" id="createdOn"  maxlength="255"/>
        <form:errors path="createdOn" cssClass="help-block"/>
    </div>
    <spring:bind path="mststylerouteoperation.modifiedAt">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mststylerouteoperation.modifiedAt" styleClass="control-label"/>
        <form:input cssClass="form-control" path="modifiedAt" id="modifiedAt"  maxlength="255"/>
        <form:errors path="modifiedAt" cssClass="help-block"/>
    </div>
    <spring:bind path="mststylerouteoperation.modifiedBy">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mststylerouteoperation.modifiedBy" styleClass="control-label"/>
        <form:input cssClass="form-control" path="modifiedBy" id="modifiedBy"  maxlength="255"/>
        <form:errors path="modifiedBy" cssClass="help-block"/>
    </div>
    <spring:bind path="mststylerouteoperation.modifiedOn">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mststylerouteoperation.modifiedOn" styleClass="control-label"/>
        <form:input cssClass="form-control" path="modifiedOn" id="modifiedOn"  maxlength="255"/>
        <form:errors path="modifiedOn" cssClass="help-block"/>
    </div>
    <spring:bind path="mststylerouteoperation.approvedBy">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mststylerouteoperation.approvedBy" styleClass="control-label"/>
        <form:input cssClass="form-control" path="approvedBy" id="approvedBy"  maxlength="50"/>
        <form:errors path="approvedBy" cssClass="help-block"/>
    </div>
    <spring:bind path="mststylerouteoperation.approvedOn">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mststylerouteoperation.approvedOn" styleClass="control-label"/>
        <form:input cssClass="form-control" path="approvedOn" id="approvedOn"  maxlength="19"/>
        <form:errors path="approvedOn" cssClass="help-block"/>
    </div>
    <spring:bind path="mststylerouteoperation.assignLocation">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mststylerouteoperation.assignLocation" styleClass="control-label"/>
        <form:input cssClass="form-control" path="assignLocation" id="assignLocation"  maxlength="6"/>
        <form:errors path="assignLocation" cssClass="help-block"/>
    </div>
    <spring:bind path="mststylerouteoperation.buyerDept">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mststylerouteoperation.buyerDept" styleClass="control-label"/>
        <form:input cssClass="form-control" path="buyerDept" id="buyerDept"  maxlength="10"/>
        <form:errors path="buyerDept" cssClass="help-block"/>
    </div>
    <spring:bind path="mststylerouteoperation.cycleTime">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mststylerouteoperation.cycleTime" styleClass="control-label"/>
        <form:input cssClass="form-control" path="cycleTime" id="cycleTime"  maxlength="255"/>
        <form:errors path="cycleTime" cssClass="help-block"/>
    </div>
    <!-- todo: change this to read the identifier field from the other pojo -->
    <form:select cssClass="form-control" path="mststyleheader" items="mststyleheaderList" itemLabel="label" itemValue="value"/>
    <!-- todo: change this to read the identifier field from the other pojo -->
    <form:select cssClass="form-control" path="mststyleheader" items="mststyleheaderList" itemLabel="label" itemValue="value"/>
    <!-- todo: change this to read the identifier field from the other pojo -->
    <form:select cssClass="form-control" path="mststyleheader" items="mststyleheaderList" itemLabel="label" itemValue="value"/>
    <!-- todo: change this to read the identifier field from the other pojo -->
    <form:select cssClass="form-control" path="mststyleheader" items="mststyleheaderList" itemLabel="label" itemValue="value"/>
    <!-- todo: change this to read the identifier field from the other pojo -->
    <form:select cssClass="form-control" path="mststyleheader" items="mststyleheaderList" itemLabel="label" itemValue="value"/>
    <spring:bind path="mststylerouteoperation.noOfHealpers">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mststylerouteoperation.noOfHealpers" styleClass="control-label"/>
        <form:input cssClass="form-control" path="noOfHealpers" id="noOfHealpers"  maxlength="255"/>
        <form:errors path="noOfHealpers" cssClass="help-block"/>
    </div>
    <spring:bind path="mststylerouteoperation.noOfMachines">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mststylerouteoperation.noOfMachines" styleClass="control-label"/>
        <form:input cssClass="form-control" path="noOfMachines" id="noOfMachines"  maxlength="255"/>
        <form:errors path="noOfMachines" cssClass="help-block"/>
    </div>
    <spring:bind path="mststylerouteoperation.noOfPcs">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mststylerouteoperation.noOfPcs" styleClass="control-label"/>
        <form:input cssClass="form-control" path="noOfPcs" id="noOfPcs"  maxlength="255"/>
        <form:errors path="noOfPcs" cssClass="help-block"/>
    </div>
    <spring:bind path="mststylerouteoperation.noOfWokers">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mststylerouteoperation.noOfWokers" styleClass="control-label"/>
        <form:input cssClass="form-control" path="noOfWokers" id="noOfWokers"  maxlength="255"/>
        <form:errors path="noOfWokers" cssClass="help-block"/>
    </div>
    <spring:bind path="mststylerouteoperation.orderQty">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mststylerouteoperation.orderQty" styleClass="control-label"/>
        <form:input cssClass="form-control" path="orderQty" id="orderQty"  maxlength="255"/>
        <form:errors path="orderQty" cssClass="help-block"/>
    </div>
    <spring:bind path="mststylerouteoperation.remarks">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mststylerouteoperation.remarks" styleClass="control-label"/>
        <form:input cssClass="form-control" path="remarks" id="remarks"  maxlength="100"/>
        <form:errors path="remarks" cssClass="help-block"/>
    </div>
    <spring:bind path="mststylerouteoperation.styleRouteName">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mststylerouteoperation.styleRouteName" styleClass="control-label"/>
        <form:input cssClass="form-control" path="styleRouteName" id="styleRouteName"  maxlength="30"/>
        <form:errors path="styleRouteName" cssClass="help-block"/>
    </div>
    <spring:bind path="mststylerouteoperation.targetDate">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mststylerouteoperation.targetDate" styleClass="control-label"/>
        <form:input cssClass="form-control" path="targetDate" id="targetDate" size="11" title="date" datepicker="true"/>
        <form:errors path="targetDate" cssClass="help-block"/>
    </div>
    <spring:bind path="mststylerouteoperation.workMins">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mststylerouteoperation.workMins" styleClass="control-label"/>
        <form:input cssClass="form-control" path="workMins" id="workMins"  maxlength="255"/>
        <form:errors path="workMins" cssClass="help-block"/>
    </div>

    <div class="form-group">
        <button type="submit" class="btn btn-primary" name="save" onclick="bCancel=false">
            <i class="icon-ok icon-white"></i> <fmt:message key="button.save"/>
        </button>
        <c:if test="${not empty mststylerouteoperation.id}">
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

<v:javascript formName="mststylerouteoperation" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<c:url value='/scripts/validator.jsp'/>"></script>

<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/webjars/bootstrap-datepicker/1.2.0/css/datepicker.css'/>" />
<script type="text/javascript" src="<c:url value='/webjars/bootstrap-datepicker/1.2.0/js/bootstrap-datepicker.js'/>"></script>
<c:if test="${pageContext.request.locale.language != 'en'}">
<script type="text/javascript" src="<c:url value='/webjars/bootstrap-datepicker/1.2.0/js/locales/bootstrap-datepicker.${pageContext.request.locale.language}.js'/>"></script>
</c:if>
<script type="text/javascript">
    $(document).ready(function() {
        $("input[type='text']:visible:enabled:first", document.forms['mststylerouteoperationForm']).focus();
        $('.text-right.date').datepicker({format: "<fmt:message key='calendar.format'/>", weekStart: "<fmt:message key='calendar.weekstart'/>", language: '${pageContext.request.locale.language}'});
    });
</script>
