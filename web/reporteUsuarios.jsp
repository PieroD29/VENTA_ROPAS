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
        <h1>Reporte Usuarios</h1>

        <table border="1">
            <tr>
                <th>ID</th>
                <th>USUARIO</th>
                <th>CONTRASEÑA</th>
                <th>PERFIL</th>
                <th>NIVEL</th>
                <th>OTROS</th>
            </tr>
            <c:forEach items="${usuarios}" var="usua">
                <tr>
                    <td> ${usua.getid_user()} </td>
                    <td> ${usua.getusuario()} </td>
                    <td> ${usua.getcontraseña()} </td>
                    <td> ${usua.getperfil()} </td>
                    <td> ${usua.getnivel()}</td>
                    <td> ${usua.getotros()}</td>
                </tr>
            </c:forEach>
        </table>
    </center>
</body>
</html>