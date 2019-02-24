<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored ="false" %>

<%@page pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Statistic</title>
</head>
<body>
<header>
    <h2>Statistic</h2>
</header>

<a href="index.jsp">Back to questionnaire</a>
<br/>
<br/>

<p>1. Do you like Java? - Yes:${rez[0]}  ,No: ${rez[1]} </p>
<p>2. Do you like .NET? - Yes:${rez[2]} ,No:${rez[3]} </p>
<p>3. Do you like JavaScript? - Yes:${rez[4]} ,No:${rez[5]} </p>
<p>Total profiles: ${total}</p>
<table>
    <caption>The form was filled:</caption>
    <tr>
        <th>Name</th>
        <th>Last name</th>
        <th>Age</th>
    </tr>

</table>
</body>
</html>


