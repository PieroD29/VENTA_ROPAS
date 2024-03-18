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
        <h1>Reporte de Ventas Realizadas</h1>

        <table border="1">
            <tr>
                <th>ID</th>
                <th>CLIENTE</th>
                <th>VENDEDOR</th>
                <th>NUMERO_SERIE</th>
                <th>FECHA_EMISION</th>
                <th>MONTO_TOTAL</th>
                <th>ESTADO</th>
            </tr>
            <c:forEach var="ve" items="${ventas}">
                <tr>
                    <td> ${ve.getNRO_BOLETA()} </td>
                    <td>
                        <c:forEach var="cliente" items="${clientes}">
                            <c:if test="${cliente.ID_CLIENTE == ve.ID_CLIENTE}">
                                ${cliente.NOMBRE_CLIENTE}
                            </c:if>
                        </c:forEach>
                    </td>
                    <td>
                        <c:forEach var="vendedor" items="${vendedores}">
                            <c:if test="${vendedor.ID_VENDEDOR == ve.ID_VENDEDOR}">
                                ${vendedor.NOMBRE_VENDEDOR}
                            </c:if>
                        </c:forEach>
                    </td>
                    <td> ${ve.getNUMERO_SERIE()} </td>
                    <td> ${ve.getFECHA_EMISION()} </td>
                    <td> ${ve.getMONTO_TOTAL()} </td>
                    <td> ${ve.getESTADO()} </td>
                </tr>
            </c:forEach>
            </form>
        </table>
    </center>
</body>
</html>