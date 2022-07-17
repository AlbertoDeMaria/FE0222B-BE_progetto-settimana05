package municipaleCRUD.DAO.auto;

import java.sql.*;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import municipaleCRUD.connectionFactory;

public class autoDAOImpl implements AutoDAO{
	
	@Override
	// metodo per inserire le auto
	public boolean inserisciAuto(Auto auto) {
		// logback
		final Logger log = LoggerFactory.getLogger(connectionFactory.class);
		// connessione
		Connection conn = connectionFactory.getConnection();
		PreparedStatement ps = null;
		int i = 0;
		
		try {
			// inserisco la Query
			String q = "INSERT INTO auto (targa, marca, modello) VALUES(?,?,?);";
			ps = conn.prepareStatement(q);
			ps.setString(1, auto.getTarga());
			ps.setString(2, auto.getMarca());
			ps.setString(3, auto.getModello());
			i = ps.executeUpdate();
			
			log.info("Auto inserita con successo!");
		} catch(SQLException ecc) {
			ecc.printStackTrace();
			log.error("Errore durante l'inserimento");
		}
		
		// chiudo la connessione
		try {conn.close();} catch(Exception ex) {};
		
		return (i>0) ? true : false;	
	}
	
	@Override
	public ArrayList<Auto> getAllAuto() {
		// logback
		final Logger log = LoggerFactory.getLogger(connectionFactory.class);
		// connessione
		Connection conn = connectionFactory.getConnection();
		Statement st = null;
		ResultSet rs = null;
		ArrayList<Auto> listaAuto= null;
		
		try {
			st = conn.createStatement();
			// inserisco la Query
			rs = st.executeQuery("SELECT * FROM auto");
			listaAuto = new ArrayList<Auto>();
			
			while(rs.next()) {
				Auto auto = new Auto();
				auto.setTarga(rs.getString("targa"));
				auto.setMarca(rs.getString("marca"));
				auto.setModello(rs.getString("modello"));				
				
				listaAuto.add(auto);
			}
		}catch(SQLException ecc) {
			log.error("Errore");
			ecc.printStackTrace();
		}
		
		// chiudo il resultSet
		try {rs.close();} catch(Exception ex) {};
		// chiudo la connessione
		try {conn.close();} catch(Exception ex) {};
	
		// ritorno l'arrayList
		return listaAuto;
	}
	
	@Override
	public Auto ricercaAuto(String targa) {
		// logback
		final Logger log = LoggerFactory.getLogger(connectionFactory.class);
		// connessione
		Connection conn = connectionFactory.getConnection();
		Statement st = null;
		ResultSet rs = null;
		
		Auto auto = null;
		
		try {
			st = conn.createStatement();
			// inserisco la Query
			rs = st.executeQuery("SELECT * FROM auto WHERE targa like '" + targa.toUpperCase() + "'");

			if(rs.next()) {
				auto = new Auto();
				auto.setTarga(rs.getString("targa"));
				auto.setMarca(rs.getString("marca"));
				auto.setModello(rs.getString("modello"));
				
				return auto;
			}
			
		} catch(SQLException ecc) {
			log.error("Errore durante l'estrazione");
			ecc.printStackTrace();
		}
		
		// chiudo il resultSet
		try {rs.close();} catch(Exception ex) {};
		// chiudo la connessione
		try {conn.close();} catch(Exception ex) {};
		
		// ritorno l'auto
		return auto;
	}
}
