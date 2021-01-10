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


<table>
    <thead>
    <tr>
        <th>Name</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach items="${ dojos }" var="d">

        <tr>
            <td><a href="/dojos/${d.id}"> <c:out value="${d.name}"/></a></td>
        </tr>

    </c:forEach>

    </tbody>
</table>


</body>
</html>
