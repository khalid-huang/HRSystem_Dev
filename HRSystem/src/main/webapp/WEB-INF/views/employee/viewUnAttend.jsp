<%--
  Created by IntelliJ IDEA.
  User: kevin
  Date: 18-3-6
  Time: 下午5:19
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
        <tr bgcolor="#e1e1e1">
            <td colspan="4">您只能查看最近三天的非正常打卡，如有异议，请立即向经理申请</td>
        </tr>
        <tr class="pt11" height="45">
            <td width="29%"><b>打卡日期</b></td>
            <td width="20%"><b>异动名称</b></td>
            <td width="26%"><b>打卡时间</b></td>
            <td width="25%">&nbsp;</td>
        </tr>
        <c:forEach items="${requestScope.unAttends}" var="unAttend" varStatus="vs">
            <c:if test="${vs.index%2==0}">
                <tr style="background-color:#dddddd" class="pt11" height="32">
            </c:if>
            <c:if test="${vs.index%2 == 1}">
                <tr class="pt11" height="32">
            </c:if>
                    <td>${unAttend.getDutyDay()}</td>
                    <td>${unAttend.getUnType()}</td>
                    <td>${unAttend.getTime()}</td>
                    <td><a href="appChange?attId=${unAttend.getId()}">申请改变</a></td>
                </tr>
        </c:forEach>
    </table>
        </td>
    </tr>
</table>
<%@include file="../footer.jsp"%>
</body>
</html>
