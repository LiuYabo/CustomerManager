<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">当前查询的用户</h1><br/>
<a href="/cusmang/welcom.jsp">返回主页</a>
<table align="center" >
	<tr>
		<td>id</td>
		<td>姓名</td>
		<td>性别</td>
		<td>电话</td>
		<td>邮箱</td>
		<td>简介</td>
	</tr>
	

	<tr>
		<td>${customer.id}</td>
		<td>${customer.name}</td>
		<td>${customer.gender}</td>
		<td>${customer.phone}</td>
		<td>${customer.email}</td>
		<td>${customer.description}</td>
	</tr>


</table>



</body>
</html>