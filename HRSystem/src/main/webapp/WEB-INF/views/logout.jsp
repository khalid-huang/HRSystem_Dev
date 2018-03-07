<%--
  Created by IntelliJ IDEA.
  User: kevin
  Date: 18-3-7
  Time: 下午7:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>系统登出</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
<%@include file="header.jsp"%>
<table width="960" border="0" align="center"
       background="${pageContext.request.contextPath}/resources/images/bodybg.jpg">
    <tr>
        <td height="264"><div align="center"><font color="#336666" size="3"><b>您已经成功地登出系统，欢迎下次光临</b></font></div></td>
    </tr>
</table>
<%@include file="footer.jsp"%>
</body>
</html>
