<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<!DOCTYPE>
<html>
	<head>
		<meta charset="utf-8">
		<title><tiles:insertAttribute name="title" /></title>
	</head>
	<body>
		<tiles:insertAttribute name="body" />
	</body>
</html>