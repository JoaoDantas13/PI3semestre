<%-- 
    Document   : relatorioAnalitico
    Created on : 03/06/2021, 10:46:49
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
        
        <<table class="table">
            <th>Produto</th>
            <th>Cliente</th>
            <th>Valor</th>
            <th>Filial</th>
            <th>Data</th>
            
            <c:forEach items="${relatorio}" var="venda">
                <tr>
                    <td>${venda.produto}</td>
                    <td>${venda.cpfCli}</td>
                    <td>${venda.precoUnit}</td> 
                    <<td>${venda.filial}</td>
                    <td>${venda.data}</td>
                </tr>
            </c:forEach>
        </table>
        
    </body>
</html>
