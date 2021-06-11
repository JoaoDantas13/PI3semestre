<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Clientes</title>
        
        <script type="text/javascript">
            function mostrarTelaAlteracao(cpf){
                $.ajax("AlterarClienteServlet?cpf=" + cpf).done(function(){
                    alert(cpf);
                })
                    .fail(function(){
                       alert("erro"); 
                });
            }
                       
            function mostrarTelaConfirmacao(cpf){
                
                $("#cpfCliente").html(cpf);
                
                var modalConfirmacao = $("#confirmarInativacao");
                modalConfirmacao.show();
            }
            
            function fecharTelaConfirmacao(){
                $("#confirmarInativacao").hide();
            }
            
            function inativarCliente(){
                var cpf = $("#cpfCliente").html();
                fecharTelaConfirmacao();
                $.ajax("InativarClienteServlet?cpf=" + cpf).done(function(){
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
             <c:import url="/header.jsp"/>
        </div>
        
        <h1>Clientes:</h1>
        
        <table class="table">
            
            <th>Nome</th>
            <th>Email</th>
            <th>CPF</th>
            <th>Endereco</th>
            <th>Cidade</th>
            <th>Sexo</th>
            <th>Loja</th>
            
            <c:forEach items="${listaClientes}" var="cliente">
                
                <tr>
                    
                    <td>${cliente.nome}</td>
                    <td>${cliente.email}</td>
                    <td>${cliente.cpf}</td>
                    <td>${cliente.endereco}</td>
                    <td>${cliente.cidade}</td>
                    <td>${cliente.sexo}</td>
                    <td>${cliente.loja}</td>
                    
                    <td><a href="AlterarClienteServlet?cpf=${cliente.cpf}"><button type="button" class="btn btn-primary">Alterar</button></a></td>
                    <td><button type="button" class="btn btn-primary" onclick="mostrarTelaConfirmacao('${cliente.cpf}')">Inativar</button></td>
                    
                                        
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
                  <p>Tem certeza que deseja inativar o cliente de CPF <label id="cpfCliente"></label>?</p>
              </div>
              <div class="modal-footer">
                  <button type="button" class="btn btn-secondary" onclick="fecharTelaConfirmacao()">Cancelar</button>
                  <button type="button" class="btn btn-primary" onclick="inativarCliente()">Confirmar</button>
              </div>
            </div>
          </div>
        </div>
                     
         <br/><br/>
         <a href="<c:url value="/protegido/Cliente.jsp"/>"><button type="button" class="btn btn-danger">Voltar</button></a>
    </body>
</html>
