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
        <h1>Reporte Telefonos</h1>

        <table border="1">
            <tr>
                <th>ID</th>
                <th>TELEFONO FIJO</th>
                <th>TELEFONO MOVIL</th>
                <th>CLIENTE</th>
            </tr>
            <c:forEach var="tel" items="${telefonos}">
                <tr>
                    <td>${tel.getID_TELEFONO()}</td>
                    <td>${tel.getTELEFONO_1()}</td>
                    <td>${tel.getTELEFONO_2()}</td>
                    <td>
                        <c:forEach var="cliente" items="${clientes}">
                            <c:if test="${cliente.ID_CLIENTE == tel.ID_CLIENTE}">
                                ${cliente.NOMBRE_CLIENTE}
                            </c:if>
                        </c:forEach>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </center>
</body>
</html>