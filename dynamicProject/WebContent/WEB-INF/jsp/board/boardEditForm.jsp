<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SHOW CONTENT </title>

</head>
<body>
<div align="center"><h1>Modify Board</h1></div>
<div align="center">
	
	<div>
	<form id="frm" name="frm" action="writeNewBoard.do" method="post">
	<input type="hidden" name="bId" value="${vo.bId }" readonly="readonly">
	<input type="hidden" name="bContent" value="${vo.bContent }">	

	<table border="1">
	
			<tr>
				<th width="100">NAME</th>
				<td width="120">${vo.bName }</td>
				<th width="100">DATE</th>
				<td width="120" >${vo.bDate }</td>
				<th width="100">HIT NO</th>
				<td width="100">${vo.bHit }</td>
			</tr>
			<tr>
				<th>TITLE</th>
				<td colspan="5" >${vo.bTitle }</td>
			</tr>
			<tr>
				<th>CONTENT</th>
				<td colspan="5"><textarea name = "text1" rows="25" cols="90" >${vo.bContent }</textarea></td>
			</tr>	
		</table>
			</form>
		</div><br/>
		
	<div>
		<button type="submit" >UPDATE</button>&nbsp;&nbsp;&nbsp;
		<button type="reset">CANCLE</button>&nbsp;&nbsp;&nbsp;
		<button type="button" onclick="location.href='BoardList.do'">GOBACK</button>
	</div>
</div>	
		
</body>
</html>