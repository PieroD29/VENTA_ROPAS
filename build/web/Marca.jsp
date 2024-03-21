<%-- 
    Document   : Marca
    Created on : 21 mar. 2024, 00:33:17
    Author     : PC
--%>

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
            <h1>LISTA DE MARCAS</h1>
            <a class="btn btn-primary" href="Controlador_tabla?menu=ReportesMarca&amp;accion=reportemarca"><strong>ReporteExcel de Marca</strong></a> 
        </div>
        <div class="container">
            <div class="table-container">
                <br>
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>NOMBRE</th>
                            <th>ESTADO</th>
                            <th></th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="mar" items="${listamarca}">
                            <tr>
                                <td> ${mar.getID_MARCA()} </td>
                                <td> ${mar.getNOMBRE_MARCA()} </td>
                                <td> ${mar.isESTADO_MARCA()} </td>
                                <td><a class="btn btn-warning"
                                       href="Controlador_tabla?menu=Marca&accion=Update&id=${mar.ID_MARCA}">Update</a></td>
                                <td><a class="btn btn-danger"
                                       href="Controlador_tabla?menu=Marca&accion=Delete&id=${mar.ID_MARCA}">Delete</a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="form-container">
            <div class="card" style=" height: 10%;">
                <div class="card-body">
                    <form action="Controlador_tabla?menu=Marca" method="POST">
                        <div class="form-group">
                            <label>ID_MARCA</label>
                            <input type="text" value="${marca.ID_MARCA}" name="txtidmarca" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>NOMBRE_MARCA</label>
                            <input type="text" value="${marca.NOMBRE_MARCA}" name="txtnommarca" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>ESTADO</label>
                            <input type="text" value="${marca.ESTADO_MARCA}" name="txtestmarca" class="form-control">
                        </div>
                        <input type="submit" name="accion" value="Agregar" class="btn btn-info">
                        <input type="submit" name="accion" value="Actualizar" class="btn btn-success">
                    </form>
                </div>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    


</body>
</html>
