<%-- 
    Document   : SubCategorias
    Created on : 20 mar. 2024, 13:14:44
    Author     : W10
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <style>
            .container {
                display: flex;
                justify-content: space-between;
                overflow: hidden;
                margin-right: 255px;
            }

            .table-container {
                flex: 1;
                max-width: 84%; /* Reducido el ancho de la tabla al 75% */
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
                margin-right: 0;
            }

            th, td {
                border: 1px solid #dddddd;
                text-align: left;
                padding: 8px;
            }

            th:nth-child(3), td:nth-child(3) {
                width: 40%;
            }

            tr:nth-child(even) {
                background-color: #f2f2f2;
            }
        </style>
    </head>
    <body>
        <div style="margin-left: 280px;">
            <h1>LISTA DE SUBCATEGORIAS</h1>
             <a class="btn btn-primary"  href="Controlador_tabla?menu=ReportesSubCategorias&accion=reportecategoria"><strong>ReporteExcel de SubCategorias</strong></a> 
        </div>
        <div class="container">
            <div class="table-container">
                <br>
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>SUBCATEGORIA</th>
                            <th>IMAGEN</th>
                            <th>ACCIONES</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="sbcate" items="${subcategoria}">
                            <tr>
                                <td>${sbcate.getId_cat()}</td>
                                <td>${sbcate.getDescripcion()}</td>
                                <td>${sbcate.getImg_dir()}</td>
                                <td><a class="btn btn-warning" href="Controlador_tabla?menu=subCategorias&accion=Update&id=${sbcate.Id_sbcat}">Update</a></td>
                                <td><a class="btn btn-danger" href="Controlador_tabla?menu=subCategorias&accion=Delete&id=<c:out value='${sbcate.Id_sbcat}' />">Delete</a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="form-container">
            <div class="card">
                <div class="card-body">
                    <form action="Controlador_tabla?menu=subCategorias" action="Controlador_tabla?menu=ReportesSubCategorias" method="POST">
                        <div class="form-group">
                            <label>DESCRIPCION_SUBCATEGORIA</label>
                            <input type="text" value="${subcategoria.descripcion}" name="txtdescripcion" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>IMAGEN</label>
                            <input type="text" value="${subcategoria.img_dir}" name="txtdir_imagen" class="form-control">
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
