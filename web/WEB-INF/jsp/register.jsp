<%--
  Created by IntelliJ IDEA.
  User: 20698
  Date: 2022/11/21
  Time: 14:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册界面</title>
    <link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/5.2.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <form action="register" method="post">
        <div class="form-group col-md-6">
            <label for="user-name-label">用户名</label>
            <input type="text" class="form-control" id="user-name-label" placeholder="username" name="name">
        </div>
        <div class="form-group col-md-6">
            <label for="password-label">密码</label>
            <input type="password" class="form-control" id="password-label" placeholder="Password" name="password">
        </div>
        <br><br>
        <button type="submit" class="btn btn-success">提 交</button>
    </form>
</div>
</body>
</html>
