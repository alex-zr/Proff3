<%@ page import="java.time.LocalDate" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>prog.kiev.ua</title>
</head>
<body>
<h1> Current time : <%= LocalDateTime.now()%></h1>
<form action="/question" method="POST">

    <br/><input type="radio" name="question1" value="yes">
    <br/><input type="radio" name="question1" value="no">

    <br/> Do you like animals?
    <br/><input type="radio" name="question1" value="yes">
    <br/><input type="radio" name="question1" value="no">

    <br/> <input type="submit"/>
</form>
</body>
</html>
