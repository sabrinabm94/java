package br.univille.app.tarefas.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {
	
	//?autoReconnect=true&useSSL=false
	public Connection getConnection() {
        try {
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost/bancoSabrina?autoReconnect=true&useSSL=false", // link de conexão
                    "root", // usuario
                    "univille");// senha
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


	
}
