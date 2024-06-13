package dc.human.kimbanbagi.tableJava.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dc.human.kimbanbagi.tableJava.common.DBConnectionManager;
import dc.human.kimbanbagi.tableJava.dto.*;

/*

PROJECT        : tablejava
PROGRAM ID    : MyPageDAO.java
PROGRAM NAME    : 마이 페이지 dao
DESCRIPTION    : 마이 페이지 관련 sql문 처리
AUTHOR        : 김문정, 이경민
CREATED DATE    : 2024.06.05.
HISTORY
======================================================
DATE     NAME           DESCRIPTION
2024.06.05   김문정, 이경민        init

*/

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
	
	// 마이 페이지 > 사용한 식당 내역
	//사용자가 이용 완료한 식당 리스트 가져오는 메소드
	// reservation_status가 "4"(이용 완료)인 레코드 가져오기
	public List<BookDTO> restaurantHistory(String id) {
		List<BookDTO> dtoList = new ArrayList<>();
		
		try {
			conn = DBConnectionManager.getConnection();
			
			String sql = "SELECT "
					+ "restaurant_name,"
					+ "reservation_date,"
					+ "reservation_time "
					+ "FROM reservation "
					+ "WHERE user_id=? "
					+ "AND reservation_status=?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, "4");
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BookDTO dto = new BookDTO();
				
				dto.setRestaurant_name(rs.getString("restaurant_name"));
				dto.setDate(rs.getString("reservation_date"));
				dto.setTime(rs.getString("reservation_time"));
				
				dtoList.add(dto);
			}
			
			conn.close();
			pstmt.close();
			rs.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return dtoList;
	}
}
