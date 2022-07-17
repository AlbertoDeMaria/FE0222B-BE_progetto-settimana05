package municipaleCRUD.DAO.infrazione;

public class Infrazione {

	private int id;
	private String data;
	private String tipo;
	private float importo;
	private int id_auto;
	
	// Constructors
	public Infrazione() {};
	
	public Infrazione(int id, String data, String tipo, float importo, int id_auto) {
		this.id = id;
		this.data = data;
		this.tipo = tipo;
		this.importo = importo;
		this.id_auto = id_auto;
	}
	
	public Infrazione(String data, String tipo, float importo, int id_auto) {
		this.data = data;
		this.tipo = tipo;
		this.importo = importo;
		this.id_auto = id_auto;
	}

	// Getters e Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public float getImporto() {
		return importo;
	}

	public void setImporto(float importo) {
		this.importo = importo;
	}
	
	public int getId_auto() {
		return id_auto;
	}

	public void setId_auto(int id_auto) {
		this.id_auto = id_auto;
	}

	//toString()
	@Override
	public String toString() {
		return "Infrazione [id=" + id + ", data=" + data + ", tipo=" + tipo + ", importo=" + importo + ", id_auto="
				+ id_auto + "]";
	}
	
}
