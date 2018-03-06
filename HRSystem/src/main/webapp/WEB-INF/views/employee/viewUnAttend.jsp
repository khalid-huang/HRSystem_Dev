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
<table width="80%" border="0" align="center" bgcolor="#cccccc">
    <tr bgcolor="#e1e1e1">
        <td colspan="4">
            <div class="mytitle">
                <span>当前用户<%=request.getSession().getAttribute("user")%></span>
            </div>
        </td>
    </tr>

</table>
</body>
</html>
