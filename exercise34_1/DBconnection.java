/*Program name: DBconnection.java
* Author: Laura Amorim
* Date last updated: 02/23/2026
* Purpose: estabilish database connection using xampp
*/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {

    private static final String URL =
        "jdbc:mysql://localhost:3306/info?useSSL=false&allowPublicKeyRetrieval=true";

    private static final String USER = "root";
    private static final String PASSWORD = ""; // XAMPP default

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

