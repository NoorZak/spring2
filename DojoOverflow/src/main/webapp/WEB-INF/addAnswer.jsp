<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 1/12/2021
  Time: 2:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>

    <h1><c:out value="${question.question}"/></h1>

    <div class="row p-5">
    <div class="col-md-offset-3 col-md-6">

            <c:forEach items="${ question.tags }" var="tag">

        <fieldset class="d-inline border border-secondary"> <c:out value="${tag.subject}"/></fieldset>

            </c:forEach>



        <table  class="table">
            <thead class="thead-dark">
                <tr>
                    <th>Answers</th>

                </tr>
            </thead>
            <tbody>
            <c:forEach items="${question.answers}" var="a">



                <tr>
                    <td>${a.text}</td>
                <tr>

                </c:forEach>

            </tbody>
        </table>


    </div>

    <form:form cssClass="mt-5 col-md-offset-3 col-md-6" action="/questions/${question.id}" method="post" modelAttribute="answer">
        <h1>Add Your Answer></h1>

        <input type="hidden" name="_method" value="put">

    <div class="form-inline">
            <form:label path="text">Answer</form:label>
            <form:errors path="text"/>
        <form:textarea path="text"></form:textarea>

    </div>


<%--        <form:hidden path="question" value="${ question.id }"/>--%>
        <div class="ml-5">
        <input type="submit"  value="submit" />
        </div>
    </form:form>
</div>
</body>
</html>