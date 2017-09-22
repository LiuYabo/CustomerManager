<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2 align="center">全部员工</h2>
<br/>
<div align="center">
<table align="center" border="1" cellspacing="0" cellpadding="0">
	<tr>
		<th align="center">id</th>
		<th align="center">姓名</th>
		<th align="center">性别</th>
		<th align="center">电话</th>
		<th align="center">邮箱</th>
		<th align="center">简介</th>
	</tr>
	
	<c:forEach var="c" items="${pagebean.list }">

	<tr>
		<td align="center">${c.id}</td>
		<td align="center">${c.name}</td>
		<td align="center">${c.gender}</td>
		<td align="center">${c.phone}</td>
		<td align="center">${c.email}</td>
		<td align="center">${c.description}</td>
	</tr>
	</c:forEach>
	</table>
	
	共${pagebean.totalRecord}条记录，每页${pagebean.pageSize}条，共${pagebean.totalPage}页，当前为第${pagebean.currentPage}页  
	<br/>
	<a href = "/cusmang/QueryFindAll?currentpage=${pagebean.previousPage}">上一页</a>
	
		<c:forEach var="cp" items="${bar}">
			<a href = "/cusmang/QueryFindAll?currentpage=${cp}">${cp}</a>
		</c:forEach>
	
	<a href = "/cusmang/QueryFindAll?currentpage=${pagebean.nextPage}">下一页</a>
	
	

<br/><br/>
<a href="/cusmang/welcom.jsp">返回主页</a>
</div>
</body>
</html>