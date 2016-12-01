<%@ include file="/common/taglibs.jsp" %>
	<div id="me">
    <c:forEach items="${mercostsheetrowmaterialslists}" var="mercostsheetrowmaterialslist">	
			 <c:forEach items="${mercostsheetrowmaterialslist}" var="mercostsheetrowmaterials">	
					
					${mercostsheetrowmaterials}
					<br>
				
			</c:forEach><br><br>
	</c:forEach>
	</div>
