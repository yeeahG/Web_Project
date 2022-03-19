package kpizza.model;

import java.sql.SQLException;
import java.util.ArrayList;

import kpizza.exception.MessageException;
import kpizza.exception.NotExistException;
import kpizza.model.dto.ClientDTO;
import kpizza.model.dto.MenuDTO;



public class KPizzaService {
	public static void notExistClient(String clientId) throws NotExistException, SQLException{
		ClientDTO probono = ClientDAO.getClient(clientId);
		if(probono == null){
			throw new NotExistException("검색하신 고객 정보가 없습니다.");
		}
	}

	//모든 Client Project 검색 
		public static ArrayList<ClientDTO> getAllClient() throws SQLException,NotExistException{
			ArrayList<ClientDTO> clientAll = ClientDAO.getAllClients();
		
			if(clientAll == null){
				throw new NotExistException("검색하는 재능기부 프로젝트가 미 존재합니다.");
			}
			
			return clientAll;
		}
		
		public static boolean addClient(ClientDTO client) throws MessageException{
			boolean result = false;
			try {
				result=ClientDAO.addClientDTO(client);
			}catch(SQLException s) {
				throw new MessageException("이미 존재하는 ID입니다. 다시 시도 하세요");
			}
			return result;
		}

		public static ArrayList<MenuDTO> getAllMenu() throws SQLException,NotExistException{
			ArrayList<MenuDTO> menuAll = MenuDAO.getAllMenus();
		
			if(menuAll == null){
				throw new NotExistException("검색하신 메뉴가 없습니다.");
			}
			
			return menuAll;
		}

		public static MenuDTO getMenu(String foodId) throws NotExistException, SQLException {
			MenuDTO menu = MenuDAO.getMenu(foodId);
			if(foodId == null) {
				throw new NotExistException("해당 음식이 없습니다.");
			}
			return menu;
		}
}







