package dc.human.kimbanbagi.tableJava.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dc.human.kimbanbagi.tableJava.dto.*;
import dc.human.kimbanbagi.tableJava.common.DBConnectionManager;

public class JoinDAO {
	private Connection conn;

    public void join(UserDTO dto) {
        try {
        	conn = DBConnectionManager.getConnection();
        	
            String sql = "INSERT INTO USERS (user_id, user_pwd, user_email, user_name, phone_number, user_role, store_register, withdrawal_status) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            
            pstmt.setString(1, dto.getuId());
            pstmt.setString(2, dto.getPwd());
            pstmt.setString(3, dto.getEmail());
            pstmt.setString(4, dto.getName());
            pstmt.setString(5, dto.getNumber());
            pstmt.setString(6, dto.getRole());
            pstmt.setString(7, dto.getRegister());
            pstmt.setString(8, dto.getWithdrawal());

            pstmt.executeUpdate();
            
            conn.close();
            pstmt.close();
         
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //아이디 중복 확인 메소드
    public boolean idCheck(String id) {
        boolean result = false;
        
        try {
        	conn = DBConnectionManager.getConnection();
        	
            String sql = "SELECT user_id FROM USERS WHERE user_id = ?";
            
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            
            ResultSet rs = pstmt.executeQuery();
            result = rs.next();
            
            conn.close();
            pstmt.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}