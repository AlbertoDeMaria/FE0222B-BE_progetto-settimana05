package municipaleCRUD.DAO.infrazione;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import municipaleCRUD.connectionFactory;
import municipaleCRUD.DAO.auto.Auto;

public class InfrazioneDAOImpl implements InfrazioneDAO{

	@Override
	public boolean inserisciInfrazione(Infrazione infrazione) {
		// logback
		final Logger log = LoggerFactory.getLogger(connectionFactory.class);
		//connessione
		Connection conn = connectionFactory.getConnection();
		PreparedStatement ps = null;
		int i = 0;
		
		try {
			// query
			String q = "INSERT INTO infrazione (data, tipo, importo, id_auto) VALUES(?,?,?,?);";
			ps = conn.prepareStatement(q);
			ps.setString(1, infrazione.getData());
			ps.setString(2, infrazione.getTipo());
			ps.setFloat(3, infrazione.getImporto());
			ps.setInt(4, infrazione.getId_auto());
			i = ps.executeUpdate();
			
			log.info("Infrazione inserita con successo!");
		} catch(SQLException ecc) {
			ecc.printStackTrace();
			log.error("Errore durante l'inserimento");
		}
		
		// chiudo la connessione
		try {conn.close();} catch(Exception ex) {};
		
		return (i>0) ? true : false;	
	}
	
	@Override
	public boolean eliminaInfrazine(int id) {
		// logback
		final Logger log = LoggerFactory.getLogger(connectionFactory.class);
		// connessione
		Connection conn = connectionFactory.getConnection();
		Statement st = null;
		int i = 0;
		
		try {
			// query
			String q = "DELETE FROM infrazione where id = " + id;
			st = conn.createStatement();
			i = st.executeUpdate(q);
			
			log.info("Infrazione eliminata con successo!");
		} catch(SQLException ecc) {
			ecc.printStackTrace();
			log.error("Errore durante il Delete");
		}
		
		// chiudo la connessione
		try {conn.close();} catch(Exception ex) {};
		
		return (i>0) ? true : false;
	}


	@Override
	public void stampaDatiInfrazioneAuto(String targa) {
		// logback
		final Logger log = LoggerFactory.getLogger(connectionFactory.class);
		// connessione
		Connection conn = connectionFactory.getConnection();
		Statement st = null;
		ResultSet rs = null;
			
		Auto auto = null;
		Infrazione infrazione = null;
				
		try {
			st = conn.createStatement();
			// inserisco la Query
			rs = st.executeQuery("select * from infrazione as i inner join auto as a on a.id = i.id_auto where a.targa like '" + targa +"'");

			if(rs.next()) {
				auto = new Auto();
				auto.setTarga(rs.getString("targa"));
				auto.setMarca(rs.getString("marca"));
				auto.setModello(rs.getString("modello"));
						
				System.out.println(auto);
						
				infrazione = new Infrazione();
				
				infrazione.setData(rs.getString("data"));
				infrazione.setId_auto(rs.getInt("id_auto"));
				infrazione.setImporto(rs.getFloat("importo"));
				infrazione.setTipo(rs.getString("tipo"));
				
				System.out.println(infrazione);
				
			}
					
		} catch(SQLException ecc) {
			log.error("Errore durante l'estrazione");
			ecc.printStackTrace();
		}
				
		// chiudo il resultSet
		try {rs.close();} catch(Exception ex) {};
		// chiudo la connessione
		try {conn.close();} catch(Exception ex) {};
	}
	
	
}
