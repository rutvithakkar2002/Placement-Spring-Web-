<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Student</title>
<jsp:include page="AllCss.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="Header.jsp"></jsp:include>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-4">

				<h2>New Student</h2>
				<br>
				<form action="updateuser" method="post" autocomplete="off">

					FirstName:<input class="form-control" type="text" name="firstname" value="${student.firstname}"><br>
					LastName:<input class="form-control" type="text" name="lastname" /><br>
					Email:<input class="form-control" type="text" name="email" /><br>
					Gender: Male<input type="radio" name="gender" value="male" />
							Female<input type="radio" name="gender" value="female" /><br><br>			
					SSC:<input class="form-control" type="text" name="ssc" /><br>
					HSC:<input class="form-control" type="text" name="hsc" /><br>
					BachelorCgpa:<input class="form-control" type="text" name="bachelorcgpa"/><br>
					University:<input class="form-control" type="text" name="university"/><br>
					Branch:<input class="form-control" type="text" name="branch"/><br>
					ContactNum:<input class="form-control" type="text" name="contactnum"/><br>
					<button type="submit" class="btn btn-primary">Save Student</button>
				
				</form>

			</div>

		</div>


	</div>

	<jsp:include page="AllJs.jsp"></jsp:include>

</body>
</html>