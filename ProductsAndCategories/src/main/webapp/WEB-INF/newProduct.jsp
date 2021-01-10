<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 1/11/2021
  Time: 12:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h1>New Product</h1>
<form:form action="/products" method="post" modelAttribute="product">
    <p>
        <form:label path="name">Name</form:label>
        <form:errors path="name"/>
        <form:input path="name"/>
    </p>
    <p>
        <form:label path="description">Description</form:label>
        <form:errors path="description"/>
        <form:textarea path="description"/>
    </p>
    <p>
        <form:label path="price">Price</form:label>
        <form:errors path="price"/>
        <form:input type="number" step="0.01"  path="price"/>
    </p>

    <input type="submit" value="Create"/>
</form:form>