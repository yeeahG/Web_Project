/*
		sort_no           
       client_id          
       password         
       name               	
       nickname           
       contact           
       address
 */

package kpizza.model;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kpizza.model.dto.ClientDTO;
import kpizza.model.util.DBUtil;

public class ClientDAO {
	// sql - select * from activist
	public static ArrayList<ClientDTO> getAllClients() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<ClientDTO> list = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from client");
			rset = pstmt.executeQuery();

			list = new ArrayList<ClientDTO>();
			while (rset.next()) {
				list.add(new ClientDTO(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getString(5), rset.getString(6), rset.getString(7)));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
	
	//id濡?client ?뺣낫媛?몄삤湲?
	public static ClientDTO getClient(String clientId) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ClientDTO client = null;
		
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from client where client_id=?");
			pstmt.setString(1, clientId);
			rset = pstmt.executeQuery();
			if(rset.next()){
				client = new ClientDTO(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getString(5), rset.getString(6), rset.getString(7));
			}
		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return client;
	}
	
	public static boolean addClient(ClientDTO client) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("insert into client values(?, ?, ?, ?, ?, ?, ?)");
			pstmt.setInt(1, client.getSort_no());
			pstmt.setString(2, client.getClient_id());
			pstmt.setString(3, client.getPassword());
			pstmt.setString(4, client.getName());
			
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
