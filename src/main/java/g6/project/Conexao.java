package g6.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static String url = "jdbc:mysql://localhost:3306/cliente";
    private static String user = "root";
    private static String password = "@Patrizi2004";
    private static Connection connection = null;

    private Conexao() {}

    public static Connection conectar() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(url, user, password);
        }
        return connection;
    }

    public static void desconectar() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
        return;
    }
}