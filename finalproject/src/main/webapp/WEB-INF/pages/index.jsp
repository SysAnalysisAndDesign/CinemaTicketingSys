<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2017/5/11
  Time: 11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-COMPATIBLE" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="/static/css/public.css">
    <link rel="stylesheet" href="/static/css/index.css">
    <!-- 可选的Bootstrap主题文件（一般不用引入） -->
    <link rel="stylesheet" href="/static/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/static/bootstrap/css/bootstrap-theme.css">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="/static/scripts/jquery-3.1.1.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="/static/bootstrap/js/bootstrap.min.js"></script>
    <script src="/static/scripts/public.js"></script>

    <title>首页</title>

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
                <li><a href="/syllabus">个人中心</a></li>
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

<div id="myCarousel" class="carousel slide">
    <!-- 轮播（Carousel）指标 -->
    <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>
    <!-- 轮播（Carousel）项目 -->
    <div class="carousel-inner">
        <div class="item active">
            <img src="/static/images/13.jpg" alt="First slide" style="height: 300px; width: 100%">
        </div>
        <div class="item">
            <img src="/static/images/33.png" alt="Second slide" style="height: 300px; width: 100%">
        </div>
        <div class="item">
            <img src="/static/images/28.jpg" alt="Third slide" style="height: 300px; width: 100%">
        </div>
    </div>
    <!-- 轮播（Carousel）导航 -->
    <a class="carousel-control left" href="#myCarousel"
       data-slide="prev">&lsaquo;</a>
    <a class="carousel-control right" href="#myCarousel"
       data-slide="next">&rsaquo;</a>
</div>

<div class="popular-movies">
    <div class="container">
        <div class="heading">
            <h2>热门电影</h2>
        </div>

        <div class="info-movies">
            <div class="row">
                <div class="col-xs-6 col-sm-3 col-md-3">
                    <div class="movie-box box-grey">
                        <div class="inner">
                            <h5>加勒比海盗5</h5>
                            <div class="avatar">
                                <img src="/static/images/Caribbean5.jpeg">
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-xs-6 col-sm-3 col-md-3">
                    <div class="movie-box box-grey">
                        <div class="inner">
                            <h5>三只小猪</h5>
                            <div class="avatar">
                                <img src="/static/images/3pigs.jpeg">
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-xs-6 col-sm-3 col-md-3">
                    <div class="movie-box box-grey">
                        <div class="inner">
                            <h5>摔跤吧！爸爸</h5>
                            <div class="avatar">
                                <img src="/static/images/dangle.jpeg">
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-xs-6 col-sm-3 col-md-3">
                    <div class="movie-box box-grey">
                        <div class="inner">
                            <h5>寇荡风云</h5>
                            <div class="avatar">
                                <img src="/static/images/dkfy.jpeg">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>

<div class="bottom">
    <p>本页面由Clown-Movie制作</p>
    <p>www.Clown-Movie.com.cn</p>
    <p>Clown-Movie版权所有</p>
</div>

</body>
</html>