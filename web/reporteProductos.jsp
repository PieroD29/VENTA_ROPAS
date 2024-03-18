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
        <h1>Reporte Productos</h1>

        <table border="1">
            <tr>
                <th>ID</th>
                <th>NOMBRE </th>
                <th>DESCRIPCION</th>
                <th>PRECIO</th>
                <th>STOCK</th>
                <th>ESTADO</th>
                <th>PROVEEDOR</th>
                <th>CATEGORIA</th>
            </tr>
            <c:forEach var="pro" items="${productos}">
                <tr>
                    <td> ${pro.getCOD_PRODUCTO()} </td>
                    <td> ${pro.getNOMBRE_PRODUCTO()} </td>
                    <td> ${pro.getDESCRIPCION()} </td>
                    <td> ${pro.getPRECIO_UNITARIO()} </td>
                    <td> ${pro.getSTOCK()} </td>
                    <td> ${pro.isESTADO()} </td>
                    <td>
                        <c:forEach var="proveedor" items="${proveedores}">
                            <c:if test="${proveedor.ID_PROVEEDOR == pro.ID_PROVEEDOR}">
                                ${proveedor.NOM_PROVEEDOR}
                            </c:if>
                        </c:forEach>
                    </td>
                    <td>
                        <c:forEach var="categoria" items="${categorias}">
                            <c:if test="${categoria.ID_CATEGORIA == pro.ID_CATEGORIA}">
                                ${categoria.NOMBRE_CATEGORIA}
                            </c:if>
                        </c:forEach>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </center>
</body>
</html>