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

@WebServlet("/OwnerBookList")
public class OwnerBookListServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("utf-8");
		
		String uId = request.getParameter("userId");
		String rId = request.getParameter("restaurantId");
		
		String action = request.getParameter("action");
		
		if(action.equals("bookList")) {
			BookDAO dao = new BookDAO();

			List<BookDTO> bookList = dao.getOwnerBookList(rId);
			
			request.setAttribute("userId", uId);
			request.setAttribute("restaurantId", rId);
			request.setAttribute("bookList", bookList);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ownerBookList.jsp");
			dispatcher.forward(request, response);
		} else if(action.equals("status")) {
			
			String status = request.getParameter("status");
			
			BookDAO dao = new BookDAO();
			dao.changeStatus(status, uId, rId);
			
			response.sendRedirect("ownerBookList.jsp");
		}
	}

}
