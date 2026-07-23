package org.example.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * ==========================================================
 * Clase: ConexionBD
 * Proyecto: BibliotecaJavaMySQL
 * Autor: Giovanny A. Tapiero C. :. . /  .
 * Java: 21
 * Base de Datos: MySQL 8
 * ==========================================================
 *
 * Responsabilidades:
 * - Abrir conexión con MySQL.
 * - Retornar la conexión activa.
 * - Cerrar la conexión.
 *
 */

public class ConexionBD {


    // Datos de conexión
    private static final String URL =
            "jdbc:mysql://localhost:3306/biblioteca_db?useSSL=false&serverTimezone=UTC";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "Tapiero123";  // Cambiar por tu contraseña
    private static Connection conexion;


    /**
     * Constructor.
     */
    public ConexionBD() {
        conexion = null;
    }

    /**
     * Abre la conexión con la base de datos.
     *
     * @return Connection
     */
    public static Connection conectar() {

        try {
            if (conexion == null || conexion.isClosed()) {

                conexion = DriverManager.getConnection(
                        URL,
                        USUARIO,
                        PASSWORD
                );

                System.out.println("-----------------------------------------");
                System.out.println("Conexión establecida correctamente.");
                System.out.println("-----------------------------------------");
            }
        } catch (SQLException e) {

            System.out.println("-----------------------------------------");
            System.out.println("Error al conectar con MySQL.");
            System.out.println(e.getMessage());
            System.out.println("-----------------------------------------");
        }

        return conexion;
    }


    /**
     * Cierra la conexión.
     */
    public void cerrarConexion() {

        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
                System.out.println("-----------------------------------------");
                System.out.println("Conexión cerrada correctamente.");
                System.out.println("-----------------------------------------");
            }
        } catch (SQLException e) {
            System.out.println("-----------------------------------------");
            System.out.println("Error al cerrar la conexión.");
            System.out.println(e.getMessage());
            System.out.println("-----------------------------------------");
        }
    }
}