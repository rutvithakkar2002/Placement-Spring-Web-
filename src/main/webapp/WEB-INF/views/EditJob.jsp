<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Job</title>
</head>
<body>

	<form action="savejob" method="post" enctype="multipart/form-data">

		Jobtitle:<input type="text" name="title" value="${job.title}"><br>
		<br> JobDescription: <input type="file" name="jdUrl" value="${job.jdUrl}"><br>
		<br> <input type="submit" value="upload">
	</form>

</body>
</html>