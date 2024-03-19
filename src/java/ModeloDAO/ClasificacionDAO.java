package ModeloDAO;

import Config.Conexion;
import Modelo.Clasificacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class ClasificacionDAO {
    Conexion conn = new Conexion();
    Connection conexion;
    PreparedStatement ps;
    ResultSet result;

    int respuesta;

    public List<Clasificacion> obtenerTodasLasClasificaciones() {
        List<Clasificacion> clasificaciones = new ArrayList<>();
        String sql = "SELECT * FROM vista_clasificacion;";

        try {
            conexion = conn.getConnection();
            ps = conexion.prepareStatement(sql);
            result = ps.executeQuery();

            while (result.next()) {
                Clasificacion clasificacion = new Clasificacion();
                clasificacion.setId_clas(result.getInt("id_clas"));
                clasificacion.setDescripcion(result.getString("descripcion"));
                clasificacion.setImg_dir(result.getString("imagen"));
                clasificaciones.add(clasificacion);
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

        return clasificaciones;
    }

    public List listar() {
        String sql = "SELECT id_cat, descripcion, imagen FROM vista_clasificacion;";
        ArrayList<Clasificacion> lista = new ArrayList<>();
        try {
            conexion = conn.getConnection();
            ps = conexion.prepareStatement(sql);
            result = ps.executeQuery();
            while (result.next()) {
                Clasificacion clasi = new Clasificacion();
                clasi.setId_clas(result.getInt(1));
                clasi.setDescripcion(result.getString(2));
                clasi.setImg_dir(result.getString(3));
                lista.add(clasi);
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

    public int agregar(Clasificacion clasi) {
        String sql = "INSERT INTO CLASIFICACION(id_clas, descripcion, imagen) "
                + "VALUES(?, ?, ?)";
        try {
            conexion = conn.getConnection();
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, clasi.getId_clas());
            ps.setString(2, clasi.getDescripcion());
            ps.setString(3, clasi.getImg_dir());
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

    public Clasificacion listarId(int id) {

        Clasificacion clasi = new Clasificacion();
        String sql = "SELECT id_clas, descripcion, imagen FROM vista_clasificacion WHERE id_clas=" + id;
        try {
            conexion = conn.getConnection();
            ps = conexion.prepareStatement(sql);
            result = ps.executeQuery();
            while (result.next()) {
                clasi.setId_clas(Integer.parseInt(result.getString(1)));
                clasi.setDescripcion(result.getString(2));
                clasi.setImg_dir(result.getString(3));
            }
        } catch (Exception e) {

        }
        return clasi;
    }

    public int actualizar(Clasificacion clasi) {
        String sql = "UPDATE CLASIFICACION SET DESCRIPCION= ?, IMAGEN = ?  WHERE ID_CLAS = ?";

        try {
            conexion = conn.getConnection();
            ps = conexion.prepareStatement(sql);
            ps.setString(1, clasi.getDescripcion());
            ps.setString(2, clasi.getImg_dir());
            ps.setInt(3, clasi.getId_clas());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar recursos y manejar excepciones aquí
        }
        return respuesta;
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM CLASIFICACION WHERE ID_CLAS =" + id;

        try {
            conexion = conn.getConnection();
            ps = conexion.prepareStatement(sql);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
