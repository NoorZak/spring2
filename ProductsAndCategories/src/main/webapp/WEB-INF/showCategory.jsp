<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 1/11/2021
  Time: 12:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1><c:out value="${category.name}"/></h1>


<ul>
    <c:forEach items="${ category.products }" var="p">

        <li> <c:out value="${p.name}"/></li>

    </c:forEach>


</ul>


<form:form action="/categories/${category.id}" method="post" modelAttribute="association">

    <input type="hidden" name="_method" value="put">
    <p>
        <form:label path="product">Products</form:label>
        <form:errors path="product"/>
        <form:select path="product">
            <c:forEach items="${ products }" var="p">
                <form:option value="${ p }">${ p.name }</form:option>
            </c:forEach>
        </form:select>
    </p>

    <input type="submit"  value="submit" />
</form:form>
</body>
</html>
