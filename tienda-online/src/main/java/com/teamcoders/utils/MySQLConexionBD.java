package com.teamcoders.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Esta clase ya no se utiliza. Sustituida por JPA (JpaUtil).

/**
 * Clase de utilidad que gestiona la conexión a la base de datos MySQL.
 */
public class MySQLConexionBD {

    // Cambia los valores si tu base de datos usa otras credenciales
    private static final String URL = "jdbc:mysql://localhost:3306/TeamCodersBD";
    private static final String USER = "root";
    private static final String PASS = "root";

    /**
     * Establece y retorna una conexión con la base de datos MySQL.
     *
     * @return Objeto Connection activo.
     * @throws SQLException si ocurre un error al conectar.
     */
    public static Connection getConnection() throws SQLException {
        try {
            // Carga el driver JDBC de MySQL si aún no está cargado
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("No se encontró el driver JDBC para MySQL", e);
        }
        // Retorna la conexión activa
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
