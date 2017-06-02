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
    <title>影院详情</title>
    <script src="/static/scripts/jquery-3.1.1.min.js"></script>
</head>
<body>
<h2>影院详情</h2>
<p>${cinema.cinemaName}</p>
<p>${cinema.address}</p>
<p>${cinema.description}</p>

<h2>所有影片</h2>
<table id="allMovies">
    <c:forEach items="${cinema.movies}" var="movie">
        <tr id="${movie.movieId}">
            <td align="center">${movie.movieName}</td>
            <td align="center">${movie.description}</td>
            <td align="center">${movie.price}</td>
        </tr>
    </c:forEach>
</table>

<script type="text/javascript">
    $(document).ready(function(){
        $("table tr").click(function(){
            var url = "http://localhost:8080/movies/" + this.id;
            window.location.href = url;
        });
    });
</script>

</body>
</html>
