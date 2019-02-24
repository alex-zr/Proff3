<%@page isELIgnored="false" %>
<%@page pageEncoding="UTF-8" %>

<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Questionnaire</title>
    <link rel="stylesheet" href="css/main.css">
</head>

<body>
<header>
    <h1>Анкета</h1>
</header>

    <form action="/anketa" method="POST">

        <input type="text" name="login" value=""/><br/>
        <input type="password" name="password" value=""/><br/>


        <br/>

        <br/> Do you like cars?
        <br/><input type="radio" name="question1" value="yes">
        <br/><input type="radio" name="question1" value="no">

        <br/> Do you like animals?
        <br/><input type="radio" name="question2" value="yes">
        <br/><input type="radio" name="question2" value="no">

        <br/> Do you like sunny weather?
        <br/><input type="radio" name="question3" value="yes">
        <br/><input type="radio" name="question3" value="no">
        <br/>

        <a href="/statistic.jsp" >Надіслати</a>
    </form>
</body>
</html>