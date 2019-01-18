package beans;

import java.io.Serializable;

public class SessioneDiGioco implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nome;
	
	public SessioneDiGioco() {
		
	}
	
	public void setNome(String nome) {
		this.nome=nome;
	}
	
	public String getNome() {
		return this.nome;
	}

}
