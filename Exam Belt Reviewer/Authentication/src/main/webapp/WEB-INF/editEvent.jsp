<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 1/15/2021
  Time: 12:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>





<h1><c:out value="${event.name}" /></h1>

<form:form class="col-md-offset-3 col-md-6" method="POST" action="/events" modelAttribute="event">

    <form:hidden path="id" />

    <div class="form-group">
        <form:label class="control-label" path="name">Name:</form:label>
        <form:errors  path="name"/>
        <form:input class="form-control"  path="name"/>
    </div>

    <div class="form-group">
        <form:label class="control-label" path="eventDate">Date</form:label>
        <form:errors path="eventDate"/>
        <form:input class="form-control" type="date" path="eventDate"/>
    </div>

    <div class="form-group">
        <form:label class="control-label" path="city">City</form:label>
        <form:errors path="city"/>
        <form:input  class="form-control" path="city" />
    </div>

    <div class="form-group">
        <form:label class="control-label" path="state">State</form:label>
        <form:errors path="state"/>
        <form:select class="form-control" path="state">
            <c:forEach items="${ states }" var="state">

                <c:choose>
                    <c:when  test="${ state.equals(event.state) }">
                        <option selected value="${ state }">${ state }</option>
                    </c:when>
                    <c:otherwise>
                        <option value="${ state }">${ state }</option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </form:select>
    </div>

    <input type="submit" value="Add Event"/>
</form:form>


</body>
</html>
