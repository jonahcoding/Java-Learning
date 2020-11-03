<%--
  Created by IntelliJ IDEA.
  User: shinrin
  Date: 2020/10/17
  Time: 13:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<h1>登录</h1>
<div>
    <%--以post方式提交--%>
    <form action="${pageContext.request.contextPath}/login" method="post">
        用户名：<input type="text" name="username" required><br>
        密码：<input type="password" name="password" required><br>
        爱好：
        <input type="checkbox" name="hobby" value="Girl">Girl
        <input type="checkbox" name="hobby" value="Coding">Coding
        <input type="checkbox" name="hobby" value="Music">Music
        <input type="checkbox" name="hobby" value="Draw">Draw
        <br>
        <input type="submit">
    </form>
</div>
</body>
</html>
