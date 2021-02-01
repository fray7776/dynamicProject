<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LIST OF RENTAL BOOKS</title>

<style>
	.button{
		color:white;
  		text-align: center;
  		font-size: 12px;
        margin: 0px;
        box-sizing: border-box;
        background-color: darkgrey;
	}
	.table{
		color:black;
		border: 1px solid #444444;
		border-collapse: collapse;
	}
	th{
		background-color: darkgrey;
	}
	td{
		text-align:center;
	}

</style>
<script>
function myfunction(){
	var viewPage=null;
	var checkBox = document.getElementById("myCheck");
	 if (checkBox.checked == true) viewPage="update.do";
}

</script>
<body>
<div align="center">
	<div><h1>대여 목록</h1></div>
		<table border="1" class="table">
			<tr >
				<th width="150">대여 일자</th>
				<th width="150">도서 코드</th>
				<th width="150">회원 아이디</th>
				<th width="150">반납 코드</th>
				<th width="150">도서 이름</th>
				<th width="150">반납 입자</th>
				<th width="150">도서 수정</th>
				<th width="150">도서 삭제</th>
				
			</tr>
			<c:forEach var="vo" items="${list }">
			<tr>
				<td width="150">${vo.rentalDate}</td>
				<td width="150">${vo.bookCode }</td>
				<td width="150">${vo.memberId }</td>
				
				<td width="150">${vo.rentalCode }</td>
				<td width="150">${vo.bookName }</td>
				<c:if test="${vo.returnDate eq null}">
					<td width="150">기록없음</td>
				</c:if>
				<c:if test="${vo.returnDate ne null}">
					<td width="150">${vo.returnDate }</td>
				</c:if>
				<td><input type="checkbox" name="update" id="update" value="수정" onclick="myfunction()" ></td>
				<td><input type="checkbox" value="삭제"></td>
			</tr>	
			</c:forEach>
		</table><br/>
		<div>
			<button type="button" id="add" name="add" onclick="location.href='insertbAdmin.do'">도서 등록</button>&nbsp;&nbsp;
		</div>
		

</div>
</body>
</html>