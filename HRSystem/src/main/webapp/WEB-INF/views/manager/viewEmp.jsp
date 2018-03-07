<%--
  Created by IntelliJ IDEA.
  User: kevin
  Date: 18-3-7
  Time: 下午5:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>查看本部门全部员工</title>
</head>
<body>
<%@include file="../header.jsp"%>
<%@include file="mgrheader.jsp"%>
<table width="960" align="center" background="${pageContext.request.contextPath}/resources/images/bodybg.jpg">
    <tr>
        <td>
            <br>
            <table width="80%" border="0" align="center" bgcolor="#cccccc">
                <tr bgcolor="#e1e1e1">
                    <td colspan="5">
                        <div class="mytitle">处理申请</div>
                    </td>
                </tr>
                <tr class="pt11" height="45">
                    <td><b>员工名</b></td>
                    <td><b>密码</b></td>
                    <td><b>工资</b></td>
                </tr>
                <c:forEach items="emps" var="emp" varStatus="vs">
                <c:if test="vs.index%2==0">
                <tr style="background-color: #cccccc" class="pt11" height="32">
                    </c:if>
                    <c:if test="vs.index%2==1">
                <tr class="pt11" height32>
                    </c:if>
                    <td>${emp.empName}</td>
                    <td>${emp.empPass}</td>
                    <td>${emp.amount}</td>
                    </c:forEach>
            </table>
        </td>
    </tr>
</table>
<%@include file="../footer.jsp"%>
</body>
</html>
