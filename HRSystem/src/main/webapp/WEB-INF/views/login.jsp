<%--
  Created by IntelliJ IDEA.
  User: kevin
  Date: 18-3-3
  Time: 下午5:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=gb2312">
    <title>登录系统</title>
</head>

<body>
    <%@include file="header.jsp"%>
    <table width="960" align="center"
           background="${pageContext.request.contextPath}/images/bodybg.jpg">
        <tr>
            <td>
                请输入用户名和密码来登录<br />
        <c:if test="${message.size() > 0}">
</body>
</html>