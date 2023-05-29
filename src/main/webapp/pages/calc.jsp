<%--
  Created by IntelliJ IDEA.
  User: garan
  Date: 29.05.2023
  Time: 9:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calc</title>
</head>
<body>
<form action="/calc" method="post">
    <input type="text" name="num1" placeholder="Num1">
    <input type="text" name="num2" placeholder="Num2">
    <select class="form-select" name="type">
        <option selected value="SUM">SUM</option>
        <option value="SUB">SUB</option>
        <option value="MUL">MUL</option>
        <option value="DIV">DIV</option>
    </select>
    <button>Calculate</button>
</form>
<p>Result = ${result}</p>
</body>
</html>
