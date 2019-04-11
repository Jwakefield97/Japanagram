<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form action="/springtemplate/login/attempt?${_csrf.parameterName}=${_csrf.token}" method = "post">
  username:<br>
  <input type="text" name="username"><br>
  password:<br>
  <input type="password" name="password"><br>
  <input type="submit" value="Submit">
</form>
<a href="/springtemplate/register">register an account</a>