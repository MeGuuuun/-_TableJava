package dc.human.kimbanbagi.tableJava.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dc.human.kimbanbagi.tableJava.common.DBConnectionManager;
import dc.human.kimbanbagi.tableJava.dto.*;

public class MyPageDAO {
	private Connection conn;
	
	public UserDTO getUserInfo(String id) {
		UserDTO dto = new UserDTO();
		
		try {
			conn = DBConnectionManager.getConnection();
			
			String sql = "SELECT "
					+ "user_id,"
					+ "user_email,"
					+ "user_pwd,"
					+ "user_name,"
					+ "phone_number,"
					+ "withdrawal_status "
					+ "FROM users "
					+ "WHERE user_id=?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				dto.setuId(rs.getString("user_id"));
				dto.setEmail(rs.getString("user_email"));
				dto.setPwd(rs.getString("user_pwd"));
				dto.setName(rs.getString("user_name"));
				dto.setNumber(rs.getString("phone_number"));
				dto.setWithdrawal(rs.getString("withdrawal_status"));
			}
			
			conn.close();
			pstmt.close();
			rs.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return dto;
	}
}
