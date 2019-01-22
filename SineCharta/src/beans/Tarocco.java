package beans;

public class Tarocco {
<<<<<<< HEAD
	String descrizione, descrizioneDominante;
	int numero, valoreCuori, valoreQuadri, valoreFiori, valorePicche;
	
=======
	
	/**
	 * Classe Tarocco, permette di istanziare un Oggetto Tarocco da inserire nel Mazzo
	 */
	
	String descrizione, descrizioneDominante;
	int numero, valoreCuori, valoreQuadri, valoreFiori, valorePicche;
	
	
	/**
	 * Costruttore della classe Tarocco
	 * @param descrizione nome del Tarocco
	 * @param descrizioneDominante descrizione del Tarocco
	 * @param valoreCuori numero relativo al valore cuori
	 * @param valoreQuadri numero relativo al valore quadri
	 * @param valoreFiori numero relativo al valore fiori
	 * @param valorePicche numero relativo al valore picche
	 * @param numero il numero che identifica il Tarocco
	 */
>>>>>>> Develop
	public Tarocco(String descrizione, String descrizioneDominante, int valoreCuori, int valoreQuadri,
			int valoreFiori, int valorePicche, int numero) {
		super();
		this.descrizione = descrizione;
		this.descrizioneDominante = descrizioneDominante;
		this.valoreCuori = valoreCuori;
		this.valoreQuadri = valoreQuadri;
		this.valoreFiori = valoreFiori;
		this.valorePicche = valorePicche;
		this.numero = numero;
	}

	// getter degli attributi
<<<<<<< HEAD
	public String getDescrizione() {
		return descrizione;
	}

=======
	/**
	 * Metodo che restituisce il nome del Tarocco
	 * @return il nome del Tarocco
	 */
	public String getDescrizione() {
		return descrizione;
	}
	
	/**
	 * Metodo che restituisce la descrizione del Tarocco
	 * @return la descrizione del Tarocco
	 */
>>>>>>> Develop
	public String getDescrizioneDominante() {
		return descrizioneDominante;
	}

<<<<<<< HEAD
=======
	/**
	 * Metodo che restituisce il valore legato ai cuori del Tarocco
	 * @return il valore di cuori
	 */
>>>>>>> Develop
	public int getValoreCuori() {
		return valoreCuori;
	}

<<<<<<< HEAD
=======
	/**
	 * Metodo che restituisce il valore legato ai quadri del Tarocco
	 * @return il valore di quadri
	 */
>>>>>>> Develop
	public int getValoreQuadri() {
		return valoreQuadri;
	}

<<<<<<< HEAD
=======
	/**
	 * Metodo che restituisce il valore legato ai fiori del Tarocco
	 * @return il valore di fiori
	 */
>>>>>>> Develop
	public int getValoreFiori() {
		return valoreFiori;
	}

<<<<<<< HEAD
=======
	/**
	 * Metodo che restituisce il valore legato ai picche del Tarocco
	 * @return il valore di fiori
	 */
>>>>>>> Develop
	public int getValorePicche() {
		return valorePicche;
	}

<<<<<<< HEAD
=======
	/**
	 * Metodo che restituisce il numero del Tarocco
	 * @return il numero che identifica il Tarocco
	 */
>>>>>>> Develop
	public int getNumero() {
		return numero;
	}

<<<<<<< HEAD
=======
	//setter degli attributi
	/**
	 * Metodo che permette di settare la descrizione di un Tarocco
	 * @param descrizione la descrizione del Tarocco
	 */
>>>>>>> Develop
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

<<<<<<< HEAD
=======
	/**
	 * Metodo che permette di settare la descrizione dominante di un Tarocco
	 * @param descrizioneDominante la nuova descrizione dominante del Tarocco
	 */
>>>>>>> Develop
	public void setDescrizioneDominante(String descrizioneDominante) {
		this.descrizioneDominante = descrizioneDominante;
	}

<<<<<<< HEAD
	//setter degli attributi
=======
	/**
	 * Metodo che permette di settare il valore di cuori di un Tarocco
	 * @param valoreCuori il nuovo valore di cuori
	 */
>>>>>>> Develop
	public void setValoreCuori(int valoreCuori) {
		this.valoreCuori = valoreCuori;
	}

<<<<<<< HEAD
=======
	/**
	 * Metodo che permette di settare il valore di quadri di un Tarocco
	 * @param valoreQuadri il nuovo valore di quadri
	 */
>>>>>>> Develop
	public void setValoreQuadri(int valoreQuadri) {
		this.valoreQuadri = valoreQuadri;
	}

<<<<<<< HEAD
=======
	/**
	 * Metodo che permette di settare il valore di fiori di un Tarocco
	 * @param valoreFiori il nuovo valore di fiori 
	 */
>>>>>>> Develop
	public void setValoreFiori(int valoreFiori) {
		this.valoreFiori = valoreFiori;
	}

<<<<<<< HEAD
=======
	/**
	 * Metodo che permette di settare il valore di picche di un Tarocco
	 * @param valorePicche il nuovo valore di picche
	 */
>>>>>>> Develop
	public void setValorePicche(int valorePicche) {
		this.valorePicche = valorePicche;
	}

<<<<<<< HEAD
=======
	/**
	 * Metodo che permette di settare il numero di un Tarocco
	 * @param numero il nuovo valore di un Tarocco
	 */
>>>>>>> Develop
	public void setNumero(int numero) {
		this.numero = numero;
	}



}
