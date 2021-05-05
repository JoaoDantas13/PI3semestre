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
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Produto</title>
    </head>
    <body>
        <c:import url="header.jsp" />
        <h1>Produto</h1>
        <label>Placa</label>
        <input type="text">
        <label>Nome</label>
        <input type="text">
        <label>Quantidade</label>
        <input type="number"><br>
        <label>Valor Unitário</label>
        <input type = "number"><br>
        <button type ="button">Incluir</button>
        <button type="button">Alterar</button>
        <button type ="button">Inativar</button>
        <c:import url="footer.jsp" />
        <br/>         
        <a href="ProdutoServlet">Voltar</a>
    </body>
</html>