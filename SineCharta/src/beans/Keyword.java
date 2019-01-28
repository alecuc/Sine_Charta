package beans;

import java.io.Serializable;

public class Keyword implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int idKeyword, idSessione;
	private String chiave_nome, descrizione;
	private SessioneDiGioco sessione;
	
	public Keyword() {
		
	}

	public void setSessioneKeyword(SessioneDiGioco nuovaSessione) {
		if(sessione!=nuovaSessione) {
			SessioneDiGioco oldSessione = sessione;
			sessione = nuovaSessione;
			if(nuovaSessione!=null)nuovaSessione.aggiungiKeyword(this);
			if(oldSessione!=null)oldSessione.rimuoviKeyword(this);
		}
	}

	/**
	 * @return the idKeyword
	 */
	public int getIdKeyword() {
		return idKeyword;
	}

	/**
	 * @param idKeyword the idKeyword to set
	 */
	public void setIdKeyword(int idKeyword) {
		this.idKeyword = idKeyword;
	}

	/**
	 * @return the idSessione
	 */
	public int getIdSessione() {
		return idSessione;
	}

	/**
	 * @param idSessione the idSessione to set
	 */
	public void setIdSessione(int idSessione) {
		this.idSessione = idSessione;
	}

	/**
	 * @return the chiave_nome
	 */
	public String getChiave_nome() {
		return chiave_nome;
	}

	/**
	 * @param chiave_nome the chiave_nome to set
	 */
	public void setChiave_nome(String chiave_nome) {
		this.chiave_nome = chiave_nome;
	}

	/**
	 * @return the descrizione
	 */
	public String getDescrizione() {
		return descrizione;
	}

	/**
	 * @param descrizione the descrizione to set
	 */
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	@Override
	public String toString() {
		return getClass().getName() +"[ idKeyword=" + idKeyword + ", idSessione=" + idSessione + ", chiave_nome=" + chiave_nome
				+ ", descrizione=" + descrizione + "]";
	}

	
	
	
}
