<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2020/1/15
  Time: 18:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <title>错误</title>
    <style>
        #left{
            width: 30%;
            height: 100%;
            float: left;
            background-color: aqua;
        }
        #right{
            width: 70%;
            float: right;
            background-color: gold;
        }
    </style>
</head>
<body>
<div id="left">
    <p>
        <a href="/backed/index/home">回到首页</a>
    </p>
    <h1>欢迎${us.username}登录后台</h1>
    <a href="/backed/shop/getall">获取所有商品数据</a>
</div>
<div id="right">
<h1>系统出错</h1>
</div>
</body>
</html>
