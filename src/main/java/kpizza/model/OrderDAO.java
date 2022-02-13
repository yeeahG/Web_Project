package kpizza.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kpizza.model.dto.OrderDTO;
import kpizza.model.util.DBUtil;

public class OrderDAO {
	
	//sql에서 select*from order
	public static ArrayList<OrderDTO> getAllorders() throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		ArrayList<OrderDTO> list=null;
		
		try {
			con=DBUtil.getConnection();
			pstmt=con.prepareStatement("select * from order");
			rset=pstmt.executeQuery();
			
			list=new ArrayList<OrderDTO>();
			while (rset.next()) {
				list.add(new OrderDTO(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getInt(5), rset.getString(6), rset.getInt(7), rset.getInt(8),rset.getString(9)));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);;
		}
		return list;
	}
	
	
	//id로 order정보 가져오기
	public static OrderDTO getOrder(String orderId) throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		OrderDTO order=null;
		
		try {
			con=DBUtil.getConnection();
			pstmt=con.prepareStatement("select * from order where order_list_id=?");
			pstmt.setString(1, orderId);
			rset=pstmt.executeQuery();
			
			if(rset.next()) {
				order=new OrderDTO(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getInt(5), rset.getString(6), rset.getInt(7), rset.getInt(8),rset.getString(9));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return order;
	}
	
	//order 추가
	public static boolean addOrder(OrderDTO order) throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			con=DBUtil.getConnection();
			pstmt=con.prepareStatement("insert into order values(?, ?, ?, ?, ?, ?, ?, ?, ?)");
			
			pstmt.setInt(1, order.getOrder_list_id());
			pstmt.setString(2, order.getOrder_list_name());
			pstmt.setString(3, order.getClient_id());
			pstmt.setString(4, order.getFood_id());
			pstmt.setInt(5, order.getFood_quantity());
			pstmt.setString(6, order.getFood_id2());
			pstmt.setInt(7, order.getFood2_quantity());
			pstmt.setInt(7, order.getTotal_price());
			pstmt.setString(6, order.getMessage());
			
			int result = pstmt.executeUpdate();
			
			if(result==1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}
	
	
	//order 삭제
	//sql에서는 delete from order where order_list_id=?
	public static boolean deleteOrder(String clientId) throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=DBUtil.getConnection();
			pstmt=con.prepareStatement("delete from order where order_list_id=?");
			pstmt.setString(1, clientId);
			int result=pstmt.executeUpdate();
			
			if(result==1) {
				return true;
			}
			
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}
	
	
}
