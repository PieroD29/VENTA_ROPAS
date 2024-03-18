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
        <h1>Reporte Empleados</h1>

        <table border="1">
            <tr>
                <th>ID</th>
                <th>DNI</th>
                <th>NOMBRES</th>
                <th>FECHA_CONTRATO</th>
                <th>SALARIO</th>
                <th>ESTADO</th>
                <th>USUARIO</th>
            </tr>
            <c:forEach items="${vendedores}" var="vende">
                <tr>
                    <td> ${vende.getID_VENDEDOR()} </td>
                    <td> ${vende.getDNI()} </td>
                    <td> ${vende.getNOMBRE_VENDEDOR()} </td>
                    <td> ${vende.getFECHA_CONTRATO()} </td>
                    <td>${vende.getSALARIO()}</td>
                    <td> ${vende.getESTADO_VENDEDOR()}</td>
                    <td> ${vende.getUSUARIO()}</td>
                </tr>
            </c:forEach>
        </table>
    </center>
</body>
</html>