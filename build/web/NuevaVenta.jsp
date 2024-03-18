<%-- 
    Document   : NuevaVenta
    Created on : 24 oct 2023, 11:13:10
    Author     : HP SUPPORT
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>VENTAS</title>
        <style>
            @media print {

                .hidden-print {
                    display: none !important; /* Ocultar elementos en la impresión */
                }
            }
            /* Estilos para la factura */
            .invoice {
                font-family: Arial, sans-serif;
                background-color: #fff;
                max-width: 800px;
                margin: 0 auto;
                padding: 20px;
            }


            /* Estilos para los datos de la empresa */
            .company-info {
                text-align: left;
                margin-bottom: 20px;

            }

            .company-info img {
                max-width: 190px;
                margin-bottom : 10px;

            }

            .company-info p {
                margin: 0;
            }

            /* Estilos para los datos del cliente */
            .customer-info {
                right: 100px;
                bottom :1px;

            }

            /* Estilos para los datos del producto */
            .product-info {
                left: 400px;
                bottom :210px;
            }

            .employee-info {
                right: 100px;
                bottom :320px;

            }
            .tabla-info {

                bottom :280px;

            }
            /* Estilos para los campos de entrada */
            input[type="text"], input[type="number"] {
                width: 100%;
                padding: 10px;
                margin-bottom: 10px;
            }

            /* Estilos para los botones */
            .btn {
                padding: 10px 20px;
            }

            /* Otros estilos */
            .form-group label {
                font-weight: bold;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-sm-12 col-md-12 part01">
                    <div class="card">
                        <form action="Controlador_tabla?menu=NuevaVenta"  action="Controlador_tabla?menu=ReportesVentas"  method="POST">
                            <div class="invoice">
                                <div class="company-info">
                                    <img src="img/BFKC.png" alt="Logo de la Empresa">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    <div style="display: inline-block;">
                                        <p style="font-size: 17px;">RUC: 20469811001</p>
                                        <p style="font-size: 17px;">Teléfono: 950939419</p>
                                        <p style="font-size: 17px;">Direccion: Calle.Las Brisas 2250 - Lima - Callao - Peru</p>
                                    </div>
                                    <!-- Agrega más detalles de la empresa aquí -->
                                </div>

                                <div class="customer-info col-lg-6" >
                                    <div class="form-group">
                                        <label>DATOS DEL CLIENTE</label>
                                    </div>
                                    <input type="text" name="codigocliente" value="${c.getDNI()}" placeholder="Código del Cliente">
                                    <input type="submit" name="accion" value="BuscarCliente" class="btn btn-outline-info">
                                    <input type="text" name="nombrescliente" value="${c.getNOMBRE_CLIENTE()}" placeholder="Nombre del Cliente">
                                </div>
                                <div class="product-info col-lg-8">
                                    <div class="form-group">
                                        <label>DATOS DEL PRODUCTO</label>
                                    </div>
                                    <input type="text" name="codigoproducto" value="${producto.getCOD_PRODUCTO()}" placeholder="Código del Producto">
                                    <input type="submit" name="accion" value="BuscarProducto" class="btn btn-outline-info">
                                    <input type="text" name="nomproducto" value="${producto.getNOMBRE_PRODUCTO()}" placeholder="Nombre del Producto">
                                    <div class="form-group d-flex">
                                        <input type="text" name="precio" value="${producto.getPRECIO_UNITARIO()}" placeholder="Precio del Producto">
                                        <input type="number" value="1" name="cantidad" placeholder="Cantidad" class="ml-2">
                                        <input type="text" name="stock" value="${producto.getSTOCK()}" placeholder="Stock del Producto" class="ml-2">
                                    </div>
                                    <div class="form-group col-lg-8">
                                        <button type="submit" name="accion" value="Agregar" class="btn btn-outline-info">Agregar Producto</button>
                                    </div>
                                </div>
                                <div class="employee-info col-lg-6">
                                    <div class="form-group ">
                                        <label>VENTA REALIZADA POR:</label>
                                    </div>
                                    <input type="text" name="codigoempleado" value="${e.getDNI()}" placeholder="Código del Empleado">
                                    <input type="submit" name="accion" value="BuscarEmpleado" class="btn btn-outline-info">
                                    <input type="text" name="nombresempleado" value="${e.getNOMBRE_VENDEDOR()}" placeholder="Nombre del Empleado">
                                </div>
                                <div class="tabla-info col-sm-12 ml-auto">
                                    <div class="card col-sm-12">
                                        <div class="card-body col-sm-12">
                                            <div class="d-flex col-sm-6 ml-auto">
                                                <label>NumeroSerie</label>
                                                <input type="text" name="NroSerie" value="${numeroserie}" class="form-control">
                                            </div>
                                            <br>

                                            <table class="table table-hover">
                                                <thead>
                                                    <tr>
                                                        <th>NRO</th>
                                                        <th>CODIGO</th>
                                                        <th>DESCRIPCION</th>
                                                        <th>PRECIO</th>
                                                        <th>CANTIDAD</th>
                                                        <th>SUBTOTAL</th>
                                                        <th class="accion">ACCIONES</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <c:forEach var="list" items="${lista}">
                                                        <tr>
                                                            <td>${list.getItem()}</td>
                                                            <td>${list.getIdproducto()}</td>
                                                            <td>${list.getDescripcion_pro()}</td>
                                                            <td>${list.getPrecio()}</td>
                                                            <td>${list.getCantidad()}</td>
                                                            <td>${list.getSubtotal()}</td>
                                                            <td class="d-flex">
                                                                <a class="btn btn-warning" href="">Update</a>
                                                                <a class="btn btn-danger" style="margin-left:10px" href="">Delete</a>
                                                            </td>
                                                        </tr>
                                                    </c:forEach>     
                                                </tbody>
                                            </table>
                                        </div>

                                        <div class="card-footer d-flex">
                                            <div class="col-lg-6 col-md-12">
                                                <a href="Controlador_tabla?menu=NuevaVenta&accion=GenerarVenta" onclick="print()" class="btn btn-success">Generar Venta</a>
                                                <input type="submit" name="accion" value="Cancelar" class="btn btn-danger">
                                            </div>
                                            <div class="col-lg-4 col-md-12 ml-auto">
                                                <input type="text" name="txttotal" value="S/. ${totalpagar}0" class="form-control">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                    </div>    
                    </form>
                </div>
            </div>
        </div>
        <script src="https://codejquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
