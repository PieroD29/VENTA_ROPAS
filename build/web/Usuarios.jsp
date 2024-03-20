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
                <h1>&nbsp;LISTA DE USUARIOS</h1>
                <br>
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>USUARIO</th>
                            <th>CONTRASEÑA</th>
                            <th>PERFIL</th>
                            <th>NIVEL</th>
                            <th>OTROS</th>
                            <th>ACCIONES</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="usua" items="${usuarios}">
                            <tr>
                                <td> ${usua.getid_user()} </td>
                                <td> ${usua.getusuario()} </td>
                                <td> ${usua.getcontra()} </td>
                                <td> ${usua.getperfil()} </td>
                                <td>${usua.getnivel()}</td>
                                <td> ${usua.getotros()}</td>
                                <td><a class="btn btn-warning" href="Controlador_tabla?menu=Usuarios&accion=Update&id=${usua.id_user}">Update</a></td>
                                <td><a class="btn btn-danger" href="Controlador_tabla?menu=Usuarios&accion=Delete&id=${usua.id_user}">Delete</a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                     <a class="btn btn-primary" href="Controlador_tabla?menu=ReportesUsuarios&accion=reporteusuario"><strong>ReporteExcel de Usuarios</strong></a> 
                </table>
            </div>
        </div>
        <div class="form-container">
            <div class="card">
                <div class="card-body">
                    <form action="Controlador_tabla?menu=Usuarios" action="Controlador_tabla?menu=ReportesUsuarios" method="POST">
                        <input type="text" name="perfil" id="perfilInput" placeholder="Perfil del Usuario">
                        <input type="submit" name="accion" value="BuscarUsuario" class="btn btn-outline-info">
                        <div class="form-group">
                            <label>USUARIO</label>
                            <input type="text" value="${usuario.usuario}" name="txtusuario" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>CONTRASEÑA</label>
                            <input type="text" value="${usuario.contra}" name="txtcontra" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>PERFIL</label>
                            <input type="text" value="${usuario.perfil}" name="txtperfil" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>NIVEL</label>
                            <input type="text" value="${usuario.nivel}" name="txtnivel" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>OTROS</label>
                            <input type="text" value="${usuario.otros}" name="txtotros" class="form-control">
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