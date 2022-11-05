<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Jobs</title>
</head>
<body>

	<table border="1">

		<tr>
			<td>Jobid</td>
			<td>Jobtitle</td>
			<td>JobDescriptionurl</td>
			<td>Action</td>
		</tr>

		<c:forEach items="${jobs}" var="j">

			<tr>

				<td>${j.jobId}</td>
				<td>${j.title}</td>
				<td><a href="${j.jdUrl}" target="_blank">JD</a></td>
				<td><a href="deletejob?jobId=${j.jobId}">delete</a>|
					<a href="editjob?jobId=${j.jobId}">Edit</a>
				</td>


			</tr>


		</c:forEach>

	</table>

</body>
</html>