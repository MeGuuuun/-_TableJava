package dc.human.kimbanbagi.tableJava.servlet;

import dc.human.kimbanbagi.tableJava.dao.*;
import dc.human.kimbanbagi.tableJava.dto.*;
import java.util.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/*

PROJECT        : tablejava
PROGRAM ID    : OwnerBookListServlet.java
PROGRAM NAME    : 사장님 예약 내역 리스트
DESCRIPTION    : 사장님의 예약 내역을 보여주고 관리 함
AUTHOR        : 박지민
CREATED DATE    : 2024.06.05.
HISTORY
======================================================
DATE     NAME           DESCRIPTION
2024.06.05   박지민        init

*/

@WebServlet("/OwnerBookList")
public class OwnerBookListServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("utf-8");
		
		// jsp에서 보낸 request 읽기
		String userId = request.getParameter("userId");
		String restaurantId = request.getParameter("restaurantId");
		
		// 사장님이 누르는 버튼의 종류에 따라 다른 처리를 해야 함
		String action = request.getParameter("action");
		
		BookDAO dao = new BookDAO();
		
		// 사장님의 예약 내역 리스트를 보여줌
		if(action.equals("bookList")) {
			
			List<BookDTO> bookList = dao.getOwnerBookList(restaurantId);
			
			request.setAttribute("userId", userId);
			request.setAttribute("restaurantId", restaurantId);
			request.setAttribute("bookList", bookList);
			request.getRequestDispatcher("/ownerBookList.jsp").forward(request, response);
			
		// 	사장님의 예약 내역 중 특정 예약의 상태를 예약 확정 또는 예약 거절 등으로 변경 할 수 있음
		} else if(action.equals("status")) {
			String restaurantName = request.getParameter("restaurantName");
			
			String status = request.getParameter("status");
			String bookId = request.getParameter("bookId");
			
			// 예약 상태 변경 sql문 처리 확인
			if(dao.changeStatus(status, bookId, restaurantId) != 0) {
				NotificationDAO ndao = new NotificationDAO();
				// 예약 확정일 경우 알림
				if(status.equals("1")) {
					
					if(ndao.confirmBook(bookId, restaurantName)!=0) {
						
						request.setAttribute("userId", userId);
						request.setAttribute("restaurantId", restaurantId);
						request.getRequestDispatcher("/ownerBookList.jsp").forward(request, response);
						
					} else {
						// notification 쿼리문 오류 처리 코드 작성
					}
				
				// 예약 거절일 경우 알림
				}else if(status.equals("3")) {
					if(ndao.bookCancelFromOwner(bookId,restaurantId, restaurantName)!=0) {
						
						request.setAttribute("userId", userId);
						request.setAttribute("restaurantId", restaurantId);
						request.getRequestDispatcher("/ownerBookList.jsp").forward(request, response);
						
					}else {
						// notification 쿼리문 오류 처리 코드 작성
					}
				
				// 예약 종료일 경우 알림
				}else if(status.equals("4")) {
					if(ndao.endBook(bookId, restaurantId, restaurantName)!=0) {
						
						request.setAttribute("userId", userId);
						request.setAttribute("restaurantId", restaurantId);
						request.getRequestDispatcher("/ownerBookList.jsp").forward(request, response);
						
					}else {
						// notification 쿼리문 오류 처리 코드 작성
					}
				}
				
			}else {
				// 예약 상태 변경 관련 sql문 오류 시 처리 코드 작성
			}
		}
	}

}
