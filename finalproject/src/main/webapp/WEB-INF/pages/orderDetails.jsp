<%@ page import="com.cinema_ticketing_sys.order.entity.Order" %><%--
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
    <script src="/static/scripts/jquery-3.1.1.min.js"></script>
</head>
<body>

影院：${movie.cinema.cinemaName}<br/>

电影：${movie.movieName}<br/>

<!-- 计算当前日期 -->
<%
    java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    java.util.Date currentTime = new java.util.Date(); // 得到当前系统时间

    String str_date1 = formatter.format(currentTime);  // 将日期时间格式化
    pageContext.setAttribute("date", str_date1.substring(0,10));
%>
日期：<%= str_date1 %>

<c:forEach items="${seats}" var="seat">
    <tr>
        <td align="center">${seat.row}排</td>
        <td align="center">${seat.col}列</td>
        <td align="center"> | </td>
    </tr>
</c:forEach>

影票张数：${tickets}<br/>

影厅：${cutting.hallNumber}号厅

总价：${totalPrice}元<br/>

<button id="pay">确认支付</button>

<!-- 支付按钮点击事件
     将各种数据包装在对象里
     用json传给后台
 -->
<script type="text/javascript">
    $(document).ready(function() {
        $("#pay").click(function() {
            var newOrder = new Object();
            newOrder.cinemaName = "${movie.cinema.cinemaName}";
            newOrder.movieName = "${movie.movieName}";
            newOrder.date = "${date}";
            newOrder.hallNumber = "${cutting.hallNumber}";
            newOrder.totalPrice = "${totalPrice}";
            var orderArray = [];
            orderArray.push(newOrder);
            $.ajax(
                {
                    async: "false",
                    type:'post',
                    url: "http://localhost:8080/order.do",
                    data: { newOrder: JSON.stringify(orderArray) },
                    dataType: "json"
                }
            );
            window.location.href = "http://localhost:8080/";
        });
    });
</script>

</body>
</html>
