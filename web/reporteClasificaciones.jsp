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
            <h1>Reporte Clasificaciones</h1>
            <table border="1">
                <tr>
                    <th>ID</th>
                    <th>DESCRIPCION</th>
                    <th>IMAGEN</th>
                </tr>
                <c:forEach  items="${clasificacion}" var="clasi">
                    <tr>
                        <td>${clasi.getId_cat()}</td>
                        <td>${clasi.getDescripcion()}</td>
                        <td>${clasi.getImg_dir()}</td>
                    </tr>
                </c:forEach>
            </table>
        </center> 
    </body>
</html>
