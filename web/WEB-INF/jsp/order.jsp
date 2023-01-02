<%--
  Created by IntelliJ IDEA.
  User: 20698
  Date: 2022/11/22
  Time: 20:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--自定义标签库--%>
<%@taglib prefix="myfunc" uri="http://cdu.zch/functions" %>
<html>
<head>
    <title>下单页面</title>
    <link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/5.2.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <h1>确认订单</h1>
    <c:if test="${not empty sessionScope.customer}">
        ${sessionScope.customer.name}
        <a href="logout">退出</a>
        <a href="list">取消订单，继续购物</a>
    </c:if>
    <br>
    <table class="table table-bordered">
        <tr>
            <th>序号</th>
            <th>图片</th>
            <th>商品名称</th>
            <th>原价</th>
            <th>折后价</th>
            <th>购买数量</th>
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
            </tr>
        </c:forEach>
        <tr style="text-align: center">
            <td colspan="8">总价：${myfunc:currency(sessionScope.cartMoney) }</td>
        </tr>
    </table>

    <div class="info">
        <form action="order" method="post">
            <label for="name">收货人：</label>
            <input type="text" name="name" id="name" class="form-control"><br>
            <label for="tel">收货人电话：</label>
            <input type="text" name="tel" id="tel" class="form-control"><br>
            <label for="address">收货地址：</label>
            <input type="text" name="address" id="address" class="form-control"><br>
            <input type="submit" class="btn btn-default" value="提交订单准备支付"/>
        </form>

    </div>
</div>
</body>
</html>
