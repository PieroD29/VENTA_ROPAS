package ModeloDAO;

import Modelo.Proveedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Config.Conexion;

public class ProveedorDAO {

    Conexion conn = new Conexion();
    Connection conexion;
    PreparedStatement ps;
    ResultSet result;

    int respuesta;

    public Proveedor buscar(String ruc) {
        Proveedor prove = new Proveedor();
        String sql = "SELECT * FROM PROVEEDOR WHERE RUC=" + ruc;
        try {
            conexion = conn.getConnection();//
            ps = conexion.prepareStatement(sql);
            result = ps.executeQuery();
            while (result.next()) {

                prove.setID_PROVEEDOR(result.getInt(1));
                prove.setNOM_PROVEEDOR(result.getString(2));
                prove.setRUC(result.getString(3));
                prove.setESTADO_PROVEEDOR(result.getString(4));
 
            }
        } catch (Exception e) {
        }
        return prove;
    }
 

    public List<Proveedor> obtenerTodosLosProveedores() {
        List<Proveedor> proveedores = new ArrayList<>();
        String sql = "SELECT * FROM PROVEEDOR";

        try {
            conexion = conn.getConnection();
            ps = conexion.prepareStatement(sql);
            result = ps.executeQuery();

            while (result.next()) {
                Proveedor proveedor = new Proveedor();
                proveedor.setID_PROVEEDOR(result.getInt("ID_PROVEEDOR"));
                proveedor.setNOM_PROVEEDOR(result.getString("NOM_PROVEEDOR"));
                // Puedes agregar otras propiedades del proveedor si es necesario
                proveedores.add(proveedor);
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

        return proveedores;
    }
    
    
//-----------------Operaciones CRUD---------------------------

    public List listar() {
        String sql = "SELECT * FROM PROVEEDOR";
        ArrayList<Proveedor> lista = new ArrayList<>();
        try {
            conexion = conn.getConnection();//
            ps = conexion.prepareStatement(sql);
            result = ps.executeQuery();
            while (result.next()) {
                Proveedor prove = new Proveedor();
                prove.setID_PROVEEDOR(result.getInt(1));
                prove.setNOM_PROVEEDOR(result.getString(2));
                prove.setRUC(result.getString(3));
                prove.setESTADO_PROVEEDOR(result.getString(4));
                lista.add(prove);
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

    public int agregar(Proveedor prove) {
        String sql = "INSERT INTO PROVEEDOR(NOM_PROVEEDOR, RUC, ESTADO_PROVEEDOR) "
                + "VALUES(?, ?, ?)";
        try {
            conexion = conn.getConnection();
            ps = conexion.prepareStatement(sql);
            ps.setString(1, prove.getNOM_PROVEEDOR());
            ps.setString(2, prove.getRUC());
            ps.setString(3, prove.getESTADO_PROVEEDOR());
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

    public Proveedor listarId(int id) {

        Proveedor prove = new Proveedor();
        String sql = "SELECT * FROM PROVEEDOR WHERE ID_PROVEEDOR=" + id;
        try {
            conexion = conn.getConnection();
            ps = conexion.prepareStatement(sql);
            result = ps.executeQuery();
            while (result.next()) {
                prove.setNOM_PROVEEDOR(result.getString(2));
                prove.setRUC(result.getString(3));
                prove.setESTADO_PROVEEDOR(result.getString(4));
            }
        } catch (Exception e) {

        }
        return prove;
    }

    public int actualizar(Proveedor prov) {
        String sql = "UPDATE PROVEEDOR SET  NOM_PROVEEDOR = ?, RUC = ?, ESTADO_PROVEEDOR  = ?  WHERE ID_PROVEEDOR = ?";

        try {
            conexion = conn.getConnection();
            ps = conexion.prepareStatement(sql);
            ps.setString(1, prov.getNOM_PROVEEDOR());
            ps.setString(2, prov.getRUC());
            ps.setString(3, prov.getESTADO_PROVEEDOR());
            ps.setInt(4, prov.getID_PROVEEDOR());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar recursos y manejar excepciones aquí
        }
        return respuesta;
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM PROVEEDOR WHERE ID_PROVEEDOR =" + id;

        try {
            conexion = conn.getConnection();
            ps = conexion.prepareStatement(sql);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
