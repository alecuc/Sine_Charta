package beans;

public class Arma extends Oggetto{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String modello, munizione;
	private int danno, ricarica;
	private enum tipo{pistola, mitra,fucile};
	private tipo miaArma;
	
	/**
	 * 
	 * 
	 */
	public Arma() {
		super();
	}

	/**
	 * Metodi per settare il tipo di arma.
	 * 
	 */
	public void setFucile(){
		this.miaArma = tipo.fucile;
	}
	
	public void setPistola() {
		this.miaArma = tipo.pistola;
	}
	
	public void setMitra() {
		this.miaArma = tipo.mitra;
	}
	
	public tipo getTipoArma() {
		return this.miaArma;
	}
	
	public String toStringArma() {
		return getTipoArma().toString();
	}
	/**
	 * @return the modello
	 */
	public String getModello() {
		return modello;
	}

	/**
	 * @param modello the modello to set
	 */
	public void setModello(String modello) {
		this.modello = modello;
	}

	/**
	 * @return the munizione
	 */
	public String getMunizione() {
		return munizione;
	}

	/**
	 * @param munizione the munizione to set
	 */
	public void setMunizione(String munizione) {
		this.munizione = munizione;
	}

	/**
	 * @return the danno
	 */
	public int getDanno() {
		return danno;
	}

	/**
	 * @param danno the danno to set
	 */
	public void setDanno(int danno) {
		this.danno = danno;
	}

	/**
	 * @return the ricarica
	 */
	public int getRicarica() {
		return ricarica;
	}

	/**
	 * @param ricarica the ricarica to set
	 */
	public void setRicarica(int ricarica) {
		this.ricarica = ricarica;
	}
	
	public void setTipo() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
