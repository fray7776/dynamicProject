<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SHOW CONTENT </title>
<script type="text/javascript">
function deleteAlert(){
	 var yn = confirm('Do you really want to delete?');
	 	if(yn) {
	 		frm.action="/20210129/boardDelete.do?bId="+${vo.bId };
	 		frm.submit();
	 	}else{
	 		
	 	}
}

function updateAlert(){
	 var yn = confirm('Do you really want to update?');
	 	if(yn) {
	 		frm.action="boardUpdate.do";
	 		frm.submit();
	 	}else{
	 		
	 	}
	 	
</script>
</head>
<body>
<div align="center">
	
	<div>
	<form id="frm" name="frm" method="post">
	<input type="hidden" name="bId" value="${vo.bId }">
	<input type="hidden" name="bContent" value="${vo.bContent }">	

	<table border="1">
	
			<tr>
				<th width="100">NAME</th>
				<td width="120">${vo.bName }</td>
				<th width="100">DATE</th>
				<td width="120">${vo.bDate }</td>
				<th width="100">HIT NO</th>
				<td width="100">${vo.bHit }</td>
			</tr>
			<tr>
				<th>TITLE</th>
				<td colspan="5">${vo.bTitle }</td>
			</tr>
			<tr>
				<th>CONTENT</th>
				<td colspan="5"><textarea name = "text1" rows="25" cols="90" >${vo.bContent }</textarea></td>
			</tr>	
		</table>
			</form>
		</div><br/>
		<div>
			<c:if test="${not empty list }" >
				<c:forEach var="rvo" items="${list }">
					<table border = "1">
						<tr>
							<td width="500">${rvo.subject}</td>
							<td width="100">${rvo.rdate }</td>
						</tr>
					</table>
				</c:forEach>
			</c:if> 
		</div>
	<div>
		<button type="button" onclick="location.href='BoardList.do'">GOBACK</button>&nbsp;&nbsp;&nbsp;
		<button type="button" onclick="deleteAlert()">DELETE</button>&nbsp;&nbsp;&nbsp;
	    <button type="button" onclick="updateAlert()">UPDATE</button>
	    
		
	</div>
</div>	
		
</body>
</html>