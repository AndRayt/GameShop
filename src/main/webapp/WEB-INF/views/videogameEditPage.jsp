<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>GameShop | Редактирование игры</title>
    <link rel="stylesheet" href="../resources/style.css">
</head>
<body>

<h1>Edit Videogame</h1>
<c:url var="saveUrl" value="/videogames/edit?id=${videogameAttribute.videogameId}" />
<form:form modelAttribute="videogameAttribute" method="POST" action="${saveUrl}">
    <table>
        <tr>
            <td><form:label path="videogame">Videogame: </form:label></td>
            <td><form:input path="videogame"/></td>
        </tr>
        <tr>
            <td><form:label path="publisher">Publisher: </form:label></td>
            <td><form:input path="publisher"/></td>
        </tr>
        <tr>
            <td><form:label path="developer">Developer: </form:label></td>
            <td><form:input path="developer"/></td>
        </tr>
        <tr>
            <td><form:label path="genre">Genre: </form:label></td>
            <td><form:input path="genre"/></td>
        </tr>
        <tr>
            <td><form:label path="ageRating">Age Rating: </form:label></td>
            <td><form:input path="ageRating"/></td>
        </tr>
        <tr>
            <td><form:label path="date">Date: </form:label></td>
            <td><form:input path="date" type="date"/></td>
        </tr>
        <tr>
            <td><form:label path="costOfPurchase">Cost of purchase: </form:label></td>
            <td><form:input path="costOfPurchase"/></td>
        </tr>
        <tr>
            <td><form:label path="price">Price: </form:label></td>
            <td><form:input path="price"/></td>
        </tr>
        <tr>
            <td><form:label path="quantity">Quantity: </form:label></td>
            <td><form:input path="quantity"/></td>
        </tr>
    </table>
    <input type="submit" value="Save" />
</form:form>
</body>
</html>