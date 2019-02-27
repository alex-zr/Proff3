<%@ page import="java.util.Set" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>All photos</title>
</head>
<body>

<%
    Set<Long> allphotos= (Set) response.;
%>

<c:forEach items="${a}" var="photo">
    ${photo.field1}
    ${photo.field2}
    ${photo.field...}
    ${photo.fieldN}
    <br>
</c:forEach>


</body>
</html>
