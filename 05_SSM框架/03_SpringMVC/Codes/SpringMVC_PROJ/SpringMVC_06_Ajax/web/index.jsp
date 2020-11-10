<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>

    <script src="${pageContext.request.contextPath}/statics/js/jquery-3.5.1.js"></script>
    <script>

      function a() {
        $.post({
          //[地址]localhost:8080/a1
          url:"${pageContext.request.contextPath}/a1",
          //[参数]使用data获取输入框的username并传入后端
          data:{"name":$("#username").val()},
          //使用回调函数，取消后端对视图的控制权
          //[请求成功]function中的形参data接受后端的数据
          success:function (data) {
            console.log(data);
            alert(data);
          },
          //[请求失败]
          error:function () {

          }
        })
      }
    </script>

  </head>
  <body>

  <%--时区焦点时发起请求到后台--%>
  <%--onblur：失去焦点--%>
  用户名：<input type="text" id="username" onblur="a()">

  </body>
</html>
