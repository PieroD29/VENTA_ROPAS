package ModeloDAO;

import Modelo.SubCategoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Config.Conexion;

public class SubCategoriaDAO {
    
    Conexion conn = new Conexion();
    Connection conexion;
    PreparedStatement ps;
    ResultSet result;

    int respuesta;

    public List<SubCategoria> obtenerTodasLasSubCategorias() {
        List<SubCategoria> categorias = new ArrayList<>();
        String sql = "SELECT id_sbcat, descripcion, imagen FROM vista_subCat;";

        try {
            conexion = conn.getConnection();
            ps = conexion.prepareStatement(sql);
            result = ps.executeQuery();

            while (result.next()) {
                SubCategoria sbCategoria = new SubCategoria();
                sbCategoria.setId_sbcat(result.getInt("id_sbcat"));
                sbCategoria.setDescripcion(result.getString("descripcion"));
                sbCategoria.setImg_dir(result.getString("imagen"));
                categorias.add(sbCategoria);
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
        String sql = "SELECT id_sbcat, descripcion, imagen FROM vista_subCat;";
        ArrayList<SubCategoria> lista = new ArrayList<>();
        try {
            conexion = conn.getConnection();
            ps = conexion.prepareStatement(sql);
            result = ps.executeQuery();
            while (result.next()) {
                SubCategoria sbCate = new SubCategoria();
                sbCate.setId_sbcat(result.getInt(1));
                sbCate.setDescripcion(result.getString(2));
                sbCate.setImg_dir(result.getString(3));
                lista.add(sbCate);
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

    public int agregar(SubCategoria sbcate) {
        String sql = "INSERT INTO SUBCATEGORIA(id_sbcat, descripcion, imagen) "
                + "VALUES(?, ?, ?)";
        try {
            conexion = conn.getConnection();
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, sbcate.getId_sbcat());
            ps.setString(2, sbcate.getDescripcion());
            ps.setString(3, sbcate.getImg_dir());
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

    public SubCategoria listarId(int id) {

        SubCategoria sbcate = new SubCategoria();
        String sql = "SELECT id_cat, descripcion, imagen FROM vista_subCat WHERE id_sbcat=" + id;
        try {
            conexion = conn.getConnection();
            ps = conexion.prepareStatement(sql);
            result = ps.executeQuery();
            while (result.next()) {
                sbcate.setId_sbcat(Integer.parseInt(result.getString(1)));
                sbcate.setDescripcion(result.getString(2));
                sbcate.setImg_dir(result.getString(3));
            }
        } catch (Exception e) {

        }
        return sbcate;
    }

    public int actualizar(SubCategoria sbcat) {
        String sql = "UPDATE SUBCATEGORIA SET DESCRIPCION= ?, IMAGEN = ?  WHERE ID_SBCAT = ?";

        try {
            conexion = conn.getConnection();
            ps = conexion.prepareStatement(sql);
            ps.setString(1, sbcat.getDescripcion());
            ps.setString(2, sbcat.getImg_dir());
            ps.setInt(3, sbcat.getId_sbcat());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar recursos y manejar excepciones aquí
        }
        return respuesta;
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM SUBCATEGORIA WHERE ID_SBCAT =" + id;

        try {
            conexion = conn.getConnection();
            ps = conexion.prepareStatement(sql);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    
}
