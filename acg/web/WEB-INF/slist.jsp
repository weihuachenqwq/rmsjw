<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2020/1/14
  Time: 23:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="errorpage.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>商品列表</title>
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
        #sou{
            height: 25px;
            width: 80px;
            display: flex;
        }

    </style>
</head>
<body>
<div id="left">
        <p>
        <a href="/backed/index/home">回到首页</a>
        </p>
    <form action="/backed/shop/tocha" method="post">
        <div id="sou">
            <input type="text" name="gjz">
            <input type="submit" value="搜索">
        </div>

    </form>


    <h1>欢迎${us.username}登录后台</h1>
    <a href="/backed/shop/getall">获取数据</a>

    <a href=""><button id="bt">上架商品</button></a>


</div>
<div id="right">
<c:if test="${not empty slist.data}">
<table>
<tr>
    <th>序号</th>
    <th>名称</th>
    <th>价格</th>
    <th>库存</th>
    <th>在售</th>
    <th>创建</th>
    <th>更新</th>
</tr>
    <c:forEach items="${slist.data}" var="p">
<tr>
    <td>${p.sid}</td>
    <td>${p.sname}</td>
    <td>${p.sprice}</td>
    <td>${p.snum}</td>
    <td class="sh">${p.shou}</td>
    <td>${p.create_time}</td>
    <td>${p.update_time}</td>
    <td>
        <button onclick="toShou(this)">下架</button>
        <button>修改</button>
    </td>
</tr>
    </c:forEach>
</c:if>
    <%--<c:if test="${empty slist.data}">--%>
        <%--无更多商品--%>
    <%--</c:if>--%>

        <c:if test="${not empty clist.data}">
        <table>
            <tr>
                <th>序号</th>
                <th>名称</th>
                <th>价格</th>
                <th>库存</th>
                <th>在售</th>
                <th>创建</th>
                <th>更新</th>
            </tr>
            <c:forEach items="${clist.data}" var="c">
                <tr>
                    <td>${c.sid}</td>
                    <td>${c.sname}</td>
                    <td>${c.sprice}</td>
                    <td>${c.snum}</td>
                    <td class="sh">${c.shou}</td>
                    <td>${c.create_time}</td>
                    <td>${c.update_time}</td>
                    <td>
                        <button onclick="toShou(this)">下架</button>
                        <button>修改</button>
                    </td>
                </tr>
            </c:forEach>
            </c:if>

</table>


</div>
</body>
<script src="${pageContext.request.contextPath}/js/jquery-3.3.1.js">
</script>
<script>
    function toShou(but) {
        var id2=$(but).parent().parent().children().first().text();
        $.get(
            "backed/shop/toshou",
        {sid:id2},
            function (data) {
                var num=Number(data);
               if(data>0){
                   var id2=$(but).parent().parent().children().first().nextAll(".sh").text(1);
               }
            }
        )
    }

</script>
</html>
