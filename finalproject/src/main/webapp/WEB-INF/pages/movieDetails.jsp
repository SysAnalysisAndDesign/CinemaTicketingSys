<%--
  Created by IntelliJ IDEA.
  User: huitianrui
  Date: 2017/5/28
  Time: 13:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-COMPATIBLE" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="/static/css/public.css">
    <link rel="stylesheet" href="/static/css/movieDetails.css">
    <!-- 可选的Bootstrap主题文件（一般不用引入） -->
    <link rel="stylesheet" href="/static/bootstrap/css/bootstrap.min.css">
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
    <div class="detail-wrap">
        <div class="detail-cont">
            <h3 class="cont-title">${movie.movieName}</h3>
            <div class="float-cont">
                <div class="cont-img">
                    <img src="${movie.posterUrl}">
                </div>
                <ul class="cont-info">
                    <li>导演：</li>
                    <li>主演：</li>
                    <li>类型：</li>
                    <li>制片国家/地区：</li>
                    <li>语言：</li>
                    <li>片长：</li>
                    <li>简介：${movie.description},每一天梦想都延续着,心中总是满怀期待,站在这个熠熠生辉的舞台
                    ,看到了大家手中的荧光,我的声音 大家都好好地听到了吗</li>
                </ul>
            </div>

        </div>
    </div>
    <div class="head center-wrap">
        <h2>所有场次</h2>
    </div>
    <div class="session-wrap center-wrap">
        <table class="hall-table">
            <thead>
            <tr>
                <th class="hall-time">放映时间</th>
                <th class="hall-type">语言版本</th>
                <th class="hall-name">放映厅</th>
                <th class="hall-price">价格</th>
                <th class="hall-buy">选座购票</th>
            </tr>
            </thead>


        </table>
    </div>

    <div class="head center-wrap">
        <h2>影片评论</h2>
    </div>
</div>


<h2>所有场次</h2>
<table id="allMovieCuttings">
    <c:forEach items="${movie.movieCuttings}" var="cutting">
        <tr id="${cutting.movieCuttingId}">
            <td align="center">${cutting.startDate}</td>
            <td align="center">${cutting.startTime}</td>
            <td align="center">${cutting.length}分钟</td>
            <td align="center">${cutting.hallNumber}号厅</td>
        </tr>
    </c:forEach>
</table>

<h2>影片评论</h2>
<table id="allComments">
    <c:forEach items="${movie.comments}" var="comment">
        <tr id="${comment.commentId}">
            <td align="center">${comment.user.userName}</td>
            <td align="center">${comment.rate}分</td>
            <td align="center">${comment.content}</td>
            <td align="center">${comment.date}</td>
        </tr>
    </c:forEach>
</table>

<script type="text/javascript">
    $(document).ready(function () {
        $("#allMovieCuttings tr").click(function () {
            var url = "http://localhost:8080/cuttings/" + this.id;
            window.location.href = url;
        });
    });
</script>

</body>
</html>
