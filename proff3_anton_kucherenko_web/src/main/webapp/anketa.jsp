<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Anketa Task - "POST" method</title>
</head>
<body>
<form action="anketa" method="post">
    <p>
    <h3>
        <center>Please enter your name, surname and age.</center>
    </h3>

    </p>

    <p>
    <center>
        Name: <input type="text" name="name" required/>
        Surname: <input type="text" name="surname" required/>
        Age: <input type="text" name="age" required/>
    </center>
    </p>
    <hr>

    <p>
    <h3>
        Please answer the following questions:
    </h3>
    </p>

    <p> Do you like Java?
        <br><input type="radio" name="question1" value="yes" required/> Yes
        <br><input type="radio" name="question1" value="no" required/> No
    </p>
    <hr>

    <p>Do you like .Net?
        <br><input type="radio" name="question2" value="yes" required/> Yes
        <br><input type="radio" name="question2" value="no" required/> No
    </p>
    <hr>

    <br><input type="submit"/>


</form>
</body>
</html>
