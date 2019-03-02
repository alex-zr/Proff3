<%--
  Created by IntelliJ IDEA.
  User: Latitude
  Date: 28.02.2019
  Time: 10:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello! Who are you?</title>
</head>
<body>
<div align="center">
   <p> </p>
    <h2>Form for existing users</h2>
    <form action="/index" method="POST">
        Login: <input type="text" name="photo_id">
       Password: <input type="text" name="photo_id">
        <input type="submit"/>
    </form>

    <form action="/new_user" method="GET">
        New user:
        <input type="submit"/>

</div>
</body>
</html>
