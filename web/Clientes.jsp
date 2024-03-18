<%-- 
    Document   : Clientes
    Created on : 23 oct 2023, 1:38:43
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
                margin-right: 245px;
            }

            .table-container {
                flex: 1;
                max-width: 84%;
                max-height: 100vh;
                overflow-y: auto;
                margin-right: 20px;
            }

            .form-container {
                flex: 1;
                display: flex;
                flex-direction: column;
                justify-content: flex-start;
                align-items: flex-end;
                max-width: 800%; /* Aumenta el ancho máximo según tus necesidades */
                position: absolute;
                top: 10px;
                right: 15px;
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
        <div class="container">
            <div class="table-container">
                <h1>LISTA DE CLIENTES</h1>
                <br>
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>DNI</th>
                            <th>NOMBRE</th>
                            <th>RECORD_COMPRA</th>
                            <th>FECHA_NACIMIENTO</th>
                            <th>ESTADO</th>
                            <th>ACCIONES</th>
                    </thead>
                    <tbody>
                        <c:forEach var="cli" items="${clientes}">
                            <tr>
                                <td> ${cli.getID_CLIENTE()} </td>
                                <td> ${cli.getDNI()} </td>
                                <td> ${cli.getNOMBRE_CLIENTE()} </td>
                                <td> ${cli.getRECORD_COMPRA()} </td>
                                <td> ${cli.getFECHA_NACIMIENTO()} </td>
                                <td> ${cli.getESTADO_CLIENTE()} </td>
                                <td><a class="btn btn-warning"
                                       href="Controlador_tabla?menu=Clientes&accion=Update&id=${cli.ID_CLIENTE}">Update</a>
                                </td>
                                <td><a class="btn btn-danger"
                                       href="Controlador_tabla?menu=Clientes&accion=Delete&id=<c:out value='${cli.ID_CLIENTE}' />">Delete</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                    <a class="btn btn-primary" href="Controlador_tabla?menu=ReportesClientes&accion=reportecliente"><strong>ReporteExcel de Clientes</strong></a>
                </table>
            </div>
        </div>
        <div class="form-container  ">
            <div class="card   ">
                <div class="card-body ">
                    <form action="Controlador_tabla?menu=Clientes" action="Controlador_tabla?menu=ReportesClientes" method="POST">
                        <input type="text" name="codigocliente" id="dniInput" placeholder="DNI del Cliente">
                        <input type="submit" name="accion" value="BuscarCliente" class="btn btn-outline-info">
       
                        <div class="form-group">
                            <label>DNI</label>
                            <input type="text" value="${cliente.DNI}" name="txtdni" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>NOMBRE</label>
                            <input type="text" value="${cliente.NOMBRE_CLIENTE}" name="txtnombre" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>RECORD_COMPRA</label>
                            <input type="text" value="${cliente.RECORD_COMPRA}" name="txtrecord" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>FECHA_NACIMIENTO</label>
                            <input type="text" value="${cliente.FECHA_NACIMIENTO}" name="txtfecha" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>ESTADO</label>
                            <input type="text" value="${cliente.ESTADO_CLIENTE}" name="txtestado" class="form-control">
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
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <script>
    // Función para mostrar la ventana emergente con mensajes personalizados
    function mostrarMensaje(mensaje) {
        alert(mensaje);
    }

    // Agregar un listener al formulario para llamar a la función cuando se envía el formulario
    document.getElementById('clienteForm').addEventListener('submit', function(event) {
        event.preventDefault();  // Evita el envío del formulario normal

        // Verificar la acción del formulario
        var accion = document.querySelector('input[name="accion"]').value;
        if (accion === 'Agregar') {
            // Si la acción es "Agregar", mostrar la ventana emergente
            mostrarMensaje('Cliente registrado correctamente');
        } else {
            // Lógica para otras acciones (actualizar, buscar, etc.)
            // Puedes agregar lógica específica para cada caso si es necesario
        }
    });
</script>
<script>
    // Función para ordenar la tabla por el DNI del cliente
    function orden_DNI() {
        // Obtener las filas de la tabla
        var filas = $('table tbody tr').get();

        // Ordenar las filas en función del valor del DNI (según el texto numérico)
        filas.sort(function (a, b) {
            var dniA = $(a).find('td:eq(1)').text();  // Obtener el valor del DNI de la primera columna
            var dniB = $(b).find('td:eq(1)').text();  // Obtener el valor del DNI de la segunda columna

            // Comparar los valores del DNI como números
            return parseInt(dniA) - parseInt(dniB);
        });

        // Volver a añadir las filas ordenadas a la tabla
        $('table tbody').empty().append(filas);
    }

    // Llamar a la función de ordenamiento al cargar la página (puedes cambiar esto según tus necesidades)
    $(document).ready(function() {
        orden_DNI();
    });
</script>
    </body>
</html>
