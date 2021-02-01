<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script>
function checkForm(){
	var form = document.frm;
	var memberId = form.memberId.value;
	var memberPassword = form.memberPassword.value;


	if (memberId != "" && memberPassword != "") {
		
			form.submit();

	} else {
		alert("빈 칸을 채워주세요.")
		if (memberId == "") {
			form.memberId.focus();
		} else if (memberPassword == "") {
			form.memberPassword.focus();
		}
	}
	
}

</script>

		<div style="padding: 10px;">
			<form id="frm" name="frm" action="login.do" method="post">
				<div>
					<table>
						<tr>
							<td>아 이 디</td>
							<td><input type="text" id="memberId" name="memberId" size="20"></td>
						</tr>
						<tr>
							<td>패스워드</td>
							<td><input type="text" id="memberPassword" name="memberPassword" size="20"></td>
						</tr>
					</table>
				</div>
				<button type="button" onclick=checkForm()>로그인</button>
			</form>
		</div>