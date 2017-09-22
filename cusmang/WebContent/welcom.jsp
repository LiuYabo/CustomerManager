<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="text-align: center;">
	<br/><br/>
    <h1>客户管理系统</h1>
    <br/><br/>
    <a href="/cusmang/add.jsp">添加客户</a>
    <a href="/cusmang/findId.jsp">查询客户</a>
    <a href="/cusmang/delete.jsp">删除用户</a>
    <a href="/cusmang/QueryFindAll">查询全部用户</a>
    <br/>
    <br/>
	<h3><a href="/cusmang/Logout">注销登入</a></h3>
	
	<br/><br/><br/>
	<h5>累计访问人数：${count}</h5>


</body>
</html>