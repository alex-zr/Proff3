<%@ page import="java.util.Date" %>
<html>
<body>
<h2>Hello from index.jsp!</h2>
<a href="http://localhost:8080/dmitriy_helbak_web_war_exploded/serv">serv</a>
<br/>
<a href="http://localhost:8080/dmitriy_helbak_web_war_exploded/serv2">serv2</a>
<form action="/hello" method="get"></form>
<%
    Date date = new Date();
    out.println(date);
%>
<%= 1 + 4 %>
<%= global++%>%>
<%! private static int global = 0;%>
</body>
</html>
