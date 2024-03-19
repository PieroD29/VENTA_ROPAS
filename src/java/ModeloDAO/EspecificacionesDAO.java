package ModeloDAO;

import Config.Conexion;
import Modelo.Especificaciones;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EspecificacionesDAO {

    Conexion conn = new Conexion();
    Connection conexion;
    PreparedStatement ps;
    ResultSet result;

    int respuesta;


    public List listar() {
        String sql = "SELECT id_esp, titulo, descripcion, id_prod FROM especificaciones";
        ArrayList<Especificaciones> lista = new ArrayList<>();
        try {
            conexion = conn.getConnection();//
            ps = conexion.prepareStatement(sql);
            result = ps.executeQuery();
            while (result.next()) {
                Especificaciones espe = new Especificaciones();
                espe.setid_esp(result.getInt(1));
                espe.settitulo(result.getString(2));
                espe.setdescripcion(result.getString(3));
                espe.setid_prod(result.getInt(4));
                lista.add(espe);
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

    public int agregar(Especificaciones espe) {
        String sql = "INSERT INTO especificaciones(titulo, descripcion, id_prod) "
                + "VALUES(?, ?, ?)";
        try {
            conexion = conn.getConnection();
            ps = conexion.prepareStatement(sql);
            ps.setString(1, espe.gettitulo());
            ps.setString(2, espe.getdescripcion());
            ps.setInt(3, espe.getid_prod());
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

    public Especificaciones listarId(int id) {

        Especificaciones espe = new Especificaciones();
        String sql = "SELECT * FROM especificaciones WHERE id_esp=" + id;
        try {
            conexion = conn.getConnection();
            ps = conexion.prepareStatement(sql);
            result = ps.executeQuery();
            while (result.next()) {
                espe.settitulo(result.getString(2));
                espe.setdescripcion(result.getString(3));
                espe.setid_prod(result.getInt(4));
            }
        } catch (Exception e) {

        }
        return espe;
    }

    public int actualizar(Especificaciones esp) {
        String sql = "UPDATE especificaciones SET titulo = ?, descripcion = ?, id_prod = ?  WHERE id_esp = ?";

        try {
            conexion = conn.getConnection();
            ps = conexion.prepareStatement(sql);
            ps.setString(1, esp.gettitulo());
            ps.setString(2, esp.getdescripcion());
            ps.setInt(3, esp.getid_prod());
            ps.setInt(4, esp.getid_esp());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar recursos y manejar excepciones aquí
        }
        return respuesta;
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM especificaciones WHERE id_esp =" + id;

        try {
            conexion = conn.getConnection();
            ps = conexion.prepareStatement(sql);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
