<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Aterar</title>
    </head>
    <body class="conteiner">
        
        <div class="header-1">
             <c:import url="../../header.jsp"/>
        </div>
        
        <h1>Altera os dados dos Clientes</h1>
        
        <c:if test="${not empty cliente}">
            
            <form action="${pageContext.request.contextPath}/AlterarClienteServlet" method="POST">
                
                <label class="form-label">Nome:</label>&nbsp;
                <input type="text" size="60" name="nome" required="true" value="${cliente.nome}"/> <br/><br/>
                
                <label class="form-label">Email:</label>&nbsp;
                <input type="text" size="60" name="email" required="true" value="${cliente.email}"/> <br/><br/>
                
                <label class="form-label">CPF:</label>&nbsp;
                <input type="text" size="10" name="cpf" required="true" value="${cliente.cpf}" readonly="true"/> <br/><br/>
                
                <label class="form-label">Endereço:</label>&nbsp;
                <input type="text" size="60" name="endereco" required="true" value="${cliente.endereco}"/> <br/><br/>
                
                <label class="form-label">Cidade:</label>&nbsp;
                <input type="text" size="35" name="cidade" required="true" value="${cliente.cidade}"/> <br/><br/>
                
                <label class="form-label">Sexo:</label>&nbsp;
                <input type="text" size="5" name="sexo" required="true" value="${cliente.sexo}"/> <br/><br/>
                
                <label class="form-label">Loja:</label>&nbsp;
                <input type="text" size="10" name="loja" required="true" value="${cliente.loja}"/> <br/><br/>
                 
                <button type="submit" class="btn btn-primary">Confirmar</button>
                
            </form>    
                       
        </c:if>
                
        <br/><br/>
        <a href="/protegido/Cliente.jsp">Voltar</a>
    </body>
</html>
