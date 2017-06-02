<%--
  Created by IntelliJ IDEA.
  User: huitianrui
  Date: 2017/5/28
  Time: 12:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-COMPATIBLE" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="/static/css/public.css">
    <link rel="stylesheet" href="/static/css/cinemaDetails.css">
    <!-- 可选的Bootstrap主题文件（一般不用引入） -->
    <link rel="stylesheet" href="/static/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/static/bootstrap/css/bootstrap-theme.css">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="/static/scripts/jquery-3.1.1.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="/static/bootstrap/js/bootstrap.min.js"></script>
    <script src="/static/scripts/public.js"></script>
    <title>影院详情</title>
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


<div class="information-wrapper">
    <div class="center-wrap">
        <h4 class="cinema-name">${cinema.cinemaName}</h4>
        <div class="info">
            <img class="cinema-img" src="/static/images/cinema.jpg">
            <ul class="info-list">
                <li>详细地址：${cinema.address}</li>
                <li>简介：${cinema.description}</li>
                <li>评分：${cinema.rate}</li>
            </ul>
        </div>
    </div>
</div>

<div class="center-wrap movie-head">
    <h2 class="movie-title">所有影片</h2>
</div>

<div class="center-wrap">
    <c:forEach items="${cinema.movies}" var="movie">
        <div class="movie-wrapper">
            <img class="movie-img" src="${movie.posterUrl}">
            <div class="movie-info-wrap">
                <h4 class="movie-name"><a href="/movies/${movie.movieId}">${movie.movieName}</a></h4>
                <div class="movie-info">
                    <ul>
                        <li>简介：${movie.description}</li>
                        <li>价格：${movie.price}</li>
                    </ul>
                </div>
            </div>
        </div>
    </c:forEach>
</div>

<div class="bottom">
    <p>本页面由Clown-Movie制作</p>
    <p>www.Clown-Movie.com.cn</p>
    <p>Clown-Movie版权所有</p>
</div>

</body>
</html>
