package modelo.consultas;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Historial;
import modelo.Mascota;
import modelo.Procedimiento;

public class HistorialSQL {

    Connection conn;
    PreparedStatement ps;

    public void addHistial(Historial h) {
        try {
            conn = new Conexion().getConexion();

            String sql = "INSERT INTO historial (descripcion, codigo_pro, codigo_m) "
                    + " VALUES (?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, h.getDescripcion());
            ps.setInt(2, h.getProcedimiento().getCodigo());
            ps.setInt(3, h.getCodigoMascota());

            ps.executeUpdate();
            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error");
        }
    }

    public ArrayList<Historial> getHistorials(Mascota m) {
        ResultSet rs;
        ArrayList<Historial> hitoriales = new ArrayList();

        try {
            conn = new Conexion().getConexion();
            String sql = "SELECT * FROM historial JOIN procedimiento ON "
                    + "historial.codigo_pro = procedimiento.codigo_pro WHERE codigo_m=" + m.getCodigo();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Procedimiento p = new Procedimiento(rs.getInt("codigo_pro"), rs.getString("nombre_pro"));
                Historial h = new Historial(rs.getInt("codigo_h"),
                        rs.getString("descripcion"),
                        p,
                        rs.getInt("codigo_m"));

                hitoriales.add(h);
            }
            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error");
        }
        return hitoriales;
    }

    public void eliminarHistoria(Historial h) {
        try {
            conn = new Conexion().getConexion();
            String sql = "DELETE FROM historial WHERE codigo_h=" + h.getCodigo();
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error" + e);
        }
    }
}
