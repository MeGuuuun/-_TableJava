/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/10.1.23
 * Generated at: 2024-06-13 06:08:23 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;

public final class book_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title>예약 화면</title>\r\n");
      out.write("<script src=\"https://code.jquery.com/jquery-3.6.0.min.js\"></script>\r\n");
      out.write("<script>\r\n");
      out.write("			$(document).ready(function() {\r\n");
      out.write("				var a_count = parseInt($(\"#a_count\").text()); // 성인 인원\r\n");
      out.write("			    var k_count = parseInt($(\"#k_count\").text()); // 유아 인원\r\n");
      out.write("			    var s_count = parseInt($(\"#s_count\").text()); // 유모차 개수\r\n");
      out.write("			    var w_count = parseInt($(\"#w_count\").text()); // 휠체어 개수\r\n");
      out.write("\r\n");
      out.write("			 // 성인 인원 증가/감소\r\n");
      out.write("			    $('#a_increaseCount').on('click', function(event) {\r\n");
      out.write("			        event.preventDefault();\r\n");
      out.write("			        a_count++;\r\n");
      out.write("			        $(\"#a_count\").text(a_count);\r\n");
      out.write("			        $('#hiddenAdultCount').val($(\"#a_count\").text());\r\n");
      out.write("			    });\r\n");
      out.write("\r\n");
      out.write("			    $('#a_decreaseCount').on('click', function(event) {\r\n");
      out.write("			        event.preventDefault();\r\n");
      out.write("			        if (a_count > 0) {\r\n");
      out.write("			            a_count--;\r\n");
      out.write("			            $(\"#a_count\").text(a_count);\r\n");
      out.write("			            $('#hiddenAdultCount').val($(\"#a_count\").text());\r\n");
      out.write("			        }\r\n");
      out.write("			    });\r\n");
      out.write("\r\n");
      out.write("			    // 유아 인원 증가/감소\r\n");
      out.write("			    $('#k_increaseCount').on('click', function(event) {\r\n");
      out.write("			        event.preventDefault();\r\n");
      out.write("			        k_count++;\r\n");
      out.write("			        $(\"#k_count\").text(k_count);\r\n");
      out.write("			        $('#hiddenKidCount').val($(\"#k_count\").text());\r\n");
      out.write("			    });\r\n");
      out.write("\r\n");
      out.write("			    $('#k_decreaseCount').on('click', function(event) {\r\n");
      out.write("			        event.preventDefault();\r\n");
      out.write("			        if (k_count > 0) {\r\n");
      out.write("			            k_count--;\r\n");
      out.write("			            $(\"#k_count\").text(k_count);\r\n");
      out.write("			            $('#hiddenKidCount').val($(\"#k_count\").text());\r\n");
      out.write("			        }\r\n");
      out.write("			    });\r\n");
      out.write("\r\n");
      out.write("			    // 유모차 개수 증가/감소\r\n");
      out.write("			    $('#s_increaseCount').on('click', function(event) {\r\n");
      out.write("			        event.preventDefault();\r\n");
      out.write("			        s_count++;\r\n");
      out.write("			        $(\"#s_count\").text(s_count);\r\n");
      out.write("			        $('#hiddenStroller').val($(\"#s_count\").text());\r\n");
      out.write("			    });\r\n");
      out.write("\r\n");
      out.write("			    $('#s_decreaseCount').on('click', function(event) {\r\n");
      out.write("			        event.preventDefault();\r\n");
      out.write("			        if (s_count > 0) {\r\n");
      out.write("			            s_count--;\r\n");
      out.write("			            $(\"#s_count\").text(s_count);\r\n");
      out.write("			            $('#hiddenStroller').val($(\"#s_count\").text());\r\n");
      out.write("			        }\r\n");
      out.write("			    });\r\n");
      out.write("\r\n");
      out.write("			    // 휠체어 개수 증가/감소\r\n");
      out.write("			    $('#w_increaseCount').on('click', function(event) {\r\n");
      out.write("			        event.preventDefault();\r\n");
      out.write("			        w_count++;\r\n");
      out.write("			        $(\"#w_count\").text(w_count);\r\n");
      out.write("			        $('#hiddenWheelchair').val($(\"#w_count\").text());\r\n");
      out.write("			    });\r\n");
      out.write("\r\n");
      out.write("			    $('#w_decreaseCount').on('click', function(event) {\r\n");
      out.write("			        event.preventDefault();\r\n");
      out.write("			        if (w_count > 0) {\r\n");
      out.write("			            w_count--;\r\n");
      out.write("			            $(\"#w_count\").text(w_count);\r\n");
      out.write("			            $('#hiddenWheelchair').val($(\"#w_count\").text());\r\n");
      out.write("			        }\r\n");
      out.write("			    });\r\n");
      out.write("				\r\n");
      out.write("			    // 전 페이지로 돌아가기\r\n");
      out.write("			    $(\"#goBackBtn\").on('click', function(event) {\r\n");
      out.write("			    	event.preventDefault();\r\n");
      out.write("			    })\r\n");
      out.write("			});\r\n");
      out.write("		</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<form action=\"book\" method=\"post\" id=\"frm\">\r\n");
      out.write("	<input type=\"hidden\" name=\"userId\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${userId }", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("	<input type=\"hidden\" name=\"restaurantId\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${restaurantId }", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("	<input type=\"hidden\" name=\"restaurantName\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${restaurantName}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("	<div id=\"container\">\r\n");
      out.write("		<div id=\"store_div\">\r\n");
      out.write("			<div>사진</div>\r\n");
      out.write("			<div>가게 정보<br>\r\n");
      out.write("				식당 이름 : ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${restaurantName }", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(" <br>\r\n");
      out.write("			</div>\r\n");
      out.write("		</div>\r\n");
      out.write("		<div id=\"book_div\">\r\n");
      out.write("			인원 <br>\r\n");
      out.write("			성인\r\n");
      out.write("			<span id=\"a_count\">0</span>\r\n");
      out.write("			<button type=\"button\" id=\"a_increaseCount\">+</button>\r\n");
      out.write("    		<button type=\"button\" id=\"a_decreaseCount\">-</button>\r\n");
      out.write("    		<input type=\"hidden\">\r\n");
      out.write("    		유아\r\n");
      out.write("    		<span id=\"k_count\">0</span>\r\n");
      out.write("			<button type=\"button\" id=\"k_increaseCount\">+</button>\r\n");
      out.write("    		<button type=\"button\" id=\"k_decreaseCount\">-</button>\r\n");
      out.write("    		유모차\r\n");
      out.write("    		<span id=\"s_count\">0</span>\r\n");
      out.write("			<button type=\"button\" id=\"s_increaseCount\">+</button>\r\n");
      out.write("    		<button type=\"button\" id=\"s_decreaseCount\">-</button>\r\n");
      out.write("    		휠체어\r\n");
      out.write("    		<span id=\"w_count\">0</span>\r\n");
      out.write("			<button type=\"button\" id=\"w_increaseCount\">+</button>\r\n");
      out.write("    		<button type=\"button\" id=\"w_decreaseCount\">-</button>\r\n");
      out.write("    		\r\n");
      out.write("    		<input type=\"hidden\" name=\"adultCount\" id=\"hiddenAdultCount\" value=\"0\">\r\n");
      out.write("    		<input type=\"hidden\" name=\"kidCount\" id=\"hiddenKidCount\" value=\"0\">\r\n");
      out.write("    		<input type=\"hidden\" name=\"stroller\" id=\"hiddenStroller\" value=\"0\">\r\n");
      out.write("    		<input type=\"hidden\" name=\"wheelchair\" id=\"hiddenWheelchair\" value=\"0\">\r\n");
      out.write("    		\r\n");
      out.write("  			<label for=\"dateInput\">Select Date:</label>\r\n");
      out.write("			<input type=\"date\" id=\"dateInput\" name=\"dateValue\">\r\n");
      out.write("			\r\n");
      out.write("			<label for=\"timeInput\">Select Time:</label>\r\n");
      out.write("			<input type=\"time\" id=\"timeInput\" name=\"timeValue\">\r\n");
      out.write("    		\r\n");
      out.write("    		<textarea name=\"requirement\" value=\"요청사항\"></textarea>\r\n");
      out.write("    		\r\n");
      out.write("    		<button id=\"goBackBtn\">뒤로가기</button>\r\n");
      out.write("    		<button type=\"submit\" name=\"action\" value=\"addBook\" >예약하기</button>\r\n");
      out.write("		</div>\r\n");
      out.write("	</div>\r\n");
      out.write("</form>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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
