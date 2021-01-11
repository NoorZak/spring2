<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 1/10/2021
  Time: 10:29 PM
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

<h1><c:out value="${product.name}"/></h1>


    <ul>
    <c:forEach items="${ product.categories }" var="c">

            <li> <c:out value="${c.name}"/></li>

    </c:forEach>


    </ul>


<form:form action="/products/${product.id}" method="post" modelAttribute="association">

    <input type="hidden" name="_method" value="put">
    <p>
    <form:label path="category">Categories</form:label>
    <form:errors path="category"/>
    <form:select path="category">
        <c:forEach items="${ categories }" var="c">
            <form:option value="${ c }">${ c.name }</form:option>
        </c:forEach>
    </form:select>
    </p>

    <input type="submit"  value="submit" />
</form:form>
</body>
</html>
