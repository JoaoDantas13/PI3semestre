
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Clientes</title>
    </head>
    <body class="container">
        
         <div class="header-1">
            <h1 class="ttsp">Speed Racer</h1>
        </div>
        
        <h1>Clientes:</h1>
        
        <table>
            
            <th>Nome</th>
            <th>Email</th>
            <th>CPF</th>
            <th>Endereco</th>
            <th>Cidade</th>
            <th>Sexo</th>
            
            <c:forEach items="${listaClientes}" var="cliente">
                
                <tr>
                    
                    <td>${cliente.nome}</td>
                    <td>${cliente.email}</td>
                    <td>${cliente.cpf}</td>
                    <td>${cliente.endereco}</td>
                    <td>${cliente.cidade}</td>
                    <td>${cliente.sexo}</td>
                    
                    <td><a href="AlterarClienteServlet?cpf=${cliente.cpf}">Alterar</a></td>
                    <td><button type="button">Inativar</button></td>
                                        
                </tr>
            </c:forEach>
        </table>
                     
         <br/><br/>
        <a href="Cliente.jsp">Voltar</a>
    </body>
</html>
