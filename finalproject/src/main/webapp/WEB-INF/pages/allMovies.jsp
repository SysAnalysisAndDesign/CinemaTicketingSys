<%--
  Created by IntelliJ IDEA.
  User: huitianrui
  Date: 2017/5/30
  Time: 14:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>所有电影</title>
    <link rel="stylesheet" href="/static/css/public.css">
    <link rel="stylesheet" href="/static/css/allMovies.css">
    <!-- 可选的Bootstrap主题文件（一般不用引入） -->
    <link rel="stylesheet" href="/static/bootstrap/css/bootstrap.min.css">
    <script src="/static/scripts/jquery-3.1.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.2.0/js/tether.min.js"
            integrity="sha384-Plbmg8JY28KFelvJVai01l8WyZzrYWG825m+cZ0eDDS1f7d/js6ikvy1+X+guPIB"
            crossorigin="anonymous"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="/static/bootstrap/js/bootstrap.min.js"></script>
    <script src="/static/scripts/jquery.twbsPagination.js" type="text/javascript"></script>
</head>

<body>

<script>
    <%-- 导航栏 --%>
    $(document).ready(function () {
        $("#user_index").attr("href", "/user/index?username=" + '${username}');
        $("#user_settings").attr("href", "/user/settings?username=" + '${username}');
    });
</script>
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
                        <li><a href="/index">${pageContext.request.userPrincipal.name}</a></li>
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

<script>
    <%-- 搜索框 --%>
    $(document).ready(function () {
        $("#search_btn").click(function () {
            var search_text = $("#search_text").val();
            window.location.href = "/search?vague_name=" + search_text;
        });
        $("#search_text").keydown(function (e) {
            if (e.keyCode == 13) {
                var search_text = $(this).val();
                window.location.href = "/search?vague_name=" + search_text;
            }
        });
    });
</script>

<div class="search-box">
    <form class="searchCinema-form">
        <input class="kw" type="text" maxlength="32" name="kw" placeholder="查找电影" autocomplete="off">
        <button class="submit" type="submit"></button>
    </form>
</div>

<!-- TODO 修改class名字 css等 -->
<div class="container">
    <div class="container-movie">
        <ul class="movie-list">
            <c:forEach items="${moviePage.list}" var="movie">
                <li id="${movie.movieId}">
                    <div  class="item movie-poster">
                        <span><img src="${movie.posterUrl}" width="120px" height="165px"/></span>
                    </div>
                    <div  class="item movie-name">
                        <span>${movie.movieName}</span>
                    </div>
                    <div  class="item movie-description">
                        <span>${movie.description}</span>
                    </div>
                </li>
            </c:forEach>
        </ul>

        <div class="pager2">
            <nav aria-label="Page navigation">
                <ul class="pagination" id="pagination"></ul>
            </nav>
        </div>
    </div>
</div>

<script type="text/javascript">
    $(function () {
        $('#pagination').twbsPagination({
            totalPages: ${moviePage.totalPage},
            visiblePages: 5,
            first: "首页",
            prev: "上一页",
            next: "下一页",
            last: "末页",
            initiateStartPageClick: false,
            startPage: ${moviePage.currPage},
            onPageClick: function (event, page) {
                window.location.href="http://localhost:8080/movies?pageNo=" + page + "&pageSize=2";
            }
        });
    });
</script>

<div class="bottom">
    <p>本页面由Clown-Movie制作</p>
    <p>www.Clown-Movie.com.cn</p>
    <p>Clown-Movie版权所有</p>
</div>

<script type="text/javascript">
    $(function () {
        $('#pagination').twbsPagination({
            totalPages: ${cinemaPage.totalPage},
            visiblePages: 5,
            first: "首页",
            prev: "上一页",
            next: "下一页",
            last: "末页",
            initiateStartPageClick: false,
            startPage: ${cinemaPage.currPage},
            onPageClick: function (event, page) {
                window.location.href = "http://localhost:8080/cinemas?pageNo=" + page + "&pageSize=2";
            }
        });
    });
</script>

<script type="text/javascript">
    $(document).ready(function(){
        $("ul li").click(function(){
            var url = "http://localhost:8080/movies/" + this.id + "/cinemas";
            window.location.href = url;
        });
    });
</script>

</body>
</html>