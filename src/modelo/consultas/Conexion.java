
package modelo.consultas;

import java.sql.*;
import javax.swing.JOptionPane;


public class Conexion {
    public static final String url = "jdbc:mysql://localhost:3306/veterinaria";
    public static final String usuario = "root";
    public static final String pass = "admin";
    
    public Connection getConexion(){
        Connection conexion = null;
   
        try {
            conexion = (Connection)DriverManager.getConnection(url, usuario, pass);                    
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error");
        }
        return conexion;
    }
    
}
