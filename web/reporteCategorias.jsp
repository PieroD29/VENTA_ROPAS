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
        <h1>Reporte Categorias</h1>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>CATEGORIA</th>
                <th>DESCRIPCION</th>
                <th>ESTADO</th>
            </tr>
            <c:forEach  items="${categorias}" var="cate">
                <tr>
                    <td>${cate.getID_CATEGORIA()}</td>
                    <td>${cate.getNOMBRE_CATEGORIA()}</td>
                    <td>${cate.getDESCRIPCION()}</td>
                    <td>${cate.isESTADO()}</td>
                </tr>
            </c:forEach>
        </table>
    </center>


</body>
</html>