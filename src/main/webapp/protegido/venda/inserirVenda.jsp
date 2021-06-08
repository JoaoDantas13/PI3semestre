<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Venda</title>
    </head>
    <body class="container" background="../../Background.png" bgproperties="fixed">
        <c:import url="../../header.jsp"/>
        
        <c:if test="${empty venda}">
        <form action="${pageContext.request.contextPath}/CadastrarVendaServlet" method="POST">
            
            <label class="form-label">Placa:</label><br/>
            <input type="text" name="placa" required="true" class="form-control" /> <br/><br/>
                                   
            <label class="form-label">CPF do Cliente:</label><br/>
            <input type="text" name="cpfCli" required="true" class="form-control" /> <br/><br/>
                        
            <label class="form-label">Preço Unitário:</label><br/>
            <input type="text" name="precoUnit" required="true" class="form-control" /> <br/><br/>
            
            <label class="form-label">Loja:</label><br/>
            <input type="text" name="filial" required="true" class="form-control" /> <br/><br/>
            
            <label>Data da Venda</label><br/>
            <input type="date" name="data" required="true" class="form-control" /><br/><br/>
           
            <button type="submit" class="btn btn-primary">Realizar Venda</button> <br/><br/>
                
        </form>
        </c:if>
        
       <a href="../index.jsp">Voltar</a>
        
    </body>
</html>
