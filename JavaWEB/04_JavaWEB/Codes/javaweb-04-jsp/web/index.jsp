<%--
  Created by IntelliJ IDEA.
  User: shinrin
  Date: 2020/10/18
  Time: 23:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <%--  JSP表达式
  作用：将程序结果输出到客户端
  <%= 变量或表达式%>
  --%>
  <%= new java.util.Date()%>
  <%--jsp脚本片段--%>
  <%
    int sum = 0;
    for (int i = 0; i <= 100; i++) {
      sum+=i;
    }
    out.println("<h1>Sum="+sum+"</h1>");
  %>
  <%
    int x = 10;
    out.println(x);
  %>
  <p>JSP文档</p>
  <%
    int y = 2;
    out.println(y);
  %>
  <hr>
  <%--代码中嵌入HTML文档--%>
  <%
    for (int i = 0; i < 5; i++) {
  %>
  <h1>Hello World <%=i%> </h1>
  <%
    }
  %>

  <%!
    static {
      System.out.println("Loading Servlet!");
    }
    private int glovalVar = 0;
    public void shinrin(){
      System.out.println("shinrin");
    }
  %>
  $END$
  </body>

<%--  <%@page args.... %>--%>
<%--  <%@include file=""%>--%>

  <%--@include会将两个页面合二为一--%>

  <%@include file="common/header.jsp"%>
  <h1>网页主体</h1>

  <%@include file="common/footer.jsp"%>

  <hr>

  <%--jSP标签
      jsp:include：拼接页面，本质还是三个
      --%>
  <jsp:include page="/common/header.jsp"/>
  <h1>网页主体</h1>
  <jsp:include page="/common/footer.jsp"/>

  <%
      pageContext.setAttribute("name1","shinrin1"); //保存的数据只在一个页面中有效
      request.setAttribute("name2","shinrin2"); //保存的数据只在一次请求中有效，请求转发会携带这个数据
      session.setAttribute("name3","shinrin3"); //保存的数据只在一次会话中有效，从打开浏览器到关闭浏览器
      application.setAttribute("name4","shinrin4");  //保存的数据只在服务器中有效，从打开服务器到关闭服务器
  %>

</html>
