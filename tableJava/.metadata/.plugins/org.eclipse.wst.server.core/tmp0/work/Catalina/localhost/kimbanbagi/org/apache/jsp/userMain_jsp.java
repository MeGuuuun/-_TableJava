/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/10.1.23
 * Generated at: 2024-06-13 06:31:11 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;

public final class userMain_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports,
                 org.apache.jasper.runtime.JspSourceDirectives {

  private static final jakarta.servlet.jsp.JspFactory _jspxFactory =
          jakarta.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/lib/jakarta.servlet.jsp.jstl-2.0.0.jar", Long.valueOf(1717469890096L));
    _jspx_dependants.put("jar:file:/C:/Users/admin/Desktop/tableJava/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/kimbanbagi/WEB-INF/lib/jakarta.servlet.jsp.jstl-2.0.0.jar!/META-INF/c.tld", Long.valueOf(1602841572000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(3);
    _jspx_imports_packages.add("jakarta.servlet");
    _jspx_imports_packages.add("jakarta.servlet.http");
    _jspx_imports_packages.add("jakarta.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile jakarta.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public boolean getErrorOnELNotFound() {
    return false;
  }

  public jakarta.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final jakarta.servlet.http.HttpServletRequest request, final jakarta.servlet.http.HttpServletResponse response)
      throws java.io.IOException, jakarta.servlet.ServletException {

    if (!jakarta.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final jakarta.servlet.jsp.PageContext pageContext;
    jakarta.servlet.http.HttpSession session = null;
    final jakarta.servlet.ServletContext application;
    final jakarta.servlet.ServletConfig config;
    jakarta.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    jakarta.servlet.jsp.JspWriter _jspx_out = null;
    jakarta.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>사용자 메인 화면</title>\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("	src=\"https://code.jquery.com/jquery-3.6.0.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("	src=\"//dapi.kakao.com/v2/maps/sdk.js?appkey=1f3274f01f7f59a2883492e9cd1c8599\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	<div class=\"navbar\">\r\n");
      out.write("		<button onclick=\"location.reload()\">메인 화면</button>\r\n");
      out.write("		<form method=\"post\" action=\"UserBookList\">\r\n");
      out.write("			<input type=\"hidden\" name=\"userId\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${userId }", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("			<button name=\"action\" value=\"bookList\">예약/웨이팅</button>\r\n");
      out.write("		</form>\r\n");
      out.write("		<form method=\"post\" action=\"Notification\">\r\n");
      out.write("        	<input type=\"hidden\" name=\"userId\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${userId }", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("        	<button type=\"submit\" name=\"action\" value=\"userNotification\">알림</button>\r\n");
      out.write("        </form>\r\n");
      out.write("		<form method=\"post\" action=\"MyPage\">\r\n");
      out.write("			<input type=\"hidden\" name=\"userId\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${userId }", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("			<button type=\"submit\" name=\"action\" value=\"getUserInfo\">마이\r\n");
      out.write("				페이지</button>\r\n");
      out.write("		</form>\r\n");
      out.write("	</div>\r\n");
      out.write("	<div></div>\r\n");
      out.write("	<div class=\"search-section\">\r\n");
      out.write("		<div class=\"search-div\">\r\n");
      out.write("			<form method=\"post\" action=\"search\" class=\"search-form\">\r\n");
      out.write("				<label for=\"name\">검색할 이름:</label> <input type=\"text\" id=\"keywords\"\r\n");
      out.write("					name=\"keywords\" placeholder=\"식당 이름을 입력하세요\" required> <input\r\n");
      out.write("					type=\"hidden\" name=\"userId\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${userId }", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\"> <input\r\n");
      out.write("					type=\"submit\" value=\"검색\" class=\"search-button\">\r\n");
      out.write("			</form>\r\n");
      out.write("		</div>\r\n");
      out.write("	</div>\r\n");
      out.write("	<div class=\"map-section\">\r\n");
      out.write("		<div id=\"map\" style=\"width: 500px; height: 400px;\"></div>\r\n");
      out.write("	</div>\r\n");
      out.write("	<script>\r\n");
      out.write("    var mapContainer = document.getElementById('map'), // 지도를 표시할 div \r\n");
      out.write("    mapOption = { \r\n");
      out.write("        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표\r\n");
      out.write("        level: 3 // 지도의 확대 레벨 \r\n");
      out.write("    }; \r\n");
      out.write("\r\n");
      out.write("	var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다\r\n");
      out.write("\r\n");
      out.write("	// HTML5의 geolocation으로 사용할 수 있는지 확인합니다 \r\n");
      out.write("	if (navigator.geolocation) {\r\n");
      out.write("    \r\n");
      out.write("    	// GeoLocation을 이용해서 접속 위치를 얻어옵니다\r\n");
      out.write("    	navigator.geolocation.getCurrentPosition(function(position) {\r\n");
      out.write("        \r\n");
      out.write("        	var lat = position.coords.latitude, // 위도\r\n");
      out.write("            	lon = position.coords.longitude; // 경도\r\n");
      out.write("        \r\n");
      out.write("        	var locPosition = new kakao.maps.LatLng(lat, lon), // 마커가 표시될 위치를 geolocation으로 얻어온 좌표로 생성합니다\r\n");
      out.write("            	message = '<div style=\"padding:5px;\">여기에 계신가요?!</div>'; // 인포윈도우에 표시될 내용입니다\r\n");
      out.write("        \r\n");
      out.write("        	// 마커와 인포윈도우를 표시합니다\r\n");
      out.write("        	displayMarker(locPosition, message);\r\n");
      out.write("            \r\n");
      out.write("      	});\r\n");
      out.write("    \r\n");
      out.write("	} else { // HTML5의 GeoLocation을 사용할 수 없을때 마커 표시 위치와 인포윈도우 내용을 설정합니다\r\n");
      out.write("    \r\n");
      out.write("    	var locPosition = new kakao.maps.LatLng(33.450701, 126.570667),    \r\n");
      out.write("        	message = 'geolocation을 사용할수 없어요..'\r\n");
      out.write("        \r\n");
      out.write("    	displayMarker(locPosition, message);\r\n");
      out.write("	}\r\n");
      out.write("\r\n");
      out.write("	// 지도에 마커와 인포윈도우를 표시하는 함수입니다\r\n");
      out.write("	function displayMarker(locPosition, message) {\r\n");
      out.write("\r\n");
      out.write("    	// 마커를 생성합니다\r\n");
      out.write("    	var marker = new kakao.maps.Marker({  \r\n");
      out.write("        	map: map, \r\n");
      out.write("        	position: locPosition\r\n");
      out.write("    	}); \r\n");
      out.write("    \r\n");
      out.write("    	var iwContent = message, // 인포윈도우에 표시할 내용\r\n");
      out.write("        	iwRemoveable = true;\r\n");
      out.write("\r\n");
      out.write("    	// 인포윈도우를 생성합니다\r\n");
      out.write("    	var infowindow = new kakao.maps.InfoWindow({\r\n");
      out.write("        	content : iwContent,\r\n");
      out.write("        	removable : iwRemoveable\r\n");
      out.write("    	});\r\n");
      out.write("    \r\n");
      out.write("    	// 인포윈도우를 마커위에 표시합니다 \r\n");
      out.write("    	infowindow.open(map, marker);\r\n");
      out.write("    \r\n");
      out.write("    	// 지도 중심좌표를 접속위치로 변경합니다\r\n");
      out.write("    	map.setCenter(locPosition);      \r\n");
      out.write("	}    \r\n");
      out.write("    </script>\r\n");
      out.write("	<div class=\"list-section\">\r\n");
      out.write("		<ul id=\"restaurant-list\">사용자 위치 기반 주위 식당 리스트\r\n");
      out.write("		</ul>\r\n");
      out.write("	</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof jakarta.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
