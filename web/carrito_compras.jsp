<%-- 
    Document   : carrito_compras
    Created on : 1/11/2020, 13:33:50
    Author     : Wilmer
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Carrito de compras</title>
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
                    <a class="dropdown-item" href="Controlador?accion=carrito">Carrito</a><%-- Revisar si va a cambiar en algo cuando lo pase al otro proyecto --%>
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
                    <a class="dropdown-item" href="#">Tabla Compras</a>
                    <a class="dropdown-item" href="proveedores.jsp">Tabla Proveedores</a>
                </div>    
            </li>
            <a class="dropdown-item" href="Controlador?accion=carrito" style="color: white">Seguir Comprando</a><%-- Revisar si va a cambiar en algo cuando lo pase al otro proyecto --%>
        </ul>        
    </nav>
        
        
        <div class="container mt-4">           
            <h3>Carrito</h3>
        <br>
            <div class="row">
                <div class="col-sm-8">
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th>ITEM</th>
                                <th>Nombre del producto</th>
                                <th>Descripcion</th>
                                <th>Imagen</th>
                                <th>Precio</th>
                                <th>Cantidad</th>
                                <th>Sub-total</th>
                                <th>Accion</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="car" items="${carrito}">  
                            <tr>
                                <td>${car.getItem()}</td>
                                <td>${car.getProducto()}</td>
                                <td>${car.getDescripcion()}</td>
                                <td><img src="imagenes/${car.getImagen()}" width="100" height="100"></td>
                                <td>${car.getPrecio_venta()}</td>
                                <td>
                                    <input type="hidden" id="idpro" value="${car.getId_producto()}">
                                    <input type="number" id="Cantidad" value="${car.getExistencia()}" class="form-control text-center" min="1">
                                </td>
                                
                                <td>${car.getSub_total()}</td>
                                <td>
                                    <input type="hidden" id="id_pro" value="${car.getId_producto()}" >
                                    <a href="#" id="btnDelete">Eliminar</a>                                    
                                </td>
                            </tr>
                        </c:forEach>
                            
                        </tbody>
                    </table>
                </div>
                <div class="col-sm-4">
                    <div class="card">
                        <div class="card-header">
                            <h3>Generar compra</h3>
                        </div>
                        <div class="card-body">
                            <label>Subtotal:</label>
                            <input type="text" value="Q.${totalPagar}" class="form-control" readonly>
                            <label>Total a pagar:</label>
                            <input type="text" value="Q.${totalPagar}" class="form-control" readonly>                            
                        </div>
                        <div class="card-footer">
                            <a href="#" class="btn btn-info btn-block">Realizar Pago</a>                            
                            <a href="Controlador?accion=GenerarCompra" class="btn btn-danger btn-block">Generar Compra</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>    
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    <script src="js/funciones.js" type="text/javascript"></script>
    <script src="https://code.jquery.com/jquery-3.5.0.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    </body>
</html>
