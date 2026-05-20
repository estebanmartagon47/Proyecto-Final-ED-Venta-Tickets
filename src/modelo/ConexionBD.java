package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase encargada de gestionar la conexión con la base de datos MySQL.
 */
public class ConexionBD {

    private static final String URL =
            "jdbc:mysql://localhost:3306/venta_tickets_parque?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

    private static final String USER = "ticketapp_user";
    private static final String PASSWORD = "Ticket2026*";

    /**
     * Devuelve una conexión activa con la base de datos.
     *
     * @return conexión con MySQL
     * @throws SQLException si ocurre un error de conexión
     */
    public static Connection conectar() throws SQLException {

        /*
         * Carga manual del driver JDBC de MySQL.
         * En versiones modernas no es obligatorio,
         * pero se incluye por buenas prácticas.
         */
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("No se encontró el driver JDBC de MySQL", e);
        }

        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}