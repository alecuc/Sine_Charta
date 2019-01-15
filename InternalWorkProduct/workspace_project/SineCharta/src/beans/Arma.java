package beans;

import java.io.Serializable;

public class Arma implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String modello, munizione;
	private int danno, abilita, ricarica;
	private enum tipo{pistola, mitra,fucile};

	public Arma() {

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
	 * @return the abilita
	 */
	public int getAbilita() {
		return abilita;
	}

	/**
	 * @param abilita the abilita to set
	 */
	public void setAbilita(int abilita) {
		this.abilita = abilita;
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

}
