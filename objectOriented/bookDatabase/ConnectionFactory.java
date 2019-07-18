package objectOriented.bookDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    //?autoReconnect=true&useSSL=false
    public Connection getConnection() {
        try {
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost/bookregistry?autoReconnect=true&useSSL=false", // link de conex�o
                    "root", // usuario
                    "root");// senha:univille
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
