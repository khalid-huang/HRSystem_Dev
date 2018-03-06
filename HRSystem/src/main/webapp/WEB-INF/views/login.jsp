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
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>登录系统</title>
</head>

<body>
    <%@include file="header.jsp"%>
    <table width="960" align="center"
           background="${pageContext.request.contextPath}/resources/images/bodybg.jpg">
        <tr>
            <td>
                请输入用户名和密码来登录<br />
                <c:if test="${error.length() > 0}">
                    <div class="error">
                            <c:out value="${error}"></c:out>
                    </div>
                </c:if>
                <div class="center">
                    <%--测试一下这个的话是怎么调用的，普通的form的action是调用什么的--%>
                    <%--经过下面的这种也是可以的，跟form没有本质区别，可能主要是在数据绑定上的区别吧--%>
                    <%--<form action="processLogin" method="POST">--%>
                        <%--用户名： <input type="text" name="name">--%>
                        <%--<br />--%>
                        <%--密码：<input type="password" name="password">--%>
                        <%--<input type="submit" value="提交">--%>
                    <%--</form>--%>
                    <form:form method="POST" action="processLogin" modelAttribute="employee">
                        <table>
                            <tr>
                                <td><form:label path="name">Name</form:label></td>
                                <td><form:input path="name"/></td>
                            </tr>
                            <tr>
                                <td><form:label path="password">Password</form:label></td>
                                <td><form:password path="password"/></td>
                            </tr>
                            <tr>
                                <td><input type="submit" value="登录"></td>
                                <td><input type="reset" value="重填"></td>
                            </tr>
                        </table>
                    </form:form>
                </div>
            </td>
        </tr>
    </table>
<%@include file="footer.jsp"%>

</body>
</html>