package org.leanpoker.player.calculator;

public class HandStrenght {

	private Hand hand;
	private Integer handStrenght;

	public HandStrenght(Hand hand) {
		this.hand = hand;
	}

	public void calculateHandStrenght() {
		int strenght = 0;
		int hand1 = hand.getCards1().getRank();
		int hand2 = hand.getCards2().getRank();
	}


}
