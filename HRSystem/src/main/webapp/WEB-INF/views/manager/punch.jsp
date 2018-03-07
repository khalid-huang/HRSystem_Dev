<%--
  Created by IntelliJ IDEA.
  User: kevin
  Date: 18-3-6
  Time: 下午5:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <title>电子打卡</title>
</head>
<body>
<%@include file="../header.jsp"%>
<%@include file="mgrheader.jsp"%>

<table width="960" align="center" background="${pageContext.request.contextPath}/resources/images/bodybg.jpg">
    <tr>
        <td colspan="3"><br/><br/>
            <div class="mytitle">电子打卡系统</div>
        </td>
    </tr>
    <tr>
        <td colspan="3" style="text-align : center;">
            <br/>
            <!-- 当PunchIsValid为1或3时，可上班打卡-->
            <c:if test="${punchIsValid==1 || punchIsValid==3}">
                <form action="employeeCome">
                    <input type="=submit" value="上班打卡">
                </form>
            </c:if>
            <!-- 当punchIsValid为2或3时可下班打卡 -->
            <c:if test="${punchIsValid==2 || punchIsValid==3}">
                <form action="employeeLeave">
                    <input type="submit" value="下班打卡">
                </form>
            </c:if>
        </td>
    </tr>
</table>
<%@include file="../footer.jsp"%>
</body>
</html>
