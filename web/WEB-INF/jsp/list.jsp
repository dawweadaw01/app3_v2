<%--
  Created by IntelliJ IDEA.
  User: 20698
  Date: 2022/12/1
  Time: 14:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--自定义标签库--%>
<%@taglib prefix="myfunc" uri="http://cdu.zch/functions" %>
<html>
<head>
    <base href="http://${header.host}${pageContext.request.contextPath}/">
    <title>Title</title>
    <link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/5.2.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <h1>商品列表</h1>
    <%--当能取到session的name值时，就显示后面的，不能的话就显示前面的--%>
    <c:if test="${empty sessionScope.customer}">
        <a href="login.do">去登录</a> / <a href="register.do">注册</a><br>
    </c:if>

    <c:if test="${not empty sessionScope.customer}">
        ${sessionScope.customer.name}
        <a href="cart">查看购物车</a>
        <a href="logout">退出</a>
    </c:if>

    <table class="table table-bordered">
        <tr>
            <th>id</th>
            <th>图片</th>
            <th>商品名称</th>
            <th>价格</th>
            <th>折扣</th>
            <th>库存</th>
            <th>上架时间</th>
            <th>加入购物车</th>
        </tr>
        <c:forEach var="pro" items="${requestScope.productList}">
            <tr>
                <td>${pro.id}</td>
                <td>
                    <img src="${pro.imgUrl}" alt="" width="100px" class="img-rounded">
                </td>
                <td>${pro.name}</td>
                <td>${myfunc: currency(pro.price)}</td>
                    <%--                <td>${pro.price}</td>--%>
                <td>${pro.sale}%</td>
                <td>${pro.stock}</td>
                <td>${myfunc: formatDate(pro.marketDate)}</td>
                    <%--                <td>${pro.marketDate}</td>--%>
                <td>
                    <a href="cartIn?productId=${pro.id}">加入购物车</a>
                </td>
            </tr>
        </c:forEach>

        <tr style="text-align: center">
            <td colspan="8">
                <a href="list?currentPage=1">首页</a>
                <c:if test="${requestScope.pageInfos.currentPage > 1}">
                    <a href="list?currentPage=${requestScope.pageInfos.currentPage - 1}">上一页</a>
                </c:if>
                当前页 ${requestScope.pageInfos.currentPage} | ${requestScope.pageInfos.pageNum} 总页数
                <c:if test="${requestScope.pageInfos.currentPage < requestScope.pageInfos.pageNum}">
                    <a href="list?currentPage=${requestScope.pageInfos.currentPage + 1}">下一页</a>
                </c:if>
                <a href="list?currentPage=${requestScope.pageInfos.pageNum}">末页</a>
            </td>
        </tr>
    </table>
</div>


</body>
</html>
