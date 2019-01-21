package beans;

public class Tarocco {
	String descrizione, descrizioneDominante;
	int numero, valoreCuori, valoreQuadri, valoreFiori, valorePicche;
	
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
	public String getDescrizione() {
		return descrizione;
	}

	public String getDescrizioneDominante() {
		return descrizioneDominante;
	}

	public int getValoreCuori() {
		return valoreCuori;
	}

	public int getValoreQuadri() {
		return valoreQuadri;
	}

	public int getValoreFiori() {
		return valoreFiori;
	}

	public int getValorePicche() {
		return valorePicche;
	}

	public int getNumero() {
		return numero;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public void setDescrizioneDominante(String descrizioneDominante) {
		this.descrizioneDominante = descrizioneDominante;
	}

	//setter degli attributi
	public void setValoreCuori(int valoreCuori) {
		this.valoreCuori = valoreCuori;
	}

	public void setValoreQuadri(int valoreQuadri) {
		this.valoreQuadri = valoreQuadri;
	}

	public void setValoreFiori(int valoreFiori) {
		this.valoreFiori = valoreFiori;
	}

	public void setValorePicche(int valorePicche) {
		this.valorePicche = valorePicche;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}



}
