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
        <h1>Reporte Especificaciones</h1>

        <table border="1">
            <tr>
                <th>ID</th>
                <th>TITULO</th>
                <th>DESCRIPCION</th>
                <th>PRODUCTO</th>
            </tr>
            <c:forEach items="${especificaciones}" var="espe">
                <tr>
                    <td> ${usua.getid_esp()} </td>
                    <td> ${usua.gettitulo()} </td>
                    <td> ${usua.getdescripcion()} </td>
                    <td>
                        <c:forEach var="producto" items="${productos}">
                            <c:if test="${producto.id_prod == espe.id_prod}">
                                ${producto.NOMBRE_PROD}
                            </c:if>
                        </c:forEach>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </center>
</body>
</html>