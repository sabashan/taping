<%@ include file="/common/taglibs.jsp"%>

<head>
<title><fmt:message key="display.title" /></title>
<meta name="menu" content="AdminMenu" />
</head>

<div class="col-sm-12 col-md-12">
	<h1>
		<fmt:message key="display.heading" />
	</h1>
</div>

<div class="row paddingleft20">
	<!--View Page start-->
	<div class="col-sm-12 col-md-12">
		<h3 class="marginbottom5">
			File upload summary
		</h3>
		<hr>
	</div>
</div>
<div class="col-sm-10">

	<table class="table-striped" cellpadding="5">
		<tr height="30px">
			<th width="30%">Friendly Name:</th>
			<td><c:out value="${friendlyName}" /></td>
		</tr>
		<tr height="30px">
			<th>Filename:</th>
			<td><c:out value="${fileName}" /></td>
		</tr>
		<tr height="30px">
			<th>File content type:</th>
			<td><c:out value="${contentType}" /></td>
		</tr>
		<tr height="30px">
			<th>File size:</th>
			<td><c:out value="${size}" /></td>
		</tr>
		<tr height="30px">
			<th class="tallCell">File Location:</th>
			<td>The file has been written to: <br /> <a
				href="<c:out value="${link}"/>"><c:out value="${location}"
						escapeXml="false" /></a>
			</td>
		</tr>
	</table>
	<div id="actions" class="form-group">
		<a class="btn btn-primary" href="home"> <i
			class="icon-ok icon-white"></i> <fmt:message key="button.done" />
		</a> <a class="btn btn-default" href="fileupload"> <i
			class="icon-upload"></i> Upload Another
		</a>
	</div>
</div>


