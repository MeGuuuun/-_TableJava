package dc.human.kimbanbagi.tableJava.dao;

import dc.human.kimbanbagi.tableJava.dto.*;
import dc.human.kimbanbagi.tableJava.common.DBConnectionManager;

import java.sql.*;

public class FindIDDAO {
	private Connection conn;
	
	public String findID(UserDTO dto) {
		String email = dto.getEmail();
		String name = dto.getName();
		String userId = null;
		
		try {
			conn = DBConnectionManager.getConnection();
			
			String sql = "SELECT user_id FROM users WHERE user_email=? AND user_name=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, email);
			pstmt.setString(2, name);
			
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				userId = rs.getString("user_id");
			}
			
			conn.close();
			pstmt.close();
			rs.close();
			
		} catch (Exception e){
			e.printStackTrace();
		}
		
		return userId;
	}
	
	
	
}
