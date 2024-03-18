<%-- 
    Document   : Productos
    Created on : 23 oct 2023, 1:39:46
    Author     : HP SUPPORT
--%>

<%@page import="Modelo.Proveedor"%>
<%@page import="java.util.List"%>
<%@page import="ModeloDAO.ProductoDAO"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <style>
            .container {
                display: flex;
                justify-content: space-between;
                margin-right: 245px;
            }

            .table-container {
                flex: 1;
                max-width: 92%; /* Reducido el ancho de la tabla al 84% */
                max-height: 100vh;
                overflow-y: auto;
                margin-right: 20px;
            }

            .form-container {
                width: 330px;
                position: absolute;
                top: 10px;
                right: 10px;
                z-index: 1;
            }

            .form-group {
                margin: 10px 0;
            }

            .btn {
                margin: 10px 0;
            }

            .h1 {
                margin-right: 190px;
            }
            .table.table-hover {
                width: 100%;
            }

            .btn-danger {
                margin-right: 0;
            }

            th, td {
                border: 1px solid #dddddd;
                text-align: left;
                padding: 8px;
            }

            th:nth-child(8), td:nth-child(8) {
                width: 25%;
            }
            tr:nth-child(even) {
                background-color: #f2f2f2;
            }
        </style>
    </head>
    <body>
        <div style="margin-left: 280px;">
            <h1>LISTA DE PRODUCTOS</h1>
            <a class="btn btn-primary" href="Controlador_tabla?menu=ReportesProductos&accion=reporteproducto"><strong>ReporteExcel de Productos</strong></a> 
        </div>
        <div class="container">
            <div class="table-container">
                <br>
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>NOMBRE </th>
                            <th>DESCRIPCION</th>
                            <th>PRECIO</th>
                            <th>STOCK</th>
                            <th>ESTADO</th>
                            <th>PROVEEDOR</th>
                            <th>CATEGORIA</th>
                            <th>ACCIONES</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="pro" items="${productos}">
                            <tr>
                                <td> ${pro.getCOD_PRODUCTO()} </td>
                                <td> ${pro.getNOMBRE_PRODUCTO()} </td>
                                <td> ${pro.getDESCRIPCION()} </td>
                                <td> ${pro.getPRECIO_UNITARIO()} </td>
                                <td> ${pro.getSTOCK()} </td>
                                <td> ${pro.isESTADO()} </td>
                                <td>
                                    <c:forEach var="proveedor" items="${proveedores}">
                                        <c:if test="${proveedor.ID_PROVEEDOR == pro.ID_PROVEEDOR}">
                                            ${proveedor.NOM_PROVEEDOR}
                                        </c:if>
                                    </c:forEach>
                                </td>
                                <td>
                                    <c:forEach var="categoria" items="${categorias}">
                                        <c:if test="${categoria.ID_CATEGORIA == pro.ID_CATEGORIA}">
                                            ${categoria.NOMBRE_CATEGORIA}
                                        </c:if>
                                    </c:forEach>
                                </td>
                                <td><a class="btn btn-warning"
                                       href="Controlador_tabla?menu=Productos&accion=Update&id=${pro.COD_PRODUCTO}">Update</a></td>
                                <td><a class="btn btn-danger"
                                       href="Controlador_tabla?menu=Productos&accion=Delete&id=${pro.COD_PRODUCTO}">Delete</a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="form-container">
            <div class="card"  style=" height: 10%;">
                <div class="card-body">
                    <form action="Controlador_tabla?menu=Productos" action="Controlador_tabla?menu=ReportesProductos" method="POST">
                        <div class="form-group">
                            <label>NOMBRE_PRODUCTO</label>
                            <input type="text" value="${producto.NOMBRE_PRODUCTO}" name="txtnombre" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>DESCRIPCION</label>
                            <input type="text" value="${producto.DESCRIPCION}" name="txtdescripcion" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>PRECIO</label>
                            <input type="text" value="${producto.PRECIO_UNITARIO}" name="txtprecio" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>STOCK</label>
                            <input type="text" value="${producto.STOCK}" name="txtstock" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>ESTADO</label>
                            <input type="text" value="${producto.ESTADO}" name="txtestado" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>ID_PROVEEDOR</label>
                            <select name="txtproveedor" class="form-control">
                                <option value="">Seleccione un proveedor</option>
                                <c:forEach var="proveedor" items="${proveedores}">
                                    <c:choose>
                                        <c:when test="${proveedor.ID_PROVEEDOR == producto.ID_PROVEEDOR}">
                                            <option value="${proveedor.ID_PROVEEDOR}" selected>${proveedor.NOM_PROVEEDOR}</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="${proveedor.ID_PROVEEDOR}">${proveedor.NOM_PROVEEDOR}</option>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>ID_CATEGORIA</label>
                            <select name="txtcategoria" class="form-control">
                                <option value="">Seleccione una categoría</option>
                                <c:forEach var="categoria" items="${categorias}">
                                    <c:choose>
                                        <c:when test="${categoria.ID_CATEGORIA == producto.ID_CATEGORIA}">
                                            <option value="${categoria.ID_CATEGORIA}" selected>${categoria.NOMBRE_CATEGORIA}</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="${categoria.ID_CATEGORIA}">${categoria.NOMBRE_CATEGORIA}</option>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </select>
                        </div>
                        <input type="submit" name="accion" value="Agregar" class="btn btn-info">
                        <input type="submit" name="accion" value="Actualizar" class="btn btn-success">
                    </form>
                </div>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
                integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js"
                integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js"
                integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
    </body>
</html>
