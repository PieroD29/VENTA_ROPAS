<%@page import="utilerias.Conversiones, java.util.*"%>
<%@page contentType="application-/vnd.ms-excel"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String nombreArchivo = "Reporte.xls";
    response.setHeader("Content-Disposition", "attachment;filename=" + nombreArchivo);
%>
<!DOCTYPE html>
<html>
    <head>
        <title>Reporte Excel</title>
    </head>
    <body>
    <center> 
        <h1>Reporte Direcciones de Clientes</h1>

        <table border="1">
            <tr>
                <th>ID</th>
                <th>CLIENTE</th>
                <th>DIRECCION DE CASA</th>
            </tr>
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
                </tr>
            </c:forEach>
        </table>
    </center>
</body>
</html>