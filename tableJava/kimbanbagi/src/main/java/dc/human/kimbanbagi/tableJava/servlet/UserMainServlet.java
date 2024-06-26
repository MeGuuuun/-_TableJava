package dc.human.kimbanbagi.tableJava.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/*

PROJECT        : tablejava
PROGRAM ID    : UserMainServlet.java
PROGRAM NAME    : 사용자 메인 페이지
DESCRIPTION    : 사용자 메인 페이지 관련 servlet
AUTHOR        : 김문정
CREATED DATE    : 2024.06.05.
HISTORY
======================================================
DATE     NAME           DESCRIPTION
2024.06.05   김문정        init

*/

@WebServlet("/userMain")
public class UserMainServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		
		// jsp에서 보낸 request 읽는 경우
		String userId = request.getParameter("userId");
		
		// 서블릿에서 보낸 request 읽는 경우
		String uId = (String) request.getAttribute("userId");
		
		if(uId == null) {
			request.setAttribute("userId", userId);
			request.getRequestDispatcher("userMain.jsp").forward(request, response);
		} else {
			request.setAttribute("userId", uId);
			request.getRequestDispatcher("userMain.jsp").forward(request, response);
		}
	}
		
		

}
