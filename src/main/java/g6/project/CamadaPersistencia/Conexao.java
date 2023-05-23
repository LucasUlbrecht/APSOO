package g6.project.CamadaPersistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static String url="jdbc:mysql://localhost:3306/cliente";
    private static String user="root";
    private static String password="@Patrizi2004";
    private Conexao(){}
    public static Connection getConnection()throws SQLException{
        Connection connection=null;
        connection = DriverManager.getConnection(url, user, password);

        return connection;
    }
}
