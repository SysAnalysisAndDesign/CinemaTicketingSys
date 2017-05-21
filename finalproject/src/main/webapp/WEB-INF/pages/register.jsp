<%--
  Created by IntelliJ IDEA.
  User: huitianrui
  Date: 2017/5/13
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-COMPATIBLE" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="/static/css/register.css">
    <link rel="stylesheet" href="/static/css/public.css">
    <!-- 可选的Bootstrap主题文件（一般不用引入） -->
    <link rel="stylesheet" href="/static/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/static/bootstrap/css/bootstrap-theme.css">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="/static/scripts/jquery-3.1.1.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="/static/bootstrap/js/bootstrap.min.js"></script>
    <title>用户注册</title>
</head>
<body>
<div class="container content">
    <div class="main">
        <form action="login.do" method="post" role="form">
            <span class="form-header">注册</span>
            <input type="text" name="username" class="form-control inputType" placeholder="用户名" required autofocus>

            <input type="text" name="phone_number" class="form-control inputType" placeholder="手机号">
            <input type="text" name="email" class="form-control inputType" placeholder="邮箱">
            <input type="password" name="password" class="form-control inputType" placeholder="密码" required>
            <input type="password" name="passwordConfirm" class="form-control inputType" placeholder="确认密码" required>
            <button class="btn btn-lg btn-primary btn-block" type="submit">注册</button>
        </form>
        <span class="reg">已有账号？<a href="login">点我登录</a></span>
    </div>

</div>

</body>
</html>
