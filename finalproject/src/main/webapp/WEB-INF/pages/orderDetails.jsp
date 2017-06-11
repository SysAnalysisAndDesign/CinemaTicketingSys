<%@ page import="com.cinema_ticketing_sys.order.entity.Order" %><%--
  Created by IntelliJ IDEA.
  User: huitianrui
  Date: 2017/5/29
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>订单详情</title>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-COMPATIBLE" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="/static/css/public.css">
    <link rel="stylesheet" href="/static/css/orderDetails.css">
    <!-- 可选的Bootstrap主题文件（一般不用引入） -->
    <link rel="stylesheet" href="/static/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/static/bootstrap/css/bootstrap-theme.css">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="/static/scripts/jquery-3.1.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.2.0/js/tether.min.js"
            integrity="sha384-Plbmg8JY28KFelvJVai01l8WyZzrYWG825m+cZ0eDDS1f7d/js6ikvy1+X+guPIB"
            crossorigin="anonymous"></script>
    <script src="/static/scripts/jquery.twbsPagination.js" type="ztext/javascript"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="/static/bootstrap/js/bootstrap.min.js"></script>
    <script src="/static/scripts/jquery.twbsPagination.js"></script>
    <script src="/static/scripts/public.js"></script>
</head>
<body>

<!-- 导航栏 -->
<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="container">

        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/">小丑电影</a>
        </div>

        <div id="navbar" class="navbar-collapse collapse">

            <ul class="nav navbar-nav">
                <li class="active"><a href="/">首页</a></li>
                <li><a href="/movies?pageNo=1&pageSize=2">电影</a></li>
                <li><a href="/cinemas?pageNo=1&pageSize=2">影院</a></li>
            </ul>


            <ul class="nav navbar-nav navbar-right ">
                <c:choose>
                    <c:when test="${pageContext.request.userPrincipal.authenticated}">
                        <li><a id="user_index" href="#">${pageContext.request.userPrincipal.name}</a></li>
                        <li><a href="/j_spring_security_logout">logout</a></li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="/user/login">登录或注册</a></li>
                    </c:otherwise>
                </c:choose>

            </ul>
            <div>
                <form id="nav-search" class="navbar-form navbar-right" role="search">
                    <div class="form-group">
                        <input id="search_text" type="text" class="form-control">
                    </div>
                    <button id="search_btn" type="button" class="btn btn-default">Search</button>
                </form>
            </div>

        </div><!--/.nav-collapse -->
    </div>
</nav>

<div class="content">
    <div class="order-wrapper">
        <div class="order-info">
            <p>影院：${movie.cinema.cinemaName}<p/>

            <p>电影：${movie.movieName}<p/>

            <!-- 计算当前日期 -->
            <%
                java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

                java.util.Date currentTime = new java.util.Date(); // 得到当前系统时间

                String str_date1 = formatter.format(currentTime);  // 将日期时间格式化
                pageContext.setAttribute("date", str_date1.substring(0, 10));
            %>
            <p>日期：<%= str_date1 %><p/>
            |
            <c:forEach items="${seats}" var="seat">
                <tr>
                    <td align="center">${seat.row}排</td>
                    <td align="center">${seat.col}列</td>
                    <td align="center"> |</td>
                </tr>
            </c:forEach>

            <p>影票张数：${tickets}<p/>

            <p>影厅：${cutting.hallNumber}号厅<p/>

            <p>总价：${totalPrice}元<p/>

            <button id="pay">确认支付</button>

        </div>
    </div>

</div>
<div class="bottom">
    <p>本页面由Clown-Movie制作</p>
    <p>www.Clown-Movie.com.cn</p>
    <p>Clown-Movie版权所有</p>
</div>

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
