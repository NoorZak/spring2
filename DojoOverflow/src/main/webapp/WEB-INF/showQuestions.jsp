<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 1/12/2021
  Time: 12:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>
<div class="row p-5">


        <h1>Questions Dashboard</h1>

        <table  class="table">
            <thead class="thead-dark">
            <tr>
                <th>Questions</th>

                <th>Tags</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${questions}" var="q">



            <tr>
                <td><a href="/questions/${q.id}">${q.question}</a></td>
                <td>
                <c:forEach items="${q.tags  }" var="t">
                    ${t.subject},
                </c:forEach>

                </td>

            <tr>
                </c:forEach>

            </tbody>
        </table>
</div>
</body>
</html>
