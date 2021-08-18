<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>New Question</title>
</head>
<body>
	<h1>Add a Question</h1>
	<form:form action="/questions" method="post" modelAttribute="q">
 
    <p>
        <form:label path="question">question: </form:label>
        <form:errors path="question"/>
        <form:input path="question"/>
    </p>
    <p>
        <form:label path="tag">tags: </form:label>
        <form:errors path="tag"/>
        <form:input path="tag"/>
    </p>

    <input type="submit" value="Create Question"/>
</form:form>   
	
</body>
</html>