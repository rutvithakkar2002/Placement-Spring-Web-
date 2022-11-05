<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Student</title>
</head>
<body>
	<h3>List Student</h3>
	<table border="1">
		<tr>
			<th>StudentId</th>
			<th>FirstName</th>
			<th>lastName</th>
			<th>Email</th>
			<th>University</th>
			<th>Bachelorcgpa</th>
			<th>Contact number</th>
			<th>Action</th>
		</tr>


		<c:forEach items="${students}" var="s">
			<tr>
				<td>${s.studentId}</td>
				<td>${s.firstname}</td>
				<td>${s.lastname}</td>
				<td>${s.email}</td>
				<td>${s.university}</td>
				<td>${s.bachelorcgpa}</td>
				<td>${s.contactnum}</td>
				<td><a href="deletestudent?studentId=${s.studentId}">Delete</a>|
				<a href="editstudent?studentId=${s.studentId}">Edit</a></td>
			</tr>
		</c:forEach>

	</table>


</body>
</html>