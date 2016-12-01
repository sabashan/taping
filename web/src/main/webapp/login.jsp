<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta charset="utf-8">
    <title><fmt:message key="login.title"/></title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="This is the login page ">
    <meta name="author" content="">
    <meta name="menu" content="Login"/>

    <!-- Le styles -->
    <link href="styles/bootstrap.min.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Lato' rel='stylesheet' type='text/css'>
   <link href='http://fonts.googleapis.com/css?family=Roboto+Slab' rel='stylesheet' type='text/css'>
    <link href="styles/login.css" rel='stylesheet' type='text/css'>
	
     
    </style>
    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="../assets/js/html5shiv.js"></script>
    <![endif]-->
  </head>

  <body id="login">

    <div class="container">
	<div class="form" style="max-height:470px">
      <form method="post" id="loginForm" action="<c:url value='/j_security_check'/>"
    onsubmit="return validateForm(this)" class="form-signin" autocomplete="off">
      
        <img class="form-signin-heading logo" src="images/lpogo.png" style="margin: 0 110px 50px 100px;"/> 
        <input type="text" name="j_username" id="j_username"  class="form-control" placeholder="<fmt:message key="label.username"/>" required>
        <input type="password" name="j_password" id="j_password" class="form-control" placeholder="<fmt:message key="label.password"/>" required>
      
      <c:if test="${appConfig['rememberMeEnabled']}">
      
        <label for="rememberMe" class="checkbox">
        <input type="checkbox" name="_spring_security_remember_me" id="rememberMe" tabindex="3"/>
        <fmt:message key="login.rememberMe"/></label>
      </c:if>
    
    <c:if test="${param.error != null}">    
  <div class="bs-docs-example " style="max-width: 359px;    margin: 0 auto;">
            <div class="alert alert-error">
              <strong> <fmt:message key="errors.password.mismatch"/></strong>
            </div>
          </div>
   </c:if>
    
        <button class="btn btn-large btn-primary" name="login" type="submit" style="border-radius: 0px;"> <fmt:message key='button.login'/></button>
       <div class="lisance"> <p>&copy; ExcelSoft (Pvt) Ltd. All rights reserved. </p></div>
      </form>
       
</div>
 
  
    </div> <!-- /container -->

    <!-- Le javascript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="scripts/jquery-1.11.0.min.js"></script>
     <script src="scripts/bootstrap.min.js"></script>
   
  <script>
  
  $(".alert").alert('close')</script>

  

</body></html>