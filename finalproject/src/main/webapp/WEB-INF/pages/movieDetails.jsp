<%--
  Created by IntelliJ IDEA.
  User: huitianrui
  Date: 2017/5/28
  Time: 13:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>影片详情</title>
    <script src="/static/scripts/jquery-3.1.1.min.js"></script>
</head>
<body>

<h2>影片详情</h2>
<p>${movie.cinema.cinemaName}</p>
<P>${movie.movieName}</P>
<p>${movie.description}</p>
<p>${movie.price}</p>

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
    $(document).ready(function(){
        $("#allMovieCuttings tr").click(function(){
            var url = "http://localhost:8080/cuttings/" + this.id;
            window.location.href = url;
        });
    });
</script>

</body>
</html>
