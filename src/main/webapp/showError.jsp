<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
    
<% String url = application.getContextPath() + "/"; %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<title>K PIZZA STORE</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="shortcut icon" href="https://cdn-icons.flaticon.com/png/512/819/premium/819810.png?token=exp=1644675573~hmac=7db772047276497dde3a8e73d2ca954a">

<!-- <head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>K PIZZA STORE</title>
</head> -->

<body>

	<center>

		<h3>${requestScope.errorMsg}</h3>
			
		<br><br><br>
		<p class="w3-center">
		정보를 다 입력해주세요!<br>
			<button class="w3-button w3-section w3-red w3-ripple">
			<a href="${pageContext.request.contextPath}/KPizza.html">로그인 화면으로 이동하기</a></button><br>
			<button class="w3-button w3-section w3-red w3-ripple">
			<a href="KPizza.html">홈으로 이동하기</a></button>
		
	</center>
	
</body>
</html>