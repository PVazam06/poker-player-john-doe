package org.leanpoker.player;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.Map;

import org.leanpoker.player.request.GameRequest;

public class Player {

    static final String VERSION = "Default Java folding player";

    public static int betRequest(JsonElement request) {
    	
    	try {
    		Gson g = new Gson();		
    		GameRequest req = g.fromJson(request, GameRequest.class);
    	} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	JsonObject roundObject = request.getAsJsonObject();
    	
    	int currentByIn =  roundObject.get("current_buy_in").getAsInt();
    	int minRaise =  roundObject.get("minimum_raise").getAsInt();
    	
    	int myPlayerPos = roundObject.get("in_action").getAsInt();
    	//myPlayer = roundObject.get("players").getAsJsonArray().get(myPlayerPos);
    	
    	return minRaise;
    }

    public static void showdown(JsonElement game) {
    }
}
