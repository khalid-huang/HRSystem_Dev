<%--
  Created by IntelliJ IDEA.
  User: kevin
  Date: 18-3-6
  Time: 下午4:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>员工首页</title>
</head>
<body>
    <%@include file="../header.jsp"%>
    <%@include file="empheader.jsp"%>
    <table width="960" align="center" background="${pageContext.request.contextPath}/resources/images/bodybg.jpg">
        <tr height="60">
            <td>&nbsp;</td>
        </tr>
        <tr>
            <td>
                <c:if test="${message.length()>0}">
                    <div class="error">
                        <c:out value="${message}"></c:out>
                    </div>
                </c:if>
            </td>
        </tr>
        <tr height="80">
            <td>&nbsp;</td>
        </tr>
        <tr>
            <td><%=request.getSession().getAttribute("user")%>
                ，欢迎您使用JavaEE简单工作流系统，您是普通员工</td>
        </tr>
        <tr height="60">
            <td>&nbsp;</td>
        </tr>
    </table>
<%@include file="../footer.jsp"%>
</body>
</html>
