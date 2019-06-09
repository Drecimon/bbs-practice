<%--
  Created by IntelliJ IDEA.
  User: junjiedemac
  Date: 2019-05-21
  Time: 23:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>wangEditor demo</title>
</head>
<body>
<form id="newspost" method="post" action="newspost" enctype="multipart/form-data">

         <input type="hidden" id="content" name="content"/>
         <div style="padding: 5px 0; color: #ccc"></div>
         <div id="editor"></div>
         <br/>
         </form>
     <button id="btn1">获取html</button>
<script type="text/javascript">
         //下面这两行脚本就是弹出文本框
        var E = window.wangEditor
         var editor = new E('#editor')
    // 上传图片（举例）
        editor.customConfig.uploadImgServer = '/upload.ashx'

        //将网络图片隐藏掉
       editor.customConfig.showLinkImg = false

       // 将 timeout 时间改为 3s
        editor.customConfig.uploadImgTimeout = 1000 * 10;

         document.getElementById('btn1').addEventListener('click', function () {
                // 读取 html
                alert(editor.txt.html())
      }, false)

         editor.create();
     </script>
</body>

</html>