<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 1/10/2021
  Time: 10:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1><c:out value="${dojo.name}"/></h1>

    <table>
        <thead>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Age </th>
            </tr>
        </thead>
        <tbody>

            <c:forEach items="${ dojo.ninjas }" var="n">

                <tr>
                    <td> <c:out value="${n.firstName}"/></td>
                    <td> <c:out value="${n.lastName}"/></td>
                    <td> <c:out value="${n.age}"/></td>
                </tr>

            </c:forEach>

        </tbody>
    </table>


</body>
</html>
