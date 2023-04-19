package avlyakulov.timur.practise.db_mysql.persons;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class PersonsDBUtil {
    public static Connection getConnection() {
        Connection connection = null;
        Properties properties = new Properties();
        try (BufferedReader fileReader = new BufferedReader(new FileReader("src/main/resources/mysql.properties"))) {
            properties.load(fileReader);
            String dbURL = properties.getProperty("db.host");
            String dbUsername = properties.getProperty("db.name");
            String dbPassword = properties.getProperty("db.pass");
            connection = DriverManager.getConnection(dbURL, dbUsername, dbPassword);

        } catch (SQLException | FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}