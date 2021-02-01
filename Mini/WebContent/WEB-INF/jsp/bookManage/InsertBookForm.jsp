<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
	<div><h1>도서 등록</h1></div>
		<table border="1" class="table">
			<tr >
				<th width="150">도서 코드</th>
				<th width="150">도서명</th>
				<th width="150">기본 수량</th>
				<th width="150">현재 수량</th>
			</tr>
			<c:forEach var="vo" items="${list }">
			<tr>
				<td width="150">${vo.bookCode}</td>
				<td width="150">${vo.bookName }</td>
				<c:if test="${vo.quantity eq null }">
	 				<td width="150"></td>
	 			</c:if>	
	 			<c:if test="${vo.quantity ne null }">
	 				<td width="150">${vo.quantity }</td>
	 			</c:if>
				<td width="150">${vo.bCount }</td>
			</tr>	
			
			</c:forEach>
		</table><br/>
		<div>
			<input type="submit" id="save" name="save">도서 등록&nbsp;&nbsp;
			<input type="reset" id="cancle" name="cancle">취소&nbsp;&nbsp;
		</div>
		

</div>
</body>
</html>