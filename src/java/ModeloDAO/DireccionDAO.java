package ModeloDAO;

import Config.Conexion;
import Modelo.Direccion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DireccionDAO {

    Conexion conn = new Conexion();
    Connection conexion;
    PreparedStatement ps;
    ResultSet result;

    int respuesta;

    public List<Direccion> obtenerTodasLasDirecciones() {
        List<Direccion> direcciones = new ArrayList<>();
        String sql = "SELECT * FROM DIRECCION";

        try {
            conexion = conn.getConnection();
            ps = conexion.prepareStatement(sql);
            result = ps.executeQuery();

            while (result.next()) {
                Direccion direccion = new Direccion();
                direccion.setID_DIRECCION(result.getInt("ID_DIRECCION"));
                direccion.setCALLE(result.getString("CALLE"));
                // Puedes agregar otras propiedades del proveedor si es necesario
                direcciones.add(direccion);
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

        return direcciones;
    }

    public List listar() {
        String sql = "SELECT * FROM DIRECCION";
        ArrayList<Direccion> lista = new ArrayList<>();
        try {
            conexion = conn.getConnection();//
            ps = conexion.prepareStatement(sql);
            result = ps.executeQuery();
            while (result.next()) {
                Direccion dir = new Direccion();
                dir.setID_DIRECCION(result.getInt(1));
                dir.setCALLE(result.getString(2));
                dir.setDISTRITO(result.getString(3));
                dir.setCIUDAD(result.getString(4));
                lista.add(dir);
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

    public int agregar(Direccion dir) {
        String sql = "INSERT INTO DIRECCION(CALLE, DISTRITO, CIUDAD) "
                + "VALUES(?, ?, ?)";
        try {
            conexion = conn.getConnection();
            ps = conexion.prepareStatement(sql);
            ps.setString(1, dir.getCALLE());
            ps.setString(2, dir.getDISTRITO());
            ps.setString(3, dir.getCIUDAD());
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

    public Direccion listarId(int id) {

        Direccion dir = new Direccion();
        String sql = "SELECT * FROM DIRECCION WHERE ID_DIRECCION=" + id;
        try {
            conexion = conn.getConnection();
            ps = conexion.prepareStatement(sql);
            result = ps.executeQuery();
            while (result.next()) {
                dir.setCALLE(result.getString(2));
                dir.setDISTRITO(result.getString(3));
                dir.setCIUDAD(result.getString(4));
            }
        } catch (Exception e) {

        }
        return dir;
    }

    public int actualizar(Direccion dire) {
        String sql = "UPDATE DIRECCION SET CALLE = ?, DISTRITO= ?, CIUDAD = ?  WHERE ID_DIRECCION = ?";

        try {
            conexion = conn.getConnection();
            ps = conexion.prepareStatement(sql);
            ps.setString(1, dire.getCALLE());
            ps.setString(2, dire.getDISTRITO());
            ps.setString(3, dire.getCIUDAD());
            ps.setInt(4, dire.getID_DIRECCION());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar recursos y manejar excepciones aquí
        }
        return respuesta;
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM DIRECCION WHERE ID_DIRECCION =" + id;

        try {
            conexion = conn.getConnection();
            ps = conexion.prepareStatement(sql);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
