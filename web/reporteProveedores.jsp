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
        <h1>Reporte Proveedores</h1>

        <table border="1">
            <tr>
                <th>ID</th>
                <th>NOMBRE</th>
                <th>RUC</th>
                <th>ESTADO</th>
            </tr>
            <c:forEach  items="${proveedores}" var="prove">
                <tr>
                    <td>${prove.getID_PROVEEDOR()}</td>
                    <td>${prove.getNOM_PROVEEDOR()}</td>
                    <td>${prove.getRUC()}</td>
                    <td>${prove.getESTADO_PROVEEDOR()}</td>
                </tr>
            </c:forEach>
        </table>
    </center>
</body>
</html>