package ModeloDAO;
 

import Config.Conexion;
import Modelo.Boleta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoletaDAO {

    Conexion conn = new Conexion();
    Connection conexion;
    PreparedStatement ps;
    ResultSet result;
    int r;

    public String GenerarSerie() {
        String numero_serie = "";
        String sql = "SELECT MAX(NUMERO_SERIE) FROM BOLETA";

        try {
            conexion = conn.getConnection();//
            ps = conexion.prepareStatement(sql);
            result = ps.executeQuery();
            while (result.next()) {
                numero_serie = result.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return numero_serie;
    }

    public List listar() {
        String sql = "SELECT * FROM BOLETA";
        ArrayList<Boleta> lista = new ArrayList<>();
        try {
            conexion = conn.getConnection();//
            ps = conexion.prepareStatement(sql);
            result = ps.executeQuery();
            while (result.next()) {
                Boleta bole = new Boleta();
                bole.setIdboleta(result.getInt(1));
                bole.setItem(result.getInt(2));
                bole.setIdcliente(result.getInt(3));
                bole.setIdempleado(result.getInt(4));
                bole.setIdproducto(result.getInt(5));
                bole.setNumserie(result.getString(6));
                bole.setDescripcion_pro(result.getString(7));
                bole.setFecha(result.getString(8));
                bole.setPrecio(result.getDouble(9));
                bole.setCantidad(result.getInt(10));
                bole.setSubtotal(result.getDouble(11));
                bole.setMonto(result.getDouble(12));
                bole.setEstado(result.getString(13));
                lista.add(bole);
            }
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            if (result != null) {
                try {
                    result.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return lista;
    }

    public String NroBoleta() {
        String idventas = "";
        String sql = "SELECT MAX(NRO_BOLETA) FROM BOLETA";
        try {
            conexion = conn.getConnection();//
            ps = conexion.prepareStatement(sql);
            result = ps.executeQuery();
            while (result.next()) {
                idventas = result.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return idventas;
    }

    public int guardarBoleta(Boleta bo) {
        String sql = "INSERT INTO BOLETA(ID_CLIENTE, ID_VENDEDOR, NUMERO_SERIE, FECHA_EMISION, MONTO_TOTAL, ESTADO) VALUES(?,?,?,?,?,?)";
        try {
            conexion = conn.getConnection();//
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, bo.getIdcliente());
            ps.setInt(2, bo.getIdempleado());
            ps.setString(3, bo.getNumserie());
            ps.setString(4, bo.getFecha());
            ps.setDouble(5, bo.getMonto());
            ps.setString(6, bo.getEstado());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return r;
    }

    public int guardarDetalleboletas(Boleta boleta) {
        String sql = "INSERT INTO DETALLE_BOLETA(NRO_BOLETA, COD_PRODUCTO, CANTIDAD, PRECIO_VENTA) VALUES (?,?,?,?)";
        try {
            conexion = conn.getConnection();//
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, boleta.getIdboleta());
            ps.setInt(2, boleta.getIdproducto());
            ps.setInt(3, boleta.getCantidad());
            ps.setDouble(4, boleta.getPrecio());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return r;
    }
}
