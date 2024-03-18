/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloDAO;

import Config.Conexion;
import Modelo.Venta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP SUPPORT
 */
public class VentaDAO {

    Conexion conn = new Conexion();
    Connection conexion;
    PreparedStatement ps;
    ResultSet result;
    int respuesta;

    public List listar() {
        String sql = "SELECT * FROM BOLETA";
        ArrayList<Venta> lista = new ArrayList<>();
        try {
            conexion = conn.getConnection();//
            ps = conexion.prepareStatement(sql);
            result = ps.executeQuery();
            while (result.next()) {
                Venta ve = new Venta();
                ve.setNRO_BOLETA(result.getInt(1));
                ve.setID_CLIENTE(result.getInt(2));
                ve.setID_VENDEDOR(result.getInt(3));
                ve.setNUMERO_SERIE(result.getString(4));
                ve.setFECHA_EMISION(result.getString(5));
                ve.setMONTO_TOTAL(result.getDouble(6));
                ve.setESTADO(result.getString(7));
                lista.add(ve);
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
    
        public String obtenerNombreCliente(int ID_CLIENTE) {
        String nombreCliente = "";
        String sql = "SELECT NOMBRE_CLIENTE FROM CLIENTE WHERE ID_CLIENTE = ?";
        
        try {
            conexion = conn.getConnection();
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, ID_CLIENTE);
            result = ps.executeQuery();
            
            if (result.next()) {
                nombreCliente = result.getString("NOMBRE_CLIENTE");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cierre de recursos aquí
        }
        
        return nombreCliente;
    }
        
           public String obtenerNombreVendedor(int ID_VENDEDOR) {
        String nombreVendedor = "";
        String sql = "SELECT NOMBRE_VENDEDOR FROM VENDEDOR WHERE ID_VENDEDOR = ?";
        
        try {
            conexion = conn.getConnection();
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, ID_VENDEDOR);
            result = ps.executeQuery();
            
            if (result.next()) {
                nombreVendedor = result.getString("NOMBRE_VENDEDOR");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cierre de recursos aquí
        }
        
        return nombreVendedor;
    }
}
