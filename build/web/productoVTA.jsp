<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro VTA</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <h2>Registro de Productos</h2>
            </div>
            <div class="row">
                <div class="card-body">
                    <table class="table table-hover" >
                        <thead>
                            <tr>
                                <th>ID PRODUCTO</th>
                                <th>NOMBRE PRODUCTO</th>
                                <th>DESCRIPCION PRODUCTO</th>
                                <th>UNIDADES PRODUCTO</th>
                                <th>VALOR PRODUCTO</th>
                                <th>Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="temp" items="${listaProductos}">
                                <tr>
                                    <td>${temp.getId()}</td>
                                    <td>${temp.getNombre()}</td>
                                    <td>${temp.getDescripcion()}</td>
                                    <td>${temp.getUnidad()}</td>
                                    <td>${temp.getValor()}</td>
                                    <td>
                                        <a href="ProductoCTO" class="btn btn-outline-success" >Ver</a>
                                        <a href="ProductoCTO" class="btn btn-outline-warning" >Editar</a>
                                        <a href="ProductoCTO?accion=eliminar&id=${temp.getId()}" class="btn btn-outline-danger" >Eliminar</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
