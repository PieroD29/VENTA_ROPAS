package ModeloDAO;

import Config.Conexion;
import Modelo.Usuarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuariosDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int respuesta;
    
    
     public List<Usuarios> obtenerTodosLosUsuarios() {
        List<Usuarios> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Usuarios usuario = new Usuarios();
                usuario.setid_user(rs.getInt("id_user"));
                usuario.setusuario(rs.getString("usuario"));
                // Puedes agregar otras propiedades del proveedor si es necesario
                usuarios.add(usuario);
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

        return usuarios;
    }

    public Usuarios validar(String user, String contra) {
        Usuarios us = new Usuarios();
        String sql = "SELECT * FROM usuarios WHERE usuario=? AND contra=?";
        try {

            con = cn.getConnection();
            ps = con.prepareStatement(sql);

            ps.setString(1, user);
            ps.setString(2, contra);
            rs = ps.executeQuery();

            while (rs.next()) {
                us.setid_user(rs.getInt("id_user"));
                us.setusuario(rs.getString("usuario"));
                us.setcontra(rs.getString("contra"));
                us.setperfil(rs.getString("perfil"));
            }
        } catch (Exception e) {
        }
        return us;
    }
    
       public Usuarios buscar(String usuario) {
        Usuarios us = new Usuarios();
        String sql = "SELECT * FROM usuarios WHERE usuario=" + usuario;
        try {
            con = cn.getConnection();//
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {

                us.setid_user(rs.getInt(1));
                us.setusuario(rs.getString(2));
                us.setcontra(rs.getString(3));
                us.setperfil(rs.getString(4));
                us.setnivel(rs.getString(5));
                us.setotros(rs.getString(6));
            }
        } catch (Exception e) {
        }
        return us;
    }

 
//----------------OPERACIONES CRUD----------------------     

    public List listar() {
        String sql = "SELECT * FROM usuarios";
        ArrayList<Usuarios> lista = new ArrayList<>();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Usuarios us = new Usuarios();
                us.setid_user(rs.getInt(1));
                us.setusuario(rs.getString(2));
                us.setcontra(rs.getString(3));
                us.setperfil(rs.getString(4));
                us.setnivel(rs.getString(5));
                us.setotros(rs.getString(6));
          
                lista.add(us);
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

    public int agregar(Usuarios Us) {
        String sql = "INSERT INTO usuarios(usuario, contra, perfil, nivel, otros) "
                + "VALUES(?, ?, ?, ?, ?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);

            ps.setString(1, Us.getusuario());
            ps.setString(2, Us.getcontra());
            ps.setString(3, Us.getperfil());
            ps.setString(4, Us.getnivel());
            ps.setString(5, Us.getotros());
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

    public Usuarios listarId(int id) {

        Usuarios usua = new Usuarios();
        String sql = "SELECT * FROM usuarios WHERE id_user=" + id;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                usua.setusuario(rs.getString(2));
                usua.setcontra(rs.getString(3));
                usua.setperfil(rs.getString(4));
                usua.setnivel(rs.getString(5));
                usua.setotros(rs.getString(6));
            }
        } catch (Exception e) {

        }
        return usua;
    }

    public int actualizar(Usuarios usu) {
        String sql = "UPDATE usuarios SET  usuario = ?, contra = ?, perfil = ?, nivel = ?, otros = ? WHERE id_user = ?";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, usu.getusuario());
            ps.setString(2, usu.getcontra());
            ps.setString(3, usu.getperfil());
            ps.setString(4, usu.getnivel());
            ps.setString(5, usu.getotros());
            ps.setInt(6, usu.getid_user());
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
