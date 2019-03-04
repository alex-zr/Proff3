<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
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

        <input class="form-control form-group" type="text" name="login" placeholder="Login">
        <input class="form-control form-group" type="password" name="pass" placeholder="Password">

        <input type="submit" class="btn btn-primary" value="Login">
        <input type="button" class="btn btn-primary" value="New User" id="button_new_user">
        <input type="button" class="btn btn-primary" value="Cancel" id="button_cancel">
    </form>
    <div class="alert alert-danger" role="alert" style="display: ${no_name};">
        <strong>User with login: "${login}" not found!</strong> Change a few things up and try submitting again.
    </div>
    <div class="alert alert-warning" role="alert" style="display: ${no_pass};">
        <strong> Wrong password!</strong>
    </div>
    <div class="alert alert-success" role="alert" style="display: ${ok_login};">
        <strong> "${login}", welcome to the system!)</strong>
    </div>
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