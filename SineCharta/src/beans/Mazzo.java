package beans;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import interfaces.Deckable;


/**
 * Rappresenta il mazzo di SineCharta, viene istanziato sia il mazzo da poker che il 
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
    	
    	Tarocco bagatto = new Tarocco("Il Bagatto","Un successo rocambolesco.", "Sarai una persona dedita all'avventura e ai viaggi.", 15, 24, 13, 10, 1);
    	mazzoTarocco.add(bagatto);
    	Tarocco papessa = new Tarocco("La Papessa","Le azioni che richiedono caratteristiche fisiche falliranno. Le altre avranno successo, grazie alle conoscenze del personaggio.", "Il sapere e lo studio conteranno tutto.", 24, 15, 10, 21, 2);
    	mazzoTarocco.add(papessa);
    	Tarocco imperatrice = new Tarocco("L'Imperatrice","Si riceve un aiuto insperato da qualcuno vicino. Se non ci sono presenti l'azione fallisce.", "Sei una persona autoritaria, la cui sola presenza intimorisce chiunque.", 19, 16, 16, 11, 3);
    	mazzoTarocco.add(imperatrice);
    	Tarocco imperatore = new Tarocco("L'Imperatore","Con la propria forza il personaggio riesce a prevalere.", "Sei nato per comandare.", 15, 15, 18, 8, 4);
    	mazzoTarocco.add(imperatore);
    	Tarocco papa = new Tarocco("Il Papa","Il personaggio rimane indeciso e immobile.", "Lo studio e l'insegnamento contano molto.", 16, 20, 8, 16, 5);
    	mazzoTarocco.add(papa);
    	Tarocco innamorato = new Tarocco("L'Innamorato","La fiducia mal riposta in qualcuno o se stessi conduce ad un fallimento.", "Vivi la vita seguendo le tue passioni amorose, ignorando spesso il resto.", 14 , 19, 12, 14, 6);
    	mazzoTarocco.add(innamorato);
    	Tarocco carro = new Tarocco("Il Carro","Un successo trionfale in qualsiasi situazione.", "Sei una persona ambiziosa e che aspira al successo", 18, 21, 19, 12, 7);
    	mazzoTarocco.add(carro);
    	Tarocco giustizia = new Tarocco("La Giustizia","Un fallimento in qualsiasi situazione. Maggiori le tue colpe, peggiore il falliento.", "Giudicherai sempre gli altri prima di te stesso.", 16, 18, 15, 15, 11);
    	mazzoTarocco.add(giustizia);
    	Tarocco eremita = new Tarocco("L'Eremita","Insuccesso durevole: si ripercuote in ogni situazione simile.", "Saggio e riservato, vivi in pace con gli altri.", 22, 8, 11, 22, 9);
    	mazzoTarocco.add(eremita);
    	Tarocco ruotaFortuna = new Tarocco("La Ruota della Fortuna","Il personaggio ottiene un successo. Immeritato, ma pur sempre un successo. Che fortuna!", "Sei una persona convinta che tutto sia predestinato.", 14, 14, 14, 19, 10);
    	mazzoTarocco.add(ruotaFortuna);
    	Tarocco forza = new Tarocco("La Forza","Un impeto di risolutezza e coraggio conduce ad un successo!", "Sei una persona che non si lascia mai scoraggiare e che lotta fino alla fine.", 10, 13, 24, 13, 8);
    	mazzoTarocco.add(forza);
    	Tarocco appeso = new Tarocco("L'Appeso","Un insuccesso dovuto alle circostanze, contro le quali non puoi nulla.", "Vivi nelle tue fantasie, dimenticando il reale.", 13, 22, 13, 17, 12);
    	mazzoTarocco.add(appeso);
    	Tarocco morte = new Tarocco("La Morte","Un insuccesso grave e definitivo.", "Cinico, misterioso e a tratti macabro, pochi riescono a starti attorno.", 18, 12, 14, 20, 13);
    	mazzoTarocco.add(morte);
    	Tarocco temperanza = new Tarocco("La Temperanza","L'evento avviene senza influenzare il personaggio in alcun modo.", "Sei una persona quilibrata e paziente.", 15, 15, 15, 15, 14);
    	mazzoTarocco.add(temperanza);
    	Tarocco diavolo = new Tarocco("Il Diavolo","Un fallimento disastroso e inspiegabile oltre ogni aspettativa.", "Chiunque vale meno di te. Sei il migliore, egoista e presuntuoso.", 11, 17, 17, 24, 15);
    	mazzoTarocco.add(diavolo);
    	Tarocco torre = new Tarocco("La Torre","Un fallimento grave che coinvolge tutti i presenti.", "Sei nato sconfitto: la vita potrebbe non avere nulla in serbo per te.", 8, 10, 15, 18, 16);
    	mazzoTarocco.add(torre);
    	Tarocco stelle = new Tarocco("Le Stelle","Un successo perfetto. Era destino.", "Sei nato per vincere ogni sfida che ti si para davanti.", 20, 22, 21, 18, 17);
    	mazzoTarocco.add(stelle);
    	Tarocco luna = new Tarocco("La Luna","Insuccesso dovuto ad insicurezza e paura.", "Sei una persona romantica, sognatrice.", 21, 14, 16, 13, 18);
    	mazzoTarocco.add(luna);
    	Tarocco sole = new Tarocco("Il Sole","Successo pieno dovuto interamente alle capacità del personaggio.", "Sei una persona molto estroversa e fiduciosa nel prossimo.", 13, 18, 20, 14, 19);
    	mazzoTarocco.add(sole);
    	Tarocco giudizio = new Tarocco("Il Giudizio","Una scarsa interpretazione degli eventi conduce ad un fallimento.", "Sei cocciuto e criticone.", 13, 13, 16, 15, 20);
    	mazzoTarocco.add(giudizio);
    	Tarocco mondo = new Tarocco("Il Mondo","L'azione va a buon fine perché il tempo sembra essersi fermato.", "Nessuno riesce a importi di fare qualcosa: farai sempre di testa tua.", 17, 16, 16, 16, 21);
    	mazzoTarocco.add(mondo);
    	Tarocco matto = new Tarocco("Il Matto","La situazione si risolve in maniera incomprensibile, irripetibile e improvvisa.", "Imprevedibile, folle. MATTO.", 17, 17, 17, 17, 0);
    	mazzoTarocco.add(matto);
    	Collections.shuffle(mazzoTarocco);	
	}	
	/**
	 * metodo che permette di estrarre la prima carta dal mazzo da Poker
	 * override del metodo dell'interfaccia Deckable
	 * @return la prima carta del mazzo di Poker
	 */
	@Override
	public String estraiPoker() {
		return deckPoker[--n];
	}

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
