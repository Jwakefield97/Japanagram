<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<ul> 
	<c:forEach items="${users}" var="user">
   		<li>
   			<span>name ${user.getName()}</span>
   			<span>email ${user.getEmail()}</span>
   		</li>
	</c:forEach>
</ul>