<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sucesso</title>

        <style type="text/css">

            #posicao{
                
                position: absolute;
                font-family: Times New Roman;
                color: red;
                font-size: 70px;
                font-weight: 900;
                top: 50%;
                left: 50%;
                margin-right: -50%;
                transform: translate(-50%, -50%) 
                
            }
            
            
            
            #posicaobtn {
                
                position: absolute;
                top: 70%;
                left: 50%;
                margin-right: -50%;
                transform: translate(-50%, -50%) 
            }


        </style>
    </head>
    <body class="container" background="Background.png" bgproperties="fixed">

 
        <h1 id="posicao" >Infelizmente você não acesso !!</h1>

        
        <h6>
            <a id="posicaobtn" href="<c:url value="/protegido/index.jsp"/>"><button type="button" class="btn btn-primary">Confirmar</button></a>
        </h6>



    </body>
</html>


