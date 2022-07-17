package municipaleCRUD.DAO.infrazione;

public interface InfrazioneDAO {
	
	boolean inserisciInfrazione(Infrazione infrazione);
	boolean eliminaInfrazine(int id);
	void stampaDatiInfrazioneAuto(String targa);
	
}
