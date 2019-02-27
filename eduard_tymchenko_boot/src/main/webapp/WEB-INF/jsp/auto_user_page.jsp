<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login User</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <form role="form" class="form-horizontal" action="/contact/add" method="post">
        <h3>Login User</h3>

        <input class="form-control form-group" type="text" name="name" placeholder="Name">
        <input class="form-control form-group" type="text" name="surname" placeholder="Login">

        <input type="submit" class="btn btn-primary" value="login">
    </form>
</div>
</body>
</html>