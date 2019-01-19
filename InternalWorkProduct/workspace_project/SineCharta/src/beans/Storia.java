<<<<<<< HEAD
package beans;

import java.io.Serializable;

public class Storia implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String titolo, descrizione, ambientazione;
	
	public Storia() {
		
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Storia [id=" + id + ", titolo=" + titolo + ", descrizione=" + descrizione + ", ambientazione="
				+ ambientazione + "]";
	}
	
	

}
=======
package beans;

public class Storia {

}
>>>>>>> fraBranch
