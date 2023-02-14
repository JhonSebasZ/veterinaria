package modelo.consultas;

import modelo.Mascota;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Raza;

public class MascotaSQL {

    Connection conn;
    PreparedStatement ps;

    public void agregarMascota(Mascota mascota) {

        try {
            conn = new Conexion().getConexion();
            String sql = "INSERT INTO mascota (nombre_responsable, nombre_mascota, codigo_raza, numero_contacto)"
                    + "VALUES (?,?,?,?)";

            ps = conn.prepareStatement(sql);
            ps.setString(1, mascota.getNombreResponsable());
            ps.setString(2, mascota.getNombreMascota());
            ps.setInt(3, mascota.getRaza().getCodigoRaza());
            ps.setString(4, mascota.getNumeroContacto());

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Operacion exitosa");
            conn.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de consulta"+e);
        }
    }

    public ArrayList<Mascota> getMascotas() {

        ResultSet rs;
        ArrayList<Mascota> mascotas = new ArrayList();
        
        try {
            conn = new Conexion().getConexion();
            String sql = "SELECT * FROM mascota JOIN raza ON mascota.codigo_raza = raza.codigo_r";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Raza r = new Raza();
                r.setNombreRaza(rs.getNString("nombre_raza"));

                Mascota m = new Mascota(rs.getString("nombre_responsable"),
                        rs.getString("nombre_mascota"), r, rs.getString("numero_contacto"));
                m.setCodigo(rs.getInt("codigo_m"));

                mascotas.add(m);
            }
            conn.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar las mascotas");
        }

        return mascotas;
    }

    public Mascota getMascota(int codigo) {
        ResultSet rs;
        Mascota m = new Mascota();
        
        try {
            conn = new Conexion().getConexion();
            String sql = "SELECT * FROM mascota JOIN raza WHERE codigo_m=" + codigo;
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Raza r = new Raza();
                r.setCodigoRaza(rs.getInt("codigo_raza"));

                r.setNombreRaza(rs.getString("nombre_raza"));

                m = new Mascota(rs.getString("nombre_responsable"),
                        rs.getString("nombre_mascota"), r, rs.getString("numero_contacto"));
                m.setCodigo(rs.getInt("codigo_m"));
            }
            conn.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error, intente de nuevo" + e);
        }
        return m;
    }

    public void actualizarMascota(Mascota m) {
        try {
            conn = new Conexion().getConexion();
            String sql = "UPDATE mascota SET nombre_responsable='" + m.getNombreResponsable()
                    + "', nombre_mascota='" + m.getNombreMascota() + "', codigo_raza='" + m.getRaza().getCodigoRaza()
                    + "', numero_contacto='" + m.getNumeroContacto() + "' WHERE codigo_m=" + m.getCodigo();

            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            conn.close();
            JOptionPane.showMessageDialog(null, "Actualizacion exitosa");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error, intente de nuevo" + e);
        }
    }

    public void elimirMascota(int codigo) {
        try {
            conn = new Conexion().getConexion();
            String sql = "DELETE FROM mascota WHERE codigo_m=" + codigo;
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            conn.close();
            JOptionPane.showMessageDialog(null, "Eliminación exitosa");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error, intente de nuevo" + e);
        }
    }
}
