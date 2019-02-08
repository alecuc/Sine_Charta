package beans;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


public class Personaggio implements Serializable{
	
	/**
	 * Serializable class ID
	 */
	private static final long serialVersionUID = 1L;
	
	private String nome, cognome, nazionalita, taroccoDominante, username, feritaTesta, feritaBraccia, feritaTorso, feritaGambe;
	private int age, salute, risoluzione, idStoria;
	private Set<Oggetto> oggetti;
	private Set<Abilita> ability;
	private Storia storia;
	private User utenteDelPG;
	
	/*Caratteristiche del personaggio*/
	private int intuito, memoria, percezione, volonta, aspetto, comando, creativita, socievolezza,
			coordinazione, destrManuale, forzaFisica, mira, affinOcculta,
			distDaMorte, equilibrMentale, karma;
	
	

	
	public Personaggio() {
		oggetti = new HashSet<Oggetto>();
		ability = new HashSet<Abilita>();
	}
	public User getUser() {
		return this.utenteDelPG;
	}
	public void setUser(User utente) {
		if(utenteDelPG!= utente) {
			User oldUser = utenteDelPG;
			utenteDelPG = utente;
			if(utenteDelPG!=null) {
				utenteDelPG.aggiungiPG(this);
			}
			if(oldUser!=null) {
				oldUser.rimuoviPG(this);
			}
		}
	}
	
	public void setStoria(Storia unaStoria) {
		if(storia != unaStoria) {
			Storia oldStory = storia;
			storia = unaStoria;
			if(unaStoria != null) unaStoria.addPersonaggio(this);
			if(oldStory != null) oldStory.rimuoviPG(this);
		}
	}
	
	public Storia getStoria() {
		return this.storia;
	}
	
	public void aggiungiOggetto(Oggetto obj) {
		oggetti.add(obj);
		obj.setPersonaggioOggetto(this);;
	}
	
	public void aggiungiListaOggetti(Set<Oggetto> oggetti) {
		this.oggetti = oggetti;
	}
	
	public Set<Oggetto> getListaOggetti(){
		return this.oggetti;
	}
	
	public void rimuoviOggetto(Oggetto obj) {
		oggetti.remove(obj);
		obj.setPersonaggioOggetto(null);;
	}

	
	public void aggiungiAbilita(Abilita abilita) {
		ability.add(abilita);
		abilita.setPersonaggio(this);
	}
	
	public void aggiungiListaAbilita(Set<Abilita> listaAbilita) {
		this.ability = listaAbilita;
	}
	
	public void rimuoviAbilita(Abilita abilita) {
		ability.remove(abilita);
		abilita.setPersonaggio(null);
	}
	
