<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="mstcustomerDetail.title"/></title>
    <meta name="heading" content="<fmt:message key='mstcustomerDetail.heading'/>"/>
</head>

<c:set var="delObject" scope="request"><fmt:message key="mstcustomerList.mstcustomer"/></c:set>
<script type="text/javascript">var msgDelConfirm =
   "<fmt:message key="delete.confirm"><fmt:param value="${delObject}"/></fmt:message>";
</script>

<div class="col-sm-12 col-md-12">
    <h1><fmt:message key="mstcustomerDetail.heading"/></h1>
</div>

<div class="row paddingleft20"> <!--View Page start-->
        <div class="col-sm-12 col-md-12">

          <h3 class="marginbottom5"><fmt:message key="mstcustomerDetail.message"/></h3>
          <hr>
        </div>
      </div>
<div class="col-sm-7">
<form:errors path="*" cssClass="alert alert-danger alert-dismissable" element="div"/>
<form:form commandName="mstcustomer" method="post" action="mstcustomerform" cssClass="well"
           id="mstcustomerForm" onsubmit="return validateMstcustomer(this)">
<ul>
<%--     <spring:bind path="mstcustomer.id"> --%>
<%--     <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}"> --%>
<%--     </spring:bind> --%>
<%--         <appfuse:label key="mstcustomer.id" styleClass="control-label"/> --%>
<%--         <form:input path="id" id="id"/> --%>
<%--         <form:errors path="id" cssClass="help-block"/> --%>
<!--     </div> -->
    <spring:bind path="mstcustomer.boiRegno">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mstcustomer.boiRegno" styleClass="control-label"/>
        <form:input cssClass="form-control" path="boiRegno" id="boiRegno"  maxlength="8"/>
        <form:errors path="boiRegno" cssClass="help-block"/>
    </div>
    <spring:bind path="mstcustomer.buyerEmail">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mstcustomer.buyerEmail" styleClass="control-label"/>
        <form:input cssClass="form-control" path="buyerEmail" id="buyerEmail"  maxlength="50"/>
        <form:errors path="buyerEmail" cssClass="help-block"/>
    </div>
    <spring:bind path="mstcustomer.chequeName">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mstcustomer.chequeName" styleClass="control-label"/>
        <form:input cssClass="form-control" path="chequeName" id="chequeName"  maxlength="100"/>
        <form:errors path="chequeName" cssClass="help-block"/>
    </div>
    <spring:bind path="mstcustomer.contactName">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mstcustomer.contactName" styleClass="control-label"/>
        <form:input cssClass="form-control" path="contactName" id="contactName"  maxlength="30"/>
        <form:errors path="contactName" cssClass="help-block"/>
    </div>
    <spring:bind path="mstcustomer.crTerm">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mstcustomer.crTerm" styleClass="control-label"/>
        <form:input cssClass="form-control" path="crTerm" id="crTerm"  maxlength="6"/>
        <form:errors path="crTerm" cssClass="help-block"/>
    </div>
    <spring:bind path="mstcustomer.createdAt">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mstcustomer.createdAt" styleClass="control-label"/>
        <form:input cssClass="form-control" path="createdAt" id="createdAt"  maxlength="10"/>
        <form:errors path="createdAt" cssClass="help-block"/>
    </div>
    <spring:bind path="mstcustomer.createdBy">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mstcustomer.createdBy" styleClass="control-label"/>
        <form:input cssClass="form-control" path="createdBy" id="createdBy"  maxlength="10"/>
        <form:errors path="createdBy" cssClass="help-block"/>
    </div>
    <spring:bind path="mstcustomer.createdOn">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mstcustomer.createdOn" styleClass="control-label"/>
        <form:input cssClass="form-control" path="createdOn" id="createdOn"  maxlength="19"/>
        <form:errors path="createdOn" cssClass="help-block"/>
    </div>
    <spring:bind path="mstcustomer.creditLimit">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mstcustomer.creditLimit" styleClass="control-label"/>
        <form:input cssClass="form-control" path="creditLimit" id="creditLimit"  maxlength="255"/>
        <form:errors path="creditLimit" cssClass="help-block"/>
    </div>
    <spring:bind path="mstcustomer.custAddress">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mstcustomer.custAddress" styleClass="control-label"/>
        <form:input cssClass="form-control" path="custAddress" id="custAddress"  maxlength="120"/>
        <form:errors path="custAddress" cssClass="help-block"/>
    </div>
    <spring:bind path="mstcustomer.custName">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mstcustomer.custName" styleClass="control-label"/>
        <form:input cssClass="form-control" path="custName" id="custName"  maxlength="40"/>
        <form:errors path="custName" cssClass="help-block"/>
    </div>
    <spring:bind path="mstcustomer.custReference">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mstcustomer.custReference" styleClass="control-label"/>
        <form:input cssClass="form-control" path="custReference" id="custReference"  maxlength="2"/>
        <form:errors path="custReference" cssClass="help-block"/>
    </div>
    <spring:bind path="mstcustomer.custType">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mstcustomer.custType" styleClass="control-label"/>
        <form:input cssClass="form-control" path="custType" id="custType"  maxlength="6"/>
        <form:errors path="custType" cssClass="help-block"/>
    </div>
    <spring:bind path="mstcustomer.dtFormat">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mstcustomer.dtFormat" styleClass="control-label"/>
        <form:input cssClass="form-control" path="dtFormat" id="dtFormat"  maxlength="11"/>
        <form:errors path="dtFormat" cssClass="help-block"/>
    </div>
    <spring:bind path="mstcustomer.emailAddress">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mstcustomer.emailAddress" styleClass="control-label"/>
        <form:input cssClass="form-control" path="emailAddress" id="emailAddress"  maxlength="40"/>
        <form:errors path="emailAddress" cssClass="help-block"/>
    </div>
    <spring:bind path="mstcustomer.extDiscPer">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mstcustomer.extDiscPer" styleClass="control-label"/>
        <form:input cssClass="form-control" path="extDiscPer" id="extDiscPer"  maxlength="255"/>
        <form:errors path="extDiscPer" cssClass="help-block"/>
    </div>
    <spring:bind path="mstcustomer.factoryDayvalue">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mstcustomer.factoryDayvalue" styleClass="control-label"/>
        <form:input cssClass="form-control" path="factoryDayvalue" id="factoryDayvalue"  maxlength="255"/>
        <form:errors path="factoryDayvalue" cssClass="help-block"/>
    </div>
    <spring:bind path="mstcustomer.faxNo">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mstcustomer.faxNo" styleClass="control-label"/>
        <form:input cssClass="form-control" path="faxNo" id="faxNo"  maxlength="14"/>
        <form:errors path="faxNo" cssClass="help-block"/>
    </div>
    <spring:bind path="mstcustomer.financeAmt">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mstcustomer.financeAmt" styleClass="control-label"/>
        <form:input cssClass="form-control" path="financeAmt" id="financeAmt"  maxlength="255"/>
        <form:errors path="financeAmt" cssClass="help-block"/>
    </div>
    <spring:bind path="mstcustomer.fobValue">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mstcustomer.fobValue" styleClass="control-label"/>
        <form:input cssClass="form-control" path="fobValue" id="fobValue"  maxlength="255"/>
        <form:errors path="fobValue" cssClass="help-block"/>
    </div>
    <spring:bind path="mstcustomer.glCtrlAcc">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mstcustomer.glCtrlAcc" styleClass="control-label"/>
        <form:input cssClass="form-control" path="glCtrlAcc" id="glCtrlAcc"  maxlength="10"/>
        <form:errors path="glCtrlAcc" cssClass="help-block"/>
    </div>
    <spring:bind path="mstcustomer.importFr">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mstcustomer.importFr" styleClass="control-label"/>
        <form:input cssClass="form-control" path="importFr" id="importFr"  maxlength="1"/>
        <form:errors path="importFr" cssClass="help-block"/>
    </div>
    <spring:bind path="mstcustomer.intDiscPer">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mstcustomer.intDiscPer" styleClass="control-label"/>
        <form:input cssClass="form-control" path="intDiscPer" id="intDiscPer"  maxlength="255"/>
        <form:errors path="intDiscPer" cssClass="help-block"/>
    </div>
    <spring:bind path="mstcustomer.invCustCode">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mstcustomer.invCustCode" styleClass="control-label"/>
        <form:input cssClass="form-control" path="invCustCode" id="invCustCode"  maxlength="10"/>
        <form:errors path="invCustCode" cssClass="help-block"/>
    </div>
    <spring:bind path="mstcustomer.markupPercentage">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mstcustomer.markupPercentage" styleClass="control-label"/>
        <form:input cssClass="form-control" path="markupPercentage" id="markupPercentage"  maxlength="255"/>
        <form:errors path="markupPercentage" cssClass="help-block"/>
    </div>
    <spring:bind path="mstcustomer.maxQtyallowPcn">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mstcustomer.maxQtyallowPcn" styleClass="control-label"/>
        <form:input cssClass="form-control" path="maxQtyallowPcn" id="maxQtyallowPcn"  maxlength="255"/>
        <form:errors path="maxQtyallowPcn" cssClass="help-block"/>
    </div>
    <spring:bind path="mstcustomer.minimumPack">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mstcustomer.minimumPack" styleClass="control-label"/>
        <form:input cssClass="form-control" path="minimumPack" id="minimumPack"  maxlength="255"/>
        <form:errors path="minimumPack" cssClass="help-block"/>
    </div>
    <spring:bind path="mstcustomer.modifiedAt">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mstcustomer.modifiedAt" styleClass="control-label"/>
        <form:input cssClass="form-control" path="modifiedAt" id="modifiedAt"  maxlength="10"/>
        <form:errors path="modifiedAt" cssClass="help-block"/>
    </div>
    <spring:bind path="mstcustomer.modifiedBy">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mstcustomer.modifiedBy" styleClass="control-label"/>
        <form:input cssClass="form-control" path="modifiedBy" id="modifiedBy"  maxlength="10"/>
        <form:errors path="modifiedBy" cssClass="help-block"/>
    </div>
    <spring:bind path="mstcustomer.modifiedOn">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mstcustomer.modifiedOn" styleClass="control-label"/>
        <form:input cssClass="form-control" path="modifiedOn" id="modifiedOn"  maxlength="19"/>
        <form:errors path="modifiedOn" cssClass="help-block"/>
    </div>
