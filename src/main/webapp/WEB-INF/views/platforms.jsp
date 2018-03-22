<%@ page language="java" pageEncoding="UTF-8" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head lang="en">
    <title>GameShop | Платформы</title>
    <link rel="stylesheet" href="../resources/style.css">
</head>

<body>
    <div id="main">
        <div id="dialog">
            <h2>Table Platforms</h2>
            <p class="text1">
            Select the table you want to work with:
            <select name="Навигация" onchange="top.location.href=this.options[this.selectedIndex].value;">
                <option value="http://localhost:8080/clients">Clients</option>
                <option value="http://localhost:8080/employees">Employees</option>
                <option value="http://localhost:8080/orders">Orders</option>
                <option selected value="http://localhost:8080/platforms">Platforms</option>
                <option value="http://localhost:8080/videogames">Videogames</option>
            </select> To return to the main page, click this <a href="http://localhost:8080/">link</a>.</p>
            <table class="table1">
            <tr>
                <th>Producer</th>
                <th>Relevance</th>
                <th>Platformcol</th>
                <th>Platform</th>
                <th><a href="http://localhost:8080/platforms/add" class="buttonAdd">Add new Entry</a> <a href="http://localhost:8080/set_vg_pl" class="buttonAdd">Relation with Videogame</a><br></th>
            </tr>
            <c:forEach items="${platforms}" var="platform" varStatus="status">
                <tr valign="top">
                    <td>${platform.getProducer()}</td>
                    <td>${platform.getRelevance()}</td>
                    <td>${platform.getPlatformcol()}</td>
                    <td>${platform.getPlatform()}</td>
                    <td><a class = "buttonAdd" href="${pageContext.servletContext.contextPath}/platforms/delete?id=${platform.platformId}">Delete</a>
                        <a class = "buttonAdd" href="${pageContext.servletContext.contextPath}/platforms/edit?id=${platform.platformId}">Edit</a>
                        <a class = "buttonAdd" href="${pageContext.servletContext.contextPath}/platforms/videogames?id=${platform.platformId}">Videogames</a></td></td>
                </tr>
            </c:forEach>
            </table>
            </div>
        </div>
    </div>
</body>
</html>