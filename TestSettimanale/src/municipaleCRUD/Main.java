package municipaleCRUD;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import municipaleCRUD.DAO.auto.Auto;
import municipaleCRUD.DAO.auto.autoDAOImpl;
import municipaleCRUD.DAO.infrazione.Infrazione;
import municipaleCRUD.DAO.infrazione.InfrazioneDAOImpl;

public class Main {
	
	public static void main(String[] args) {
		final Logger log = LoggerFactory.getLogger(Main.class);
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("---------------------------------------");
		System.out.println("1 - Inserisci Dati Auto\n2 - Inserisci Dati Infrazione\n3 - Visualizza tutte le Auto\n4 - Cerca auto\n5 - Visualizza dati Infrazioni e Auto da Targa\n6 - Elimina Infrazione");
		System.out.println("---------------------------------------");
		
		try {
			int scelta = scanner.nextInt();
			
			autoDAOImpl ad = new autoDAOImpl(); 
			InfrazioneDAOImpl id = new InfrazioneDAOImpl();
			
			ArrayList<Auto> listaAuto = new ArrayList<>();
			
			switch(scelta){
				case 1:
					Auto a = new Auto();
					
					System.out.println("Inserisci la targa: ");
					a.setTarga(scanner.next().toUpperCase());
					
					System.out.println("Inserisci la marca: ");
					a.setMarca(scanner.next());
					
					System.out.println("Inserisci il modello: ");
					a.setModello(scanner.next());
					
					ad.inserisciAuto(a);
					break;
				
				case 2:
					Infrazione i = new Infrazione();
					
					System.out.println("Inserisci la data");
					i.setData(scanner.next());
					
					System.out.println("Inserisci l'importo");
					i.setImporto(Float.parseFloat(scanner.next()));
					
					System.out.println("Inserisci l'id della macchina che ha commesso l'infrazione");
					i.setId_auto(scanner.nextInt());
					
					System.out.println("Inserisci il tipo di infrazione commessa");
					i.setTipo(scanner.next());
					
					id.inserisciInfrazione(i);
					break;
					
				case 3:
					listaAuto = ad.getAllAuto();
					for(Auto auto: listaAuto) {
						stampaAuto(auto);
					}
					break;
				
				case 4:
					System.out.println("Inserisci una targa: ");
					String targ = scanner.next();
					
					Auto a1 = new Auto();
					
					a1 = ad.ricercaAuto(targ);
					stampaAuto(a1);
					
					break;
				
				case 5:
					System.out.println("Inserisci una targa");
					String targa = scanner.next();
					id.stampaDatiInfrazioneAuto(targa);
					
					break;
				
				case 6:
					System.out.println("Inserisci l'id dell'infrazione che vuoi eliminare");
					int idInfrazione = scanner.nextInt();
					
					id.eliminaInfrazine(idInfrazione);	
					break;
				
				default:
					log.error("Errore, devi inserire un numero compreso tra 1 e 6!");
		}
		
		}catch(InputMismatchException e) {
			log.error("Errore");
		}
		
		scanner.close();
		
	}
	
	private static void stampaAuto(Auto auto) {
		if(auto != null) {
			System.out.println("- " + "Targa: " + auto.getTarga() + " Marca: " + auto.getMarca() + " Modello: " + auto.getModello());
		} else {
			System.out.println("Nessuna auto trovata!");
		}
	}

}
