package dc.human.kimbanbagi.tableJava.servlet;
import dc.human.kimbanbagi.tableJava.dao.*;
import dc.human.kimbanbagi.tableJava.dto.*;
import jakarta.servlet.RequestDispatcher;

import java.io.IOException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/*

PROJECT        : tablejava
PROGRAM ID    : OwnerMainServlet.java
PROGRAM NAME    : 사장님 메인 페이지
DESCRIPTION    : 사장님 메인 페이지 관련 servlet
AUTHOR        : 이경민
CREATED DATE    : 2024.06.05.
HISTORY
======================================================
DATE     NAME           DESCRIPTION
2024.06.05   이경민        init

*/

@WebServlet("/ownerMain")
public class OwnerMainServlet extends HttpServlet {
	
	protected void doPost(jakarta.servlet.http.HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		
		// jsp에서 request를 읽어온 경우
		String userId = request.getParameter("userId");
		String restaurantId = request.getParameter("restaurantId");
		
		// 서블릿에서 request를 읽어온 경우
		String uId = (String) request.getAttribute("userId");
		String rId = (String) request.getAttribute("restaurantId");
		
		RestaurantDAO dao=new RestaurantDAO();
		
		// request로 읽어온 userId와 restaurantId로 사장님의 가게 정보를 가져와 jsp에 보내기
		if(uId==null) {
			RestaurantDTO dto= dao.getOwnerRestaurant(restaurantId);
			
			request.setAttribute("restaurant", dto);
			request.setAttribute("userId", userId);
			request.setAttribute("restaurantId", restaurantId);
			request.getRequestDispatcher("ownerMain.jsp").forward(request, response);
			
		}else {
			RestaurantDTO dto= dao.getOwnerRestaurant(rId);
			
			request.setAttribute("restaurant", dto);
			request.setAttribute("userId", uId);
			request.setAttribute("restaurantId", rId);
			request.getRequestDispatcher("ownerMain.jsp").forward(request, response);
		}
		
		
	}

}
