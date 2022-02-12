package kpizza.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kpizza.model.LoginService;


@WebServlet("/login")
public class LoginValidate extends HttpServlet {

	 public LoginValidate() {
	    	System.out.println("---- LoginValidate 생성자 ----");
	    }
	   

		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("LoginValidate doPost()");
			try {
				process(request, response);
			} catch (ServletException | IOException | SQLException e) {
				e.printStackTrace();
			}
		}

		protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
			String id = request.getParameter("id"); 
			String pw = request.getParameter("pw");
			
			if(id != null && LoginService.checkDB(id, pw) ) {
		
//				response.setContentType("text/html;charset=utf-8");
//				PrintWriter out = response.getWriter();

				//이미 데이터값까지 보유한 세션객체 획득해서 활용
				HttpSession session = request.getSession();
				session.setAttribute("id", id);
				response.sendRedirect("KPizza.html");
			}else {
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				out.println("\"<script>alert('아이디와 비밀번호를 확인해주세요'); history.go(-1);</script>");
				out.close();
				
			}
			
			
		}

}