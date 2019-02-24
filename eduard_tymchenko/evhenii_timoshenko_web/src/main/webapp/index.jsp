<%@ page import="java.time.LocalDate" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>prog.kiev.ua</title>
</head>
<body>
<a href="http://localhost:8080/serv">Анкета</a>


<form action="/hello" method="get">
    <input type="text" name="login" value=""/><br/>
    <input type="password" name="password" value=""/><br/>
    <input type="submit" value="Login"/>
</form>

<form action="/question" method="POST">

    <br/> Do you like cars?
    <br/><input type="radio" name="question1" value="yes">
    <br/><input type="radio" name="question1" value="no">

    <br/> Do you like animals?
    <br/><input type="radio" name="question2" value="yes">
    <br/><input type="radio" name="question2" value="no">

    <br/> Do you like sunny weather?
    <br/><input type="radio" name="question3" value="yes">
    <br/><input type="radio" name="question3" value="no">

    <br/> <input type="submit"/>
</form>
</body>
</html>

