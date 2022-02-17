package kpizza.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/success")
public class LoginController extends HttpServlet {

	//post요청 방식만 처리하는 메소드
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LoginValidate doPost()");
		//...
		process(request, response);
	}
	
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request로 부터 getParameter("id") 값을 server 콘솔에 출력
		System.out.println(request.getParameter("id"));
		//setAttribute로 저장한 데이터 server 콘솔에 출력
		System.out.println(request.getAttribute("name"));
		
		response.sendRedirect("ClientIndex.html");
	}
	
}
