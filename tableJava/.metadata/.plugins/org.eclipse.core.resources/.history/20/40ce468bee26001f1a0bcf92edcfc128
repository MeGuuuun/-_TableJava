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

@WebServlet("/restaurantDetail")
public class RestaurantDetailServlet extends HttpServlet {
	
	public void init() throws ServletException {
		System.out.println("Servlet Created");
	}

	public void destroy() {
		System.out.println("Servlet Destroyed");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request, response);
	}
	
	private void doHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		
		String id = "111-111-22222";
		String name = "몰트 하우스";
		
		RestaurantDAO dao = new RestaurantDAO();
		RestaurantDTO restaurant = dao.getRestaurantDetail(id, name);
		
		request.setAttribute("restaurant", restaurant);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/restaurantDetail.jsp");
		dispatcher.forward(request, response);
		
	}

}