<!--     todo: change this to read the identifier field from the other pojo -->
<%--     <form:select cssClass="form-control" path="mstcompany" items="mstcompanyList" itemLabel="label" itemValue="value"/> --%>
<%--     <spring:bind path="mstcustomer.numberofDecimal"> --%>
<%--     <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}"> --%>
<%--     </spring:bind> --%>
<%--         <appfuse:label key="mstcustomer.numberofDecimal" styleClass="control-label"/> --%>
<%--         <form:checkbox path="numberofDecimal" id="numberofDecimal" cssClass="checkbox"/> --%>
<%--         <form:errors path="numberofDecimal" cssClass="help-block"/> --%>
<!--     </div> -->
    <spring:bind path="mstcustomer.ocdComm">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mstcustomer.ocdComm" styleClass="control-label"/>
        <form:input cssClass="form-control" path="ocdComm" id="ocdComm"  maxlength="255"/>
        <form:errors path="ocdComm" cssClass="help-block"/>
    </div>
    <spring:bind path="mstcustomer.othComm">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mstcustomer.othComm" styleClass="control-label"/>
        <form:input cssClass="form-control" path="othComm" id="othComm"  maxlength="255"/>
        <form:errors path="othComm" cssClass="help-block"/>
    </div>
    <spring:bind path="mstcustomer.ownerShip">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mstcustomer.ownerShip" styleClass="control-label"/>
        <form:input cssClass="form-control" path="ownerShip" id="ownerShip"  maxlength="10"/>
        <form:errors path="ownerShip" cssClass="help-block"/>
    </div>
    <spring:bind path="mstcustomer.salesGlCode">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mstcustomer.salesGlCode" styleClass="control-label"/>
        <form:input cssClass="form-control" path="salesGlCode" id="salesGlCode"  maxlength="10"/>
        <form:errors path="salesGlCode" cssClass="help-block"/>
    </div>
    <spring:bind path="mstcustomer.taxNo">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mstcustomer.taxNo" styleClass="control-label"/>
        <form:input cssClass="form-control" path="taxNo" id="taxNo"  maxlength="30"/>
        <form:errors path="taxNo" cssClass="help-block"/>
    </div>
    <spring:bind path="mstcustomer.telNo">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mstcustomer.telNo" styleClass="control-label"/>
        <form:input cssClass="form-control" path="telNo" id="telNo"  maxlength="14"/>
        <form:errors path="telNo" cssClass="help-block"/>
    </div>
    <spring:bind path="mstcustomer.tlxNo">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mstcustomer.tlxNo" styleClass="control-label"/>
        <form:input cssClass="form-control" path="tlxNo" id="tlxNo"  maxlength="14"/>
        <form:errors path="tlxNo" cssClass="help-block"/>
    </div>
    <spring:bind path="mstcustomer.tqbNo">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mstcustomer.tqbNo" styleClass="control-label"/>
        <form:input cssClass="form-control" path="tqbNo" id="tqbNo"  maxlength="30"/>
        <form:errors path="tqbNo" cssClass="help-block"/>
    </div>
    <spring:bind path="mstcustomer.trackingReference">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="mstcustomer.trackingReference" styleClass="control-label"/>
        <form:input cssClass="form-control" path="trackingReference" id="trackingReference"  maxlength="1"/>
        <form:errors path="trackingReference" cssClass="help-block"/>
    </div>

    <div class="form-group">
        <button type="submit" class="btn btn-primary" name="save" onclick="bCancel=true">
            <i class="icon-ok icon-white"></i> <fmt:message key="button.save"/>
        </button>
        <c:if test="${not empty mstcustomer.id}">
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


<v:javascript formName="mstcustomer" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<c:url value='/scripts/validator.jsp'/>"></script>

<script type="text/javascript">
//     $(document).ready(function() {
//         $("input[type='text']:visible:enabled:first", document.forms['mstcustomerForm']).focus();
//     });
</script>
