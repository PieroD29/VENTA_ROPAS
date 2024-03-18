<%-- 
    Document   : Proveedores
    Created on : 23 oct 2023, 1:39:17
    Author     : HP SUPPORT
--%>


<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                overflow: hidden;
                margin-right: 255px;
            }

            .table-container {
                flex: 1;
                max-width: 140vh;
                max-height: 100vh;
                overflow-y: auto;
                margin-right: 20px;
            }

            .form-container {
                width: 400px;
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

            .table.table-hover {
                width: 100%;
            }

            .btn-danger {
                margin-right: 20px;
            }

            th, td {
                border: 1px solid #dddddd;
                text-align: left;
                padding: 8px;
            }

            tr:nth-child(even) {
                background-color: #f2f2f2;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <div class="table-container">
                <h1>&nbsp;LISTA DE PROVEEDORES</h1>
                <br>
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>NOMBRE</th>
                            <th>RUC</th>
                            <th>ESTADO</th>
                            <th>ACCIONES</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="prove" items="${proveedores}">
                            <tr>
                                <td>${prove.getID_PROVEEDOR()}</td>
                                <td>${prove.getNOM_PROVEEDOR()}</td>
                                <td>${prove.getRUC()}</td>
                                <td>${prove.getESTADO_PROVEEDOR()}</td>
                                <td><a class="btn btn-warning" href="Controlador_tabla?menu=Proveedores&accion=Update&id=${prove.ID_PROVEEDOR}">Update</a></td>
                                <td><a class="btn btn-danger" href="Controlador_tabla?menu=Proveedores&accion=Delete&id=<c:out value='${prove.ID_PROVEEDOR}' />">Delete</a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                    <a class="btn btn-primary" href="Controlador_tabla?menu=ReportesProveedores&accion=reporteproveedor"><strong>ReporteExcel de Proveedores</strong></a> 
                </table>
            </div>
        </div>
        <div class="form-container">
            <div class="card">
                <div class="card-body">
                    <form action="Controlador_tabla?menu=Proveedores" action="Controlador_tabla?menu=ReportesProveedores" method="POST">
                        <input type="text" name="codigoproveedor" id="rucInput" placeholder="RUC del Proveedor">
                        <input type="submit" name="accion" value="BuscarProveedor" class="btn btn-outline-info">
                        <input type="submit" name="accion" value="Regresar" class="btn btn-warning">
                        <div class="form-group">
                            <label>NOMBRE</label>
                            <input type="text" value="${proveedor.NOM_PROVEEDOR}" name="txtnombre" class="form-control">
                        </div>
                        <div class "form-group">
                            <label>RUC</label>
                            <input type="text" value="${proveedor.RUC}" name="txtruc" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>ESTADO</label>
                            <input type="text" value="${proveedor.ESTADO_PROVEEDOR}" name="txtestado" class="form-control">
                        </div>
                        <input type="submit" name="accion" value="Agregar" class="btn btn-info">
                        <input type="submit" name="accion" value="Actualizar" class="btn btn-success">
                    </form>
                </div>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js"
                integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
    </body>
</html>