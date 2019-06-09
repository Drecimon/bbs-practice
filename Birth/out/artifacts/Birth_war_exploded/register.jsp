<%--
  Created by IntelliJ IDEA.
  User: junjiedemac
  Date: 2019-05-21
  Time: 22:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="css/style.css">
    <script src="./js/jquery-3.3.1.min.js"></script>
    <script src="./js/index.js"></script>
    <style>
        .Banner-left{
            width: 700px;
            height: 400px;
            margin-top: 100px;
            margin-left: 245px;
        }

        .Banner-left>div{
            width: 450px;
        }
        .Banner-left>div>input{
            margin-left: 115px;
        }
        .Banner-left>div>a{
            margin-left: 225px;
        }
    </style>
    <title>注册</title>
</head>
<body>
<div class="container">
    <div class="contaner-top">
        <img src="images/logo.jpg" alt="">
        <img src="images/banner.png" class="contaner-top-img2">
    </div>

    <div class="Nav">
        <ul>
            <li><a href="text.jsp">首页</a></li>
            <li><a href="library.jsp">实验室概况</a></li>
            <li><a href="technology.jsp">技术平台</a></li>
            <li><a href="team.jsp">科研团队</a></li>
            <li><a href="talent.jsp">人才培养</a></li>
            <li><a href="#">内部记录</a></li>
            <li><a href="#">English</a></li>
        </ul>
    </div>


    <div class="Banner-left">
        <img src="images/left.jpg" style="width: 200px;">
        <div>
            <form action ="RegisterServlet" method="post">
                <h3>注册界面</h3>
                账号：<input name="userName" type ="text"><br>
                密码：<input name="password" type ="password"><br>
                <input  type ="submit" value="提交按钮">
            </form>
        </div>
    </div>


</div>
</body>
