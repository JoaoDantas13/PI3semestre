<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <title>Produto</title>
       
       <script type="text/javascript">
            function outraOpcaoStatus(opcao1){
                if(opcao1 === "Inativo"){
                    $("#segundaOpcao").html('Ativo');    
                } else{
                    $("#segundaOpcao").html('Inativo');
                }               
            } 
            
            function outraOpcaoQuantidade(opcao1){
                if(opcao1 === '1'){
                    $("#segundaOpcaoQuantidade").html('0');    
                } else{
                    $("#segundaOpcaoQuantidade").html('1');
                }               
            }
            
            function outraOpcaoTipo(opcao1){
                if(opcao1 === 'Comum'){
                    $("#segundaOpcaoTipo").html('Luxo');
                    $("#terceiraOpcaoTipo").html('SUV');
                    $("#quartaOpcaoTipo").html('Utilitário');
                    $("#quintaOpcaoTipo").html('Offroad');
                } else if(opcao1 === 'Luxo'){
                    $("#segundaOpcaoTipo").html('Comum');
                    $("#terceiraOpcaoTipo").html('SUV');
                    $("#quartaOpcaoTipo").html('Utilitário');
                    $("#quintaOpcaoTipo").html('Offroad');
                } else if(opcao1 === 'SUV'){
                    $("#segundaOpcaoTipo").html('Comum');
                    $("#terceiraOpcaoTipo").html('Luxo');
                    $("#quartaOpcaoTipo").html('Utilitário');
                    $("#quintaOpcaoTipo").html('Offroad');
                } else if(opcao1 === 'Utilitário'){
                    $("#segundaOpcaoTipo").html('Comum');
                    $("#terceiraOpcaoTipo").html('Luxo');
                    $("#quartaOpcaoTipo").html('SUV');
                    $("#quintaOpcaoTipo").html('Offroad'); 
                } else{
                    $("#segundaOpcaoTipo").html('Comum');
                    $("#terceiraOpcaoTipo").html('Luxo');
                    $("#quartaOpcaoTipo").html('SUV');
                    $("#quintaOpcaoTipo").html('Utilitário');
                }   
            } 
           
       </script>    
       
    </head>
    <body class="container" onload="outraOpcaoStatus('${produto.status}'), 
          outraOpcaoQuantidade('${produto.quantidade}'),
          outraOpcaoTipo('${produto.tipo}')" >
        
        <c:import url="../../../header.jsp" />
        <h1>Produto</h1>
        
        <form action="${pageContext.request.contextPath}/AlterarProdutoServlet" method="POST" >
        <label>Placa</label>
        <input type="text" name="placa" required="true" value="${produto.placa}" readonly="true" class="form-control"/>
        </br>
        <label>Marca</label>
        <input type="text" name="marca" required="true" value="${produto.marca}" readonly="true" class="form-control"/>
        </br>
        <label>Modelo</label>
        <input type="text" name="modelo" required="true" value="${produto.modelo}" class="form-control"/>
        </br>
        
        <label>Tipo</label>
        <select name="tipo"class="form-control">
          <option value="${produto.tipo}" >${produto.tipo}</option>
          <option id="segundaOpcaoTipo"></option>
          <option id="terceiraOpcaoTipo"></option>
          <option id="quartaOpcaoTipo"></option>
          <option id="quintaOpcaoTipo"></option>
        </select>
        
        </br>
        
        <label>Quantidade</label>
        <select name="quantidade"class="form-control">
          <option value="${produto.quantidade}" >${produto.quantidade}</option>
          <option id="segundaOpcaoQuantidade"></option>
        </select>
        
        </br>
                
        <label>Valor Unitário</label>
        <input type = "text" name="precoUnit" required="true" value="${produto.precoUnit}" class="form-control"/>
        </br>
        <label>Loja</label>
        <input type = "text" name="loja" required="true" value="${produto.loja}" class="form-control"/>
        </br>
        <label>Status</label>                
        <select name="status" class="form-control">
          <option value="${produto.status}" >${produto.status}</option>
          <option id="segundaOpcao"></option>
        </select><br>
        
        <button type ="submit" class="btn btn-primary">Atualizar</button>
        
        </form>
        
        <br/>         
        <a href="../PI3semestre/ProdutoServlet">Voltar</a>
    </body>
</html>