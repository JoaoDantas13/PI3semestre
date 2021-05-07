<%-- 
    Document   : Vendas
    Created on : 26/04/2021, 19:16:15
    Author     : Danta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
 <meta charset="utf-8">
 <meta http-equiv="X-UA-Compatible" content="IE=edge">
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
 <meta name="viewport" content="width=device-width, initial-scale=1">
 <title>Vendas</title>
 <link href="bootstrap.min.css" rel="stylesheet">
 <link href="css/style.css" rel="stylesheet">
</head>
<body> 
 <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<table width="60%" border="1" id="tabela-herdeiro" class="table">
<tbody>
    <tr>
        <td>Placa<input type="text"></td>
        <td>&nbsp;</td> 
        <td width="10%">Nome<input type="text"></td></td>
        <td width="27%">&nbsp;</td>
        <td width="10%">Quantidade<input type="text"></td></td>
        <td width="22%">&nbsp;</td>
        <td width="10%">PrecoUnit<input type="text"></td></td>
        <td width="22%">&nbsp;</td>
    </tr>
    
    <tr>
        <td colspan="6" align="right"><button class="btn btn-large btn-danger btn-xs" type="button">Remover</button></td>
    </tr>       
   
</tbody>
</table>
<br>
<button id="adicionar">Adicionar linha</button>
</tbody>
<script>
    $(function(){

   // já cria logo uma cópia do TBODY original
   var copia = document.querySelector("#tabela-herdeiro tbody").outerHTML;

    $(document).on("click", "#tabela-herdeiro button", function(){

      var tr = $(this).closest("tbody");
      
      tr.fadeOut(400, function(){
        this.remove(); 
      }); 

    });

    $("#adicionar").on("click", function(){
        $("#tabela-herdeiro").append(copia);
    });          

});
</script>
</body>
</html>
