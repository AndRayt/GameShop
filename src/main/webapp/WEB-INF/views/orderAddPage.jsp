<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>GameShop | Добавление заказа</title>
</head>
<body>

<h1>Create Order</h1>
<c:url var="saveUrl" value="/orders/add" />
<form:form modelAttribute="orderAttribute" method="POST" action="${saveUrl}">
    <table>
        <tr>
            <td><label for="date">Date: </label></td>
            <td><input type="date" name="date"></td>
        </tr>

        <tr>
            <td><label for="empId">Employee ID: </label></td>
            <td><select multiple name="empId">
                <c:forEach items="${employees}" var="employee">
                    <option value=${employee.getEmployeeId()}>${employee.getName()} : ${employee.getEmployeeId()}</option>
                </c:forEach>
                </select></td>
        </tr>

        <tr>
            <td><label for="clId">Client ID: </label></td>
            <td><select multiple name="clId">
                <c:forEach items="${clients}" var="client">
                    <option value=${client.getClientId()}>${client.getName()} : ${client.getClientId()}</option>
                </c:forEach>
            </select></td>
        </tr>
    </table>

    <input type="submit" value="Save" />
</form:form>

</body>
</html>
