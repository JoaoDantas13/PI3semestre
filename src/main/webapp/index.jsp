<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head >
        <c:import url="header.jsp" />
        <link rel="stylesheet" href="style.css">
        <title>SpeedRacer</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body class="container">
        <br/>
        <div class="header-1">
            
            <!--Div login-->
            <div class="acesso">
                <label>Usuario:</label>
                <input type="text">
                <label>Loja:</label>
                <input type="text">
            </div>
        </div> <br/><br/>
        <!--Div acesso-->
        <div class = "conteiner">
            <!--Div menu central-->
            <div  class="menucentral">
                <div class="vendas">    
                    <h1 class="ttvds">Menu</h1> <br/>
                    <a href="Cliente.jsp"><button type="button" class="btn btn-primary">Cliente</button></a>
                    <a href="venda/inserirVenda.jsp"><button type="button" class="btn btn-primary">Vendas</button></a>
                    <a href="ProdutoServlet"><button type="button" class="btn btn-primary">Produto</button></a> 
                </div>
            </div> 
        </div> <br/><br/>
        <div class ="telaacess">
            <h1 class = "h-1">Manutencao</h1>
            <button class = "abc" type="button">Adicionar</button>
            <button class = "rmv" type="button">Remover</button>
            <button class ="fina"  type="button">Finalizar</button>
        </div>
    </body>
</html>

