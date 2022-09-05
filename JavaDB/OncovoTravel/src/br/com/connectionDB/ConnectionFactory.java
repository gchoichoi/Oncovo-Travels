package br.com.connectionDB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory implements AutoCloseable {

	private static String CONNECTION_URL = "jdbc:sqlserver://localhost:1433;databaseName=ONCOVOTRAVEL;user=sa;password=123456;encrypt=true;trustServerCertificate=true";
    private static Connection connection;
	public static Connection createConnection() throws SQLException {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver not found: " + e.getMessage());
			e.printStackTrace();
		}

		connection = DriverManager.getConnection(CONNECTION_URL);

		return connection;
  
	}

	@Override
	public void close() throws Exception {
		connection.close();
		System.out.println("Fechando conexão");
	}
}