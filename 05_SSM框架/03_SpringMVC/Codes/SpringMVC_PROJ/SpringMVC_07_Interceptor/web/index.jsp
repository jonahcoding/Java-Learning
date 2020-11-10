<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>首页</title>
  </head>
  <body>

  <%--<a href="${pageContext.request.contextPath}/interceptor">拦截器测试</a>--%>
  <a href="${pageContext.request.contextPath}/user/jumpLogin">登录</a>
  <a href="${pageContext.request.contextPath}/user/jumpSuccess">成功页面</a>

  </body>
</html>
