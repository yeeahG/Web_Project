package kpizza.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kpizza.model.KPizzaService;
import kpizza.model.dto.ClientDTO;

@WebServlet("/controller")
public class KPizzaController extends HttpServlet {

	public KPizzaController() {
		super();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	protected void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		// command pattern
		String command = request.getParameter("command");
	
	try{
		
		if(command.equals("kpizzaClientAll")){//모든 probono project 정보 검색
			kpizzaClientAll(request, response);
		} else if(command.equals("clientInsert")){//회원 등록
			clientInsert(request, response);
		}else if(command.equals("kpizzaMenuAll")){
			kpizzaMenuAll(request, response);
		} else if(command.equals("kpizzaMenu")) {
			kpizzaMenu(request, response);
		} else if(command.equals("kpizzaOrder")) {
//			kpizzaOrder(request,response);
		}
		
		
		
		
		
		
		
		
	}catch(Exception s){
		request.setAttribute("errorMsg", s.getMessage());
		request.getRequestDispatcher("showError.jsp").forward(request, response);
		s.printStackTrace();
	}
	}

	

//	private void kpizzaOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String url = "showError.jsp";
//		try {
//			request.setAttribute("order", KPizzaService.getOrder(request.getParameter("foodId")));
//			url = "Menu.jsp";
//		}catch(Exception s){
//			request.setAttribute("errorMsg", s.getMessage());
//			s.printStackTrace();
//		}
//		request.getRequestDispatcher(url).forward(request, response);
//		
//	}
	
	protected void clientInsert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String nickname = request.getParameter("nickname");
		String address = request.getParameter("address");
		
		
		//해킹등으로 불합리하게 요청도 될수 있다는 가정하에 모든 데이터가 제대로 전송이 되었는지를 검증하는 로직
		//if(id != null && id.length() !=0 && name != null) {
			
		
		ClientDTO client = new ClientDTO(1, id, pw, name, phone, nickname, address);
		try{
			boolean result = KPizzaService.addClient(client);
			if(result){
				request.setAttribute("client", client);
				request.setAttribute("successMsg", "가입 완료");
				url = "clientDetail.jsp";
			}else{
				request.setAttribute("errorMsg", "다시 시도하세요");
			}
		}catch(Exception s){
			request.setAttribute("errorMsg", s.getMessage());
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	private void kpizzaMenu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			request.setAttribute("menu", KPizzaService.getMenu(request.getParameter("foodId")));
			url = "Menu.jsp";
		}catch(Exception s){
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);

	}

	private void kpizzaClientAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			request.setAttribute("kpizzaClientAll",KPizzaService.getAllClient());
			url = "probonoProjectList.jsp";
		}catch(Exception s){
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
		
	}
	private void kpizzaMenuAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			request.setAttribute("kpizzaMenuAll",KPizzaService.getAllMenu());
			url = "Menu.jsp";
		}catch(Exception s){
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
		
	}
}