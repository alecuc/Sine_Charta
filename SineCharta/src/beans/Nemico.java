package beans;

public class Nemico {

	
	/**
	 * Rappresenta la classe Nemico o NPC 
	 */
		
	private String nome, speciale;
	private int attacco;
	
	/**
	 * 
	 * @param nome= il nome del Nemico
	 * @param speciale= abilità speciale di un Nemico  
	 * @param attacco= il valore di attacco di un Nemico
	 */
	public Nemico(String nome, String speciale, int attacco) {
		
		this.nome = nome;
		this.speciale = speciale;
		this.attacco = attacco;
	}

	/**
	 * Metodo che restituisce il nome del Nemico
	 * @return il nome del Nemico,
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Metodo che setta il nome del Nemico
	 * @param nome= il nome del nemico
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Metodo che restituisce l'abilità speciale del nemico
	 * @return l'abilità speciale del Nemico
	 */
	public String getSpeciale() {
		return speciale;
	}
	
	/**
	 * Metodo che setta l'abilità speciale del Nemico
	 * @param speciale: l'abilità speciale del Nemico
	 */
	public void setSpeciale(String speciale) {
		this.speciale = speciale;
	}
	
	/**
	 * Metodo che restituisce il valore di attacco del Nemico
	 * @return il valore di attacco del Nemico
	 */
	public int getAtacco() {
		return attacco;
	}
	
	/**
	 * Metodo che setta il valore di attacco del nemico
	 * @param attacco= il valore di attacco del nemico
	 */
	public void setAtacco(int attacco) {
		this.attacco = attacco;
	}
 

}
