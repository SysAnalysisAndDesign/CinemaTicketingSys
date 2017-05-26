<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2017/5/11
  Time: 11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<<<<<<< HEAD
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>

=======
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
>>>>>>> origin/develop
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-COMPATIBLE" content="IE=edge"> <!-- 看到IE我就怕 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
<<<<<<< HEAD
        <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="/static/css/public.css">
    <!-- 可选的Bootstrap主题文件（一般不用引入） -->
    <link rel="stylesheet" href="/static/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/static/bootstrap/css/bootstrap-theme.css">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="/static/scripts/jquery-3.1.1.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="/static/bootstrap/js/bootstrap.min.js"></script>

    <title>首页</title>

    <script>
        <sec:authentication property="name" var="username" scope="page"/>
        <c:if test="${pageScope.username == 'anonymousUser'}">
        <c:remove var="username" scope="page"/>
        </c:if>

        <c:if test="${!empty pageScope.username}">
        <sec:authentication property="principal" var="authentication" scope="page"/>
        <c:set var="uid" value="${authentication.id}" scope="page"/>
        </c:if>

    </script>

    <style>

        .row {
            margin: 0 1%;
        }

        .row .col-lg-4 {
            width:250px;
            height:250px;
            overflow: hidden;
        }

        .row .col-lg-4 .intro {
            text-overflow: ellipsis;
        }

        .row .col-lg-4 p {
            margin: 0 auto 100px auto;
        }

        .row .col-lg-4 .btn {
            position: absolute;
            bottom: -1px;
            right: 33%;
        }

        #nav-search {
            margin-right: 50px;
        }

        #search_text {
            width: 200px;
        }

        .contact-container {
            background-color: white;
        }

        .bottom{
            background-color: #0f0f0f;
            color: #f5f5f5;
        }

        .contact-h2{
            font-size: 18px;
        }

        .bottom {
            font-size: 10px;
            padding-top: 20px;
            padding-bottom: 20px;
            text-align: center;
        }
        .bottom p {
            padding: 0;
            margin: 0;
        }
    </style>
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
                <li><a href="/knowledgeBase">电影</a></li>
                <li><a href="/course">影院</a></li>
                <li><a href="/syllabus">个人中心</a></li>
            </ul>


            <ul class="nav navbar-nav navbar-right ">
                <c:if test="${empty pageScope.username}">
                    <li><a href="/user/login">登录或注册</a></li>
                </c:if>

                <c:if test="${!empty pageScope.username}">
                    <li><a id="user_index" href="#">${pageScope.username}</a></li>
                    <li><a id="user_settings" href="#">settings</a></li>
                    <li><a href="/j_spring_security_logout">logout</a></li>
                </c:if>
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


<!-- Example row of columns -->
<div class="container course-container">
    <div class="row">
        <h2>热门电影</h2>
    </div>
</div>

<div class="contact-container">
    <div class="row">
        <h2 class="contact-h2">联系方式</h2>
    </div>
    <div class="row">
        <p>  联系邮箱：xiaochou@163.com.cn    客服热线：020-88888888    客服QQ：500000000</p>
    </div>
    <div class="row">
        <p>  联系地址：广州市大学城中山大学</p>
    </div>
</div>
<div class="bottom">
    <p>本页面由Clown-Movie制作</p>
    <p>www.Clown-Movie.com.cn</p>
    <p>Clown-Movie版权所有</p>
</div>
=======
    <title>CSC</title>
    <!-- 文档中有提到css 我就不搞了 -->
</head>
<body>
<c:choose>
    <c:when test="${pageContext.request.userPrincipal.authenticated}">
        <h1>Hello, ${pageContext.request.userPrincipal.name}</h1>
    </c:when>
    <c:otherwise>
        <h1>Hello, please login</h1>
    </c:otherwise>
</c:choose>
>>>>>>> origin/develop

</body>
</html>
