<%--
  Created by IntelliJ IDEA.
  User: 20698
  Date: 2022/11/21
  Time: 21:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <base href="http://${header.host}${pageContext.request.contextPath}/customer/"/>
    <title>顾客管理</title>
    <link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/5.2.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <a href="javascript:void(0);">添加用户</a><br><br>
    <table class="table table-bordered">
        <tr>
            <th>id</th>
            <th>用户名</th>
            <th>密码</th>
            <th>是否是VIP</th>
            <th>操作</th>
        </tr>
        <c:forEach var="cus" items="${requestScope.customerList}">
            <tr>
                <td>${cus.id}</td>
                <td>${cus.name}</td>
                <td>${cus.password}</td>
                <td>${cus.isVip}</td>
                <td>
                    <a href="javascript:void(0);">修改</a>
                    <a href="javascript:void(0);">删除</a>
                </td>
            </tr>
        </c:forEach>

        <tr style="text-align: center">
            <td colspan="8">
                <a href="list?currentPage=1">首页</a>
                <c:if test="${requestScope.pageInfo.currentPage > 1}">
                    <a href="list?currentPage=${requestScope.pageInfo.currentPage - 1}">上一页</a>
                </c:if>
                当前页 ${requestScope.pageInfo.currentPage} | ${requestScope.pageInfo.pageNum} 总页数
                <c:if test="${requestScope.pageInfo.currentPage < requestScope.pageInfo.pageNum}">
                    <a href="list?currentPage=${requestScope.pageInfo.currentPage + 1}">下一页</a>
                </c:if>
                <a href="list?currentPage=${requestScope.pageInfo.pageNum}">末页</a>
            </td>
        </tr>
    </table>
</div>

</body>
</html>
