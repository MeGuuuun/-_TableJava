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
PROGRAM ID    : OwnerWaitListServlet.java
PROGRAM NAME    : 사장님 웨이팅 내역 리스트
DESCRIPTION    : 사장님의 웨이팅 내역을 보여주고 관리 함
AUTHOR        : 반재홍
CREATED DATE    : 2024.06.05.
HISTORY
======================================================
DATE     NAME           DESCRIPTION
2024.06.05   반재홍        init

*/

@WebServlet("/OwnerWaitList")
public class OwnerWaitListServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		// jsp에서 보낸 request 읽어오기
		String userId = request.getParameter("userId");
		String restaurantId = request.getParameter("restaurantId");
		
		String action = request.getParameter("action");
		
		WaitDAO dao = new WaitDAO();
		
		// 사장님의 웨이팅 리스트를 보여주는 선택지
		if(action.equals("waitList")){
			List<WaitDTO> waitList = dao.getOwnerWaitingList(restaurantId);
			
			request.setAttribute("userId", userId);
			request.setAttribute("restaurantId", restaurantId);
			request.setAttribute("waitList", waitList);
			request.getRequestDispatcher("/ownerWaitList.jsp").forward(request, response);
			
		// 웨이팅 상태 변경 처리 메소드
		}else if (action.equals("status")) {
			String status = request.getParameter("status");
			String bookId = request.getParameter("bookId");
			
			if(dao.changeStatus(status, bookId, restaurantId) != 0 ) {
				NotificationDAO ndao = new NotificationDAO();
				
				String restaurantName = request.getParameter("restaurantName");
				
				if(ndao.waitCancelFromOwner(restaurantId, userId, restaurantName)!=0) {
					
					request.setAttribute("userId", userId);
					request.setAttribute("restaurantId", restaurantId);
					request.getRequestDispatcher("/ownerWaitList.jsp").forward(request, response);
					
				}else {
					//notification 오류 처리
				}
			} else {
				// 웨이팅 상태 변경 관련 sql문 오류 시 처리 코드 작성
			}
		}
	}

}
