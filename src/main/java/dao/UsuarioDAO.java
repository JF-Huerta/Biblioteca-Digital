package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

    // Valida si el usuario y la contraseña existen en la base de datos
    public boolean validarUsuario(String usuario, String password) {

        String sql = "SELECT * FROM usuarios WHERE usuario = ? AND password = ?";

        Connection conexion = ConexionBD.getInstancia().getConexion();

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, usuario);
            ps.setString(2, password);

            // Si existe un registro con esos datos, el usuario es válido
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }

        } catch (SQLException e) {

            System.out.println("Error al validar usuario: " + e.getMessage());

            return false;
        }
    }
}