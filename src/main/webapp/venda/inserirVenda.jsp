<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Venda</title>
    </head>
    <body class="container">
        <c:import url="../header.jsp"/>
        
        <c:if test="${empty venda}">
        <form action="CadastrarVendaServlet" method="POST">
            
            <label class="form-label">Placa:</label><br/>
            <input type="text" name="placa" required="true" class="form-control" required/> <br/><br/>
            
            <label class="form-label">Marca:</label><br/>
            <input type="text" name="marca" required="true" class="form-control" required/> <br/><br/>
            
            <label class="form-label">Nome:</label><br/>
            <input type="text" name="nome" required="true" class="form-control" required/> <br/><br/>
            
            <label class="form-label">CPF do Cliente:</label><br/>
            <input type="text" name="cpfCli" required="true" class="form-control" required/> <br/><br/>
            
            <label class="form-label">Quantidade:</label><br/>
            <input type="text" name="quantidade" required="true" class="form-control" required/> <br/><br/>
            
            <label class="form-label">Preço Unitário:</label><br/>
            <input type="text" name="precoUnit" required="true" class="form-control" required/> <br/><br/>
            
            <label class="form-label">Filial:</label><br/>
            <input type="text" name="filial" required="true" class="form-control" required/> <br/><br/>
            
            <button type="submit" class="btn btn-primary">Realizar Venda</button>
                
        </form>
        </c:if>
    </body>
</html>
