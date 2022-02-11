<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
String url = application.getContextPath() + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Menu</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Amatic+SC">
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

</head>
<body>
	<!-- About Container -->
	<div class="w3-container w3-padding-64 w3-red w3-grayscale w3-xlarge"
		id="order">
		<div class="w3-content">
			<h1 class="w3-center w3-jumbo" style="margin-bottom: 64px">ORDER</h1>

			<p>
				<strong>K PIZZA 를 이용해주셔서 감사합니다 ${ requestScope.name }</strong><br> <img
					src="./images/chef.jpg" style="width: 150px"
					class="w3-circle w3-right" alt="Chef">
				
			</p>

			<br>
			<div class="w3-row w3-center w3-border w3-border-dark-grey">
				<div class="w3-col s4 tablink w3-padding-large w3-white">
					ORDER LIST</div>
				<br>

				<center>
					<hr>
					<p>
					<form action="controller?command=order" method="post">
						<input type="hidden" name="command" value="client_id">
						<table border="1">
							<tr>
								<td>주문자명</td>
								<td><input type="text" name="id"></td>
							</tr>
							<tr>
								<td>메뉴</td>
								<td><input type="text" name="id"></td>
							</tr>
							<tr>
								<td>수량</td>
								<td><input type="text" name="receiveContent"></td>
							</tr>
							<tr>
								<td>금액</td>
								<td><input type="text" name="receiveContent"></td>
							</tr>
							<tr>
								<td colspan="2"><input type="submit" value="주문">&nbsp;&nbsp;&nbsp;<input
									type="reset" value="취소"></td>
							</tr>
						</table>
					</form>
			</div>



			<p>
			<div class="w3-right w3-hide-small">
				<a href="javascript:void(0)"
					onclick="CheckboxToHidden(frm, frm.chk); frm.submit();"> <a
					href="KPizza.html" class="w3-button w3-xxlarge w3-black"> 위로 가기</a>
				</a>
			</div>
			</p>

			<script>
				// Tabbed Menu
				function openMenu(evt, menuName) {
					var i, x, tablinks;
					x = document.getElementsByClassName("menu");
					for (i = 0; i < x.length; i++) {
						x[i].style.display = "none";
					}
					tablinks = document.getElementsByClassName("tablink");
					for (i = 0; i < x.length; i++) {
						tablinks[i].className = tablinks[i].className.replace(
								" w3-red", "");
					}
					document.getElementById(menuName).style.display = "block";
					evt.currentTarget.firstElementChild.className += " w3-red";
				}
				document.getElementById("myLink").click();

				function CheckboxToHidden(f, ele) {
					var ele_h;
					var val;

					if (typeof (ele.length) != "undefined") {// checkbox가 배열일경우
						for (var i = 0; i < ele.length; i++) {
							// hidden객체생성, 이름은 checkbox와 같게한다.
							ele_h = document.createElement("input");
							ele_h.setAttribute("type", "hidden");
							ele_h.setAttribute("name", ele[i].name);
							ele[i].checked ? val = ele[i].value : val = "";
							ele_h.setAttribute("value", val);
							f.appendChild(ele_h);

							// 기존 checkbox의 이름을 이름_dummy로 변경한후 checked = false해준다.
							ele[i].checked = false;
							ele[i].setAttribute("name", ele[i].name + "_dummy");
						}
					} else {// checkbox가 한개
						ele_h = document.createElement("input");
						ele_h.setAttribute("type", "hidden");
						ele_h.setAttribute("name", ele.name);
						ele.checked ? val = ele.value : val = "";
						ele_h.setAttribute("value", val);
						f.appendChild(ele_h);

						ele.checked = false;
						ele.setAttribute("name", ele.name + "_dummy");
					}
				}
			</script>
</body>
</html>