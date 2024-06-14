package dc.human.kimbanbagi.tableJava.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import dc.human.kimbanbagi.tableJava.dao.*;
import dc.human.kimbanbagi.tableJava.dto.*;

/*

PROJECT        : tablejava
PROGRAM ID    : MyPageServlet.java
PROGRAM NAME    : 마이 페이지
DESCRIPTION    : 마이 페이지 관련 servlet
AUTHOR        : 이경민
CREATED DATE    : 2024.06.05.
HISTORY
======================================================
DATE     NAME           DESCRIPTION
2024.06.05   이경민        init

*/

@WebServlet("/MyPage")
public class MyPageServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("utf-8");
        
        // jsp에서 보낸 request 읽기
        String userId = request.getParameter("userId");
        
        String action = request.getParameter("action");
        
        MyPageDAO dao = new MyPageDAO();
        
        // users 테이블에서 회원 정보 끌어오는 메소드 만들어서 마이 페이지로 보내는 코드 작성
        // 사장님 정보 가져오는 메소드
        if(action.equals("getOwnerInfo")) {
        	String restaurantId = request.getParameter("restaurantId");
        	
        	UserDTO dto = dao.getUserInfo(userId);
        	
        	request.setAttribute("user", dto);
        	request.setAttribute("userId", userId);
        	request.setAttribute("restaurantId", restaurantId);
        	request.getRequestDispatcher("ownerMyPage.jsp").forward(request, response);
        
        	// 사용자 정보 가져오는 메소드	
        }else if(action.equals("getUserInfo")) {
        	UserDTO dto = dao.getUserInfo(userId);
        	List<BookDTO> dtoList = dao.restaurantHistory(userId);
        	
        	request.setAttribute("user", dto);
        	request.setAttribute("history", dtoList);
        	request.setAttribute("userId", userId);
        	request.getRequestDispatcher("userMyPage.jsp").forward(request, response);
        	
        	// 비밀번호 변경 메소드
        }else if(action.equals("changePW")) {
        	String newPwd = request.getParameter("newPwd");
        	
        	// 비밀번호 변경 성공 시 request의 attribute를 모두 삭제하고 로그인 페이지로 이동
        	if(dao.updatePwd(userId, newPwd)!=0) {
        		request.removeAttribute("userId");
        		request.removeAttribute("restaurantId");
        	}else {
        		// 비밀번호 업데이트 sql 처리 오류
        	}
        	
        	// 회원 탈퇴
        }else if(action.equals("withdrawal")) {
        	
        	// 회원 탈퇴 성공 시 request의 attribute를 모두 삭제하고 로그인 페이지로 이동
        	if(dao.withdrawal(userId)!=0) {
        		request.removeAttribute("userId");
        		request.removeAttribute("restaurantId");
        	}
        }
        
    }

}
