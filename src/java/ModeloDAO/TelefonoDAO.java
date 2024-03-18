package ModeloDAO;

import Config.Conexion;
import Modelo.Cliente;
import Modelo.Telefono;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TelefonoDAO {

    Conexion conn = new Conexion();
    Connection conexion;
    PreparedStatement ps;
    ResultSet result;
    int respuesta;


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

//----------------OPERACIONES CRUD----------------------

    public List listar() {
        String sql = "SELECT * FROM TELEFONO";
        ArrayList<Telefono> lista = new ArrayList<>();
        try {
            conexion = conn.getConnection();//
            ps = conexion.prepareStatement(sql);
            result = ps.executeQuery();
            while (result.next()) {
                Telefono tel = new Telefono();
                tel.setID_TELEFONO(result.getInt(1));
                tel.setTELEFONO_1(result.getString(2));
                tel.setTELEFONO_2(result.getString(3));
                tel.setID_CLIENTE(result.getInt(4));
                lista.add(tel);
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

    public int agregar(Telefono tel) {
        String sql = "INSERT INTO TELEFONO (TELEFONO_1, TELEFONO_2, ID_CLIENTE) VALUES (?, ?, ?)";
        try {
            conexion = conn.getConnection();
            ps = conexion.prepareStatement(sql);
            ps.setString(1, tel.getTELEFONO_1());
            ps.setString(2, tel.getTELEFONO_2());
            ps.setInt(3, tel.getID_CLIENTE());
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

    public Telefono listarId(int id) {

       Telefono tel = new Telefono();
        String sql = "SELECT * FROM TELEFONO WHERE ID_TELEFONO=" + id;
        try {
            conexion = conn.getConnection();
            ps = conexion.prepareStatement(sql);
            result = ps.executeQuery();
            while (result.next()) {
                tel.setTELEFONO_1(result.getString(2));
                tel.setTELEFONO_2(result.getString(3));
                tel.setID_CLIENTE(result.getInt(4));
 
            }
        } catch (Exception e) {

        }
        return tel;
    }

    public int actualizar(Telefono tele) {
        String sql = "UPDATE TELEFONO SET  TELEFONO_1 = ?, TELEFONO_2 = ?, ID_CLIENTE = ?  WHERE ID_TELEFONO = ?";

        try {
            conexion = conn.getConnection();
            ps = conexion.prepareStatement(sql);
            ps.setString(1, tele.getTELEFONO_1());
            ps.setString(2, tele.getTELEFONO_2());
            ps.setInt(3, tele.getID_CLIENTE());
            ps.setInt(4, tele.getID_TELEFONO());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar recursos y manejar excepciones aquí
        }
        return respuesta;
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM TELEFONO WHERE ID_TELEFONO =" + id;

        try {
            conexion = conn.getConnection();
            ps = conexion.prepareStatement(sql);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
