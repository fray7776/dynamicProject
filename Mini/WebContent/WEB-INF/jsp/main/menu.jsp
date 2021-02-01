<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Inconsolata">
<link rel="stylesheet" href="/Mini/css/css.css" type="text/css">
<title>Insert title here</title>
</head>
<body>



	<div class="w3-top">
		<div>
			<img src="/Mini/img/lib.jpg"
				style="width: 100%; height: 200px; object-fit: cover;">
		</div>
		<div class="w3-row w3-padding w3-black">
			<div class="w3-col s3">
				<a href="#" class="w3-button w3-block w3-black">HOME</a>
			</div>
			<c:if test="${MemberVo.memberAuth eq 'admin'}">
				<div class="w3-col s3">
					<a href="#about" class="w3-button w3-block w3-black">도서 조회</a>
				</div>
				<div class="w3-col s3">
					<a href="managebook.do" class="w3-button w3-block w3-black">도서 관리</a>
				</div>
				<div class="w3-col s3">
					<a href="#where" class="w3-button w3-block w3-black">회원 관리</a>
				</div>
				<div class="w3-col s3">
					<a href="logout.do" class="w3-button w3-block w3-black">로그아웃</a>
				</div>
			</c:if>
			<c:if test="${MemberVo.memberAuth eq 'user'}">
				<div class="w3-col s3">
					<a href="#about" class="w3-button w3-block w3-black">도서 조회</a>
				</div>
				<div class="w3-col s3">
					<a href="#" class="w3-button w3-block w3-black">대출 관리</a>
				</div>

				<div class="w3-col s3">
					<a href="logout.do" class="w3-button w3-block w3-black">로그아웃</a>
				</div>
			</c:if>

		</div>
	</div>