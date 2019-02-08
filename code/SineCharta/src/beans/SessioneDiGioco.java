package beans;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class SessioneDiGioco implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idNumeroSessione, idStoria;
	private String contenutoSessione, usernameModeratore;
	private Set<Keyword> sessionKeywords;
	private Storia storiaDiRiferimento;
	
	public SessioneDiGioco() {
		sessionKeywords = new HashSet<Keyword>();
	}
	
	public void setStoriaSessione(Storia nuovaStoria) {
		if(storiaDiRiferimento!=nuovaStoria) {
			Storia oldStoria = storiaDiRiferimento;
			storiaDiRiferimento = nuovaStoria;
			if(nuovaStoria!=null)nuovaStoria.aggiungiSessione(this);
			if(oldStoria!=null)oldStoria.rimuoviSessione(this);
		}
	}
	
	public void aggiungiKeyword(Keyword nuovaKeyword) {
		sessionKeywords.add(nuovaKeyword);
		nuovaKeyword.setSessioneKeyword(this);
	}
	
	public Set<Keyword> getKeywordSessione(){
		return this.sessionKeywords;
	}
	
	public void addListaKeyword(Set<Keyword> list) {
		this.sessionKeywords = list;
	}
	
	public void rimuoviKeyword(Keyword keywordDaRimuovere) {
		sessionKeywords.remove(keywordDaRimuovere);
		keywordDaRimuovere.setSessioneKeyword(null);
	}

	/**
	 * @return the idNumeroSessione
	 */
	public int getIdNumeroSessione() {
		return idNumeroSessione;
	}

	/**
	 * @param idNumeroSessione the idNumeroSessione to set
	 */
	public void setIdNumeroSessione(int idNumeroSessione) {
		this.idNumeroSessione = idNumeroSessione;
	}

	/**
	 * @return the idStoria
	 */
	public int getIdStoria() {
		return idStoria;
	}

	/**
	 * @param idStoria the idStoria to set
	 */
	public void setIdStoria(int idStoria) {
		this.idStoria = idStoria;
	}

	/**
	 * @return the contenutoSessione
	 */
	public String getContenutoSessione() {
		return contenutoSessione;
	}

	/**
	 * @param contenutoSessione the contenutoSessione to set
	 */
	public void setContenutoSessione(String contenutoSessione) {
		this.contenutoSessione = contenutoSessione;
	}

	/**
	 * @return the usernameModeratore
	 */
	public String getUsernameModeratore() {
		return usernameModeratore;
	}

	/**
	 * @param usernameModeratore the usernameModeratore to set
	 */
	public void setUsernameModeratore(String usernameModeratore) {
		this.usernameModeratore = usernameModeratore;
	}

	@Override
	public String toString() {
		return getClass().getName() + "[idNumeroSessione=" + idNumeroSessione + ", idStoria=" + idStoria
				+ ", contenutoSessione=" + contenutoSessione + ", usernameModeratore=" + usernameModeratore +", keyword= "+ sessionKeywords +"]";
	}
	
	
	

	
	
	

}
