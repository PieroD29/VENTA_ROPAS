package ModeloDAO;

import Modelo.Productos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Config.Conexion;

public class ProductosDAO {
    
    Conexion conn = new Conexion();
    Connection conexion;
    PreparedStatement ps;
    ResultSet result;
    int respuesta;
    
    public Productos buscar(int id){
        
        Productos pro = new Productos();
        String sql = "SELECT * FROM PRODUCTOS WHERE ID_PROD=" + id;
        try {
            conexion = conn.getConnection();
            ps = conexion.prepareStatement(sql);
            result = ps.executeQuery();
            while(result.next()) {
                pro.setID_PROD(result.getInt(1));
                pro.setNOMBRE_PROD(result.getString(2));
                pro.setDESC_PROD(result.getString(3));
                pro.setPREC_PROD(result.getDouble(4));
                pro.setMODE_PROD(result.getString(5));
                pro.setSTOCK_PROD(result.getInt(6));
                pro.setESTADO_PROD(result.getBoolean(7));
                pro.setID_CLASIFICACION(result.getInt(8));
                pro.setID_CATEGORIA(result.getInt(9));
                pro.setID_SUBCAT(result.getInt(10));
                pro.setID_MARCA(result.getInt(11));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return pro;
    }
    
    public int actualizarstock(int id, int stock) {
        String sql = "UPDATE PRODUCTOS SET STOCK=? WHERE ID_PROD=?";
        
        try{
            conexion = conn.getConnection();
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, stock);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return respuesta;
    }
    
    public List listar(){
        String sql = "SELECT * FROM PRODUCTOS";
        ArrayList<Productos> lista = new ArrayList<>();
        try{
            conexion = conn.getConnection();
            ps = conexion.prepareStatement(sql);
            result = ps.executeQuery();
            while(result.next()){
                Productos pro = new Productos();
                pro.setID_PROD(result.getInt(1));
                pro.setNOMBRE_PROD(result.getString(2));
                pro.setDESC_PROD(result.getString(3));
                pro.setPREC_PROD(result.getDouble(4));
                pro.setMODE_PROD(result.getString(5));
                pro.setSTOCK_PROD(result.getInt(6));
                pro.setESTADO_PROD(result.getBoolean(7));
                pro.setID_CLASIFICACION(result.getInt(8));
                pro.setID_CATEGORIA(result.getInt(9));
                pro.setID_SUBCAT(result.getInt(10));
                pro.setID_MARCA(result.getInt(11));
                lista.add(pro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    public int agregar(Productos pro){
        String sql = "INSERT INTO PRODUCTOS(ID_PROD, NOMBRE_PROD, DESCRIPCION, PRECIO, MODELO, STOCK, ESTADO, ID_CLAS, ID_CAT, ID_SBCAT, ID_MARCA) VALUES (?,?,?,?,?,?,?,?,?,?)";
        try {
            conexion = conn.getConnection();
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, pro.getID_PROD());
            ps.setString(2)
            ps.setString(3)
            ps.setDouble(4)
            ps.setString(5)
            ps.setInt(6)
            ps.setBoolean(7)
            ps.setInt(8)
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
