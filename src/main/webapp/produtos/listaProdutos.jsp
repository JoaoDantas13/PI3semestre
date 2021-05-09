<%-- 
    Document   : listaProdutos
    Created on : 30/04/2021, 19:27:20
    Author     : HOME
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Produtos</title>
        
        <script type="text/javascript">
            function mostrarTelaConfirmacao(placa){
                
                $("#placaVeiculo").html(placa);
                
                var modalConfirmacao = $("#confirmarInativacao");
                modalConfirmacao.show();
            }
            
            function fecharTelaConfirmacao(){
                $("#confirmarInativacao").hide();
            }
            
            function inativarCliente(){
                var placa = $("#placaVeiculo").html();
                fecharTelaConfirmacao();
                $.ajax("InativarProdutoServlet?placa=" + placa).done(function(){
                        location.reload();
                        
                    })
                    .fail(function(){
                        $("#erro").css("display", "block");
                        setTimeout(function(){
                            $("#erro").css("display", "none");                        
                        }, 3000);
                    });
            }
            
        </script>    
        
    </head>
    <body class="container">
        
        <div class="header-1">
             <c:import url="../header.jsp"/>
        </div>
        
        <h1>Produtos:</h1>
    </b></b>   
   
    <div class="alert alert-danger" role="alert" id="erro" style="display:none">
            Erro ao Inativar Produto!           
    </div>

    <div class="alert alert-primary" role="alert" id="concluido" style="display:none">
            Produto Inativado com Sucesso!           
    </div>
        
    </b></b>
        <table class="table">
            
            <th>Placa</th>
            <th>Nome</th>
            <th>Quantidade</th>
            <th>Preço Unitário</th>
            <th>Loja</th>
            <th>Status</th>
            
            <c:forEach items="${listaProdutos}" var="produto">                
                <tr>                    
                    <td>${produto.placa}</td>                    
                    <td>${produto.nome}</td>
                    <td>${produto.quantidade}</td>
                    <td>${produto.precoUnit}</td>
                    <td>${produto.loja}</td>
                    <td>${produto.status}</td>
              
                    <td><a href="AlterarProdutoServlet?placa=${produto.placa}">Alterar</a></td>                    
                    
                    <td><button type="button" class="btn btn-primary" onclick="mostrarTelaConfirmacao('${produto.placa}')">Inativar</button></td>
                </tr>
            </c:forEach>
        </table>
        
        
        <div class="modal" id="confirmarInativacao">
          <div class="modal-dialog">
            <div class="modal-content">
              <div class="modal-header">
                <h5 class="modal-title">Confirmar Inativação</h5>
                </div>
              <div class="modal-body">
                  <p>Tem certeza que deseja inativar o veiculo de placa <label id="placaVeiculo"></label>?</p>
              </div>
              <div class="modal-footer">
                  <button type="button" class="btn btn-secondary" onclick="fecharTelaConfirmacao()">Cancelar</button>
                  <button type="button" class="btn btn-primary" onclick="inativarCliente()">Confirmar</button>
              </div>
            </div>
          </div>
        </div>
        
                     
         <br/><br/>
                    <div class ="btnincluir">
                            <a href="produtos/incluirProduto.jsp">Incluir</a>
                    </div>                    
         
        
        <c:import url="../footer.jsp"/>
        
        
    </body>
</html>