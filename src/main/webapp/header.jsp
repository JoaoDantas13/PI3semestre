<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script  src = "${pageContext.request.contextPath}/lib/jquery-3.6.0.min.js"  type = "text/javascript" > </script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">
        </head>
    <body class="container" background="Background.png" bgproperties="fixed">
        <h1 class="ttsp">Speed Racer</h1> <br/>
        
        <c:if test="${not empty sessionScope.usuario}">
            
            <p>Usuário:${sessionScope.usuario.nome}</p>
            <p>Perfil:${sessionScope.usuario.perfil}</p>
            <a href="<c:url value="/LogoutServlet"/>">Sair</a>
            
        </c:if>
        
    </body>
</html>
