<%--
  Created by IntelliJ IDEA.
  User: huitianrui
  Date: 2017/5/29
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>订单详情</title>
</head>
<body>

影院：${movie.cinema.cinemaName}<br/>
电影：${movie.movieName}<br/>
<c:forEach items="${seats}" var="seat">
    <tr>
        <td align="center">${seat.row}排</td>
        <td align="center">${seat.col}列</td>
        <td align="center"> | </td>
    </tr>
</c:forEach>
影票张数：${tickets}<br/>
总价：${totalPrice}<br/>
<button id="pay">确认支付</button>
</body>
</html>
