<%--
  Created by IntelliJ IDEA.
  User: codingBoy
  Date: 16/10/23
  Time: 下午12:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2 align="center">添加客户</h2>

<form action="/cusmang/addCheck" method="get">
    <input type="hidden" name="method" value="add">
    <div align="center">

    <table border="0" align="center" >
    <tr>
            <td width="100px">客户ID</td>
            <td width="40%">
                <input type="text" name="id"/>
                <span class="message">${requestScope.check.Id }</span>
            </td>
            <td align="left">
                <label id="idError" class="error">&nbsp;</label>
            </td>
        </tr>
        <tr>
            <td width="100px">客户名称</td>
            <td width="40%">
                <input type="text" name="name"/>
                <span class="message">${requestScope.check.Name }</span>
            </td>
            <td align="left">
                <label id="nameError" class="error">&nbsp;</label>
            </td>
        </tr>
        <tr>
            <td>客户性别</td>
            <td>
                <input type="radio" name="gender" value="male" id="male"/>
                <label for="male">男</label>
                <input type="radio" name="gender" value="female" id="female"/>
                <label for="female">女</label>
            </td>
            <td>
                <label id="genderError" class="error">&nbsp;</label>
            </td>
        </tr>
        <tr>
            <td>手机</td>
            <td>
                <input type="text" name="phone" id="phone"/>
                <span class="message">${requestScope.check.phone }</span>
            </td>
            <td>
                <label id="phoneError" class="error">&nbsp;</label>
            </td>
        </tr>
        <tr>
            <td>邮箱</td>
            <td>
                <input type="text" name="email" id="email"/>
                <span class="message">${requestScope.check.email }</span>
                
            </td>
            <td>
                <label id="emailError" class="error">&nbsp;</label>
            </td>
        </tr>
        <tr>
            <td>描述</td>
            <td>
                <textarea rows="5" cols="30" name="description"></textarea>
            </td>
            <td>
                <label id="descriptionError" class="error">&nbsp;</label>
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <input type="submit" name="submit"/>
                <input type="reset" name="reset"/>
            </td>
        </tr>
    </table>
    <br/>
	<br/>
	<br/>
    <a href="/cusmang/welcom.jsp">返回主页</a>
    </div>
</form>

</body>
</html>
