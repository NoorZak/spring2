<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h1><c:out value="${person.firstName}${person.lastName}"/></h1>
<p>License Number: <c:out value="${person.license.numberAsString}"/></p>
<p>State: <c:out value="${person.license.state}"/></p>
<p>Expiaration Date: <c:out value="${person.license.expirationDate}"/></p>
