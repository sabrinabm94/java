package objectOriented.MVC.taskApp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    //?autoReconnect=true&useSSL=false
    public Connection getConnection() {
        try {
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost/database?autoReconnect=true&useSSL=false", // link de conexão
                    "root", // usuario
                    "root");// senha
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
