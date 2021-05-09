<%-- 
    Document   : produto
    Created on : 28/04/2021, 21:13:12
    Author     : HOME
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Produto</title>
    </head>
    <body class="container">
        <c:import url="../header.jsp" />
        <h1>Produto</h1>
        
        <form action="CadastraProdutoServlet" method="POST">
        <label class="form-label">Placa</label>
        <input type="text" name="placa" required="true" class="form-control"/>
        <label class="form-label">Nome</label>
        <input type="text" name="nome" required="true" class="form-control"/>
        <label class="form-label">Quantidade</label>
        <input type="text" name="quantidade" required="true" class="form-control"/>
        <label class="form-label">Valor Unitário</label>
        <input type = "text" name="precoUnit" required="true" class="form-control"/>
        <label class="form-label">Loja</label>
        <input type = "text" name="loja" required="true" class="form-control"/><br>
        
        <button type ="submit" class="btn-primary">Incluir</button>
        
        </form>
        
        <br/>         
        <a href="../ProdutoServlet">Voltar</a>
    </body>
</html>