<%@ page language="java" pageEncoding="UTF-8" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head lang="en">
    <title>GameShop | Работники</title>
    <link rel="stylesheet" href="../resources/style.css">
</head>

<body>
<div id="main">
    <div id="dialog">
        <h2>Table Employees</h2>
        <p class="text1">
        Select the table you want to work with:
        <select name="Навигация" onchange="top.location.href=this.options[this.selectedIndex].value;">
            <option value="http://localhost:8080/clients">Clients</option>
            <option selected value="http://localhost:8080/employees">Employees</option>
            <option value="http://localhost:8080/orders">Orders</option>
            <option value="http://localhost:8080/platforms">Platforms</option>
            <option value="http://localhost:8080/videogames">Videogames</option>
        </select> To return to the main page, click this <a href="http://localhost:8080/">link</a>.</p>
        <table class="table1">
        <tr>
            <th>Name</th>
            <th>Passport</th>
            <th>Adress</th>
            <th>Telephone</th>
            <th><a href="http://localhost:8080/employees/add" class="buttonAdd">Add new Entry</a><br></th>
        </tr>
        <c:forEach items="${employees}" var="employee" varStatus="status">
            <tr valign="top">
                <td>${employee.getName()}</td>
                <td>${employee.getPassport()}</td>
                <td>${employee.getAdress()}</td>
                <td>${employee.getTelephone()}</td>
                <td><a class = "buttonAdd" href="${pageContext.servletContext.contextPath}/employees/delete?id=${employee.employeeId}">Delete</a>
                    <a class = "buttonAdd" href="${pageContext.servletContext.contextPath}/employees/edit?id=${employee.employeeId}">Edit</a></td>
            </tr>
        </c:forEach>
        </table>
    </div>
</div>
</div>
</body>
</html>