<%--
  Created by IntelliJ IDEA.
  User: huitianrui
  Date: 2017/5/23
  Time: 23:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>所有影院</title>
</head>
<body>

<!-- 最下面显示跳转页面 -->
<!-- ${cinemaPage.totalCount }总的记录条数  其他的类似，与Page.java相关联 -->

<c:forEach items="${cinemaPage.list}" var="cinema">
    <tr>
        <td align="center">${cinema.cinemaName}</td>
        <td align="center">${cinema.address}</td>
        <td align="center">${cinema.description}</td>
        <td align="center">${cinema.rate}</td>
    </tr>
    <br/>
</c:forEach>

<div>

    共 <i class="blue">${cinemaPage.totalCount }</i>
    条记录，当前显示第 <i class="blue">${cinemaPage.currPage }
</i> 页 / 共 <i class="blue">${cinemaPage.totalPage }</i> 页
    跳转
    <input type="text" class="scinput"
           style="width: 40px;height: 20px" id="currPage2" onblur="page2()"
           onkeyup="this.value=this.value.replace(/\D/g,'')"
           onafterpaste="this.value=this.value.replace(/\D/g,'')" />  页

    <!-- 首页按钮，跳转到首页 -->
    <p>  <c:if test="${cinemaPage.currPage <= 1 }"></c:if>
        <a href="javascript:;" <c:if test="${cinemaPage.currPage > 1 }">onclick="page1(1)"</c:if> >首页</a>


        <!-- 上页按钮，跳转到上一页 -->
        <c:if test="${cinemaPage.currPage <= 1 }"></c:if>
        <a href="javascript:;" <c:if test="${cinemaPage.currPage > 1 }">onclick="page1('${cinemaPage.currPage - 1}')"</c:if> >上页</a>

        <!-- 下页按钮，跳转到下一页 -->
        <c:if test="${cinemaPage.currPage >= cinemaPage.totalPage }"></c:if>
        <a href="javascript:;" <c:if test="${cinemaPage.currPage < cinemaPage.totalPage }">onclick="page1('${cinemaPage.currPage + 1}')"</c:if> >下页</a>

        <!-- 末页按钮，跳转到最后一页 -->
        <c:if test="${cinemaPage.currPage >= cinemaPage.totalPage }"></c:if>
        <a href="javascript:;" <c:if test="${cinemaPage.currPage < cinemaPage.totalPage }">onclick="page1('${cinemaPage.totalPage}')"</c:if> >末页</a>
    </p>
</div>

</body>
</html>
