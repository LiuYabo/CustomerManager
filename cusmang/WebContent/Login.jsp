<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="text-align: center;">
<h1>客户管理系统</h1>
<h2>管理员登入</h2><br/>
	<form action="/cusmang/LoginServlet">
	<table align="center">
		<tr>
			<td>ID:</td>
			<td><input type="text" name="id"></td>
		</tr>
		<tr>
			<td>邮箱:</td>
			<td><input type="text" name="email"></td>
		</tr>
	</table>

	
	<br/>
	<input type="submit" value="登入"></input>
	
	</form>




</body>
</html>