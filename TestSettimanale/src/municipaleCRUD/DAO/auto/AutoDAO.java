package municipaleCRUD.DAO.auto;

import java.util.ArrayList;

public interface AutoDAO {

	boolean inserisciAuto(Auto auto);
	ArrayList getAllAuto();
	Auto ricercaAuto(String targa);
	
}
