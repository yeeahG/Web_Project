<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<% 	
	String url = application.getContextPath() + "/";
	System.out.println(url);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html> 



<title>K PIZZA STORE</title>
<meta name="viewport" content="width=device-width, initial-scale=1" charset="UTF-8">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="shortcut icon" href="https://cdn-icons.flaticon.com/png/512/819/premium/819810.png?token=exp=1644675573~hmac=7db772047276497dde3a8e73d2ca954a">

<style>
	body, html {
		height: 100%
	}
	
	body, h1, h2, h3, h4, h5, h6 {
		font-family: "Amatic SC", sans-serif
	}
	
	.menu {
		display: none
	}
	
	 .bgimg {
		background-repeat: no-repeat;
		background-size: cover;
		background-image: url("./images/pizza.jpg");
		min-height: 90%;
	}
</style>



<body>

	
	<!-- Navbar (sit on top) -->
	<div class="w3-top w3-hide-small">
		<div class="w3-bar w3-xlarge w3-black w3-opacity w3-hover-opacity-off" id="myNavbar">
			<a href="KPizza.html" class="w3-bar-item w3-button">HOME</a> 
			<a href="controller?command=kpizzaMenuAll" class="w3-bar-item w3-button">MENU</a> 
			<a href="Order.jsp" class="w3-bar-item w3-button">ORDER</a>
			<div class="w3-right w3-hide-small">
				<a href="KpizzaLogin.html" class="w3-bar-item w3-button">LOG IN</a>
			</div>
		</div>
	</div>
	
	<center>
	${requestScope.successMsg}
	
	<!-- Menu Container -->
	<div class="w3-container w3-black w3-padding-64 w3-large" id="info">
		<div class="w3-content">

			<div class="w3-center w3-jumbo" style="margin-bottom: 100px"></div>
			
			<p>회원정보</p>
			<hr>
		 	
			<table border="1">
				<tr>
					<th>회원 id</th><th>회원이름</th><th>연락처</th><th>닉네임</th><th>주소</th>
				</tr>
			 	<tr>
			 		<td>${client.id}</td>
			 		<td>${client.name}</td>
			 		<td>${client.phone}</td>
			 		<td>${client.nickname}</td>
			 		<td>${client.address}</td>
			 	</tr>
			</table>
			
				
			</div>
		</div>
	
		<p class="w3-center">
		<button class="w3-button w3-section w3-red w3-ripple" type="submit" value="가입"><a href="${pageContext.request.contextPath}/KpizzaLogin.html"> 확인 </a></button>
		<button class="w3-button w3-section w3-red w3-ripple" type="submit" value="취소"><a href="KpizzaLogin.html">탈퇴하기</a></button>
		</p>
		
		
	
	</center>
</body>
</html>