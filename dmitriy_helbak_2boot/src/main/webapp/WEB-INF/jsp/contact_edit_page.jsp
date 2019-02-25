<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>New Contact</title>

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
    </head>
    <%--<body>--%>
        <%--<div class="container">--%>
            <%--<form role="form" class="form-horizontal" action="/contact/edit" method="post">--%>
                        <%--<h3>Edit contact</h3>--%>
                        <%--<select class="form-control form-group" name="group">--%>
                            <%--<option value="-1">Default</option>--%>
                            <%--<c:forEach items="${groups}" var="group">--%>
                                <%--<option value="${group.id}"--%>
                                        <%--<c:if test="${group.id eq contact.group.id}">--%>
                                            <%--selected--%>
                                        <%--</c:if>--%>
                                <%-->${group.name}</option>--%>
                            <%--</c:forEach>--%>
                        <%--</select>--%>
                        <%--<input type="hidden" name="userId" value=${contact.id}>--%>
                        <%--<input class="form-control form-group" type="text" name="name" placeholder="Name" value=${contact.name}>--%>
                        <%--<input class="form-control form-group" type="text" name="surname" placeholder="Short description" value=${contact.surname}>--%>
                        <%--<input class="form-control form-group" type="text" name="phone" placeholder="Long description" value=${contact.phone}>--%>
                        <%--<input class="form-control form-group" type="text" name="email" placeholder="Phone" value=${contact.email}>--%>
                    <%--<input type="button" class="btn btn-primary" value="Save"id="button_save">--%>
                    <%--<input type="button" class="btn btn-primary" value="Cancel" id="button_cancel">--%>
            <%--</form>--%>
        <%--</div>--%>
    <%--<script>--%>
        <%--$('#button_cancel').click(function(){--%>
            <%--window.location.href='/';--%>
        <%--});--%>


        <%--$('#button_save').click(function(){--%>
            <%--window.location.href='/';--%>
        <%--});--%>


    <%--</script>--%>
    <%--</body>--%>

    <body>
    <div class="container">
        <form role="form" class="form-horizontal" action="/contact/edit" method="post">
            <h3>Edit contact</h3>
            <select id="sel" class="form-control form-group" name="group">
                <option value="-1">Default</option>
                <c:forEach items="${groups}" var="group">
                    <option value="${group.id}">${group.name}</option>
                </c:forEach>
            </select>
            <input type="hidden" name="userId" value=${contact.id}>
            <input class="form-control form-group" type="text" name="name" placeholder="Name" value="${contact.name}">
            <input class="form-control form-group" type="text" name="surname" placeholder="Short description"
                   value="${contact.surname}">
            <input class="form-control form-group" type="text" name="phone" placeholder="Long description"
                   value="${contact.phone}">
            <input class="form-control form-group" type="text" name="email" placeholder="Phone" value="${contact.email}">
            <input type="submit" class="btn btn-primary" value="Save">
            <input type="button" class="btn btn-primary" value="Cancel" id="button_cancel">
        </form>
    </div>
    <script>
        $("#sel [value='" + ${contact.group.id} +"']").attr("selected", "selected");
        $("#button_cancel").click(function () {
            window.location.href = '/';
        });
    </script>
    </body>


</html>