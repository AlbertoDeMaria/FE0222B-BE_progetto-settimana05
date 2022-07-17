package municipaleCRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class connectionFactory {

	public static final String URL = "jdbc:postgresql://localhost:5432/municipale";
	public static final String USERNAME = "postgres";
	public static final String PASSWORD = "admin";
	public static final Logger log = LoggerFactory.getLogger(connectionFactory.class);
	
	public static Connection getConnection() {
		
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			log.info("connessione effettuata correttamente");
		} catch (SQLException ex) {
			log.error("connessione fallita");
			ex.printStackTrace();
		}
		
		return conn;
		
	}	
}