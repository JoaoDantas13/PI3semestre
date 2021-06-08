<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Relatorio</title>
    </head>
    <body class="container" background="../../Background.png" bgproperties="fixed">
        
        <div class="header-1">
            <c:import url="../../header.jsp"/>
        </div>
        <h1>Relatório</h1>
        
        <table class="table">
            <th>${buscaPor}</th>
            <th>quantidade</th>
            <th>valor total</th>
            
            <c:forEach items="${relatorio}" var="venda">
                <tr>
                    <td>${venda.nome}</td>
                    <td>${venda.quantidade}</td>
                    <td>${venda.total}</td>                    
                </tr>
            </c:forEach>
        </table>
            
        <br/><br/>
        
        <a href="../menuRelatorioSintetico.jsp">Voltar</a>
    </body>
</html>