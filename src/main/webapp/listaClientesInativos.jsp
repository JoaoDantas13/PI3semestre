<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ativar</title>
        
        <script type="text/javascript">
            function mostrarTelaAlteracao(cpf){
                $.ajax("ClienteInativoServlet?cpf=" + cpf).done(function(){
                    alert(cpf);
                })
                    .fail(function(){
                       alert("erro"); 
                });
            }
                       
            function mostrarTelaConfirmacao(cpf){
                
                $("#cpfCliente").html(cpf);
                
                var modalConfirmacao = $("#confirmarReativacao");
                modalConfirmacao.show();
            }
            
            function fecharTelaConfirmacao(){
                $("#confirmarReativacao").hide();
            }
            
            function ReativarCliente(){
                var cpf = $("#cpfCliente").html();
                fecharTelaConfirmacao();
                $.ajax("AtivarClienteServlet?cpf=" + cpf).done(function(){
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
            
            <c:forEach items="${listaClientesInativos}" var="cliente">
                
                <tr>
                    
                    <td>${cliente.nome}</td>
                    <td>${cliente.email}</td>
                    <td>${cliente.cpf}</td>
                    <td>${cliente.endereco}</td>
                    <td>${cliente.cidade}</td>
                    <td>${cliente.sexo}</td>
                    <td>${cliente.loja}</td>
                    
                    
                    <td><button type="button" class="btn btn-primary" onclick="mostrarTelaConfirmacao('${cliente.cpf}')">Reativar</button></td>
                    
                                        
                </tr>
            </c:forEach>
        </table>
        
        <div class="modal" id="confirmarReativacao">
          <div class="modal-dialog">
            <div class="modal-content">
              <div class="modal-header">
                <h5 class="modal-title">Confirmar Reativação</h5>
                </div>
              <div class="modal-body">
                  <p>Tem certeza que deseja Reativar o cliente de CPF <label id="cpfCliente"></label>?</p>
              </div>
              <div class="modal-footer">
                  <button type="button" class="btn btn-secondary" onclick="fecharTelaConfirmacao()">Cancelar</button>
                  <button type="button" class="btn btn-primary" onclick="ReativarCliente()">Confirmar</button>
              </div>
            </div>
          </div>
        </div>
                                   
         <br/><br/>
        <a href="Cliente.jsp">Voltar</a>
    </body>
</html>
