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
        <h2>Table Platforms</h2>
        <br>
        Select the table you want to work with:
        <select name="Навигация" onchange="top.location.href=this.options[this.selectedIndex].value;">
            <option value="http://localhost:8080/clients">Clients</option>
            <option value="http://localhost:8080/employees">Employees</option>
            <option value="http://localhost:8080/orders">Orders</option>
            <option selected value="http://localhost:8080/platforms">Platforms</option>
            <option value="http://localhost:8080/videogames">Videogames</option>
        </select>
        <br>To add a new entry, click:
        <input type="button" value="Add" onclick="javascript:window.location='http://localhost:8080/platforms/add'"/>
        <br><br><table style="border: 1px solid; width: 700px; text-align:center">
        <thead style="background:#C6EFCE">
        <tr>
            <th>Producer</th>
            <th>Relevance</th>
            <th>Platformcol</th>
            <th>Platform</th>
            <th></th>
        </tr>
        <c:forEach items="${platforms}" var="platform" varStatus="status">
            <tr valign="top">
                <td>${platform.getProducer()}</td>
                <td>${platform.getRelevance()}</td>
                <td>${platform.getPlatformcol()}</td>
                <td>${platform.getPlatform()}</td>
                <td><a class = "two" href="${pageContext.servletContext.contextPath}/platforms/delete?id=${platform.platformId}">Delete</a>
                    <a class = "two" href="${pageContext.servletContext.contextPath}/platforms/edit?id=${platform.platformId}">Edit</a></td>
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