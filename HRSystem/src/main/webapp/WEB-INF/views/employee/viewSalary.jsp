<%--
  Created by IntelliJ IDEA.
  User: kevin
  Date: 18-3-7
  Time: 上午10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <title>查看自己的非正常出勤</title>
</head>
<body>
<%@include file="../header.jsp"%>
<%@include file="empheader.jsp"%>
<table width="960" align="center"
       background="${pageContext.request.contextPath}/resources/images/bodybg.jpg">
    <tr>
        <td>
    <table width="80%" border="0" align="center" bgcolor="#cccccc">
        <tr bgcolor="#e1e1e1">
            <td colspan="4">
                <div class="mytitle">
                    <span>当前用户<%=request.getSession().getAttribute("user")%></span>
                </div>
            </td>
        </tr>
        <tr class="pt11" height="45">
            <td><b>发薪月份</b></td>
            <td><b>薪水</b></td>
        </tr>
        <c:forEach items="salarys" var="salary" varStatus="vs">
            <c:if test="${vs.index%2==0}">
                <tr style="background-color:#dddddd" class="pt11" height="32">
            </c:if>
            <c:if test="${vs.index%2 == 1}">
                <tr class="pt11" height="32">
            </c:if>
                    <td>${salary.payMonth}</td>
                    <td>${salary.amount}</td>
                </tr>
        </c:forEach>
    </table>
        </td>
    </tr>
</table>
<%@include file="../footer.jsp"%>
</body>
</html>
