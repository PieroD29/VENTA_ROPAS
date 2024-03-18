package Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {

    private static String url = "jdbc:mysql://localhost:3306/proyectofinal?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
    private static String usuario = "root";
    private static String contraseña = "admin";
    // private static String driver = "com.mysql.cj.jdbc.Driver";

    public Conexion() {

    }

    static {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("CONECTADO A LA BASE DE DATOS");
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error en el driver: " + e);
        }
    }

    public Connection getConnection() {
        Connection con = null;

        try {
            con = DriverManager.getConnection(url, usuario, contraseña);//

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

       

}