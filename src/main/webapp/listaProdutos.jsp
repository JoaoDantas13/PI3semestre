<%-- 
    Document   : listaProdutos
    Created on : 30/04/2021, 19:27:20
    Author     : HOME
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Produtos</title>
    </head>
    <body class="container">
        
         <div class="header-1">
            <h1 class="ttsp">Speed Racer</h1>
        </div>
        
        <h1>Produtos:</h1>
        
        <table>
            
            <th>Placa</th>
            <th>Nome</th>
            <th>Quantidade</th>
            <th>Preço Unitário</th>
            
            <c:forEach items="${listaProdutos}" var="produto">                
                <tr>                    
                    <td>${produto.placa}</td>                    
                    <td>${produto.nome}</td>
                    <td>${produto.quantidade}</td>
                    <td>${produto.precoUnit}</td>
                    

                    <td><button type="button">Alterar</button></td>
                    <td><button type="button">Inativar</button></td>                    
                </tr>
            </c:forEach>
        </table>
                     
         <br/><br/>
                    <div class ="btnincluir">
                        <button class = "inc" type="button">
                            <a href="produto.jsp">Incluir</a></button>
                    </div>                    
         
         <br/><br/>         
        <a href="index.jsp">Voltar</a>
    </body>
</html>