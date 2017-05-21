<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2017/5/11
  Time: 11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-COMPATIBLE" content="IE=edge"> <!-- 看到IE我就怕 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>CSC</title>
    <!-- 文档中有提到css 我就不搞了 -->
</head>
<body>
<c:choose>
    <c:when test="${pageContext.request.userPrincipal.authenticated}">
        <h1>Hello, ${pageContext.request.userPrincipal.name}</h1>
        <br>
        手机号：<%= pageContext.getRequest().getAttribute("phone_number")%>
        <br>
        邮箱：<%= pageContext.getRequest().getAttribute("email")%>

    </c:when>
    <c:otherwise>
        <h1>Hello, please login</h1>
    </c:otherwise>
</c:choose>

</body>
</html>
