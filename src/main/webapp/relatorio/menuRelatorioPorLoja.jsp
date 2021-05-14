<%-- 
    Document   : menuRelatorio
    Created on : 14/05/2021, 06:58:01
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
        <form action="GerarRelatorioPorLojaServlet">
            <label>Loja</label>
            <select name="loja">
                <option value="loja1">Loja 1</option>
                <option value="loja2">Loja 2</option>
                <option value="loja2">Loja 3</option>
                <option value="loja2">Loja 4</option>
            </select>
            <label>Data Inicial:</label>
            <input type="date" id="datainicial" name="datainicial" required="true">
            <label>Data Final:</label>
            <input type="date" id="datafinal" name="datafinal" required="true">
            <label>Seleção por:</label>
            <select name ="selecao">
                <option value ="produto">Produto</option>
                <option value ="cliente">Cliente</option>
            </select>
            <button type="submit">Gerar</button>
        </form>
    </body>
</html>