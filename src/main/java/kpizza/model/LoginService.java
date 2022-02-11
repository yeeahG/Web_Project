package kpizza.model;

import java.sql.SQLException;

public class LoginService {

	public static boolean checkDB(String id, String pw) throws SQLException {
		
		return ClientDAO.checkDB(id, pw);
	}

}