<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Game Shop | Изменение записи о клиенте</title>
    <link rel="stylesheet" href="../resources/style.css">
</head>
<body>

<h1>Edit Client</h1>
<c:url var="saveUrl" value="/clients/edit?id=${clientAttribute.clientId}" />
<form:form modelAttribute="clientAttribute" method="POST" action="${saveUrl}">
    <table>
        <tr>
            <td><form:label path="name">Name:</form:label></td>
            <td><form:input path="name"/></td>
        </tr>

        <tr>
            <td><form:label path="email">Email: </form:label></td>
            <td><form:input path="email"/></td>
        </tr>

        <tr>
            <td><form:label path="telephone">Telephone: </form:label></td>
            <td><form:input path="telephone"/></td>
        </tr>
    </table>

    <input type="submit" value="Save" />
</form:form>

</body>
</html>
