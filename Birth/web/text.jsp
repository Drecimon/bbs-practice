<%--
  Created by IntelliJ IDEA.
  User: junjiedemac
  Date: 2019-06-04
  Time: 12:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
    *{
    margin: 0px;
    padding: 0px;
    }
    ul{
    list-style: none;
    }
    a{
    text-decoration: none;
    }
    .container{
    width: 1200px;
    height: 1200px;
    margin: 20px auto;
    }
    .contaner-top{
    width: 100%;
    height: 120px;
    display: flex;
    justify-content: space-between;
    align-items: center;
    }
    .contaner-top-img2{
    width: 1000px;
    height: 120px;
    }
    .Nav{
    width: 100%;
    height: 40px;
    margin: 10px auto;
    }
    .Nav>ul{
    width: 100%;
    height: 100%;
    display: flex;
    justify-content: space-between;
    align-items: center;
    }
    .Nav>ul>li{
    width: 150px;
    height: 40px;
    border: 1px solid #888888;
    border-radius: 4px;
    }
    .Nav>ul>li>a{
    display: block;
    width: 150px;
    height: 40px;
    line-height: 40px;
    text-align: center;
    color: #666666
    }
    .Banner{
    width: 100%;
    height: 300px;

    }
    .Banner-left{
    width: 450px;
    height: 100%;
    float: left;
    box-shadow: 1px 0px 15px #AAA;
    }
    .Banner-left>img{
    float: left;
    }
    .Banner-left>div{
    width: 300px;
    height: 100%;
    float: right;
    }
    .Banner-left>div>span{
    display: block;
    width: 100%;
    font-size: 18px;
    color: #666666;
    text-align: center;
    margin: 30px 0px;
    }
    .Login{
    width: 100%;
    height: 40px;
    display: flex;
    justify-content: space-around;
    align-items: center;
    }
    .Login>a{
    display: block;
    width: 80px;
    height: 30px;
    text-align: center;
    line-height: 30px;
    border: 1px solid #888888;
    border-radius: 4px;
    color: #000000;
    }
    .Banner-left>div>input{
    width: 230px;
    height: 35px;
    border: 1px solid #dddddd;
    margin-left: 30px;
    margin-top: 15px;
    border-radius: 2px;
    text-indent: 16px;
    }
    .Banner-left>div>a{
    display: block;
    width: 120px;
    height: 40px;
    text-align: center;
    line-height: 40px;
    background-color: #4C6CFB;
    color: #FFF;
    margin-top: 20px;
    margin-left: 140px;
    }



    .Banner-right{
    width: 690px;
    height: 260px;
    float: right;
    padding: 20px;
    box-shadow: 1px 0px 15px #AAA;
    }
    .Banner-right>h3{
    color: #2F921F;
    }
    .Banner-right>ul{
    width: 46%;
    height: 230px;
    padding: 10px;
    }
    .Banner-right>ul>li{
    font-size: 14px;
    margin: 20px 0px;
    border-bottom: 1px solid #666666;
    }
    .Banner-right>ul>li>span{
    color: #2F921F;
    font-size: 14px;
    }

    .Footer{
    width: 100%;
    height: 490px;
    padding: 3px 0px;
    }
    .Footer>.Footer-left>ul>li>img{
    width: 450px;
    margin: 10px 0px;
    }
    .Footer-left>span{
    display: block;
    width: 450px;
    height: 80px;
    text-align: center;
    line-height: 80px;
    color: #2F921F;
    font-size: 30px;
    }
    .Footer-left{
    width: 450px;
    height: 100%;
    float: left;
    box-shadow: 1px 0px 15px #AAA;
    }
    .Footer-right{
    width: 730px;
    float: right;
    }
    /* ++++++++++++++++++++++++++++++ */


    #wrap {
    position:relative;
    width:700px;
    height:400px;
    margin: 40px auto;
    overflow:hidden;
    }
    #wrap .pic {
    position:absolute;
    top:0;
    left:0;
    width:1000%;
    height:100%;
    }
    .pic li {
    float:left;
    width:700px;
    height:400px;
    color:#fff;
    font-size:80px;
    text-align:center;
    line-height:400px;
    }
    .pic>li>a>img {
    border:0;
    vertical-align:middle;
    width: 700px;
    height: 400px;
    }
    .tab {
    position:absolute;
    bottom: 10px;
    left:55%;
    margin-left:-100px;
    height:30px;
    padding-left:10px;
    background:rgba(0,0,0,.2);
    border-radius:15px;
    transition:0.5s;
    }
    .tab:hover {
    background:rgba(0,0,0,.5);
    transform:scale(1.2);
    }
    .tab li {
    width:20px;
    height:20px;
    float:left;
    background:#fff;
    border-radius:50%;
    margin:5px 10px 0 0;
    cursor:pointer;
    }
    .tab li.on {
    background:#f60;
    }

    .Footer-bottom{
    width: 100%;
    height: 40px;
    text-align: center;
    margin: 100px 0px;
    }


    .Banner-Lab{
    width: 100%;
    margin: 20px 0px;
    }
    .Banner-Lab>h2{
    width: 200px;
    padding: 10px;
    border-bottom: 2px solid #2F921F;
    }
    .Banner-Lab>img{
    width: 800px;
    height: 430px;
    margin-top: 50px;
    margin-left: 200px;
    }
    .Banner-Lab>p{
    width: 800px;
    margin: 20px auto;
    line-height: 25px;
    }
    </style>
