<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Relatório Analítico</title>
    </head>
    <body class="container" background="../../Background.png" bgproperties="fixed">
        
         <div class="header-1">
             <c:import url="../../header.jsp"/>
        </div>
        
        <form action="GerarRelatorioAnaliticoServlet">
            <label>Buscar por:</label>
            <br/>
            <select name ="buscapor">
                <option value="produto">Produto</option>
                <option value="cliente">Cliente</option>
                <option value="filial">Filial</option>
            </select>
            <input type="text" id="palavrachave" name="palavrachave">
            <br/>
            <label>Data Inicial:</label>
            <input type="date" id="datainicial" name="datainicial" required="true">
            <br/>
            <label>Data Final:</label>
            <input type="date" id="datafinal" name="datafinal" required="true">
            <button type="submit">Gerar</button>
        </form>
        
        <br/><br/>
        
        <a href="../index.jsp">Voltar</a>
    </body>
</html>
