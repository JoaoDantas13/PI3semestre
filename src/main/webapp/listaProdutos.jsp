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
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Produtos</title>
    </head>
    <body class="container">
        
         <div class="header-1">
             <c:import url="header.jsp"/>
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
                            <a href="incluirProduto.jsp">Incluir</a></button>
                    </div>                    
         
        
        <c:import url="footer.jsp"/>
    
    </body>
</html>