</head>
<body>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="css/style.css">
    <script src="./js/jquery-3.3.1.min.js"></script>
    <script src="./js/index.js"></script>
    <title>实验室</title>
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

    <div class="Banner">
        <div class="Banner-left">
            <img src="images/left.jpg" alt="">
            <div>
                <span>Welcome</span>
                <div class="Login">
                    <a href="login_1.jsp" style="margin-left: 30px;">Sign in</a>
                    <a href="login_1.jsp">Sign up</a><br>
                </div>
                <input type="text" placeholder="UserName"><br>
                <input type="text" placeholder="PassWard"><br>
                <a href="#">Login</a>
            </div>
        </div>
        <div class="Banner-right">
            <h3>科研进展</h3>
            <ul style="float: left;">
                <li><span>【2019-4-12】>>></span><a href="index.jsp">"第一届XXX研讨会"成功举办</a></li>
                <li><span>【2019-4-12】>>></span>"第一届XXX研讨会"成功举办</li>
                <li><span>【2019-4-12】>>></span>"第一届XXX研讨会"成功举办</li>
                <li><span>【2019-4-12】>>></span>"第一届XXX研讨会"成功举办</li>
                <li><span>【2019-4-12】>>></span>"第一届XXX研讨会"成功举办</li>
            </ul>
            <ul style="float: right;">
                <li><span>【2019-4-12】>>></span>"第一届XXX研讨会"成功举办</li>
                <li><span>【2019-4-12】>>></span>"第一届XXX研讨会"成功举办</li>
                <li><span>【2019-4-12】>>></span>"第一届XXX研讨会"成功举办</li>
                <li><span>【2019-4-12】>>></span>"第一届XXX研讨会"成功举办</li>
                <li><span>【2019-4-12】>>></span>"第一届XXX研讨会"成功举办</li>
            </ul>
        </div>
    </div>

    <div class="Footer">
        <div class="Footer-left">
            <span>快速导航</span>
            <ul>
                <li><img src="images/down1.jpg" alt=""></li>
                <li><img src="images/down2.jpg" alt=""></li>
                <li><img src="images/down3.jpg" alt=""></li>
            </ul>
        </div>
        <div class="Footer-right">

            <div id="wrap">
                <ul class="pic">
                    <li>
                        <a href="#"><img src="images/pic1.jpg" alt=""></a>
                    </li>
                    <li>
                        <a href="#"><img src="images/pic2.gif" alt=""></a>
                    </li>
                    <li>
                        <a href="#"><img src="images/pic3.gif" alt=""></a>
                    </li>
                    <li>
                        <a href="#"><img src="images/pic4.gif" alt=""></a>
                    </li>
                    <li>
                        <a href="#"><img src="images/pic5.gif" alt=""></a>
                    </li>

                </ul>
                <ul class="tab">

                    <li class="on"></li>
                    <li></li>
                    <li></li>
                    <li></li>
                    <li></li>

                </ul>

            </div>

        </div>


    </div>

    <div class="Footer-bottom">
        关于我们@copyright
    </div>
</div>
</body>

</html>
</body>
</html>
