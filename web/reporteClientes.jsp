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
        <h1>Reporte Clientes</h1>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>DNI</th>
                <th>NOMBRE</th>
                <th>RECORD_COMPRA</th>
                <th>FECHA_NACIMIENTO</th>
                <th>ESTADO</th>
            </tr>
            <c:forEach  items="${clientes}" var="cli">
                <tr>
                    <td> ${cli.getID_CLIENTE()} </td>
                    <td> ${cli.getDNI()} </td>
                    <td> ${cli.getNOMBRE_CLIENTE()} </td>
                    <td> ${cli.getRECORD_COMPRA()} </td>
                    <td> ${cli.getFECHA_NACIMIENTO()} </td>
                    <td> ${cli.getESTADO_CLIENTE()} </td>
                </tr>
            </c:forEach>

        </table>
    </center>
</body>
</html>