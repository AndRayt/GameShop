<%--
  Created by IntelliJ IDEA.
  User: Андрей
  Date: 11.03.2018
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Game Shop</title>
</head>
<body>
<br><h2>Welcome to administration panel of Game Shop</h2>
<br>
Select the table you want to work with:
<select name="Навигация" onchange="top.location.href=this.options[this.selectedIndex].value;">
    <option selected value=""></option>
    <option value="http://localhost:8080/clients">Clients</option>
    <option value="http://localhost:8080/employees">Employees</option>
    <option value="http://localhost:8080/orders">Orders</option>
    <option value="http://localhost:8080/platforms">Platforms</option>
    <option value="http://localhost:8080/videogames">Videogames</option>
</select>
</body>
</html>
