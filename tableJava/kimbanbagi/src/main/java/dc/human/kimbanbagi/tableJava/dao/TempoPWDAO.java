package dc.human.kimbanbagi.tableJava.dao;

import java.sql.*;
import java.util.Random;

import dc.human.kimbanbagi.tableJava.dto.*;
import dc.human.kimbanbagi.tableJava.common.DBConnectionManager;

/*

PROJECT        : tablejava
PROGRAM ID    : tempoPWDAO.java
PROGRAM NAME    : 임시 비밀번호 
DESCRIPTION    : 임시 비밀번호 관련 sql문 처리
AUTHOR        : 박지민
CREATED DATE    : 2024.06.05.
HISTORY
======================================================
DATE     NAME           DESCRIPTION
2024.06.05   박지민        init

*/

public class TempoPWDAO {
	private Connection conn;
	int row=0; // insert 또는 update문이 잘 실행되었는지 확인할 때 쓰이는 변수

	//update 또는 insert 시 updated_date / created_date 칼럼에 사용
	java.util.Date now = new java.util.Date();
	Date sqlDate = new Date(now.getTime()); 
	
	// 사용자가 입력한 정보와 일치하는 회원 정보가 있는지 확인하는 메소드
	public boolean check(UserDTO dto) {
		String id = dto.getuId();
		String name = dto.getName();
		
		boolean result=false;
		int cnt=0;
		
		try {
			conn = DBConnectionManager.getConnection();
			
			String sql = "SELECT "
					+ "COUNT(*) AS cnt "
					+ "FROM users "
					+ "WHERE user_id=? "
					+ "AND user_name=?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				cnt = rs.getInt("cnt");
				
				// 사용자가 입력한 정보와 일치하는 회원 정보 발견 시 임시 비밀 번호 지급
				if(cnt == 1) {
					if(tempoPW(id)!=0) result = true;
					else System.out.println("임시 비밀번호 지급에 실패했습니다.");
				}
				
			} else {
				System.out.println("일치하는 정보가 없습니다.");
			}
			
			conn.close();
			rs.close();
			pstmt.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	// 임시 비밀 번호를 DB에 저장하는 메소드
	public int tempoPW(String id) {
		String typedId = id;
		String tempoPw = randomPW(8);
		
		try {
			conn = DBConnectionManager.getConnection();
			
			String sql = "INSERT INTO temporary_password ("
					+ "user_id,"
					+ "temporary_pwd,"
					+ "created_date,"
					+ "created_id) "
					+ "VALUES (?, ?, ?, ?)";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, typedId);
			pstmt.setString(2, tempoPw);
			pstmt.setDate(3, sqlDate);
			pstmt.setString(4, typedId);
			
			row = pstmt.executeUpdate();
			
			conn.close();
			pstmt.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return row;
	}
	
	// 영문 + 숫자가 섞인 8자리 문자열 생성 메소드
	public static String randomPW(int range) {
		StringBuilder sb = new StringBuilder();
		Random rd = new Random();
		
		for(int i=0; i<range; i++) {
			if(rd.nextBoolean()) {
				sb.append(rd.nextInt(10));
			}else {
				sb.append((char)(rd.nextInt(26)+65));
			}
		}
		return sb.toString();
	}
	


}
