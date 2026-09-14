package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Libro;

public class LibroDAO {

    // Obtiene todos los libros registrados en la base de datos
    public List<Libro> obtenerLibros() {

        List<Libro> libros = new ArrayList<>();

        String sql = "SELECT id, titulo, autor, disponible FROM libros";

        Connection conexion = ConexionBD.getInstancia().getConexion();

        try (PreparedStatement ps = conexion.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            // Recorre los resultados y crea un objeto Libro por cada registro
            while (rs.next()) {

                Libro libro = new Libro(
                    rs.getInt("id"),
                    rs.getString("titulo"),
                    rs.getString("autor"),
                    rs.getBoolean("disponible")
                );

                libros.add(libro);
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener libros: " + e.getMessage());
        }

        return libros;
    }

    // Agrega un nuevo libro a la base de datos
    public void agregarLibro(String titulo, String autor) {

        String sql = "INSERT INTO libros (titulo, autor) VALUES (?, ?)";

        Connection conexion = ConexionBD.getInstancia().getConexion();

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, titulo);
            ps.setString(2, autor);

            ps.executeUpdate();

            System.out.println("Libro agregado correctamente");

        } catch (SQLException e) {
            System.out.println("Error al agregar libro: " + e.getMessage());
        }
    }

    // Elimina un libro utilizando su ID
    public void eliminarLibro(int id) {

        String sql = "DELETE FROM libros WHERE id = ?";

        Connection conexion = ConexionBD.getInstancia().getConexion();

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setInt(1, id);

            ps.executeUpdate();

            System.out.println("Libro eliminado correctamente");

        } catch (SQLException e) {
            System.out.println("Error al eliminar libro: " + e.getMessage());
        }
    }

    // Actualiza el título y autor de un libro existente
    public void actualizarLibro(int id, String titulo, String autor) {

        String sql = "UPDATE libros SET titulo = ?, autor = ? WHERE id = ?";

        Connection conexion = ConexionBD.getInstancia().getConexion();

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, titulo);
            ps.setString(2, autor);
            ps.setInt(3, id);

            ps.executeUpdate();

            System.out.println("Libro actualizado correctamente");

        } catch (SQLException e) {
            System.out.println("Error al actualizar libro: " + e.getMessage());
        }
    }
}