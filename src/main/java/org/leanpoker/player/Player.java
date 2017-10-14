package org.leanpoker.player;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.Map;

import org.leanpoker.player.model.Cards;
import org.leanpoker.player.request.GameRequest;

public class Player {

    static final String VERSION = "Default Java folding player";

    public static int betRequest(JsonElement request) {
    	
    	try {
    		Gson g = new Gson();		
    		GameRequest req = g.fromJson(request, GameRequest.class);
    		
    		JsonObject roundObject = request.getAsJsonObject();
    		
    		int currentByIn =  roundObject.get("current_buy_in").getAsInt();
    		int minRaise =  roundObject.get("minimum_raise").getAsInt();
    		
    		Cards[] allCards = getCards(roundObject);
    		System.out.println(allCards.toString());
    		
    		return minRaise;
    		
    	} catch (Exception e) {		
			e.printStackTrace();
			return 1000;
		}
    	
    }

    public static void showdown(JsonElement game) {
    }
    
    public static Cards[] getCards(JsonObject roundObject)
    {
    	Cards[] allCards = new Cards[7];
    	int myPlayerPos = roundObject.get("in_action").getAsInt();
    	JsonObject player = roundObject.get("players").getAsJsonArray().get(myPlayerPos).getAsJsonObject();
    	
    	JsonArray ownCards = player.get("hole_cards").getAsJsonArray();
    	JsonArray comCards = roundObject.get("community_cards").getAsJsonArray();
    	for(int i = 0; i < ownCards.size(); i++){
    		allCards[i].rank = ownCards.get(i).getAsJsonObject().get("rank").getAsInt();
    		allCards[i].suit = ownCards.get(i).getAsJsonObject().get("suit").getAsString();
    	}
    	
    	for(int i = 0; i < comCards.size(); i++){
    		allCards[i + ownCards.size()].rank = comCards.get(i).getAsJsonObject().get("rank").getAsInt();
    		allCards[i + ownCards.size()].suit = comCards.get(i).getAsJsonObject().get("suit").getAsString();
    	}
    	
    	return allCards;
    }
}


