package kpizza.model;

import java.sql.SQLException;
import java.util.ArrayList;

import kpizza.exception.NotExistException;
import kpizza.model.dto.ClientDTO;
import kpizza.model.dto.MenuDTO;



public class KPizzaService {
	public static void notExistClient(String clientId) throws NotExistException, SQLException{
		ClientDTO probono = ClientDAO.getClient(clientId);
		if(probono == null){
			throw new NotExistException("검색하진 재능기부 정보가 없습니다.");
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

		public static ArrayList<MenuDTO> getAllMenu() throws SQLException,NotExistException{
			ArrayList<MenuDTO> menuAll = MenuDAO.getAllMenus();
		
			if(menuAll == null){
				throw new NotExistException("검색하는 재능기부 프로젝트가 미 존재합니다.");
			}
			
			return menuAll;
		}

		public static MenuDTO getMenu(String foodId) throws NotExistException, SQLException {
			MenuDTO menu = MenuDAO.getMenu(foodId);
			if(foodId == null) {
				throw new NotExistException("검색하는 재능 기부자가 미 존재합니다.");
			}
			return menu;
		}
}
