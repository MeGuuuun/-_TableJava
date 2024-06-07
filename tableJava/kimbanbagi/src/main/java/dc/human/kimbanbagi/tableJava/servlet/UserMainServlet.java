package dc.human.kimbanbagi.tableJava.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/userMain")
public class UserMainServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		
		String userId = (String) request.getAttribute("userId");
		String uId = request.getParameter("userId");
		
		if(uId == null) {
			request.setAttribute("userId", userId);
			request.getRequestDispatcher("userMain.jsp").forward(request, response);
		} else {
			request.setAttribute("userId", uId);
			request.getRequestDispatcher("userMain.jsp").forward(request, response);
		}
		
	}
		
		

}
