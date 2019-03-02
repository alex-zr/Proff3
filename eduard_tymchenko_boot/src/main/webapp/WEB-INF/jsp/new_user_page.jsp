<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New User</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <form role="form" class="form-horizontal" action="/new/user" method="post">
        <h3>New User</h3>

        <input class="form-control form-group" type="text" name="login" placeholder="Login">
        <input class="form-control form-group" type="password" name="password" placeholder="Password">
        <input class="form-control form-group" type="password" name="password" placeholder="Repeat password">

        <input type="submit" class="btn btn-primary" value="Add User">
        <input type="button" class="btn btn-primary" value="Cancel" id="button_cancel">
    </form>
</div>
<script>
    $("#button_cancel").click(function () {
        window.location.href = '/';
    });
</script>
</body>
</html>