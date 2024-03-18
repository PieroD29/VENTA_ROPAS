<%-- 
    Document   : Direcciones
    Created on : 27 oct 2023, 11:36:40
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
                margin-right: 250px;
            }

            .table-container {
                flex: 1;
                max-width: 80%;
                max-height: 100vh;
                overflow-y: auto;
                margin-right: 20px;
            }

            .form-container {
                width: 350px;
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
                <h1>&nbsp;REGISTRO DE DIRECCIONES</h1>
                <br>
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>CALLE</th>
                            <th>DISTRITO</th>
                            <th>CIUDAD</th>
                            <th>ACCIONES</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="dir" items="${direcciones}">
                            <tr>
                                <td>${dir.getID_DIRECCION()}</td>
                                <td>${dir.getCALLE()}</td>
                                <td>${dir.getDISTRITO()}</td>
                                <td>${dir.getCIUDAD()}</td>
                                <td><a class="btn btn-warning" href="Controlador_tabla?menu=Direcciones&accion=Update&id=${dir.ID_DIRECCION}">Update</a></td>
                                <td><a class="btn btn-danger"
                                       href="Controlador_tabla?menu=Direcciones&accion=Delete&id=<c:out value='${dir.ID_DIRECCION}' />">Delete</a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                     <a class="btn btn-primary" href="Controlador_tabla?menu=ReportesDirecciones&accion=reportedireccion"><strong>ReporteExcel de Direcciones</strong></a> 
                </table>
            </div>
        </div>
        <div class="form-container">
            <div class="card">
                <div class="card-body">
                    <form action="Controlador_tabla?menu=Direcciones" action="Controlador_tabla?menu=ReportesDirecciones" method="POST">
                        <div class="form-group">
                            <label>CALLE</label>
                            <input type="text" value="${direccion.CALLE}" name="txtcalle" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>DISTRITO</label>
                            <input type="text" value="${direccion.DISTRITO}" name="txtdistrito" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>CIUDAD</label>
                            <input type="text" value="${direccion.CIUDAD}" name="txtciudad" class="form-control">
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