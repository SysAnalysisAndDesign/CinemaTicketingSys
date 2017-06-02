<%--
  Created by IntelliJ IDEA.
  User: huitianrui
  Date: 2017/5/30
  Time: 16:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>放映影院</title>
    <script src="/static/scripts/jquery-3.1.1.min.js"></script>
</head>
<body>

<table id="movieCinemas">
    放映该影片的影院：
    <tr id="${movie.cinema.cinemaId}">
        <td align="center">${movie.cinema.cinemaName}</td>
        <td align="center">${movie.cinema.address}</td>
        <td align="center">${movie.cinema.description}</td>
    </tr>
</table>

<script>
    $(document).ready(function() {
        $("#movieCinemas").click(function() {
            var url = "http://localhost:8080/movies/" + ${movie.movieId};
            window.location.href = url;
        });
    });
</script>

</body>
</html>
