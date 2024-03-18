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
        <h1>Reporte Direcciones</h1>

        <table border="1">
            <tr>
                <th>ID</th>
                <th>CALLE</th>
                <th>DISTRITO</th>
                <th>CIUDAD</th>
            </tr>
            <c:forEach  items="${direcciones}" var="dir">
                <tr>
                    <td>${dir.getID_DIRECCION()}</td>
                    <td>${dir.getCALLE()}</td>
                    <td>${dir.getDISTRITO()}</td>
                    <td>${dir.getCIUDAD()}</td>
                </tr>
            </c:forEach>
        </table>
    </center>
</body>
</html>