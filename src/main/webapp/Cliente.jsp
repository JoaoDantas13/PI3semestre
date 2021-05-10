<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cliente</title>
    </head>
    <body class="container">
        
        <div class="header-1">
            <c:import url="/header.jsp"/>
        </div>
        
        <h1>Tela de Clientes</h1>
                        
        <br/>
        <a href="clientes/cadastrar.jsp"><button type="button" class="btn btn-primary">Cadastar os Clientes</button></a>
                        
        <br/><br/>
        <a href="ClienteServlet"><button type="button" class="btn btn-primary">Lista de Clientes</button></a>
        
        <br/><br/>
        <a href="clientes/ativarCliente.jsp"><button type="button" class="btn btn-primary">Clientes Inativados</button></a>
                
        <br/><br/>
        <a href="index.jsp">Voltar</a>
    </body>
</html>
