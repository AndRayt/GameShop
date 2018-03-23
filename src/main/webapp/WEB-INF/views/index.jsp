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
    <option value="${pageContext.servletContext.contextPath}/clients">Clients</option>
    <option value="${pageContext.servletContext.contextPath}/employees">Employees</option>
    <option value="${pageContext.servletContext.contextPath}/orders">Orders</option>
    <option value="${pageContext.servletContext.contextPath}/platforms">Platforms</option>
    <option value="${pageContext.servletContext.contextPath}/videogames">Videogames</option>
</select></p>
</body>
</html>
