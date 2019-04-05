<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>Login</title>
	</head>
	<body>
		<form action="/springtemplate/register/attempt?${_csrf.parameterName}=${_csrf.token}" method = "post">
		  username:<br>
		  <input type="text" name="username"><br>
		  password:<br>
		  <input type="password" name="password"><br>
		  name:<br>
		  <input type="text" name="name"><br>
		  email:<br>
		  <input type="text" name="email"><br>
		  <input type="submit" value="Submit">
		</form>
	</body>
</html>