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

<h1>Events in Your State</h1>

<table  class="table">
    <thead class="thead-dark">
    <tr>
        <th>Name</th>

        <th>Date</th>

        <th>Location</th>

        <th>Host</th>

        <th>Action/Status</th>

    </tr>
    </thead>

    <tbody>
    <c:forEach items="${events}" var="e">

    <tr>
        <td><a href="/events/${e.id}">${e.name}</a></td>
        <td>${e.eventDate}</td>
        <td>${e.city}</td>
        <td>${e.planner.firstName}${e.planner.lastName}</td>
        <td>
            <c:choose>

                <c:when test="${sessionScope.user_id== e.planner.id}">
                <a href="/edit/${e.id}">Edit</a>
                <a href="/delete/${e.id}">Delete</a>
                </c:when>

                <c:otherwise >
                    <c:choose>

                        <c:when test="${e.attendees.contains(user)}">
                            <a href="/cancel/${e.id}">Cancel</a>
                        </c:when>

                        <c:otherwise >
                            <a href="/join/${e.id}">Join</a>

                        </c:otherwise>

                    </c:choose>
                </c:otherwise>

            </c:choose>


        </td>

    </tr>

    </c:forEach>

    </tbody>
</table>




<h1>Events Not in Your State</h1>
<table  class="table">
    <thead class="thead-dark">
    <tr>
        <th>Name</th>

        <th>Date</th>

        <th>Location</th>

        <th>State</th>

        <th>Host</th>

        <th>Action/Status</th>

    </tr>
    </thead>

    <tbody>
    <c:forEach items="${eventsNot}" var="e">

        <tr>
            <td><a href="/events/${e.id}">${e.name}</a></td>
            <td>${e.eventDate}</td>

            <td>${e.city}</td>
            <td>${e.state}</td>

            <td>${e.planner.firstName}${e.planner.lastName}</td>
            <td>
                <c:choose>

                    <c:when test="${sessionScope.user_id== e.planner.id}">
                        <a href="/edit/${e.id}">Edit</a>
                        <a href="/delete/${e.id}">Delete</a>
                    </c:when>

                    <c:otherwise >
                        <c:choose>

                            <c:when test="${e.attendees.contains(user)}">
                                <a href="/cancel/${e.id}">Cancel</a>
                            </c:when>

                            <c:otherwise >
                                <a href="/join/${e.id}">Join</a>

                            </c:otherwise>

                        </c:choose>

                    </c:otherwise>

                </c:choose>
            </td>
        </tr>

    </c:forEach>

    </tbody>
</table>





<form:form class="col-md-offset-3 col-md-6" method="POST" action="/events/${event.id}" modelAttribute="event">

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
                <option value="${ state }">${ state }</option>
            </c:forEach>
        </form:select>
    </div>

    <input type="submit" value="Add Event"/>
</form:form>


</body>
</html>
