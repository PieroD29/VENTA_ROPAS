package ModeloDAO;

import Config.Conexion;
import Modelo.Cliente_direccion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Cliente_direccionDAO {

    Conexion conn = new Conexion();
    Connection conexion;
    PreparedStatement ps;
    ResultSet result;

    int respuesta;


    public List listar() {
        String sql = "SELECT ID_CLIENTE_DIRECCION, ID_CLIENTE, ID_DIRECCION FROM CLIENTE_DIRECCION";
        ArrayList<Cliente_direccion> lista = new ArrayList<>();
        try {
            conexion = conn.getConnection();//
            ps = conexion.prepareStatement(sql);
            result = ps.executeQuery();
            while (result.next()) {
                Cliente_direccion cli_dir = new Cliente_direccion();
                cli_dir.setID_CLIENTE_DIRECCION(result.getInt(1));
                cli_dir.setID_CLIENTE(result.getInt(2));
                cli_dir.setID_DIRECCION(result.getInt(3));
                lista.add(cli_dir);
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

    public int agregar(Cliente_direccion cli_dir) {
        String sql = "INSERT INTO CLIENTE_DIRECCION(ID_CLIENTE, ID_DIRECCION) "
                + "VALUES(?, ?)";
        try {
            conexion = conn.getConnection();
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, cli_dir.getID_CLIENTE());
            ps.setInt(2, cli_dir.getID_DIRECCION());
            respuesta = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            // Cerrar recursos y manejar excepciones aquí
            try {
                if (result != null) {
                    result.close();
                }

                if (ps != null) {
                    ps.close();
                }
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return respuesta;
    }

    public Cliente_direccion listarId(int id) {

        Cliente_direccion cli_dir = new Cliente_direccion();
        String sql = "SELECT * FROM CLIENTE_DIRECCION WHERE ID_CLIENTE_DIRECCION=" + id;
        try {
            conexion = conn.getConnection();
            ps = conexion.prepareStatement(sql);
            result = ps.executeQuery();
            while (result.next()) {
                cli_dir.setID_CLIENTE(result.getInt(2));
                cli_dir.setID_DIRECCION(result.getInt(3));
            }
        } catch (Exception e) {

        }
        return cli_dir;
    }

    public int actualizar(Cliente_direccion cd) {
        String sql = "UPDATE CLIENTE_DIRECCION SET ID_CLIENTE = ?, ID_DIRECCION = ?  WHERE ID_CLIENTE_DIRECCION = ?";

        try {
            conexion = conn.getConnection();
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, cd.getID_CLIENTE());
            ps.setInt(2, cd.getID_DIRECCION());
            ps.setInt(3, cd.getID_CLIENTE_DIRECCION());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar recursos y manejar excepciones aquí
        }
        return respuesta;
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM CLIENTE_DIRECCION WHERE ID_CLIENTE_DIRECCION =" + id;

        try {
            conexion = conn.getConnection();
            ps = conexion.prepareStatement(sql);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
