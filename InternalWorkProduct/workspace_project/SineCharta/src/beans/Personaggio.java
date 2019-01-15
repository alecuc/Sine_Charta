package beans;

import java.io.Serializable;

public class Personaggio implements Cloneable, Serializable{
	
	/**
	 * Serializable class ID
	 */
	private static final long serialVersionUID = -3995688470791211026L;
	
	String nome, cognome, nazionalita;
	int age, caratteristiche;
	
	
	
	
	public Personaggio() {
		
	}

}
