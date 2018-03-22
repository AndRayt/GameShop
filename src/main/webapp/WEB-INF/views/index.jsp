<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Game Shop</title>
    <link rel="stylesheet" href="../resources/style.css">
</head>
<body><h2>Welcome to administration panel of Game Shop</h2>
<p class="text1"> Select the table you want to work with:
<select name="Навигация" onchange="top.location.href=this.options[this.selectedIndex].value;">
    <option selected value=""></option>
    <option value="http://localhost:8080/clients">Clients</option>
    <option value="http://localhost:8080/employees">Employees</option>
    <option value="http://localhost:8080/orders">Orders</option>
    <option value="http://localhost:8080/platforms">Platforms</option>
    <option value="http://localhost:8080/videogames">Videogames</option>
</select></p>
</body>
</html>
