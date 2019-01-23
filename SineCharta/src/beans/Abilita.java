package beans;

import java.io.Serializable;

public class Abilita implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nome;
	private int valore;
	private Personaggio pgConAbilita;

		
	public Abilita() {
		
	}
	
	public void setAbilitaPG(Personaggio pg) {
		if(pgConAbilita != pg) {
			Personaggio oldPg = pgConAbilita;
			pgConAbilita = pg;
			if(pg!=null) pg.aggiungiAbilita(this);
			if(oldPg!=null) oldPg.rimuoviAbilita(this);
		}
		
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Abilita [nome=" + nome + ", valore=" + valore + ", pgConAbilita=" + pgConAbilita + "]";
	}
	
	
	
	
}
