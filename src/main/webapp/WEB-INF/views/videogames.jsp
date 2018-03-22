<%@ page language="java" pageEncoding="UTF-8" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head lang="en">
    <title>GameShop | Видеоигры</title>
    <link rel="stylesheet" href="../resources/style.css">
</head>

<body>
<div id="main">
    <div id="dialog">
        <h2>Table VideoGames</h2>
        <p class="text1">
        Select the table you want to work with:
        <select name="Навигация" onchange="top.location.href=this.options[this.selectedIndex].value;">
            <option value="http://localhost:8080/clients">Clients</option>
            <option value="http://localhost:8080/employees">Employees</option>
            <option value="http://localhost:8080/orders">Orders</option>
            <option value="http://localhost:8080/platforms">Platforms</option>
            <option selected value="http://localhost:8080/videogames">Videogames</option>
        </select> To return to the main page, click this <a href="http://localhost:8080/">link</a>.</p>
        <table class="table1">
        <tr>
            <th>Videogame</th>
            <th>Developer</th>
            <th>Publisher</th>
            <th>Genre</th>
            <th>Age Rating</th>
            <th>Date</th>
            <th>Cost of purchase</th>
            <th>Price</th>
            <th>Quantity</th>
            <th><a href="http://localhost:8080/videogames/add" class="buttonAdd">Add new Entry</a></th>
        </tr>
        <c:forEach items="${videogames}" var="videogame" varStatus="status">
        <tr valign="top">
            <td>${videogame.getVideogame()}</td>
            <td>${videogame.getDeveloper()}</td>
            <td>${videogame.getPublisher()}</td>
            <td>${videogame.getGenre()}</td>
            <td>${videogame.getAgeRating()}</td>
            <td>${videogame.getDate()}</td>
            <td>${videogame.getCostOfPurchase()}</td>
            <td>${videogame.getPrice()}</td>
            <td>${videogame.getQuantity()}</td>
            <td><a class = "buttonAdd" href="${pageContext.servletContext.contextPath}/videogames/delete?id=${videogame.videogameId}">Delete</a>
                <a class = "buttonAdd" href="${pageContext.servletContext.contextPath}/videogames/edit?id=${videogame.videogameId}">Edit</a>
        </tr>
        </c:forEach>
        </table>
    </div>
</div>
</div>
</body>
</html>