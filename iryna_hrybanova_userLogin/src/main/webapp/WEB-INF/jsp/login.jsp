<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login&Registration</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <form role="form" class="form-horizontal" action="/user/login" method="post">
        <h3><c:if test="${success != null}">registration successful: ${success}</c:if></h3>
        <h3>Login</h3>

        <input class="form-control form-group" type="text" name="login" placeholder="Login">
        <input class="form-control form-group" type="password" name="password" placeholder="Password">

        <input type="submit" class="btn btn-primary" value="Login">
        <input type="button" class="btn btn-primary" value="Registration" id="button_registration">
    </form>
</div>
<script>
    $("#button_registration").click(function () {
        window.location.href = '/user/registration';
    });
</script>
</body>
</html>