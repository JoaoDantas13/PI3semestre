<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Relatório Sintético</title>
    </head>
    <body class="container" background="../../Background.png" bgproperties="fixed">
        
         <div class="header-1">
             <c:import url="../../header.jsp"/>
        </div>
        
        <form action="GerarRelatorioSinteticoServlet">
            <label>Data Inicial:</label>
            <input type="date" id="datainicial" name="datainicial" required="true">
            <label>Data Final:</label>
            <input type="date" id="datafinal" name="datafinal" required="true">
            <label>Visualizar por:</label>
            <select name ="buscapor">
                <option value="produto">Produto</option>
                <option value="cliente">Cliente</option>
                <option value="filial">Filial</option>
            </select>
            <button type="submit">Gerar</button>
        </form>
        
        <br/><br/>
        
        <a href="../index.jsp"><button type="button" class="btn btn-danger">Voltar</button></a>
    </body>
</html>
