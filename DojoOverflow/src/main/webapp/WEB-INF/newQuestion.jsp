<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 1/11/2021
  Time: 10:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>What is your question</h1>
<form:form action="/questions" method="post" modelAttribute="newquestion">
    <div class="form-group">
        <form:label path="question">Question</form:label>
        <form:errors path="question"/>
        <form:textarea class="form-control" path="question"></form:textarea>
    </div>
    <div class="form-group">
        <form:label path="tags">Tags</form:label>
        <form:errors path="tags"/>
        <form:input class="form-control" path="tags"/>
    </div>
    <button>Submit</button>
</form:form>

</body>
</html>
