package ModeloDAO;

import Modelo.Marca;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Config.Conexion;

public class MarcaDAO {

    Conexion conn = new Conexion();
    Connection conexion;
    PreparedStatement ps;
    ResultSet result;
    int respuesta;
    
    public Marca buscar(int id){
        
        Marca mar = new Marca();
        String sql = "SELECT * FROM MARCA WHERE ID_MARCA =" + id;
        try {
            conexion = conn.getConnection();
            ps = conexion.prepareStatement(sql);
            result = ps.executeQuery();
            while(result.next()) {
                mar.setID_MARCA(result.getInt(1));
                mar.setNOMBRE_MARCA(result.getString(2));
                mar.setESTADO_MARCA(result.getBoolean(3));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return mar;
    }
    
    public int actualizarnombre(int id, String nombre, boolean estado) {
        String sql = "UPDATE MARCA SET NOMBRE = ?, ESTADO = ? WHERE ID_MARCA = ?";
        
        try{
            conexion = conn.getConnection();
            ps = conexion.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setBoolean(2,estado);
            ps.setInt(3, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return respuesta;
    }
    
    public List listar(){
        String sql = "SELECT * FROM MARCA";
        ArrayList<Marca> lista = new ArrayList<>();
        try{
            conexion = conn.getConnection();
            ps = conexion.prepareStatement(sql);
            result = ps.executeQuery();
            while(result.next()){
                Marca mar = new Marca();
                mar.setID_MARCA(result.getInt(1));
                mar.setNOMBRE_MARCA(result.getString(2));
                mar.setESTADO_MARCA(result.getBoolean(3));
                lista.add(mar);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    public int agregar(Marca mar){
        String sql = "INSERT INTO MARCA(ID_MARCA, NOMBRE, ESTADO) VALUES(?,?,?)";
        try {
            conexion = conn.getConnection();
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, mar.getID_MARCA());
            ps.setString(2, mar.getNOMBRE_MARCA());
            ps.setBoolean(3, mar.isESTADO_MARCA());
            respuesta = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return respuesta;
    }
    
    public void eliminar(int id) {
        String sql = "DELETE FROM MARCA WHERE ID_MARCA = " + id;

        try {
            conexion = conn.getConnection();
            ps = conexion.prepareStatement(sql);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    
    public void activar(int id) {
        String sql = "UPDATE MARCA SET ESTADO = 1 WHERE ID_MARCA = " + id;

        try {
            conexion = conn.getConnection();
            ps = conexion.prepareStatement(sql);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    
    public void desactivar(int id) {
        String sql = "UPDATE MARCA SET ESTADO = 0 WHERE ID_MARCA = " + id;

        try {
            conexion = conn.getConnection();
            ps = conexion.prepareStatement(sql);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
