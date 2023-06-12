<%--
  Created by IntelliJ IDEA.
  User: garan
  Date: 29.05.2023
  Time: 9:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Calc</title>
</head>
<body>
<s:form action="/calc" method="post" modelAttribute="newOperationDto">

    <s:input path="num1" placeholder="Num1"/>
    <br>
    <s:errors path="num1"/>
    <br>
    <s:input path="num2" placeholder="Num2"/>
    <br>
    <s:errors path="num2"/>
    <br>

    <s:select path="type">
        <s:option value="SUM" label="SUM"/>
        <s:option value="SUB" label="SUB"/>
        <s:option value="MUL" label="MUL"/>
        <s:option value="DIV" label="DIV"/>
    </s:select>
    <br>
    <s:button>Calculate</s:button>
</s:form>
<p>Result = ${result}</p>
</body>
</html>
