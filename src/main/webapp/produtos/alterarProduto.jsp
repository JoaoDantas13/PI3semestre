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
        
        <form action="AlterarProdutoServlet" method="POST">
        <label>Placa</label>
        <input type="text" name="placa" required="true" value="${produto.placa}" readonly="true"/>
        <label>Nome</label>
        <input type="text" name="nome" required="true" value="${produto.nome}"/>
        <label>Quantidade</label>
        <input type="text" name="quantidade" required="true" value="${produto.quantidade}"/><br>
        <label>Valor Unitário</label>
        <input type = "text" name="precoUnit" required="true" value="${produto.precoUnit}"/>
        <label>Loja</label>
        <input type = "text" name="loja" required="true" value="${produto.loja}"/>
        <label>Status</label>        
        <input type = "text" name="status" required="true" value="${produto.status}"/><br>
        
        <button type ="submit">Atualizar</button>
        
        </form>
        
        <br/>         
        <a href="../PI3semestre/ProdutoServlet">Voltar</a>
    </body>
</html>