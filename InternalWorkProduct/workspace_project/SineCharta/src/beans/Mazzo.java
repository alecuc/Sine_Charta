package beans;

import java.util.ArrayList;

import interfaces.Deckable;

public class Mazzo implements Deckable{

	public ArrayList<CartaPoker> MazzoPoker;
	public ArrayList<Tarocco> MazzoTarocco;
	public Mazzo() {
		
	}
	@Override
	public Object estrai() {
	
		return null;
	}

	@Override
	public void mischia() {
		
	}

}
