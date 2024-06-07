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


@WebServlet("/ownerMain")
public class OwnerMainServlet extends HttpServlet {
	
	protected void doPost(jakarta.servlet.http.HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		
		String userId = (String) request.getAttribute("userId");
		String restaurantId = (String) request.getAttribute("restaurantId");
		
		String uId = request.getParameter("userId");
		String rId = request.getParameter("restaurantId");
		
		RestaurantDAO dao=new RestaurantDAO();
		
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
