package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Prestamo;

public class PrestamoDAO {

    // Obtener todos los préstamos
    public List<Prestamo> obtenerPrestamos() {

        List<Prestamo> prestamos = new ArrayList<>();

        String sql = "SELECT id, libro_id, usuario, fecha_prestamo, "
                   + "fecha_devolucion, devuelto FROM prestamos";

        Connection conexion = ConexionBD.getInstancia().getConexion();

        try (PreparedStatement ps = conexion.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Prestamo prestamo = new Prestamo(
                    rs.getInt("id"),
                    rs.getInt("libro_id"),
                    rs.getString("usuario"),
                    rs.getDate("fecha_prestamo"),
                    rs.getDate("fecha_devolucion"),
                    rs.getBoolean("devuelto")
                );

                prestamos.add(prestamo);
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener préstamos: " + e.getMessage());
        }

        return prestamos;
    }

    // Registrar un nuevo préstamo
    public void agregarPrestamo(int libroId, String usuario) {

        String sql = "INSERT INTO prestamos "
                   + "(libro_id, usuario, fecha_prestamo, devuelto) "
                   + "VALUES (?, ?, CURDATE(), false)";

        Connection conexion = ConexionBD.getInstancia().getConexion();

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setInt(1, libroId);
            ps.setString(2, usuario);

            ps.executeUpdate();

            System.out.println("Préstamo agregado correctamente");

        } catch (SQLException e) {
            System.out.println("Error al agregar préstamo: " + e.getMessage());
        }
    }

    // Registrar la devolución de un préstamo
    public void devolverPrestamo(int prestamoId) {

        String sql = "UPDATE prestamos "
                   + "SET devuelto = true, fecha_devolucion = CURDATE() "
                   + "WHERE id = ?";

        Connection conexion = ConexionBD.getInstancia().getConexion();

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setInt(1, prestamoId);

            ps.executeUpdate();

            System.out.println("Libro devuelto correctamente");

        } catch (SQLException e) {
            System.out.println("Error al devolver libro: " + e.getMessage());
        }
    }
}