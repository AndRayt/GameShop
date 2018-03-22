<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>GameShop | Изменение даты заказа</title>
    <link rel="stylesheet" href="../resources/style.css">
</head>
<body>

<h1>Edit Order</h1>
<c:url var="saveUrl" value="/orders/edit" />
<form:form modelAttribute="orderId" method="POST" action="${saveUrl}">
    <table>
        <tr>
            <td><label for="date">Date: </label></td>
            <td><input type="date" name="date"></td>
        </tr>
    </table>

    <input type="submit" value="Save" />
</form:form>

</body>
</html>
