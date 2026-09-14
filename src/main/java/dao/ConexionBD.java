package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    // Instancia única de la conexión (patrón Singleton)
    private static ConexionBD instancia;

    // Objeto que mantiene la conexión con la base de datos
    private Connection conexion;

    // Datos necesarios para conectarse a MySQL
    private static final String URL = "jdbc:mysql://localhost:3306/biblioteca_digital";
    private static final String USUARIO = "root";
    private static final String PASSWORD = System.getenv("Biblioteca_DB_PASSWORD");

    // Constructor privado para evitar crear varias instancias
    private ConexionBD() {
        try {
            // Carga el driver de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establece la conexión con la base de datos
            conexion = DriverManager.getConnection(URL, USUARIO, PASSWORD);

            System.out.println("Conexión exitosa a la base de datos");

        } catch (ClassNotFoundException e) {
            System.out.println("No se encontró el driver de MySQL: " + e.getMessage());

        } catch (SQLException e) {
            System.out.println("Error al conectar: " + e.getMessage());
        }
    }

    // Devuelve la única instancia de ConexionBD
    public static ConexionBD getInstancia() {
        if (instancia == null) {
            instancia = new ConexionBD();
        }

        return instancia;
    }

    // Permite utilizar la conexión desde las clases DAO
    public Connection getConexion() {
        return conexion;
    }
}