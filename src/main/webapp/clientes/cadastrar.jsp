<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar</title>
    </head>
    <body class="conteiner">
        
        <div class="header-1">
             <c:import url="../header.jsp"/>
        </div>
        
        <h1>Cadastrar os Clientes</h1>
        
        <c:if test="${empty cliente}">
            
            <form action="CadastrarClienteServlet" method="POST">
                
                <label class="form-label">Nome:</label>&nbsp;
                <input type="text" name="nome" required="true" class="form-control"/> <br/><br/>
                
                <label class="form-label">Email:</label>&nbsp;
                <input type="text" name="email" required="true" class="form-control"/> <br/><br/>
                
                <label class="form-label">CPF:</label>&nbsp;
                <input type="text" name="cpf" required="true" class="form-control"/> <br/><br/>
                
                <label class="form-label">Endereço:</label>&nbsp;
                <input type="text" name="endereco" required="true" class="form-control"/> <br/><br/>
                
                <label class="form-label">Cidade:</label>&nbsp;
                <input type="text" name="cidade" required="true" class="form-control"/> <br/><br/>
                
                <label class="form-label">Sexo:</label>&nbsp;
                <input type="text" name="sexo" required="true" class="form-control"/> <br/><br/>
                
                <label class="form-label">Loja:</label>&nbsp;
                <input type="text" name="loja" required="true" class="form-control"/> <br/><br/>
                 
                <button type="submit" class="btn btn-primary">Cadastrar</button>
                
            </form>    
                       
        </c:if>
                
        <br/><br/>
        <a href="../Cliente.jsp">Voltar</a>
    </body>
</html>
