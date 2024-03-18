package ModeloDAO;

import Modelo.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Config.Conexion;

public class CategoriaDAO {

    Conexion conn = new Conexion();
    Connection conexion;
    PreparedStatement ps;
    ResultSet result;

    int respuesta;

    public List<Categoria> obtenerTodasLasCategorias() {
        List<Categoria> categorias = new ArrayList<>();
        String sql = "SELECT * FROM CATEGORIA";

        try {
            conexion = conn.getConnection();
            ps = conexion.prepareStatement(sql);
            result = ps.executeQuery();

            while (result.next()) {
                Categoria categoria = new Categoria();
                categoria.setID_CATEGORIA(result.getInt("ID_CATEGORIA"));
                categoria.setNOMBRE_CATEGORIA(result.getString("NOMBRE_CATEGORIA"));
                categoria.setDESCRIPCION(result.getString("DESCRIPCION"));
                categoria.setESTADO(result.getBoolean("ESTADO"));
                categorias.add(categoria);
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

        return categorias;
    }

    public List listar() {
        String sql = "SELECT * FROM CATEGORIA";
        ArrayList<Categoria> lista = new ArrayList<>();
        try {
            conexion = conn.getConnection();//
            ps = conexion.prepareStatement(sql);
            result = ps.executeQuery();
            while (result.next()) {
                Categoria cate = new Categoria();
                cate.setID_CATEGORIA(result.getInt(1));
                cate.setNOMBRE_CATEGORIA(result.getString(2));
                cate.setDESCRIPCION(result.getString(3));
                cate.setESTADO(result.getBoolean(4));
                lista.add(cate);
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

    public int agregar(Categoria cate) {
        String sql = "INSERT INTO CATEGORIA(NOMBRE_CATEGORIA, DESCRIPCION, ESTADO) "
                + "VALUES(?, ?, ?)";
        try {
            conexion = conn.getConnection();
            ps = conexion.prepareStatement(sql);
            ps.setString(1, cate.getNOMBRE_CATEGORIA());
            ps.setString(2, cate.getDESCRIPCION());
            ps.setBoolean(3, cate.isESTADO());
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

    public Categoria listarId(int id) {

        Categoria cate = new Categoria();
        String sql = "SELECT * FROM CATEGORIA WHERE ID_CATEGORIA=" + id;
        try {
            conexion = conn.getConnection();
            ps = conexion.prepareStatement(sql);
            result = ps.executeQuery();
            while (result.next()) {
                cate.setNOMBRE_CATEGORIA(result.getString(2));
                cate.setDESCRIPCION(result.getString(3));
                cate.setESTADO(result.getBoolean(4));
            }
        } catch (Exception e) {

        }
        return cate;
    }

    public int actualizar(Categoria cat) {
        String sql = "UPDATE CATEGORIA SET NOMBRE_CATEGORIA = ?, DESCRIPCION= ?, ESTADO = ?  WHERE ID_CATEGORIA = ?";

        try {
            conexion = conn.getConnection();
            ps = conexion.prepareStatement(sql);
            ps.setString(1, cat.getNOMBRE_CATEGORIA());
            ps.setString(2, cat.getDESCRIPCION());
            ps.setBoolean(3, cat.isESTADO());
            ps.setInt(4, cat.getID_CATEGORIA());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar recursos y manejar excepciones aquí
        }
        return respuesta;
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM CATEGORIA WHERE ID_CATEGORIA =" + id;

        try {
            conexion = conn.getConnection();
            ps = conexion.prepareStatement(sql);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
