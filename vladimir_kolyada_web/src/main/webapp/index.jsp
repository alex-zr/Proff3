<%@ page import="java.util.Date" %>
<html>
<body>
<h2>Hello World!</h2>
<a href="serv">Servlet</a>
<form action="hello" method="get" target="_self">
    <input type="text" name="login" value="Zurab"><br>
    <input type="password" name="password" ><br>
    <input type="submit" value="Login"><br>
</form>
    <%
        Date date = new Date();
        out.println(date);
    %>
<br>
<%=
    1 + ++gl +global
%>
<br>
<%!
    private static String global = " GlobalString";
    private  static int gl= 1;
%>
</body>
</html>
