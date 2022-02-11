/*
public class MenuDTO {
	private String food_id;
	private String food_name;
	private String sort;
	private String food_size;
	private int price;
*/
package kpizza.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kpizza.model.dto.ClientDTO;
import kpizza.model.dto.MenuDTO;
import kpizza.model.util.DBUtil;

public class MenuDAO {

	// sql - select * from activist
	public static ArrayList<MenuDTO> getAllMenus() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<MenuDTO> list = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from menu");
			rset = pstmt.executeQuery();

			list = new ArrayList<MenuDTO>();
			while (rset.next()) {
				list.add(new MenuDTO(rset.getString(1), rset.getString(2), rset.getString(3), rset.getInt(4)));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
	
	//select * from client where client_id=?
	public static MenuDTO getMenu(String foodId) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		MenuDTO menu = null;
		
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from client where food_id=?");
			pstmt.setString(1, foodId);
			rset = pstmt.executeQuery();
			if(rset.next()){
				menu = new MenuDTO(rset.getString(1), rset.getString(2), rset.getString(3), rset.getInt(4));
			}
		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return menu;
	}
	
	public static boolean addMenu(MenuDTO menu) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("insert into menu values(?, ?, ?, ?)");
			pstmt.setString(1, menu.getFood_id());
			pstmt.setString(2, menu.getFood_name());
			pstmt.setString(3, menu.getSort());
			pstmt.setInt(5, menu.getPrice());
			
			int result = pstmt.executeUpdate();
		
			if(result == 1){
				return true;
			}
		}finally{
			DBUtil.close(con, pstmt);
		}
		return false;
	}
	
	
}
