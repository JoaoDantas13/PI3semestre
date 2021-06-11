<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cliente</title>
    </head>
    <body class="container" background="../Background.png" bgproperties="fixed">
        
        <div class="header-1">
            <c:import url="../header.jsp"/>
        </div>
        
        <h1>Tela de Clientes</h1>
                        
        <br/>
        <a href="clientes/cadastrar.jsp"><button type="button" class="btn btn-primary">Cadastar os Clientes</button></a>
                        
        <br/><br/>
        <a href="<c:url value="/ClienteServlet"/>"><button type="button" class="btn btn-primary">Lista de Clientes</button></a>
        
        <br/><br/>
        <a href="<c:url value="/ClienteInativoServlet"/>"><button type="button" class="btn btn-primary">Clientes Inativados</button></a>
                
        <br/><br/>
        <a href="index.jsp"><button type="button" class="btn btn-danger">Voltar</button></a>
    </body>
</html>
