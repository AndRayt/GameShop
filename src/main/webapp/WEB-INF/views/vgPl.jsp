<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Андрей
  Date: 13.03.2018
  Time: 19:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>GameShop | Добавление связи Платформа - Видеоигра</title>
</head>
<body>

<h1>Create Client</h1>
<c:url var="saveUrl" value="/set_vg_pl" />
<form:form modelAttribute="vgpl" method="POST" action="${saveUrl}">
    <table>
        <tr>
            <td><select multiple name="plId">
                <c:forEach items="${platforms}" var="platform">
                    <option value=${platform.getPlatformId()}>${platform.getPlatform()} : ${platform.getPlatformId()}</option>
                </c:forEach>
            </select></td>
            <td><select multiple name="vgId">
                <c:forEach items="${videogames}" var="videogame">
                    <option value=${videogame.getVideogameId()}>${videogame.getVideogame()} : ${videogame.getVideogameId()}</option>
                </c:forEach>
            </select></td>
        </tr>
    </table>

    <input type="submit" value="Save" />
</form:form>

</body>
</html>
