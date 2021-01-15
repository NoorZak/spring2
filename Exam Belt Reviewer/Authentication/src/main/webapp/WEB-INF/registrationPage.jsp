<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration Page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<h1>Register!</h1>

<%--<p><form:errors path="user.*"/></p>--%>
<div class="row p-5">

<form:form class="col-md-offset-3 col-md-6" method="POST" action="/registration" modelAttribute="user">

<div class="form-group">
    <form:label class="control-label" path="firstName">First Name:</form:label>
    <form:errors  path="firstName"/>
    <form:input class="form-control" type="text" path="firstName"/>
</div>

    <div class="form-group">
        <form:label class="control-label" path="lastName">Last Name:</form:label>
        <form:errors path="lastName"/>
        <form:input  class="form-control" type="text" path="lastName"/>
</div>
<div class="form-group">
        <form:label class="control-label" path="email">Email:</form:label>
        <form:errors path="email"/>
        <form:input class="form-control" type="email" path="email"/>
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

    <div class="form-group">

    <form:label class="control-label" path="password">Password:</form:label>
        <form:errors path="password"/>

        <form:password  class="form-control" path="password"/>
    </div>>

<div class="form-group">
        <form:label  class="control-label" path="passwordConfirmation">Password Confirmation:</form:label>
            <form:errors path="passwordConfirmation"/>

        <form:password  class="form-control" path="passwordConfirmation"/>
</div>

    <input type="submit" value="Register!"/>
</form:form>



    <form class="col-md-offset-3 col-md-6" method="post" action="/login">
        <p><c:out value = "${error}"></c:out> </p>
        <div class="form-group">
            <label class="control-label" for="email1">Email</label>
            <input class="form-control" type="text" id="email1" name="email1"/>
        </div>
        <div class="form-group">
            <label class="control-label" for="password1">Password</label>
            <input  class="form-control" type="password" id="password1" name="password1"/>
        </div>
        <input type="submit" value="Login!"/>
    </form>
</body>
</html>