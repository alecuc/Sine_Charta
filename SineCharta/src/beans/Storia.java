package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Storia implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String titolo, descrizione, ambientazione, username;
	private Set<Personaggio> personaggi;
	private User utenteModeratore;
	private ArrayList<SessioneDiGioco> listaSessioni;
	
	
	
	public Storia() {
		personaggi = new HashSet<Personaggio>();
	}

	public void aggiungiSessione(SessioneDiGioco sessione) {
		listaSessioni.add(sessione);
		sessione.setStoriaSessione(this);
	}
	
	public void rimuoviSessione(SessioneDiGioco sessione) {
		listaSessioni.remove(sessione);
		sessione.setStoriaSessione(null);
		
	}
	
	public void addPersonaggio(Personaggio pg) {
		personaggi.add(pg);
		pg.setStoria(this);
	}
	
	public void rimuoviPG(Personaggio pg) {
		personaggi.remove(pg);
		pg.setStoria(null);
	}
	
	public void setUtenteModeratore(User nuovoModeratore) {
		if(utenteModeratore!= nuovoModeratore) {
			User oldModeratore = utenteModeratore;
			utenteModeratore = nuovoModeratore;
			if(nuovoModeratore!=null)nuovoModeratore.aggiungiStoria(this);
			if(oldModeratore!=null) oldModeratore.rimuoviStoria(this);
		}
	}
	
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the titolo
	 */
	public String getTitolo() {
		return titolo;
	}

	/**
	 * @param titolo the titolo to set
	 */
	public void setTitolo(String titolo) {
		this.titolo = titolo;
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

	/**
	 * @return the ambientazione
	 */
	public String getAmbientazione() {
		return ambientazione;
	}

	/**
	 * @param ambientazione the ambientazione to set
	 */
	public void setAmbientazione(String ambientazione) {
		this.ambientazione = ambientazione;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Storia [id=" + id + ", titolo=" + titolo + ", descrizione=" + descrizione + ", ambientazione="
				+ ambientazione + ", username=" + username + "]";
	}
	
	

}
