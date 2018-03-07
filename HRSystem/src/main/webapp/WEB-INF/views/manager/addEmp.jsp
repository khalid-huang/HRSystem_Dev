<%--
  Created by IntelliJ IDEA.
  User: kevin
  Date: 18-3-7
  Time: 下午7:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
    <title>增加新员工</title>
</head>
<body>
<%@include file="../header.jsp"%>
<%@include file="mgrheader.jsp"%>
<table width="960" align="center" background="${pageContext.request.contextPath}/resources/images/bodybg.jpg">
    <tr>
        <td>请输入新员工的资料：</td>
        <div align="center">
            <form action="processAddEmploee"></form>
            <label for="name">员工用户名</label>
            <input type="text" id="name" name="emp.name">
            <br>
            <label for="password">员工密码</label>
            <input type="text" id="password" name="emp.pass">
            <br>
            <label for="salary">员工月薪</label>
            <input type="text" id="salary" name="emp.salary">
            <input type="submit" value="添加新员工">
            <input type="reset" value="重新输入">
            </td>
        </div>
    </tr>
</table>
<%@include file="../footer.jsp"%>
</body>
</html>
