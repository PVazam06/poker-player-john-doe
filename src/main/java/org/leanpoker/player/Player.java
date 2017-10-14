package org.leanpoker.player;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;

import java.io.InputStream;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.leanpoker.player.model.Card;
import org.leanpoker.player.request.GameRequest;
import org.leanpoker.player.request.PlayerJson;
import org.leanpoker.player.request.RankHelper;
import org.leanpoker.player.tools.JHttpClient;

public class Player {

	static final String VERSION = "Default Java folding player";

	private static Gson jsonHelper = new Gson();
	
	private static JHttpClient client = new JHttpClient();

	private static GameRequest req;

	public static int betRequest(JsonElement request) {
		System.out.println("----incomming request--------");
		try {
			//String jsonRequest = jsonHelper.toJson(request);
			//System.out.println("request json: " +jsonRequest);
			
			req = jsonHelper.fromJson(request, GameRequest.class);
			return req.getCurrentBuyIn() - req.getPlayers().get(req.getIn_action()).getBet();
			
//			System.out.println("game request is serialized now");
//			
//			
//			Collection<Card> allCards = listCards(req);
//						
//			String json = jsonHelper.toJson(allCards);
//			json = "cards="+json;
//			
//			InputStream res = client.Post("http://rainman.leanpoker.org/rank", json);
//
//			JsonElement rankObject = jsonHelper.toJsonTree(res);
//			
//			int rank = rankObject.getAsJsonObject().get("rank").getAsInt();
//			
//			System.out.println("our rank: "+ rank);
//			
//			int returnValue = RankHelper.getReturnValue(rank, req);
//
//			int minraise = req.getMinimum_raise();
//			
//			System.out.println("min raise: " + minraise);
//			
//			return returnValue;

		}catch(JsonParseException jpe){
			System.out.println("json pars exception");
			jpe.printStackTrace();
		}catch (Exception e) {
			System.out.println("---------- error log out----------");
			e.printStackTrace();
			
		}
		
		try {
			return req.getCurrentBuyIn() - req.getPlayers().get(req.getIn_action()).getBet();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return 520;
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

//	public static Card[] getCards(JsonObject roundObject) {
//		Card[] allCards = new Card[7];
//		int myPlayerPos = roundObject.get("in_action").getAsInt();
//		JsonObject player = roundObject.get("players").getAsJsonArray().get(myPlayerPos).getAsJsonObject();
//
//		JsonArray ownCards = player.get("hole_cards").getAsJsonArray();
//
//		JsonArray comCards = roundObject.get("community_cards").getAsJsonArray();
//
//		for (int i = 0; i < ownCards.size(); i++) {
//			allCards[i].setRank(ownCards.get(i).getAsJsonObject().get("rank").getAsInt());
//			allCards[i].setSuit(ownCards.get(i).getAsJsonObject().get("suit").getAsString());
//		}
//
//		for (int i = 0; i < comCards.size(); i++) {
//			allCards[i + ownCards.size()].setRank(comCards.get(i).getAsJsonObject().get("rank").getAsInt());
//			allCards[i + ownCards.size()].setSuit(comCards.get(i).getAsJsonObject().get("suit").getAsString());
//		}
//
//		return allCards;
//	}
}
