package beans;

import java.io.Serializable;

public class Oggetto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private String nome;
	private double peso, costo;
	private int quantita, id_oggetto;
	private Personaggio pg;
	private Arma arma;
	
	
	public Oggetto() {
		arma = new Arma(this);
	}
	
	public Arma getArma() {
		return arma;
	}
	
	public void setPG(Personaggio newpg) {
		if(pg != newpg) {
			Personaggio old = pg;
			pg = newpg;
			if(newpg != null) newpg.aggiungiOggetto(this);
			if(old != null) old.rimuoviOggetto(this);
		}
		
	}
	
	
	/**
	 * @return the id_oggetto
	 */
	public int getId_oggetto() {
		return id_oggetto;
	}



	/**
	 * @param id_oggetto the id_oggetto to set
	 */
	public void setId_oggetto(int id_oggetto) {
		this.id_oggetto = id_oggetto;
	}



	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the peso
	 */
	public double getPeso() {
		return peso;
	}

	/**
	 * @param peso the peso to set
	 */
	public void setPeso(double peso) {
		this.peso = peso;
	}

	/**
	 * @return the prezzo
	 */
	public double getCosto() {
		return costo;
	}

	/**
	 * @param prezzo the prezzo to set
	 */
	public void setCosto(double costo) {
		this.costo = costo;
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}



	
	
}
