/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.70
 * Generated at: 2021-11-05 05:27:18 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_005fform_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
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

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
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

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("	<head>\r\n");
      out.write("		<meta charset=\"UTF-8\">\r\n");
      out.write("		<title>Insert title here</title>\r\n");
      out.write("		\r\n");
      out.write("		<link rel=\"stylesheet\"\r\n");
      out.write("				  href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/css/style.css\">\r\n");
      out.write("				  \r\n");
      out.write("		<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/js/httpRequest.js\"></script>\r\n");
      out.write("		\r\n");
      out.write("		<!-- \r\n");
      out.write("		<script language = \"javascript\">\r\n");
      out.write("			var imgArray = new Array();\r\n");
      out.write("			imgArray[0] = \"https://img.cgv.co.kr/Movie/Thumbnail/Poster/000084/84643/84643_1000.jpg\";\r\n");
      out.write("			imgArray[1] = \"https://img.cgv.co.kr/Movie/Thumbnail/Poster/000084/84703/84703_1000.jpg\";\r\n");
      out.write("			imgArray[2] = \"https://img.cgv.co.kr/Movie/Thumbnail/Poster/000084/84647/84647_1000.jpg\";\r\n");
      out.write("			imgArray[3] = \"https://img.cgv.co.kr/Movie/Thumbnail/Poster/000084/84686/84686_1000.jpg\";\r\n");
      out.write("			\r\n");
      out.write("			function showImage(){\r\n");
      out.write("				var imgNum = Math.round(Math.random()*3);\r\n");
      out.write("				var objImg = document.getElementById(\"poster\");\r\n");
      out.write("				objImg.src = imgArray[imgNum];\r\n");
      out.write("			}\r\n");
      out.write("		</script>\r\n");
      out.write(" 		-->\r\n");
      out.write("		<script type=\"text/javascript\">\r\n");
      out.write("			\r\n");
      out.write("		function login(){\r\n");
      out.write("			\r\n");
      out.write("			var id = document.getElementById(\"id\").value; \r\n");
      out.write("			var pwd = document.getElementById(\"pwd\").value; \r\n");
      out.write("			\r\n");
      out.write("			if(id == ''){\r\n");
      out.write("				alert(\"아이디를 입력하세요.\");\r\n");
      out.write("				return;\r\n");
      out.write("			}\r\n");
      out.write("			if(pwd == ''){\r\n");
      out.write("				alert(\"비밀번호를 입력하세요.\");\r\n");
      out.write("				return;\r\n");
      out.write("			}\r\n");
      out.write("			\r\n");
      out.write("			var url = \"login.do\";\r\n");
      out.write("			\r\n");
      out.write("			var param = \"id=\"+id+\"&pwd=\"+pwd;\r\n");
      out.write("			\r\n");
      out.write("			sendRequest( url, param, resultFn, \"post\");\r\n");
      out.write("			\r\n");
      out.write("			\r\n");
      out.write("		}\r\n");
      out.write("		\r\n");
      out.write("		function resultFn(){\r\n");
      out.write("			\r\n");
      out.write("			if(xhr.readyState == 4 && xhr.status == 200 ){\r\n");
      out.write("				\r\n");
      out.write("				var id = xhr.responseText;\r\n");
      out.write("				\r\n");
      out.write("				\r\n");
      out.write("				if(id != null){\r\n");
      out.write("					alert( id + \"님 환영합니다.\" );\r\n");
      out.write("					location.href=\"main.do?id=\"+id;\r\n");
      out.write("					\r\n");
      out.write("				}else{\r\n");
      out.write("					alert(\"id 또는 비밀번호가 일치하지 않습니다.\");\r\n");
      out.write("					return;\r\n");
      out.write("				}\r\n");
      out.write("			}\r\n");
      out.write("		}\r\n");
      out.write("		\r\n");
      out.write("		\r\n");
      out.write("		</script>\r\n");
      out.write("	</head>\r\n");
      out.write("	<body>\r\n");
      out.write("		<div class=\"wrapper\" style=\"\">\r\n");
      out.write("\r\n");
      out.write("			<div class=\"inner\">\r\n");
      out.write("			\r\n");
      out.write("					<div class=\"image-holder\">\r\n");
      out.write("						<img id=\"poster\"\r\n");
      out.write("							src=\"https://img.cgv.co.kr/Movie/Thumbnail/Poster/000084/84643/84643_1000.jpg\"\r\n");
      out.write("							alt=\"\">\r\n");
      out.write("					</div>\r\n");
      out.write("				\r\n");
      out.write("		<form>\r\n");
      out.write("				<p class=\"register-title\">\r\n");
      out.write("							<img src=\"http://img.cgv.co.kr/R2014/images/title/h1_cgv.png\">\r\n");
      out.write("							<span>로그인</span>\r\n");
      out.write("				</p>\r\n");
      out.write("			\r\n");
      out.write("				<div class=\"form-wrapper form-wrapper-id\">\r\n");
      out.write("					<div class=\"id-wrapper\">\r\n");
      out.write("						<input id=\"id\" name=\"id\" type=\"text\" placeholder=\"아이디\"\r\n");
      out.write("							   class=\"form-control\"><i class=\"zmdi zmdi-accounts\"></i>\r\n");
      out.write("					\r\n");
      out.write("					</div>\r\n");
      out.write("				</div>\r\n");
      out.write("				<div class=\"form-wrapper\">\r\n");
      out.write("					<input type=\"password\" name=\"pwd\" placeholder=\"비밀번호\"\r\n");
      out.write("						   id=\"pwd\" class=\"form-control\"> <i\r\n");
      out.write("						   class=\"zmdi zmdi-lock\"></i>\r\n");
      out.write("				</div>\r\n");
      out.write("					<button type=\"button\" class=\"loginButton\" onclick=\"login();\">\r\n");
      out.write("						<span>&nbsp&nbsp 로그인 하기 →</span><i class=\"zmdi zmdi-arrow-right\"></i>\r\n");
      out.write("					</button>\r\n");
      out.write("					<button type=\"button\" class=\"moveNewmember\" style=\"margin-top: 10px;\" onclick=\"location.href='newmember_form.do'\">\r\n");
      out.write("						<span>&nbsp&nbsp 회원가입 하기 →</span> <i class=\"zmdi zmdi-arrow-right\"></i>\r\n");
      out.write("					</button>\r\n");
      out.write("				\r\n");
      out.write("					<button type=\"button\" class=\"moveMain\" style=\"margin-top: 10px;\" onclick=\"location.href='main.do'\">\r\n");
      out.write("						<span>&nbsp&nbsp 메인 홈페이지 →</span><i class=\"zmdi zmdi-arrow-right\"></i>\r\n");
      out.write("					</button>\r\n");
      out.write("					\r\n");
      out.write("					<button type=\"button\" class=\"moveFind_id\" style=\"margin-top: 10px;\" onclick=\"location.href='find_id_form.do'\">\r\n");
      out.write("						<span>&nbsp&nbsp 아이디 찾기 →</span><i class=\"zmdi zmdi-arrow-right\"></i>\r\n");
      out.write("					</button>\r\n");
      out.write("					<button type=\"button\" class=\"moveFind_pwd\" style=\"margin-top: 10px;\" onclick=\"location.href='find_pwd_form.do'\">\r\n");
      out.write("						<span>&nbsp&nbsp 비밀번호 찾기 →</span><i class=\"zmdi zmdi-arrow-right\"></i>\r\n");
      out.write("					</button>\r\n");
      out.write("					\r\n");
      out.write("			</form>\r\n");
      out.write("			</div>\r\n");
      out.write("		</div>\r\n");
      out.write("		\r\n");
      out.write("\r\n");
      out.write("	</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
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
