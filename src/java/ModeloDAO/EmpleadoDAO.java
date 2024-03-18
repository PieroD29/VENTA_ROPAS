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
        String sql = "SELECT * FROM VENDEDOR";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Empleado empleado = new Empleado();
                empleado.setID_VENDEDOR(rs.getInt("ID_VENDEDOR"));
                empleado.setNOMBRE_VENDEDOR(rs.getString("NOMBRE_VENDEDOR"));
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

    public Empleado validar(String user, String dni) {
        Empleado em = new Empleado();
        String sql = "SELECT * FROM VENDEDOR WHERE USUARIO=? AND DNI=?";
        try {

            con = cn.getConnection();
            ps = con.prepareStatement(sql);

            ps.setString(1, user);
            ps.setString(2, dni);
            rs = ps.executeQuery();

            while (rs.next()) {
                em.setID_VENDEDOR(rs.getInt("ID_VENDEDOR"));
                em.setUSUARIO(rs.getString("USUARIO"));
                em.setDNI(rs.getString("DNI"));
                em.setNOMBRE_VENDEDOR(rs.getString("NOMBRE_VENDEDOR"));
            }
        } catch (Exception e) {
        }
        return em;
    }
    
       public Empleado buscar(String dni) {
        Empleado em = new Empleado();
        String sql = "SELECT * FROM VENDEDOR WHERE DNI=" + dni;
        try {
            con = cn.getConnection();//
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {

                em.setID_VENDEDOR(rs.getInt(1));
                em.setDNI(rs.getString(2));
                em.setNOMBRE_VENDEDOR(rs.getString(3));
                em.setFECHA_CONTRATO(rs.getString(4));
                em.setSALARIO(rs.getDouble(5));
                em.setESTADO_VENDEDOR(rs.getString(6));
                em.setUSUARIO(rs.getString(7));
            }
        } catch (Exception e) {
        }
        return em;
    }

 
//----------------OPERACIONES CRUD----------------------     

    public List listar() {
        String sql = "SELECT * FROM VENDEDOR";
        ArrayList<Empleado> lista = new ArrayList<>();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Empleado em = new Empleado();
                em.setID_VENDEDOR(rs.getInt(1));
                em.setDNI(rs.getString(2));
                em.setNOMBRE_VENDEDOR(rs.getString(3));
                em.setFECHA_CONTRATO(rs.getString(4));
                em.setSALARIO(rs.getDouble(5));
                em.setESTADO_VENDEDOR(rs.getString(6));
                em.setUSUARIO(rs.getString(7));
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
        String sql = "INSERT INTO VENDEDOR(DNI, NOMBRE_VENDEDOR, FECHA_CONTRATO, SALARIO, ESTADO_VENDEDOR, USUARIO) "
                + "VALUES(?, ?, ?, ?, ?, ?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);

            ps.setString(1, Em.getDNI());
            ps.setString(2, Em.getNOMBRE_VENDEDOR());
            ps.setString(3, Em.getFECHA_CONTRATO());
            ps.setDouble(4, Em.getSALARIO());
            ps.setString(5, Em.getESTADO_VENDEDOR());
            ps.setString(6, Em.getUSUARIO());
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
        String sql = "SELECT * FROM VENDEDOR WHERE ID_VENDEDOR=" + id;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                vende.setDNI(rs.getString(2));
                vende.setNOMBRE_VENDEDOR(rs.getString(3));
                vende.setFECHA_CONTRATO(rs.getString(4));
                vende.setSALARIO(rs.getDouble(5));
                vende.setESTADO_VENDEDOR(rs.getString(6));
                vende.setUSUARIO(rs.getString(7));
            }
        } catch (Exception e) {

        }
        return vende;
    }

    public int actualizar(Empleado emple) {
        String sql = "UPDATE VENDEDOR SET  DNI = ?, NOMBRE_VENDEDOR = ?, FECHA_CONTRATO = ?, SALARIO = ?, ESTADO_VENDEDOR = ?, USUARIO = ? WHERE ID_VENDEDOR = ?";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, emple.getDNI());
            ps.setString(2, emple.getNOMBRE_VENDEDOR());
            ps.setString(3, emple.getFECHA_CONTRATO());
            ps.setDouble(4, emple.getSALARIO());
            ps.setString(5, emple.getESTADO_VENDEDOR());
            ps.setString(6, emple.getUSUARIO());
            ps.setInt(7, emple.getID_VENDEDOR());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar recursos y manejar excepciones aquí
        }
        return respuesta;
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM VENDEDOR WHERE ID_VENDEDOR =" + id;

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
