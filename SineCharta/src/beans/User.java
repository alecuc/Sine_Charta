package beans;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class User implements Serializable{
	
	
	/**
	 * Variabili di istanza di User.
	 */
	private static final long serialVersionUID = 1L;
	private String name, surname, email, username, password,ruolo;
	private Set<Personaggio> personaggiUtente;
	private Set<Storia> storieUtente;
	

	public User() {
		personaggiUtente = new HashSet<Personaggio>();
		storieUtente = new HashSet<Storia>();
	}

	public void aggiungiStoria(Storia nuovaStoria) {
		storieUtente.add(nuovaStoria);
		nuovaStoria.setUtenteModeratore(this);
	}
	
	public void rimuoviStoria(Storia storiaDaRimuovere) {
		storieUtente.remove(storiaDaRimuovere);
		storiaDaRimuovere.setUtenteModeratore(null);
		
	}
	
	

	public void aggiungiPG(Personaggio pg) {
		personaggiUtente.add(pg);
		pg.setUser(this);
	}
	
	
	public void rimuoviPG(Personaggio pg) {
		personaggiUtente.remove(pg);
		pg.setUser(null);
	}
	/**
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * @param surname the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
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

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	public String getRuolo() {
		return ruolo;
	}

	public void setRuolo(String ruolo) {
		// TODO Auto-generated method stub
		this.ruolo= ruolo;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", surname=" + surname + ", email=" + email + ", username=" + username
				+ ", password=" + password + ", ruolo=" + ruolo + ", personaggiUtente=" + personaggiUtente
				+ ", storieUtente=" + storieUtente + "]";
	}
	
	
	
	

}
