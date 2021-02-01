<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script></script>

<jsp:include page="menu.jsp" />

<div class="w3-content" style="max-width:2000px;margin-top:296px;">

<c:if test="${MemberVo.memberAuth eq null}">
<jsp:include page="login.jsp" />
			</c:if>
			
<c:if test="${MemberVo.memberAuth ne null}">
<h1>환영합니다</h1>
			
			
</c:if>

<h1>메인</h1>

</div>
</body>
</html>