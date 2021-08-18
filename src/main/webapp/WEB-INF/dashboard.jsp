<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Dashboard</title>
</head>
<body>
<h1>Dashboard</h1>

<table>
    <thead>
        <tr>
            <th>Question</th>
            <th>Tags</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${questions}" var="q">
        <tr>
            <td> <a href="/questions/${q.id}"><c:out value="${q.question}"/></a></td>
            <td><c:out value="${q.tag}"/></td>
        </tr>
        </c:forEach>
    </tbody>
</table>
<a href="/questions/new">New Question</a>
</body>
</html>