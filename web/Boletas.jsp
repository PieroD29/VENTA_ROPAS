 
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
                overflow: hidden; 
                margin-right: 230px;
                
            }

            .table-container {
                flex: 1;
                overflow-y: auto;
            }

            /* Estilos para que la tabla ocupe todo el ancho disponible */
            .table-container .table {
                width: 100%;
            }

            .form-group {
                margin: 10px 0;
            }

            .btn {
                margin: 10px 0;
            }

            .table.table-hover {
                /* No establezcas un ancho fijo en la tabla */
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
                <h1>VENTAS REGISTRADAS</h1>
                <br>
                <table class="table table-hover">
                    <thead>
                        <tr>

                            <th>#</th>
                            <th>CLIENTE</th>
                            <th>VENDEDOR</th>
                            <th>NUMERO_SERIE</th>
                            <th>FECHA_EMISION</th>
                            <th>MONTO_TOTAL</th>
                            <th>ESTADO</th>
                    </thead>
                    <tbody>
                        <c:forEach var="ve" items="${ventas}">
                            <tr>
                                <td> ${ve.getNRO_BOLETA()} </td>
                                <td>
                                    <c:forEach var="cliente" items="${clientes}">
                                        <c:if test="${cliente.ID_CLIENTE == ve.ID_CLIENTE}">
                                            ${cliente.NOMBRE_CLIENTE}
                                        </c:if>
                                    </c:forEach>
                                </td>
                                <td>
                                    <c:forEach var="vendedor" items="${vendedores}">
                                        <c:if test="${vendedor.ID_VENDEDOR == ve.ID_VENDEDOR}">
                                            ${vendedor.NOMBRE_VENDEDOR}
                                        </c:if>
                                    </c:forEach>
                                </td>
                                <td> ${ve.getNUMERO_SERIE()} </td>
                                <td> ${ve.getFECHA_EMISION()} </td>
                                <td> ${ve.getMONTO_TOTAL()} </td>
                                <td> ${ve.getESTADO()} </td>
                                <!---<td><a class="btn btn-warning"
                                       href="Controlador_tabla?menu=Ventas&accion=Update&id=${ve.NRO_BOLETA}">Update</a>
                                </td>--->
                                <td><a class="btn btn-danger"
                                       href="Controlador_tabla?menu=Ventas&accion=Delete&id=<c:out value='${ve.NRO_BOLETA}' />">Delete</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                    <a class="btn btn-primary" href="Controlador_tabla?menu=ReportesVentas&accion=reporteventa"><strong>ReporteExcel de Ventas</strong></a> 
                </table>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
                integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js"
                integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
