<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login User</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <form role="form" class="form-horizontal" action="/login/user" method="post">
        <h3>Login User</h3>

        <input class="form-control form-group" type="text" name="name" placeholder="Login">
        <input class="form-control form-group" type="password" name="surname" placeholder="Password">

        <input type="submit" class="btn btn-primary" value="Login">
        <input type="button" class="btn btn-primary" value="New User" id="button_new_user">
        <input type="button" class="btn btn-primary" value="Cancel" id="button_cancel">
    </form>
</div>
<script>
    $("#button_cancel").click(function () {
        window.location.href = '/';
    });
    $("#button_new_user").click(function () {
        window.location.href = '/new_user_page';
    });
</script>
</body>
</html>