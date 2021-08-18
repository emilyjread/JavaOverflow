<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Show Question</title>
</head>
<body>
<a href="/questions">Back to all questions</a>
<h1><c:out value="${question.question}"/></h1>
<ul>
	<c:forEach items="${question.answers}" var= "a">
		<li><c:out value="${a.answer}"/></li>
	</c:forEach> 
</ul>
	
<form:form action="/addAnswer" method="post" modelAttribute="ans">

    <p>
        <form:label path="answer"> Answer: </form:label>
         <form:errors path="answer"/>
        <form:textarea path="answer"/>
    </p>
    <p> 
        <form:label path="question"/> 
        <form:input type="hidden" path="question" value= "${question.id}"/>
    </p>  
    <input type="submit" value="Answer"/>
</form:form>   

	
</body>
</html>