<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>Welcome</title>
	</head>
	<body>
		<ul> 
			<c:forEach items="${users}" var="user">
         		<li>
         			<span>name ${user.getName()}</span>
         			<span>email ${user.getEmail()}</span>
         		</li>
      		</c:forEach>
		</ul>
	</body>
</html>