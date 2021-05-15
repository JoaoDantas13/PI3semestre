<%-- 
    Document   : relatorio
    Created on : 14/05/2021, 12:13:40
    Author     : saulo.ambezerra
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body class="container">
        
        <div class="header-1">
            <c:import url="/header.jsp"/>
        </div>
        <h1>Relatório</h1>
        
        <table class="table">
            <th>placa</th>
            <th>cpf</th>
            <th>precoUnit</th>
            <th>filial</th>
            <th>data</th>
            
            <c:forEach items="${listaVendas}" var="venda">
                <tr>
                    <td>${venda.placa}</td>
                    <td>${venda.cpf}</td>
                    <td>${venda.precoUnit}</td>
                    <td>${venda.filial}</td>
                    <td>${venda.data}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>