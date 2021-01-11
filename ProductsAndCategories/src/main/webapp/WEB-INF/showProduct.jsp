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

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>
    <div class="row p-5">
        <div class="col-md-offset-3 col-md-6">
            <h1><c:out value="${product.name}"/></h1>


                <ul>
                <c:forEach items="${ product.categories }" var="c">

                        <li> <c:out value="${c.name}"/></li>

                </c:forEach>


                </ul>

        </div>
        <form:form cssClass="col-md-offset-3 col-md-6" action="/products/${product.id}" method="post" modelAttribute="association">

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
    </div>
</body>
</html>
