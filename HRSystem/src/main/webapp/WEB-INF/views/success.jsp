<%--
  Created by IntelliJ IDEA.
  User: kevin
  Date: 18-3-4
  Time: 上午11:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    success
    <div>
        <c:if test="${message.length()>0}">
            <c:out value="${message}"></c:out>
        </c:if>
        Next:
        ${requestScope.message}<br/>
        <%=request.getSession().getAttribute("user")%>
    </div>
</body>
</html>
