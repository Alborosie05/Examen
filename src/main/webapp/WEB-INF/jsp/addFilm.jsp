<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,es.salesianos.model.*" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>


	<form:form action="addFilm" method="post" modelAttribute="film">
		<span>title:</span> <form:input type="text" path="title" name="title"/> <br />
		<input type="submit">
	</form:form>
	
<table border="1">
	<thead>
		<tr>
			<td>CodFilm</td>
			<td>Title</td>
			<td>codDirector</td>
			<td>Delete</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="film" items="${listAllFilms}">
			<tr>
				<td><c:out value="${film.cod}"/> </td>
				<td><c:out value="${film.title}"/> </td>
				<td><c:out value="${film.codDirector}"/> </td>
				<td><a href="/deleteFilm?cod=${film.cod}">Delete</a> </td>
	    	</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>