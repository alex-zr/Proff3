<%--
  Created by IntelliJ IDEA.
  User: Latitude
  Date: 28.02.2019
  Time: 12:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>authorization</title>
</head>
<body>
<div align="center">
    <h2>Ok</h2>
<%--<h2>where +${result}</h2>--%>

    <h2>Form for new users</h2>
    <form action="/add_user" method="POST">
        Login: <input type="text" name="login">
        Password: <input type="text" name="password">
        <input type="submit"/>
    </form>


<br>

</form>
</div>
</body>
</html>
