package ModeloDAO;

import Config.Conexion;
import Modelo.Empleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int respuesta;
    
    
     public List<Empleado> obtenerTodosLosEmpleados() {
        List<Empleado> vendedores = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Empleado empleado = new Empleado();
                empleado.setid_user(rs.getInt("id_user"));
                empleado.setusuario(rs.getString("usuario"));
                // Puedes agregar otras propiedades del proveedor si es necesario
                vendedores.add(empleado);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cierre de recursos aquí
            if (rs != null) {
                try {
                    rs.close();
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
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return vendedores;
    }

    public Empleado validar(String user, String contra) {
        Empleado em = new Empleado();
        String sql = "SELECT * FROM usuarios WHERE usuario=? AND contra=?";
        try {

            con = cn.getConnection();
            ps = con.prepareStatement(sql);

            ps.setString(1, user);
            ps.setString(2, contra);
            rs = ps.executeQuery();

            while (rs.next()) {
                em.setid_user(rs.getInt("id_user"));
                em.setusuario(rs.getString("usuario"));
                em.setcontra(rs.getString("contra"));
                em.setperfil(rs.getString("perfil"));
            }
        } catch (Exception e) {
        }
        return em;
    }
    
       public Empleado buscar(String perfil) {
        Empleado em = new Empleado();
        String sql = "SELECT * FROM usuarios WHERE perfil=" + perfil;
        try {
            con = cn.getConnection();//
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {

                em.setid_user(rs.getInt(1));
                em.setusuario(rs.getString(2));
                em.setcontra(rs.getString(3));
                em.setperfil(rs.getString(4));
                em.setnivel(rs.getString(5));
                em.setotros(rs.getString(6));
            }
        } catch (Exception e) {
        }
        return em;
    }

 
//----------------OPERACIONES CRUD----------------------     

    public List listar() {
        String sql = "SELECT * FROM usuarios";
        ArrayList<Empleado> lista = new ArrayList<>();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Empleado em = new Empleado();
                em.setid_user(rs.getInt(1));
                em.setusuario(rs.getString(2));
                em.setcontra(rs.getString(3));
                em.setperfil(rs.getString(4));
                em.setnivel(rs.getString(5));
                em.setotros(rs.getString(6));
          
                lista.add(em);
            }
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            if (rs != null) {
                try {
                    rs.close();
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
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return lista;
    }

    public int agregar(Empleado Em) {
        String sql = "INSERT INTO usuarios(usuario, contra, perfil, nivel, otros) "
                + "VALUES(?, ?, ?, ?, ?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);

            ps.setString(1, Em.getusuario());
            ps.setString(2, Em.getcontra());
            ps.setString(3, Em.getperfil());
            ps.setString(4, Em.getnivel());
            ps.setString(5, Em.getotros());
            respuesta = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            // Cerrar recursos y manejar excepciones aquí
            try {
                if (rs != null) {
                    rs.close();
                }

                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return respuesta;
    }

    public Empleado listarId(int id) {

        Empleado vende = new Empleado();
        String sql = "SELECT * FROM usuarios WHERE id_user=" + id;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                vende.setusuario(rs.getString(2));
                vende.setcontra(rs.getString(3));
                vende.setperfil(rs.getString(4));
                vende.setnivel(rs.getString(5));
                vende.setotros(rs.getString(6));
            }
        } catch (Exception e) {

        }
        return vende;
    }

    public int actualizar(Empleado emple) {
        String sql = "UPDATE usuarios SET  usuario = ?, contra = ?, perfil = ?, nivel = ?, otros = ? WHERE id_user = ?";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, emple.getusuario());
            ps.setString(2, emple.getcontra());
            ps.setString(3, emple.getperfil());
            ps.setString(4, emple.getnivel());
            ps.setString(5, emple.getotros());
            ps.setInt(6, emple.getid_user());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar recursos y manejar excepciones aquí
        }
        return respuesta;
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM usuarios WHERE id_user =" + id;

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
