<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head >        

        <title>SpeedRacer</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body class="container" background="../Background.png" bgproperties="fixed">

        <div class="header-1">
            <c:import url="../header.jsp"/>
        </div>

    </div> <br/><br/>
    <!--Div acesso-->
    <div class = "conteiner">
        <!--Div menu central-->
        <div  class="menucentral">
            <div class="vendas">    
                <h1 class="ttvds">Menu</h1> <br/>
                <a href="Cliente.jsp"><button type="button" class="btn btn-primary">Cliente</button></a>&nbsp;
                <a href="venda/inserirVenda.jsp"><button type="button" class="btn btn-primary">Vendas</button></a>&nbsp;

                <c:if test="${sessionScope.usuario.isGerente()}">

                    <a href= "<c:url value="/ProdutoServlet"/>"><button type="button" class="btn btn-primary">Produto</button></a>
                    
                    <br/><br/>

                    <a href="relatorio/menuRelatorioAnalitico.jsp"><button type="button" class="btn btn-primary">Relatório Analítico</button></a>
                    <a href="relatorio/menuRelatorioSintetico.jsp"><button type="button" class="btn btn-primary">Relatório Sintético</button></a>

                </c:if>

            </div>
        </div> 
    </div> <br/><br/>
</body>
</html>

