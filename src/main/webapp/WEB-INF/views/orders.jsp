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
        <h2>Table Orders</h2>
        <br>
        Select the table you want to work with:
        <select name="Навигация" onchange="top.location.href=this.options[this.selectedIndex].value;">
            <option value="http://localhost:8080/clients">Clients</option>
            <option value="http://localhost:8080/employees">Employees</option>
            <option selected value="http://localhost:8080/orders">Orders</option>
            <option value="http://localhost:8080/platforms">Platforms</option>
            <option value="http://localhost:8080/videogames">Videogames</option>
        </select>
        <br>To add a new entry, click:
        <input type="button" value="Add" onclick="javascript:window.location='http://localhost:8080/orders/add'"/>
        <br>To add a new relation with Videogame, click:
        <input type="button" value="Add" onclick="javascript:window.location='http://localhost:8080/set_vg_or'"/>
        <br><br><table style="border: 1px solid; width: 700px; text-align:center">
        <thead style="background:#C6EFCE">
        <tr>
            <th>Order number</th>
            <th>Employee</th>
            <th>Client</th>
            <th>Date</th>
            <th></th>
        </tr>
        <c:forEach items="${orders}" var="order" varStatus="status">
            <tr valign="top">
                <td>${order.getOrderId()}</td>
                <td>${order.getEmployee().getName()}</td>
                <td>${order.getClient().getName()}</td>
                <td>${order.getDate()}</td>
                <td><a class = "two" href="${pageContext.servletContext.contextPath}/orders/delete?id=${order.orderId}">Delete</a>
                    <a class = "two" href="${pageContext.servletContext.contextPath}/orders/edit?id=${order.orderId}">Edit</a>
                    <a class = "two" href="${pageContext.servletContext.contextPath}/orders/videogames?id=${order.orderId}">Videogames</a></td>
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