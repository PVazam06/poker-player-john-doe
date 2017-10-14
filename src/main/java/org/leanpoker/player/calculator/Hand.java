package org.leanpoker.player.calculator;

import org.leanpoker.player.model.Card;

public class Hand {

	private Card cards1;
	private Card cards2;

	public Hand(Card cards1, Card cards2) {
		this.cards1 = cards1;
		this.cards2 = cards2;
	}
	public Card getCards1() {
		return cards1;
	}

	public Card getCards2() {
		return cards2;
	}


}
