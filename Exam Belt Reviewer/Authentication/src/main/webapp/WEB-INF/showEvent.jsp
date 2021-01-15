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
<style>
    textarea {
        overflow-y: scroll;
        height: 100px;
        resize: none; /* Remove this if you want the user to resize the textarea */
    }
</style>
</head>

<div class="row">
<div class="col-md-offset-3 col-md-6">

<h1>${event.name}</h1>
    <ul>
        <li>Host:${event.planner}</li>
        <li>Date:${event.eventDate}</li>
        <li>Location:${event.city}${event.state}</li>
        <li>People who are attending: ${event.attendees.size()}</li>

    </ul>


<table  class="table">
    <thead class="thead-dark">
    <tr>
        <th>Name</th>

        <th>Location</th>


    </tr>
    </thead>
<tbody>
    <c:forEach items="${att}" var="at">

        <tr>
            <td>${at.firstName}${at.lastName}</td>
            <td>${at.city}</td>

        </tr>

    </c:forEach>

    </tbody>
</table>

</div>
<div class="col-md-offset-3 col-md-6">

    <fieldset class="border border-primary overflow-auto" >
        <c:forEach items="${ event.messages }" var="message">
            <p>${ message.author.firstName } says: ${ message.content }</p>
        </c:forEach>
    </fieldset>

    <form:form  method="POST" action="/message/${event.id}" modelAttribute="message">

        <div class="form-group">
            <form:label  class="control-label" path="content">Add Comment</form:label>
            <form:errors path="content"/>
            <form:input  class="form-control" path="content"/>
        </div>

        <input type="submit" value="Add!"/>
    </form:form>




</div>
    </div>

</body>
</html>
