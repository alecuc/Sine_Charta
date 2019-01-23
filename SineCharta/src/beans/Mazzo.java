package beans;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import interfaces.Deckable;



/* Rappresenta il mazzo di SineCharta, viene istanziato sia il mazzo da poker che il 
 * mazzo di tarocchi
 * @author franc
 *
 */
public class Mazzo implements Deckable{
	
	/**
	 * attributi della classe mazzo.
	 */

	ArrayList<Tarocco> mazzoTarocco = new ArrayList<Tarocco>();
	ArrayList<Tarocco> mazzoSupporto = new ArrayList<Tarocco>();
	
	String[] SUITS = {
			"Cuori" , "Quadri" , "Fiori" , "Picche"
	};
	
	String[] RANKS = {
			"2","3","4","5","6","7","8","9","10","Jack","Regina","Re","Asso"
	};
	
	int n = SUITS.length * RANKS.length;
	String[] deckPoker = new String[n];
	

	/**
	 * costruttore di mazzo, viene istanziato il mazzo di carte da poker e 
	 * il mazzo di tarocchi.
	 */

	public Mazzo() {
		
	  	for (int i = 0 ; i < RANKS.length; i++) {
    		for (int j = 0; j < SUITS.length; j++) {
    			deckPoker[SUITS.length * i + j] = RANKS[i] + "of" + SUITS[j];
    		}
    	}
    	
    	Tarocco bagatto = new Tarocco("Bagatto", "Avventura e viaggi", 15, 24, 13, 10, 1);
    	mazzoTarocco.add(bagatto);
    	Tarocco papessa = new Tarocco("Papessa", "Sapere e studio", 24, 15, 10, 21, 2);
    	mazzoTarocco.add(papessa);
    	Tarocco imperatrice = new Tarocco("Imperatrice", "Autoritario", 19, 16, 16, 11, 3);
    	mazzoTarocco.add(imperatrice);
    	Tarocco imperatore = new Tarocco("Imperatore", "Comandare", 15, 15, 18, 8, 4);
    	mazzoTarocco.add(imperatore);
    	Tarocco papa = new Tarocco("Papa", "Studio e insegnamento", 16, 20, 8, 16, 5);
    	mazzoTarocco.add(papa);
    	Tarocco innamorato = new Tarocco("L'Innamorato", "Vita con passione", 14 , 19, 12, 14, 6);
    	mazzoTarocco.add(innamorato);
    	Tarocco carro = new Tarocco("Carro", "Abizione", 18, 21, 19, 12, 7);
    	mazzoTarocco.add(carro);
    	Tarocco giustizia = new Tarocco("Giustizia", "Giudice", 16, 18, 15, 15, 8);
    	mazzoTarocco.add(giustizia);
    	Tarocco eremita = new Tarocco("Eremita", "Saggi e riservati", 22, 8, 11, 22, 9);
    	mazzoTarocco.add(eremita);
    	Tarocco ruotaFortuna = new Tarocco("Ruota della fortuna", "Fatalisti", 14, 14, 14, 19, 10);
    	mazzoTarocco.add(ruotaFortuna);
    	Tarocco forza = new Tarocco("Forza", "Lottare contro le avversità", 10, 13, 24, 13, 11);
    	mazzoTarocco.add(forza);
    	Tarocco appeso = new Tarocco("Appeso", "Scarso contatto con la realtà", 13, 22, 13, 17, 12);
    	mazzoTarocco.add(appeso);
    	Tarocco morte = new Tarocco("Morte", "Cinici e macabri", 18, 12, 14, 20, 13);
    	mazzoTarocco.add(morte);
    	Tarocco temperanza = new Tarocco("Temperanza", "Equilibrate e pazienti", 15, 15, 15, 15, 14);
    	mazzoTarocco.add(temperanza);
    	Tarocco diavolo = new Tarocco("Il Diavolo", "egoisti", 11, 17, 17, 24, 15);
    	mazzoTarocco.add(diavolo);
    	Tarocco torre = new Tarocco("Torre", "Eterni sconfitti", 8, 10, 15, 18, 16);
    	mazzoTarocco.add(torre);
    	Tarocco stelle = new Tarocco("Le stelle", "Vincenti", 20, 22, 21, 18, 17);
    	mazzoTarocco.add(stelle);
    	Tarocco luna = new Tarocco("La luna", "Romantici e sognatori", 21, 1, 16, 13, 18);
    	mazzoTarocco.add(luna);
    	Tarocco sole = new Tarocco("Il sole", "Aperte e fiduciose", 13, 18, 20, 14, 19);
    	mazzoTarocco.add(sole);
    	Tarocco giudizio = new Tarocco("Il giudizio", "Critiche e cocciute", 13, 13, 16, 15, 20);
    	mazzoTarocco.add(giudizio);
    	Tarocco mondo = new Tarocco("Il mondo", "Odiano le imposizione", 17, 16, 16, 16, 21);
    	mazzoTarocco.add(mondo);
    	Tarocco matto = new Tarocco("Il matto", "Comportamenti bizzarri", 17, 17, 17, 17, 0);
    	mazzoTarocco.add(matto);
    	Collections.shuffle(mazzoTarocco);	
	}	

	//metodo che permetti di estrarre la prima carta dal mazzo da Poker

	/**
	 * metodo che permette di estrarre la prima carta dal mazzo da Poker
	 * override del metodo dell'interfaccia Deckable
	 * @return la prima carta del mazzo di Poker
	 */

	@Override
	public String estraiPoker() {
		return deckPoker[--n];
	}


	//metodo che permetti di estrarre la prima carta dal mazzo dei Tarocchi

	/**
	 * metodo che permette di estrarre la prima carta dal mazzo dei Tarocchi
	 * override del metodo dell'interfaccia Deckable
	 * @return il Tarocco estratto
	 */

	@Override
	public Tarocco estraiTarocco() {
							
		Tarocco tmp = mazzoTarocco.get(1);
		mazzoTarocco.remove(tmp);
		mazzoSupporto.add(tmp);
		return tmp;
		
	}


	//metodo che permette di mischiare il mazzo di carte da Poker
	@Override

	/**
	 * metodo che permette di mischiare il mazzo di carte da Poker
	 *  override del metodo dell'interfaccia Deckable
	 */

	public void mischiaPoker() {
		for (int i = 0; i < n; i++) {
            int r = i + (int) (Math.random() * (n-i));
            String temp = deckPoker[r];
            deckPoker[r] = deckPoker[i];
            deckPoker[i] = temp;
        }

		}

	//metodo che permette di mischiare il mazzo di Tarocchi

	

	/**
	 * metodo che permette di mischiare il mazzo di Tarocchi
	 * override del metodo dell'interfaccia Deckable
	 */

	@Override
	public void mischiaTarocco() {
		
		Iterator<Tarocco> iterator = mazzoSupporto.iterator();
		
		while(iterator.hasNext()) {
			mazzoTarocco.add(iterator.next());
			
		}
		
		Collections.shuffle(mazzoTarocco);
		
	}
	

	/**
	 * metodo che restituisce la dimensione del mazzo dei Tarocchi
	 * @return la lunghezza del mazzo dei tarocchi
	 */
	public int size() {
		
		int n = mazzoTarocco.size();
		return n;
		
	}

}
