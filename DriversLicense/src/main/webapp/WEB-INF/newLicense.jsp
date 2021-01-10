
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>New Person</h1>
<form:form action="/licenses" method="post" modelAttribute="license">


    <p>
        <form:label path="person">Person</form:label>
        <form:errors path="person"/>
        <form:select path="person">
            <c:forEach items="${ persons }" var="p">
                <form:option value="${ p }">${ p.firstName } ${ p.lastName }</form:option>
            </c:forEach>
        </form:select>
    </p>


    <p>
        <form:label path="state">State</form:label>
        <form:errors path="state"/>
        <form:input path="state"/>
    </p>


    <p>
        <form:label path="expirationDate">Expiration Date</form:label>
        <form:errors path="expirationDate"/>
        <form:input  type="date" path="expirationDate"/>
    </p>

 <input type="submit" value="Submit"/>
</form:form>