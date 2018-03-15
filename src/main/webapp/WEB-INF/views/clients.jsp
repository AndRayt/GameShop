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
        <h2>Table Clients</h2>
        <br>
        Select the table you want to work with:
        <select name="Навигация" onchange="top.location.href=this.options[this.selectedIndex].value;">
            <option selected value="http://localhost:8080/clients">Clients</option>
            <option value="http://localhost:8080/employees">Employees</option>
            <option value="http://localhost:8080/orders">Orders</option>
            <option value="http://localhost:8080/platforms">Platforms</option>
            <option value="http://localhost:8080/videogames">Videogames</option>
        </select>
        <br>To add a new entry, click:
        <input type="button" value="Add" onclick="javascript:window.location='http://localhost:8080/clients/add'"/>
        <br><br><table style="border: 1px solid; width: 700px; text-align:center">
        <thead style="background:#C6EFCE">
        <tr>
            <th>Name</th>
            <th>E-mail</th>
            <th>Telephone</th>
            <th>Orders</th>
            <th></th>
        </tr>
        <c:forEach items="${clients}" var="client" varStatus="status">
            <tr valign="top">
                <td>${client.getName()}</>
                <td>${client.getEmail()}</>
                <td>${client.getTelephone()}</>
                <td><a class = "two" href="${pageContext.servletContext.contextPath}/get_list_orders?id=${client.clientId}">Show orders</a></td>
                <td><a class = "two" href="${pageContext.servletContext.contextPath}/clients/delete?id=${client.clientId}">Delete</a>
                    <a class = "two" href="${pageContext.servletContext.contextPath}/clients/edit?id=${client.clientId}">Edit</a></td>
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