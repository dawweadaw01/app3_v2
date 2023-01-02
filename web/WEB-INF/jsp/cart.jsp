<%--
  Created by IntelliJ IDEA.
  User: 20698
  Date: 2022/12/1
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--自定义标签库--%>
<%@taglib prefix="myfunc" uri="http://cdu.zch/functions" %>
<html>
<head>
    <base href="http://${header.host}${pageContext.request.contextPath}/">
    <title>cart</title>
    <link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/5.2.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <h1>购物车</h1>
    <c:if test="${not empty sessionScope.customer}">
        ${sessionScope.customer.name}
        <a href="logout">退出</a>
        <a href="list">继续购物</a>
    </c:if>
    <br>
    <a href="cartClear">清空购物车</a>
    <br>
    <table class="table table-bordered">
        <tr>
            <th>序号</th>
            <th>图片</th>
            <th>商品名称</th>
            <th>原价</th>
            <th>折后价</th>
            <th>购买数量</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${sessionScope.productMap}" var="map" varStatus="s">
            <tr>
                <td>${map.key } </td>
                <td>
                    <img src="${map.value.imgUrl }" width="50" height="50" alt="">
                </td>
                <td>${map.value.name } </td>
                <td>${myfunc:currency(map.value.price) } </td>
                <td>${myfunc:currency(map.value.salePrice) }</td>
                <td>${sessionScope.productNumMap[map.key] } </td>
                <td><a href="cartOut?productId=${map.value.id }">删除</a></td>
            </tr>
        </c:forEach>
    </table>
    总价：${myfunc:currency(sessionScope.cartMoney) }<br>
    <a href="order.do">确定下单</a>
</div>
</body>
</html>
