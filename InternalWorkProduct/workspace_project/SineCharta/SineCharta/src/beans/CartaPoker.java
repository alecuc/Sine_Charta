package beans;

public class CartaPoker {
	
	
	private int valore;
	private String descrizione;
	
	
	public CartaPoker(String descri , int value) {
		
		this.valore = value;
		this.descrizione = descri;
		
	}
	
	//getter degli attributi
	public String getDescrizione() {
		return descrizione;
	}
	
	public int getValore() {
		return valore;
	}
	
	//setter degli attributi
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	public void setValore(int dalore) {
		this.valore = dalore;
	}

}
