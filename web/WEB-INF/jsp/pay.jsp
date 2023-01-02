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
    <title>支付页面</title>
</head>
<body>
<div class="container">
    <h1>订单详情</h1>
    <hr>
    <c:if test="${not empty sessionScope.order}">
        订单编号：${sessionScope.order.orderId }<br>
        订单金额：${sessionScope.order.money }<br>
        收件人：${sessionScope.order.name}<br>
        收件人地址：${sessionScope.order.address }<br>
        收件人电话：${sessionScope.order.tel }<br>
        订单状态：${sessionScope.order.statusCode }<br>
        订单创建时间：${myfunc:formatDatetime(sessionScope.order.createTime)}
        <hr>
    </c:if>
    <c:if test="${sessionScope.order.statusCode==0}">
        <a href="pay?orderId=${sessionScope.order.orderId}">支付完成</a><br>
        <a href="orderCancel?orderId=${sessionScope.order.orderId}">取消订单</a><br>
    </c:if>
    <c:if test="${sessionScope.order.statusCode==1}">
        <a href="list">点我回到商品页面</a>
    </c:if>
</div>

</body>
</html>
