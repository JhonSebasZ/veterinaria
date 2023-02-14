package modelo.consultas;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Raza;

public class RazaSQL {

    Connection conn;

    public ArrayList<Raza> getRazas() {

        PreparedStatement ps;
        ResultSet rs;

        ArrayList<Raza> razas = new ArrayList();

        try {
            conn = new Conexion().getConexion();
            String sql = "SELECT * FROM raza";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Raza raza = new Raza();
                raza.setCodigoRaza(Integer.parseInt(rs.getString("codigo_r")));
                raza.setNombreRaza(rs.getString("nombre_raza"));
                razas.add(raza);
            }
            conn.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de consulta" + "\n " + e);
        }
        return razas;
    }
}
