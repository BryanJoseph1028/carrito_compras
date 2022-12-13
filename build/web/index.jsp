<%-- 
    Document   : index
    Created on : 1/11/2020, 13:21:25
    Author     : Wilmer
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/6ffafabebc.js" crossorigin="anonymous"></script>
    </head>
    <body>
    
         <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
        <a class="navbar-brand" href="index.jsp"><img src="imagenes/socios.png"></a>

        <ul class="navbar-nav">
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                    Productos
                </a>
                
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="productos.jsp">Tabla Productos</a>
                    <a class="dropdown-item" href="Controlador?accion=carrito">Carrito</a>
                    <a class="dropdown-item" href="#">Tabla Marcas</a>
                </div>    
            </li>

            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                    Ventas
                </a>
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="#">Tabla Ventas</a>
                    <a class="dropdown-item" href="clientes.jsp">Tabla Clientes</a>     

                    <a class="nav-link dropdown-toggle text-body" href="#" id="navbardrop" data-toggle="dropdown">
                        Empleados
                    </a>
                    <div class="dropdown-menu">
                        <a class="dropdown-item" href="empleados.jsp">Tabla Empleados</a>
                        <a class="dropdown-item" href="puestos.jsp">Tabla Puestos</a>       
                    </div>        
                </div>    
            </li>

            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                    Compras
                </a>
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="Controlador?accion=Carrito">Tabla Compras</a>
                    <a class="dropdown-item" href="proveedores.jsp">Tabla Proveedores</a>
                </div>    
            </li>
            <a class="dropdown-item" href="Controlador?accion=Carrito"><i class="fas fa-cart-plus">(<label style="color: orange">${contador}</label>)</i></a><%-- Revisar si va a cambiar en algo cuando lo pase al otro proyecto --%>
        </ul>        
    </nav>
        
        <div class="container mt-2">
            <div class="row">
                <c:forEach var="p" items="${productos}">
                    <div class="col-sm-4">
                    <div class="card">
                        <div class="card-header">
                            <label>${p.getProducto()}</label>
                        </div>
                        <div class="card-body">
                            <i>Q.${p.getPrecio_venta()}</i>
                            <img src="imagenes/${p.getImagen()}" width="200" height="180">
                        </div>
                        <div class="card-footer text-center">
                            <label>${p.getDescripcion()}</label>
                            <div>
                                <a href="Controlador?accion=AgregarCarrito&id_producto=${p.getId_producto()}" class="btn btn-outline-info">Agregar al carrito</a>
                                <a href="Controlador?accion=Comprar&id_producto=${p.getId_producto()}" class="btn btn-danger">Comprar</a>
                            </div>
                        </div>
                    </div>
                            <br>
                </div>
                </c:forEach>
                
            </div>
        </div>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>    
    
    </body>
</html>
