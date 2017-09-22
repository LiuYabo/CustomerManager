<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import ="java.util.Date" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="text-align: center;">

<%

Cookie cookies[] = request.getCookies();
		for (int i = 0; i < cookies.length; i++) {
			if (cookies[i].getName().equals("lastAccessTime")) {
				long cookieValue = Long.parseLong(cookies[i].getValue());
				Date date = new Date(cookieValue);
				String lastTime = date.toLocaleString();
				request.setAttribute("lastTime", lastTime);
				break;
			}
		}
		
		Cookie cookie = new Cookie("lastAccessTime", System.currentTimeMillis()+"");
		cookie.setMaxAge(3600*24*30*1);
		response.addCookie(cookie);
		
%>
		

<h2 >恭喜登入成功</h2><br/>

<h5>您上次访问时间为：${requestScope.lastTime}(近一个月内)</h5><br/>
<h6>
<meta http-equiv='refresh' content='3;url=/cusmang/welcom.jsp'>
三秒钟后自动跳转，如未自动跳转请点击<a href="/cusmang/welcom.jsp">这里</a>
</h6>

</body>
</html>