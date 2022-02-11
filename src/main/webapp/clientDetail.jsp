<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<% 	
	String url = application.getContextPath() + "/";
	System.out.println(url);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>회원 상세 정보 화면</title>
</head>
<body>
<br><br><br>
<center>

${requestScope.successMsg}

<h3>회원 정보</h3>
<hr><p> 
 
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

<br><br><br>

<a>탈퇴하기</a>

&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/index.html">메인 화면 이동</a>

</center>
</body>
</html>