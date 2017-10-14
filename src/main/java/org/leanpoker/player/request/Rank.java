package org.leanpoker.player.request;

import org.leanpoker.player.model.Card;

public class Rank {

	
	public static boolean fould(Card card1, Card card2) {
		
		if (card1.getRank().equals("A") || card2.getRank().equals("A")) {
			return false;
		}
		
		return true;
	}
}
