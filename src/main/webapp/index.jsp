<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head >
        <c:import url="header.jsp" />
        <link rel="stylesheet" href="style.css">
        <title>Vendas</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body class="container">
        <div class="header-1">
            <c:import  url="header.jsp" />
            <!--Div login-->
            <div class="acesso">
                <label>Usuario:</label>
                <input type="text">
                <label>Loja:</label>
                <input type="text">
            </div>
        </div>
        <!--Div acesso-->
        <div class = "conteiner">
            <!--Div menu central-->
            <div  class="menucentral">
                <div class="vendas">    
                    <h1 class="ttvds">Menu</h1>
                    <a href="Cliente.jsp">Cliente</a>
                    <a href="Vendas.jsp">Vendas</a>
                    <a href="ProdutoServlet">Produto</a>
                </div>
            </div> 
        </div>
        <div class ="telaacess">
            <h1 class = "h-1">Manutencao</h1>
            <button class = "abc" type="button">Adicionar</button>
            <button class = "rmv" type="button">Remover</button>
            <button class ="fina"  type="button">Finalizar</button>
        </div>
    </body>
</html>

