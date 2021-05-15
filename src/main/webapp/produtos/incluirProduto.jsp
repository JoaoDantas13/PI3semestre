<%-- 
    Document   : produto
    Created on : 28/04/2021, 21:13:12
    Author     : HOME
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Produto</title>
    </head>
    <body class="container" background="../Background.png" bgproperties="fixed">
        <c:import url="../header.jsp" />
        <h1>Produto</h1>
        
        <form action="CadastraProdutoServlet" method="POST">
        <label class="form-label">Placa</label>
        <input type="text" name="placa" required="true" class="form-control" placeholder="Ex.: XXX1111"/>
        </br>
        
        <label class="form-label">Marca</label>
        </br>
        
        <select name="marca" class="form-control" required="true">
            <option value="">Selecione uma Marca</option>
            <option value="BMW">BMW</option>
            <option value="GM/Chevrolet">GM/Chevrolet</option>
            <option value="Citroën">Citroën</option>
            <option value="Ferrari">Ferrari</option>
            <option value="Fiat">Fiat</option>
            <option value="Ford">Ford</option>
            <option value="Honda">Honda</option>
            <option value="Hyundai">Hyundai</option>
            <option value="Jeep">Jeep</option>
            <option value="Lamborghini">Lamborghini</option>
            <option value="Land Rover">Land Rover</option>
            <option value="Mitsubishi">Mitsubishi</option>
            <option value="Nissan">Nissan</option>
            <option value="Peugeot">Peugeot</option>
            <option value="Porsche">Porsche</option>
            <option value="Renault">Renault</option>
            <option value="Toyota">Toyota</option>
            <option value="Volkswagen">Volkswagen</option>      
        </select>

        </br>
        
        <label class="form-label">Modelo</label>
        <input type="text" name="modelo" required="true" class="form-control" placeholder="Ex.: Corsa, Meriva, Pajero"/>
        </br>
        
        <label class="form-label">Tipo</label>
        <select name="tipo" class="form-control" required="true">
            <option value="">Selecione o Tipo</option>
            <option value="Comum">Comum</option>
            <option value="Luxo">Luxo</option>
            <option value="SUV">SUV</option>
            <option value="Utilitario">Utilitario</option>
            <option value="Offroad">Offroad</option>
        </select>
        </br>
      
        <label class="form-label">Valor Unitário</label>
        <input type = "text" name="precoUnit" required="true" class="form-control"/>
        </br>
        <label class="form-label">Loja</label>
        <input type = "text" name="loja" required="true" class="form-control"/><br>
        
        <button type ="submit" class="btn btn-primary">Incluir</button>
        
        </form>

                   
         <br/><br/>        
        
        
        
        <br/>         
        <a href="../ProdutoServlet">Voltar</a>
    </body>
</html>