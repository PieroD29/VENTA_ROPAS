<%-- 
    Document   : Vendedores
    Created on : 23 oct 2023, 1:39:09
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
                margin-right: 255px;
            }

            .table-container {
                flex: 1;
                max-width: 92%; /* Reducido el ancho de la tabla al 92% */
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


            tr:nth-child(even) {
                background-color: #f2f2f2;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <div class="table-container">
                <h1>&nbsp;LISTA DE EMPLEADOS</h1>
                <br>
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>DNI</th>
                            <th>NOMBRES</th>
                            <th>FECHA_CONTRATO</th>
                            <th>SALARIO</th>
                            <th>ESTADO</th>
                            <th>USUARIO</th>
                            <th>ACCIONES</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="vende" items="${vendedores}">
                            <tr>
                                <td> ${vende.getID_VENDEDOR()} </td>
                                <td> ${vende.getDNI()} </td>
                                <td> ${vende.getNOMBRE_VENDEDOR()} </td>
                                <td> ${vende.getFECHA_CONTRATO()} </td>
                                <td>${vende.getSALARIO()}</td>
                                <td> ${vende.getESTADO_VENDEDOR()}</td>
                                <td> ${vende.getUSUARIO()}</td>
                                <td><a class="btn btn-warning" href="Controlador_tabla?menu=Vendedores&accion=Update&id=${vende.ID_VENDEDOR}">Update</a></td>
                                <td><a class="btn btn-danger" href="Controlador_tabla?menu=Vendedores&accion=Delete&id=${vende.ID_VENDEDOR}">Delete</a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                     <a class="btn btn-primary" href="Controlador_tabla?menu=Reportes&accion=reporte"><strong>ReporteExcel de Empleados</strong></a> 
                </table>
            </div>
        </div>
        <div class="form-container">
            <div class="card">
                <div class="card-body">
                    <form action="Controlador_tabla?menu=Vendedores" action="Controlador_tabla?menu=Reportes" method="POST">
                        <input type="text" name="codigoempleado" id="dniInput" placeholder="DNI del Empleado">
                        <input type="submit" name="accion" value="BuscarEmpleado" class="btn btn-outline-info">
                        <div class="form-group">
                            <label>DNI</label>
                            <input type="text" value="${vendedor.DNI}" name="txtdni" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>NOMBRES</label>
                            <input type="text" value="${vendedor.NOMBRE_VENDEDOR}" name="txtnombres" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>FECHA_CONTRATO</label>
                            <input type="text" value="${vendedor.FECHA_CONTRATO}" name="txtfecha" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>SALARIO</label>
                            <input type="number" value="${vendedor.SALARIO}" name="txtsalario" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>ESTADO</label>
                            <input type="text" value="${vendedor.ESTADO_VENDEDOR}" name="txtestado" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>USUARIO</label>
                            <input type="text" value="${vendedor.USUARIO}" name="txtusuario" class="form-control">
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