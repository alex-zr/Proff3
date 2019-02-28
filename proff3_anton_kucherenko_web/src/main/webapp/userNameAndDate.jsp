<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Date/Time + User + Counter print example</title>
</head>
<body>

<%
    Object name = request.getAttribute("userName");
    Date date = new Date();
    out.println(date);
%>
</p>

<%= global++ %>

<%! private static int global = 0;%>

${userName}


</body>
</html>
