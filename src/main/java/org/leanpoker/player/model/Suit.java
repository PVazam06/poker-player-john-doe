package org.leanpoker.player.model;

public enum Suit {

	KREUZ("clubs"), 
	PIK("spades"), 
	HERZ("hearts"), 
	KARO("diamonds");
	
	private String suit;
	
	private Suit(String suit) {
		this.suit = suit;
	}

	@Override
	public String toString() {
		return suit;
	}
	
	
}
