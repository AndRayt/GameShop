<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>GameShop | Добавление платформы</title>
    <link rel="stylesheet" href="../resources/style.css">
</head>
<body>

<h1>Create Platform</h1>
<c:url var="saveUrl" value="/platforms/add" />
<form:form modelAttribute="platformAttribute" method="POST" action="${saveUrl}">
    <table>
        <tr>
            <td><form:label path="producer">Producer: </form:label></td>
            <td><form:input path="producer"/></td>
        </tr>
        <tr>
            <td><form:label path="relevance">Relevance: </form:label></td>
            <td><form:input path="relevance"/></td>
        </tr>
        <tr>
            <td><form:label path="platformcol">Platformcol: </form:label></td>
            <td><form:input path="platformcol"/></td>
        </tr>
        <tr>
            <td><form:label path="platform">Platform: </form:label></td>
            <td><form:input path="platform"/></td>
        </tr>
    </table>
    <input type="submit" value="Save" />
</form:form>
</body>
</html>