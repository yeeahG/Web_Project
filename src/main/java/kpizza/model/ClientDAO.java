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
	
	//id로 client 정보 가져오기
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
	
	
	public static boolean addClientDTO(ClientDTO client) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("insert into client values(?, ?, ?, ?, ?, ?, ?)");
			pstmt.setInt(1, client.getSort_no());
			pstmt.setString(2, client.getClient_id());
			pstmt.setString(3, client.getPassword());
			pstmt.setString(4, client.getName());
			pstmt.setString(5, client.getNickname());
			pstmt.setString(6, client.getContact());
			pstmt.setString(7, client.getAddress());
			
			int result = pstmt.executeUpdate();
		
			if(result == 1) {
				return true;
			}
		}finally{
			DBUtil.close(con, pstmt);
		}
		return false;
	}
	
	
	public static boolean checkDB (String id, String pw) throws SQLException {
		/*
		 ArrayList <ClientDTO> clientAll = ClientDAO.getAllClients();
		 
		 if (clientAll==null) {
		 throw new NotExistException("검색하는 미 존재합니다"); 
		 
		 return clientAll;
		 } 참고
		 */
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ClientDTO client = null;
		
		try {
			con=DBUtil.getConnection();
			pstmt=con.prepareStatement("select client_id, password from client where client_id=?");
			pstmt.setString(1, id);
			rset=pstmt.executeQuery();
			
			if (rset.next()) {
				if (pw.equals(rset.getString(2)))
					return true;
				}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return false;
	}
	

}
