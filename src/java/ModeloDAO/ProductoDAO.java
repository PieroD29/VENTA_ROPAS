package ModeloDAO;

import Modelo.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Config.Conexion;
import Modelo.Proveedor;

public class ProductoDAO {

    Conexion conn = new Conexion();
    Connection conexion;
    PreparedStatement ps;
    ResultSet result;

    int respuesta;

     
    public Producto buscar(int id) {

        Producto pro = new Producto();
        String sql = "SELECT * FROM PRODUCTO WHERE COD_PRODUCTO=" + id;
        try {
            conexion = conn.getConnection();
            ps = conexion.prepareStatement(sql);
            result = ps.executeQuery();
            while (result.next()) {
                pro.setCOD_PRODUCTO(result.getInt(1));
                pro.setNOMBRE_PRODUCTO(result.getString(2));
                pro.setDESCRIPCION(result.getString(3));
                pro.setPRECIO_UNITARIO(result.getDouble(4));
                pro.setSTOCK(result.getInt(5));
                pro.setESTADO(result.getBoolean(6));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pro;
    }

    public int actualizarstock(int id, int stock) {
        String sql = "UPDATE PRODUCTO SET STOCK=? WHERE COD_PRODUCTO=?";

        try {
            conexion = conn.getConnection();
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, stock);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return respuesta;
    }
//----------------OPERACIONES CRUD----------------------

    public List listar() {
        String sql = "SELECT * FROM PRODUCTO";
        ArrayList<Producto> lista = new ArrayList<>();
        try {
            conexion = conn.getConnection();//
            ps = conexion.prepareStatement(sql);
            result = ps.executeQuery();
            while (result.next()) {
                Producto pro = new Producto();
                pro.setCOD_PRODUCTO(result.getInt(1));
                pro.setNOMBRE_PRODUCTO(result.getString(2));
                pro.setDESCRIPCION(result.getString(3));
                pro.setPRECIO_UNITARIO(result.getDouble(4));
                pro.setSTOCK(result.getInt(5));
                pro.setESTADO(result.getBoolean(6));
                pro.setID_PROVEEDOR(result.getInt(7));
                pro.setID_CATEGORIA(result.getInt(8));
                lista.add(pro);
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

    public int agregar(Producto pro) {
        String sql = "INSERT INTO PRODUCTO(NOMBRE_PRODUCTO, DESCRIPCION, PRECIO_UNITARIO, STOCK, ESTADO, ID_PROVEEDOR, ID_CATEGORIA) "
                + "VALUES(?, ?, ?, ?, ?, ?, ?)";
        try {
            conexion = conn.getConnection();
            ps = conexion.prepareStatement(sql);
            ps.setString(1, pro.getNOMBRE_PRODUCTO());
            ps.setString(2, pro.getDESCRIPCION());
            ps.setDouble(3, pro.getPRECIO_UNITARIO());
            ps.setInt(4, pro.getSTOCK());
            ps.setBoolean(5, pro.isESTADO());
            ps.setInt(6, pro.getID_PROVEEDOR());
            ps.setInt(7, pro.getID_CATEGORIA());
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

    public Producto listarId(int id) {

        Producto pro = new Producto();
        String sql = "SELECT * FROM PRODUCTO WHERE COD_PRODUCTO=" + id;
        try {
            conexion = conn.getConnection();
            ps = conexion.prepareStatement(sql);
            result = ps.executeQuery();
            while (result.next()) {
                pro.setCOD_PRODUCTO(result.getInt(1));
                pro.setNOMBRE_PRODUCTO(result.getString(2));
                pro.setDESCRIPCION(result.getString(3));
                pro.setPRECIO_UNITARIO(result.getDouble(4));
                pro.setSTOCK(result.getInt(5));
                pro.setESTADO(result.getBoolean(6));
                pro.setID_PROVEEDOR(result.getInt(7));
                pro.setID_CATEGORIA(result.getInt(8));
            }
        } catch (Exception e) {

        }
        return pro;
    }

    public int actualizar(Producto pr) {
        String sql = "UPDATE PRODUCTO SET NOMBRE_PRODUCTO = ?, DESCRIPCION = ?, PRECIO_UNITARIO = ?, STOCK = ?, ESTADO = ?, ID_PROVEEDOR = ?, ID_CATEGORIA = ? WHERE COD_PRODUCTO = ?";

        try {
            conexion = conn.getConnection();
            ps = conexion.prepareStatement(sql);
            ps.setString(1, pr.getNOMBRE_PRODUCTO());
            ps.setString(2, pr.getDESCRIPCION());
            ps.setDouble(3, pr.getPRECIO_UNITARIO());
            ps.setInt(4, pr.getSTOCK());
            ps.setBoolean(5, pr.isESTADO());
            ps.setInt(6, pr.getID_PROVEEDOR());
            ps.setInt(7, pr.getID_CATEGORIA());
            ps.setInt(8, pr.getCOD_PRODUCTO());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar recursos y manejar excepciones aquí
        }
        return respuesta;
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM PRODUCTO WHERE COD_PRODUCTO =" + id;

        try {
            conexion = conn.getConnection();
            ps = conexion.prepareStatement(sql);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
