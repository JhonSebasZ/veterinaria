
package modelo.consultas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Procedimiento;
import java.sql.*;

public class ProcedimientoSQL {

    Connection conn;
    PreparedStatement ps;

    public void addProcedimiento(Procedimiento p) {
        try {
            conn = new Conexion().getConexion();
            String sql = "INSERT INTO procedimiento (nombre_pro) VALUES ('" + p.getNombre() + "')";
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Operacion exitosa");
            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error");
        }
    }

    public ArrayList<Procedimiento> getProcedimientos() {
        ResultSet rs;

        ArrayList<Procedimiento> procedimientos = new ArrayList();

        try {
            conn = new Conexion().getConexion();
            String sql = "SELECT * FROM procedimiento";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Procedimiento p = new Procedimiento(rs.getInt("Codigo_pro"), rs.getString("nombre_pro"));
                procedimientos.add(p);
            }
            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar los procedimientos");
        }
        return procedimientos;
    }

    public void eliminarProcedimiento(int Codigo) {
        try {
            conn = new Conexion().getConexion();
            String sql = "DELETE FROM procedimiento WHERE codigo_pro=" + Codigo;
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Procedimiento eliminado exitosamente");
            conn.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error eliminar el procedimiento");
        }
    }
}
