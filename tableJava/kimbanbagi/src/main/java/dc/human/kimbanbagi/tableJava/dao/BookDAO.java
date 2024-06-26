package dc.human.kimbanbagi.tableJava.dao;

import dc.human.kimbanbagi.tableJava.common.DBConnectionManager;
import dc.human.kimbanbagi.tableJava.dao.*;
import dc.human.kimbanbagi.tableJava.dto.*;
import java.util.*;
import java.io.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.text.SimpleDateFormat;

/*

PROJECT        : tablejava
PROGRAM ID    : BookDAO.java
PROGRAM NAME    : 예약
DESCRIPTION    : 예약 관련 sql문 처리
AUTHOR        : 박지민
CREATED DATE    : 2024.06.05.
HISTORY
======================================================
DATE     NAME           DESCRIPTION
2024.06.05   박지민        init

*/

public class BookDAO {
	
private Connection conn;
int row=0; // insert 또는 update문이 잘 실행되었는지 확인할 때 쓰이는 변수

//update 또는 insert 시 updated_date / created_date 칼럼에 사용
java.util.Date now = new java.util.Date();
Date sqlDate = new Date(now.getTime()); 
	
	// 특정 식당에 예약을 신청하는 메소드
	public int addBook(BookDTO dto) {
		
		try {
			conn = DBConnectionManager.getConnection();
			
			String sql = "INSERT INTO reservation ("
					+ "user_id,"
					+ "restaurant_id,"
					+ "restaurant_name,"
					+ "reservation_date,"
					+ "reservation_time,"
					+ "reservation_status,"
					+ "adult_count,"
					+ "kids_count,"
					+ "stroller,"
					+ "wheelchair,"
					+ "requirements,"
					+ "created_date,"
					+ "created_id"
					+ ") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getUser_id());
			pstmt.setString(2, dto.getRestaurant_id());;
			pstmt.setString(3, dto.getRestaurant_name());
			pstmt.setString(4, dto.getDate());
			pstmt.setString(5, dto.getTime());	
			pstmt.setString(6, dto.getStatus());
			pstmt.setString(7, dto.getA_count());
			pstmt.setString(8, dto.getK_count());
			pstmt.setString(9, dto.getS_count());
			pstmt.setString(10, dto.getW_count());
			pstmt.setString(11, dto.getRequirement());
			
			pstmt.setDate(12, sqlDate);
			pstmt.setString(13, dto.getUser_id());
			
			row = pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return row;
	}
	
	//사용자의 예약 리스트 가져오는 메소드
	public List<BookDTO> getUserBookList(String id) {
		List<BookDTO> bookList = new ArrayList<>();
		
		try {
			conn = DBConnectionManager.getConnection();
			
			String sql = "SELECT "
					+ "restaurant_id,"
					+ "restaurant_name,"
					+ "reservation_date,"
					+ "reservation_time,"
					+ "DECODE(reservation_status, '0', '예약 대기', '1', '예약 확정', '2', '예약 취소', '3', '예약 거절', '4', '예약 종료') status,"
					+ "adult_count,"
					+ "kids_count,"
					+ "stroller,"
					+ "wheelchair,"
					+ "requirements "
					+ "FROM reservation "
					+ "WHERE user_id=?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BookDTO dto = new BookDTO();
				
				dto.setRestaurant_id(rs.getString("restaurant_id"));
				dto.setRestaurant_name(rs.getString("restaurant_name"));
				dto.setDate(rs.getString("reservation_date"));
				dto.setTime(rs.getString("reservation_time"));
				dto.setStatus(rs.getString("status"));
				dto.setA_count(rs.getString("adult_count"));
				dto.setK_count(rs.getString("kids_count"));
				dto.setS_count(rs.getString("stroller"));
				dto.setW_count(rs.getString("wheelchair"));
				dto.setRequirement(rs.getString("requirements"));
				
				bookList.add(dto);
				
			}
			
			conn.close();
			pstmt.close();
			rs.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return bookList;
	}
	
	
	// 사장님의 예약 리스트 가져오는 메소드
	public List<BookDTO> getOwnerBookList(String id) {
		List<BookDTO> dtoList = new ArrayList<>();
		
		try {
			conn = DBConnectionManager.getConnection();
			
			String sql = "SELECT "
					+ "user_id,"
					+ "restaurant_name,"
					+ "reservation_date,"
					+ "reservation_time,"
					+ "DECODE(reservation_status, '0', '예약 대기', '1', '예약 확정', '2', '예약 취소', '3', '예약 거절', '4', '예약 종료') status,"
					+ "adult_count,"
					+ "kids_count,"
					+ "stroller,"
					+ "wheelchair,"
					+ "requirements "
					+ "FROM reservation "
					+ "WHERE restaurant_id=?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BookDTO dto = new BookDTO();
				
				dto.setUser_id(rs.getString("user_id"));
				dto.setRestaurant_name(rs.getString("restaurant_name"));
				dto.setDate(rs.getString("reservation_date"));
				dto.setTime(rs.getString("reservation_time"));
				dto.setStatus(rs.getString("status"));
				dto.setA_count(rs.getString("adult_count"));
				dto.setK_count(rs.getString("kids_count"));
				dto.setS_count(rs.getString("stroller"));
				dto.setW_count(rs.getString("wheelchair"));
				dto.setRequirement(rs.getString("requirements"));
				
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
	
	// 예약 상태를 변경하는 메소드
	// 사용자 또는 사장님이 예약 내역에서 예약 확정/ 예약 취소 / 예약 거절 등의 버튼을 눌렀을 때 reservation_status가 변경되게 하는 메소드
	public int changeStatus(String status, String u_id, String r_id ) {
		try {
			conn = DBConnectionManager.getConnection();
			
			String sql = "UPDATE reservation SET "
					+ "reservation_status=?,"
					+ "updated_date=?,"
					+ "updated_id=? "
					+ "WHERE user_id=? "
					+ "AND restaurant_id=?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, status);
			pstmt.setDate(2, sqlDate);
			pstmt.setString(3, u_id);
			pstmt.setString(4, u_id);
			pstmt.setString(5, r_id);
			
			row = pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return row;
	}

}
