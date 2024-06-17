package dc.human.kimbanbagi.tableJava.servlet;

import dc.human.kimbanbagi.tableJava.dto.*;
import dc.human.kimbanbagi.tableJava.dao.*;

import java.io.IOException;
import java.io.InputStream;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.MultipartConfig;

/*

PROJECT        : tablejava
PROGRAM ID    : RegisterServlet.java
PROGRAM NAME    : 식당 등록
DESCRIPTION    : 식당 등록 관련 servlet
AUTHOR        : 김문정
CREATED DATE    : 2024.06.05.
HISTORY
======================================================
DATE     NAME           DESCRIPTION
2024.06.05   김문정        init

*/

@WebServlet("/register")
@MultipartConfig
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	
    	response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		
		// register.jsp에서 보낸 request 읽기
		String userId = request.getParameter("userId");
		String restaurantId = request.getParameter("restaurantId");
        String restaurantName = request.getParameter("restaurantName");
        String restaurantHead = request.getParameter("restaurantHead");
        String restaurantCity = request.getParameter("restaurantCity");
        String restaurantAddress = request.getParameter("restaurantAddress");
        String restaurantNumber = request.getParameter("restaurantNumber");
        
        // 식당 등록 시 예약과 웨이팅 기능을 활성화 할 지에 대한 유무를 입력 받음
        String reservationAvailable = request.getParameter("reservationAvailable");
        //예약을 받는 경우 1 받지 않을 경우 0
        if(reservationAvailable != null) {
        	reservationAvailable = "1";
        } else {
        	reservationAvailable = "0";
        }
        
        String waitingAvailable = request.getParameter("waitingAvailable");
        //웨이팅을 받는 경우 1 받지 않을 경우 0
        if(waitingAvailable != null) {
        	waitingAvailable = "1";
        } else {
        	waitingAvailable = "0";
        }
        
        // 첨부된 이미지를 db에 저장하기 위한 변환 과정
        Part imagePart = request.getPart("restaurantPhoto");
        InputStream inputStream = imagePart.getInputStream();

        RestaurantDTO dto = new RestaurantDTO();
        
        dto.setR_id(restaurantId);
        dto.setR_name(restaurantName);
        dto.setR_head(restaurantHead);
        dto.setR_city(restaurantCity);
        dto.setR_address(restaurantAddress);
        dto.setR_number(restaurantNumber);
        dto.setU_id(userId);
        dto.setR_status(reservationAvailable);
        dto.setW_status(waitingAvailable);
        dto.setR_photo(inputStream);
       
        RestaurantDAO dao = new RestaurantDAO();
        
        if(dao.addRestaurant(dto) != 0) {
        	// 가게 등록 완료 시 users 테이블의 가게 등록 여부 칼럼 변경
        	if(dao.changeRStatus(userId)!=0) {
        		request.setAttribute("userId", userId);
                request.setAttribute("restaurantId", restaurantId);
                
                // 가게 등록 완료 시 사장님 메인 화면으로 이동
                request.getRequestDispatcher("/ownerMain").forward(request, response);
        	} else {
        		// sql 처리 오류 시 처리 코드 작성
        	}
        	
        } else {
        	// sql 처리 오류 시 처리 코드 작성
        }
        
    }
}