	public Set<Abilita> getListaAbilita(){
		return this.ability;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public void setUsername(String username) {
		this.username = username;
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
	 * @return the taroccoDominante
	 */
	public String getTaroccoDominante() {
		return taroccoDominante;
	}
	/**
	 * @param taroccoDominante the taroccoDominante to set
	 */
	public void setTaroccoDominante(String taroccoDominante) {
		this.taroccoDominante = taroccoDominante;
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
	 * @return the risoluzione
	 */
	public int getRisoluzione() {
		return risoluzione;
	}
	/**
	 * @param risoluzione the risoluzione to set
	 */
	public void setRisoluzione(int risoluzione) {
		this.risoluzione = risoluzione;
	}
	/**
	 * @return the intuito
	 */
	public int getIntuito() {
		return intuito;
	}
	/**
	 * @param intuito the intuito to set
	 */
	public void setIntuito(int intuito) {
		this.intuito = intuito;
	}
	/**
	 * @return the memoria
	 */
	public int getMemoria() {
		return memoria;
	}
	/**
	 * @param memoria the memoria to set
	 */
	public void setMemoria(int memoria) {
		this.memoria = memoria;
	}
	/**
	 * @return the percezione
	 */
	public int getPercezione() {
		return percezione;
	}
	/**
	 * @param percezione the percezione to set
	 */
	public void setPercezione(int percezione) {
		this.percezione = percezione;
	}
	/**
	 * @return the volonta
	 */
	public int getVolonta() {
		return volonta;
	}
	/**
	 * @param volonta the volonta to set
	 */
	public void setVolonta(int volonta) {
		this.volonta = volonta;
	}
	/**
	 * @return the aspetto
	 */
	public int getAspetto() {
		return aspetto;
	}
	/**
	 * @param aspetto the aspetto to set
	 */
	public void setAspetto(int aspetto) {
		this.aspetto = aspetto;
	}
	/**
	 * @return the comando
	 */
	public int getComando() {
		return comando;
	}
	/**
	 * @param comando the comando to set
	 */
	public void setComando(int comando) {
		this.comando = comando;
	}
	/**
	 * @return the creativita
	 */
	public int getCreativita() {
		return creativita;
	}
	/**
	 * @param creativita the creativita to set
	 */
	public void setCreativita(int creativita) {
		this.creativita = creativita;
	}
	/**
	 * @return the socievolezza
	 */
	public int getSocievolezza() {
		return socievolezza;
	}
	/**
	 * @param socievolezza the socievolezza to set
	 */
	public void setSocievolezza(int socievolezza) {
		this.socievolezza = socievolezza;
	}
	/**
	 * @return the coordinazione
	 */
	public int getCoordinazione() {
		return coordinazione;
	}
	/**
	 * @param coordinazione the coordinazione to set
	 */
	public void setCoordinazione(int coordinazione) {
		this.coordinazione = coordinazione;
	}
	/**
	 * @return the destrManuale
	 */
	public int getDestrManuale() {
		return destrManuale;
	}
	/**
	 * @param destrManuale the destrManuale to set
	 */
	public void setDestrManuale(int destrManuale) {
		this.destrManuale = destrManuale;
	}
	/**
	 * @return the forzaFisica
	 */
	public int getForzaFisica() {
		return forzaFisica;
	}
	/**
	 * @param forzaFisica the forzaFisica to set
	 */
	public void setForzaFisica(int forzaFisica) {
		this.forzaFisica = forzaFisica;
	}
	/**
	 * @return the mira
	 */
	public int getMira() {
		return mira;
	}
	/**
	 * @param mira the mira to set
	 */
	public void setMira(int mira) {
		this.mira = mira;
	}
	/**
	 * @return the affinOcculta
	 */
	public int getAffinOcculta() {
		return affinOcculta;
	}
	/**
	 * @param affinOcculta the affinOcculta to set
	 */
	public void setAffinOcculta(int affinOcculta) {
		this.affinOcculta = affinOcculta;
	}
	/**
	 * @return the distDaMorte
	 */
	public int getDistDaMorte() {
		return distDaMorte;
	}
	/**
	 * @param distDaMorte the distDaMorte to set
	 */
	public void setDistDaMorte(int distDaMorte) {
		this.distDaMorte = distDaMorte;
	}
	/**
	 * @return the equilibrMentale
	 */
	public int getEquilibrMentale() {
		return equilibrMentale;
	}
	/**
	 * @param equilibrMentale the equilibrMentale to set
	 */
	public void setEquilibrMentale(int equilibrMentale) {
		this.equilibrMentale = equilibrMentale;
	}
	/**
	 * @return the karma
	 */
	public int getKarma() {
		return karma;
	}
	/**
	 * @param karma the karma to set
	 */
	public void setKarma(int karma) {
		this.karma = karma;
	}
	
	
	/**
	 * @return the salute
	 */
	public int getSalute() {
		return salute;
	}
	/**
	 * @param salute the salute to set
	 */
	public void setSalute(int salute) {
		this.salute = salute;
	}
	/**
	 * @return the feritaTesta
	 */
	public String getFeritaTesta() {
		return feritaTesta;
	}
	/**
	 * @param feritaTesta the feritaTesta to set
	 */
	public void setFeritaTesta(String feritaTesta) {
		this.feritaTesta = feritaTesta;
	}
	/**
	 * @return the feritaBraccia
	 */
	public String getFeritaBraccia() {
		return feritaBraccia;
	}
	/**
	 * @param feritaBraccia the feritaBraccia to set
	 */
	public void setFeritaBraccia(String feritaBraccia) {
		this.feritaBraccia = feritaBraccia;
	}
	/**
	 * @return the feritaTorso
	 */
	public String getFeritaTorso() {
		return feritaTorso;
	}
	/**
	 * @param feritaTorso the feritaTorso to set
	 */
	public void setFeritaTorso(String feritaTorso) {
		this.feritaTorso = feritaTorso;
	}
	/**
	 * @return the feritaGambe
	 */
	public String getFeritaGambe() {
		return feritaGambe;
	}
	/**
	 * @param feritaGambe the feritaGambe to set
	 */
	public void setFeritaGambe(String feritaGambe) {
		this.feritaGambe = feritaGambe;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getClass().getName()+" [nome=" + nome + ", cognome=" + cognome + ", nazionalita=" + nazionalita
				+ ", taroccoDominante=" + taroccoDominante + ", username=" + username + ", feritaTesta=" + feritaTesta
				+ ", feritaBraccia=" + feritaBraccia + ", feritaTorso=" + feritaTorso + ", feritaGambe=" + feritaGambe
				+ ", age=" + age + ", salute=" + salute + ", risoluzione=" + risoluzione + ", idStoria=" + idStoria
				+ ", oggetti=" + oggetti.toString() + ", storia=" + storia.getId() + ", intuito=" + intuito + ", memoria=" + memoria
				+ ", percezione=" + percezione + ", volonta=" + volonta + ", aspetto=" + aspetto + ", comando="
				+ comando + ", creativita=" + creativita + ", socievolezza=" + socievolezza + ", coordinazione="
				+ coordinazione + ", destrManuale=" + destrManuale + ", forzaFisica=" + forzaFisica + ", mira=" + mira
				+ ", affinOcculta=" + affinOcculta + ", distDaMorte=" + distDaMorte + ", equilibrMentale="
				+ equilibrMentale + ", karma=" + karma + ", ability=" + ability.toString();
	}

	
}