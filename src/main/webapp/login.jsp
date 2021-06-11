<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body class="container" background="Background.png" bgproperties="fixed">

        <div class="header-1">
            <c:import url="header.jsp"/>
        </div>

        <h1>Login</h1>

        <c:if test="${param.loginInvalido}">

            <div class ="alert alert-danger" role="alert">

                Ops, Usuário ou Senha inválido !!

            </div>

        </c:if>

        <form action="LoginServlet" method="POST">

            <label class="form-label">Login:</label>&nbsp;
            <input type="text" name="login" required="true" class="form-control"/> <br/><br/>

            <label class="form-label">Senha:</label>&nbsp;
            <input type="password" name="senha" required="true" class="form-control"/> <br/><br/>

            <button type="submit" class="btn btn-primary">Confirmar</button>

        </form> 
    </body>
</html>
