<%-- 
    Document   : Clientes_direcciones
    Created on : 27 oct 2023, 14:58:33
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
                max-width: 92%;
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
                width: 90%;
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
                <h1>&nbsp;CLIENTES Y DIRECCIONES</h1>
                <br>
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>CLIENTE</th>
                            <th>DIRECCION DE CASA</th>
                            <th>ACCIONES</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="cli_dir" items="${clientes_direcciones}">
                            <tr>
                                <td>${cli_dir.getID_CLIENTE_DIRECCION()}</td>
                                <td>
                                    <c:forEach var="cliente" items="${clientes}">
                                        <c:if test="${cliente.ID_CLIENTE == cli_dir.ID_CLIENTE}">
                                            ${cliente.NOMBRE_CLIENTE}
                                        </c:if>
                                    </c:forEach>
                                </td>
                                <td>
                                    <c:forEach var="direccion" items="${direcciones}">
                                        <c:if test="${direccion.ID_DIRECCION == cli_dir.ID_DIRECCION}">
                                            ${direccion.CALLE}
                                        </c:if>
                                    </c:forEach>
                                </td>
                                <td><a class="btn btn-warning" href="Controlador_tabla?menu=Clientes_direcciones&accion=Update&id=${cli_dir.ID_CLIENTE_DIRECCION}">Update</a></td>
                                <td><a class="btn btn-danger"
                                       href="Controlador_tabla?menu=Clientes_direcciones&accion=Delete&id=<c:out value='${cli_dir.ID_CLIENTE_DIRECCION}' />">Delete</a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                  <a class="btn btn-primary" href="Controlador_tabla?menu=ReportesDirecciones_Clientes&accion=reportedireccion_cliente"><strong>ReporteExcel Direcciones de Clientes</strong></a> 
                </table>
            </div>
        </div>
        <div class="form-container">
            <div class="card">
                <div class="card-body">
                    <form action="Controlador_tabla?menu=Clientes_direcciones" action="Controlador_tabla?menu=ReportesDirecciones_Clientes" method="POST">
                        <div class="form-group">
                            <label>ID_CLIENTE</label>
                            <select name="txtcliente" class="form-control">
                                <option value="">Seleccione el cliente</option>
                                <c:forEach var="cliente" items="${clientes}">
                                    <c:choose>
                                        <c:when test="${cliente.ID_CLIENTE == cliente_direccion.ID_CLIENTE}">
                                            <option value="${cliente.ID_CLIENTE}" selected>${cliente.NOMBRE_CLIENTE}</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="${cliente.ID_CLIENTE}">${cliente.NOMBRE_CLIENTE}</option>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>ID_DIRECCION</label>
                            <select name="txtdireccion" class="form-control">
                                <option value="">Seleccione una dirección para el cliente</option>
                                <c:forEach var="direccion" items="${direcciones}">
                                    <c:choose>
                                        <c:when test="${direccion.ID_DIRECCION == cliente_direccion.ID_DIRECCION}">
                                            <option value="${direccion.ID_DIRECCION}" selected>${direccion.CALLE}</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="${direccion.ID_DIRECCION}">${direccion.CALLE}</option>
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