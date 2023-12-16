import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseConnector {
    Connection connection;
    public Statement statement;

    DatabaseConnector() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/travelmanagementsystem", "postgres", "123");
            statement = connection.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}