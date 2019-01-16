package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class Personaggio implements Cloneable, Serializable{
	
	/**
	 * Serializable class ID
	 */
	private static final long serialVersionUID = -3995688470791211026L;
	
	String nome, cognome, nazionalita;
	int age, caratteristiche;
	private Abilita abi = new Abilita();
	private ArrayList<Abilita> ability = new ArrayList<Abilita>();
	
	class Abilita{
		private String nome;
		private int valore;
		 
		public Abilita() {
			
		}
		public Abilita(String n, int val) {
			this.nome=n;
			this.valore=val;
			
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
		 * @return the valore
		 */
		public int getValore() {
			return valore;
		}

		/**
		 * @param valore the valore to set
		 */
		public void setValore(int valore) {
			this.valore = valore;
		}
		
		public String toString() {
			return getClass().getName()+"[Nome= "+nome+", Valore= "+valore+"];";
		}
	
		
		
	}
	
	public Personaggio() {
		
		
	}

	public void setAbility(String nome, int val) {
		abi.setNome(nome);
		abi.setValore(val);
		ability.add(abi);
	}
	
	
	public void getAbility() {
		Iterator<Abilita> itr = ability.iterator();
		while(itr.hasNext()) {
			Abilita tmp = itr.next();
			System.out.println(tmp.toString());		}
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
	 * @return the cognome
	 */
	public String getCognome() {
		return cognome;
	}

	/**
	 * @param cognome the cognome to set
	 */
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	/**
	 * @return the nazionalita
	 */
	public String getNazionalita() {
		return nazionalita;
	}

	/**
	 * @param nazionalita the nazionalita to set
	 */
	public void setNazionalita(String nazionalita) {
		this.nazionalita = nazionalita;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the caratteristiche
	 */
	public int getCaratteristiche() {
		return caratteristiche;
	}

	/**
	 * @param caratteristiche the caratteristiche to set
	 */
	public void setCaratteristiche(int caratteristiche) {
		this.caratteristiche = caratteristiche;
	}

	public void setAbilita(Abilita a) {
		ability.add(a);
	}
	
	public Abilita getAbilita(int n) {
		Abilita ab = ability.get(n);
		return ab;
	}
	
}
