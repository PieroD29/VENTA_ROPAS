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
        String sql = "SELECT id_cat, descripcion, imagen FROM vista_Categoria;";

        try {
            conexion = conn.getConnection();
            ps = conexion.prepareStatement(sql);
            result = ps.executeQuery();

            while (result.next()) {
                Categoria categoria = new Categoria();
                categoria.setId_cat(result.getInt("id_cat"));
                categoria.setDescripcion(result.getString("descripcion"));
                categoria.setImg_dir(result.getString("imagen"));
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
        String sql = "SELECT id_cat, descripcion, imagen FROM vista_Categoria;";
        ArrayList<Categoria> lista = new ArrayList<>();
        try {
            conexion = conn.getConnection();
            ps = conexion.prepareStatement(sql);
            result = ps.executeQuery();
            while (result.next()) {
                Categoria cate = new Categoria();
                cate.setId_cat(result.getInt(1));
                cate.setDescripcion(result.getString(2));
                cate.setImg_dir(result.getString(3));
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
        String sql = "INSERT INTO CATEGORIA(id_cat, descripcion, imagen) "
                + "VALUES(?, ?, ?)";
        try {
            conexion = conn.getConnection();
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, cate.getId_cat());
            ps.setString(2, cate.getDescripcion());
            ps.setString(3, cate.getImg_dir());
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
        String sql = "SELECT id_cat, descripcion, imagen FROM vista_Categoria WHERE id_cat=" + id;
        try {
            conexion = conn.getConnection();
            ps = conexion.prepareStatement(sql);
            result = ps.executeQuery();
            while (result.next()) {
                cate.setId_cat(Integer.parseInt(result.getString(1)));
                cate.setDescripcion(result.getString(2));
                cate.setImg_dir(result.getString(3));
            }
        } catch (Exception e) {

        }
        return cate;
    }

    public int actualizar(Categoria cat) {
        String sql = "UPDATE CATEGORIA SET DESCRIPCION= ?, IMAGEN = ?  WHERE ID_CAT = ?";

        try {
            conexion = conn.getConnection();
            ps = conexion.prepareStatement(sql);
            ps.setString(1, cat.getDescripcion());
            ps.setString(2, cat.getImg_dir());
            ps.setInt(3, cat.getId_cat());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar recursos y manejar excepciones aquí
        }
        return respuesta;
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM CATEGORIA WHERE ID_CAT =" + id;

        try {
            conexion = conn.getConnection();
            ps = conexion.prepareStatement(sql);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
