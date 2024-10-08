package personalblog.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static Connection connection = null;

    static
    {
        final String url = "jdbc:postgresql://localhost:5432/blog";
        final String dbuser = "postgres";
        final String dbpassword = "postgres";
        try {
            connection = DriverManager.getConnection(url, dbuser, dbpassword);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection()
    {
        return connection;
    }
}
