package org.leanpoker.player.model;


public class Card {

	private int rank;
	private String suit;
	
	public int getRank(){
		return rank;
	}
	public String getSuit(){
		return suit;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public void setSuit(String suit) {
		this.suit = suit;
	}
}
