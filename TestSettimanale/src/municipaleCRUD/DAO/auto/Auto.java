package municipaleCRUD.DAO.auto;

public class Auto {
	
	private String targa;
	private String marca;
	private String modello;
	
	// Constructors
	public Auto() {}
	
	public Auto(String targa, String marca, String modello) {
		this.targa = targa;
	 	this.marca = marca;
		this.modello = modello;
	}
	
	// Getters e Setters
	public String getTarga() {
		return targa;
	}

	public void setTarga(String targa) {
		this.targa = targa.toUpperCase();
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	
	//toString()
	@Override
	public String toString() {
		return "Auto [targa=" + targa + ", marca=" + marca + ", modello=" + modello + "]";
	}
	
}
