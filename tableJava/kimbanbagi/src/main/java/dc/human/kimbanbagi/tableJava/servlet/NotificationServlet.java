package dc.human.kimbanbagi.tableJava.servlet;

import dc.human.kimbanbagi.tableJava.dto.*;
import dc.human.kimbanbagi.tableJava.dao.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/Notification")
public class NotificationServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("utf-8");
		
		String action = request.getParameter("action");
		
		String userId = request.getParameter("userId");
		
		NotificationDAO dao = new NotificationDAO();
		NotificationDTO dto = new NotificationDTO();
		
		if(action.equals("userNotification")) {
			List<NotificationDTO> dtoList = dao.getUserNotificationList(userId);
			
			request.setAttribute("userId", userId);
			request.setAttribute("notification", dtoList);
			request.getRequestDispatcher("userNotification.jsp").forward(request, response);
			
		}else if(action.equals("ownerNotification")) {
			String restaurantId = request.getParameter("restaurantId");
			
			List<NotificationDTO> dtoList = dao.getOwnerNotificationList(restaurantId);
			
			request.setAttribute("userId", userId);
			request.setAttribute("restaurantId", restaurantId);
			request.setAttribute("notification", dtoList);
			request.getRequestDispatcher("ownerNotification.jsp").forward(request, response);
			
		}
	}

}
