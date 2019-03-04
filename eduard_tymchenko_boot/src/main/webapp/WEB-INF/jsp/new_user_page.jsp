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

        <input class="form-control form-group required" type="text" name="login" placeholder="Login" id="user_login">
        <span id='message'></span>
        <input class="form-control form-group required" type="password" name="pass" placeholder="Password" id="user_pass">
        <input class="form-control form-group required" type="password" name="pass_repeat" placeholder="Repeat password" id="user_pass_rep">

        <input type="submit" class="btn btn-primary" value="Add User" id="add_user">
        <input type="button" class="btn btn-primary" value="Cancel" id="button_cancel">
    </form>
    <div class="alert alert-warning" role="alert" style="display: ${exists};">
        <strong> User with this name is exist!</strong>
    </div>
    <div class="alert alert-success" role="alert" style="display: ${ok_add};">
        <strong> User: "${login}", added to the system!)</strong>
    </div>
</div>
<script>
    $("#button_cancel").click(function () {
        window.location.href = '/';
    });

    $(document).ready(function(){
        $("form").submit(function() {
            var isFormValid = true;
            var mAlert;
            // обязательные поля отмечены классом required
            $(this).find(".required").each(function(){

                if ($.trim($("#user_login").val()).length == 0){
                    isFormValid = false;
                    mAlert = "Error! Login is empty! ";
                } else if ($("#user_pass").val() != $("#user_pass_rep").val() ){
                    isFormValid = false;
                    mAlert = "Error! Passwords do not match! ";
                } else if ($("#user_pass").val().length == 0 ) {
                    isFormValid = false;
                    mAlert = "Error! Password is empty! ";
                }
            });
            if (!isFormValid) {
                alert(mAlert);
            }
            return isFormValid;
        });
    });
</script>
</body>
</html>