package org.leanpoker.player;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.Map;

public class Player {

    static final String VERSION = "Default Java folding player";

    public static int betRequest(JsonElement request) {
    	JsonObject roundObject = request.getAsJsonObject();
    	
    	int currentByIn =  roundObject.get("current_buy_in").getAsInt();
    	int minRaise =  roundObject.get("minimum_raise").getAsInt();
    	
    	
    	return minRaise;
    }

    public static void showdown(JsonElement game) {
    }
}
