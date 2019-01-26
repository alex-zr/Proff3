<%@ page import="java.util.Date" %>
<html>
    <body>
        <h2>Hello Proff3</h2>
        <a href="http://localhost:8080/serv">ServletExample</a>

        <form action="/hello" method="get">
            <input type="text" name="login" value="Zurab"/><br/>
            <input type="password" name="password" value="Zurab"/><br/>
            <input type="submit" value="Login"/>
        </form>

        <%
            Object name = request.getAttribute("userName");
            Date date = new Date();
            out.println(name);
        %>
        <p/>
        <%= global++ %>
        <%! private static int global = 0;%>

        ${userName}
    </body>
</html>
