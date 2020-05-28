<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Address</th>
    </tr>
    <c:forEach items="${customers}" var="customer">
        <tr>
            <td>${customer.getId()}</td>
            <td>${customer.getName()}</td>
            <td>${customer.getEmail()}</td>
            <td>${customer.getAddress()}</td>
        </tr>
    </c:forEach>
</table>
<form:form method="post" modelAttribute="customer">
    ID <form:input path="id"></form:input>
    NAME <form:input path="name"></form:input>
    EMAIL <form:input path="email"></form:input>
    ADDRESS <form:input path="address"></form:input>
    <input type="submit" value="Submit"/>
</form:form>
<div><p>${message}</p></div>
</body>
</html>