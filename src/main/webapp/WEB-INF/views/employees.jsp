<%@ page language="java" pageEncoding="UTF-8" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head lang="en">
    <title>GameShop</title>
</head>

<body>

<div id="main">

    <div id="dialog">
        <h2>Table Employees</h2>
        <br>
        Select the table you want to work with:
        <select name="Навигация" onchange="top.location.href=this.options[this.selectedIndex].value;">
            <option value="http://localhost:8080/clients">Clients</option>
            <option selected value="http://localhost:8080/employees">Employees</option>
            <option value="http://localhost:8080/orders">Orders</option>
            <option value="http://localhost:8080/platforms">Platforms</option>
            <option value="http://localhost:8080/videogames">Videogames</option>
        </select>
        <br>To add a new entry, click:
        <input type="button" value="Add" onclick="javascript:window.location='http://localhost:8080/employees/add'"/>
        <br><br><table style="border: 1px solid; width: 700px; text-align:center">
        <thead style="background:#C6EFCE">
        <tr>
            <th>Name</th>
            <th>Passport</th>
            <th>Adress</th>
            <th>Telephone</th>
            <th></th>
        </tr>
        <c:forEach items="${employees}" var="employee" varStatus="status">
            <tr valign="top">
                <td>${employee.getName()}</td>
                <td>${employee.getPassport()}</td>
                <td>${employee.getAdress()}</td>
                <td>${employee.getTelephone()}</td>
                <td><a class = "two" href="${pageContext.servletContext.contextPath}/employees/delete?id=${employee.employeeId}">Delete</a>
                    <a class = "two" href="${pageContext.servletContext.contextPath}/employees/edit?id=${employee.employeeId}">Edit</a></td>
            </tr>
        </c:forEach>
        </table>
        <br>
        To return to the main page, click this <a href="http://localhost:8080/">link</a>.
    </div>
</div>
</div>
</body>
</html>