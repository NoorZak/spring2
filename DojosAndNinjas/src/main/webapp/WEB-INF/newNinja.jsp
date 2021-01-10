<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 1/10/2021
  Time: 10:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>New Person</h1>
<form:form action="/ninjas" method="post" modelAttribute="ninja">


    <p>
        <form:label path="dojo">Dojo</form:label>
        <form:errors path="dojo"/>
        <form:select path="dojo">
            <c:forEach items="${ dojos }" var="d">
                <form:option value="${ d }">${ d.name }</form:option>
            </c:forEach>
        </form:select>
    </p>


    <p>
        <form:label path="firstName">First Name</form:label>
        <form:errors path="firstName"/>
        <form:input path="firstName"/>
    </p>


    <p>
        <form:label path="lastName">Last Name</form:label>
        <form:errors path="lastName"/>
        <form:input path="lastName"/>
    </p>


    <p>
        <form:label path="age">Age</form:label>
        <form:errors path="age"/>
        <form:input type="number" path="age"/>
    </p>

    <input type="submit" value="Submit"/>
</form:form>