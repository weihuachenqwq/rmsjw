<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2020/1/17
  Time: 13:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>管理登录</title>
    <style>
        body{
            background-image: url("/1.jpg");
        }
        #wk{
            position: relative;
            display: flex;

        }
        #in1,#in2{
            position: absolute;
            margin-left: 40%;
            height:50px;
            width: 200px;
        }
        #in1{
            margin-top: 18%;
        }
        #in2{
            margin-top: 22%;
        }
        #in3{
            position: absolute;
            margin-top: 26%;
            margin-left: 46%;
        }
        #in1 input{
            outline: none;
            opacity: 0.6;
            border: none;
            border-bottom: 2px gray solid;
            width: 100%;
            height: 100%;
        }
        #in2 input{
            outline: none;
            opacity: 0.6;
            border: none;
            border-bottom: 2px gray solid;
            height: 100%;
            width: 100%;
        }
        #un{
            margin-top: 18%;
            margin-left: 43%;
        }
    </style>
</head>
<body>

<form action="/backed/user/login" method="post">
    <div id="wk">
        <div id="un">
            <p>用户名或密码错误</p>
        </div>

        <div id="in1">
            <input type="text" placeholder="账户" name="username">
        </div>
        <div id="in2">
            <input type="password" placeholder="密码" name="password">
        </div>
        <div id="in3">
            <input type="submit" value="登录">
        </div>
    </div>

</form>
</body>
</html>
