package ModeloDAO;

import Modelo.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Config.Conexion;
import Modelo.Boleta;
import Modelo.Producto;

public class ClienteDAO {

    Conexion conn = new Conexion();
    Connection conexion;
    PreparedStatement ps;
    ResultSet result;
    int respuesta;

//----------------RECUPERACION DE DATOS DEL CLIENTE EN EL COMBO BOX DE LA TABLA TELEFONOS----------------------
    public List<Cliente> obtenerTodosLosClientes() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM CLIENTE";

        try {
            conexion = conn.getConnection();
            ps = conexion.prepareStatement(sql);
            result = ps.executeQuery();

            while (result.next()) {
                Cliente cliente = new Cliente();
                cliente.setID_CLIENTE(result.getInt("ID_CLIENTE"));
                cliente.setNOMBRE_CLIENTE(result.getString("NOMBRE_CLIENTE"));
                // Puedes agregar otras propiedades del proveedor si es necesario
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cierre de recursos aquí
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

        return clientes;
    }

//----------------CLIENTE QUE REALIZARA LA COMPRA----------------------
    public Cliente buscar(String dni) {
        Cliente cli = new Cliente();
        String sql = "SELECT * FROM CLIENTE WHERE DNI=" + dni;
        try {
            conexion = conn.getConnection();//
            ps = conexion.prepareStatement(sql);
            result = ps.executeQuery();
            while (result.next()) {

                cli.setID_CLIENTE(result.getInt(1));
                cli.setDNI(result.getString(2));
                cli.setNOMBRE_CLIENTE(result.getString(3));
                cli.setRECORD_COMPRA(result.getInt(4));
                cli.setFECHA_NACIMIENTO(result.getString(5));
                cli.setESTADO_CLIENTE(result.getString(6));
            }
        } catch (Exception e) {
        }
        return cli;
    }

    //----------------RECORD DE COMPRAS DEL CLIENTE----------------------
   
//----------------OPERACIONES CRUD----------------------

    public List listar() {
        String sql = "SELECT * FROM CLIENTE";
        ArrayList<Cliente> lista = new ArrayList<>();
        try {
            conexion = conn.getConnection();//
            ps = conexion.prepareStatement(sql);
            result = ps.executeQuery();
            while (result.next()) {
                Cliente cli = new Cliente();
                cli.setID_CLIENTE(result.getInt(1));
                cli.setDNI(result.getString(2));
                cli.setNOMBRE_CLIENTE(result.getString(3));
                cli.setRECORD_COMPRA(result.getInt(4));
                cli.setFECHA_NACIMIENTO(result.getString(5));
                cli.setESTADO_CLIENTE(result.getString(6));
                lista.add(cli);
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

    public int agregar(Cliente cli) {
        String sql = "INSERT INTO CLIENTE(DNI, NOMBRE_CLIENTE, RECORD_COMPRA, FECHA_NACIMIENTO, ESTADO_CLIENTE) "
                + "VALUES(?, ?, ?, ?, ?)";
        try {
            conexion = conn.getConnection();
            ps = conexion.prepareStatement(sql);
            ps.setString(1, cli.getDNI());
            ps.setString(2, cli.getNOMBRE_CLIENTE());
            ps.setInt(3, cli.getRECORD_COMPRA());
            ps.setString(4, cli.getFECHA_NACIMIENTO());
            ps.setString(5, cli.getESTADO_CLIENTE());
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

    public Cliente listarId(int id) {

        Cliente cli = new Cliente();
        String sql = "SELECT * FROM CLIENTE WHERE ID_CLIENTE=" + id;
        try {
            conexion = conn.getConnection();
            ps = conexion.prepareStatement(sql);
            result = ps.executeQuery();
            while (result.next()) {
                cli.setDNI(result.getString(2));
                cli.setNOMBRE_CLIENTE(result.getString(3));
                cli.setRECORD_COMPRA(result.getInt(4));
                cli.setFECHA_NACIMIENTO(result.getString(5));
                cli.setESTADO_CLIENTE(result.getString(6));
            }
        } catch (Exception e) {

        }
        return cli;
    }

    public int actualizar(Cliente clie) {
        String sql = "UPDATE CLIENTE SET  DNI = ?, NOMBRE_CLIENTE = ?, RECORD_COMPRA = ?, FECHA_NACIMIENTO = ?, ESTADO_CLIENTE = ?  WHERE ID_CLIENTE = ?";

        try {
            conexion = conn.getConnection();
            ps = conexion.prepareStatement(sql);
            ps.setString(1, clie.getDNI());
            ps.setString(2, clie.getNOMBRE_CLIENTE());
            ps.setInt(3, clie.getRECORD_COMPRA());
            ps.setString(4, clie.getFECHA_NACIMIENTO());
            ps.setString(5, clie.getESTADO_CLIENTE());
            ps.setInt(6, clie.getID_CLIENTE());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar recursos y manejar excepciones aquí
        }
        return respuesta;
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM CLIENTE WHERE ID_CLIENTE =" + id;

        try {
            conexion = conn.getConnection();
            ps = conexion.prepareStatement(sql);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
