package org.leanpoker.player;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.leanpoker.player.model.Card;
import org.leanpoker.player.request.GameRequest;
import org.leanpoker.player.request.PlayerJson;

public class Player {

	static final String VERSION = "Default Java folding player";

	private static Gson jsonHelper = new Gson();

	public static int betRequest(JsonElement request) {

		try {

			GameRequest req = jsonHelper.fromJson(request, GameRequest.class);

			Collection<Card> allCards = listCards(req);

			System.out.println("output test");

			int minraise = req.getMinimum_raise();
			
			System.out.println("min raise: " + minraise);
			
			return minraise;

		} catch (Exception e) {
			e.printStackTrace();
			return 1000;
		}

	}

	public static void showdown(JsonElement game) {
	}

	private static Collection<Card> listCards(GameRequest request) {
		List<Card> community = request.getCommunityCards();
		List<Card> myCards = getMyPlayer(request).getHoleCards();
		community.addAll(myCards);
		return community;
	}

	private static PlayerJson getMyPlayer(GameRequest request) {
		int myPos = request.getIn_action();
		return request.getPlayers().get(myPos);
	}

	public static Card[] getCards(JsonObject roundObject) {
		Card[] allCards = new Card[7];
		int myPlayerPos = roundObject.get("in_action").getAsInt();
		JsonObject player = roundObject.get("players").getAsJsonArray().get(myPlayerPos).getAsJsonObject();

		JsonArray ownCards = player.get("hole_cards").getAsJsonArray();

		JsonArray comCards = roundObject.get("community_cards").getAsJsonArray();

		for (int i = 0; i < ownCards.size(); i++) {
			allCards[i].setRank(ownCards.get(i).getAsJsonObject().get("rank").getAsInt());
			allCards[i].setSuit(ownCards.get(i).getAsJsonObject().get("suit").getAsString());
		}

		for (int i = 0; i < comCards.size(); i++) {
			allCards[i + ownCards.size()].setRank(comCards.get(i).getAsJsonObject().get("rank").getAsInt());
			allCards[i + ownCards.size()].setSuit(comCards.get(i).getAsJsonObject().get("suit").getAsString());
		}

		return allCards;
	}
}
