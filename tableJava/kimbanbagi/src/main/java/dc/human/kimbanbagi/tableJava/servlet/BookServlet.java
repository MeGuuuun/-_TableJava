package dc.human.kimbanbagi.tableJava.servlet;

import dc.human.kimbanbagi.tableJava.dao.*;
import dc.human.kimbanbagi.tableJava.dto.*;
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
PROGRAM ID    : BookServlet.java
PROGRAM NAME    : 예약
DESCRIPTION    : 예약 처리
AUTHOR        : 박지민
CREATED DATE    : 2024.06.05.
HISTORY
======================================================
DATE     NAME           DESCRIPTION
2024.06.05   박지민        init

*/

@WebServlet("/book")
public class BookServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		// jsp에서 보낸 request 읽기
		String userId = request.getParameter("userId");
		String restaurantId = request.getParameter("restaurantId");
		String restaurantName = request.getParameter("restaurantName");
		
		String action = request.getParameter("action");
		
		
		if(action.equals("bookBtn")) {
			
			request.setAttribute("userId", userId);
			request.setAttribute("restaurantId", restaurantId);
			request.setAttribute("restaurantName", restaurantName);
			request.getRequestDispatcher("/book.jsp").forward(request, response);
			
		} else if(action.equals("addBook")) {
			String adultCount = request.getParameter("adultCount");
			String kidCount = request.getParameter("kidCount");
			String stroller = request.getParameter("stroller");
			String wheelchair = request.getParameter("wheelchair");
			String date = request.getParameter("dateValue");
			String time = request.getParameter("timeValue");
			String requirement = request.getParameter("requirement");
			String status = "0"; //예약 대기 상태

			BookDTO dto = new BookDTO();
			
			dto.setUser_id(userId);
			dto.setRestaurant_id(restaurantId);
			dto.setRestaurant_name(restaurantName);
			dto.setDate(date);
			dto.setTime(time);
			dto.setStatus(status);
			dto.setA_count(adultCount);
			dto.setK_count(kidCount);
			dto.setS_count(stroller);
			dto.setW_count(wheelchair);
			dto.setRequirement(requirement);
			
			BookDAO dao = new BookDAO();
			
			// 예약을 추가하기
			if(dao.addBook(dto) != 0) {
				NotificationDAO ndao = new NotificationDAO();
				
				// 예약 신청 알림 저장하기
				if(ndao.addBookNotification(dto)!=0) {
					
					request.setAttribute("userId", userId);
					request.setAttribute("book", dto);
					request.getRequestDispatcher("/book_done.jsp").forward(request, response);
					
				}else {
					//알림 관련 sql문 처리 오류 발생
				}
				
			} else {
				//예약 관련 sql문 처리 오류 발생 > alert 띄우기
			}
		}
	}
}
