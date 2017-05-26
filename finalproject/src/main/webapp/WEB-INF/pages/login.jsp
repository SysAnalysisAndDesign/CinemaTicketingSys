<%--
  Created by IntelliJ IDEA.
  User: huitianrui
  Date: 2017/5/13
  Time: 11:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<<<<<<< HEAD
    <title>用户登录</title>
</head>
<body>
<h1>自定义登录页面</h1>
<form action="login.do" method="post">
    <table>
        <tr>
            <td>用户名：</td>
            <td><input type="text" name="username"/></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type="password" name="password"/></td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="登录"/>
                <input type="reset" value="重置"/>
            </td>
        </tr>
    </table>
</form>

</body>
</html>
=======
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-COMPATIBLE" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 页面 CSS 文件 -->
    <link rel="stylesheet" href="/static/css/login.css">
    <link rel="stylesheet" href="/static/css/public.css">

    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="/static/bootstrap/css/bootstrap.min.css">
    <!-- 可选的Bootstrap主题文件（一般不用引入） -->
    <link rel="stylesheet" href="/static/bootstrap/css/bootstrap-theme.css">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="/static/scripts/jquery-3.1.1.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="/static/bootstrap/js/bootstrap.min.js"></script>

    <title>用户登录</title>
</head>
<body>
<div class="container content">
    <div class="main">
        <form action="login.do" method="post" role="form">
            <span class="form-header">登录</span>
            <input type="text" name="username" class="form-control inputType" placeholder="用户名" required autofocus>
            <input type="password" name="password" class="form-control inputType" placeholder="密码" required>
            <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
        </form>
        <span class="reg">还没有账号？<a href="register">快去注册</a></span>
    </div>

</div>


</body>
</html>
>>>>>>> origin/KC
