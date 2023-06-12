<%--
  Created by IntelliJ IDEA.
  User: garan
  Date: 08.06.2023
  Time: 8:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<s:form action="/user/login" modelAttribute="newLoginUser">
    <s:input path="email" placeholder="Email"/>
    <br>
    <s:errors path="email" />
    <br>
    <s:input path="password" placeholder="Password"/>
    <br>
    <s:errors path="password"/>
    <br>
    <s:button>Login</s:button>
</s:form>
</body>
</html>
