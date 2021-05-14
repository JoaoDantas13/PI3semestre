<%-- 
    Document   : menuRelatorioGeral
    Created on : 14/05/2021, 08:32:08
    Author     : saulo.ambezerra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="GerarRelatorioGeralServlet">
            <label>Data Inicial:</label>
            <input type="date" id="datainicial" name="datainicial" required="true">
            <label>Data Final:</label>
            <input type="date" id="datafinal" name="datafinal" required="true">
            <label>Seleção por:</label>
            <select name ="selecao">
                <option value="produto">Produto</option>
                <option value="cliente">Cliente</option>
                <option value="Loja">Loja</option>
            </select>
            <button type="submit">Gerar</button>
        </form>
    </body>
</html>
